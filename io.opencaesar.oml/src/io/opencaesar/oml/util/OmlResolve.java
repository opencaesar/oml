/**
 * 
 * Copyright 2019-2021 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *	  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package io.opencaesar.oml.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

import io.opencaesar.oml.Ontology;

/**
 * The <b>Resolve</b> API for Oml models.
 * 
 * @author elaasar
 */
public class OmlResolve {

	private static Map<WatchKey, File> watched = new HashMap<>();
	private static Map<URI, OmlCatalog> catalogCache = new HashMap<>();
	private static Map<OmlCatalog, Map<String, URI>> contextCache = new HashMap<>();
	private static WatchService watcher;
	
	static {
		try {
			watcher = FileSystems.getDefault().newWatchService();
		} catch (IOException e) {
			System.err.println(e);
		}

		// Activates the resolver's thread on load
		Thread thread = new Thread(new Monitor(), "Oml Uri Resolver");
		thread.setDaemon(true);
		thread.start();
	}
		
	/**
	 * Resolves an Oml file URI given an IRI in the context of the given resource 
	 * 
	 * @param contextResource The resource that is the context of resolution
	 * @param iri The given IRI
	 * @return The resolved URI
	 */
	public static synchronized URI resolveOmlFileUri(Resource contextResource, String iri) {
		URI resolvedUri = resolveOmlFileUri(contextResource.getURI(), iri);
		
		if (resolvedUri == null) {
			var rs = contextResource.getResourceSet();
			if (rs.getLoadOptions().get(OmlConstants.RESOLVE_IRI_USING_RESOURCE_SET) == Boolean.TRUE) {
				Ontology ontology = OmlRead.getOntologyByIri(rs, iri);
				if (ontology != null) {
					resolvedUri = ontology.eResource().getURI();
				}
			}
		}
		
		return resolvedUri;
	}

	/**
	 * Resolves an Oml file URI given an IRI in context of the given URI 
	 * 
	 * @param contextUri The context URI
	 * @param iri The IRI to resolve
	 * @return The resolved URI
	 */
	public static synchronized URI resolveOmlFileUri(URI contextUri, String iri) {
		try {
			OmlCatalog catalog = getCatalog(contextUri);
			
			Map<String, URI> resolveMap = contextCache.get(catalog);
			if (resolveMap == null) {
				contextCache.put(catalog, resolveMap = new HashMap<>());
			}
			
			if (resolveMap.containsKey(iri)) {
				return resolveMap.get(iri);
			}
	
			URI resolvedUri = resolveUri(contextUri, iri);
			
			if (resolvedUri != null) {
				for (String extension : OmlConstants.OML_EXTENSIONS) {
					URI resolvedUriWithExt = resolvedUri.appendFileExtension(extension);
					if (exists(resolvedUriWithExt)) {
						//resolveMap.put(iri, resolvedUriWithExt);
						return resolvedUriWithExt;
					}
				}
		
				if (exists(resolvedUri)) {
					//resolveMap.put(iri, resolvedUri);
					return resolvedUri;
				} 
			}
			
			//resolveMap.put(iri, null);
			return null;
		} catch(Exception e) {
			System.out.print(e);
			return null;
		}
	}
	
	/**
	 * Resolves a URI given an IRI in context of the given URI 
	 * 
	 * @param contextUri The context URI
	 * @param iri The IRI to resolve
	 * @return The resolved URI
	 */
	public static synchronized URI resolveUri(URI contextUri, String iri) {
		try {
			OmlCatalog catalog = getCatalog(contextUri);
			if (catalog != null) {
				return catalog.resolveUri(iri);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	/**
	 * Deresolves the given Oml file URI to an IRI 
	 * 
	 * @param fileUri The file URI to deresolve
	 * @return The deresolved logical IRI
	 */
	public static synchronized String deresolveOmlFileUri(URI fileUri) {
		if (OmlConstants.OML_EXTENSION_LIST.contains(fileUri.fileExtension())) {
			return deresolveUri(fileUri.trimFileExtension());
		}
		return null;
	}
	
	/**
	 * Deresolves the given URI to an IRI 
	 * 
	 * @param uri The URI to deresolve
	 * @return The deresolved IRI
	 */
	public static synchronized String deresolveUri(URI uri) {
		try {
			OmlCatalog catalog = getCatalog(uri);
			if (catalog != null) {
				return catalog.deresolveUri(uri);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	/**
	 * Checks whether the given Oml file URI is resolved by this catalog
	 *  
	 * @param fileUri The given file uri
	 * @return true if the uri is deresolvable by this catalog, false otherwise
	 */
	public static synchronized boolean isResolvedOmlFileUri(URI fileUri) {
		if (OmlConstants.OML_EXTENSION_LIST.contains(fileUri.fileExtension())) {
			return isResolvedUri(fileUri.trimFileExtension());
		}
		return false;
	}
	
	/**
	 * Checks whether the given URI is resolved by this catalog
	 *  
	 * @param uri The given uri
	 * @return true if the uri is deresolvable by this catalog, false otherwise
	 */
	public static synchronized boolean isResolvedUri(URI uri) {
		try {
			OmlCatalog catalog = getCatalog(uri);
			if (catalog != null) {
				return catalog.isResolvedUri(uri);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	/**
	 * Gets a list of Oml file URIs that can be resolved from the given context resource
	 * 
	 * @param contextResource The context resource
	 * @return a list of file URIs
	 */
	public static synchronized Set<URI> resolveOmlFileUris(Resource contextResource) {
		var uris = new HashSet<URI>();

		contextResource.getResourceSet().getResources().forEach(r -> uris.add(r.getURI()));
		uris.removeIf(uri -> !OmlConstants.OML_EXTENSION_LIST.contains((uri.fileExtension())));

		uris.addAll(resolveOmlFileUris(contextResource.getURI()));

		return uris;
	}

	/**
	 * Gets a list of Oml file URIs that can be resolved from the given context URI
	 * 
	 * @param contextUri The context URI
	 * @return a list of file URIs
	 */
	public static synchronized Set<URI> resolveOmlFileUris(URI contextUri) {
		try {
			OmlCatalog catalog = getCatalog(contextUri);
			if (catalog != null) {
				var uris = catalog.getResolvedFileUris();
				uris.removeIf(uri -> !OmlConstants.OML_EXTENSION_LIST.contains((uri.fileExtension())));
				return uris;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return Collections.emptySet();
	}

	//-------------------
	
	private static OmlCatalog getCatalog(URI contextUri) throws IOException {
		OmlCatalog catalog = null;

		final List<URI> directoryUris = new ArrayList<>();
		while (catalog == null  && contextUri.segmentCount() > 0) {
			catalog = catalogCache.get(contextUri);
			if (catalog == null) {
				directoryUris.add(contextUri);
				catalog = createCatalog(contextUri);
			}
			contextUri = contextUri.trimSegments(1);
		};

		
		for (URI uri : directoryUris) {
			catalogCache.put(uri, catalog);
			File file = toFile(uri);
			if (file != null && file.isDirectory()) {
				WatchKey key = file.toPath().register(watcher, 
						StandardWatchEventKinds.ENTRY_CREATE,
						StandardWatchEventKinds.ENTRY_DELETE, 
						StandardWatchEventKinds.ENTRY_MODIFY);
				watched.put(key, file);
			}
		};
		
		return catalog;
	}
	
	private static OmlCatalog createCatalog(URI folderUri) throws IOException {
		URI catalogUri = folderUri.appendSegment("catalog.xml");
		if  (exists(catalogUri)) {
			return OmlCatalog.create(catalogUri);
		}
		return null;
	}

	private static File toFile(URI uri) {
		URI localUri = CommonPlugin.asLocalURI(uri);
		var path = localUri.toFileString();
		return (path != null) ? new File(path) : null;
	}
	
	private static URIConverter uriConverter = new ExtensibleURIConverterImpl();

	private static boolean exists(URI uri) {
		return uriConverter.exists(uri, null);
	}

	private static class Monitor implements Runnable {
		@Override
		public void run() {
			while (true) {
				WatchKey key;
				try {
					key = watcher.take();
				} catch (InterruptedException x) {
					return;
				}
				
				synchronized(OmlResolve.class) {
					File folder = watched.get(key);
	
					for (WatchEvent<?> event : key.pollEvents()) {
						WatchEvent.Kind<?> kind = event.kind();
						
						if (kind == StandardWatchEventKinds.OVERFLOW) {
							continue;
						}
						
						@SuppressWarnings("unchecked")
						WatchEvent<Path> ev = (WatchEvent<Path>) event;
						Path fileName = ev.context();
						File file = folder.toPath().resolve(fileName).toFile();
						
						// Need a more precise way to clean the cache
						if (file.getName().equals("catalog.xml")) {
							contextCache.clear();
							catalogCache.clear();
						} else if (file.exists()) {
							contextCache.clear();
						}
					}
					
					boolean valid = key.reset();
					if (!valid) {
						watched.remove(key);
					}
				}
			}
		}
	}
	
}
