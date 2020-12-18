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
package io.opencaesar.oml.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBox;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionBundleExtension;
import io.opencaesar.oml.DescriptionBundleInclusion;
import io.opencaesar.oml.DescriptionBundleUsage;
import io.opencaesar.oml.DescriptionExtension;
import io.opencaesar.oml.DescriptionUsage;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBox;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyUsage;

public class OmlValidator2 {
	
	public static final OmlValidator2 INSTANCE = new OmlValidator2();
		
	private Map<EClass, List<Method>> methodMap;

	private OmlValidator2() {}
	
	public boolean validate(EObject object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (methodMap == null) {
			collectChecks();
		}
		final List<Method> methods = methodMap.get(object.eClass());
		if (methods != null) {
			for (Method method : methods) {
				try {
					method.invoke(this, object, diagnostics, context);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	private void collectChecks() {
		methodMap = new HashMap<>();
		final List<Method> methods = Arrays.stream(OmlValidator2.class.getDeclaredMethods()).
			filter(m -> m.getName().startsWith("check") && m.getParameterTypes().length == 3)
			.collect(Collectors.toList());
		OmlPackage.eINSTANCE.getEClassifiers().stream().
			filter(EClass.class::isInstance).
			map(EClass.class::cast).
			filter(c -> !c.isAbstract()).
			forEach(eClass -> {
				methods.forEach(method -> {
					final Class<?> paramType = method.getParameterTypes()[0];
					if (paramType.isAssignableFrom(eClass.getInstanceClass())) {
						List<Method> list = methodMap.get(eClass);
						if (list == null) {
							methodMap.put(eClass, list = new ArrayList<Method>());
						}
						list.add(method);
					}
				});
			});
	}

	protected boolean report(int kind, DiagnosticChain diagnostics, EObject object, String message, EStructuralFeature feature) {
		diagnostics.add(new BasicDiagnostic(
 			kind,
 			OmlValidator.DIAGNOSTIC_SOURCE,
 			OmlValidator.ELEMENT__EXTRA_VALIDATE, // all checks will have the same code for now!
 			message,
 			new Object[]{object, feature}));
 		return false;
	}
	
	//--------------------------------

	// VocabularyExtension

	protected boolean checkVocabularyExtensionURI(VocabularyExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(OmlRead.getImportedOntology(object) instanceof Vocabulary)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"URI <"+object.getUri()+"> could not be resolved to a vocabulary", 
				OmlPackage.Literals.IMPORT__URI);
		}
		return true;
	}

	// VocabularyUsage
		
	protected boolean checkVocabularyUsageURI(VocabularyUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(OmlRead.getImportedOntology(object) instanceof DescriptionBox)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"URI <"+object.getUri()+"> could not be resolved to an description nor an description bundle", 
				OmlPackage.Literals.IMPORT__URI);
		}
		return true;
	}

	// VocabularyBundleExtension

	protected boolean checkVocabularyBundleExtensionURI(VocabularyBundleExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(OmlRead.getImportedOntology(object) instanceof VocabularyBundle)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"URI <"+object.getUri()+"> could not be resolved to a vocabulary bundle", 
				OmlPackage.Literals.IMPORT__URI);
		}
		return true;
	}

	// VocabularyBundleInclusion

	protected boolean checkVocabularyBundleInclusionURI(VocabularyBundleInclusion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(OmlRead.getImportedOntology(object) instanceof Vocabulary)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"URI <"+object.getUri()+"> could not be resolved to a vocabulary", 
				OmlPackage.Literals.IMPORT__URI);
		}
		return true;
	}

	// DescriptionExtension

	protected boolean checkDescriptionExtensionURI(DescriptionExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(OmlRead.getImportedOntology(object) instanceof Description)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"URI <"+object.getUri()+"> could not be resolved to an description", 
				OmlPackage.Literals.IMPORT__URI);
		}
		return true;
	}

	// DescriptionUsage

	protected boolean checkDescriptionUsageURI(DescriptionUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(OmlRead.getImportedOntology(object) instanceof VocabularyBox)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"URI <"+object.getUri()+"> could not be resolved to a vocabulary nor a vocabulary bundle", 
				OmlPackage.Literals.IMPORT__URI);
		}
		return true;
	}
	
	// DescriptionBundleExtension

	protected boolean checkDescriptionBundleExtensionURI(DescriptionBundleExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(OmlRead.getImportedOntology(object) instanceof DescriptionBundle)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"URI <"+object.getUri()+"> could not be resolved to an description bundle", 
				OmlPackage.Literals.IMPORT__URI);
		}
		return true;
	}

	// DescriptionBundleInclusion

	protected boolean checkDescriptionBundleInclusionURI(DescriptionBundleInclusion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(OmlRead.getImportedOntology(object) instanceof Description)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"URI <"+object.getUri()+"> could not be resolved to an description", 
				OmlPackage.Literals.IMPORT__URI);
		}
		return true;
	}

	// DescriptionBundleUsage

	protected boolean checkDescriptionBundleUsageURI(DescriptionBundleUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(OmlRead.getImportedOntology(object) instanceof VocabularyBundle)) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"URI <"+object.getUri()+"> could not be resolved to a vocabulary bundle", 
				OmlPackage.Literals.IMPORT__URI);
		}
		return true;
	}

	// RelationRestrictionAxiom
	
	protected boolean checkRelationRestrictionAxiomRelation(RelationRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		final Classifier restrictingClassifier = OmlRead.getRestrictingClassifier(object);
		final Entity domainType = object.getRelation().getRange();
		final Collection<SpecializableTerm> allGeneralTerms = OmlRead.reflexiveClosure(restrictingClassifier, t -> OmlSearch.findGeneralTerms(t));
		if (!allGeneralTerms.stream().filter(t -> t == domainType).findAny().isPresent()) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"Relation "+OmlRead.getAbbreviatedIri(object.getRelation())+" cannot be restricted in the context of "+OmlRead.getAbbreviatedIri(OmlRead.getRestrictingClassifier(object))+"", 
				OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION);
		}
		return true;
	}
	
	// ScalarPropertyRestrictionAxiom
	
	protected boolean checkScalarPropertyRestrictionAxiomProperty(ScalarPropertyRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		final Classifier restrictingClassifier = OmlRead.getRestrictingClassifier(object);
		final Classifier domainType = object.getProperty().getDomain();
		final Collection<SpecializableTerm> allGeneralTerms = OmlRead.reflexiveClosure(restrictingClassifier, t -> OmlSearch.findGeneralTerms(t));
		if (!allGeneralTerms.stream().filter(t -> t == domainType).findAny().isPresent()) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"Property "+OmlRead.getAbbreviatedIri(object.getProperty())+" cannot be restricted in the context of "+OmlRead.getAbbreviatedIri(OmlRead.getRestrictingClassifier(object))+"", 
				OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY);
		}
		return true;
	}

	// SpecializationAxiom
	
	protected boolean checkSpecializationAxiomSpecializedTermCycle(SpecializationAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		final SpecializableTerm generalTerm = object.getSpecializedTerm();
		final SpecializableTerm specificTerm = OmlRead.getSpecificTerm(object);
		final Collection<SpecializableTerm> allGeneralTerms = OmlRead.reflexiveClosure(generalTerm, t -> OmlSearch.findGeneralTerms(t));
		if (allGeneralTerms.stream().filter(t -> t == specificTerm).findAny().isPresent()) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"Term "+OmlRead.getAbbreviatedIri(object.getSpecializedTerm())+" causes a specialization cycle for "+OmlRead.getAbbreviatedIri(OmlRead.getSpecificTerm(object))+"", 
				OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
		}
		return true;
	}

	protected boolean checkSpecializationAxiomSpecializedTermKind(SpecializationAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		final EClass specificEClass = OmlRead.getSpecificTerm(object).eClass();
		final EClass generalEClass = object.getSpecializedTerm().eClass();
		if (!((OmlPackage.Literals.ASPECT == generalEClass && OmlPackage.Literals.ENTITY.isSuperTypeOf(specificEClass)) ||
			(OmlPackage.Literals.FACETED_SCALAR == generalEClass && OmlPackage.Literals.ENUMERATED_SCALAR == specificEClass) ||
			(generalEClass == specificEClass))) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"Term "+OmlRead.getAbbreviatedIri(object.getSpecializedTerm())+" cannot be specialized by "+OmlRead.getAbbreviatedIri(OmlRead.getSpecificTerm(object))+"", 
				OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
		}
		return true;
	}

	// StructuredPropertyRestrictionAxiom
	
	protected boolean checkStructuredPropertyRestrictionAxiomProperty(StructuredPropertyRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		final Classifier restrictingClassifier = OmlRead.getRestrictingClassifier(object);
		final Classifier domainType = object.getProperty().getDomain();
		final Collection<SpecializableTerm> allGeneralTerms = OmlRead.reflexiveClosure(restrictingClassifier, t -> OmlSearch.findGeneralTerms(t));
		if (!allGeneralTerms.stream().filter(t -> t == domainType).findAny().isPresent()) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"Property "+OmlRead.getAbbreviatedIri(object.getProperty())+" cannot be restricted in the context of "+OmlRead.getAbbreviatedIri(OmlRead.getRestrictingClassifier(object))+"", 
				OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY);
		}
		return true;
	}

	// VocabularyExtension

	protected boolean checkRelationEntityReverse(RelationEntity object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (object.getReverseRelation() != null && object.getForwardRelation() == null) {
			return report(Diagnostic.ERROR, diagnostics, object,
				"Reverse relation <"+OmlRead.getAbbreviatedIri(object.getReverseRelation())+"> cannot be specified without a forward relation too", 
				OmlPackage.Literals.RELATION_ENTITY__REVERSE_RELATION);
		}
		return true;
	}

}
