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
import org.eclipse.emf.ecore.util.EcoreUtil;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.CardinalityRestrictionKind;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionStatement;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.Extension;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.Feature;
import io.opencaesar.oml.FeaturePredicate;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Inclusion;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.NamedInstanceReference;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RangeRestrictionKind;
import io.opencaesar.oml.Reference;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.RelationTargetRestrictionAxiom;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom;
import io.opencaesar.oml.SeparatorKind;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyReference;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.Usage;
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
    protected static void setCrossReferences(Ontology ontology, Element subject, EReference eRef, List<Element> objects) {
        final Class<? extends Element> objectClass = (Class<? extends Element>) eRef.getEType().getInstanceClass();
        assert !eRef.isContainment() : eRef.getName()+" is a containment reference";
        assert eRef.isMany() : eRef.getName()+" is a singular reference";
        assert Element.class.isAssignableFrom(objectClass) : eRef.getName()+" is not typed by an Oml element";
        subject.eSet(eRef, objects);
    }
    
    /**
     * Sets the given object to be contained by the given subject in the context of the given ontology
     * 
     * If the subject is a member of the given ontology; then the given member eRef will be used as the containment eRef
     * otherwise a reference to the subject is created (or retrieved) first in the ontology, then the given reference eRef will be used 
     * as the containment eRef. 
     * 
     * @param ontology the given ontology
     * @param subject the given subject
     * @param elementERef the containment eRef to use on subject if it belongs to the given ontology
     * @param referenceERef the containment eRef to use on subject if the subject does not belong to the given ontology
     * @param object the given object 
     */
    @SuppressWarnings("unchecked")
    protected static void setContainmentReference(Ontology ontology, Element subject, EReference elementERef, EReference referenceERef, Element object) {
        final Class<? extends Element> objectClass = (Class<? extends Element>) elementERef.getEType().getInstanceClass();
        assert elementERef.isContainment() : elementERef.getName()+" is not a containment reference";
        assert referenceERef.isContainment() : referenceERef.getName()+" is not a containment reference";
        assert objectClass.isInstance(object) : object+" is not an instance of "+objectClass.getName();
        assert elementERef.getEType() == referenceERef.getEType() : elementERef.getName()+" does not have the same type as "+referenceERef.getName();
        if (object != null && subject != null) {
            if (subject.getOntology() == ontology) {
                ((List<Element>)subject.eGet(elementERef)).add(object);
            } else if (subject instanceof Member){
                ((List<Element>)getOrAddReference(ontology, (Member)subject).eGet(referenceERef)).add(object);
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
    protected static Reference getOrAddReference(Ontology ontology, Member member) {
        Reference reference = OmlRead.getReferences(ontology).stream().filter(i -> OmlRead.resolve(i) == member).findFirst().orElse(null);
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
    
    // Element
    
    /**
     * Deletes the given element
     * 
     * @param element the given element to delete
     */
    public static void delete(Element element) {
        EcoreUtil.delete(element);
    }
    
    // Named Instance

    /**
     * Deletes the given instance recursively in the resource set by also deleting its 
     * referencing links and relation instances
     * 
     * @param instance the given instance
     */
    public static void deleteRecursively(NamedInstance instance) {
        for (RelationInstance ri : OmlSearch.findRelationInstancesWithTarget(instance)) {
            deleteRecursively(ri);
        };
        for (RelationInstance ri : OmlSearch.findRelationInstancesWithSource(instance)) {
            deleteRecursively(ri);
        };
        for (LinkAssertion a : OmlSearch.findLinkAssertionsWithTarget(instance)) {
            delete(a);
        };
        for (Reference r : OmlSearch.findReferences(instance)) {
            delete(r);
        };
        delete(instance);
    }
    
    // Annotation

    /**
     * Adds a new annotation on a given ontology
     * 
     * @param ontology the ontology to annotate
     * @param property the given annotation property
     * @param value the annotation literal value
     * @return a new annotation on the given ontology
     */
    public static Annotation addAnnotation(Ontology ontology, AnnotationProperty property, Literal value) {
        final Annotation annotation = create(Annotation.class);
        annotation.setValue(value);
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, property);
        ontology.getOwnedAnnotations().add(annotation);
        return annotation;
    }

    /**
     * Adds a new annotation on a given element in the context of a given ontology
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param element the annotated element to put the annotation on
     * @param property the given annotation property
     * @param value the annotation literal value
     * @return a new annotation on the given member in the context of the given ontology
     */
    public static Annotation addAnnotation(Ontology ontology, IdentifiedElement element, AnnotationProperty property, Literal value) {
        final Annotation annotation = create(Annotation.class);
        annotation.setValue(value);
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, property);
        setContainmentReference(ontology, element, OmlPackage.Literals.IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS, OmlPackage.Literals.REFERENCE__OWNED_ANNOTATIONS, annotation);
        return annotation;
    }

    /**
     * Sets the value of a given annotation property on a given element in the context of a given ontology
     * 
     * This function assumes that the annotation property should have a single value in the given ontology context
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param property the given annotation property
     * @param value the annotation literal value
     */
    public static void setAnnotationPropertyValue(Ontology ontology, AnnotationProperty property, Literal value) {
        Annotation annotation = ontology.getOwnedAnnotations().stream()
            .filter(a -> a.getProperty() == property)
            .findFirst().orElse(null);
        if (annotation != null) {
            if (value != null) {
                annotation.setValue(value);
            } else {
                delete(annotation);
            }
        } else if (value != null) {
            annotation = addAnnotation(ontology, property, value);
        }
    }

    /**
     * Sets the value of a given annotation property on a given element in the context of a given ontology
     * 
     * This function assumes that the annotation property should have a single value in the given ontology context
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param element the given annotated element
     * @param property the given annotation property
     * @param value the annotation literal value
     */
    public static void setAnnotationPropertyValue(Ontology ontology, IdentifiedElement element, AnnotationProperty property, Literal value) {
        Annotation annotation = null;
        if (element != null) {
	        if (element.getOntology() == ontology) {
	            annotation = element.getOwnedAnnotations().stream()
	                .filter(a -> a.getProperty() == property)
	                .findFirst().orElse(null);
	        } else if (element instanceof Member){
	            annotation = getOrAddReference(ontology, (Member)element).getOwnedAnnotations().stream()
	                .filter(a -> a.getProperty() == property)
	                .findFirst().orElse(null);
	        }
        }
        if (annotation != null) {
            if (value != null) {
                annotation.setValue(value);
            } else {
                delete(annotation);
            }
        } else if (value != null) {
            annotation = addAnnotation(ontology, element, property, value);
        }
    }

    // Ontology
    
    /**
     * Creates a new ontology of the given sub type 
     * 
     * @param type the sub type of ontology to create
     * @param iri the IRI of the new ontology
     * @param separator the separator kind of the new ontology
     * @param prefix the prefix of the new ontology
     * @return a newly created ontology added to the contents of a resource with the given URI
     */
    protected static <T extends Ontology> T createOntology(Class<T> type, String iri, SeparatorKind separator, String prefix) {
        final T ontology = create(type);
        ontology.setNamespace(iri+separator);
        ontology.setPrefix(prefix);
        return ontology;
    }

    // Vocabulary

    /**
     * Creates a new vocabulary 
     * 
     * @param iri the IRI of the new vocabulary
     * @param separator the separator kind of the new vocabulary
     * @param prefix the prefix of the new vocabulary
     * @return a newly created vocabulary added to the contents of a resource with the given URI
     */
    public static Vocabulary createVocabulary(String iri, SeparatorKind separator, String prefix) {
        return createOntology(Vocabulary.class, iri, separator, prefix);
    }

    // VocabularyBundle
    
    /**
     * Creates a new vocabulary bundle 
     * 
     * @param iri the IRI of the new vocabulary bundle
     * @param separator the separator kind of the new vocabulary bundle
     * @param prefix the prefix of the new vocabulary bundle
     * @return a newly created vocabulary bunel added to the contents of a resource with the given URI
     */
    public static VocabularyBundle createVocabularyBundle(String iri, SeparatorKind separator, String prefix) {
        return createOntology(VocabularyBundle.class, iri, separator, prefix);
    }

    // Description
    
    /**
     * Creates a new description 
     * 
     * @param iri the IRI of the new description
     * @param separator the separator kind of the new description
     * @param prefix the prefix of the new description
     * @return a newly created description added to the contents of a resource with the given URI
     */
    public static Description createDescription(String iri, SeparatorKind separator, String prefix) {
        return createOntology(Description.class, iri, separator, prefix);
    }

    /**
     * Creates a new description bundle 
     * 
     * @param iri the IRI of the new description bundle
     * @param separator the separator kind of the new description bundle
     * @param prefix the prefix of the new description bundle
     * @return a newly created description bundle added to the contents of a resource with the given URI
     */
    // DescriptionBundle
    
    public static DescriptionBundle createDescriptionBundle(String iri, SeparatorKind separator, String prefix) {
        return createOntology(DescriptionBundle.class, iri, separator, prefix);
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
     * @param source the given source entity
     * @param target the given target entity
     * @param functional whether the relation entity is functional
     * @param inverseFunctional whether the relation entity is inverse functional
     * @param symmetric whether the relation entity is symmetric
     * @param asymmetric whether the relation entity is asymmetric
     * @param reflexive whether the relation entity is reflexive
     * @param irreflexive whether the relation entity is irreflexive
     * @param transitive whether the relation entity is transitive
     * @return a new relation entity that is added to the given vocabulary
     */
    public static RelationEntity addRelationEntity(Vocabulary vocabulary, String name, Entity source, Entity target, 
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
        setCrossReference(vocabulary, relation, OmlPackage.Literals.RELATION_ENTITY__SOURCE, source);
        setCrossReference(vocabulary, relation, OmlPackage.Literals.RELATION_ENTITY__TARGET, target);
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
     * @param domain the given domain classifier
     * @param range the given range scalar
     * @param functional whether the scalar property is functional
     * @return a new scalar property that is added to the given vocabulary
     */
    public static ScalarProperty addScalarProperty(Vocabulary vocabulary, String name,
        Classifier domain, Scalar range, boolean functional) {
        final ScalarProperty property = create(ScalarProperty.class);
        property.setName(name);
        property.setFunctional(functional);
        setCrossReference(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__DOMAIN, domain);
        setCrossReference(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__RANGE, range);
        vocabulary.getOwnedStatements().add(property);
        return property;
    }
    
    // StructuredProperty

    /**
     * Creates a new structured property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new structured property
     * @param domain the given domain classifier
     * @param range the given target structure
     * @param functional whether the structured property is functional
     * @return a new structured property that is added to the given vocabulary
     */
    public static StructuredProperty addStructuredProperty(Vocabulary vocabulary, String name, 
        Classifier domain, Structure range, boolean functional) {
        final StructuredProperty property = create(StructuredProperty.class);
        property.setName(name);
        property.setFunctional(functional);
        setCrossReference(vocabulary, property, OmlPackage.Literals.STRUCTURED_PROPERTY__DOMAIN, domain);
        setCrossReference(vocabulary, property, OmlPackage.Literals.STRUCTURED_PROPERTY__RANGE, range);
        vocabulary.getOwnedStatements().add(property);
        return property;
    }
    
    // FacetedScalar

    /**
     * Creates a new faceted scalar and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new faceted scalar
     * @param length the length facet
     * @param minLength the min length facet
     * @param maxLength the max length facet
     * @param pattern the string pattern facet
     * @param language the language facet
     * @param minInclusive the min inclusive facet
     * @param minExclusive the min exclusive facet
     * @param maxInclusive the max inclusive facet
     * @param maxExclusive the max exclusive facet
     * @return a new faceted scalar that is added to the given vocabulary
     */
    public static FacetedScalar addFacetedScalar(Vocabulary vocabulary, String name, Long length, Long minLength, Long maxLength, String pattern, 
        String language, Literal minInclusive, Literal minExclusive, Literal maxInclusive, Literal maxExclusive) {
        final FacetedScalar scalar = create(FacetedScalar.class);
        scalar.setName(name);
        scalar.setLength(length);
        scalar.setMinLength(minLength);
        scalar.setMaxLength(maxLength);
        scalar.setPattern(pattern);
        scalar.setLanguage(language);
        scalar.setMinInclusive(minInclusive);
        scalar.setMinExclusive(minExclusive);
        scalar.setMaxInclusive(maxInclusive);
        scalar.setMaxExclusive(maxExclusive);
        vocabulary.getOwnedStatements().add(scalar);
        return scalar;
    }
        
    // EnumeratedScalar

    /**
     * Creates a new enumerated scalar and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new enumerated scalar
     * @param literals the list of literals making up the enumerated scalar value space
     * @return a new enumerated scalar that is added to the given vocabulary
     */
    public static EnumeratedScalar addEnumeratedScalar(Vocabulary vocabulary, String name, Literal...literals) {
        final EnumeratedScalar scalar = create(EnumeratedScalar.class);
        scalar.setName(name);
        scalar.getLiterals().addAll(Arrays.asList(literals));
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
     * Creates a reverse relation and adds it to the given relation entity
     * 
     * @param entity the context relation entity
     * @param name the name of the new reverse relation
     * @return a reverse relation that is added to the given relation entity
     */
    public static ReverseRelation addReverseRelation(RelationEntity entity, String name) {
        final ReverseRelation reverse = create(ReverseRelation.class);
        reverse.setName(name);
        entity.setReverseRelation(reverse);
        return reverse;
    }
    
    // Rule

    /**
     * Creates a rule and adds it to the given relation entity
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

    // MemerReference

    /**
     * Creates a reference for the given member
     * 
     * @param member the given member
     * @return a reference for the given member
     */
    protected static Reference createReference(Member member) {
        if (member instanceof Aspect) {
            return createReference((Concept) member);
        } else if (member instanceof Concept) {
            return createReference((Concept) member);
        } else if (member instanceof RelationEntity) {
            return createReference((RelationEntity) member);
        } else if (member instanceof Structure) {
            return createReference((Structure) member);
        } else if (member instanceof EnumeratedScalar) {
            return createReference((EnumeratedScalar) member);
        } else if (member instanceof FacetedScalar) {
            return createReference((FacetedScalar) member);
        } else if (member instanceof AnnotationProperty) {
            return createReference((AnnotationProperty) member);
        } else if (member instanceof ScalarProperty) {
            return createReference((ScalarProperty) member);
        } else if (member instanceof StructuredProperty) {
            return createReference((StructuredProperty) member);
        } else if (member instanceof Relation) {
            return createReference((Relation) member);
        } else if (member instanceof Rule) {
            return createReference((Rule) member);
        } else if (member instanceof ConceptInstance) {
            return createReference((ConceptInstance) member);
        } else if (member instanceof RelationInstance) {
            return createReference((RelationInstance) member);
        }
        return null;
    }
    
    // AspectReference
    
    /**
     * Creates a reference for the given aspect
     * 
     * @param aspect the given aspect
     * @return a reference for the given aspect
     */
    protected static AspectReference createReference(Aspect aspect) {
        final AspectReference reference = create(AspectReference.class);
        reference.setAspect(aspect);
        return reference;
    }

    // ConceptReference

    /**
     * Creates a reference for the given concept
     * 
     * @param concept the given concept
     * @return a reference for the given concept
     */
    protected static ConceptReference createReference(Concept concept) {
        final ConceptReference reference = create(ConceptReference.class);
        reference.setConcept(concept);
        return reference;
    }
    
    // RelationEntityReference

    /**
     * Creates a reference for the given relation entity
     * 
     * @param entity the given relation entity
     * @return a reference for the given relation entity
     */
    protected static RelationEntityReference createReference(RelationEntity entity) {
        final RelationEntityReference reference = create(RelationEntityReference.class);
        reference.setEntity(entity);
        return reference;
    }
    
    // StructureReference

    /**
     * Creates a reference for the given structure
     * 
     * @param structure the given structure
     * @return a reference for the given structure
     */
    protected static StructureReference createReference(Structure structure) {
        final StructureReference reference = create(StructureReference.class);
        reference.setStructure(structure);
        return reference;
    }
    
    // AnnotationPropertyReference

    /**
     * Creates a reference for the given annotation property
     * 
     * @param property the given annotation property
     * @return a reference for the given annotation property
     */
    protected static AnnotationPropertyReference createReference(AnnotationProperty property) {
        AnnotationPropertyReference reference = create(AnnotationPropertyReference.class);
        reference.setProperty(property);
        return reference;
    }

    // ScalarPropertyReference

    /**
     * Creates a reference for the given scalar property
     * 
     * @param property the given scalar property
     * @return a reference for the given scalar property
     */
    protected static ScalarPropertyReference createReference(ScalarProperty property) {
        ScalarPropertyReference reference = create(ScalarPropertyReference.class);
        reference.setProperty(property);
        return reference;
    }
    
    // StructuredPropertyReference

    /**
     * Creates a reference for the given structured property
     * 
     * @param property the given structured property
     * @return a reference for the given structured property
     */
    protected static StructuredPropertyReference createReference(StructuredProperty property) {
        StructuredPropertyReference reference = create(StructuredPropertyReference.class);
        reference.setProperty(property);
        return reference;
    }
    
    // FacetedScalarReference

    /**
     * Creates a reference for the given faceted scalar
     * 
     * @param scalar the given faceted scalar
     * @return a reference for the given faceted scalar
     */
    protected static FacetedScalarReference createReference(FacetedScalar scalar) {
        FacetedScalarReference reference = create(FacetedScalarReference.class);
        reference.setScalar(scalar);
        return reference;
    }
    
    // EnumeratedScalarReference

    /**
     * Creates a reference for the given enumerated scalar
     * 
     * @param scalar the given enumerated scalar
     * @return a reference for the given enumerated scalar
     */
    protected static EnumeratedScalarReference createReference(EnumeratedScalar scalar) {
        EnumeratedScalarReference reference = create(EnumeratedScalarReference.class);
        reference.setScalar(scalar);
        return reference;
    }

    // RelationReference

    /**
     * Creates a reference for the given relation
     * 
     * @param relation the given relation
     * @return a reference for the given relation
     */
    protected static RelationReference createReference(Relation relation) {
        RelationReference reference = create(RelationReference.class);
        reference.setRelation(relation);
        return reference;
    }
    
    // RuleReference

    /**
     * Creates a reference for the given rule
     * 
     * @param rule the given rule
     * @return a reference for the given rule
     */
    protected static RuleReference createReference(Rule rule) {
        RuleReference reference = create(RuleReference.class);
        reference.setRule(rule);
        return reference;
    }
    
    // ConceptInstanceReference

    /**
     * Creates a reference for the given concept instance
     * 
     * @param instance the given concept instance
     * @return a reference for the given concept instance
     */
    protected static ConceptInstanceReference createReference(ConceptInstance instance) {
        ConceptInstanceReference reference = create(ConceptInstanceReference.class);
        reference.setInstance(instance);
        return reference;
    }

    // RelationInstanceReference

    /**
     * Creates a reference for the given relation instance
     * 
     * @param instance the given relation instance
     * @return a reference for the given relation instance
     */
    protected static RelationInstanceReference createReference(RelationInstance instance) {
        RelationInstanceReference reference = create(RelationInstanceReference.class);
        reference.setInstance(instance);
        return reference;
    }
    
    // Extension
    
    /**
     * Creates an extension and adds it to the given ontology
     * 
     * @param ontology the extending ontology
     * @param extendedOntologyIri the IRI of the extended ontology
     * @param extendedOntologySeparator the separator of the extended ontology (optional)
     * @param extendedOntologyPrefix the prefix of the extended ontology (optional)
     * @return an extension that is added to the extending ontology
     */
    public static Extension addExtension(Ontology ontology, String extendedOntologyIri, SeparatorKind extendedOntologySeparator, String extendedOntologyPrefix) {
        final Extension extension = create(Extension.class);
        if (extendedOntologySeparator != null) {
        	extension.setNamespace(extendedOntologyIri+extendedOntologySeparator);
        } else {
            extension.setNamespace(extendedOntologyIri+SeparatorKind.HASH);
        }
        extension.setPrefix(extendedOntologyPrefix);
        ontology.getOwnedImports().add(extension);
        return extension;
    }

    // Usage
    
    /**
     * Creates a usage and adds it to the given ontology
     * 
     * @param ontology the using ontology
     * @param usedOntologyIri the IRI of the used ontology
     * @param usedOntologySeparator the separator of the used ontology (optional)
     * @param usedOntologyPrefix the prefix of the used ontology (optional)
     * @return a usage that is added to the using ontology
     */
    public static Usage addUsage(Ontology ontology, String usedOntologyIri, SeparatorKind usedOntologySeparator, String usedOntologyPrefix) {
        final Usage usage = create(Usage.class);
        if (usedOntologySeparator != null) {
        	usage.setNamespace(usedOntologyIri+usedOntologySeparator);
        } else {
            usage.setNamespace(usedOntologyIri+SeparatorKind.HASH);
        }
        usage.setPrefix(usedOntologyPrefix);
        ontology.getOwnedImports().add(usage);
        return usage;
    }

    // Inclusion
    
    /**
     * Creates an inclusion and adds it to the given ontology
     * 
     * @param ontology the including ontology
     * @param includedOntologyIri the IRI of the included ontology
     * @param includedOntologySeparator the separator of the included ontology (optional)
     * @param includedOntologyPrefix the prefix of the included ontology (optional)
     * @return an inclusion that is added to the including ontology
     */
    public static Inclusion addInclusion(Ontology ontology, String includedOntologyIri, SeparatorKind includedOntologySeparator, String includedOntologyPrefix) {
        final Inclusion inclusion = create(Inclusion.class);
        if (includedOntologySeparator != null) {
        	inclusion.setNamespace(includedOntologyIri+includedOntologySeparator);
        } else {
            inclusion.setNamespace(includedOntologyIri+SeparatorKind.HASH);
        }
       inclusion.setPrefix(includedOntologyPrefix);
       ontology.getOwnedImports().add(inclusion);
       return inclusion;
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
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM, superTerm);
        setContainmentReference(vocabulary, subTerm, OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS, OmlPackage.Literals.SPECIALIZABLE_TERM_REFERENCE__OWNED_SPECIALIZATIONS, axiom);
        return axiom;
    }
    
    // ScalarPropertyRangeRestrictionAxiom

    /**
     * Creates a scalar property range restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given restricting (classifier) domain
     * @param property the given restricted scalar property
     * @param range given restricted (scalar) range
     * @param restrictionKind the kind of the restriction
     * @return a scalar property range restriction axiom that is added to the given vocabulary
     */
    public static ScalarPropertyRangeRestrictionAxiom addScalarPropertyRangeRestrictionAxiom(Vocabulary vocabulary, Classifier domain, ScalarProperty property, Scalar range, RangeRestrictionKind restrictionKind) {
        final ScalarPropertyRangeRestrictionAxiom axiom = create(ScalarPropertyRangeRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, range);
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // ScalarPropertyCardinalityRestrictionAxiom

    /**
     * Creates a scalar property cardinality restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given restricting (classifier) domain
     * @param property the given restricted scalar property
     * @param cardinality the restricted cardinality
     * @param range given restricted (scalar) range
     * @param restrictionKind the kind of the restriction
     * @return a scalar property cardinality restriction axiom that is added to the given vocabulary
     */
    public static ScalarPropertyCardinalityRestrictionAxiom addScalarPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, Classifier domain, ScalarProperty property, CardinalityRestrictionKind restrictionKind, long cardinality, Scalar range) {
        final ScalarPropertyCardinalityRestrictionAxiom axiom = create(ScalarPropertyCardinalityRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        axiom.setCardinality(cardinality);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, range);
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // ScalarPropertyValueRestrictionAxiom

    /**
     * Creates a scalar property value restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given restricting (classifier) domain
     * @param property the given restricted scalar property
     * @param value the (literal) value of the restriction
     * @return a scalar property value restriction axiom that is added to the given vocabulary
     */
    public static ScalarPropertyValueRestrictionAxiom addScalarPropertyValueRestrictionAxiom(Vocabulary vocabulary, Classifier domain, ScalarProperty property, Literal value) {
        final ScalarPropertyValueRestrictionAxiom axiom = create(ScalarPropertyValueRestrictionAxiom.class);
        axiom.setValue(value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // StructuredPropertyRangeRestrictionAxiom

    /**
     * Creates a structured property range restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given restricting (classifier) domain
     * @param property the given restricted structured property
     * @param range the given restricted (structure) range
     * @param restrictionKind the kind of the restriction
     * @return a structured property range restriction axiom that is added to the given vocabulary
     */
    public static StructuredPropertyRangeRestrictionAxiom addStructuredPropertyRangeRestrictionAxiom(Vocabulary vocabulary, Classifier domain, StructuredProperty property, Structure range, RangeRestrictionKind restrictionKind) {
        final StructuredPropertyRangeRestrictionAxiom axiom = create(StructuredPropertyRangeRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, range);
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // StructuredPropertyCardinalityRestrictionAxiom

    /**
     * Creates a structured property cardinality restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given restricting (classifier) domain
     * @param property the given restricted structured property
     * @param cardinality the restricted cardinality
     * @param range the given restricted (structure) range
     * @param restrictionKind the kind of the restriction
     * @return a structured property cardinality restriction axiom that is added to the given vocabulary
     */
    public static StructuredPropertyCardinalityRestrictionAxiom addStructuredPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, Classifier domain, StructuredProperty property, CardinalityRestrictionKind restrictionKind, long cardinality, Structure range) {
        final StructuredPropertyCardinalityRestrictionAxiom axiom = create(StructuredPropertyCardinalityRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        axiom.setCardinality(cardinality);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY, property);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, range);
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // StructuredPropertyValueRestrictionAxiom
    
    /**
     * Creates a structured property value restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given restricting (classifier) domain
     * @param property the given restricted structured property
     * @param value the (structure instance) value of the restriction
     * @return a structured property value restriction axiom that is added to the given vocabulary
     */
    public static StructuredPropertyValueRestrictionAxiom addStructuredPropertyValueRestrictionAxiom(Vocabulary vocabulary, Classifier domain, StructuredProperty property, StructureInstance value) {
        final StructuredPropertyValueRestrictionAxiom axiom = create(StructuredPropertyValueRestrictionAxiom.class);
        axiom.setValue(value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY, property);
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // RelationRangeRestrictionAxiom

    /**
     * Creates a relation range restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given restricting (entity) domain
     * @param relation the given restricted relation
     * @param range the given restricted (entity) range
     * @param restrictionKind the kind of the restriction
     * @return a relation range restriction axiom that is added to the given vocabulary
     */
    public static RelationRangeRestrictionAxiom addRelationRangeRestrictionAxiom(Vocabulary vocabulary, Entity domain, Relation relation, Entity range, RangeRestrictionKind restrictionKind) {
        final RelationRangeRestrictionAxiom axiom = create(RelationRangeRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION, relation);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_RANGE_RESTRICTION_AXIOM__RANGE, range);
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.ENTITY__OWNED_RELATION_RESTRICTIONS, OmlPackage.Literals.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS, axiom);
        return axiom;
    }
    
    // RelationCardinalityRestrictionAxiom

    /**
     * Creates a relation cardinality restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given restricting (entity) domain
     * @param relation the given restricted relation
     * @param cardinality the restricted cardinality
     * @param range the given restricted (entity) range
     * @param restrictionKind the kind of the restriction
     * @return a relation cardinality restriction axiom that is added to the given vocabulary
     */
    public static RelationCardinalityRestrictionAxiom addRelationCardinalityRestrictionAxiom(Vocabulary vocabulary, Entity domain, Relation relation, CardinalityRestrictionKind restrictionKind, long cardinality, Entity range) {
        final RelationCardinalityRestrictionAxiom axiom = create(RelationCardinalityRestrictionAxiom.class);
        axiom.setKind(restrictionKind);
        axiom.setCardinality(cardinality);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION, relation);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__RANGE, range);
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.ENTITY__OWNED_RELATION_RESTRICTIONS, OmlPackage.Literals.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS, axiom);
        return axiom;
    }

    // RelationTargetRestrictionAxiom
    
    /**
     * Creates a relation target restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domain the given restricting (entity) domain
     * @param relation the given restricted relation
     * @param target the given (named instance) target of the restriction
     * @return a relation target restriction axiom that is added to the given vocabulary
     */
    public static RelationTargetRestrictionAxiom addRelationTargetRestrictionAxiom(Vocabulary vocabulary, Entity domain, Relation relation, Entity target) {
        final RelationTargetRestrictionAxiom axiom = create(RelationTargetRestrictionAxiom.class);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION, relation);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_TARGET_RESTRICTION_AXIOM__TARGET, target);
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.ENTITY__OWNED_RELATION_RESTRICTIONS, OmlPackage.Literals.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS, axiom);
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
    public static KeyAxiom addKeyAxiom(Vocabulary vocabulary, Entity domain, List<Feature> keyProperties) {
        final KeyAxiom axiom = create(KeyAxiom.class);
        setCrossReferences(vocabulary, axiom, OmlPackage.Literals.KEY_AXIOM__PROPERTIES, new ArrayList<Element>(keyProperties));
        setContainmentReference(vocabulary, domain, OmlPackage.Literals.ENTITY__OWNED_KEYS, OmlPackage.Literals.ENTITY_REFERENCE__OWNED_KEYS, axiom);
        return axiom;
    }

    // ConceptTypeAssertion
    
    /**
     * Creates a concept type assertion and adds it to the given description
     * 
     * @param description the context description
     * @param instance the given concept instance
     * @param type the given concept type
     * @return a concept type assertion that is added to the given description
     */
    public static ConceptTypeAssertion addConceptTypeAssertion(Description description, ConceptInstance instance, Concept type) {
        final ConceptTypeAssertion assertion = create(ConceptTypeAssertion.class);
        setCrossReference(description, assertion, OmlPackage.Literals.CONCEPT_TYPE_ASSERTION__TYPE, type);
        setContainmentReference(description, instance, OmlPackage.Literals.CONCEPT_INSTANCE__OWNED_TYPES, OmlPackage.Literals.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES, assertion);
        return assertion;
    }

    // RelationTypeAssertion

    /**
     * Creates a relation type assertion and adds it to the given description
     * 
     * @param description the context description
     * @param instance the given relation instance
     * @param type the given relation entity type
     * @return a relation type assertion that is added to the given description
     */
    public static RelationTypeAssertion addRelationTypeAssertion(Description description, RelationInstance instance, RelationEntity type) {
        final RelationTypeAssertion assertion = create(RelationTypeAssertion.class);
        setCrossReference(description, assertion, OmlPackage.Literals.RELATION_TYPE_ASSERTION__TYPE, type);
        setContainmentReference(description, instance, OmlPackage.Literals.RELATION_INSTANCE__OWNED_TYPES, OmlPackage.Literals.RELATION_INSTANCE_REFERENCE__OWNED_TYPES, assertion);
        return assertion;
    }

    // ScalarPropertyValueAssertion

    /**
     * Creates a scalar property value assertion and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param instance the given instance
     * @param property the given scalar property
     * @param value the asserted (literal) value of the property
     * @return a scalar property value assertion that is added to the given structure instance
     */
    public static ScalarPropertyValueAssertion addScalarPropertyValueAssertion(Ontology ontology, Instance instance, ScalarProperty property, Literal value) {
        final ScalarPropertyValueAssertion assertion = create(ScalarPropertyValueAssertion.class);
        assertion.setValue(value);
        if (instance != null) {
        	instance.getOwnedPropertyValues().add(assertion);
        }
        setCrossReference(ontology, assertion, OmlPackage.Literals.SCALAR_PROPERTY_VALUE_ASSERTION__PROPERTY, property);
        return assertion;
    }
        
    /**
     * Sets the value of a given annotation property on a given element in the context of a given ontology
     * 
     * This function assumes that the scalar property should have a single value in the given ontology context
     * 
     * @param ontology the context ontology
     * @param instance the given instance
     * @param property the given scalar property
     * @param value the asserted (literal) value of the property
     */
    public static void setScalarPropertyValue(Ontology ontology, Instance instance, ScalarProperty property, Literal value) {
        ScalarPropertyValueAssertion assertion = null;
        if (instance != null) {
	        if (instance.getOntology() == ontology) {
	            assertion = instance.getOwnedPropertyValues().stream()
	                .filter(a -> a.getProperty() == property)
	                .map(a -> (ScalarPropertyValueAssertion)a)
	                .findFirst().orElse(null);
	        } else if (instance instanceof NamedInstance){
	            var reference = (NamedInstanceReference) getOrAddReference(ontology, (NamedInstance)instance);
	            assertion = reference.getOwnedPropertyValues().stream()
	                .filter(a -> a.getProperty() == property)
	                .map(a -> (ScalarPropertyValueAssertion)a)
	                .findFirst().orElse(null);
	        }
        }
        if (assertion != null) {
            if (value != null) {
                assertion.setValue(value);
            } else {
                delete(assertion);
            }
        } else if (value != null) {
            assertion = addScalarPropertyValueAssertion(ontology, instance, property, value);
        }
    }

    // StructuredPropertyValueAssertion

    /**
     * Creates a structured property value assertion and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param instance the given instance
     * @param property the given structured property
     * @param value the asserted (structure instance) value of the property
     * @return a structured property value assertion that is added to the given description
     */
    public static StructuredPropertyValueAssertion addStructuredPropertyValueAssertion(Ontology ontology, Instance instance, StructuredProperty property, StructureInstance value) {
        final StructuredPropertyValueAssertion assertion = create(StructuredPropertyValueAssertion.class);
        assertion.setValue(value);
        setCrossReference(ontology, assertion, OmlPackage.Literals.STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY, property);
        setContainmentReference(ontology, instance, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, OmlPackage.Literals.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }
        
    // LinkAssertion
        
    /**
     * Creates a link assertion and adds it to the given description
     * 
     * @param description the context description
     * @param source the given (source) named instance
     * @param relation the given relation type of the link
     * @param target the given (target) named instance
     * @return a link assertion that is added to the given description
     */
    public static LinkAssertion addLinkAssertion(Description description, NamedInstance source, Relation relation, NamedInstance target) {
        final LinkAssertion assertion = create(LinkAssertion.class);
        setCrossReference(description, assertion, OmlPackage.Literals.LINK_ASSERTION__RELATION, relation);
        setCrossReference(description, assertion, OmlPackage.Literals.LINK_ASSERTION__TARGET, target);
        setContainmentReference(description, source, OmlPackage.Literals.NAMED_INSTANCE__OWNED_LINKS, OmlPackage.Literals.NAMED_INSTANCE_REFERENCE__OWNED_LINKS, assertion);
        return assertion;
    }

    // TypePredicate

    /**
     * Creates a type predicate
     * 
     * @param vocabulary the context vocabulary
     * @param type the given type
     * @param variable the name of a variable bound to an instance of the type
     * @return a type predicate
     */
    public static TypePredicate createTypePredicate(Vocabulary vocabulary, Type type, String variable) {
        final TypePredicate predicate = create(TypePredicate.class);
        predicate.setVariable(variable);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.TYPE_PREDICATE__TYPE, type);
        return predicate;
    }
    
    // RelationEntityPredicate

    /**
     * Creates an relation entity predicate
     * 
     * @param vocabulary the context vocabulary
     * @param entity the given relation entity
     * @param variable1 the name of a variable bound to a named instance representing the source of a relation entity
     * @param entityVariable the name of a variable bound to an instance of the relation entity
     * @param variable2 the name of a variable bound to a named instance representing the target of a relation entity
     * @return a relation entity predicate
     */
    public static RelationEntityPredicate createRelationEntityPredicate(Vocabulary vocabulary, RelationEntity entity, String variable1, String entityVariable, String variable2) {
        final RelationEntityPredicate predicate = create(RelationEntityPredicate.class);
        predicate.setVariable1(variable1);
        predicate.setEntityVariable(entityVariable);
        predicate.setVariable2(variable2);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__ENTITY, entity);
        return predicate;
    }

    // FeaturePredicate

    /**
     * Creates an relation predicate
     * 
     * @param vocabulary the context vocabulary
     * @param feature the given feature
     * @param variable1 the name of a variable bound to an instance
     * @param variable2 the name of a variable bound to a value of the feature in the instance
     * @return a relation predicate
     */
    public static FeaturePredicate createFeaturePredicate(Vocabulary vocabulary, Feature feature, String variable1, String variable2) {
        final FeaturePredicate predicate = create(FeaturePredicate.class);
        predicate.setVariable1(variable1);
        predicate.setVariable2(variable2);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.FEATURE_PREDICATE__FEATURE, feature);
        return predicate;
    }

    // SameAsPredicate

    /**
     * Creates a sameAs predicate
     * 
     * @param vocabulary the context vocabulary
     * @param variable1 the name of a variable bound to one instance
     * @param variable2 the name of a variable bound to another instance
     * @return a sameAs predicate
     */
    public static SameAsPredicate createSameAsPredicate(Vocabulary vocabulary, String variable1, String variable2) {
        final SameAsPredicate predicate = create(SameAsPredicate.class);
        predicate.setVariable1(variable1);
        predicate.setVariable2(variable2);
        return predicate;
    }

    // DifferentFromPredicate

    /**
     * Creates a differentFrom predicate
     * 
     * @param vocabulary the context vocabulary
     * @param variable1 the name of a variable bound to one instance
     * @param variable2 the name of a variable bound to another instance
     * @return a differentFrom predicate
     */
    public static DifferentFromPredicate createDifferentFromPredicate(Vocabulary vocabulary, String variable1, String variable2) {
        final DifferentFromPredicate predicate = create(DifferentFromPredicate.class);
        predicate.setVariable1(variable1);
        predicate.setVariable2(variable2);
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