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

import java.util.Optional;

import org.eclipse.emf.ecore.EClass;

import io.opencaesar.oml.Element;
import io.opencaesar.oml.OmlFactory;
import io.opencaesar.oml.OmlPackage;

public class OmlFactory2 {

	static final OmlFactory FACTORY = OmlFactory.eINSTANCE;

	public static OmlFactory2 INSTANCE = new OmlFactory2();

	private OmlFactory2() {
	}

	public <T extends Element> T create(final Class<T> type) {
		Element element = null;

		Optional<EClass> eClass = OmlPackage.eINSTANCE.getEClassifiers().stream().
			filter(c -> c instanceof EClass).
			map(c -> (EClass)c).
			filter(c -> c.getInstanceClass() == type).
			findFirst();
		
		if (eClass.isPresent()) {
			element = (Element) FACTORY.create(eClass.get());
		}
		
		return type.cast(element);
	}
}