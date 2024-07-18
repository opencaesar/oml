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
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogEntry;
import org.apache.xml.resolver.CatalogManager;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;

import com.google.common.io.Files;
/**
 * The <b>Catalog</b> that resolves logical IRIs to physical URIs. It is a wrapper around the the Apache XML Resolver Catalog. 
 * 
 * @author elaasar
 */
public final class OmlCatalog {

    /*
     * The singleton catalog manager
     */
    private static CatalogManager manager = new CatalogManager();
    static {
        manager.setUseStaticCatalog(false);
        manager.setIgnoreMissingProperties(true);
    }

    /*
     * The wrapped Apache catalog
     */
    private CatalogEx catalog;

    /*
     * The supported OML file extensions
     */
    private List<String> extensions;

    /*
     * The wrapped Apache catalog
     */
    private List<OmlCatalog> nestedCatalogs;

    /*
     * Creates a new OmlCatalog instance
     */
    private OmlCatalog(CatalogEx catalog, List<String> extensions) {
        this.catalog = catalog;
        this.extensions = extensions;
        this.nestedCatalogs = new ArrayList<>();
    }

    /**
     * Creates a new Oml Catalog given a catalog URI
     * 
     * @param catalogUri The URI of a catalog file named 'catalog.xml'
     * @param extensions The supported OML file extensions
     * @return A new instance of Oml Catalog
     * @throws IOException When there are problems parsing the catalog
     */
    public static OmlCatalog create(URI catalogUri, List<String> extensions) throws IOException {
    	CatalogEx catalog = new CatalogEx(catalogUri.trimSegments(1).toString());
        catalog.setCatalogManager(manager);
        catalog.setupReaders();
        catalog.loadSystemCatalogs();
        catalog.parseCatalog(new URL(catalogUri.toString()));
        var omlCatalog = new OmlCatalog(catalog, extensions);
		for (String path : catalog.getNestedCatalogs()) {
			omlCatalog.nestedCatalogs.add(OmlCatalog.create(URI.createURI(path)));
		}
        return omlCatalog;
    }

    /**
     * Creates a new Oml Catalog given a catalog URI
     * 
     * @param catalogUri The URI of a catalog file named 'catalog.xml'
     * @return A new instance of Oml Catalog
     * @throws IOException When there are problems parsing the catalog
     */
    public static OmlCatalog create(URI catalogUri) throws IOException {
        return create(catalogUri, OmlConstants.OML_EXTENSION_LIST);
    }

    /**
     * Resolves the given logical URI to a physical URI
     * 
     * @param uri The logical URI to resolve
     * @return The resolved physical URI
     * @throws IOException if the logical URI cannot be resolved to a physical path
     */
    public URI resolveUri(URI uri) throws IOException {
    	return URI.createURI(catalog.resolveUri(uri.toString()));
    }

    /**
     * Deresolves the given physical URI to a logical URI
     * 
     * @param path The physical URI to deresolve
     * @return The deresolved logical URI
     * @throws IOException if the physical URI cannot be deresolved to a logical URI
     */
    public URI deresolveUri(URI path) throws IOException {
		for (CatalogEntry e : catalog.getCatalogEntries()) {
			if (e.getEntryType() == Catalog.REWRITE_URI) {
				String uriStartString = e.getEntryArg(0);
				String rewriteUri = e.getEntryArg(1);
				if (rewriteUri.endsWith("/")) {
					rewriteUri = rewriteUri.substring(0, rewriteUri.length()-1);
				}
				int i =  path.toString().indexOf(rewriteUri);
				if (i != -1) {
					var pathWithNoExt = path.toString();
					for (var extension : extensions) {
						if (pathWithNoExt.endsWith("."+extension)) {
							pathWithNoExt = path.trimFileExtension().toString();
							break;
						}
					}
					var deresolved = pathWithNoExt.replace(rewriteUri, uriStartString);
					return URI.createURI(deresolved);
				}
			}
		}
    	return null;
    }

    /**
     * Gets the physical URIs that are resolved by this catalog
     * 
     * @return a list of physical URIs
     */
    public List<URI> getResolvedUris() throws IOException {
		var uris = new ArrayList<URI>();
		for (final String rewriteUri : getRewriteUris()) {
			var path = new File(CommonPlugin.asLocalURI(URI.createURI(rewriteUri)).toFileString());
			var dirPath = (path.isDirectory())? path : path.getParentFile();
			for (var file : getFiles(dirPath, extensions)) {
				if (file.getAbsolutePath().startsWith(path.getAbsolutePath())) {
					System.out.println("rewriteUri = "+rewriteUri);
					System.out.println("path = "+path.toPath());
					System.out.println("file = "+file.toPath());
					var relative = path.toPath().relativize(file.toPath());
					System.out.println("relative = "+relative);
					var relative2 = path.toURI().relativize(file.toURI());
					System.out.println("relative2 = "+relative2);
					var relative3 = relative.toString().replaceAll("\\", "/");
					System.out.println("relative3 = "+relative3);
					var uri1 = java.net.URI.create(rewriteUri).resolve(relative3);
					System.out.println("uri1 = "+uri1);
					var uri2 = uri1.normalize();
					System.out.println("uri2 = "+uri2);
					var uri3 = URI.createURI(uri2.toString());
					System.out.println("uri3 = "+uri3);
					uris.add(uri3);
				}
			}
		}
		return uris;
    }

    /**
     * Gets the rewrite URIs supported by this catalog
     * 
     * @return a list of rewrite URIs
     */
    public List<String> getRewriteUris() throws IOException {
		var uris = new ArrayList<>(catalog.getRewriteUris());
		for (final OmlCatalog nestedCatalog : nestedCatalogs) {
			uris.addAll(nestedCatalog.getRewriteUris());
		}
		return uris;
    }

    /**
     * Checks whether the given physical URI is resolved by this catalog
     *  
     * @param uri The given uri
     * @return true if the uri can be resolved, false otherwise
     */
    boolean isResolvedUri(URI uri) {
        for (String rewriteURI : catalog.getRewriteUris()) {
        	if (uri.toString().startsWith(rewriteURI.toString())) {
        		return true;
        	}
        }
        return false;
    }
    
    private Set<File> getFiles(File folder, List<String> fileExtensions) {
		final var files = new HashSet<File>();
		for (File file : folder.listFiles()) {
			if (file.isFile()) {
				var ext = Files.getFileExtension(file.toString());
				if (fileExtensions.contains(ext)) {
					files.add(file);
				}
			} else if (file.isDirectory()) {
				files.addAll(getFiles(file, fileExtensions));
			}
		}
		return files;
	}

    private static class CatalogEx extends Catalog {
    	private String baseUri;
    	public CatalogEx(String baseUri) {
    		this.baseUri = baseUri;
    	}
        public String resolveUri(String uri) throws IOException {
        	String resolved = resolveURI(uri);
        	return (resolved != null) ? normalize(resolved) : null;
        }
        public List<String> getRewriteUris() {
    		var rewriteUris = new ArrayList<String>();
    		for (CatalogEntry e : getCatalogEntries()) {
    			if (e.getEntryType() == Catalog.REWRITE_URI) {
    				String uri = normalize(e.getEntryArg(1));
    				if (uri.endsWith("/")) {
    					uri = uri.substring(0, uri.length()-1);
    				}
    				rewriteUris.add(uri);
    			}
    		}
        	return rewriteUris;
        }
        public List<CatalogEntry> getCatalogEntries() {
            List<CatalogEntry> entries = new ArrayList<CatalogEntry>();
            Enumeration<?> en = catalogEntries.elements();
            while (en.hasMoreElements()) {
                entries.add((CatalogEntry) en.nextElement());
            }
            return entries;
        }
        public List<String> getNestedCatalogs() {
            List<String> entries = new ArrayList<String>();
            Enumeration<?> en = catalogs.elements();
            while (en.hasMoreElements()) {
                entries.add((String)en.nextElement());
            }
            return entries;
        }        

        @Override
        protected String makeAbsolute(String sysid) {
            sysid = fixSlashes(sysid);
            return  baseUri.toString()+'/'+sysid;
        }

        private static String normalize(String path) {
        	java.net.URI uri = java.net.URI.create(path);
        	java.net.URI normalized = uri.normalize();
        	return path.replaceFirst(uri.getRawPath(), normalized.getRawPath());
        }
        
    }
}
