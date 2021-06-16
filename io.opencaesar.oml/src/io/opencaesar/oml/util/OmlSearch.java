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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
import io.opencaesar.oml.FeatureProperty;
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
import io.opencaesar.oml.QuotedLiteral;
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

/**
 * The <b>Search</b> API for the model. It complements the {@link OmlIndex} API by additional utilities.
 *  
 * @author elaasar
 */
public final class OmlSearch extends OmlIndex {

    //-------------------------------------------------
    // DEPRECATED
    //-------------------------------------------------

    /**
     * Find an import that references the given ontology
     * 
     * @param ontology the ontology to find
     * @return an import that references the given ontology
     * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Import> findImportsWithTarget(Ontology ontology) {
        return findReferencingImports(ontology);
    }

    /**
     * Finds description usages that reference the given vocabulary box
     * 
     * @param box the given vocabulary box
     * @return a list of description usages that reference the given vocabulary box
     * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} and filter for {@link DescriptionUsage} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionUsage> findDescriptionUsagesWithUsedVocabularyBox(VocabularyBox box) {
        return findReferencingImports(box).stream()
            .filter(i -> i instanceof DescriptionUsage)
            .map(i -> (DescriptionUsage)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds descriptions that use the given vocabulary box
     * 
     * @param box the given vocabulary box
     * @return a list of descriptions that use the given vocabulary box
     * @deprecated use {@link OmlSearch#findImportingOntologies(Ontology)} and filter for {@link Description} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Description> findUsingDescriptions(VocabularyBox box) {
        return findImportingOntologies(box).stream()
            .filter(i -> i instanceof Description)
            .map(i -> (Description)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds vocabulary extensions that reference the given vocabulary
     * 
     * @param vocabulary the given vocabulary
     * @return a list of vocabulary extensions that reference the given vocabulary
     * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} and filter for {@link VocabularyExtension} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyExtension> findVocabularyExtensionsWithExtendedVocabulary(Vocabulary vocabulary) {
        return findReferencingImports(vocabulary).stream()
            .filter(i -> i instanceof VocabularyExtension)
            .map(i -> (VocabularyExtension)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds vocabularies that extend the given vocabulary
     * 
     * @param vocabulary the given vocabulary
     * @return a list of vocabularies that extend the given vocabulary
     * @deprecated use {@link OmlSearch#findImportingOntologies(Ontology)} and filter for {@link Vocabulary} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Vocabulary> findExtendingVocabularies(Vocabulary vocabulary) {
        return findImportingOntologies(vocabulary).stream()
            .filter(i -> i instanceof Vocabulary)
            .map(i -> (Vocabulary)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds vocabulary bundle inclusions that reference the given vocabulary
     * 
     * @param vocabulary the given vocabulary
     * @return a list of vocabulary bundle inclusions that reference the given vocabulary
     * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} and filter for {@link VocabularyBundleInclusion} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyBundleInclusion> findVocabularyBundleInclusionsWithIncludedVocabulary(Vocabulary vocabulary) {
        return findReferencingImports(vocabulary).stream()
            .filter(i -> i instanceof VocabularyBundleInclusion)
            .map(i -> (VocabularyBundleInclusion)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds vocabulary bundles that include the given vocabulary
     * 
     * @param vocabulary the given vocabulary
     * @return a list of vocabulary bundles that include the given vocabulary
     * @deprecated use {@link OmlSearch#findImportingOntologies(Ontology)} and filter for {@link VocabularyBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyBundle> findIncludingVocabularyBundles(Vocabulary vocabulary) {
        return findImportingOntologies(vocabulary).stream()
            .filter(i -> i instanceof VocabularyBundle)
            .map(i -> (VocabularyBundle)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds vocabulary bundle extensions that reference the given vocabulary bundle
     * 
     * @param bundle the given vocabulary bundle
     * @return a list of vocabulary bundle extensions that reference the given vocabulary bundle
     * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} and filter for {@link VocabularyBundleExtension} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyBundleExtension> findVocabularyBundleExtensionsWithExtendedVocabularyBundle(VocabularyBundle bundle) {
        return findReferencingImports(bundle).stream()
            .filter(i -> i instanceof VocabularyBundleExtension)
            .map(i -> (VocabularyBundleExtension)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds vocabulary bundles that extend the given vocabulary bundle
     * 
     * @param bundle the given vocabulary bundle
     * @return a list of vocabulary bundles that extend the given vocabulary bundle
     * @deprecated use {@link OmlSearch#findImportingOntologies(Ontology)} and filter for {@link VocabularyBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyBundle> findExtendingVocabularyBundles(VocabularyBundle bundle) {
        return findImportingOntologies(bundle).stream()
            .filter(i -> i instanceof VocabularyBundle)
            .map(i -> (VocabularyBundle)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds description bundle usages that reference the given vocabulary bundle
     * 
     * @param bundle the given vocabulary bundle
     * @return a list of description bundle usages that reference the given vocabulary bundle
     * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} and filter for {@link DescriptionBundleUsage} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundleUsage> findDescriptionBundleUsagesWithUsedVocabularyBundle(VocabularyBundle bundle) {
        return findReferencingImports(bundle).stream()
            .filter(i -> i instanceof DescriptionBundleUsage)
            .map(i -> (DescriptionBundleUsage)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds description bundles that use the given vocabulary bundle
     * 
     * @param bundle the given vocabulary bundle
     * @return a list of description bundle extensions that use the given vocabulary bundle
     * @deprecated use {@link OmlSearch#findImportingOntologies(Ontology)} and filter for {@link DescriptionBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundle> findUsingDescriptionBundles(VocabularyBundle bundle) {
        return findImportingOntologies(bundle).stream()
            .filter(i -> i instanceof DescriptionBundle)
            .map(i -> (DescriptionBundle)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds vocabulary usages that reference the given description box
     * 
     * @param box the given description box
     * @return a list of vocabulary usages that reference the given description box
     * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} and filter for {@link VocabularyUsage} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyUsage> findVocabularyUsagesWithUsedDescriptionBox(DescriptionBox box) {
        return findReferencingImports(box).stream()
            .filter(i -> i instanceof VocabularyUsage)
            .map(i -> (VocabularyUsage)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds vocabularies that reference the given description box
     * 
     * @param box the given description box
     * @return a list of vocabularies that use the given description box
     * @deprecated use {@link OmlSearch#findImportingOntologies(Ontology)} and filter for {@link Vocabulary} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Vocabulary> findUsingVocabularies(DescriptionBox box) {
        return findImportingOntologies(box).stream()
            .filter(i -> i instanceof Vocabulary)
            .map(i -> (Vocabulary)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds description extensions that reference the given description
     * 
     * @param description the given description
     * @return a list of description extensions that reference the given description
    * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} and filter for {@link DescriptionExtension} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionExtension> findDescriptionExtensionsWithExtendedDescription(Description description) {
        return findReferencingImports(description).stream()
            .filter(i -> i instanceof DescriptionExtension)
            .map(i -> (DescriptionExtension)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds descriptions that extend the given description
     * 
     * @param description the given description
     * @return a list of descriptions that extend the given description
     * @deprecated use {@link OmlSearch#findImportingOntologies(Ontology)} and filter for {@link Description} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Description> findExtendingDescriptions(Description description) {
        return findImportingOntologies(description).stream()
            .filter(i -> i instanceof Description)
            .map(i -> (Description)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds description bundle inclusions that reference the given description
     * 
     * @param description the given description
     * @return a list of description bundle inclusions that reference the given description
     * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} and filter for {@link DescriptionBundleInclusion} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundleInclusion> findDescriptionBundleInclusionsWithIncludedDescription(Description description) {
        return findReferencingImports(description).stream()
            .filter(i -> i instanceof DescriptionBundleInclusion)
            .map(i -> (DescriptionBundleInclusion)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds description bundles that reference the given description
     * 
     * @param description the given description
     * @return a list of description bundles that include the given description
     * @deprecated use {@link OmlSearch#findImportingOntologies(Ontology)} and filter for {@link DescriptionBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundle> findIncludingDescriptionBundles(Description description) {
        return findImportingOntologies(description).stream()
            .filter(i -> i instanceof DescriptionBundle)
            .map(i -> (DescriptionBundle)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds description bundle extensions that reference the given description bundle
     * 
     * @param bundle the given description bundle
     * @return a list of description bundle extensions that reference the given description bundle
     * @deprecated use {@link OmlSearch#findReferencingImports(Ontology)} and filter for {@link DescriptionBundleExtension} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundleExtension> findDescriptionBundleExtensionsWithExtendedDescriptionBundle(DescriptionBundle bundle) {
        return findReferencingImports(bundle).stream()
            .filter(i -> i instanceof DescriptionBundleExtension)
            .map(i -> (DescriptionBundleExtension)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds description bundles that reference the given description bundle
     * 
     * @param bundle the given description bundle
     * @return a list of description bundles that extend the given description bundle
     * @deprecated use {@link OmlSearch#findImportingOntologies(Ontology)} and filter for {@link DescriptionBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundle> findExtendingDescriptionBundles(DescriptionBundle bundle) {
        return findImportingOntologies(bundle).stream()
            .filter(i -> i instanceof DescriptionBundle)
            .map(i -> (DescriptionBundle)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds specialization axioms that reference the given term as the specific
     * 
     * @param term the given term
     * @return a list of specialization axioms that reference the given term as specific
     * @deprecated use {@link OmlSearch#findSpecializationsWithSubTerm(SpecializableTerm)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<SpecializationAxiom> findSpecializationAxiomsWithSpecificTerm(SpecializableTerm term) {
        return findSpecializationsWithSubTerm(term);
    }
    
    /**
     * Finds specialization axioms that reference the given term as the general
     * 
     * @param term the given term
     * @return a list of specialization axioms that reference the given term as general
     * @deprecated use {@link OmlSearch#findSpecializationsWithSuperTerm(SpecializableTerm)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<SpecializationAxiom> findSpecializationAxiomsWithGeneralTerm(SpecializableTerm term) {
        return findSpecializationsWithSuperTerm(term);
    }

    /**
     * Finds scalar that is the supertype of the given scalar
     * 
     * @param scalar the given scalar
     * @return a scalar that is the supertype of the given scalar
     * @deprecated use {@link OmlSearch#findSuperTerms(SpecializableTerm)} and cast the first entry to {@link Scalar} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Scalar findGeneralScalar(Scalar scalar) {
        return findSuperTerms(scalar).stream().
            filter(i -> i instanceof Scalar).
            map(i -> (Scalar)i).
            findFirst().orElse(null);
    }

    /**
     * Finds entities with keys that reference the given scalar property
     * 
     * @param property the given scalar property
     * @return a list of entities with keys that reference the given scalar property
     * @deprecated use {@link OmlSearch#findEntitiesKeyedWith(ScalarProperty)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Entity> findEntitiesWithKeyProperty(ScalarProperty property) {
        return findEntitiesKeyedWith(property);
    }
    
    /**
     * Finds direct super( general) terms of the given term
     * 
     * @param term the given term
     * @return a list of direct super (general) terms of the given term 
     * @deprecated use {@link OmlSearch#findAllSuperTerms(SpecializableTerm, boolean)} and set the inclusive flag to false instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<SpecializableTerm> findAllGeneralTerms(SpecializableTerm term) {
        return findAllSuperTerms(term, false);
    }
    

    /**
     * Finds direct or transitive super (general) terms of the given term
     * 
     * @param term the given term
     * @return a list of direct or transitive super (general) terms of the given term 
     * @deprecated use {@link OmlSearch#findAllSuperTerms(SpecializableTerm, boolean)} and set the inclusive flag to true instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<SpecializableTerm> findAllGeneralTermsInclusive(SpecializableTerm term) {
        return findAllSuperTerms(term, true);
    }

    /**
     * Finds direct sub (specific) terms of the given term
     * 
     * @param term the given term
     * @return a list of sub (specific) terms of the given term 
     * @deprecated use {@link OmlSearch#findAllSubTerms(SpecializableTerm, boolean)} and set the inclusive flag to false instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<SpecializableTerm> findAllSpecificTerms(SpecializableTerm term) {
        return findAllSubTerms(term, false);
    }

    /**
     * Finds direct sub (specific) terms of the given term
     * 
     * @param term the given term
     * @return a list of sub (specific) terms of the given term 
     * @deprecated use {@link OmlSearch#findAllSubTerms(SpecializableTerm, boolean)} and set the inclusive flag to true instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<SpecializableTerm> findAllSpecificTermsInclusive(SpecializableTerm term) {
        return findAllSubTerms(term, true);
    }

    /**
     * Finds relations that have he given entity as its source
     * 
     * @param entity the given entity
     * @return a list of relations that have the given entity as its source 
     * @deprecated use {@link OmlSearch#findSourceRelations(Entity)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Relation> findRelationsWithSource(Entity entity) {
        return findSourceRelations(entity);
    }
    
    /**
     * Finds relations that have he given entity as its target
     * 
     * @param entity the given entity
     * @return a list of relations that have the given entity as its target 
     * @deprecated use {@link OmlSearch#findTargetRelations(Entity)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Relation> findRelationsWithTarget(Entity entity) {
        return findTargetRelations(entity);
    }

    /**
     * Finds type assertions that reference the given entity as a type
     * 
     * @param entity the given entity
     * @return a list of type assertions that reference the given entity as a type 
     * @deprecated use {@link OmlIndex#findConceptTypeAssertionsWithType(Concept)} or {@link OmlIndex#findRelationTypeAssertionsWithType(RelationEntity)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<TypeAssertion> findTypeAssertionsWithType(Entity entity) {
        List<TypeAssertion> assertions = new ArrayList<>();
        if (entity instanceof Concept) {
            assertions.addAll(findConceptTypeAssertionsWithType((Concept)entity));
        } else if (entity instanceof RelationEntity) {
            assertions.addAll(findRelationTypeAssertionsWithType((RelationEntity)entity));
        }
        return assertions;
    }

    /**
     * Finds literals that are the values of a scalar property with the given abbreviated iri on the given instance
     * 
     * @param instance the given instance
     * @param propertyIri the given iri of a abbreviated property 
     * @return a list of literals that are the values of a abbreviated property with the given iri on the given instance 
     * @deprecated use {@link OmlSearch#findPropertyValues(Instance, FeatureProperty)} and cast first element if any to {@link Literal} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Literal> findScalarPropertyValuesByAbbreviatedIri(Instance instance, String propertyIri) {
        FeatureProperty property = (FeatureProperty) OmlRead.getMemberByIri(instance, propertyIri);
        return findPropertyValues(instance, property).stream().
                filter(v -> v instanceof Literal).
                map(v -> (Literal)v).
                collect(Collectors.toList());
    }

    /**
     * Finds structure instances that are the values of a scalar property with the given abbreviated iri on the given instance
     * 
     * @param instance the given instance
     * @param propertyIri the given abbreviated iri of a structure property 
     * @return a list of structure instances that are the values of a structure property with the given abbreviated iri on the given instance 
     * @deprecated use {@link OmlSearch#findPropertyValues(Instance, FeatureProperty)} and cast first element if any to {@link StructureInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<StructureInstance> findStructuredPropertyValuesByAbbreviatedIri(Instance instance, String propertyIri) {
        FeatureProperty property = (FeatureProperty) OmlRead.getMemberByIri(instance, propertyIri);
        return findPropertyValues(instance, property).stream().
                filter(v -> v instanceof StructureInstance).
                map(v -> (StructureInstance)v).
                collect(Collectors.toList());
    }

    /**
     * Finds elements that are the values of a feature property with the given iri on the given instance
     * 
     * @param instance the given instance
     * @param propertyIri the given iri of a feature property 
     * @return a list of elements that are the values of a feature property with the given iri on the given instance 
     * @deprecated use {@link OmlSearch#findPropertyValues(Instance, FeatureProperty)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Element> findPropertyValuesByIri(Instance instance, String propertyIri) {
        FeatureProperty property = (FeatureProperty) OmlRead.getMemberByIri(instance, propertyIri);
        return findPropertyValues(instance, property);
    }
    
    /**
     * Finds elements that are the values of a feature property with the given abbreviated iri on the given instance
     * 
     * @param instance the given instance
     * @param propertyIri the given abbreviatediri of a feature property 
     * @return a list of elements that are the values of a feature property with the given abbreviated iri on the given instance 
     * @deprecated use {@link OmlSearch#findPropertyValues(Instance, FeatureProperty)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Element> findPropertyValuesByAbbreviatedIri(Instance instance, String propertyIri) {
        FeatureProperty property = (FeatureProperty) OmlRead.getMemberByAbbreviatedIri(instance, propertyIri);
        return findPropertyValues(instance, property);
    }

    /**
     * Determines whether the given instance has a type with the given iri
     * 
     * @param instance the given instance
     * @param typeIri the given type iri
     * @return true if the given instance has a type with the given iri; false otherwise
     * @deprecated use {@link OmlSearch#findIsTypeOf(Instance, Classifier)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static boolean hasTypeIri(Instance instance, String typeIri) {
        Classifier classifier = (Classifier) OmlRead.getMemberByIri(instance, typeIri);
        return findIsTypeOf(instance, classifier);
    }
    
    /**
     * Determines whether the given instance has a type with the given abbreviated iri
     * 
     * @param instance the given instance
     * @param typeIri the given type abbreviated iri
     * @return true if the given instance has a type with the given abbreviated iri; false otherwise
     * @deprecated use {@link OmlSearch#findIsTypeOf(Instance, Classifier)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static boolean hasAbbreviatedTypeIri(Instance instance, String typeIri) {
        Classifier classifier = (Classifier) OmlRead.getMemberByAbbreviatedIri(instance, typeIri);
        return findIsTypeOf(instance, classifier);
    }

    /**
     * Finds named instances that has the given type
     *      * 
     * @param type the given type
     * @return a list of named instances that has the given type
     * @deprecated use {@link OmlSearch#findInstancesOfType(Classifier)} and filter on {@link NamedInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findNamedInstancesWithType(Entity type) {
        return findInstancesOfType(type).stream()
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds concept instances that have the given entity as type
     *      * 
     * @param type the given type
     * @return a list of concept instances that have the given entity as type
     * @deprecated use {@link OmlSearch#findInstancesOfType(Classifier)} and filter on {@link ConceptInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<ConceptInstance> findConceptInstancesWithType(Concept type) {
        return findInstancesOfType(type).stream()
            .filter(i -> i instanceof ConceptInstance)
            .map(i -> (ConceptInstance)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds relation instances that have the given relation entity as type
     *      * 
     * @param type the given relation type
     * @return a list of relation instances that have the given relation entity as type
     * @deprecated use {@link OmlSearch#findInstancesOfType(Classifier)} and filter on {@link RelationInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<RelationInstance> findRelationInstancesWithType(RelationEntity type) {
        return findInstancesOfType(type).stream()
            .filter(i -> i instanceof RelationInstance)
            .map(i -> (RelationInstance)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Finds named instances that have the given entity as supertype
     *      * 
     * @param entity the given entity
     * @return a list of named instances that have the given entity as supertype
     * @deprecated use {@link OmlSearch#findInstancesOfType(Classifier)} and filter on {@link NamedInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findNamedInstancesWithSupertype(Entity entity) {
        return findInstancesOfType(entity).stream()
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds named instances that have a type with the given iri
     *      * 
     * @param ontology an ontology that is the context of iri resolution
     * @return a list of named instances that have a type with the given iri
     * @deprecated use {@link OmlSearch#findInstancesOfType(Classifier)} and filter on {@link NamedInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findNamedInstancesWithTypeIri(Ontology ontology, String typeIri) {
        Member member = OmlRead.getMemberByIri(ontology, typeIri);
        assert (member instanceof Entity) : typeIri+" does not resolve to an Entity";
        return findInstancesOfType((Entity)member).stream()
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds named instances that have a type with the given abbreviated iri
     *      * 
     * @param ontology an ontology that is the context of abbreviated iri resolution
     * @param abbreviatedTypeIri the abbreviated type iri
     * @return a list of named instances that have a type with the given abbreviated iri
     * @deprecated use {@link OmlSearch#findInstancesOfType(Classifier)} and filter on {@link NamedInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findNamedInstancesWithAbbreviatedTypeIri(Ontology ontology, String abbreviatedTypeIri) {
        Member member = OmlRead.getMemberByAbbreviatedIri(ontology, abbreviatedTypeIri);
        assert (member instanceof Entity) : abbreviatedTypeIri+" does not resolve to an Entity";
        return findInstancesOfType((Entity)member).stream()
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds named instances that have a supertype with the given abbreviated iri
     *      * 
     * @param ontology an ontology that is the context of abbreviated iri resolution
     * @param suptypeIri the suptype abbreviated iri
     * @return a list of named instances that have a supertype with the given abbreviated iri
     * @deprecated use {@link OmlSearch#findInstancesOfKind(Classifier)} and filter on {@link NamedInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findNamedInstancesWithAbbreviatedSupertypeIri(Ontology ontology, String suptypeIri) {
        Member member = OmlRead.getMemberByAbbreviatedIri(ontology, suptypeIri);
        assert (member instanceof Entity) : suptypeIri+" does not resolve to an Entity";
        return findInstancesOfKind((Entity)member).stream()
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .collect(Collectors.toList());
    }

    /**
      * Finds named instances that have a supertype with the given iri
     *      * 
     * @param ontology an ontology that is the context of iri resolution
     * @param suptypeIri the supertype iri
     * @return a list of named instances that have a supertype with the given iri
    * @deprecated use {@link OmlSearch#findInstancesOfKind(Classifier)} and filter on {@link NamedInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findNamedInstancesWithSupertypeIri(Ontology ontology, String suptypeIri) {
        Member member = OmlRead.getMemberByIri(ontology, suptypeIri);
        assert (member instanceof Entity) : suptypeIri+" does not resolve to an Entity";
        return findInstancesOfKind((Entity)member).stream()
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .collect(Collectors.toList());
    }

    /**
     * Finds named instances that are related to the given element as sources of a relation with the given iri
     *      * 
     * @param instance the given named instance
     * @param relationIri the relation iri
     * @return a list of named instances that are related to the given element as sources of a relation with the given iri
     * @deprecated use {@link OmlSearch#findInstancesRelatedFrom(NamedInstance, Relation)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findRelatedSourcesByIri(NamedInstance instance, String relationIri) {
        Relation relation = (Relation) OmlRead.getMemberByIri(instance, relationIri);
        return findInstancesRelatedFrom(instance, relation);
    }
    
    /**
     * Finds named instances that are related to the given element as sources of a relation with the given abbreviated iri
     *      * 
     * @param instance the given named instance
     * @param relationIri the relation abbreviated iri
     * @return a list of named instances that are related to the given element as sources of a relation with the given abbreviated iri
     * @deprecated use {@link OmlSearch#findInstancesRelatedFrom(NamedInstance, Relation)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findRelatedSourcesByAbbreviatedIri(NamedInstance instance, String relationIri) {
        Relation relation = (Relation) OmlRead.getMemberByAbbreviatedIri(instance.eResource().getResourceSet(), relationIri);
        return findInstancesRelatedFrom(instance, relation);
    }

    /**
     * Finds named instances that are related to the given element as targets of a relation with the given iri
     *      * 
     * @param instance the given named instance
     * @param relationIri the relation iri
     * @return a list of named instances that are related to the given element as targets of a relation with the given iri
     * @deprecated use {@link OmlSearch#findInstancesRelatedTo(NamedInstance, Relation)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findRelatedTargetsByIri(NamedInstance instance, String relationIri) {
        Relation relation = (Relation) OmlRead.getMemberByAbbreviatedIri(instance, relationIri);
        return findInstancesRelatedTo(instance, relation);
    }

    /**
     * Finds named instances that are related to the given element as targets of a relation with the given abbreviated iri
     *      * 
     * @param instance the given named instance
     * @param relationIri the relation abbreviated iri
     * @return a list of named instances that are related to the given element as targets of a relation with the given abbreviated iri
     * @deprecated use {@link OmlSearch#findInstancesRelatedTo(NamedInstance, Relation)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> findRelatedTargetsByAbbreviatedIri(NamedInstance instance, String relationIri) {
        Relation relation = (Relation) OmlRead.getMemberByAbbreviatedIri(instance, relationIri);
        return findInstancesRelatedTo(instance, relation);
    }

    /**
     * Finds literals that are values of annotation properties with the given iri on the given element
     *      * 
     * @param element the given element
     * @param propertyIri the property iri
     * @return a list of literals that are values of annotation properties with the given iri on the given element
     * @deprecated use {@link OmlSearch#findAnnotationValues(AnnotatedElement, AnnotationProperty)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Literal> findAnnotationValuesForIri(AnnotatedElement element, String propertyIri) {
        var property = (AnnotationProperty) OmlRead.getMemberByIri(element, propertyIri); 
        return findAnnotationValues(element, property);
    }
    
    /**
     * Finds literals that are values of annotation properties with the given abbreviated iri on the given element
     *      * 
     * @param element the given element
     * @param propertyIri the property abbreviated iri
     * @return a list of literals that are values of annotation properties with the given abbreviated iri on the given element
     * @deprecated use {@link OmlSearch#findAnnotationValues(AnnotatedElement, AnnotationProperty)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Literal> findAnnotationValuesForAbbreviatedIri(AnnotatedElement element, String propertyIri) {
        var property = (AnnotationProperty) OmlRead.getMemberByAbbreviatedIri(element, propertyIri); 
        return findAnnotationValues(element, property);
    }

    /**
     * Finds terms that are general (super) terms of the given term
     *      * 
     * @param term the given term
     * @return a list of terms that are general (super) terms of the given term
     * @deprecated use {@link OmlSearch#findSuperTerms(SpecializableTerm)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<SpecializableTerm> findGeneralTerms(SpecializableTerm term) {
        return findSuperTerms(term);
    }

    /**
     * Finds terms that are specific (sub) terms of the given term
     *      * 
     * @param term the given term
     * @return a list of terms that are specific (sub) terms of the given term
     * @deprecated use {@link OmlSearch#findSubTerms(SpecializableTerm)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<SpecializableTerm> findSpecificTerms(SpecializableTerm term) {
        return findSubTerms(term);
    }

    //-------------------------------------------------
    // COMMON
    //-------------------------------------------------

    // Member
    
    /**
     * Finds references to the given member
     * 
     * @param member the given member
     * @return a list of references to the given member
     */
    public static List<Reference> findReferences(Member member) {
        List<Reference> references = new ArrayList<>();
        if (member instanceof AnnotationProperty) {
            references.addAll(findAnnotationPropertyReferencesWithProperty((AnnotationProperty)member));
        } else if (member instanceof Aspect) {
            references.addAll(findAspectReferencesWithAspect((Aspect)member));
        } else if (member instanceof Concept) {
            references.addAll(findConceptReferencesWithConcept((Concept)member));
        } else if (member instanceof RelationEntity) {
            references.addAll(findRelationEntityReferencesWithEntity((RelationEntity)member));
        } else if (member instanceof Structure) {
            references.addAll(findStructureReferencesWithStructure((Structure)member));
        } else if (member instanceof FacetedScalar) {
            references.addAll(findFacetedScalarReferencesWithScalar((FacetedScalar)member));
        } else if (member instanceof EnumeratedScalar) {
            references.addAll(findEnumeratedScalarReferencesWithScalar((EnumeratedScalar)member));
        } else if (member instanceof Relation) {
            references.addAll(findRelationReferencesWithRelation((Relation)member));
        } else if (member instanceof StructuredProperty) {
            references.addAll(findStructuredPropertyReferencesWithProperty((StructuredProperty)member));
        } else if (member instanceof ScalarProperty) {
            references.addAll(findScalarPropertyReferencesWithProperty((ScalarProperty)member));
        } else if (member instanceof Rule) {
            references.addAll(findRuleReferencesWithRule((Rule)member));
        } else if (member instanceof ConceptInstance) {
            references.addAll(findConceptInstanceReferencesWithInstance((ConceptInstance)member));
        } else if (member instanceof RelationInstance) {
            references.addAll(findRelationInstanceReferencesWithInstance((RelationInstance)member));
        }
        return references;
    }

    // AnnotatedElement

    /**
     * Finds annotations of the given element
     * 
     * @param element the given element
     * @return a list of annotations of the given element
     */
    public static List<Annotation> findAnnotations(AnnotatedElement element) {
        final List<Annotation> annotations = new ArrayList<>(element.getOwnedAnnotations());
        if (element instanceof Member) {
            annotations.addAll(findReferences((Member)element).stream()
                .flatMap(r -> r.getOwnedAnnotations().stream())
                .collect(Collectors.toList()));
        }
        return annotations;
    }

    /**
     * Finds literals that are values of a given annotation property on the given element
     * 
     * @param element the given element with annotations
     * @param property the annotation property
     * @return a list of literals that are values of a given annotation property on the given element
     */
    public static List<Literal> findAnnotationValues(AnnotatedElement element, AnnotationProperty property) {
        return findAnnotations(element).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .collect(Collectors.toList());
    }
    
    /**
     * Finds a literal that is a value of a given annotation property on the given element
     * 
     * @param element the given element with annotations
     * @param property the annotation property
     * @return a literal that is a value of a given annotation property on the given element
     */
    public static Literal findAnnotationValue(AnnotatedElement element, AnnotationProperty property) {
        return findAnnotations(element).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .findFirst().orElse(null);
    }

    //-------------------------------------------------
    // ONTOLOGIES
    //-------------------------------------------------

    /**
     * Finds imports that import the given ontology
     * @param ontology the given ontology
     * @return a list of imports that import the given ontology
     */
    public static List<Import> findReferencingImports(Ontology ontology) {
        final Resource resource = ontology.eResource();
        return (resource == null) ? Collections.emptyList() :
            OmlRead.getOntologies(resource.getResourceSet()).stream()
                .flatMap(o -> OmlRead.getImports(o).stream())
                .filter(i -> OmlRead.getImportedOntology(i) == ontology)
                .collect(Collectors.toList());
    }

    /**
     * Finds ontologies that import the given ontology
     * 
     * @param ontology the given ontologies
     * @return a list of ontologies that import the given ontology
     */
    public static List<Ontology> findImportingOntologies(Ontology ontology) {
        return findReferencingImports(ontology).stream()
            .map(i -> OmlRead.getImportingOntology(i))
            .collect(Collectors.toList());
    }

    //-------------------------------------------------
    // AXIOMS
    //-------------------------------------------------

    // Term

    /**
     * Finds axioms that are defined for the given term
     * 
     * @param term the given term
     * @return a list of axioms that are defined for the given term
     */
    public static List<Axiom> findAxioms(Term term) {
        List<Axiom> axioms = new ArrayList<>();
        if (term instanceof SpecializableTerm){
            axioms.addAll(findSpecializationsWithSubTerm(((SpecializableTerm)term)));
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

    /**
     * Finds specialization axioms that have the given term as a sub term
     * 
     * @param term the given term
     * @return a list of specialization axioms that have the given term as a sub term
     */
    public static List<SpecializationAxiom> findSpecializationsWithSubTerm(SpecializableTerm term) {
        final List<SpecializationAxiom> axioms = new ArrayList<>();
        axioms.addAll(term.getOwnedSpecializations());
        axioms.addAll(findReferences(term).stream()
            .filter(i -> i instanceof SpecializableTermReference)
            .map(i -> (SpecializableTermReference)i)
            .flatMap(r -> r.getOwnedSpecializations().stream())
            .collect(Collectors.toList()));
        return axioms;
    }

    /**
     * Finds specialization axioms that have the given term as a super term
     * 
     * @param term the given term
     * @return a list of specialization axioms that have the given term as a super term
     */
    public static List<SpecializationAxiom> findSpecializationsWithSuperTerm(SpecializableTerm term) {
        return findSpecializationAxiomsWithSpecializedTerm(term);
    }

    // Classifier
    
    /**
     * Find property restriction axioms that are defined on the given classifier
     * 
     * @param classifier the given classifier
     * @return a list of property restriction axioms that are defined on the given classifier
     */
    public static List<PropertyRestrictionAxiom> findPropertyRestrictions(Classifier classifier) {
        final List<PropertyRestrictionAxiom> restrictions = new ArrayList<>();
        restrictions.addAll(classifier.getOwnedPropertyRestrictions());
        restrictions.addAll(findReferences(classifier).stream()
            .filter(i -> i instanceof ClassifierReference)
            .map(i -> (ClassifierReference)i)
            .flatMap(r -> r.getOwnedPropertyRestrictions().stream())
            .collect(Collectors.toList()));
        return restrictions;
    }

    // Entity

    /**
     * Find relation restriction axioms that are defined on the given entity
     * 
     * @param entity the given entity
     * @return a list of relation restriction axioms that are defined on the given entity
     */
    public static List<RelationRestrictionAxiom> findRelationRestrictions(Entity entity) {
        final List<RelationRestrictionAxiom> restrictions = new ArrayList<>();
        restrictions.addAll(entity.getOwnedRelationRestrictions());
        restrictions.addAll(findReferences(entity).stream()
            .filter(i -> i instanceof EntityReference)
            .map(i -> (EntityReference)i)
            .flatMap(r -> r.getOwnedRelationRestrictions().stream())
            .collect(Collectors.toList()));
        return restrictions;
    }

    /**
     * Find key axioms that are defined on the given entity
     * 
     * @param entity the given entity
     * @return a list of key axioms that are defined on the given entity
     */
    public static List<KeyAxiom> findKeys(Entity entity) {
        final List<KeyAxiom> keys = new ArrayList<>();
        keys.addAll(entity.getOwnedKeys());
        keys.addAll(findReferences(entity).stream()
            .filter(i -> i instanceof EntityReference)
            .map(i -> (EntityReference)i)
            .flatMap(r -> r.getOwnedKeys().stream())
            .collect(Collectors.toList()));
        return keys;
    }

    //-------------------------------------------------
    // TERMS
    //-------------------------------------------------

    // SpecializableTerm

    /**
     * Finds terms that are the direct super (general) terms of the given term 
     * 
     * @param term the given term
     * @return a list of terms that are the direct super (general) terms of the given term
     */
    public static List<SpecializableTerm> findSuperTerms(SpecializableTerm term) {
        return findSpecializationsWithSubTerm(term).stream()
            .map(i -> OmlRead.getSuperTerm(i))
            .collect(Collectors.toList());
    }

    /**
     * Finds terms that are the direct or transitive super (general) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a list of terms that are the direct or transitive super (general) terms of the given term
     */
    public static List<SpecializableTerm> findAllSuperTerms(SpecializableTerm term, boolean inclusive) {
        return OmlRead.closure(term, inclusive, t -> findSuperTerms(t));
    }
    
    /**
     * Finds terms that are the direct sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @return a list of terms that are the direct sub (specific) terms of the given term
     */
    public static List<SpecializableTerm> findSubTerms(SpecializableTerm term) {
        return findSpecializationsWithSuperTerm(term).stream()
            .map(i -> OmlRead.getSubTerm(i))
            .collect(Collectors.toList());
    }

    /**
     * Finds terms that are the direct or transitive sub (specific) terms of the given term 
     * 
     * @param term the given term
     * @param inclusive a boolean determining whether to include the given term in the result
     * @return a list of terms that are the direct or transitive sub (specific) terms of the given term
     */
    public static List<SpecializableTerm> findAllSubTerms(SpecializableTerm term, boolean inclusive) {
        return OmlRead.closure(term, inclusive, t -> findSubTerms(t));
    }

    /**
     * Determines if the given term is a sub term of the given super term  
     * 
     * @param term the given term
     * @param superTerm the given super term
     * @return true if the given term is a sub term of the given super term; otherwise false
     */
    public static boolean findIsSubTermOf(SpecializableTerm term, SpecializableTerm superTerm) {
        return OmlRead.isInClosure(term, superTerm, true, t -> findSuperTerms(t));
    }

    // Entity

    /**
     * Finds relations that have the given entity as their source
     * 
     * @param entity the given entity
     * @return a list of relations that have the given entity as their source
     */
    public static List<Relation> findSourceRelations(Entity entity) {
        final List<Relation> relations = new ArrayList<>();
        relations.addAll(findRelationEntitiesWithSource(entity).stream()
            .map(r -> r.getForwardRelation())
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        relations.addAll(findRelationEntitiesWithTarget(entity).stream()
            .map(r -> r.getReverseRelation())
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        return relations;
    }

    /**
     * Finds relations that have the given entity as their target
     * 
     * @param entity the given entity
     * @return a list of relations that have the given entity as their target
     */
    public static List<Relation> findTargetRelations(Entity entity) {
        final List<Relation> relations = new ArrayList<>();
        relations.addAll(findRelationEntitiesWithTarget(entity).stream()
            .map(r -> r.getForwardRelation())
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        relations.addAll(findRelationEntitiesWithSource(entity).stream()
            .map(r -> r.getReverseRelation())
            .filter(r -> r != null)
            .collect(Collectors.toList()));
        return relations;
    }

    // ScalarProperty

    /**
     * Find entities that have the following property included in one of their keys
     * 
     * @param property the given property
     * @return a list of entities that have the following property included in one of their keys
     */
    public static List<Entity> findEntitiesKeyedWith(ScalarProperty property) {
        return findKeyAxiomWithProperty(property).stream()
            .map(i -> OmlRead.getKeyedEntity(i))
            .collect(Collectors.toList());
    }

    //-------------------------------------------------
    // ASSERTIONS
    //-------------------------------------------------

    // Instance
    
    /**
     * Finds assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @return a list of assertions that are defined on the given instance
     */
    public static List<Assertion> findAssertions(Instance instance) {
        List<Assertion> assertions = new ArrayList<>();
        assertions.addAll(findPropertyValueAssertions(instance));
        if (instance instanceof ConceptInstance) {
            assertions.addAll(findTypeAssertions((ConceptInstance)instance));
            assertions.addAll(findLinkAssertionsWithSource((ConceptInstance)instance));
        } else if (instance instanceof RelationInstance) {
            assertions.addAll(findTypeAssertions((RelationInstance)instance));
            assertions.addAll(findLinkAssertionsWithSource((RelationInstance)instance));
        }
        return assertions;
    }

    // NamedInstance

    /**
     * Finds type assertions that are defined on the given named instance
     * 
     * @param instance the given named instance
     * @return a list of type assertions that are defined on the given named instance
     */
    public static List<TypeAssertion> findTypeAssertions(NamedInstance instance) {
        List<TypeAssertion> assertions = new ArrayList<>();
        if (instance instanceof ConceptInstance) {
            assertions.addAll(findTypeAssertions((ConceptInstance) instance));
        } else if (instance instanceof RelationInstance) {
            assertions.addAll(findTypeAssertions((RelationInstance) instance));
        }
        return assertions;
    }
    
    /**
     * Finds concept type assertions that are defined on the given concept instance
     * 
     * @param instance the given concept instance
     * @return a list of concept type assertions that are defined on the given concept instance
     */
    public static List<ConceptTypeAssertion> findTypeAssertions(ConceptInstance instance) {
        final List<ConceptTypeAssertion> relations = new ArrayList<>(instance.getOwnedTypes());
        relations.addAll(findReferences(instance).stream()
            .filter(i -> i instanceof ConceptInstanceReference)
            .map(i -> (ConceptInstanceReference)i)
            .flatMap(r -> r.getOwnedTypes().stream())
            .collect(Collectors.toList()));
        return relations;
    }

    /**
     * Finds relation type assertions that are defined on the given relation instance
     * 
     * @param instance the given relation instance
     * @return a list of relation type assertions that are defined on the given relation instance
     */
    public static List<RelationTypeAssertion> findTypeAssertions(RelationInstance instance) {
        final List<RelationTypeAssertion> relations = new ArrayList<>(instance.getOwnedTypes());
        relations.addAll(findReferences(instance).stream()
            .filter(i -> i instanceof RelationInstanceReference)
            .map(i -> (RelationInstanceReference)i)
            .flatMap(r -> r.getOwnedTypes().stream())
            .collect(Collectors.toList()));
        return relations;
    }

    // Instance

    /**
     * Finds property value assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @return a list of property value assertions that are defined on the given instance
     */
    public static List<PropertyValueAssertion> findPropertyValueAssertions(Instance instance) {
        final List<PropertyValueAssertion> assertions = new ArrayList<>(instance.getOwnedPropertyValues());
        if (instance instanceof NamedInstance) {
            assertions.addAll(findReferences((NamedInstance)instance).stream()
                .filter(i -> i instanceof NamedInstanceReference)
                .map(i -> (NamedInstanceReference)i)
                .flatMap(r -> r.getOwnedPropertyValues().stream())
                .collect(Collectors.toList()));
        }
        return assertions;
    }

    /**
     * Finds elements that represent values of given feature property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given feature property
     * @return a list of elements that represent values of given feature property defined on the given instance
     */
    public static List<Element> findPropertyValues(Instance instance, FeatureProperty property) {
        return findPropertyValueAssertions(instance).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .collect(Collectors.toList());
    }
    
    /**
     * Finds an element that represents a value of given feature property defined on the given instance
     * 
     * @param instance the given instance
     * @param property the given feature property
     * @return an element that represents a value of given feature property defined on the given instance
     */
    public static Element findPropertyValue(Instance instance, FeatureProperty property) {
        return findPropertyValueAssertions(instance).stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .findFirst().orElse(null);
    }

    // NamedInstance

    /**
     * Finds link assertions that are defined on the given instance
     * 
     * @param instance the given instance
     * @return a list of link assertions that are defined on the given instance
     */
    public static List<LinkAssertion> findLinkAssertions(NamedInstance instance) {
        final List<LinkAssertion> assertions = new ArrayList<>(instance.getOwnedLinks());
        assertions.addAll(findReferences(instance).stream()
            .filter(i -> i instanceof NamedInstanceReference)
            .map(i -> (NamedInstanceReference)i)
            .flatMap(r -> r.getOwnedLinks().stream())
            .collect(Collectors.toList()));
        return assertions;
    }

    /**
     * Finds link assertions that have the given instance as their source
     * 
     * @param instance the given instance
     * @return a list of link assertions that have the given instance as their source
     */
    public static List<LinkAssertion> findLinkAssertionsWithSource(NamedInstance instance) {
        return findLinkAssertions(instance);
    }
    
    //-------------------------------------------------
    // INSTANCES
    //-------------------------------------------------

    // Instance
    
    /**
     * Finds classifiers that are types of the given instance
     * 
     * @param instance the given instance
     * @return a list of classifiers that are types of the given instance
     */
    public static List<Classifier> findTypes(Instance instance) {
        List<Classifier> types = new ArrayList<>();
        if (instance instanceof StructureInstance) {
            types.add(((StructureInstance) instance).getType());
        } else if (instance instanceof NamedInstance) {
            types.addAll(findTypeAssertions((NamedInstance)instance).stream().
                map(i -> i.getType()).
                collect(Collectors.toList()));
        }
        return types;
    }
    
    /**
     * Finds if the given instance is typed directly by the given type
     * 
     * @param instance the given instance
     * @param type the given type
     * @return true if the given instance is typed directly by the given type; otherwise false
     */
    public static boolean findIsTypeOf(Instance instance, Classifier type) {
        if (instance instanceof StructureInstance) {
            return ((StructureInstance)instance).getType() == type;
        } else if (instance instanceof NamedInstance) {
            return findTypeAssertions((NamedInstance)instance).stream()
                .filter(i -> i.getType() == type)
                .findFirst().isPresent();
        }
        return false;
    }

    /**
     * Finds if the given instance is typed directly or transitively by the given type
     * 
     * @param instance the given instance
     * @param type the given type
     * @return true if the given instance is typed directly or transitively by the given type; otherwise false
     */
    public static boolean findIsKindOf(Instance instance, Classifier type) {
        if (instance instanceof StructureInstance) {
            return findIsSubTermOf(((StructureInstance)instance).getType(), type);
        } else if (instance instanceof NamedInstance) {
            return findTypeAssertions((NamedInstance)instance).stream()
                .map(i -> i.getType())
                .filter(t -> findIsSubTermOf(t, type))
                .findFirst().isEmpty();
        }
        return false;
    }

    // Entity

    /**
     * Finds instances that have the given type as their direct type
     * 
     * @param type the given type
     * @return a list of instances that have the given type as their direct type
     */
    public static List<Instance> findInstancesOfType(Classifier type) {
        if (type instanceof Concept) {
            return findConceptTypeAssertionsWithType((Concept)type).stream()
                .map(i -> OmlRead.getSubject(i))
                .collect(Collectors.toList());
        } else if (type instanceof RelationEntity) {
            return findRelationTypeAssertionsWithType((RelationEntity)type).stream()
                .map(i -> OmlRead.getSubject(i))
                .collect(Collectors.toList());
        } else if (type instanceof Structure) {
            return new ArrayList<Instance>(findStructureInstancesWithType((Structure)type));
        }
        return Collections.emptyList();
    }

    /**
     * Finds instances that have the given type as their direct or transitive type
     * 
     * @param type the given type
     * @return a list of instances that have the given type as their direct or transitive type
     */
    public static List<Instance> findInstancesOfKind(Classifier type) {
        return findAllSubTerms(type, true).stream()
            .map(t -> (Classifier)t)
            .flatMap(t -> findInstancesOfType(t).stream())
            .collect(Collectors.toList());
    }

    
    // StructureInstance

    /**
     * Finds instances that are related to the given instance as sources of relations
     * 
     * @param instance the given instance
     * @return a list of instances that are related to the given instance as sources of relations
     */
    public static List<NamedInstance> findInstancesRelatedFrom(NamedInstance instance) {
        final List<NamedInstance> instances = new ArrayList<>();
        instances.addAll(findLinkAssertionsWithTarget(instance).stream()
                .map(a -> OmlRead.getSource(a))
                .collect(Collectors.toList()));
        instances.addAll(findRelationInstancesWithTarget(instance).stream()
                .flatMap(a -> a.getSources().stream())
                .collect(Collectors.toList()));
        return instances;
    }

    /**
     * Finds instances that are related to the given instance as sources of a given relation
     * 
     * @param instance the given instance
     * @param relation the given relation
     * @return a list of instances that are related to the given instance as sources of a given relation
     */
    public static List<NamedInstance> findInstancesRelatedFrom(NamedInstance instance, Relation relation) {
        final List<NamedInstance> instances = new ArrayList<>();
        instances.addAll(findLinkAssertionsWithTarget(instance).stream()
                .filter(a -> a.getRelation() == relation)
                .map(a -> OmlRead.getSource(a))
                .collect(Collectors.toList()));
        instances.addAll(findRelationInstancesWithTarget(instance).stream()
                .filter(i -> findTypes(i).stream().filter(t -> ((RelationEntity)t).getReverseRelation() == relation).findFirst().isPresent())
                .flatMap(i -> i.getSources().stream())
                .collect(Collectors.toList()));
        return instances;
    }

    /**
     * Finds instances that are related to the given instance as targets of relations
     * 
     * @param instance the given instance
     * @return a list of instances that are related to the given instance as targets of relations
     */
    public static List<NamedInstance> findInstancesRelatedTo(NamedInstance instance) {
        final List<NamedInstance> instances = new ArrayList<>();
        instances.addAll(findLinkAssertions(instance).stream()
                .map(a -> a.getTarget())
                .collect(Collectors.toList()));
        instances.addAll(findRelationInstancesWithSource(instance).stream()
                .flatMap(a -> a.getTargets().stream())
                .collect(Collectors.toList()));
        return instances;
    }

    /**
     * Finds instances that are related to the given instance as targets of a given relation
     * 
     * @param instance the given instance
     * @param relation the given relation
     * @return a list of instances that are related to the given instance as targets of a given relation
     */
    public static List<NamedInstance> findInstancesRelatedTo(NamedInstance instance, Relation relation) {
        final List<NamedInstance> instances = new ArrayList<>();
        instances.addAll(findLinkAssertions(instance).stream()
                .filter(a -> a.getRelation() == relation)
                .map(a -> a.getTarget())
                .collect(Collectors.toList()));
        instances.addAll(findRelationInstancesWithSource(instance).stream()
                .filter(i -> findTypes(i).stream().filter(t -> ((RelationEntity)t).getForwardRelation() == relation).findFirst().isPresent())
                .flatMap(a -> a.getTargets().stream())
                .collect(Collectors.toList()));
        return instances;
    }

    //-------------------------------------------------
    // LITERALS
    //-------------------------------------------------

    // Scalar

    /**
     * Finds the Java type that corresponds to the given scalar
     * 
     * @param scalar the given scalar
     * @return the Java type that corresponds to the given scalar
     */
    public static Class<?> findJavaType(Scalar scalar) {
        while (scalar != null) {
            switch (scalar.getIri()) {
                case OmlConstants.XSD_NS+"integer":
                    return Integer.class;
                case OmlConstants.XSD_NS+"decimal":
                    return BigDecimal.class;
                case OmlConstants.XSD_NS+"double":
                    return Double.class;
                case OmlConstants.XSD_NS+"float":
                    return Float.class;
                case OmlConstants.XSD_NS+"boolean":
                    return Boolean.class;
                case OmlConstants.XSD_NS+"dateTime":
                    return Date.class;
                case OmlConstants.OWL_NS+"real":
                    return Double.class;
            }
            scalar = (Scalar) findSuperTerms(scalar).stream().findFirst().get();
        }
        return String.class;
    }

    /**
     * Finds the Java value that corresponds to the given literal
     * 
     * @param literal the given literal
     * @return the Java value that corresponds to the given literal
     */
    public static Object findJavaValue(Literal literal) {
        if (literal instanceof QuotedLiteral) {
            QuotedLiteral qLiteral = (QuotedLiteral)literal;
            String value =  qLiteral.getValue();
            Class<?> type = findJavaType(qLiteral.getType());
            if (type == Integer.class)
                return Integer.valueOf(value);
            else if (type == BigDecimal.class)
                return new BigDecimal(value);
            else if (type == Double.class)
                return Double.valueOf(value);
            else if (type == Float.class)
                return Float.valueOf(value);
            else if (type == Boolean.class)
                return Boolean.valueOf(value);
            else if (type == Date.class)
                try {
                    return new SimpleDateFormat().parse(value);
                } catch (ParseException e) {
                    throw new DateTimeParseException("Error parsing xsd:dateTime", value, 0);
                }
            return value;
        }
        return OmlRead.getValue(literal);
    }

}
