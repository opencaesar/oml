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

import static org.eclipse.xtext.xbase.lib.IterableExtensions.filter;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.filterNull;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.findFirst;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.flatMap;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.head;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.map;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toList;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toSet;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;

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
	
	public static <T, V extends T> Iterable<T> reflexiveClosure(V v, Function<T, Iterable<T>> f) {
		final Set<T> allResults = new LinkedHashSet<>();
		allResults.add(v);
		closure(v, f, allResults);
		return allResults;
	}

	public static <T, V extends T> Iterable<T> closure(V v, Function<T, Iterable<T>> f) {
		final Set<T> allResults = new LinkedHashSet<>();
		closure(v, f, allResults);
		return allResults;
	}

	protected static <T, V extends T> void closure(V v, Function<T, Iterable<T>> f, Set<T> allResults) {
		Iterable<T> results = f.apply(v);
		if (results == null) {
			results = Collections.emptyList();
		} else {
			results = toList(filter(filterNull(results), r -> !allResults.contains(r)));
		}
		allResults.addAll(toSet(results));
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
	
	public static Iterable<Ontology> getOntologies(ResourceSet resourceSet) {
		return filter(flatMap(resourceSet.getResources(), r -> r.getContents()), Ontology.class);
	}

	// Resource
	
	public static Element getElementWithIri(Resource resource, String iri) {
		final Ontology ontology = getOntology(resource);
		if (ontology != null) {
			if (iri.equals(ontology.getIri())) {
				return ontology;
			} else if (iri.startsWith(ontology.getIri())) {
				final String name = iri.substring(ontology.getIri().length()+1);
				return findFirst(getMembers(ontology), i -> i.getName().equals(name));
			}
		}
		return null;
	}

	public static Ontology getOntology(Resource resource) {
		return head(filter(resource.getContents(), Ontology.class));
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
	
	public static Iterable<Literal> getAnnotationValues(AnnotatedElement element, String annotationPropertyIri) {
		return map(filter(element.getOwnedAnnotations(), a -> getIri(a.getProperty()).equals(annotationPropertyIri)), a -> a.getValue());
	}
	
	public static Literal getAnnotationValue(AnnotatedElement element, String annotationPropertyIri) {
		return head(getAnnotationValues(element, annotationPropertyIri));
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

	public static Iterable<Statement> getStatements(Ontology ontology) {
		if (ontology instanceof Vocabulary) {
			return getStatements((Vocabulary)ontology);
		} else if (ontology instanceof Description) {
			return getStatements((Description)ontology);
		}
		return Collections.emptyList();
	}

	public static Iterable<Member> getMembers(Ontology ontology) {
		if (ontology instanceof Vocabulary) {
			return getMembers((Vocabulary)ontology);
		} else {
			return filter(getStatements(ontology), Member.class);
		}
	}

	public static Iterable<Reference> getReferences(Ontology ontology) {
		return filter(getStatements(ontology), Reference.class);
	}
	
	public static Iterable<Import> getImportsWithSource(Ontology ontology) {
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

	public static Iterable<Import> getAllImportsWithSource(Ontology ontology) {
		final List<Import> allImports = new ArrayList<>();
		allImports.addAll(toList(flatMap(getImportsWithSource(ontology), i -> reflexiveClosure(i, j -> {
			Ontology o = getImportedOntology(j);
			return (o != null)? getImportsWithSource(o) : null;
		}))));
		return allImports;
	}

	public static Ontology getImportedOntologyByIri(Ontology importingOntology, String importedIri) {
		for (Import _import : getAllImportsWithSource(importingOntology)) {
			if (getIri(getImportedOntology(_import)).equals(importedIri)) {
				return getImportedOntology(_import);
			}
		}
		return null;
	}
	
	public static Iterable<Ontology> getImportedOntologies(Ontology ontology) {
		return map(getImportsWithSource(ontology), i -> getImportedOntology(i));
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
	
	public static Iterable<Import> getImportsWithSource(Vocabulary ontology) {
		return filter(ontology.getOwnedImports(), Import.class);
	}

	public static Iterable<VocabularyExtension> getExtensionsWithSource(Vocabulary vocabulary) {
		return filter(vocabulary.getOwnedImports(), VocabularyExtension.class);
	}

	public static Iterable<VocabularyUsage> getUsagesWithSource(Vocabulary vocabulary) {
		return filter(vocabulary.getOwnedImports(), VocabularyUsage.class);
	}

	public static Iterable<Vocabulary> getExtendedVocabularies(Vocabulary vocabulary) {
		return map(getExtensionsWithSource(vocabulary), e -> getExtendedVocabulary(e));
	}

	public static Iterable<DescriptionBox> getUsedDescriptionBoxes(Vocabulary vocabulary) {
		return map(getUsagesWithSource(vocabulary), u -> getUsedDescriptionBox(u));
	}

	public static Iterable<Statement> getStatements(Vocabulary ontology) {
		return filter(ontology.getOwnedStatements(), Statement.class);
	}

	public static Iterable<Member> getMembers(Vocabulary ontology) {
		final List<Member> members = new ArrayList<>();
		members.addAll(toList(filter(ontology.getOwnedStatements(), Member.class)));
		members.addAll(toList(flatMap(filter(ontology.getOwnedStatements(), RelationEntity.class), i -> getRelations(i))));
		return members;
	}

	// VocabularyBundle

	public static Iterable<Import> getImportsWithSource(VocabularyBundle ontology) {
		return filter(ontology.getOwnedImports(), Import.class);
	}

	public static Iterable<VocabularyBundleExtension> getExtensionsWithSource(VocabularyBundle bundle) {
		return filter(bundle.getOwnedImports(), VocabularyBundleExtension.class);
	}

	public static Iterable<VocabularyBundleInclusion> getInclusionsWithSource(VocabularyBundle bundle) {
		return filter(bundle.getOwnedImports(), VocabularyBundleInclusion.class);
	}

	public static Iterable<VocabularyBundle> getExtendedVocabularyBundles(VocabularyBundle bundle) {
		return map(getExtensionsWithSource(bundle), e -> getExtendedVocabularyBundle(e));
	}

	public static Iterable<Vocabulary> getIncludedVocabularies(VocabularyBundle bundle) {
		return map(getInclusionsWithSource(bundle), i -> getIncludedVocabulary(i));
	}

	// DescriptionBox

	// Description

	public static Iterable<Import> getImportsWithSource(Description ontology) {
		return filter(ontology.getOwnedImports(), Import.class);
	}

	public static Iterable<DescriptionUsage> getUsagesWithSource(Description description) {
		return filter(description.getOwnedImports(), DescriptionUsage.class);
	}

	public static Iterable<DescriptionExtension> getExtensionsWithSource(Description description) {
		return filter(description.getOwnedImports(), DescriptionExtension.class);
	}

	public static Iterable<Description> getExtendedDescriptions(Description description) {
		return map(getExtensionsWithSource(description), u -> getExtendedDescription(u));
	}

	public static Iterable<VocabularyBox> getUsedVocabularyBoxes(Description description) {
		return map(getUsagesWithSource(description), u -> getUsedVocabularyBox(u));
	}

	public static Iterable<Statement> getStatements(Description ontology) {
		return filter(ontology.getOwnedStatements(), Statement.class);
	}

	// DescriptionBundle

	public static Iterable<Import> getImportsWithSource(DescriptionBundle ontology) {
		return filter(ontology.getOwnedImports(), Import.class);
	}

	public static Iterable<DescriptionBundleExtension> getExtensionsWithSource(DescriptionBundle bundle) {
		return filter(bundle.getOwnedImports(), DescriptionBundleExtension.class);
	}

	public static Iterable<DescriptionBundleInclusion> getInclusionsWithSource(DescriptionBundle bundle) {
		return filter(bundle.getOwnedImports(), DescriptionBundleInclusion.class);
	}

	public static Iterable<DescriptionBundleUsage> getUsagesWithSource(DescriptionBundle bundle) {
		return filter(bundle.getOwnedImports(), DescriptionBundleUsage.class);
	}

	public static Iterable<DescriptionBundle> getExtendedDescriptionBundles(DescriptionBundle bundle) {
		return map(getExtensionsWithSource(bundle), e -> getExtendedDescriptionBundle(e));
	}

	public static Iterable<Description> getIncludedDescriptions(DescriptionBundle bundle) {
		return map(getInclusionsWithSource(bundle), i -> getIncludedDescription(i));
	}

	public static Iterable<VocabularyBundle> getUsedVocabularyBundles(DescriptionBundle bundle) {
		return map(getUsagesWithSource(bundle), u -> getUsedVocabularyBundle(u));
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

	public static Iterable<SpecializableTerm> getSpecializedTerms(SpecializableTerm term) {
		return map(term.getOwnedSpecializations(), i -> i.getSpecializedTerm());
	}

	// Type

	// Classifier
	
	// Entity
	
	// Aspect
	
	// Concept
	
	// RelationEntity
	
	public static Iterable<Relation> getRelations(RelationEntity entity) {
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
		return (Scalar) head(getSpecializedTerms(scalar));
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
	
	public static Iterable<Literal> getAnnotationValues(Reference reference, String annotationPropertyIri) {
		return map(filter(reference.getOwnedAnnotations(), a -> getIri(a.getProperty()).equals(annotationPropertyIri)), a -> a.getValue());
	}
	
	public static Literal getAnnotationValue(Reference reference, String annotationPropertyIri) {
		return head(getAnnotationValues(reference, annotationPropertyIri));
	}

	public static String getAnnotationLexicalValue(Reference reference, String annotationPropertyIri) {
		Literal literal = getAnnotationValue(reference, annotationPropertyIri);
		return (literal != null) ? getLexicalValue(literal) : null;
	}

	// SpecializableTermReference
	
	public static Iterable<SpecializableTerm> getSpecializedTerms(SpecializableTermReference reference) {
		return map(reference.getOwnedSpecializations(), s -> s.getSpecializedTerm());
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