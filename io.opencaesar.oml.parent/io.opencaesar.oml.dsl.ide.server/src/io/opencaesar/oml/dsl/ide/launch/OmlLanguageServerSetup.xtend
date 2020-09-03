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
package io.opencaesar.oml.dsl.ide.launch

import com.google.gson.GsonBuilder
import org.eclipse.sprotty.xtext.launch.DiagramLanguageServerSetup
import org.eclipse.sprotty.layout.ElkLayoutEngine
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider
import org.eclipse.elk.alg.graphviz.layouter.GraphvizMetaDataProvider
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.elk.core.util.persistence.ElkGraphResourceFactory
import org.eclipse.sprotty.server.json.ActionTypeAdapter
import org.eclipse.sprotty.server.json.EnumTypeAdapter
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.sprotty.xtext.ls.SyncDiagramServerModule
import org.eclipse.xtext.util.Modules2
import io.opencaesar.oml.dsl.ide.diagram.FilterAction

class OmlLanguageServerSetup extends DiagramLanguageServerSetup {
	override setupLanguages() {
		ElkLayoutEngine.initialize(new LayeredMetaDataProvider)
		ElkLayoutEngine.initialize(new GraphvizMetaDataProvider)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put('elkg', new ElkGraphResourceFactory)
	}
	
	override configureGson(GsonBuilder gsonBuilder) {
		val factory = new ActionTypeAdapter.Factory()
		factory.addActionKind(FilterAction.KIND, FilterAction)
		gsonBuilder
			.registerTypeAdapterFactory(factory)
			.registerTypeAdapterFactory(new EnumTypeAdapter.Factory)
	}
	
	override getLanguageServerModule() {
		Modules2.mixin(
			new ServerModule,
			new SyncDiagramServerModule
		)
	}
}