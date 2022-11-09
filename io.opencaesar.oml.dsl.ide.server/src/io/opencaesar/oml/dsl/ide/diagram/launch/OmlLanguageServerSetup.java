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
package io.opencaesar.oml.dsl.ide.diagram.launch;

import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.elk.core.util.persistence.ElkGraphResourceFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sprotty.layout.ElkLayoutEngine;
import org.eclipse.sprotty.server.json.ActionTypeAdapter;
import org.eclipse.sprotty.server.json.EnumTypeAdapter;
import org.eclipse.sprotty.xtext.EditActionTypeAdapterFactory;
import org.eclipse.sprotty.xtext.launch.DiagramLanguageServerSetup;
import org.eclipse.sprotty.xtext.ls.SyncDiagramServerModule;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.Modules2;

import com.google.gson.GsonBuilder;

import io.opencaesar.oml.dsl.ide.diagram.FilterAction;
import io.opencaesar.oml.dsl.resource.OmlSynchronizedXtextResourceSet;

@SuppressWarnings("all")
public class OmlLanguageServerSetup extends DiagramLanguageServerSetup {

	@Override
	public void setupLanguages() {
		ElkLayoutEngine.initialize(new LayeredMetaDataProvider());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("elkg", new ElkGraphResourceFactory());
	}

	@Override
	public GsonBuilder configureGson(final GsonBuilder gsonBuilder) {
		final var factory = new ActionTypeAdapter.Factory();
		factory.addActionKind(FilterAction.KIND, FilterAction.class);
		return gsonBuilder.registerTypeAdapterFactory(factory).registerTypeAdapterFactory(new EditActionTypeAdapterFactory()).registerTypeAdapterFactory(new EnumTypeAdapter.Factory());
	}

	@Override
	public com.google.inject.Module getLanguageServerModule() {
		return Modules2.mixin(new ServerModule(), new SyncDiagramServerModule(), it -> {
			it.bind(XtextResourceSet.class).to(OmlSynchronizedXtextResourceSet.class);
		});
	}
}
