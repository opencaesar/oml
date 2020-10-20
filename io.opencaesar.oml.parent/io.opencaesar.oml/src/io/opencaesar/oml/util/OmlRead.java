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

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBox;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionBundleExtension;
import io.opencaesar.oml.DescriptionBundleImport;
import io.opencaesar.oml.DescriptionBundleInclusion;
import io.opencaesar.oml.DescriptionBundleUsage;
import io.opencaesar.oml.DescriptionExtension;
import io.opencaesar.oml.DescriptionImport;
import io.opencaesar.oml.DescriptionStatement;
import io.opencaesar.oml.DescriptionUsage;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.FeatureProperty;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Reference;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.RestrictionAxiom;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializableTermReference;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyReference;
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBox;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleImport;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyImport;
import io.opencaesar.oml.VocabularyStatement;
import io.opencaesar.oml.VocabularyUsage;

public class OmlRead {
	
	private static final String CATALOGS = "Catalogs";
	private static final String OML_EXTENSION = "oml";
	
	// closure operators
	
	public static <T, V extends T> Collection<T> reflexiveClosure(V v, Function<T, Collection<T>> f) {
		final Set<T> allResults = new LinkedHashSet<>();
		allResults.add(v);
		closure(v, f, allResults);
		return allResults;
	}

	public static <T, V extends T> Collection<T> closure(V v, Function<T, Collection<T>> f) {
		final Set<T> allResults = new LinkedHashSet<>();
		closure(v, f, allResults);
		return allResults;
	}

	protected static <T, V extends T> void closure(V v, Function<T, Collection<T>> f, Set<T> allResults) {
		Collection<T> results = f.apply(v);
		if (results == null) {
			results = Collections.emptyList();
		} else {
			results = results.stream().
				filter(r -> r != null).
				filter(r -> !allResults.contains(r)).
				collect(Collectors.toList());
		}
		allResults.addAll(results);
		results.forEach(r -> closure(r, f, allResults));
	}

	// ResourceSet
	
	public static Element getElementWithIri(ResourceSet resourceSet, String iri) {
		for (Resource resource : resourceSet.getResources()) {
			final Element found = getElementWithIri(resource, iri);
			if (found != null) {
				return found;
			}
		}
		return null;
	}
	
	public static Collection<Ontology> getOntologies(ResourceSet resourceSet) {
		return resourceSet.getResources().stream().
			flatMap(r -> r.getContents().stream()).
			filter(r -> r instanceof Ontology).
			map(r -> (Ontology)r).
			collect(Collectors.toList());
	}

	// Resource
	
	public static Element getElementWithIri(Resource resource, String iri) {
		final Ontology ontology = getOntology(resource);
		if (ontology != null) {
			if (iri.equals(ontology.getIri())) {
				return ontology;
			} else if (iri.startsWith(ontology.getIri())) {
				final String name = iri.substring(ontology.getIri().length()+1);
				return getMembers(ontology).stream().filter(i -> i.getName().equals(name)).findFirst().orElse(null);
			}
		}
		return null;
	}

	public static Ontology getOntology(Resource resource) {
		return resource.getContents().stream().
			filter(o -> o instanceof Ontology).
			map(o -> (Ontology)o).
			findFirst().
			orElse(null);
	}
	
	// Element
	
	public static Ontology getOntology(Element element) {
		EObject current = element;
		while (current != null && !(current instanceof Ontology)) {
			current = current.eContainer();
		}
		return (Ontology) current;
	}
	
	public static String getId(Element element) {
		return EcoreUtil.getID(element);
	}
	
	// Annotation
	
	public static AnnotatedElement getAnnotatedElement(Annotation annotation) {
		if (annotation.getOwningReference() != null) {
			return resolve(annotation.getOwningReference());
		} else {
			return annotation.getOwningElement();
		}
	}
	
	// AnnotatedElement
	
	public static Collection<Literal> getAnnotationValues(AnnotatedElement element, String annotationPropertyIri) {
		return element.getOwnedAnnotations().stream().
			filter(a -> getIri(a.getProperty()).equals(annotationPropertyIri)).
			map(a -> a.getValue()).
			collect(Collectors.toList());
	}
	
	public static Literal getAnnotationValue(AnnotatedElement element, String annotationPropertyIri) {
		return getAnnotationValues(element, annotationPropertyIri).stream().findFirst().orElse(null);
	}

	public static String getAnnotationLexicalValue(AnnotatedElement element, String annotationPropertyIri) {
		Literal value = getAnnotationValue(element, annotationPropertyIri);
		return (value != null)? getLexicalValue(value) : null;
	}

	// IdentifiedElement
	
	public static String getIri(IdentifiedElement element) {
		if (element instanceof Ontology) {
			return getIri((Ontology) element);
		} else if (element instanceof Member) {
			return getIri((Member) element);
		}
		return null;
	}

	public static String getAbbreviatedIri(IdentifiedElement element) {
		if (element instanceof Ontology) {
			return getAbbreviatedIri((Ontology) element);
		} else if (element instanceof Member) {
			return getAbbreviatedIri((Member) element);
		}
		return null;
	}

	public static String getNameIn(IdentifiedElement element, Ontology ontology) {
		if (element instanceof Ontology) {
			return getNameIn((Ontology) element, ontology);
		} else if (element instanceof Member) {
			return getNameIn((Member) element, ontology);
		}
		return null;
	}
	
	// Ontology
	
	public static String getIri(Ontology element) {
		return element.getIri();
	}

	public static String getAbbreviatedIri(Ontology element) {
		return element.getPrefix();
	}

	public static String getNameIn(Ontology element, Ontology ontology) {
		if (element == ontology) {
			return element.getPrefix();
		} else {
			return getImportPrefixes(ontology).get(getNamespace(element));
		}
	}

	public static String getNamespace(Ontology ontology) {
		return ontology.getIri()+ontology.getSeparator();
	}

	public static Collection<Statement> getStatements(Ontology ontology) {
		if (ontology instanceof Vocabulary) {
			return getStatements((Vocabulary)ontology);
		} else if (ontology instanceof Description) {
			return getStatements((Description)ontology);
		}
		return Collections.emptyList();
	}

	public static Collection<Member> getMembers(Ontology ontology) {
		if (ontology instanceof Vocabulary) {
			return getMembers((Vocabulary)ontology);
		} else {
			return getStatements(ontology).stream().
				filter(s -> s instanceof Member).
				map(s -> (Member)s).
				collect(Collectors.toList());
		}
	}

	public static Collection<Reference> getReferences(Ontology ontology) {
		return getStatements(ontology).stream().
			filter(s -> s instanceof Reference).
			map(s -> (Reference)s).
			collect(Collectors.toList());
	}
	
	public static Collection<Import> getImportsWithSource(Ontology ontology) {
		if (ontology instanceof Vocabulary) {
			return getImportsWithSource((Vocabulary)ontology);
		} else if (ontology instanceof VocabularyBundle) {
			return getImportsWithSource((VocabularyBundle)ontology);
		} else if (ontology instanceof Description) {
			return getImportsWithSource((Description)ontology);
		} else if (ontology instanceof DescriptionBundle) {
			return getImportsWithSource((DescriptionBundle)ontology);
		}
		return Collections.emptyList();
	}

	public static Collection<Import> getAllImportsWithSource(Ontology ontology) {
		return getImportsWithSource(ontology).stream().
			flatMap(i -> reflexiveClosure(i, j -> getImportsWithSource(getImportedOntology(j))).stream()).
			collect(Collectors.toList());
	}

	public static Ontology getImportedOntologyByIri(Ontology importingOntology, String importedIri) {
		for (Import _import : getAllImportsWithSource(importingOntology)) {
			if (getIri(getImportedOntology(_import)).equals(importedIri)) {
				return getImportedOntology(_import);
			}
		}
		return null;
	}
	
	public static Collection<Ontology> getImportedOntologies(Ontology ontology) {
		return getImportsWithSource(ontology).stream().
			map(i -> getImportedOntology(i)).
			collect(Collectors.toList());
	}

	public static Map<String, String> getImportPrefixes(Ontology ontology) {
		final Map<String, String> namespaces = new LinkedHashMap<>();
		getAllImportsWithSource(ontology).forEach(i -> {
			if (!namespaces.containsKey(getImportNamespace(i))) {
				namespaces.put(getImportNamespace(i), getImportPrefix(i));
			}
		});
		return namespaces;
	}

	// VocabularyBox

	// Vocabulary
	
	public static Collection<Import> getImportsWithSource(Vocabulary ontology) {
		return new ArrayList<>(ontology.getOwnedImports());
	}

	public static Collection<VocabularyExtension> getExtensionsWithSource(Vocabulary vocabulary) {
		return vocabulary.getOwnedImports().stream().
			filter(i -> i instanceof VocabularyExtension).
			map(i -> (VocabularyExtension)i).
			collect(Collectors.toList());
	}

	public static Collection<VocabularyUsage> getUsagesWithSource(Vocabulary vocabulary) {
		return vocabulary.getOwnedImports().stream().
			filter(i -> i instanceof VocabularyUsage).
			map(i -> (VocabularyUsage)i).
			collect(Collectors.toList());
	}

	public static Collection<Vocabulary> getExtendedVocabularies(Vocabulary vocabulary) {
		return getExtensionsWithSource(vocabulary).stream().
			map(e -> getExtendedVocabulary(e)).
			collect(Collectors.toList());
	}

	public static Collection<DescriptionBox> getUsedDescriptionBoxes(Vocabulary vocabulary) {
		return getUsagesWithSource(vocabulary).stream().
			map(u -> getUsedDescriptionBox(u)).
			collect(Collectors.toList());
	}

	public static Collection<Statement> getStatements(Vocabulary ontology) {
		return new ArrayList<>(ontology.getOwnedStatements());
	}

	public static Collection<Member> getMembers(Vocabulary ontology) {
		final List<Member> members = new ArrayList<>();
		members.addAll(ontology.getOwnedStatements().stream().
			filter(s -> s instanceof Member)
			.map(s -> (Member)s).
			collect(Collectors.toList()));
		members.addAll(ontology.getOwnedStatements().stream().
			filter(i -> i instanceof RelationEntity).
			flatMap(i -> getRelations((RelationEntity)i).stream()).
			collect(Collectors.toList()));
		return members;
	}

	// VocabularyBundle

	public static Collection<Import> getImportsWithSource(VocabularyBundle ontology) {
		return new ArrayList<>(ontology.getOwnedImports());
	}

	public static Collection<VocabularyBundleExtension> getExtensionsWithSource(VocabularyBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof VocabularyBundleExtension).
			map(i -> (VocabularyBundleExtension)i).
			collect(Collectors.toList());
	}

	public static Collection<VocabularyBundleInclusion> getInclusionsWithSource(VocabularyBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof VocabularyBundleInclusion).
			map(i -> (VocabularyBundleInclusion)i).
			collect(Collectors.toList());
	}

	public static Collection<VocabularyBundle> getExtendedVocabularyBundles(VocabularyBundle bundle) {
		return getExtensionsWithSource(bundle).stream().
			map(e -> getExtendedVocabularyBundle(e)).
			collect(Collectors.toList());
	}

	public static Collection<Vocabulary> getIncludedVocabularies(VocabularyBundle bundle) {
		return getInclusionsWithSource(bundle).stream().
			map(i -> getIncludedVocabulary(i)).
			collect(Collectors.toList());
	}

	// DescriptionBox

	// Description

	public static Collection<Import> getImportsWithSource(Description ontology) {
		return new ArrayList<>(ontology.getOwnedImports());
	}

	public static Collection<DescriptionUsage> getUsagesWithSource(Description description) {
		return description.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionUsage).
			map(i -> (DescriptionUsage)i).
			collect(Collectors.toList());
	}

	public static Collection<DescriptionExtension> getExtensionsWithSource(Description description) {
		return description.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionExtension).
			map(i -> (DescriptionExtension)i).
			collect(Collectors.toList());
	}

	public static Collection<Description> getExtendedDescriptions(Description description) {
		return getExtensionsWithSource(description).stream().
			map(e -> getExtendedDescription(e)).
			collect(Collectors.toList());
	}

	public static Collection<VocabularyBox> getUsedVocabularyBoxes(Description description) {
		return getUsagesWithSource(description).stream().
			map(e -> getUsedVocabularyBox(e)).
			collect(Collectors.toList());
	}

	public static Collection<Statement> getStatements(Description ontology) {
		return new ArrayList<>(ontology.getOwnedStatements());
	}

	// DescriptionBundle

	public static Collection<Import> getImportsWithSource(DescriptionBundle ontology) {
		return new ArrayList<>(ontology.getOwnedImports());
	}

	public static Collection<DescriptionBundleExtension> getExtensionsWithSource(DescriptionBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionBundleExtension).
			map(i -> (DescriptionBundleExtension)i).
			collect(Collectors.toList());
	}

	public static Collection<DescriptionBundleInclusion> getInclusionsWithSource(DescriptionBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionBundleInclusion).
			map(i -> (DescriptionBundleInclusion)i).
			collect(Collectors.toList());
	}

	public static Collection<DescriptionBundleUsage> getUsagesWithSource(DescriptionBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionBundleUsage).
			map(i -> (DescriptionBundleUsage)i).
			collect(Collectors.toList());
	}

	public static Collection<DescriptionBundle> getExtendedDescriptionBundles(DescriptionBundle bundle) {
		return getExtensionsWithSource(bundle).stream().
			map(e -> getExtendedDescriptionBundle(e)).
			collect(Collectors.toList());
	}

	public static Collection<Description> getIncludedDescriptions(DescriptionBundle bundle) {
		return getInclusionsWithSource(bundle).stream().
			map(e -> getIncludedDescription(e)).
			collect(Collectors.toList());
	}

	public static Collection<VocabularyBundle> getUsedVocabularyBundles(DescriptionBundle bundle) {
		return getUsagesWithSource(bundle).stream().
			map(e -> getUsedVocabularyBundle(e)).
			collect(Collectors.toList());
	}

	// Member
	
	public static String getIri(Member element) {
		final Ontology ontology = getOntology(element);
		String namespace = (ontology != null) ? getNamespace(ontology) : "";
		return namespace + element.getName();
	}

	public static String getAbbreviatedIri(Member element) {
		final Ontology ontology = getOntology(element);
		String prefix = (ontology != null) ? ontology.getPrefix() : "";
		return prefix + ':' + element.getName();
	}

	public static String getNameIn(Member element, Ontology context) {
		final Ontology ontology = getOntology(element);
		if (ontology == context) {
			return element.getName();
		} else if (ontology != null) {
			String prefix = getImportPrefixes(context).get(getNamespace(ontology));
			return (prefix != null) ? prefix + ':'+element.getName() : null;
		}
		return null;
	}

	// Term

	// SpecializableTerm

	public static Collection<SpecializableTerm> getSpecializedTerms(SpecializableTerm term) {
		return term.getOwnedSpecializations().stream().
			map(i -> i.getSpecializedTerm()).
			collect(Collectors.toList());
	}

	// Type

	// Classifier
	
	// Entity
	
	// Aspect
	
	// Concept
	
	// RelationEntity
	
	public static Collection<Relation> getRelations(RelationEntity entity) {
		final List<Relation> relations = new ArrayList<>();
		if (entity.getForward() != null) {
			relations.add(entity.getForward());
		}
		if (entity.getReverse() != null) {
			relations.add(entity.getReverse());
		}
		return relations;
	}
	
	// Structure
	
	// Property
	
	// AnnotationProperty
	
	// FeaturedProperty

	public static Type getRange(final FeatureProperty property) {
		if (property instanceof ScalarProperty) {
			return getRange((ScalarProperty) property);
		} else if (property instanceof StructuredProperty) {
			return getRange((StructuredProperty) property);
		}
		return null;
	}

	// ScalarProperty
	
	public static Scalar getRange(ScalarProperty property) {
		return property.getRange();
	}
	
	// StructuredProperty

	public static Structure getRange(StructuredProperty property) {
		return property.getRange();
	}

	// Scalar
		
	public static Scalar getSpecializedScalar(Scalar scalar) {
		// scalars can have a max of one specialized term
		return getSpecializedTerms(scalar).stream().
			filter(i -> i instanceof Scalar).
			map(i -> (Scalar)i).
			findFirst().orElse(null);
	}

	// FacetedScalar
		
	// EnumeratedScalar
			
	// Relation
	
	public static Vocabulary getVocabulary(Relation relation) {
		return (Vocabulary) getOntology(relation);
	}

	public static RelationEntity getEntity(final Relation relation) {
		if (relation instanceof ForwardRelation) {
			return getEntity((ForwardRelation) relation);
		} else if (relation instanceof ReverseRelation) {
			return getEntity((ReverseRelation) relation);
		}
		return null;
	}

	// ForwardRelation
	
	public static RelationEntity getEntity(ForwardRelation relation) {
		return relation.getEntity();
	}

	// ReverseRelation
		
	public static RelationEntity getEntity(ReverseRelation relation) {
		return relation.getEntity();
	}

	// Rule

	// Instance

	// StructureInstance
		
	// NamedInstance
		
	// ConceptInstance
	
	// RelationInstance
	
	// Reference
	
	public static Member resolve(Reference reference) {
		if (reference instanceof AnnotationPropertyReference) {
			return ((AnnotationPropertyReference) reference).getProperty();
		} else if (reference instanceof AspectReference) {
			return ((AspectReference) reference).getAspect();
		} else if (reference instanceof ConceptInstanceReference) {
			return ((ConceptInstanceReference) reference).getInstance();
		} else if (reference instanceof ConceptReference) {
			return ((ConceptReference) reference).getConcept();
		} else if (reference instanceof EnumeratedScalarReference) {
			return ((EnumeratedScalarReference) reference).getScalar();
		} else if (reference instanceof FacetedScalarReference) {
			return ((FacetedScalarReference) reference).getScalar();
		} else if (reference instanceof RelationEntityReference) {
			return ((RelationEntityReference) reference).getEntity();
		} else if (reference instanceof RelationInstanceReference) {
			return ((RelationInstanceReference) reference).getInstance();
		} else if (reference instanceof RelationReference) {
			return ((RelationReference) reference).getRelation();
		} else if (reference instanceof RuleReference) {
			return ((RuleReference) reference).getRule();
		} else if (reference instanceof ScalarPropertyReference) {
			return ((ScalarPropertyReference) reference).getProperty();
		} else if (reference instanceof StructuredPropertyReference) {
			return ((StructuredPropertyReference) reference).getProperty();
		} else if (reference instanceof StructureReference) {
			return ((StructureReference) reference).getStructure();
		}
		return null;
	}

	public static String getResolvedName(Reference reference) {
		return getNameIn(resolve(reference), getOntology(reference));
	}
	
	public static Collection<Literal> getAnnotationValues(Reference reference, String annotationPropertyIri) {
		return reference.getOwnedAnnotations().stream().
			filter(a -> getIri(a.getProperty()).equals(annotationPropertyIri)).
			map(a -> a.getValue()).
			collect(Collectors.toList());
	}
	
	public static Literal getAnnotationValue(Reference reference, String annotationPropertyIri) {
		return getAnnotationValues(reference, annotationPropertyIri).stream().findFirst().orElse(null);
	}

	public static String getAnnotationLexicalValue(Reference reference, String annotationPropertyIri) {
		Literal literal = getAnnotationValue(reference, annotationPropertyIri);
		return (literal != null) ? getLexicalValue(literal) : null;
	}

	// SpecializableTermReference
	
	public static Collection<SpecializableTerm> getSpecializedTerms(SpecializableTermReference reference) {
		return reference.getOwnedSpecializations().stream().
			map(s -> s.getSpecializedTerm()).
			collect(Collectors.toList());
	}

	// EntityReference
	
	// AspectReference
	
	// ConceptReference

	// RelationEntityReference

	// StructureReference
	
	// AnnotationPropertyReference

	// ScalarPropertyReference
	
	// StructuredPropertyReference
	
	// ScalarReference

	// FacetedScalarReference
	
	// EnumeratedScalarReference
	
	// RelationReference
	
	// RuleReference

	// NamedInstanceReference

	// ConceptInstanceReference
	
	// RelationInstanceReference
	
	// Statement

	// VocabularyStatement
	
	public static Vocabulary getVocabulary(VocabularyStatement statement) {
		return (Vocabulary) getOntology(statement);
	}

	// DescriptionStatement
	
	public static Description getDescription(DescriptionStatement statement) {
		return (Description) getOntology(statement);
	}

	// Import

	public static String getImportPrefix(Import _import) {
		if (_import.getPrefix() != null) {
			return _import.getPrefix();
		} else {
			Ontology ontology = getImportedOntology(_import);
			return (ontology != null) ? ontology.getPrefix() : null;
		}
	}

	public static String getImportNamespace(Import _import) {
		Ontology ontology = getImportedOntology(_import);
		return (ontology != null) ? getNamespace(ontology) : null;
	}

	public static final Pattern NUMBER = Pattern.compile("\\d+");

	synchronized public static URI getResolvedImportUri(Import _import) {
		if (_import.getUri() != null) {
			URI uri = URI.createURI(_import.getUri());
			if (uri.isRelative() && !uri.isEmpty()) {
				final Resource r = _import.eResource();
				final URI contextURI = (r != null) ? r.getURI() : null;
				if (contextURI != null) {
					uri = uri.resolve(contextURI);
				} else {
					uri = null;
				}
			} else {
				final Resource r = _import.eResource();
				final URI contextURI = (r != null) ? r.getURI() : null;
				final ResourceSet rs = (r != null) ? r.getResourceSet() : null;
				if (rs != null && contextURI != null) {
					@SuppressWarnings("unchecked")
					Map<URI, OmlCatalog> catalogMap = (Map<URI, OmlCatalog>) rs.getLoadOptions().get(CATALOGS);
					if (catalogMap == null) {
						rs.getLoadOptions().put(CATALOGS, catalogMap = new HashMap<>());
					}
					try {
						final URI directoryURI = contextURI.trimSegments(1);
						if (!catalogMap.containsKey(directoryURI)) {
							findCatalogs(catalogMap, directoryURI);
						}
						OmlCatalog catalog = catalogMap.get(directoryURI);
						if (catalog != null) {
							final String resolved = catalog.resolveURI(uri.toString());
							if (resolved != null) {
								uri = URI.createURI(resolved);
								if (uri.fileExtension() == null) {
									// if the imported URI does not end with an extension, assume it's .oml
									uri = uri.appendFileExtension(OML_EXTENSION);
								} else if (NUMBER.matcher(uri.fileExtension()).matches()) { 
									// special case for the dc vocabulary ending its IRI with a version number
									uri = uri.appendFileExtension(OML_EXTENSION);
								}
							}
						}
					} catch (Exception e) {
						System.out.println(e);
						// could not resolve using catalog
					}
				}
			}
			return uri;
		}
		return null;
	}
	
	private static void findCatalogs(Map<URI, OmlCatalog> catalogMap, URI folderUri) {
		final List<URI> uris = new ArrayList<>();
		OmlCatalog catalog = null;
		URI currentUri = folderUri;
		while (currentUri != null && catalog == null && currentUri.segmentCount() > 0) {
			uris.add(currentUri);
			URL catalogUrl = null;
			try {
				catalogUrl = new URL(currentUri.appendSegment("catalog.xml").toString());
			} catch (MalformedURLException e) {
				System.out.println(e);
			}
			URL catalogFileUrl = null;
			try {
				catalogFileUrl = FileLocator.toFileURL(catalogUrl);
			} catch (IOException e) {
				System.out.println(e);
			}
			try {
				if (catalogFileUrl != null && catalogFileUrl.getProtocol().equals("file") && Paths.get(catalogFileUrl.toURI()).toFile().exists()) {
					catalog = OmlCatalog.create(catalogUrl);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			if (catalog == null) {
				currentUri = currentUri.trimSegments(1);
				catalog = catalogMap.get(currentUri);
			}
		}
		final OmlCatalog finalCatalog = catalog;
		uris.forEach(uri -> catalogMap.put(uri, finalCatalog));
	}

	public static Resource getImportedResource(Import _import) {
		final URI uri = getResolvedImportUri(_import);
		if (uri == null) {
			return null;
		}			
		final ResourceSet resourceSet = _import.eResource().getResourceSet();
		if (resourceSet == null) {
			return null;
		}
		 Resource resource = resourceSet.getResource(uri, false);
		 if (resource != null) {
		 	return resource;
		 }
		try {
			final URIConverter uriConverter = resourceSet.getURIConverter();
			if (uriConverter != null && uriConverter.exists(uri, resourceSet.getLoadOptions())) {
				resource = resourceSet.getResource(uri, true);
			}
			return resource;
		} catch (Throwable t) {
			return null;
		}
	}

	public static Ontology getImportedOntology(Import _import) {
		Resource r = getImportedResource(_import);
		return (r != null) ? getOntology(r) : null;
	}

	public static Ontology getImportingOntology(Import _import) {
		if (_import instanceof VocabularyImport) {
			return getImportingVocabulary((VocabularyImport)_import);
		} else if (_import instanceof VocabularyBundleImport) {
			return getImportingVocabularyBundle((VocabularyBundleImport)_import);
		} if (_import instanceof DescriptionImport) {
			return getImportingDescription((DescriptionImport)_import);
		} else if (_import instanceof DescriptionBundleImport) {
			return getImportingDescriptionBundle((DescriptionBundleImport)_import);
		}
		return null;
	}

	// VocabularyImport
	
	public static Vocabulary getImportingVocabulary(VocabularyImport _import) {
		return _import.getOwningVocabulary();
	}

	// VocabularyExtension
	
	public static Vocabulary getExtendingVocabulary(VocabularyExtension extension) {
		return extension.getOwningVocabulary();
	}

	public static Vocabulary getExtendedVocabulary(VocabularyExtension extension) {
		return (Vocabulary) getImportedOntology(extension);
	}

	// VocabularyUsage
	
	public static Vocabulary getUsingVocabulary(VocabularyUsage usage) {
		return usage.getOwningVocabulary();
	}

	public static DescriptionBox getUsedDescriptionBox(VocabularyUsage usage) {
		return (DescriptionBox) getImportedOntology(usage);
	}

	// VocabularyBundleImport
	
	public static VocabularyBundle getImportingVocabularyBundle(VocabularyBundleImport _import) {
		return _import.getOwningVocabularyBundle();
	}

	// VocabularyBundleExtension
	
	public static VocabularyBundle getExtendingVocabularyBundle(VocabularyBundleExtension extension) {
		return extension.getOwningVocabularyBundle();
	}

	public static VocabularyBundle getExtendedVocabularyBundle(VocabularyBundleExtension extension) {
		return (VocabularyBundle) getImportedOntology(extension);
	}

	// VocabularyBundleInclusion
	
	public static VocabularyBundle getIncludingVocabularyBundle(VocabularyBundleInclusion inclusion) {
		return inclusion.getOwningVocabularyBundle();
	}

	public static Vocabulary getIncludedVocabulary(VocabularyBundleInclusion inclusion) {
		return (Vocabulary) getImportedOntology(inclusion);
	}

	// DescriptionImport
	
	public static Description getImportingDescription(DescriptionImport _import) {
		return _import.getOwningDescription();
	}

	// DescriptionExtension

	public static Description getExtendingDescription(DescriptionExtension extension) {
		return extension.getOwningDescription();
	}

	public static Description getExtendedDescription(DescriptionExtension extension) {
		return (Description) getImportedOntology(extension);
	}

	// DescriptionUsage
	
	public static Description getUsingDescription(DescriptionUsage usage) {
		return usage.getOwningDescription();
	}

	public static VocabularyBox getUsedVocabularyBox(DescriptionUsage usage) {
		return (VocabularyBox) getImportedOntology(usage);
	}

	// DescriptionBundleImport
	
	public static DescriptionBundle getImportingDescriptionBundle(DescriptionBundleImport _import) {
		return _import.getOwningDescriptionBundle();
	}

	// DescriptionBundleExtension
	
	public static DescriptionBundle getExtendingDescriptionBundle(DescriptionBundleExtension extension) {
		return extension.getOwningDescriptionBundle();
	}

	public static DescriptionBundle getExtendedDescriptionBundle(DescriptionBundleExtension extension) {
		return (DescriptionBundle) getImportedOntology(extension);
	}

	// DescriptionBundleInclusion
	
	public static DescriptionBundle getIncludingDescriptionBundle(DescriptionBundleInclusion inclusion) {
		return inclusion.getOwningDescriptionBundle();
	}

	public static Description getIncludedDescription(DescriptionBundleInclusion inclusion) {
		return (Description) getImportedOntology(inclusion);
	}

	// DescriptionBundleUsage
	
	public static DescriptionBundle getUsingDescriptionBundle(DescriptionBundleUsage usage) {
		return usage.getOwningDescriptionBundle();
	}

	public static VocabularyBundle getUsedVocabularyBundle(DescriptionBundleUsage usage) {
		return (VocabularyBundle) getImportedOntology(usage);
	}

	// Axiom

	public static Classifier getRestrictingType(final Axiom axiom) {
		if (axiom instanceof PropertyRestrictionAxiom) {
			return getRestrictingType((PropertyRestrictionAxiom) axiom);
		} else if (axiom instanceof RelationRestrictionAxiom) {
			return getRestrictingType((RelationRestrictionAxiom) axiom);
		} else if (axiom instanceof KeyAxiom) {
			return getRestrictingType((KeyAxiom) axiom);
		} else if (axiom instanceof RestrictionAxiom) {
			return getRestrictingType((RestrictionAxiom) axiom);
		}
		return null;
	}

	// SpecializationAxiom

	public static SpecializableTerm getSpecializingTerm(SpecializationAxiom axiom) {
		if (axiom.getOwningReference() != null) {
			return (SpecializableTerm) resolve(axiom.getOwningReference());
		} else {
			return axiom.getOwningTerm();
		}
	}
	
	// RestrictionAxiom

	public static Classifier getRestrictingType(RestrictionAxiom axiom) {
		if (axiom instanceof KeyAxiom) {
			return getRestrictingType((KeyAxiom) axiom);
		} else if (axiom instanceof PropertyRestrictionAxiom) {
			return getRestrictingType((PropertyRestrictionAxiom) axiom);
		} else if (axiom instanceof RelationRestrictionAxiom) {
			return getRestrictingType((RelationRestrictionAxiom) axiom);
		} 
		return null;
	}
			
	public static Term getRestrictedTerm(RestrictionAxiom axiom) {
		if (axiom instanceof RelationRestrictionAxiom) {
			return getRestrictedTerm((RelationRestrictionAxiom) axiom);
		} else if (axiom instanceof ScalarPropertyRestrictionAxiom) {
			return getRestrictedTerm((ScalarPropertyRestrictionAxiom) axiom);
		} else if (axiom instanceof StructuredPropertyRestrictionAxiom) {
			return getRestrictedTerm((StructuredPropertyRestrictionAxiom) axiom);
		}
		return null;
	}

	// PropertyRestrictionAxiom

	public static Classifier getRestrictingType(PropertyRestrictionAxiom axiom) {
		if (axiom.getOwningReference() != null) {
			return (Classifier) resolve(axiom.getOwningReference());
		} else {
			return axiom.getOwningClassifier();
		}
	}

	// ScalarPropertyRestrictionAxiom

	public static Term getRestrictedTerm(ScalarPropertyRestrictionAxiom axiom) {
		return axiom.getProperty();
	}

	// ScalarPropertyRangeRestrictionAxiom
		
	// ScalarPropertyCardinalityRestrictionAxiom

	// ScalarPropertyValueRestrictionAxiom
	
	// StructuredPropertyRestrictionAxiom
		
	public static Term getRestrictedTerm(StructuredPropertyRestrictionAxiom axiom) {
		return axiom.getProperty();
	}

	// StructuredPropertyRangeRestrictionAxiom
	
	// StructuredPropertyCardinalityRestrictionAxiom

	// StructuredPropertyValueRestrictionAxiom
	
	// RelationRestrictionAxiom

	public static Term getRestrictedTerm(RelationRestrictionAxiom axiom) {
		return axiom.getRelation();
	}
	
	public static Classifier getRestrictingType(RelationRestrictionAxiom axiom) {
		return getRestrictingEntity(axiom);
	}

	public static Entity getRestrictingEntity(RelationRestrictionAxiom axiom) {
		if (axiom.getOwningReference() != null) {
			return (Entity) resolve(axiom.getOwningReference());
		} else {
			return axiom.getOwningEntity();
		}
	}

	// RelationRangeRestrictionAxiom
	
	// RelationCardinalityRestrictionAxiom
	
	// RelationTargetRestrictionAxiom

	// KeyAxiom

	public static Entity getKeyedEntity(KeyAxiom axiom) {
		if (axiom.getOwningReference() != null) {
			return (Entity) resolve(axiom.getOwningReference());
		} else {
			return axiom.getOwningEntity();
		}
	}

	public static Classifier getRestrictingType(KeyAxiom axiom) {
		return getRestrictingEntity(axiom);
	}

	public static Entity getRestrictingEntity(KeyAxiom axiom) {
		if (axiom.getOwningReference() != null) {
			return (Entity) resolve(axiom.getOwningReference());
		} else {
			return axiom.getOwningEntity();
		}
	}

	// Assertion
	
	public static Instance getInstance(Assertion assertion) {
		if (assertion instanceof ConceptTypeAssertion) {
			return getInstance((ConceptTypeAssertion) assertion);
		} else if (assertion instanceof LinkAssertion) {
			return getInstance((LinkAssertion) assertion);
		} else if (assertion instanceof PropertyValueAssertion) {
			return getInstance((PropertyValueAssertion) assertion);
		} else if (assertion instanceof RelationTypeAssertion) {
			return getInstance((RelationTypeAssertion) assertion);
		}
		return null;
	}
	
	// TypeAssertion

	public static Entity getType(TypeAssertion assertion) {
		if (assertion instanceof ConceptTypeAssertion) {
			return getType((ConceptTypeAssertion) assertion);
		} else if (assertion instanceof RelationTypeAssertion) {
			return getType((RelationTypeAssertion) assertion);
		}
		return null;
	}

	// ConceptTypeAssertion
	
	public static Entity getType(ConceptTypeAssertion assertion) {
		return assertion.getType();
	}

	public static Instance getInstance(ConceptTypeAssertion assertion) {
		return getConceptInstance(assertion);
	}

	public static ConceptInstance getConceptInstance(ConceptTypeAssertion assertion) {
		if (assertion.getOwningReference() != null) {
			return (ConceptInstance) resolve(assertion.getOwningReference());
		} else {
			return assertion.getOwningInstance();
		}
	}

	// RelationTypeAssertion

	public static Entity getType(RelationTypeAssertion assertion) {
		return assertion.getType();
	}

	public static Instance getInstance(RelationTypeAssertion assertion) {
		return getRelationInstance(assertion);
	}
	
	public static RelationInstance getRelationInstance(RelationTypeAssertion assertion) {
		if (assertion.getOwningReference() != null) {
			return (RelationInstance) resolve(assertion.getOwningReference());
		} else {
			return assertion.getOwningInstance();
		}
	}

	// PropertyValueAssertion

	public static Instance getInstance(PropertyValueAssertion assertion) {
		if (assertion.getOwningReference() != null) {
			return (Instance) resolve(assertion.getOwningReference());
		} else {
			return assertion.getOwningInstance();
		}
	}

	public static Property getProperty(PropertyValueAssertion assertion) {
		if (assertion instanceof ScalarPropertyValueAssertion) {
			return ((ScalarPropertyValueAssertion) assertion).getProperty();
		} else if (assertion instanceof StructuredPropertyValueAssertion) {
			return ((StructuredPropertyValueAssertion) assertion).getProperty();
		}
		return null;
	}
		
	public static Element getValue(PropertyValueAssertion assertion) {
		if (assertion instanceof ScalarPropertyValueAssertion) {
			return ((ScalarPropertyValueAssertion) assertion).getValue();
		} else if (assertion instanceof StructuredPropertyValueAssertion) {
			return ((StructuredPropertyValueAssertion) assertion).getValue();
		}
		return null;
	}

	// ScalarPropertyValueAssertion
	
	// StructuredPropertyValueAssertion
	
	// LinkAssertion
		
	public static NamedInstance getSource(LinkAssertion assertion) {
		return (NamedInstance) getInstance(assertion);
	}

	public static Instance getInstance(LinkAssertion assertion) {
		return getNamedInstance(assertion);
	}
	
	public static NamedInstance getNamedInstance(LinkAssertion assertion) {
		if (assertion.getOwningReference() != null) {
			return (NamedInstance) resolve(assertion.getOwningReference());
		} else {
			return assertion.getOwningInstance();
		}
	}

	// Predicate

	// UnaryPredicate

	// EntityPredicate

	// BinaryPredicate
	
	// RelationPredicate

	// SameAsPredicate

	// DifferentFromPredicate

	// RelationEntityPredicate

	// Literal

	public static Object getLiteralValue(Literal literal) {
		if (literal instanceof QuotedLiteral) {
			return getLiteralValue((QuotedLiteral)literal); 
		} else if (literal instanceof IntegerLiteral) {
			return getLiteralValue((IntegerLiteral)literal); 
		} else if (literal instanceof DecimalLiteral) {
			return getLiteralValue((DecimalLiteral)literal); 
		} else if (literal instanceof DoubleLiteral) {
			return getLiteralValue((DoubleLiteral)literal); 
		} else if (literal instanceof BooleanLiteral) {
			return getLiteralValue((BooleanLiteral)literal); 
		}
		return null;
	}

	public static String getLexicalValue(Literal literal) {
		if (literal instanceof QuotedLiteral) {
			return getLexicalValue((QuotedLiteral)literal); 
		} else if (literal instanceof IntegerLiteral) {
			return getLexicalValue((IntegerLiteral)literal); 
		} else if (literal instanceof DecimalLiteral) {
			return getLexicalValue((DecimalLiteral)literal); 
		} else if (literal instanceof DoubleLiteral) {
			return getLexicalValue((DoubleLiteral)literal); 
		} else if (literal instanceof BooleanLiteral) {
			return getLexicalValue((BooleanLiteral)literal); 
		}
		return null;
	}

	// QuotedLiteral
	
	public static String getLiteralValue(QuotedLiteral literal) {
		return literal.getValue();
	}

	public static String getLexicalValue(QuotedLiteral literal) {
		return literal.getValue();
	}

	// IntegerLiteral
	
	public static int getLiteralValue(IntegerLiteral literal) {
		return literal.getValue();
	}

	public static String getLexicalValue(IntegerLiteral literal) {
		return Integer.toString(literal.getValue());
	}

	// DecimalLiteral
	
	public static BigDecimal getLiteralValue(DecimalLiteral literal) {
		return literal.getValue();
	}

	public static String getLexicalValue(DecimalLiteral literal) {
		return (literal.getValue() != null) ? literal.getValue().toString() : "0.0";
	}

	// DoubleLiteral
	
	public static double getLiteralValue(DoubleLiteral literal) {
		return literal.getValue();
	}

	public static String getLexicalValue(DoubleLiteral literal) {
		return Double.toString(literal.getValue());
	}
	
	// BooleanLiteral
	
	public static boolean getLiteralValue(BooleanLiteral literal) {
		return literal.isValue();
	}

	public static String getLexicalValue(BooleanLiteral literal) {
		return Boolean.toString(literal.isValue());
	}

}