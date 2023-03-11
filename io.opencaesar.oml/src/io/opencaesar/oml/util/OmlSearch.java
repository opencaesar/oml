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

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
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
import io.opencaesar.oml.Term;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.UnreifiedRelation;

/**
 * The <b>Search</b> API for the model. It complements the {@link OmlIndex} API by additional utilities.
 *  
 * @author elaasar
 */
public final class OmlSearch extends OmlIndex {

    //-------------------------------------------------
    // ONTOLOGIES
    //-------------------------------------------------

    /**
     * Finds references to the given member
     * 
     * @param member the given member
     * @return a list of references to the given member
     */
    public static List<Member> findReferences(Member member) {
        List<Member> references = new ArrayList<>();
        if (member instanceof AnnotationProperty) {
            references.addAll(findAnnotationPropertiesWithRef((AnnotationProperty)member));
        } else if (member instanceof Aspect) {
            references.addAll(findAspectsWithRef((Aspect)member));
        } else if (member instanceof Concept) {
            references.addAll(findConceptsWithRef((Concept)member));
        } else if (member instanceof RelationEntity) {
            references.addAll(findRelationEntitiesWithRef((RelationEntity)member));
        } else if (member instanceof Structure) {
            references.addAll(findStructuresWithRef((Structure)member));
        } else if (member instanceof FacetedScalar) {
            references.addAll(findFacetedScalarsWithRef((FacetedScalar)member));
        } else if (member instanceof EnumeratedScalar) {
            references.addAll(findEnumeratedScalarsWithRef((EnumeratedScalar)member));
        } else if (member instanceof Relation) {
            references.addAll(findUnreifiedRelationsWithRef((Relation)member));
        } else if (member instanceof StructuredProperty) {
            references.addAll(findStructuredPropertiesWithRef((StructuredProperty)member));
        } else if (member instanceof ScalarProperty) {
            references.addAll(findScalarPropertiesWithRef((ScalarProperty)member));
        } else if (member instanceof Rule) {
            references.addAll(findRulesWithRef((Rule)member));
        } else if (member instanceof ConceptInstance) {
            references.addAll(findConceptInstancesWithRef((ConceptInstance)member));
        } else if (member instanceof RelationInstance) {
            references.addAll(findRelationInstancesWithRef((RelationInstance)member));
        }
        return references;
    }

    /**
     * Finds annotations of the given element
     * 
     * @param element the given element
     * @return a list of annotations of the given element
     */
    public static List<Annotation> findAnnotations(IdentifiedElement element) {
        final List<Annotation> annotations = new ArrayList<>(element.getOwnedAnnotations());
        if (element instanceof Member) {
            annotations.addAll(findReferences((Member)element).stream()
                .flatMap(r -> r.getOwnedAnnotations().stream())
                .collect(Collectors.toList()));
        }
        return annotations;
    }

    /**
     * Finds the values of a given annotation property in the given element
     * 
     * @param element the given element with annotations
     * @param property the annotation property
     * @return a list of literals representing annotation values
     */
    public static List<Element> findAnnotationValues(IdentifiedElement element, AnnotationProperty property) {
        return findAnnotations(element).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .collect(Collectors.toList());
    }
    
    /**
     * Gets a value of the given annotation property in the given element
     * 
     * @param element the given element with annotations
     * @param property the annotation property
     * @return a literal representing an annotation value
     */
    public static Element findAnnotationValue(IdentifiedElement element, AnnotationProperty property) {
        return findAnnotations(element).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .findFirst().orElse(null);
    }

    /**
     * Finds imports that import the given ontology
     * @param ontology the given ontology
     * @return a list of imports that import the given ontology
     */
    public static List<Import> findReferencingImports(Ontology ontology) {
        final Resource resource = ontology.eResource();
        return (resource == null) ? Collections.emptyList() :
            OmlRead.getOntologies(resource.getResourceSet()).stream()
                .flatMap(o -> o.getOwnedImports().stream())
                .filter(i -> OmlRead.getImportedOntology(i) == ontology)
                .collect(Collectors.toList());
    }

    /**
     * Finds ontologies that import the given ontology
     * 
     * @param ontology the given ontologies
     * @return a list of ontologies that import the given ontology
     */
    public static List<Ontology> findImportingOntologies(Ontology ontology) {
        return findReferencingImports(ontology).stream()
            .map(i -> OmlRead.getImportingOntology(i))
            .collect(Collectors.toList());
    }

    //-------------------------------------------------
    // VOCABULARIES
    //-------------------------------------------------

    /**
     * Finds axioms that are defined for the given term
     * 
     * @param term the given term
     * @return a list of axioms that are defined for the given term
     */
    public static List<Axiom> findAxioms(Term term) {
        List<Axiom> axioms = new ArrayList<>();
        if (term instanceof SpecializableTerm){
            axioms.addAll(findSpecializationsWithSubTerm(((SpecializableTerm)term)));
        }
        if (term instanceof Classifier) {
            axioms.addAll(findPropertyRestrictions(((Classifier)term)));
        }
        if (term instanceof Entity) {
            axioms.addAll(findKeys(((Entity)term)));
        }
        return axioms;
    }

    /**
     * Finds specialization axioms that have the given term as a sub term
     * 
     * @param term the given term
     * @return a list of specialization axioms that have the given term as a sub term
     */
    public static List<SpecializationAxiom> findSpecializationsWithSubTerm(SpecializableTerm term) {
        final List<SpecializationAxiom> axioms = new ArrayList<>();
        axioms.addAll(term.getOwnedSpecializations());
        axioms.addAll(findReferences(term).stream()
            .filter(i -> i instanceof SpecializableTerm)
            .map(i -> (SpecializableTerm)i)
            .flatMap(r -> r.getOwnedSpecializations().stream())
            .collect(Collectors.toList()));
        return axioms;
    }

    /**
     * Finds specialization axioms that have the given term as a super term
     * 
     * @param term the given term
     * @return a list of specialization axioms that have the given term as a super term
     */
    public static List<SpecializationAxiom> findSpecializationsWithSuperTerm(SpecializableTerm term) {
        return findSpecializationAxiomsWithSpecializedTerm(term);
    }

    /**
     * Find property restriction axioms that are defined on the given classifier
     * 
     * @param classifier the given classifier
     * @return a list of restriction axioms that are defined on the given classifier
     */
    public static List<PropertyRestrictionAxiom> findPropertyRestrictions(Classifier classifier) {
        final List<PropertyRestrictionAxiom> restrictions = new ArrayList<>();
        restrictions.addAll(classifier.getOwnedPropertyRestrictions());
        restrictions.addAll(findReferences(classifier).stream()
            .filter(i -> i instanceof Classifier)
            .map(i -> (Classifier)i)
            .flatMap(r -> r.getOwnedPropertyRestrictions().stream())
            .collect(Collectors.toList()));
        return restrictions;
    }

    /**
     * Find key axioms that are defined on the given entity
     * 
     * @param entity the given entity
     * @return a list of key axioms that are defined on the given entity
     */
    public static List<KeyAxiom> findKeys(Entity entity) {
        final List<KeyAxiom> keys = new ArrayList<>();
        keys.addAll(entity.getOwnedKeys());
        keys.addAll(findReferences(entity).stream()
            .filter(i -> i instanceof Entity)
            .map(i -> (Entity)i)
            .flatMap(r -> r.getOwnedKeys().stream())
            .collect(Collectors.toList()));
        return keys;
    }

    /**
     * Finds terms that are the direct super (general) terms of the given term 
     * 
     * @param term the given term
     * @return a list of terms that are the direct super (general) terms of the given term
     */
    public static List<SpecializableTerm> findSuperTerms(SpecializableTerm term) {
        return findSpecializationsWithSubTerm(term).stream()
            .map(i -> i.getSuperTerm())
            .collect(Collectors.toList());
    }

    /**
     * Finds terms that are the direct or transitive super (general) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a list of terms that are the direct or transitive super (general) terms of the given term
     */
    public static List<SpecializableTerm> findAllSuperTerms(SpecializableTerm term, boolean inclusive) {
        return OmlRead.closure(term, inclusive, t -> findSuperTerms(t));
    }
    
    /**
     * Finds terms that are the direct sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @return a list of terms that are the direct sub (specific) terms of the given term
     */
    public static List<SpecializableTerm> findSubTerms(SpecializableTerm term) {
        return findSpecializationsWithSuperTerm(term).stream()
            .map(i -> OmlRead.getSubTerm(i))
            .collect(Collectors.toList());
    }

    /**
     * Finds terms that are the direct or transitive sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a list of terms that are the direct or transitive sub (specific) terms of the given term
     */
    public static List<SpecializableTerm> findAllSubTerms(SpecializableTerm term, boolean inclusive) {
        return OmlRead.closure(term, inclusive, t -> findSubTerms(t));
    }

    /**
     * Determines if the given term is a sub term of the given super term  
     * 
     * @param term the given term
     * @param superTerm the given super term
     * @return true if the given term is a sub term of the given super term; otherwise false
     */
    public static boolean findIsSubTermOf(SpecializableTerm term, SpecializableTerm superTerm) {
        return OmlRead.isInClosure(superTerm, term, true, t -> findSuperTerms(t));
    }

    /**
     * Finds relations that have the given entity as their source
     * 
     * @param entity the given entity
     * @return a list of relations that have the given entity as their source
     */
    public static List<Relation> findSourceRelations(Entity entity) {
        final List<Relation> relations = new ArrayList<>();
        relations.addAll(findRelationBasesWithSource(entity).stream()
        	.filter(r -> r instanceof UnreifiedRelation)
            .map(r -> (UnreifiedRelation)r)
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        relations.addAll(findRelationBasesWithSource(entity).stream()
            	.filter(r -> r instanceof RelationEntity)
                .map(r -> ((RelationEntity)r).getForwardRelation())
                .filter(r -> r != null)
                .collect(Collectors.toList()));
        relations.addAll(findRelationBasesWithTarget(entity).stream()
            .map(r -> r.getReverseRelation())
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        return relations;
    }

    /**
     * Finds relations that have the given entity as their target
     * 
     * @param entity the given entity
     * @return a list of relations that have the given entity as their target
     */
    public static List<Relation> findTargetRelations(Entity entity) {
        final List<Relation> relations = new ArrayList<>();
        relations.addAll(findRelationBasesWithTarget(entity).stream()
           	.filter(r -> r instanceof UnreifiedRelation)
            .map(r -> (UnreifiedRelation)r)
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        relations.addAll(findRelationBasesWithTarget(entity).stream()
            	.filter(r -> r instanceof RelationEntity)
                .map(r -> ((RelationEntity)r).getForwardRelation())
                .filter(r -> r != null)
                .collect(Collectors.toList()));
        relations.addAll(findRelationBasesWithSource(entity).stream()
            .map(r -> r.getReverseRelation())
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        return relations;
    }

    /**
     * Finds semantic properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @return A list of referencing semantic properties
     */
    public static List<SemanticProperty> findSemanticPropertiesWithDomain(Classifier domain) {
    	var properties = new ArrayList<SemanticProperty>();
    	properties.addAll(findScalarPropertiesWithDomain(domain));
    	properties.addAll(findStructuredPropertiesWithDomain(domain));
        return properties;
    }
    
    /**
     * Find entities that have the following property included in one of their keys
     * 
     * @param property the given property
     * @return a list of entities that have the following property included in one of their keys
     */
    public static List<Entity> findEntitiesKeyedWith(SemanticProperty property) {
        return findKeyAxiomWithProperty(property).stream()
            .map(i -> OmlRead.getKeyedEntity(i))
            .collect(Collectors.toList());
    }

    //-------------------------------------------------
    // DESCRIPTIONS
    //-------------------------------------------------

    /**
     * Finds assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @return a list of assertions that are defined on the given instance
     */
    public static List<Assertion> findAssertions(Instance instance) {
        List<Assertion> assertions = new ArrayList<>();
        assertions.addAll(findPropertyValueAssertions(instance));
        if (instance instanceof NamedInstance) {
            assertions.addAll(findTypeAssertions((NamedInstance)instance));
        }
        return assertions;
    }

    /**
     * Finds type assertions that are defined on the given named instance
     * 
     * @param instance the given named instance
     * @return a list of type assertions that are defined on the given named instance
     */
    public static List<TypeAssertion> findTypeAssertions(NamedInstance instance) {
        final List<TypeAssertion> assertions = new ArrayList<>(instance.getOwnedTypes());
        assertions.addAll(findReferences(instance).stream()
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .flatMap(r -> r.getOwnedTypes().stream())
            .collect(Collectors.toList()));
        return assertions;
    }
    
    /**
     * Finds property value assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @return a list of property value assertions that are defined on the given instance
     */
    public static List<PropertyValueAssertion> findPropertyValueAssertions(Instance instance) {
        final List<PropertyValueAssertion> assertions = new ArrayList<>(instance.getOwnedPropertyValues());
        if (instance instanceof NamedInstance) {
            assertions.addAll(findReferences((NamedInstance)instance).stream()
                .filter(i -> i instanceof NamedInstance)
                .map(i -> (NamedInstance)i)
                .flatMap(r -> r.getOwnedPropertyValues().stream())
                .collect(Collectors.toList()));
        }
        return assertions;
    }

    /**
     * Finds property value assertions that have the given instance as their source
     * 
     * @param source the given source instance
     * @return a list of relation value assertions that have the given instance as their source
     */
    public static List<PropertyValueAssertion> findPropertyValueAssertionsWithSource(NamedInstance source) {
        return findPropertyValueAssertions(source).stream()
                .filter(i -> i.getProperty() instanceof Relation)
                .collect(Collectors.toList());
    }

    /**
     * Finds relation value assertions that have the given instance as their target
     * 
     * @param target the given target instance
     * @return a list of relation value assertions that have the given instance as their target
     */
    public static List<PropertyValueAssertion> findPropertyValueAssertionsWithTarget(NamedInstance target) {
        return findPropertyValueAssertionsWithNamedInstanceValue(target);
    }

    /**
     * Finds instances that are asserted as related to the given instance by any relation
     * 
     * @param instance the given instance
     * @return a list of instances related to the given instance by any relation
     */
    public static List<NamedInstance> findInstancesRelatedTo(NamedInstance instance) {
        final List<NamedInstance> related = new ArrayList<>();
        related.addAll(findInstancesRelatedAsTargetTo(instance));
        related.addAll(findInstancesRelatedAsSourceTo(instance));
        return related;
    }

    /**
     * Finds instances that are asserted as related to the given instance by a given relation
     * 
     * @param instance the given instance
     * @param relation the given relation
     * @return a list of instances related to the given instance by a given relation
     */
    public static List<NamedInstance> findInstancesRelatedTo(NamedInstance instance, Relation relation) {
        final List<NamedInstance> related = new ArrayList<>();
        related.addAll(findInstancesRelatedAsTargetTo(instance, relation));
        related.addAll(findInstancesRelatedAsSourceTo(instance, relation));
        return related;
    }

    /**
     * Finds target instances that are asserted as related to the given source instance by any relation
     * 
     * @param source the given source instance
     * @return a list of target instances related to the given source instance
     */
    public static List<NamedInstance> findInstancesRelatedAsTargetTo(NamedInstance source) {
        final List<NamedInstance> targets = new ArrayList<>();
        // check property value assertions
        targets.addAll(findPropertyValueAssertionsWithSource(source).stream()
                .map(a -> OmlRead.getTarget(a))
                .collect(Collectors.toList()));
        // check relation instances
        targets.addAll(findRelationInstancesWithSource(source).stream()
                .flatMap(a -> a.getTargets().stream())
                .collect(Collectors.toList()));
        return targets;
    }

    /**
     * Finds target instances that are asserted as related to the given source instance by a given relation
     * 
     * @param source the given source instance
     * @param relation the given relation
     * @return a list of target instances related to the given source instance
     */
    public static List<NamedInstance> findInstancesRelatedAsTargetTo(NamedInstance source, Relation relation) {
    	final List<NamedInstance> targets = new ArrayList<>();
        // look in property value assertions
        targets.addAll(findPropertyValueAssertionsWithSource(source).stream()
                .filter(a -> a.getProperty() == relation)
                .map(a -> OmlRead.getTarget(a))
                .collect(Collectors.toList()));
        // look in relation instances
        if (relation instanceof ForwardRelation) {
	        targets.addAll(findRelationInstancesWithSource(source).stream()
	                .filter(i -> findIsTypeOf(i, ((ForwardRelation)relation).getRelationEntity()))
	                .flatMap(a -> a.getTargets().stream())
	                .collect(Collectors.toList()));
        }
        return targets;
    }

    /**
     * Finds source instances that are related by any relation to the given target instance
     * 
     * @param target the given target instance
     * @return a list of source instances related to the given target instance
     */
    public static List<NamedInstance> findInstancesRelatedAsSourceTo(NamedInstance target) {
        final List<NamedInstance> sources = new ArrayList<>();
        // look in property value assertions
       sources.addAll(findPropertyValueAssertionsWithTarget(target).stream()
                .map(a -> OmlRead.getSource(a))
                .collect(Collectors.toList()));
       // look in relation instances
        sources.addAll(findRelationInstancesWithTarget(target).stream()
                .flatMap(a -> a.getSources().stream())
                .collect(Collectors.toList()));
        return sources;
    }

    /**
     * Finds source instances that are related by a given relation to a given target instance
     * 
     * @param target the given target instance
     * @param relation the given relation
     * @return a list of source instances that are related by a given relation to the given target instance
     */
    public static List<NamedInstance> findInstancesRelatedAsSourceTo(NamedInstance target, Relation relation) {
        final List<NamedInstance> sources = new ArrayList<>();
        // look in property value assertions
        sources.addAll(findPropertyValueAssertionsWithTarget(target).stream()
                .filter(a -> a.getProperty() == relation)
                .map(a -> OmlRead.getSource(a))
                .collect(Collectors.toList()));
        // look in relation instances
        if (relation instanceof ForwardRelation) {
	        sources.addAll(findRelationInstancesWithTarget(target).stream()
	                .filter(i -> findIsTypeOf(i, ((ForwardRelation)relation).getRelationEntity()))
	                .flatMap(i -> i.getSources().stream())
	                .collect(Collectors.toList()));
        }
        return sources;
    }

    /**
     * Finds elements that represent values of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @return a list of elements that represent values of given semantic property defined on the given instance
     */
    public static List<Element> findPropertyValues(Instance instance, SemanticProperty property) {
        return findPropertyValueAssertions(instance).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .collect(Collectors.toList());
    }
    
    /**
     * Finds an element that represents a value of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @return an element that represents a value of given semantic property defined on the given instance
     */
    public static Element findPropertyValue(Instance instance, SemanticProperty property) {
        return findPropertyValueAssertions(instance).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .findFirst().orElse(null);
    }

    /**
     * Finds classifiers that are direct types of the given instance
     * 
     * @param instance the given instance
     * @return a list of classifiers that are direcf types of the given instance
     */
    public static List<Classifier> findTypes(Instance instance) {
        List<Classifier> types = new ArrayList<>();
        if (instance instanceof StructureInstance) {
            types.add(((StructureInstance) instance).getType());
        } else if (instance instanceof NamedInstance) {
            types.addAll(findTypeAssertions((NamedInstance)instance).stream().
                map(i -> i.getType()).
                collect(Collectors.toList()));
        }
        return types;
    }
    
    /**
     * Finds classifiers that are direct or indirect types of the given instance
     * 
     * @param instance the given instance
     * @return a list of classifiers that are direct or indirect types of the given instance
     */
    public static List<Classifier> findAllTypes(Instance instance) {
        List<Classifier> types = findTypes(instance).stream()
        		.flatMap(t -> OmlSearch.findAllSuperTerms(t, true).stream())
        		.filter(t -> t instanceof Classifier)
        		.map(t -> (Classifier)t)
        		.distinct()
        		.collect(Collectors.toList());
        return types;
    }

    /**
     * Finds if the given instance is typed directly by the given type
     * 
     * @param instance the given instance
     * @param type the given type
     * @return true if the given instance is typed directly by the given type; otherwise false
     */
    public static boolean findIsTypeOf(Instance instance, Classifier type) {
        if (instance instanceof StructureInstance) {
            return ((StructureInstance)instance).getType() == type;
        } else if (instance instanceof NamedInstance) {
            return findTypeAssertions((NamedInstance)instance).stream()
                .filter(i -> i.getType() == type)
                .findFirst().isPresent();
        }
        return false;
    }

    /**
     * Finds if the given instance is typed directly or transitively by the given type
     * 
     * @param instance the given instance
     * @param type the given type
     * @return true if the given instance is typed directly or transitively by the given type; otherwise false
     */
    public static boolean findIsKindOf(Instance instance, Classifier type) {
        if (instance instanceof StructureInstance) {
            return findIsSubTermOf(((StructureInstance)instance).getType(), type);
        } else if (instance instanceof NamedInstance) {
            return findTypeAssertions((NamedInstance)instance).stream()
                .map(i -> i.getType())
                .filter(t -> findIsSubTermOf(t, type))
                .findFirst().isPresent();
        }
        return false;
    }

    /**
     * Finds instances that have the given type as their direct type
     * 
     * @param type the given type
     * @return a list of instances that have the given type as their direct type
     */
    public static List<Instance> findInstancesOfType(Classifier type) {
        if (type instanceof Entity) {
            return findTypeAssertionsWithType((Entity)type).stream()
                .map(i -> OmlRead.getAssertingInstance(i))
                .collect(Collectors.toList());
        } else if (type instanceof Structure) {
            return new ArrayList<Instance>(findStructureInstancesWithType((Structure)type));
        }
        return Collections.emptyList();
    }

    /**
     * Finds instances that have the given type as their direct or transitive type
     * 
     * @param type the given type
     * @return a list of instances that have the given type as their direct or transitive type
     */
    public static List<Instance> findInstancesOfKind(Classifier type) {
        return findAllSubTerms(type, true).stream()
            .map(t -> (Classifier)t)
            .flatMap(t -> findInstancesOfType(t).stream())
            .collect(Collectors.toList());
    }

    //-------------------------------------------------
    // LITERALS
    //-------------------------------------------------

    /**
     * Finds the Java type that corresponds to the given scalar
     * 
     * @param scalar the given scalar
     * @return the Java type that corresponds to the given scalar
     */
    public static Class<?> findJavaType(Scalar scalar) {
        while (scalar != null) {
            switch (scalar.getIri()) {
                case OmlConstants.XSD_NS+"integer":
                    return Integer.class;
                case OmlConstants.XSD_NS+"decimal":
                    return BigDecimal.class;
                case OmlConstants.XSD_NS+"double":
                    return Double.class;
                case OmlConstants.XSD_NS+"float":
                    return Float.class;
                case OmlConstants.XSD_NS+"boolean":
                    return Boolean.class;
                case OmlConstants.XSD_NS+"dateTime":
                    return Date.class;
                case OmlConstants.OWL_NS+"real":
                    return Double.class;
            }
            scalar = (Scalar) findSuperTerms(scalar).stream().findFirst().get();
        }
        return String.class;
    }

    /**
     * Finds the Java value that corresponds to the given literal
     * 
     * @param literal the given literal
     * @return the Java value that corresponds to the given literal
     */
    public static Object findJavaValue(Literal literal) {
        if (literal instanceof QuotedLiteral) {
            QuotedLiteral qLiteral = (QuotedLiteral)literal;
            String value =  qLiteral.getValue();
            Class<?> type = findJavaType(qLiteral.getType());
            if (type == Integer.class)
                return Integer.valueOf(value);
            else if (type == BigDecimal.class)
                return new BigDecimal(value);
            else if (type == Double.class)
                return Double.valueOf(value);
            else if (type == Float.class)
                return Float.valueOf(value);
            else if (type == Boolean.class)
                return Boolean.valueOf(value);
            else if (type == Date.class)
                try {
                    return new SimpleDateFormat().parse(value);
                } catch (ParseException e) {
                    throw new DateTimeParseException("Error parsing xsd:dateTime", value, 0);
                }
            return value;
        }
        return OmlRead.getValue(literal);
    }

    /**
     * Finds all the scalars that are direct or indirect types of the given literal
     * 
     * @param literal the given literal
     * @return a list of scalars that are direct or indirect types of the given literal
     */
    public static List<Scalar> findAllTypes(Literal literal) {
        List<Scalar> types = OmlSearch.findAllSuperTerms(OmlRead.getType(literal), true).stream()
        		.filter(t -> t instanceof Scalar)
        		.map(t -> (Scalar)t)
        		.distinct()
        		.collect(Collectors.toList());
        return types;
    }

    /**
     * Finds if the given literal is typed directly by the given type
     * 
     * @param literal the given literal
     * @param type the given type
     * @return true if the given literal is typed directly by the given type; otherwise false
     */
    public static boolean findIsTypeOf(Literal literal, Scalar type) {
    	if (type instanceof EnumeratedScalar) {
    		final String lexical = OmlRead.getStringValue(literal);
    		if ((!((EnumeratedScalar)type).getLiterals().stream().anyMatch(i -> OmlRead.getStringValue(i).equals(lexical)))) {
    			return false;
    		}
    		type = (Scalar) OmlRead.getSuperTerms(type).get(0);// scalars have one supertype
    	}
        return type == OmlRead.getType(literal);
    }

    /**
     * Finds if the given literal is typed directly or transitively by the given type
     * 
     * @param literal the given literal
     * @param type the given type
     * @return true if the given literal is typed directly or transitively by the given type; otherwise false
     */
    public static boolean findIsKindOf(Literal literal, Scalar type) {
    	if (type instanceof EnumeratedScalar) {
    		final String lexical = OmlRead.getStringValue(literal);
    		if (!(((EnumeratedScalar)type).getLiterals().stream().anyMatch(i -> OmlRead.getStringValue(i).equals(lexical)))) {
    			return false;
    		}
    		type = (Scalar) OmlRead.getSuperTerms(type).get(0);// scalars have one supertype
    	}
        return findAllTypes(literal).contains(type);
    }
}
