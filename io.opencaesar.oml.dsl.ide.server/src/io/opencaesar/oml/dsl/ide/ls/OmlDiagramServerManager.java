package io.opencaesar.oml.dsl.ide.ls;

import org.eclipse.sprotty.xtext.IDiagramServerFactory;
import org.eclipse.sprotty.xtext.ls.DiagramServerManager;

import io.opencaesar.oml.dsl.ide.diagram.OmlDiagramServerFactory;

public class OmlDiagramServerManager extends DiagramServerManager {

	@Override
	protected IDiagramServerFactory getDiagramServerFactory(final String diagramType) {
		if (null != diagramType && OmlDiagramServerFactory.OML_DIAGRAM.equals(diagramType))
			return new OmlDiagramServerFactory();
		else
			return super.getDiagramServerFactory(diagramType);
	}
}
