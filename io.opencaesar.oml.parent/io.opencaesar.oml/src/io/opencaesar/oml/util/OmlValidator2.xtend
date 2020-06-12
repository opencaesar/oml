/** 
 * Copyright 2019 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opencaesar.oml.util

import io.opencaesar.oml.DescriptionBox
import io.opencaesar.oml.DescriptionBundle
import io.opencaesar.oml.DescriptionBundleExtension
import io.opencaesar.oml.DescriptionBundleInclusion
import io.opencaesar.oml.DescriptionBundleUsage
import io.opencaesar.oml.Description
import io.opencaesar.oml.DescriptionExtension
import io.opencaesar.oml.DescriptionUsage
import io.opencaesar.oml.OmlPackage
import io.opencaesar.oml.RelationRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom
import io.opencaesar.oml.VocabularyBox
import io.opencaesar.oml.VocabularyBundle
import io.opencaesar.oml.VocabularyBundleExtension
import io.opencaesar.oml.VocabularyBundleInclusion
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

	// VocabularyExtension

	protected def checkVocabularyExtensionURI(VocabularyExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Vocabulary)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'''URI <«object.uri»> could not be resolved to a vocabulary''', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// VocabularyUsage
		
	protected def checkVocabularyUsageURI(VocabularyUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof DescriptionBox)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'''URI <«object.uri»> could not be resolved to an description nor an description bundle''', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// VocabularyBundleExtension

	protected def checkVocabularyBundleExtensionURI(VocabularyBundleExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof VocabularyBundle)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'''URI <«object.uri»> could not be resolved to a vocabulary bundle''', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// VocabularyBundleInclusion

	protected def checkVocabularyBundleInclusionURI(VocabularyBundleInclusion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Vocabulary)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'''URI <«object.uri»> could not be resolved to a vocabulary''', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// DescriptionExtension

	protected def checkDescriptionExtensionURI(DescriptionExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Description)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'''URI <«object.uri»> could not be resolved to an description''', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// DescriptionUsage

	protected def checkDescriptionUsageURI(DescriptionUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof VocabularyBox)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'''URI <«object.uri»> could not be resolved to a vocabulary nor a vocabulary bundle''', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}
	
	// DescriptionBundleExtension

	protected def checkDescriptionBundleExtensionURI(DescriptionBundleExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof DescriptionBundle)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'''URI <«object.uri»> could not be resolved to an description bundle''', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// DescriptionBundleInclusion

	protected def checkDescriptionBundleInclusionURI(DescriptionBundleInclusion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof Description)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'''URI <«object.uri»> could not be resolved to an description''', 
				OmlPackage.Literals.IMPORT__URI)
		}
		return true
	}

	// DescriptionBundleUsage

	protected def checkDescriptionBundleUsageURI(DescriptionBundleUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(object.importedOntology instanceof VocabularyBundle)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				'''URI <«object.uri»> could not be resolved to a vocabulary bundle''', 
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
				'''Relation «object.relation.abbreviatedIri» cannot be restricted in the context of «object.restrictingType.abbreviatedIri»''', 
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
				'''Property «object.property.abbreviatedIri» cannot be restricted in the context of «object.restrictingType.abbreviatedIri»''', 
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
				'''Term «object.specializedTerm.abbreviatedIri» causes a specialization cycle for «object.specializingTerm.abbreviatedIri»''', 
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
				'''Term «object.specializedTerm.abbreviatedIri» cannot be specialized by «object.specializingTerm.abbreviatedIri»''', 
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
				'''Property «object.property.abbreviatedIri» cannot be restricted in the context of «object.restrictingType.abbreviatedIri»''', 
				OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY)
		}
		return true
	}

}