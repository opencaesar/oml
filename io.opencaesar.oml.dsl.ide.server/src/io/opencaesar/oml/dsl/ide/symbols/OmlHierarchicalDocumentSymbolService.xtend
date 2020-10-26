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
package io.opencaesar.oml.dsl.ide.symbols

import io.opencaesar.oml.IdentifiedElement
import io.opencaesar.oml.Reference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.ide.server.symbol.HierarchicalDocumentSymbolService

import static extension com.google.common.collect.Iterators.*

class OmlHierarchicalDocumentSymbolService extends HierarchicalDocumentSymbolService {

	override protected getAllContents(Resource resource) {
		return resource.allContents.filter(IdentifiedElement).concat(resource.allContents.filter(Reference)).filter(Object);
	}

}