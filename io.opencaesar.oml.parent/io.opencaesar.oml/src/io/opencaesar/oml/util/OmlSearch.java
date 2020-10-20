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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierReference;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
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
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.Reference;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializableTermReference;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
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

	public static Collection<Annotation> findAnnotations(AnnotatedElement element) {
	    if (element instanceof Member) {
	        return findAnnotations((Member)element);
	    } else {
	    	return element.getOwnedAnnotations();
	    }
	}

	public static Collection<Literal> findAnnotationValues(AnnotatedElement element, String annotationPropertyIri) {
		return findAnnotations(element).stream().
			filter(a -> OmlRead.getIri(a.getProperty()).equals(annotationPropertyIri)).
			map(a -> a.getValue()).
			collect(Collectors.toList());
	}
	
	public static String findAnnotationLexicalValue(AnnotatedElement element, String annotationPropertyIri) {
		Collection<Literal> literals = findAnnotationValues(element, annotationPropertyIri);
		return (!literals.isEmpty()) ? OmlRead.getLexicalValue(literals.iterator().next()) : null;
	}
	
	// IdentifiedElement
	
	// Ontology

	public static Collection<Import> findImportsWithTarget(Ontology ontology) {
		final Resource resource = ontology.eResource();
		return (resource == null) ? Collections.emptyList() :
			OmlRead.getOntologies(resource.getResourceSet()).stream().
				flatMap(o -> OmlRead.getImportsWithSource(o).stream()).
				filter(i -> OmlRead.getImportingOntology(i) == ontology).
				collect(Collectors.toList());
	}

	public static Collection<Ontology> findImportingOntologies(Ontology ontology) {
		return findImportsWithTarget(ontology).stream().
			map(i -> OmlRead.getImportingOntology(i)).
			collect(Collectors.toList());
	}

	// VocabularyBox

	public static Collection<DescriptionUsage> findDescriptionUsagesWithUsedVocabularyBox(VocabularyBox box) {
		return findImportsWithTarget(box).stream().
			filter(i -> i instanceof DescriptionUsage).
			map(i -> (DescriptionUsage)i).
			collect(Collectors.toList());
	}

	public static Collection<Description> findUsingDescriptions(VocabularyBox box) {
		return findDescriptionUsagesWithUsedVocabularyBox(box).stream().
				map(i -> OmlRead.getUsingDescription(i)).
				collect(Collectors.toList());
	}

	// Vocabulary

	public static Collection<VocabularyExtension> findVocabularyExtensionsWithExtendedVocabulary(Vocabulary vocabulary) {
		return findImportsWithTarget(vocabulary).stream().
			filter(i -> i instanceof VocabularyExtension).
			map(i -> (VocabularyExtension)i).
			collect(Collectors.toList());
	}

	public static Collection<Vocabulary> findExtendingVocabularies(Vocabulary vocabulary) {
		return findVocabularyExtensionsWithExtendedVocabulary(vocabulary).stream().
				map(i -> OmlRead.getExtendingVocabulary(i)).
				collect(Collectors.toList());
	}

	public static Collection<VocabularyBundleInclusion> findVocabularyBundleInclusionsWithIncludedVocabulary(Vocabulary vocabulary) {
		return findImportsWithTarget(vocabulary).stream().
				filter(i -> i instanceof VocabularyBundleInclusion).
				map(i -> (VocabularyBundleInclusion)i).
				collect(Collectors.toList());
	}

	public static Collection<VocabularyBundle> findIncludingVocabularyBundles(Vocabulary vocabulary) {
		return findVocabularyBundleInclusionsWithIncludedVocabulary(vocabulary).stream().
				map(i -> OmlRead.getIncludingVocabularyBundle(i)).
				collect(Collectors.toList());
	}

	// VocabularyBundle
	
	public static Collection<VocabularyBundleExtension> findVocabularyBundleExtensionsWithExtendedVocabularyBundle(VocabularyBundle bundle) {
		return findImportsWithTarget(bundle).stream().
				filter(i -> i instanceof VocabularyBundleExtension).
				map(i -> (VocabularyBundleExtension)i).
				collect(Collectors.toList());
	}

	public static Collection<VocabularyBundle> findExtendingVocabularyBundles(VocabularyBundle bundle) {
		return findVocabularyBundleExtensionsWithExtendedVocabularyBundle(bundle).stream().
				map(i -> OmlRead.getExtendingVocabularyBundle(i)).
				collect(Collectors.toList());
	}

	public static Collection<DescriptionBundleUsage> findDescriptionBundleUsagesWithUsedVocabularyBundle(VocabularyBundle bundle) {
		return findImportsWithTarget(bundle).stream().
				filter(i -> i instanceof DescriptionBundleUsage).
				map(i -> (DescriptionBundleUsage)i).
				collect(Collectors.toList());
	}

	public static Collection<DescriptionBundle> findUsingDescriptionBundles(VocabularyBundle bundle) {
		return findDescriptionBundleUsagesWithUsedVocabularyBundle(bundle).stream().
				map(i -> OmlRead.getUsingDescriptionBundle(i)).
				collect(Collectors.toList());
	}

	// DescriptionBox

	public static Collection<VocabularyUsage> findVocabularyUsagesWithUsedDescriptionBox(DescriptionBox box) {
		return findImportsWithTarget(box).stream().
				filter(i -> i instanceof VocabularyUsage).
				map(i -> (VocabularyUsage)i).
				collect(Collectors.toList());
	}

	public static Collection<Vocabulary> findUsingVocabularies(DescriptionBox box) {
		return findVocabularyUsagesWithUsedDescriptionBox(box).stream().
				map(i -> OmlRead.getUsingVocabulary(i)).
				collect(Collectors.toList());
	}

	// Description
	
	public static Collection<DescriptionExtension> findDescriptionExtensionsWithExtendedDescription(Description description) {
		return findImportsWithTarget(description).stream().
				filter(i -> i instanceof DescriptionExtension).
				map(i -> (DescriptionExtension)i).
				collect(Collectors.toList());
	}

	public static Collection<Description> findExtendingDescriptions(Description description) {
		return findDescriptionExtensionsWithExtendedDescription(description).stream().
				map(i -> OmlRead.getExtendingDescription(i)).
				collect(Collectors.toList());
	}

	public static Collection<DescriptionBundleInclusion> findDescriptionBundleInclusionsWithIncludedDescription(Description description) {
		return findImportsWithTarget(description).stream().
				filter(i -> i instanceof DescriptionBundleInclusion).
				map(i -> (DescriptionBundleInclusion)i).
				collect(Collectors.toList());
	}

	public static Collection<DescriptionBundle> findIncludingDescriptionBundles(Description description) {
		return findDescriptionBundleInclusionsWithIncludedDescription(description).stream().
				map(i -> OmlRead.getIncludingDescriptionBundle(i)).
				collect(Collectors.toList());
	}

	// DescriptionBundle
	
	public static Collection<DescriptionBundleExtension> findDescriptionBundleExtensionsWithExtendedDescriptionBundle(DescriptionBundle bundle) {
		return findImportsWithTarget(bundle).stream().
				filter(i -> i instanceof DescriptionBundleExtension).
				map(i -> (DescriptionBundleExtension)i).
				collect(Collectors.toList());
	}

	public static Collection<DescriptionBundle> findExtendingDescriptionBundles(DescriptionBundle bundle) {
		return findDescriptionBundleExtensionsWithExtendedDescriptionBundle(bundle).stream().
				map(i -> OmlRead.getExtendingDescriptionBundle(i)).
				collect(Collectors.toList());
	}

	// Member
	
	public static Collection<Reference> findReferences(Member member) {
		Collection<Reference> references = new ArrayList<>();
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

	public static Collection<Annotation> findAnnotations(Member member) {
		final List<Annotation> terms = new ArrayList<>();
		terms.addAll(member.getOwnedAnnotations());
		terms.addAll(findReferences(member).stream().
				flatMap(r -> r.getOwnedAnnotations().stream()).
				collect(Collectors.toList()));
		return terms;
	}

	// Term

	// SpecializableTerm

	public static Collection<SpecializationAxiom> findSpecializationsWithSource(SpecializableTerm term) {
		final List<SpecializationAxiom> specializations = new ArrayList<>();
		specializations.addAll(term.getOwnedSpecializations());
		specializations.addAll(findReferences(term).stream().
				filter(i -> i instanceof SpecializableTermReference).
				map(i -> (SpecializableTermReference)i).
				flatMap(r -> r.getOwnedSpecializations().stream()).
				collect(Collectors.toList()));
		return specializations;
	}

	public static Collection<SpecializableTerm> findSpecializedTerms(SpecializableTerm term) {
		return findSpecializationsWithSource(term).stream().
				map(i -> i.getSpecializedTerm()).
				collect(Collectors.toList());
	}
		
	public static Collection<SpecializationAxiom> findSpecializationsWithTarget(SpecializableTerm term) {
		return findSpecializationAxiomsWithSpecializedTerm(term);
	}

	public static Collection<SpecializableTerm> findSpecializingTerms(SpecializableTerm term) {
		return findSpecializationsWithTarget(term).stream().
				map(i -> OmlRead.getSpecializingTerm(i)).
				collect(Collectors.toList());
	}

	// Type

	// Classifier
	
	public static Collection<PropertyRestrictionAxiom> findPropertyRestrictions(Classifier classifier) {
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

	public static Collection<Relation> findRelationsWithSource(Entity entity) {
		final List<Relation> relations = new ArrayList<>();
		relations.addAll(findRelationEntitiesWithSource(entity).stream().
				map(r -> r.getForward()).
				collect(Collectors.toList()));
		relations.addAll(findRelationEntitiesWithTarget(entity).stream().
				map(r -> r.getReverse()).
				filter(r -> r != null).
				collect(Collectors.toList()));
		return relations;
	}

	public static Collection<Relation> findRelationsWithTarget(Entity entity) {
		final List<Relation> relations = new ArrayList<>();
		relations.addAll(findRelationEntitiesWithTarget(entity).stream().
				map(r -> r.getForward()).
				collect(Collectors.toList()));
		relations.addAll(findRelationEntitiesWithSource(entity).stream().
				map(r -> r.getReverse()).
				filter(r -> r != null).
				collect(Collectors.toList()));
		return relations;
	}

	public static Collection<RelationRestrictionAxiom> findRelationRestrictions(Entity entity) {
		final List<RelationRestrictionAxiom> restrictions = new ArrayList<>();
		restrictions.addAll(entity.getOwnedRelationRestrictions());
		restrictions.addAll(findReferences(entity).stream().
				filter(i -> i instanceof EntityReference).
				map(i -> (EntityReference)i).
				flatMap(r -> r.getOwnedRelationRestrictions().stream()).
				collect(Collectors.toList()));
		return restrictions;
	}

	public static Collection<KeyAxiom> findKeys(Entity entity) {
		final List<KeyAxiom> keys = new ArrayList<>();
		keys.addAll(entity.getOwnedKeys());
		keys.addAll(findReferences(entity).stream().
				filter(i -> i instanceof EntityReference).
				map(i -> (EntityReference)i).
				flatMap(r -> r.getOwnedKeys().stream()).
				collect(Collectors.toList()));
		return keys;
	}

	public static Collection<TypeAssertion> findTypeAssertionsWithType(Entity entity) {
		if (entity instanceof Concept) {
			return findTypeAssertionsWithType((Concept) entity);
		} else if (entity instanceof RelationEntity) {
			return findTypeAssertionsWithType((RelationEntity) entity);
		}
		return Collections.emptyList();
	}

	public static Collection<NamedInstance> findNamedInstancesWithType(Entity entity) {
		if (entity instanceof Concept) {
			return findNamedInstancesWithType((Concept) entity);
		} else if (entity instanceof RelationEntity) {
			return findNamedInstancesWithType((RelationEntity) entity);
		}
		return Collections.emptyList();
	}

	// Aspect

	// Concept

	public static Collection<TypeAssertion> findTypeAssertionsWithType(Concept entity) {
		return findConceptTypeAssertionsWithType(entity).stream().
				filter(i -> i instanceof TypeAssertion).
				map(i -> (TypeAssertion)i).
				collect(Collectors.toList());
	}
	
	public static Collection<NamedInstance> findNamedInstancesWithType(Concept entity) {
		return findConceptInstancesWithType(entity);
	}

	public static Collection<NamedInstance> findConceptInstancesWithType(Concept entity) {
		return findConceptTypeAssertionsWithType(entity).stream().
				map(i -> OmlRead.getConceptInstance(i)).
				collect(Collectors.toList());
	}

	// RelationEntity
	
	public static Collection<TypeAssertion> findTypeAssertionsWithType(RelationEntity entity) {
		return findRelationTypeAssertionsWithType(entity).stream().
				filter(i -> i instanceof TypeAssertion).
				map(i -> (TypeAssertion)i).
				collect(Collectors.toList());
	}
	
	public static Collection<NamedInstance> findNamedInstancesWithType(RelationEntity entity) {
		return findRelationInstancesWithType(entity).stream().
				filter(i -> i instanceof NamedInstance).
				map(i -> (NamedInstance)i).
				collect(Collectors.toList());
	}

	public static Collection<RelationInstance> findRelationInstancesWithType(RelationEntity entity) {
		return findRelationTypeAssertionsWithType(entity).stream().
				map(i -> OmlRead.getRelationInstance(i)).
				collect(Collectors.toList());
	}

	// Structure

	// Property

	// AnnotationProperty

	// FeatureProperty

	// ScalarProperty

	public static Collection<Entity> findEntitiesWithKeyProperty(ScalarProperty property) {
		return findKeyAxiomWithProperty(property).stream().
				map(i -> OmlRead.getKeyedEntity(i)).
				collect(Collectors.toList());
	}

	// StructuredProperty

	// Scalar

	// FacetedScalar

	// EnumeratedScalar

	// Relation

	// ForwardRelation

	// ReverseRelation

	// Rule

	// Instance

	public static Collection<PropertyValueAssertion> findPropertyValueAssertions(Instance instance) {
	    if (instance instanceof NamedInstance) {
	        return findPropertyValueAssertions((NamedInstance)instance);
	    } else {
	    	return instance.getOwnedPropertyValues();
	    }
	}

	public static Collection<Element> findPropertyValues(Instance instance, String propertyIri) {
		return findPropertyValueAssertions(instance).stream().
				filter(a -> OmlRead.getIri(OmlRead.getProperty(a)).equals(propertyIri)).
				map(a -> OmlRead.getValue(a)).
				collect(Collectors.toList());
	}
	
	public static Collection<Literal> findScalarPropertyValues(Instance instance, String propertyIri) {
		return findPropertyValues(instance, propertyIri).stream().
				filter(i -> i instanceof Literal).
				map(i -> (Literal)i).
				collect(Collectors.toList());
	}

	public static Collection<StructureInstance> findStructuredPropertyValues(Instance instance, String propertyIri) {
		return findPropertyValues(instance, propertyIri).stream().
				filter(i -> i instanceof StructureInstance).
				map(i -> (StructureInstance)i).
				collect(Collectors.toList());
	}

	// StructureInstance

	// NamedInstance

	public static Collection<PropertyValueAssertion> findPropertyValueAssertions(NamedInstance instance) {
		final List<PropertyValueAssertion> relations = new ArrayList<>();
		relations.addAll(instance.getOwnedPropertyValues());
		relations.addAll(findReferences(instance).stream().
				filter(i -> i instanceof NamedInstanceReference).
				map(i -> (NamedInstanceReference)i).
				flatMap(r -> r.getOwnedPropertyValues().stream()).
				collect(Collectors.toList()));
		return relations;
	}

	public static Collection<LinkAssertion> findLinkAssertionsWithSource(NamedInstance instance) {
		final List<LinkAssertion> relations = new ArrayList<>();
		relations.addAll(instance.getOwnedLinks());
		relations.addAll(findReferences(instance).stream().
				filter(i -> i instanceof NamedInstanceReference).
				map(i -> (NamedInstanceReference)i).
				flatMap(r -> r.getOwnedLinks().stream()).
				collect(Collectors.toList()));
		return relations;
	}

	public static Collection<NamedInstance> findInstancesRelatedAsTargetOf(NamedInstance instance, String relationIri) {
		final List<NamedInstance> instances = new ArrayList<>();
		instances.addAll(findLinkAssertionsWithSource(instance).stream().
				filter(a -> OmlRead.getIri(a.getRelation()).equals(relationIri)).
				map(a -> a.getTarget()).
				collect(Collectors.toList()));
		instances.addAll(findRelationInstancesWithSource(instance).stream().
				filter(a -> findTypes(a).stream().filter(t -> OmlRead.getIri(t).equals(relationIri)).findAny().isPresent()).
				map(a -> a.getTarget()).
				collect(Collectors.toList()));
		return instances;
	}
	
	public static Collection<NamedInstance> findInstancesRelatedAsSourceOf(NamedInstance instance, String relationIri) {
		final List<NamedInstance> instances = new ArrayList<>();
		instances.addAll(findLinkAssertionsWithTarget(instance).stream().
				filter(a -> OmlRead.getIri(a.getRelation()).equals(relationIri)).
				map(a -> OmlRead.getSource(a)).
				collect(Collectors.toList()));
		instances.addAll(findRelationInstancesWithTarget(instance).stream().
				filter(a -> findTypes(a).stream().filter(t -> OmlRead.getIri(t).equals(relationIri)).findAny().isPresent()).
				map(a -> a.getSource()).
				collect(Collectors.toList()));
		return instances;
	}

	public static Collection<TypeAssertion> findTypeAssertions(NamedInstance instance) {
		if (instance instanceof ConceptInstance) {
			return findTypeAssertions((ConceptInstance) instance);
		} else if (instance instanceof RelationInstance) {
			return findTypeAssertions((RelationInstance) instance);
		}
		return Collections.emptyList();
	}
	
	public static Collection<Entity> findTypes(NamedInstance instance) {
		return findTypeAssertions(instance).stream().
				map(i -> OmlRead.getType(i)).
				collect(Collectors.toList());
	}

	// ConceptInstance

	public static Collection<TypeAssertion> findTypeAssertions(ConceptInstance instance) {
		final List<TypeAssertion> relations = new ArrayList<>();
		relations.addAll(instance.getOwnedTypes());
		relations.addAll(findReferences(instance).stream().
				filter(i -> i instanceof ConceptInstanceReference).
				map(i -> (ConceptInstanceReference)i).
				flatMap(r -> r.getOwnedTypes().stream()).
				collect(Collectors.toList()));
		return relations;
	}

	// RelationInstance

	public static Collection<TypeAssertion> findTypeAssertions(RelationInstance instance) {
		final List<TypeAssertion> relations = new ArrayList<>();
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
			
}