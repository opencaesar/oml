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
package io.opencaesar.oml.dsl.ui;

import io.opencaesar.oml.dsl.resource.OmlSynchronizedXtextResourceSet;
import io.opencaesar.oml.dsl.ui.hyperlinking.OmlHyperlinkHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@SuppressWarnings("all")
public class OmlUiModule extends AbstractOmlUiModule {

	public Class<? extends XtextResourceSet> bindXtextResourceSet() {
		return OmlSynchronizedXtextResourceSet.class;
	}

	@Override
	public Class<? extends PrefixMatcher> bindPrefixMatcher() {
		return OmlUiModule.FQNPrefixMatcher2.class;
	}

	public Class<? extends HyperlinkHelper> bindHyperlinkHelper() {
		return OmlHyperlinkHelper.class;
	}

	public OmlUiModule(final AbstractUIPlugin plugin) {
		super(plugin);
	}

	public static class FQNPrefixMatcher2 extends FQNPrefixMatcher {
		@Override
		public boolean isCandidateMatchingPrefix(final String name, final String prefix) {
			this.setDelimiter('#');
			if (super.isCandidateMatchingPrefix(name, prefix)) {
				return true;
			}
			this.setDelimiter('/');
			if (super.isCandidateMatchingPrefix(name, prefix)) {
				return true;
			}
			this.setDelimiter(':');
			if (super.isCandidateMatchingPrefix(name, prefix)) {
				return true;
			}
			return false;
		}
	}
}
