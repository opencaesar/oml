package io.opencaesar.oml.dsl.ui.contentassist;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.xtext.ui.JdtTypesProposalProvider.FQNShortener;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;

import io.opencaesar.oml.Import;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.util.OmlRead;

public class FQNImporter extends FQNShortener {
	
	private final ITextViewer viewer;

	public FQNImporter(Resource context, ITextViewer viewer, IScope scope, IQualifiedNameConverter qualifiedNameConverter, IValueConverter<String> valueConverter) {
		super(context, scope, qualifiedNameConverter, valueConverter);
		this.viewer = viewer;
	}

	@Override
	public void apply(IDocument document, ConfigurableCompletionProposal proposal) throws BadLocationException {
		String proposalReplacementString = proposal.getReplacementString();
		String memberName = proposalReplacementString;
		if (valueConverter != null) {
			memberName = valueConverter.toValue(proposalReplacementString, null);
		}
		String replacementString = getActualReplacementString(proposal);
		// there is an import statement - apply computed replacementString
		if (!proposalReplacementString.equals(replacementString)) {
			String shortTypeName = replacementString;
			if (valueConverter != null) {
				shortTypeName = valueConverter.toValue(replacementString, null);
			}
			QualifiedName shortQualifiedName = qualifiedNameConverter.toQualifiedName(shortTypeName);
			if (shortQualifiedName.getSegmentCount() == 1) {
				proposal.setCursorPosition(replacementString.length());
				document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(), replacementString);
				return;
			}
		}

		QualifiedName qualifiedName = qualifiedNameConverter.toQualifiedName(memberName);
		if (qualifiedName.getSegmentCount() == 1) {
			// type resides in default package - no need to hassle with imports
			proposal.setCursorPosition(proposalReplacementString.length());
			document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(),
					proposalReplacementString);
			return;
		}

		IEObjectDescription description = scope.getSingleElement(qualifiedName.skipFirst(qualifiedName.getSegmentCount() - 1));
		if (description != null) {
			// there exists a conflict - insert fully qualified name
			proposal.setCursorPosition(proposalReplacementString.length());
			document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(),
					proposalReplacementString);
			return;
		}
		
		description = scope.getSingleElement(qualifiedName);
		var prefix = description.getUserData("defaultPrefix");
		var namespace = qualifiedName.getFirstSegment();
		var separator = namespace.charAt(namespace.length()-1);
	
		var isImportedVocabulary = OmlPackage.Literals.TERM.isSuperTypeOf(description.getEClass());
		var isContextVocabulary = OmlRead.getOntology(context) instanceof Vocabulary;
		String importKeyword;
		if (isImportedVocabulary == isContextVocabulary) {
			importKeyword = "extends";
		} else {
			importKeyword = "uses";
		}

		int topPixel = -1;
		// store the pixel coordinates to prevent the ui from flickering
		StyledText widget = viewer.getTextWidget();
		if (widget != null)
			topPixel = widget.getTopPixel();
		ITextViewerExtension viewerExtension = null;
		if (viewer instanceof ITextViewerExtension) {
			viewerExtension = (ITextViewerExtension) viewer;
			viewerExtension.setRedraw(false);
		}
		try {
			// Import does not introduce ambiguities - add import and insert short name
			String shortName = qualifiedName.getLastSegment();
			String escapedShortname = shortName;
			if (valueConverter != null) {
				escapedShortname = valueConverter.toString(shortName);
			}
			escapedShortname = prefix+":"+escapedShortname;
			
			proposal.setCursorPosition(escapedShortname.length());
			document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(), escapedShortname);

			// compute import statement's offset
			int offset = 0;
			boolean startWithLineBreak = true;
			boolean endWithLineBreak = false;
			Ontology ontology = (Ontology) context.getContents().get(0);
			List<Import> importDirectives = OmlRead.getImports(ontology);
			if (importDirectives.isEmpty()) {
				List<Statement> statements = OmlRead.getStatements(ontology);
				if (statements.isEmpty()) {
					ICompositeNode node = NodeModelUtils.getNode(ontology);
					offset = findOffsetOfKeyword(node, "{") + 1;
				} else {
					startWithLineBreak = false;
					ICompositeNode node = NodeModelUtils.getNode(statements.get(0));
					offset = node.getOffset();
					endWithLineBreak = true;
				}
			} else {
				ICompositeNode node = NodeModelUtils.getNode(importDirectives.get(importDirectives.size() - 1));
				offset = node.getOffset() + node.getLength();
			}
			if (proposal.getReplacementOffset() < offset) {
				offset += escapedShortname.length();
			}
			
			// add import statement
			int lineOfOffset = document.getLineOfOffset(offset);
			String lineDelimiter = document.getLineDelimiter(lineOfOffset);
			if (lineDelimiter == null && lineOfOffset > 0) {
				lineDelimiter = document.getLineDelimiter(lineOfOffset - 1);
			}
			String importNamespace = qualifiedName.getFirstSegment();
			String importIri = importNamespace.substring(0, importNamespace.length()-1);
			String importStatement = (startWithLineBreak ? lineDelimiter + lineDelimiter +"\t" : "") + 
					importKeyword+" " + valueConverter.toString(importIri) + ((separator != '#') ? " with "+separator : "")+ " as "+prefix;
			if (endWithLineBreak)
				importStatement += lineDelimiter + lineDelimiter+"\t";
			document.replace(offset, 0, importStatement.toString());
			if (proposal.getReplacementOffset() < offset) {
				proposal.setCursorPosition(proposal.getCursorPosition() + importStatement.length());
			}

			// set the pixel coordinates
			if (widget != null) {
				int additionalTopPixel = 0;
				if (startWithLineBreak)
					additionalTopPixel += 2 * widget.getLineHeight();
				if (endWithLineBreak)
					additionalTopPixel += 2 * widget.getLineHeight();
				widget.setTopPixel(topPixel + additionalTopPixel);
			}
		} finally {
			if (viewerExtension != null) {
				viewerExtension.setRedraw(true);
			}
		}
	}
	
	private int findOffsetOfKeyword(INode node, String keyword) {
		var i = node.getAsTreeIterable().iterator();
		while (i.hasNext()) {
			INode next = i.next();
			if (next.getGrammarElement() instanceof Keyword) {
				var e = (Keyword) next.getGrammarElement();
				if (e.getValue().equals(keyword)) {
					return next.getOffset();
				}
			}
		}
		return node.getOffset();
	}
}