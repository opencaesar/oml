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

import java.util.Arrays;
import java.util.List;

/**
 * The <b>Constants</b> used frequently by OML code base
 * 
 * @author elaasar
 */
public interface OmlConstants {

    /**
     * The extension of OML Text files
     */
    public static final String OML_EXTENSION = "oml";

    /**
     * The extension of OML XMI files
     */
    public static final String OMLXMI_EXTENSION = "omlxmi";

    /**
     * The extension of OML JSON files
     */
    public static final String OMLJSON_EXTENSION = "omljson";

    /**
     * The supported OML file extensions
     */
    public static final String[] OML_EXTENSIONS= { OML_EXTENSION, OMLXMI_EXTENSION, OMLJSON_EXTENSION };

    /**
     * The supported OML file extension list
     */
    public static final List<String> OML_EXTENSION_LIST= Arrays.asList(OML_EXTENSIONS);

    /**
     * The IRI of the OML vocabulary
     */
    public static final String OML_IRI= "http://opencaesar.io/oml";

    /**
     * The namespace of the OML vocabulary
     */
    public static final String OML_NS= OML_IRI+"#";

    /**
     * The prefix of the OML vocabulary
     */
    public static final String OML_PREFIX= "oml";

    /**
     * The IRI of the XSD vocabulary
     */
    public static final String XSD_IRI = "http://www.w3.org/2001/XMLSchema";

    /**
     * The namespace of the XSD vocabulary
     */
    public static final String XSD_NS = XSD_IRI+"#";

    /**
     * The prefix of the XSD vocabulary
     */
    public static final String XSD_PREFIX= "xsd";

    /**
     * The IRI of the RDF vocabulary
     */
    public static final String RDF_IRI = "http://www.w3.org/1999/02/22-rdf-syntax-ns";

    /**
     * The namespace of the RDF vocabulary
     */
    public static final String RDF_NS = RDF_IRI+"#";

    /**
     * The prefix of the RDF vocabulary
     */
    public static final String RDF_PREFIX= "rdf";

    /**
     * The IRI of the RDFS vocabulary
     */
    public static final String RDFS_IRI = "http://www.w3.org/2000/01/rdf-schema";

    /**
     * The namespace of the RDFS vocabulary
     */
    public static final String RDFS_NS = RDFS_IRI+"#";

    /**
     * The prefix of the RDFS vocabulary
     */
    public static final String RDFS_PREFIX= "rdfs";

   /**
     * The IRI of the OWL vocabulary
     */
    public static final String OWL_IRI = "http://www.w3.org/2002/07/owl";

    /**
     * The namespace of the OWL vocabulary
     */
    public static final String OWL_NS = OWL_IRI+"#";

    /**
     * The prefix of the OWL vocabulary
     */
    public static final String OWL_PREFIX= "owl";

    /**
     * The IRI of the DC vocabulary
     */
    public static final String DC_IRI = "http://purl.org/dc/elements/1.1";

    /**
     * The namespace of the DC vocabulary
     */
    public static final String DC_NS = DC_IRI+"/";

    /**
     * The prefix of the DC vocabulary
     */
    public static final String DC_PREFIX= "dc";
    
    /**
     * A flag that can be set to <code>Boolean.True</code> in a resource set's loading options to enable 
     * resolving IRIs to URIs using already loaded OML ontologies when they are not resolvable using catalogs.
     */
    public static final String RESOLVE_IRI_USING_RESOURCE_SET = "ResolveIRIsUsingLoadedResources";

}
