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
package io.opencaesar.oml.dsl.ui

import io.opencaesar.oml.dsl.resource.OmlSynchronizedXtextResourceSet
import io.opencaesar.oml.dsl.ui.hyperlinking.OmlHyperlinkHelper
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class OmlUiModule extends AbstractOmlUiModule {
	
	def Class<? extends XtextResourceSet> bindXtextResourceSet() {
		OmlSynchronizedXtextResourceSet
	}
	
	override Class<? extends PrefixMatcher> bindPrefixMatcher() {
		return FQNPrefixMatcher2;
	}

	def Class<? extends HyperlinkHelper> bindHyperlinkHelper() {
		return OmlHyperlinkHelper;
	}

	static class FQNPrefixMatcher2 extends FQNPrefixMatcher {

		override boolean isCandidateMatchingPrefix(String name, String prefix) {
			delimiter = '#'
			if (super.isCandidateMatchingPrefix(name, prefix)) {
				return true
			}
			delimiter = '/'
			if (super.isCandidateMatchingPrefix(name, prefix)) {
				return true
			}
			delimiter = ':'
			if (super.isCandidateMatchingPrefix(name, prefix)) {
				return true
			}
			return false;
		}
	}
}
