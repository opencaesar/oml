package io.opencaesar.oml.dsl.ide.diagram;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;
import org.eclipse.elk.alg.layered.LayeredLayoutProvider;
import org.eclipse.elk.alg.layered.options.GreedySwitchType;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.core.AbstractLayoutProvider;
import org.eclipse.elk.core.math.ElkPadding;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.options.HierarchyHandling;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.sprotty.Action;
import org.eclipse.sprotty.SGraph;
import org.eclipse.sprotty.SModelRoot;
import org.eclipse.sprotty.layout.ElkLayoutEngine;
import org.eclipse.sprotty.layout.SprottyLayoutConfigurator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

public class OmlDiagramLayeredLayoutEngine extends ElkLayoutEngine {

	private static final Logger LOG = Logger.getLogger(OmlDiagramLayeredLayoutEngine.class);

	@Override
	public void layout(SModelRoot root, Action cause) {
		if ((root instanceof SGraph)) {
			final SprottyLayoutConfigurator configurator = new SprottyLayoutConfigurator();
			
			configurator
			.configureByType(OmlDiagramModule.OmlDiagram_SGrapView)
			.setProperty(CoreOptions.DIRECTION, Direction.UP)
			.setProperty(CoreOptions.SPACING_NODE_NODE, Double.valueOf(30.0))
			.setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, Double.valueOf(30.0))
			.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN)
			.setProperty(LayeredOptions.CROSSING_MINIMIZATION_GREEDY_SWITCH_TYPE, GreedySwitchType.OFF)
			.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN);
			
			configurator
			.configureByType(OmlDiagramModule.ModuleNode_ModuleNodeView)
			.setProperty(CoreOptions.DIRECTION, Direction.UP)
			.setProperty(CoreOptions.SPACING_NODE_NODE, Double.valueOf(100.0))
			.setProperty(CoreOptions.SPACING_EDGE_NODE, Double.valueOf(30.0))
			.setProperty(CoreOptions.SPACING_EDGE_EDGE, Double.valueOf(15.0))
			.setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, Double.valueOf(30.0))
			.setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, Double.valueOf(100.0))
			.setProperty(CoreOptions.PADDING, new ElkPadding(50))
			.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN);
			
			configurator
			.configureByType(OmlDiagramModule.SLabel_SLabelView_text)
			.setProperty(CoreOptions.FONT_SIZE, 14);

			configurator
			.configureByType(OmlDiagramModule.SLabel_RestrictsLabelView)
			.setProperty(CoreOptions.FONT_SIZE, 14);

			configurator
			.configureByType(OmlDiagramModule.SLabel_RelationshipLabelView)
			.setProperty(CoreOptions.FONT_SIZE, 14);
			
			final AbstractLayoutProvider provider = new LayeredLayoutProvider();
			setEngine(provider);
			
			LOG.info("Calculating layout of: "+root.getId());
			layout(((SGraph) root), configurator, cause);
			LOG.info("Calculated layout of: "+root.getId());
		}
	}

	
	@Override
	protected void applyEngine(final ElkNode elkGraph) {
		elkGraph.setProperty(CoreOptions.DEBUG_MODE, true);
		LOG.info("Apply engine to: "+elkGraph.getIdentifier());
		if (LOG.isTraceEnabled()) {
			LOG.info(toXMI(elkGraph));
		}
		super.applyEngine(elkGraph);
		LOG.info("Applied engine to: "+elkGraph.getIdentifier());
	}

	private String toXMI(final ElkNode elkGraph) {
		try {
			final ResourceSetImpl rs = new ResourceSetImpl();
			final Resource r = rs.createResource(URI.createFileURI("output.elkg"));
			r.getContents().add(elkGraph);
			final ByteArrayOutputStream os = new ByteArrayOutputStream();
			r.save(os, CollectionLiterals.emptyMap());
			final String result = os.toString();
			os.close();
			return result;
		} catch (Throwable t) {
			throw Exceptions.sneakyThrow(t);
		}
	}
}
