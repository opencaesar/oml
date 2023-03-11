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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumerationAxiom;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.Vocabulary;

/**
 * The <b>Read</b> API for the model. It complements the OML getter API by additional utilities.
 *  
 * @author elaasar
 */
public final class OmlRead {
    
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
    
    /**
     * Gets all ontologies loaded in the given resource set 
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
     * Gets an ontology with the given iri that is loaded in the given resource set
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
     * Gets an ontology with the given prefix that is loaded in the given resource set
     * 
     * If more than one ontology has the same prefix, one of them is returned randomly
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
     * Gets a member with the given iri in the given resource set
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
            return getMemberByName(ontology, fragment);
        }
        return null;
    }
    
    /**
     * Gets a member with the given abbreviated iri in the given resource set
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
            return getMemberByName(ontology, fragment);
        }
        return null;
    }
    
    /**
     * Gets the ontology of the given resource if one exists
     * 
     * @param resource The resource to get the ontology from
     * @return An ontology if one exists in the resource; otherwise null
     */
    public static Ontology getOntology(Resource resource) {
		if (!resource.isLoaded()) {
			try {
				resource.load(null);
			} catch (IOException e) {
				return null;
			}
		}
        return resource.getContents().stream()
            .filter(o -> o instanceof Ontology)
            .map(o -> (Ontology)o)
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Gets a member by iri in the context of the given resource following the import closure
     * 
     * @param resource The resource to look for the member in
     * @param iri The iri of the member
     * @return A member if one exists with the given iri; otherwise null
     */
    public static Member getMemberByIri(Resource resource, String iri) {
        String[] iriParts = parseIri(iri);
        String baseIri = iriParts[0];
        String fragment = iriParts[1];
        final Ontology ontology = getOntologyByIri(resource, baseIri);
        return (ontology != null) ? getMemberByName(ontology, fragment) : null;
    }
    
    /**
     * Gets the ontology with the given Iri in the context of the given resource
     * 
     * The iri is resolved using the resource's OML catalog
     * 
     * @param resource The resource to use as context of iri resolution
     * @param iri The logical iri of the ontology to get
     * @return The resolved URI
     */
    public static Ontology getOntologyByIri(Resource resource, String iri) {
    	Resource resolved = getResourceByIri(resource, iri);
        return (resolved != null) ? getOntology(resolved) : null;
    }

   /**
     * Gets a resource that has the given logical Iri in the context of the given resource.
     * 
     * The resource may not be loaded when it is returned
     * 
     * @param resource The resource to use as context of uri resolution
     * @param iri The logical iri to resolve
     * @return The resource that has the given IRI
     */
    public static Resource getResourceByIri(Resource resource, String iri) {
    	URI uri = getUriByIri(resource, iri);
    	ResourceSet resourceSet = (uri != null) ? resource.getResourceSet() : null;
    	return (resourceSet != null) ? resourceSet.getResource(uri, false) : null;
    }
    
    /**
     * Gets a physical URI that corresponds to the given logical Iri in the context of the given resource.
     * 
     * @param resource The resource to use as context of uri resolution
     * @param iri The logical iri to resolve
     * @return The resolved URI
     */
    public static URI getUriByIri(Resource resource, String iri) {
        if (resource == null || iri == null || iri.isEmpty()) {
            return null;
        }
        return OmlUriResolver.getInstance().resolve(resource, iri);
    }
    
    /**
     * Gets the resource URIs that are resolvable from the context of the given resource
     * 
     * This method looks for resolvable resources in the resource's OML catalog 
     * 
     * @param resource the context resource
     * @return a set of resource URIs that are resolvable from the given resource
     */
    public static Set<URI> getResolvableUris(Resource resource) {
        if (resource == null) {
            return Collections.emptySet();
        }
        return OmlUriResolver.getInstance().getResolvableUris(resource);
    }
    
    /**
     * Determines whether the resource with the given URI is mapped by an OML catalog 
     * 
     * @param uri the given resource URI
     * @return Whether the given resource URI is of an OML resource mapped by a catalog
     */
    public static boolean isUriMappedByCatalog(URI uri) {
        if (Arrays.asList(OmlConstants.OML_EXTENSIONS).contains(uri.fileExtension())) {
        	return OmlUriResolver.getInstance().isUriMappedByCatalog(uri);
        }
        return false;
    }

    //-------------------------------------------------
    // ONTOLOGIES
    //-------------------------------------------------
    
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
     * Gets the annotated element of the given annotation
     * 
     * @param annotation the given annotation
     * @return the annotated element of the annotation
     */
    public static IdentifiedElement getAnnotatedElement(Annotation annotation) {
        if (annotation.getOwningElement() instanceof Member) {
            return resolve((Member)annotation.getOwningElement());
        } else {
            return annotation.getOwningElement();
        }
    }
    
    /**
     * Gets all annotations that references the given property on the given element
     * 
     * @param element The element that has the annotation
     * @param property the given annotation property
     * @return a list of annotations referencing the annotation property on the element
     */
    public static List<Annotation> getAnnotations(IdentifiedElement element, AnnotationProperty property) {
        return element.getOwnedAnnotations().stream()
            .filter(a -> a.getProperty() == property)
            .collect(Collectors.toList());
    }

    /**
     * Gets the values of a given annotation property in the given element
     * 
     * @param element The element that has the annotation
     * @param property the given annotation property
     * @return a list of literals representing annotation values
     */
    public static List<Element> getAnnotationValues(IdentifiedElement element, AnnotationProperty property) {
        return element.getOwnedAnnotations().stream()
            .filter(a -> a.getProperty() == property)
            .map(a -> a.getValue())
            .collect(Collectors.toList());
    }
    
    /**
     * Gets the direct or transitive imports of the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of direct imports of the ontology
     */
    public static List<Import> getAllImports(Ontology ontology) {
        return ontology.getOwnedImports().stream()
            .flatMap(i -> closure(i, true, j -> getImportedOntology(j).getOwnedImports()).stream())
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
     * Gets all reference statements defined in a given ontology
     * 
     * @param ontology the given ontology
     * @return a list of all reference statements defined in the given ontology
     */
    public static List<Statement> getReferences(Ontology ontology) {
        return getStatements(ontology).stream()
            .filter(s -> s.isRef())
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
        ontology.getOwnedImports().stream()
        	.filter(i -> i.getPrefix() != null)
        	.forEach(i -> map.put(i.getNamespace(), i.getPrefix()));
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
        return ontology.getOwnedImports().stream()
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
        return closure(ontology, inclusive, i -> i.getOwnedImports().stream()
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
        return ontology.getOwnedImports().stream()
            .filter(i -> iri.equals(i.getIri()))
            .map(i -> getImportedOntology(i))
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
        return ontology.getOwnedImports().stream()
                .filter(i -> prefix.equals(i.getPrefix()))
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
     * Gets a member with the given iri defined by the given ontology or its import closure
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
     * Gets a member with the given abbreviated iri defined by the given ontology or its import closure
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
        
    /**
     * Gets the resource URI that is resolved by the given import statement
     * 
     * @param _import the given import
     * @return the resolved URI of the given import
     */
    public static URI getImportedUri(Import _import) {
        if (_import.getIri() == null || _import.getIri().isEmpty()) {
            return null;
        }
        String iri = _import.getIri();
        final Resource r = _import.eResource();
        if (r == null) {
            return null;
        }
        return getUriByIri(r, iri);
    }
    
    /**
     * Gets the ontology that is imported by the given import
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
        return _import.getOwningOntology();
    }
    
    /**
     * Gets the resource imported by the given import
     * 
     * The resource may not be loaded when it is returned
     * 
     * @param _import the given import
     * @return a resource that is imported by the given import
     */
    public static Resource getImportedResource(Import _import) {
        final URI uri = getImportedUri(_import);
        final ResourceSet resourceSet = (uri != null) ? _import.eResource().getResourceSet() : null;
        return (resourceSet != null) ? resourceSet.getResource(uri, true) : null;
    }
    
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

    /**
     * Resolves the given reference to a member
     * 
     * @param reference the given reference
     * @return the resolved member
     */
    @SuppressWarnings("unchecked")
	public static <T extends Member> T resolve(T reference) {
    	if (reference.isRef()) {
    		return (T) reference.getRef();
    	}
        return reference;
    }
    
    //-------------------------------------------------
    // VOCABULARIES
    //-------------------------------------------------

    /**
     * Gets the super (general) terms of the given term
     * 
     * @param term the give term
     * @return a list of super terms of the given term
     */
    public static List<SpecializableTerm> getSuperTerms(SpecializableTerm term) {
        return term.getOwnedSpecializations().stream()
            .map(i -> i.getSuperTerm())
            .collect(Collectors.toList());
    }
    
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

    /**
     * Gets the relation entity that defines the given relation
     * 
     * @param relation the given relation
     * @return the relation entity that defines the given relation, or null if none exists
     */
    public static RelationEntity getRelationEntity(Relation relation) {
        RelationEntity entity = null;
        if (relation instanceof ForwardRelation) {
        	entity = ((ForwardRelation)relation).getRelationEntity();
        } else if (relation instanceof ReverseRelation) {
        	RelationBase base = ((ReverseRelation)relation).getRelationBase();
        	if (base instanceof RelationEntity) {
        		entity = (RelationEntity) base;
        	}
        }
        return entity;
    }
    
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
            axioms.addAll(((Entity)term).getOwnedKeys());            
        }
        if (term instanceof Concept) {
            axioms.add(((Concept)term).getOwnedEnumeration());            
        }
        return axioms;
    }
    
    /**
     * Gets the entity that defines the given key axiom
     * 
     * @param axiom the given key axiom
     * @return the entity that defines the given key axiom
     */
    public static Entity getKeyedEntity(KeyAxiom axiom) {
    	return resolve(axiom.getOwningEntity());
    }
    
    /**
     * Gets the concept that defines the given enumeration axiom
     * 
     * @param axiom the given enumeration axiom
     * @return the concept that defines the given enumeration axiom
     */
    public static Concept getEnumeratedConcept(EnumerationAxiom axiom) {
    	return resolve(axiom.getOwningConcept());
    }

    /**
     * Gets the sub (specific) term of the given specialization axiom
     * 
     * @param axiom the given specialization axiom
     * @return the sub term of the given specialization axiom
     */
    public static SpecializableTerm getSubTerm(SpecializationAxiom axiom) {
    	return resolve(axiom.getOwningTerm());
    }
    
    /**
     * Gets the restricting domain of the given property restriction axiom
     * 
     * @param axiom the given property restriction axiom
     * @return the restricting domain of the given property restriction axiom
     */
    public static Classifier getRestrictingDomain(PropertyRestrictionAxiom axiom) {
    	return resolve(axiom.getOwningClassifier());
    }
    
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
    		return ((RelationEntityPredicate)predicate).getType();
    	} else if (predicate instanceof PropertyPredicate) {
    		return ((PropertyPredicate)predicate).getProperty();
    	}
    	return null;
    }

    //-------------------------------------------------
    // DESCRIPTIONS
    //-------------------------------------------------
    
    /**
     * Gets all the assertions owned by the given instance
     * 
     * @param instance the given instance
     * @return a list of assertions owned by the given instance
     */
    public static List<Assertion> getAssertions(Instance instance) {
        var assertions = new ArrayList<Assertion>();
        if (instance instanceof NamedInstance) {
        	assertions.addAll(((NamedInstance)instance).getOwnedTypes());
        }
        assertions.addAll(instance.getOwnedPropertyValues());
        return assertions;
    }

    /**
     * Gets the values of the given semantic property in the given instance
     * 
     * @param instance The given instance
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
            types.addAll(((NamedInstance)instance).getOwnedTypes().stream().
                map(i -> i.getType()).
                collect(Collectors.toList()));
        }
        return types;
    }

    /**
     * Gets the instance that asserts the given assertion
     * 
     * @param assertion the given assertion
     * @return the instance that is the subject of this assertion
     */
    public static Instance getAssertingInstance(Assertion assertion) {
        if (assertion instanceof TypeAssertion) {
            return getAssertingInstance((TypeAssertion) assertion);
        } else if (assertion instanceof PropertyValueAssertion) {
            return getAssertingInstance((PropertyValueAssertion) assertion);
        }
        return null;
    }
    
    /**
     * Gets the named instance that is the subject of the given type assertion
     * 
     * @param assertion the given type assertion
     * @return the concept instance that is the subject of the concept type assertion
     */
    public static NamedInstance getAssertingInstance(TypeAssertion assertion) {
    	return resolve(assertion.getOwningInstance());
    }
    
    /**
     * Gets the instance that is the subject of the given value assertion
     * 
     * @param assertion the given value assertion
     * @return the instance that is the subject of the value assertion
     */
    public static Instance getAssertingInstance(PropertyValueAssertion assertion) {
        if (assertion.getOwningInstance() instanceof NamedInstance) {
            return resolve((NamedInstance)assertion.getOwningInstance());
        } else {
            return assertion.getOwningInstance();
        }
    }
    
    /**
     * Gets the subject of the given assertion 
     * 
     * @param assertion the given assertion
     * @return the subject (instance) of the given assertion
     */
    public static Instance getSubject(Assertion assertion) {
        return getAssertingInstance(assertion);
    }
    
    /**
     * Gets the object of the given assertion 
     * 
     * @param assertion the given assertion
     * @return the object (value) of the given assertion
     */
    public static Element getObject(Assertion assertion) {
        if (assertion instanceof TypeAssertion) {
        	return ((TypeAssertion)assertion).getType();
        } else if (assertion instanceof PropertyValueAssertion) {
        	return ((PropertyValueAssertion)assertion).getValue();
        }
        return null;
    }

    /**
     * Gets the source instance of the given relation value (link) assertion 
     * 
     * @param assertion the given property value assertion
     * @return the source instance
     */
    public static NamedInstance getSource(PropertyValueAssertion assertion) {
        return (NamedInstance) getAssertingInstance(assertion);
    }
    
    /**
     * Gets the target instance of the given relation value (link) assertion 
     * 
     * @param assertion the given link assertion
     * @return the target instance
     */
    public static NamedInstance getTarget(PropertyValueAssertion assertion) {
        return assertion.getNamedInstanceValue();
    }
    
    //-------------------------------------------------
    // LITERALS
    //-------------------------------------------------
    
    /**
     * Gets the lexical value of the given literal
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
     * Gets the string value of the given literal
     * 
     * @param literal the given literal
     * @return the string value of the given literal
     */
    public static String getStringValue(Literal literal) {
        Object value = getValue(literal);
        return (value != null) ? value.toString() : "";
    }
    
    /**
     * Gets the value of the given literal
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
     * Gets the iri of the given literal's type
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
    
    /**
     * Gets the type of the given literal
     * 
     * @param literal the given literal
     * @return the scalar type of the given literal
     */
    public static Scalar getType(Literal literal) {
    	String iri = getTypeIri(literal);
    	return (Scalar) getMemberByIri(literal.eResource().getResourceSet(), iri);
    }
}