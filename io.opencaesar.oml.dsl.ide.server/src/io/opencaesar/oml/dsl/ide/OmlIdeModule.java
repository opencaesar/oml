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

import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.ide.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ide.editor.contentassist.IPrefixMatcher;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolKindProvider;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolNameProvider;
import org.eclipse.xtext.ide.server.symbol.HierarchicalDocumentSymbolService;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

import com.google.inject.Binder;
import com.google.inject.name.Names;

import io.opencaesar.oml.dsl.ide.contentassist.OmlIdeContentProposalProvider;
import io.opencaesar.oml.dsl.ide.contentassist.OmlIdeCrossRefProposalProvider;
import io.opencaesar.oml.dsl.ide.server.codeActions.OmlCodeActionService;
import io.opencaesar.oml.dsl.ide.server.symbols.OmlDocumentSymbolKindProvider;
import io.opencaesar.oml.dsl.ide.server.symbols.OmlDocumentSymbolNameProvider;
import io.opencaesar.oml.dsl.ide.server.symbols.OmlHierarchicalDocumentSymbolService;
import io.opencaesar.oml.dsl.resource.OmlSynchronizedXtextResourceSet;

/**
 * Use this class to register ide components.
 */
public class OmlIdeModule extends AbstractOmlIdeModule {

	@Override
	public void configure(final Binder binder) {
		binder.bind(IPreferenceValuesProvider.class).annotatedWith(FormatterPreferences.class).to(FormatterPreferenceValuesProvider.class);
		binder.bind(String.class).annotatedWith(Names.named(ImportUriResolver.IMPORT_URI_FEATURE)).toInstance("uri");
		super.configure(binder);
		return;
	}

	public Class<? extends XtextResourceSet> bindXtextResourceSet() {
		return OmlSynchronizedXtextResourceSet.class;
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

	public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		return OmlIdeContentProposalProvider.class;
	}

	public Class<? extends IdeCrossrefProposalProvider> bindIdeCrossrefProposalProvider() {
		return OmlIdeCrossRefProposalProvider.class;
	}

	public Class<? extends IPrefixMatcher> bindIPrefixMatcher() {
		return FQNPrefixMatcher2.class;
	}

	static public class FQNPrefixMatcher2 extends FQNPrefixMatcher {

		private String delimiter;

		@Override
		public boolean isCandidateMatchingPrefix(String name, String prefix) {
			delimiter = "#";
			if (super.isCandidateMatchingPrefix(name, prefix)) {
				return true;
			}
			delimiter = "/";
			if (super.isCandidateMatchingPrefix(name, prefix)) {
				return true;
			}
			delimiter = ":";
			if (super.isCandidateMatchingPrefix(name, prefix)) {
				return true;
			}
			return false;
		}

		public String getDelimiter() {
			return delimiter;
		}
	}
}
