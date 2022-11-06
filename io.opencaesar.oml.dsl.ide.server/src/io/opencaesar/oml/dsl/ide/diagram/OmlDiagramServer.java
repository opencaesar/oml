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
package io.opencaesar.oml.dsl.ide.diagram;

import org.eclipse.sprotty.Action;
import org.eclipse.sprotty.xtext.LanguageAwareDiagramServer;
import org.eclipse.sprotty.xtext.ReconnectAction;

@SuppressWarnings("all")
public class OmlDiagramServer extends LanguageAwareDiagramServer {

	@Override
	public void handleAction(final Action action) {
		switch (action.getKind()) {
		case FilterAction.KIND:
			this.handle(((FilterAction) action));
			break;
		case ReconnectAction.KIND:
			super.handleAction(action);
			break;
		}
		super.handleAction(action);
	}

	protected void handle(final FilterAction action) {
		System.out.println("FilterAction.data = " + action.getData());
		this.getOptions().put("filterAction", action.getData());
		this.getDiagramLanguageServer().getDiagramUpdater().updateDiagram(this);
	}
}
