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
     * The IRI of the OML vocabulary
     */
    public static final String OML_IRI= "http://opencaesar.io/oml";

    /**
     * The namespace of the OML vocabulary
     */
    public static final String OML_NS= OML_IRI+"#";

    /**
     * The IRI of the XSD vocabulary
     */
    public static final String XSD_IRI = "http://www.w3.org/2001/XMLSchema";

    /**
     * The namespace of the XSD vocabulary
     */
    public static final String XSD_NS = XSD_IRI+"#";

    /**
     * The IRI of the RDF vocabulary
     */
    public static final String RDF_IRI = "http://www.w3.org/1999/02/22-rdf-syntax-ns";

    /**
     * The namespace of the RDF vocabulary
     */
    public static final String RDF_NS = RDF_IRI+"#";

    /**
     * The IRI of the RDFS vocabulary
     */
    public static final String RDFS_IRI = "http://www.w3.org/2000/01/rdf-schema";

    /**
     * The namespace of the RDFS vocabulary
     */
    public static final String RDFS_NS = RDFS_IRI+"#";

    /**
     * The IRI of the OWL vocabulary
     */
    public static final String OWL_IRI = "http://www.w3.org/2002/07/owl";

    /**
     * The namespace of the OWL vocabulary
     */
    public static final String OWL_NS = OWL_IRI+"#";

    /**
     * The IRI of the DC vocabulary
     */
    public static final String DC_IRI = "http://purl.org/dc/elements/1.1";

    /**
     * The namespace of the DC vocabulary
     */
    public static final String DC_NS = DC_IRI+"/";

}
