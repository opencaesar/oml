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

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierReference;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBox;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionBundleExtension;
import io.opencaesar.oml.DescriptionBundleInclusion;
import io.opencaesar.oml.DescriptionBundleUsage;
import io.opencaesar.oml.DescriptionExtension;
import io.opencaesar.oml.DescriptionUsage;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityReference;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
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
import io.opencaesar.oml.Reference;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializableTermReference;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBox;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyUsage;

/*
 * This API assumes the resource set has a CrossReferenceAdapter installed on all EObjects
 */
public class OmlSearch extends OmlIndex {

	// Element

	// Annotation

	// AnnotatedElement

	public static List<Annotation> findAnnotations(AnnotatedElement element) {
	    if (element instanceof Member) {
	        return findAnnotations((Member)element);
	    } else {
	    	return element.getOwnedAnnotations();
	    }
	}

	public static List<Literal> findAnnotationValuesForIri(AnnotatedElement element, String propertyIri) {
		return findAnnotations(element).stream().
			filter(a -> OmlRead.getIri(a.getProperty()).equals(propertyIri)).
			map(a -> a.getValue()).
			collect(Collectors.toList());
	}
	
	public static List<Literal> findAnnotationValuesForAbbreviatedIri(AnnotatedElement element, String propertyIri) {
		return findAnnotations(element).stream().
			filter(a -> OmlRead.getAbbreviatedIri(a.getProperty()).equals(propertyIri)).
			map(a -> a.getValue()).
			collect(Collectors.toList());
	}

	// IdentifiedElement
	
	// Ontology

	public static List<Import> findImportsWithTarget(Ontology ontology) {
		final Resource resource = ontology.eResource();
		return (resource == null) ? Collections.emptyList() :
			OmlRead.getOntologies(resource.getResourceSet()).stream().
				flatMap(o -> OmlRead.getImportsWithSource(o).stream()).
				filter(i -> OmlRead.getImportingOntology(i) == ontology).
				collect(Collectors.toList());
	}

	public static List<Ontology> findImportingOntologies(Ontology ontology) {
		return findImportsWithTarget(ontology).stream().
			map(i -> OmlRead.getImportingOntology(i)).
			collect(Collectors.toList());
	}

	// VocabularyBox

	public static List<DescriptionUsage> findDescriptionUsagesWithUsedVocabularyBox(VocabularyBox box) {
		return findImportsWithTarget(box).stream().
			filter(i -> i instanceof DescriptionUsage).
			map(i -> (DescriptionUsage)i).
			collect(Collectors.toList());
	}

	public static List<Description> findUsingDescriptions(VocabularyBox box) {
		return findDescriptionUsagesWithUsedVocabularyBox(box).stream().
				map(i -> OmlRead.getUsingDescription(i)).
				collect(Collectors.toList());
	}

	// Vocabulary

	public static List<VocabularyExtension> findVocabularyExtensionsWithExtendedVocabulary(Vocabulary vocabulary) {
		return findImportsWithTarget(vocabulary).stream().
			filter(i -> i instanceof VocabularyExtension).
			map(i -> (VocabularyExtension)i).
			collect(Collectors.toList());
	}

	public static List<Vocabulary> findExtendingVocabularies(Vocabulary vocabulary) {
		return findVocabularyExtensionsWithExtendedVocabulary(vocabulary).stream().
				map(i -> OmlRead.getExtendingVocabulary(i)).
				collect(Collectors.toList());
	}

	public static List<VocabularyBundleInclusion> findVocabularyBundleInclusionsWithIncludedVocabulary(Vocabulary vocabulary) {
		return findImportsWithTarget(vocabulary).stream().
				filter(i -> i instanceof VocabularyBundleInclusion).
				map(i -> (VocabularyBundleInclusion)i).
				collect(Collectors.toList());
	}

	public static List<VocabularyBundle> findIncludingVocabularyBundles(Vocabulary vocabulary) {
		return findVocabularyBundleInclusionsWithIncludedVocabulary(vocabulary).stream().
				map(i -> OmlRead.getIncludingVocabularyBundle(i)).
				collect(Collectors.toList());
	}

	// VocabularyBundle
	
	public static List<VocabularyBundleExtension> findVocabularyBundleExtensionsWithExtendedVocabularyBundle(VocabularyBundle bundle) {
		return findImportsWithTarget(bundle).stream().
				filter(i -> i instanceof VocabularyBundleExtension).
				map(i -> (VocabularyBundleExtension)i).
				collect(Collectors.toList());
	}

	public static List<VocabularyBundle> findExtendingVocabularyBundles(VocabularyBundle bundle) {
		return findVocabularyBundleExtensionsWithExtendedVocabularyBundle(bundle).stream().
				map(i -> OmlRead.getExtendingVocabularyBundle(i)).
				collect(Collectors.toList());
	}

	public static List<DescriptionBundleUsage> findDescriptionBundleUsagesWithUsedVocabularyBundle(VocabularyBundle bundle) {
		return findImportsWithTarget(bundle).stream().
				filter(i -> i instanceof DescriptionBundleUsage).
				map(i -> (DescriptionBundleUsage)i).
				collect(Collectors.toList());
	}

	public static List<DescriptionBundle> findUsingDescriptionBundles(VocabularyBundle bundle) {
		return findDescriptionBundleUsagesWithUsedVocabularyBundle(bundle).stream().
				map(i -> OmlRead.getUsingDescriptionBundle(i)).
				collect(Collectors.toList());
	}

	// DescriptionBox

	public static List<VocabularyUsage> findVocabularyUsagesWithUsedDescriptionBox(DescriptionBox box) {
		return findImportsWithTarget(box).stream().
				filter(i -> i instanceof VocabularyUsage).
				map(i -> (VocabularyUsage)i).
				collect(Collectors.toList());
	}

	public static List<Vocabulary> findUsingVocabularies(DescriptionBox box) {
		return findVocabularyUsagesWithUsedDescriptionBox(box).stream().
				map(i -> OmlRead.getUsingVocabulary(i)).
				collect(Collectors.toList());
	}

	public static List<NamedInstance> findNamedInstancesWithTypeIri(DescriptionBox box, String typeIri) {
		Member member = OmlRead.getMemberByIri(box, typeIri);
		assert (member instanceof Entity) : typeIri+" does not resolve to an Entity";
		return findNamedInstancesWithType((Entity)member);
	}

	public static List<NamedInstance> findNamedInstancesWithSupertypeIri(DescriptionBox box, String typeIri) {
		Member member = OmlRead.getMemberByIri(box, typeIri);
		assert (member instanceof Entity) : typeIri+" does not resolve to an Entity";
		Entity entity = (Entity) member;
		return findAllSpecializingTermsInclusive(entity).stream().
				filter(i -> i instanceof Entity).
				map(i -> (Entity)i).
				flatMap(i -> findNamedInstancesWithType(i).stream()).
				collect(Collectors.toList());
	}

	public static List<NamedInstance> findNamedInstancesWithAbbreviatedTypeIri(DescriptionBox box, String abbreviatedTypeIri) {
		Member member = OmlRead.getMemberByAbbreviatedIri(box, abbreviatedTypeIri);
		assert (member instanceof Entity) : abbreviatedTypeIri+" does not resolve to an Entity";
		return findNamedInstancesWithType((Entity)member);
	}

	public static List<NamedInstance> findNamedInstancesWithAbbreviatedSupertypeIri(DescriptionBox box, String abbreviatedTypeIri) {
		Member member = OmlRead.getMemberByAbbreviatedIri(box, abbreviatedTypeIri);
		assert (member instanceof Entity) : abbreviatedTypeIri+" does not resolve to an Entity";
		Entity entity = (Entity) member;
		return findAllSpecializingTermsInclusive(entity).stream().
				filter(i -> i instanceof Entity).
				map(i -> (Entity)i).
				flatMap(i -> findNamedInstancesWithType(i).stream()).
				collect(Collectors.toList());
	}

	// Description
	
	public static List<DescriptionExtension> findDescriptionExtensionsWithExtendedDescription(Description description) {
		return findImportsWithTarget(description).stream().
				filter(i -> i instanceof DescriptionExtension).
				map(i -> (DescriptionExtension)i).
				collect(Collectors.toList());
	}

	public static List<Description> findExtendingDescriptions(Description description) {
		return findDescriptionExtensionsWithExtendedDescription(description).stream().
				map(i -> OmlRead.getExtendingDescription(i)).
				collect(Collectors.toList());
	}

	public static List<DescriptionBundleInclusion> findDescriptionBundleInclusionsWithIncludedDescription(Description description) {
		return findImportsWithTarget(description).stream().
				filter(i -> i instanceof DescriptionBundleInclusion).
				map(i -> (DescriptionBundleInclusion)i).
				collect(Collectors.toList());
	}

	public static List<DescriptionBundle> findIncludingDescriptionBundles(Description description) {
		return findDescriptionBundleInclusionsWithIncludedDescription(description).stream().
				map(i -> OmlRead.getIncludingDescriptionBundle(i)).
				collect(Collectors.toList());
	}

	// DescriptionBundle
	
	public static List<DescriptionBundleExtension> findDescriptionBundleExtensionsWithExtendedDescriptionBundle(DescriptionBundle bundle) {
		return findImportsWithTarget(bundle).stream().
				filter(i -> i instanceof DescriptionBundleExtension).
				map(i -> (DescriptionBundleExtension)i).
				collect(Collectors.toList());
	}

	public static List<DescriptionBundle> findExtendingDescriptionBundles(DescriptionBundle bundle) {
		return findDescriptionBundleExtensionsWithExtendedDescriptionBundle(bundle).stream().
				map(i -> OmlRead.getExtendingDescriptionBundle(i)).
				collect(Collectors.toList());
	}

	// Member
	
	public static List<Reference> findReferences(Member member) {
		List<Reference> references = new ArrayList<>();
		if (member instanceof AnnotationProperty) {
			references.addAll(findAnnotationPropertyReferencesWithProperty((AnnotationProperty)member));
		} else if (member instanceof Aspect) {
			references.addAll(findAspectReferencesWithAspect((Aspect)member));
		} else if (member instanceof Concept) {
			references.addAll(findConceptReferencesWithConcept((Concept)member));
		} else if (member instanceof ConceptInstance) {
			references.addAll(findConceptInstanceReferencesWithInstance((ConceptInstance)member));
		} else if (member instanceof EnumeratedScalar) {
			references.addAll(findEnumeratedScalarReferencesWithScalar((EnumeratedScalar)member));
		} else if (member instanceof FacetedScalar) {
			references.addAll(findFacetedScalarReferencesWithScalar((FacetedScalar)member));
		} else if (member instanceof Relation) {
			references.addAll(findRelationReferencesWithRelation((Relation)member));
		} else if (member instanceof RelationEntity) {
			references.addAll(findRelationEntityReferencesWithEntity((RelationEntity)member));
		} else if (member instanceof RelationInstance) {
			references.addAll(findRelationInstanceReferencesWithInstance((RelationInstance)member));
		} else if (member instanceof Rule) {
			references.addAll(findRuleReferencesWithRule((Rule)member));
		} else if (member instanceof ScalarProperty) {
			references.addAll(findScalarPropertyReferencesWithProperty((ScalarProperty)member));
		} else if (member instanceof Structure) {
			references.addAll(findStructureReferencesWithStructure((Structure)member));
		} else if (member instanceof StructuredProperty) {
			references.addAll(findStructuredPropertyReferencesWithProperty((StructuredProperty)member));
		}
		return references;
	}

	public static List<Annotation> findAnnotations(Member member) {
		final List<Annotation> terms = new ArrayList<>();
		terms.addAll(member.getOwnedAnnotations());
		terms.addAll(findReferences(member).stream().
				flatMap(r -> r.getOwnedAnnotations().stream()).
				collect(Collectors.toList()));
		return terms;
	}

	// Term

	public static List<Axiom> findAxioms(Term term) {
		List<Axiom> axioms = new ArrayList<>();
		if (term instanceof SpecializableTerm){
			axioms.addAll(findSpecializationsWithSource(((SpecializableTerm)term)));
		}
		if (term instanceof Classifier) {
			axioms.addAll(findPropertyRestrictions(((Classifier)term)));
		}
		if (term instanceof Entity) {
			axioms.addAll(findRelationRestrictions(((Entity)term)));
			axioms.addAll(findKeys(((Entity)term)));
		}
		return axioms;
	}
	
	// SpecializableTerm

	public static List<SpecializationAxiom> findSpecializationAxiomsWithSpecificTerm(SpecializableTerm term) {
		final List<SpecializationAxiom> axioms = new ArrayList<>();
		axioms.addAll(term.getOwnedSpecializations());
		axioms.addAll(findReferences(term).stream().
				filter(i -> i instanceof SpecializableTermReference).
				map(i -> (SpecializableTermReference)i).
				flatMap(r -> r.getOwnedSpecializations().stream()).
				collect(Collectors.toList()));
		return axioms;
	}

	/**
	 * @Deprecated use {@link OmlSearch#findSpecializationAxiomsWithSpecificTerm(SpecializableTerm)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializationAxiom> findSpecializationsWithSource(SpecializableTerm term) {
		return findSpecializationAxiomsWithSpecificTerm(term);
	}
	
	public static List<SpecializableTerm> findGeneralTerms(SpecializableTerm term) {
		return findSpecializationAxiomsWithSpecificTerm(term).stream().
				map(i -> OmlRead.getGeneralTerm(i)).
				collect(Collectors.toList());
	}

	/**
	 * @Deprecated use {@link OmlSearch#findGeneralTerms(SpecializableTerm)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializableTerm> findSpecializedTerms(SpecializableTerm term) {
		return findGeneralTerms(term);
	}
	
	public static List<SpecializableTerm> findAllGeneralTerms(SpecializableTerm term) {
		return OmlRead.closure(term, t -> findGeneralTerms(t));
	}
	
	/**
	 * @Deprecated use {@link OmlSearch#findAllGeneralTerms(SpecializableTerm)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializableTerm> findAllSpecializedTerms(SpecializableTerm term) {
		return findAllGeneralTerms(term);
	}

	public static List<SpecializableTerm> findAllGeneralTermsInclusive(SpecializableTerm term) {
		return OmlRead.reflexiveClosure(term, t -> findGeneralTerms(t));
	}

	/**
	 * @Deprecated use {@link OmlSearch#findAllGeneralTermsInclusive(SpecializableTerm)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializableTerm> findAllSpecializedTermsInclusive(SpecializableTerm term) {
		return findAllGeneralTermsInclusive(term);
	}

	public static List<SpecializationAxiom> findSpecializationAxiomsWithGeneralTerm(SpecializableTerm term) {
		return findSpecializationAxiomsWithSpecializedTerm(term);
	}

	/**
	 * @Deprecated use {@link OmlSearch#findSpecializationAxiomsWithGeneralTerm(SpecializableTerm)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializationAxiom> findSpecializationsWithTarget(SpecializableTerm term) {
		return findSpecializationAxiomsWithGeneralTerm(term);
	}

	public static List<SpecializableTerm> findSpecificTerms(SpecializableTerm term) {
		return findSpecializationAxiomsWithGeneralTerm(term).stream().
				map(i -> OmlRead.getSpecificTerm(i)).
				collect(Collectors.toList());
	}

	/**
	 * @Deprecated use {@link OmlSearch#findSpecificTerms(SpecializableTerm)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializableTerm> findSpecializingTerms(SpecializableTerm term) {
		return findSpecificTerms(term);
	}

	public static List<SpecializableTerm> findAllSpecificTerms(SpecializableTerm term) {
		return OmlRead.closure(term, t -> findSpecificTerms(t));
	}

	/**
	 * @Deprecated use {@link OmlSearch#findAllSpecificTerms(SpecializableTerm)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializableTerm> findAllSpecializingTerms(SpecializableTerm term) {
		return findAllSpecificTerms(term);
	}
	
	public static List<SpecializableTerm> findAllSpecificTermsInclusive(SpecializableTerm term) {
		return OmlRead.reflexiveClosure(term, t -> findSpecificTerms(t));
	}

	/**
	 * @Deprecated use {@link OmlSearch#findAllSpecificTermsInclusive(SpecializableTerm)} instead 
	 */
	@Deprecated(since = "0.8.3", forRemoval = true)
	public static List<SpecializableTerm> findAllSpecializingTermsInclusive(SpecializableTerm term) {
		return findAllSpecificTermsInclusive(term);
	}

	// Type

	// Classifier
	
	public static List<PropertyRestrictionAxiom> findPropertyRestrictions(Classifier classifier) {
		final List<PropertyRestrictionAxiom> restrictions = new ArrayList<>();
		restrictions.addAll(classifier.getOwnedPropertyRestrictions());
		restrictions.addAll(findReferences(classifier).stream().
				filter(i -> i instanceof ClassifierReference).
				map(i -> (ClassifierReference)i).
				flatMap(r -> r.getOwnedPropertyRestrictions().stream()).
				collect(Collectors.toList()));
		return restrictions;
	}

	// Entity

	public static List<Relation> findRelationsWithSource(Entity entity) {
		final List<Relation> relations = new ArrayList<>();
		relations.addAll(findRelationEntitiesWithSource(entity).stream().
				map(r -> r.getForwardRelation()).
				filter(r -> r != null).
				collect(Collectors.toList()));
		relations.addAll(findRelationEntitiesWithTarget(entity).stream().
				map(r -> r.getReverseRelation()).
				filter(r -> r != null).
				collect(Collectors.toList()));
		return relations;
	}

	public static List<Relation> findRelationsWithTarget(Entity entity) {
		final List<Relation> relations = new ArrayList<>();
		relations.addAll(findRelationEntitiesWithTarget(entity).stream().
				map(r -> r.getForwardRelation()).
				filter(r -> r != null).
				collect(Collectors.toList()));
		relations.addAll(findRelationEntitiesWithSource(entity).stream().
				map(r -> r.getReverseRelation()).
				filter(r -> r != null).
				collect(Collectors.toList()));
		return relations;
	}

	public static List<RelationRestrictionAxiom> findRelationRestrictions(Entity entity) {
		final List<RelationRestrictionAxiom> restrictions = new ArrayList<>();
		restrictions.addAll(entity.getOwnedRelationRestrictions());
		restrictions.addAll(findReferences(entity).stream().
				filter(i -> i instanceof EntityReference).
				map(i -> (EntityReference)i).
				flatMap(r -> r.getOwnedRelationRestrictions().stream()).
				collect(Collectors.toList()));
		return restrictions;
	}

	public static List<KeyAxiom> findKeys(Entity entity) {
		final List<KeyAxiom> keys = new ArrayList<>();
		keys.addAll(entity.getOwnedKeys());
		keys.addAll(findReferences(entity).stream().
				filter(i -> i instanceof EntityReference).
				map(i -> (EntityReference)i).
				flatMap(r -> r.getOwnedKeys().stream()).
				collect(Collectors.toList()));
		return keys;
	}

	public static List<TypeAssertion> findTypeAssertionsWithType(Entity entity) {
		if (entity instanceof Concept) {
			return findTypeAssertionsWithType((Concept) entity);
		} else if (entity instanceof RelationEntity) {
			return findTypeAssertionsWithType((RelationEntity) entity);
		}
		return Collections.emptyList();
	}

	public static List<NamedInstance> findNamedInstancesWithType(Entity entity) {
		if (entity instanceof Concept) {
			return new ArrayList<>(findConceptInstancesWithType((Concept)entity));
		} else if (entity instanceof RelationEntity) {
			return new ArrayList<>(findRelationInstancesWithType((RelationEntity)entity));
		}
		return Collections.emptyList();
	}

	public static List<NamedInstance> findNamedInstancesWithSupertype(Entity entity) {
		
		if (entity instanceof Concept) {
			return new ArrayList<>(findConceptInstancesWithType((Concept)entity));
		} else if (entity instanceof RelationEntity) {
			return new ArrayList<>(findRelationInstancesWithType((RelationEntity)entity));
		}
		return Collections.emptyList();
	}

	// Aspect

	// Concept

	public static List<TypeAssertion> findTypeAssertionsWithType(Concept entity) {
		return findConceptTypeAssertionsWithType(entity).stream().
				filter(i -> i instanceof TypeAssertion).
				map(i -> (TypeAssertion)i).
				collect(Collectors.toList());
	}
	
	public static List<ConceptInstance> findConceptInstancesWithType(Concept entity) {
		return findConceptTypeAssertionsWithType(entity).stream().
				map(i -> OmlRead.getConceptInstance(i)).
				collect(Collectors.toList());
	}

	// RelationEntity
	
	public static List<TypeAssertion> findTypeAssertionsWithType(RelationEntity entity) {
		return findRelationTypeAssertionsWithType(entity).stream().
				filter(i -> i instanceof TypeAssertion).
				map(i -> (TypeAssertion)i).
				collect(Collectors.toList());
	}
	
	public static List<RelationInstance> findRelationInstancesWithType(RelationEntity entity) {
		return findRelationTypeAssertionsWithType(entity).stream().
				map(i -> OmlRead.getRelationInstance(i)).
				collect(Collectors.toList());
	}

	// Structure

	// Property

	// AnnotationProperty

	// FeatureProperty

	// ScalarProperty

	public static List<Entity> findEntitiesWithKeyProperty(ScalarProperty property) {
		return findKeyAxiomWithProperty(property).stream().
				map(i -> OmlRead.getKeyedEntity(i)).
				collect(Collectors.toList());
	}

	// StructuredProperty

	// Scalar

	public static Scalar findGeneralScalar(Scalar scalar) {
		// scalars can have a max of one specialized term
		return findGeneralTerms(scalar).stream().
			filter(i -> i instanceof Scalar).
			map(i -> (Scalar)i).
			findFirst().orElse(null);
	}

	public static Scalar findRootScalar(Scalar scalar) {
		while (scalar != null) {
			scalar = findGeneralScalar(scalar);	
		}
		return scalar;
	}
	
	public static Scalar findJavaScalar(Scalar scalar) {
		while (scalar != null) {
			String scalarIri = OmlRead.getIri(scalar);
			if (scalarIri.equals(OmlConstants.XSD_NS+"integer") ||
			    scalarIri.equals(OmlConstants.XSD_NS+"decimal") ||
			    scalarIri.equals(OmlConstants.XSD_NS+"double") ||
			    scalarIri.equals(OmlConstants.XSD_NS+"float") ||
			    scalarIri.equals(OmlConstants.XSD_NS+"boolean") ||
			    scalarIri.equals(OmlConstants.XSD_NS+"dateTime")) {
				return scalar;
			}
			scalar = findGeneralScalar(scalar);	
		}
		return scalar;
	}

	// FacetedScalar

	// EnumeratedScalar

	// Relation

	// ForwardRelation

	// ReverseRelation

	// Rule

	// Instance

	public static List<PropertyValueAssertion> findPropertyValueAssertions(Instance instance) {
	    if (instance instanceof NamedInstance) {
	        return findPropertyValueAssertions((NamedInstance)instance);
	    } else {
	    	return instance.getOwnedPropertyValues();
	    }
	}

	public static List<Element> findPropertyValuesByIri(Instance instance, String propertyIri) {
		Member property = OmlRead.getMemberByIri(instance.eResource().getResourceSet(), propertyIri);
		assert property instanceof Property : propertyIri+" is not compatoble with this instance";
		return findPropertyValueAssertions(instance).stream().
				filter(a -> OmlRead.getProperty(a) == property).
				map(a -> OmlRead.getValue(a)).
				collect(Collectors.toList());
	}
	
	public static List<Element> findPropertyValuesByAbbreviatedIri(Instance instance, String abbreviatedPropertyIri) {
		Member property = OmlRead.getMemberByAbbreviatedIri(instance.eResource().getResourceSet(), abbreviatedPropertyIri);
		return findPropertyValuesByIri(instance, OmlRead.getIri(property));
	}

	public static List<Literal> findScalarPropertyValuesByAbbreviatedIri(Instance instance, String abbreviatedPropertyIri) {
		return findPropertyValuesByAbbreviatedIri(instance, abbreviatedPropertyIri).stream().
				filter(v -> v instanceof Literal).
				map(v -> (Literal)v).
				collect(Collectors.toList());
	}

	public static List<StructureInstance> findStructuredPropertyValuesByAbbreviatedIri(Instance instance, String abbreviatedPropertyIri) {
		return findPropertyValuesByAbbreviatedIri(instance, abbreviatedPropertyIri).stream().
				filter(v -> v instanceof StructureInstance).
				map(v -> (StructureInstance)v).
				collect(Collectors.toList());
	}

	public static boolean hasTypeIri(Instance instance, String typeIri) {
		Member member = OmlRead.getMemberByIri(instance.eResource().getResourceSet(), typeIri);
		assert member instanceof SpecializableTerm : typeIri+" is not compatoble with this instance";
		Set<SpecializableTerm> subtypes = new HashSet<>(findAllSpecificTermsInclusive((SpecializableTerm)member)); 
		if (instance instanceof StructureInstance) {
			return subtypes.contains(((StructureInstance)instance).getType()); 
		} else if (instance instanceof ConceptInstance) {
			return findTypeAssertions((ConceptInstance)instance).stream().
					filter(i -> subtypes.contains(i.getType())).
					findAny().isPresent();
		} else if (instance instanceof RelationInstance) {
			return findTypeAssertions((RelationInstance)instance).stream().
					filter(i -> subtypes.contains(i.getType())).
					findAny().isPresent();
		}
		return false;
	}

	public static boolean hasAbbreviatedTypeIri(Instance instance, String abbreviatedTypeIri) {
		Member member = OmlRead.getMemberByAbbreviatedIri(instance.eResource().getResourceSet(), abbreviatedTypeIri);
		return hasTypeIri(instance, OmlRead.getIri(member));
	}

	public static List<Assertion> findAssertions(Instance instance) {
		List<Assertion> assertions = new ArrayList<>();
		assertions.addAll(findPropertyValueAssertions(instance));
		if (instance instanceof ConceptInstance) {
			assertions.addAll(findTypeAssertions((ConceptInstance)instance));
			assertions.addAll(findLinkAssertionsWithSource((ConceptInstance)instance));
		}
		if (instance instanceof RelationInstance) {
			assertions.addAll(findTypeAssertions((RelationInstance)instance));
			assertions.addAll(findLinkAssertionsWithSource((RelationInstance)instance));
		}
		return assertions;
	}

	// StructureInstance

	// NamedInstance

	public static List<PropertyValueAssertion> findPropertyValueAssertions(NamedInstance instance) {
		final List<PropertyValueAssertion> assertions = new ArrayList<>();
		assertions.addAll(instance.getOwnedPropertyValues());
		assertions.addAll(findReferences(instance).stream().
				filter(i -> i instanceof NamedInstanceReference).
				map(i -> (NamedInstanceReference)i).
				flatMap(r -> r.getOwnedPropertyValues().stream()).
				collect(Collectors.toList()));
		return assertions;
	}

	public static List<LinkAssertion> findLinkAssertionsWithSource(NamedInstance instance) {
		final List<LinkAssertion> assertions = new ArrayList<>();
		assertions.addAll(instance.getOwnedLinks());
		assertions.addAll(findReferences(instance).stream().
				filter(i -> i instanceof NamedInstanceReference).
				map(i -> (NamedInstanceReference)i).
				flatMap(r -> r.getOwnedLinks().stream()).
				collect(Collectors.toList()));
		return assertions;
	}

	public static List<NamedInstance> findRelatedSourcesByIri(NamedInstance instance, String relationIri) {
		Relation relation = (Relation) OmlRead.getMemberByIri(instance.eResource().getResourceSet(), relationIri);
		final List<NamedInstance> instances = new ArrayList<>();
		instances.addAll(findLinkAssertionsWithTarget(instance).stream().
				filter(a -> a.getRelation() == relation).
				map(a -> OmlRead.getSource(a)).
				collect(Collectors.toList()));
		instances.addAll(findRelationInstancesWithTarget(instance).stream().
				filter(a -> findTypes(a).stream().filter(t -> t == relation).findAny().isPresent()).
				flatMap(a -> a.getSources().stream()).
				collect(Collectors.toList()));
		return instances;
	}

	public static List<NamedInstance> findRelatedSourcesByAbbreviatedIri(NamedInstance instance, String abbreviatedRelationIri) {
		Relation relation = (Relation) OmlRead.getMemberByAbbreviatedIri(instance.eResource().getResourceSet(), abbreviatedRelationIri);
		return findRelatedSourcesByIri(instance, OmlRead.getIri(relation));
	}

	public static List<NamedInstance> findRelatedTargetsByIri(NamedInstance instance, String relationIri) {
		Relation relation = (Relation) OmlRead.getMemberByIri(instance.eResource().getResourceSet(), relationIri);
		final List<NamedInstance> instances = new ArrayList<>();
		instances.addAll(findLinkAssertionsWithSource(instance).stream().
				filter(a -> a.getRelation() == relation).
				map(a -> a.getTarget()).
				collect(Collectors.toList()));
		instances.addAll(findRelationInstancesWithSource(instance).stream().
				filter(a -> findTypes(a).stream().filter(t -> t == relation).findAny().isPresent()).
				flatMap(a -> a.getTargets().stream()).
				collect(Collectors.toList()));
		return instances;
	}

	public static List<NamedInstance> findRelatedTargetsByAbbreviatedIri(NamedInstance instance, String abbreviatedRelationIri) {
		Relation relation = (Relation) OmlRead.getMemberByAbbreviatedIri(instance.eResource().getResourceSet(), abbreviatedRelationIri);
		return findRelatedTargetsByIri(instance, OmlRead.getIri(relation));
	}

	public static List<TypeAssertion> findTypeAssertions(NamedInstance instance) {
		if (instance instanceof ConceptInstance) {
			return new ArrayList<>(findTypeAssertions((ConceptInstance) instance));
		} else if (instance instanceof RelationInstance) {
			return new ArrayList<>(findTypeAssertions((RelationInstance) instance));
		}
		return Collections.emptyList();
	}
	
	public static List<Entity> findTypes(NamedInstance instance) {
		return findTypeAssertions(instance).stream().
				map(i -> OmlRead.getType(i)).
				collect(Collectors.toList());
	}

	// ConceptInstance

	public static List<ConceptTypeAssertion> findTypeAssertions(ConceptInstance instance) {
		final List<ConceptTypeAssertion> relations = new ArrayList<>();
		relations.addAll(instance.getOwnedTypes());
		relations.addAll(findReferences(instance).stream().
				filter(i -> i instanceof ConceptInstanceReference).
				map(i -> (ConceptInstanceReference)i).
				flatMap(r -> r.getOwnedTypes().stream()).
				collect(Collectors.toList()));
		return relations;
	}

	// RelationInstance

	public static List<RelationTypeAssertion> findTypeAssertions(RelationInstance instance) {
		final List<RelationTypeAssertion> relations = new ArrayList<>();
		relations.addAll(instance.getOwnedTypes());
		relations.addAll(findReferences(instance).stream().
				filter(i -> i instanceof RelationInstanceReference).
				map(i -> (RelationInstanceReference)i).
				flatMap(r -> r.getOwnedTypes().stream()).
				collect(Collectors.toList()));
		return relations;
	}

	// Statement

	// VocabularyStatement
	
	// DescriptionStatement

	// Import
		
	// VocabularyImport
	
	// VocabularyExtension
	
	// VocabularyUsage

	// VocabularyBundleImport

	// VocabularyBundleInclusion
	
	// VocabularyBundleExtension
	
	// DescriptionImport

	// DescriptionUsage

	// DescriptionExtension	

	// DescriptionBundleImport

	// DescriptionBundleInclusion
	
	// DescriptionBundleExtension

	// DescriptionBundleUsage

	// Axiom

	// SpecializationAxiom

	// RestrictionAxiom

	// PropertyRestrictionAxiom

	// ScalarPropertyRestrictionAxiom

	// ScalarPropertyRangeRestrictionAxiom

	// ScalarPropertyCardinalityRestrictionAxiom

	// ScalarPropertyValueRestrictionAxiom

	// StructuredPropertyRestrictionAxiom

	// StructuredPropertyRangeRestrictionAxiom

	// StructuredPropertyCardinalityRestrictionAxiom

	// StructuredPropertyValueRestrictionAxiom
	
	// RelationRestrictionAxiom

	// RelationRangeRestrictionAxiom
	
	// RelationCardinalityRestrictionAxiom

	// RelationTargetRestrictionAxiom

	// Assertion
	
	// TypeAssertion

	// ConceptTypeAssertion

	// RelationTypeAssertion

	// PropertyValueAssertion

	// ScalarPropertyValueAssertion

	// StructuredPropertyValueAssertion

	// LinkAssertion

	// Predicate

	// UnaryPredicate

	// EntityPredicate

	// BinaryPredicate
	
	// RelationPredicate

	// SameAsPredicate

	// DifferentFromPredicate

	// RelationEntityPredicate

	// Literal

	public static Object findTypedLiteralValue(Literal literal) {
		Object value = OmlRead.getLiteralValue(literal);
		if (value instanceof String) {
			String strValue =  (String)value;
			Scalar type = findJavaScalar(literal.getType());
			if (type != null) {
				switch(OmlRead.getIri(type)) {
					case OmlConstants.XSD_NS+"integer":
						return Integer.valueOf(strValue);
					case OmlConstants.XSD_NS+"decimal":
						return new BigDecimal(strValue);
					case OmlConstants.XSD_NS+"double":
						return Double.valueOf(strValue);
					case OmlConstants.XSD_NS+"float":
						return Float.valueOf(strValue);
					case OmlConstants.XSD_NS+"boolean":
						return Boolean.valueOf(strValue);
					case OmlConstants.XSD_NS+"dateTime":
						try {
							return new SimpleDateFormat().parse(strValue);
						} catch (ParseException e) {
							throw new DateTimeParseException("Error parsing xsd:dateTime", strValue, 0);
						}
				}
			}
		}
		return value;
	}

	// QuotedLiteral

	// IntegerLiteral

	// DecimalLiteral

	// DoubleLiteral

	// BooleanLiteral

}
