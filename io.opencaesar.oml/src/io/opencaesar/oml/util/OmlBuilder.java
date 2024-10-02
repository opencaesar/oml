/**
 * 
 * Copyright 2019-2021 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *	  http://www.apache.org/licenses/LICENSE-2.0
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
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityEquivalenceAxiom;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.ImportKind;
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
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertySelfRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RangeRestrictionKind;
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
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.UnreifiedRelation;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;

/**
 * The <b>Builder</b> API for Oml models. It leverages the {@link OmlWrite} API and provides additional services.
 *  
 * It allows clients to specify cross references by IRI and defers their resolution and setting until the build process is finished. 
 * This allows clients to have a single-phase build process as opposed to the typical two-phase builds (where objects are created 
 * in the first phase, and cross references are set in the second phase).
 * 
 * @author elaasar
 */
public class OmlBuilder {
	
	/*
	 * The cache of ontology-to-iri-to-member
	 */
	private final HashBasedTable<Ontology, String, Member> cache  = HashBasedTable.create();
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
		assert !eRef.isContainment() : eRef.getName()+" is a containment reference";
		
		final Class<? extends Member> objectClass = (Class<? extends Member>) eRef.getEType().getInstanceClass();
		assert Member.class.isAssignableFrom(objectClass) : eRef.getName()+" is not typed by Member or one of its subclasses";

		final Class<?> subjectClass = eRef.getEContainingClass().getInstanceClass();
		assert subjectClass.isInstance(subject) : subject+" is not an instance of "+subjectClass.getName();
				
		if (objectIri != null) {
			if (eRef.isMany()) {
				defer.add(() -> ((List<Element>)subject.eGet(eRef)).add(resolve(objectClass, ontology, objectIri)));
			} else {
				defer.add(() -> subject.eSet(eRef, resolve(objectClass, ontology, objectIri)));
			}
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
		assert !eRef.isContainment() : eRef.getName()+" is a containment reference";
		assert eRef.isMany() : eRef.getName()+" is a singular reference";
		
		final Class<? extends Member> objectClass = (Class<? extends Member>) eRef.getEType().getInstanceClass();
		assert Member.class.isAssignableFrom(objectClass) : eRef.getName()+" is not typed by Member or one of its subclasses";

		final Class<?> subjectClass = eRef.getEContainingClass().getInstanceClass();
		assert subjectClass.isInstance(subject) : subject+" is not an instance of "+subjectClass.getName();
				
		if (objectIris.iterator().hasNext()) {
			defer.add(() -> subject.eSet(eRef, objectIris.stream().map(objectIri -> resolve(objectClass, ontology, objectIri)).collect(Collectors.toList())));
		}
	}

	/**
	 * Sets the given object to be contained by the given subject that is resolved by iri in the context of the given ontology
	 * 
	 * @param ontology the given ontology
	 * @param subjectIri the given iri of a member to be resolved as subject
	 * @param eRef the containment eRef to use on subject if it belongs to the given ontology
	 * @param object the given object 
	 */
	@SuppressWarnings("unchecked")
	protected void setContainmentReference(Ontology ontology, String subjectIri, EReference eRef, Element object) {
		assert eRef.isContainment() : eRef.getName()+" is not a containment reference";

		final Class<? extends Element> objectClass = (Class<? extends Element>) eRef.getEType().getInstanceClass();
		assert objectClass.isInstance(object) : object+" is not an instance of "+objectClass.getName();
		
		defer.add(() -> {
			final Class<? extends Element> subjectClass = (Class<? extends Element>) eRef.getEContainingClass().getInstanceClass();
			Member subject = resolve(Member.class, ontology, subjectIri);
			// second condition is to cover forward/reverse rel cannot own specialization axiom
			if (subject.getOntology() != ontology || !subjectClass.isInstance(subject)) {
				subject = OmlWrite.getOrAddRef(ontology, subject);
			}
			assert subjectClass.isInstance(subject) : subject+" is not an instance of "+subjectClass.getName();
			
			if (eRef.isMany()) {
				((List<Element>)subject.eGet(eRef)).add(object);
			} else {
				subject.eSet(eRef, object);
			}
		});
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
	protected <T extends Member> T resolve(Class<T> type, Ontology context, String iri) {
		Member member = cache.get(context, iri);
		if (member == null) {
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
				if (obj instanceof Member) {
					member = (Member)obj;
				}
			}
			if (member == null) {
				throw new RuntimeException("could not resolve "+iri+" in context of "+context.getIri());
			}
			cache.put(context, iri, member);
		}
		if (type.isInstance(member)) {
			return type.cast(member);
		} else {
			throw new RuntimeException("resolved iri "+iri+" in context of "+context.getIri()+" to element of type "+member.getClass().getName()+" instead of expected type "+type.getName());
		}
	}
	
	// ------------------------------------------------------------------------------------
	
	// Annotation

	/**
	 * Adds a new annotation with a literal value on a given ontology
	 * 
	 * @param ontology the ontology to annotate
	 * @param propertyIri the annotation property identified by iri
	 * @param literalValue the annotation's literal value
	 * @return a new annotation on the given ontology
	 */
	public Annotation addAnnotation(Ontology ontology, String propertyIri, Literal literalValue) {
		final Annotation annotation = OmlWrite.addAnnotation(ontology, null, literalValue);
		setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, propertyIri);
		return annotation;
	}

	/**
	 * Adds a new annotation with a reference value (iri of a member) on a given ontology
	 * 
	 * @param ontology the ontology to annotate
	 * @param propertyIri the annotation property identified by iri
	 * @param referencedValueIri the annotation's referenced value (iri of a member)
	 * @return a new annotation on the given ontology
	 */
	public Annotation addAnnotation(Ontology ontology, String propertyIri, String referencedValueIri) {
		final Annotation annotation = OmlWrite.addAnnotation(ontology, null, new Member[0]);
	   	setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__REFERENCED_VALUES, referencedValueIri);
		setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, propertyIri);
		return annotation;
	}

	/**
	 * Adds a new annotation with literal values on a a given member (identified by iri) in the context of a given ontology
	 * 
	 * @param ontology the context ontology that will have the annotation axiom
	 * @param memberIri the iri of a member to put the annotation on
	 * @param propertyIri the annotation property identified by iri
	 * @param literalValues the annotation's literal values
	 * @return a new annotation on the given member in the context of the given ontology
	 */
	public Annotation addAnnotation(Ontology ontology, String memberIri, String propertyIri, Literal...literalValues) {
		final Annotation annotation = OmlWrite.addAnnotation(ontology, null, null, literalValues);
		setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, propertyIri);
		setContainmentReference(ontology, memberIri, OmlPackage.Literals.IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS, annotation);
		return annotation;
	}

	/**
	 * Adds a new annotation with a reference values (iris of members) in the context of a given ontology
	 * 
	 * @param ontology the context ontology that will have the annotation axiom
	 * @param memberIri the iri of a member to put the annotation on
	 * @param propertyIri the annotation property identified by iri
	 * @param referencedValueIris the annotation's referenced values i(ris of members)
	 * @return a new annotation on the given member in the context of the given ontology
	 */
	public Annotation addAnnotation(Ontology ontology, String memberIri, String propertyIri, String...referencedValueIris) {
		final Annotation annotation = OmlWrite.addAnnotation(ontology, null, null, new Member[0]);
	   	setCrossReferences(ontology, annotation, OmlPackage.Literals.ANNOTATION__REFERENCED_VALUES, Arrays.asList(referencedValueIris));
		setCrossReference(ontology, annotation, OmlPackage.Literals.ANNOTATION__PROPERTY, propertyIri);
		setContainmentReference(ontology, memberIri, OmlPackage.Literals.IDENTIFIED_ELEMENT__OWNED_ANNOTATIONS, annotation);
		return annotation;
	}

	// Vocabulary

	/**
	 * Creates a new vocabulary and add it as content of a resource with the given URI 
	 * 
	 * @param resourceURI the URI of a new resource to add the vocabulary to its contents
	 * @param namespace the namespace of the new vocabulary
	 * @param prefix the prefix of the new vocabulary
	 * @return a newly created vocabulary added to the contents of a resource with the given URI
	 */
	public Vocabulary createVocabulary(URI resourceURI, String namespace, String prefix) {
		final Vocabulary vocabulary = OmlWrite.createVocabulary(namespace, prefix);
		addToNewResources(vocabulary, resourceURI);
		return vocabulary;
	}

	// VocabularyBundle
	
	/**
	 * Creates a new vocabulary bundle and add it as content of a resource with the given URI 
	 * 
	 * @param resourceURI the URI of a new resource to add the vocabulary bundle to its contents
	 * @param namespace the namespace of the new vocabulary bundle
	 * @param prefix the prefix of the new vocabulary bundle
	 * @return a newly created vocabulary bunel added to the contents of a resource with the given URI
	 */
	public VocabularyBundle createVocabularyBundle(URI resourceURI, String namespace, String prefix) {
		final VocabularyBundle bundle = OmlWrite.createVocabularyBundle(namespace, prefix);
		addToNewResources(bundle, resourceURI);
		return bundle;
	}

	// Description
	
	/**
	 * Creates a new description and add it as content of a resource with the given URI 
	 * 
	 * @param resourceURI the URI of a new resource to add the description to its contents
	 * @param namespace the namespace of the new description
	 * @param prefix the prefix of the new description
	 * @return a newly created description added to the contents of a resource with the given URI
	 */
	public Description createDescription(URI resourceURI, String namespace, String prefix) {
		final Description description = OmlWrite.createDescription(namespace, prefix);
		addToNewResources(description, resourceURI);
		return description;
	}

	// DescriptionBundle

	/**
	 * Creates a new description bundle and add it as content of a resource with the given URI 
	 * 
	 * @param resourceURI the URI of a new resource to add the description bundle to its contents
	 * @param namespace the namespace of the new description bundle
	 * @param prefix the prefix of the new description bundle
	 * @return a newly created description bundle added to the contents of a resource with the given URI
	 */
	
	public DescriptionBundle createDescriptionBundle(URI resourceURI, String namespace, String prefix) {
		final DescriptionBundle bundle = OmlWrite.createDescriptionBundle(namespace, prefix);
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
	 * @param name the name of the new relation entity
	 * @param sourceIris the iris of the source entities
	 * @param targetIris the iris of the target entities
	 * @param functional whether the relation entity is functional
	 * @param inverseFunctional whether the relation entity is inverse functional
	 * @param symmetric whether the relation entity is symmetric
	 * @param asymmetric whether the relation entity is asymmetric
	 * @param reflexive whether the relation entity is reflexive
	 * @param irreflexive whether the relation entity is irreflexive
	 * @param transitive whether the relation entity is transitive
	 * @return a new relation entity that is added to the given vocabulary
	 */
	public RelationEntity addRelationEntity(Vocabulary vocabulary, String name, List<String> sourceIris, List<String> targetIris, 
		boolean functional, boolean inverseFunctional, boolean symmetric, 
		boolean asymmetric, boolean reflexive, boolean irreflexive, boolean transitive) {
		final RelationEntity relationEntity = OmlWrite.addRelationEntity(vocabulary, name, Collections.emptyList(), Collections.emptyList(), functional, inverseFunctional, symmetric, asymmetric, reflexive, irreflexive, transitive);
		setCrossReferences(vocabulary, relationEntity, OmlPackage.Literals.RELATION_BASE__SOURCES, sourceIris);
		setCrossReferences(vocabulary, relationEntity, OmlPackage.Literals.RELATION_BASE__TARGETS, targetIris);
		return relationEntity;
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
	 * @param domainIris the iris of the domain entities
	 * @param rangeIris the iris of the range scalars
	 * @param functional whether the scalar property is functional
	 * @return a new scalar property that is added to the given vocabulary
	 */
	public ScalarProperty addScalarProperty(Vocabulary vocabulary, String name,
		List<String> domainIris, List<String> rangeIris, boolean functional) {
		final ScalarProperty property = OmlWrite.addScalarProperty(vocabulary, name, Collections.emptyList(), Collections.emptyList(), functional);
		setCrossReferences(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__DOMAINS, domainIris);
		setCrossReferences(vocabulary, property, OmlPackage.Literals.SCALAR_PROPERTY__RANGES, rangeIris);
		return property;
	}
	
	/**
	 * Sets a scalar property details in the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param propertyIri the iri of the scalar property
	 * @param domainIri the iri of a domain entity
	 * @param rangeIri the iri of a range scalar
	 * @param functional whether the scalar property is functional (can be null)
	 */
	public void setScalarProperty(Vocabulary vocabulary, String propertyIri,
		String domainIri, String rangeIri, Boolean functional) {
		defer.add(() -> {
			ScalarProperty property = resolve(ScalarProperty.class, vocabulary, propertyIri);
			if (property.getOntology() != vocabulary) {
				property = (ScalarProperty) OmlWrite.getOrAddRef(vocabulary, property);
			}
			if (domainIri != null) {
				property.getDomains().add(resolve(Entity.class, vocabulary, domainIri));
			}
			if (rangeIri != null) {
				property.getRanges().add(resolve(Scalar.class, vocabulary, rangeIri));
			}
			if (functional != null) {
				property.setFunctional(functional);
			}
		});
	}

	// Scalar

	/**
	 * Creates a new scalar and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param name the name of the new faceted scalar
	 * @return a new scalar that is added to the given vocabulary
	 */
	public Scalar addScalar(Vocabulary vocabulary, String name) {
		final Scalar scalar = OmlWrite.addScalar(vocabulary, name);
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
	 * @param name the name of the new relation
	 * @param sourceIris the iri of the source entity
	 * @param targetIris the iri of the target entity
	 * @param functional whether the relation entity is functional
	 * @param inverseFunctional whether the relation entity is inverse functional
	 * @param symmetric whether the relation entity is symmetric
	 * @param asymmetric whether the relation entity is asymmetric
	 * @param reflexive whether the relation entity is reflexive
	 * @param irreflexive whether the relation entity is irreflexive
	 * @param transitive whether the relation entity is transitive
	 * @return a new relation entity that is added to the given vocabulary
	 */
	public UnreifiedRelation addUnreifiedRelation(Vocabulary vocabulary, String name, List<String> sourceIris, List<String> targetIris, 
		boolean functional, boolean inverseFunctional, boolean symmetric, 
		boolean asymmetric, boolean reflexive, boolean irreflexive, boolean transitive) {
		final UnreifiedRelation relation = OmlWrite.addUnreifiedRelation(vocabulary, name, Collections.emptyList(), Collections.emptyList(), functional, inverseFunctional, symmetric, asymmetric, reflexive, irreflexive, transitive);
		setCrossReferences(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__SOURCES, sourceIris);
		setCrossReferences(vocabulary, relation, OmlPackage.Literals.RELATION_BASE__TARGETS, targetIris);
		return relation;
	}

	/**
	 * Sets relation base details in the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param relationIri the iri of the relation
	 * @param sourceIri the iri of a source entity
	 * @param targetIri the iri of a target entity
	 * @param functional whether the relation entity is functional
	 * @param inverseFunctional whether the relation entity is inverse functional
	 * @param symmetric whether the relation entity is symmetric
	 * @param asymmetric whether the relation entity is asymmetric
	 * @param reflexive whether the relation entity is reflexive
	 * @param irreflexive whether the relation entity is irreflexive
	 * @param transitive whether the relation entity is transitive
	 */
	public void setRelationBase(Vocabulary vocabulary, String relationIri, String sourceIri, String targetIri, 
		Boolean functional, Boolean inverseFunctional, Boolean symmetric, 
		Boolean asymmetric, Boolean reflexive, Boolean irreflexive, Boolean transitive) {
		defer.add(() -> {
			RelationBase relation = resolve(RelationBase.class, vocabulary, relationIri);
			if (relation.getOntology() != vocabulary) {
				relation = (RelationBase) OmlWrite.getOrAddRef(vocabulary, relation);
			}
			if (sourceIri != null) {
				relation.getSources().add(resolve(Entity.class, vocabulary, sourceIri));
			}
			if (targetIri != null) {
				relation.getTargets().add(resolve(Entity.class, vocabulary, targetIri));
			}
			if (functional != null) {
				relation.setFunctional(functional);
			}
			if (inverseFunctional != null) {
				relation.setInverseFunctional(inverseFunctional);
			}
			if (symmetric != null) {
				relation.setSymmetric(symmetric);
			}
			if (asymmetric != null) {
				relation.setAsymmetric(asymmetric);
			}
			if (reflexive != null) {
				relation.setReflexive(reflexive);
			}
			if (irreflexive != null) {
				relation.setIrreflexive(irreflexive);
			}
			if (transitive != null) {
				relation.setTransitive(transitive);
			}
		});
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
	public Rule addRule(Vocabulary vocabulary, String name, Predicate[] antecedent, Predicate[] consequent) {
		final Rule rule = OmlWrite.addRule(vocabulary, name, antecedent, consequent);
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
	public BuiltIn addBuiltIn(Vocabulary vocabulary, String name) {
		final BuiltIn builtIn = OmlWrite.addBuiltIn(vocabulary, name);
		return builtIn;
	}

	// AnonymousConceptInstance

	/**
	 * Creates a entity instance and adds it to the given ontology
	 * 
	 * @param ontology the context ontology
	 * @param entityIri the iri of a entity that is the type of the entity instance
	 * @return a entity instance that is added to the given ontology
	 */
	public AnonymousConceptInstance createAnonymousConceptInstance(Ontology ontology, String entityIri) {
		final AnonymousConceptInstance instance = OmlWrite.createAnonymousConceptInstance(ontology, null);
		setCrossReference(ontology, instance, OmlPackage.Literals.ANONYMOUS_CONCEPT_INSTANCE__TYPE, entityIri);
		return instance;
	}

	// AnonymousRelationInstance

	/**
	 * Creates an anonymous relation instance and adds it to the given ontology
	 * 
	 * @param ontology the context ontology
	 * @param targetIri the given iri of the target instance of the anonymous relation instance
	 * @return an anonymous relation instance that is added to the given ontology
	 */
	public AnonymousRelationInstance createAnonymousRelationInstance(Ontology ontology, String targetIri) {
		final AnonymousRelationInstance instance = OmlWrite.createAnonymousRelationInstance(ontology, null);
		setCrossReference(ontology, instance, OmlPackage.Literals.ANONYMOUS_RELATION_INSTANCE__TARGET, targetIri);
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

	/**
	 * Sets a relation instance details in the given description
	 * 
	 * @param description the context description
	 * @param relationInstanceIri the iri of a relation instance
	 * @param sourceIri the iri of a source instance
	 * @param targetIri the iri of a target instance
	 */
	public void setRelationInstance(Description description, String relationInstanceIri, String sourceIri, String targetIri) {
		defer.add(() -> {
			RelationInstance relationInstance = resolve(RelationInstance.class, description, relationInstanceIri);
			if (relationInstance.getOntology() != description) {
				relationInstance = (RelationInstance) OmlWrite.getOrAddRef(description, relationInstance);
			}
			if (sourceIri != null) {
				relationInstance.getSources().add(resolve(NamedInstance.class, description, sourceIri));
			}
			if (targetIri != null) {
				relationInstance.getTargets().add(resolve(NamedInstance.class, description, targetIri));
			}
		});
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
	public Import addImport(Ontology ontology, ImportKind kind, String namespace, String prefix) {
		final Import import_ = OmlWrite.addImport(ontology, kind, namespace, prefix);
		return import_;
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
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM, superTermIri);
		setContainmentReference(vocabulary, subTermIri, OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS, axiom);
		return axiom;
	}
	
	// EntityEquivalenceAxiom

	/**
	 * Creates a entity equivalence axiom between the sub entity and super entities and adds it to the given vocabulary
	 *  
	 * @param vocabulary the context vocabulary
	 * @param subEntityIri the given iri of sub entity
	 * @param superEntityIris the given iris of super entities
	 * @return a entity equivalence axiom that is added to the vocabulary
	 */
	public EntityEquivalenceAxiom addEntityEquivalenceAxiom(Vocabulary vocabulary, String subEntityIri, List<String> superEntityIris) {
		final EntityEquivalenceAxiom axiom = OmlWrite.addEntityEquivalenceAxiom(vocabulary, null, Collections.emptyList());
		setCrossReferences(vocabulary, axiom, OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES, superEntityIris);
		setContainmentReference(vocabulary, subEntityIri, OmlPackage.Literals.ENTITY__OWNED_EQUIVALENCES, axiom);
		return axiom;
	}

	// ScalarEquivalenceAxiom

	/**
	 * Creates a scalar equivalence axiom between the sub scalar and super scalar and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param subScalarIri the given iri of sub scalar
	 * @param superScalarIri the given iri of super scalar
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
	public ScalarEquivalenceAxiom addScalarEquivalenceAxiom(Vocabulary vocabulary, String subScalarIri, String superScalarIri, Integer length, Integer minLength, Integer maxLength, String pattern, 
		String language, Literal minInclusive, Literal minExclusive, Literal maxInclusive, Literal maxExclusive) {
		final ScalarEquivalenceAxiom axiom = OmlWrite.addScalarEquivalenceAxiom(vocabulary, null, null, length, minLength, maxLength, pattern, language, minInclusive, minExclusive, maxInclusive, maxExclusive);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR, superScalarIri);
		setContainmentReference(vocabulary, subScalarIri, OmlPackage.Literals.SCALAR__OWNED_EQUIVALENCES, axiom);
		return axiom;
	}

	// PropertyEquivalenceAxiom

	/**
	 * Creates a property equivalence axiom between the sub property and super property and adds it to the given vocabulary
	 *  
	 * @param vocabulary the context vocabulary
	 * @param subPropertyIri the iri of the given sub property
	 * @param superPropertyIri the iri of the given super property
	 * @return a property equivalence axiom that is added to the vocabulary
	 */
	public PropertyEquivalenceAxiom addPropertyEquivalenceAxiom(Vocabulary vocabulary, String subPropertyIri, String superPropertyIri) {
		final PropertyEquivalenceAxiom axiom = OmlWrite.addPropertyEquivalenceAxiom(vocabulary, null, null);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY, superPropertyIri);
		setContainmentReference(vocabulary, subPropertyIri, OmlPackage.Literals.SPECIALIZABLE_PROPERTY__OWNED_EQUIVALENCES, axiom);
		return axiom;
	}

	// PropertyRangeRestrictionAxiom

	/**
	 * Creates a property range restriction axiom and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param owner the owner (either a String representing the iri of the owning entity, or the owning entity equivalence axiom object)
	 * @param propertyIri the iri of the restricted property
	 * @param rangeIri the iri of the restricted range
	 * @param restrictionKind the kind of the restriction
	 * @return a property range restriction axiom that is added to the given vocabulary
	 */
	public PropertyRangeRestrictionAxiom addPropertyRangeRestrictionAxiom(Vocabulary vocabulary, Object owner, String propertyIri, String rangeIri, RangeRestrictionKind restrictionKind) {
		final PropertyRangeRestrictionAxiom axiom = OmlWrite.addPropertyRangeRestrictionAxiom(vocabulary, null, null, null, restrictionKind);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, rangeIri);
		if (owner instanceof String) {
			setContainmentReference(vocabulary, (String)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
		} else if (owner instanceof EntityEquivalenceAxiom) {
			((EntityEquivalenceAxiom)owner).getOwnedPropertyRestrictions().add(axiom);
		}
		return axiom;
	}

	// PropertyCardinalityRestrictionAxiom

	/**
	 * Creates a property cardinality restriction axiom and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param owner the owner (either a String representing the iri of the owning entity, or the owning entity equivalence axiom object)
	 * @param propertyIri the iri of the restricted property
	 * @param cardinality the restricted cardinality
	 * @param rangeIri the iri of the restricted range (optional)
	 * @param restrictionKind the kind of the restriction
	 * @return a property cardinality restriction axiom that is added to the given vocabulary
	 */
	public PropertyCardinalityRestrictionAxiom addPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, Object owner, String propertyIri, CardinalityRestrictionKind restrictionKind, int cardinality, String rangeIri) {
		final PropertyCardinalityRestrictionAxiom axiom = OmlWrite.addPropertyCardinalityRestrictionAxiom(vocabulary, null, null, restrictionKind, cardinality, null);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, rangeIri);
		if (owner instanceof String) {
			setContainmentReference(vocabulary, (String)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
		} else if (owner instanceof EntityEquivalenceAxiom) {
			((EntityEquivalenceAxiom)owner).getOwnedPropertyRestrictions().add(axiom);
		}
		return axiom;
	}

	// PropertyValueRestrictionAxiom

	/**
	 * Creates a property value restriction axiom for a scalar property and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param owner the owner (either a String representing the iri of the owning entity, or the owning entity equivalence axiom object)
	 * @param propertyIri the iri of the restricted scalar property
	 * @param literal the (literal) value of the restriction
	 * @return a property value restriction axiom that is added to the given vocabulary
	 */
	public PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, Object owner, String propertyIri, Literal literal) {
		final PropertyValueRestrictionAxiom axiom = OmlWrite.addPropertyValueRestrictionAxiom(vocabulary, null, null, literal);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
		if (owner instanceof String) {
			setContainmentReference(vocabulary, (String)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
		} else if (owner instanceof EntityEquivalenceAxiom) {
			((EntityEquivalenceAxiom)owner).getOwnedPropertyRestrictions().add(axiom);
		}
		return axiom;
	}

	/**
	 * Creates a property value restriction axiom for a property and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param owner the owner (either a String representing the iri of the owning entity, or the owning entity equivalence axiom object)
	 * @param propertyIri the iri of the restricted property
	 * @param containedValue the contained value of the restriction
	 * @return a property value restriction axiom that is added to the given vocabulary
	 */
	public PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, Object owner, String propertyIri, AnonymousInstance containedValue) {
		final PropertyValueRestrictionAxiom axiom = OmlWrite.addPropertyValueRestrictionAxiom(vocabulary, null, null, containedValue);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, propertyIri);
		if (owner instanceof String) {
			setContainmentReference(vocabulary, (String)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
		} else if (owner instanceof EntityEquivalenceAxiom) {
			((EntityEquivalenceAxiom)owner).getOwnedPropertyRestrictions().add(axiom);
		}
		return axiom;
	}

	/**
	 * Creates a property value restriction axiom for a relation and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param owner the owner (either a String representing the iri of the owning entity, or the owning entity equivalence axiom object)
	 * @param relationIri the iri of the restricted relation
	 * @param referencedValueIri the Iri of a referenced value of the restriction
	 * @return a property value restriction axiom that is added to the given vocabulary
	 */
	public PropertyValueRestrictionAxiom addPropertyValueRestrictionAxiom(Vocabulary vocabulary, Object owner, String relationIri, String referencedValueIri) {
		final PropertyValueRestrictionAxiom axiom = OmlWrite.addPropertyValueRestrictionAxiom(vocabulary, null, null, (NamedInstance) null);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE, referencedValueIri);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, relationIri);
		if (owner instanceof String) {
			setContainmentReference(vocabulary, (String)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
		} else if (owner instanceof EntityEquivalenceAxiom) {
			((EntityEquivalenceAxiom)owner).getOwnedPropertyRestrictions().add(axiom);
		}
		return axiom;
	}

	/**
	 * Creates a property value restriction axiom for a forward relation and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param owner the owner (either a String representing the iri of the owning entity, or the owning entity equivalence axiom object)
	 * @param relationEntityIri the iri of the relation entity that owns the restricted forward relation
	 * @param containedValue the contained value of the restriction
	 * @return a property value restriction axiom that is added to the given vocabulary
	 */
	public PropertyValueRestrictionAxiom addForwardRelationValueRestrictionAxiom(Vocabulary vocabulary, Object owner, String relationEntityIri, AnonymousInstance containedValue) {
		final PropertyValueRestrictionAxiom axiom = OmlWrite.addPropertyValueRestrictionAxiom(vocabulary, null, null, containedValue);
		defer.add(() -> axiom.setProperty(resolve(RelationEntity.class, vocabulary, relationEntityIri).getForwardRelation()));
		if (owner instanceof String) {
			setContainmentReference(vocabulary, (String)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
		} else if (owner instanceof EntityEquivalenceAxiom) {
			((EntityEquivalenceAxiom)owner).getOwnedPropertyRestrictions().add(axiom);
		}
		return axiom;
	}

	/**
	 * Creates a property value restriction axiom for a reverse relation and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param owner the owner (either a String representing the iri of the owning entity, or the owning entity equivalence axiom object)
	 * @param relationBaseri the iri of the relation base that owns the restricted reverse relation
	 * @param containedValue the contained value of the restriction
	 * @return a property value restriction axiom that is added to the given vocabulary
	 */
	public PropertyValueRestrictionAxiom addReverseRelationValueRestrictionAxiom(Vocabulary vocabulary, Object owner, String relationBaseri, AnonymousInstance containedValue) {
		final PropertyValueRestrictionAxiom axiom = OmlWrite.addPropertyValueRestrictionAxiom(vocabulary, null, null, containedValue);
		defer.add(() -> axiom.setProperty(resolve(RelationBase.class, vocabulary, relationBaseri).getReverseRelation()));
		if (owner instanceof String) {
			setContainmentReference(vocabulary, (String)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
		} else if (owner instanceof EntityEquivalenceAxiom) {
			((EntityEquivalenceAxiom)owner).getOwnedPropertyRestrictions().add(axiom);
		}
		return axiom;
	}

	// PropertySelfRestrictionAxiom

	/**
	 * Creates a self restriction axiom on a relation and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param owner the given restricting owner (entity or entity equivalence axiom)
	 * @param relationIri the iri of the restricted relation
	 * @return a property value restriction axiom that is added to the given vocabulary
	 */
	public PropertySelfRestrictionAxiom addPropertySelfRestrictionAxiom(Vocabulary vocabulary, Object owner, String relationIri) {
		final PropertySelfRestrictionAxiom axiom = OmlWrite.addPropertySelfRestrictionAxiom(vocabulary, null, null);
		setCrossReference(vocabulary, axiom, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, relationIri);
		if (owner instanceof String) {
			setContainmentReference(vocabulary, (String)owner, OmlPackage.Literals.ENTITY__OWNED_PROPERTY_RESTRICTIONS, axiom);
		} else if (owner instanceof EntityEquivalenceAxiom) {
			((EntityEquivalenceAxiom)owner).getOwnedPropertyRestrictions().add(axiom);
		}
		return axiom;
	}

	// KeyAxiom

	/**
	 * Creates a key axiom and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param domainIri the iri of the (concept) domain
	 * @param keyPropertyIris the list of iris of the properties that are part of the key
	 * @return a key axiom that is added to the given vocabulary
	 */
	public KeyAxiom addKeyAxiom(Vocabulary vocabulary, String domainIri, List<String> keyPropertyIris) {
		final KeyAxiom axiom = OmlWrite.addKeyAxiom(vocabulary, null, Collections.emptyList());
		setCrossReferences(vocabulary, axiom, OmlPackage.Literals.KEY_AXIOM__PROPERTIES, keyPropertyIris);
		setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.ENTITY__OWNED_KEYS, axiom);
		return axiom;
	}

	// InstanceEnumerationAxiom

	/**
	 * Creates an instance enumeration axiom and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param domainIri the iri of the (concept) domain
	 * @param instanceIris the list of iris of the concept instances
	 * @return an instance enumeration axiom that is added to the given vocabulary
	 */
	public InstanceEnumerationAxiom addInstanceEnumerationAxiom(Vocabulary vocabulary, String domainIri, List<String> instanceIris) {
		final InstanceEnumerationAxiom axiom = OmlWrite.addInstanceEnumerationAxiom(vocabulary, null, Collections.emptyList());
		setCrossReferences(vocabulary, axiom, OmlPackage.Literals.INSTANCE_ENUMERATION_AXIOM__INSTANCES, instanceIris);
		setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.CONCEPT__OWNED_ENUMERATION, axiom);
		return axiom;
	}

	// LiteralEnumerationAxiom

	/**
	 * Creates an literal enumeration axiom and adds it to the given vocabulary
	 * 
	 * @param vocabulary the context vocabulary
	 * @param domainIri the iri of the (scalar) domain
	 * @param literals the list of enumerated literals
	 * @return a literal enumeration axiom that is added to the given vocabulary
	 */
	public LiteralEnumerationAxiom addLiteralEnumerationAxiom(Vocabulary vocabulary, String domainIri, Literal...literals) {
		final LiteralEnumerationAxiom axiom = OmlWrite.addLiteralEnumerationAxiom(vocabulary, null, literals);
		setContainmentReference(vocabulary, domainIri, OmlPackage.Literals.SCALAR__OWNED_ENUMERATION, axiom);
		return axiom;
	}

	// TypeAssertion
	
	/**
	 * Creates a type assertion and adds it to the given description
	 * 
	 * @param description the context description
	 * @param instanceIri the iri of the named instance
	 * @param typeIri the iri of the type
	 * @return a type assertion that is added to the given description
	 */
	public TypeAssertion addTypeAssertion(Description description, String instanceIri, String typeIri) {
		final TypeAssertion assertion = OmlWrite.addTypeAssertion(description, null, null);
		setCrossReference(description, assertion, OmlPackage.Literals.TYPE_ASSERTION__TYPE, typeIri);
		setContainmentReference(description, instanceIri, OmlPackage.Literals.NAMED_INSTANCE__OWNED_TYPES, assertion);
		return assertion;
	}

	// PropertyValueAssertion

	/**
	 * Creates a property value assertion with literal values and adds it to the given ontology
	 * 
	 * @param ontology the context ontology
	 * @param owner either an anonymous instance or the iri of a named instance
	 * @param propertyIri the iri of the scalar property
	 * @param literalValues the asserted (literal) values of the property
	 * @return a property value assertion that is added to the given description
	 */
	public PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, Object owner, String propertyIri, Literal...literalValues) {
		final PropertyValueAssertion assertion = OmlWrite.addPropertyValueAssertion(ontology, null, null, literalValues);
		setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, propertyIri);
		if (owner instanceof String) {
			setContainmentReference(ontology, (String)owner, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
		} else if (owner instanceof AnonymousInstance) {
			((AnonymousInstance)owner).getOwnedPropertyValues().add(assertion);
		}
		return assertion;
	}
	
	/**
	 * Creates a property value assertion with contained values and adds it to the given ontology
	 * 
	 * @param ontology the context ontology
	 * @param owner either an anonymous instance or the iri of a named instance
	 * @param propertyIri the iri of the property
	 * @param containedValues the asserted contained values of the property
	 * @return a property value assertion that is added to the given description
	 */
	public PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, Object owner, String propertyIri, AnonymousInstance...containedValues) {
		final PropertyValueAssertion assertion = OmlWrite.addPropertyValueAssertion(ontology, null, null, containedValues);
		setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, propertyIri);
		if (owner instanceof String) {
			setContainmentReference(ontology, (String)owner, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
		} else if (owner instanceof AnonymousInstance) {
			((AnonymousInstance)owner).getOwnedPropertyValues().add(assertion);
		}
		return assertion;
	}

	/**
	 * Creates a property value assertion with referenced values and adds it to the given ontology
	 * 
	 * @param ontology the context ontology
	 * @param owner either an anonymous instance or the iri of a named instance
	 * @param propertyIri the iri of the relation property
	 * @param referencedValueIris the asserted referenced values (iris of members) of the property
	 * @return a property value assertion that is added to the given description
	 */
	public PropertyValueAssertion addPropertyValueAssertion(Ontology ontology, Object owner, String propertyIri, String...referencedValueIris) {
		final PropertyValueAssertion assertion = OmlWrite.addPropertyValueAssertion(ontology, null, null, new NamedInstance[0]);
		setCrossReferences(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUES, Arrays.asList(referencedValueIris));
		setCrossReference(ontology, assertion, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, propertyIri);
		if (owner instanceof String) {
			setContainmentReference(ontology, (String)owner, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
		} else if (owner instanceof AnonymousInstance) {
			((AnonymousInstance)owner).getOwnedPropertyValues().add(assertion);
		}
		return assertion;
	}

	/**
	 * Creates a property value assertion for a forward relation with contained values and adds it to the given ontology
	 * 
	 * @param ontology the context ontology
	 * @param owner either an anonymous instance or the iri of a named instance
	 * @param relationEntityIri the iri of the relation entity that owns the forward relation
	 * @param containedValues the asserted contained values of the property
	 * @return a property value assertion that is added to the given description
	 */
	public PropertyValueAssertion addForwardRelationValueAssertion(Ontology ontology, Object owner, String relationEntityIri, AnonymousInstance...containedValues) {
		final PropertyValueAssertion assertion = OmlWrite.addPropertyValueAssertion(ontology, null, null, containedValues);
		defer.add(() -> assertion.setProperty(resolve(RelationEntity.class, ontology, relationEntityIri).getForwardRelation()));
		if (owner instanceof String) {
			setContainmentReference(ontology, (String)owner, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
		} else if (owner instanceof AnonymousInstance) {
			((AnonymousInstance)owner).getOwnedPropertyValues().add(assertion);
		}
		return assertion;
	}

	/**
	 * Creates a property value assertion for a reverse relation with contained values and adds it to the given ontology
	 * 
	 * @param ontology the context ontology
	 * @param owner either an anonymous instance or the iri of a named instance
	 * @param relationBaseIri the iri of the relation base that owns the reverse relation
	 * @param containedValues the asserted contained values of the property
	 * @return a property value assertion that is added to the given description
	 */
	public PropertyValueAssertion addReverseRelationValueAssertion(Ontology ontology, Object owner, String relationBaseIri, AnonymousInstance...containedValues) {
		final PropertyValueAssertion assertion = OmlWrite.addPropertyValueAssertion(ontology, null, null, containedValues);
		defer.add(() -> assertion.setProperty(resolve(RelationBase.class, ontology, relationBaseIri).getReverseRelation()));
		if (owner instanceof String) {
			setContainmentReference(ontology, (String)owner, OmlPackage.Literals.INSTANCE__OWNED_PROPERTY_VALUES, assertion);
		} else if (owner instanceof AnonymousInstance) {
			((AnonymousInstance)owner).getOwnedPropertyValues().add(assertion);
		}
		return assertion;
	}

	// Argument

	/**
	 * Creates an argument
	 * 
	 * @param vocabulary the context vocabulary
	 * @param variable a given variable name
	 * @param literal a given literal
	 * @param instanceIri an IRI of a given named instance
	 * @return an argument
	 */
	public Argument createArgument(Vocabulary vocabulary, String variable, Literal literal, String instanceIri) {
		final Argument argument = OmlWrite.createArgument(vocabulary, variable, literal, null);
		setCrossReference(vocabulary, argument, OmlPackage.Literals.ARGUMENT__INSTANCE, instanceIri);
		return argument;
	}

	//TypePredicate

	/**
	 * Creates a type predicate
	 * 
	 * @param vocabulary the context vocabulary
	 * @param typeIri the iri of the type
	 * @param argument the argument bound to a value of the type
	 * @return a type predicate
	 */
	public TypePredicate createTypePredicate(Vocabulary vocabulary, String typeIri, Argument argument) {
		final TypePredicate predicate = OmlWrite.createTypePredicate(vocabulary, null, argument);
		setCrossReference(vocabulary, predicate, OmlPackage.Literals.TYPE_PREDICATE__TYPE, typeIri);
		return predicate;
	}
	
	// RelationEntityPredicate

	/**
	 * Creates an relation entity predicate
	 * 
	 * @param vocabulary the context vocabulary
	 * @param typeIri the iri of the relation entity
	 * @param argument1 the argument bound to a named instance representing the source of a relation instance
	 * @param argument the argument bound to a relation instance
	 * @param argument2 the argument bound to a named instance representing the target of a relation instance
	 * @return a relation entity predicate
	 */
	public RelationEntityPredicate createRelationEntityPredicate(Vocabulary vocabulary, String typeIri, Argument argument1, Argument argument, Argument argument2) {
		final RelationEntityPredicate predicate = OmlWrite.createRelationEntityPredicate(vocabulary, null, argument1, argument, argument2);
		setCrossReference(vocabulary, predicate, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__TYPE, typeIri);
		return predicate;
	}

	// RelationPredicate

	/**
	 * Creates a property predicate
	 * 
	 * @param vocabulary the context vocabulary
	 * @param propertyIri the iri of the property
	 * @param argument1 the argument bound to a instance representing the subject of the given property
	 * @param argument2 the argument bound to a value representing the object of the given property
	 * @return a relation predicate
	 */
	public PropertyPredicate createPropertyPredicate(Vocabulary vocabulary, String propertyIri, Argument argument1, Argument argument2) {
		final PropertyPredicate predicate = OmlWrite.createPropertyPredicate(vocabulary, null, argument1, argument2);
		setCrossReference(vocabulary, predicate, OmlPackage.Literals.PROPERTY_PREDICATE__PROPERTY, propertyIri);
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
	public SameAsPredicate createSameAsPredicate(Vocabulary vocabulary, Argument argument1, Argument argument2) {
		final SameAsPredicate predicate = OmlWrite.createSameAsPredicate(vocabulary, argument1, argument2);
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
	public DifferentFromPredicate createDifferentFromPredicate(Vocabulary vocabulary, Argument argument1, Argument argument2) {
		final DifferentFromPredicate predicate = OmlWrite.createDifferentFromPredicate(vocabulary, argument1, argument2);
		return predicate;
	}

	// BuiltInPredicate

	/**
	 * Creates a builtIn predicate
	 * 
	 * @param vocabulary the context vocabulary
	 * @param builtInIri the given builtIn IRI
	 * @param arguments the arguments of the builtin
	 * @return a builtIn predicate
	 */
	public BuiltInPredicate createBuiltInPredicate(Vocabulary vocabulary, String builtInIri, Argument... arguments ) {
		final BuiltInPredicate predicate = OmlWrite.createBuiltInPredicate(vocabulary, null, arguments);
		setCrossReference(vocabulary, predicate, OmlPackage.Literals.BUILT_IN_PREDICATE__BUILT_IN, builtInIri);
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
		
	/**
	 * Creates a literal
	 * 
	 * @param value the value of the literal
	 * @return a literal
	 */
	public Literal createLiteral(Object value) {
		final Literal literal = OmlWrite.createLiteral(value);
		return literal;
	}

}