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

import java.util.Arrays;
import java.util.List;

/**
 * The <b>Constants</b> used frequently by OML code base
 * 
 * @author elaasar
 */
public interface OmlConstants {

	// Extensions
	
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

	// IRI, Namespace, and Prefix

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

	// OML Annotations Property IRIs
	
	/**
	 * The oml:type annotation IRI
	 */
	public static final String type = OML_NS + "type";

	/**
	 * The oml:namespace annotation IRI
	 */
	public static final String namespace = OML_NS + "namespace";

	/**
	 * The oml:prefix annotation IRI
	 */
	public static final String prefix = OML_NS + "prefix";
	
	/**
	 * The oml:name annotation IRI
	 */
	public static final String name = OML_NS + "name";

	/**
	 * The oml:relationEntity annotation IRI
	 */
	public static final String relationEntity = OML_NS + "relationEntity";

	/**
	 * The oml:relationBase annotation IRI
	 */
	public static final String relationBase = OML_NS + "relationBase";

	/**
	 * The oml:hasSource annotation IRI
	 */
	public static final String hasSource = OML_NS + "hasSource";

	/**
	 * The oml:hasTarget annotation IRI
	 */
	public static final String hasTarget = OML_NS + "hasTarget";

	/**
	 * The oml:isSourceOf annotation IRI
	 */
	public static final String isSourceOf = OML_NS + "isSourceOf";

	/**
	 * The oml:isTargetOf annotation IRI
	 */
	public static final String isTargetOf = OML_NS + "isTargetOf";

	// OML Term IRIs 
	
	/**
	 * The oml:Vocabulary IRI
	 */
	public static final String Vocabulary = OML_NS + "Vocabulary";

	/**
	 * The oml:VocabularyBundle IRI
	 */
	public static final String VocabularyBundle = OML_NS + "VocabularyBundle";

	/**
	 * The oml:Description IRI
	 */
	public static final String Description = OML_NS + "Description";

	/**
	 * The oml:DescriptionBundle IRI
	 */
	public static final String DescriptionBundle = OML_NS + "DescriptionBundle";

	/**
	 * The oml:Aspect IRI
	 */
	public static final String Aspect = OML_NS + "Aspect";

	/**
	 * The oml:Concept IRI
	 */
	public static final String Concept = OML_NS + "Concept";

	/**
	 * The oml:RelationEntity IRI
	 */
	public static final String RelationEntity = OML_NS + "RelationEntity";

	/**
	 * The oml:Scalar IRI
	 */
	public static final String Scalar = OML_NS + "Scalar";

	/**
	 * The oml:UnreifiedRelation IRI
	 */
	public static final String UnreifiedRelation = OML_NS + "UnreifiedRelation";

	/**
	 * The oml:ForwardRelation IRI
	 */
	public static final String ForwardRelation = OML_NS + "ForwardRelation";

	/**
	 * The oml:ReverseRelation IRI
	 */
	public static final String ReverseRelation = OML_NS + "ReverseRelation";

	/**
	 * The oml:AnnotationProperty IRI
	 */
	public static final String AnnotationProperty = OML_NS + "AnnotationProperty";

	/**
	 * The oml:ScalarProperty IRI
	 */
	public static final String ScalarProperty = OML_NS + "ScalarProperty";

	/**
	 * The oml:Rule IRI
	 */
	public static final String Rule = OML_NS + "Rule";

	/**
	 * The oml:ConceptInstance IRI
	 */
	public static final String ConceptInstance = OML_NS + "ConceptInstance";

	/**
	 * The oml:RelationInstance IRI
	 */
	public static final String RelationInstance = OML_NS + "RelationInstance";

	/**
	 * The oml:AnonymousConceptInstance IRI
	 */
	public static final String AnonymousConceptInstance = OML_NS + "AnonymousConceptInstance";
 
	/**
	 * The oml:AnonymousRelationInstance IRI
	 */
	public static final String AnonymousRelationInstance = OML_NS + "AnonymousRelationInstance";

	// Flags

	/**
	 * A flag that can be set to <code>Boolean.True</code> in a resource set's loading options to enable 
	 * resolving IRIs to URIs using already loaded OML ontologies when they are not resolvable using catalogs.
	 */
	public static final String RESOLVE_IRI_USING_RESOURCE_SET = "ResolveIRIsUsingLoadedResources";

}
