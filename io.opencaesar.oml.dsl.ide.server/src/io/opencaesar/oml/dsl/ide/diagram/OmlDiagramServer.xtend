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
package io.opencaesar.oml.dsl.ide.diagram

import org.eclipse.sprotty.Action
import org.eclipse.sprotty.xtext.LanguageAwareDiagramServer
import org.eclipse.sprotty.xtext.ReconnectAction

class OmlDiagramServer extends LanguageAwareDiagramServer {
	
	override handleAction(Action action) {
		switch(action.getKind()) {
			case FilterAction.KIND: {
				handle(action as FilterAction)
			}
			case ReconnectAction.KIND: {
				// TODO: Does this action make sense in OML?
				// If so, then how to configure it to allow well-formed connections only?
				super.handleAction(action)
			}
		}
		super.handleAction(action)
	}

	def protected handle(FilterAction action) {
		System.out.println("FilterAction.data = " + action.data)
		options.put("filterAction", action.data)
		diagramLanguageServer.diagramUpdater.updateDiagram(this)
	}
}
