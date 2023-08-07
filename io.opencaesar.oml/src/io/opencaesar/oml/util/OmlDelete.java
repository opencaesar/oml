/**
 * 
 * Copyright 2023 California Institute of Technology ("Caltech").
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

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import io.opencaesar.oml.Element;
import io.opencaesar.oml.Member;

/**
 * Utilities to help delete Oml elements 
 */
public class OmlDelete {

    /**
     * Deletes the given element only
     * 
     * @param element the given element to delete
     */
    public static void delete(Element element) {
        EcoreUtil.delete(element);
        
    }

    /**
     * Deletes the given element and recursively all its referencing elements
     * 
     * @param element the given element to delete
     */
    public static void deleteRecursively(Element element) {
        var referencers = findReferencersToDelete(element);
        for (var referencer : referencers) {
        	delete(referencer);
        }
        delete(element);
        
    }

    /**
     * Returns a set of referencing elements that should be deleted if the given element is deleted
     * 
     * @param element the element to be deleted
     * @return the set of elements that also should be deleted if the given element is to be deleted
     */
	public static Set<Element> findReferencersToDelete(Element element) {
        final Set<Element> referencers = new LinkedHashSet<>();
        for (Setting setting : OmlSearch.findInverseReferencers(element)) {
        	var referencer = setting.getEObject();
        	if (referencer instanceof Element) {
	            if (referencer instanceof Member) {
	            	var member = (Member) referencer;
	            	if (!member.isRef()) {
	            		referencers.addAll(findReferencersToDelete(member));
	            	}
	            }
	        	referencers.add((Element)referencer);
        	}
        }
        return referencers;
	}

}
