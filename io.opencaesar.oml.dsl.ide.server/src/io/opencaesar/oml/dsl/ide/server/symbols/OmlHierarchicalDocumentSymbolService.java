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
package io.opencaesar.oml.dsl.ide.server.symbols;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.server.symbol.HierarchicalDocumentSymbolService;

import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.util.OmlRead;

public class OmlHierarchicalDocumentSymbolService extends HierarchicalDocumentSymbolService {

	protected Iterator<Object> getAllContents(Resource resource) {
		final Ontology o = OmlRead.getOntology(resource);
		return OmlRead.getStatements(o).stream().flatMap(s -> {
			final ArrayList<Object> rs = new ArrayList<>();
			if (s instanceof RelationEntity) {
				final RelationEntity rel = (RelationEntity) s;
				rs.add(rel);
				rs.addAll(OmlRead.getRelations(rel));
			} else {
				rs.add(s);
			}
			return rs.stream();
		}).collect(Collectors.toList()).iterator();
	}

}
