/*
 * Copyright 2019 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opencaesar.oml.dsl	

import com.google.inject.Binder	
import com.google.inject.name.Names	
import io.opencaesar.oml.dsl.conversion.OmlQualifiedNameConverter	
import io.opencaesar.oml.dsl.conversion.OmlValueConverterService	
import io.opencaesar.oml.dsl.naming.OmlQualifiedNameProvider	
import io.opencaesar.oml.dsl.resource.OmlResourceDescriptionStrategy	
import io.opencaesar.oml.dsl.resource.OmlXtextResourceSetProvider	
import io.opencaesar.oml.dsl.scoping.OmlImportUriGlobalScopeProvider	
import io.opencaesar.oml.dsl.scoping.OmlImportedNamespaceAwareLocalScopeProvider	
import org.eclipse.xtext.conversion.IValueConverterService	
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider	
import org.eclipse.xtext.formatting2.FormatterPreferences	
import org.eclipse.xtext.naming.IQualifiedNameConverter	
import org.eclipse.xtext.naming.IQualifiedNameProvider	
import org.eclipse.xtext.preferences.IPreferenceValuesProvider	
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy	
import org.eclipse.xtext.resource.XtextResourceSet	
import org.eclipse.xtext.scoping.IGlobalScopeProvider	
import org.eclipse.xtext.scoping.IScopeProvider	
import org.eclipse.xtext.scoping.impl.ImportUriResolver	

/**	
 * Use this class to register components to be used at runtime / without the Equinox extension registry.	
 */	
class OmlRuntimeModule extends AbstractOmlRuntimeModule {	

	override void configure(Binder binder) {	
		binder.bind(IPreferenceValuesProvider).annotatedWith(FormatterPreferences).to(FormatterPreferenceValuesProvider)	
		binder.bind(String).annotatedWith(Names.named(ImportUriResolver.IMPORT_URI_FEATURE)).toInstance("uri")	
		binder.bind(XtextResourceSet).toProvider(OmlXtextResourceSetProvider)	
		super.configure(binder)	
	}	

	def Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {	
		OmlResourceDescriptionStrategy	
	}	

	override Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {	
		OmlImportUriGlobalScopeProvider	
	}	

	override Class<? extends IScopeProvider> bindIScopeProvider() {	
		OmlImportedNamespaceAwareLocalScopeProvider	
	}	

	override Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {	
		OmlQualifiedNameProvider	
	}	

	def Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {	
		OmlQualifiedNameConverter	
	}	

	override Class<? extends IValueConverterService> bindIValueConverterService() {	
		OmlValueConverterService	
	}	

	override Class<? extends XtextResourceSet> bindXtextResourceSet() {	
		// If this method returns OmlSynchronizedXtextResourceSet.class instead of null, then the server fails with:
		//
		// Caused by: java.lang.ArrayIndexOutOfBoundsException: Index 12143 out of bounds for length 2090
		//
		null	
	}	
}