/**
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
 */
package io.opencaesar.oml.dsl.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.CancelableDiagnostician;

import com.google.inject.Inject;

import io.opencaesar.oml.Member;
import io.opencaesar.oml.Ontology;

public class OmlDiagnostician extends CancelableDiagnostician {

	@Inject
	public OmlDiagnostician(Registry registry) {
		super(registry);
	}

	@Override
	public String getObjectLabel(EObject eObject) {
		String type = eObject.eClass().getName();
		String name = "";
		if (eObject.eIsProxy()) {
			return "";
		} else if (eObject instanceof Member) {
			name = ((Member)eObject).getAbbreviatedIri();
		} else if (eObject instanceof Ontology) {
	    	name = ((Ontology)eObject).getNamespace();
	    }
	    return type + (name.length()>0 ? " "+name : "");
	}
	
}
