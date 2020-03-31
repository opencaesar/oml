package io.opencaesar.oml.util

import io.opencaesar.oml.Bundle
import io.opencaesar.oml.BundleExtension
import io.opencaesar.oml.BundleInclusion
import io.opencaesar.oml.Description
import io.opencaesar.oml.DescriptionExtension
import io.opencaesar.oml.DescriptionUsage
import io.opencaesar.oml.OmlPackage
import io.opencaesar.oml.RelationRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom
import io.opencaesar.oml.Terminology
import io.opencaesar.oml.Vocabulary
import io.opencaesar.oml.VocabularyExtension
import io.opencaesar.oml.VocabularyUsage
import java.lang.reflect.Method
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.BasicDiagnostic
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature

import static extension io.opencaesar.oml.util.OmlRead.*
import static extension io.opencaesar.oml.util.OmlSearch.*

class OmlValidator2 {
	
	public static val INSTANCE = new OmlValidator2
		
	var Map<EClass, List<Method>> methodMap

	private new() {}
	
	def boolean validate(EObject object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (methodMap === null) {
			collectChecks
		}
		val methods = methodMap.get(object.eClass)
		if (methods !== null) {
			for (Method method : methods) {
				try {
					method.invoke(this, object, diagnostics, context)
				} catch (Exception e) {
					e.printStackTrace
					return false
				}
			}
		}
		return true
	}

	def collectChecks() {
		methodMap = new HashMap
		val methods = OmlValidator2.getDeclaredMethods().filter[name.startsWith('check') && parameterTypes.length === 3]
		OmlPackage.eINSTANCE.EClassifiers.filter(EClass).filter[!abstract].forEach[eClass |
			for (Method method : methods) {
				val paramType = method.parameterTypes.get(0)
				if (paramType.isAssignableFrom(eClass.instanceClass)) {
					var list = methodMap.get(eClass)
					if (list === null) {
						methodMap.put(eClass, list = new ArrayList<Method>)
					}
					list.add(method)
				}
			}
		]
	}

	def report(int kind, DiagnosticChain diagnostics, EObject object, String message, EStructuralFeature feature) {
		diagnostics.add(new BasicDiagnostic(
 			kind,
 			OmlValidator.DIAGNOSTIC_SOURCE,
 			OmlValidator.ELEMENT__EXTRA_VALIDATE, // all checks will have the same code for now!
 			message,
 			#[object, feature]))
 		return false
	}
	
	//--------------------------------

	// BundleExtension

	protected def checkBundleExtensionURI(BundleExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Bundle)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'URL could not be resolved to a bundle', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// BundleInclusion

	protected def checkBundleInclusionURI(BundleInclusion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Vocabulary)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'URL could not be resolved to a vocabulary', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// DescriptionExtension

	protected def checkDescriptionExtensionURI(DescriptionExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Description)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'URL could not be resolved to a description', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// DescriptionUsage

	protected def checkDescriptionUsageURI(DescriptionUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Terminology)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'URL could not be resolved to a vocabulary nor a bundle', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}
	
	// RelationRestrictionAxiom
	
	protected def checkRelationRestrictionAxiomRelation(RelationRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val restrictingType = object.restrictingType
		val domainType = object.relation.domain
		if (!restrictingType.reflexiveClosure[findSpecializedTerms].exists[t | t == domainType]) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'Relation cannot be restricted in this context', 
				OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION)
		}
		return true
	}
	
	// ScalarPropertyRestrictionAxiom
	
	protected def checkScalarPropertyRestrictionAxiomProperty(ScalarPropertyRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val restrictingType = object.restrictingType
		val domainType = object.property.domain
		if (!restrictingType.reflexiveClosure[findSpecializedTerms].exists[t | t == domainType]) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'Property cannot be restricted in this context', 
				OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY)
		}
		return true
	}

	// SpecializationAxiom
	
	protected def checkSpecializationAxiomSpecializedTermCycle(SpecializationAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val specializedTerm = object.specializedTerm
		val specializingTerm = object.specializingTerm
		if (specializedTerm.reflexiveClosure[findSpecializedTerms].exists[t | t == specializingTerm]) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'Term causes a specialization cycle', 
				OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM)
		}
		return true
	}

	protected def checkSpecializationAxiomSpecializedTermKind(SpecializationAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val specializingEClass = object.specializingTerm.eClass
		val specializedEClass = object.specializedTerm.eClass
		if (!((OmlPackage.Literals.ASPECT == specializedEClass && OmlPackage.Literals.ENTITY.isSuperTypeOf(specializingEClass)) ||
			(OmlPackage.Literals.FACETED_SCALAR == specializedEClass && OmlPackage.Literals.ENUMERATED_SCALAR == specializingEClass) ||
			(specializedEClass === specializingEClass))) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'Term cannot be specialized in this context', 
				OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM)
		}
		return true
	}

	// StructuredPropertyRestrictionAxiom
	
	protected def checkStructuredPropertyRestrictionAxiomProperty(StructuredPropertyRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val restrictingType = object.restrictingType
		val domainType = object.property.domain
		if (!restrictingType.reflexiveClosure[findSpecializedTerms].exists[t | t == domainType]) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'Property cannot be restricted in this context', 
				OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY)
		}
		return true
	}

	// VocabularyExtension

	protected def checkVocabularyExtensionURI(VocabularyExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Vocabulary)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'URI could not be resolved to a vocabulary', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// VocabularyUsage
		
	protected def checkVocabularyUsageURI(VocabularyUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Description)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'URL could not be resolved to a description', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

}