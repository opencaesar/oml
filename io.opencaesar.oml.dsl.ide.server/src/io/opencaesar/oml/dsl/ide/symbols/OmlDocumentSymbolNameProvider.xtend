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

import io.opencaesar.oml.AnnotationPropertyReference
import io.opencaesar.oml.AspectReference
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.EnumeratedScalarReference
import io.opencaesar.oml.FacetedScalarReference
import io.opencaesar.oml.Member
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.RelationEntityReference
import io.opencaesar.oml.RelationReference
import io.opencaesar.oml.RuleReference
import io.opencaesar.oml.ScalarPropertyReference
import io.opencaesar.oml.StructuredPropertyReference
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolNameProvider

class OmlDocumentSymbolNameProvider extends DocumentSymbolNameProvider {

	override getName(EObject object) {
		switch object {
			Ontology:
				return object.iri
			Member:
				return object.name
			RelationReference:
				return object.relation.name
			RuleReference:
				return object.rule.name
			AnnotationPropertyReference:
				return object.property.name
			AspectReference:
				return object.aspect.name
			ConceptReference:
				return object.concept.name
			RelationEntityReference:
				return object.entity.name
			EnumeratedScalarReference:
				return object.scalar.name
			FacetedScalarReference:
				return object.scalar.name
			ScalarPropertyReference:
				return object.property.name
			StructuredPropertyReference:
				return object.property.name
			default:
				return "<unnamed>"
		}
	}

}
