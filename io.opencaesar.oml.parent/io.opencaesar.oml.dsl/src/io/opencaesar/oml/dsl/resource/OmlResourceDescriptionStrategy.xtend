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
package io.opencaesar.oml.dsl.resource

import io.opencaesar.oml.Member
import io.opencaesar.oml.Ontology
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.util.IAcceptor

import static extension io.opencaesar.oml.util.OmlRead.*

class OmlResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
	
	public static val IMPORTS = "imports"
	
	override boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if(eObject instanceof Ontology) {
			this.createEObjectDescriptionForOntology(eObject, acceptor)
			return true
		}
		else if (eObject instanceof Member) {
			return super.createEObjectDescriptions(eObject, acceptor)
		}
		return false
	}

	def createEObjectDescriptionForOntology(Ontology ontology, IAcceptor<IEObjectDescription> acceptor) {
		var Map<String, String> userData
		val uris = ontology.closure[importedOntologies].filter[it !== ontology].map[eResource.URI]
		if (!uris.empty) {
			userData = new HashMap
			userData.put(IMPORTS, uris.join(","))
		}
		acceptor.accept(EObjectDescription.create(QualifiedName.create(ontology.iri), ontology, userData))
	}
}