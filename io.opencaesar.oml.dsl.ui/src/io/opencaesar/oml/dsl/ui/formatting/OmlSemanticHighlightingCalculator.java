package io.opencaesar.oml.dsl.ui.formatting;

import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

public class OmlSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (resource == null || resource.getParseResult() == null)
			return;

		INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {
			if (node.getGrammarElement() instanceof CrossReference) {
				CrossReference ref = (CrossReference) node.getGrammarElement();
				if (ref.eContainer() instanceof Assignment) {
					Assignment a = (Assignment) ref.eContainer();
					if (a.getFeature().equals("type") || a.getFeature().equals("property")) {
						acceptor.addPosition(node.getOffset(), node.getLength(), OmlHighlightingConfiguration.CROSS_REF);
					}
				}
			}
		}
	}

}
