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

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierReference;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityReference;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.NamedInstanceReference;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Reference;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializableTermReference;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.TypeAssertion;

/**
 * The <b>Search</b> API for the model. It complements the {@link OmlIndex} API by additional utilities.
 *  
 * @author elaasar
 */
public final class OmlSearch extends OmlIndex {

    //-------------------------------------------------
    // COMMON
    //-------------------------------------------------

    // Member
    
    /**
     * Finds references to the given member
     * 
     * @param member the given member
     * @return a list of references to the given member
     */
    public static List<Reference> findReferences(Member member) {
        List<Reference> references = new ArrayList<>();
        if (member instanceof AnnotationProperty) {
            references.addAll(findAnnotationPropertyReferencesWithProperty((AnnotationProperty)member));
        } else if (member instanceof Aspect) {
            references.addAll(findAspectReferencesWithAspect((Aspect)member));
        } else if (member instanceof Concept) {
            references.addAll(findConceptReferencesWithConcept((Concept)member));
        } else if (member instanceof RelationEntity) {
            references.addAll(findRelationEntityReferencesWithEntity((RelationEntity)member));
        } else if (member instanceof Structure) {
            references.addAll(findStructureReferencesWithStructure((Structure)member));
        } else if (member instanceof FacetedScalar) {
            references.addAll(findFacetedScalarReferencesWithScalar((FacetedScalar)member));
        } else if (member instanceof EnumeratedScalar) {
            references.addAll(findEnumeratedScalarReferencesWithScalar((EnumeratedScalar)member));
        } else if (member instanceof Relation) {
            references.addAll(findRelationReferencesWithRelation((Relation)member));
        } else if (member instanceof StructuredProperty) {
            references.addAll(findStructuredPropertyReferencesWithProperty((StructuredProperty)member));
        } else if (member instanceof ScalarProperty) {
            references.addAll(findScalarPropertyReferencesWithProperty((ScalarProperty)member));
        } else if (member instanceof Rule) {
            references.addAll(findRuleReferencesWithRule((Rule)member));
        } else if (member instanceof ConceptInstance) {
            references.addAll(findConceptInstanceReferencesWithInstance((ConceptInstance)member));
        } else if (member instanceof RelationInstance) {
            references.addAll(findRelationInstanceReferencesWithInstance((RelationInstance)member));
        }
        return references;
    }

    // AnnotatedElement

    /**
     * Finds annotations of the given element
     * 
     * @param element the given element
     * @return a list of annotations of the given element
     */
    public static List<Annotation> findAnnotations(AnnotatedElement element) {
        final List<Annotation> annotations = new ArrayList<>(element.getOwnedAnnotations());
        if (element instanceof Member) {
            annotations.addAll(findReferences((Member)element).stream()
                .flatMap(r -> r.getOwnedAnnotations().stream())
                .collect(Collectors.toList()));
        }
        return annotations;
    }

    /**
     * Finds literals that are values of a given annotation property on the given element
     * 
     * @param element the given element with annotations
     * @param property the annotation property
     * @return a list of literals that are values of a given annotation property on the given element
     */
    public static List<Literal> findAnnotationValues(AnnotatedElement element, AnnotationProperty property) {
        return findAnnotations(element).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .collect(Collectors.toList());
    }
    
    /**
     * Finds a literal that is a value of a given annotation property on the given element
     * 
     * @param element the given element with annotations
     * @param property the annotation property
     * @return a literal that is a value of a given annotation property on the given element
     */
    public static Literal findAnnotationValue(AnnotatedElement element, AnnotationProperty property) {
        return findAnnotations(element).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .findFirst().orElse(null);
    }

    //-------------------------------------------------
    // ONTOLOGIES
    //-------------------------------------------------

    /**
     * Finds imports that import the given ontology
     * @param ontology the given ontology
     * @return a list of imports that import the given ontology
     */
    public static List<Import> findReferencingImports(Ontology ontology) {
        final Resource resource = ontology.eResource();
        return (resource == null) ? Collections.emptyList() :
            OmlRead.getOntologies(resource.getResourceSet()).stream()
                .flatMap(o -> OmlRead.getImports(o).stream())
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
    // AXIOMS
    //-------------------------------------------------

    // Term

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
            axioms.addAll(findRelationRestrictions(((Entity)term)));
            axioms.addAll(findKeys(((Entity)term)));
        }
        return axioms;
    }

    // SpecializableTerm

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
            .filter(i -> i instanceof SpecializableTermReference)
            .map(i -> (SpecializableTermReference)i)
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

    // Classifier
    
    /**
     * Find property restriction axioms that are defined on the given classifier
     * 
     * @param classifier the given classifier
     * @return a list of property restriction axioms that are defined on the given classifier
     */
    public static List<PropertyRestrictionAxiom> findPropertyRestrictions(Classifier classifier) {
        final List<PropertyRestrictionAxiom> restrictions = new ArrayList<>();
        restrictions.addAll(classifier.getOwnedPropertyRestrictions());
        restrictions.addAll(findReferences(classifier).stream()
            .filter(i -> i instanceof ClassifierReference)
            .map(i -> (ClassifierReference)i)
            .flatMap(r -> r.getOwnedPropertyRestrictions().stream())
            .collect(Collectors.toList()));
        return restrictions;
    }

    // Entity

    /**
     * Find relation restriction axioms that are defined on the given entity
     * 
     * @param entity the given entity
     * @return a list of relation restriction axioms that are defined on the given entity
     */
    public static List<RelationRestrictionAxiom> findRelationRestrictions(Entity entity) {
        final List<RelationRestrictionAxiom> restrictions = new ArrayList<>();
        restrictions.addAll(entity.getOwnedRelationRestrictions());
        restrictions.addAll(findReferences(entity).stream()
            .filter(i -> i instanceof EntityReference)
            .map(i -> (EntityReference)i)
            .flatMap(r -> r.getOwnedRelationRestrictions().stream())
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
            .filter(i -> i instanceof EntityReference)
            .map(i -> (EntityReference)i)
            .flatMap(r -> r.getOwnedKeys().stream())
            .collect(Collectors.toList()));
        return keys;
    }

    //-------------------------------------------------
    // TERMS
    //-------------------------------------------------

    // SpecializableTerm

    /**
     * Finds terms that are the direct super (general) terms of the given term 
     * 
     * @param term the given term
     * @return a list of terms that are the direct super (general) terms of the given term
     */
    public static List<SpecializableTerm> findSuperTerms(SpecializableTerm term) {
        return findSpecializationsWithSubTerm(term).stream()
            .map(i -> OmlRead.getSuperTerm(i))
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

    // Entity

    /**
     * Finds relations that have the given entity as their source
     * 
     * @param entity the given entity
     * @return a list of relations that have the given entity as their source
     */
    public static List<Relation> findSourceRelations(Entity entity) {
        final List<Relation> relations = new ArrayList<>();
        relations.addAll(findRelationEntitiesWithSource(entity).stream()
            .map(r -> r.getForwardRelation())
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        relations.addAll(findRelationEntitiesWithTarget(entity).stream()
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
        relations.addAll(findRelationEntitiesWithTarget(entity).stream()
            .map(r -> r.getForwardRelation())
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        relations.addAll(findRelationEntitiesWithSource(entity).stream()
            .map(r -> r.getReverseRelation())
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        return relations;
    }

    // ScalarProperty

    /**
     * Find entities that have the following property included in one of their keys
     * 
     * @param property the given property
     * @return a list of entities that have the following property included in one of their keys
     */
    public static List<Entity> findEntitiesKeyedWith(ScalarProperty property) {
        return findKeyAxiomWithProperty(property).stream()
            .map(i -> OmlRead.getKeyedEntity(i))
            .collect(Collectors.toList());
    }

    //-------------------------------------------------
    // ASSERTIONS
    //-------------------------------------------------

    // Instance
    
    /**
     * Finds assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @return a list of assertions that are defined on the given instance
     */
    public static List<Assertion> findAssertions(Instance instance) {
        List<Assertion> assertions = new ArrayList<>();
        assertions.addAll(findPropertyValueAssertions(instance));
        if (instance instanceof ConceptInstance) {
            assertions.addAll(findTypeAssertions((ConceptInstance)instance));
            assertions.addAll(findLinkAssertionsWithSource((ConceptInstance)instance));
        } else if (instance instanceof RelationInstance) {
            assertions.addAll(findTypeAssertions((RelationInstance)instance));
            assertions.addAll(findLinkAssertionsWithSource((RelationInstance)instance));
        }
        return assertions;
    }

    // NamedInstance

    /**
     * Finds type assertions that are defined on the given named instance
     * 
     * @param instance the given named instance
     * @return a list of type assertions that are defined on the given named instance
     */
    public static List<TypeAssertion> findTypeAssertions(NamedInstance instance) {
        List<TypeAssertion> assertions = new ArrayList<>();
        if (instance instanceof ConceptInstance) {
            assertions.addAll(findTypeAssertions((ConceptInstance) instance));
        } else if (instance instanceof RelationInstance) {
            assertions.addAll(findTypeAssertions((RelationInstance) instance));
        }
        return assertions;
    }
    
    /**
     * Finds concept type assertions that are defined on the given concept instance
     * 
     * @param instance the given concept instance
     * @return a list of concept type assertions that are defined on the given concept instance
     */
    public static List<ConceptTypeAssertion> findTypeAssertions(ConceptInstance instance) {
        final List<ConceptTypeAssertion> relations = new ArrayList<>(instance.getOwnedTypes());
        relations.addAll(findReferences(instance).stream()
            .filter(i -> i instanceof ConceptInstanceReference)
            .map(i -> (ConceptInstanceReference)i)
            .flatMap(r -> r.getOwnedTypes().stream())
            .collect(Collectors.toList()));
        return relations;
    }

    /**
     * Finds relation type assertions that are defined on the given relation instance
     * 
     * @param instance the given relation instance
     * @return a list of relation type assertions that are defined on the given relation instance
     */
    public static List<RelationTypeAssertion> findTypeAssertions(RelationInstance instance) {
        final List<RelationTypeAssertion> relations = new ArrayList<>(instance.getOwnedTypes());
        relations.addAll(findReferences(instance).stream()
            .filter(i -> i instanceof RelationInstanceReference)
            .map(i -> (RelationInstanceReference)i)
            .flatMap(r -> r.getOwnedTypes().stream())
            .collect(Collectors.toList()));
        return relations;
    }

    // Instance

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
                .filter(i -> i instanceof NamedInstanceReference)
                .map(i -> (NamedInstanceReference)i)
                .flatMap(r -> r.getOwnedPropertyValues().stream())
                .collect(Collectors.toList()));
        }
        return assertions;
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

    // NamedInstance

    /**
     * Finds link assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @return a list of link assertions that are defined on the given instance
     */
    public static List<LinkAssertion> findLinkAssertions(NamedInstance instance) {
        final List<LinkAssertion> assertions = new ArrayList<>(instance.getOwnedLinks());
        assertions.addAll(findReferences(instance).stream()
            .filter(i -> i instanceof NamedInstanceReference)
            .map(i -> (NamedInstanceReference)i)
            .flatMap(r -> r.getOwnedLinks().stream())
            .collect(Collectors.toList()));
        return assertions;
    }

    /**
     * Finds link assertions that have the given instance as their source
     * 
     * @param instance the given instance
     * @return a list of link assertions that have the given instance as their source
     */
    public static List<LinkAssertion> findLinkAssertionsWithSource(NamedInstance instance) {
        return findLinkAssertions(instance);
    }
    
    //-------------------------------------------------
    // INSTANCES
    //-------------------------------------------------

    // Instance
    
    /**
     * Finds classifiers that are types of the given instance
     * 
     * @param instance the given instance
     * @return a list of classifiers that are types of the given instance
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

    // Entity

    /**
     * Finds instances that have the given type as their direct type
     * 
     * @param type the given type
     * @return a list of instances that have the given type as their direct type
     */
    public static List<Instance> findInstancesOfType(Classifier type) {
        if (type instanceof Concept) {
            return findConceptTypeAssertionsWithType((Concept)type).stream()
                .map(i -> OmlRead.getSubject(i))
                .collect(Collectors.toList());
        } else if (type instanceof RelationEntity) {
            return findRelationTypeAssertionsWithType((RelationEntity)type).stream()
                .map(i -> OmlRead.getSubject(i))
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

    
    // StructureInstance

    /**
     * Finds instances that are related to the given instance as sources of relations
     * 
     * @param instance the given instance
     * @return a list of instances that are related to the given instance as sources of relations
     */
    public static List<NamedInstance> findInstancesRelatedFrom(NamedInstance instance) {
        final List<NamedInstance> instances = new ArrayList<>();
        instances.addAll(findLinkAssertionsWithTarget(instance).stream()
                .map(a -> OmlRead.getSource(a))
                .collect(Collectors.toList()));
        instances.addAll(findRelationInstancesWithTarget(instance).stream()
                .flatMap(a -> a.getSources().stream())
                .collect(Collectors.toList()));
        return instances;
    }

    /**
     * Finds instances that are related to the given instance as sources of a given relation
     * 
     * @param instance the given instance
     * @param relation the given relation
     * @return a list of instances that are related to the given instance as sources of a given relation
     */
    public static List<NamedInstance> findInstancesRelatedFrom(NamedInstance instance, Relation relation) {
        final List<NamedInstance> instances = new ArrayList<>();
        instances.addAll(findLinkAssertionsWithTarget(instance).stream()
                .filter(a -> a.getRelation() == relation)
                .map(a -> OmlRead.getSource(a))
                .collect(Collectors.toList()));
        instances.addAll(findRelationInstancesWithTarget(instance).stream()
                .filter(i -> findTypes(i).stream().filter(t -> ((RelationEntity)t).getReverseRelation() == relation).findFirst().isPresent())
                .flatMap(i -> i.getSources().stream())
                .collect(Collectors.toList()));
        return instances;
    }

    /**
     * Finds instances that are related to the given instance as targets of relations
     * 
     * @param instance the given instance
     * @return a list of instances that are related to the given instance as targets of relations
     */
    public static List<NamedInstance> findInstancesRelatedTo(NamedInstance instance) {
        final List<NamedInstance> instances = new ArrayList<>();
        instances.addAll(findLinkAssertions(instance).stream()
                .map(a -> a.getTarget())
                .collect(Collectors.toList()));
        instances.addAll(findRelationInstancesWithSource(instance).stream()
                .flatMap(a -> a.getTargets().stream())
                .collect(Collectors.toList()));
        return instances;
    }

    /**
     * Finds instances that are related to the given instance as targets of a given relation
     * 
     * @param instance the given instance
     * @param relation the given relation
     * @return a list of instances that are related to the given instance as targets of a given relation
     */
    public static List<NamedInstance> findInstancesRelatedTo(NamedInstance instance, Relation relation) {
        final List<NamedInstance> instances = new ArrayList<>();
        instances.addAll(findLinkAssertions(instance).stream()
                .filter(a -> a.getRelation() == relation)
                .map(a -> a.getTarget())
                .collect(Collectors.toList()));
        instances.addAll(findRelationInstancesWithSource(instance).stream()
                .filter(i -> findTypes(i).stream().filter(t -> ((RelationEntity)t).getForwardRelation() == relation).findFirst().isPresent())
                .flatMap(a -> a.getTargets().stream())
                .collect(Collectors.toList()));
        return instances;
    }

    //-------------------------------------------------
    // LITERALS
    //-------------------------------------------------

    // Scalar

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

}
