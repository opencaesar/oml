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
package io.opencaesar.oml.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

public class OmlXMIResourceFactory extends ResourceFactoryImpl {

	public OmlXMIResourceFactory() {
		super();
	}

	@Override
	public Resource createResource(URI uri) {
		return new OmlXMIResource(uri);
	}
	
	public static void register() {
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(OmlXMIResource.EXTENSION)) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(OmlXMIResource.EXTENSION, new OmlXMIResourceFactory());
		}
	}
}
