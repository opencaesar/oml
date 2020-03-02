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

import io.opencaesar.oml.Import
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

import static extension io.opencaesar.oml.util.OmlRead.*
import io.opencaesar.oml.OmlPackage

class OmlXMIResource extends XMIResourceImpl {

	public static val EXTENSION = "omlxmi"

	new(URI uri) {
		super(uri)
		getDefaultSaveOptions().put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
	}

	override attached(EObject eObject) {
		if (eObject instanceof Import) {
			eAdapters += new AdapterImpl {
	  			override notifyChanged(Notification notification) {
	  				super.notifyChanged(notification)
	  				if (notification.feature === OmlPackage.Literals.IMPORT__URI) {
						eObject.importedOntology
					}
	  			}
			}
			eObject.importedOntology
		}
	}

	override doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
	    // this option is set by the Sample Reflective Ecore Model Editor; unset it
	    val mergedOptions = new HashMap<Object, Object>(options);
		mergedOptions.remove(XMIResource.OPTION_LINE_WIDTH)
		super.doSave(outputStream, mergedOptions)
	}

}
