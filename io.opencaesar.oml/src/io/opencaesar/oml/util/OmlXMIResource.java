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

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;

/**
 * The <b>XMI Resource</b> implementation for the model.
 * 
 * @author elaasar
 */
public final class OmlXMIResource extends XMIResourceImpl {

    private final Map<String, EObject> idToEObjectMap = new HashMap<>();
    private final Adapter idToEObjectMapAdapter = new AdapterImpl() {
        @Override
        public void notifyChanged(Notification notification) {
            if (notification.getFeature() == OmlPackage.Literals.MEMBER__NAME) {
                if (notification.getOldValue() != null) {
                    if (idToEObjectMap.remove(notification.getOldValue()) != null) {
                        if (notification.getNewValue() != null) {
                            idToEObjectMap.put((String)notification.getNewValue(), (EObject)notification.getNotifier());
                        }
                    }
                }
            }
        }
    };

    /**
     * Creates a new Oml XMI Resource given a uri of the resource
     * 
     * @param uri The uri of the created resource
     */
    public OmlXMIResource(URI uri) {
        super(uri);
        var handler = new OmlXMIURIHandler(this);
        getDefaultLoadOptions().put(XMIResource.OPTION_URI_HANDLER, handler);
        getDefaultSaveOptions().put(XMIResource.OPTION_URI_HANDLER, handler);
        getDefaultSaveOptions().put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
        intrinsicIDToEObjectMap = idToEObjectMap;
    }
    
    @Override
    public void attached(EObject eObject) {
        super.attached(eObject);
        if (eObject instanceof Member) {
            eObject.eAdapters().add(idToEObjectMapAdapter);
        }
    }

    @Override
    public void detached(EObject eObject) {
        if (eObject instanceof Member) {
            eObject.eAdapters().remove(idToEObjectMapAdapter);
        }
        super.detached(eObject);
    }

    @Override
    public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
        // this option is set by the Sample Reflective Ecore Model Editor; unset it
        final Map<Object, Object> mergedOptions = new HashMap<>(options);
        mergedOptions.remove(XMIResource.OPTION_LINE_WIDTH);
        super.doSave(outputStream, mergedOptions);
    }

}
