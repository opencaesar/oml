/*
 * Copyright 2022 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opencaesar.oml.dsl.resource;

import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class OmlXtextResourceFactory extends XtextResourceFactory {

	@Inject
	public OmlXtextResourceFactory(Provider<XtextResource> resourceProvider) {
		super(resourceProvider);
	}

    @Override
    public Resource createResource(URI uri) {
    	XtextResource r = (XtextResource) super.createResource(uri);
        r.setIntrinsicIDToEObjectMap(new HashMap<>());
    	r.setTrackingModification(true);
        return r;
    }

}
