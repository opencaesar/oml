package io.opencaesar.oml.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogEntry;
import org.apache.xml.resolver.CatalogManager;

public class OmlCatalog {

	static CatalogManager manager = new CatalogManager();
	static {
		manager.setUseStaticCatalog(false);
		manager.setIgnoreMissingProperties(true);
	}

	private CatalogEx catalog;
	
	private OmlCatalog(CatalogEx catalog) {
		this.catalog = catalog;
	}
	
	static public OmlCatalog create(URL catalogUrl) throws IOException {
		CatalogEx catalog = new CatalogEx();
		catalog.setCatalogManager(manager);
		catalog.setupReaders();
		catalog.loadSystemCatalogs();
		catalog.parseCatalog(catalogUrl);
		return new OmlCatalog(catalog);
	}
	
	public String resolveURI(String uri) throws IOException {
		return catalog.resolveURI(uri);
	}

	public String getCurrentBase() {
		return catalog.getCurrentBase();
	}
	
	public List<CatalogEntry> getEntries() {
	    List<CatalogEntry> entries = new ArrayList<CatalogEntry>();
		Enumeration<?> en = catalog.getCatalogEntries().elements();
	    while (en.hasMoreElements()) {
	    	entries.add((CatalogEntry) en.nextElement());
	    }
	    return entries;
	}
	
	public List<String> getNestedCatalogs() {
	    List<String> entries = new ArrayList<String>();
		Enumeration<?> en = catalog.getCatalogs().elements();
	    while (en.hasMoreElements()) {
	    	entries.add((String)en.nextElement());
	    }
	    return entries;
	}
	
	private static class CatalogEx extends Catalog {
		Vector<?> getCatalogEntries() {
			return catalogEntries;
		}
		Vector<?> getCatalogs() {
			return catalogs;
		}
	}
}
