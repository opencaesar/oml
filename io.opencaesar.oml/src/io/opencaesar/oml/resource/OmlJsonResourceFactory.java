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
import org.eclipse.emfcloud.jackson.resource.JsonResourceFactory;

import io.opencaesar.oml.util.OmlConstants;

/**
 * The <b>Json Resource Factory</b> implementation for the model.
 * 
 * @author elaasar
 */
public class OmlJsonResourceFactory extends JsonResourceFactory {

	private boolean useCatalog;

	public OmlJsonResourceFactory() {
		this(true);
	}
	
	/**
     * @param useCatalog whether to use the catalog to (de)resolve cross references
	 */
	public OmlJsonResourceFactory(boolean useCatalog) {
		this.useCatalog = useCatalog;
	}
	
    @Override
    public Resource createResource(URI uri) {
        return new OmlJsonResource(uri, useCatalog);
    }
    
    /**
     * Registers the factory with the OML XMI extension 
     */
    public static void register() {
    	register(true);
    }

    /**
     * Registers the factory with the OML XMI extension 
     * 
     * @param useCatalog whether to use the catalog to (de)resolve cross references
     */
    public static void register(boolean useCatalog) {
        if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(OmlConstants.OMLJSON_EXTENSION)) {
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(OmlConstants.OMLJSON_EXTENSION, new OmlJsonResourceFactory(useCatalog));
        }
    }

}
