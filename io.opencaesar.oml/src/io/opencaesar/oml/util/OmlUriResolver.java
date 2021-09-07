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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogEntry;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

import com.google.common.io.Files;

/**
 * The <B>Resolver</B> for OML ontology URIs
 * 
 * @author elaasar
 */
final class OmlUriResolver implements Runnable {

    /*
     * The singleton instance of the class
     */
    private static OmlUriResolver instance = new OmlUriResolver();
    
    private static final List<String> OML_EXTENSIONS_LIST = Arrays.asList(OmlConstants.OML_EXTENSIONS);

    private Thread thread;
    private boolean doStop = false;
    private WatchService watcher;
    private Map<WatchKey, File> watched;
    
    private Map<URI, Map<String, URI>> importCache;
    private Map<URI, OmlCatalog> catalogCache;
    
    private OmlUriResolver() {
        catalogCache = new HashMap<>();
        importCache = new HashMap<>();
        activate();
    }
    
    /**
     * Activates the resolver's thread
     */
    public void activate() {
        if (thread == null) {
            try {
                watcher = FileSystems.getDefault().newWatchService();
                watched = new HashMap<>();
                thread = new Thread(this, "CatalogManager");
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
    public void deactivate() {
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
    
    /**
     * Clears the import and catalog caches of the resolver
     */
    public void clearCache() {
        importCache.clear();
        catalogCache.clear();
    }
    
    /**
     * Gets the Oml URI resolver corresponding for the passed resource set
     * 
     * @param resourceSet The input resource set
     * @return The corresponding Oml URI resolver
     */
    public static OmlUriResolver get(ResourceSet resourceSet) {
        List<Adapter> adapters = resourceSet.eAdapters();
        for (int i = 0, size = adapters.size(); i < size; ++i) {
            Object adapter = adapters.get(i);
            if (adapter instanceof Listener) {
                return instance;
            }
        }
        resourceSet.eAdapters().add(instance.new Listener());
        return instance;
    }
    
    private File toFile(URI uri) {
        URI localUri = CommonPlugin.asLocalURI(uri);
        return localUri.isFile() ? new File(localUri.toFileString()) : null;
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
    
    private List<File> getParents(File file) {
        final List<File> parents = new ArrayList<>();
        while (file.getParentFile() != null) {
            File parent = file.getParentFile();
            parents.add(parent);
            file = parent;
        }
        return parents;
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
    
    public synchronized Set<URI> getResolvableUris(Resource contextResource) {
		final var uris = new LinkedHashSet<URI>();
		
		// add the URIs from the current resource set
		contextResource.getResourceSet().getResources().forEach(r -> uris.add(r.getURI()));
		uris.removeIf(uri -> !OML_EXTENSIONS_LIST.contains(uri.fileExtension()));
		
		// retain only OML files

		// get the context URI
        URI contextUri = (contextResource != null) ? contextResource.getURI() : null;
        if (contextUri == null) {
            return Collections.emptySet();
        }

        // get the folder URI of the context
        URI folderUri = contextUri.trimSegments(1);

        if (!catalogCache.containsKey(folderUri)) {
            findCatalogs(catalogCache, folderUri);
        }
        
        // get the catalog being used with the context
        OmlCatalog catalog = catalogCache.get(folderUri);
        if (catalog == null) {
            return Collections.emptySet();
        }
		
        // final all file paths specified in the catalog
		var entryUris = new ArrayList<URI>();
		for (CatalogEntry e : catalog.getEntries()) {
			if (e.getEntryType() == Catalog.REWRITE_URI) { // only type of entry supported so far
				var uri = URI.createURI(e.getEntryArg(1));
				if (uri.hasTrailingPathSeparator()) {
					uri = uri.trimSegments(1);
				}
				entryUris.add(uri);
			}
		}
		
		// collect URIs from the catalog file paths
		for (final URI entryUri : entryUris) {
			var path = new File(CommonPlugin.asLocalURI(entryUri).toFileString());
			if (path.isDirectory()) {
				for (var file : getFiles(path)) {
					String relative = path.toURI().relativize(file.toURI()).getPath();
					uris.add(URI.createURI(entryUri+"/"+relative));
				}
			} else { // likely a file name with no extension
				for (String ext : OML_EXTENSIONS_LIST) {
					var file = new File(path.toString()+"."+ext);
					if (file.exists()) {
						uris.add(URI.createURI(entryUri+"."+ext));
						break;
					}
				}
			}
		}
		
		// remove the context URI
		uris.remove(contextUri);
		
		return uris;
	}

    protected Set<File> getFiles(File folder) {
		final var files = new HashSet<File>();
		for (File file : folder.listFiles()) {
			if (file.isFile()) {
				var ext = Files.getFileExtension(file.toString());
				if (OmlConstants.OML_EXTENSION.equals(ext)) {
					files.add(file);
				}
			} else if (file.isDirectory()) {
				files.addAll(getFiles(file));
			}
		}
		return files;
	}

	private URI resolveFromCatalog(ResourceSet rs, URI folderUri, String iri) {
        if (!catalogCache.containsKey(folderUri)) {
            findCatalogs(catalogCache, folderUri);
        }
        
        OmlCatalog catalog = catalogCache.get(folderUri);
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
    
    private void findCatalogs(Map<URI, OmlCatalog> catalogMap, URI folderUri) {
        final List<URI> uris = new ArrayList<>();
        OmlCatalog catalog = null;
        URI currentUri = folderUri;
        while (currentUri != null && catalog == null && currentUri.segmentCount() > 0) {
            uris.add(currentUri);
            URI catalogUri = currentUri.appendSegment("catalog.xml");
            try {
	        	if  (new File(CommonPlugin.asLocalURI(catalogUri).toFileString()).exists()) {
	                catalog = OmlCatalog.create(catalogUri);
	        	}
	        } catch (IOException e) {
	            System.out.println(e);
	        }
            if (catalog == null) {
                currentUri = currentUri.trimSegments(1);
                catalog = catalogMap.get(currentUri);
            }
        }
        final OmlCatalog finalCatalog = catalog;
        uris.forEach(uri -> catalogMap.put(uri, finalCatalog));
    }
    
    private void addResource(Resource resource) {
        if (resource.getURI().isPlatformPlugin()) {
            return;
        }
        File file = toFile(resource.getURI());
        if (file == null) {
            return;
        }
        for (File parent : getParents(file)) {
            if (!watched.containsValue(parent)) {
                try {
                    WatchKey key = parent.toPath().register(watcher, 
                            StandardWatchEventKinds.ENTRY_CREATE,
                            StandardWatchEventKinds.ENTRY_DELETE, 
                            StandardWatchEventKinds.ENTRY_MODIFY);
                    watched.put(key, parent);
                } catch (IOException e) {
                    break;
                }
            } else {
                break;
            }
        }
    }
    
    @Override
    public void run() {
        while (!doStop) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }
            
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                
                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }
                
                @SuppressWarnings("unchecked")
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path fileName = ev.context();
                File folder = watched.get(key);
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
    
    private class Listener extends AdapterImpl {
        @Override
        public void notifyChanged(Notification notification) {
            if (notification.getFeatureID(ResourceSet.class) == ResourceSet.RESOURCE_SET__RESOURCES) {
                switch (notification.getEventType()) {
                    case Notification.RESOLVE: {
                        Resource newValue = (Resource) notification.getNewValue();
                        addResource(newValue);
                        break;
                    }
                    case Notification.UNSET: {
                        Object newValue = notification.getNewValue();
                        if (newValue != null && newValue != Boolean.TRUE && newValue != Boolean.FALSE) {
                            addResource((Resource) newValue);
                        }
                        break;
                    }
                    case Notification.SET: {
                        Resource newValue = (Resource) notification.getNewValue();
                        if (newValue != null) {
                            addResource(newValue);
                        }
                        break;
                    }
                    case Notification.ADD: {
                        Resource newValue = (Resource) notification.getNewValue();
                        if (newValue != null) {
                            addResource(newValue);
                        }
                        break;
                    }
                    case Notification.ADD_MANY: {
                        for (Object newValue : (Collection<?>) notification.getNewValue()) {
                            addResource((Resource) newValue);
                        }
                        break;
                    }
                }
            }
        }
    }
}
