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
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionBundleExtension;
import io.opencaesar.oml.DescriptionBundleInclusion;
import io.opencaesar.oml.DescriptionBundleUsage;
import io.opencaesar.oml.DescriptionExtension;
import io.opencaesar.oml.DescriptionUsage;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FeaturePredicate;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
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
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationTargetRestrictionAxiom;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom;
import io.opencaesar.oml.SeparatorKind;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyUsage;

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
     * Adds a new annotation on a given ontology
     * 
     * @param ontology the ontology to annotate
     * @param propertyIri the annotation property identified by iri
     * @param value the annotation literal value
     * @return a new annotation on the given ontology
     */
    public Annotation addAnnotation(Ontology ontology, String propertyIri, Literal value) {
        final Annotation annotation = OmlWrite.addAnnotation(ontology, null, value);
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, propertyIri);
        return annotation;
    }

    /**
     * Adds a new annotation on a given annotated element in the context of a given ontology
     * 
     * Note that if the element is already added to an ontology, it is expected to be the same as the given ontology
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param element the annotated element to put the annotation on
     * @param propertyIri the annotation property identified by iri
     * @param value the annotation literal value
     * @return a new annotation on the given annotated element in the context of the given ontology
     */
    public Annotation addAnnotation(Ontology ontology, IdentifiedElement element, String propertyIri, Literal value) {
        final Annotation annotation = OmlWrite.addAnnotation(ontology, element, null, value);
        setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, propertyIri);
        return annotation;
    }

    /**
     * Adds a new annotation on a given member (identified by iri) in the context of a given ontology
     * 
     * @param ontology the context ontology that will have the annotation axiom
     * @param memberIri the iri of a member to put the annotation on
     * @param propertyIri the annotation property identified by iri
     * @param value the annotation literal value
     * @return a new annotation on the given member in the context of the given ontology
     */
    public Annotation addAnnotation(Ontology ontology, String memberIri, String propertyIri, Literal value) {
        final Annotation annotation = OmlWrite.addAnnotation(ontology, null, null, value);
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
        setCrossReference(vocabulary, relation, OmlPackage.Literals.RELATION_ENTITY__SOURCE, sourceIri);
        setCrossReference(vocabulary, relation, OmlPackage.Literals.RELATION_ENTITY__TARGET, targetIri);
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
     * Creates a reverse relation and adds it to the given relation entity
     * 
     * @param entity the context relation entity
     * @param name the name of the new reverse relation
     * @return a reverse relation that is added to the given relation entity
     */
    public ReverseRelation addReverseRelation(RelationEntity entity, String name) {
        final ReverseRelation reverse = OmlWrite.addReverseRelation(entity, name);
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
    
    // VocabularyExtension
    
    /**
     * Creates a vocabulary extension and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param extenedVocabularyIri the IRI of the extended vocabulary
     * @param extenedVocabularySeparator the separator of the extended vocabulary (optional)
     * @param extenedVocabularyPrefix the prefix of the extended vocabulary (optional)
     * @return a vocabulary extension that is added to the given vocabulary
     */
    public VocabularyExtension addVocabularyExtension(Vocabulary vocabulary, String extenedVocabularyIri, SeparatorKind extenedVocabularySeparator, String extenedVocabularyPrefix) {
        final VocabularyExtension extension = OmlWrite.addVocabularyExtension(vocabulary, extenedVocabularyIri, extenedVocabularySeparator, extenedVocabularyPrefix);
        return extension;
    }

    // VocabularyUsage
    
    /**
     * Creates a vocabulary usage and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param usedDescriptionBoxIri the IRI of the used description box
     * @param usedDescriptionBoxSeparator the separator of the used description box (optional)
     * @param usedDescriptionBoxPrefix the prefix of the used description box (optional)
     * @return a vocabulary usage that is added to the given vocabulary
     */
    public VocabularyUsage addVocabularyUsage(Vocabulary vocabulary, String usedDescriptionBoxIri, SeparatorKind usedDescriptionBoxSeparator, String usedDescriptionBoxPrefix) {
        final VocabularyUsage usage = OmlWrite.addVocabularyUsage(vocabulary, usedDescriptionBoxIri, usedDescriptionBoxSeparator, usedDescriptionBoxPrefix);
        return usage;
    }

    // VocabularyBundleExtension
    
    /**
     * Creates a vocabulary bundle extension and adds it to the given vocabulary bundle
     * 
     * @param bundle the context vocabulary bundle
     * @param extenedVocabularyBundleIri the IRI of the extended vocabulary bundle
     * @param extenedVocabularyBundleSeparator the separator of the extended vocabulary bundle (optional)
     * @param extenedVocabularyBundlePrefix the prefix of the extended vocabulary bundle (optional)
     * @return a vocabulary bundle extension that is added to the given vocabulary bundle
     */
    public VocabularyBundleExtension addVocabularyBundleExtension(VocabularyBundle bundle, String extenedVocabularyBundleIri, SeparatorKind extenedVocabularyBundleSeparator, String extenedVocabularyBundlePrefix) {
        final VocabularyBundleExtension extension = OmlWrite.addVocabularyBundleExtension(bundle, extenedVocabularyBundleIri, extenedVocabularyBundleSeparator, extenedVocabularyBundlePrefix);
        return extension;
    }

    // VocabularyBundleInclusion
    
    /**
     * Creates a vocabulary bundle inclusion and adds it to the given vocabulary bundle
     * 
     * @param bundle the context vocabulary bundle
     * @param includedVocabularyIri the IRI of the included vocabulary
     * @param includedVocabularySeparator the separator of the included vocabulary (optional)
     * @param includedVocabularyPrefix the prefix of the included vocabulary (optional)
     * @return a vocabulary bundle inclusion that is added to the given vocabulary bundle
     */
    public VocabularyBundleInclusion addVocabularyBundleInclusion(VocabularyBundle bundle, String includedVocabularyIri, SeparatorKind includedVocabularySeparator, String includedVocabularyPrefix) {
        final VocabularyBundleInclusion inclusion = OmlWrite.addVocabularyBundleInclusion(bundle, includedVocabularyIri, includedVocabularySeparator, includedVocabularyPrefix);
        return inclusion;
    }

    // DescriptionExtension

    /**
     * Creates a description extension and adds it to the given description
     * 
     * @param description the context description
     * @param extenedDescriptionIri the IRI of the extended description
     * @param extenedDescriptionSeparator the separator of the extended description (optional)
     * @param extenedDescriiptionPrefix the prefix of the extended description (optional)
     * @return a description extension that is added to the given description
     */
    public DescriptionExtension addDescriptionExtension(Description description, String extenedDescriptionIri, SeparatorKind extenedDescriptionSeparator, String extenedDescriiptionPrefix) {
        final DescriptionExtension extension = OmlWrite.addDescriptionExtension(description, extenedDescriptionIri, extenedDescriptionSeparator, extenedDescriiptionPrefix);
        return extension;
    }
    
    // DescriptionUsage

    /**
     * Creates a description usage and adds it to the given description
     * 
     * @param description the context description
     * @param usedVocabularyBoxIri the IRI of the used vocabulary box
     * @param usedVocabularyBoxSeparator the separator of the used vocabulary box (optional)
     * @param usedVocabularyBoxPrefix the prefix of the used vocabulary box (optional)
     * @return a description usage that is added to the given description
     */
    public DescriptionUsage addDescriptionUsage(Description description, String usedVocabularyBoxIri, SeparatorKind usedVocabularyBoxSeparator, String usedVocabularyBoxPrefix) {
        final DescriptionUsage usage = OmlWrite.addDescriptionUsage(description, usedVocabularyBoxIri, usedVocabularyBoxSeparator, usedVocabularyBoxPrefix);
        return usage;
    }
    
    // DescriptionBundleExtension
    
    /**
     * Creates a description bundle extension and adds it to the given description bundle
     * 
     * @param bundle the context description bundle
     * @param extenedDescriptionBundleIri the IRI of the extended vocabulary bundle
     * @param extenedDescriptionBundleSeparator the separator of the extended vocabulary bundle (optional)
     * @param extenedDescriptionBundlePrefix the prefix of the extended vocabulary bundle (optional)
     * @return a description bundle extension that is added to the given description bundle
     */
    public DescriptionBundleExtension addDescriptionBundleExtension(DescriptionBundle bundle, String extenedDescriptionBundleIri, SeparatorKind extenedDescriptionBundleSeparator, String extenedDescriptionBundlePrefix) {
        final DescriptionBundleExtension extension = OmlWrite.addDescriptionBundleExtension(bundle, extenedDescriptionBundleIri, extenedDescriptionBundleSeparator, extenedDescriptionBundlePrefix);
        return extension;
    }

    // DescriptionBundleInclusion
    
    /**
     * Creates a description bundle inclusion and adds it to the given description bundle
     * 
     * @param bundle the context description bundle
     * @param includedDescriptionIri the IRI of the extended description
     * @param includedDescriptionSeparator the separator of the extended description (optional)
     * @param includedDescriptionPrefix the prefix of the extended description (optional)
     * @return a description bundle inclusion that is added to the given description bundle
     */
    public DescriptionBundleInclusion addDescriptionBundleInclusion(DescriptionBundle bundle, String includedDescriptionIri, SeparatorKind includedDescriptionSeparator, String includedDescriptionPrefix) {
        final DescriptionBundleInclusion inclusion = OmlWrite.addDescriptionBundleInclusion(bundle, includedDescriptionIri, includedDescriptionSeparator, includedDescriptionPrefix);
        return inclusion;
    }

    // DescriptionBundleUsage

    /**
     * Creates a description bundle usage and adds it to the given description bundle
     * 
     * @param bundle the context description bundle
     * @param usedVocabularyBoxIri the IRI of the used vocabulary box
     * @param usedVocabularyBoxSeparator the separator of the used vocabulary box (optional)
     * @param usedVocabularyBoxPrefix the prefix of the used vocabulary box (optional)
     * @return a description bundle usage that is added to the given description bundle
     */
    public DescriptionBundleUsage addDescriptionBundleUsage(DescriptionBundle bundle, String usedVocabularyBoxIri, SeparatorKind usedVocabularyBoxSeparator, String usedVocabularyBoxPrefix) {
        final DescriptionBundleUsage usage = OmlWrite.addDescriptionBundleUsage(bundle, usedVocabularyBoxIri, usedVocabularyBoxSeparator, usedVocabularyBoxPrefix);
        return usage;
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
    
    // ScalarPropertyRangeRestrictionAxiom

    /**
     * Creates a scalar property range restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted scalar property
     * @param rangeIri the iri of the restricted (scalar) range
     * @param restrictionKind the kind of the restriction
     * @return a scalar property range restriction axiom that is added to the given vocabulary
     */
    public ScalarPropertyRangeRestrictionAxiom addScalarPropertyRangeRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, String rangeIri, RangeRestrictionKind restrictionKind) {
        final ScalarPropertyRangeRestrictionAxiom axiom = OmlWrite.addScalarPropertyRangeRestrictionAxiom(vocabulary, null, null, null, restrictionKind);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, rangeIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // ScalarPropertyCardinalityRestrictionAxiom

    /**
     * Creates a scalar property cardinality restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted scalar property
     * @param cardinality the restricted cardinality
     * @param rangeIri the iri of the restricted (scalar) range (optional)
     * @param restrictionKind the kind of the restriction
     * @return a scalar property cardinality restriction axiom that is added to the given vocabulary
     */
    public ScalarPropertyCardinalityRestrictionAxiom addScalarPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, CardinalityRestrictionKind restrictionKind, long cardinality, String rangeIri) {
        final ScalarPropertyCardinalityRestrictionAxiom axiom = OmlWrite.addScalarPropertyCardinalityRestrictionAxiom(vocabulary, null, null, restrictionKind, cardinality, null);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, rangeIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // ScalarPropertyValueRestrictionAxiom

    /**
     * Creates a scalar property value restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted scalar property
     * @param value the (literal) value of the restriction
     * @return a scalar property value restriction axiom that is added to the given vocabulary
     */
    public ScalarPropertyValueRestrictionAxiom addScalarPropertyValueRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, Literal value) {
        final ScalarPropertyValueRestrictionAxiom axiom = OmlWrite.addScalarPropertyValueRestrictionAxiom(vocabulary, null, null, value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // StructuredPropertyRangeRestrictionAxiom

    /**
     * Creates a structured property range restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted structured property
     * @param rangeIri the iri of the restricted (structure) range
     * @param restrictionKind the kind of the restriction
     * @return a structured property range restriction axiom that is added to the given vocabulary
     */
    public StructuredPropertyRangeRestrictionAxiom addStructuredPropertyRangeRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, String rangeIri, RangeRestrictionKind restrictionKind) {
        final StructuredPropertyRangeRestrictionAxiom axiom = OmlWrite.addStructuredPropertyRangeRestrictionAxiom(vocabulary, null, null, null, restrictionKind);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, rangeIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // StructuredPropertyCardinalityRestrictionAxiom

    /**
     * Creates a structured property cardinality restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted structured property
     * @param rangeIri the iri of the restricted (structure) range (optional)
     * @param cardinality the restricted cardinality
     * @param restrictionKind the kind of the restriction
     * @return a structured property cardinality restriction axiom that is added to the given vocabulary
     */
    public StructuredPropertyCardinalityRestrictionAxiom addStructuredPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, CardinalityRestrictionKind restrictionKind, long cardinality, String rangeIri) {
        final StructuredPropertyCardinalityRestrictionAxiom axiom = OmlWrite.addStructuredPropertyCardinalityRestrictionAxiom(vocabulary, null, null, restrictionKind, cardinality, null);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, rangeIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // StructuredPropertyValueRestrictionAxiom
    
    /**
     * Creates a structured property value restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (classifier) domain
     * @param propertyIri the iri of the restricted structured property
     * @param value the (structure instance) value of the restriction
     * @return a structured property value restriction axiom that is added to the given vocabulary
     */
    public StructuredPropertyValueRestrictionAxiom addStructuredPropertyValueRestrictionAxiom(Vocabulary vocabulary, String domainIri, String propertyIri, StructureInstance value) {
        final StructuredPropertyValueRestrictionAxiom axiom = OmlWrite.addStructuredPropertyValueRestrictionAxiom(vocabulary, null, null, value);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY, propertyIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS, OmlPackage.Literals.CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS, axiom);
        return axiom;
    }

    // RelationRangeRestrictionAxiom

    /**
     * Creates a relation range restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (entity) domain
     * @param relationIri the iri of the restricted relation
     * @param rangeIri the iri of the restricted (entity) range
     * @param restrictionKind the kind of the restriction
     * @return a relation range restriction axiom that is added to the given vocabulary
     */
    public RelationRangeRestrictionAxiom addRelationRangeRestrictionAxiom(Vocabulary vocabulary, String domainIri, String relationIri, String rangeIri, RangeRestrictionKind restrictionKind) {
        final RelationRangeRestrictionAxiom axiom = OmlWrite.addRelationRangeRestrictionAxiom(vocabulary, null, null, null, restrictionKind);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION, relationIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_RANGE_RESTRICTION_AXIOM__RANGE, rangeIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.ENTITY__OWNED_RELATION_RESTRICTIONS, OmlPackage.Literals.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS, axiom);
        return axiom;
    }
    
    // RelationCardinalityRestrictionAxiom

    /**
     * Creates a relation cardinality restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (entity) domain
     * @param relationIri the iri of the restricted relation
     * @param rangeIri the iri of the restricted (entity) range (optional)
     * @param cardinality the restricted cardinality
     * @param restrictionKind the kind of the restriction
     * @return a relation cardinality restriction axiom that is added to the given vocabulary
     */
    public RelationCardinalityRestrictionAxiom addRelationCardinalityRestrictionAxiom(Vocabulary vocabulary, String domainIri, String relationIri, CardinalityRestrictionKind restrictionKind, long cardinality, String rangeIri) {
        final RelationCardinalityRestrictionAxiom axiom = OmlWrite.addRelationCardinalityRestrictionAxiom(vocabulary, null, null, restrictionKind, cardinality, null);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION, relationIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__RANGE, rangeIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.ENTITY__OWNED_RELATION_RESTRICTIONS, OmlPackage.Literals.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS, axiom);
        return axiom;
    }

    // RelationTargetRestrictionAxiom
    
    /**
     * Creates a relation target restriction axiom and adds it to the given vocabulary
     * 
     * @param vocabulary the context vocabulary
     * @param domainIri the iri of the restricting (entity) domain
     * @param relationIri the iri of the restricted relation
     * @param targetIri the iri of the (named instance) target of the restriction
     * @return a relation target restriction axiom that is added to the given vocabulary
     */
    public RelationTargetRestrictionAxiom addRelationTargetRestrictionAxiom(Vocabulary vocabulary, String domainIri, String relationIri, String targetIri) {
        final RelationTargetRestrictionAxiom axiom = OmlWrite.addRelationTargetRestrictionAxiom(vocabulary, null, null, null);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_RESTRICTION_AXIOM__RELATION, relationIri);
        setCrossReference(vocabulary, axiom, OmlPackage.Literals.RELATION_TARGET_RESTRICTION_AXIOM__TARGET, targetIri);
        setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.ENTITY__OWNED_RELATION_RESTRICTIONS, OmlPackage.Literals.ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS, axiom);
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

    // ConceptTypeAssertion
    
    /**
     * Creates a concept type assertion and adds it to the given description
     * 
     * @param description the context description
     * @param instanceIri the iri of the concept instance
     * @param typeIri the iri of the concept type
     * @return a concept type assertion that is added to the given description
     */
    public ConceptTypeAssertion addConceptTypeAssertion(Description description, String instanceIri, String typeIri) {
        final ConceptTypeAssertion assertion = OmlWrite.addConceptTypeAssertion(description, null, null);
        setCrossReference(description, assertion, OmlPackage.Literals.CONCEPT_TYPE_ASSERTION__TYPE, typeIri);
        setContainmentReference(description, instanceIri, OmlPackage.Literals.CONCEPT_INSTANCE__OWNED_TYPES, OmlPackage.Literals.CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES, assertion);
        return assertion;
    }

    // RelationTypeAssertion

    /**
     * Creates a relation type assertion and adds it to the given description
     * 
     * @param description the context description
     * @param instanceIri the iri of the relation instance
     * @param typeIri the iri of the relation entity type
     * @return a relation type assertion that is added to the given description
     */
    public RelationTypeAssertion addRelationTypeAssertion(Description description, String instanceIri, String typeIri) {
        final RelationTypeAssertion assertion = OmlWrite.addRelationTypeAssertion(description, null, null);
        setCrossReference(description, assertion, OmlPackage.Literals.RELATION_TYPE_ASSERTION__TYPE, typeIri);
        setContainmentReference(description, instanceIri, OmlPackage.Literals.RELATION_INSTANCE__OWNED_TYPES, OmlPackage.Literals.RELATION_INSTANCE_REFERENCE__OWNED_TYPES, assertion);
        return assertion;
    }

    // ScalarPropertyValueAssertion

    /**
     * Creates a scalar property value assertion and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param instanceIri the iri of the instance
     * @param propertyIri the iri of the scalar property
     * @param value the asserted (literal) value of the property
     * @return a scalar property value assertion that is added to the given description
     */
    public ScalarPropertyValueAssertion addScalarPropertyValueAssertion(Ontology ontology, String instanceIri, String propertyIri, Literal value) {
        final ScalarPropertyValueAssertion assertion = OmlWrite.addScalarPropertyValueAssertion(ontology, null, null, value);
        setCrossReference(ontology, assertion, OmlPackage.Literals.SCALAR_PROPERTY_VALUE_ASSERTION__PROPERTY, propertyIri);
        setContainmentReference(ontology, instanceIri, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, OmlPackage.Literals.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }

    // StructuredPropertyValueAssertion

    /**
     * Creates a structured property value assertion and adds it to the given ontology
     * 
     * @param ontology the context ontology
     * @param instanceIri the iri of the instance
     * @param propertyIri the iri of the structured property
     * @param value the asserted (structure instance) value of the property
     * @return a structured property value assertion that is added to the given description
     */
    public StructuredPropertyValueAssertion addStructuredPropertyValueAssertion(Ontology ontology, String instanceIri, String propertyIri, StructureInstance value) {
        final StructuredPropertyValueAssertion assertion = OmlWrite.addStructuredPropertyValueAssertion(ontology, null, null, value);
        setCrossReference(ontology, assertion, OmlPackage.Literals.STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY, propertyIri);
        setContainmentReference(ontology, instanceIri, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, OmlPackage.Literals.NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES, assertion);
        return assertion;
    }

    // LinkAssertion
        
    /**
     * Creates a link assertion and adds it to the given description
     * 
     * @param description the context description
     * @param sourceIri the iri of the (source) named instance
     * @param relationIri the iri of the relation type of the link
     * @param targetIri the iri of the (target) named instance
     * @return a link assertion that is added to the given description
     */
    public LinkAssertion addLinkAssertion(Description description, String sourceIri, String relationIri, String targetIri) {
        final LinkAssertion assertion = OmlWrite.addLinkAssertion(description, null, null, null);
        setCrossReference(description, assertion, OmlPackage.Literals.LINK_ASSERTION__RELATION, relationIri);
        setCrossReference(description, assertion, OmlPackage.Literals.LINK_ASSERTION__TARGET, targetIri);
        setContainmentReference(description, sourceIri, OmlPackage.Literals.NAMED_INSTANCE__OWNED_LINKS, OmlPackage.Literals.NAMED_INSTANCE_REFERENCE__OWNED_LINKS, assertion);
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
     * @param entityVariable the name of a variable bound to an instance of the relation entity
     * @param variable2 the name of a variable bound to a named instance representing the target of the relation entity
     * @return a relation entity predicate
     */
    public RelationEntityPredicate createRelationEntityPredicate(Vocabulary vocabulary, String entityIri, String variable1, String entityVariable, String variable2) {
        final RelationEntityPredicate predicate = OmlWrite.createRelationEntityPredicate(vocabulary, null, variable1, entityVariable, variable2);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__ENTITY, entityIri);
        return predicate;
    }

    // RelationPredicate

    /**
     * Creates an feature predicate
     * 
     * @param vocabulary the context vocabulary
     * @param featureIri the iri of the feature
     * @param variable1 the name of a variable bound to an instance
     * @param variable2 the name of a variable bound to a value of the feature in the instance
     * @return a relation predicate
     */
    public FeaturePredicate createFeaturePredicate(Vocabulary vocabulary, String featureIri, String variable1, String variable2) {
        final FeaturePredicate predicate = OmlWrite.createFeaturePredicate(vocabulary, null, variable1, variable2);
        setCrossReference(vocabulary, predicate, OmlPackage.Literals.FEATURE_PREDICATE__FEATURE, featureIri);
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