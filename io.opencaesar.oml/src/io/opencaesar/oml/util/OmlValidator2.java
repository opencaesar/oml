/**
 * 
 * Copyright 2019-2021 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
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
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.FeaturePredicate;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBox;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyUsage;

/**
 * The <b>Validator2</b> for the model. It adds additional semantic rules that go beyond the EMF syntax rules. 
 * 
 * @author elaasar
 */
public final class OmlValidator2 {
    
    /**
     * The singleton instance of this class
     */
    public static final OmlValidator2 INSTANCE = new OmlValidator2();
        
    private Map<EClass, List<Method>> methodMap;
    
    private OmlValidator2() {}
    
    /**
     * Validates the given Oml element by this validator's rules 
     * 
     * @param element The element to validate
     * @param diagnostics The diagnostics found during validation
     * @param context An object to object context map used in producing the error messages
     * @return True if the element is valid; False otherwise
     */
    public boolean run(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (methodMap == null) {
            collectValidates();
        }
        final List<Method> methods = methodMap.get(element.eClass());
        if (methods != null) {
            for (Method method : methods) {
                try {
                    method.invoke(this, element, diagnostics, context);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }
    
    private void collectValidates() {
        methodMap = new HashMap<>();
        final List<Method> methods = Arrays.stream(OmlValidator2.class.getDeclaredMethods()).
            filter(m -> m.getName().startsWith("validate") && m.getParameterTypes().length == 3)
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
    
    private boolean report(int kind, DiagnosticChain diagnostics, EObject object, String message, EStructuralFeature feature) {
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
    
    /**
     * Checks if a vocabulary extention URI resolves to a vocabulary
     * 
     * @param object The vocabulary extension to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateVocabularyExtensionURI(VocabularyExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!(OmlRead.getImportedOntology(object) instanceof Vocabulary)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "URI <"+object.getUri()+"> could not be resolved to a vocabulary", 
                OmlPackage.Literals.IMPORT__URI);
        }
        return true;
    }
    
    // VocabularyUsage
    
    /**
     * Checks if a vocabulary usage URI resolves to a description box
     * 
     * @param object The vocabulary usage to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateVocabularyUsageURI(VocabularyUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!(OmlRead.getImportedOntology(object) instanceof DescriptionBox)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "URI <"+object.getUri()+"> could not be resolved to an description nor an description bundle", 
                OmlPackage.Literals.IMPORT__URI);
        }
        return true;
    }
    
    // VocabularyBundleExtension
    
    /**
     * Checks if a vocabulary bundle extention URI resolves to a vocabulary bundle
     * 
     * @param object The vocabulary bundle extension to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateVocabularyBundleExtensionURI(VocabularyBundleExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!(OmlRead.getImportedOntology(object) instanceof VocabularyBundle)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "URI <"+object.getUri()+"> could not be resolved to a vocabulary bundle", 
                OmlPackage.Literals.IMPORT__URI);
        }
        return true;
    }
    
    // VocabularyBundleInclusion
    
    /**
     * Checks if a vocabulary bundle inclusion URI resolves to a vocabulary
     * 
     * @param object The vocabulary bundle inclusion to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateVocabularyBundleInclusionURI(VocabularyBundleInclusion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!(OmlRead.getImportedOntology(object) instanceof Vocabulary)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "URI <"+object.getUri()+"> could not be resolved to a vocabulary", 
                OmlPackage.Literals.IMPORT__URI);
        }
        return true;
    }
    
    // DescriptionExtension
    
    /**
     * Checks if a description extension URI resolves to a description
     * 
     * @param object The description extension to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateDescriptionExtensionURI(DescriptionExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!(OmlRead.getImportedOntology(object) instanceof Description)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "URI <"+object.getUri()+"> could not be resolved to an description", 
                OmlPackage.Literals.IMPORT__URI);
        }
        return true;
    }
    
    // DescriptionUsage
    
    /**
     * Checks if a description usage URI resolves to a vocabulary box
     * 
     * @param object The description usage to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateDescriptionUsageURI(DescriptionUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!(OmlRead.getImportedOntology(object) instanceof VocabularyBox)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "URI <"+object.getUri()+"> could not be resolved to a vocabulary nor a vocabulary bundle", 
                OmlPackage.Literals.IMPORT__URI);
        }
        return true;
    }
    
    // DescriptionBundleExtension
    
    /**
     * Checks if a description bundle extension URI resolves to a description bundle
     * 
     * @param object The description bundle extension to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateDescriptionBundleExtensionURI(DescriptionBundleExtension object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!(OmlRead.getImportedOntology(object) instanceof DescriptionBundle)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "URI <"+object.getUri()+"> could not be resolved to an description bundle", 
                OmlPackage.Literals.IMPORT__URI);
        }
        return true;
    }
    
    // DescriptionBundleInclusion
    
    /**
     * Checks if a description bundle inclusion URI resolves to a description
     * 
     * @param object The description bundle inclusion to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateDescriptionBundleInclusionURI(DescriptionBundleInclusion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!(OmlRead.getImportedOntology(object) instanceof Description)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "URI <"+object.getUri()+"> could not be resolved to an description", 
                OmlPackage.Literals.IMPORT__URI);
        }
        return true;
    }
    
    // DescriptionBundleUsage
    
    /**
     * Checks if a description bundle usage URI resolves to a vocabulary bundle
     * 
     * @param object The description bundle usage to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateDescriptionBundleUsageURI(DescriptionBundleUsage object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!(OmlRead.getImportedOntology(object) instanceof VocabularyBundle)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "URI <"+object.getUri()+"> could not be resolved to a vocabulary bundle", 
                OmlPackage.Literals.IMPORT__URI);
        }
        return true;
    }
    
    // RelationRestrictionAxiom
    
    /**
     * Checks if the domain of a restricted relation is the same as or a super type of the restricting classifier
     * 
     * @param object The relation restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateRelationRestrictionAxiomRelation(RelationRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Classifier restrictingClassifier = OmlRead.getRestrictingClassifier(object);
        final Entity domainType = object.getRelation().getDomain();
        if (restrictingClassifier != null && domainType != null) {
	        final Collection<SpecializableTerm> allGeneralTerms = OmlRead.closure(restrictingClassifier, true, t -> OmlSearch.findSuperTerms(t));
	        if (!allGeneralTerms.stream().filter(t -> t == domainType).findAny().isPresent()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Relation "+object.getRelation().getAbbreviatedIri()+" has a domain that is not the same as or a super type of "+restrictingClassifier.getAbbreviatedIri(), 
	                OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION);
	        }
        }
        return true;
    }
    
    /**
     * Checks if the restricted range is the same as or a sub type of the restricted relation's range
     * 
     * @param object The relation restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateRelationRangeRestrictionAxiomRange(RelationRangeRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Entity restrictedRange = object.getRange();
        final Entity rangeType = object.getRelation().getRange();
        if (restrictedRange != null && rangeType != null) {
	        final Collection<SpecializableTerm> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
	        if (!allGeneralEntities.stream().filter(t -> t == rangeType).findAny().isPresent()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Entity "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of "+rangeType.getAbbreviatedIri(), 
	                OmlPackage.Literals.RELATION_RANGE_RESTRICTION_AXIOM__RANGE);
	        }
        }
        return true;
    }

    /**
     * Checks if the restricted range is the same as or a sub type of the restricted relation's range
     * 
     * @param object The relation restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateRelationCardinalityRestrictionAxiomRange(RelationCardinalityRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Entity restrictedRange = object.getRange();
        final Entity rangeType = object.getRelation().getRange();
        if (restrictedRange != null && rangeType != null) {
            final Collection<SpecializableTerm> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
            if (!allGeneralEntities.stream().filter(t -> t == rangeType).findAny().isPresent()) {
                return report(Diagnostic.WARNING, diagnostics, object,
                    "Entity "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of "+rangeType.getAbbreviatedIri(), 
                    OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__RANGE);
            }
        }
        return true;
    }

    // ScalarPropertyRestrictionAxiom
    
    /**
     * Checks if the domain of a restricted scalar property is the same as or a super type of the restricting classifier
     * 
     * @param object The scalar property restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateScalarPropertyRestrictionAxiomProperty(ScalarPropertyRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Classifier restrictingClassifier = OmlRead.getRestrictingClassifier(object);
        final Classifier domainType = object.getProperty().getDomain();
        if (restrictingClassifier != null && domainType != null) {
	        final Collection<SpecializableTerm> allGeneralTerms = OmlRead.closure(restrictingClassifier, true, t -> OmlSearch.findSuperTerms(t));
	        if (!allGeneralTerms.stream().filter(t -> t == domainType).findAny().isPresent()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Property "+object.getProperty().getAbbreviatedIri()+" has a domain that is not the same as or a super type of "+OmlRead.getRestrictingClassifier(object).getAbbreviatedIri(), 
	                OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY);
	        }
        }
        return true;
    }
    
    /**
     * Checks if the restricted range is the same as or a sub type of the restricted scalar property's range
     * 
     * @param object The scalar property restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateScalarPropertyRangeRestrictionAxiomRange(ScalarPropertyRangeRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Scalar restrictedRange = object.getRange();
        final Scalar rangeType = object.getProperty().getRange();
        if (restrictedRange != null && rangeType != null) {
	        final Collection<SpecializableTerm> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
	        if (!allGeneralEntities.stream().filter(t -> t == rangeType).findAny().isPresent()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Scalar "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of "+rangeType.getAbbreviatedIri(), 
	                OmlPackage.Literals.SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE);
	        }
        }
        return true;
    }

    /**
     * Checks if the restricted range is the same as or a sub type of the restricted scalar property's range
     * 
     * @param object The scalar property restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateScalarPropertyCardinalityRestrictionAxiomRange(ScalarPropertyCardinalityRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Scalar restrictedRange = object.getRange();
        final Scalar rangeType = object.getProperty().getRange();
        if (restrictedRange != null && rangeType != null) {
            final Collection<SpecializableTerm> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
            if (!allGeneralEntities.stream().filter(t -> t == rangeType).findAny().isPresent()) {
                return report(Diagnostic.WARNING, diagnostics, object,
                    "Scalar "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of "+rangeType.getAbbreviatedIri(), 
                    OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE);
            }
        }
        return true;
    }

    // StructuredPropertyRestrictionAxiom
    
    /**
     * Checks if the domain of a restricted structured property is the same as or a super type of the restricting classifier
     * 
     * @param object The structured property restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateStructuredPropertyRestrictionAxiomProperty(StructuredPropertyRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Classifier restrictingClassifier = OmlRead.getRestrictingClassifier(object);
        final Classifier domainType = object.getProperty().getDomain();
        if (restrictingClassifier != null && domainType != null) {
	        final Collection<SpecializableTerm> allGeneralTerms = OmlRead.closure(restrictingClassifier, true, t -> OmlSearch.findSuperTerms(t));
	        if (!allGeneralTerms.stream().filter(t -> t == domainType).findAny().isPresent()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Property "+object.getProperty().getAbbreviatedIri()+" has a domain that is not the same as or a super type of "+OmlRead.getRestrictingClassifier(object).getAbbreviatedIri(), 
	                OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY);
	        }
        }
        return true;
    }
    
    /**
     * Checks if the restricted range is the same as or a sub type of the restricted structured property's range
     * 
     * @param object The structured property restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateStructuredPropertyRangeRestrictionAxiomRange(StructuredPropertyRangeRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Structure restrictedRange = object.getRange();
        final Structure rangeType = object.getProperty().getRange();
        if (restrictedRange != null && rangeType != null) {
	        final Collection<SpecializableTerm> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
	        if (!allGeneralEntities.stream().filter(t -> t == rangeType).findAny().isPresent()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Structure "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of "+rangeType.getAbbreviatedIri(), 
	                OmlPackage.Literals.STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE);
	        }
        }
        return true;
    }

    /**
     * Checks if the restricted range is the same as or a sub type of the restricted structured property's range
     * 
     * @param object The structured property restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateStructuredPropertyCardinalityRestrictionAxiomRange(StructuredPropertyCardinalityRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Structure restrictedRange = object.getRange();
        final Structure rangeType = object.getProperty().getRange();
        if (restrictedRange != null && rangeType != null) {
            final Collection<SpecializableTerm> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
            if (!allGeneralEntities.stream().filter(t -> t == rangeType).findAny().isPresent()) {
                return report(Diagnostic.WARNING, diagnostics, object,
                    "Structure "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of "+rangeType.getAbbreviatedIri(), 
                    OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE);
            }
        }
        return true;
    }

    // SpecializationAxiom
    
    /**
     * Checks if a specialization axiom is not between compatible term kinds
     * 
     * @param object The specialization axiom to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateSpecializationAxiomSpecializedTermKind(SpecializationAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final SpecializableTerm superTerm = OmlRead.getSuperTerm(object);
        final SpecializableTerm subTerm = OmlRead.getSubTerm(object);
        if (superTerm != null && subTerm != null) {
	        final EClass superEClass = superTerm.eClass();
	        final EClass subEClass = subTerm.eClass();
	        if (!((OmlPackage.Literals.ASPECT == superEClass && OmlPackage.Literals.ENTITY.isSuperTypeOf(subEClass)) ||
	            (OmlPackage.Literals.FACETED_SCALAR == superEClass && OmlPackage.Literals.ENUMERATED_SCALAR == subEClass) ||
	            (superEClass == subEClass))) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "Term "+superTerm.getAbbreviatedIri()+" cannot be specialized by "+subTerm.getAbbreviatedIri()+"", 
	                OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
	        }
        }
        return true;
    }
    
    // Faceted Scalar
    
    /**
     * Checks that a non-standard faceted scalar has a single supertype
     * 
     * @param object The faceted scalar to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateFacetedScalarSupertype(FacetedScalar object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final var ontologyIri = object.getOntology().getIri();
    	// non-standard scalars
        if (!ontologyIri.equals(OmlConstants.XSD_IRI) && 
        	!ontologyIri.equals(OmlConstants.RDF_IRI) &&
        	!ontologyIri.equals(OmlConstants.OWL_IRI)) {
        	final var specializations = object.getOwnedSpecializations();
        	if (specializations.isEmpty()) {
                return report(Diagnostic.ERROR, diagnostics, object,
                	"Faceted scalar "+object.getAbbreviatedIri()+" must specify a supertype", 
    	            OmlPackage.Literals.MEMBER__NAME);
        	} else if (specializations.size() > 1) {
                return report(Diagnostic.ERROR, diagnostics, object,
                	"Faceted scalar "+object.getAbbreviatedIri()+" can specify a single supertype only", 
    	            OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS);
        	}
        }
        return true;
    }

    /**
     * Checks that a non-standard faceted scalar reference has no supertype
     * 
     * @param object The faceted scalar reference to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateFacetedScalarReferenceSupertype(FacetedScalarReference object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final var scalar = object.getScalar();
        if (scalar != null && !scalar.eIsProxy()) {
        	final var ontologyIri = scalar.getOntology().getIri();
	    	// non-standard scalars
	        if (!ontologyIri.equals(OmlConstants.XSD_IRI) && 
	        	!ontologyIri.equals(OmlConstants.RDF_IRI) &&
	        	!ontologyIri.equals(OmlConstants.OWL_IRI)) {
	        	final var specializations = object.getOwnedSpecializations();
	        	if (!specializations.isEmpty()) {
	                return report(Diagnostic.ERROR, diagnostics, object,
	                	"Faceted scalar reference "+OmlRead.getAbbreviatedIri(object)+" cannot specify a supertype", 
	                	OmlPackage.Literals.SPECIALIZABLE_TERM_REFERENCE__OWNED_SPECIALIZATIONS);
	        	}
	        }
        }
        return true;
    }

    // Enumerated Scalar

    /**
     * Checks an enumerated scalar's literals
     * 
     * @param object The enumerated scalar to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateEnumeratedScalarLiterals(EnumeratedScalar object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getOwnedSpecializations().isEmpty() && object.getLiterals().isEmpty()) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "Enumerated scalar "+object.getAbbreviatedIri()+" must specify either some literals or a supertype", 
                OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
        } else if (!object.getOwnedSpecializations().isEmpty() && !object.getLiterals().isEmpty()) {
            return report(Diagnostic.ERROR, diagnostics, object,
                    "Enumerated scalar "+object.getAbbreviatedIri()+" with a supertype cannot specify literals", 
                    OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
        }
        return true;
    }

    /**
     * Checks an enumerated scalar reference has no supertype
     * 
     * @param object The enumerated scalar reference to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateEnumeratedScalarReferebce(EnumeratedScalarReference object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!object.getOwnedSpecializations().isEmpty()) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "Enumerated scalar reference "+OmlRead.getAbbreviatedIri(object)+" cannot specify a supertype", 
            	OmlPackage.Literals.SPECIALIZABLE_TERM_REFERENCE__OWNED_SPECIALIZATIONS);
        }
        return true;
    }

    // Classifier Predicate

    /**
     * Checks if a type predicate references an invalid type in a rule's consequent
     * 
     * @param object The type predicate to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateTypePredicate(TypePredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getConsequentRule() != null) {
	       if (object.getType() instanceof Structure) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "Structure "+object.getType().getAbbreviatedIri()+" cannot be used as a consequent predicate", 
	                OmlPackage.Literals.TYPE_PREDICATE__TYPE);
	        } else if (object.getType() instanceof Scalar) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                    "Scalar "+object.getType().getAbbreviatedIri()+" cannot be used as a consequent predicate", 
	                    OmlPackage.Literals.TYPE_PREDICATE__TYPE);
	        }
        }
        return true;
    }

    // Feature Predicate

    /**
     * Checks if a feature predicate references invalid features is in a rule's consequent
     * 
     * @param object The feature predicate to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateFeaturePredicate(FeaturePredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getConsequentRule() != null && object.getFeature() instanceof StructuredProperty) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "Structured property "+object.getFeature().getAbbreviatedIri()+" cannot be used as a consequent predicate", 
                OmlPackage.Literals.FEATURE_PREDICATE__FEATURE);
        }
        return true;
    }

}