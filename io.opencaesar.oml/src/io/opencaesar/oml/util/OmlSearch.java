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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.resource.Resource;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnonymousInstance;
import io.opencaesar.oml.AnonymousRelationInstance;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityEquivalenceAxiom;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.InstanceEnumerationAxiom;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.LiteralEnumerationAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarEquivalenceAxiom;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializableProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.Type;
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
     * Finds refs to the given member
     * 
     * @param member the given member
     * @param scope The scope of the search (can be null)
     * @return a set of refs to the given member
     */
    public static Set<Member> findRefs(Member member, Set<Resource> scope) {
        Set<Member> refs = new LinkedHashSet<>();
        if (member instanceof AnnotationProperty) {
            refs.addAll(findAnnotationPropertiesWithRef((AnnotationProperty)member, scope));
        } else if (member instanceof Aspect) {
            refs.addAll(findAspectsWithRef((Aspect)member, scope));
        } else if (member instanceof Concept) {
            refs.addAll(findConceptsWithRef((Concept)member, scope));
        } else if (member instanceof RelationEntity) {
            refs.addAll(findRelationEntitiesWithRef((RelationEntity)member, scope));
        } else if (member instanceof Scalar) {
            refs.addAll(findScalarsWithRef((Scalar)member, scope));
        } else if (member instanceof Relation) {
            refs.addAll(findUnreifiedRelationsWithRef((Relation)member, scope));
        } else if (member instanceof ScalarProperty) {
            refs.addAll(findScalarPropertiesWithRef((ScalarProperty)member, scope));
        } else if (member instanceof Rule) {
            refs.addAll(findRulesWithRef((Rule)member, scope));
        } else if (member instanceof ConceptInstance) {
            refs.addAll(findConceptInstancesWithRef((ConceptInstance)member, scope));
        } else if (member instanceof RelationInstance) {
            refs.addAll(findRelationInstancesWithRef((RelationInstance)member, scope));
        }
        return refs;
    }

    /**
     * Finds refs to the given member
     * 
     * @param member the given member
     * @return a set of refs to the given member
     * @deprecated As of 2.5.0. Use {{@link #findRefs(Member, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Member> findRefs(Member member) {
    	return findRefs(member, null);
    }
    
    /*
     * Finds annotations of the given annotation property in the given element
     * 
     * @param element the given element
     * @param property the annotation property
     * @param scope The scope of the search (can be null)
     * @return a set of annotations of the given element
     */
    private static Stream<Annotation> findAnnotations(IdentifiedElement element, AnnotationProperty property, Set<Resource> scope) {
        final Set<Annotation> annotations = new LinkedHashSet<>(element.getOwnedAnnotations());
        if (element instanceof Member) {
        	var member = (Member)element;
            annotations.addAll(findRefs(member, scope).stream()
                .flatMap(r -> r.getOwnedAnnotations().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return annotations.stream().filter(a -> a.getProperty() == property);
    }

    /**
     * Finds the values of a given annotation property in the given element
     * 
     * @param element The given element
     * @param property the annotation property
     * @param scope The scope of the search (can be null)
     * @return a set of literals representing annotation values
     */
    public static Set<Element> findAnnotationValues(IdentifiedElement element, AnnotationProperty property, Set<Resource> scope) {
        return findAnnotations(element, property, scope)
            .flatMap(a -> a.getValue().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    /**
     * Finds the values of a given annotation property in the given element
     * 
     * @param element The given element
     * @param property the annotation property
     * @return a set of literals representing annotation values
     * @deprecated As of 2.5.0. Use {{@link #findAnnotationValues(IdentifiedElement, AnnotationProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Element> findAnnotationValues(IdentifiedElement element, AnnotationProperty property) {
        return findAnnotationValues(element, property, null);
    }

    /**
     * Finds the first literal value of the given annotation property in the given element
     * 
     * @param element The given element
     * @param property the given annotation property
     * @param scope The scope of the search (can be null)
     * @return an annotation literal value
     */
    public static Literal findAnnotationLiteralValue(IdentifiedElement element, AnnotationProperty property, Set<Resource> scope) {
        return findAnnotations(element, property, scope)
                .filter(a -> a.getLiteralValue() != null)
                .flatMap(a -> a.getLiteralValue().stream())
	            .findFirst()
	            .orElse(null);
    }

    /**
     * Finds the first literal value of the given annotation property in the given element
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return an annotation literal value
     * @deprecated As of 2.5.0. Use {{@link #findAnnotationLiteralValue(IdentifiedElement, AnnotationProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Literal findAnnotationLiteralValue(IdentifiedElement element, AnnotationProperty property) {
        return findAnnotationLiteralValue(element, property, null);
    }

    /**
     * Finds the first referenced value of a given annotation property in the given element
     * 
     * @param element The given element
     * @param property the given annotation property
     * @param scope The scope of the search (can be null)
     * @return an annotation reference value
     */
    public static Member findAnnotationReferencedValue(IdentifiedElement element, AnnotationProperty property, Set<Resource> scope) {
        return findAnnotations(element, property, scope)
            .filter(a -> a.getReferencedValue() != null)
            .flatMap(a -> a.getReferencedValue().stream())
            .findFirst()
            .orElse(null);
    }

    /**
     * Finds the first referenced value of a given annotation property in the given element
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return an annotation reference value
     * @deprecated As of 2.5.0. Use {{@link #findAnnotationReferencedValue(IdentifiedElement, AnnotationProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Member findAnnotationReferencedValue(IdentifiedElement element, AnnotationProperty property) {
        return findAnnotationReferencedValue(element, property, null);
    }

    /**
     * Finds whether the given element is annotated with the given annotation property
     * 
     * @param element The given element
     * @param property the given annotation property
     * @param scope The scope of the search (can be null)
     * @return true if the element is annotated with the given annotation property; otherwise false
     */
    public static boolean findIsAnnotatedBy(IdentifiedElement element, AnnotationProperty property, Set<Resource> scope) {
        return !findAnnotations(element, property, scope).findAny().isEmpty();
    }

    /**
     * Finds whether the given element is annotated with the given annotation property
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return true if the element is annotated with the given annotation property; otherwise false
     * @deprecated As of 2.5.0. Use {{@link #findIsAnnotatedBy(IdentifiedElement, AnnotationProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static boolean findIsAnnotatedBy(IdentifiedElement element, AnnotationProperty property) {
        return findIsAnnotatedBy(element, property, null);
    }

    //-------------------------------------------------
    // VOCABULARIES
    //-------------------------------------------------

    /**
     * Finds axioms that are defined for the given term
     * 
     * @param term the given term
     * @param scope The scope of the search (can be null)
     * @return a set of axioms that are defined for the given term
     */
    public static Set<Axiom> findAxioms(Term term, Set<Resource> scope) {
        Set<Axiom> axioms = new LinkedHashSet<>();
        if (term instanceof SpecializableTerm){
            axioms.addAll(findSpecializationAxiomsWithSubTerm(((SpecializableTerm)term), scope));
        }
        if (term instanceof Entity) {
            axioms.addAll(findEntityEquivalenceAxiomsWithSubEntity(((Entity)term), scope));
            axioms.addAll(findPropertyRestrictionAxioms(((Entity)term), scope));
            axioms.addAll(findKeyAxioms(((Entity)term), scope));
        }
        if (term instanceof Concept) {
            axioms.addAll(findInstanceEnumerationAxioms(((Concept)term), scope));
        }
        if (term instanceof Scalar) {
            axioms.addAll(findScalarEquivalenceAxiomsWithSubScalar(((Scalar)term), scope));
            axioms.addAll(findLiteralEnumerationAxioms(((Scalar)term), scope));
        }
        if (term instanceof Property) {
            axioms.addAll(findPropertyEquivalenceAxiomsWithSubProperty(((Property)term), scope));
        }
        return axioms;
    }

    /**
     * Finds axioms that are defined for the given term
     * 
     * @param term the given term
     * @return a set of axioms that are defined for the given term
     * @deprecated As of 2.5.0. Use {{@link #findAxioms(Term, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Axiom> findAxioms(Term term) {
    	return findAxioms(term, null);
    }
    
    /**
     * Find key axioms that are defined on the given entity
     * 
     * @param entity the given entity
     * @param scope The scope of the search (can be null)
     * @return a set of key axioms that are defined on the given entity
     */
    public static Set<KeyAxiom> findKeyAxioms(Entity entity, Set<Resource> scope) {
        final Set<KeyAxiom> axioms = new LinkedHashSet<>();
        axioms.addAll(entity.getOwnedKeys());
        axioms.addAll(findRefs(entity, scope).stream()
            .filter(i -> i instanceof Entity)
            .map(i -> (Entity)i)
            .flatMap(r -> r.getOwnedKeys().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Find key axioms that are defined on the given entity
     * 
     * @param entity the given entity
     * @return a set of key axioms that are defined on the given entity
     * @deprecated As of 2.5.0. Use {{@link #findKeyAxioms(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<KeyAxiom> findKeyAxioms(Entity entity) {
    	return findKeyAxioms(entity, null);
    }
    
    /**
     * Find instance enumeration axioms that are defined on the given concept
     * 
     * @param concept the given concept
     * @param scope The scope of the search (can be null)
     * @return a set of instance enumeration axioms that are defined on the given concept
     */
    public static Set<InstanceEnumerationAxiom> findInstanceEnumerationAxioms(Concept concept, Set<Resource> scope) {
        final Set<InstanceEnumerationAxiom> axioms = new LinkedHashSet<>();
        if (concept.getOwnedEnumeration() != null) {
        	axioms.add(concept.getOwnedEnumeration());
        }
        axioms.addAll(findRefs(concept, scope).stream()
            .filter(i -> i instanceof Concept)
            .map(i -> (Concept)i)
            .filter(i -> i.getOwnedEnumeration() != null)
            .map(i -> i.getOwnedEnumeration())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Find instance enumeration axioms that are defined on the given concept
     * 
     * @param concept the given concept
     * @return a set of instance enumeration axioms that are defined on the given concept
     * @deprecated As of 2.5.0. Use {{@link #findInstanceEnumerationAxioms(Concept, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<InstanceEnumerationAxiom> findInstanceEnumerationAxioms(Concept concept) {
    	return findInstanceEnumerationAxioms(concept, null);
    }
    
    /**
     * Find literal enumeration axioms that are defined on the given scalar
     * 
     * @param scalar the given scalar
     * @param scope The scope of the search (can be null)
     * @return a set of literal enumeration axioms that are defined on the given scalar
     */
    public static Set<LiteralEnumerationAxiom> findLiteralEnumerationAxioms(Scalar scalar, Set<Resource> scope) {
        final Set<LiteralEnumerationAxiom> axioms = new LinkedHashSet<>();
        if (scalar.getOwnedEnumeration() != null) {
        	axioms.add(scalar.getOwnedEnumeration());
        }
        axioms.addAll(findRefs(scalar, scope).stream()
            .filter(i -> i instanceof Scalar)
            .map(i -> (Scalar)i)
            .filter(i -> i.getOwnedEnumeration() != null)
            .map(i -> i.getOwnedEnumeration())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Find literal enumeration axioms that are defined on the given scalar
     * 
     * @param scalar the given scalar
     * @return a set of literal enumeration axioms that are defined on the given scalar
     * @deprecated As of 2.5.0. Use {{@link #findLiteralEnumerationAxioms(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<LiteralEnumerationAxiom> findLiteralEnumerationAxioms(Scalar scalar) {
    	return findLiteralEnumerationAxioms(scalar, null);
    }
    
    /**
     * Find property restriction axioms that are defined on the given entity
     * 
     * @param entity the given entity
     * @param scope The scope of the search (can be null)
     * @return a set of restriction axioms that are defined on the given entity
     */
    public static Set<PropertyRestrictionAxiom> findPropertyRestrictionAxioms(Entity entity, Set<Resource> scope) {
        final Set<PropertyRestrictionAxiom> axioms = new LinkedHashSet<>();
        axioms.addAll(entity.getOwnedPropertyRestrictions());
        axioms.addAll(findRefs(entity, scope).stream()
            .filter(i -> i instanceof Entity)
            .map(i -> (Entity)i)
            .flatMap(r -> r.getOwnedPropertyRestrictions().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Find property restriction axioms that are defined on the given entity
     * 
     * @param entity the given entity
     * @return a set of restriction axioms that are defined on the given entity
     * @deprecated As of 2.5.0. Use {{@link #findPropertyRestrictionAxioms(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyRestrictionAxiom> findPropertyRestrictionAxioms(Entity entity) {
    	return findPropertyRestrictionAxioms(entity, null);
    }
    
    //-----Beginning-Of-Specialization-and-Equivalence-Axioms-----------------
    
    /**
     * Finds specialization axioms that have the given term as a sub term
     * 
     * @param term the given term
     * @param scope The scope of the search (can be null)
     * @return a set of specialization axioms that have the given term as a sub term
     */
    public static Set<SpecializationAxiom> findSpecializationAxiomsWithSubTerm(Term term, Set<Resource> scope) {
        final Set<SpecializationAxiom> axioms = new LinkedHashSet<>();
        if (term instanceof SpecializableTerm) {
        	axioms.addAll(((SpecializableTerm)term).getOwnedSpecializations());
        }
        axioms.addAll(findRefs(term, scope).stream()
            .filter(i -> i instanceof SpecializableTerm)
            .map(i -> (SpecializableTerm)i)
            .flatMap(r -> r.getOwnedSpecializations().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Finds specialization axioms that have the given term as a sub term
     * 
     * @param term the given term
     * @return a set of specialization axioms that have the given term as a sub term
     * @deprecated As of 2.5.0. Use {{@link #findSpecializationAxiomsWithSubTerm(Term, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<SpecializationAxiom> findSpecializationAxiomsWithSubTerm(Term term) {
    	return findSpecializationAxiomsWithSubTerm(term, null);
    }
    
    /**
     * Finds entity equivalence axioms that have the given entity as a sub
     * 
     * @param entity the given entity
     * @param scope The scope of the search (can be null)
     * @return a set of entity equivalence axioms that have the given entity as a sub
     */
    public static Set<EntityEquivalenceAxiom> findEntityEquivalenceAxiomsWithSubEntity(Entity entity, Set<Resource> scope) {
        final Set<EntityEquivalenceAxiom> axioms = new LinkedHashSet<>();
       	axioms.addAll(entity.getOwnedEquivalences());
        axioms.addAll(findRefs(entity, scope).stream()
            .filter(i -> i instanceof Entity)
            .map(i -> (Entity)i)
            .flatMap(r -> r.getOwnedEquivalences().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Finds entity equivalence axioms that have the given entity as a sub
     * 
     * @param entity the given entity
     * @return a set of entity equivalence axioms that have the given entity as a sub
     * @deprecated As of 2.5.0. Use {{@link #findEntityEquivalenceAxiomsWithSubEntity(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<EntityEquivalenceAxiom> findEntityEquivalenceAxiomsWithSubEntity(Entity entity) {
    	return findEntityEquivalenceAxiomsWithSubEntity(entity, null);
    }
    
    /**
     * Finds scalar equivalence axioms that have the given scalar as a sub
     * 
     * @param scalar the given scalar
     * @param scope The scope of the search (can be null)
     * @return a set of scalar equivalence axioms that have the given scalar as a sub
     */
    public static Set<ScalarEquivalenceAxiom> findScalarEquivalenceAxiomsWithSubScalar(Scalar scalar, Set<Resource> scope) {
        final Set<ScalarEquivalenceAxiom> axioms = new LinkedHashSet<>();
       	axioms.addAll(scalar.getOwnedEquivalences());
        axioms.addAll(findRefs(scalar, scope).stream()
            .filter(i -> i instanceof Scalar)
            .map(i -> (Scalar)i)
            .flatMap(r -> r.getOwnedEquivalences().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Finds scalar equivalence axioms that have the given scalar as a sub
     * 
     * @param scalar the given scalar
     * @return a set of scalar equivalence axioms that have the given scalar as a sub
     * @deprecated As of 2.5.0. Use {{@link #findScalarEquivalenceAxiomsWithSubScalar(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<ScalarEquivalenceAxiom> findScalarEquivalenceAxiomsWithSubScalar(Scalar scalar) {
    	return findScalarEquivalenceAxiomsWithSubScalar(scalar, null);
    }
    
    /**
     * Finds property equivalence axioms that have the given property as a sub
     * 
     * @param property the given property
     * @param scope The scope of the search (can be null)
     * @return a set of property equivalence axioms that have the given property as a sub
     */
    public static Set<PropertyEquivalenceAxiom> findPropertyEquivalenceAxiomsWithSubProperty(Property property, Set<Resource> scope) {
        final Set<PropertyEquivalenceAxiom> axioms = new LinkedHashSet<>();
        if (property instanceof SpecializableProperty) {
        	axioms.addAll(((SpecializableProperty)property).getOwnedEquivalences());
        }
        axioms.addAll(findRefs(property, scope).stream()
            .filter(i -> i instanceof SpecializableProperty)
            .map(i -> (SpecializableProperty)i)
            .flatMap(r -> r.getOwnedEquivalences().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Finds property equivalence axioms that have the given property as a sub
     * 
     * @param property the given property
     * @return a set of property equivalence axioms that have the given property as a sub
     * @deprecated As of 2.5.0. Use {{@link #findPropertyEquivalenceAxiomsWithSubProperty(Property, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyEquivalenceAxiom> findPropertyEquivalenceAxiomsWithSubProperty(Property property) {
    	return findPropertyEquivalenceAxiomsWithSubProperty(property, null);
    }
    
    /**
     * Finds terms that are the direct super (general) terms of the given term 
     * 
     * @param term the given term
     * @param scope The scope of the search (can be null)
     * @return a set of terms that are the direct super (general) terms of the given term
     */
    public static Set<Term> findSuperTerms(Term term, Set<Resource> scope) {
        final Set<Term> supers = new LinkedHashSet<>();
        supers.addAll(findSpecializationSuperTerms(term, scope));
        if (term instanceof Entity) {
        	supers.addAll(findEquivalenceSuperEntitys((Entity)term, scope));
        	supers.addAll(findEquivalentEntitys((Entity)term, scope));
        } else if (term instanceof Scalar) {
        	supers.addAll(findEquivalenceSuperScalars((Scalar)term, scope));
        	supers.addAll(findEquivalentScalars((Scalar)term, scope));
        } else if (term instanceof Property) {
        	supers.addAll(findEquivalentProperties((Property)term, scope));
        }
        return supers;
    }

    /**
     * Finds terms that are the direct super (general) terms of the given term 
     * 
     * @param term the given term
     * @return a set of terms that are the direct super (general) terms of the given term
     * @deprecated As of 2.5.0. Use {{@link #findSuperTerms(Term, Set<Resource>)} instead
     */
    @Deprecated
   public static Set<Term> findSuperTerms(Term term) {
    	return findSuperTerms(term, null);
    }
    
    /**
     * Finds terms that are the direct sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @param scope The scope of the search (can be null)
     * @return a set of terms that are the direct sub (specific) terms of the given term
     */
    public static Set<Term> findSubTerms(Term term, Set<Resource> scope) {
        final Set<Term> subs = new LinkedHashSet<>();
        subs.addAll(findSpecializationSubTerms(term, scope));
        if (term instanceof Entity) {
        	subs.addAll(findEquivalenceSubEntitys((Entity)term, scope));
        	subs.addAll(findEquivalentEntitys((Entity)term, scope));
        } else if (term instanceof Scalar) {
        	subs.addAll(findEquivalenceSubScalars((Scalar)term, scope));
        	subs.addAll(findEquivalentScalars((Scalar)term, scope));
        } else if (term instanceof Property) {
        	subs.addAll(findEquivalentProperties((Property)term, scope));
        }
        return subs;
    }

    /**
     * Finds terms that are the direct sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @return a set of terms that are the direct sub (specific) terms of the given term
     * @deprecated As of 2.5.0. Use {{@link #findSubTerms(Term, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Term> findSubTerms(Term term) {
    	return findSubTerms(term, null);
    }
    
    /**
     * Finds terms that are the direct or transitive super (general) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @param scope The scope of the search (can be null)
     * @return a set of terms that are the direct or transitive super (general) terms of the given term
     */
    public static Set<Term> findAllSuperTerms(Term term, boolean inclusive, Set<Resource> scope) {
        return OmlRead.closure(term, inclusive, t -> findSuperTerms(t, scope)).stream()
        		.collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    /**
     * Finds terms that are the direct or transitive super (general) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a set of terms that are the direct or transitive super (general) terms of the given term
     * @deprecated As of 2.5.0. Use {{@link #findAllSuperTerms(Term, boolean, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Term> findAllSuperTerms(Term term, boolean inclusive) {
    	return findAllSuperTerms(term, inclusive, null);
    }
    
    /**
     * Finds terms that are the direct or transitive sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @param scope The scope of the search (can be null)
     * @return a set of terms that are the direct or transitive sub (specific) terms of the given term
     */
    public static Set<Term> findAllSubTerms(Term term, boolean inclusive, Set<Resource> scope) {
        return OmlRead.closure(term, inclusive, t -> findSubTerms(t, scope)).stream()
        		.collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds terms that are the direct or transitive sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a set of terms that are the direct or transitive sub (specific) terms of the given term
     * @deprecated As of 2.5.0. Use {{@link #findAllSubTerms(Term, boolean, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Term> findAllSubTerms(Term term, boolean inclusive) {
        return findAllSubTerms(term, inclusive, null);
    }

    /**
     * Determines if the given term is a sub term of the given super term  
     * 
     * @param term the given term
     * @param superTerm the given super term
     * @param scope The scope of the search (can be null)
     * @return true if the given term is a sub term of the given super term; otherwise false
     */
    public static boolean findIsSubTermOf(Term term, Term superTerm, Set<Resource> scope) {
        return OmlRead.isInClosure(superTerm, term, true, t -> findSuperTerms(t, scope));
    }

    /**
     * Determines if the given term is a sub term of the given super term  
     * 
     * @param term the given term
     * @param superTerm the given super term
     * @return true if the given term is a sub term of the given super term; otherwise false
     * @deprecated As of 2.5.0. Use {{@link #findIsSubTermOf(Term, Term, Set<Resource>)} instead
     */
    @Deprecated
    public static boolean findIsSubTermOf(Term term, Term superTerm) {
    	return findIsSubTermOf(term, superTerm, null);
    }
    
    /**
     * Finds terms that are the direct specialization super terms of the given term 
     * 
     * @param term the given term
     * @param scope The scope of the search (can be null)
     * @return a set of terms that are the direct specialization super terms of the given term
     */
    public static Set<Term> findSpecializationSuperTerms(Term term, Set<Resource> scope) {
    	var supers = new LinkedHashSet<Term>();
        supers.addAll(findSpecializationAxiomsWithSubTerm(term, scope).stream()
                .map(i -> i.getSuperTerm())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        if (term instanceof ForwardRelation) {
        	var entity = ((ForwardRelation)term).getRelationEntity();
    		supers.addAll(findSpecializationSuperTerms(entity, scope).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	} else if (term instanceof ReverseRelation) {
        	var base = ((ReverseRelation)term).getRelationBase();
    		supers.addAll(findSpecializationSuperTerms(base, scope).stream()
    	        .filter(i -> i instanceof RelationBase)
	            .map(i -> (RelationBase)i)
	            .filter(i -> i.getReverseRelation() != null)
	            .map(i -> i.getReverseRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	}
    	return supers;
    }

    /**
     * Finds terms that are the direct specialization super terms of the given term 
     * 
     * @param term the given term
     * @return a set of terms that are the direct specialization super terms of the given term
     * @deprecated As of 2.5.0. Use {{@link #findSpecializationSuperTerms(Term, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Term> findSpecializationSuperTerms(Term term) {
    	return findSpecializationSuperTerms(term, null);
    }
    
    /**
     * Finds terms that are the direct specialization sub terms of the given term 
     * 
     * @param term the given term
     * @param scope The scope of the search (can be null)
     * @return a set of terms that are the direct specialization sub terms of the given term
     */
    public static Set<Term> findSpecializationSubTerms(Term term, Set<Resource> scope) {
    	var subs = new LinkedHashSet<Term>();
        subs.addAll(findSpecializationAxiomsWithSuperTerm(term, scope).stream()
            .map(i -> i.getSubTerm())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        if (term instanceof ForwardRelation) {
        	var entity = ((ForwardRelation)term).getRelationEntity();
    		subs.addAll(findSpecializationSubTerms(entity, scope).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	} else if (term instanceof ReverseRelation) {
        	var base = ((ReverseRelation)term).getRelationBase();
        	subs.addAll(findSpecializationSubTerms(base, scope).stream()
    	        .filter(i -> i instanceof RelationBase)
	            .map(i -> (RelationBase)i)
	            .filter(i -> i.getReverseRelation() != null)
	            .map(i -> i.getReverseRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	}
    	return subs;
    }

    /**
     * Finds terms that are the direct specialization sub terms of the given term 
     * 
     * @param term the given term
     * @return a set of terms that are the direct specialization sub terms of the given term
     * @deprecated As of 2.5.0. Use {{@link #findSpecializationSubTerms(Term, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Term> findSpecializationSubTerms(Term term) {
    	return findSpecializationSubTerms(term, null);
    }
    
    /**
     * Finds entities that are the direct equivalence super of a given entity 
     * 
     * @param entity the given entity
     * @param scope The scope of the search (can be null)
     * @return a set of entity that are the direct equivalence super of the given entity
     */
    public static Set<Entity> findEquivalenceSuperEntitys(Entity entity, Set<Resource> scope) {
        return findEntityEquivalenceAxiomsWithSubEntity(entity, scope).stream()
            .flatMap(i -> i.getSuperEntities().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds entities that are the direct equivalence super of a given entity 
     * 
     * @param entity the given entity
     * @return a set of entity that are the direct equivalence super of the given entity
     * @deprecated As of 2.5.0. Use {{@link #findEquivalenceSuperEntitys(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findEquivalenceSuperEntitys(Entity entity) {
    	return findEquivalenceSuperEntitys(entity, null);
    }
    
    /**
     * Finds entities that are the direct equivalence sub of a given entity 
     * 
     * @param entity the given entity
     * @param scope The scope of the search (can be null)
     * @return a set of entity that are the direct equivalence sub of the given entity
     */
    public static Set<Entity> findEquivalenceSubEntitys(Entity entity, Set<Resource> scope) {
        return findEntityEquivalenceAxiomsWithSuperEntity(entity, scope).stream()
            .map(i -> i.getSubEntity())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds entities that are the direct equivalence sub of a given entity 
     * 
     * @param entity the given entity
     * @return a set of entity that are the direct equivalence sub of the given entity
     * @deprecated As of 2.5.0. Use {{@link #findEquivalenceSubEntitys(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findEquivalenceSubEntitys(Entity entity) {
    	return findEquivalenceSubEntitys(entity, null);
    }
    
    /**
     * Finds scalars that are the direct equivalence super of a given scalar 
     * 
     * @param scalar the given scalar
     * @param scope The scope of the search (can be null)
     * @return a set of entity that are the direct equivalence super of the given entity
     */
    public static Set<Scalar> findEquivalenceSuperScalars(Scalar scalar, Set<Resource> scope) {
        return findScalarEquivalenceAxiomsWithSubScalar(scalar, scope).stream()
            .map(i -> i.getSuperScalar())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds scalars that are the direct equivalence super of a given scalar 
     * 
     * @param scalar the given scalar
     * @return a set of entity that are the direct equivalence super of the given entity
     * @deprecated As of 2.5.0. Use {{@link #findEquivalenceSuperScalars(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Scalar> findEquivalenceSuperScalars(Scalar scalar) {
    	return findEquivalenceSuperScalars(scalar, null);
    }
    
    /**
     * Finds scalars that are the direct equivalence sub of a given scalar 
     * 
     * @param scalar the given scalar
     * @param scope The scope of the search (can be null)
     * @return a set of scalars that are the direct equivalence sub of the given scalar
     */
    public static Set<Scalar> findEquivalenceSubScalars(Scalar scalar, Set<Resource> scope) {
        return findScalarEquivalenceAxiomsWithSuperScalar(scalar, scope).stream()
            .map(i -> i.getSubScalar())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds scalars that are the direct equivalence sub of a given scalar 
     * 
     * @param scalar the given scalar
     * @return a set of scalars that are the direct equivalence sub of the given scalar
     * @deprecated As of 2.5.0. Use {{@link #findEquivalenceSubScalars(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Scalar> findEquivalenceSubScalars(Scalar scalar) {
    	return findEquivalenceSubScalars(scalar, null);
    }
    
    /**
     * Finds properties that are the direct equivalence super of a given property 
     * 
     * @param property the given property
     * @param scope The scope of the search (can be null)
     * @return a set of properties that are the direct equivalence super of the given property
     */
    public static Set<Property> findEquivalenceSuperProperties(Property property, Set<Resource> scope) {
    	var supers = new LinkedHashSet<Property>();
        supers.addAll(findPropertyEquivalenceAxiomsWithSubProperty(property, scope).stream()
            .map(i -> i.getSuperProperty())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        if (property instanceof ForwardRelation) {
    		var entity = ((ForwardRelation)property).getRelationEntity();
    		supers.addAll(findEquivalenceSuperEntitys(entity, scope).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	} else if (property instanceof ReverseRelation) {
    		var base = ((ReverseRelation)property).getRelationBase();
    		if (base instanceof RelationEntity) {
        		supers.addAll(findEquivalenceSuperEntitys((RelationEntity)base, scope).stream()
            	        .filter(i -> i instanceof RelationEntity)
        	            .map(i -> (RelationEntity)i)
        	            .filter(i -> i.getReverseRelation() != null)
        	            .map(i -> i.getReverseRelation())
    		            .collect(Collectors.toCollection(LinkedHashSet::new)));
    		} else if (base instanceof UnreifiedRelation) {
        		supers.addAll(findEquivalenceSuperProperties((UnreifiedRelation)base, scope).stream()
            	        .filter(i -> i instanceof UnreifiedRelation)
        	            .map(i -> (UnreifiedRelation)i)
        	            .filter(i -> i.getReverseRelation() != null)
        	            .map(i -> i.getReverseRelation())
			            .collect(Collectors.toCollection(LinkedHashSet::new)));
    		}
    	}
    	return supers;
    }

    /**
     * Finds properties that are the direct equivalence super of a given property 
     * 
     * @param property the given property
     * @return a set of properties that are the direct equivalence super of the given property
     * @deprecated As of 2.5.0. Use {{@link #findEquivalenceSuperProperties(Property, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Property> findEquivalenceSuperProperties(Property property) {
    	return findEquivalenceSuperProperties(property, null);
    }
    
    /**
     * Finds properties that are the direct equivalence sub of a given property 
     * 
     * @param property the given property
     * @param scope The scope of the search (can be null)
     * @return a set of properties that are the direct equivalence sub of the given property
     */
    public static Set<Property> findEquivalenceSubProperties(Property property, Set<Resource> scope) {
    	var subs = new LinkedHashSet<Property>();
    	subs.addAll(findPropertyEquivalenceAxiomsWithSuperProperty(property, scope).stream()
            .map(i -> i.getSubProperty())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        if (property instanceof ForwardRelation) {
    		var entity = ((ForwardRelation)property).getRelationEntity();
    		subs.addAll(findEquivalenceSubEntitys(entity, scope).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	} else if (property instanceof ReverseRelation) {
    		var base = ((ReverseRelation)property).getRelationBase();
    		if (base instanceof RelationEntity) {
        		subs.addAll(findEquivalenceSubEntitys((RelationEntity)base, scope).stream()
            	        .filter(i -> i instanceof RelationEntity)
        	            .map(i -> (RelationEntity)i)
        	            .filter(i -> i.getReverseRelation() != null)
        	            .map(i -> i.getReverseRelation())
    		            .collect(Collectors.toCollection(LinkedHashSet::new)));
    		} else if (base instanceof UnreifiedRelation) {
        		subs.addAll(findEquivalenceSubProperties((UnreifiedRelation)base, scope).stream()
            	        .filter(i -> i instanceof UnreifiedRelation)
        	            .map(i -> (UnreifiedRelation)i)
        	            .filter(i -> i.getReverseRelation() != null)
        	            .map(i -> i.getReverseRelation())
			            .collect(Collectors.toCollection(LinkedHashSet::new)));
    		}
    	}
   		return subs;
    }

    /**
     * Finds properties that are the direct equivalence sub of a given property 
     * 
     * @param property the given property
     * @return a set of properties that are the direct equivalence sub of the given property
     * @deprecated As of 2.5.0. Use {{@link #findEquivalenceSubProperties(Property, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Property> findEquivalenceSubProperties(Property property) {
    	return findEquivalenceSubProperties(property, null);
    }
    
    /**
     * Finds entities that are the direct equivalent to a given entity 
     * 
     * @param entity the given entity
     * @param scope The scope of the search (can be null)
     * @return a set of entity that are the direct equivalents of the given entity
     */
    public static Set<Entity> findEquivalentEntitys(Entity entity, Set<Resource> scope) {
        final Set<Entity> equivalents = new LinkedHashSet<>();
        equivalents.addAll(findEntityEquivalenceAxiomsWithSubEntity(entity, scope).stream()
            	.filter(i -> i.getOwnedPropertyRestrictions().size() == 0)
            	.filter(i -> i.getSuperEntities().size() == 1)
                .map(i -> i.getSuperEntities().get(0))
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        equivalents.addAll(findEntityEquivalenceAxiomsWithSuperEntity(entity, scope).stream()
            	.filter(i -> i.getOwnedPropertyRestrictions().size() == 0)
	        	.filter(i -> i.getSuperEntities().size() == 1)
	            .map(i -> i.getSubEntity())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return equivalents;
    }

    /**
     * Finds entities that are the direct equivalent to a given entity 
     * 
     * @param entity the given entity
     * @return a set of entity that are the direct equivalents of the given entity
     * @deprecated As of 2.5.0. Use {{@link #findEquivalentEntitys(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findEquivalentEntitys(Entity entity) {
    	return findEquivalentEntitys(entity, null); 
    }
    
    /**
     * Finds scalars that are the direct equivalent to a given scalar 
     * 
     * @param scalar the given scalar
     * @param scope The scope of the search (can be null)
     * @return a set of scalars that are the direct equivalents of the given scalar
     */
    public static Set<Scalar> findEquivalentScalars(Scalar scalar, Set<Resource> scope) {
        final Set<Scalar> equivalents = new LinkedHashSet<>();
        equivalents.addAll(findScalarEquivalenceAxiomsWithSubScalar(scalar, scope).stream()
            	.filter(i -> OmlRead.getNumberOfFacets(i) == 0)
                .map(i -> i.getSuperScalar())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        equivalents.addAll(findScalarEquivalenceAxiomsWithSuperScalar(scalar, scope).stream()
            	.filter(i -> OmlRead.getNumberOfFacets(i) == 0)
	            .map(i -> i.getSubScalar())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return equivalents;
    }

    /**
     * Finds scalars that are the direct equivalent to a given scalar 
     * 
     * @param scalar the given scalar
     * @return a set of scalars that are the direct equivalents of the given scalar
     * @deprecated As of 2.5.0. Use {{@link #findEquivalentScalars(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Scalar> findEquivalentScalars(Scalar scalar) {
    	return findEquivalentScalars(scalar, null);
    }
    
    /**
     * Finds properties that are the direct equivalent to a given property 
     * 
     * @param property the given property
     * @param scope The scope of the search (can be null)
     * @return a set of property that are the direct equivalents of the given property
     */
    public static Set<Property> findEquivalentProperties(Property property, Set<Resource> scope) {
        final Set<Property> equivalents = new LinkedHashSet<>();
        equivalents.addAll(findEquivalenceSuperProperties(property, scope));
        equivalents.addAll(findEquivalenceSubProperties(property, scope));
        return equivalents;
    }

    /**
     * Finds properties that are the direct equivalent to a given property 
     * 
     * @param property the given property
     * @return a set of property that are the direct equivalents of the given property
     * @deprecated As of 2.5.0. Use {{@link #findEquivalentProperties(Property, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Property> findEquivalentProperties(Property property) {
    	return findEquivalentProperties(property, null);
    }
    
    //-----End-Of-Specialization-and-Equivalence-Axioms-----------------

    /**
     * Finds relations that have the given entity as their source
     * 
     * @param entity the given entity
     * @param scope The scope of the search (can be null)
     * @return a set of relations that have the given entity as their source
     */
    public static Set<Relation> findSourceRelations(Entity entity, Set<Resource> scope) {
        final Set<Relation> relations = new LinkedHashSet<>();
        relations.addAll(findRelationBasesWithSource(entity, scope).stream()
        	.filter(r -> r instanceof UnreifiedRelation)
            .map(r -> (UnreifiedRelation)r)
            .filter(r -> r != null)
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        relations.addAll(findRelationBasesWithSource(entity, scope).stream()
            	.filter(r -> r instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        relations.addAll(findRelationBasesWithTarget(entity, scope).stream()
	            .map(i -> (RelationBase)i)
	            .filter(i -> i.getReverseRelation() != null)
	            .map(i -> i.getReverseRelation())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return relations;
    }

    /**
     * Finds relations that have the given entity as their source
     * 
     * @param entity the given entity
     * @return a set of relations that have the given entity as their source
     * @deprecated As of 2.5.0. Use {{@link #findSourceRelations(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Relation> findSourceRelations(Entity entity) {
    	return findSourceRelations(entity, null);
    }
    
    /**
     * Finds relations that have the given entity as their target
     * 
     * @param entity the given entity
     * @param scope The scope of the search (can be null)
     * @return a set of relations that have the given entity as their target
     */
    public static Set<Relation> findTargetRelations(Entity entity, Set<Resource> scope) {
        final Set<Relation> relations = new LinkedHashSet<>();
        relations.addAll(findRelationBasesWithTarget(entity, scope).stream()
           	.filter(r -> r instanceof UnreifiedRelation)
            .map(r -> (UnreifiedRelation)r)
            .filter(r -> r != null)
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        relations.addAll(findRelationBasesWithTarget(entity, scope).stream()
            	.filter(r -> r instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        relations.addAll(findRelationBasesWithSource(entity, scope).stream()
	            .map(i -> (RelationBase)i)
	            .filter(i -> i.getReverseRelation() != null)
	            .map(i -> i.getReverseRelation())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return relations;
    }

    /**
     * Finds relations that have the given entity as their target
     * 
     * @param entity the given entity
     * @return a set of relations that have the given entity as their target
     * @deprecated As of 2.5.0. Use {{@link #findTargetRelations(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Relation> findTargetRelations(Entity entity) {
    	return findTargetRelations(entity, null);
    }
    
    /**
     * Finds semantic properties referencing the given entity as domain
     * 
     * @param domain The referenced entity
     * @param scope The scope of the search (can be null)
     * @return A set of referencing semantic properties
     */
    public static Set<SemanticProperty> findSemanticPropertiesWithDomain(Entity domain, Set<Resource> scope) {
    	var properties = new LinkedHashSet<SemanticProperty>();
    	properties.addAll(findScalarPropertiesWithDomain(domain, scope));
   		properties.addAll(findSourceRelations((Entity)domain, scope));
        return properties;
    }
 
    /**
     * Finds semantic properties referencing the given entity as domain
     * 
     * @param domain The referenced entity
     * @return A set of referencing semantic properties
     * @deprecated As of 2.5.0. Use {{@link #findSemanticPropertiesWithDomain(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<SemanticProperty> findSemanticPropertiesWithDomain(Entity domain) {
    	return findSemanticPropertiesWithDomain(domain, null);
    }
    
    /**
     * Finds semantic properties referencing the given type as range
     * 
     * @param range The referenced type
     * @param scope The scope of the search (can be null)
     * @return A set of referencing semantic properties
     */
    public static Set<SemanticProperty> findSemanticPropertiesWithRange(Type range, Set<Resource> scope) {
    	var properties = new LinkedHashSet<SemanticProperty>();
    	if (range instanceof Scalar) {
    		properties.addAll(findScalarPropertiesWithRange((Scalar)range, scope));
    	} else if (range instanceof Entity) {
    		properties.addAll(findTargetRelations((Entity)range, scope));
    	}
        return properties;
    }

    /**
     * Finds semantic properties referencing the given type as range
     * 
     * @param range The referenced type
     * @return A set of referencing semantic properties
     * @deprecated As of 2.5.0. Use {{@link #findSemanticPropertiesWithRange(Type, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<SemanticProperty> findSemanticPropertiesWithRange(Type range) {
    	return findSemanticPropertiesWithRange(range, null);
    }
    
    /**
     * Finds the domains of the given semantic property
     * 
     * @param property The given property
     * @param scope The scope of the search (can be null)
     * @return A set of domains for the given semantic property
     */
    public static Set<Entity> findDomains(SemanticProperty property, Set<Resource> scope) {
    	var domains = new LinkedHashSet<Entity>();
    	domains.addAll(property.getDomainList());
    	domains.addAll(findRefs(property, scope).stream()
                .map(i -> (SemanticProperty)i)
                .flatMap(r -> r.getDomainList().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return domains;
    }

    /**
     * Finds the domains of the given semantic property
     * 
     * @param property The given property
     * @return A set of domains for the given semantic property
     * @deprecated As of 2.5.0. Use {{@link #findDomains(SemanticProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findDomains(SemanticProperty property) {
    	return findDomains(property, null);
    }
    
    /**
     * Finds all (direct or inherited) domains of the given property
     * 
     * @param property the given property
     * @param scope The scope of the search (can be null)
     * @return A set of domains for the given semantic property
     */
    public static Set<Entity> findAllDomains(SemanticProperty property, Set<Resource> scope) {
    	return findAllSuperTerms(property, true, scope).stream()
    			.map(i -> (SemanticProperty)i)
    			.flatMap(i -> findDomains(i, scope).stream())
    			.collect(Collectors.toSet());
    }

    /**
     * Finds all (direct or inherited) domains of the given property
     * 
     * @param property the given property
     * @return A set of domains for the given semantic property
     * @deprecated As of 2.5.0. Use {{@link #findAllDomains(SemanticProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findAllDomains(SemanticProperty property) {
    	return findAllDomains(property, null);
    }
    
    /**
     * Finds the ranges of the given semantic property
     * 
     * @param property The given property
     * @param scope The scope of the search (can be null)
     * @return A set of ranges for the given semantic property
     */
    public static Set<Type> findRanges(SemanticProperty property, Set<Resource> scope) {
    	var ranges = new LinkedHashSet<Type>();
    	ranges.addAll(property.getRangeList());
    	ranges.addAll(findRefs(property, scope).stream()
                .map(i -> (SemanticProperty)i)
                .flatMap(r -> r.getRangeList().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return ranges;
    }

    /**
     * Finds the ranges of the given semantic property
     * 
     * @param property The given property
     * @return A set of ranges for the given semantic property
     * @deprecated As of 2.5.0. Use {{@link #findRanges(SemanticProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Type> findRanges(SemanticProperty property) {
    	return findRanges(property, null);
    }
    
    /**
     * Finds all (direct or inherited) ranges of the given property
     * 
     * @param property the given property
     * @param scope The scope of the search (can be null)
     * @return A set of ranges for the given semantic property
     */
    public static Set<Type> findAllRanges(SemanticProperty property, Set<Resource> scope) {
    	return findAllSuperTerms(property, true, scope).stream()
    			.map(i -> (SemanticProperty)i)
    			.flatMap(i -> findRanges(i, scope).stream())
    			.collect(Collectors.toSet());
    }

    /**
     * Finds all (direct or inherited) ranges of the given property
     * 
     * @param property the given property
     * @return A set of ranges for the given semantic property
     * @deprecated As of 2.5.0. Use {{@link #findAllRanges(SemanticProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Type> findAllRanges(SemanticProperty property) {
    	return findAllRanges(property, null);
    }
    
    /**
     * Find entities that have the following property included in one of their keys
     * 
     * @param property the given property
     * @param scope The scope of the search (can be null)
     * @return a set of entities that have the following property included in one of their keys
     */
    public static Set<Entity> findEntitiesKeyedWith(SemanticProperty property, Set<Resource> scope) {
        return findKeyAxiomsWithProperty(property, scope).stream()
            .map(i -> i.getKeyedEntity())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Find entities that have the following property included in one of their keys
     * 
     * @param property the given property
     * @return a set of entities that have the following property included in one of their keys
     * @deprecated As of 2.5.0. Use {{@link #findEntitiesKeyedWith(SemanticProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findEntitiesKeyedWith(SemanticProperty property) {
    	return findEntitiesKeyedWith(property, null);
    }
    
    /**
     * Finds the sources of the given relation base
     * 
     * @param base The given relation base
     * @param scope The scope of the search (can be null)
     * @return A set of sources for the given relation base
     */
    public static Set<Entity> findSources(RelationBase base, Set<Resource> scope) {
    	var sources = new LinkedHashSet<Entity>();
    	sources.addAll(base.getSources());
    	sources.addAll(findRefs(base, scope).stream()
                .map(i -> (RelationEntity)i)
                .flatMap(r -> r.getSources().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return sources;
    }

    /**
     * Finds the sources of the given relation base
     * 
     * @param base The given relation base
     * @return A set of sources for the given relation base
     * @deprecated As of 2.5.0. Use {{@link #findSources(RelationBase, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findSources(RelationBase base) {
    	return findSources(base, null);
    }
    
    /**
     * Finds the targets of the given relation base
     * 
     * @param base The given relation base
     * @param scope The scope of the search (can be null)
     * @return A set of targets for the given relation base
     */
    public static Set<Entity> findTargets(RelationBase base, Set<Resource> scope) {
    	var sources = new LinkedHashSet<Entity>();
    	sources.addAll(base.getTargets());
    	sources.addAll(findRefs(base, scope).stream()
                .map(i -> (RelationEntity)i)
                .flatMap(r -> r.getTargets().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return sources;
    }

    /**
     * Finds the targets of the given relation base
     * 
     * @param base The given relation base
     * @return A set of targets for the given relation base
     * @deprecated As of 2.5.0. Use {{@link #findTargets(RelationBase, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findTargets(RelationBase base) {
    	return findTargets(base, null);
    }
    
    /**
     * Finds whether the given scalar property has as one of its ranges an enumerated scalar
     * 
     * @param property The given scalar property
     * @param scope The scope of the search (can be null)
     * @return true is the scalar is enumerated; false otherwise
     */
    public static boolean findIsEnumeratedProperty(ScalarProperty property, Set<Resource> scope) {
    	return property.getRanges().stream().anyMatch(r -> findIsEnumeratedScalar(r, scope));
    }

    /**
     * Finds whether the given scalar property has as one of its ranges an enumerated scalar
     * 
     * @param property The given scalar property
     * @return true is the scalar is enumerated; false otherwise
     * @deprecated As of 2.5.0. Use {{@link #findIsEnumeratedProperty(ScalarProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static boolean findIsEnumeratedProperty(ScalarProperty property) {
    	return findIsEnumeratedProperty(property, null);
    }
    
    /**
     * Finds whether the given scalar has enumeration literals
     * 
     * @param scalar The given scalar
     * @param scope The scope of the search (can be null)
     * @return true is the scalar is enumerated; false otherwise
     */
    public static boolean findIsEnumeratedScalar(Scalar scalar, Set<Resource> scope) {
    	return !findLiteralEnumerationAxioms(scalar, scope).isEmpty();
    }

    /**
     * Finds whether the given scalar has enumeration literals
     * 
     * @param scalar The given scalar
     * @return true is the scalar is enumerated; false otherwise
     * @deprecated As of 2.5.0. Use {{@link #findIsEnumeratedScalar(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static boolean findIsEnumeratedScalar(Scalar scalar) {
    	return findIsEnumeratedScalar(scalar, null);
    }
    
    /**
     * Finds the list of enumeration liters of the given scalar
     * 
     * @param scalar The given scalar
     * @param scope The scope of the search (can be null)
     * @return a list of enumeration literals
     */
    public static List<Literal> findEnumerationLiterals(Scalar scalar, Set<Resource> scope) {
    	return findLiteralEnumerationAxioms(scalar, scope).stream()
    			.flatMap(a -> a.getLiterals().stream())
    			.collect(Collectors.toList());
    }	

    /**
     * Finds the list of enumeration liters of the given scalar
     * 
     * @param scalar The given scalar
     * @return a list of enumeration literals
     * @deprecated As of 2.5.0. Use {{@link #findEnumerationLiterals(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static List<Literal> findEnumerationLiterals(Scalar scalar) {
    	return findEnumerationLiterals(scalar, null);
    }
    
    //-------------------------------------------------
    // DESCRIPTIONS
    //-------------------------------------------------

    /**
     * Finds assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @param scope The scope of the search (can be null)
     * @return a set of assertions that are defined on the given instance
     */
    public static Set<Assertion> findAssertions(Instance instance, Set<Resource> scope) {
        Set<Assertion> assertions = new LinkedHashSet<>();
        assertions.addAll(findPropertyValueAssertionsWithSubject(instance, scope));
        if (instance instanceof NamedInstance) {
            assertions.addAll(findTypeAssertions((NamedInstance)instance, scope));
        }
        return assertions;
    }

    /**
     * Finds assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @return a set of assertions that are defined on the given instance
     * @deprecated As of 2.5.0. Use {{@link #findAssertions(Instance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Assertion> findAssertions(Instance instance) {
    	return findAssertions(instance, null);
    }
    
    /**
     * Finds type assertions that are defined on the given named instance
     * 
     * @param instance the given named instance
     * @param scope The scope of the search (can be null)
     * @return a set of type assertions that are defined on the given named instance
     */
    public static Set<TypeAssertion> findTypeAssertions(NamedInstance instance, Set<Resource> scope) {
        final Set<TypeAssertion> assertions = new LinkedHashSet<>(instance.getOwnedTypes());
        assertions.addAll(findRefs(instance, scope).stream()
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .flatMap(r -> r.getOwnedTypes().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return assertions;
    }

    /**
     * Finds type assertions that are defined on the given named instance
     * 
     * @param instance the given named instance
     * @return a set of type assertions that are defined on the given named instance
     * @deprecated As of 2.5.0. Use {{@link #findTypeAssertions(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<TypeAssertion> findTypeAssertions(NamedInstance instance) {
    	return findTypeAssertions(instance, null);
    }
    
    /**
     * Finds property value assertions that have the given instance as their source
     * 
     * @param subject the given subject instance
     * @param scope The scope of the search (can be null)
     * @return a set of relation value assertions that have the given instance as their subject
     */
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithSubject(Instance subject, Set<Resource> scope) {
        final Set<PropertyValueAssertion> assertions = new LinkedHashSet<>(subject.getOwnedPropertyValues());
        if (subject instanceof NamedInstance) {
            assertions.addAll(findRefs((NamedInstance)subject, scope).stream()
                .filter(i -> i instanceof NamedInstance)
                .map(i -> (NamedInstance)i)
                .flatMap(r -> r.getOwnedPropertyValues().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return assertions;
    }

    /**
     * Finds property value assertions that have the given instance as their source
     * 
     * @param subject the given subject instance
     * @return a set of relation value assertions that have the given instance as their subject
     * @deprecated As of 2.5.0. Use {{@link #findPropertyValueAssertionsWithSubject(Instance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithSubject(Instance subject) {
    	return findPropertyValueAssertionsWithSubject(subject, null);
    }
    
    /**
     * Finds relation value assertions that have the given instance as their object
     * 
     * @param object the given object instance
     * @param scope The scope of the search (can be null)
     * @return a set of relation value assertions that have the given instance as their object
     */
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithObject(NamedInstance object, Set<Resource> scope) {
    	Set<PropertyValueAssertion> assertions = new HashSet<>();
    	assertions.addAll(findPropertyValueAssertionsWithReferencedValue(object, scope));
    	assertions.addAll(findAnonymousRelationInstanceWithTarget(object, scope).stream()
    			.map(i -> i.getOwningAssertion())
    			.collect(Collectors.toSet()));
        return assertions;
    }

    /**
     * Finds relation value assertions that have the given instance as their object
     * 
     * @param object the given object instance
     * @return a set of relation value assertions that have the given instance as their object
     * @deprecated As of 2.5.0. Use {{@link #findPropertyValueAssertionsWithObject(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithObject(NamedInstance object) {
    	return findPropertyValueAssertionsWithObject(object, null);
    }
    
    /**
     * Finds instances that are asserted as related to the given instance by any relation
     * 
     * @param instance the given instance
     * @param scope The scope of the search (can be null)
     * @return a set of instances related to the given instance by any relation
     */
    public static Set<Instance> findInstancesRelatedTo(Instance instance, Set<Resource> scope) {
        final Set<Instance> related = new LinkedHashSet<>();
        related.addAll(findInstancesRelatedAsTargetTo(instance, scope));
        if (instance instanceof NamedInstance) {
        	related.addAll(findInstancesRelatedAsSourceTo((NamedInstance) instance, scope));
        }
        return related;
    }

    /**
     * Finds instances that are asserted as related to the given instance by any relation
     * 
     * @param instance the given instance
     * @return a set of instances related to the given instance by any relation
     * @deprecated As of 2.5.0. Use {{@link #findInstancesRelatedTo(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Instance> findInstancesRelatedTo(Instance instance) {
    	return findInstancesRelatedTo(instance, (Set<Resource>)null);
    }
    
    /**
     * Finds instances that are asserted as related to the given instance by a given relation
     * 
     * @param instance the given instance
     * @param relation the given relation
     * @param scope The scope of the search (can be null)
     * @return a set of instances related to the given instance by a given relation
     */
    public static Set<Instance> findInstancesRelatedTo(Instance instance, Relation relation, Set<Resource> scope) {
        final Set<Instance> related = new LinkedHashSet<>();
        related.addAll(findInstancesRelatedAsTargetTo(instance, relation, scope));
        if (instance instanceof NamedInstance) {
        	related.addAll(findInstancesRelatedAsSourceTo((NamedInstance)instance, relation, scope));
        }
        return related;
    }

    /**
     * Finds instances that are asserted as related to the given instance by a given relation
     * 
     * @param instance the given instance
     * @param relation the given relation
     * @return a set of instances related to the given instance by a given relation
     * @deprecated As of 2.5.0. Use {{@link #findInstancesRelatedTo(NamedInstance, Relation, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Instance> findInstancesRelatedTo(Instance instance, Relation relation) {
    	return findInstancesRelatedTo(instance, relation, null);
    }
    
    /**
     * Finds target instances that are asserted as related to the given source instance by any relation
     * 
     * @param source the given source instance
     * @param scope The scope of the search (can be null)
     * @return a set of target instances related to the given source instance
     */
    public static Set<NamedInstance> findInstancesRelatedAsTargetTo(Instance source, Set<Resource> scope) {
        final Set<NamedInstance> targets = new LinkedHashSet<>();
        // check property value assertions
        targets.addAll(findPropertyValueAssertionsWithSubject(source, scope).stream()
        		.filter(a -> a.getProperty() instanceof Relation)
                .flatMap(a -> a.getReferencedValue().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        // check relation instances
        if (source instanceof NamedInstance) {
	        targets.addAll(findRelationInstancesWithSource((NamedInstance)source, scope).stream()
	                .flatMap(a -> a.getTargets().stream())
	                .collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return targets;
    }

    /**
     * Finds target instances that are asserted as related to the given source instance by any relation
     * 
     * @param source the given source instance
     * @return a set of target instances related to the given source instance
     * @deprecated As of 2.5.0. Use {{@link #findInstancesRelatedAsTargetTo(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<NamedInstance> findInstancesRelatedAsTargetTo(Instance source) {
    	return findInstancesRelatedAsTargetTo(source, (Set<Resource>)null);
    }
    
    /**
     * Finds target instances that are asserted as related to the given source instance by a given relation
     * 
     * @param source the given source instance
     * @param relation the given relation
     * @param scope The scope of the search (can be null)
     * @return a set of target instances related to the given source instance
     */
    public static Set<NamedInstance> findInstancesRelatedAsTargetTo(Instance source, Relation relation, Set<Resource> scope) {
    	final Set<NamedInstance> targets = new LinkedHashSet<>();
        // look in property value assertions
    	var subRelations = findAllSubTerms(relation, true, scope);
        targets.addAll(findPropertyValueAssertionsWithSubject(source, scope).stream()
                .filter(a -> a.getProperty() instanceof Relation)
                .filter(a -> subRelations.contains(a.getProperty()))
                .flatMap(a -> a.getReferencedValue().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        // look in relation instances
        if (relation instanceof ForwardRelation) {
        	var subEntities = findAllSubTerms(((ForwardRelation)relation).getRelationEntity(), true, scope);
        	if (source instanceof NamedInstance) {
		        targets.addAll(findRelationInstancesWithSource((NamedInstance)source, scope).stream()
		                .filter(i -> findAllTypes(i, scope).retainAll(subEntities))
		                .flatMap(a -> a.getTargets().stream())
		                .collect(Collectors.toCollection(LinkedHashSet::new)));
        	}
        }
        return targets;
    }

    /**
     * Finds target instances that are asserted as related to the given source instance by a given relation
     * 
     * @param source the given source instance
     * @param relation the given relation
     * @return a set of target instances related to the given source instance
     * @deprecated As of 2.5.0. Use {{@link #findInstancesRelatedAsTargetTo(NamedInstance, Relation, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<NamedInstance> findInstancesRelatedAsTargetTo(Instance source, Relation relation) {
    	return findInstancesRelatedAsTargetTo(source, relation, null);
    }
    
    /**
     * Finds source instances that are related by any relation to the given target instance
     * 
     * @param target the given target instance
     * @param scope The scope of the search (can be null)
     * @return a set of source instances related to the given target instance
     */
    public static Set<Instance> findInstancesRelatedAsSourceTo(NamedInstance target, Set<Resource> scope) {
        final Set<Instance> sources = new LinkedHashSet<>();
        // look in property value assertions
       sources.addAll(findPropertyValueAssertionsWithObject(target, scope).stream()
                .map(a -> (NamedInstance) a.getSubject())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
       // look in relation instances
        sources.addAll(findRelationInstancesWithTarget(target, scope).stream()
                .flatMap(a -> a.getSources().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return sources;
    }

    /**
     * Finds source instances that are related by any relation to the given target instance
     * 
     * @param target the given target instance
     * @return a set of source instances related to the given target instance
     * @deprecated As of 2.5.0. Use {{@link #findInstancesRelatedAsSourceTo(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Instance> findInstancesRelatedAsSourceTo(NamedInstance target) {
    	return findInstancesRelatedAsSourceTo(target, (Set<Resource>)null);
    }
    
    /**
     * Finds source instances that are related by a given relation to a given target instance
     * 
     * @param target the given target instance
     * @param relation the given relation
     * @param scope The scope of the search (can be null)
     * @return a set of source instances that are related by a given relation to the given target instance
     */
    public static Set<Instance> findInstancesRelatedAsSourceTo(NamedInstance target, Relation relation, Set<Resource> scope) {
        final Set<Instance> sources = new LinkedHashSet<>();
        // look in property value assertions
    	var subRelations = findAllSubTerms(relation, true, scope);
        sources.addAll(findPropertyValueAssertionsWithObject(target, scope).stream()
                .filter(a -> a.getProperty() instanceof Relation)
                .filter(a -> subRelations.contains(a.getProperty()))
                .map(a -> (NamedInstance) a.getSubject())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        // look in relation instances
        if (relation instanceof ForwardRelation) {
        	var subEntities = findAllSubTerms(((ForwardRelation)relation).getRelationEntity(), true, scope);
	        sources.addAll(findRelationInstancesWithTarget(target, scope).stream()
	                .filter(i -> findAllTypes(i, scope).retainAll(subEntities))
	                .flatMap(i -> i.getSources().stream())
	                .collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return sources;
    }

    /**
     * Finds source instances that are related by a given relation to a given target instance
     * 
     * @param target the given target instance
     * @param relation the given relation
     * @return a set of source instances that are related by a given relation to the given target instance
     * @deprecated As of 2.5.0. Use {{@link #findInstancesRelatedAsSourceTo(NamedInstance, Relation, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Instance> findInstancesRelatedAsSourceTo(NamedInstance target, Relation relation) {
    	return findInstancesRelatedAsSourceTo(target, relation, null);
    }
    
    /**
     * Finds elements that represent values of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @param scope The scope of the search (can be null)
     * @return a set of elements that represent values of given semantic property defined on the given instance
     */
    public static Set<Element> findPropertyValues(Instance instance, SemanticProperty property, Set<Resource> scope) {
        return findPropertyValueAssertionsWithSubject(instance, scope).stream()
            .filter(a -> a.getProperty() == property)
            .flatMap(a -> a.getValue().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds elements that represent values of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @return a set of elements that represent values of given semantic property defined on the given instance
     * @deprecated As of 2.5.0. Use {{@link #findPropertyValues(Instance, Relation, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Element> findPropertyValues(Instance instance, SemanticProperty property) {
    	return findPropertyValues(instance, property, null);
    }
    
    /**
     * Finds the first literal value of given scalar property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @param scope The scope of the search (can be null)
     * @return a literal value of the given scalar property on the given instance
     */
    public static Literal findPropertyLiteralValue(Instance instance, SemanticProperty property, Set<Resource> scope) {
        return findPropertyValues(instance, property, scope).stream()
            	.filter(i -> i instanceof Literal)
            	.map(i -> (Literal)i)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds the first literal value of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @return a literal value of the given scalar property on the given instance
     * @deprecated As of 2.5.0. Use {{@link #findPropertyLiteralValue(Instance, ScalarProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Literal findPropertyLiteralValue(Instance instance, SemanticProperty property) {
    	return findPropertyLiteralValue(instance, property, null);
    }
    
    /**
     * Finds the first contained value of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @param scope The scope of the search (can be null)
     * @return a contained value of the given semantic property on the given instance
     */
    public static AnonymousInstance findPropertyContainedValue(Instance instance, SemanticProperty property, Set<Resource> scope) {
        return findPropertyValues(instance, property, scope).stream()
            	.filter(i -> i instanceof AnonymousInstance)
            	.map(i -> (AnonymousInstance)i)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds the first contained value of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @return a contained value of the given semantic property on the given instance
     * @deprecated As of 2.5.0. Use {{@link #findPropertyContainedValue(Instance, SemanticProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static AnonymousInstance findPropertyContainedValue(Instance instance, SemanticProperty property) {
    	return findPropertyContainedValue(instance, property, null);
    }
    
    /**
     * Finds the first referenced value of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @param scope The scope of the search (can be null)
     * @return a referenced value of the given relation on the given instance
     */
    public static NamedInstance findPropertyReferencedValue(Instance instance, SemanticProperty property, Set<Resource> scope) {
        return findPropertyValues(instance, property, scope).stream()
            	.filter(i -> i instanceof NamedInstance)
            	.map(i -> (NamedInstance)i)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds the first referenced value of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @return a referenced value of the given relation on the given instance
     * @deprecated As of 2.5.0. Use {{@link #findPropertyReferencedValue(Instance, Relation, Set<Resource>)} instead
     */
    @Deprecated
    public static NamedInstance findPropertyReferencedValue(Instance instance, SemanticProperty property) {
    	return findPropertyReferencedValue(instance, property, null);
    }
    
    /**
     * Finds entities that are direct types of the given instance
     * 
     * @param instance the given instance
     * @param scope The scope of the search (can be null)
     * @return a set of entities that are direcf types of the given instance
     */
    public static Set<Entity> findTypes(Instance instance, Set<Resource> scope) {
        Set<Entity> types = new LinkedHashSet<>();
        if (instance instanceof AnonymousInstance) {
            types.addAll(instance.getTypes());
        } else if (instance instanceof NamedInstance) {
            types.addAll(findTypeAssertions((NamedInstance)instance, scope).stream().
                map(i -> i.getType()).
                collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return types;
    }
 
    /**
     * Finds entities that are direct types of the given instance
     * 
     * @param instance the given instance
     * @return a set of entities that are direcf types of the given instance
     * @deprecated As of 2.5.0. Use {{@link #findTypes(Instance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findTypes(Instance instance) {
    	return findTypes(instance, null);
    }
    
    /**
     * Finds entities that are direct or indirect types of the given instance
     * 
     * @param instance the given instance
     * @param scope The scope of the search (can be null)
     * @return a set of entities that are direct or indirect types of the given instance
     */
    public static Set<Entity> findAllTypes(Instance instance, Set<Resource> scope) {
        return findTypes(instance, scope).stream()
        		.flatMap(t -> findAllSuperTerms(t, true, scope).stream())
        		.filter(t -> t instanceof Entity)
        		.map(t -> (Entity)t)
        		.distinct()
        		.collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds entities that are direct or indirect types of the given instance
     * 
     * @param instance the given instance
     * @return a set of entities that are direct or indirect types of the given instance
     * @deprecated As of 2.5.0. Use {{@link #findAllTypes(Instance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Entity> findAllTypes(Instance instance) {
    	return findAllTypes(instance, null);
    }
    
    /**
     * Finds whether the given instance is typed directly by the given type
     * 
     * @param instance the given instance
     * @param type the given type
     * @param scope The scope of the search (can be null)
     * @return true if the given instance is typed directly by the given type; otherwise false
     */
    public static boolean findIsTypeOf(Instance instance, Entity type, Set<Resource> scope) {
        return findTypes(instance, scope).stream()
            .filter(t -> t == type)
            .findFirst().isPresent();
    }

    /**
     * Finds whether the given instance is typed directly by the given type
     * 
     * @param instance the given instance
     * @param type the given type
     * @return true if the given instance is typed directly by the given type; otherwise false
     * @deprecated As of 2.5.0. Use {{@link #findIsTypeOf(Instance, Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static boolean findIsTypeOf(Instance instance, Entity type) {
    	return findIsTypeOf(instance, type, null);
    }
    
    /**
     * Finds whether the given instance is typed directly or transitively by the given type
     * 
     * @param instance the given instance
     * @param type the given type
     * @param scope The scope of the search (can be null)
     * @return true if the given instance is typed directly or transitively by the given type; otherwise false
     */
    public static boolean findIsKindOf(Instance instance, Entity type, Set<Resource> scope) {
        return findTypes(instance, scope).stream()
            .filter(t -> findIsSubTermOf(t, type, scope))
            .findFirst().isPresent();
    }

    /**
     * Finds whether the given instance is typed directly or transitively by the given type
     * 
     * @param instance the given instance
     * @param type the given type
     * @return true if the given instance is typed directly or transitively by the given type; otherwise false
     * @deprecated As of 2.5.0. Use {{@link #findIsKindOf(Instance, Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static boolean findIsKindOf(Instance instance, Entity type) {
    	return findIsKindOf(instance, type, null);
    }
    
    /**
     * Finds instances that have the given type as their direct type
     * 
     * @param type the given type
     * @param scope The scope of the search (can be null)
     * @return a set of instances that have the given type as their direct type
     */
    public static Set<Instance> findInstancesOfType(Entity type, Set<Resource> scope) {
    	Set<Instance> instances = new HashSet<>();

		instances.addAll(findTypeAssertionsWithType((Entity)type, scope).stream()
            .map(i -> i.getSubject())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
		if (type instanceof RelationEntity) {
			instances.addAll(findAnonymousRelationInstanceOfType((RelationEntity)type, scope));
		}
		
        return instances;
    }

    /**
     * Finds instances that have the given type as their direct type
     * 
     * @param type the given type
     * @return a set of instances that have the given type as their direct type
     * @deprecated As of 2.5.0. Use {{@link #findInstancesOfType(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Instance> findInstancesOfType(Entity type) {
    	return findInstancesOfType(type, null);
    }
    
    /**
     * Finds instances that have the given type as their direct or transitive type
     * 
     * @param type the given type
     * @param scope The scope of the search (can be null)
     * @return a set of instances that have the given type as their direct or transitive type
     */
    public static Set<Instance> findInstancesOfKind(Entity type, Set<Resource> scope) {
        return findAllSubTerms(type, true, scope).stream()
            .map(t -> (Entity)t)
            .flatMap(t -> findInstancesOfType(t, scope).stream())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds instances that have the given type as their direct or transitive type
     * 
     * @param type the given type
     * @return a set of instances that have the given type as their direct or transitive type
     * @deprecated As of 2.5.0. Use {{@link #findInstancesOfKind(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Instance> findInstancesOfKind(Entity type) {
    	return findInstancesOfKind(type,  null);
    }
    
    /**
     * Finds anonymous relation instances referencing the given entity as a type
     * 
     * @param entity The given relation entity
     * @param scope The scope of the search (can be null)
     * @return A set of referencing anonymous relation instances
     */
    public static Set<AnonymousRelationInstance> findAnonymousRelationInstanceOfType(RelationEntity entity, Set<Resource> scope) {
    	Set<AnonymousRelationInstance> instances = new HashSet<>();
    	
    	instances.addAll(findPropertyValueAssertionsWithProperty(entity.getForwardRelation(), scope).stream()
        	.flatMap(a -> a.getContainedValue().stream())
        	.filter(v -> v instanceof AnonymousRelationInstance)
        	.map(v -> (AnonymousRelationInstance)v)
        	.collect(Collectors.toSet()));
        
    	if (entity.getReverseRelation() != null) {
        	instances.addAll(findPropertyValueAssertionsWithProperty(entity.getReverseRelation(), scope).stream()
                	.flatMap(a -> a.getContainedValue().stream())
                	.filter(v -> v instanceof AnonymousRelationInstance)
                	.map(v -> (AnonymousRelationInstance)v)
                	.collect(Collectors.toSet()));
        }
    	
        return instances;
    }

    /**
     * Finds anonymous relation instances referencing the given entity as a type
     * 
     * @param entity The given relation entity
     * @return A set of referencing anonymous relation instances
     * @deprecated As of 2.5.0. Use {{@link #findAnonymousRelationInstanceOfType(RelationEntity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<AnonymousRelationInstance> findAnonymousRelationInstanceOfType(RelationEntity entity) {
    	return findAnonymousRelationInstanceOfType(entity, null);
    }

    //-------------------------------------------------
    // LITERALS
    //-------------------------------------------------

    /**
     * Finds all the scalars that are direct or indirect types of the given literal
     * 
     * @param literal the given literal
     * @param scope The scope of the search (can be null)
     * @return a set of scalars that are direct or indirect types of the given literal
     */
    public static Set<Scalar> findAllTypes(Literal literal, Set<Resource> scope) {
        return findAllSuperTerms(OmlRead.getType(literal), true, scope).stream()
        		.filter(t -> t instanceof Scalar)
        		.map(t -> (Scalar)t)
        		.collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds all the scalars that are direct or indirect types of the given literal
     * 
     * @param literal the given literal
     * @return a set of scalars that are direct or indirect types of the given literal
     * @deprecated As of 2.5.0. Use {{@link #findAllTypes(Literal, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Scalar> findAllTypes(Literal literal) {
    	return findAllTypes(literal, null);
    }
    
    /**
     * Finds if the given literal is typed directly or transitively by the given type
     * 
     * @param literal the given literal
     * @param type the given type
     * @param scope The scope of the search (can be null)
     * @return true if the given literal is typed directly or transitively by the given type; otherwise false
     */
    public static boolean findIsKindOf(Literal literal, Scalar type, Set<Resource> scope) {
    	if (OmlRead.isStandardScalar(type)) {
    		return findAllTypes(literal, scope).contains(type);
    	} else if (findIsEnumeratedScalar(type, scope)) {
    		return findEnumerationLiterals(type, scope).stream().anyMatch(i -> OmlRead.isEqual(i, literal));
    	} else  { // facetted scalar
    		return findEquivalentScalars(type, scope).stream()
    				.anyMatch(s -> findIsKindOf(literal, s, scope));
    	}
	}

    /**
     * Finds if the given literal is typed directly or transitively by the given type
     * 
     * @param literal the given literal
     * @param type the given type
     * @return true if the given literal is typed directly or transitively by the given type; otherwise false
     * @deprecated As of 2.5.0. Use {{@link #findIsKindOf(Literal, Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static boolean findIsKindOf(Literal literal, Scalar type) {
    	return findIsKindOf(literal, type, null);
    }
    
}
