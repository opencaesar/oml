package io.opencaesar.oml.dsl.ui.formatting;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class OmlHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public final static String CROSS_REF = "CrossReference";

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(CROSS_REF, "Cross-References", crossReferenceTextStyle());
	}

	public TextStyle crossReferenceTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(168, 0, 87));
		return textStyle;
	}

}
