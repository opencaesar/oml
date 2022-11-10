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
package io.opencaesar.oml.dsl.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;

public class OmlSynchronizedXtextResourceSet extends SynchronizedXtextResourceSet {

	public OmlSynchronizedXtextResourceSet() {
		super();
		eAdapters().add(new OmlCrossReferenceAdapter());
	}
	
	private class OmlCrossReferenceAdapter extends ECrossReferenceAdapter {
		
		@Override
		protected InverseCrossReferencer createInverseCrossReferencer() {
			return new OmlInverseCrossReferencer();
		}

		private class OmlInverseCrossReferencer extends InverseCrossReferencer {
			private static final long serialVersionUID = 1L;

			@Override
			protected void add(InternalEObject eObject, EReference eReference, EObject crossReferencedEObject) {
				if (crossReferencedEObject.eIsProxy()) {
					crossReferencedEObject = EcoreUtil.resolve(crossReferencedEObject, eObject);
				}
				super.add(eObject, eReference, crossReferencedEObject);
			}
		}
	}
}
