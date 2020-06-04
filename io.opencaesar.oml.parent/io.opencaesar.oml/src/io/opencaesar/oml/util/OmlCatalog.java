package io.opencaesar.oml.util;

import java.io.IOException;
import java.net.URL;

import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogManager;

public class OmlCatalog {

	private Catalog catalog;
	
	private OmlCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	
	static public OmlCatalog create(URL catalogUrl) throws IOException {
		CatalogManager manager = new CatalogManager();
		manager.setUseStaticCatalog(false);
		manager.setIgnoreMissingProperties(true);
		Catalog catalog = manager.getCatalog();
		catalog.parseCatalog(catalogUrl);
		return new OmlCatalog(catalog);
	}
	
	public String resolveURI(String uri) throws IOException {
		return catalog.resolveURI(uri);
	}
}
