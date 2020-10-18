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

import static org.eclipse.xtext.xbase.lib.IterableExtensions.exists;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.filter;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.flatMap;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.flatten;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.head;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.isEmpty;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.map;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.reject;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

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

	public static Iterable<Annotation> findAnnotations(AnnotatedElement element) {
	    if (element instanceof Member) {
	        return findAnnotations((Member)element);
	    } else {
	    	return element.getOwnedAnnotations();
	    }
	}

	public static Iterable<Literal> findAnnotationValues(AnnotatedElement element, String annotationPropertyIri) {
		return map(filter(findAnnotations(element), a -> OmlRead.getIri(a.getProperty()).equals(annotationPropertyIri)), a -> a.getValue());
	}
	
	public static String findAnnotationLexicalValue(AnnotatedElement element, String annotationPropertyIri) {
		Iterable<Literal> literals = findAnnotationValues(element, annotationPropertyIri);
		return (!isEmpty(literals)) ? OmlRead.getLexicalValue(head(literals)) : null;
	}
	
	// IdentifiedElement
	
	// Ontology

	public static Iterable<Import> findImportsWithTarget(Ontology ontology) {
		final Resource resource = ontology.eResource();
		final ResourceSet resourceSet = (resource != null) ? resource.getResourceSet() : null;
		final Iterable<Ontology> ontologies = OmlRead.getOntologies(resourceSet);
		final Iterable<Import> allImports = flatten(map(ontologies, o -> OmlRead.getImportsWithSource(o)));
		return filter(allImports, i -> OmlRead.getImportingOntology(i) == ontology);
	}

	public static Iterable<Ontology> findImportingOntologies(Ontology ontology) {
		return map(OmlSearch.findImportsWithTarget(ontology), i -> OmlRead.getImportingOntology(i));
	}

	// VocabularyBox

	public static Iterable<DescriptionUsage> findDescriptionUsagesWithUsedVocabularyBox(VocabularyBox box) {
		return filter(OmlSearch.findImportsWithTarget(box), DescriptionUsage.class);
	}

	public static Iterable<Description> findUsingDescriptions(VocabularyBox box) {
		return map(findDescriptionUsagesWithUsedVocabularyBox(box), u -> OmlRead.getUsingDescription(u));
	}

	// Vocabulary

	public static Iterable<VocabularyExtension> findVocabularyExtensionsWithExtendedVocabulary(Vocabulary vocabulary) {
		return filter(findImportsWithTarget(vocabulary), VocabularyExtension.class);
	}

	public static Iterable<Vocabulary> findExtendingVocabularies(Vocabulary vocabulary) {
		return map(findVocabularyExtensionsWithExtendedVocabulary(vocabulary), e -> OmlRead.getExtendingVocabulary(e));
	}

	public static Iterable<VocabularyBundleInclusion> findVocabularyBundleInclusionsWithIncludedVocabulary(Vocabulary vocabulary) {
		return filter(findImportsWithTarget(vocabulary), VocabularyBundleInclusion.class);
	}

	public static Iterable<VocabularyBundle> findIncludingVocabularyBundles(Vocabulary vocabulary) {
		return map(findVocabularyBundleInclusionsWithIncludedVocabulary(vocabulary), i -> OmlRead.getIncludingVocabularyBundle(i));
	}

	// VocabularyBundle
	
	public static Iterable<VocabularyBundleExtension> findVocabularyBundleExtensionsWithExtendedVocabularyBundle(VocabularyBundle bundle) {
		return filter(findImportsWithTarget(bundle), VocabularyBundleExtension.class);
	}

	public static Iterable<VocabularyBundle> findExtendingVocabularyBundles(VocabularyBundle bundle) {
		return map(findVocabularyBundleExtensionsWithExtendedVocabularyBundle(bundle), e -> OmlRead.getExtendingVocabularyBundle(e));
	}

	public static Iterable<DescriptionBundleUsage> findDescriptionBundleUsagesWithUsedVocabularyBundle(VocabularyBundle bundle) {
		return filter(findImportsWithTarget(bundle), DescriptionBundleUsage.class);
	}

	public static Iterable<DescriptionBundle> findUsingDescriptionBundles(VocabularyBundle bundle) {
		return map(findDescriptionBundleUsagesWithUsedVocabularyBundle(bundle), i -> OmlRead.getUsingDescriptionBundle(i));
	}

	// DescriptionBox

	public static Iterable<VocabularyUsage> findVocabularyUsagesWithUsedDescriptionBox(DescriptionBox box) {
		return filter(findImportsWithTarget(box), VocabularyUsage.class);
	}

	public static Iterable<Vocabulary> findUsingVocabularies(DescriptionBox box) {
		return map(findVocabularyUsagesWithUsedDescriptionBox(box), u -> OmlRead.getUsingVocabulary(u));
	}

	// Description
	
	public static Iterable<DescriptionExtension> findDescriptionExtensionsWithExtendedDescription(Description description) {
		return filter(findImportsWithTarget(description), DescriptionExtension.class);
	}

	public static Iterable<Description> findExtendingDescriptions(Description description) {
		return map(findDescriptionExtensionsWithExtendedDescription(description), e -> OmlRead.getExtendingDescription(e));
	}

	public static Iterable<DescriptionBundleInclusion> findDescriptionBundleInclusionsWithIncludedDescription(Description description) {
		return filter(findImportsWithTarget(description), DescriptionBundleInclusion.class);
	}

	public static Iterable<DescriptionBundle> findIncludingDescriptionBundles(Description description) {
		return map(findDescriptionBundleInclusionsWithIncludedDescription(description), i -> OmlRead.getIncludingDescriptionBundle(i));
	}

	// DescriptionBundle
	
	public static Iterable<DescriptionBundleExtension> findDescriptionBundleExtensionsWithExtendedDescriptionBundle(DescriptionBundle bundle) {
		return filter(findImportsWithTarget(bundle), DescriptionBundleExtension.class);
	}

	public static Iterable<DescriptionBundle> findExtendingDescriptionBundles(DescriptionBundle bundle) {
		return map(findDescriptionBundleExtensionsWithExtendedDescriptionBundle(bundle), e -> OmlRead.getExtendingDescriptionBundle(e));
	}

	// Member
	
	public static Iterable<Reference> findReferences(Member member) {
		if (member instanceof AnnotationProperty) {
			return findReferences((AnnotationProperty) member);
		} else if (member instanceof Aspect) {
			return findReferences((Aspect) member);
		} else if (member instanceof Concept) {
			return findReferences((Concept) member);
		} else if (member instanceof ConceptInstance) {
			return findReferences((ConceptInstance) member);
		} else if (member instanceof EnumeratedScalar) {
			return findReferences((EnumeratedScalar) member);
		} else if (member instanceof FacetedScalar) {
			return findReferences((FacetedScalar) member);
		} else if (member instanceof Relation) {
			return findReferences((Relation) member);
		} else if (member instanceof RelationEntity) {
			return findReferences((RelationEntity) member);
		} else if (member instanceof RelationInstance) {
			return findReferences((RelationInstance) member);
		} else if (member instanceof Rule) {
			return findReferences((Rule) member);
		} else if (member instanceof ScalarProperty) {
			return findReferences((ScalarProperty) member);
		} else if (member instanceof Structure) {
			return findReferences((Structure) member);
		} else if (member instanceof StructuredProperty) {
			return findReferences((StructuredProperty) member);
		}
		return Collections.emptyList();
	}

	public static Iterable<Annotation> findAnnotations(Member member) {
		final List<Annotation> terms = new ArrayList<>();
		terms.addAll(member.getOwnedAnnotations());
		terms.addAll(toList(flatMap(findReferences(member), r -> r.getOwnedAnnotations())));
		return terms;
	}

	// Term

	// SpecializableTerm

	public static Iterable<SpecializationAxiom> findSpecializationsWithSource(SpecializableTerm term) {
		final List<SpecializationAxiom> specializations = new ArrayList<>();
		specializations.addAll(term.getOwnedSpecializations());
		specializations.addAll(toList(flatMap(filter(findReferences(term), SpecializableTermReference.class), r -> r.getOwnedSpecializations())));
		return specializations;
	}

	public static Iterable<SpecializableTerm> findSpecializedTerms(SpecializableTerm term) {
		return map(findSpecializationsWithSource(term), s -> s.getSpecializedTerm());
	}
		
	public static Iterable<SpecializationAxiom> findSpecializationsWithTarget(SpecializableTerm term) {
		return findSpecializationAxiomsWithSpecializedTerm(term);
	}

	public static Iterable<SpecializableTerm> findSpecializingTerms(SpecializableTerm term) {
		return map(findSpecializationsWithTarget(term), s -> OmlRead.getSpecializingTerm(s));
	}

	// Type

	// Classifier
	
	public static Iterable<PropertyRestrictionAxiom> findPropertyRestrictions(Classifier classifier) {
		final List<PropertyRestrictionAxiom> restrictions = new ArrayList<>();
		restrictions.addAll(classifier.getOwnedPropertyRestrictions());
		restrictions.addAll(toList(flatMap(filter(findReferences(classifier), ClassifierReference.class), r -> r.getOwnedPropertyRestrictions())));
		return restrictions;
	}

	// Entity

	public static Iterable<Relation> findRelationsWithSource(Entity entity) {
		final List<Relation> relations = new ArrayList<>();
		relations.addAll(toList(map(findRelationEntitiesWithSource(entity), r -> r.getForward())));
		relations.addAll(toList(reject(map(findRelationEntitiesWithTarget(entity), r -> r.getReverse()), r -> r == null)));
		return relations;
	}

	public static Iterable<Relation> findRelationsWithTarget(Entity entity) {
		final List<Relation> relations = new ArrayList<>();
		relations.addAll(toList(map(findRelationEntitiesWithTarget(entity), r -> r.getForward())));
		relations.addAll(toList(reject(map(findRelationEntitiesWithSource(entity), r -> r.getReverse()), r -> r == null)));
		return relations;
	}

	public static Iterable<RelationRestrictionAxiom> findRelationRestrictions(Entity entity) {
		final List<RelationRestrictionAxiom> restrictions = new ArrayList<>();
		restrictions.addAll(entity.getOwnedRelationRestrictions());
		restrictions.addAll(toList(flatMap(filter(findReferences(entity), EntityReference.class), r -> r.getOwnedRelationRestrictions())));
		return restrictions;
	}

	public static Iterable<KeyAxiom> findKeys(Entity entity) {
		final List<KeyAxiom> keys = new ArrayList<>();
		keys.addAll(entity.getOwnedKeys());
		keys.addAll(toList(flatMap(filter(findReferences(entity), EntityReference.class), r -> r.getOwnedKeys())));
		return keys;
	}

	public static Iterable<TypeAssertion> findTypeAssertionsWithType(Entity entity) {
		if (entity instanceof Concept) {
			return findTypeAssertionsWithType((Concept) entity);
		} else if (entity instanceof RelationEntity) {
			return findTypeAssertionsWithType((RelationEntity) entity);
		}
		return Collections.emptyList();
	}

	public static Iterable<NamedInstance> findNamedInstancesWithType(Entity entity) {
		if (entity instanceof Concept) {
			return findNamedInstancesWithType((Concept) entity);
		} else if (entity instanceof RelationEntity) {
			return findNamedInstancesWithType((RelationEntity) entity);
		}
		return Collections.emptyList();
	}

	// Aspect

	public static Iterable<Reference> findReferences(Aspect member) {
		return filter(findAspectReferencesWithAspect(member), Reference.class);
	}

	// Concept

	public static Iterable<Reference> findReferences(Concept member) {
		return filter(findConceptReferencesWithConcept(member), Reference.class);
	}

	public static Iterable<TypeAssertion> findTypeAssertionsWithType(Concept entity) {
		return filter(findConceptTypeAssertionsWithType(entity), TypeAssertion.class);
	}
	
	public static Iterable<NamedInstance> findNamedInstancesWithType(Concept entity) {
		return findConceptInstancesWithType(entity);
	}

	public static Iterable<NamedInstance> findConceptInstancesWithType(Concept entity) {
		return map(findConceptTypeAssertionsWithType(entity), a -> OmlRead.getConceptInstance(a));
	}

	// RelationEntity
	
	public static Iterable<Reference> findReferences(RelationEntity member) {
		return filter(findRelationEntityReferencesWithEntity(member), Reference.class);
	}

	public static Iterable<TypeAssertion> findTypeAssertionsWithType(RelationEntity entity) {
		return filter(findRelationTypeAssertionsWithType(entity), TypeAssertion.class);
	}
	
	public static Iterable<NamedInstance> findNamedInstancesWithType(RelationEntity entity) {
		return filter(findRelationInstancesWithType(entity), NamedInstance.class);
	}

	public static Iterable<RelationInstance> findRelationInstancesWithType(RelationEntity entity) {
		return map(findRelationTypeAssertionsWithType(entity), a -> OmlRead.getRelationInstance(a));
	}

	// Structure

	public static Iterable<Reference> findReferences(Structure member) {
		return filter(findStructureReferencesWithStructure(member), Reference.class);
	}

	// Property

	// AnnotationProperty

	public static Iterable<Reference> findReferences(AnnotationProperty member) {
		return filter(findAnnotationPropertyReferencesWithProperty(member), Reference.class);
	}

	// FeatureProperty

	// ScalarProperty

	public static Iterable<Reference> findReferences(ScalarProperty member) {
		return filter(findScalarPropertyReferencesWithProperty(member), Reference.class);
	}

	public static Iterable<Entity> findEntitiesWithKeyProperty(ScalarProperty property) {
		return map(findKeyAxiomWithProperty(property), a -> OmlRead.getKeyedEntity(a));
	}

	// StructuredProperty

	public static Iterable<Reference> findReferences(StructuredProperty member) {
		return filter(findStructuredPropertyReferencesWithProperty(member), Reference.class);
	}

	// Scalar

	// FacetedScalar

	public static Iterable<Reference> findReferences(FacetedScalar member) {
		return filter(findFacetedScalarReferencesWithScalar(member), Reference.class);
	}

	// EnumeratedScalar

	public static Iterable<Reference> findReferences(EnumeratedScalar member) {
		return filter(findEnumeratedScalarReferencesWithScalar(member), Reference.class);
	}

	// Relation

	public static Iterable<Reference> findReferences(Relation member) {
		return filter(findRelationReferencesWithRelation(member), Reference.class);
	}

	// ForwardRelation

	// ReverseRelation

	// Rule

	public static Iterable<Reference> findReferences(Rule member) {
		return filter(findRuleReferencesWithRule(member), Reference.class);
	}

	// Instance

	public static Iterable<PropertyValueAssertion> findPropertyValueAssertions(Instance instance) {
	    if (instance instanceof NamedInstance) {
	        return findPropertyValueAssertions((NamedInstance)instance);
	    } else {
	    	return instance.getOwnedPropertyValues();
	    }
	}

	public static Iterable<Element> findPropertyValues(Instance instance, String propertyIri) {
		return map(filter(findPropertyValueAssertions(instance), a -> OmlRead.getIri(OmlRead.getProperty(a)).equals(propertyIri)), a -> OmlRead.getValue(a));
	}
	
	public static Iterable<Literal> findScalarPropertyValues(Instance instance, String propertyIri) {
		return filter(findPropertyValues(instance, propertyIri), Literal.class);
	}

	public static Iterable<StructureInstance> findStructuredPropertyValues(Instance instance, String propertyIri) {
		return filter(findPropertyValues(instance, propertyIri), StructureInstance.class);
	}

	// StructureInstance

	// NamedInstance

	public static Iterable<PropertyValueAssertion> findPropertyValueAssertions(NamedInstance instance) {
		final List<PropertyValueAssertion> relations = new ArrayList<>();
		relations.addAll(instance.getOwnedPropertyValues());
		relations.addAll(toList(flatMap(filter(findReferences(instance), NamedInstanceReference.class), r -> r.getOwnedPropertyValues())));
		return relations;
	}

	public static Iterable<LinkAssertion> findLinkAssertionsWithSource(NamedInstance instance) {
		final List<LinkAssertion> relations = new ArrayList<>();
		relations.addAll(instance.getOwnedLinks());
		relations.addAll(toList(flatMap(filter(findReferences(instance), NamedInstanceReference.class), r -> r.getOwnedLinks())));
		return relations;
	}

	public static Iterable<NamedInstance> findInstancesRelatedAsTargetOf(NamedInstance instance, String relationIri) {
		final List<NamedInstance> instances = new ArrayList<>();
		instances.addAll(toList(map(filter(findLinkAssertionsWithSource(instance), a -> OmlRead.getIri(a.getRelation()).equals(relationIri)), a -> a.getTarget())));
		instances.addAll(toList(map(filter(findRelationInstancesWithSource(instance), a -> exists(findTypes(a), t -> OmlRead.getIri(t).equals(relationIri))), a -> a.getTarget())));
		return instances;
	}
	
	public static Iterable<NamedInstance> findInstancesRelatedAsSourceOf(NamedInstance instance, String relationIri) {
		final List<NamedInstance> instances = new ArrayList<>();
		instances.addAll(toList(map(filter(findLinkAssertionsWithTarget(instance), a -> OmlRead.getIri(a.getRelation()).equals(relationIri)), a -> OmlRead.getSource(a))));
		instances.addAll(toList(map(filter(findRelationInstancesWithTarget(instance), a -> exists(findTypes(a), t -> OmlRead.getIri(t).equals(relationIri))), a -> a.getSource())));
		return instances;
	}

	public static Iterable<TypeAssertion> findTypeAssertions(NamedInstance instance) {
		if (instance instanceof ConceptInstance) {
			return findTypeAssertions((ConceptInstance) instance);
		} else if (instance instanceof RelationInstance) {
			return findTypeAssertions((RelationInstance) instance);
		}
		return Collections.emptyList();
	}
	
	public static Iterable<Entity> findTypes(NamedInstance instance) {
		return map(findTypeAssertions(instance), a -> OmlRead.getType(a));
	}

	// ConceptInstance

	public static Iterable<Reference> findReferences(ConceptInstance member) {
		return filter(findConceptInstanceReferencesWithInstance(member), Reference.class);
	}

	public static Iterable<TypeAssertion> findTypeAssertions(ConceptInstance instance) {
		final List<TypeAssertion> relations = new ArrayList<>();
		relations.addAll(instance.getOwnedTypes());
		relations.addAll(toList(flatMap(filter(findReferences(instance), ConceptInstanceReference.class), r -> r.getOwnedTypes())));
		return relations;
	}

	// RelationInstance

	public static Iterable<Reference> findReferences(RelationInstance member) {
		return filter(findRelationInstanceReferencesWithInstance(member), Reference.class);
	}

	public static Iterable<TypeAssertion> findTypeAssertions(RelationInstance instance) {
		final List<TypeAssertion> relations = new ArrayList<>();
		relations.addAll(instance.getOwnedTypes());
		relations.addAll(toList(flatMap(filter(findReferences(instance), RelationInstanceReference.class), r -> r.getOwnedTypes())));
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