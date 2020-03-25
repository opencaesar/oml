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
package io.opencaesar.oml.util

import io.opencaesar.oml.Member
import io.opencaesar.oml.OmlPackage
import java.io.IOException
import java.io.OutputStream
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.xmi.XMIResource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl

class OmlXMIResource extends XMIResourceImpl {

	public static val EXTENSION = "omlxmi"

	val idToEObjectMap = new HashMap<String, EObject>
	val idToEObjectMapAdapter = new AdapterImpl {
		override notifyChanged(Notification notification) {
			if (notification.feature === OmlPackage.Literals.MEMBER__NAME) {
				if (notification.oldValue !== null) {
					if (idToEObjectMap.remove(notification.oldValue) !== null) {
						if (notification.newValue !== null) {
							idToEObjectMap.put(notification.newValue as String, notification.notifier as EObject)
						}
					}
				}
			}
		}
	} 

	new(URI uri) {
		super(uri)
		getDefaultSaveOptions().put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		intrinsicIDToEObjectMap = idToEObjectMap
	}
	
	override attached(EObject eObject) {
		super.attached(eObject)
		if (eObject instanceof Member) {
			eObject.eAdapters.add(idToEObjectMapAdapter)
		}
	}

	override detached(EObject eObject) {
		if (eObject instanceof Member) {
			eObject.eAdapters.remove(idToEObjectMapAdapter)
		}
		super.detached(eObject)
	}

	override doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
	    // this option is set by the Sample Reflective Ecore Model Editor; unset it
	    val mergedOptions = new HashMap<Object, Object>(options);
		mergedOptions.remove(XMIResource.OPTION_LINE_WIDTH)
		super.doSave(outputStream, mergedOptions)
	}

}
