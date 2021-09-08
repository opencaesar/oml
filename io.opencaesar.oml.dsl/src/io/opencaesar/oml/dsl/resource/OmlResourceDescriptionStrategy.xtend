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
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.util.IAcceptor

class OmlResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
	
	override boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (eObject instanceof Ontology) {
			val qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName !== null) {
				acceptor.accept(EObjectDescription.create(qualifiedName, eObject, newHashMap(
					"namespace" -> eObject.ontology.namespace,
					"prefix" -> eObject.ontology.prefix)));
			}
			return true
		} else if (eObject instanceof Member) {
			val qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName !== null) {
				acceptor.accept(EObjectDescription.create(qualifiedName, eObject, newHashMap(
					"defaultPrefix" -> eObject.ontology.prefix)));
			}
			return true;
		}
		return false
	}

}