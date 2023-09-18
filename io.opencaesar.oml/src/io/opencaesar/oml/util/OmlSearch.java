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
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import io.opencaesar.oml.QuotedLiteral;
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
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
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
     * @return a set of refs to the given member
     */
    public static Set<Member> findRefs(Member member) {
        Set<Member> refs = new LinkedHashSet<>();
        if (member instanceof AnnotationProperty) {
            refs.addAll(findAnnotationPropertiesWithRef((AnnotationProperty)member));
        } else if (member instanceof Aspect) {
            refs.addAll(findAspectsWithRef((Aspect)member));
        } else if (member instanceof Concept) {
            refs.addAll(findConceptsWithRef((Concept)member));
        } else if (member instanceof RelationEntity) {
            refs.addAll(findRelationEntitiesWithRef((RelationEntity)member));
        } else if (member instanceof Structure) {
            refs.addAll(findStructuresWithRef((Structure)member));
        } else if (member instanceof Scalar) {
            refs.addAll(findScalarsWithRef((Scalar)member));
        } else if (member instanceof Relation) {
            refs.addAll(findUnreifiedRelationsWithRef((Relation)member));
        } else if (member instanceof StructuredProperty) {
            refs.addAll(findStructuredPropertiesWithRef((StructuredProperty)member));
        } else if (member instanceof ScalarProperty) {
            refs.addAll(findScalarPropertiesWithRef((ScalarProperty)member));
        } else if (member instanceof Rule) {
            refs.addAll(findRulesWithRef((Rule)member));
        } else if (member instanceof ConceptInstance) {
            refs.addAll(findConceptInstancesWithRef((ConceptInstance)member));
        } else if (member instanceof RelationInstance) {
            refs.addAll(findRelationInstancesWithRef((RelationInstance)member));
        }
        return refs;
    }

    /*
     * Finds annotations of the given annotation property in the given element
     * 
     * @param element the given element
     * @param property the annotation property
     * @return a set of annotations of the given element
     */
    private static Stream<Annotation> findAnnotations(IdentifiedElement element, AnnotationProperty property) {
        final Set<Annotation> annotations = new LinkedHashSet<>(element.getOwnedAnnotations());
        if (element instanceof Member) {
        	var member = (Member)element;
            annotations.addAll(findRefs(member).stream()
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
     * @return a set of literals representing annotation values
     */
    public static Set<Element> findAnnotationValues(IdentifiedElement element, AnnotationProperty property) {
        return findAnnotations(element, property)
            .map(a -> a.getValue())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    /**
     * Finds the first literal value of the given annotation property in the given element
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return an annotation literal value
     */
    public static Literal findAnnotationLiteralValue(IdentifiedElement element, AnnotationProperty property) {
        return findAnnotations(element, property)
                .filter(a -> a.getLiteralValue() != null)
                .map(a -> a.getLiteralValue())
	            .findFirst()
	            .orElse(null);
    }

    /**
     * Finds the first referenced value of a given annotation property in the given element
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return an annotation reference value
     */
    public static Member findAnnotationReferencedValue(IdentifiedElement element, AnnotationProperty property) {
        return findAnnotations(element, property)
            .filter(a -> a.getReferencedValue() != null)
            .map(a -> a.getReferencedValue())
            .findFirst()
            .orElse(null);
    }

    /**
     * Finds whether the given element is annotated with the given annotation property
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return true if the element is annotated with the given annotation property; otherwise false
     */
    public static boolean findIsAnnotatedBy(IdentifiedElement element, AnnotationProperty property) {
        return !findAnnotations(element, property).findAny().isEmpty();
    }

    //-------------------------------------------------
    // VOCABULARIES
    //-------------------------------------------------

    /**
     * Finds axioms that are defined for the given term
     * 
     * @param term the given term
     * @return a set of axioms that are defined for the given term
     */
    public static Set<Axiom> findAxioms(Term term) {
        Set<Axiom> axioms = new LinkedHashSet<>();
        if (term instanceof SpecializableTerm){
            axioms.addAll(findSpecializationAxiomsWithSubTerm(((SpecializableTerm)term)));
        }
        if (term instanceof Classifier) {
            axioms.addAll(findClassifierEquivalenceAxiomsWithSubClassifier(((Classifier)term)));
            axioms.addAll(findPropertyRestrictionAxioms(((Classifier)term)));
        }
        if (term instanceof Entity) {
            axioms.addAll(findKeyAxioms(((Entity)term)));
        }
        if (term instanceof Concept) {
            axioms.addAll(findInstanceEnumerationAxioms(((Concept)term)));
        }
        if (term instanceof Scalar) {
            axioms.addAll(findScalarEquivalenceAxiomsWithSubScalar(((Scalar)term)));
            axioms.addAll(findLiteralEnumerationAxioms(((Scalar)term)));
        }
        if (term instanceof Property) {
            axioms.addAll(findPropertyEquivalenceAxiomsWithSubProperty(((Property)term)));
        }
        return axioms;
    }

    /**
     * Find key axioms that are defined on the given entity
     * 
     * @param entity the given entity
     * @return a set of key axioms that are defined on the given entity
     */
    public static Set<KeyAxiom> findKeyAxioms(Entity entity) {
        final Set<KeyAxiom> axioms = new LinkedHashSet<>();
        axioms.addAll(entity.getOwnedKeys());
        axioms.addAll(findRefs(entity).stream()
            .filter(i -> i instanceof Entity)
            .map(i -> (Entity)i)
            .flatMap(r -> r.getOwnedKeys().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Find instance enumeration axioms that are defined on the given concept
     * 
     * @param concept the given concept
     * @return a set of instance enumeration axioms that are defined on the given concept
     */
    public static Set<InstanceEnumerationAxiom> findInstanceEnumerationAxioms(Concept concept) {
        final Set<InstanceEnumerationAxiom> axioms = new LinkedHashSet<>();
        if (concept.getOwnedEnumeration() != null) {
        	axioms.add(concept.getOwnedEnumeration());
        }
        axioms.addAll(findRefs(concept).stream()
            .filter(i -> i instanceof Concept)
            .map(i -> (Concept)i)
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
     */
    public static Set<LiteralEnumerationAxiom> findLiteralEnumerationAxioms(Scalar scalar) {
        final Set<LiteralEnumerationAxiom> axioms = new LinkedHashSet<>();
        if (scalar.getOwnedEnumeration() != null) {
        	axioms.add(scalar.getOwnedEnumeration());
        }
        axioms.addAll(findRefs(scalar).stream()
            .filter(i -> i instanceof Scalar)
            .map(i -> (Scalar)i)
            .filter(i -> i.getOwnedEnumeration() != null)
            .map(i -> i.getOwnedEnumeration())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Find property restriction axioms that are defined on the given classifier
     * 
     * @param classifier the given classifier
     * @return a set of restriction axioms that are defined on the given classifier
     */
    public static Set<PropertyRestrictionAxiom> findPropertyRestrictionAxioms(Classifier classifier) {
        final Set<PropertyRestrictionAxiom> axioms = new LinkedHashSet<>();
        axioms.addAll(classifier.getOwnedPropertyRestrictions());
        axioms.addAll(findRefs(classifier).stream()
            .filter(i -> i instanceof Classifier)
            .map(i -> (Classifier)i)
            .flatMap(r -> r.getOwnedPropertyRestrictions().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    //-----Beginning-Of-Specialization-and-Equivalence-Axioms-----------------
    
    /**
     * Finds specialization axioms that have the given term as a sub term
     * 
     * @param term the given term
     * @return a set of specialization axioms that have the given term as a sub term
     */
    public static Set<SpecializationAxiom> findSpecializationAxiomsWithSubTerm(Term term) {
        final Set<SpecializationAxiom> axioms = new LinkedHashSet<>();
        if (term instanceof SpecializableTerm) {
        	axioms.addAll(((SpecializableTerm)term).getOwnedSpecializations());
        }
        axioms.addAll(findRefs(term).stream()
            .filter(i -> i instanceof SpecializableTerm)
            .map(i -> (SpecializableTerm)i)
            .flatMap(r -> r.getOwnedSpecializations().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Finds classifier equivalence axioms that have the given classifier as a sub
     * 
     * @param classifier the given classifier
     * @return a set of classifier equivalence axioms that have the given classifier as a sub
     */
    public static Set<ClassifierEquivalenceAxiom> findClassifierEquivalenceAxiomsWithSubClassifier(Classifier classifier) {
        final Set<ClassifierEquivalenceAxiom> axioms = new LinkedHashSet<>();
       	axioms.addAll(classifier.getOwnedEquivalences());
        axioms.addAll(findRefs(classifier).stream()
            .filter(i -> i instanceof Classifier)
            .map(i -> (Classifier)i)
            .flatMap(r -> r.getOwnedEquivalences().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Finds scalar equivalence axioms that have the given scalar as a sub
     * 
     * @param scalar the given scalar
     * @return a set of scalar equivalence axioms that have the given scalar as a sub
     */
    public static Set<ScalarEquivalenceAxiom> findScalarEquivalenceAxiomsWithSubScalar(Scalar scalar) {
        final Set<ScalarEquivalenceAxiom> axioms = new LinkedHashSet<>();
       	axioms.addAll(scalar.getOwnedEquivalences());
        axioms.addAll(findRefs(scalar).stream()
            .filter(i -> i instanceof Scalar)
            .map(i -> (Scalar)i)
            .flatMap(r -> r.getOwnedEquivalences().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Finds property equivalence axioms that have the given property as a sub
     * 
     * @param property the given property
     * @return a set of property equivalence axioms that have the given property as a sub
     */
    public static Set<PropertyEquivalenceAxiom> findPropertyEquivalenceAxiomsWithSubProperty(Property property) {
        final Set<PropertyEquivalenceAxiom> axioms = new LinkedHashSet<>();
        if (property instanceof SpecializableProperty) {
        	axioms.addAll(((SpecializableProperty)property).getOwnedEquivalences());
        }
        axioms.addAll(findRefs(property).stream()
            .filter(i -> i instanceof SpecializableProperty)
            .map(i -> (SpecializableProperty)i)
            .flatMap(r -> r.getOwnedEquivalences().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return axioms;
    }

    /**
     * Finds terms that are the direct super (general) terms of the given term 
     * 
     * @param term the given term
     * @return a set of terms that are the direct super (general) terms of the given term
     */
    public static Set<Term> findSuperTerms(Term term) {
        final Set<Term> supers = new LinkedHashSet<>();
        supers.addAll(findSpecializationSuperTerms(term));
        if (term instanceof Classifier) {
        	supers.addAll(findEquivalenceSuperClassifiers((Classifier)term));
        	supers.addAll(findEquivalentClassifiers((Classifier)term));
        } else if (term instanceof Scalar) {
        	supers.addAll(findEquivalenceSuperScalars((Scalar)term));
        	supers.addAll(findEquivalentScalars((Scalar)term));
        } else if (term instanceof Property) {
        	supers.addAll(findEquivalentProperties((Property)term));
        }
        return supers;
    }

    /**
     * Finds terms that are the direct sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @return a set of terms that are the direct sub (specific) terms of the given term
     */
    public static Set<Term> findSubTerms(Term term) {
        final Set<Term> subs = new LinkedHashSet<>();
        subs.addAll(findSpecializationSubTerms(term));
        if (term instanceof Classifier) {
        	subs.addAll(findEquivalenceSubClassifiers((Classifier)term));
        	subs.addAll(findEquivalentClassifiers((Classifier)term));
        } else if (term instanceof Scalar) {
        	subs.addAll(findEquivalenceSubScalars((Scalar)term));
        	subs.addAll(findEquivalentScalars((Scalar)term));
        } else if (term instanceof Property) {
        	subs.addAll(findEquivalentProperties((Property)term));
        }
        return subs;
    }

    /**
     * Finds terms that are the direct or transitive super (general) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a set of terms that are the direct or transitive super (general) terms of the given term
     */
    public static Set<Term> findAllSuperTerms(Term term, boolean inclusive) {
        return OmlRead.closure(term, inclusive, t -> findSuperTerms(t)).stream()
        		.collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    /**
     * Finds terms that are the direct or transitive sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a set of terms that are the direct or transitive sub (specific) terms of the given term
     */
    public static Set<Term> findAllSubTerms(Term term, boolean inclusive) {
        return OmlRead.closure(term, inclusive, t -> findSubTerms(t)).stream()
        		.collect(Collectors.toCollection(LinkedHashSet::new));
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
     * @return a set of terms that are the direct specialization super terms of the given term
     */
    public static Set<Term> findSpecializationSuperTerms(Term term) {
    	var supers = new LinkedHashSet<Term>();
        supers.addAll(findSpecializationAxiomsWithSubTerm(term).stream()
                .map(i -> i.getSuperTerm())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        if (term instanceof ForwardRelation) {
        	var entity = ((ForwardRelation)term).getRelationEntity();
    		supers.addAll(findSpecializationSuperTerms(entity).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	} else if (term instanceof ReverseRelation) {
        	var base = ((ReverseRelation)term).getRelationBase();
    		supers.addAll(findSpecializationSuperTerms(base).stream()
    	        .filter(i -> i instanceof RelationBase)
	            .map(i -> (RelationBase)i)
	            .filter(i -> i.getReverseRelation() != null)
	            .map(i -> i.getReverseRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	}
    	return supers;
    }
    
    /**
     * Finds terms that are the direct specialization sub terms of the given term 
     * 
     * @param term the given term
     * @return a set of terms that are the direct specialization sub terms of the given term
     */
    public static Set<Term> findSpecializationSubTerms(Term term) {
    	var subs = new LinkedHashSet<Term>();
        subs.addAll(findSpecializationAxiomsWithSuperTerm(term).stream()
            .map(i -> i.getSubTerm())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        if (term instanceof ForwardRelation) {
        	var entity = ((ForwardRelation)term).getRelationEntity();
    		subs.addAll(findSpecializationSubTerms(entity).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	} else if (term instanceof ReverseRelation) {
        	var base = ((ReverseRelation)term).getRelationBase();
        	subs.addAll(findSpecializationSubTerms(base).stream()
    	        .filter(i -> i instanceof RelationBase)
	            .map(i -> (RelationBase)i)
	            .filter(i -> i.getReverseRelation() != null)
	            .map(i -> i.getReverseRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	}
    	return subs;
    }

    /**
     * Finds classifiers that are the direct equivalence super of a given classifier 
     * 
     * @param classifier the given classifier
     * @return a set of classifier that are the direct equivalence super of the given classifier
     */
    public static Set<Classifier> findEquivalenceSuperClassifiers(Classifier classifier) {
        return findClassifierEquivalenceAxiomsWithSubClassifier(classifier).stream()
            .flatMap(i -> i.getSuperClassifiers().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    /**
     * Finds classifiers that are the direct equivalence sub of a given classifier 
     * 
     * @param classifier the given classifier
     * @return a set of classifier that are the direct equivalence sub of the given classifier
     */
    public static Set<Classifier> findEquivalenceSubClassifiers(Classifier classifier) {
        return findClassifierEquivalenceAxiomsWithSuperClassifier(classifier).stream()
            .map(i -> i.getSubClassifier())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    /**
     * Finds scalars that are the direct equivalence super of a given scalar 
     * 
     * @param scalar the given scalar
     * @return a set of classifier that are the direct equivalence super of the given classifier
     */
    public static Set<Scalar> findEquivalenceSuperScalars(Scalar scalar) {
        return findScalarEquivalenceAxiomsWithSubScalar(scalar).stream()
            .map(i -> i.getSuperScalar())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    /**
     * Finds scalars that are the direct equivalence sub of a given scalar 
     * 
     * @param scalar the given scalar
     * @return a set of scalars that are the direct equivalence sub of the given scalar
     */
    public static Set<Scalar> findEquivalenceSubScalars(Scalar scalar) {
        return findScalarEquivalenceAxiomsWithSuperScalar(scalar).stream()
            .map(i -> i.getSubScalar())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds properties that are the direct equivalence super of a given property 
     * 
     * @param property the given property
     * @return a set of properties that are the direct equivalence super of the given property
     */
    public static Set<Property> findEquivalenceSuperProperties(Property property) {
    	var supers = new LinkedHashSet<Property>();
        supers.addAll(findPropertyEquivalenceAxiomsWithSubProperty(property).stream()
            .map(i -> i.getSuperProperty())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        if (property instanceof ForwardRelation) {
    		var entity = ((ForwardRelation)property).getRelationEntity();
    		supers.addAll(findEquivalenceSuperClassifiers(entity).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	} else if (property instanceof ReverseRelation) {
    		var base = ((ReverseRelation)property).getRelationBase();
    		if (base instanceof RelationEntity) {
        		supers.addAll(findEquivalenceSuperClassifiers((RelationEntity)base).stream()
            	        .filter(i -> i instanceof RelationEntity)
        	            .map(i -> (RelationEntity)i)
        	            .filter(i -> i.getReverseRelation() != null)
        	            .map(i -> i.getReverseRelation())
    		            .collect(Collectors.toCollection(LinkedHashSet::new)));
    		} else if (base instanceof UnreifiedRelation) {
        		supers.addAll(findEquivalenceSuperProperties((UnreifiedRelation)base).stream()
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
     * Finds properties that are the direct equivalence sub of a given property 
     * 
     * @param property the given property
     * @return a set of properties that are the direct equivalence sub of the given property
     */
    public static Set<Property> findEquivalenceSubProperties(Property property) {
    	var subs = new LinkedHashSet<Property>();
    	subs.addAll(findPropertyEquivalenceAxiomsWithSuperProperty(property).stream()
            .map(i -> i.getSubProperty())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        if (property instanceof ForwardRelation) {
    		var entity = ((ForwardRelation)property).getRelationEntity();
    		subs.addAll(findEquivalenceSubClassifiers(entity).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
    	} else if (property instanceof ReverseRelation) {
    		var base = ((ReverseRelation)property).getRelationBase();
    		if (base instanceof RelationEntity) {
        		subs.addAll(findEquivalenceSubClassifiers((RelationEntity)base).stream()
            	        .filter(i -> i instanceof RelationEntity)
        	            .map(i -> (RelationEntity)i)
        	            .filter(i -> i.getReverseRelation() != null)
        	            .map(i -> i.getReverseRelation())
    		            .collect(Collectors.toCollection(LinkedHashSet::new)));
    		} else if (base instanceof UnreifiedRelation) {
        		subs.addAll(findEquivalenceSubProperties((UnreifiedRelation)base).stream()
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
     * Finds classifiers that are the direct equivalent to a given classifier 
     * 
     * @param classifier the given classifier
     * @return a set of classifier that are the direct equivalents of the given classifier
     */
    public static Set<Classifier> findEquivalentClassifiers(Classifier classifier) {
        final Set<Classifier> equivalents = new LinkedHashSet<>();
        equivalents.addAll(findClassifierEquivalenceAxiomsWithSubClassifier(classifier).stream()
            	.filter(i -> i.getOwnedPropertyRestrictions().size() == 0)
            	.filter(i -> i.getSuperClassifiers().size() == 1)
                .map(i -> i.getSuperClassifiers().get(0))
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        equivalents.addAll(findClassifierEquivalenceAxiomsWithSuperClassifier(classifier).stream()
            	.filter(i -> i.getOwnedPropertyRestrictions().size() == 0)
	        	.filter(i -> i.getSuperClassifiers().size() == 1)
	            .map(i -> i.getSubClassifier())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return equivalents;
    }

    /**
     * Finds scalars that are the direct equivalent to a given scalar 
     * 
     * @param scalar the given scalar
     * @return a set of scalars that are the direct equivalents of the given scalar
     */
    public static Set<Scalar> findEquivalentScalars(Scalar scalar) {
        final Set<Scalar> equivalents = new LinkedHashSet<>();
        equivalents.addAll(findScalarEquivalenceAxiomsWithSubScalar(scalar).stream()
            	.filter(i -> OmlRead.getNumberOfFacets(i) == 0)
                .map(i -> i.getSuperScalar())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        equivalents.addAll(findScalarEquivalenceAxiomsWithSuperScalar(scalar).stream()
            	.filter(i -> OmlRead.getNumberOfFacets(i) == 0)
	            .map(i -> i.getSubScalar())
	            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return equivalents;
    }

    /**
     * Finds properties that are the direct equivalent to a given property 
     * 
     * @param property the given property
     * @return a set of property that are the direct equivalents of the given property
     */
    public static Set<Property> findEquivalentProperties(Property property) {
        final Set<Property> equivalents = new LinkedHashSet<>();
        equivalents.addAll(findEquivalenceSuperProperties(property));
        equivalents.addAll(findEquivalenceSubProperties(property));
        return equivalents;
    }

    //-----End-Of-Specialization-and-Equivalence-Axioms-----------------

    /**
     * Finds relations that have the given entity as their source
     * 
     * @param entity the given entity
     * @return a set of relations that have the given entity as their source
     */
    public static Set<Relation> findSourceRelations(Entity entity) {
        final Set<Relation> relations = new LinkedHashSet<>();
        relations.addAll(findRelationBasesWithSource(entity).stream()
        	.filter(r -> r instanceof UnreifiedRelation)
            .map(r -> (UnreifiedRelation)r)
            .filter(r -> r != null)
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        relations.addAll(findRelationBasesWithSource(entity).stream()
            	.filter(r -> r instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        relations.addAll(findRelationBasesWithTarget(entity).stream()
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
     */
    public static Set<Relation> findTargetRelations(Entity entity) {
        final Set<Relation> relations = new LinkedHashSet<>();
        relations.addAll(findRelationBasesWithTarget(entity).stream()
           	.filter(r -> r instanceof UnreifiedRelation)
            .map(r -> (UnreifiedRelation)r)
            .filter(r -> r != null)
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        relations.addAll(findRelationBasesWithTarget(entity).stream()
            	.filter(r -> r instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        relations.addAll(findRelationBasesWithSource(entity).stream()
	            .map(i -> (RelationBase)i)
	            .filter(i -> i.getReverseRelation() != null)
	            .map(i -> i.getReverseRelation())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return relations;
    }

    /**
     * Finds semantic properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @return A set of referencing semantic properties
     */
    public static Set<SemanticProperty> findSemanticPropertiesWithDomain(Classifier domain) {
    	var properties = new LinkedHashSet<SemanticProperty>();
    	properties.addAll(findScalarPropertiesWithDomain(domain));
    	properties.addAll(findStructuredPropertiesWithDomain(domain));
    	if (domain instanceof Entity) {
    		properties.addAll(findSourceRelations((Entity)domain));
    	}
        return properties;
    }
    
    /**
     * Finds semantic properties referencing the given type as range
     * 
     * @param range The referenced type
     * @return A set of referencing semantic properties
     */
    public static Set<SemanticProperty> findSemanticPropertiesWithRange(Type range) {
    	var properties = new LinkedHashSet<SemanticProperty>();
    	if (range instanceof Scalar) {
    		properties.addAll(findScalarPropertiesWithRange((Scalar)range));
    	} else if (range instanceof Structure) {
    		properties.addAll(findStructuredPropertiesWithRange((Structure)range));
    	} else if (range instanceof Entity) {
    		properties.addAll(findTargetRelations((Entity)range));
    	}
        return properties;
    }

    /**
     * Finds the domains of the given semantic property
     * 
     * @param property The given property
     * @return A set of domains for the given semantic property
     */
    public static Set<Classifier> findDomains(SemanticProperty property) {
    	var domains = new LinkedHashSet<Classifier>();
    	domains.addAll(property.getDomainList());
    	domains.addAll(findRefs(property).stream()
                .map(i -> (SemanticProperty)i)
                .flatMap(r -> r.getDomainList().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return domains;
    }

    /**
     * Finds the ranges of the given semantic property
     * 
     * @param property The given property
     * @return A set of ranges for the given semantic property
     */
    public static Set<Type> findRanges(SemanticProperty property) {
    	var ranges = new LinkedHashSet<Type>();
    	ranges.addAll(property.getRangeList());
    	ranges.addAll(findRefs(property).stream()
                .map(i -> (SemanticProperty)i)
                .flatMap(r -> r.getRangeList().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return ranges;
    }

    /**
     * Find entities that have the following property included in one of their keys
     * 
     * @param property the given property
     * @return a set of entities that have the following property included in one of their keys
     */
    public static Set<Entity> findEntitiesKeyedWith(SemanticProperty property) {
        return findKeyAxiomsWithProperty(property).stream()
            .map(i -> i.getKeyedEntity())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Finds the sources of the given relation base
     * 
     * @param base The given relation base
     * @return A set of sources for the given relation base
     */
    public static Set<Entity> findSources(RelationBase base) {
    	var sources = new LinkedHashSet<Entity>();
    	sources.addAll(base.getSources());
    	sources.addAll(findRefs(base).stream()
                .map(i -> (RelationEntity)i)
                .flatMap(r -> r.getSources().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return sources;
    }

    /**
     * Finds the targets of the given relation base
     * 
     * @param base The given relation base
     * @return A set of targets for the given relation base
     */
    public static Set<Entity> findTargets(RelationBase base) {
    	var sources = new LinkedHashSet<Entity>();
    	sources.addAll(base.getTargets());
    	sources.addAll(findRefs(base).stream()
                .map(i -> (RelationEntity)i)
                .flatMap(r -> r.getTargets().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return sources;
    }
    
    /**
     * Finds whether the given scalar property has as one of its ranges an enumerated scalar
     * 
     * @param property The given scalar property
     * @return true is the scalar is enumerated; false otherwise
     */
    public static boolean findIsEnumeratedProperty(ScalarProperty property) {
    	return property.getRanges().stream().anyMatch(r -> findIsEnumeratedScalar(r));
    }

    /**
     * Finds whether the given scalar has enumeration literals
     * 
     * @param scalar The given scalar
     * @return true is the scalar is enumerated; false otherwise
     */
    public static boolean findIsEnumeratedScalar(Scalar scalar) {
    	return findLiteralEnumerationAxioms(scalar).isEmpty();
    }
    
    /**
     * Finds the list of enumeration liters of the given scalar
     * 
     * @param scalar The given scalar
     * @return a list of enumeration literals
     */
    public static List<Literal> findEnumerationLiterals(Scalar scalar) {
    	return findLiteralEnumerationAxioms(scalar).stream()
    			.flatMap(a -> a.getLiterals().stream())
    			.collect(Collectors.toList());
    }	

    //-------------------------------------------------
    // DESCRIPTIONS
    //-------------------------------------------------

    /**
     * Finds assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @return a set of assertions that are defined on the given instance
     */
    public static Set<Assertion> findAssertions(Instance instance) {
        Set<Assertion> assertions = new LinkedHashSet<>();
        assertions.addAll(findPropertyValueAssertionsWithSubject(instance));
        if (instance instanceof NamedInstance) {
            assertions.addAll(findTypeAssertions((NamedInstance)instance));
        }
        return assertions;
    }

    /**
     * Finds type assertions that are defined on the given named instance
     * 
     * @param instance the given named instance
     * @return a set of type assertions that are defined on the given named instance
     */
    public static Set<TypeAssertion> findTypeAssertions(NamedInstance instance) {
        final Set<TypeAssertion> assertions = new LinkedHashSet<>(instance.getOwnedTypes());
        assertions.addAll(findRefs(instance).stream()
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .flatMap(r -> r.getOwnedTypes().stream())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
        return assertions;
    }
    
    /**
     * Finds property value assertions that have the given instance as their source
     * 
     * @param subject the given subject instance
     * @return a set of relation value assertions that have the given instance as their subject
     */
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithSubject(Instance subject) {
        final Set<PropertyValueAssertion> assertions = new LinkedHashSet<>(subject.getOwnedPropertyValues());
        if (subject instanceof NamedInstance) {
            assertions.addAll(findRefs((NamedInstance)subject).stream()
                .filter(i -> i instanceof NamedInstance)
                .map(i -> (NamedInstance)i)
                .flatMap(r -> r.getOwnedPropertyValues().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return assertions;
    }

    /**
     * Finds relation value assertions that have the given instance as their object
     * 
     * @param object the given object instance
     * @return a set of relation value assertions that have the given instance as their object
     */
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithObject(NamedInstance object) {
        return findPropertyValueAssertionsWithReferencedValue(object);
    }

    /**
     * Finds instances that are asserted as related to the given instance by any relation
     * 
     * @param instance the given instance
     * @return a set of instances related to the given instance by any relation
     */
    public static Set<NamedInstance> findInstancesRelatedTo(NamedInstance instance) {
        final Set<NamedInstance> related = new LinkedHashSet<>();
        related.addAll(findInstancesRelatedAsTargetTo(instance));
        related.addAll(findInstancesRelatedAsSourceTo(instance));
        return related;
    }

    /**
     * Finds instances that are asserted as related to the given instance by a given relation
     * 
     * @param instance the given instance
     * @param relation the given relation
     * @return a set of instances related to the given instance by a given relation
     */
    public static Set<NamedInstance> findInstancesRelatedTo(NamedInstance instance, Relation relation) {
        final Set<NamedInstance> related = new LinkedHashSet<>();
        related.addAll(findInstancesRelatedAsTargetTo(instance, relation));
        related.addAll(findInstancesRelatedAsSourceTo(instance, relation));
        return related;
    }

    /**
     * Finds target instances that are asserted as related to the given source instance by any relation
     * 
     * @param source the given source instance
     * @return a set of target instances related to the given source instance
     */
    public static Set<NamedInstance> findInstancesRelatedAsTargetTo(NamedInstance source) {
        final Set<NamedInstance> targets = new LinkedHashSet<>();
        // check property value assertions
        targets.addAll(findPropertyValueAssertionsWithSubject(source).stream()
        		.filter(a -> a.getProperty() instanceof Relation)
                .map(a -> a.getReferencedValue())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        // check relation instances
        targets.addAll(findRelationInstancesWithSource(source).stream()
                .flatMap(a -> a.getTargets().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return targets;
    }

    /**
     * Finds target instances that are asserted as related to the given source instance by a given relation
     * 
     * @param source the given source instance
     * @param relation the given relation
     * @return a set of target instances related to the given source instance
     */
    public static Set<NamedInstance> findInstancesRelatedAsTargetTo(NamedInstance source, Relation relation) {
    	final Set<NamedInstance> targets = new LinkedHashSet<>();
        // look in property value assertions
    	var subRelations = findAllSubTerms(relation, true);
        targets.addAll(findPropertyValueAssertionsWithSubject(source).stream()
                .filter(a -> a.getProperty() instanceof Relation)
                .filter(a -> subRelations.contains(a.getProperty()))
                .map(a -> a.getReferencedValue())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        // look in relation instances
        if (relation instanceof ForwardRelation) {
        	var subEntities = findAllSubTerms(((ForwardRelation)relation).getRelationEntity(), true);
	        targets.addAll(findRelationInstancesWithSource(source).stream()
	                .filter(i -> findAllTypes(i).retainAll(subEntities))
	                .flatMap(a -> a.getTargets().stream())
	                .collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return targets;
    }

    /**
     * Finds source instances that are related by any relation to the given target instance
     * 
     * @param target the given target instance
     * @return a set of source instances related to the given target instance
     */
    public static Set<NamedInstance> findInstancesRelatedAsSourceTo(NamedInstance target) {
        final Set<NamedInstance> sources = new LinkedHashSet<>();
        // look in property value assertions
       sources.addAll(findPropertyValueAssertionsWithObject(target).stream()
                .map(a -> (NamedInstance) a.getSubject())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
       // look in relation instances
        sources.addAll(findRelationInstancesWithTarget(target).stream()
                .flatMap(a -> a.getSources().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        return sources;
    }

    /**
     * Finds source instances that are related by a given relation to a given target instance
     * 
     * @param target the given target instance
     * @param relation the given relation
     * @return a set of source instances that are related by a given relation to the given target instance
     */
    public static Set<NamedInstance> findInstancesRelatedAsSourceTo(NamedInstance target, Relation relation) {
        final Set<NamedInstance> sources = new LinkedHashSet<>();
        // look in property value assertions
    	var subRelations = findAllSubTerms(relation, true);
        sources.addAll(findPropertyValueAssertionsWithObject(target).stream()
                .filter(a -> a.getProperty() instanceof Relation)
                .filter(a -> subRelations.contains(a.getProperty()))
                .map(a -> (NamedInstance) a.getSubject())
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        // look in relation instances
        if (relation instanceof ForwardRelation) {
        	var subEntities = findAllSubTerms(((ForwardRelation)relation).getRelationEntity(), true);
	        sources.addAll(findRelationInstancesWithTarget(target).stream()
	                .filter(i -> findAllTypes(i).retainAll(subEntities))
	                .flatMap(i -> i.getSources().stream())
	                .collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return sources;
    }

    /**
     * Finds elements that represent values of given semantic property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given semantic property
     * @return a set of elements that represent values of given semantic property defined on the given instance
     */
    public static Set<Element> findPropertyValues(Instance instance, SemanticProperty property) {
        return findPropertyValueAssertionsWithSubject(instance).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    /**
     * Finds the first literal value of given scalar property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given scalar property
     * @return a literal value of the given scalar property on the given instance
     */
    public static Literal findPropertyLiteralValue(Instance instance, ScalarProperty property) {
        return findPropertyValues(instance, property).stream()
            	.filter(i -> i instanceof Literal)
            	.map(i -> (Literal)i)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds the first contained value of given structured property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given structured property
     * @return a contained value of the given structured property on the given instance
     */
    public static StructureInstance findPropertyContainedValue(Instance instance, StructuredProperty property) {
        return findPropertyValues(instance, property).stream()
            	.filter(i -> i instanceof StructureInstance)
            	.map(i -> (StructureInstance)i)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds the first referenced value of given structured property defined on the given instance
     * 
     * @param instance the given instance
     * @param relation the given relation
     * @return a referenced value of the given relation on the given instance
     */
    public static NamedInstance findPropertyReferencedValue(Instance instance, Relation relation) {
        return findPropertyValues(instance, relation).stream()
            	.filter(i -> i instanceof NamedInstance)
            	.map(i -> (NamedInstance)i)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds classifiers that are direct types of the given instance
     * 
     * @param instance the given instance
     * @return a set of classifiers that are direcf types of the given instance
     */
    public static Set<Classifier> findTypes(Instance instance) {
        Set<Classifier> types = new LinkedHashSet<>();
        if (instance instanceof StructureInstance) {
            types.add(((StructureInstance) instance).getType());
        } else if (instance instanceof NamedInstance) {
            types.addAll(findTypeAssertions((NamedInstance)instance).stream().
                map(i -> i.getType()).
                collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return types;
    }
    
    /**
     * Finds classifiers that are direct or indirect types of the given instance
     * 
     * @param instance the given instance
     * @return a set of classifiers that are direct or indirect types of the given instance
     */
    public static Set<Classifier> findAllTypes(Instance instance) {
        Set<Classifier> types = findTypes(instance).stream()
        		.flatMap(t -> OmlSearch.findAllSuperTerms(t, true).stream())
        		.filter(t -> t instanceof Classifier)
        		.map(t -> (Classifier)t)
        		.distinct()
        		.collect(Collectors.toCollection(LinkedHashSet::new));
        return types;
    }

    /**
     * Finds whether the given instance is typed directly by the given type
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
     * Finds whether the given instance is typed directly or transitively by the given type
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
     * @return a set of instances that have the given type as their direct type
     */
    public static Set<Instance> findInstancesOfType(Classifier type) {
        if (type instanceof Entity) {
            return findTypeAssertionsWithType((Entity)type).stream()
                .map(i -> i.getSubject())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        } else if (type instanceof Structure) {
            return new LinkedHashSet<Instance>(findStructureInstancesWithType((Structure)type));
        }
        return Collections.emptySet();
    }

    /**
     * Finds instances that have the given type as their direct or transitive type
     * 
     * @param type the given type
     * @return a set of instances that have the given type as their direct or transitive type
     */
    public static Set<Instance> findInstancesOfKind(Classifier type) {
        return findAllSubTerms(type, true).stream()
            .map(t -> (Classifier)t)
            .flatMap(t -> findInstancesOfType(t).stream())
            .collect(Collectors.toCollection(LinkedHashSet::new));
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
        return literal.getValue();
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
     * @return a set of scalars that are direct or indirect types of the given literal
     */
    public static Set<Scalar> findAllTypes(Literal literal) {
        Set<Scalar> types = OmlSearch.findAllSuperTerms(OmlRead.getType(literal), true).stream()
        		.filter(t -> t instanceof Scalar)
        		.map(t -> (Scalar)t)
        		.distinct()
        		.collect(Collectors.toCollection(LinkedHashSet::new));
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
    public static boolean findIsKindOf(Literal literal, Scalar type) {
    	if (type.getOwnedEnumeration() != null) {
    		return type.getOwnedEnumeration().getLiterals().stream().anyMatch(i -> OmlRead.isEqual(i, literal));
    	} else if (OmlRead.isStandardScalar(type)) {
    		return findAllTypes(literal).contains(type);
    	}
    	for (Term t : findAllSuperTerms(type, false)) {
    		Scalar supertype = (Scalar)t;
    		if (!findIsKindOf(literal, supertype)) {
    			return false;
    		}
    	}
    	return true;
	}
}
