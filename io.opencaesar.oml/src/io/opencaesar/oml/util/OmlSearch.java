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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierEquivalenceAxiom;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.InstanceEnumerationAxiom;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
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
import io.opencaesar.oml.SpecializableProperty;
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
        } else if (member instanceof Scalar) {
            references.addAll(findScalarsWithRef((Scalar)member));
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
            axioms.addAll(findSpecializationAxiomsWithSubTerm(((SpecializableTerm)term)));
        }
        if (term instanceof Classifier) {
            axioms.addAll(findPropertyRestrictionAxioms(((Classifier)term)));
            axioms.addAll(findClassifierEquivalenceAxiomsWithSubClassifier(((Classifier)term)));
        }
        if (term instanceof Property) {
            axioms.addAll(findPropertyEquivalenceAxiomsWithSubProperty(((Property)term)));
        }
        if (term instanceof Entity) {
            axioms.addAll(findKeyAxioms(((Entity)term)));
        }
        if (term instanceof Concept) {
            axioms.addAll(findInstanceEnumerationAxioms(((Concept)term)));
        }
        return axioms;
    }

    /**
     * Finds specialization axioms that have the given term as a sub term
     * 
     * @param term the given term
     * @return a list of specialization axioms that have the given term as a sub term
     */
    public static List<SpecializationAxiom> findSpecializationAxiomsWithSubTerm(Term term) {
        final List<SpecializationAxiom> axioms = new ArrayList<>();
        if (term instanceof SpecializableTerm) {
        	axioms.addAll(((SpecializableTerm)term).getOwnedSpecializations());
        }
        axioms.addAll(findReferences(term).stream()
            .filter(i -> i instanceof SpecializableTerm)
            .map(i -> (SpecializableTerm)i)
            .flatMap(r -> r.getOwnedSpecializations().stream())
            .collect(Collectors.toList()));
        return axioms;
    }

    /**
     * Finds classifier equivalence axioms that have the given classifier as a sub
     * 
     * @param classifier the given classifier
     * @return a list of classifier equivalence axioms that have the given classifier as a sub
     */
    public static List<ClassifierEquivalenceAxiom> findClassifierEquivalenceAxiomsWithSubClassifier(Classifier classifier) {
        final List<ClassifierEquivalenceAxiom> axioms = new ArrayList<>();
       	axioms.addAll(classifier.getOwnedEquivalences());
        axioms.addAll(findReferences(classifier).stream()
            .filter(i -> i instanceof Classifier)
            .map(i -> (Classifier)i)
            .flatMap(r -> r.getOwnedEquivalences().stream())
            .collect(Collectors.toList()));
        return axioms;
    }

    /**
     * Finds property equivalence axioms that have the given property as a sub
     * 
     * @param property the given property
     * @return a list of property equivalence axioms that have the given property as a sub
     */
    public static List<PropertyEquivalenceAxiom> findPropertyEquivalenceAxiomsWithSubProperty(Property property) {
        final List<PropertyEquivalenceAxiom> axioms = new ArrayList<>();
        if (property instanceof SpecializableProperty) {
        	axioms.addAll(((SpecializableProperty)property).getOwnedEquivalences());
        }
        axioms.addAll(findReferences(property).stream()
            .filter(i -> i instanceof SpecializableProperty)
            .map(i -> (SpecializableProperty)i)
            .flatMap(r -> r.getOwnedEquivalences().stream())
            .collect(Collectors.toList()));
        return axioms;
    }

    /**
     * Find property restriction axioms that are defined on the given classifier
     * 
     * @param classifier the given classifier
     * @return a list of restriction axioms that are defined on the given classifier
     */
    public static List<PropertyRestrictionAxiom> findPropertyRestrictionAxioms(Classifier classifier) {
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
    public static List<KeyAxiom> findKeyAxioms(Entity entity) {
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
     * Find instance enumeration axioms that are defined on the given concept
     * 
     * @param concept the given concept
     * @return a list of instance enumeration axioms that are defined on the given concept
     */
    public static List<InstanceEnumerationAxiom> findInstanceEnumerationAxioms(Concept concept) {
        final List<InstanceEnumerationAxiom> keys = new ArrayList<>();
        keys.add(concept.getOwnedEnumeration());
        keys.addAll(findReferences(concept).stream()
            .filter(i -> i instanceof Concept)
            .map(i -> (Concept)i)
            .map(r -> r.getOwnedEnumeration())
            .collect(Collectors.toList()));
        return keys;
    }

    /**
     * Finds terms that are the direct super (general) terms of the given term 
     * 
     * @param term the given term
     * @return a list of terms that are the direct super (general) terms of the given term
     */
    public static List<Term> findSuperTerms(Term term) {
        final Set<Term> supers = new LinkedHashSet<>();
        supers.addAll(findSpecializationSuperTerms(term));
        if (term instanceof Classifier) {
        	supers.addAll(findEquivalenceSuperClassifiers((Classifier)term));
        	supers.addAll(findEquivalentClassifiers((Classifier)term));
        } else if (term instanceof Property) {
        	supers.addAll(findEquivalentProperties((Property)term));
        }
        return new ArrayList<Term>(supers);
    }

    /**
     * Finds terms that are the direct or transitive super (general) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a list of terms that are the direct or transitive super (general) terms of the given term
     */
    public static List<Term> findAllSuperTerms(Term term, boolean inclusive) {
        return OmlRead.closure(term, inclusive, t -> findSuperTerms(t));
    }
    
    /**
     * Finds terms that are the direct sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @return a list of terms that are the direct sub (specific) terms of the given term
     */
    public static List<Term> findSubTerms(Term term) {
        final Set<Term> subs = new LinkedHashSet<>();
        subs.addAll(findSpecializationSubTerms(term));
        if (term instanceof Classifier) {
        	subs.addAll(findEquivalenceSubClassifiers((Classifier)term));
        	subs.addAll(findEquivalentClassifiers((Classifier)term));
        } else if (term instanceof Property) {
        	subs.addAll(findEquivalentProperties((Property)term));
        }
        return new ArrayList<Term>(subs);
    }

    /**
     * Finds terms that are the direct or transitive sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a list of terms that are the direct or transitive sub (specific) terms of the given term
     */
    public static List<Term> findAllSubTerms(Term term, boolean inclusive) {
        return OmlRead.closure(term, inclusive, t -> findSubTerms(t));
    }

    /**
     * Determines if the given term is a sub term of the given super term  
     * 
     * @param term the given term
     * @param superTerm the given super term
     * @return true if the given term is a sub term of the given super term; otherwise false
     */
    public static boolean findIsSubTermOf(Term term, Term superTerm) {
        return OmlRead.isInClosure(superTerm, term, true, t -> findSuperTerms(t));
    }

    /**
     * Finds terms that are the direct specialization super terms of the given term 
     * 
     * @param term the given term
     * @return a list of terms that are the direct specialization super terms of the given term
     */
    public static List<Term> findSpecializationSuperTerms(Term term) {
        return findSpecializationAxiomsWithSubTerm(term).stream()
                .map(i -> i.getSuperTerm())
                .collect(Collectors.toList());
    }
    
    /**
     * Finds terms that are the direct specialization sub terms of the given term 
     * 
     * @param term the given term
     * @return a list of terms that are the direct specialization sub terms of the given term
     */
    public static List<Term> findSpecializationSubTerms(Term term) {
        return findSpecializationAxiomsWithSuperTerm(term).stream()
            .map(i -> i.getSubTerm())
            .collect(Collectors.toList());
    }

    /**
     * Finds classifiers that are the direct equivalence super of a given classifier 
     * 
     * @param classifier the given classifier
     * @return a list of classifier that are the direct equivalence super of the given classifier
     */
    public static List<Classifier> findEquivalenceSuperClassifiers(Classifier classifier) {
        return findClassifierEquivalenceAxiomsWithSubClassifier(classifier).stream()
            .flatMap(i -> i.getSuperClassifiers().stream())
            .collect(Collectors.toList());
    }
    
    /**
     * Finds classifiers that are the direct equivalence sub of a given classifier 
     * 
     * @param classifier the given classifier
     * @return a list of classifier that are the direct equivalence sub of the given classifier
     */
    public static List<Classifier> findEquivalenceSubClassifiers(Classifier classifier) {
        return findClassifierEquivalenceAxiomsWithSuperClassifier(classifier).stream()
            .map(i -> i.getSubClassifier())
            .collect(Collectors.toList());
    }
    
    /**
     * Finds classifiers that are the direct equivalent to a given classifier 
     * 
     * @param classifier the given classifier
     * @return a list of classifier that are the direct equivalents of the given classifier
     */
    public static List<Classifier> findEquivalentClassifiers(Classifier classifier) {
        final List<Classifier> equivalents = new ArrayList<>();
        equivalents.addAll(findClassifierEquivalenceAxiomsWithSubClassifier(classifier).stream()
            	.filter(i -> i.getSuperClassifiers().size() == 1)
                .flatMap(i -> i.getSuperClassifiers().stream())
                .collect(Collectors.toList()));
        equivalents.addAll(findClassifierEquivalenceAxiomsWithSuperClassifier(classifier).stream()
        	.filter(i -> i.getSuperClassifiers().size() == 1)
            .map(i -> i.getSubClassifier())
            .collect(Collectors.toList()));
        return equivalents;
    }

    /**
     * Finds properties that are the direct equivalence super of a given property 
     * 
     * @param property the given property
     * @return a list of properties that are the direct equivalence super of the given property
     */
    public static List<Property> findEquivalenceSuperProperties(Property property) {
        return findPropertyEquivalenceAxiomsWithSubProperty(property).stream()
            .map(i -> i.getSuperProperty())
            .collect(Collectors.toList());
    }
    
    /**
     * Finds properties that are the direct equivalence sub of a given property 
     * 
     * @param property the given property
     * @return a list of properties that are the direct equivalence sub of the given property
     */
    public static List<Property> findEquivalenceSubProperties(Property property) {
        return findPropertyEquivalenceAxiomsWithSuperProperty(property).stream()
            .map(i -> i.getSubProperty())
            .collect(Collectors.toList());
    }

    /**
     * Finds properties that are the direct equivalent to a given property 
     * 
     * @param property the given property
     * @return a list of property that are the direct equivalents of the given property
     */
    public static List<Property> findEquivalentProperties(Property property) {
        final List<Property> equivalents = new ArrayList<>();
        equivalents.addAll(findPropertyEquivalenceAxiomsWithSubProperty(property).stream()
                .map(i -> i.getSuperProperty())
                .collect(Collectors.toList()));
        equivalents.addAll(findPropertyEquivalenceAxiomsWithSuperProperty(property).stream()
            .map(i -> i.getSubProperty())
            .collect(Collectors.toList()));
        return equivalents;
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
            .map(i -> i.getKeyedEntity())
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
	                .filter(i -> findIsOfType(i, ((ForwardRelation)relation).getRelationEntity()))
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
	                .filter(i -> findIsOfType(i, ((ForwardRelation)relation).getRelationEntity()))
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
    public static boolean findIsOfType(Instance instance, Classifier type) {
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
    public static boolean findIsOfKind(Instance instance, Classifier type) {
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
                .map(i -> i.getAssertingInstance())
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
     * Finds the scalar that is the direct type of the given literal
     * 
     * @param literal the given literal
     * @return a scalar that is the type of the given literal
     */
    public static Scalar findType(Literal literal) {
        return OmlRead.getType(literal);
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
     * Finds if the given literal is typed directly or transitively by the given type
     * 
     * @param literal the given literal
     * @param type the given type
     * @return true if the given literal is typed directly or transitively by the given type; otherwise false
     */
    /**
     * Determines if the given literal is typed directly by the given type
     * 
     * @param literal the given literal
     * @param type the given type
     * @return true if the given literal is typed directly by the given type; otherwise false
     */
    public static boolean findIsOfKind(Literal literal, Scalar type) {
    	if (type.getOwnedEnumeration() != null) {
    		return type.getOwnedEnumeration().getLiterals().stream().anyMatch(i -> OmlRead.getLexicalValue(i).equals(OmlRead.getLexicalValue(literal)));
    	} else if (OmlRead.isStandardScalar(type)) {
    		return findAllTypes(literal).contains(type);
    	}
    	for (Term t : findAllSuperTerms(type, false)) {
    		Scalar supertype = (Scalar)t;
    		if (!findIsOfKind(literal, supertype)) {
    			return false;
    		}
    	}
    	return true;
	}
}
