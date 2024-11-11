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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogEntry;
import org.apache.xml.resolver.CatalogManager;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
/**
 * The <b>OmlCatalog</b> resolves logical IRIs to physical URIs. 
 * 
 * @author elaasar
 */
final class OmlCatalog {

	/*
	 * The singleton catalog manager
	 */
	private static CatalogManager manager = createCatalogManager();

	/*
	 * The wrapped Apache catalog
	 */
	private CatalogEx catalog;

	/*
	 * The wrapped nested OML catalogs
	 */
	private List<OmlCatalog> nestedCatalogs;

	/*
	 * Creates a new catalog manager
	 */
	private static CatalogManager createCatalogManager() {
		CatalogManager manager = new CatalogManager();
		manager.setUseStaticCatalog(false);
		manager.setIgnoreMissingProperties(true);
		return manager;
	}
	
	/*
	 * Creates a new OmlCatalog instance
	 */
	private OmlCatalog(CatalogEx catalog) throws IOException {
		this.catalog = catalog;
		this.nestedCatalogs = new ArrayList<>();
		for (String path : catalog.getNestedCatalogs()) {
			this.nestedCatalogs.add(OmlCatalog.create(URI.createURI(path)));
		}
	}

	/**
	 * Creates a new Oml Catalog given a catalog URI
	 * 
	 * @param catalogUri The URI of a catalog file named 'catalog.xml'
	 * @return A new instance of Oml Catalog
	 * @throws IOException When there are problems parsing the catalog
	 */
	public static OmlCatalog create(URI catalogUri) throws IOException {
		CatalogEx catalog = new CatalogEx(catalogUri.trimSegments(1).toString());
		catalog.setCatalogManager(manager);
		catalog.setupReaders();
		catalog.loadSystemCatalogs();
		catalog.parseCatalog(catalogUri.toString());
		return new OmlCatalog(catalog);
	}

	/**
	 * Resolves a URI given an IRI
	 * 
	 * @param iri The IRI to resolve the URI with
	 * @return The resolved URI
	 * @throws IOException if the IRI cannot be resolved to a URI
	 */
	public URI resolveUri(String iri) throws IOException {
		return URI.createURI(catalog.resolveUri(iri));
	}

	/**
	 * Deresolves the given URI to an IRI
	 * 
	 * @param uri The URI to deresolve
	 * @return The deresolved IRI (can be null)
	 */
	public String deresolveUri(URI uri) {
		String iri = null;
		for (var e : getAllRewriteEntries().entrySet()) {
			String uriStartString = e.getKey();
			String rewriteUri = e.getValue();
			if (uri.toString().startsWith(rewriteUri)) {
				iri = uri.toString().replace(rewriteUri, uriStartString);
				break;
			}
		}
		return iri;
	}

	/**
	 * Checks whether the given URI is resolved by this catalog
	 *  
	 * @param uri The given uri
	 * @return true if the uri is deresolvable by this catalog, false otherwise
	 */
	public boolean isResolvedUri(URI uri) {
		for (String rewriteURI : getAllRewriteEntries().values()) {
			if (uri.toString().startsWith(rewriteURI.toString())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets a set of file URIs that are resolved by this catalog
	 * 
	 * @return a set of file URIs
	 */
	public Set<URI> getResolvedFileUris() {
		var uris = new HashSet<URI>();
		for (var rewriteUri : getAllRewriteEntries().values()) {
			var prefix = new File(CommonPlugin.asLocalURI(URI.createURI(rewriteUri)).toFileString());
			for (var file : getFilesFromPrefix(prefix)) {
				var relative = prefix.toPath().relativize(file.toPath()).toString().replace("\\", "/");
				var uri = normalize(rewriteUri + "/" + relative);
				uris.add(URI.createURI(uri));
			}
		}
		return uris;
	}

	//---------------------
	
	/*
	 * Gets a set of files that has the given prefix
	 */
	private Set<File> getFilesFromPrefix(File prefix) {
		if (prefix.isDirectory()) {
			return getFilesFromDirectory(prefix);
		}
		if (prefix.getParentFile().isDirectory()) {
			var files = getFilesFromDirectory(prefix.getParentFile());
			var i = files.iterator();
			while (i.hasNext()) {
				if (!i.next().getPath().startsWith(prefix.getPath())) {
					i.remove();
				}
			}
			return files;
		}
		return Collections.emptySet();
	}

	/*
	 * Gets a list of files contained recursively in a directory
	 */
	private Set<File> getFilesFromDirectory(File directory) {
		final var files = new HashSet<File>();
		for (File file : directory.listFiles()) {
			if (file.isFile()) {
				files.add(file);
			} else if (file.isDirectory()) {
				files.addAll(getFilesFromDirectory(file));
			}
		}
		return files;
	}

	private static String normalize(String path) {
		java.net.URI uri = java.net.URI.create(path);
		java.net.URI normalized = uri.normalize();
		return path.replaceFirst(uri.getRawPath(), normalized.getRawPath());
	}

	/*
	 * Gets a list of rewrite URIs supported by this catalog and its nested catalogs
	 */
	private Map<String, String> getAllRewriteEntries() {
		var entries = new HashMap<String, String>();
		for (var nestedCatalog : nestedCatalogs) {
			entries.putAll(nestedCatalog.getAllRewriteEntries());
		}
		entries.putAll(catalog.getRewriteEntries());
		return entries;
	}

	/*
	 * Wrapper around Apache Catalog providing some API
	 */
	private static class CatalogEx extends Catalog {
		private String baseUri;
		public CatalogEx(String baseUri) {
			this.baseUri = baseUri;
		}
		public String resolveUri(String uri) throws IOException {
			String resolved = resolveURI(uri);
			return (resolved != null) ? normalize(resolved) : null;
		}
		public Map<String, String> getRewriteEntries() {
			var entries = new HashMap<String, String>();
			for (CatalogEntry e : getCatalogEntries()) {
				if (e.getEntryType() == Catalog.REWRITE_URI) {
					entries.put(e.getEntryArg(0), normalize(e.getEntryArg(1)));
				}
			}
			return entries;
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
		
	}
}
