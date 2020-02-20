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

import org.eclipse.sprotty.SGraph
import org.eclipse.sprotty.SModelRoot
import org.eclipse.sprotty.layout.ElkLayoutEngine
import org.eclipse.sprotty.layout.SprottyLayoutConfigurator
import java.io.ByteArrayOutputStream
import org.apache.log4j.Logger
import org.eclipse.elk.alg.layered.options.LayeredOptions
import org.eclipse.elk.core.math.ElkPadding
import org.eclipse.elk.core.options.CoreOptions
import org.eclipse.elk.core.options.Direction
import org.eclipse.elk.graph.ElkNode
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl

class OmlLayoutEngine extends ElkLayoutEngine {
	
	static val LOG = Logger.getLogger(OmlLayoutEngine)
	
	override layout(SModelRoot root) {
		if (root instanceof SGraph) {
			val configurator = new SprottyLayoutConfigurator
			configurator.configureByType('graph')
				.setProperty(CoreOptions.DIRECTION, Direction.UP)
				.setProperty(CoreOptions.SPACING_NODE_NODE, 30.0)
				.setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, 30.0)
				// TODO: enable when ELK is fixed:
				// https://github.com/eclipse/elk/issues/226
//				.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN)
//				.setProperty(LayeredOptions.CROSSING_MINIMIZATION_GREEDY_SWITCH_TYPE, GreedySwitchType.OFF)
			configurator.configureByType('node:module')
				.setProperty(CoreOptions.DIRECTION, Direction.UP)
				.setProperty(CoreOptions.SPACING_NODE_NODE, 100.0)
				.setProperty(CoreOptions.SPACING_EDGE_NODE, 30.0)
				.setProperty(CoreOptions.SPACING_EDGE_EDGE, 15.0)
				.setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, 30.0)
				.setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 100.0)
				.setProperty(CoreOptions.PADDING, new ElkPadding(50))
			layout(root, configurator)
		}
	}
	
	override protected applyEngine(ElkNode elkGraph) {
		if (LOG.isTraceEnabled)
			LOG.info(elkGraph.toXMI)
		super.applyEngine(elkGraph)
	}
	
	private def toXMI(ElkNode elkGraph) {
		val resourceSet = new ResourceSetImpl
		val resource = resourceSet.createResource(URI.createFileURI('output.elkg'))
		resource.contents += elkGraph
		val outputStream = new ByteArrayOutputStream
		resource.save(outputStream, emptyMap)
		return outputStream.toString
	}
	
}