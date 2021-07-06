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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
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
import io.opencaesar.oml.Feature;
import io.opencaesar.oml.FeaturePredicate;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.NamedInstanceReference;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Reference;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.RestrictionAxiom;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializableTermReference;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyReference;
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
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

/**
 * The <b>Read</b> API for the model. It complements the OML getter API by additional utilities.
 *  
 * @author elaasar
 */
public final class OmlRead {
    
    //-------------------------------------------------
    // DEPRECATED
    //-------------------------------------------------
    
    /**
     * Get the ontology that defines the given element
     * 
     * @param element the given element
     * @return the ontology that defines the given element
     * @deprecated use {@link Element#getOntology()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Ontology getOntology(Element element) {
        return element.getOntology();
    }
    
    /**
     * Get the IRI of the given element
     * 
     * @param element the given element
     * @return the IRI of the given element
     * @deprecated use {@link IdentifiedElement#getIri()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static String getIri(IdentifiedElement element) {
        return element.getIri();
    }
    
    /**
     * Get the abbreviated IRI of the given element
     * 
     * @param element the given element
     * @return the abbreviated IRI of the given element
     * @deprecated use {@link Ontology#getPrefix()} or  {@link Member#getAbbreviatedIri()}
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static String getAbbreviatedIri(IdentifiedElement element) {
        if (element instanceof Ontology) {
            return ((Ontology) element).getPrefix();
        } else if (element instanceof Member) {
            return ((Member) element).getAbbreviatedIri();
        }
        return null;
    }
    
    /**
     * Get the name of the given element in the context of the given ontology
     * 
     * @param element the given element
     * @param context The given ontology context
     * @return the name of the given element
     * @deprecated use {@link OmlRead#getPrefixIn(Ontology, Ontology)} or  {@link OmlRead#getAbbreviatedIriIn(Member, Ontology)}
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static String getNameIn(IdentifiedElement element, Ontology context) {
        if (element instanceof Ontology) {
            return getPrefixIn((Ontology) element, context);
        } else if (element instanceof Member) {
            return getAbbreviatedIriIn((Member) element, context);
        }
        return null;
    }
    
    /**
     * Get the namespace of the given ontology
     * 
     * @param ontology the given ontology
     * @return the namespace of the given ontology
     * @deprecated use {@link Ontology#getNamespace()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static String getNamespace(Ontology ontology) {
        return ontology.getNamespace();
    }
    
    /**
     * Get the vocabulary the owns the given vocabulary statement
     * 
     * @param statement the given vocabulary statement
     * @return the vocabulary that owns the given statement
     * @deprecated use {@link VocabularyStatement#getOwningVocabulary()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Vocabulary getVocabulary(VocabularyStatement statement) {
        return statement.getOwningVocabulary();
    }
    
    
    /**
     * Get the vocabulary the defines the given relation
     * 
     * @param relation the given relation
     * @return the vocabulary that defines the given relation
     * @deprecated use {@link Element#getOntology()} and cast to {@link Vocabulary} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Vocabulary getVocabulary(Relation relation) {
        return (Vocabulary) relation.getOntology();
    }
    
    /**
     * Get the description the owns the given description statement
     * 
     * @param statement the given description statement
     * @return the description that owns the given statement
     * @deprecated use {@link DescriptionStatement#getOwningDescription()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Description getDescription(DescriptionStatement statement) {
        return statement.getOwningDescription();
    }
    
    /**
     * Get the closure of the given recursive function starting from and including a given root
     * 
     * @param root the given root object to start from
     * @param recursive the function to recurse with
     * @return the recursive closure of applying the given function on the given root including the root
     * @deprecated use {@link OmlRead#closure(Object, boolean, Function)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static <T, V extends T> List<T> reflexiveClosure(V root, Function<T, List<T>> recursive) {
        return closure(root, true, recursive);
    }
    
    /**
     * Get the closure of the given recursive function starting from a given root
     * 
     * @param root the given root object to start from
     * @param recursive the function to recurse with
     * @return the recursive closure of applying the given function on the given root
     * @deprecated use {@link OmlRead#closure(Object, boolean, Function)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static <T, V extends T> List<T> closure(V root, Function<T, List<T>> recursive) {
        return closure(root, false, recursive);
    }
    
    /**
     * Get the value of the given literal
     * 
     * @param literal the given literal
     * @return the value of the given literal
     * @deprecated use {@link OmlRead#getValue(Literal)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Object getLiteralValue(Literal literal) {
        return getValue(literal);
    }
    
    /**
     * Get the lexical value of the given annotation property in the given element
     * 
     * @param element The element that has the annotation
     * @param propertyIri the iri of the annotation property
     * @return a string representing the lexical representation of first annotation value
     * @deprecated chain {@link OmlRead#getAnnotationValue(AnnotatedElement, AnnotationProperty)} with {@link OmlRead#getLexicalValue(Literal)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static String getAnnotationLexicalValue(AnnotatedElement element, String propertyIri) {
        var property = (AnnotationProperty) getMemberByIri(element, propertyIri);
        Literal value = getAnnotationValue(element, property);
        return (value != null)? getLexicalValue(value) : null;
    }
    
    /**
     * Get the lexical value of the given annotation property in the given reference
     * 
     * @param reference The reference that has the annotation
     * @param propertyIri the iri of the annotation property
     * @return a string representing the lexical representation of first annotation value
     * @deprecated use {@link Reference#getOwnedAnnotations()} and filter one with the propertyIri then call {@link OmlRead#getLexicalValue(Literal)} on its value instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static String getAnnotationLexicalValue(Reference reference, String propertyIri) {
        Literal literal = reference.getOwnedAnnotations().stream()
            .filter(a -> a.getProperty().getIri().equals(propertyIri))
            .map(a -> a.getValue())
            .findFirst().orElse(null);
        return (literal != null) ? getLexicalValue(literal) : null;
    }
    
    /**
     * Gets the direct imports of the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of direct imports of the ontology
     * @deprecated use {@link OmlRead#getImports(Ontology)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Import> getImportsWithSource(Ontology ontology) {
        return getImports(ontology);
    }
    
    /**
     * Gets the direct and transitive imports of the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of direct imports of the ontology
     * @deprecated use {@link OmlRead#getAllImports(Ontology)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Import> getAllImportsWithSource(Ontology ontology) {
        return getAllImports(ontology);
    }
    
    /**
     * Gets the ontologies directly or transitively imported by the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of ontologies directly imported by the given ontology
     * @deprecated use {@link OmlRead#getAllImportedOntologies(Ontology, boolean)} and setting inclusive to false instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Ontology> getAllImportedOntologies(Ontology ontology) {
        return getAllImportedOntologies(ontology, false);
    }
    
    /**
     * Gets the ontologies directly or transitively imported by the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of ontologies transitively imported by the given ontology
     * @deprecated use {@link OmlRead#getAllImportedOntologies(Ontology, boolean)} and setting inclusive to true instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Ontology> getAllImportedOntologiesInclusive(Ontology ontology) {
        return getAllImportedOntologies(ontology, true);
    }
    
    /**
     * Gets all vocabulary extensions directly defined by the given vocabulary
     * 
     * @param vocabulary the given vocabulary
     * @return a list of vocabulary extensions directly defined by the given vocabulary
     * @deprecated use {@link OmlRead#getImports(Ontology)} and filter on {@link VocabularyExtension} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyExtension> getExtensionsWithSource(Vocabulary vocabulary) {
        return getImports(vocabulary).stream()
            .filter(i -> i instanceof VocabularyExtension)
            .map(i -> (VocabularyExtension)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all vocabulary usages directly defined by the given vocabulary
     * 
     * @param vocabulary the given vocabulary
     * @return a list of vocabulary usages directly defined by the given vocabulary
     * @deprecated use {@link OmlRead#getImports(Ontology)} and filter on {@link VocabularyUsage} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyUsage> getUsagesWithSource(Vocabulary vocabulary) {
        return getImports(vocabulary).stream()
            .filter(i -> i instanceof VocabularyUsage)
            .map(i -> (VocabularyUsage)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all vocabularies extended directly by the given vocabulary
     * 
     * @param vocabulary the given vocabulary
     * @return a list of vocabularies extended directly by the given vocabulary
     * @deprecated use {@link OmlRead#getImportedOntologies(Ontology)} and filter on {@link Vocabulary} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Vocabulary> getExtendedVocabularies(Vocabulary vocabulary) {
        return getImportedOntologies(vocabulary).stream()
            .filter(i -> i instanceof Vocabulary)
            .map(i -> (Vocabulary)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all description boxes used directly by the given vocabulary
     * 
     * @param vocabulary the given vocabulary
     * @return a list of description boxes used directly by the given vocabulary
     * @deprecated use {@link OmlRead#getImportedOntologies(Ontology)} and filter on {@link DescriptionBox} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBox> getUsedDescriptionBoxes(Vocabulary vocabulary) {
        return getImportedOntologies(vocabulary).stream()
            .filter(i -> i instanceof DescriptionBox)
            .map(i -> (DescriptionBox)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all vocabulary bundle extensions directly defined by the given vocabulary bundle
     * 
     * @param bundle the given vocabulary bundle
     * @return a list of vocabulary bundle extensions directly defined by the given vocabulary bundle
     * @deprecated use {@link OmlRead#getImports(Ontology)} and filter on {@link VocabularyBundleExtension} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyBundleExtension> getExtensionsWithSource(VocabularyBundle bundle) {
        return getImports(bundle).stream()
            .filter(i -> i instanceof VocabularyBundleExtension)
            .map(i -> (VocabularyBundleExtension)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all vocabulary bundle inclusions directly defined by the given vocabulary bundle
     * 
     * @param bundle the given vocabulary bundle
     * @return a list of vocabulary bundle inclusions directly defined by the given vocabulary bundle
     * @deprecated use {@link OmlRead#getImports(Ontology)} and filter on {@link VocabularyBundleInclusion} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyBundleInclusion> getInclusionsWithSource(VocabularyBundle bundle) {
        return getImports(bundle).stream()
            .filter(i -> i instanceof VocabularyBundleInclusion)
            .map(i -> (VocabularyBundleInclusion)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all vocabulary bundles extended directly by the given vocabulary bundle
     * 
     * @param bundle the given vocabulary bundle
     * @return a list of vocabulary bundles extended directly by the given vocabulary bundle
     * @deprecated use {@link OmlRead#getImportedOntologies(Ontology)} and filter on {@link VocabularyBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyBundle> getExtendedVocabularyBundles(VocabularyBundle bundle) {
        return getImportedOntologies(bundle).stream()
            .filter(i -> i instanceof VocabularyBundle)
            .map(i -> (VocabularyBundle)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all vocabularies included directly by the given vocabulary bundle
     * 
     * @param bundle the given vocabulary bundle
     * @return a list of vocabularies included directly by the given vocabulary bundle
     * @deprecated use {@link OmlRead#getImportedOntologies(Ontology)} and filter on {@link Vocabulary} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Vocabulary> getIncludedVocabularies(VocabularyBundle bundle) {
        return getImportedOntologies(bundle).stream()
            .filter(i -> i instanceof Vocabulary)
            .map(i -> (Vocabulary)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all description usages directly defined by the given description
     * 
     * @param description the given description
     * @return a list of description usages directly defined by the given description
     * @deprecated use {@link OmlRead#getImports(Ontology)} and filter on {@link DescriptionUsage} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionUsage> getUsagesWithSource(Description description) {
        return getImports(description).stream()
            .filter(i -> i instanceof DescriptionUsage)
            .map(i -> (DescriptionUsage)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all description extensions directly defined by the given description
     * 
     * @param description the given description
     * @return a list of description extensions directly defined by the given description
     * @deprecated use {@link OmlRead#getImports(Ontology)} and filter on {@link DescriptionExtension} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionExtension> getExtensionsWithSource(Description description) {
        return getImports(description).stream()
            .filter(i -> i instanceof DescriptionExtension)
            .map(i -> (DescriptionExtension)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all descriptions extended directly by the given description
     * 
     * @param description the given description
     * @return a list of descriptions extended directly by the given description
     * @deprecated use {@link OmlRead#getImportedOntologies(Ontology)} and filter on {@link Description} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Description> getExtendedDescriptions(Description description) {
        return getImportedOntologies(description).stream()
            .filter(i -> i instanceof Description)
            .map(i -> (Description)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all vocabulary boxes used directly by the given description
     * 
     * @param description the given description
     * @return a list of vocabulary boxes used directly by the given description
     * @deprecated use {@link OmlRead#getImportedOntologies(Ontology)} and filter on {@link VocabularyBox} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyBox> getUsedVocabularyBoxes(Description description) {
        return getImportedOntologies(description).stream()
            .filter(i -> i instanceof VocabularyBox)
            .map(i -> (VocabularyBox)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all description bundle extensions directly defined by the given description bundle
     * 
     * @param bundle the given description bundle
     * @return a list of description extensions directly defined by the given description bundle
     * @deprecated use {@link OmlRead#getImports(Ontology)} and filter on {@link DescriptionBundleExtension} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundleExtension> getExtensionsWithSource(DescriptionBundle bundle) {
        return getImports(bundle).stream()
            .filter(i -> i instanceof DescriptionBundleExtension)
            .map(i -> (DescriptionBundleExtension)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all description bundle inclusions directly defined by the given description bundle
     * 
     * @param bundle the given description bundle
     * @return a list of description inclusions directly defined by the given description bundle
     * @deprecated use {@link OmlRead#getImports(Ontology)} and filter on {@link DescriptionBundleInclusion} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundleInclusion> getInclusionsWithSource(DescriptionBundle bundle) {
        return getImports(bundle).stream()
            .filter(i -> i instanceof DescriptionBundleInclusion)
            .map(i -> (DescriptionBundleInclusion)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all description bundle usages directly defined by the given description bundle
     * 
     * @param bundle the given description bundle
     * @return a list of description usages directly defined by the given description bundle
     * @deprecated use {@link OmlRead#getImports(Ontology)} and filter on {@link DescriptionBundleUsage} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundleUsage> getUsagesWithSource(DescriptionBundle bundle) {
        return getImports(bundle).stream()
            .filter(i -> i instanceof DescriptionBundleUsage)
            .map(i -> (DescriptionBundleUsage)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all description bundles extended directly by the given description bundle
     * 
     * @param bundle the given description bundle
     * @return a list of description bundles extended directly by the given description bundle
     * @deprecated use {@link OmlRead#getImportedOntologies(Ontology)} and filter on {@link DescriptionBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<DescriptionBundle> getExtendedDescriptionBundles(DescriptionBundle bundle) {
        return getImportedOntologies(bundle).stream()
            .filter(i -> i instanceof DescriptionBundle)
            .map(i -> (DescriptionBundle)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all descriptions included directly by the given description bundle
     * 
     * @param bundle the given description bundle
     * @return a list of descriptions included directly by the given description bundle
     * @deprecated use {@link OmlRead#getImportedOntologies(Ontology)} and filter on {@link Description} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Description> getIncludedDescriptions(DescriptionBundle bundle) {
        return getImportedOntologies(bundle).stream()
            .filter(i -> i instanceof Description)
            .map(i -> (Description)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all vocabulary bundles used directly by the given description bundle
     * 
     * @param bundle the given description bundle
     * @return a list of vocabulary bundles used directly by the given description bundle
     * @deprecated use {@link OmlRead#getImportedOntologies(Ontology)} and filter on {@link VocabularyBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<VocabularyBundle> getUsedVocabularyBundles(DescriptionBundle bundle) {
        return getImportedOntologies(bundle).stream()
            .filter(i -> i instanceof VocabularyBundle)
            .map(i -> (VocabularyBundle)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets the named instances defined directly by the given description
     * 
     * @param description the given description
     * @return a list of named instances defined directly by the given description
     * @deprecated use {@link OmlRead#getStatements(Ontology)} and filter on {@link NamedInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> getNamedInstances(Description description) {
        return getStatements(description).stream()
            .filter(s -> s instanceof NamedInstance)
            .map(s -> (NamedInstance)s)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets the named instances defined directly or transitively by the given description box
     * 
     * @param box the given description box
     * @return a list of named instances defined transitively by the given description box
     * @deprecated use {@link OmlRead#getAllImportedOntologies(Ontology)}, filter on {@link Description}, 
     * map {@link OmlRead#getMembers(Ontology)}, and filter on {@link NamedInstance} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<NamedInstance> getAllNamedInstances(DescriptionBox box) {
        return getAllImportedOntologies(box, true).stream()
            .filter(i -> i instanceof Description)
            .map(i -> (Description)i)
            .flatMap(i -> getMembers(i).stream())
            .filter(i -> i instanceof NamedInstance)
            .map(i -> (NamedInstance)i)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets the effective prefix implied by the given import
     * 
     * This might be the import's prefix override if specified, 
     * otherwise it is the imported ontology's prefix
     * 
     * @param _import the given import
     * @return the prefix override specified by the given import
     * @deprecated use {@link OmlRead#getEffectivePrefix(Import)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static String getImportPrefix(Import _import) {
        return getEffectivePrefix(_import);
    }
    
    /**
     * Gets the ontology namespace that is imported by the given import
     * 
     * @param _import the given import
     * @return the namespace of the imported ontology
     * @deprecated use {@link OmlRead#getImportedNamespace(Import)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static String getImportNamespace(Import _import) {
        return getImportedNamespace(_import);
    }
    
    /**
     * Gets the URI that results from resolving the given import's uri
     * 
     * @param _import the given import
     * @return the resolved URI of the given import
     * @deprecated use {@link OmlRead#getResolvedUri(Import)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static URI getResolvedImportUri(Import _import) {
        return getResolvedUri(_import);
    }
    
    /**
     * Gets the vocabulary that defines the given vocabulary import
     * 
     * @param _import the given vocabulary import
     * @return the vocabulary that defines the given import
     * @deprecated use {@link VocabularyImport#getOwningVocabulary()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Vocabulary getImportingVocabulary(VocabularyImport _import) {
        return _import.getOwningVocabulary();
    }
    
    /**
     * Gets the vocabulary that defines the given vocabulary extension
     * 
     * @param extension the given vocabulary extension
     * @return the vocabulary that defines the given extension
     * @deprecated use {@link VocabularyImport#getOwningVocabulary()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Vocabulary getExtendingVocabulary(VocabularyExtension extension) {
        return extension.getOwningVocabulary();
    }
    
    /**
     * Gets the vocabulary that is imported by the given vocabulary extension
     * 
     * @param extension the given vocabulary extension
     * @return the vocabulary that is imported by the given vocabulary extension
     * @deprecated use {@link OmlRead#getImportedOntology(Import)} and cast to {@link Vocabulary} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Vocabulary getExtendedVocabulary(VocabularyExtension extension) {
        return (Vocabulary) getImportedOntology(extension);
    }
    
    /**
     * Gets the vocabulary that defines the given vocabulary usage
     * 
     * @param usage the given vocabulary usage
     * @return the vocabulary that defines the given usage
     * @deprecated use {@link VocabularyImport#getOwningVocabulary()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Vocabulary getUsingVocabulary(VocabularyUsage usage) {
        return usage.getOwningVocabulary();
    }
    
    /**
     * Gets the description box that is imported by the given vocabulary usage
     * 
     * @param usage the given vocabulary usage
     * @return the description box that is imported by the given vocabulary usage
     * @deprecated use {@link OmlRead#getImportedOntology(Import)} and cast to {@link DescriptionBox} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static DescriptionBox getUsedDescriptionBox(VocabularyUsage usage) {
        return (DescriptionBox) getImportedOntology(usage);
    }
    
    /**
     * Gets the vocabulary bundle that defines the given vocabulary bundle import
     * 
     * @param _import the given vocabulary bundle import
     * @return the vocabulary bundle that defines the given import
     * @deprecated use {@link VocabularyBundleImport#getOwningVocabularyBundle()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static VocabularyBundle getImportingVocabularyBundle(VocabularyBundleImport _import) {
        return _import.getOwningVocabularyBundle();
    }
    
    /**
     * Gets the vocabulary bundle that defines the given vocabulary bundle extension
     * 
     * @param extension the given vocabulary bundle extension
     * @return the vocabulary bundle that defines the given extension
     * @deprecated use {@link VocabularyBundleImport#getOwningVocabularyBundle()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static VocabularyBundle getExtendingVocabularyBundle(VocabularyBundleExtension extension) {
        return extension.getOwningVocabularyBundle();
    }
    
    /**
     * Gets the vocabulary bundle that is imported by the given vocabulary bundle extension
     * 
     * @param extension the given vocabulary bundle extension
     * @return the vocabulary bundle that is imported by the given vocabulary bundle extension
     * @deprecated use {@link OmlRead#getImportedOntology(Import)} and cast to {@link VocabularyBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static VocabularyBundle getExtendedVocabularyBundle(VocabularyBundleExtension extension) {
        return (VocabularyBundle) getImportedOntology(extension);
    }
    
    /**
     * Gets the vocabulary bundle that defines the given vocabulary bundle inclusion
     * 
     * @param inclusion the given vocabulary bundle inclusion
     * @return the vocabulary bundle that defines the given inclusion
     * @deprecated use {@link VocabularyBundleImport#getOwningVocabularyBundle()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static VocabularyBundle getIncludingVocabularyBundle(VocabularyBundleInclusion inclusion) {
        return inclusion.getOwningVocabularyBundle();
    }
    
    /**
     * Gets the vocabulary that is imported by the given vocabulary bundle inclusion
     * 
     * @param inclusion the given vocabulary bundle inclusion
     * @return the vocabulary that is imported by the given vocabulary bundle inclusion
     * @deprecated use {@link OmlRead#getImportedOntology(Import)} and cast to {@link Vocabulary} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Vocabulary getIncludedVocabulary(VocabularyBundleInclusion inclusion) {
        return (Vocabulary) getImportedOntology(inclusion);
    }
    
    /**
     * Gets the description that defines the given description import
     * 
     * @param _import the given description import
     * @return the description that defines the given import
     * @deprecated use {@link DescriptionImport#getOwningDescription()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Description getImportingDescription(DescriptionImport _import) {
        return _import.getOwningDescription();
    }
    
    /**
     * Gets the description that defines the given description extension
     * 
     * @param extension the given description extension
     * @return the description that defines the given description extension
     * @deprecated use {@link DescriptionImport#getOwningDescription()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Description getExtendingDescription(DescriptionExtension extension) {
        return extension.getOwningDescription();
    }
    
    /**
     * Gets the description that is imported by the given description extension
     * 
     * @param extension the given description extension
     * @return the description that is imported by the given description extension
     * @deprecated use {@link OmlRead#getImportedOntology(Import)} and cast to {@link Description} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Description getExtendedDescription(DescriptionExtension extension) {
        return (Description) getImportedOntology(extension);
    }
    
    /**
     * Gets the description that defines the given description usage
     * 
     * @param usage the given description usage
     * @return the description that defines the given description usage
     * @deprecated use {@link DescriptionImport#getOwningDescription()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Description getUsingDescription(DescriptionUsage usage) {
        return usage.getOwningDescription();
    }
    
    /**
     * Gets the vocabulary box that is imported by the given description usage
     * 
     * @param usage the given description usage
     * @return the vocabulary box that is imported by the given description usage
     * @deprecated use {@link OmlRead#getImportedOntology(Import)} and cast to {@link VocabularyBox} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static VocabularyBox getUsedVocabularyBox(DescriptionUsage usage) {
        return (VocabularyBox) getImportedOntology(usage);
    }
    
    /**
     * Gets the description bundle that defines the given description bundle import
     * 
     * @param _import the given description bundle import
     * @return the description bundle that defines the given import
     * @deprecated use {@link DescriptionBundleImport#getOwningDescriptionBundle()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static DescriptionBundle getImportingDescriptionBundle(DescriptionBundleImport _import) {
        return _import.getOwningDescriptionBundle();
    }
    
    /**
     * Gets the description bundle that defines the given description bundle extension
     * 
     * @param extension the given description bundle extension
     * @return the description bundle that defines the given description bundle extension
     * @deprecated use {@link DescriptionBundleImport#getOwningDescriptionBundle()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static DescriptionBundle getExtendingDescriptionBundle(DescriptionBundleExtension extension) {
        return extension.getOwningDescriptionBundle();
    }
    
    /**
     * Gets the description bundle that is imported by the given description bundle extension
     * 
     * @param extension the given description bundle extension
     * @return the description bundle that is imported by the given description bundle extension
     * @deprecated use {@link OmlRead#getImportedOntology(Import)} and cast to {@link DescriptionBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static DescriptionBundle getExtendedDescriptionBundle(DescriptionBundleExtension extension) {
        return (DescriptionBundle) getImportedOntology(extension);
    }
    
    /**
     * Gets the description bundle that defines the given description bundle inclusion
     * 
     * @param inclusion the given description bundle inclusion
     * @return the description bundle that defines the given description bundle inclusion
     * @deprecated use {@link DescriptionBundleImport#getOwningDescriptionBundle()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static DescriptionBundle getIncludingDescriptionBundle(DescriptionBundleInclusion inclusion) {
        return inclusion.getOwningDescriptionBundle();
    }
    
    /**
     * Gets the description that is imported by the given description bundle inclusion
     * 
     * @param inclusion the given description bundle inclusion
     * @return the description that is imported by the given description bundle inclusion
     * @deprecated use {@link OmlRead#getImportedOntology(Import)} and cast to {@link Description} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Description getIncludedDescription(DescriptionBundleInclusion inclusion) {
        return (Description) getImportedOntology(inclusion);
    }
    
    /**
     * Gets the description bundle that defines the given description bundle usage
     * 
     * @param usage the given description bundle usage
     * @return the description bundle that defines the given description bundle usage
     * @deprecated use {@link DescriptionBundleImport#getOwningDescriptionBundle()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static DescriptionBundle getUsingDescriptionBundle(DescriptionBundleUsage usage) {
        return usage.getOwningDescriptionBundle();
    }
    
    /**
     * Gets the vocabulary bundle that is imported by the given description bundle usage
     * 
     * @param usage the given description bundle usage
     * @return the vocabulary bundle that is imported by the given description bundle usage
     * @deprecated use {@link OmlRead#getImportedOntology(Import)} and cast to {@link VocabularyBundle} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static VocabularyBundle getUsedVocabularyBundle(DescriptionBundleUsage usage) {
        return (VocabularyBundle) getImportedOntology(usage);
    }
    
    /**
     * Gets the abbreviated IRI of the given reference
     * 
     * @param reference the given reference
     * @return the abbreviated IRI of the given reference
     * @deprecated use {@link OmlRead#getAbbreviatedIri(Reference)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static String getResolvedName(Reference reference) {
        return getAbbreviatedIri(reference);
    }
    
    /**
     * Gets the general scalar of a given scalar
     * 
     * @param scalar the given scalar
     * @return the general scalar of the given scalar
     * @deprecated use {@link OmlRead#getGeneralTerms(SpecializableTerm)} and cast the first element if any to @link Scalar} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Scalar getGeneralScalar(Scalar scalar) {
        return scalar.getOwnedSpecializations().stream().
            map(a -> a.getSpecializedTerm()).
            filter(i -> i instanceof Scalar).
            map(i -> (Scalar)i).
            findFirst().orElse(null);
    }
    
    /**
     * Gets the range of the given semantic property
     * 
     * @param property the given semantic property
     * @return the range of the given property
     * @deprecated use {@link SemanticProperty#getRange()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Type getRange(final SemanticProperty property) {
        return property.getRange();
    }
    
    /**
     * Gets the relation entity that defines the given relation
     * 
     * @param relation the given relation
     * @return the relation entity that defines the given relation
     * @deprecated use {@link Relation#getRelationEntity()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static RelationEntity getRelationEntity(final Relation relation) {
        return relation.getRelationEntity();
    }
    
    /**
     * Gets the restricted property of the given property restriction axiom
     * 
     * @param axiom the given property restriction axiom
     * @return the restricted property of the given property restriction axiom
     * @deprecated use {@link OmlRead#getRestrictedFeature(RestrictionAxiom)} and cast to {@link SemanticProperty} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static SemanticProperty getRestrictedProperty(PropertyRestrictionAxiom axiom) {
        return (SemanticProperty) getRestrictedFeature(axiom);
    }
    
    /**
     * Gets the restricted scalar property of the given scalar property restriction axiom
     * 
     * @param axiom the given scalar property restriction axiom
     * @return the restricted scalar property of the given scalar property restriction axiom
     * @deprecated use {@link OmlRead#getRestrictedFeature(RestrictionAxiom)} and cast to {@link ScalarProperty} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static ScalarProperty getRestrictedScalarProperty(ScalarPropertyRestrictionAxiom axiom) {
        return (ScalarProperty) getRestrictedFeature(axiom);
    }
        
    /**
     * Gets the restricted structured property of the given structured property restriction axiom
     * 
     * @param axiom the given structured property restriction axiom
     * @return the restricted structured property of the given structured property restriction axiom
     * @deprecated use {@link OmlRead#getRestrictedFeature(RestrictionAxiom)} and cast to {@link StructuredProperty} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static StructuredProperty getRestrictedStructuredProperty(StructuredPropertyRestrictionAxiom axiom) {
        return (StructuredProperty) getRestrictedFeature(axiom);
    }
    
    /**
     * Gets the restricted relation of the given relation restriction axiom
     * 
     * @param axiom the given relation restriction axiom
     * @return the restricted relation of the given relation restriction axiom
     * @deprecated use {@link OmlRead#getRestrictedFeature(RestrictionAxiom)} and cast to {@link Relation} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Relation getRestrictedRelation(RelationRestrictionAxiom axiom) {
        return (Relation) getRestrictedFeature(axiom);
    }
    
    /**
     * Gets the type referenced by the given type assertion
     * 
     * @param assertion the given type assertion
     * @return the type referenced by the given type assertion
     * @deprecated use {@link TypeAssertion#getType()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Entity getType(TypeAssertion assertion) {
        return assertion.getType();
    }
    
    /**
     * Gets the property referenced by the given property value assertion
     * 
     * @param assertion the given property value assertion
     * @return the property referenced by the given property value assertion
     * @deprecated use {@link PropertyValueAssertion#getProperty()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Property getProperty(PropertyValueAssertion assertion) {
        return assertion.getProperty();
    }
        
    /**
     * Gets the value referenced by the given property value assertion
     * 
     * @param assertion the given property value assertion
     * @return the value referenced by the given property value assertion
     * @deprecated use {@link PropertyValueAssertion#getValue()} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Element getValue(PropertyValueAssertion assertion) {
        return assertion.getValue();
    }
    
    /**
     * Gets the concept instance that specifies the given concept type assertion
     * 
     * @param assertion the given concept type assertion
     * @return the concept instance that specifies the concept type assertion
     * @deprecated use {@link OmlRead#getSubject(ConceptTypeAssertion)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static ConceptInstance getConceptInstance(ConceptTypeAssertion assertion) {
        return getSubject(assertion);
    }
    
    /**
     * Gets the relation instance that specifies the given relation type assertion
     * 
     * @param assertion the given relation type assertion
     * @return the relation instance that specifies the relation type assertion
     * @deprecated use {@link OmlRead#getSubject(RelationTypeAssertion)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static RelationInstance getRelationInstance(RelationTypeAssertion assertion) {
        return getSubject(assertion);
    }
    
    /**
     * Gets the named instance that specifies the given link assertion
     * 
     * @param assertion the given link assertion
     * @return the named instance that specifies the link assertion
     * @deprecated use {@link OmlRead#getSubject(LinkAssertion)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static NamedInstance getNamedInstance(LinkAssertion assertion) {
        return getSubject(assertion);
    }
    
    /**
     * Gets the instance that specifies the given property value assertion
     * 
     * @param assertion the given property value assertion
     * @return the instance that specifies the property value assertion
     * @deprecated use {@link OmlRead#getSubject(PropertyValueAssertion)} instead
     */
    @Deprecated(since = "0.9.0", forRemoval = true)
    public static Instance getInstance(PropertyValueAssertion assertion) {
        return getSubject(assertion);
    }
    
   /**
    * Gets all the values of  annotations with the given property iri on the given element 
    * 
    * @param element the given element
    * @param propertyIri the given property iri
    * @return a list of literals that are the values of the given annotation property
    * @deprecated use {@link OmlRead#getAnnotationValues(AnnotatedElement, AnnotationProperty)} instead
    */
   @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Literal> getAnnotationValues(AnnotatedElement element, String propertyIri) {
       var property = (AnnotationProperty) getMemberByIri(element, propertyIri);
       return getAnnotationValues(element, property);
    }
    
   /**
    * Gets a value of an annotation with the given property iri on the given element 
    * 
    * @param element the given element
    * @param propertyIri the given property iri
    * @return a literal that is the value of the given annotation property
    * @deprecated use {@link OmlRead#getAnnotationValue(AnnotatedElement, AnnotationProperty)} instead
    */
   @Deprecated(since = "0.9.0", forRemoval = true)
    public static Literal getAnnotationValue(AnnotatedElement element, String propertyIri) {
       var property = (AnnotationProperty) getMemberByIri(element, propertyIri);
       return getAnnotationValue(element, property);
    }

   /**
    * Gets all the values of  annotations with the given property iri on the given element 
    * 
    * @param reference the given reference
    * @param propertyIri the given property iri
    * @return a list of literals that are the values of the given annotation property
    * @deprecated use {@link Reference#getOwnedAnnotations()} and filter the ones that have the annotation property instead
    */
   @Deprecated(since = "0.9.0", forRemoval = true)
    public static List<Literal> getAnnotationValues(Reference reference, String propertyIri) {
       var property = (AnnotationProperty) getMemberByIri(reference, propertyIri);
       return reference.getOwnedAnnotations().stream()
               .filter(a -> a.getProperty() == property)
               .map(a -> a.getValue())
               .collect(Collectors.toList());
    }
    
   /**
    * Gets a value of an annotation with the given property iri on the given element 
    * 
    * @param reference the given Reference
    * @param propertyIri the given property iri
    * @return a literal that is the value of the given annotation property
    * @deprecated use {@link Reference#getOwnedAnnotations()} and filter the ones that have the annotation property instead
    */
   @Deprecated(since = "0.9.0", forRemoval = true)
    public static Literal getAnnotationValue(Reference reference, String propertyIri) {
       var property = (AnnotationProperty) getMemberByIri(reference, propertyIri);
       return reference.getOwnedAnnotations().stream()
               .filter(a -> a.getProperty() == property)
               .map(a -> a.getValue())
               .findFirst().orElse(null);
    }

   /**
    * Gets the super (general) terms of the given term
    * 
    * @param term the give term
    * @return a list of super terms of the given term
    * @deprecated use {@link OmlRead#getSuperTerms(SpecializableTerm)} instead
    */
   @Deprecated(since = "0.9.0", forRemoval = true)
   public static List<SpecializableTerm> getGeneralTerms(SpecializableTerm term) {
       return getSuperTerms(term);
   }
   
   /**
    * Gets the super (general) terms of the given term reference
    * 
    * @param reference the give term reference
    * @return a list of super terms of the given term
    * @deprecated use {@link SpecializableTermReference#getOwnedSpecializations()} and on each item call {@link SpecializationAxiom#getSpecializedTerm()} instead
    */
   @Deprecated(since = "0.9.0", forRemoval = true)
   public static List<SpecializableTerm> getGeneralTerms(SpecializableTermReference reference) {
       return reference.getOwnedSpecializations().stream()
               .map(i -> i.getSpecializedTerm())
               .collect(Collectors.toList());
   }

   /**
    * Gets all the axioms owned by the given term reference
    * 
    * @param reference the given term reference
    * @return a list of axioms owned by the given term reference
    * @deprecated use {@link SpecializableTermReference#getOwnedSpecializations()}, 
    *     {@link ClassifierReference#getOwnedPropertyRestrictions()},
    *     {@link EntityReference#getOwnedRelationRestrictions}
    *     {@link EntityReference#getOwnedKeys} instead
    */
   @Deprecated(since = "0.9.0", forRemoval = true)
   public static List<Axiom> getAxioms(SpecializableTermReference reference) {
       List<Axiom> axioms = new ArrayList<>((reference).getOwnedSpecializations());
       if (reference instanceof ClassifierReference) {
           axioms.addAll(((ClassifierReference)reference).getOwnedPropertyRestrictions());
       }
       if (reference instanceof EntityReference) {
           axioms.addAll(((EntityReference)reference).getOwnedRelationRestrictions());            
           axioms.addAll(((EntityReference)reference).getOwnedKeys());            
       }
       return axioms;
   }
   
   /**
    * Gets the super (general) term of the given specialization axiom
    * 
    * @param axiom the given specialization axiom
    * @return the super term of the given specialization axiom
    * @deprecated use {@link OmlRead#getSuperTerm(SpecializationAxiom)} instead
    */
   @Deprecated(since = "0.9.0", forRemoval = true)
   public static SpecializableTerm getGeneralTerm(SpecializationAxiom axiom) {
       return getSuperTerm(axiom);
   }
   
   /**
    * Gets the sub (specific) term of the given specialization axiom
    * 
    * @param axiom the given specialization axiom
    * @return the sub term of the given specialization axiom
    * @deprecated use {@link OmlRead#getSubTerm(SpecializationAxiom)} instead
    */
   @Deprecated(since = "0.9.0", forRemoval = true)
   public static SpecializableTerm getSpecificTerm(SpecializationAxiom axiom) {
       return getSubTerm(axiom);
   }

   //-------------------------------------------------
    // UTILITIES
    //-------------------------------------------------
    
    /**
     * Gets the closure of the given recursive function starting from a given root
     * 
     * @param root the given root to start the recursion from
     * @param includeRoot whether to include the root in the closure results
     * @param recursive the function to recurse with
     * @return the recursive closure of applying the given function on the given root
     */
    public static <T, V extends T> List<T> closure(V root, boolean includeRoot, Function<T, List<T>> recursive) {
        final Set<T> results = new LinkedHashSet<>();
        if (includeRoot)
            results.add(root);
        closure(root, results, recursive);
        return new ArrayList<T>(results);
    }
    
    /*
     * Recurses on the given function starting from a given root skipping results already in the cache
     * 
     * Updates the cache with the collected results at the end of this recursion cycle
     * 
     * @param root the given root to start the recursion from
     * @param cache the cache of results already collected before the recursion starts
     * @param recursive the function to recurse with
     */
    private static <T, V extends T> void closure(V root, Set<T> cache, Function<T, List<T>> recursive) {
        List<T> results = recursive.apply(root);
        if (results == null) {
            results = Collections.emptyList();
        } else {
            results = results.stream()
                .filter(r -> r != null)
                .filter(r -> !cache.contains(r))
                .collect(Collectors.toList());
        }
        cache.addAll(results);
        results.forEach(r -> closure(r, cache, recursive));
    }
    
    /**
     * Checks if a given item is in the closure of the given recursive function starting from a given root
     * 
     * @param item the given item to look for
     * @param root the given root to start the recursion from
     * @param includeRoot whether to include the root in the closure
     * @param recursive the function to recurse with
     * @return true if the given item is in the closure; otherwise false
     */
    public static <T, V extends T> boolean isInClosure(T item, V root, boolean includeRoot, Function<T, List<T>> recursive) {
        final Set<T> results = new LinkedHashSet<>();
        if (includeRoot) {
               results.add(root);
        }
        if (results.contains(item)) {
            return true;
        }
        return isInClosure(item, root, results, recursive);
    }

    /*
     * Checks if a given item is in the closure of the given recursive function starting from a given root
     * and skipping results already in the cache
     * 
     * @param item the given item to look for
     * @param root the given root to start the recursion from
     * @param cache the cache of results already collected before the recursion starts
     * @param recursive the function to recurse with
     * @return true if the given item is in the closure; otherwise false
     */
    private static <T, V extends T> boolean isInClosure(T item, V root, Set<T> cache, Function<T, List<T>> recursive) {
        List<T> results = recursive.apply(root);
        if (results == null) {
            results = Collections.emptyList();
        } else {
            results = results.stream()
                .filter(r -> r != null)
                .filter(r -> !cache.contains(r))
                .collect(Collectors.toList());
        }
        if (results.contains(item)) {
            return true;
        } 
        cache.addAll(results);
        for (T r : results) {
            if (isInClosure(item, r, cache, recursive)) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Breaks the given IRI string into its base and fragment components
     * 
     * @param iri The given IRI
     * @return The IRI components as a string array
     */
    private static String[] parseIri(String iri) {
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
    
    /*
     * Breaks the given abbreviated IRI string into its prefix and fragment components
     * 
     * @param iri The given abbreviated IRI
     * @return The IRI components as a string array
     */
    private static String[] parseAbbreviatedIri(String iri) {
        String[] parts = iri.split(":");
        String prefix = (parts.length> 1) ? parts[0] : "";
        String fragment = (parts.length> 1) ? parts[1] : parts[0];
        return new String[] {prefix, fragment};
    }
    
    //-------------------------------------------------
    // RESOURCES
    //-------------------------------------------------
    
    // ResourceSet
    
    /**
     * Get all ontologies in the given resource set 
     * 
     * @param resourceSet The resource set to look for ontologies in 
     * @return The list of ontologies in the given resource set
     */
    public static List<Ontology> getOntologies(ResourceSet resourceSet) {
        return resourceSet.getResources().stream()
            .map(r -> getOntology(r))
            .collect(Collectors.toList());
    }
    
    /**
     * Get an ontology with the given iri in the given resource set
     *  
     * @param resourceSet The resource set to look for an ontology in
     * @param iri The iri of the ontology
     * @return an ontology with the given iri if found; otherwise null
     */
    public static Ontology getOntologyByIri(ResourceSet resourceSet, String iri) {
        return resourceSet.getResources().stream()
            .flatMap(r -> r.getContents().stream())
            .filter(o -> o instanceof Ontology)
            .map(o -> (Ontology)o)
            .filter(o -> iri.equals(o.getIri()))
            .findFirst().orElse(null);
    }
    
    /**
     * Get an ontology with the given prefix in the given resource set
     *  
     * @param resourceSet The resource set to look for an ontology in
     * @param prefix The prefix of the ontology
     * @return an ontology with the given prefix if found; otherwise null
     */
    public static Ontology getOntologyByPrefix(ResourceSet resourceSet, String prefix) {
        return resourceSet.getResources().stream()
            .flatMap(r -> r.getContents().stream())
            .filter(o -> o instanceof Ontology)
            .map(o -> (Ontology)o)
            .filter(o -> prefix.equals(o.getPrefix()))
            .findFirst().orElse(null);
    }
    
    /**
     * Get a member with the given iri in the given resource set
     *  
     * @param resourceSet The resource set to look for an ontology in
     * @param iri The iri of the member
     * @return a member with the given iri if found; otherwise null
     */
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
    
    /**
     * Get a member with the given abbreviated iri in the given resource set
     *  
     * @param resourceSet The resource set to look for an ontology in
     * @param iri The abbreviated iri of the member
     * @return a member with the given abbreviated iri if found; otherwise null
     */
    public static Member getMemberByAbbreviatedIri(ResourceSet resourceSet, String iri) {
        String[] iriParts = parseAbbreviatedIri(iri);
        String prefix = iriParts[0];
        String fragment = iriParts[1];
        Ontology ontology = getOntologyByPrefix(resourceSet, prefix);
        if (ontology != null) {
            return (Member) ontology.eResource().getEObject(fragment);
        }
        return null;
    }
    
    // Resource
    
    /**
     * Get the ontology of the given resource if one exists
     * 
     * @param resource The resource to get the ontology from
     * @return An ontology if one exists in the resource; otherwise null
     */
    public static Ontology getOntology(Resource resource) {
        return resource.getContents().stream()
            .filter(o -> o instanceof Ontology)
            .map(o -> (Ontology)o)
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Get a member by iri in the context of the given resource
     * 
     * @param resource The resource to look for the member in
     * @param iri The iri of the member
     * @return A member if one exists with the given iri; otherwise null
     */
    public static Member getMemberByIri(Resource resource, String iri) {
        final Ontology ontology = getOntology(resource);
        if (ontology != null) {
            return getMemberByIri(ontology, iri);
        }
        return null;
    }
    
    /**
     * Get a member by abbreviated iri in the context of the given resource
     * 
     * @param resource The resource to look for the member in
     * @param iri The abbreviated iri of the member
     * @return A member if one exists with the given abbreviated iri; otherwise null
     */
    public static Member getMemberByAbbreviatedIri(Resource resource, String iri) {
        final Ontology ontology = getOntology(resource);
        if (ontology != null) {
            return getMemberByAbbreviatedIri(ontology, iri);
        }
        return null;
    }
    
    /**
     * Resolve the given (logical or physical) uri in the context of the given resource.
     * (The physical uri can be relative or absolute)
     * 
     * @param resource The resource to use as context of uri resolution
     * @param uri The (logical or physical) uri to resolve
     * @return The resolved URI
     */
    public static URI getResolvedUri(Resource resource, URI uri) {
        if (resource == null || uri == null || uri.isEmpty()) {
            return null;
        }
        final ResourceSet rs = resource.getResourceSet();
        if (rs == null) {
            return null;
        }
        OmlUriResolver resolver = OmlUriResolver.get(rs);
        if (resolver == null) {
            return null;
        }
        return resolver.resolve(resource, uri);
    }
    
    //-------------------------------------------------
    // COMMON
    //-------------------------------------------------
    
    // Element
    
    /**
     * Gets the id of the given element
     * 
     * The id attribute is defined by the metaclass of the element
     * 
     * @param element the element to get its id
     * @return the id of the element
     */
    public static String getId(Element element) {
        return EcoreUtil.getID(element);
    }
    
    /**
     * Resolves the given iri in the given context to a member
     * 
     * @param context the given context of resolution
     * @param iri the given iri
     * @return the member that has the given iri in the given context
     */
    public static Member getMemberByIri(Element context, String iri) {
        return getMemberByIri(context.getOntology(), iri);
    }
    
    /**
     * Resolves the given abbreviated iri in the given context to a member
     * 
     * @param context the given context of resolution
     * @param iri the given abbreviated iri
     * @return the member that has the given abbreviated iri in the given context
     */
    public static Member getMemberByAbbreviatedIri(Element context, String iri) {
        return getMemberByAbbreviatedIri(context.getOntology(), iri);
    }

    // Annotation
    
    /**
     * Get the annotated element of the given annotation
     * 
     * @param annotation the given annotation
     * @return the annotated element of the annotation
     */
    public static AnnotatedElement getAnnotatedElement(Annotation annotation) {
        if (annotation.getOwningReference() != null) {
            return resolve(annotation.getOwningReference());
        } else {
            return annotation.getOwningElement();
        }
    }
    
    // AnnotatedElement
    
    /**
     * Get the values of the given annotation property in the given element
     * 
     * @param element The element that has the annotation
     * @param property the given annotation property
     * @return a list of literals representing annotation values
     */
    public static List<Literal> getAnnotationValues(AnnotatedElement element, AnnotationProperty property) {
        return element.getOwnedAnnotations().stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .collect(Collectors.toList());
    }
    
    /**
     * Get the first value of the given annotation property in the given element
     * 
     * @param element The element that has the annotation
     * @param property the given annotation property
     * @return a literal representing the first annotation value
     */
    public static Literal getAnnotationValue(AnnotatedElement element, AnnotationProperty property) {
        return element.getOwnedAnnotations().stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .findFirst()
            .orElse(null);
    }
    
    // Literal
    
    /**
     * Get the lexical value of the given literal
     * 
     * @param literal the given literal
     * @return the lexical value of the given literal
     */
    public static String getLexicalValue(Literal literal) {
        String value = getStringValue(literal);
        if (literal instanceof QuotedLiteral) {
            var qLiteral = (QuotedLiteral) literal;
            var language = (qLiteral.getLangTag() != null) ? "$"+qLiteral.getLangTag() : "";
            var type = (qLiteral.getType() != null) ? "^^"+qLiteral.getType().getAbbreviatedIri() : "";
            value = '"'+value+'"'+language+type;
        }
        return value;
    }

    /**
     * Get the string value of the given literal
     * 
     * @param literal the given literal
     * @return the string value of the given literal
     */
    public static String getStringValue(Literal literal) {
        Object value = getValue(literal);
        return (value != null) ? value.toString() : "";
    }
    
    /**
     * Get the value of the given literal
     * 
     * @param literal the given literal
     * @return the value of the given literal
     */
    public static Object getValue(Literal literal) {
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
    
    /**
     * Get the iri of the given literal's type
     * 
     * @param literal the given literal
     * @return the iri of the given literal's type
     */
    public static String getTypeIri(Literal literal) {
        if (literal instanceof QuotedLiteral) {
            QuotedLiteral qLiteral = (QuotedLiteral)literal; 
            return qLiteral.getType() != null ? 
                qLiteral.getType().getIri() : 
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
    
    //-------------------------------------------------
    // ONTOLOGIES
    //-------------------------------------------------
    
    // Ontology
    
    /**
     * Gets the direct imports of the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of direct imports of the ontology
     */
    public static List<Import> getImports(Ontology ontology) {
        List<Import> imports = new ArrayList<>();
        if (ontology instanceof Vocabulary) {
            imports.addAll((((Vocabulary)ontology).getOwnedImports()));
        } else if (ontology instanceof VocabularyBundle) {
            imports.addAll((((VocabularyBundle)ontology).getOwnedImports()));
        } else if (ontology instanceof Description) {
            imports.addAll((((Description)ontology).getOwnedImports()));
        } else if (ontology instanceof DescriptionBundle) {
            imports.addAll((((DescriptionBundle)ontology).getOwnedImports()));
        }
        return imports;
    }
    
    /**
     * Gets the direct or transitive imports of the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of direct imports of the ontology
     */
    public static List<Import> getAllImports(Ontology ontology) {
        return getImports(ontology).stream()
            .flatMap(i -> closure(i, true, j -> getImports(getImportedOntology(j))).stream())
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all statements of the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of all statements of the given ontology
     */
    public static List<Statement> getStatements(Ontology ontology) {
        List<Statement> statements = new ArrayList<>();
        if (ontology instanceof Vocabulary) {
            statements.addAll(((Vocabulary)ontology).getOwnedStatements());
        } else if (ontology instanceof Description) {
            statements.addAll(((Description)ontology).getOwnedStatements());
        }
        return statements;
    }
    
    /**
     * Gets all references defined in the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of all references defined in the given ontology
     */
    public static List<Reference> getReferences(Ontology ontology) {
        return getStatements(ontology).stream()
            .filter(s -> s instanceof Reference)
            .map(s -> (Reference)s)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets all members defined in the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of all members defined in the given ontology
     */
    public static List<Member> getMembers(Ontology ontology) {
        if (ontology instanceof Vocabulary) {
            return getStatements(ontology).stream()
                .flatMap(s -> {
                    final ArrayList<Member> ms = new ArrayList<>();
                    if (s instanceof Member)
                        ms.add((Member) s);
                    if (s instanceof RelationEntity)
                        ms.addAll(getRelations((RelationEntity) s));
                    return ms.stream();
                })
                .collect(Collectors.toList());
        } else if (ontology instanceof Description){
            return getStatements(ontology).stream()
                .filter(s -> s instanceof Member)
                .map(s -> (Member)s)
                .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
    
    /**
     * Gets a map from import namespaces to import prefixes in the given ontology
     * 
     * @param ontology the given ontology
     * @return a map from import namespaces to import prefixes 
     */
    public static Map<String, String> getImportPrefixes(Ontology ontology) {
        final Map<String, String> map = new LinkedHashMap<>();
        getAllImports(ontology).forEach(i -> {
            if (!map.containsKey(getImportedNamespace(i))) {
                map.put(getImportedNamespace(i), getEffectivePrefix(i));
            }
        });
        return map;
    }
    
    /**
     * Gets the prefix of a given ontology imported by a context ontology
     * 
     * This could either be the given ontology's regular prefix or an override 
     * used when importing it in the context ontology
     * 
     * @param ontology the imported ontology
     * @param context the context ontology
     * @return
     */
    public static String getPrefixIn(Ontology ontology, Ontology context) {
        if (ontology == context) {
            return ontology.getPrefix();
        } else {
            return getImportPrefixes(context).get(ontology.getNamespace());
        }
    }
    
    /**
     * Gets the ontologies directly imported by a context ontology
     * 
     * @param ontology the given ontology
     * @return a list of ontologies directly imported by the given ontology
     */
    public static List<Ontology> getImportedOntologies(Ontology ontology) {
        return getImports(ontology).stream()
            .map(i -> getImportedOntology(i))
            .collect(Collectors.toList());
    }
    
    /**
     * Gets the ontologies directly or transitively imported by the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of ontologies directly imported by the given ontology
     */
    public static List<Ontology> getAllImportedOntologies(Ontology ontology, boolean inclusive) {
        return closure(ontology, inclusive, i -> getImports(i).stream()
            .map(j -> getImportedOntology(j))
            .collect(Collectors.toList()));
    }
    
    /**
     * Gets an ontology with a given iri that is imported by a given ontology
     * 
     * This iri is the ontology's logical IRI even though it may be imported by a physical URI
     * 
     * @param ontology the context ontology
     * @param iri the iri of the imported ontology
     * @return the imported ontology that has the given iri 
     */
    public static Ontology getImportedOntologyByIri(Ontology ontology, String iri) {
        return getAllImports(ontology).stream()
            .map(i -> getImportedOntology(i))
            .filter(o -> o != null && o.getIri().equals(iri))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Gets an ontology with a given prefix that is imported by a given ontology
     * 
     * This prefix has to be the ontology's import override prefix if used; otherwise has to be its default prefix
     * 
     * @param ontology the context ontology
     * @param prefix the prefix of the imported ontology
     * @return the imported ontology that has the given iri 
     */
    public static Ontology getImportedOntologyByPrefix(Ontology ontology, String prefix) {
        return getAllImports(ontology).stream()
            .filter(i -> getEffectivePrefix(i).equals(prefix))
            .map(i -> getImportedOntology(i))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Gets a member with the given name defined in the given ontology
     * 
     * @param ontology the given ontology
     * @param name the name of the member
     * @return a member with the given name if found; otherwise null
     */
    public static Member getMemberByName(Ontology ontology, String name) {
        // this is more efficient than iterating over the members
        EObject obj = ontology.eResource().getEObject(name);
        return (obj instanceof Member) ? (Member)obj : null;
    }
    
    /**
     * Gets a member with the given iri defined by the given ontology
     * 
     * @param ontology the given ontology
     * @param iri the iri of the member
     * @return a member with the given iri if found; otherwise null
     */
    public static Member getMemberByIri(Ontology ontology, String iri) {
        String[] iriParts = parseIri(iri);
        String baseIri = iriParts[0];
        String fragment = iriParts[1];
        Ontology baseOntology;
        if (ontology.getIri().equals(baseIri)) {
            baseOntology = ontology;
        } else {
            baseOntology = getImportedOntologyByIri(ontology, baseIri);
        }
        return (baseOntology != null) ? getMemberByName(baseOntology, fragment) : null;
    }
    
    /**
     * Gets a member with the given abbreviated iri defined by the given ontology
     * 
     * @param ontology the given ontology
     * @param iri the abbreviated iri of the member
     * @return a member with the given abbreviated iri if found; otherwise null
     */
    public static Member getMemberByAbbreviatedIri(Ontology ontology, String iri) {
        String[] iriParts = parseAbbreviatedIri(iri);
        String prefix = iriParts[0];
        String fragment = iriParts[1];
        Ontology baseOntology;
        if (ontology.getPrefix().equals(prefix)) {
            baseOntology = ontology;
        } else {
            baseOntology = getImportedOntologyByPrefix(ontology, prefix);
        }
        return (baseOntology != null) ? getMemberByName(baseOntology, fragment) : null;
    }
        
    //-------------------------------------------------
    // IMPORTS
    //-------------------------------------------------
    
    // Import
    
    /**
     * Gets the effective prefix implied by the given import
     * 
     * This might be the import's prefix override if specified, 
     * otherwise it is the imported ontology's prefix
     * 
     * @param _import the given import
     * @return the prefix override specified by the given import
     */
    public static String getEffectivePrefix(Import _import) {
        if (_import.getPrefix() != null) {
            return _import.getPrefix();
        } else {
            Ontology ontology = getImportedOntology(_import);
            return (ontology != null) ? ontology.getPrefix() : null;
        }
    }
    
    /**
     * Gets the URI that results from resolving the given import's uri
     * 
     * @param _import the given import
     * @return the resolved URI of the given import
     */
    public static URI getResolvedUri(Import _import) {
        if (_import.getUri() == null || _import.getUri().isEmpty()) {
            return null;
        }
        URI importUri = URI.createURI(_import.getUri());
        final Resource r = _import.eResource();
        if (r == null) {
            return null;
        }
        return getResolvedUri(r, importUri);
    }
    
    /**
     * Gets the namespace of the ontology imported by the given import
     * 
     * @param _import the given import
     * @return the namespace of the imported ontology
     */
    public static String getImportedNamespace(Import _import) {
        Ontology ontology = getImportedOntology(_import);
        return (ontology != null) ? ontology.getNamespace() : null;
    }
    
    /**
     * Get the ontology that is imported by the given import
     * 
     * @param _import the given import
     * @return the ontology that is imported by the given import (can be null of the import failed)
     */
    public static Ontology getImportedOntology(Import _import) {
        Resource r = getImportedResource(_import);
        return (r != null) ? getOntology(r) : null;
    }
    
    /**
     * Gets the ontology that defines the given import
     * 
     * @param _import the given import
     * @return the ontology that defines the given import
     */
    public static Ontology getImportingOntology(Import _import) {
        if (_import instanceof VocabularyImport) {
            return ((VocabularyImport)_import).getOwningVocabulary();
        } else if (_import instanceof VocabularyBundleImport) {
            return ((VocabularyBundleImport)_import).getOwningVocabularyBundle();
        } if (_import instanceof DescriptionImport) {
            return ((DescriptionImport)_import).getOwningDescription();
        } else if (_import instanceof DescriptionBundleImport) {
            return ((DescriptionBundleImport)_import).getOwningDescriptionBundle();
        }
        return null;
    }
    
    /**
     * Gets the resource imported by the given import
     * 
     * @param _import the given import
     * @return a resource that is imported by the given import
     */
    public static Resource getImportedResource(Import _import) {
        final URI uri = getResolvedUri(_import);
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
    
    //-------------------------------------------------
    // MEMBERS
    //-------------------------------------------------

    // Reference
    
    /**
     * Resolves the given reference to a member
     * 
     * @param reference the given reference
     * @return the resolved member
     */
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
    
    /**
     * Gets the abbreviated iri of the given reference
     * 
     * @param reference the given reference
     * @return the abbreviated IRI of the given reference
     */
    public static String getAbbreviatedIri(Reference reference) {
        return getAbbreviatedIriIn(resolve(reference), reference.getOntology());
    }
    
    // Member
    
    /**
     * Gets the abbreviated iri of the given member in the given context ontology
     * 
     * @param member the given member
     * @param context the given context ontology
     * @return the abbreviated IRI of the given reference in the given context ontology
     */
    public static String getAbbreviatedIriIn(Member member, Ontology context) {
        final Ontology ontology = member.getOntology();
        if (ontology == context) {
            return member.getName();
        } else {
            String prefix = getPrefixIn(ontology, context);
            return (prefix != null) ? prefix + ':'+member.getName() : null;
        }
    }
    
    // SpecializableTerm
    
    /**
     * Gets the super (general) terms of the given term
     * 
     * @param term the give term
     * @return a list of super terms of the given term
     */
    public static List<SpecializableTerm> getSuperTerms(SpecializableTerm term) {
        return term.getOwnedSpecializations().stream()
            .map(i -> i.getSpecializedTerm())
            .collect(Collectors.toList());
    }
    
    // RelationEntity
    
    /**
     * Gets all the relations defined by the given relation entity
     * 
     * @param entity the given relation entity
     * @return a list of relations defined by the given relation entity
     */
    public static List<Relation> getRelations(RelationEntity entity) {
        var relations = new ArrayList<Relation>();
        if (entity.getForwardRelation() != null) {
            relations.add(entity.getForwardRelation());
        }
        if (entity.getReverseRelation() != null) {
            relations.add(entity.getReverseRelation());
        }
        return relations;
    }
    
    // SpecializableTerm
    
    /**
     * Gets all the axioms owned by the given term
     * 
     * @param term the given term
     * @return a list of axioms owned by the given term
     */
    public static List<Axiom> getAxioms(SpecializableTerm term) {
        var axioms = new ArrayList<Axiom>();
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
    
    // Instance
    
    /**
     * Gets all the assertions owned by the given instance
     * 
     * @param instance the given instance
     * @return a list of assertions owned by the given instance
     */
    public static List<Assertion> getAssertions(Instance instance) {
        var assertions = new ArrayList<Assertion>();
        assertions.addAll(instance.getOwnedPropertyValues());
        if (instance instanceof NamedInstance) {
            assertions.addAll(((NamedInstance)instance).getOwnedLinks());
            assertions.addAll(getTypeAssertions((NamedInstance)instance));
        }
        return assertions;
    }
    
    /**
     * Gets all the type assertions owned by the given instance
     * 
     * @param instance the given instance
     * @return a list of type assertions owned by the given instance
     */
    public static List<TypeAssertion> getTypeAssertions(NamedInstance instance) {
        var assertions = new ArrayList<TypeAssertion>();
        if (instance instanceof ConceptInstance) {
            assertions.addAll(((ConceptInstance)instance).getOwnedTypes());
        } else if (instance instanceof RelationInstance) {
            assertions.addAll(((RelationInstance)instance).getOwnedTypes());
        }
        return assertions;
    }

    // NamedInstanceReference
    
    /**
     * Gets all the assertions owned by the given reference
     * 
     * @param reference the given reference
     * @return a list of assertions owned by the given reference
     */
    public static List<Assertion> getAssertions(NamedInstanceReference reference) {
        var assertions = new ArrayList<Assertion>();
        assertions.addAll(reference.getOwnedPropertyValues());
        assertions.addAll(reference.getOwnedLinks());
        assertions.addAll(getTypeAssertions(reference));
        return assertions;
    }
    
    /**
     * Gets all the type assertions owned by the given reference
     * 
     * @param reference the given reference
     * @return a list of type assertions owned by the given reference
     */
    public static List<TypeAssertion> getTypeAssertions(NamedInstanceReference reference) {
        var assertions = new ArrayList<TypeAssertion>();
        if (reference instanceof ConceptInstanceReference) {
            assertions.addAll(((ConceptInstanceReference)reference).getOwnedTypes());
        } else if (reference instanceof RelationInstanceReference) {
            assertions.addAll(((RelationInstanceReference)reference).getOwnedTypes());
        }
        return assertions;
    }

    // AnnotatedElement
    
    /**
     * Get the values of the given semantic property in the given instance
     * 
     * @param instance The instance that has the annotation
     * @param property the given semantic property
     * @return a list of elements representing the property values
     */
    public static List<Element> getPropertyValues(Instance instance, SemanticProperty property) {
        return instance.getOwnedPropertyValues().stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .collect(Collectors.toList());
    }
    
    /**
     * Get a value of the given semantic property in the given instance
     * 
     * @param instance The instance that has the annotation
     * @param property the given semantic property
     * @return an element representing a property value
     */
    public static Element getPropertyValue(Instance instance, SemanticProperty property) {
        return instance.getOwnedPropertyValues().stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .findFirst().orElse(null);
    }
    
    /**
     * Gets the types declared on the given instance
     * 
     * @param instance the given instance
     * @return a list of types of the given element
     */
    public static List<Classifier> getTypes(Instance instance) {
       var types = new ArrayList<Classifier>();
        if (instance instanceof StructureInstance) {
            types.add(((StructureInstance) instance).getType());
        } else if (instance instanceof NamedInstance) {
            types.addAll(getTypeAssertions((NamedInstance)instance).stream().
                map(i -> i.getType()).
                collect(Collectors.toList()));
        }
        return types;
    }

    //-------------------------------------------------
    // AXIOMS
    //-------------------------------------------------
    
    // KeyAxiom
    
    /**
     * Gets the entity that defines the given key axiom
     * 
     * @param axiom the given key axiom
     * @return the entity that defines the given key axiom
     */
    public static Entity getKeyedEntity(KeyAxiom axiom) {
        if (axiom.getOwningReference() != null) {
            return (Entity) resolve(axiom.getOwningReference());
        } else {
            return axiom.getOwningEntity();
        }
    }
    
    // SpecializationAxiom
    
    /**
     * Gets the super (general) term of the given specialization axiom
     * 
     * @param axiom the given specialization axiom
     * @return the super term of the given specialization axiom
     */
    public static SpecializableTerm getSuperTerm(SpecializationAxiom axiom) {
        return axiom.getSpecializedTerm();
    }
    
    /**
     * Gets the sub (specific) term of the given specialization axiom
     * 
     * @param axiom the given specialization axiom
     * @return the sub term of the given specialization axiom
     */
    public static SpecializableTerm getSubTerm(SpecializationAxiom axiom) {
        if (axiom.getOwningReference() != null) {
            return (SpecializableTerm) resolve(axiom.getOwningReference());
        } else {
            return axiom.getOwningTerm();
        }
    }
    
    // RestrictionAxiom
    
    /**
     * Gets the restricting classifier of the given restriction axiom
     * 
     * @param axiom the given restriction axiom
     * @return the restricting classifier of the given restriction axiom
     */
    public static Classifier getRestrictingClassifier(RestrictionAxiom axiom) {
        if (axiom instanceof PropertyRestrictionAxiom) {
            return getRestrictingClassifier((PropertyRestrictionAxiom) axiom);
        } else if (axiom instanceof RelationRestrictionAxiom) {
            return getRestrictingEntity((RelationRestrictionAxiom) axiom);
        } 
        return null;
    }
    
    /**
     * Gets the restricting classifier of the given property restriction axiom
     * 
     * @param axiom the given property restriction axiom
     * @return the restricting classifier of the given property restriction axiom
     */
    public static Classifier getRestrictingClassifier(PropertyRestrictionAxiom axiom) {
        if (axiom.getOwningReference() != null) {
            return (Classifier) resolve(axiom.getOwningReference());
        } else {
            return axiom.getOwningClassifier();
        }
    }
    
    /**
     * Gets the restricting entity of the given relation restriction axiom
     * 
     * @param axiom the given relation restriction axiom
     * @return the restricting entity of the given relation restriction axiom
     */
    public static Entity getRestrictingEntity(RelationRestrictionAxiom axiom) {
        if (axiom.getOwningReference() != null) {
            return (Entity) resolve(axiom.getOwningReference());
        } else {
            return axiom.getOwningEntity();
        }
    }
    
    /**
     * Gets the restricted feature of the given restriction axiom
     * 
     * @param axiom the given restriction axiom
     * @return the restricted feature of the given restriction axiom
     */
    public static Feature getRestrictedFeature(RestrictionAxiom axiom) {
        if (axiom instanceof RelationRestrictionAxiom) {
            return ((RelationRestrictionAxiom) axiom).getRelation();
        } else if (axiom instanceof ScalarPropertyRestrictionAxiom) {
            return ((ScalarPropertyRestrictionAxiom) axiom).getProperty();
        } else if (axiom instanceof StructuredPropertyRestrictionAxiom) {
            return ((StructuredPropertyRestrictionAxiom) axiom).getProperty();
        }
        return null;
    }
    
    //-------------------------------------------------
    // ASSERTIONS
    //-------------------------------------------------
    
    // Assertion
    
    /**
     * Get the instance that is the subject of the given assertion
     * 
     * @param assertion the given assertion
     * @return the instance that is the subject of this assertion
     */
    public static Instance getSubject(Assertion assertion) {
        if (assertion instanceof ConceptTypeAssertion) {
            return getSubject((ConceptTypeAssertion) assertion);
        } else if (assertion instanceof RelationTypeAssertion) {
            return getSubject((RelationTypeAssertion) assertion);
        } else if (assertion instanceof LinkAssertion) {
            return getSubject((LinkAssertion) assertion);
        } else if (assertion instanceof PropertyValueAssertion) {
            return getSubject((PropertyValueAssertion) assertion);
        }
        return null;
    }
    
    /**
     * Gets the concept instance that is the subject of the given concept type assertion
     * 
     * @param assertion the given concept type assertion
     * @return the concept instance that is the subject of the concept type assertion
     */
    public static ConceptInstance getSubject(ConceptTypeAssertion assertion) {
        if (assertion.getOwningReference() != null) {
            return (ConceptInstance) resolve(assertion.getOwningReference());
        } else {
            return assertion.getOwningInstance();
        }
    }
    
    /**
     * Gets the relation instance that is the subject of the given relation type assertion
     * 
     * @param assertion the given relation type assertion
     * @return the relation instance that is the subject of the relation type assertion
     */
    public static RelationInstance getSubject(RelationTypeAssertion assertion) {
        if (assertion.getOwningReference() != null) {
            return (RelationInstance) resolve(assertion.getOwningReference());
        } else {
            return assertion.getOwningInstance();
        }
    }
    
    /**
     * Gets the named instance that is the subject of the given link assertion
     * 
     * @param assertion the given link assertion
     * @return the named instance that is the subject of the link assertion
     */
    public static NamedInstance getSubject(LinkAssertion assertion) {
        if (assertion.getOwningReference() != null) {
            return (NamedInstance) resolve(assertion.getOwningReference());
        } else {
            return assertion.getOwningInstance();
        }
    }
    
    /**
     * Gets the instance that is the subject of the given property value assertion
     * 
     * @param assertion the given property value assertion
     * @return the instance that is the subject of the property value assertion
     */
    public static Instance getSubject(PropertyValueAssertion assertion) {
        if (assertion.getOwningReference() != null) {
            return (Instance) resolve(assertion.getOwningReference());
        } else {
            return assertion.getOwningInstance();
        }
    }
    
    // LinkAssertion
    
    /**
     * Gets the source instance of the given link assertion 
     * 
     * @param assertion the given link assertion
     * @return the instance that is the source of the given link assertion
     */
    public static NamedInstance getSource(LinkAssertion assertion) {
        return (NamedInstance) getSubject(assertion);
    }
    
    /**
     * Gets the target instance of the given link assertion 
     * 
     * @param assertion the given link assertion
     * @return the instance that is the target of the given link assertion
     */
    public static NamedInstance getTarget(LinkAssertion assertion) {
        return assertion.getTarget();
    }
    
    // Predicate
    
    /**
     * Gets the term that is bound by the given predicate
     * 
     * @param predicate the given predicate
     * @return the term that is bound by the predicate
     */
    public static Term getTerm(Predicate predicate) {
    	if (predicate instanceof TypePredicate) {
    		return ((TypePredicate)predicate).getType();
    	} else if (predicate instanceof RelationEntityPredicate) {
    		return ((RelationEntityPredicate)predicate).getEntity();
    	} else if (predicate instanceof FeaturePredicate) {
    		return ((FeaturePredicate)predicate).getFeature();
    	}
    	return null;
    }

}