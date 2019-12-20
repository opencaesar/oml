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

import org.eclipse.sprotty.Layouting
import org.eclipse.sprotty.SCompartment
import org.eclipse.sprotty.SEdge
import org.eclipse.sprotty.SGraph
import org.eclipse.sprotty.SLabel
import org.eclipse.sprotty.SNode
import org.eclipse.sprotty.SShapeElement
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class OmlGraph extends SGraph {
}

@Accessors
class OmlNode extends SNode {
	String cssClass
	Boolean expanded
}

@Accessors
class OmlEdge extends SEdge {
}

@Accessors
class OmlHeaderNode extends SCompartment {
	String cssClass
}

@Accessors
class OmlLabel extends SLabel {
}

@Accessors 
class OmlTag extends SShapeElement implements Layouting {
	String layout
	
	new() {}
	new((OmlTag)=>void initializer) {
		initializer.apply(this)
	}
}