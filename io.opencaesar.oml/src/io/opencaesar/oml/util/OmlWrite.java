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
import io.opencaesar.oml.Argument;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.BuiltIn;
import io.opencaesar.oml.BuiltInPredicate;
import io.opencaesar.oml.CardinalityRestrictionKind;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierEquivalenceAxiom;
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
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
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
    @SuppressWarnings("unchecked")
    protected static void setCrossReference(Ontology ontology, Element subject, EReference eRef, IdentifiedElement object) {
        final Class<? extends IdentifiedElement> objectClass = (Class<? extends IdentifiedElement>) eRef.getEType().getInstanceClass();
        assert !eRef.isContainment() : eRef.getName()+" is a containment reference";
        assert !eRef.isMany() : eRef.getName()+" is a List reference";
        assert IdentifiedElement.class.isAssignableFrom(objectClass) : eRef.getName()+" is not typed by an identified element";
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
    @SuppressWarnings("unchecked")
    protected static void setCrossReferences(Ontology ontology, Element subject, EReference eRef, List<? extends Element> objects) {
        final Class<? extends Element> objectClass = (Class<? extends Element>) eRef.getEType().getInstanceClass();
        assert !eRef.isContainment() : eRef.getName()+" is a containment reference";
        assert eRef.isMany() : eRef.getName()+" is a singular reference";
        assert Element.class.isAssignableFrom(objectClass) : eRef.getName()+" is not typed by an Oml element";
        subject.eSet(eRef, objects);
    }
    
    /**
     * Sets the given object to be contained by the given subject in the context of the given ontology
     * 
     * @param ontology the given ontology
     * @param subject the given subject
     * @param elementERef the containment eRef to use on subject if it belongs to the given ontology
     * @param object the given object 
     */
    @SuppressWarnings("unchecked")
    protected static void setContainmentReference(Ontology ontology, Element subject, EReference elementERef, Element object) {
        final Class<? extends Element> objectClass = (Class<? extends Element>) elementERef.getEType().getInstanceClass();
        assert elementERef.isContainment() : elementERef.getName()+" is not a containment reference";
        assert objectClass.isInstance(object) : object+" is not an instance of "+objectClass.getName();
        assert elementERef.getEType() == elementERef.getEType() : elementERef.getName()+" does not have the same type as "+elementERef.getName();
        if (object != null && subject != null) {
            if (subject.getOntology() == ontology) {
                ((List<Element>)subject.eGet(elementERef)).add(object);
            } else if (subject instanceof Member){
                ((List<Element>)getOrAddReference(ontology, (Member)subject).eGet(elementERef)).add(object);
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
     * Gets an existing or creates a new reference to the given member in the context of the given ontology
     *  
     * @param ontology the context ontology
     * @param member the given member
     * @return a reference to the given member in the context of the given ontology
     */
    protected static Member getOrAddReference(Ontology ontology, Member member) {
        Member reference = OmlRead.getReferences(ontology).stream().filter(i -> i.getRef() == member).findFirst().orElse(null);
        if (reference == null) {
            reference = createReference(member);
            if (ontology instanceof Vocabulary) {
                ((Vocabulary) ontology).getOwnedStatements().add((VocabularyStatement) reference);
            } else if (ontology instanceof Description) {
                ((Description) ontology).getOwnedStatements().add((DescriptionStatement) reference); 
            }
        }
        return reference;
    }

    // ------------------------------------------------------------------------------------
    
    // Annotation

    /**
     * Adds a new annotation with either a literal or reference value (but not both) on a given ontology
     * 
     * @param ontology the ontology to annotate
     * @param property the given annotation property
     * @param literalValue the annotation literal value
     * @param referenceValue the annotation reference value
     * @return a new annotation on the given ontology
     */
    public static Annotation addAnnotation(Ontology ontology, AnnotationProperty property, Literal literalValue, Member referenceValue) {
        final Annotation annotation = create(Annotation.class);
        if (literalValue != null)
        	annotation.setLiteralValue(literalValue);
        else if (referenceValue != null)
        	annotation.setReferenceValue(referenceValue);
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, property);
        ontology.getOwnedAnnotations().add(annotation);
        return annotation;
    }

    /**
     * Adds a new annotation with either a literal or reference value (but not both) on a given element in the context of a given ontology
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param element the annotated element to put the annotation on
     * @param property the given annotation property
     * @param literalValue the annotation literal value
     * @param referenceValue the annotation reference value
     * @return a new annotation on the given member in the context of the given ontology
     */
    public static Annotation addAnnotation(Ontology ontology, IdentifiedElement element, AnnotationProperty property, Literal literalValue, Member referenceValue) {
        final Annotation annotation = create(Annotation.class);
        if (literalValue != null)
        	annotation.setLiteralValue(literalValue);
        else if (referenceValue != null)
        	annotation.setReferenceValue(referenceValue);
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

    // Structure

    /**
     * Creates a new structure and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new structure
     * @return a new structure that is added to the given vocabulary
     */
    public static Structure addStructure(Vocabulary vocabulary, String name) {
        final Structure structure = create(Structure.class);
        structure.setName(name);
        vocabulary.getOwnedStatements().add(structure);
        return structure;
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
     * @param domains the given list of domain classifiers
     * @param ranges the given list of range scalars
     * @param functional whether the scalar property is functional
     * @return a new scalar property that is added to the given vocabulary
     */
    public static ScalarProperty addScalarProperty(Vocabulary vocabulary, String name,
        List<Classifier> domains, List<Scalar> ranges, boolean functional) {
        final ScalarProperty property = create(ScalarProperty.class);
        property.setName(name);
        property.setFunctional(functional);
        setCrossReferences(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__DOMAINS, domains);
        setCrossReferences(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__RANGES, ranges);
        vocabulary.getOwnedStatements().add(property);
        return property;
    }
    
    // StructuredProperty

    /**
     * Creates a new structured property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new structured property
     * @param domains the given list of domain classifiers
     * @param ranges the given list of target structures
     * @param functional whether the structured property is functional
     * @return a new structured property that is added to the given vocabulary
     */
    public static StructuredProperty addStructuredProperty(Vocabulary vocabulary, String name, 
        List<Classifier> domains, List<Structure> ranges, boolean functional) {
        final StructuredProperty property = create(StructuredProperty.class);
        property.setName(name);
        property.setFunctional(functional);
        setCrossReferences(vocabulary, property, OmlPackage.Literals.STRUCTURED_PROPERTY__DOMAINS, domains);
        setCrossReferences(vocabulary, property, OmlPackage.Literals.STRUCTURED_PROPERTY__RANGES, ranges);
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
     * @param consequent a list of consequent predicates of the rule
     * @param antecedent a list of antecedent predicates of the rule
     * @return a rule that is added to the given vocabulary
     */
    public static Rule addRule(Vocabulary vocabulary, String name, Predicate[] consequent, Predicate[] antecedent) {
        final Rule rule = create(Rule.class);
        rule.setName(name);
        rule.getConsequent().addAll(Arrays.asList(consequent));
        rule.getAntecedent().addAll(Arrays.asList(antecedent));
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

    // StructureInstance

    /**
     * Creates a structure instance and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param structure the given structure that is the type of the structure instance
     * @return a structure instance that is added to the given ontology
     */
    public static StructureInstance createStructureInstance(Ontology ontology, Structure structure) {
        final StructureInstance instance = create(StructureInstance.class);
        setCrossReference(ontology, instance, OmlPackage.Literals.STRUCTURE_INSTANCE__TYPE, structure);
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
     * Creates a reference for the given member
     * 
     * @param member the given member
     * @return a reference for the given member
     */
    @SuppressWarnings("unchecked")
	protected static <T extends Member> T createReference(T member) {
        if (member instanceof Aspect) {
            final var reference = create(Aspect.class);
            reference.setRef((Aspect)member);
            return (T) reference;
        } else if (member instanceof Concept) {
            final var reference = create(Concept.class);
            reference.setRef((Concept)member);
            return (T) reference;
        } else if (member instanceof RelationEntity) {
            final var reference = create(RelationEntity.class);
            reference.setRef((RelationEntity)member);
            return (T) reference;
        } else if (member instanceof Structure) {
            final var reference = create(Structure.class);
            reference.setRef((Structure)member);
            return (T) reference;
        } else if (member instanceof Scalar) {
            final var reference = create(Scalar.class);
            reference.setRef((Scalar)member);
            return (T) reference;
        } else if (member instanceof AnnotationProperty) {
            final var reference = create(AnnotationProperty.class);
            reference.setRef((AnnotationProperty)member);
            return (T) reference;
        } else if (member instanceof ScalarProperty) {
            final var reference = create(ScalarProperty.class);
            reference.setRef((ScalarProperty)member);
            return (T) reference;
        } else if (member instanceof StructuredProperty) {
            final var reference = create(StructuredProperty.class);
            reference.setRef((StructuredProperty)member);
            return (T) reference;
        } else if (member instanceof Relation) {
            final var reference = create(UnreifiedRelation.class);
            reference.setRef((Relation)member);
            return (T) reference;
        } else if (member instanceof Rule) {
            final var reference = create(Rule.class);
            reference.setRef((Rule)member);
            return (T) reference;
        } else if (member instanceof ConceptInstance) {
            final var reference = create(ConceptInstance.class);
            reference.setRef((ConceptInstance)member);
            return (T) reference;
        } else if (member instanceof RelationInstance) {
            final var reference = create(RelationInstance.class);
            reference.setRef((RelationInstance)member);
            return (T) reference;
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

    // SpecializationAxiom

    /**
     * Creates a specialization axiom between two terms and adds it to the given vocabulary
     *  
     * @param vocabulary the context vocabulary
     * @param subTerm the given sub term
     * @param superTerm the given super term
     * @return a specialization axiom that is added to the vocabulary
     */
    public static SpecializationAxiom addSpecializationAxiom(Vocabulary vocabulary, SpecializableTerm subTerm, SpecializableTerm superTerm) {
        final SpecializationAxiom axiom = create(SpecializationAxiom.class);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM, superTerm);
        setContainmentReference(vocabulary, subTerm, OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS, axiom);
        return axiom;
    }
    
    // ClassifierEquivalenceAxiom

    /**
     * Creates a classifier equivalence axiom between the sub classifier and super classifiers and adds it to the given vocabulary
     *  
     * @param vocabulary the context vocabulary
     * @param subClassifier the given sub classifier
     * @param superClassifiers the given super classifiers
     * @return a classifier equivalence axiom that is added to the vocabulary
     */
    public static ClassifierEquivalenceAxiom addClassifierEquivalenceAxiom(Vocabulary vocabulary, Classifier subClassifier, List<Classifier> superClassifiers) {
        final ClassifierEquivalenceAxiom axiom = create(ClassifierEquivalenceAxiom.class);
        setCrossReferences(vocabulary, axiom, OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS, superClassifiers);
        setContainmentReference(vocabulary, subClassifier, OmlPackage.Literals.CLASSIFIER__OWNED_EQUIVALENCES, axiom);
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
    public static ScalarEquivalenceAxiom addScalarEquivalenceAxiom(Vocabulary vocabulary, Scalar subScalar, Scalar superScalar, Long length, Long minLength, Long maxLength, String pattern, 
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
     * @param owner the given restricting owner (classifier or classifier equivalence axiom)
     * @param property the given restricted property
     * @param range given restricted range
     * @param restrictionKind the kind of the restriction
     * @return a property range restriction axiom that is added to the given vocabulary
     */
    public static PropertyRangeRestrictionAxiom addPropertyRangeRestrictionAxiom(Vocabulary vocabulary, Element owner, SemanticProperty property, Type range, RangeRestrictionKind restrictionKind) {
        final PropertyRangeRestrictionAxiom axiom = create(PropertyRangeRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, range);
        if (owner instanceof Classifier) {
        	setContainmentReference(vocabulary, (Classifier)owner, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof ClassifierEquivalenceAxiom) {
            	setContainmentReference(vocabulary, (ClassifierEquivalenceAxiom)owner, OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    // PropertyCardinalityRestrictionAxiom

    /**
     * Creates a property cardinality restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (classifier or classifier equivalence axiom)
     * @param property the given restricted property
     * @param cardinality the restricted cardinality
     * @param range given restricted range
     * @param restrictionKind the kind of the restriction
     * @return a property cardinality restriction axiom that is added to the given vocabulary
     */
    public static PropertyCardinalityRestrictionAxiom addPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, Element owner, SemanticProperty property, CardinalityRestrictionKind restrictionKind, long cardinality, Type range) {
        final PropertyCardinalityRestrictionAxiom axiom = create(PropertyCardinalityRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        axiom.setCardinality(cardinality);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, range);
        if (owner instanceof Classifier) {
        	setContainmentReference(vocabulary, (Classifier)owner, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof ClassifierEquivalenceAxiom) {
            	setContainmentReference(vocabulary, (ClassifierEquivalenceAxiom)owner, OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    // PropertyValueRestrictionAxiom

    /**
     * Creates a property value restriction axiom on a scalar property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (classifier or classifier equivalence axiom)
     * @param property the given scalar property
     * @param value the restricted literal value
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public static PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, Element owner, ScalarProperty property, Literal value) {
        final PropertyValueRestrictionAxiom axiom = create(PropertyValueRestrictionAxiom.class);
        axiom.setLiteralValue(value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        if (owner instanceof Classifier) {
        	setContainmentReference(vocabulary, (Classifier)owner, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof ClassifierEquivalenceAxiom) {
            	setContainmentReference(vocabulary, (ClassifierEquivalenceAxiom)owner, OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    /**
     * Creates a property value restriction axiom on a structured property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (classifier or classifier equivalence axiom)
     * @param property the given structured property
     * @param value the restricted structure instance value
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public static PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, Element owner, StructuredProperty property, StructureInstance value) {
        final PropertyValueRestrictionAxiom axiom = create(PropertyValueRestrictionAxiom.class);
        axiom.setStructureInstanceValue(value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        if (owner instanceof Classifier) {
        	setContainmentReference(vocabulary, (Classifier)owner, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof ClassifierEquivalenceAxiom) {
            	setContainmentReference(vocabulary, (ClassifierEquivalenceAxiom)owner, OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    /**
     * Creates a value restriction axiom on a relation and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (classifier or classifier equivalence axiom)
     * @param relation the given relation
     * @param value the restricted named instance value
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public static PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, Element owner, Relation relation, NamedInstance value) {
        final PropertyValueRestrictionAxiom axiom = create(PropertyValueRestrictionAxiom.class);
        axiom.setNamedInstanceValue(value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, relation);
        if (owner instanceof Classifier) {
        	setContainmentReference(vocabulary, (Classifier)owner, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof ClassifierEquivalenceAxiom) {
            setContainmentReference(vocabulary, (ClassifierEquivalenceAxiom)owner, OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
        }
        return axiom;
    }

    // PropertySelfRestrictionAxiom

    /**
     * Creates a self restriction axiom on a relation and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param owner the given restricting owner (classifier or classifier equivalence axiom)
     * @param relation the given relation
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public static PropertySelfRestrictionAxiom addPropertySelfRestrictionAxiom(Vocabulary vocabulary, Element owner, Relation relation) {
        final PropertySelfRestrictionAxiom axiom = create(PropertySelfRestrictionAxiom.class);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, relation);
        if (owner instanceof Classifier) {
        	setContainmentReference(vocabulary, (Classifier)owner, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, axiom);
        } else if (owner instanceof ClassifierEquivalenceAxiom) {
            setContainmentReference(vocabulary, (ClassifierEquivalenceAxiom)owner, OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__OWNED_PROPERTY_RESTRICTIONS, axiom);
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
     * Creates a property value assertion for a scalar property and adds it to the given ontology.
     * 
     * @param ontology the context ontology
     * @param instance the given instance
     * @param property the given scalar property
     * @param literalValue the asserted (literal) value of the property
     * @return a property value assertion that is added to the given ontology
     */
    public static PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, Instance instance, ScalarProperty property, Literal literalValue) {
        final PropertyValueAssertion assertion = create(PropertyValueAssertion.class);
       	assertion.setLiteralValue(literalValue);
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, property);
        setContainmentReference(ontology, instance, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }
        
    /**
     * Creates a property value assertion for a structured property and adds it to the given ontology.
     * 
     * @param ontology the context ontology
     * @param instance the given instance
     * @param property the given structured property
     * @param structureInstanceValue the asserted (structure instance) value of the property
     * @return a property value assertion that is added to the given ontology
     */
    public static PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, Instance instance, StructuredProperty property, StructureInstance structureInstanceValue) {
        final PropertyValueAssertion assertion = create(PropertyValueAssertion.class);
       	assertion.setStructureInstanceValue(structureInstanceValue);
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, property);
        setContainmentReference(ontology, instance, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }

    /**
     * Creates a property value assertion for a relation and adds it to the given ontology.
     * 
     * @param ontology the context ontology
     * @param instance the given instance
     * @param relation the given relation
     * @param namedInstanceValue the asserted (named instance) value of the property
     * @return a property value assertion that is added to the given ontology
     */
    public static PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, Instance instance, Relation relation, NamedInstance namedInstanceValue) {
        final PropertyValueAssertion assertion = create(PropertyValueAssertion.class);
       	assertion.setNamedInstanceValue(namedInstanceValue);
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, relation);
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