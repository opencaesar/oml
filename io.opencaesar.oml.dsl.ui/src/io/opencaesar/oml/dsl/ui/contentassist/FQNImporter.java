/**
 * 
 * Copyright 2019-2021 California Institute of Technology ("Caltech").
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
package io.opencaesar.oml.dsl.ui.contentassist;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.xtext.ui.JdtTypesProposalProvider.FQNShortener;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;

import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.util.OmlRead;

public class FQNImporter extends FQNShortener {
	
	private final ITextViewer viewer;

	public FQNImporter(Resource context, ITextViewer viewer, IScope scope, IQualifiedNameConverter qualifiedNameConverter, IValueConverter<String> valueConverter) {
		super(context, scope, qualifiedNameConverter, valueConverter);
		this.viewer = viewer;
	}

	@Override
	public void apply(IDocument document, ConfigurableCompletionProposal proposal) throws BadLocationException {
		// get the proposal
		var proposalReplacementString = proposal.getReplacementString();
		var memberName = proposalReplacementString;
		if (valueConverter != null) {
			memberName = valueConverter.toValue(proposalReplacementString, null);
		}
		String replacementString = getActualReplacementString(proposal);
		
		// if there is an import statement - apply computed replacementString
		if (!proposalReplacementString.equals(replacementString)) {
			var shortTypeName = replacementString;
			if (valueConverter != null) {
				shortTypeName = valueConverter.toValue(replacementString, null);
			}
			var shortQualifiedName = qualifiedNameConverter.toQualifiedName(shortTypeName);
			if (shortQualifiedName.getSegmentCount() == 1) {
				proposal.setCursorPosition(replacementString.length());
				document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(), replacementString);
				return;
			}
		}

		// if type is local - no need to hassle with imports
		var qualifiedName = qualifiedNameConverter.toQualifiedName(memberName);
		if (qualifiedName.getSegmentCount() == 1) {
			proposal.setCursorPosition(proposalReplacementString.length());
			document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(),
					proposalReplacementString);
			return;
		}

		// if there is an import statement, add proposal only
		var description = scope.getSingleElement(qualifiedName.skipFirst(qualifiedName.getSegmentCount() - 1));
		if (description != null) {
			proposal.setCursorPosition(proposalReplacementString.length());
			document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(), proposalReplacementString);
			return;
		}
		
		// get the import prefix
		description = scope.getSingleElement(qualifiedName);
		var importPrefix = description.getUserData("defaultPrefix");
	
		// store the pixel coordinates to prevent the ui from flickering
		int topPixel = -1;
		var widget = viewer.getTextWidget();
		if (widget != null)
			topPixel = widget.getTopPixel();
		ITextViewerExtension viewerExtension = null;
		if (viewer instanceof ITextViewerExtension) {
			viewerExtension = (ITextViewerExtension) viewer;
			viewerExtension.setRedraw(false);
		}
		
		try {
			// Import does not introduce ambiguities - add import and insert short name
			var shortName = qualifiedName.getLastSegment();
			var escapedShortname = shortName;
			if (valueConverter != null) {
				escapedShortname = valueConverter.toString(shortName);
			}
			escapedShortname = importPrefix+":"+escapedShortname;
			
			proposal.setCursorPosition(escapedShortname.length());
			document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(), escapedShortname);

			// calculate the offset of the import statement
			var offset = 0;
			var startWithLineBreak = true;
			var endWithLineBreak = false;
			var ontology = (Ontology) context.getContents().get(0);
			var importDirectives = OmlRead.getImports(ontology);
			if (importDirectives.isEmpty()) {
				var statements = OmlRead.getStatements(ontology);
				if (statements.isEmpty()) {
					var node = NodeModelUtils.getNode(ontology);
					offset = findOffsetOfKeyword(node, "{") + 1;
				} else {
					startWithLineBreak = false;
					var node = NodeModelUtils.getNode(statements.get(0));
					offset = node.getOffset();
					endWithLineBreak = true;
				}
			} else {
				var node = NodeModelUtils.getNode(importDirectives.get(importDirectives.size() - 1));
				offset = node.getOffset() + node.getLength();
			}
			if (proposal.getReplacementOffset() < offset) {
				offset += escapedShortname.length() - proposal.getReplacementLength();
			}
			
			// calculate the text of the import statement
			var lineOfOffset = document.getLineOfOffset(offset);
			var lineDelimiter = document.getLineDelimiter(lineOfOffset);
			if (lineDelimiter == null && lineOfOffset > 0) {
				lineDelimiter = document.getLineDelimiter(lineOfOffset - 1);
			}
			var importKeyword = getImportKeyword(ontology.eClass(), description.getEClass());
			var importNamespace = qualifiedName.getFirstSegment();
			var importStatement = (startWithLineBreak ? lineDelimiter + lineDelimiter +"\t" : "") + 
					importKeyword+" " + valueConverter.toString(importNamespace) + " as "+ importPrefix +
					(endWithLineBreak ? lineDelimiter + lineDelimiter+"\t" : "");
			
			// add import statement
			document.replace(offset, 0, importStatement.toString());
			if (proposal.getReplacementOffset() > offset) {
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
	
	private String getImportKeyword(EClass contextOntology, EClass importedFeature) {
		var importedOntology = OmlPackage.Literals.NAMED_INSTANCE.isSuperTypeOf(importedFeature) ?
			OmlPackage.Literals.DESCRIPTION : OmlPackage.Literals.VOCABULARY;
		if (contextOntology == importedOntology) {
			return "extends";
		}
		var contextIsVocabulary = OmlPackage.Literals.VOCABULARY_BOX.isSuperTypeOf(contextOntology);
		var importedIsVocabulary = OmlPackage.Literals.VOCABULARY_BOX.isSuperTypeOf(importedOntology);
		if ((contextIsVocabulary && !importedIsVocabulary) || (!contextIsVocabulary && importedIsVocabulary)) {
			return "uses";
		}
		return "includes";
	}
}