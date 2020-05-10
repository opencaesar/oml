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

import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolKindProvider
import org.eclipse.emf.ecore.EClass

import static io.opencaesar.oml.OmlPackage.Literals.*
import static org.eclipse.lsp4j.SymbolKind.*

class OmlDocumentSymbolKindProvider extends DocumentSymbolKindProvider {

	override protected getSymbolKind(EClass clazz) {
		return switch (clazz) {
			case ONTOLOGY.isSuperTypeOf(clazz): Package
			case ASPECT.isSuperTypeOf(clazz): Interface
			case CONCEPT.isSuperTypeOf(clazz): Class
			case STRUCTURE.isSuperTypeOf(clazz): Struct
			case FACETED_SCALAR.isSuperTypeOf(clazz): String
			case ENUMERATED_SCALAR.isSuperTypeOf(clazz): Enum
			case RELATION_ENTITY.isSuperTypeOf(clazz): Class
			case FORWARD_RELATION.isSuperTypeOf(clazz): Property
			case REVERSE_RELATION.isSuperTypeOf(clazz): Property
			case ANNOTATION_PROPERTY.isSuperTypeOf(clazz): Property
			case SCALAR_PROPERTY.isSuperTypeOf(clazz): Property
			case STRUCTURED_PROPERTY.isSuperTypeOf(clazz): Property
			case CONCEPT_INSTANCE.isSuperTypeOf(clazz): Object
			case RELATION_INSTANCE.isSuperTypeOf(clazz): Object
			default: Property
		}
	}

}
