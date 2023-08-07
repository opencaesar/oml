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

import java.util.Collection;
import java.util.LinkedHashSet;
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
import io.opencaesar.oml.ClassifierEquivalenceAxiom;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.InstanceEnumerationAxiom;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
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
import io.opencaesar.oml.ScalarEquivalenceAxiom;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.Term;
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
    
    /**
     * Finds all objects that cross reference a given object using a given EReference 
     * 
     * @param object The object to search for cross refs to
     * @return A set of settings representing cross references
     */
    static Collection<Setting> findInverseReferencers(EObject object) {
        final ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
        Collection<Setting> settings;
        if (adapter != null) {
            // the fast method
            settings = adapter.getNonNavigableInverseReferences(object);
        } else {
            // the slow method
            settings = searchForNonNavigableInverseReferences(object);
        };
        return settings;
    }

    /**
     * Searches the context (resource set if available or resource) for cross references to a given object
     *  
     * @param object The object to search for cross refs to
     * @return A set of Setting objects including the cross referencing objects and the features they reference with
     */
    private static Collection<Setting> searchForNonNavigableInverseReferences(EObject object) {
        final Resource resource = object.eResource();
        if (resource != null) {
            ResourceSet resourceSet = resource.getResourceSet();
            if (resourceSet != null) {
                return UsageCrossReferencer.find(object, resourceSet);
            } else {
                return UsageCrossReferencer.find(object, resource);
            }
        } else {
            final EObject rootEObject = EcoreUtil.getRootContainer(object);
            return UsageCrossReferencer.find(object, rootEObject);
        }
    }
    
    /**
     * Finds all objects that cross reference a given object conforming to a given Java type and using a given EReference
     * 
     * @param object The object to search for cross refs to
     * @param eReference The eReference to filter the cross refs by
     * @param type The Java type to filter the cross refs by
     * @return A set of objects that cross reference the given object based on the criteria
     */
    private static <T extends EObject> Set<T> findInverseReferencers(EObject object, EReference eReference, Class<T> type) {
        final Set<T> referencers = new LinkedHashSet<>();
        Collection<Setting> settings = findInverseReferencers(object);
        for (Setting setting : settings) {
            if (setting.getEStructuralFeature() == eReference) {
            	var referencer = setting.getEObject();
                if (type.isInstance(referencer)) {
                    referencers.add(type.cast(referencer));
                }
            }
        }
        return referencers;
    }
    
    // Annotation
    
    /**
     * Finds annotations referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing annotations
     */
    public static Set<Annotation> findAnnotationsWithProperty(AnnotationProperty property) {
        return findInverseReferencers(property, OmlPackage.Literals.ANNOTATION__PROPERTY, Annotation.class);
    }
    
    /**
     * Finds annotations referencing the given referenced value
     * 
     * @param value The referenced value
     * @return A set of referencing annotations
     */
    public static Set<Annotation> findAnnotationsWithReferencedValue(Member value) {
        return findInverseReferencers(value, OmlPackage.Literals.ANNOTATION__REFERENCED_VALUE, Annotation.class);
    }

    // Enumeration Axiom

    /**
     * Finds instance enumeration axioms that references the given instance
     * 
     * @param instance The given instance
     * @return A set of instance enumeration axioms enumerating the given instance
     */
    public static Set<InstanceEnumerationAxiom> findInstanceEnumerationAxiomsWithInstance(ConceptInstance instance) {
        return findInverseReferencers(instance, OmlPackage.Literals.INSTANCE_ENUMERATION_AXIOM__INSTANCES, InstanceEnumerationAxiom.class);
    }

    // RelationBase
    
    /**
     * Finds relation bases referencing the given entity as source
     * 
     * @param source The referenced entity
     * @return A set of referencing relation bases
     */
    public static Set<RelationBase> findRelationBasesWithSource(Entity source) {
        return findInverseReferencers(source, OmlPackage.Literals.RELATION_BASE__SOURCES, RelationBase.class);
    }
    
    /**
     * Finds relation bases referencing the given entity as target
     * 
     * @param target The referenced entity
     * @return A set of referencing relation bases
     */
    public static Set<RelationBase> findRelationBasesWithTarget(Entity target) {
        return findInverseReferencers(target, OmlPackage.Literals.RELATION_BASE__TARGETS, RelationBase.class);
    }
    
    // ScalarProperty
    
    /**
     * Finds scalar properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @return A set of referencing scalar properties
     */
    public static Set<ScalarProperty> findScalarPropertiesWithDomain(Classifier domain) {
        return findInverseReferencers(domain, OmlPackage.Literals.SCALAR_PROPERTY__DOMAINS, ScalarProperty.class);
    }

    /**
     * Finds scalar properties referencing the given scalar as range
     * 
     * @param range The referenced scalar
     * @return A set of referencing scalar properties
     */
    public static Set<ScalarProperty> findScalarPropertiesWithRange(Scalar range) {
        return findInverseReferencers(range, OmlPackage.Literals.SCALAR_PROPERTY__RANGES, ScalarProperty.class);
    }
    
    // StructuredProperty
    
    /**
     * Finds structured properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @return A set of referencing scalar properties
     */
    public static Set<StructuredProperty> findStructuredPropertiesWithDomain(Classifier domain) {
        return findInverseReferencers(domain, OmlPackage.Literals.STRUCTURED_PROPERTY__DOMAINS, StructuredProperty.class);
    }

    /**
     * Finds structured properties referencing the given structure as range
     * 
     * @param range The referenced structure
     * @return A set of referencing structured properties
     */
    public static Set<StructuredProperty> findStructuredPropertiesWithRange(Structure range) {
        return findInverseReferencers(range, OmlPackage.Literals.STRUCTURED_PROPERTY__RANGES, StructuredProperty.class);
    }
    
    // StructureInstance
    
    /**
     * Finds structure instances referencing the given structure as type
     * 
     * @param type The referenced structure
     * @return A set of referencing structure instances
     */
    public static Set<StructureInstance> findStructureInstancesWithType(Structure type) {
        return findInverseReferencers(type, OmlPackage.Literals.STRUCTURE_INSTANCE__TYPE, StructureInstance.class);
    }
    
    // RelationInstance
    
    /**
     * Finds relation instances referencing the given named instance as source
     * 
     * @param source The referenced named instance
     * @return A set of referencing relation instances
     */
    public static Set<RelationInstance> findRelationInstancesWithSource(NamedInstance source) {
        return findInverseReferencers(source, OmlPackage.Literals.RELATION_INSTANCE__SOURCES, RelationInstance.class);
    }
    
    /**
     * Finds relation instances referencing the given named instance as target
     * 
     * @param target The referenced named instance
     * @return A set of referencing relation instances
     */
    public static Set<RelationInstance> findRelationInstancesWithTarget(NamedInstance target) {
        return findInverseReferencers(target, OmlPackage.Literals.RELATION_INSTANCE__TARGETS, RelationInstance.class);
    }
    
    // Aspect
    
    /**
     * Finds aspects referencing the given aspect
     * 
     * @param aspect The referenced aspect
     * @return A set of referencing aspects
     */
    public static Set<Aspect> findAspectsWithRef(Aspect aspect) {
        return findInverseReferencers(aspect, OmlPackage.Literals.ASPECT__REF, Aspect.class);
    }
    
    // Concept
    
    /**
     * Finds concept referencing the given concept
     * 
     * @param concept The referenced concept
     * @return A set of referencing concepts
     */
    public static Set<Concept> findConceptsWithRef(Concept concept) {
        return findInverseReferencers(concept, OmlPackage.Literals.CONCEPT__REF, Concept.class);
    }
    
    // RelationEntity
    
    /**
     * Finds relation entity referencing the given relation entity
     * 
     * @param entity The referenced relation entity
     * @return A set of referencing relation entities
     */
    public static Set<RelationEntity> findRelationEntitiesWithRef(RelationEntity entity) {
        return findInverseReferencers(entity, OmlPackage.Literals.RELATION_ENTITY__REF, RelationEntity.class);
    }
    
    // Structure
    
    /**
     * Finds structure referencing the given structure
     * 
     * @param structure The referenced structure
     * @return A set of referencing structures
     */
    public static Set<Structure> findStructuresWithRef(Structure structure) {
        return findInverseReferencers(structure, OmlPackage.Literals.STRUCTURE__REF, Structure.class);
    }
    
    // AnnotationProperty
    
    /**
     * Finds annotation property referencing the given annotation property
     * 
     * @param property The referenced annotation property
     * @return A set of referencing annotation properties
     */
    public static Set<AnnotationProperty> findAnnotationPropertiesWithRef(AnnotationProperty property) {
        return findInverseReferencers(property, OmlPackage.Literals.ANNOTATION_PROPERTY__REF, AnnotationProperty.class);
    }
    
    // ScalarProperty
    
    /**
     * Finds scalar property referencing the given scalar property
     * 
     * @param property The referenced scalar property
     * @return A set of referencing scalar properties
     */
    public static Set<ScalarProperty> findScalarPropertiesWithRef(ScalarProperty property) {
        return findInverseReferencers(property, OmlPackage.Literals.SCALAR_PROPERTY__REF, ScalarProperty.class);
    }
    
    // StructuredProperty
    
    /**
     * Finds structured property referencing the given structured property
     * 
     * @param property The referenced structured property
     * @return A set of referencing structured properties
     */
    public static Set<StructuredProperty> findStructuredPropertiesWithRef(StructuredProperty property) {
        return findInverseReferencers(property, OmlPackage.Literals.STRUCTURED_PROPERTY__REF, StructuredProperty.class);
    }
    
    // Scalar
    
    /**
     * Finds scalar referencing the given scalar
     * 
     * @param scalar The referenced scalar
     * @return A set of referencing scalars
     */
    public static Set<Scalar> findScalarsWithRef(Scalar scalar) {
        return findInverseReferencers(scalar, OmlPackage.Literals.SCALAR__REF, Scalar.class);
    }
    
    // UnreifiedRelation
    
    /**
     * Finds unreified relations referencing the given relation
     * 
     * @param relation The referenced relation
     * @return A set of referencing relations
     */
    public static Set<UnreifiedRelation> findUnreifiedRelationsWithRef(Relation relation) {
        return findInverseReferencers(relation, OmlPackage.Literals.UNREIFIED_RELATION__REF, UnreifiedRelation.class);
    }
    
    // Rule
    
    /**
     * Finds rule referencing the given rule
     * 
     * @param rule The referenced rule
     * @return A set of referencing rules
     */
    public static Set<Rule> findRulesWithRef(Rule rule) {
        return findInverseReferencers(rule, OmlPackage.Literals.RULE__REF, Rule.class);
    }
    
    // BuiltIn
    
    /**
     * Finds builtIn referencing the given builtIn
     * 
     * @param builtIn The referenced builtIn
     * @return A set of referencing builtIn
     */
    public static Set<BuiltIn> findBuiltInsWithRef(BuiltIn builtIn) {
        return findInverseReferencers(builtIn, OmlPackage.Literals.BUILT_IN__REF, BuiltIn.class);
    }

    // ConceptInstance
    
    /**
     * Finds concept instance referencing the given concept instance
     * 
     * @param instance The referenced concept instance
     * @return A set of referencing concept instances
     */
    public static Set<ConceptInstance> findConceptInstancesWithRef(ConceptInstance instance) {
        return findInverseReferencers(instance, OmlPackage.Literals.CONCEPT_INSTANCE__REF, ConceptInstance.class);
    }
    
    // RelationInstance
    
    /**
     * Finds relation instance referencing the given relation instance
     * 
     * @param instance The referenced relation instance
     * @return A set of referencing relation instances
     */
    public static Set<RelationInstance> findRelationInstancesWithRef(RelationInstance instance) {
        return findInverseReferencers(instance, OmlPackage.Literals.RELATION_INSTANCE__REF, RelationInstance.class); 
    }
    
    // SpecializationAxiom
    
    /**
     * Finds specialization axioms referencing the given super term
     * 
     * @param term The referenced super term
     * @return A set of referencing specialization axioms
     */
    public static Set<SpecializationAxiom> findSpecializationAxiomsWithSuperTerm(Term term) {
        return findInverseReferencers(term, OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM, SpecializationAxiom.class);
    }
    
    // ClassifierEquivalenceAxiom
    
    /**
     * Finds classifier equivalence axioms referencing the given classifier
     * 
     * @param classifier The referenced classifier
     * @return A set of referencing classifier equivalence axioms
     */
    public static Set<ClassifierEquivalenceAxiom> findClassifierEquivalenceAxiomsWithSuperClassifier(Classifier classifier) {
        return findInverseReferencers(classifier, OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS, ClassifierEquivalenceAxiom.class);
    }

    // ScalarEquivalenceAxiom
    
    /**
     * Finds scalars equivalence axioms referencing the given scalar
     * 
     * @param scalar The referenced scalar
     * @return A set of referencing scalar equivalence axioms
     */
    public static Set<ScalarEquivalenceAxiom> findScalarEquivalenceAxiomsWithSuperScalar(Scalar scalar) {
        return findInverseReferencers(scalar, OmlPackage.Literals.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR, ScalarEquivalenceAxiom.class);
    }

    // PropertyEquivalenceAxiom
    
    /**
     * Finds property equivalence axioms referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing property equivalence axioms
     */
    public static Set<PropertyEquivalenceAxiom> findPropertyEquivalenceAxiomsWithSuperProperty(Property property) {
        return findInverseReferencers(property, OmlPackage.Literals.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY, PropertyEquivalenceAxiom.class);
    }

    // PropertyRestrictionAxiom
    
    /**
     * Finds property restriction axioms referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing property restriction axioms
     */
    public static Set<PropertyRestrictionAxiom> findPropertyRestrictionAxiomsWithProperty(Property property) {
        return findInverseReferencers(property, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, PropertyRestrictionAxiom.class);
    }
    
    // PropertyRangeRestrictionAxiom
    
    /**
     * Finds property range restriction axioms referencing the given range
     * 
     * @param range The given range
     * @return A set of referencing property range restriction axioms
     */
    public static Set<PropertyRangeRestrictionAxiom> findPropertyRangeRestrictionAxiomsWithRange(Type range) {
        return findInverseReferencers(range, OmlPackage.Literals.PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, PropertyRangeRestrictionAxiom.class);
    }
    
    // PropertyCardinalityRestrictionAxiom
    
    /**
     * Finds property cardinality restriction axioms referencing the given range
     * 
     * @param range The given range
     * @return A set of referencing property cardinality restriction axioms
     */
    public static Set<PropertyCardinalityRestrictionAxiom> findPropertyCardinalityRestrictionAxiomsWithRange(Type range) {
        return findInverseReferencers(range, OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, PropertyCardinalityRestrictionAxiom.class);
    }
    
    // PropertyValueRestrictionAxiom
    
    /**
     * Finds property value restriction axioms referencing the given referenced value
     * 
     * @param value The given referenced value
     * @return A set of referencing property value restriction axioms
     */
    public static Set<PropertyValueRestrictionAxiom> findPropertyValueRestrictionAxiomsWithReferencedValue(NamedInstance value) {
        return findInverseReferencers(value, OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE, PropertyValueRestrictionAxiom.class);
    }
    
    // KeyAxiom
    
    /**
     * Finds key axioms referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing key axioms
     */
    public static Set<KeyAxiom> findKeyAxiomsWithProperty(Property property) {
        return findInverseReferencers(property, OmlPackage.Literals.KEY_AXIOM__PROPERTIES, KeyAxiom.class);
    }
    
    // TypeAssertion
    
    /**
     * Finds type assertions referencing the given type
     * 
     * @param type The referenced type
     * @return A set of referencing type assertions
     */
    public static Set<TypeAssertion> findTypeAssertionsWithType(Entity type) {
        return findInverseReferencers(type, OmlPackage.Literals.TYPE_ASSERTION__TYPE, TypeAssertion.class);
    }
        
    // PropertyValueAssertion
    
    /**
     * Finds property value assertions referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing property value assertions
     */
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithProperty(SemanticProperty property) {
        return findInverseReferencers(property, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, PropertyValueAssertion.class);
    }
    
    /**
     * Finds property value assertions referencing the given referenced value
     * 
     * @param value The referenced value
     * @return A set of referencing property value assertions
     */
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithReferencedValue(NamedInstance value) {
        return findInverseReferencers(value, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE, PropertyValueAssertion.class);
    }
    
    // TypePredicate
    
    /**
     * Finds type predicates referencing the given type
     * 
     * @param type The referenced type
     * @return A set of referencing type predicates
     */
    public static Set<TypePredicate> findTypePredicatesWithType(Type type) {
        return findInverseReferencers(type, OmlPackage.Literals.TYPE_PREDICATE__TYPE, TypePredicate.class);
    }
    
    // RelationEntityPredicate
    
    /**
     * Finds relation entity predicates referencing the given relation entity
     * 
     * @param type The referenced relation entity
     * @return A set of referencing relation entity predicates
     */
    public static Set<RelationEntityPredicate> findRelationEntityPredicatesWithType(RelationEntity type) {
        return findInverseReferencers(type, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__TYPE, RelationEntityPredicate.class);
    }
    
    // PropertyPredicate
    
    /**
     * Finds property predicates referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing property predicates
     */
    public static Set<PropertyPredicate> findPropertyPredicatesWithProperty(Property property) {
        return findInverseReferencers(property, OmlPackage.Literals.PROPERTY_PREDICATE__PROPERTY, PropertyPredicate.class);
    }
    
    // BuiltInPredicate
    
    /**
     * Finds builtIn predicates referencing the given builtIn
     * 
     * @param builtIn The referenced builtIn
     * @return A set of referencing builtIn predicates
     */
    public static Set<BuiltInPredicate> findBuiltInPredicatesWithBuiltIn(BuiltIn builtIn) {
        return findInverseReferencers(builtIn, OmlPackage.Literals.BUILT_IN_PREDICATE__BUILT_IN, BuiltInPredicate.class);
    }

    // QuotedLiteral
    
    /**
     * Finds quoted literals referencing the given scalar as type
     * 
     * @param type The referenced scalar
     * @return A set of referencing quoted literals
     */
    public static Set<QuotedLiteral> findQuotedLiteralsWithType(Scalar type) {
        return findInverseReferencers(type, OmlPackage.Literals.QUOTED_LITERAL__TYPE, QuotedLiteral.class);
    }
    
    // Argument
    
    /**
     * Finds arguments referencing the given named instance
     * 
     * @param instance The referenced instance
     * @return A set of referencing arguments
     */
    public static Set<Argument> findArgumentsWithInstance(NamedInstance instance) {
        return findInverseReferencers(instance, OmlPackage.Literals.ARGUMENT__INSTANCE, Argument.class);
    }

}