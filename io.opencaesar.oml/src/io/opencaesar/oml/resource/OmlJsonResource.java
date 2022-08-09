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

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emfcloud.jackson.module.EMFModule;
import org.eclipse.emfcloud.jackson.resource.JsonResource;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.opencaesar.oml.OmlPackage;

/**
 * The <b>Json Resource</b> implementation for the model.
 * 
 * @author elaasar
 */
public class OmlJsonResource extends JsonResource {

    private final Map<String, EObject> idToEObjectMap = new HashMap<>();

    /**
	 * @param uri the URI of the resource
	 */
	public OmlJsonResource(URI uri) {
		this(uri, true);
	}

	/**
	 * @param uri the URI of the resource
     * @param useCatalog whether to use the catalog to (de)resolve cross references
	 */
	public OmlJsonResource(URI uri, boolean useCatalog) {
		super(uri);
        
		// setup the intrinsic id cache
        setIntrinsicIDToEObjectMap(idToEObjectMap);
    	setTrackingModification(true);

    	if (useCatalog) {
			setObjectMapper(setupDefaultMapper(null));
		}
	}

    @Override
	protected Adapter createModificationTrackingAdapter() {
        return new ResourceImpl.ModificationTrackingAdapter() {
        	@Override
        	public void notifyChanged(Notification notification) {
        		super.notifyChanged(notification);
        		if (notification.getFeature() == OmlPackage.Literals.MEMBER__NAME) {
        			if (notification.getOldValue() != null) {
        				idToEObjectMap.remove(notification.getOldValue());
        			}
					if (notification.getNewValue() != null) {
						idToEObjectMap.put((String)notification.getNewValue(), (EObject)notification.getNotifier());
                    }
                }
            }
        };
	}

	private ObjectMapper setupDefaultMapper(final JsonFactory factory) {
		final ObjectMapper mapper = new ObjectMapper(factory);
		// same as emf
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		dateFormat.setTimeZone(TimeZone.getDefault());

		var module = new EMFModule();
		module.setUriHandler(new OmlJsonURIHandler(this));

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.setDateFormat(dateFormat);
		mapper.setTimeZone(TimeZone.getDefault());
		mapper.registerModule(module);

		return mapper;
	}

}
