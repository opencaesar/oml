/**
 * 
 * Copyright 2019-2022 California Institute of Technology ("Caltech").
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

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import io.opencaesar.oml.OmlPackage;

/**
 * The <b>XMI Resource</b> implementation for the model.
 * 
 * @author elaasar
 */
public final class OmlXMIResource extends XMIResourceImpl {

    private final Map<String, EObject> idToEObjectMap = new HashMap<>();

    /**
     * Creates a new Oml XMI Resource given a uri of the resource
     * 
     * @param uri The uri of the created resource
     */
    public OmlXMIResource(URI uri) {
    	this(uri, true);
    }
    
    /**
     * Creates a new Oml XMI Resource given a uri of the resource
     * 
     * @param uri The uri of the created resource
     * @param useCatalog whether to use the catalog to (de)resolve cross references
     */
    public OmlXMIResource(URI uri, boolean useCatalog) {
        super(uri);

        // setup the intrinsic id cache
        setIntrinsicIDToEObjectMap(idToEObjectMap);
    	setTrackingModification(true);

        // Load Options
        getDefaultLoadOptions().put(XMIResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<String, EStructuralFeature>());
        // Save Options
        getDefaultSaveOptions().put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
        getDefaultSaveOptions().put(XMIResource.OPTION_EXTENDED_META_DATA, new OmlExtendedMetaData());
        getDefaultSaveOptions().put(XMIResource.OPTION_USE_CACHED_LOOKUP_TABLE, new ArrayList<Object>());

        if (useCatalog) {
        	var handler = new OmlXMIURIHandler(this);
            getDefaultLoadOptions().put(XMIResource.OPTION_URI_HANDLER, handler);
            getDefaultSaveOptions().put(XMIResource.OPTION_URI_HANDLER, handler);
        }
    }

    @Override
	public void load(Map<?, ?> options) throws IOException {
        Map<Object, Object> mergedOptions = new HashMap<Object, Object>(options);
        mergedOptions.put(XMIResource.OPTION_URI_HANDLER, getDefaultLoadOptions().get(XMIResource.OPTION_URI_HANDLER));
        super.load(mergedOptions);
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

    @Override
    public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
        // this option is set by the Sample Reflective Ecore Model Editor; unset it
        final Map<Object, Object> mergedOptions = new HashMap<>(options);
        mergedOptions.remove(XMIResource.OPTION_LINE_WIDTH);
        mergedOptions.put(XMIResource.OPTION_URI_HANDLER, getDefaultSaveOptions().get(XMIResource.OPTION_URI_HANDLER));
        super.doSave(outputStream, mergedOptions);
    }

	private class OmlExtendedMetaData extends BasicExtendedMetaData {
	    
		private String ownedImportsName = OmlPackage.Literals.ONTOLOGY__OWNED_IMPORTS.getName();
		
		/**
	     * This work around ensures that ownedImports is the first reference
	     * to be serialized for an ontology such that it can be used in
	     * ({@link OmlXMIURIHandler} to resolve namespace prefixes
	     */
		@Override
		public List<EStructuralFeature> getAllElements(EClass eClass) {
	    	var features = super.getAllElements(eClass);
	    	if (!eClass.isAbstract() && OmlPackage.Literals.ONTOLOGY.isSuperTypeOf(eClass)) {
	    		features = new ArrayList<EStructuralFeature>(eClass.getEAllReferences());
	    		var ownedImports = features.stream().filter(f -> f.getName().equals(ownedImportsName)).findFirst().orElse(null);
	    		if (ownedImports != null) {
		    		features.remove(ownedImports);
		    		features.add(0, ownedImports);
	    		}
	    	} 
	    	return features;
    	}
	}
    
}
