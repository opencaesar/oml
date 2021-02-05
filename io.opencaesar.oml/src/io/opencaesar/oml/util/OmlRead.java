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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierReference;
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
import io.opencaesar.oml.EntityReference;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.FeatureProperty;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.InverseSourceRelation;
import io.opencaesar.oml.InverseTargetRelation;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.NamedInstanceReference;
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
import io.opencaesar.oml.SourceRelation;
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
import io.opencaesar.oml.TargetRelation;
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
	
	// closure operators
	
	public static <T, V extends T> List<T> reflexiveClosure(V v, Function<T, List<T>> f) {
		final Set<T> allResults = new LinkedHashSet<>();
		allResults.add(v);
		closure(v, f, allResults);
		return new ArrayList<T>(allResults);
	}

	public static <T, V extends T> List<T> closure(V v, Function<T, List<T>> f) {
		final Set<T> allResults = new LinkedHashSet<>();
		closure(v, f, allResults);
		return new ArrayList<T>(allResults);
	}

	protected static <T, V extends T> void closure(V v, Function<T, List<T>> f, Set<T> allResults) {
		List<T> results = f.apply(v);
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

	protected static String[] parseIri(String iri) {
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
		return new String[] {baseIri, fragment};
	}

	protected static String[] parseAbbreviatedIri(String iri) {
		String[] parts = iri.split(":");
		String prefix = (parts.length> 1) ? parts[0] : "";
		String fragment = (parts.length> 1) ? parts[1] : parts[0];
		return new String[] {prefix, fragment};
	}

	// ResourceSet
	
	public static Member getMemberByIri(ResourceSet resourceSet, String iri) {
		String[] iriParts = parseIri(iri);
		String baseIri = iriParts[0];
		String fragment = iriParts[1];
		Ontology ontology = getOntologyByIri(resourceSet, baseIri);
		if (ontology != null) {
			return (Member) ontology.eResource().getEObject(fragment);
		}
		return null;
	}
	
	public static Member getMemberByAbbreviatedIri(ResourceSet resourceSet, String abbreviatedIri) {
		String[] iriParts = parseAbbreviatedIri(abbreviatedIri);
		String prefix = iriParts[0];
		String fragment = iriParts[1];
		Ontology ontology = getOntologyByPrefix(resourceSet, prefix);
		if (ontology != null) {
			return (Member) ontology.eResource().getEObject(fragment);
		}
		return null;
	}

	public static Ontology getOntologyByIri(ResourceSet resourceSet, String iri) {
		return resourceSet.getResources().stream().
			flatMap(r -> r.getContents().stream()).
			filter(o -> o instanceof Ontology).
			map(o -> (Ontology)o).
			filter(o -> iri.equals(o.getIri())).
			findFirst().orElse(null);
	}

	public static Ontology getOntologyByPrefix(ResourceSet resourceSet, String prefix) {
		return resourceSet.getResources().stream().
			flatMap(r -> r.getContents().stream()).
			filter(o -> o instanceof Ontology).
			map(o -> (Ontology)o).
			filter(o -> prefix.equals(o.getPrefix())).
			findFirst().orElse(null);
	}

	public static List<Ontology> getOntologies(ResourceSet resourceSet) {
		return resourceSet.getResources().stream().
			flatMap(r -> r.getContents().stream()).
			filter(r -> r instanceof Ontology).
			map(r -> (Ontology)r).
			collect(Collectors.toList());
	}

	// Resource
	
	public static Ontology getOntology(Resource resource) {
		return resource.getContents().stream().
			filter(o -> o instanceof Ontology).
			map(o -> (Ontology)o).
			findFirst().
			orElse(null);
	}
	
	public static Member getMemberByIri(Resource resource, String iri) {
		final Ontology ontology = getOntology(resource);
		if (ontology != null) {
			return getMemberByIri(ontology, iri);
		}
		return null;
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
	
	public static List<Literal> getAnnotationValues(AnnotatedElement element, String annotationPropertyIri) {
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

	public static List<Statement> getStatements(Ontology ontology) {
		if (ontology instanceof Vocabulary) {
			return new ArrayList<>(((Vocabulary)ontology).getOwnedStatements());
		} else if (ontology instanceof Description) {
			return new ArrayList<>(((Description)ontology).getOwnedStatements());
		}
		return Collections.emptyList();
	}

	public static List<Member> getMembers(Ontology ontology) {
		if (ontology instanceof Vocabulary) {
			return getMembers((Vocabulary)ontology);
		} else {
			return getStatements(ontology).stream().
				filter(s -> s instanceof Member).
				map(s -> (Member)s).
				collect(Collectors.toList());
		}
	}

	public static List<Reference> getReferences(Ontology ontology) {
		return getStatements(ontology).stream().
			filter(s -> s instanceof Reference).
			map(s -> (Reference)s).
			collect(Collectors.toList());
	}
	
	public static Member getMemberByName(Ontology context, String memberName) {
		return (Member) context.eResource().getEObject(memberName);
	}

	public static Member getMemberByIri(Ontology context, String iri) {
		String[] iriParts = parseIri(iri);
		String baseIri = iriParts[0];
		String fragment = iriParts[1];
		Resource resource;
		if (context.getIri().equals(baseIri)) {
			resource = context.eResource();
		} else {
			Ontology ontology = getImportedOntologyByIri(context, baseIri);
			resource = (ontology != null) ? ontology.eResource() : null;
		}
		if (resource != null) {
			return (Member) resource.getEObject(fragment);
		}
		return null;
	}

	public static Member getMemberByAbbreviatedIri(Ontology context, String abbreviatedIri) {
		String[] iriParts = parseAbbreviatedIri(abbreviatedIri);
		String prefix = iriParts[0];
		String fragment = iriParts[1];
		Resource resource;
		if (context.getPrefix().equals(prefix)) {
			resource = context.eResource();
		} else {
			Ontology ontology = getImportedOntologyByPrefix(context, prefix);
			resource = (ontology != null) ? ontology.eResource() : null;
		}
		if (resource != null) {
			return (Member) resource.getEObject(fragment);
		}
		return null;
	}

	public static List<Import> getImportsWithSource(Ontology ontology) {
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

	public static List<Import> getAllImportsWithSource(Ontology ontology) {
		return getImportsWithSource(ontology).stream().
			flatMap(i -> reflexiveClosure(i, j -> getImportsWithSource(getImportedOntology(j))).stream()).
			collect(Collectors.toList());
	}

	public static List<Ontology> getImportedOntologies(Ontology ontology) {
		return getImportsWithSource(ontology).stream().
			map(i -> getImportedOntology(i)).
			collect(Collectors.toList());
	}

	public static List<Ontology> getAllImportedOntologies(Ontology ontology) {
		return closure(ontology, i -> getImportsWithSource(i).stream().
				map(j -> getImportedOntology(j)).
				collect(Collectors.toList()));
	}

	public static List<Ontology> getAllImportedOntologiesInclusive(Ontology ontology) {
		return reflexiveClosure(ontology, i -> getImportsWithSource(i).stream().
				map(j -> getImportedOntology(j)).
				collect(Collectors.toList()));
	}

	public static Ontology getImportedOntologyByIri(Ontology importingOntology, String iri) {
		for (Import i : getAllImportsWithSource(importingOntology)) {
			Ontology importedOntology = getImportedOntology(i);		
			if (importedOntology != null && importedOntology.getIri().equals(iri)) {
				return importedOntology;
			}
		}
		return null;
	}
	
	public static Ontology getImportedOntologyByPrefix(Ontology importingOntology, String prefix) {
		for (Import i : getAllImportsWithSource(importingOntology)) {
			if (getImportPrefix(i).equals(prefix)) {
				return getImportedOntology(i);
			}
		}
		return null;
	}

	public static Map<String, String> getImportPrefixes(Ontology ontology) {
		final Map<String, String> map = new LinkedHashMap<>();
		getAllImportsWithSource(ontology).forEach(i -> {
			if (!map.containsKey(getImportNamespace(i))) {
				map.put(getImportNamespace(i), getImportPrefix(i));
			}
		});
		return map;
	}

	// VocabularyBox

	// Vocabulary
	
	public static List<Import> getImportsWithSource(Vocabulary ontology) {
		return new ArrayList<>(ontology.getOwnedImports());
	}

	public static List<VocabularyExtension> getExtensionsWithSource(Vocabulary vocabulary) {
		return vocabulary.getOwnedImports().stream().
			filter(i -> i instanceof VocabularyExtension).
			map(i -> (VocabularyExtension)i).
			collect(Collectors.toList());
	}

	public static List<VocabularyUsage> getUsagesWithSource(Vocabulary vocabulary) {
		return vocabulary.getOwnedImports().stream().
			filter(i -> i instanceof VocabularyUsage).
			map(i -> (VocabularyUsage)i).
			collect(Collectors.toList());
	}

	public static List<Vocabulary> getExtendedVocabularies(Vocabulary vocabulary) {
		return getExtensionsWithSource(vocabulary).stream().
			map(e -> getExtendedVocabulary(e)).
			collect(Collectors.toList());
	}

	public static List<DescriptionBox> getUsedDescriptionBoxes(Vocabulary vocabulary) {
		return getUsagesWithSource(vocabulary).stream().
			map(u -> getUsedDescriptionBox(u)).
			collect(Collectors.toList());
	}

	public static List<Member> getMembers(Vocabulary ontology) {
		return ontology.getOwnedStatements().stream().flatMap(s -> {
			final ArrayList<Member> ms = new ArrayList<>();
			if (s instanceof Member)
				ms.add((Member) s);
			if (s instanceof RelationEntity)
				ms.addAll(getRelations((RelationEntity) s));
			return ms.stream();
		}).collect(Collectors.toList());
	}

	// VocabularyBundle

	public static List<Import> getImportsWithSource(VocabularyBundle ontology) {
		return new ArrayList<>(ontology.getOwnedImports());
	}

	public static List<VocabularyBundleExtension> getExtensionsWithSource(VocabularyBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof VocabularyBundleExtension).
			map(i -> (VocabularyBundleExtension)i).
			collect(Collectors.toList());
	}

	public static List<VocabularyBundleInclusion> getInclusionsWithSource(VocabularyBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof VocabularyBundleInclusion).
			map(i -> (VocabularyBundleInclusion)i).
			collect(Collectors.toList());
	}

	public static List<VocabularyBundle> getExtendedVocabularyBundles(VocabularyBundle bundle) {
		return getExtensionsWithSource(bundle).stream().
			map(e -> getExtendedVocabularyBundle(e)).
			collect(Collectors.toList());
	}

	public static List<Vocabulary> getIncludedVocabularies(VocabularyBundle bundle) {
		return getInclusionsWithSource(bundle).stream().
			map(i -> getIncludedVocabulary(i)).
			collect(Collectors.toList());
	}

	// DescriptionBox

	public static List<NamedInstance> getAllNamedInstances(DescriptionBox box) {
		return getAllImportedOntologiesInclusive(box).stream().
				filter(i -> i instanceof Description).
				map(i -> (Description)i).
				flatMap(i -> getNamedInstances(i).stream()).
				collect(Collectors.toList());
	}
	
	// Description

	public static List<NamedInstance> getNamedInstances(Description description) {
		return description.getOwnedStatements().stream().
				filter(s -> s instanceof NamedInstance).
				map(s -> (NamedInstance)s).
				collect(Collectors.toList());
	}
	
	public static List<Import> getImportsWithSource(Description ontology) {
		return new ArrayList<>(ontology.getOwnedImports());
	}

	public static List<DescriptionUsage> getUsagesWithSource(Description description) {
		return description.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionUsage).
			map(i -> (DescriptionUsage)i).
			collect(Collectors.toList());
	}

	public static List<DescriptionExtension> getExtensionsWithSource(Description description) {
		return description.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionExtension).
			map(i -> (DescriptionExtension)i).
			collect(Collectors.toList());
	}

	public static List<Description> getExtendedDescriptions(Description description) {
		return getExtensionsWithSource(description).stream().
			map(e -> getExtendedDescription(e)).
			collect(Collectors.toList());
	}

	public static List<VocabularyBox> getUsedVocabularyBoxes(Description description) {
		return getUsagesWithSource(description).stream().
			map(e -> getUsedVocabularyBox(e)).
			collect(Collectors.toList());
	}

	// DescriptionBundle

	public static List<Import> getImportsWithSource(DescriptionBundle ontology) {
		return new ArrayList<>(ontology.getOwnedImports());
	}

	public static List<DescriptionBundleExtension> getExtensionsWithSource(DescriptionBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionBundleExtension).
			map(i -> (DescriptionBundleExtension)i).
			collect(Collectors.toList());
	}

	public static List<DescriptionBundleInclusion> getInclusionsWithSource(DescriptionBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionBundleInclusion).
			map(i -> (DescriptionBundleInclusion)i).
			collect(Collectors.toList());
	}

	public static List<DescriptionBundleUsage> getUsagesWithSource(DescriptionBundle bundle) {
		return bundle.getOwnedImports().stream().
			filter(i -> i instanceof DescriptionBundleUsage).
			map(i -> (DescriptionBundleUsage)i).
			collect(Collectors.toList());
	}

	public static List<DescriptionBundle> getExtendedDescriptionBundles(DescriptionBundle bundle) {
		return getExtensionsWithSource(bundle).stream().
			map(e -> getExtendedDescriptionBundle(e)).
			collect(Collectors.toList());
	}

	public static List<Description> getIncludedDescriptions(DescriptionBundle bundle) {
		return getInclusionsWithSource(bundle).stream().
			map(e -> getIncludedDescription(e)).
			collect(Collectors.toList());
	}

	public static List<VocabularyBundle> getUsedVocabularyBundles(DescriptionBundle bundle) {
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
		String prefix = (ontology != null) ? ontology.getPrefix() : null;
		return ((prefix != null && prefix.length()>0) ? prefix + ':' : "") + element.getName();
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

	public static List<SpecializableTerm> getGeneralTerms(SpecializableTerm term) {
		return term.getOwnedSpecializations().stream().
				map(i -> i.getSpecializedTerm()).
				collect(Collectors.toList());
	}
	
	/**
	 * @Deprecated use {@link OmlRead#getGeneralTerms(SpecializableTerm)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializableTerm> getSpecializedTerms(SpecializableTerm term) {
		return getGeneralTerms(term);
	}

	public static List<Axiom> getAxioms(SpecializableTerm term) {
		List<Axiom> axioms = new ArrayList<>();
		axioms.addAll(((SpecializableTerm)term).getOwnedSpecializations());
		if (term instanceof Classifier) {
			axioms.addAll(((Classifier)term).getOwnedPropertyRestrictions());
		}
		if (term instanceof Entity) {
			axioms.addAll(((Entity)term).getOwnedRelationRestrictions());			
			axioms.addAll(((Entity)term).getOwnedKeys());			
		}
		return axioms;
	}

	// Type

	// Classifier
	
	// Entity
	
	// Aspect
	
	// Concept
	
	// RelationEntity
	
	public static List<Relation> getRelations(RelationEntity entity) {
		final List<Relation> relations = new ArrayList<>();
		if (entity.getForwardRelation() != null) {
			relations.add(entity.getForwardRelation());
		}
		if (entity.getReverseRelation() != null) {
			relations.add(entity.getReverseRelation());
		}
		if (entity.getSourceRelation() != null) {
			relations.add(entity.getSourceRelation());
		}
		if (entity.getInverseSourceRelation() != null) {
			relations.add(entity.getInverseSourceRelation());
		}
		if (entity.getTargetRelation() != null) {
			relations.add(entity.getTargetRelation());
		}
		if (entity.getInverseTargetRelation() != null) {
			relations.add(entity.getInverseTargetRelation());
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
		
	public static Scalar getGeneralScalar(Scalar scalar) {
		// scalars can have a max of one specialized term
		return getGeneralTerms(scalar).stream().
			filter(i -> i instanceof Scalar).
			map(i -> (Scalar)i).
			findFirst().orElse(null);
	}
	
	/**
	 * @Deprecated use {@link OmlRead#getGeneralScalar(Scalar)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static Scalar getSpecializedScalar(Scalar scalar) {
		return getGeneralScalar(scalar);
	}
	
	// FacetedScalar
		
	// EnumeratedScalar
			
	// Relation
	
	public static Vocabulary getVocabulary(Relation relation) {
		return (Vocabulary) getOntology(relation);
	}

	public static RelationEntity getRelationEntity(final Relation relation) {
		if (relation instanceof ForwardRelation) {
			return ((ForwardRelation) relation).getRelationEntity();
		}  if (relation instanceof ReverseRelation) {
			return ((ReverseRelation) relation).getRelationEntity();
		} else if (relation instanceof SourceRelation) {
			return ((SourceRelation) relation).getRelationEntity();
		} else if (relation instanceof InverseSourceRelation) {
			return ((InverseSourceRelation) relation).getRelationEntity();
		} else if (relation instanceof TargetRelation) {
			return ((TargetRelation) relation).getRelationEntity();
		} else if (relation instanceof InverseTargetRelation) {
			return ((InverseTargetRelation) relation).getRelationEntity();
		}
		return null;
	}

	// ForwardRelation
	
	// ReverseRelation
		
	// Rule

	// Instance

	public static List<Assertion> getAssertions(Instance instance) {
		List<Assertion> assertions = new ArrayList<>();
		assertions.addAll(instance.getOwnedPropertyValues());
		if (instance instanceof ConceptInstance) {
			assertions.addAll(((ConceptInstance)instance).getOwnedTypes());
			assertions.addAll(((ConceptInstance)instance).getOwnedLinks());
		}
		if (instance instanceof RelationInstance) {
			assertions.addAll(((RelationInstance)instance).getOwnedTypes());
			assertions.addAll(((RelationInstance)instance).getOwnedLinks());
		}
		return assertions;
	}

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
	
	public static List<Literal> getAnnotationValues(Reference reference, String annotationPropertyIri) {
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
	
	public static List<SpecializableTerm> getGeneralTerms(SpecializableTermReference reference) {
		return reference.getOwnedSpecializations().stream().
				map(s -> s.getSpecializedTerm()).
				collect(Collectors.toList());
	}
	
	/**
	 * @Deprecated use {@link OmlRead#getGeneralTerms(SpecializableTermReference)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializableTerm> getSpecializedTerms(SpecializableTermReference reference) {
		return getGeneralTerms(reference);
	}

	public static List<Axiom> getAxioms(SpecializableTermReference reference) {
		List<Axiom> axioms = new ArrayList<>();
		axioms.addAll((reference).getOwnedSpecializations());
		if (reference instanceof ClassifierReference) {
			axioms.addAll(((ClassifierReference)reference).getOwnedPropertyRestrictions());
		}
		if (reference instanceof EntityReference) {
			axioms.addAll(((EntityReference)reference).getOwnedRelationRestrictions());			
			axioms.addAll(((EntityReference)reference).getOwnedKeys());			
		}
		return axioms;
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

	public static List<Assertion> getAssertions(NamedInstanceReference reference) {
		List<Assertion> assertions = new ArrayList<>();
		assertions.addAll(reference.getOwnedPropertyValues());
		if (reference instanceof ConceptInstanceReference) {
			assertions.addAll(((ConceptInstanceReference)reference).getOwnedTypes());
			assertions.addAll(((ConceptInstanceReference)reference).getOwnedLinks());
		}
		if (reference instanceof RelationInstanceReference) {
			assertions.addAll(((RelationInstanceReference)reference).getOwnedTypes());
			assertions.addAll(((RelationInstanceReference)reference).getOwnedLinks());
		}
		return assertions;
	}

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
		if (_import.getUri() == null || _import.getUri().isEmpty()) {
			return null;
		}

		URI importUri = URI.createURI(_import.getUri());

		final Resource r = _import.eResource();
		if (r == null) {
			return null;
		}

		final ResourceSet rs = r.getResourceSet();
		if (rs == null) {
			return null;
		}
		
		OmlUriResolver resolver = OmlUriResolver.get(rs);
		if (resolver == null) {
			return null;
		}
		
		return resolver.resolve(r, importUri);
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
		try {
			return resourceSet.getResource(uri, true);
		} catch(Throwable t) {
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

	// SpecializationAxiom

	public static SpecializableTerm getGeneralTerm(SpecializationAxiom axiom) {
		return axiom.getSpecializedTerm();
	}

	public static SpecializableTerm getSpecificTerm(SpecializationAxiom axiom) {
		if (axiom.getOwningReference() != null) {
			return (SpecializableTerm) resolve(axiom.getOwningReference());
		} else {
			return axiom.getOwningTerm();
		}
	}
	
	/**
	 * @Deprecated use {@link OmlRead#getSpecificTerm(SpecializationAxiom)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static SpecializableTerm getSpecializingTerm(SpecializationAxiom axiom) {
		return getSpecificTerm(axiom);
	}
	
	// RestrictionAxiom

	public static Classifier getRestrictingClassifier(RestrictionAxiom axiom) {
		if (axiom instanceof PropertyRestrictionAxiom) {
			return getRestrictingClassifier((PropertyRestrictionAxiom) axiom);
		} else if (axiom instanceof RelationRestrictionAxiom) {
			return getRestrictingEntity((RelationRestrictionAxiom) axiom);
		} 
		return null;
	}

	/**
	 * @Deprecated use {@link OmlReadh#getRestrictingClassifier(RestrictionAxiom)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static Classifier getRestrictingType(RestrictionAxiom axiom) {
		return getRestrictingClassifier(axiom);
	}
	
	public static Term getRestrictedTerm(RestrictionAxiom axiom) {
		if (axiom instanceof RelationRestrictionAxiom) {
			return getRestrictedRelation((RelationRestrictionAxiom) axiom);
		} else if (axiom instanceof ScalarPropertyRestrictionAxiom) {
			return getRestrictedScalarProperty((ScalarPropertyRestrictionAxiom) axiom);
		} else if (axiom instanceof StructuredPropertyRestrictionAxiom) {
			return getRestrictedStructuredProperty((StructuredPropertyRestrictionAxiom) axiom);
		}
		return null;
	}

	// PropertyRestrictionAxiom

	public static Classifier getRestrictingClassifier(PropertyRestrictionAxiom axiom) {
		if (axiom.getOwningReference() != null) {
			return (Classifier) resolve(axiom.getOwningReference());
		} else {
			return axiom.getOwningClassifier();
		}
	}

	/**
	 * @Deprecated use {@link OmlReadh#getRestrictingClassifier(PropertyRestrictionAxiom)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static Classifier getRestrictingType(PropertyRestrictionAxiom axiom) {
		return getRestrictingClassifier(axiom);
	}

	// ScalarPropertyRestrictionAxiom

	public static ScalarProperty getRestrictedScalarProperty(ScalarPropertyRestrictionAxiom axiom) {
		return axiom.getProperty();
	}

	// ScalarPropertyRangeRestrictionAxiom
		
	// ScalarPropertyCardinalityRestrictionAxiom

	// ScalarPropertyValueRestrictionAxiom
	
	// StructuredPropertyRestrictionAxiom
		
	public static StructuredProperty getRestrictedStructuredProperty(StructuredPropertyRestrictionAxiom axiom) {
		return axiom.getProperty();
	}

	// StructuredPropertyRangeRestrictionAxiom
	
	// StructuredPropertyCardinalityRestrictionAxiom

	// StructuredPropertyValueRestrictionAxiom
	
	// RelationRestrictionAxiom

	public static Relation getRestrictedRelation(RelationRestrictionAxiom axiom) {
		return axiom.getRelation();
	}
	
	public static Entity getRestrictingEntity(RelationRestrictionAxiom axiom) {
		if (axiom.getOwningReference() != null) {
			return (Entity) resolve(axiom.getOwningReference());
		} else {
			return axiom.getOwningEntity();
		}
	}

	/**
	 * @Deprecated use {@link OmlReadh#getRestrictingEntity(RelationRestrictionAxiom)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static Classifier getRestrictingType(RelationRestrictionAxiom axiom) {
		return getRestrictingEntity(axiom);
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

	/**
	 * @Deprecated use {@link OmlRead#getKeyedEntity(KeyAxiom)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static Entity getRestrictingEntity(KeyAxiom axiom) {
		return getKeyedEntity(axiom);
	}

	/**
	 * @Deprecated use {@link OmlRead#getKeyedEntity(KeyAxiom)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static Classifier getRestrictingType(KeyAxiom axiom) {
		return getKeyedEntity(axiom);
	}

	// Assertion
	
	public static Instance getInstance(Assertion assertion) {
		if (assertion instanceof ConceptTypeAssertion) {
			return getConceptInstance((ConceptTypeAssertion) assertion);
		} else if (assertion instanceof RelationTypeAssertion) {
			return getRelationInstance((RelationTypeAssertion) assertion);
		} else if (assertion instanceof LinkAssertion) {
			return getNamedInstance((LinkAssertion) assertion);
		} else if (assertion instanceof PropertyValueAssertion) {
			return getInstance((PropertyValueAssertion) assertion);
		}
		return null;
	}
	
	// TypeAssertion

	public static Entity getType(TypeAssertion assertion) {
		if (assertion instanceof ConceptTypeAssertion) {
			return ((ConceptTypeAssertion) assertion).getType();
		} else if (assertion instanceof RelationTypeAssertion) {
			return ((RelationTypeAssertion) assertion).getType();
		}
		return null;
	}

	// ConceptTypeAssertion
	
	public static ConceptInstance getConceptInstance(ConceptTypeAssertion assertion) {
		if (assertion.getOwningReference() != null) {
			return (ConceptInstance) resolve(assertion.getOwningReference());
		} else {
			return assertion.getOwningInstance();
		}
	}

	// RelationTypeAssertion

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
			return ((QuotedLiteral)literal).getValue(); 
		} else if (literal instanceof IntegerLiteral) {
			return ((IntegerLiteral)literal).getValue(); 
		} else if (literal instanceof DecimalLiteral) {
			return ((DecimalLiteral)literal).getValue(); 
		} else if (literal instanceof DoubleLiteral) {
			return ((DoubleLiteral)literal).getValue(); 
		} else if (literal instanceof BooleanLiteral) {
			return ((BooleanLiteral)literal).isValue(); 
		}
		return null;
	}

	public static String getLexicalValue(Literal literal) {
		Object value = getLiteralValue(literal);
		return value != null ? value.toString() : null;
	}

	public static String getTypeIri(Literal literal) {
		if (literal instanceof QuotedLiteral) {
			QuotedLiteral qLiteral = (QuotedLiteral)literal; 
			return qLiteral.getType() != null ? 
				OmlRead.getIri(qLiteral.getType()) : 
				OmlConstants.XSD_NS+"string"; 
		} else if (literal instanceof IntegerLiteral) {
			return OmlConstants.XSD_NS+"integer"; 
		} else if (literal instanceof DecimalLiteral) {
			return OmlConstants.XSD_NS+"decimal"; 
		} else if (literal instanceof DoubleLiteral) {
			return OmlConstants.XSD_NS+"double"; 
		} else if (literal instanceof BooleanLiteral) {
			return OmlConstants.XSD_NS+"boolean"; 
		}
		return null;
	}

	// QuotedLiteral
	
	// IntegerLiteral
	
	// DecimalLiteral
	
	// DoubleLiteral
	
	// BooleanLiteral

}