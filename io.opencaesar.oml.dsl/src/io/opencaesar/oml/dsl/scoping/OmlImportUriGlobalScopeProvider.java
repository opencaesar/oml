/**
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
 */
package io.opencaesar.oml.dsl.scoping;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.opencaesar.oml.util.OmlRead;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.util.IResourceScopeCache;

@SuppressWarnings("all")
public class OmlImportUriGlobalScopeProvider extends ImportUriGlobalScopeProvider {

	@Inject
	private IResourceScopeCache cache;

	@Override
	protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		return cache.<LinkedHashSet<URI>>get(OmlImportUriGlobalScopeProvider.class.getSimpleName(), resource, new Provider<LinkedHashSet<URI>>() {
			@Override
			public LinkedHashSet<URI> get() {
				Set<URI> uris = OmlRead.getResolvedUris(resource);
				return new LinkedHashSet<URI>(uris);
			}
		});
	}
}
