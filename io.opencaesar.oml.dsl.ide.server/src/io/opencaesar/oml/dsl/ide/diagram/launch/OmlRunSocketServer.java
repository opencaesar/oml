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
package io.opencaesar.oml.dsl.ide.diagram.launch;

import org.eclipse.sprotty.xtext.launch.DiagramLanguageServerSetup;
import org.eclipse.sprotty.xtext.launch.DiagramServerSocketLauncher;

import io.opencaesar.oml.dsl.ide.diagram.launch.OmlLanguageServerSetup;

@SuppressWarnings("all")
public class OmlRunSocketServer extends DiagramServerSocketLauncher {

	@Override
	public DiagramLanguageServerSetup createSetup() {
		return new OmlLanguageServerSetup();
	}

	public static void main(final String... args) {
		new OmlRunSocketServer().run(args);
	}
}
