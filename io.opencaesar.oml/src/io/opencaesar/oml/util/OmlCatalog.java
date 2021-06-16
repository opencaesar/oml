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
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogEntry;
import org.apache.xml.resolver.CatalogManager;

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
     * @param catalogUrl The URI of a catalog file named 'catalog.xml'
     * @return A new instance of Oml Catalog
     * @throws IOException When there are problems parsing the catalog
     */
    public static OmlCatalog create(URL catalogUrl) throws IOException {
        CatalogEx catalog = new CatalogEx();
        catalog.setCatalogManager(manager);
        catalog.setupReaders();
        catalog.loadSystemCatalogs();
        catalog.parseCatalog(catalogUrl);
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
        return catalog.resolveURI(uri);
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

    private static class CatalogEx extends Catalog {
        Vector<?> getCatalogEntries() {
            return catalogEntries;
        }
        Vector<?> getCatalogs() {
            return catalogs;
        }
    }
}
