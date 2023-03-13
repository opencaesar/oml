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
package io.opencaesar.oml.dsl.ide.server.symbols;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper;

import io.opencaesar.oml.Member;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.util.OmlRead;

@SuppressWarnings("all")
public class OmlDocumentSymbolNameProvider extends DocumentSymbolMapper.DocumentSymbolNameProvider {

	@Override public String getName(EObject object) {
		if (object instanceof Ontology)
			return ((Ontology) object).getIri();
		if (object instanceof Member)
			return ((Member) object).resolve().getName();
		return "<unnamed>";
	}

}
