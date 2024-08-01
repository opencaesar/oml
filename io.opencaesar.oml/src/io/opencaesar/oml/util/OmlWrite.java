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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EReference;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnonymousConceptInstance;
import io.opencaesar.oml.AnonymousInstance;
import io.opencaesar.oml.AnonymousRelationInstance;
import io.opencaesar.oml.Argument;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.BuiltIn;
import io.opencaesar.oml.BuiltInPredicate;
import io.opencaesar.oml.CardinalityRestrictionKind;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionStatement;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityEquivalenceAxiom;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.ImportKind;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.InstanceEnumerationAxiom;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.LiteralEnumerationAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertySelfRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RangeRestrictionKind;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.SameAsPredicate;
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
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.UnreifiedRelation;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyStatement;

/**
 * The <b>Write</b> API for the model. It complements the OML setter API by additional utilities.
 *  * 
 * @author elaasar
 */
public class OmlWrite {

    /**
     * Sets the given eRef on the given subject to an object in the context of the given ontology
     *  
     * @param ontology the given ontology
     * @param subject the given subject
     * @param eRef the given eReference 
     * @param object the given object
     */
    protected static void setCrossReference(Ontology ontology, Element subject, EReference eRef, Element object) {
        final Class<?> subjectClass = eRef.getEContainingClass().getInstanceClass();
        final Class<?> objectClass = eRef.getEType().getInstanceClass();
        assert subjectClass.isInstance(subject) : subject+" is not an instance of "+subjectClass.getName();
        assert object == null || objectClass.isInstance(object) : object+" is not an instance of "+objectClass.getName();
        assert !eRef.isContainment() : eRef.getName()+" is a containment reference";
        assert !eRef.isMany() : eRef.getName()+" is a multi valued reference";
    	subject.eSet(eRef, object);
    }
    
    /**
     * Sets the given eRef on the given subject to a List of objects in the context of the given ontology
     * 
     * @param ontology the given ontology
     * @param subject the given subject
     * @param eRef the given eReference 
     * @param objects the given list of objects
     */
    protected static void setCrossReferences(Ontology ontology, Element subject, EReference eRef, List<? extends Element> objects) {
        final Class<?> subjectClass = eRef.getEContainingClass().getInstanceClass();
        final Class<?> objectClass = eRef.getEType().getInstanceClass();
        assert subjectClass.isInstance(subject) : subject+" is not an instance of "+subjectClass.getName();
        for (Element object : objects) {
        	assert objectClass.isInstance(object) : object+" is not an instance of "+objectClass.getName();
        }
        assert !eRef.isContainment() : eRef.getName()+" is a containment reference";
        assert eRef.isMany() : eRef.getName()+" is a singular reference";
        subject.eSet(eRef, objects);
    }
    
    /**
     * Sets the given object to be contained by the given subject in the context of the given ontology
     * 
     * @param ontology the given ontology
     * @param subject the given subject
     * @param eRef the containment eRef to use on subject if it belongs to the given ontology
     * @param object the given object 
     */
    @SuppressWarnings("unchecked")
    protected static void setContainmentReference(Ontology ontology, Element subject, EReference eRef, Element object) {
        final Class<? extends Element> subjectClass = (Class<? extends Element>) eRef.getEContainingClass().getInstanceClass();
        final Class<? extends Element> objectClass = (Class<? extends Element>) eRef.getEType().getInstanceClass();
        assert subject == null || subjectClass.isInstance(subject) : subject+" is not an instance of "+subjectClass.getName();
        assert objectClass.isInstance(object) : object+" is not an instance of "+objectClass.getName();
        assert eRef.isContainment() : eRef.getName()+" is not a containment reference";
        if (subject != null) {
	        if (subject.getOntology() == ontology) {
	        	if (eRef.isMany()) {
	        		((List<Element>)subject.eGet(eRef)).add(object);
	        	} else {
	        		subject.eSet(eRef, object);
	        	}
	        } else if (subject instanceof Member){
	        	Member ref = getOrAddRef(ontology, (Member)subject);
	        	if (eRef.isMany()) {
	        		((List<Element>)ref.eGet(eRef)).add(object);
	        	} else {
	        		ref.eSet(eRef, object);
	        	}
	        }
        }
    }

    /**
     * Creates an object of the given type using the Oml factory
     * 
     * @param type the given Java type
     * @return an Oml object of the given type
     */
    protected static <T extends Element> T create(Class<T> type) {
        return OmlFactory2.INSTANCE.create(type);
    }

    /**
     * Gets an existing or creates a new ref to the given member in the context of the given ontology
     *  
     * @param ontology the context ontology
     * @param member the given member
     * @return a ref to the given member in the context of the given ontology
     */
    protected static Member getOrAddRef(Ontology ontology, Member member) {
        Member ref = OmlRead.getRefs(ontology).stream().filter(i -> i.getRef() == member).findFirst().orElse(null);
        if (ref == null) {
            ref = createRef(member);
            if (ontology instanceof Vocabulary) {
                ((Vocabulary) ontology).getOwnedStatements().add((VocabularyStatement) ref);
            } else if (ontology instanceof Description) {
                ((Description) ontology).getOwnedStatements().add((DescriptionStatement) ref); 
            }
        }
        return ref;
    }

    // ------------------------------------------------------------------------------------
    
    // Annotation

    /**
     * Adds a new annotation with literal values on a given ontology
     * 
     * @param ontology the ontology to annotate
     * @param property the given annotation property
     * @param literalValues the annotation's literal values
     * @return a new annotation on the given ontology
     */
    public static Annotation addAnnotation(Ontology ontology, AnnotationProperty property, Literal...literalValues) {
        final Annotation annotation = create(Annotation.class);
       	annotation.getLiteralValue().addAll(Arrays.asList(literalValues));
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, property);
        ontology.getOwnedAnnotations().add(annotation);
        return annotation;
    }

    /**
     * Adds a new annotation with a reference values (iris of members) on a given ontology
     * 
     * @param ontology the ontology to annotate
     * @param property the given annotation property
     * @param referencedValues the annotation's reference values (iris of members)
     * @return a new annotation on the given ontology
     */
    public static Annotation addAnnotation(Ontology ontology, AnnotationProperty property, Member...referencedValues) {
        final Annotation annotation = create(Annotation.class);
       	annotation.getReferencedValue().addAll(Arrays.asList(referencedValues));
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, property);
        ontology.getOwnedAnnotations().add(annotation);
        return annotation;
    }

    /**
     * Adds a new annotation with literal values on a given element in the context of a given ontology
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param element the annotated element to put the annotation on
     * @param property the given annotation property
     * @param literalValues the annotation's literal values
     * @return a new annotation on the given member in the context of the given ontology
     */
    public static Annotation addAnnotation(Ontology ontology, IdentifiedElement element, AnnotationProperty property, Literal...literalValues) {
        final Annotation annotation = create(Annotation.class);
       	annotation.getLiteralValue().addAll(Arrays.asList(literalValues));
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, property);
        setContainmentReference(ontology, element, OmlPackage.Literals.IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS, annotation);
        return annotation;
    }

    /**
     * Adds a new annotation with a reference values (iris of members) on a given element in the context of a given ontology
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param element the annotated element to put the annotation on
     * @param property the given annotation property
     * @param referencedValues the annotation's reference values (iris of members)
     * @return a new annotation on the given member in the context of the given ontology
     */
    public static Annotation addAnnotation(Ontology ontology, IdentifiedElement element, AnnotationProperty property, Member...referencedValues) {
        final Annotation annotation = create(Annotation.class);
       	annotation.getReferencedValue().addAll(Arrays.asList(referencedValues));
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, property);
        setContainmentReference(ontology, element, OmlPackage.Literals.IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS, annotation);
        return annotation;
    }

    // Ontology
    
    /**
     * Creates a new ontology of the given sub type 
     * 
     * @param type the sub type of ontology to create
     * @param namespace the namespace of the new ontology
     * @param prefix the prefix of the new ontology
     * @return a newly created ontology added to the contents of a resource with the given URI
     */
    protected static <T extends Ontology> T createOntology(Class<T> type, String namespace, String prefix) {
        final T ontology = create(type);
        ontology.setNamespace(namespace);
        ontology.setPrefix(prefix);
        return ontology;
    }

    // Vocabulary

    /**
     * Creates a new vocabulary 
     * 
     * @param namespace the namespace of the new vocabulary
     * @param prefix the prefix of the new vocabulary
     * @return a newly created vocabulary added to the contents of a resource with the given URI
     */
    public static Vocabulary createVocabulary(String namespace, String prefix) {
        return createOntology(Vocabulary.class, namespace, prefix);
    }

    // VocabularyBundle
    
    /**
     * Creates a new vocabulary bundle 
     * 
     * @param namespace the namespace of the new vocabulary bundle
     * @param prefix the prefix of the new vocabulary bundle
     * @return a newly created vocabulary bunel added to the contents of a resource with the given URI
     */
    public static VocabularyBundle createVocabularyBundle(String namespace, String prefix) {
        return createOntology(VocabularyBundle.class, namespace, prefix);
    }

    // Description
    
    /**
     * Creates a new description 
     * 
     * @param namespace the namespace of the new description
     * @param prefix the prefix of the new description
     * @return a newly created description added to the contents of a resource with the given URI
     */
    public static Description createDescription(String namespace, String prefix) {
        return createOntology(Description.class, namespace, prefix);
    }

    // DescriptionBundle

    /**
     * Creates a new description bundle 
     * 
     * @param namespace the namespace of the new description bundle
     * @param prefix the prefix of the new description bundle
     * @return a newly created description bundle added to the contents of a resource with the given URI
     */
    public static DescriptionBundle createDescriptionBundle(String namespace, String prefix) {
        return createOntology(DescriptionBundle.class, namespace, prefix);
    }

    // Aspect

    /**
     * Creates a new aspect and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new aspect
     * @return a new aspect that is added to the given vocabulary
     */
    public static Aspect addAspect(Vocabulary vocabulary, String name) {
        final Aspect aspect = create(Aspect.class);
        aspect.setName(name);
        vocabulary.getOwnedStatements().add(aspect);
        return aspect;
    }
    
    // Concept

    /**
     * Creates a new concept and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new concept
     * @return a new concept that is added to the given vocabulary
     */
    public static Concept addConcept(Vocabulary vocabulary, String name) {
        final Concept concept = create(Concept.class);
        concept.setName(name);
        vocabulary.getOwnedStatements().add(concept);
        return concept;
    }

    // RelationEntity
    
    /**
     * Creates a new relation entity and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new concept
     * @param sources the given list of source entities
     * @param targets the given list of target entities
     * @param functional whether the relation entity is functional
     * @param inverseFunctional whether the relation entity is inverse functional
     * @param symmetric whether the relation entity is symmetric
     * @param asymmetric whether the relation entity is asymmetric
     * @param reflexive whether the relation entity is reflexive
     * @param irreflexive whether the relation entity is irreflexive
     * @param transitive whether the relation entity is transitive
     * @return a new relation entity that is added to the given vocabulary
     */
    public static RelationEntity addRelationEntity(Vocabulary vocabulary, String name, List<Entity> sources, List<Entity> targets, 
        boolean functional, boolean inverseFunctional, boolean symmetric, 
        boolean asymmetric, boolean reflexive, boolean irreflexive, boolean transitive) {
        final RelationEntity relation = create(RelationEntity.class);
        relation.setName(name);
        relation.setFunctional(functional);
        relation.setInverseFunctional(inverseFunctional);
        relation.setSymmetric(symmetric);
        relation.setAsymmetric(asymmetric);
        relation.setReflexive(reflexive);
        relation.setIrreflexive(irreflexive);
        relation.setTransitive(transitive);
        setCrossReferences(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__SOURCES, sources);
        setCrossReferences(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__TARGETS, targets);
        vocabulary.getOwnedStatements().add(relation);
        return relation;
    }

    // AnnotationProperty

    /**
     * Creates a new annotation property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new annotation property
     * @return a new annotation property that is added to the given vocabulary
     */
    public static AnnotationProperty addAnnotationProperty(Vocabulary vocabulary, String name) {
        final AnnotationProperty property = create(AnnotationProperty.class);
        property.setName(name);
        vocabulary.getOwnedStatements().add(property);
        return property;
    }
    
    // ScalarProperty

    /**
     * Creates a new scalar property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new scalar property
     * @param domains the given list of domain entities
     * @param ranges the given list of range scalars
     * @param functional whether the scalar property is functional
     * @return a new scalar property that is added to the given vocabulary
     */
    public static ScalarProperty addScalarProperty(Vocabulary vocabulary, String name,
        List<Entity> domains, List<Scalar> ranges, boolean functional) {
        final ScalarProperty property = create(ScalarProperty.class);
        property.setName(name);
        property.setFunctional(functional);
        setCrossReferences(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__DOMAINS, domains);
        setCrossReferences(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__RANGES, ranges);
        vocabulary.getOwnedStatements().add(property);
        return property;
    }
    
    // Scalar

    /**
     * Creates a new scalar and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new scalar
     * @return a new scalar that is added to the given vocabulary
     */
    public static Scalar addScalar(Vocabulary vocabulary, String name) {
        final Scalar scalar = create(Scalar.class);
        scalar.setName(name);
        vocabulary.getOwnedStatements().add(scalar);
        return scalar;
    }
        
    // ForwardRelation

    /**
     * Creates a forward relation and adds it to the given relation entity
     * 
     * @param entity the context relation entity
     * @param name the name of the new forward relation
     * @return a forward relation that is added to the given relation entity
     */
    public static ForwardRelation addForwardRelation(RelationEntity entity, String name) {
        final ForwardRelation forward = create(ForwardRelation.class);
        forward.setName(name);
        entity.setForwardRelation(forward);
        return forward;
    }

    // ReverseRelation

    /**
     * Creates a reverse relation and adds it to the given relation base
     * 
     * @param base the context relation base
     * @param name the name of the new reverse relation
     * @return a reverse relation that is added to the given relation base
     */
    public static ReverseRelation addReverseRelation(RelationBase base, String name) {
        final ReverseRelation reverse = create(ReverseRelation.class);
        reverse.setName(name);
        base.setReverseRelation(reverse);
        return reverse;
    }
    
    // UnreifiedRelation

    /**
     * Creates a new unreified relation and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new concept
     * @param sources the given list of source entities
     * @param targets the given list of target entities
     * @param functional whether the relation entity is functional
     * @param inverseFunctional whether the relation entity is inverse functional
     * @param symmetric whether the relation entity is symmetric
     * @param asymmetric whether the relation entity is asymmetric
     * @param reflexive whether the relation entity is reflexive
     * @param irreflexive whether the relation entity is irreflexive
     * @param transitive whether the relation entity is transitive
     * @return a new unreified relation that is added to the given vocabulary
     */
    public static UnreifiedRelation addUnreifiedRelation(Vocabulary vocabulary, String name, List<Entity> sources, List<Entity> targets, 
        boolean functional, boolean inverseFunctional, boolean symmetric, 
        boolean asymmetric, boolean reflexive, boolean irreflexive, boolean transitive) {
        final UnreifiedRelation relation = create(UnreifiedRelation.class);
        relation.setName(name);
        relation.setFunctional(functional);
        relation.setInverseFunctional(inverseFunctional);
        relation.setSymmetric(symmetric);
        relation.setAsymmetric(asymmetric);
        relation.setReflexive(reflexive);
        relation.setIrreflexive(irreflexive);
        relation.setTransitive(transitive);
        setCrossReferences(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__SOURCES, sources);
        setCrossReferences(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__TARGETS, targets);
        vocabulary.getOwnedStatements().add(relation);
        return relation;
    }

    // Rule

    /**
     * Creates a rule and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new rule
     * @param antecedent a list of antecedent predicates of the rule
     * @param consequent a list of consequent predicates of the rule
     * @return a rule that is added to the given vocabulary
     */
    public static Rule addRule(Vocabulary vocabulary, String name, Predicate[] antecedent, Predicate[] consequent) {
        final Rule rule = create(Rule.class);
        rule.setName(name);
        rule.getAntecedent().addAll(Arrays.asList(antecedent));
        rule.getConsequent().addAll(Arrays.asList(consequent));
        vocabulary.getOwnedStatements().add(rule);
        return rule;
    }

    // BuiltIn

    /**
     * Creates a builtIn and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new builtIn
     * @return a builtIn that is added to the given vocabulary
     */
    public static BuiltIn addBuiltIn(Vocabulary vocabulary, String name) {
        final BuiltIn builtIn = create(BuiltIn.class);
        builtIn.setName(name);
        vocabulary.getOwnedStatements().add(builtIn);
        return builtIn;
    }

    // AnonymousConceptInstance

    /**
     * Creates a entity instance and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param entity the given entity that is the type of the entity instance
     * @return a entity instance that is added to the given ontology
     */
    public static AnonymousConceptInstance createAnonymousConceptInstance(Ontology ontology, Entity entity) {
        final AnonymousConceptInstance instance = create(AnonymousConceptInstance.class);
        setCrossReference(ontology, instance, OmlPackage.Literals.ANONYMOUS_CONCEPT_INSTANCE__TYPE, entity);
        return instance;
    }

    // AnonymousRelationInstance

    /**
     * Creates an anonymous relation instance and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param target the given instance that is the target of the anonymous relation instance
     * @return an anonymous relation instance that is added to the given ontology
     */
    public static AnonymousRelationInstance createAnonymousRelationInstance(Ontology ontology, NamedInstance target) {
        final AnonymousRelationInstance instance = create(AnonymousRelationInstance.class);
        setCrossReference(ontology, instance, OmlPackage.Literals.ANONYMOUS_RELATION_INSTANCE__TARGET, target);
        return instance;
    }

    // ConceptInstance

    /**
     * Creates a concept instance and adds it to the given description
     * 
     * @param description the context description
     * @param name the name of the new concept instance
     * @return a concept instance that is added to the given description
     */
    public static ConceptInstance addConceptInstance(Description description, String name) {
        final ConceptInstance instance = create(ConceptInstance.class);
        instance.setName(name);
        description.getOwnedStatements().add(instance);
        return instance;
    }

    // RelationInstance

    /**
     * Creates a relation instance and adds it to the given description
     * 
     * @param description the context description
     * @param name the name of the new relation instance
     * @param sources a given list of source instances
     * @param targets a given list of target instances
     * @return a relation instance that is added to the given description
     */
    public static RelationInstance addRelationInstance(Description description, String name, List<NamedInstance> sources, List<NamedInstance> targets) {
        final RelationInstance instance = create(RelationInstance.class);
        instance.setName(name);
        setCrossReferences(description, instance, OmlPackage.Literals.RELATION_INSTANCE__SOURCES, new ArrayList<Element>(sources));
        setCrossReferences(description, instance, OmlPackage.Literals.RELATION_INSTANCE__TARGETS, new ArrayList<Element>(targets));
        description.getOwnedStatements().add(instance);
        return instance;
    }

    // Member

    /**
     * Creates a ref to the given member
     * 
     * @param member the given member
     * @return a ref for the given member
     */
    @SuppressWarnings("unchecked")
	protected static <T extends Member> T createRef(T member) {
        if (member instanceof Aspect) {
            final var ref = create(Aspect.class);
            ref.setRef((Aspect)member);
            return (T) ref;
        } else if (member instanceof Concept) {
            final var ref = create(Concept.class);
            ref.setRef((Concept)member);
            return (T) ref;
        } else if (member instanceof RelationEntity) {
            final var ref = create(RelationEntity.class);
            ref.setRef((RelationEntity)member);
            return (T) ref;
        } else if (member instanceof Scalar) {
            final var ref = create(Scalar.class);
            ref.setRef((Scalar)member);
            return (T) ref;
        } else if (member instanceof AnnotationProperty) {
            final var ref = create(AnnotationProperty.class);
            ref.setRef((AnnotationProperty)member);
            return (T) ref;
        } else if (member instanceof ScalarProperty) {
            final var ref = create(ScalarProperty.class);
            ref.setRef((ScalarProperty)member);
            return (T) ref;
        } else if (member instanceof Relation) {
            final var ref = create(UnreifiedRelation.class);
            ref.setRef((Relation)member);
            return (T) ref;
        } else if (member instanceof Rule) {
            final var ref = create(Rule.class);
            ref.setRef((Rule)member);
            return (T) ref;
        } else if (member instanceof ConceptInstance) {
            final var ref = create(ConceptInstance.class);
            ref.setRef((ConceptInstance)member);
            return (T) ref;
        } else if (member instanceof RelationInstance) {
            final var ref = create(RelationInstance.class);
            ref.setRef((RelationInstance)member);
            return (T) ref;
        }
        return null;
    }
    
    // Import
    
    /**
     * Creates an import and adds it to the given ontology
     * 
     * @param ontology the importing ontology
     * @param kind the kind of import
     * @param namespace the namespace of the imported ontology
     * @param prefix the prefix of the imported ontology (optional)
     * @return an import that is added to the importing ontology
     */
    public static Import addImport(Ontology ontology, ImportKind kind, String namespace, String prefix) {
        final Import import_ = create(Import.class);
        import_.setKind(kind);
        import_.setNamespace(namespace);
        import_.setPrefix(prefix);
        ontology.getOwnedImports().add(import_);
        return import_;
    }

    /**
     * Creates an import to a given ontology and adds it to a context ontology
     * 
     * @param ontology The importing ontology
     * @param importedOntology The imported ontology
     */
    public static void addImport(Ontology ontology, Ontology importedOntology) {
    	var namespace = importedOntology.getNamespace();
    	var prefix = importedOntology.getPrefix();
    	
		if (ontology instanceof Vocabulary) {
			if (importedOntology instanceof Vocabulary) {
				addImport(ontology, ImportKind.EXTENSION, namespace, prefix);
			} else if (importedOntology instanceof Description){
				addImport(ontology, ImportKind.USAGE, namespace, prefix);
			}
		} else if (ontology instanceof Description) {
			if (importedOntology instanceof Description) {
				addImport(ontology, ImportKind.EXTENSION, namespace, prefix);
			} else if (importedOntology instanceof Vocabulary){
				addImport(ontology, ImportKind.USAGE, namespace, prefix);
			}
		} else if (ontology instanceof VocabularyBundle) {
			if (importedOntology instanceof VocabularyBundle) {
				addImport(ontology, ImportKind.EXTENSION, namespace, prefix);
			} else if (importedOntology instanceof Vocabulary) {
				addImport(ontology, ImportKind.INCLUSION, namespace, prefix);
			}
		} else if (ontology instanceof DescriptionBundle){
			if (importedOntology instanceof DescriptionBundle) {
				addImport(ontology, ImportKind.EXTENSION, namespace, prefix);
			} else if (ontology instanceof Description) {
				addImport(ontology, ImportKind.INCLUSION, namespace, prefix);
			} else if (importedOntology instanceof VocabularyBundle) {
				addImport(ontology, ImportKind.USAGE, namespace, prefix);
			}
		}
    }
    
	// SpecializationAxiom

    /**
     * Creates a specialization axiom between two terms and adds it to the given vocabulary
     *  
     * @param vocabulary the context vocabulary
     * @param subTerm the given sub term
     * @param superTerm the given super term
     * @return a specialization axiom that is added to the vocabulary
     */
    public static SpecializationAxiom addSpecializationAxiom(Vocabulary vocabulary, Term subTerm, Term superTerm) {
        if (subTerm != null && !(subTerm instanceof SpecializableTerm)) {
        	// e.g. forward relation or reverse relation as sub terms
        	subTerm = (SpecializableTerm) getOrAddRef(vocabulary, subTerm);
        }
        final SpecializationAxiom axiom = create(SpecializationAxiom.class);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM, superTerm);
        setContainmentReference(vocabulary, subTerm, OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS, axiom);
        return axiom;
    }
    
    // EntityEquivalenceAxiom

    /**
     * Creates a entity equivalence axiom between the sub entity and super entities and adds it to the given vocabulary
     *  
     * @param vocabulary the context vocabulary
     * @param subEntity the given sub entity
     * @param superEntities the given super entities
     * @return a entity equivalence axiom that is added to the vocabulary
     */
    public static EntityEquivalenceAxiom addEntityEquivalenceAxiom(Vocabulary vocabulary, Entity subEntity, List<Entity> superEntities) {
        final EntityEquivalenceAxiom axiom = create(EntityEquivalenceAxiom.class);
        setCrossReferences(vocabulary, axiom, OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES, superEntities);
        setContainmentReference(vocabulary, subEntity, OmlPackage.Literals.ENTITY__OWNED_EQUIVALENCES, axiom);
        return axiom;
    }

    // ScalarEquivalenceAxiom

    /**
     * Creates a scalar equivalence axiom between the sub scalar and super scalar and adds it to the given vocabulary
     *  
     * @param vocabulary the context vocabulary
     * @param subScalar the given sub scalar
     * @param superScalar the given super scalar
     * @param length the length facet
     * @param minLength the min length facet
     * @param maxLength the max length facet
     * @param pattern the string pattern facet
     * @param language the language facet
     * @param minInclusive the min inclusive facet
     * @param minExclusive the min exclusive facet
     * @param maxInclusive the max inclusive facet
     * @param maxExclusive the max exclusive facet
     * @return a scalar equivalence axiom that is added to the vocabulary
     */
    public static ScalarEquivalenceAxiom addScalarEquivalenceAxiom(Vocabulary vocabulary, Scalar subScalar, Scalar superScalar, Integer length, Integer minLength, Integer maxLength, String pattern, 
        String language, Literal minInclusive, Literal minExclusive, Literal maxInclusive, Literal maxExclusive) {
        final ScalarEquivalenceAxiom axiom = create(ScalarEquivalenceAxiom.class);
        axiom.setLength(length);
        axiom.setMinLength(minLength);
        axiom.setMaxLength(maxLength);
        axiom.setPattern(pattern);
        axiom.setLanguage(language);
        axiom.setMinInclusive(minInclusive);
        axiom.setMinExclusive(minExclusive);
        axiom.setMaxInclusive(maxInclusive);
        axiom.setMaxExclusive(maxExclusive);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR, superScalar);
        setContainmentReference(vocabulary, subScalar, OmlPackage.Literals.SCALAR__OWNED_EQUIVALENCES, axiom);
        return axiom;
    }

    // PropertyEquivalenceAxiom

    /**
     * Creates a property equivalence axiom between the sub property and super property and adds it to the given vocabulary
     *  
     * @param vocabulary the context vocabulary
     * @param subProperty the given sub property
     * @param superProperty the given super property
     * @return a property equivalence axiom that is added to the vocabulary
     */
    public static PropertyEquivalenceAxiom addPropertyEquivalenceAxiom(Vocabulary vocabulary, SpecializableProperty subProperty, Property superProperty) {
        final PropertyEquivalenceAxiom axiom = create(PropertyEquivalenceAxiom.class);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY, superProperty);
        setContainmentReference(vocabulary, subProperty, OmlPackage.Literals.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES, axiom);
        return axiom;
    }

    // PropertyRangeRestrictionAxiom

    /**
     * Creates a property range restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (entity or entity equivalence axiom)
     * @param property the given semantic property
     * @param range given restricted range
     * @param restrictionKind the kind of the restriction
     * @return a property range restriction axiom that is added to the given vocabulary
     */
    public static PropertyRangeRestrictionAxiom addPropertyRangeRestrictionAxiom(Vocabulary vocabulary, Element owner, SemanticProperty property, Type range, RangeRestrictionKind restrictionKind) {
        final PropertyRangeRestrictionAxiom axiom = create(PropertyRangeRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, range);
        if (owner instanceof Entity) {
        	setContainmentReference(vocabulary, (Entity)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof EntityEquivalenceAxiom) {
            	setContainmentReference(vocabulary, (EntityEquivalenceAxiom)owner, OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    // PropertyCardinalityRestrictionAxiom

    /**
     * Creates a property cardinality restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (entity or entity equivalence axiom)
     * @param property the given semantic property
     * @param cardinality the restricted cardinality
     * @param range given restricted range
     * @param restrictionKind the kind of the restriction
     * @return a property cardinality restriction axiom that is added to the given vocabulary
     */
    public static PropertyCardinalityRestrictionAxiom addPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, Element owner, SemanticProperty property, CardinalityRestrictionKind restrictionKind, int cardinality, Type range) {
        final PropertyCardinalityRestrictionAxiom axiom = create(PropertyCardinalityRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        axiom.setCardinality(cardinality);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, range);
        if (owner instanceof Entity) {
        	setContainmentReference(vocabulary, (Entity)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof EntityEquivalenceAxiom) {
            	setContainmentReference(vocabulary, (EntityEquivalenceAxiom)owner, OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    // PropertyValueRestrictionAxiom

    /**
     * Creates a property value restriction axiom on a scalar property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (entity or entity equivalence axiom)
     * @param property the given semantic property
     * @param value the restricted literal value
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public static PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, Element owner, SemanticProperty property, Literal value) {
        final PropertyValueRestrictionAxiom axiom = create(PropertyValueRestrictionAxiom.class);
        axiom.setLiteralValue(value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        if (owner instanceof Entity) {
        	setContainmentReference(vocabulary, (Entity)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof EntityEquivalenceAxiom) {
            	setContainmentReference(vocabulary, (EntityEquivalenceAxiom)owner, OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    /**
     * Creates a property value restriction axiom on a property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (entity or entity equivalence axiom)
     * @param property the given semantic property
     * @param value the restricted entity instance value
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public static PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, Element owner, SemanticProperty property, AnonymousInstance value) {
        final PropertyValueRestrictionAxiom axiom = create(PropertyValueRestrictionAxiom.class);
        axiom.setContainedValue(value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        if (owner instanceof Entity) {
        	setContainmentReference(vocabulary, (Entity)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof EntityEquivalenceAxiom) {
            	setContainmentReference(vocabulary, (EntityEquivalenceAxiom)owner, OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    /**
     * Creates a value restriction axiom on a relation and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (entity or entity equivalence axiom)
     * @param property the given semantic property
     * @param value the restricted named instance value
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public static PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, Element owner, SemanticProperty property, NamedInstance value) {
        final PropertyValueRestrictionAxiom axiom = create(PropertyValueRestrictionAxiom.class);
        axiom.setReferencedValue(value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        if (owner instanceof Entity) {
        	setContainmentReference(vocabulary, (Entity)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof EntityEquivalenceAxiom) {
            setContainmentReference(vocabulary, (EntityEquivalenceAxiom)owner, OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    // PropertySelfRestrictionAxiom

    /**
     * Creates a self restriction axiom on a relation and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (entity or entity equivalence axiom)
     * @param relation the given relation
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public static PropertySelfRestrictionAxiom addPropertySelfRestrictionAxiom(Vocabulary vocabulary, Element owner, Relation relation) {
        final PropertySelfRestrictionAxiom axiom = create(PropertySelfRestrictionAxiom.class);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, relation);
        if (owner instanceof Entity) {
        	setContainmentReference(vocabulary, (Entity)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof EntityEquivalenceAxiom) {
            setContainmentReference(vocabulary, (EntityEquivalenceAxiom)owner, OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    // KeyAxiom

    /**
     * Creates a key axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given keyed (entity) domain
     * @param keyProperties the list of properties that are part of the key
     * @return a key axiom that is added to the given vocabulary
     */
    public static KeyAxiom addKeyAxiom(Vocabulary vocabulary, Entity domain, List<Property> keyProperties) {
        final KeyAxiom axiom = create(KeyAxiom.class);
        setCrossReferences(vocabulary, axiom, OmlPackage.Literals.KEY_AXIOM__PROPERTIES, new ArrayList<Element>(keyProperties));
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.ENTITY__OWNED_KEYS, axiom);
        return axiom;
    }

    // InstanceEnumerationAxiom

    /**
     * Creates an instance enumeration axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given (concept) domain
     * @param instances the list of concept instances
     * @return an instance enumeration axiom that is added to the given vocabulary
     */
    public static InstanceEnumerationAxiom addInstanceEnumerationAxiom(Vocabulary vocabulary, Concept domain, List<ConceptInstance> instances) {
        final InstanceEnumerationAxiom axiom = create(InstanceEnumerationAxiom.class);
        setCrossReferences(vocabulary, axiom, OmlPackage.Literals.INSTANCE_ENUMERATION_AXIOM__INSTANCES, new ArrayList<Element>(instances));
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.CONCEPT__OWNED_ENUMERATION, axiom);
        return axiom;
    }

    // LiteralEnumerationAxiom

    /**
     * Creates an literal enumeration axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given (scalar) domain
     * @param literals the list of enumerated literals
     * @return a literal enumeration axiom that is added to the given vocabulary
     */
    public static LiteralEnumerationAxiom addLiteralEnumerationAxiom(Vocabulary vocabulary, Scalar domain, Literal...literals) {
        final LiteralEnumerationAxiom axiom = create(LiteralEnumerationAxiom.class);
        axiom.getLiterals().addAll(Arrays.asList(literals));
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.SCALAR__OWNED_ENUMERATION, axiom);
        return axiom;
    }

    // TypeAssertion
    
    /**
     * Creates a type assertion and adds it to the given description
     * 
     * @param description the context description
     * @param instance the given named instance
     * @param type the given type
     * @return a type assertion that is added to the given description
     */
    public static TypeAssertion addTypeAssertion(Description description, NamedInstance instance, Entity type) {
        final TypeAssertion assertion = create(TypeAssertion.class);
        setCrossReference(description, assertion, OmlPackage.Literals.TYPE_ASSERTION__TYPE, type);
        setContainmentReference(description, instance, OmlPackage.Literals.NAMED_INSTANCE__OWNED_TYPES, assertion);
        return assertion;
    }

    // PropertyValueAssertion

    /**
     * Creates a property value assertion for literal values and adds it to the given ontology.
     * 
     * @param ontology the context ontology
     * @param instance the given instance
     * @param property the given semantic property
     * @param literalValues the asserted (literal) values of the property
     * @return a property value assertion that is added to the given ontology
     */
    public static PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, Instance instance, SemanticProperty property, Literal...literalValues) {
        final PropertyValueAssertion assertion = create(PropertyValueAssertion.class);
       	assertion.getLiteralValue().addAll(Arrays.asList(literalValues));
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, property);
        setContainmentReference(ontology, instance, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }
        
    /**
     * Creates a property value assertion for anonymous instances and adds it to the given ontology.
     * 
     * If an anonymous relation instance is given then the property must be a relation owned by a relation entity
     * 
     * @param ontology the context ontology
     * @param instance the given instance
     * @param property the given semantic property
     * @param containedeValues the asserted contained values of the property
     * @return a property value assertion that is added to the given ontology
     */
    public static PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, Instance instance, SemanticProperty property, AnonymousInstance...containedeValues) {
        final PropertyValueAssertion assertion = create(PropertyValueAssertion.class);
       	assertion.getContainedValue().addAll(Arrays.asList(containedeValues));
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, property);
        setContainmentReference(ontology, instance, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }

    /**
     * Creates a property value assertion for named instances and adds it to the given ontology.
     * 
     * @param ontology the context ontology
     * @param instance the given instance
     * @param property the given semantic property
     * @param referencedValues the asserted referenced values of the property
     * @return a property value assertion that is added to the given ontology
     */
    public static PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, Instance instance, SemanticProperty property, NamedInstance...referencedValues) {
        final PropertyValueAssertion assertion = create(PropertyValueAssertion.class);
       	assertion.getReferencedValue().addAll(Arrays.asList(referencedValues));
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, property);
        setContainmentReference(ontology, instance, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }

    // Argument

    /**
     * Creates an argument
     * 
     * @param vocabulary the context vocabulary
     * @param variable a given variable name
     * @param literal a given literal
     * @param instance a given named instance
     * @return an argument
     */
    public static Argument createArgument(Vocabulary vocabulary, String variable, Literal literal, NamedInstance instance) {
        final Argument argument = create(Argument.class);
        argument.setVariable(variable);
        argument.setLiteral(literal);
        setCrossReference(vocabulary, argument, OmlPackage.Literals.ARGUMENT__INSTANCE, instance);
        return argument;
    }

    // TypePredicate

    /**
     * Creates a type predicate
     * 
     * @param vocabulary the context vocabulary
     * @param type the given type
     * @param argument the argument bound to a value of the type
     * @return a type predicate
     */
    public static TypePredicate createTypePredicate(Vocabulary vocabulary, Type type, Argument argument) {
        final TypePredicate predicate = create(TypePredicate.class);
        predicate.setArgument(argument);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.TYPE_PREDICATE__TYPE, type);
        return predicate;
    }
    
    // RelationEntityPredicate

    /**
     * Creates an relation entity predicate
     * 
     * @param vocabulary the context vocabulary
     * @param type the type of a relation instance
     * @param argument1 the argument bound to a named instance representing the source of a relation instance
     * @param argument the argument bound to a relation instance
     * @param argument2 the argument bound to a named instance representing the target of a relation instance
     * @return a relation entity predicate
     */
    public static RelationEntityPredicate createRelationEntityPredicate(Vocabulary vocabulary, RelationEntity type, Argument argument1, Argument argument, Argument argument2) {
        final RelationEntityPredicate predicate = create(RelationEntityPredicate.class);
        predicate.setArgument1(argument1);
        predicate.setArgument(argument);
        predicate.setArgument2(argument2);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__TYPE, type);
        return predicate;
    }

    // PropertyPredicate

    /**
     * Creates an relation predicate
     * 
     * @param vocabulary the context vocabulary
     * @param property the given property
     * @param argument1 the argument bound to a instance representing the subject of the given property
     * @param argument2 the argument bound to a value representing the object of the given property
     * @return a relation predicate
     */
    public static PropertyPredicate createPropertyPredicate(Vocabulary vocabulary, Property property, Argument argument1, Argument argument2) {
        final PropertyPredicate predicate = create(PropertyPredicate.class);
        predicate.setArgument1(argument1);
        predicate.setArgument2(argument2);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.PROPERTY_PREDICATE__PROPERTY, property);
        return predicate;
    }

    // SameAsPredicate

    /**
     * Creates a sameAs predicate
     * 
     * @param vocabulary the context vocabulary
     * @param argument1 the argument bound to the first named instance
     * @param argument2 the argument bound to the second named instance
     * @return a sameAs predicate
     */
    public static SameAsPredicate createSameAsPredicate(Vocabulary vocabulary, Argument argument1, Argument argument2) {
        final SameAsPredicate predicate = create(SameAsPredicate.class);
        predicate.setArgument1(argument1);
        predicate.setArgument2(argument2);
        return predicate;
    }

    // DifferentFromPredicate

    /**
     * Creates a differentFrom predicate
     * 
     * @param vocabulary the context vocabulary
     * @param argument1 the argument bound to the first named instance
     * @param argument2 the argument bound to the second named instance
     * @return a differentFrom predicate
     */
    public static DifferentFromPredicate createDifferentFromPredicate(Vocabulary vocabulary, Argument argument1, Argument argument2) {
        final DifferentFromPredicate predicate = create(DifferentFromPredicate.class);
        predicate.setArgument1(argument1);
        predicate.setArgument2(argument2);
        return predicate;
    }

    // BuiltInPredicate

    /**
     * Creates a builtIn predicate
     * 
     * @param vocabulary the context vocabulary
     * @param builtIn the given builtIn
     * @param arguments the arguments of the builtin
     * @return a builtIn predicate
     */
    public static BuiltInPredicate createBuiltInPredicate(Vocabulary vocabulary, BuiltIn builtIn, Argument... arguments ) {
        final BuiltInPredicate predicate = create(BuiltInPredicate.class);
        predicate.setBuiltIn(builtIn);
        predicate.getArguments().addAll(Arrays.asList(arguments));
        return predicate;
    }

    // Literal

    /**
     * Creates a literal from the given lexical value in the given ontology
     * 
     * @param value the lexical value of the literal
     * @return a literal with the given value
     */
    public static Literal createLiteral(Object value) {
        if (value instanceof Boolean) {
            return createBooleanLiteral((Boolean)value);
        } else if (value instanceof Double) {
            return createDoubleLiteral((Double)value);
        } else if (value instanceof BigDecimal) {
            return createDecimalLiteral((BigDecimal)value);
        } else if (value instanceof Integer) {
            return createIntegerLiteral((Integer)value);
        } else {
            return createQuotedLiteral(null, value.toString(), null, null);
        }
    }

    // QuotedLiteral

    /**
     * Creates a quoted literal in the given ontology
     * 
     * @param ontology the ontology context
     * @param value the lexical value of the literal
     * @param type the given (scalar) type of the literal (optional)
     * @param langTag the language tag of the literal (optional)
     * @return a quoted literal
     */
    public static QuotedLiteral createQuotedLiteral(Ontology ontology, String value, Scalar type, String langTag) {
        final QuotedLiteral literal = create(QuotedLiteral.class);
        literal.setValue(value);
        if (type != null) {
            setCrossReference(ontology, literal, OmlPackage.Literals.QUOTED_LITERAL__TYPE, type);
        } else if (langTag != null) {
            literal.setLangTag(langTag);
        }
        return literal;
    }

    // IntegerLiteral

    /**
     * Creates an integer literal
     * 
     * @param value the integer value of the literal
     * @return an integer literal
     */
    public static IntegerLiteral createIntegerLiteral(int value) {
        final IntegerLiteral literal = create(IntegerLiteral.class);
        literal.setValue(value);
        return literal;
    }
        
    // DecimalLiteral

    /**
     * Creates a decimal literal
     * 
     * @param value the big decimal value of the literal
     * @return a decimal literal
     */
    public static DecimalLiteral createDecimalLiteral(BigDecimal value) {
        final DecimalLiteral literal = create(DecimalLiteral.class);
        literal.setValue(value);
        return literal;
    }

    // DoubleLiteral

    /**
     * Creates a double literal
     * 
     * @param value the double value of the literal
     * @return a double literal
     */
    public static DoubleLiteral createDoubleLiteral(double value) {
        final DoubleLiteral literal = create(DoubleLiteral.class);
        literal.setValue(value);
        return literal;
    }

    // BooleanLiteral
    
    /**
     * Creates an boolean literal
     * 
     * @param value the boolean value of the literal
     * @return a boolean literal
     */
    public static BooleanLiteral createBooleanLiteral( boolean value) {
        final BooleanLiteral literal = create(BooleanLiteral.class);
        literal.setValue(value);
        return literal;
    }
        
}