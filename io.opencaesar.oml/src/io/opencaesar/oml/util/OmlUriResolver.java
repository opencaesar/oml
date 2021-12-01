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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

/**
 * The <B>Resolver</B> for OML ontology URIs
 * 
 * @author elaasar
 */
final class OmlUriResolver {

    /*
     * The singleton instance of the class
     */
    private static OmlUriResolver instance;
    
    private Thread thread;
    private boolean doStop = false;
    private WatchService watcher;
    private Map<WatchKey, File> watched;
    private Map<URI, Map<String, URI>> importCache;
    private Map<URI, OmlCatalog> catalogCache;
    private URIConverter uriConverter;
    
    private OmlUriResolver() {
    	uriConverter = new ExtensibleURIConverterImpl();
        activate();
    }
    
    public static OmlUriResolver getInstance() {
    	if (instance == null) {
    		instance = new OmlUriResolver();
    	}
    	return instance;
    }
    
    /**
     * Activates the resolver's thread
     */
    protected void activate() {
        if (thread == null) {
            try {
                catalogCache = new HashMap<>();
                importCache = new HashMap<>();
                watcher = FileSystems.getDefault().newWatchService();
                watched = new HashMap<>();
                thread = new Thread(new Monitor(), "Oml Uri Resolver");
                thread.setDaemon(true);
                thread.start();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
    
    /**
     * Deactivates the resolver's thread
     */
    protected void deactivate() {
        if (thread != null) {
	        try {
	            doStop = true;
	            thread.interrupt();
	            thread = null;
	            watched = null;
	            watcher.close();
	            clearCache();
	        } catch (IOException e) {
	            System.err.println(e);
	        }
        }
    }
    
    /**
     * Clears the import and catalog caches of the resolver
     */
    protected void clearCache() {
    	if (importCache != null) {
    		importCache.clear();
    	}
    	if (catalogCache != null) {
    		catalogCache.clear();
    	}
    }
    
    private File toFile(URI uri) {
        URI localUri = CommonPlugin.asLocalURI(uri);
        return (localUri != null && localUri.isFile()) ? new File(localUri.toFileString()) : null;
    }
    
    private boolean exists(ResourceSet rs, URI uri) {
        try {
            if (rs.getResource(uri, false) != null) {
                return true;
            }
            final URIConverter uriConverter = rs.getURIConverter();
            if (uriConverter != null && uriConverter.exists(uri, rs.getLoadOptions())) {
                return rs.getResource(uri, true) != null;
            }
            return false;
        } catch(Throwable t) {
            return false;
        }
    }
    
    /**
     * Resolves the given logical IRI in context of the given resource 
     * 
     * @param contextResource The resource that is the context of resolution
     * @param iri The logical IRI to resolve
     * @return The resolved physical URI
     */
    public synchronized URI resolve(Resource contextResource, String iri) {
        URI contextUri = (contextResource != null) ? contextResource.getURI() : null;
        if (contextUri == null) {
            return null;
        }
        
        URI folderUri = contextUri.trimSegments(1);
        
        Map<String, URI> importMap = importCache.get(folderUri);
        if (importMap == null) {
            importCache.put(folderUri, importMap = new HashMap<>());
        }
        
        if (importMap.containsKey(iri)) {
            return importMap.get(iri);
        }
        
        final URI resolvedUri = resolveFromCatalog(contextResource.getResourceSet(), folderUri, iri);
        
        if (resolvedUri != null) {
            importMap.put(iri, resolvedUri);
        }
        
        return resolvedUri;
    }
    
	private URI resolveFromCatalog(ResourceSet rs, URI folderUri, String iri) {
        OmlCatalog catalog = findCatalog(folderUri);
        if (catalog == null) {
            return null;
        }
                
        final String resolved;
        try {
            resolved = catalog.resolveURI(iri);
            if (resolved == null) {
                return null;
            }
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
        
        URI resolvedUri = URI.createURI(resolved+'.'+OmlConstants.OML_EXTENSION);
        if (!exists(rs, resolvedUri)) {
            resolvedUri = URI.createURI(resolved+'.'+OmlConstants.OMLXMI_EXTENSION);
            if (!exists(rs, resolvedUri)) {
                resolvedUri = URI.createURI(resolved);
                if (!exists(rs, resolvedUri)) {
                    return null;
                }
            }
        }
        
        return resolvedUri;
    }
    
   public synchronized Set<URI> getResolvableUris(Resource contextResource) {
		final var uris = new LinkedHashSet<URI>();
		
		// add the URIs from the current resource set
		contextResource.getResourceSet().getResources().forEach(r -> uris.add(r.getURI()));
		uris.removeIf(uri -> !OmlConstants.OML_EXTENSION.equals(uri.fileExtension()));
		
		// retain only OML files

		// get the context URI
        URI contextUri = (contextResource != null) ? contextResource.getURI() : null;
        if (contextUri == null) {
            return Collections.emptySet();
        }

        // get the folder URI of the context
        URI folderUri = contextUri.trimSegments(1);

        // get the catalog being used with the context
        OmlCatalog catalog = findCatalog(folderUri);
        if (catalog == null) {
            return Collections.emptySet();
        }
		
        // final all file paths specified in the catalog
        var extensions = Collections.singletonList(OmlConstants.OML_EXTENSION);
		uris.addAll(catalog.getFileUris(extensions));
		
		// remove the context URI
		uris.remove(contextUri);
		
		return uris;
	}
    
    public boolean isUriMappedByCatalog(URI uri) {
        // get the folder URI of the context
        URI folderUri = uri.trimSegments(1);

        // get the catalog being used with the context
        OmlCatalog catalog = findCatalog(folderUri);
        if (catalog == null) {
            return false;
        }
        
        for (URI rewriteURI : catalog.getRewriteUris()) {
        	if (uri.toString().startsWith(rewriteURI.toString())) {
        		return true;
        	}
        }
        
        return false;
    }

    public OmlCatalog findCatalog(URI folderUri) {
        OmlCatalog catalog = null;
        final List<URI> folderUris = new ArrayList<>();
        while (catalog == null  && folderUri.segmentCount() > 0) {
        	catalog = catalogCache.get(folderUri);
        	if (catalog == null) {
        		folderUris.add(folderUri);
        		catalog = getCatalog(folderUri);
        	}
            folderUri = folderUri.trimSegments(1);
        };
        for (URI uri : folderUris) {
        	catalogCache.put(uri, catalog);
        	File folder = toFile(uri);
            try {
                WatchKey key = folder.toPath().register(watcher, 
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE, 
                        StandardWatchEventKinds.ENTRY_MODIFY);
                watched.put(key, folder);
            } catch (IOException e) {
                break;
            }
        };
        return catalog;
    }
    
    private OmlCatalog getCatalog(URI folderUri) {
        try {
            URI catalogUri = folderUri.appendSegment("catalog.xml");
        	if  (uriConverter.exists(catalogUri, null)) {
                return OmlCatalog.create(catalogUri);
        	}
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
    
    private class Monitor implements Runnable {
	    @Override
	    public void run() {
	        while (!doStop) {
	            WatchKey key;
	            try {
	                key = watcher.take();
	            } catch (InterruptedException x) {
	                return;
	            }
	            
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
	                    importCache.clear();
	                    catalogCache.clear();
	                } else if (file.exists()) {
	                    importCache.clear();
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
