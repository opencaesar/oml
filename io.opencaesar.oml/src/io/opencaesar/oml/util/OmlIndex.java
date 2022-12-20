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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.RelationValueRestrictionAxiom;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyReference;
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.TypePredicate;

/**
 * The <b>Index</b> API for the model. It allows looking up cross references of OML objects in the resource set by using two lookup mechanisms:
 * 
 * 1) Fast: looking up cross references in a cache if a {@link ECrossReferenceAdapter} is installed in the resource set
 * 2) Slow: iterating over the content of a resource set to look for cross referencers 
 *  
 * @author elaasar
 */
public class OmlIndex {
    
    /*
     * Finds all objects that cross reference a given Oml element using a given EReference 
     * 
     * @param element The element to search for cross refs to
     * @param eReference The eReference to filter the cross refs by
     * @return A list of objects that cross reference the given element based on the criteria
     */
    private static List<EObject> findInverseReferencers(Element element, EReference eReference) {
        final Set<EObject> referencers = new HashSet<>();
        final ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(element);
        Collection<Setting> settings;
        if (adapter != null) {
            // the fast method
            settings = adapter.getInverseReferences(element);
        } else {
            // the slow method
            settings = searchForReferences(element);
        };
        for (Setting setting : settings) {
            if (setting.getEStructuralFeature() == eReference) {
                referencers.add(setting.getEObject());
            }
        }
        return new ArrayList<EObject>(referencers);
    }
    
    /*
     * Finds all objects that cross reference a given Oml element conforming to a given Java type and using a given EReference
     * 
     * @param element The element to search for cross refs to
     * @param type The Java type to filter the cross refs by
     * @param eReference The eReference to filter the cross refs by
     * @return A list of objects that cross reference the given element based on the criteria
     */
    private static <T extends EObject> List<T> findInverseReferencers(Element element, Class<T> type, EReference eReference) {
        final Set<T> referencers = new HashSet<>(); 
        findInverseReferencers(element, eReference).forEach(referencer -> {
            if (type.isInstance(referencer)) {
                referencers.add(type.cast(referencer));
            }
        });
        return new ArrayList<T>(referencers);
    }
    
    /*
     * Searches the context (resource set if available or resource) for cross references to a given element
     *  
     * @param element The element to search for cross refs to
     * @return A list of Setting objects including the cross referencing elements and the features they reference with
     */
    private static Collection<Setting> searchForReferences(EObject element) {
        final Resource resource = element.eResource();
        if (resource == null) {
            final EObject rootEObject = EcoreUtil.getRootContainer(element);
            return UsageCrossReferencer.find(element, rootEObject);
        } else {
            ResourceSet resourceSet = resource.getResourceSet();
            if (resourceSet == null) {
                return UsageCrossReferencer.find(element, resource);
              } else {
                return UsageCrossReferencer.find(element, resourceSet);
              }
        }
    }
    
    // Annotation
    
    /**
     * Finds annotations referencing the given property
     * 
     * @param property The referenced property
     * @return A list of referencing annotations
     */
    public static List<Annotation> findAnnotationsWithProperty(AnnotationProperty property) {
        return findInverseReferencers(property, Annotation.class, OmlPackage.Literals.ANNOTATION__PROPERTY);
    }
    
    // Concept

    /**
     * Finds concepts that enumerate the given instance
     * 
     * @param instance The given instance
     * @return A list of concepts enumerating the given instance
     */
    public static List<Concept> findConceptsWithEnumeratedInstance(ConceptInstance instance) {
        return findInverseReferencers(instance, Concept.class, OmlPackage.Literals.CONCEPT__ENUMERATED_INSTANCES);
    }

    // RelationBase
    
    /**
     * Finds relation bases referencing the given entity as source
     * 
     * @param source The referenced entity
     * @return A list of referencing relation bases
     */
    public static List<RelationBase> findRelationBasesWithSource(Entity source) {
        return findInverseReferencers(source, RelationBase.class, OmlPackage.Literals.RELATION_BASE__SOURCE);
    }
    
    /**
     * Finds relation bases referencing the given entity as target
     * 
     * @param target The referenced entity
     * @return A list of referencing relation bases
     */
    public static List<RelationBase> findRelationBasesWithTarget(Entity target) {
        return findInverseReferencers(target, RelationBase.class, OmlPackage.Literals.RELATION_BASE__TARGET);
    }
    
    // ScalarProperty
    
    /**
     * Finds scalar properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @return A list of referencing scalar properties
     */
    public static List<ScalarProperty> findScalarPropertiesWithDomain(Classifier domain) {
        return findInverseReferencers(domain, ScalarProperty.class, OmlPackage.Literals.SCALAR_PROPERTY__DOMAIN);
    }

    /**
     * Finds scalar properties referencing the given scalar as range
     * 
     * @param range The referenced scalar
     * @return A list of referencing scalar properties
     */
    public static List<ScalarProperty> findScalarPropertiesWithRange(Scalar range) {
        return findInverseReferencers(range, ScalarProperty.class, OmlPackage.Literals.SCALAR_PROPERTY__RANGE);
    }
    
    // StructuredProperty
    
    /**
     * Finds structured properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @return A list of referencing scalar properties
     */
    public static List<StructuredProperty> findStructuredPropertiesWithDomain(Classifier domain) {
        return findInverseReferencers(domain, StructuredProperty.class, OmlPackage.Literals.STRUCTURED_PROPERTY__DOMAIN);
    }

    /**
     * Finds structured properties referencing the given structure as range
     * 
     * @param range The referenced structure
     * @return A list of referencing structured properties
     */
    public static List<StructuredProperty> findStructuredPropertiesWithRange(Structure range) {
        return findInverseReferencers(range, StructuredProperty.class, OmlPackage.Literals.STRUCTURED_PROPERTY__RANGE);
    }
    
    // StructureInstance
    
    /**
     * Finds structure instances referencing the given structure as type
     * 
     * @param type The referenced structure
     * @return A list of referencing structure instances
     */
    public static List<StructureInstance> findStructureInstancesWithType(Structure type) {
        return findInverseReferencers(type, StructureInstance.class, OmlPackage.Literals.STRUCTURE_INSTANCE__TYPE);
    }
    
    // RelationInstance
    
    /**
     * Finds relation instances referencing the given named instance as source
     * 
     * @param source The referenced named instance
     * @return A list of referencing relation instances
     */
    public static List<RelationInstance> findRelationInstancesWithSource(NamedInstance source) {
        return findInverseReferencers(source, RelationInstance.class, OmlPackage.Literals.RELATION_INSTANCE__SOURCES);
    }
    
    /**
     * Finds relation instances referencing the given named instance as target
     * 
     * @param target The referenced named instance
     * @return A list of referencing relation instances
     */
    public static List<RelationInstance> findRelationInstancesWithTarget(NamedInstance target) {
        return findInverseReferencers(target, RelationInstance.class, OmlPackage.Literals.RELATION_INSTANCE__TARGETS);
    }
    
    // AspectReference
    
    /**
     * Finds aspect references referencing the given aspect
     * 
     * @param aspect The referenced aspect
     * @return A list of referencing aspect references
     */
    public static List<AspectReference> findAspectReferencesWithAspect(Aspect aspect) {
        return findInverseReferencers(aspect, AspectReference.class, OmlPackage.Literals.ASPECT_REFERENCE__ASPECT);
    }
    
    // ConceptReference
    
    /**
     * Finds concept references referencing the given concept
     * 
     * @param concept The referenced concept
     * @return A list of referencing concept references
     */
    public static List<ConceptReference> findConceptReferencesWithConcept(Concept concept) {
        return findInverseReferencers(concept, ConceptReference.class, OmlPackage.Literals.CONCEPT_REFERENCE__CONCEPT);
    }
    
    // RelationEntityReference
    
    /**
     * Finds relation entity references referencing the given relation entity
     * 
     * @param entity The referenced relation entity
     * @return A list of referencing relation entity references
     */
    public static List<RelationEntityReference> findRelationEntityReferencesWithEntity(RelationEntity entity) {
        return findInverseReferencers(entity, RelationEntityReference.class, OmlPackage.Literals.RELATION_ENTITY_REFERENCE__ENTITY);
    }
    
    // StructureReference
    
    /**
     * Finds structure references referencing the given structure
     * 
     * @param structure The referenced structure
     * @return A list of referencing structure references
     */
    public static List<StructureReference> findStructureReferencesWithStructure(Structure structure) {
        return findInverseReferencers(structure, StructureReference.class, OmlPackage.Literals.STRUCTURE_REFERENCE__STRUCTURE);
    }
    
    // AnnotationPropertyReference
    
    /**
     * Finds annotation property references referencing the given annotation property
     * 
     * @param property The referenced annotation property
     * @return A list of referencing annotation property references
     */
    public static List<AnnotationPropertyReference> findAnnotationPropertyReferencesWithProperty(AnnotationProperty property) {
        return findInverseReferencers(property, AnnotationPropertyReference.class, OmlPackage.Literals.ANNOTATION_PROPERTY_REFERENCE__PROPERTY);
    }
    
    // ScalarPropertyReference
    
    /**
     * Finds scalar property references referencing the given scalar property
     * 
     * @param property The referenced scalar property
     * @return A list of referencing scalar property references
     */
    public static List<ScalarPropertyReference> findScalarPropertyReferencesWithProperty(ScalarProperty property) {
        return findInverseReferencers(property, ScalarPropertyReference.class, OmlPackage.Literals.SCALAR_PROPERTY_REFERENCE__PROPERTY);
    }
    
    // StructuredPropertyReference
    
    /**
     * Finds structured property references referencing the given structured property
     * 
     * @param property The referenced structured property
     * @return A list of referencing structured property references
     */
    public static List<StructuredPropertyReference> findStructuredPropertyReferencesWithProperty(StructuredProperty property) {
        return findInverseReferencers(property, StructuredPropertyReference.class, OmlPackage.Literals.STRUCTURED_PROPERTY_REFERENCE__PROPERTY);
    }
    
    // FacetedScalarReference
    
    /**
     * Finds faceted scalar references referencing the given faceted scalar
     * 
     * @param scalar The referenced faceted scalar
     * @return A list of referencing faceted scalar references
     */
    public static List<FacetedScalarReference> findFacetedScalarReferencesWithScalar(FacetedScalar scalar) {
        return findInverseReferencers(scalar, FacetedScalarReference.class, OmlPackage.Literals.FACETED_SCALAR_REFERENCE__SCALAR);
    }
    
    // EnumeratedScalarReference
    
    /**
     * Finds enumerated scalar references referencing the given enumerated scalar
     * 
     * @param scalar The referenced enumerated scalar
     * @return A list of referencing enumerated scalar references
     */
    public static List<EnumeratedScalarReference> findEnumeratedScalarReferencesWithScalar(EnumeratedScalar scalar) {
        return findInverseReferencers(scalar, EnumeratedScalarReference.class, OmlPackage.Literals.ENUMERATED_SCALAR_REFERENCE__SCALAR);
    }
    
    // RelationReference
    
    /**
     * Finds relation references referencing the given relation
     * 
     * @param relation The referenced relation
     * @return A list of referencing relation references
     */
    public static List<RelationReference> findRelationReferencesWithRelation(Relation relation) {
        return findInverseReferencers(relation, RelationReference.class, OmlPackage.Literals.RELATION_REFERENCE__RELATION);
    }
    
    // RuleReference
    
    /**
     * Finds rule references referencing the given rule
     * 
     * @param rule The referenced enumerated scalar
     * @return A list of referencing enumerated scalar references
     */
    public static List<RuleReference> findRuleReferencesWithRule(Rule rule) {
        return findInverseReferencers(rule, RuleReference.class, OmlPackage.Literals.RULE_REFERENCE__RULE);
    }
    
    // ConceptInstanceReference
    
    /**
     * Finds concept instance references referencing the given concept instance
     * 
     * @param instance The referenced concept instance
     * @return A list of referencing concept instance references
     */
    public static List<ConceptInstanceReference> findConceptInstanceReferencesWithInstance(ConceptInstance instance) {
        return findInverseReferencers(instance, ConceptInstanceReference.class, OmlPackage.Literals.CONCEPT_INSTANCE_REFERENCE__INSTANCE);
    }
    
    // RelationInstanceReference
    
    /**
     * Finds relation instance references referencing the given relation instance
     * 
     * @param instance The referenced relation instance
     * @return A list of referencing relation instance references
     */
    public static List<RelationInstanceReference> findRelationInstanceReferencesWithInstance(RelationInstance instance) {
        return findInverseReferencers(instance, RelationInstanceReference.class, OmlPackage.Literals.RELATION_INSTANCE_REFERENCE__INSTANCE); 
    }
    
    // SpecializationAxiom
    
    /**
     * Finds specialization axioms referencing the given specialized term
     * 
     * @param specializedTerm The referenced specialized term
     * @return A list of referencing specialization axioms
     */
    public static List<SpecializationAxiom> findSpecializationAxiomsWithSpecializedTerm(SpecializableTerm specializedTerm) {
        return findInverseReferencers(specializedTerm, SpecializationAxiom.class, OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
    }
    
    // ScalarPropertyRestrictionAxiom
    
    /**
     * Finds scalar property restriction axioms referencing the given scalar property
     * 
     * @param property The referenced scalar property
     * @return A list of referencing scalar property restriction axioms
     */
    public static List<ScalarPropertyRestrictionAxiom> findScalarPropertyRestrictionAxiomsWithProperty(ScalarProperty property) {
        return findInverseReferencers(property, ScalarPropertyRestrictionAxiom.class, OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY);
    }
    
    // ScalarPropertyRangeRestrictionAxiom
    
    /**
     * Finds scalar property range restriction axioms referencing the given scalar as range
     * 
     * @param range The referenced scalar
     * @return A list of referencing scalar property range restriction axioms
     */
    public static List<ScalarPropertyRangeRestrictionAxiom> findScalarPropertyRangeRestrictionAxiomsWithRange(Scalar range) {
        return findInverseReferencers(range, ScalarPropertyRangeRestrictionAxiom.class, OmlPackage.Literals.SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE);
    }
    
    // ScalarPropertyCardinalityRestrictionAxiom
    
    /**
     * Finds scalar property cardinality restriction axioms referencing the given scalar as range
     * 
     * @param range The referenced scalar
     * @return A list of referencing scalar property cardinality restriction axioms
     */
    public static List<ScalarPropertyCardinalityRestrictionAxiom> findScalarPropertyCardinalityRestrictionAxiomsWithRange(Scalar range) {
        return findInverseReferencers(range, ScalarPropertyCardinalityRestrictionAxiom.class, OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE);
    }
    
    // StructuredPropertyRestrictionAxiom
    
    /**
     * Finds structured property restriction axioms referencing the given structured property
     * 
     * @param property The referenced structured property
     * @return A list of referencing structure property restriction axioms
     */
    public static List<StructuredPropertyRestrictionAxiom> findStructuredPropertyRestrictionAxiomsWithProperty(StructuredProperty property) {
        return findInverseReferencers(property, StructuredPropertyRestrictionAxiom.class, OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY);
    }
    
    // StructuredPropertyRangeRestrictionAxiom
    
    /**
     * Finds structured property range restriction axioms referencing the given structure as range
     * 
     * @param range The referenced structure
     * @return A list of referencing structured property range restriction axioms
     */
    public static List<StructuredPropertyRangeRestrictionAxiom> findStructuredPropertyRangeRestrictionAxiomsWithRange(Structure range) {
        return findInverseReferencers(range, StructuredPropertyRangeRestrictionAxiom.class, OmlPackage.Literals.STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE);
    }
    
    // StructuredPropertyCardinalityRestrictionAxiom
    
    /**
     * Finds structured property cardinality restriction axioms referencing the given structure as range
     * 
     * @param range The referenced structure
     * @return A list of referencing structured property cardinality restriction axioms
     */
    public static List<StructuredPropertyCardinalityRestrictionAxiom> findStructuredPropertyCardinalityRestrictionAxiomsWithRange(Structure range) {
        return findInverseReferencers(range, StructuredPropertyCardinalityRestrictionAxiom.class, OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE);
    }
    
    // RelationRestrictionAxiom
    
    /**
     * Finds relation restriction axioms referencing the given relation
     * 
     * @param relation The referenced relation
     * @return A list of referencing relation restriction axioms
     */
    public static List<RelationRestrictionAxiom> findRelationRestrictionAxiomsWithProperty(Relation relation) {
        return findInverseReferencers(relation, RelationRestrictionAxiom.class, OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__PROPERTY);
    }
    
    // RelationRangeRestrictionAxiom
    
    /**
     * Finds relation range restriction axioms referencing the given restricted range
     * 
     * @param range The restricted range
     * @return A list of referencing relation range restriction axioms
     */
    public static List<RelationRangeRestrictionAxiom> findRelationRangeRestrictionAxiomsWithRange(Entity range) {
        return findInverseReferencers(range, RelationRangeRestrictionAxiom.class, OmlPackage.Literals.RELATION_RANGE_RESTRICTION_AXIOM__RANGE);
    }
    
    // RelationCardinalityRestrictionAxiom
    
    /**
     * Finds relation cardinality restriction axioms referencing the given restricted range
     * 
     * @param range The referenced entity
     * @return A list of referencing relation cardinality restriction axioms
     */
    public static List<RelationCardinalityRestrictionAxiom> findRelationCardinalityRestrictionAxiomsWithRange(Entity range) {
        return findInverseReferencers(range, RelationCardinalityRestrictionAxiom.class, OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__RANGE);
    }
    
    // RelationValueRestrictionAxiom
    
    /**
     * Finds relation value restriction axioms referencing the given named instance as a value
     * 
     * @param value The referenced named instance value
     * @return A list of referencing relation value restriction axioms
     */
    public static List<RelationValueRestrictionAxiom> findRelationValueRestrictionAxiomsWithValue(NamedInstance value) {
        return findInverseReferencers(value, RelationValueRestrictionAxiom.class, OmlPackage.Literals.RELATION_VALUE_RESTRICTION_AXIOM__VALUE);
    }
    
    // KeyAxiom
    
    /**
     * Finds key axioms referencing the given property
     * 
     * @param property The referenced property
     * @return A list of referencing key axioms
     */
    public static List<KeyAxiom> findKeyAxiomWithProperty(Property property) {
        return findInverseReferencers(property, KeyAxiom.class, OmlPackage.Literals.KEY_AXIOM__PROPERTIES);
    }
    
    // ConceptTypeAssertion
    
    /**
     * Finds concept type assertions referencing the given concept
     * 
     * @param type The referenced concept
     * @return A list of referencing concept type assertions
     */
    public static List<ConceptTypeAssertion> findConceptTypeAssertionsWithType(Concept type) {
        return findInverseReferencers(type, ConceptTypeAssertion.class, OmlPackage.Literals.CONCEPT_TYPE_ASSERTION__TYPE);
    }
    
    // RelationTypeAssertion
    
    /**
     * Finds relation type assertions referencing the given relation
     * 
     * @param type The referenced relation
     * @return A list of referencing relation type assertions
     */
    public static List<RelationTypeAssertion> findRelationTypeAssertionsWithType(RelationEntity type) {
        return findInverseReferencers(type, RelationTypeAssertion.class, OmlPackage.Literals.RELATION_TYPE_ASSERTION__TYPE);
    }
    
    // ScalarPropertyValueAssertion
    
    /**
     * Finds scalar property value assertions referencing the given scalar property
     * 
     * @param property The referenced scalar property
     * @return A list of referencing scalar property value assertions
     */
    public static List<ScalarPropertyValueAssertion> findScalarPropertyValueAssertionsWithProperty(ScalarProperty property) {
        return findInverseReferencers(property, ScalarPropertyValueAssertion.class, OmlPackage.Literals.SCALAR_PROPERTY_VALUE_ASSERTION__PROPERTY);
    }
    
    // StructuredPropertyValueAssertion
    
    /**
     * Finds structured property value assertions referencing the given structured property
     * 
     * @param property The referenced structured property
     * @return A list of referencing structured property value assertions
     */
    public static List<StructuredPropertyValueAssertion> findStructuredPropertyValueAssertionsWithProperty(StructuredProperty property) {
        return findInverseReferencers(property, StructuredPropertyValueAssertion.class, OmlPackage.Literals.STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY);
    }
    
    // LinkAssertion
    
    /**
     * Finds link assertions referencing the given relation
     * 
     * @param property The referenced (relation) property
     * @return A list of referencing link assertions
     */
    public static List<LinkAssertion> findLinkAssertionsWithProperty(Relation property) {
        return findInverseReferencers(property, LinkAssertion.class, OmlPackage.Literals.LINK_ASSERTION__PROPERTY);
    }
    
    /**
     * Finds link assertions referencing the given named instance as a value
     * 
     * @param value The referenced named instance value
     * @return A list of referencing link assertions
     */
    public static List<LinkAssertion> findLinkAssertionsWithValue(NamedInstance value) {
        return findInverseReferencers(value, LinkAssertion.class, OmlPackage.Literals.LINK_ASSERTION__VALUE);
    }
    
    // TypePredicate
    
    /**
     * Finds type predicates referencing the given type
     * 
     * @param type The referenced type
     * @return A list of referencing type predicates
     */
    public static List<TypePredicate> findTypePredicatesWithClassifier(Type type) {
        return findInverseReferencers(type, TypePredicate.class, OmlPackage.Literals.TYPE_PREDICATE__TYPE);
    }
    
    // RelationEntityPredicate
    
    /**
     * Finds relation entity predicates referencing the given relation entity
     * 
     * @param entity The referenced relation entity
     * @return A list of referencing relation entity predicates
     */
    public static List<RelationEntityPredicate> findRelationEntityPredicatesWithEntity(RelationEntity entity) {
        return findInverseReferencers(entity, RelationEntityPredicate.class, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__ENTITY);
    }
    
    // PropertyPredicate
    
    /**
     * Finds property predicates referencing the given property
     * 
     * @param property The referenced property
     * @return A list of referencing property predicates
     */
    public static List<PropertyPredicate> findPropertyPredicatesWithProperty(Property property) {
        return findInverseReferencers(property, PropertyPredicate.class, OmlPackage.Literals.PROPERTY_PREDICATE__PROPERTY);
    }
    
    // QuotedLiteral
    
    /**
     * Finds quoted literals referencing the given scalar as type
     * 
     * @param type The referenced scalar
     * @return A list of referencing quoted literals
     */
    public static List<QuotedLiteral> findQuotedLiteralsWithType(Scalar type) {
        return findInverseReferencers(type, QuotedLiteral.class, OmlPackage.Literals.QUOTED_LITERAL__TYPE);
    }
    
}