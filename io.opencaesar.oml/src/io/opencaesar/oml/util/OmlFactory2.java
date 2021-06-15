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

import java.util.Optional;

import org.eclipse.emf.ecore.EClass;

import io.opencaesar.oml.Element;
import io.opencaesar.oml.OmlFactory;
import io.opencaesar.oml.OmlPackage;

/**
 * The <b>Factory2</b> for the model. It allows creating OML objects reflectively using their Java type.
 * 
 * This is an alternative to {@link OmlFactory} which has individual create methods for each object type
 * 
 * @author elaasar
 */
public final class OmlFactory2 {

    /**
     * The singleton factory instance
     */
    public static OmlFactory2 INSTANCE = new OmlFactory2();

    private OmlFactory2() {
    }

    /**
     * Creates a new Oml object given a Java type
     * 
     * @param type The Java type of the Oml object
     * @return A new object that is an instance of the given type
     */
    public <T extends Element> T create(final Class<T> type) {
        Element element = null;

        Optional<EClass> eClass = OmlPackage.eINSTANCE.getEClassifiers().stream().
        filter(c -> c instanceof EClass).
        map(c -> (EClass)c).
        filter(c -> c.getInstanceClass() == type).
            findFirst();
        
        if (eClass.isPresent()) {
            element = (Element) OmlFactory.eINSTANCE.create(eClass.get());
        }
        
        return type.cast(element);
    }
}