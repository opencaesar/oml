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
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnonymousInstance;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarEquivalenceAxiom;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializableProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.UnreifiedRelation;
import io.opencaesar.oml.Vocabulary;

/**
 * The <b>Read</b> API for the model. It complements the OML getter API by additional utilities.
 *  
 * @author elaasar
 */
public final class OmlRead {

    /**
     * The standard ontology namespaces
     */
    private static final String XSD_NS = "http://www.w3.org/2001/XMLSchema#";
    private static final String RDF_NS = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    private static final String RDFS_NS = "http://www.w3.org/2000/01/rdf-schema#";
    private static final String OWL_NS = "http://www.w3.org/2002/07/owl#";
    private static final String SWRLB_NS = "http://www.w3.org/2003/11/swrlb#";

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
    @SuppressWarnings("unchecked")
	public static <V, T extends V> Collection<T> closure(V root, boolean includeRoot, Function<V, Collection<T>> recursive) {
        final Set<T> results = new LinkedHashSet<>();
        if (includeRoot) {
        	try {
        		results.add((T)root);
        	} catch (ClassCastException e) {
        		// IGNORE
        	}
        }
        closure(root, results, recursive);
        return results;
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
    private static <V, T extends V> void closure(V root, Set<T> cache, Function<V, Collection<T>> recursive) {
    	Collection<T> results = recursive.apply(root);
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
    public static <T, V extends T> boolean isInClosure(T item, V root, boolean includeRoot, Function<T, Collection<T>> recursive) {
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
    private static <V, T extends V> boolean isInClosure(T item, V root, Set<T> cache, Function<V, Collection<T>> recursive) {
    	Collection<T> results = recursive.apply(root);
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
    // URIs
    //-------------------------------------------------
    
    /**
     * Determines whether the given URI can be resolved to an OML resource in the workspace
     * 
     * @param uri the given URI
     * @return True if the given URI can be resolved, otherwise False
     */
    public static boolean isResolvedUri(URI uri) {
        if (Arrays.asList(OmlConstants.OML_EXTENSIONS).contains(uri.fileExtension())) {
        	return OmlUriResolver.getInstance().isResolvedUri(uri);
        }
        return false;
    }

    /**
     * Gets a URI that is resolved by the given IRI in the context of the given physical URI.
     * 
     * @param context The physical URI to use as context of URI resolution
     * @param iri The IRI to resolve
     * @return The resolved URI
     */
    public static URI getResolvedUri(URI context, String iri) {
        if (context == null || iri == null || iri.isEmpty()) {
            return null;
        }
        return OmlUriResolver.getInstance().resolveUri(context, iri);
    }

    /**
     * Gets a URI that is resolved by the given IRI in the context of the given OML resource.
     * 
     * @param context The OML resource to use as context of URI resolution
     * @param iri The IRI to resolve
     * @return The resolved URI
     */
    public static URI getResolvedUri(Resource context, String iri) {
        if (context == null || iri == null || iri.isEmpty()) {
            return null;
        }
        return OmlUriResolver.getInstance().resolveUri(context, iri);
    }
    
    /**
     * Gets the URIs that can be resolved in the context of the given OML resource
     * 
     * @param context the context resource
     * @return a set of resource URIs that are resolvable from the given resource
     */
    public static Set<URI> getResolvedUris(Resource context) {
        if (context == null) {
            return Collections.emptySet();
        }
        return OmlUriResolver.getInstance().getResolvedUris(context);
    }
    
    /**
     * Gets a logical IRI that is deresolved from the given file URI.
     * 
     * @param fileUri The file URI to deresolve
     * @return The deresolved logical IRI
     */
    public static URI getDeresolvedIri(URI fileUri) {
        if (fileUri == null) {
            return null;
        }
        return OmlUriResolver.getInstance().deresolveUri(fileUri);
    }

    //-------------------------------------------------
    // Ontologies
    //-------------------------------------------------

    /**
     * Gets the ontology loaded in the given OML resource (if one exists)
     * 
     * @param resource The OML resource to get the ontology of
     * @return An ontology if one exists in the given resource; otherwise null
     */
    public static Ontology getOntology(Resource resource) {
        return resource.getContents().stream()
            .filter(o -> o instanceof Ontology)
            .map(o -> (Ontology)o)
            .findFirst()
            .orElse(null);
    }
    
    /*
     * Gets stream of ontologies loaded in the given resource set 
     * 
     * @param resourceSet The resource set to look for ontologies in 
     * @return A stream of ontologies in the given resource set
     */
    private static Stream<Ontology> getOntologyStream(ResourceSet resourceSet) {
        return resourceSet.getResources().stream()
            .map(r -> getOntology(r))
            .filter(Objects::nonNull);
    }

    /**
     * Gets all ontologies loaded in the given resource set 
     * 
     * @param resourceSet The resource set to look for ontologies in 
     * @return The list of ontologies loaded in the given resource set
     */
    public static List<Ontology> getOntologies(ResourceSet resourceSet) {
        return getOntologyStream(resourceSet)
            .collect(Collectors.toList());
    }
    
    /**
     * Gets an ontology with the given IRI loaded in the given resource set
     *  
     * @param resourceSet The resource set to look for an ontology in
     * @param iri The IRI of the ontology
     * @return an ontology with the given IRI if found; otherwise null
     */
    public static Ontology getOntologyByIri(ResourceSet resourceSet, String iri) {
        return getOntologyStream(resourceSet)
            .filter(o -> iri.equals(o.getIri()))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Gets an ontology with the given prefix loaded in the given resource set
     * 
     * If more than one ontology has the same prefix, the first found is returned
     *  
     * @param resourceSet The resource set to look for an ontology in
     * @param prefix The prefix of the ontology
     * @return an ontology with the given prefix if found; otherwise null
     */
    public static Ontology getOntologyByPrefix(ResourceSet resourceSet, String prefix) {
        return getOntologyStream(resourceSet)
            .filter(o -> prefix.equals(o.getPrefix()))
            .findFirst()
            .orElse(null);
    }

    /**
     * Gets an ontology with the given IRI that can be resolved in the context of the given resource
     * 
     * This will cause the ontology's resource to load if not already loaded
     * 
     * @param context The resource to use as context of IRI resolution
     * @param iri The IRI of the ontology to get
     * @return an ontology with the given IRI
     */
    public static Ontology getOntologyByResolvingIri(Resource context, String iri) {
    	var uri = getResolvedUri(context, iri);
    	if (uri == null) {
    		return null;
    	}
    	var resource = context.getResourceSet().getResource(uri, true);
		return getOntology(resource);
    }

    /**
     * Gets the ontologies directly imported by a given ontology
     * 
     * This will cause an imported ontology's resource to load if not already loaded
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
     * Gets an ontology directly imported by a given ontology using the given IRI
     * 
     * This will cause an imported ontology's resource to load if not already loaded
     * 
     * @param ontology the context ontology
     * @param iri the IRI of the imported ontology
     * @return an ontology that is imported by the given IRI; otherwise null 
     */
    public static Ontology getImportedOntologyByIri(Ontology ontology, String iri) {
        return ontology.getOwnedImports().stream()
            .filter(i -> iri.equals(i.getIri()))
            .map(i -> getImportedOntology(i))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Gets an ontology directly imported by a given ontology using the given prefix
     * 
     * This will cause an imported ontology's resource to load if not already loaded
     * 
     * @param ontology the context ontology
     * @param prefix the prefix of the imported ontology
     * @return an ontology that is imported by the given prefix; otherwise null 
     */
    public static Ontology getImportedOntologyByPrefix(Ontology ontology, String prefix) {
        return ontology.getOwnedImports().stream()
                .filter(i -> prefix.equals(i.getPrefix()))
                .map(i -> getImportedOntology(i))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Gets the ontologies directly or transitively imported by the given ontology
     * 
     * This will cause an imported ontology's resource to load if not already loaded
     * 
     * @param ontology the given ontology
     * @param inclusive whether the given ontology should be included in the closure
     * @return a collection of ontologies directly or transitively imported by the given ontology
     */
    public static Collection<Ontology> getImportedOntologyClosure(Ontology ontology, boolean inclusive) {
        return closure(ontology, inclusive, i -> getImportedOntologies(i));
    }

    /**
     * Gets loaded ontologies that directly import the given ontology
     * 
     * @param ontology the given ontologies
     * @return a collection of ontologies that import the given ontology directly
     */
    public static Collection<Ontology> getImportingOntologies(Ontology ontology) {
        var resourceSet = ontology.eResource().getResourceSet();
        return OmlRead.getOntologies(resourceSet).stream()
            	.filter(i -> getImportNamespaceToPrefixMap(i).containsKey(ontology.getIri()))
            	.collect(Collectors.toSet());
    }

    /**
     * Gets the set of resources that represent the import scope of the given ontology
     * 
     * This will cause an imported ontology's resource to load if not already loaded
     * 
     * @param ontology the given ontology
     * @return a collection of resources that represent the import scope of the given ontology
     */
    public static Set<Resource> getImportScope(Ontology ontology) {
        return getImportedOntologyClosure(ontology, true).stream().map(o -> o.eResource()).collect(Collectors.toSet());
    }

    /**
     * Gets the ontology that is imported by the given import
     * 
     * This will cause an imported ontology's resource to load if not already loaded
     * 
     * @param _import the given import
     * @return the ontology that is imported by the given import (or null if the import resolution failed)
     */
    public static Ontology getImportedOntology(Import _import) {
        if (_import.getIri() == null || _import.getIri().isEmpty()) {
            return null;
        }
        var context = _import.eResource();
    	var uri = getResolvedUri(context, _import.getIri());
    	if (uri != null) {
    		ResourceSet rs = context.getResourceSet();
    		Resource r = rs.getResource(uri, false);
    		if ((r == null || !r.isLoaded()) && rs.getURIConverter().exists(uri, rs.getLoadOptions())) {
	    		try {
	    			r = rs.getResource(uri, true);
	    		} catch (Exception e) {
	    			System.err.println(e);
	    		}
    		}
	        if (r != null) {
	        	return getOntology(r);
	        }
    	}
		return null;
    }
    
    /**
     * Gets the ontology that owns the given import
     * 
     * @param _import the given import
     * @return the ontology that defines the given import
     */
    public static Ontology getImportingOntology(Import _import) {
        return _import.getOwningOntology();
    }
    
    /**
     * Gets a map from import namespaces to import prefixes in the given ontology
     * 
     * @param ontology the given ontology
     * @return a map from import namespaces to import prefixes 
     */
    public static Map<String, String> getImportNamespaceToPrefixMap(Ontology ontology) {
        final Map<String, String> map = new LinkedHashMap<>();
        ontology.getOwnedImports().stream()
        	.filter(i -> i.getPrefix() != null)
        	.forEach(i -> map.put(i.getNamespace(), i.getPrefix()));
        return map;
    }
    
    /**
     * Gets a map from import prefixes to import namespaces in the given ontology
     * 
     * @param ontology the given ontology
     * @return a map from import prefixes to import namespaces 
     */
    public static Map<String, String> getImportPrefixToNamespaceMap(Ontology ontology) {
        final Map<String, String> map = new LinkedHashMap<>();
        ontology.getOwnedImports().stream()
        	.filter(i -> i.getPrefix() != null)
        	.forEach(i -> map.put(i.getPrefix(), i.getNamespace()));
        return map;
    }

    //-------------------------------------------------
    // Members
    //-------------------------------------------------

    /**
     * Gets all members defined in the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of all members defined in the given ontology
     */
    public static List<Member> getMembers(Ontology ontology) {
    	Function<Member, Stream<Member>> allMembers = (i) -> {
            var stream = Stream.of(i);
    		if (i instanceof RelationEntity) {
    			var entity = (RelationEntity)i;
    			if (entity.getForwardRelation() != null) {
    				stream = Stream.concat(stream, Stream.of(entity.getForwardRelation()));
    			}
            }
    		if (i instanceof RelationBase) {
    			var base = (RelationBase)i;
    			if (base.getReverseRelation() != null) {
    				stream = Stream.concat(stream, Stream.of(base.getReverseRelation()));
    			}
            }
    		return stream;
    	};
        return getStatements(ontology).stream()
        		.filter(i -> !i.isRef())
        		.flatMap(i -> allMembers.apply(i))
        		.collect(Collectors.toList());
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
     * Gets a member with the given IRI defined by the given ontology or its direct imports
     * 
     * @param ontology the given ontology
     * @param iri the IRI of the member
     * @return a member with the given IRI if found; otherwise null
     */
    public static Member getMemberByIri(Ontology ontology, String iri) {
        String[] iriParts = parseIri(iri);
        String baseIri = iriParts[0];
        String fragment = iriParts[1];
        Ontology baseOntology = ontology.getIri().equals(baseIri)
            ? ontology
            : getImportedOntologyByIri(ontology, baseIri);
        return (baseOntology != null) ? getMemberByName(baseOntology, fragment) : null;
    }
    
    /**
     * Gets a member with the given IRI in the given resource set
     *  
     * @param resourceSet The resource set to look for an ontology in
     * @param iri The IRI of the member
     * @return a member with the given IRI if found; otherwise null
     */
    public static Member getMemberByIri(ResourceSet resourceSet, String iri) {
        String[] iriParts = parseIri(iri);
        String baseIri = iriParts[0];
        String fragment = iriParts[1];
        Ontology baseOntology = getOntologyByIri(resourceSet, baseIri);
        return (baseOntology != null) ? getMemberByName(baseOntology, fragment) : null;
    }

    /**
     * Gets a member with the given abbreviated IRI defined by the given ontology or its direct imports
     * 
     * @param ontology the given ontology
     * @param iri the abbreviated IRI of the member
     * @return a member with the given abbreviated IRI if found; otherwise null
     */
    public static Member getMemberByAbbreviatedIri(Ontology ontology, String iri) {
        String[] iriParts = parseAbbreviatedIri(iri);
        String prefix = iriParts[0];
        String fragment = iriParts[1];
        Ontology baseOntology =  ontology.getPrefix().equals(prefix)
            ? ontology
        	: getImportedOntologyByPrefix(ontology, prefix);
        return (baseOntology != null) ? getMemberByName(baseOntology, fragment) : null;
    }

    /**
     * Gets a member with the given abbreviated IRI in the given resource set
     *  
     * @param resourceSet The resource set to look for an ontology in
     * @param iri The abbreviated IRI of the member
     * @return a member with the given abbreviated IRI if found; otherwise null
     */
    public static Member getMemberByAbbreviatedIri(ResourceSet resourceSet, String iri) {
        String[] iriParts = parseAbbreviatedIri(iri);
        String prefix = iriParts[0];
        String fragment = iriParts[1];
        Ontology baseOntology = getOntologyByPrefix(resourceSet, prefix);
        return (baseOntology != null) ? getMemberByName(baseOntology, fragment) : null;
    }
    
    /**
     * Gets a member with the given IRI that can be resolved in the context of the given resource
     * 
     * This will cause the member's ontology resource to load if not already loaded
     * 
     * @param context The resource to look for the member in
     * @param iri The IRI of the member
     * @return A member if one exists with the given IRI; otherwise null
     */
    public static Member getMemberByResolvingIri(Resource context, String iri) {
        String[] iriParts = parseIri(iri);
        String baseIri = iriParts[0];
        String fragment = iriParts[1];
        final Ontology baseOntology = getOntologyByResolvingIri(context, baseIri);
        return (baseOntology != null) ? getMemberByName(baseOntology, fragment) : null;
    }
    
    //-------------------------------------------------
    // ONTOLOGY/MEMBERS
    //-------------------------------------------------
    
    /**
     * Gets the prefix of a given ontology in a given context ontology
     * 
     * If both ontologies are the same, the ontology's prefix will be returned; 
     * otherwise if the ontology is imported, its import prefix will be returned if specified;
     * otherwise null will be returned.
     * 
     * @param ontology the given ontology
     * @param context the context ontology
     * @return ontology's prefix in context or null
     */
    public static String getPrefixIn(Ontology ontology, Ontology context) {
        if (ontology == context) {
            return context.getPrefix();
        } else {
            return getImportNamespaceToPrefixMap(context).get(ontology.getNamespace());
        }
    }
       
    /**
     * Gets the abbreviated IRI of the given member in the given context ontology
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
     * Gets all statements of the given ontology
     * 
     * @param ontology the given ontology
     * @return a list of all statements of the given ontology
     */
    public static List<Statement> getStatements(Ontology ontology) {
        if (ontology instanceof Vocabulary) {
            return ((Vocabulary)ontology).getOwnedStatements().stream()
            	.map(i -> (Statement)i)
            	.collect(Collectors.toList());
        } else if (ontology instanceof Description) {
            return ((Description)ontology).getOwnedStatements().stream()
	        	.map(i -> (Statement)i)
	        	.collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
    
    /**
     * Gets all refs defined in a given ontology
     * 
     * @param ontology the given ontology
     * @return a list of all refs defined in the given ontology
     */
    public static List<Member> getRefs(Ontology ontology) {
        return getStatements(ontology).stream()
            .filter(s -> s.isRef())
            .collect(Collectors.toList());
    }
    
    /*
     * Gets all annotations that references the given property on the given element
     * 
     * @param element The element that has the annotation
     * @param property the given annotation property
     * @return a list of annotations referencing the annotation property on the element
     */
    private static Stream<Annotation> getAnnotations(IdentifiedElement element, AnnotationProperty property) {
        return element.getOwnedAnnotations().stream()
            .filter(a -> a.getProperty() == property);
    }

    /**
     * Gets the values of a given annotation property in the given element
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return a list of annotation values
     */
    public static List<Element> getAnnotationValues(IdentifiedElement element, AnnotationProperty property) {
        return getAnnotations(element, property)
            .flatMap(a -> a.getValues().stream())
            .collect(Collectors.toList());
    }
    
    /**
     * Gets the first literal value of a given annotation property in the given element
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return an annotation literal value
     */
    public static Literal getAnnotationLiteralValue(IdentifiedElement element, AnnotationProperty property) {
        return getAnnotations(element, property)
            .filter(a -> !a.getLiteralValues().isEmpty())
            .flatMap(a -> a.getLiteralValues().stream())
            .findFirst()
            .orElse(null);
    }

    /**
     * Determines whether the given element is annotated with the given annotation property
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return true if the element is annotated with the given annotation property; otherwise false
     */
    public static boolean isAnnotatedBy(IdentifiedElement element, AnnotationProperty property) {
        return !getAnnotations(element, property).findAny().isEmpty();
    }

    /**
     * Gets the first referenced value of a given annotation property in the given element
     * 
     * @param element The given element
     * @param property the given annotation property
     * @return an annotation reference value
     */
    public static Member getAnnotationReferencedValue(IdentifiedElement element, AnnotationProperty property) {
        return getAnnotations(element, property)
            .filter(a -> !a.getReferencedValues().isEmpty())
            .flatMap(a -> a.getReferencedValues().stream())
            .findFirst()
            .orElse(null);
    }

    //-------------------------------------------------
    // VOCABULARY MEMBERS
    //-------------------------------------------------

    /**
     * Gets the super terms of the given term
     * 
     * @param term the give term
     * @return a list of specialization super terms of the given term
     */
    public static List<Term> getSuperTerms(Term term) {
    	var supers = new ArrayList<Term>();
        supers.addAll(getSpecializationSuperTerms(term));
        if (term instanceof Entity) {
            supers.addAll(getEquivalenceSuperEntities((Entity)term));
        } else if (term instanceof Scalar) {
            supers.addAll(getEquivalenceSuperScalars((Scalar)term));
        } else if (term instanceof Property) {
            supers.addAll(getEquivalenceSuperProperties((Property)term));
        }
        return supers;
    }

    /**
     * Gets the specialization super terms of the given term
     * 
     * @param term the give term
     * @return a list of specialization super terms of the given term
     */
    public static List<Term> getSpecializationSuperTerms(Term term) {
    	var supers = new ArrayList<Term>();
    	if (term instanceof SpecializableTerm) {
	    	supers.addAll(((SpecializableTerm)term).getOwnedSpecializations().stream()
		            .filter(i -> i.getSuperTerm() != null)
		            .map(i -> i.getSuperTerm())
		            .collect(Collectors.toList()));
    	} else  if (term instanceof ForwardRelation) {
        	var entity = ((ForwardRelation)term).getRelationEntity();
    		supers.addAll(getSpecializationSuperTerms(entity).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toList()));
    	} else if (term instanceof ReverseRelation) {
        	var base = ((ReverseRelation)term).getRelationBase();
    		supers.addAll(getSpecializationSuperTerms(base).stream()
    	        .filter(i -> i instanceof RelationBase)
	            .map(i -> (RelationBase)i)
	            .filter(i -> i.getReverseRelation() != null)
	            .map(i -> i.getReverseRelation())
	            .collect(Collectors.toList()));
    	}
    	return supers;
   }
    
    /**
     * Gets the equivalence super entities of the given entity
     * 
     * @param entity the given entity
     * @return a list of equivalence super entities of the given entity
     */
    public static List<Entity> getEquivalenceSuperEntities(Entity entity) {
        return entity.getOwnedEquivalences().stream()
	            .flatMap(i -> i.getSuperEntities().stream())
	            .collect(Collectors.toList());
    }

    /**
     * Gets the equivalence super scalars of the given scalar
     * 
     * @param scalar the given scalar
     * @return a list of equivalence super scalars of the given scalar
     */
    public static List<Scalar> getEquivalenceSuperScalars(Scalar scalar) {
        return scalar.getOwnedEquivalences().stream()
	            .map(i -> i.getSuperScalar())
	            .collect(Collectors.toList());
    }

    /**
     * Gets the equivalence super properties of the given property
     * 
     * @param property the given property
     * @return a list of equivalence super properties of the given property
     */
    public static List<Property> getEquivalenceSuperProperties(Property property) {
    	var supers = new ArrayList<Property>();
    	if (property instanceof SpecializableProperty) {
	        supers.addAll(((SpecializableProperty)property).getOwnedEquivalences().stream()
		            .map(i -> i.getSuperProperty())
		            .collect(Collectors.toList()));
    	} else if (property instanceof ForwardRelation) {
    		var entity = ((ForwardRelation)property).getRelationEntity();
    		supers.addAll(getEquivalenceSuperEntities(entity).stream()
    	        .filter(i -> i instanceof RelationEntity)
	            .map(i -> (RelationEntity)i)
	            .filter(i -> i.getForwardRelation() != null)
	            .map(i -> i.getForwardRelation())
	            .collect(Collectors.toList()));
    	} else if (property instanceof ReverseRelation) {
    		var base = ((ReverseRelation)property).getRelationBase();
    		if (base instanceof RelationEntity) {
        		supers.addAll(getEquivalenceSuperEntities((RelationEntity)base).stream()
            	        .filter(i -> i instanceof RelationEntity)
        	            .map(i -> (RelationEntity)i)
        	            .filter(i -> i.getReverseRelation() != null)
    		            .map(i -> i.getReverseRelation())
    		            .collect(Collectors.toList()));
    		} else if (base instanceof UnreifiedRelation) {
        		supers.addAll(getEquivalenceSuperProperties((UnreifiedRelation)base).stream()
            	        .filter(i -> i instanceof UnreifiedRelation)
        	            .map(i -> (UnreifiedRelation)i)
        	            .filter(i -> i.getReverseRelation() != null)
    		            .map(i -> i.getReverseRelation())
			            .collect(Collectors.toList()));
    		}
    	}
    	return supers;
   }
    
    /**
     * Gets all the axioms specified on the given term
     * 
     * @param term the given term
     * @return a list of axioms specified on the given term
     */
    public static List<Axiom> getAxioms(SpecializableTerm term) {
        var axioms = new ArrayList<Axiom>();
        for (EObject object : term.eContents()) {
        	if (object instanceof Axiom) {
        		axioms.add((Axiom)object);
        	}
        }
        return axioms;
    }
        
    /**
     * Gets the number of facets defined on the given scalar equivalence axiom
     * 
     * @param axiom the given axiom
     * @return the number of facets defined on the given scalar equivalence axiom
     */
    public static int getNumberOfFacets(ScalarEquivalenceAxiom axiom) {
		int number = 0;
		if (axiom.getLanguage() != null) number++;
		if (axiom.getPattern() != null) number++;
	    if (axiom.getLength() != null) number++;
	    if (axiom.getMaxLength() != null) number++;
	    if (axiom.getMinLength() != null) number++;
	    if (axiom.getMaxExclusive() != null) number++;
	    if (axiom.getMaxInclusive() != null) number++;
	    if (axiom.getMinExclusive() != null) number++;
	    if (axiom.getMinInclusive() != null) number++;
		return number;
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

    /**
     * Determines if the given scalar is a standard one
     *  
     * @param scalar the given scalar
     * @return whether the scalar is standard
     */
    public static boolean isStandardScalar(Scalar scalar) {
    	var ontology = scalar.getOntology();
    	if (ontology != null) {
	    	var ontologyNs = ontology.getNamespace();
	    	return ontologyNs.equals(XSD_NS) ||
	            	ontologyNs.equals(RDF_NS) ||
	            	ontologyNs.equals(RDFS_NS) ||
	            	ontologyNs.equals(OWL_NS) ||
	            	ontologyNs.equals(SWRLB_NS);
    	}
    	return false;
    }

    //-------------------------------------------------
    // DESCRIPTION MEMBERS
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
            .flatMap(a -> a.getValues().stream())
            .collect(Collectors.toList());
    }
    
    /**
     * Gets the first literal value of the given semantic property in the given instance
     * 
     * @param instance The given instance
     * @param property the given semantic property
     * @return a literal representing the property's literal value
     */
    public static Literal getPropertyLiteralValue(Instance instance, SemanticProperty property) {
        return getPropertyValues(instance, property).stream()
        	.filter(i -> i instanceof Literal)
        	.map(i -> (Literal)i)
            .findFirst()
            .orElse(null);
    }

    /**
     * Gets the first contained value of the given semantic property in the given instance
     * 
     * @param instance The given instance
     * @param property the given property
     * @return an anonymous instance representing the property's contained value
     */
    public static AnonymousInstance getPropertyContainedValue(Instance instance, SemanticProperty property) {
        return getPropertyValues(instance, property).stream()
        	.filter(i -> i instanceof AnonymousInstance)
        	.map(i -> (AnonymousInstance)i)
            .findFirst()
            .orElse(null);
    }

    /**
     * Gets the first referenced value of the given semantic property in the given instance
     * 
     * @param instance The given instance
     * @param property the given property
     * @return a named instance representing the relation's referenced value
     */
    public static NamedInstance getPropertyReferencedValue(Instance instance, SemanticProperty property) {
        return getPropertyValues(instance, property).stream()
        	.filter(i -> i instanceof NamedInstance)
        	.map(i -> (NamedInstance)i)
            .findFirst()
            .orElse(null);
    }

    /**
     * Gets the types declared on the given instance
     * 
     * @param instance the given instance
     * @return a list of types of the given element
     */
    public static List<Entity> getTypes(Instance instance) {
       var types = new ArrayList<Entity>();
        if (instance instanceof AnonymousInstance) {
            types.addAll(instance.getTypes());
        } else if (instance instanceof NamedInstance) {
            types.addAll(((NamedInstance)instance).getOwnedTypes().stream().
                map(i -> i.getType()).
                collect(Collectors.toList()));
        }
        return types;
    }

    //-------------------------------------------------
    // LITERALS
    //-------------------------------------------------
    
    /**
     * Gets the Java Object value of the given literal
     * 
     * @param literal The given literal
     * @return Object representing value of literal
     */
    public static Object getJavaValue(Literal literal) {
    	if (literal instanceof QuotedLiteral) {
            var value = ((QuotedLiteral)literal).getValue();
    		var typeIri = literal.getTypeIri();
            if (value != null && typeIri != null) {
                if (typeIri.equals(XSD_NS+"string")) {
                    return value;
                } else if (typeIri.equals(XSD_NS+"integer")) {
                    return Integer.valueOf(value);
                } else if (typeIri.equals(XSD_NS+"decimal")) {
                    return new BigDecimal(value);
                } else if (typeIri.equals(XSD_NS+"real")) {
                    return Double.valueOf(value);
                } else if (typeIri.equals(XSD_NS+"double")) {
                    return Double.valueOf(value);
                } else if (typeIri.equals(XSD_NS+"float")) {
                    return Float.valueOf(value);
                } else if (typeIri.equals(XSD_NS+"boolean")) {
                    return Boolean.valueOf(value);
                } else if (typeIri.equals(XSD_NS+"dateTime")) {
                	try {
                		return new SimpleDateFormat().parse(value);
                	} catch(Exception e) {
                        throw new DateTimeParseException("Error parsing xsd:dateTime", value, 0);
                	}
                }
            }
            return value;
    	} else {
    		return literal.getValue();
    	}
    }

    /**
     * Gets the type of the given literal
     * 
     * @param literal the given literal
     * @return the scalar type of the given literal
     */
    public static Scalar getType(Literal literal) {
    	String iri = literal.getTypeIri();
    	return (Scalar) getMemberByIri(literal.eResource().getResourceSet(), iri);
    }
    
    /**
     * Determins if the two given literals are equal
     * @param literal1 the first given literal
     * @param literal2 the second given literal
     * @return true if equivalent; otherwise false
     */
    public static boolean isEqual(Literal literal1, Literal literal2) {
    	if (literal1 == literal2)
    		return true;
    	if (literal1 == null || literal2 == null)
    		return false;
    	var s1 = literal1.getStringValue()+"_"+literal1.getTypeIri()+"_"+
    			((literal1 instanceof QuotedLiteral) ? ((QuotedLiteral)literal1).getLangTag() : "");
    	var s2 = literal2.getStringValue()+"_"+literal2.getTypeIri()+"_"+
    			((literal2 instanceof QuotedLiteral) ? ((QuotedLiteral)literal2).getLangTag() : "");
    	return s1.equals(s2);
    }

}