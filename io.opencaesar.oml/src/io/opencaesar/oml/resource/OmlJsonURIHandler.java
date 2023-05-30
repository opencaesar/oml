/**
 * 
 * Copyright 2022 California Institute of Technology ("Caltech").
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
import org.eclipse.emfcloud.jackson.handlers.BaseURIHandler;

import io.opencaesar.oml.Member;
import io.opencaesar.oml.SeparatorKind;
import io.opencaesar.oml.util.OmlRead;

/**
 * The <b>Json URI Handler</b> implementation for the model.
 * 
 * This handler allows Oml cross-refs to be serialized/loaded using abbreviated IRIs in .omljson format.
 * It is installed by default by {@link OmlJsonResource} instances.
 * 
 * @author elaasar
 */
public class OmlJsonURIHandler extends BaseURIHandler {

	private Resource resource;
	
	public OmlJsonURIHandler(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public URI resolve(final URI baseURI, final URI uri) {
		String[] qname = uri.toString().split(":");
		if (!uri.toString().contains("/") && qname.length == 2) {// abbreviated iri
			var ontology = OmlRead.getOntology(resource);
			var _import = ontology.getOwnedImports().stream()
				.filter(i -> qname[0].equals(i.getPrefix()))
				.findFirst().orElse(null);
			if (_import != null) {
				URI resolvedUri = OmlRead.getUriByIri(resource, _import.getIri());
				if (resolvedUri != null) {
					return URI.createURI(resolvedUri.toString() + SeparatorKind.HASH.toString() + qname[1]);
				}
			}
			return URI.createHierarchicalURI(new String[]{qname[0]}, null, qname[1]);
		}
		return super.resolve(baseURI, uri);
	}

	@Override
    public URI deresolve(final URI baseURI, URI uri) {
		var obj = resource.getResourceSet().getEObject(uri, true);
		if (obj instanceof Member) {
			var ontology = OmlRead.getOntology(resource);
			var iri = OmlRead.getAbbreviatedIriIn((Member) obj, ontology);
			if (iri != null) {
				return URI.createURI(iri);
			}
			throw new RuntimeException("References to <" + uri + "> do not have a corresponding import statement");
		}
		return super.deresolve(baseURI, uri);
	}

}
