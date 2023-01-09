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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.dsl.conversion.NAMESPACEValueConverter;
import io.opencaesar.oml.dsl.services.OmlGrammarAccess;

public class OmlIdeContentProposalProvider extends IdeContentProposalProvider {

	@Inject
	private OmlGrammarAccess omlGrammarAccess;

	@Inject
	private IGlobalScopeProvider omlGlobalScopeProvider;

	@Inject
	private NAMESPACEValueConverter qualifiedNameValueConverter;

	protected void _createProposals(RuleCall ruleCall, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		if (context.getCurrentModel() instanceof Import) {
			if (ruleCall.getRule() == omlGrammarAccess.getNAMESPACERule()) {
				complete_NAMESPACE(context.getCurrentModel(), ruleCall, context, acceptor);
			} else if (ruleCall.getRule() == omlGrammarAccess.getIDRule()) {
				complete_ID(context.getCurrentModel(), ruleCall, context, acceptor);
			}
		}
	}

	protected void complete_NAMESPACE(EObject model, RuleCall ruleCall, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		var ontology = ((Element) model).getOntology();
		var ontologyURI = EcoreUtil.getURI(ontology);
		var enumLiteral = (EnumLiteralDeclaration) context.getLastCompleteNode().getGrammarElement();
		Predicate<IEObjectDescription> predicate = null;
		if (ontology instanceof Vocabulary) {
			if (enumLiteral == omlGrammarAccess.getExtendsAccess().getExtensionEnumLiteralDeclaration()) {
				predicate = (x -> !x.getEObjectURI().equals(ontologyURI) && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.getEClass()));
			} else if (enumLiteral == omlGrammarAccess.getUsesAccess().getUsageEnumLiteralDeclaration()) {
				predicate = (x -> !x.getEObjectURI().equals(ontologyURI) && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.getEClass()));
			}
		} else if (ontology instanceof VocabularyBundle) {
			if (enumLiteral == omlGrammarAccess.getExtendsAccess().getExtensionEnumLiteralDeclaration()) {
				predicate = (x -> !x.getEObjectURI().equals(ontologyURI) && OmlPackage.Literals.VOCABULARY_BUNDLE.isSuperTypeOf(x.getEClass()));
			} else if (enumLiteral == omlGrammarAccess.getIncludesAccess().getInclusionEnumLiteralDeclaration()) {
				predicate = (x -> !x.getEObjectURI().equals(ontologyURI) && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.getEClass()));
			}
		} else if (ontology instanceof Description) {
			if (enumLiteral == omlGrammarAccess.getExtendsAccess().getExtensionEnumLiteralDeclaration()) {
				predicate = (x -> !x.getEObjectURI().equals(ontologyURI) && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.getEClass()));
			} else if (enumLiteral == omlGrammarAccess.getUsesAccess().getUsageEnumLiteralDeclaration()) {
				predicate = (x -> !x.getEObjectURI().equals(ontologyURI) && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.getEClass()));
			}
		} else if (ontology instanceof DescriptionBundle) {
			if (enumLiteral == omlGrammarAccess.getExtendsAccess().getExtensionEnumLiteralDeclaration()) {
				predicate = (x -> !x.getEObjectURI().equals(ontologyURI) && OmlPackage.Literals.DESCRIPTION_BUNDLE.isSuperTypeOf(x.getEClass()));
			} else if (enumLiteral == omlGrammarAccess.getUsesAccess().getUsageEnumLiteralDeclaration()) {
				predicate = (x -> !x.getEObjectURI().equals(ontologyURI) && OmlPackage.Literals.VOCABULARY_BOX.isSuperTypeOf(x.getEClass()));
			} else if (enumLiteral == omlGrammarAccess.getIncludesAccess().getInclusionEnumLiteralDeclaration()) {
				predicate = (x -> !x.getEObjectURI().equals(ontologyURI) && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.getEClass()));
			}
		}
		if (predicate != null) {
			var eReference = EcoreFactory.eINSTANCE.createEReference();
			eReference.setEType(OmlPackage.Literals.ONTOLOGY);
			var scope = omlGlobalScopeProvider.getScope(ontology.eResource(), eReference, predicate);
			scope.getAllElements().forEach(o -> acceptor.accept(getProposalCreator().createProposal(qualifiedNameValueConverter.toString(o.getUserData("namespace")), context), 0));
		}
	}

	protected void complete_ID(EObject model, RuleCall ruleCall, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		if (model instanceof Import) {
			var _import = (Import) model;
			var eReference = EcoreFactory.eINSTANCE.createEReference();
			eReference.setEType(OmlPackage.Literals.ONTOLOGY);
			var scope = omlGlobalScopeProvider.getScope(_import.eResource(), eReference, x -> x.getUserData("namespace").equals(_import.getNamespace()));
			scope.getAllElements().forEach(o -> acceptor.accept(getProposalCreator().createProposal(o.getUserData("prefix"), context), 0));
		}
	}

}
