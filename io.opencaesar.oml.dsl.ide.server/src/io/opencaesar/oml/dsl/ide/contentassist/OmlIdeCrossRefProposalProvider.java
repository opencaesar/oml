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
package io.opencaesar.oml.dsl.ide.contentassist;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescription;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.dsl.conversion.RefValueConverter;
import io.opencaesar.oml.util.OmlRead;

public class OmlIdeCrossRefProposalProvider extends IdeCrossrefProposalProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private RefValueConverter valueConverter;

	protected ContentAssistEntry createProposal(IEObjectDescription candidate, CrossReference crossRef, ContentAssistContext context) {
		// creat the default proposal
		var entry = super.createProposal(candidate, crossRef, context);
		if (entry == null) {
			return entry;
		}

		// get the name and the import prefix
		var memberName = candidate.getName();
		var importPrefix = candidate.getUserData("defaultPrefix");

		// fix the proposed name
		if (candidate instanceof AliasedEObjectDescription) {
			// if there is an name, convert it to a string
			var proposal = valueConverter.toString(qualifiedNameConverter.toString(memberName));
			entry.setProposal(proposal);
		} else {
			// otherwise default the name to the abbreviated iri
			var fragment = memberName.getLastSegment();
			var proposal = ((importPrefix != null) ? importPrefix + ":" : "") + fragment;
			entry.setProposal(proposal);
		}

		// if the import statement already exists
		if (!(candidate instanceof SerializableEObjectDescription)) {
			return entry;
		}

		// get the context ontology
		var ontology = (Ontology) context.getRootModel();

		// calculate the offset of the import statement
		var offset = 0;
		var startWithLineBreak = true;
		var endWithLineBreak = false;
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

		// calculate the text of the import statement
		var lineDelimiter = "\n";
		var importKeyword = getImportKeyword(ontology.eClass(), candidate.getEClass());
		var importNamespace = memberName.getFirstSegment();
		var importStatement = (startWithLineBreak ? lineDelimiter + lineDelimiter + "\t" : "") + importKeyword + " " + valueConverter.toString(importNamespace) + " as " + importPrefix
				+ (endWithLineBreak ? lineDelimiter + lineDelimiter + "\t" : "");

		// add the import statement
		var tr = new TextRegion(offset, 0);
		var rg = new ReplaceRegion(tr, importStatement);
		entry.getTextReplacements().add(rg);

		return entry;
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
		var importedOntology = OmlPackage.Literals.NAMED_INSTANCE.isSuperTypeOf(importedFeature) ? OmlPackage.Literals.DESCRIPTION : OmlPackage.Literals.VOCABULARY;
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
