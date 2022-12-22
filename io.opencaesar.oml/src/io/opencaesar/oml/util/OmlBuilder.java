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
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.HashBasedTable;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.CardinalityRestrictionKind;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.Extension;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Inclusion;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RangeRestrictionKind;
import io.opencaesar.oml.Reference;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SeparatorKind;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.UnreifiedRelation;
import io.opencaesar.oml.Usage;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;

/**
 * The <b>Builder</b> for the model. This builder uses the {@link OmlWrite} API and provides additional features.
 *  
 * It allows clients to specify cross references by IRI and defers their resolution and setting until the build process is finished. 
 * This allows clients to have a single-phase build process as opposed to the typical two-phase builds (where objects are created 
 * in the first phase, and cross references are set in the second phase).
 * 
 * @author elaasar
 */
public class OmlBuilder {
    
    /*
     * The cache of ontology-to-iri-to-element
     */
    private final HashBasedTable<Ontology, String, Element> cache  = HashBasedTable.create();
    /*
     * The resource set of the OML models
     */
    private final ResourceSet resourceSet;
    /*
     * The set of newly created OML models
     */
    private final Set<Resource> newResources = new LinkedHashSet<>();
    /*
     * A list of cross-references resolution and assignment logic that is deferred to the end
     */
    private final List<Runnable> defer = new ArrayList<>();

    /**
     * Creates a new instance of the OML Builder for a given resource set 
     * 
     * @param resourceSet the given resource set
     */
    public OmlBuilder(ResourceSet resourceSet) {
        this.resourceSet = resourceSet;
    }
    
    /**
     * Gets the builder's resource set
     * 
     * @return the builder's resource set
     */
    public ResourceSet getResourceSet() {
        return resourceSet;
    }
    
    /**
     * Creates a new resource with the given URI and adds the given ontology as its root
     *  
     * The new resource will be created in the resource set and added to the set of new resources
     * 
     * @param ontology the given ontology
     * @param resourceURI the given resourceURI
     */
    protected void addToNewResources(Ontology ontology, URI resourceURI) {
        final Resource resource = resourceSet.createResource(resourceURI);
        resource.getContents().add(ontology);
        newResources.add(resource);
    }
    
    /**
     * Gets all the newly created resources by the builder
     * 
     * @return a List of newly created resources
     */
    public Collection<Resource> getNewResources() {
        return newResources;
    }    

    /**
     * Perform actions at the start of the building process 
     */
    public void start() {
        EcoreUtil.resolveAll(resourceSet);
    }
    
    /**
     * Perform actions at the end of the building process
     */
    public void finish() {
        defer.forEach(p -> p.run());
        defer.clear();
    }
    
    /**
     * Sets the given eRef on the given subject to an object that is resolved by iri in the context of the given ontology
     * 
     * Object iri resolution and  setting of the cross reference is deferred until the building is finished
     * 
     * @param ontology the given ontology
     * @param subject the given subject
     * @param eRef the given non-containment eReference 
     * @param objectIri an iri of the object
     */
    @SuppressWarnings("unchecked")
    protected void setCrossReference(Ontology ontology, Element subject, EReference eRef, String objectIri) {
        final Class<? extends IdentifiedElement> objectClass = (Class<? extends IdentifiedElement>) eRef.getEType().getInstanceClass();
        assert !eRef.isContainment() : eRef.getName()+" is a containment reference";
        assert !eRef.isMany() : eRef.getName()+" is a List reference";
        assert IdentifiedElement.class.isAssignableFrom(objectClass) : eRef.getName()+" is not typed by an identified element";
        if (objectIri != null) {
            defer.add(() -> subject.eSet(eRef, resolve(objectClass, ontology, objectIri)));
        }
    }
    
    /**
     * Sets the given eRef on the given subject to a List of objects that are resolved by iri in the context of the given ontology
     * 
     * Object iri resolution and  setting of the cross reference is deferred until the building is finished
     * 
     * @param ontology the given ontology
     * @param subject the given subject
     * @param eRef the given non-containment eReference 
     * @param objectIris a list of iris of objects
     */
    @SuppressWarnings("unchecked")
    protected void setCrossReferences(Ontology ontology, Element subject, EReference eRef, List<String> objectIris) {
        final Class<? extends IdentifiedElement> objectClass = (Class<? extends IdentifiedElement>) eRef.getEType().getInstanceClass();
        assert !eRef.isContainment() : eRef.getName()+" is a containment reference";
        assert eRef.isMany() : eRef.getName()+" is a singular reference";
        assert IdentifiedElement.class.isAssignableFrom(objectClass) : eRef.getName()+" is not typed by an identified element";
        if (objectIris.iterator().hasNext()) {
            defer.add(() -> subject.eSet(eRef, objectIris.stream().map(objectIri -> resolve(objectClass, ontology, objectIri)).collect(Collectors.toList())));
        }
    }

    /**
     * Sets the given object to be contained by the given subject that is resolved by iri in the context of the given ontology
     * 
     * If the subject iri resolves to a member of the given ontology; then the given member eRef will be used as the containment eRef
     * otherwise a reference to the subject is created (or retrieved) first in the ontology, then the given reference eRef will be used 
     * as the containment eRef. 
     * 
     * @param ontology the given ontology
     * @param subjectIri the given iri of a member to be resolved as subject
     * @param elementERef the containment eRef to use on subject if it belongs to the given ontology
     * @param referenceERef the containment eRef to use on subject if the subject does not belong to the given ontology
     * @param object the given object 
     */
    @SuppressWarnings("unchecked")
    protected void setContainmentReference(Ontology ontology, String subjectIri, EReference elementERef, EReference referenceERef, Element object) {
        final Class<? extends Element> objectClass = (Class<? extends Element>) elementERef.getEType().getInstanceClass();
        assert elementERef.isContainment() : elementERef.getName()+" is not a containment reference";
        assert referenceERef.isContainment() : referenceERef.getName()+" is not a containment reference";
        assert objectClass.isInstance(object) : object+" is not an instance of "+objectClass.getName();
        assert elementERef.getEType() == referenceERef.getEType() : elementERef.getName()+" does not have the same type as "+referenceERef.getName();
        if (subjectIri != null) {
            defer.add(() -> {
                final Member member = resolve(Member.class, ontology, subjectIri);
                if (member.getOntology() == ontology) {
                    ((List<Element>)member.eGet(elementERef)).add(object);
                } else {
                    ((List<Element>)OmlWrite.getOrAddReference(ontology, member).eGet(referenceERef)).add(object);
                }
            });
        }
    }

    /**
     * Resolves the given iri to an element of the given type in the context of the given ontology
     * 
     * This function will throw a {@link RuntimeException} if the element was not resolved
     * 
     * @param type The given Oml type that is a subtype of {@link IdentifiedElement}
     * @param context The given ontology context
     * @param iri the given iri of the element
     * @return an element with the given iri and type that is resolved in the context of the given ontology
     */
    protected <T extends IdentifiedElement> T resolve(Class<T> type, Ontology context, String iri) {
        Element element = cache.get(context, iri);
        if (element == null) {
            int i = iri.lastIndexOf('#');
            String baseIri;
            if (i > 0) {
                baseIri = iri.substring(0, i);            
            } else {
                i = iri.lastIndexOf('/');
                baseIri = iri.substring(0, i);            
            }
            String fragment;
            if (i > 0) {
                fragment = iri.substring(i+1);            
            } else {
                i = iri.lastIndexOf('/');
                fragment = iri.substring(i+1);        
            }
            Resource resource = null;
            if (context.getIri().equals(baseIri)) {
                resource = context.eResource();
            } else {
                Ontology ontology = OmlRead.getImportedOntologyByIri(context, baseIri);
                if (ontology != null) {
                    resource = ontology.eResource();
                } else {
                    throw new RuntimeException("could not resolve "+baseIri+" in context of "+context.getIri());
                }
            }
            if (resource != null) {
                EObject obj = resource.getEObject(fragment);
                if (obj instanceof Element) {
                    element = (Element)obj;
                }
            }
            if (element == null) {
                throw new RuntimeException("could not resolve "+iri+" in context of "+context.getIri());
            }
            cache.put(context, iri, element);
        }
        return type.cast(element);
    }
    
    // ------------------------------------------------------------------------------------
    
    // Annotation

    /**
     * Adds a new annotation with a literal or reference value (but not both) on a given ontology
     * 
     * @param ontology the ontology to annotate
     * @param propertyIri the annotation property identified by iri
     * @param literalValue the annotation literal value
     * @param referenceValueIri the annotation (member) reference value identified by iri
     * @return a new annotation on the given ontology
     */
    public Annotation addAnnotation(Ontology ontology, String propertyIri, Literal literalValue, String referenceValueIri) {
        final Annotation annotation = OmlWrite.addAnnotation(ontology, null, literalValue, null);
        if (referenceValueIri != null)
        	setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__REFERENCE_VALUE, referenceValueIri);
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, propertyIri);
        return annotation;
    }

    /**
     * Adds a new annotation with a literal or reference value (but not both) on a given annotated element in the context of a given ontology
     * 
     * Note that if the element is already added to an ontology, it is expected to be the same as the given ontology
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param element the annotated element to put the annotation on
     * @param propertyIri the annotation property identified by iri
     * @param literalValue the annotation literal value
     * @param referenceValueIri the annotation (member) reference value identified by iri
     * @return a new annotation on the given annotated element in the context of the given ontology
     */
    public Annotation addAnnotation(Ontology ontology, IdentifiedElement element, String propertyIri, Literal literalValue, String referenceValueIri) {
        final Annotation annotation = OmlWrite.addAnnotation(ontology, element, null, literalValue, null);
        if (referenceValueIri != null)
        	setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__REFERENCE_VALUE, referenceValueIri);
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, propertyIri);
        return annotation;
    }

    /**
     * Adds a new annotation with a literal or reference value (but not both) on a a given member (identified by iri) in the context of a given ontology
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param memberIri the iri of a member to put the annotation on
     * @param propertyIri the annotation property identified by iri
     * @param literalValue the annotation literal value
     * @param referenceValueIri the annotation (member) reference value identified by iri
     * @return a new annotation on the given member in the context of the given ontology
     */
    public Annotation addAnnotation(Ontology ontology, String memberIri, String propertyIri, Literal literalValue, String referenceValueIri) {
        final Annotation annotation = OmlWrite.addAnnotation(ontology, null, null, literalValue, null);
        if (referenceValueIri != null)
        	setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__REFERENCE_VALUE, referenceValueIri);
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, propertyIri);
        setContainmentReference(ontology, memberIri, OmlPackage.Literals.IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS, OmlPackage.Literals.REFERENCE__OWNED_ANNOTATIONS, annotation);
        return annotation;
    }

    // Vocabulary

    /**
     * Creates a new vocabulary and add it as content of a resource with the given URI 
     * 
     * @param resourceURI the URI of a new resource to add the vocabulary to its contents
     * @param iri the IRI of the new vocabulary
     * @param separator the separator kind of the new vocabulary
     * @param prefix the prefix of the new vocabulary
     * @return a newly created vocabulary added to the contents of a resource with the given URI
     */
    public Vocabulary createVocabulary(URI resourceURI, String iri, SeparatorKind separator, String prefix) {
        final Vocabulary vocabulary = OmlWrite.createVocabulary(iri, separator, prefix);
        addToNewResources(vocabulary, resourceURI);
        return vocabulary;
    }

    // VocabularyBundle
    
    /**
     * Creates a new vocabulary bundle and add it as content of a resource with the given URI 
     * 
     * @param resourceURI the URI of a new resource to add the vocabulary bundle to its contents
     * @param iri the IRI of the new vocabulary bundle
     * @param separator the separator kind of the new vocabulary bundle
     * @param prefix the prefix of the new vocabulary bundle
     * @return a newly created vocabulary bunel added to the contents of a resource with the given URI
     */
    public VocabularyBundle createVocabularyBundle(URI resourceURI, String iri, SeparatorKind separator, String prefix) {
        final VocabularyBundle bundle = OmlWrite.createVocabularyBundle(iri, separator, prefix);
        addToNewResources(bundle, resourceURI);
        return bundle;
    }

    // Description
    
    /**
     * Creates a new description and add it as content of a resource with the given URI 
     * 
     * @param resourceURI the URI of a new resource to add the description to its contents
     * @param iri the IRI of the new description
     * @param separator the separator kind of the new description
     * @param prefix the prefix of the new description
     * @return a newly created description added to the contents of a resource with the given URI
     */
    public Description createDescription(URI resourceURI, String iri, SeparatorKind separator, String prefix) {
        final Description description = OmlWrite.createDescription(iri, separator, prefix);
        addToNewResources(description, resourceURI);
        return description;
    }

    /**
     * Creates a new description bundle and add it as content of a resource with the given URI 
     * 
     * @param resourceURI the URI of a new resource to add the description bundle to its contents
     * @param iri the IRI of the new description bundle
     * @param separator the separator kind of the new description bundle
     * @param prefix the prefix of the new description bundle
     * @return a newly created description bundle added to the contents of a resource with the given URI
     */
    // DescriptionBundle
    
    public DescriptionBundle createDescriptionBundle(URI resourceURI, String iri, SeparatorKind separator, String prefix) {
        final DescriptionBundle bundle = OmlWrite.createDescriptionBundle(iri, separator, prefix);
        addToNewResources(bundle, resourceURI);
        return bundle;
    }

    // Aspect

    /**
     * Creates a new aspect and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new aspect
     * @return a new aspect that is added to the given vocabulary
     */
    public Aspect addAspect(Vocabulary vocabulary, String name) {
        final Aspect aspect = OmlWrite.addAspect(vocabulary, name);
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
    public Concept addConcept(Vocabulary vocabulary, String name) {
        final Concept concept = OmlWrite.addConcept(vocabulary, name);
        return concept;
    }

    // RelationEntity
    
    /**
     * Creates a new relation entity and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new concept
     * @param sourceIri the iri of the source entity
     * @param targetIri the iri of the target entity
     * @param functional whether the relation entity is functional
     * @param inverseFunctional whether the relation entity is inverse functional
     * @param symmetric whether the relation entity is symmetric
     * @param asymmetric whether the relation entity is asymmetric
     * @param reflexive whether the relation entity is reflexive
     * @param irreflexive whether the relation entity is irreflexive
     * @param transitive whether the relation entity is transitive
     * @return a new relation entity that is added to the given vocabulary
     */
    public RelationEntity addRelationEntity(Vocabulary vocabulary, String name, String sourceIri, String targetIri, 
        boolean functional, boolean inverseFunctional, boolean symmetric, 
        boolean asymmetric, boolean reflexive, boolean irreflexive, boolean transitive) {
        final RelationEntity relation = OmlWrite.addRelationEntity(vocabulary, name, null, null, functional, inverseFunctional, symmetric, asymmetric, reflexive, irreflexive, transitive);
        setCrossReference(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__SOURCE, sourceIri);
        setCrossReference(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__TARGET, targetIri);
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
    public Structure addStructure(Vocabulary vocabulary, String name) {
        final Structure structure = OmlWrite.addStructure(vocabulary, name);
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
    public AnnotationProperty addAnnotationProperty(Vocabulary vocabulary, String name) {
        final AnnotationProperty property = OmlWrite.addAnnotationProperty(vocabulary, name);
        return property;
    }
    
    // ScalarProperty

    /**
     * Creates a new scalar property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new scalar property
     * @param domainIri the iri of the domain classifier
     * @param rangeIri the iri of the rqnge scalar
     * @param functional whether the scalar property is functional
     * @return a new scalar property that is added to the given vocabulary
     */
    public ScalarProperty addScalarProperty(Vocabulary vocabulary, String name,
        String domainIri, String rangeIri, boolean functional) {
        final ScalarProperty property = OmlWrite.addScalarProperty(vocabulary, name, null, null, functional);
        setCrossReference(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__DOMAIN, domainIri);
        setCrossReference(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__RANGE, rangeIri);
        return property;
    }
    
    // StructuredProperty

    /**
     * Creates a new structured property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new structured property
     * @param domainIri the iri of the domain classifier
     * @param rangeIri the iri of the range structure
     * @param functional whether the structured property is functional
     * @return a new structured property that is added to the given vocabulary
     */
    public StructuredProperty addStructuredProperty(Vocabulary vocabulary, String name, 
        String domainIri, String rangeIri, boolean functional) {
        final StructuredProperty property = OmlWrite.addStructuredProperty(vocabulary, name, null, null, functional);
        setCrossReference(vocabulary, property, OmlPackage.Literals.STRUCTURED_PROPERTY__DOMAIN, domainIri);
        setCrossReference(vocabulary, property, OmlPackage.Literals.STRUCTURED_PROPERTY__RANGE, rangeIri);
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
    public FacetedScalar addFacetedScalar(Vocabulary vocabulary, String name, Long length, Long minLength, Long maxLength, String pattern, 
        String language, Literal minInclusive, Literal minExclusive, Literal maxInclusive, Literal maxExclusive) {
        final FacetedScalar scalar = OmlWrite.addFacetedScalar(vocabulary, name, length, minLength, maxLength, pattern, language, minInclusive, minExclusive, maxInclusive, maxExclusive);
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
    public EnumeratedScalar addEnumeratedScalar(Vocabulary vocabulary, String name, Literal...literals) {
        final EnumeratedScalar scalar = OmlWrite.addEnumeratedScalar(vocabulary, name, literals);
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
    public ForwardRelation addForwardRelation(RelationEntity entity, String name) {
        final ForwardRelation forward = OmlWrite.addForwardRelation(entity, name);
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
    public ReverseRelation addReverseRelation(RelationBase base, String name) {
        final ReverseRelation reverse = OmlWrite.addReverseRelation(base, name);
        return reverse;
    }
    
    // UnreifiedRelation
    
    /**
     * Creates a new unreified relation and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param name the name of the new concept
     * @param sourceIri the iri of the source entity
     * @param targetIri the iri of the target entity
     * @param functional whether the relation entity is functional
     * @param inverseFunctional whether the relation entity is inverse functional
     * @param symmetric whether the relation entity is symmetric
     * @param asymmetric whether the relation entity is asymmetric
     * @param reflexive whether the relation entity is reflexive
     * @param irreflexive whether the relation entity is irreflexive
     * @param transitive whether the relation entity is transitive
     * @return a new relation entity that is added to the given vocabulary
     */
    public UnreifiedRelation addUnreifiedRelation(Vocabulary vocabulary, String name, String sourceIri, String targetIri, 
        boolean functional, boolean inverseFunctional, boolean symmetric, 
        boolean asymmetric, boolean reflexive, boolean irreflexive, boolean transitive) {
        final UnreifiedRelation relation = OmlWrite.addUnreifiedRelation(vocabulary, name, null, null, functional, inverseFunctional, symmetric, asymmetric, reflexive, irreflexive, transitive);
        setCrossReference(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__SOURCE, sourceIri);
        setCrossReference(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__TARGET, targetIri);
        return relation;
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
    public Rule addRule(Vocabulary vocabulary, String name, Predicate[] consequent, Predicate[] antecedent) {
        final Rule rule = OmlWrite.addRule(vocabulary, name, consequent, antecedent);
        return rule;
    }

    // StructureInstance

    /**
     * Creates a structure instance and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param structureIri the iri of a structure that is the type of the structure instance
     * @return a structure instance that is added to the given ontology
     */
    public StructureInstance createStructureInstance(Ontology ontology, String structureIri) {
        final StructureInstance instance = OmlWrite.createStructureInstance(ontology, null);
        setCrossReference(ontology, instance, OmlPackage.Literals.STRUCTURE_INSTANCE__TYPE, structureIri);
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
    public ConceptInstance addConceptInstance(Description description, String name) {
        final ConceptInstance instance = OmlWrite.addConceptInstance(description, name);
        return instance;
    }

    // RelationInstance

    /**
     * Creates a relation instance and adds it to the given description
     * 
     * @param description the context description
     * @param name the name of the new relation instance
     * @param sourceIris a list of Iris for source instances
     * @param targetIris a list of Iris of target instances
     * @return a relation instance that is added to the given description
     */
    public RelationInstance addRelationInstance(Description description, String name, List<String> sourceIris, List<String> targetIris) {
        final RelationInstance instance = OmlWrite.addRelationInstance(description, name, Collections.emptyList(), Collections.emptyList());
        setCrossReferences(description, instance, OmlPackage.Literals.RELATION_INSTANCE__SOURCES, sourceIris);
        setCrossReferences(description, instance, OmlPackage.Literals.RELATION_INSTANCE__TARGETS, targetIris);
        return instance;
    }

    // MemerReference

    /**
     * Creates a reference for the given member
     * 
     * @param member the given member
     * @return a reference for the given member
     */
    public Reference createReference(Member member) {
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
    public Extension addExtension(Ontology ontology, String extendedOntologyIri, SeparatorKind extendedOntologySeparator, String extendedOntologyPrefix) {
        final Extension extension = OmlWrite.addExtension(ontology, extendedOntologyIri, extendedOntologySeparator, extendedOntologyPrefix);
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
    public Usage addUsage(Ontology ontology, String usedOntologyIri, SeparatorKind usedOntologySeparator, String usedOntologyPrefix) {
        final Usage usage = OmlWrite.addUsage(ontology, usedOntologyIri, usedOntologySeparator, usedOntologyPrefix);
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
    public Inclusion addInclusion(Ontology ontology, String includedOntologyIri, SeparatorKind includedOntologySeparator, String includedOntologyPrefix) {
        final Inclusion inclusion = OmlWrite.addInclusion(ontology, includedOntologyIri, includedOntologySeparator, includedOntologyPrefix);
        return inclusion;
    }
    
    // SpecializationAxiom

    /**
     * Creates a specialization axiom between two terms and adds it to the given vocabulary
     *  
     * @param vocabulary the context vocabulary
     * @param subTermIri the iri of the sub term
     * @param superTermIri the iri of the super term
     * @return a specialization axiom that is added to the vocabulary
     */
    public SpecializationAxiom addSpecializationAxiom(Vocabulary vocabulary, String subTermIri, String superTermIri) {
        final SpecializationAxiom axiom = OmlWrite.addSpecializationAxiom(vocabulary, null, null);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM, superTermIri);
        setContainmentReference(vocabulary, subTermIri, OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS, OmlPackage.Literals.SPECIALIZABLE_TERM_REFERENCE__OWNED_SPECIALIZATIONS, axiom);
        return axiom;
    }
    
    // PropertyRangeRestrictionAxiom

    /**
     * Creates a property range restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted property
     * @param rangeIri the iri of the restricted range
     * @param restrictionKind the kind of the restriction
     * @return a property range restriction axiom that is added to the given vocabulary
     */
    public PropertyRangeRestrictionAxiom addPropertyRangeRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, String rangeIri, RangeRestrictionKind restrictionKind) {
        final PropertyRangeRestrictionAxiom axiom = OmlWrite.addPropertyRangeRestrictionAxiom(vocabulary, null, null, null, restrictionKind);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, rangeIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // PropertyCardinalityRestrictionAxiom

    /**
     * Creates a property cardinality restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted property
     * @param cardinality the restricted cardinality
     * @param rangeIri the iri of the restricted range (optional)
     * @param restrictionKind the kind of the restriction
     * @return a property cardinality restriction axiom that is added to the given vocabulary
     */
    public PropertyCardinalityRestrictionAxiom addPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, CardinalityRestrictionKind restrictionKind, long cardinality, String rangeIri) {
        final PropertyCardinalityRestrictionAxiom axiom = OmlWrite.addPropertyCardinalityRestrictionAxiom(vocabulary, null, null, restrictionKind, cardinality, null);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, rangeIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // PropertyValueRestrictionAxiom

    /**
     * Creates a property value restriction axiom for a scalar property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted scalar property
     * @param literal the (literal) value of the restriction
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, Literal literal) {
        final PropertyValueRestrictionAxiom axiom = OmlWrite.addPropertyValueRestrictionAxiom(vocabulary, null, null, literal);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    /**
     * Creates a property value restriction axiom for a structured property and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted structured property
     * @param structureInstance the (structure instance) value of the restriction
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, StructureInstance structureInstance) {
        final PropertyValueRestrictionAxiom axiom = OmlWrite.addPropertyValueRestrictionAxiom(vocabulary, null, null, structureInstance);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    /**
     * Creates a property value restriction axiom for a relation and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted relation
     * @param namedInstanceIri the Iri of a (named instance) value of the restriction
     * @return a property value restriction axiom that is added to the given vocabulary
     */
    public PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, String namedInstanceIri) {
        final PropertyValueRestrictionAxiom axiom = OmlWrite.addPropertyValueRestrictionAxiom(vocabulary, null, null, (NamedInstance) null);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__NAMED_INSTANCE_VALUE, namedInstanceIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // KeyAxiom

    /**
     * Creates a key axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the keyed (entity) domain
     * @param keyPropertyIris the list of iris of the properties that are part of the key
     * @return a key axiom that is added to the given vocabulary
     */
    public KeyAxiom addKeyAxiom(Vocabulary vocabulary, String domainIri, List<String> keyPropertyIris) {
        final KeyAxiom axiom = OmlWrite.addKeyAxiom(vocabulary, null, Collections.emptyList());
        setCrossReferences(vocabulary, axiom, OmlPackage.Literals.KEY_AXIOM__PROPERTIES, keyPropertyIris);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.ENTITY__OWNED_KEYS, OmlPackage.Literals.ENTITY_REFERENCE__OWNED_KEYS, axiom);
        return axiom;
    }

    // TypeAssertion
    
    /**
     * Creates a type assertion and adds it to the given description
     * 
     * @param description the context description
     * @param instanceIri the iri of the named instance
     * @param typeIri the iri of the type
     * @return a concept type assertion that is added to the given description
     */
    public TypeAssertion addConceptTypeAssertion(Description description, String instanceIri, String typeIri) {
        final TypeAssertion assertion = OmlWrite.addTypeAssertion(description, null, null);
        setCrossReference(description, assertion, OmlPackage.Literals.TYPE_ASSERTION__TYPE, typeIri);
        setContainmentReference(description, instanceIri, OmlPackage.Literals.NAMED_INSTANCE__OWNED_TYPES, OmlPackage.Literals.NAMED_INSTANCE_REFERENCE__OWNED_TYPES, assertion);
        return assertion;
    }

    // PropertyValueAssertion

    /**
     * Creates a property value assertion for a scalar property and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param instanceIri the iri of the instance
     * @param propertyIri the iri of the scalar property
     * @param literalValue the asserted (literal) value of the property
     * @return a property value assertion that is added to the given description
     */
    public PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, String instanceIri, String propertyIri, Literal literalValue) {
        final PropertyValueAssertion assertion = OmlWrite.addPropertyValueAssertion(ontology, null, null, literalValue);
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, propertyIri);
        setContainmentReference(ontology, instanceIri, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, OmlPackage.Literals.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }

    /**
     * Creates a property value assertion for a structured property and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param instanceIri the iri of the instance
     * @param propertyIri the iri of the structured property
     * @param structureInstanceValue the asserted (structure instance) value of the property
     * @return a property value assertion that is added to the given description
     */
    public PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, String instanceIri, String propertyIri, StructureInstance structureInstanceValue) {
        final PropertyValueAssertion assertion = OmlWrite.addPropertyValueAssertion(ontology, null, null, structureInstanceValue);
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, propertyIri);
        setContainmentReference(ontology, instanceIri, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, OmlPackage.Literals.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }

    /**
     * Creates a property value assertion for a relation and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param instanceIri the iri of the instance
     * @param propertyIri the iri of the relation property
     * @param namedInstanceValueIri the asserted (named instance) value (identified by iri) of the property
     * @return a property value assertion that is added to the given description
     */
    public PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, String instanceIri, String propertyIri, String namedInstanceValueIri) {
        final PropertyValueAssertion assertion = OmlWrite.addPropertyValueAssertion(ontology, null, null, (NamedInstance) null);
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__NAMED_INSTANCE_VALUE, namedInstanceValueIri);
        setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, propertyIri);
        setContainmentReference(ontology, instanceIri, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, OmlPackage.Literals.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }

    // ClassifierPredicate

    /**
     * Creates a type predicate
     * 
     * @param vocabulary the context vocabulary
     * @param typeIri the iri of the type
     * @param variable the name of a variable bound to an instance of the type
     * @return a type predicate
     */
    public TypePredicate createTypePredicate(Vocabulary vocabulary, String typeIri, String variable) {
        final TypePredicate predicate = OmlWrite.createTypePredicate(vocabulary, null, variable);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.TYPE_PREDICATE__TYPE, typeIri);
        return predicate;
    }
    
    // RelationEntityPredicate

    /**
     * Creates an relation entity predicate
     * 
     * @param vocabulary the context vocabulary
     * @param entityIri the iri of the relation entity
     * @param variable1 the name of a variable bound to a named instance representing the source of the relation entity
     * @param variable the name of a variable bound to an instance of the relation entity
     * @param variable2 the name of a variable bound to a named instance representing the target of the relation entity
     * @return a relation entity predicate
     */
    public RelationEntityPredicate createRelationEntityPredicate(Vocabulary vocabulary, String entityIri, String variable1, String variable, String variable2) {
        final RelationEntityPredicate predicate = OmlWrite.createRelationEntityPredicate(vocabulary, null, variable1, variable, variable2);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__ENTITY, entityIri);
        return predicate;
    }

    // RelationPredicate

    /**
     * Creates a property predicate
     * 
     * @param vocabulary the context vocabulary
     * @param propertyIri the iri of the property
     * @param variable1 the name of a variable bound to an instance
     * @param variable2 the name of a variable bound to a value of the property in the instance
     * @return a relation predicate
     */
    public PropertyPredicate createPropertyPredicate(Vocabulary vocabulary, String propertyIri, String variable1, String variable2) {
        final PropertyPredicate predicate = OmlWrite.createPropertyPredicate(vocabulary, null, variable1, variable2);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.PROPERTY_PREDICATE__PROPERTY, propertyIri);
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
    public SameAsPredicate createSameAsPredicate(Vocabulary vocabulary, String variable1, String variable2) {
        final SameAsPredicate predicate = OmlWrite.createSameAsPredicate(vocabulary, variable1, variable2);
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
    public DifferentFromPredicate createDifferentFromPredicate(Vocabulary vocabulary, String variable1, String variable2) {
        final DifferentFromPredicate predicate = OmlWrite.createDifferentFromPredicate(vocabulary, variable1, variable2);
        return predicate;
    }

    // QuotedLiteral

    /**
     * Creates a quoted literal in the given ontology
     * 
     * @param ontology the ontology context
     * @param value the lexical value of the literal
     * @param typeIri the iri of (scalar) type of the literal (optional)
     * @param langTag the language tag of the literal (optional)
     * @return a quoted literal
     */
    public QuotedLiteral createQuotedLiteral(Ontology ontology, String value, String typeIri, String langTag) {
        final QuotedLiteral literal = OmlWrite.createQuotedLiteral(ontology, value, null, langTag);
        if (typeIri != null) {
            setCrossReference(ontology, literal, OmlPackage.Literals.QUOTED_LITERAL__TYPE, typeIri);
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
    public IntegerLiteral createIntegerLiteral(int value) {
        final IntegerLiteral literal = OmlWrite.createIntegerLiteral(value);
        return literal;
    }

    // DecimalLiteral

    /**
     * Creates a decimal literal
     * 
     * @param value the big decimal value of the literal
     * @return a decimal literal
     */
    public DecimalLiteral createDecimalLiteral(BigDecimal value) {
        final DecimalLiteral literal = OmlWrite.createDecimalLiteral(value);
        return literal;
    }

    // DoubleLiteral

    /**
     * Creates a double literal
     * 
     * @param value the double value of the literal
     * @return a double literal
     */
    public DoubleLiteral createDoubleLiteral(double value) {
        final DoubleLiteral literal = OmlWrite.createDoubleLiteral(value);
        return literal;
    }

    // BooleanLiteral
    
    /**
     * Creates an boolean literal
     * 
     * @param value the boolean value of the literal
     * @return a boolean literal
     */
    public BooleanLiteral createBooleanLiteral(boolean value) {
        final BooleanLiteral literal = OmlWrite.createBooleanLiteral(value);
        return literal;
    }
        
}