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

import com.google.inject.Inject
import org.eclipse.sprotty.IDiagramServer
import org.eclipse.sprotty.IPopupModelFactory
import org.eclipse.sprotty.RequestPopupModelAction
import org.eclipse.sprotty.SModelElement
import org.eclipse.sprotty.xtext.ILanguageAwareDiagramServer
import org.eclipse.sprotty.xtext.tracing.ITraceProvider
//import io.typefox.sprotty.server.xtext.tracing.Traceable

class OmlPopupModelFactory implements IPopupModelFactory {

	@Inject extension ITraceProvider

	override createPopupModel(SModelElement element, RequestPopupModelAction request, IDiagramServer server) {
		if (element.trace !== null) {
			val future = element.withSource(server as ILanguageAwareDiagramServer) [ statement, context |
				null
			]
			future.get
		} else {
			null
		}
	}

}
