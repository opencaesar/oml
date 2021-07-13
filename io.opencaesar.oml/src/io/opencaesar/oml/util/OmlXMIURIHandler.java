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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;

import io.opencaesar.oml.Member;

/**
 * The <b>XMI URI Handler</b> implementation for the model.
 * 
 * This handler allows Oml cross-refs to be serialized/loaded using abbreviated IRIs in .omlxmi format.
 * It is installed by default by {@link OmlXMIResource} instances.
 * 
 * @author elaasar
 */
public class OmlXMIURIHandler extends URIHandlerImpl {

	private Resource resource;
	
	public OmlXMIURIHandler(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public URI resolve(URI uri) {
		String[] qname = uri.toString().split(":");
		if (!uri.toString().contains("/") && qname.length == 2) {// abbreviated iri
			var ontology = OmlRead.getOntology(resource);
			var nsMap = OmlRead.getImportNamespaces(ontology);
			String namespace = nsMap.get(qname[0]);
			if (namespace != null) {
				URI resolvedUri = OmlRead.getResolvedUri(resource, URI.createURI(namespace));
				if (resolvedUri != null) {
					return resolvedUri.appendFragment(qname[1]);
				}
			}
			throw new RuntimeException("Uri '" + uri + "' cannot be resolved");
		}
		return super.resolve(uri);
	}

	@Override
	public URI deresolve(URI uri) {
		var obj = resource.getResourceSet().getEObject(uri, true);
		if (obj instanceof Member) {
			var ontology = OmlRead.getOntology(resource);
			var iri = OmlRead.getAbbreviatedIriIn((Member) obj, ontology);
			if (iri != null) {
				return URI.createURI(iri);
			}
			throw new RuntimeException("Uri '" + uri + "' cannot be converted to a logical iri");
		}
		return super.deresolve(uri);
	}

}
