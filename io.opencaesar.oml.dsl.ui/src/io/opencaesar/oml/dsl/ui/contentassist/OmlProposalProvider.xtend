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
package io.opencaesar.oml.dsl.ui.contentassist

import com.google.common.base.Predicate
import com.google.inject.Inject
import io.opencaesar.oml.Element
import io.opencaesar.oml.Import
import io.opencaesar.oml.OmlPackage
import io.opencaesar.oml.dsl.conversion.NAMESPACEValueConverter
import io.opencaesar.oml.dsl.services.OmlGrammarAccess
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import java.util.ArrayList

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
class OmlProposalProvider extends AbstractOmlProposalProvider {

	@Inject 
	extension OmlGrammarAccess

	@Inject
	IGlobalScopeProvider omlGlobalScopeProvider

	@Inject
	IQualifiedNameConverter qualifiedNameConverter
	
	@Inject
	NAMESPACEValueConverter qualifiedNameValueConverter

	protected override lookupCrossReference(CrossReference crossReference, EReference reference,
			ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter) {
		var scope = omlGlobalScopeProvider.getScope(contentAssistContext.currentModel.eResource, reference) [true]
		super.lookupCrossReference(crossReference, reference, contentAssistContext, getImportingProposalAcceptor(scope, contentAssistContext, acceptor), filter)
	}

	private def ICompletionProposalAcceptor getImportingProposalAcceptor(IScope scope, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val textApplier = new FQNImporter(context.getResource(), context.getViewer(), 
				scope, qualifiedNameConverter, qualifiedNameValueConverter)
		val scopeAwareAcceptor = new ICompletionProposalAcceptor.Delegate(acceptor) {
			override accept(ICompletionProposal proposal) {
				if (proposal instanceof ConfigurableCompletionProposal) {
					(proposal as ConfigurableCompletionProposal).setTextApplier(textApplier)
				}
				super.accept(proposal)
			}
		}
		return scopeAwareAcceptor
	}

	override complete_NAMESPACE(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val ontology = (model as Element).ontology
		val ontologyURI = EcoreUtil.getURI(ontology)
		val keyword = context.lastCompleteNode.grammarElement as Keyword
		var Predicate<IEObjectDescription> predicate;
		if (keyword === vocabularyExtensionAccess.extendsKeyword_1) {
			predicate = [x | x.EObjectURI != ontologyURI && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.EClass)]
		} else if (keyword === vocabularyUsageAccess.usesKeyword_1) {
			predicate = [x | x.EObjectURI != ontologyURI && OmlPackage.Literals.DESCRIPTION_BOX.isSuperTypeOf(x.EClass)]
		} else if (keyword === vocabularyBundleExtensionAccess.extendsKeyword_1) {
			predicate = [x | x.EObjectURI != ontologyURI && OmlPackage.Literals.VOCABULARY_BUNDLE.isSuperTypeOf(x.EClass)]
		} else if (keyword === vocabularyBundleInclusionAccess.includesKeyword_1) {
			predicate = [x | x.EObjectURI != ontologyURI && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.EClass)]
		} else if (keyword === descriptionExtensionAccess.extendsKeyword_1) {
			predicate = [x | x.EObjectURI != ontologyURI && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.EClass)]
		} else if (keyword === descriptionUsageAccess.usesKeyword_1) {
			predicate = [x | x.EObjectURI != ontologyURI && OmlPackage.Literals.VOCABULARY_BOX.isSuperTypeOf(x.EClass)]
		} else if (keyword === descriptionBundleExtensionAccess.extendsKeyword_1) {
			predicate = [x | x.EObjectURI != ontologyURI && OmlPackage.Literals.DESCRIPTION_BUNDLE.isSuperTypeOf(x.EClass)]
		} else if (keyword === descriptionBundleInclusionAccess.includesKeyword_1) {
			predicate = [x | x.EObjectURI != ontologyURI && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.EClass)]
		} else if (keyword === descriptionBundleUsageAccess.usesKeyword_1) {
			predicate = [x | x.EObjectURI != ontologyURI && OmlPackage.Literals.VOCABULARY_BOX.isSuperTypeOf(x.EClass)]
		}
 		val eReference = EcoreFactory.eINSTANCE.createEReference()
		eReference.EType = OmlPackage.Literals.ONTOLOGY
		val scope = omlGlobalScopeProvider.getScope(ontology.eResource, eReference, predicate)
		scope.allElements.forEach[o | acceptor.accept(createCompletionProposal(qualifiedNameValueConverter.toString(o.getUserData("namespace")), context))]
	}

	override complete_ID(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof Import) {
			val _import = model as Import 
	 		val eReference = EcoreFactory.eINSTANCE.createEReference()
			eReference.EType = OmlPackage.Literals.ONTOLOGY
			val scope = omlGlobalScopeProvider.getScope(_import.eResource, eReference) [x | x.getUserData("namespace") == _import.namespace]
			scope.allElements.forEach[o | acceptor.accept(createCompletionProposal(o.getUserData("prefix"), context))]
		}
	}

	protected override boolean isValidProposal(String proposal, String prefix, ContentAssistContext context) {
		var prefix2 = prefix
		// match an abbreviated iri proposal if the name simply matches 
		if (prefix.contains(":") && proposal.startsWith("<") && proposal.endsWith(">")) {
			prefix2 = new ArrayList(prefix.split(":")).last 
		}
		return super.isValidProposal(proposal, prefix2, context);
	}

}
