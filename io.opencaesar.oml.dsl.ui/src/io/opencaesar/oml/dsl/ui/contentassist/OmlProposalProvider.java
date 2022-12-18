/**
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
 */
package io.opencaesar.oml.dsl.ui.contentassist;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.dsl.conversion.NAMESPACEValueConverter;
import io.opencaesar.oml.dsl.services.OmlGrammarAccess;

/**
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
@SuppressWarnings("all")
public class OmlProposalProvider extends AbstractOmlProposalProvider {

	@Inject
	private OmlGrammarAccess oml;

	@Inject
	private IGlobalScopeProvider omlGlobalScopeProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private NAMESPACEValueConverter qualifiedNameValueConverter;

	@Override
	protected void lookupCrossReference(final CrossReference crossReference, final EReference reference, final ContentAssistContext contentAssistContext, final ICompletionProposalAcceptor acceptor,
			final Predicate<IEObjectDescription> filter) {
		var scope = omlGlobalScopeProvider.getScope(contentAssistContext.getCurrentModel().eResource(), reference, i -> true );
		super.lookupCrossReference(crossReference, reference, contentAssistContext, this.getImportingProposalAcceptor(scope, contentAssistContext, acceptor), filter);
	}

	private ICompletionProposalAcceptor getImportingProposalAcceptor(final IScope scope, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		final var textApplier = new FQNImporter(context.getResource(), context.getViewer(), scope, this.qualifiedNameConverter, this.qualifiedNameValueConverter);
		final var.Delegate scopeAwareAcceptor = new ICompletionProposalAcceptor.Delegate(acceptor) {
			@Override
			public void accept(final ICompletionProposal proposal) {
				if ((proposal instanceof ConfigurableCompletionProposal)) {
					((ConfigurableCompletionProposal) proposal).setTextApplier(textApplier);
				}
				super.accept(proposal);
			}
		};
		return scopeAwareAcceptor;
	}

	@Override
	public void complete_NAMESPACE(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		final Ontology ontology = ((Element) model).getOntology();
		final URI ontologyURI = EcoreUtil.getURI(ontology);
		final Keyword keyword = ((Keyword) context.getLastCompleteNode().getGrammarElement());
		Predicate<IEObjectDescription> predicate = null;
		if (ontology instanceof Vocabulary) {
			if (keyword == oml.getExtensionAccess().getExtendsKeyword_0()) {
				predicate = x -> x.getEObjectURI() != ontologyURI && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.getEClass());
			} else if (keyword == oml.getUsageAccess().getUsesKeyword_0()) {
				predicate = x -> x.getEObjectURI() != ontologyURI && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.getEClass());
			}
		} else if (ontology instanceof VocabularyBundle) {
			if (keyword == oml.getExtensionAccess().getExtendsKeyword_0()) {
				predicate = x -> x.getEObjectURI() != ontologyURI && OmlPackage.Literals.VOCABULARY_BUNDLE.isSuperTypeOf(x.getEClass());
			} else if (keyword == oml.getInclusionAccess().getIncludesKeyword_0()) {
				predicate = x -> x.getEObjectURI() != ontologyURI && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.getEClass());
			}
		} else if (ontology instanceof Description) {
			if (keyword == oml.getExtensionAccess().getExtendsKeyword_0()) {
				predicate = x -> x.getEObjectURI() != ontologyURI && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.getEClass());
			} else if (keyword == oml.getUsageAccess().getUsesKeyword_0()) {
				predicate = x -> x.getEObjectURI() != ontologyURI && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.getEClass());
			}
		} else if (ontology instanceof DescriptionBundle) {
			if (keyword == oml.getExtensionAccess().getExtendsKeyword_0()) {
				predicate = x -> x.getEObjectURI() != ontologyURI && OmlPackage.Literals.DESCRIPTION_BUNDLE.isSuperTypeOf(x.getEClass());
			} else if (keyword == oml.getUsageAccess().getUsesKeyword_0()) {
				predicate = x -> x.getEObjectURI() != ontologyURI && OmlPackage.Literals.VOCABULARY_BOX.isSuperTypeOf(x.getEClass());
			} else if (keyword == oml.getInclusionAccess().getIncludesKeyword_0()) {
				predicate = x -> x.getEObjectURI() != ontologyURI && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.getEClass());
			}
		}
		final EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setEType(OmlPackage.Literals.ONTOLOGY);
		final IScope scope = omlGlobalScopeProvider.getScope(ontology.eResource(), eReference, predicate);
		scope.getAllElements().forEach(o -> acceptor.accept(this.createCompletionProposal(this.qualifiedNameValueConverter.toString(o.getUserData("namespace")), context)));
	}

	@Override
	public void complete_ID(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		if ((model instanceof Import)) {
			var _import = ((Import) model);
			var eReference = EcoreFactory.eINSTANCE.createEReference();
			eReference.setEType(OmlPackage.Literals.ONTOLOGY);
			final IScope scope = omlGlobalScopeProvider.getScope(_import.eResource(), eReference, x -> x.getUserData("namespace").equals(_import.getNamespace()));
			scope.getAllElements().forEach(o -> acceptor.accept(this.createCompletionProposal(o.getUserData("prefix"), context)));
		}
	}

	@Override
	protected boolean isValidProposal(final String proposal, final String prefix, final ContentAssistContext context) {
		var prefix2 = prefix;
		// match an abbreviated iri proposal if the name simply matches 
		if (prefix.contains(":") && proposal.startsWith("<") && proposal.endsWith(">")) {
			prefix2 = prefix.split(":")[1];
		}
		return super.isValidProposal(proposal, prefix2, context);
	}
}
