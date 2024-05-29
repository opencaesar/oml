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
package io.opencaesar.oml.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;

import io.opencaesar.oml.Member;
import io.opencaesar.oml.SeparatorKind;
import io.opencaesar.oml.util.OmlRead;

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
		if (!uri.toString().contains("/") && qname.length >= 2) {// abbreviated iri
			// qname.length == 2 is for backward compatibility with earlier 2.x versions of OML
			String prefix = (qname.length == 3) ? qname[1] : (qname.length == 2) ? qname[0] : null; 
			String name = (qname.length == 3) ? qname[2] : (qname.length == 2) ? qname[1] : null;
			if (prefix != null && name != null) {
				var ontology = OmlRead.getOntology(resource);
				var _import = ontology.getOwnedImports().stream()
					.filter(i -> prefix.equals(i.getPrefix()))
					.findFirst().orElse(null);
				if (_import != null) {
					URI resolvedUri = OmlRead.getResolvedUri(resource, _import.getIri());
					if (resolvedUri != null) {
						return URI.createURI(resolvedUri.toString() + SeparatorKind.HASH.toString() + name);
					}
				}
				//COMPARE-MERGE-CASE
				return URI.createHierarchicalURI(new String[]{prefix}, null, name);
			}
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
				return URI.createURI("oml:"+iri); // "oml:" is set as the URI's (lower case) scheme
			}
			throw new RuntimeException("References to <" + uri + "> do not have a corresponding import statement");
		} else if (uri.fragment() != null) {
			// Reverse of COMPARE-MERGE-CASE above
			return URI.createURI(uri.toString().replace('#', ':'));
		}
		return super.deresolve(uri);
	}

}
