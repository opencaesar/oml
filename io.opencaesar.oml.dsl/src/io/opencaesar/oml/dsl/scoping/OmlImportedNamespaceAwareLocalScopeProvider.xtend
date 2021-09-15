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
package io.opencaesar.oml.dsl.scoping

import com.google.common.collect.Lists
import com.google.inject.Inject
import io.opencaesar.oml.Import
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.dsl.naming.OmlNamespaceImportNormalizer
import java.util.Collections
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.scoping.impl.ImportNormalizer
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider
import io.opencaesar.oml.util.OmlRead

class OmlImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider{

	@Inject IQualifiedNameConverter qnc

	override String getImportedNamespace(EObject object) {
		if (object instanceof Import) {
			object.getPrefix()
		}
	}

	override List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		if (context instanceof Ontology) {
			
			val importedNamespaceResolvers = Lists.newArrayList();
			
			// add the current ontology
			if (context.namespace !== null) {
				importedNamespaceResolvers.add(new OmlNamespaceImportNormalizer(qnc.toQualifiedName(context.namespace), context.prefix, ignoreCase))
			}
		
			// collect all local imports first (so they get priority)
			OmlRead.getImportPrefixes(context).forEach[namespace, prefix|
				if (prefix !== null && namespace !== null) {
					importedNamespaceResolvers.add(new OmlNamespaceImportNormalizer(qnc.toQualifiedName(namespace), prefix, ignoreCase))
				}
			]
			
			return importedNamespaceResolvers;
		}
		return Collections.EMPTY_LIST
	}

	
}