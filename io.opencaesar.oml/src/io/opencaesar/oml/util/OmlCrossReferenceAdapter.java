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

import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

/**
 * An implementation of {@link ECrossReferenceAdapter} that does not resolve references
 * 
 * This is needed to only load resources on demand, while still maintaining the index
 * 
 * @author elaasar
 */
public class OmlCrossReferenceAdapter extends ECrossReferenceAdapter{

	@Override
	protected boolean resolve() {
		return false;
	}

}
