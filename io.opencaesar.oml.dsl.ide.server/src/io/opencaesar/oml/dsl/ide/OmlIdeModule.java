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

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import io.opencaesar.oml.dsl.ide.server.OmlProjectManager;
import io.opencaesar.oml.dsl.ide.symbols.OmlDocumentSymbolKindProvider;
import io.opencaesar.oml.dsl.ide.symbols.OmlDocumentSymbolNameProvider;
import io.opencaesar.oml.dsl.ide.symbols.OmlHierarchicalDocumentSymbolService;
import io.opencaesar.oml.dsl.ide.server.codeActions.OmlCodeActionService;

import io.opencaesar.oml.dsl.resource.OmlXtextResourceSetProvider;
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolKindProvider;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolNameProvider;
import org.eclipse.xtext.ide.server.symbol.HierarchicalDocumentSymbolService;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

/**
 * Use this class to register ide components.
 */
public class OmlIdeModule extends AbstractOmlIdeModule {

	@Override
	public void configure(final Binder binder) {
		binder.bind(IPreferenceValuesProvider.class).annotatedWith(FormatterPreferences.class).to(FormatterPreferenceValuesProvider.class);
		binder.bind(String.class).annotatedWith(Names.named(ImportUriResolver.IMPORT_URI_FEATURE)).toInstance("uri");
		binder.bind(XtextResourceSet.class).toProvider(OmlXtextResourceSetProvider.class);
		super.configure(binder);
		return;
	}

	public Class<? extends ProjectManager> bindProjectManager() {
		return OmlProjectManager.class;
	}
	public Class<? extends Provider<XtextResourceSet>> provideResourceSet() {
		return OmlXtextResourceSetProvider.class;
	}

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
