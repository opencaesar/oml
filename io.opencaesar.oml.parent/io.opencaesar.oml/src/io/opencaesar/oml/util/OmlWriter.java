/**
 * 
 * Copyright 2019 California Institute of Technology ("Caltech").
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

import static org.eclipse.xtext.xbase.lib.IterableExtensions.findFirst;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.map;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.HashBasedTable;

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.CardinalityRestrictionKind;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierReference;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionBundleExtension;
import io.opencaesar.oml.DescriptionBundleInclusion;
import io.opencaesar.oml.DescriptionBundleUsage;
import io.opencaesar.oml.DescriptionExtension;
import io.opencaesar.oml.DescriptionStatement;
import io.opencaesar.oml.DescriptionUsage;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityPredicate;
import io.opencaesar.oml.EntityReference;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.NamedInstanceReference;
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
import io.opencaesar.oml.RelationPredicate;
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
import io.opencaesar.oml.SpecializableTermReference;
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
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyStatement;
import io.opencaesar.oml.VocabularyUsage;

public class OmlWriter {
	
	private static final HashBasedTable<Ontology, String, Element> table  = HashBasedTable.create();

	private final ResourceSet resourceSet;
	private final Set<Resource> newResources = new LinkedHashSet<>();
	private final List<Runnable> defer = new ArrayList<>();

	public OmlWriter(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	protected <T extends IdentifiedElement> T resolve(Class<T> type, Ontology context, String iri) {
		Element element = table.get(context, iri);
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
			Resource resource;
			if (context.getIri().equals(baseIri)) {
				resource = context.eResource();
			} else {
				Ontology ontology = OmlRead.getImportedOntologyByIri(context, baseIri);
				resource = (ontology != null) ? ontology.eResource() : null;
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
			table.put(context, iri, element);
		}
		return type.cast(element);
	}
	
	protected <T extends Element> T create(Class<T> type) {
		return OmlWrite.INSTANCE.create(type);
	}

	protected <T extends Reference> T getOrAddReference(Ontology ontology, Member member, Class<T> type) {
		Reference reference = type.cast(findFirst(OmlRead.getReferences(ontology), i -> OmlRead.resolve(i) == member));
		if (reference == null) {
			reference = type.cast(createReference(member));
			if (ontology instanceof Vocabulary) {
				((Vocabulary) ontology).getOwnedStatements().add((VocabularyStatement) reference);
			} else if (ontology instanceof Description) {
				((Description) ontology).getOwnedStatements().add((DescriptionStatement) reference); 
			}
		}
		return type.cast(reference);
	}

	protected void addToNewResource(Ontology ontology, URI resourceURI) {
		final Resource resource = resourceSet.createResource(resourceURI);
		resource.getContents().add(ontology);
		newResources.add(resource);
	}
	
	public void loadDependentResource(URI resourceURI) {
		resourceSet.getResource(resourceURI, true);
	}
	
	public void start() {
		EcoreUtil.resolveAll(resourceSet);
	}
	
	public void finish() {
		defer.forEach(p -> p.run());
		defer.clear();
	}
	
	public Collection<Resource> getNewResources() {
		return newResources;
	}	

	// ------------------------------------------------------------------------------------
	
	// Annotation

	public Annotation addAnnotation(Ontology ontology, String memberIri, String propertyIri, Literal value) {
		final Annotation annotation = create(Annotation.class);
		defer.add(() -> annotation.setProperty(resolve(AnnotationProperty.class, ontology, propertyIri)));
		annotation.setValue(value);
		defer.add(() -> {
			final Member member = resolve(Member.class, ontology, memberIri);
			if (OmlRead.getOntology(member) == ontology) {
				member.getOwnedAnnotations().add(annotation);
			} else {
				getOrAddReference(ontology, member, Reference.class).getOwnedAnnotations().add(annotation); 
			}
		});
		return annotation;
	}

	public Annotation addAnnotation(AnnotatedElement element, String propertyIri, Literal value) {
		final Annotation annotation = create(Annotation.class);
		defer.add(() -> annotation.setProperty(resolve(AnnotationProperty.class, OmlRead.getOntology(element), propertyIri)));
		annotation.setValue(value);
		element.getOwnedAnnotations().add(annotation);
		return annotation;
	}

	// Ontology
	
	public <T extends Ontology> T createOntology(Class<T> type, URI resourceURI, String iri, SeparatorKind separator, String prefix) {
		final T ontology = create(type);
		ontology.setIri(iri);
		ontology.setSeparator(separator);
		ontology.setPrefix(prefix);
		addToNewResource(ontology, resourceURI);
		return type.cast(ontology);
	}

	// Vocabulary

	public Vocabulary createVocabulary(URI resourceURI, String iri, SeparatorKind separator, String name) {
		return createOntology(Vocabulary.class, resourceURI, iri, separator, name);
	}

	// VocabularyBundle
	
	public VocabularyBundle createVocabularyBundle(URI resourceURI, String iri, SeparatorKind separator, String name) {
		return createOntology(VocabularyBundle.class, resourceURI, iri, separator, name);
	}

	// Description
	
	public Description createDescription(URI resourceURI, String iri, SeparatorKind separator, String name) {
		return createOntology(Description.class, resourceURI, iri, separator, name);
	}

	// DescriptionBundle
	
	public DescriptionBundle createDescriptionBundle(URI resourceURI, String iri, SeparatorKind separator, String name) {
		return createOntology(DescriptionBundle.class, resourceURI, iri, separator, name);
	}

	// Aspect

	public Aspect addAspect(Vocabulary vocabulary, String name) {
		final Aspect aspect = create(Aspect.class);
		aspect.setName(name);
		vocabulary.getOwnedStatements().add(aspect);
		return aspect;
	}
	
	// Concept

	public Concept addConcept(Vocabulary vocabulary, String name) {
		final Concept concept = create(Concept.class);
		concept.setName(name);
		vocabulary.getOwnedStatements().add(concept);
		return concept;
	}

	// RelationEntity
	
	public RelationEntity addRelationEntity(Vocabulary vocabulary, String name, String sourceIri, String targetIri, 
		boolean functional, boolean inverseFunctional, boolean symmetric, 
		boolean asymmetric, boolean reflexive, boolean irreflexive, boolean transitive) {
		final RelationEntity relation = create(RelationEntity.class);
		relation.setName(name);
		defer.add(() -> relation.setSource(resolve(Entity.class, vocabulary, sourceIri)));
		defer.add(() -> relation.setTarget(resolve(Entity.class, vocabulary, targetIri)));
		relation.setFunctional(functional);
		relation.setInverseFunctional(inverseFunctional);
		relation.setSymmetric(symmetric);
		relation.setAsymmetric(asymmetric);
		relation.setReflexive(reflexive);
		relation.setIrreflexive(irreflexive);
		relation.setTransitive(transitive);
		vocabulary.getOwnedStatements().add(relation);
		return relation;
	}

	// Structure

	public Structure addStructure(Vocabulary vocabulary, String name) {
		final Structure structure = create(Structure.class);
		structure.setName(name);
		vocabulary.getOwnedStatements().add(structure);
		return structure;
	}
	
	// AnnotationProperty

	public AnnotationProperty addAnnotationProperty(Vocabulary vocabulary, String name) {
		final AnnotationProperty property = create(AnnotationProperty.class);
		property.setName(name);
		vocabulary.getOwnedStatements().add(property);
		return property;
	}
	
	// ScalarProperty

	public ScalarProperty addScalarProperty(Vocabulary vocabulary, String name,
		String domainIri, String rangeIri, boolean functional) {
		final ScalarProperty property = create(ScalarProperty.class);
		property.setName(name);
		defer.add(() -> property.setDomain(resolve(Classifier.class, vocabulary, domainIri)));
		defer.add(() -> property.setRange(resolve(Scalar.class, vocabulary, rangeIri)));
		property.setFunctional(functional);
		vocabulary.getOwnedStatements().add(property);
		return property;
	}
	
	// StructuredProperty

	public StructuredProperty addStructuredProperty(Vocabulary vocabulary, String name, 
		String domainIri, String rangeIri, boolean functional) {
		final StructuredProperty property = create(StructuredProperty.class);
		property.setName(name);
		defer.add(() -> property.setDomain(resolve(Classifier.class, vocabulary, domainIri)));
		defer.add(() -> property.setRange(resolve(Structure.class, vocabulary, rangeIri)));
		property.setFunctional(functional);
		vocabulary.getOwnedStatements().add(property);
		return property;
	}
	
	// FacetedScalar

	public FacetedScalar addFacetedScalar(Vocabulary vocabulary, String name, Long length, Long minLength, Long maxLength, String pattern, 
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

	public EnumeratedScalar addEnumeratedScalar(Vocabulary vocabulary, String name, Literal...literals) {
		final EnumeratedScalar scalar = create(EnumeratedScalar.class);
		scalar.setName(name);
		scalar.getLiterals().addAll(Arrays.asList(literals));
		vocabulary.getOwnedStatements().add(scalar);
		return scalar;
	}
	
	// ForwardRelation

	public ForwardRelation addForwardRelation(RelationEntity entity, String name) {
		final ForwardRelation forward = create(ForwardRelation.class);
		forward.setName(name);
		entity.setForward(forward);
		return forward;
	}

	// ReverseRelation

	public ReverseRelation addReverseRelation(RelationEntity entity, String name) {
		final ReverseRelation reverse = create(ReverseRelation.class);
		reverse.setName(name);
		entity.setReverse(reverse);
		return reverse;
	}
	
	// Rule

	public Rule addRule(Vocabulary vocabulary, String name, Predicate[] consequent, Predicate[] antecedent) {
		final Rule rule = create(Rule.class);
		rule.setName(name);
		rule.getConsequent().addAll(Arrays.asList(consequent));
		rule.getAntecedent().addAll(Arrays.asList(antecedent));
		vocabulary.getOwnedStatements().add(rule);
		return rule;
	}
	
	// StructureInstance

	public StructureInstance createStructureInstance(Ontology ontology, String structureIri) {
		final StructureInstance instance = create(StructureInstance.class);
		defer.add(() -> instance.setType(resolve(Structure.class, ontology, structureIri)));
		return instance;
	}
	
	// ConceptInstance

	public ConceptInstance addConceptInstance(Description description, String name) {
		final ConceptInstance instance = create(ConceptInstance.class);
		instance.setName(name);
		description.getOwnedStatements().add(instance);
		return instance;
	}
	
	// RelationInstance

	public RelationInstance addRelationInstance(Description description, String name, String sourceIri, String targetIri) {
		final RelationInstance instance = create(RelationInstance.class);
		instance.setName(name);
		defer.add(() -> instance.setSource(resolve(NamedInstance.class, description, sourceIri)));
		defer.add(() -> instance.setTarget(resolve(NamedInstance.class, description, targetIri)));
		description.getOwnedStatements().add(instance);
		return instance;
	}

	// MemerReference

	public Reference createReference(Member member) {
		if (member instanceof Aspect) {
			return createReference((Aspect) member);
		} else if (member instanceof Concept) {
			return createReference((Concept) member);
		} else if (member instanceof ConceptInstance) {
			return createReference((ConceptInstance) member);
		} else if (member instanceof EnumeratedScalar) {
			return createReference((EnumeratedScalar) member);
		} else if (member instanceof FacetedScalar) {
			return createReference((FacetedScalar) member);
		} else if (member instanceof Relation) {
			return createReference((Relation) member);
		} else if (member instanceof RelationEntity) {
			return createReference((RelationEntity) member);
		} else if (member instanceof RelationInstance) {
			return createReference((RelationInstance) member);
		} else if (member instanceof Rule) {
			return createReference((Rule) member);
		} else if (member instanceof ScalarProperty) {
			return createReference((ScalarProperty) member);
		} else if (member instanceof Structure) {
			return createReference((Structure) member);
		} else if (member instanceof StructuredProperty) {
			return createReference((StructuredProperty) member);
		}
		return null;
	}
	
	// AspectReference
	
	public AspectReference createReference(Aspect aspect) {
		final AspectReference reference = create(AspectReference.class);
		reference.setAspect(aspect);
		return reference;
	}

	// ConceptReference

	public ConceptReference createReference(Concept concept) {
		final ConceptReference reference = create(ConceptReference.class);
		reference.setConcept(concept);
		return reference;
	}
	
	// RelationEntityReference

	public RelationEntityReference createReference(RelationEntity entity) {
		final RelationEntityReference reference = create(RelationEntityReference.class);
		reference.setEntity(entity);
		return reference;
	}
	
	// StructureReference

	public StructureReference createReference(Structure structure) {
		final StructureReference reference = create(StructureReference.class);
		reference.setStructure(structure);
		return reference;
	}
	
	// AnnotationPropertyReference

	public AnnotationPropertyReference createReference(AnnotationProperty property) {
		AnnotationPropertyReference reference = create(AnnotationPropertyReference.class);
		reference.setProperty(property);
		return reference;
	}

	// ScalarPropertyReference

	public ScalarPropertyReference createReference(ScalarProperty property) {
		ScalarPropertyReference reference = create(ScalarPropertyReference.class);
		reference.setProperty(property);
		return reference;
	}
	
	// StructuredPropertyReference

	public StructuredPropertyReference createReference(StructuredProperty property) {
		StructuredPropertyReference reference = create(StructuredPropertyReference.class);
		reference.setProperty(property);
		return reference;
	}
	
	// FacetedScalarReference

	public FacetedScalarReference createReference(FacetedScalar scalar) {
		FacetedScalarReference reference = create(FacetedScalarReference.class);
		reference.setScalar(scalar);
		return reference;
	}
	
	// EnumeratedScalarReference

	public EnumeratedScalarReference createReference(EnumeratedScalar scalar) {
		EnumeratedScalarReference reference = create(EnumeratedScalarReference.class);
		reference.setScalar(scalar);
		return reference;
	}

	// RelationReference

	protected RelationReference createReference(Relation relation) {
		RelationReference reference = create(RelationReference.class);
		reference.setRelation(relation);
		return reference;
	}
	
	// RuleReference

	public RuleReference createReference(Rule rule) {
		RuleReference reference = create(RuleReference.class);
		reference.setRule(rule);
		return reference;
	}
	
	// ConceptInstanceReference

	public ConceptInstanceReference createReference(ConceptInstance instance) {
		ConceptInstanceReference reference = create(ConceptInstanceReference.class);
		reference.setInstance(instance);
		return reference;
	}

	// RelationInstanceReference

	public RelationInstanceReference createReference(RelationInstance instance) {
		RelationInstanceReference reference = create(RelationInstanceReference.class);
		reference.setInstance(instance);
		return reference;
	}
	
	// VocabularyExtension
	
	public VocabularyExtension addVocabularyExtension(Vocabulary vocabulary, String extenedVocabularyURI, String extenedVocabularyPrefix) {
		final VocabularyExtension extension = create(VocabularyExtension.class);
		extension.setUri(extenedVocabularyURI);
		extension.setPrefix(extenedVocabularyPrefix);
		vocabulary.getOwnedImports().add(extension);
		return extension;
	}

	// VocabularyUsage
	
	public VocabularyUsage addVocabularyUsage(Vocabulary vocabulary, String usedDescriptionBoxURI, String usedDescriptionBoxPrefix) {
		final VocabularyUsage usage = create(VocabularyUsage.class);
		usage.setUri(usedDescriptionBoxURI);
		usage.setPrefix(usedDescriptionBoxPrefix);
		vocabulary.getOwnedImports().add(usage);
		return usage;
	}

	// VocabularyBundleExtension
	
	public VocabularyBundleExtension addVocabularyBundleExtension(VocabularyBundle bundle, String extenedVocabularyBundleURI, String extenedVocabularyBundlePrefix) {
		final VocabularyBundleExtension extension = create(VocabularyBundleExtension.class);
		extension.setUri(extenedVocabularyBundleURI);
		extension.setPrefix(extenedVocabularyBundlePrefix);
		bundle.getOwnedImports().add(extension);
		return extension;
	}

	// VocabularyBundleInclusion
	
	public VocabularyBundleInclusion addVocabularyBundleInclusion(VocabularyBundle bundle, String includedVocabularyURI, String includedVocabularyPrefix) {
		final VocabularyBundleInclusion inclusion = create(VocabularyBundleInclusion.class);
		inclusion.setUri(includedVocabularyURI);
		inclusion.setPrefix(includedVocabularyPrefix);
		bundle.getOwnedImports().add(inclusion);
		return inclusion;
	}

	// DescriptionExtension

	public DescriptionExtension addDescriptionExtension(Description description, String extenedAssertionURI, String extenedAssertionPrefix) {
		final DescriptionExtension extension = create(DescriptionExtension.class);
		extension.setUri(extenedAssertionURI);
		extension.setPrefix(extenedAssertionPrefix);
		description.getOwnedImports().add(extension);
		return extension;
	}
	
	// DescriptionUsage

	public DescriptionUsage addDescriptionUsage(Description description, String usedVocabularyBoxURI, String usedVocabularyBoxPrefix) {
		final DescriptionUsage usage = create(DescriptionUsage.class);
		usage.setUri(usedVocabularyBoxURI);
		usage.setPrefix(usedVocabularyBoxPrefix);
		description.getOwnedImports().add(usage);
		return usage;
	}
	
	// DescriptionBundleExtension
	
	public DescriptionBundleExtension addDescriptionBundleExtension(DescriptionBundle bundle, String extenedDescriptionBundleURI, String extenedDescriptionBundlePrefix) {
		final DescriptionBundleExtension extension = create(DescriptionBundleExtension.class);
		extension.setUri(extenedDescriptionBundleURI);
		extension.setPrefix(extenedDescriptionBundlePrefix);
		bundle.getOwnedImports().add(extension);
		return extension;
	}

	// DescriptionBundleInclusion
	
	public DescriptionBundleInclusion addDescriptionBundleInclusion(DescriptionBundle bundle, String includedAssertionURI, String includedAssertionPrefix) {
		final DescriptionBundleInclusion inclusion = create(DescriptionBundleInclusion.class);
		inclusion.setUri(includedAssertionURI);
		inclusion.setPrefix(includedAssertionPrefix);
		bundle.getOwnedImports().add(inclusion);
		return inclusion;
	}

	// DescriptionBundleUsage

	public DescriptionBundleUsage addDescriptionBundleUsage(DescriptionBundle bundle, String usedVocabularyBundleURI, String usedVocabularyBundlePrefix) {
		final DescriptionBundleUsage usage = create(DescriptionBundleUsage.class);
		usage.setUri(usedVocabularyBundleURI);
		usage.setPrefix(usedVocabularyBundlePrefix);
		bundle.getOwnedImports().add(usage);
		return usage;
	}
	
	// SpecializationAxiom

	public SpecializationAxiom addSpecializationAxiom(Vocabulary vocabulary, String specializingIri, String specializedIri) {
		final SpecializationAxiom axiom = create(SpecializationAxiom.class);
		defer.add(() -> axiom.setSpecializedTerm(resolve(SpecializableTerm.class, vocabulary, specializedIri)));
		defer.add(() -> {
			final SpecializableTerm specializing = resolve(SpecializableTerm.class, vocabulary, specializingIri);
			if (OmlRead.getVocabulary(specializing) == vocabulary) {
				specializing.getOwnedSpecializations().add(axiom);
			} else {
				getOrAddReference(vocabulary, specializing, SpecializableTermReference.class).getOwnedSpecializations().add(axiom); 
			}
		});
		return axiom;
	}
	
	// ScalarPropertyRangeRestrictionAxiom

	public ScalarPropertyRangeRestrictionAxiom addScalarPropertyRangeRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, String rangeIri, RangeRestrictionKind kind) {
		final ScalarPropertyRangeRestrictionAxiom axiom = create(ScalarPropertyRangeRestrictionAxiom.class);
		axiom.setKind(kind);
		defer.add(() -> axiom.setProperty(resolve(ScalarProperty.class, vocabulary, propertyIri)));
		defer.add(() -> axiom.setRange(resolve(Scalar.class, vocabulary, rangeIri)));
		defer.add(() -> {
			final Classifier type = resolve(Classifier.class, vocabulary, typeIri);
			if (OmlRead.getVocabulary(type) == vocabulary) {
				type.getOwnedPropertyRestrictions().add(axiom);
			} else {
				getOrAddReference(vocabulary, type, ClassifierReference.class).getOwnedPropertyRestrictions().add(axiom); 
			}
		});
		return axiom;
	}

	// ScalarPropertyCardinalityRestrictionAxiom

	public ScalarPropertyCardinalityRestrictionAxiom addScalarPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, CardinalityRestrictionKind kind, long cardinality, String rangeIri) {
		final ScalarPropertyCardinalityRestrictionAxiom axiom = create(ScalarPropertyCardinalityRestrictionAxiom.class);
		defer.add(() -> axiom.setProperty(resolve(ScalarProperty.class, vocabulary, propertyIri)));
		axiom.setKind(kind);
		axiom.setCardinality(cardinality);
		defer.add(() -> axiom.setRange(resolve(Scalar.class, vocabulary, rangeIri)));
		defer.add(() -> {
			final Entity entity = resolve(Entity.class, vocabulary, typeIri);
			if (OmlRead.getVocabulary(entity) == vocabulary) {
				entity.getOwnedPropertyRestrictions().add(axiom);
			} else {
				getOrAddReference(vocabulary, entity, EntityReference.class).getOwnedPropertyRestrictions().add(axiom); 
			}
		});
		return axiom;
	}

	// ScalarPropertyValueRestrictionAxiom

	public ScalarPropertyValueRestrictionAxiom addScalarPropertyValueRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, Literal value) {
		final ScalarPropertyValueRestrictionAxiom axiom = create(ScalarPropertyValueRestrictionAxiom.class);
		defer.add(() -> axiom.setProperty(resolve(ScalarProperty.class, vocabulary, propertyIri)));
		axiom.setValue(value);
		defer.add(() -> {
			final Classifier type = resolve(Classifier.class, vocabulary, typeIri);
			if (OmlRead.getVocabulary(type) == vocabulary) {
				type.getOwnedPropertyRestrictions().add(axiom);
			} else {
				getOrAddReference(vocabulary, type, ClassifierReference.class).getOwnedPropertyRestrictions().add(axiom); 
			}
		});
		return axiom;
	}

	// StructuredPropertyRangeRestrictionAxiom

	public StructuredPropertyRangeRestrictionAxiom addStructuredPropertyRangeRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, String rangeIri, RangeRestrictionKind kind) {
		final StructuredPropertyRangeRestrictionAxiom axiom = create(StructuredPropertyRangeRestrictionAxiom.class);
		axiom.setKind(kind);
		defer.add(() -> axiom.setProperty(resolve(StructuredProperty.class, vocabulary, propertyIri)));
		defer.add(() -> axiom.setRange(resolve(Structure.class, vocabulary, rangeIri)));
		defer.add(() -> {
			final Classifier type = resolve(Classifier.class, vocabulary, typeIri);
			if (OmlRead.getVocabulary(type) == vocabulary) {
				type.getOwnedPropertyRestrictions().add(axiom);
			} else {
				getOrAddReference(vocabulary, type, ClassifierReference.class).getOwnedPropertyRestrictions().add(axiom); 
			}
		});
		return axiom;
	}

	// StructuredPropertyCardinalityRestrictionAxiom

	public StructuredPropertyCardinalityRestrictionAxiom addStructuredPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, CardinalityRestrictionKind kind, long cardinality, String rangeIri) {
		final StructuredPropertyCardinalityRestrictionAxiom axiom = create(StructuredPropertyCardinalityRestrictionAxiom.class);
		defer.add(() -> axiom.setProperty(resolve(StructuredProperty.class, vocabulary, propertyIri)));
		axiom.setKind(kind);
		axiom.setCardinality(cardinality);
		defer.add(() -> axiom.setRange(resolve(Structure.class, vocabulary, rangeIri)));
		defer.add(() -> {
			final Entity entity = resolve(Entity.class, vocabulary, typeIri);
			if (OmlRead.getVocabulary(entity) == vocabulary) {
				entity.getOwnedPropertyRestrictions().add(axiom);
			} else {
				getOrAddReference(vocabulary, entity, EntityReference.class).getOwnedPropertyRestrictions().add(axiom); 
			}
		});
		return axiom;
	}

	// StructuredPropertyValueRestrictionAxiom
	
	public StructuredPropertyValueRestrictionAxiom addStructuredPropertyValueRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, StructureInstance value) {
		final StructuredPropertyValueRestrictionAxiom axiom = create(StructuredPropertyValueRestrictionAxiom.class);
		defer.add(() -> axiom.setProperty(resolve(StructuredProperty.class, vocabulary, propertyIri)));
		axiom.setValue(value);
		defer.add(() -> {
			final Classifier type = resolve(Classifier.class, vocabulary, typeIri);
			if (OmlRead.getVocabulary(type) == vocabulary) {
				type.getOwnedPropertyRestrictions().add(axiom);
			} else {
				getOrAddReference(vocabulary, type, ClassifierReference.class).getOwnedPropertyRestrictions().add(axiom); 
			}
		});
		return axiom;
	}

	// RelationRangeRestrictionAxiom

	public RelationRangeRestrictionAxiom addRelationRangeRestrictionAxiom(Vocabulary vocabulary, String entityIri, String relationIri, String rangeIri, RangeRestrictionKind kind) {
		final RelationRangeRestrictionAxiom axiom = create(RelationRangeRestrictionAxiom.class);
		axiom.setKind(kind);
		defer.add(() -> axiom.setRelation(resolve(Relation.class, vocabulary, relationIri)));
		defer.add(() -> axiom.setRange(resolve(Entity.class, vocabulary, rangeIri)));
		defer.add(() -> {
			final Entity entity = resolve(Entity.class, vocabulary, entityIri);
			if (OmlRead.getVocabulary(entity) == vocabulary) {
				entity.getOwnedRelationRestrictions().add(axiom);
			} else {
				getOrAddReference(vocabulary, entity, EntityReference.class).getOwnedRelationRestrictions().add(axiom); 
			}
		});
		return axiom;
	}
	
	// RelationCardinalityRestrictionAxiom

	public RelationCardinalityRestrictionAxiom addRelationCardinalityRestrictionAxiom(Vocabulary vocabulary, String entityIri, String relationIri, CardinalityRestrictionKind kind, long cardinality, String rangeIri) {
		final RelationCardinalityRestrictionAxiom axiom = create(RelationCardinalityRestrictionAxiom.class);
		defer.add(() -> axiom.setRelation(resolve(Relation.class, vocabulary, relationIri)));
		axiom.setKind(kind);
		axiom.setCardinality(cardinality);
		defer.add(() -> axiom.setRange(resolve(Entity.class, vocabulary, rangeIri)));
		defer.add(() -> {
			final Entity entity = resolve(Entity.class, vocabulary, entityIri);
			if (OmlRead.getVocabulary(entity) == vocabulary) {
				entity.getOwnedRelationRestrictions().add(axiom);
			} else {
				getOrAddReference(vocabulary, entity, EntityReference.class).getOwnedRelationRestrictions().add(axiom); 
			}
		});
		return axiom;
	}

	// RelationTargetRestrictionAxiom
	
	public RelationTargetRestrictionAxiom addRelationTargetRestrictionAxiom(Vocabulary vocabulary, String entityIri, String relationIri, String targetIri) {
		final RelationTargetRestrictionAxiom axiom = create(RelationTargetRestrictionAxiom.class);
		defer.add(() -> axiom.setRelation(resolve(Relation.class, vocabulary, relationIri)));
		defer.add(() -> axiom.setTarget(resolve(NamedInstance.class, vocabulary, targetIri)));
		defer.add(() -> {
			final Entity entity = resolve(Entity.class, vocabulary, entityIri);
			if (OmlRead.getVocabulary(entity) == vocabulary) {
				entity.getOwnedRelationRestrictions().add(axiom);
			} else {
				getOrAddReference(vocabulary, entity, EntityReference.class).getOwnedRelationRestrictions().add(axiom); 
			}
		});
		return axiom;
	}

	// KeyAxiom

	public KeyAxiom addKeyAxiom(Vocabulary vocabulary, String entityIri, Iterable<String> keyPropertyIris) {
		final KeyAxiom axiom = create(KeyAxiom.class);
		defer.add(() -> axiom.getProperties().addAll(toList(map(keyPropertyIris, iri -> resolve(ScalarProperty.class, vocabulary, iri)))));
		defer.add(() -> {
			final Entity entity = resolve(Entity.class, vocabulary, entityIri);
			if (OmlRead.getVocabulary(entity) == vocabulary) {
				entity.getOwnedKeys().add(axiom);
			} else {
				getOrAddReference(vocabulary, entity, EntityReference.class).getOwnedKeys().add(axiom);
			}
		});
		return axiom;
	}

	// ConceptTypeAssertion
	
	public ConceptTypeAssertion addConceptTypeAssertion(Description description, String instanceIri, String typeIri) {
		final ConceptTypeAssertion axiom = create(ConceptTypeAssertion.class);
		defer.add(()  -> axiom.setType(resolve(Concept.class, description, typeIri)));
		defer.add(() -> {
			final ConceptInstance instance = resolve(ConceptInstance.class, description, instanceIri);
			if (OmlRead.getDescription(instance) == description) {
				instance.getOwnedTypes().add(axiom);
			} else {
				getOrAddReference(description, instance, ConceptInstanceReference.class).getOwnedTypes().add(axiom); 
			}
		});
		return axiom;
	}

	// RelationTypeAssertion

	public RelationTypeAssertion addRelationTypeAssertion(Description description, String instanceIri, String typeIri) {
		final RelationTypeAssertion axiom = create(RelationTypeAssertion.class);
		defer.add(() -> axiom.setType(resolve(RelationEntity.class, description, typeIri)));
		defer.add(() -> {
			final RelationInstance instance = resolve(RelationInstance.class, description, instanceIri);
			if (OmlRead.getDescription(instance) == description) {
				instance.getOwnedTypes().add(axiom);
			} else {
				getOrAddReference(description, instance, RelationInstanceReference.class).getOwnedTypes().add(axiom);
			}
		});
		return axiom;
	}

	// ScalarPropertyValueAssertion

	public ScalarPropertyValueAssertion addScalarPropertyValueAssertion(Description description, String instanceIri, String propertyIri, Literal value) {
		final ScalarPropertyValueAssertion assertion = create(ScalarPropertyValueAssertion.class);
		defer.add(() -> assertion.setProperty(resolve(ScalarProperty.class, description, propertyIri)));
		assertion.setValue(value);
		defer.add(() -> {		
			final NamedInstance instance = resolve(NamedInstance.class, description, instanceIri);
			if (OmlRead.getDescription(instance) == description) {
				instance.getOwnedPropertyValues().add(assertion);
			} else {
				getOrAddReference(description, instance, NamedInstanceReference.class).getOwnedPropertyValues().add(assertion); 
			}
		});
		return assertion;
	}

	public ScalarPropertyValueAssertion addScalarPropertyValueAssertion(StructureInstance instance, String propertyIri, Literal value) {
		final ScalarPropertyValueAssertion assertion = create(ScalarPropertyValueAssertion.class);
		defer.add(() -> assertion.setProperty(resolve(ScalarProperty.class, OmlRead.getOntology(instance), propertyIri)));
		assertion.setValue(value);
		instance.getOwnedPropertyValues().add(assertion);
		return assertion;
	}
		
	// StructuredPropertyValueAssertion

	public StructuredPropertyValueAssertion addStructuredPropertyValueAssertion(Description description, String instanceIri, String propertyIri, StructureInstance value) {
		final StructuredPropertyValueAssertion assertion = create(StructuredPropertyValueAssertion.class);
		assertion.setValue(value);
		defer.add(() -> assertion.setProperty(resolve(StructuredProperty.class, description, propertyIri)));
		defer.add(() -> {
			final NamedInstance instance = resolve(NamedInstance.class, description, instanceIri);
			if (OmlRead.getDescription(instance) == description) {
				instance.getOwnedPropertyValues().add(assertion);
			} else {
				getOrAddReference(description, instance, NamedInstanceReference.class).getOwnedPropertyValues().add(assertion); 
			}
		});
		return assertion;
	}

	public StructuredPropertyValueAssertion addStructuredPropertyValueAssertion(StructureInstance instance, String propertyIri, StructureInstance value) {
		final StructuredPropertyValueAssertion assertion = create(StructuredPropertyValueAssertion.class);
		defer.add(() -> assertion.setProperty(resolve(StructuredProperty.class, OmlRead.getOntology(instance), propertyIri)));
		assertion.setValue(value);
		instance.getOwnedPropertyValues().add(assertion);
		return assertion;
	}
		
	// LinkAssertion
		
	public LinkAssertion addLinkAssertion(Description description, String instanceIri, String relationIri, String targetIri) {
		final LinkAssertion assertion = create(LinkAssertion.class);
		defer.add(() -> assertion.setRelation(resolve(Relation.class, description, relationIri)));
		defer.add(() -> assertion.setTarget(resolve(NamedInstance.class, description, targetIri)));
		defer.add(() -> {
			final NamedInstance instance = resolve(NamedInstance.class, description, instanceIri);
			if (OmlRead.getDescription(instance) == description) {
				instance.getOwnedLinks().add(assertion);
			} else {
				getOrAddReference(description, instance, NamedInstanceReference.class).getOwnedLinks().add(assertion); 
			}
		});
		return assertion;
	}

	// EntityPredicate

	public EntityPredicate createEntityPredicate(Vocabulary vocabulary, String entityIri, String variable) {
		final EntityPredicate predicate = create(EntityPredicate.class);
		defer.add(() -> predicate.setEntity(resolve(Entity.class, vocabulary, entityIri)));
		predicate.setVariable(variable);
		return predicate;
	}
	
	// RelationPredicate

	public RelationPredicate createRelationPredicate(Vocabulary vocabulary, String relationIri, String variable1, String variable2) {
		final RelationPredicate predicate = create(RelationPredicate.class);
		defer.add(() -> predicate.setRelation(resolve(Relation.class, vocabulary, relationIri)));
		predicate.setVariable1(variable1);
		predicate.setVariable2(variable2);
		return predicate;
	}
		
	// SameAsPredicate

	public SameAsPredicate createSameAsPredicate(Vocabulary vocabulary, String variable1, String variable2) {
		final SameAsPredicate predicate = create(SameAsPredicate.class);
		predicate.setVariable1(variable1);
		predicate.setVariable2(variable2);
		return predicate;
	}

	// DifferentFromPredicate

	public DifferentFromPredicate createDifferentFromPredicate(Vocabulary vocabulary, String variable1, String variable2) {
		final DifferentFromPredicate predicate = create(DifferentFromPredicate.class);
		predicate.setVariable1(variable1);
		predicate.setVariable2(variable2);
		return predicate;
	}

	// RelationEntityPredicate

	public RelationEntityPredicate createRelationEntityPredicate(Vocabulary vocabulary, String entityIri, String variable1, String entityVariable, String variable2) {
		final RelationEntityPredicate predicate = create(RelationEntityPredicate.class);
		defer.add(() -> predicate.setEntity(resolve(RelationEntity.class, vocabulary, entityIri)));
		predicate.setVariable1(variable1);
		predicate.setEntityVariable(entityVariable);
		predicate.setVariable2(variable2);
		return predicate;
	}

	// QuotedLiteral

	public QuotedLiteral createQuotedLiteral(Ontology ontology, String value, String typeIri, String langTag) {
		final QuotedLiteral literal = create(QuotedLiteral.class);
		literal.setValue(value);
		if (typeIri != null) {
			defer.add(() -> literal.setType(resolve(Scalar.class, ontology, typeIri)));
		} else if (langTag != null) {
			literal.setLangTag(langTag);
		}
		return literal;
	}
		
	// IntegerLiteral

	public IntegerLiteral createIntegerLiteral(Ontology ontology, int value, String typeIri) {
		final IntegerLiteral literal = create(IntegerLiteral.class);
		literal.setValue(value);
		if (typeIri != null) {
			defer.add(() -> literal.setType(resolve(Scalar.class, ontology, typeIri)));
		}
		return literal;
	}
		
	// DecimalLiteral

	public DecimalLiteral createDecimalLiteral(Ontology ontology, BigDecimal value, String typeIri) {
		final DecimalLiteral literal = create(DecimalLiteral.class);
		literal.setValue(value);
		if (typeIri != null) {
			defer.add(() -> literal.setType(resolve(Scalar.class, ontology, typeIri)));
		}
		return literal;
	}

	// DoubleLiteral

	public DoubleLiteral createDoubleLiteral(Ontology ontology, double value, String typeIri) {
		final DoubleLiteral literal = create(DoubleLiteral.class);
		literal.setValue(value);
		if (typeIri != null) {
			defer.add(() -> literal.setType(resolve(Scalar.class, ontology, typeIri)));
		}
		return literal;
	}

	// BooleanLiteral
	
	public BooleanLiteral createBooleanLiteral(Ontology ontology, boolean value, String typeIri) {
		final BooleanLiteral literal = create(BooleanLiteral.class);
		literal.setValue(value);
		if (typeIri != null) {
			defer.add(() -> literal.setType(resolve(Scalar.class, ontology, typeIri)));
		}
		return literal;
	}
	
}