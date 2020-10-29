package io.opencaesar.oml.dsl.ide.diagram;

import org.eclipse.sprotty.xtext.IDiagramGenerator;

import com.google.inject.Provider;

public class OmlDiagramViewGeneratorProvider implements Provider<IDiagramGenerator> {

	@Override
	public IDiagramGenerator get() {
		return new OmlDiagramViewGenerator();
	}

}
