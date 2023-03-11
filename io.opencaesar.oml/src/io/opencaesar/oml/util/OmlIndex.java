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
import io.opencaesar.oml.Argument;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.BuiltIn;
import io.opencaesar.oml.BuiltInPredicate;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumerationAxiom;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.UnreifiedRelation;

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
    
    // Enumeration Axiom

    /**
     * Finds enumeration axioms that enumerates the given instance
     * 
     * @param instance The given instance
     * @return A list of enumeration axioms enumerating the given instance
     */
    public static List<EnumerationAxiom> findEnumerationAxiomsWithEnumeratedInstance(ConceptInstance instance) {
        return findInverseReferencers(instance, EnumerationAxiom.class, OmlPackage.Literals.ENUMERATION_AXIOM__INSTANCES);
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
    
    // Aspect
    
    /**
     * Finds aspects referencing the given aspect
     * 
     * @param aspect The referenced aspect
     * @return A list of referencing aspects
     */
    public static List<Aspect> findAspectsWithRef(Aspect aspect) {
        return findInverseReferencers(aspect, Aspect.class, OmlPackage.Literals.ASPECT__REF);
    }
    
    // Concept
    
    /**
     * Finds concept referencing the given concept
     * 
     * @param concept The referenced concept
     * @return A list of referencing concepts
     */
    public static List<Concept> findConceptsWithRef(Concept concept) {
        return findInverseReferencers(concept, Concept.class, OmlPackage.Literals.CONCEPT__REF);
    }
    
    // RelationEntity
    
    /**
     * Finds relation entity referencing the given relation entity
     * 
     * @param entity The referenced relation entity
     * @return A list of referencing relation entities
     */
    public static List<RelationEntity> findRelationEntitiesWithRef(RelationEntity entity) {
        return findInverseReferencers(entity, RelationEntity.class, OmlPackage.Literals.RELATION_ENTITY__REF);
    }
    
    // Structure
    
    /**
     * Finds structure referencing the given structure
     * 
     * @param structure The referenced structure
     * @return A list of referencing structures
     */
    public static List<Structure> findStructuresWithRef(Structure structure) {
        return findInverseReferencers(structure, Structure.class, OmlPackage.Literals.STRUCTURE__REF);
    }
    
    // AnnotationProperty
    
    /**
     * Finds annotation property referencing the given annotation property
     * 
     * @param property The referenced annotation property
     * @return A list of referencing annotation properties
     */
    public static List<AnnotationProperty> findAnnotationPropertiesWithRef(AnnotationProperty property) {
        return findInverseReferencers(property, AnnotationProperty.class, OmlPackage.Literals.ANNOTATION_PROPERTY__REF);
    }
    
    // ScalarProperty
    
    /**
     * Finds scalar property referencing the given scalar property
     * 
     * @param property The referenced scalar property
     * @return A list of referencing scalar properties
     */
    public static List<ScalarProperty> findScalarPropertiesWithRef(ScalarProperty property) {
        return findInverseReferencers(property, ScalarProperty.class, OmlPackage.Literals.SCALAR_PROPERTY__REF);
    }
    
    // StructuredProperty
    
    /**
     * Finds structured property referencing the given structured property
     * 
     * @param property The referenced structured property
     * @return A list of referencing structured properties
     */
    public static List<StructuredProperty> findStructuredPropertiesWithRef(StructuredProperty property) {
        return findInverseReferencers(property, StructuredProperty.class, OmlPackage.Literals.STRUCTURED_PROPERTY__REF);
    }
    
    // FacetedScalar
    
    /**
     * Finds faceted scalar referencing the given faceted scalar
     * 
     * @param scalar The referenced faceted scalar
     * @return A list of referencing faceted scalars
     */
    public static List<FacetedScalar> findFacetedScalarsWithRef(FacetedScalar scalar) {
        return findInverseReferencers(scalar, FacetedScalar.class, OmlPackage.Literals.FACETED_SCALAR__REF);
    }
    
    // EnumeratedScalar
    
    /**
     * Finds enumerated scalar references referencing the given enumerated scalar
     * 
     * @param scalar The referenced enumerated scalar
     * @return A list of referencing enumerated scalars
     */
    public static List<EnumeratedScalar> findEnumeratedScalarsWithRef(EnumeratedScalar scalar) {
        return findInverseReferencers(scalar, EnumeratedScalar.class, OmlPackage.Literals.ENUMERATED_SCALAR__REF);
    }
    
    // UnreifiedRelation
    
    /**
     * Finds unreified relations referencing the given relation
     * 
     * @param relation The referenced relation
     * @return A list of referencing relations
     */
    public static List<UnreifiedRelation> findUnreifiedRelationsWithRef(Relation relation) {
        return findInverseReferencers(relation, UnreifiedRelation.class, OmlPackage.Literals.UNREIFIED_RELATION__REF);
    }
    
    // Rule
    
    /**
     * Finds rule referencing the given rule
     * 
     * @param rule The referenced rule
     * @return A list of referencing rules
     */
    public static List<Rule> findRulesWithRef(Rule rule) {
        return findInverseReferencers(rule, Rule.class, OmlPackage.Literals.RULE__REF);
    }
    
    // BuiltIn
    
    /**
     * Finds builtIn referencing the given builtIn
     * 
     * @param builtIn The referenced builtIn
     * @return A list of referencing builtIn
     */
    public static List<BuiltIn> findBuiltInsWithRef(BuiltIn builtIn) {
        return findInverseReferencers(builtIn, BuiltIn.class, OmlPackage.Literals.BUILT_IN__REF);
    }

    // ConceptInstance
    
    /**
     * Finds concept instance referencing the given concept instance
     * 
     * @param instance The referenced concept instance
     * @return A list of referencing concept instances
     */
    public static List<ConceptInstance> findConceptInstancesWithRef(ConceptInstance instance) {
        return findInverseReferencers(instance, ConceptInstance.class, OmlPackage.Literals.CONCEPT_INSTANCE__REF);
    }
    
    // RelationInstance
    
    /**
     * Finds relation instance referencing the given relation instance
     * 
     * @param instance The referenced relation instance
     * @return A list of referencing relation instances
     */
    public static List<RelationInstance> findRelationInstancesWithRef(RelationInstance instance) {
        return findInverseReferencers(instance, RelationInstance.class, OmlPackage.Literals.RELATION_INSTANCE__REF); 
    }
    
    // SpecializationAxiom
    
    /**
     * Finds specialization axioms referencing the given specialized term
     * 
     * @param specializedTerm The referenced specialized term
     * @return A list of referencing specialization axioms
     */
    public static List<SpecializationAxiom> findSpecializationAxiomsWithSpecializedTerm(SpecializableTerm specializedTerm) {
        return findInverseReferencers(specializedTerm, SpecializationAxiom.class, OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM);
    }
    
    // PropertyRestrictionAxiom
    
    /**
     * Finds property restriction axioms referencing the given property
     * 
     * @param property The referenced property
     * @return A list of referencing property restriction axioms
     */
    public static List<PropertyRestrictionAxiom> findPropertyRestrictionAxiomsWithProperty(Property property) {
        return findInverseReferencers(property, PropertyRestrictionAxiom.class, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
    }
    
    // PropertyRangeRestrictionAxiom
    
    /**
     * Finds property range restriction axioms referencing the given range
     * 
     * @param range The given range
     * @return A list of referencing property range restriction axioms
     */
    public static List<PropertyRangeRestrictionAxiom> findPropertyRangeRestrictionAxiomsWithRange(Type range) {
        return findInverseReferencers(range, PropertyRangeRestrictionAxiom.class, OmlPackage.Literals.PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE);
    }
    
    // PropertyCardinalityRestrictionAxiom
    
    /**
     * Finds property cardinality restriction axioms referencing the given range
     * 
     * @param range The given range
     * @return A list of referencing property cardinality restriction axioms
     */
    public static List<PropertyCardinalityRestrictionAxiom> findPropertyCardinalityRestrictionAxiomsWithRange(Type range) {
        return findInverseReferencers(range, PropertyCardinalityRestrictionAxiom.class, OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE);
    }
    
    // PropertyValueRestrictionAxiom
    
    /**
     * Finds property value restriction axioms referencing the given named instance as a value
     * 
     * @param value The given named instance value
     * @return A list of referencing property value restriction axioms
     */
    public static List<PropertyValueRestrictionAxiom> findPropertyValueRestrictionAxiomsWithNamedInstanceValue(NamedInstance value) {
        return findInverseReferencers(value, PropertyValueRestrictionAxiom.class, OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__NAMED_INSTANCE_VALUE);
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
    
    // TypeAssertion
    
    /**
     * Finds type assertions referencing the given type
     * 
     * @param type The referenced type
     * @return A list of referencing type assertions
     */
    public static List<TypeAssertion> findTypeAssertionsWithType(Entity type) {
        return findInverseReferencers(type, TypeAssertion.class, OmlPackage.Literals.TYPE_ASSERTION__TYPE);
    }
        
    // PropertyValueAssertion
    
    /**
     * Finds property value assertions referencing the given property
     * 
     * @param property The referenced property
     * @return A list of referencing property value assertions
     */
    public static List<PropertyValueAssertion> findPropertyValueAssertionsWithProperty(SemanticProperty property) {
        return findInverseReferencers(property, PropertyValueAssertion.class, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY);
    }
    
    /**
     * Finds property value assertions referencing the given named instance as a value
     * 
     * @param value The referenced named instance value
     * @return A list of referencing property value assertions
     */
    public static List<PropertyValueAssertion> findPropertyValueAssertionsWithNamedInstanceValue(NamedInstance value) {
        return findInverseReferencers(value, PropertyValueAssertion.class, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__NAMED_INSTANCE_VALUE);
    }
    
    // TypePredicate
    
    /**
     * Finds type predicates referencing the given type
     * 
     * @param type The referenced type
     * @return A list of referencing type predicates
     */
    public static List<TypePredicate> findTypePredicatesWithType(Type type) {
        return findInverseReferencers(type, TypePredicate.class, OmlPackage.Literals.TYPE_PREDICATE__TYPE);
    }
    
    // RelationEntityPredicate
    
    /**
     * Finds relation entity predicates referencing the given relation entity
     * 
     * @param type The referenced relation entity
     * @return A list of referencing relation entity predicates
     */
    public static List<RelationEntityPredicate> findRelationEntityPredicatesWithType(RelationEntity type) {
        return findInverseReferencers(type, RelationEntityPredicate.class, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__TYPE);
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
    
    // BuiltInPredicate
    
    /**
     * Finds builtIn predicates referencing the given builtIn
     * 
     * @param builtIn The referenced builtIn
     * @return A list of referencing builtIn predicates
     */
    public static List<BuiltInPredicate> findBuiltInPredicateWithBuiltIn(BuiltIn builtIn) {
        return findInverseReferencers(builtIn, BuiltInPredicate.class, OmlPackage.Literals.BUILT_IN_PREDICATE__BUILT_IN);
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
    
    // Argument
    
    /**
     * Finds arguments referencing the given named instance
     * 
     * @param instance The referenced instance
     * @return A list of referencing arguments
     */
    public static List<Argument> findArgumentsWithInstance(NamedInstance instance) {
        return findInverseReferencers(instance, Argument.class, OmlPackage.Literals.ARGUMENT__INSTANCE);
    }

}