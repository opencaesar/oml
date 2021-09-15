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
import java.util.Vector;

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
     * Creates a new OmlCatalog instance
     */
    private OmlCatalog(CatalogEx catalog) {
        this.catalog = catalog;
    }

    /**
     * Creates a new Oml Catalog given a catalog URI
     * 
     * @param catalogUri The URI of a catalog file named 'catalog.xml'
     * @return A new instance of Oml Catalog
     * @throws IOException When there are problems parsing the catalog
     */
    public static OmlCatalog create(URI catalogUri) throws IOException {
    	CatalogEx catalog = new CatalogEx(catalogUri);
        catalog.setCatalogManager(manager);
        catalog.setupReaders();
        catalog.loadSystemCatalogs();
        catalog.parseCatalog(new URL(catalogUri.toString()));
        return new OmlCatalog(catalog);
    }

    /**
     * Resolves the given URI to a file path
     * 
     * @param uri The URI to resolve
     * @return The resolved file path
     * @throws IOException if the URI cannot be turned into a valid path
     */
    public String resolveURI(String uri) throws IOException {
    	String resolved = catalog.resolveURI(uri);
    	return normalize(resolved);
    }

    /**
     * Gets the current base of the catalog
     * 
     * @return The current base of the catalog
     */
    public String getCurrentBase() {
        return catalog.getCurrentBase();
    }

    /**
     * Gets the catalog entries
     * 
     * @return The entries of the catalog
     */
    public List<CatalogEntry> getEntries() {
        List<CatalogEntry> entries = new ArrayList<CatalogEntry>();
        Enumeration<?> en = catalog.getCatalogEntries().elements();
        while (en.hasMoreElements()) {
            entries.add((CatalogEntry) en.nextElement());
        }
        return entries;
    }

    /**
     * Gets the nested catalogs of this catalog
     * 
     * @return The nested catalog of this catalog
     */
    public List<String> getNestedCatalogs() {
        List<String> entries = new ArrayList<String>();
        Enumeration<?> en = catalog.getCatalogs().elements();
        while (en.hasMoreElements()) {
            entries.add((String)en.nextElement());
        }
        return entries;
    }

    /**
     * Gets the URIs that are used for rewrite rules in this catalog
     * 
     * @return a list of rewrite URIs
     */
    public List<URI> getRewriteUris() {
		var rewriteUris = new ArrayList<URI>();
		for (CatalogEntry e : getEntries()) {
			if (e.getEntryType() == Catalog.REWRITE_URI) { // only type of entry supported so far
				var uri = URI.createURI(normalize(e.getEntryArg(1)));
				if (uri.hasTrailingPathSeparator()) {
					uri = uri.trimSegments(1);
				}
				rewriteUris.add(uri);
			}
		}
    	return rewriteUris;
    }
    
    private String normalize(String path) {
    	java.net.URI uri = java.net.URI.create(path);
    	java.net.URI normalized = uri.normalize();
    	return path.replaceFirst(uri.getRawPath(), normalized.getRawPath());
    }
    
    /**
     * Gets the URIs of files that are mapped by this catalog
     * 
     * @return a list of file URIs
     */
    public List<URI> getFileUris(List<String> fileExtensions) {
		var uris = new ArrayList<URI>();
		for (final URI rewriteUri : getRewriteUris()) {
			var path = new File(CommonPlugin.asLocalURI(rewriteUri).toFileString());
			if (path.isDirectory()) {
				for (var file : getFiles(path, fileExtensions)) {
					String relative = path.toURI().relativize(file.toURI()).getPath();
					uris.add(URI.createURI(rewriteUri+"/"+relative));
				}
			} else { // likely a file name with no extension
				for (String ext : fileExtensions) {
					var file = new File(path.toString()+"."+ext);
					if (file.exists()) {
						uris.add(URI.createURI(rewriteUri+"."+ext));
						break;
					}
				}
			}
		}
		return uris;
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
    	private URI baseUri;
    	public CatalogEx(URI catalogUri) {
    		this.baseUri = catalogUri.trimSegments(1);
    	}
        Vector<?> getCatalogEntries() {
            return catalogEntries;
        }
        Vector<?> getCatalogs() {
            return catalogs;
        }
        @Override
        protected String makeAbsolute(String sysid) {
            sysid = fixSlashes(sysid);
            return  baseUri.toString()+'/'+sysid;
        }
    }
}
