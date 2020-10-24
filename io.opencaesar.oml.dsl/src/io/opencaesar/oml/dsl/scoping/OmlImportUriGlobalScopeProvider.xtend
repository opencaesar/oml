/**
 * 
 * Copyright 2019 California Institute of Technology ("Caltech").
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
package io.opencaesar.oml.dsl.scoping

import com.google.inject.Inject
import com.google.inject.Provider
import io.opencaesar.oml.OmlPackage
import io.opencaesar.oml.dsl.resource.OmlResourceDescriptionStrategy
import java.util.LinkedHashSet
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider
import org.eclipse.xtext.util.IResourceScopeCache

class OmlImportUriGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	
	@Inject	IResourceDescription.Manager descriptionManager

	@Inject IResourceScopeCache cache

	override protected LinkedHashSet<URI> getImportedUris(Resource resource) {
		return cache.get(OmlImportUriGlobalScopeProvider.getSimpleName(), resource, new Provider<LinkedHashSet<URI>>() {
			override get() {
				val resourceDescription = descriptionManager.getResourceDescription(resource)
				val ontologyDescriptions = resourceDescription.getExportedObjectsByType(OmlPackage.Literals.ONTOLOGY)
				val uniqueImportURIs = new LinkedHashSet<URI>(5)
				ontologyDescriptions.forEach[
					val userData = getUserData(OmlResourceDescriptionStrategy.IMPORTS)
					if(userData !== null) {
						userData.split(",").forEach[uri|
							uniqueImportURIs.add(URI.createURI(uri))
						]
					}
				]
				return uniqueImportURIs
			}
		});
	}
	
}