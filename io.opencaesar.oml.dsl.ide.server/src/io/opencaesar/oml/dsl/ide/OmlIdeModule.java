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
package io.opencaesar.oml.dsl.ide;

import io.opencaesar.oml.dsl.ide.symbols.OmlDocumentSymbolKindProvider;
import io.opencaesar.oml.dsl.ide.symbols.OmlDocumentSymbolNameProvider;
import io.opencaesar.oml.dsl.ide.symbols.OmlHierarchicalDocumentSymbolService;
import io.opencaesar.oml.dsl.ide.server.codeActions.OmlCodeActionService;

import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolKindProvider;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolNameProvider;
import org.eclipse.xtext.ide.server.symbol.HierarchicalDocumentSymbolService;

/**
 * Use this class to register ide components.
 */
public class OmlIdeModule extends AbstractOmlIdeModule {

	public Class<? extends HierarchicalDocumentSymbolService> bindHierarchicalDocumentSymbolService() {
		return OmlHierarchicalDocumentSymbolService.class;
	}

	public Class<? extends DocumentSymbolKindProvider> bindDocumentSymbolKindProvider() {
		return OmlDocumentSymbolKindProvider.class;
	}

	public Class<? extends DocumentSymbolNameProvider> bindDocumentSymbolNameProvider() {
		return OmlDocumentSymbolNameProvider.class;
	}
	
	public Class<? extends ICodeActionService2> bindICodeActionService() {
		return OmlCodeActionService.class;
	}

}
