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

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.inject.Inject;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.dsl.conversion.NAMESPACEValueConverter;
import io.opencaesar.oml.dsl.services.OmlGrammarAccess;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
@SuppressWarnings("all")
public class OmlProposalProvider extends AbstractOmlProposalProvider {
  @Inject
  @Extension
  private OmlGrammarAccess _omlGrammarAccess;

  @Inject
  private IGlobalScopeProvider omlGlobalScopeProvider;

  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;

  @Inject
  private NAMESPACEValueConverter qualifiedNameValueConverter;

  @Override
  protected void lookupCrossReference(final CrossReference crossReference, final EReference reference, final ContentAssistContext contentAssistContext, final ICompletionProposalAcceptor acceptor, final Predicate<IEObjectDescription> filter) {
    final Predicate<IEObjectDescription> _function = (IEObjectDescription it) -> {
      return true;
    };
    IScope scope = this.omlGlobalScopeProvider.getScope(contentAssistContext.getCurrentModel().eResource(), reference, _function);
    super.lookupCrossReference(crossReference, reference, contentAssistContext, this.getImportingProposalAcceptor(scope, contentAssistContext, acceptor), filter);
  }

  private ICompletionProposalAcceptor getImportingProposalAcceptor(final IScope scope, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    XtextResource _resource = context.getResource();
    ITextViewer _viewer = context.getViewer();
    final FQNImporter textApplier = new FQNImporter(_resource, _viewer, scope, this.qualifiedNameConverter, this.qualifiedNameValueConverter);
    final ICompletionProposalAcceptor.Delegate scopeAwareAcceptor = new ICompletionProposalAcceptor.Delegate(acceptor) {
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
    EObject _grammarElement = context.getLastCompleteNode().getGrammarElement();
    final Keyword keyword = ((Keyword) _grammarElement);
    Predicate<IEObjectDescription> predicate = null;
    Keyword _extendsKeyword_1 = this._omlGrammarAccess.getVocabularyExtensionAccess().getExtendsKeyword_1();
    boolean _tripleEquals = (keyword == _extendsKeyword_1);
    if (_tripleEquals) {
      final Predicate<IEObjectDescription> _function = (IEObjectDescription x) -> {
        return ((!Objects.equal(x.getEObjectURI(), ontologyURI)) && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.getEClass()));
      };
      predicate = _function;
    } else {
      Keyword _usesKeyword_1 = this._omlGrammarAccess.getVocabularyUsageAccess().getUsesKeyword_1();
      boolean _tripleEquals_1 = (keyword == _usesKeyword_1);
      if (_tripleEquals_1) {
        final Predicate<IEObjectDescription> _function_1 = (IEObjectDescription x) -> {
          return ((!Objects.equal(x.getEObjectURI(), ontologyURI)) && OmlPackage.Literals.DESCRIPTION_BOX.isSuperTypeOf(x.getEClass()));
        };
        predicate = _function_1;
      } else {
        Keyword _extendsKeyword_1_1 = this._omlGrammarAccess.getVocabularyBundleExtensionAccess().getExtendsKeyword_1();
        boolean _tripleEquals_2 = (keyword == _extendsKeyword_1_1);
        if (_tripleEquals_2) {
          final Predicate<IEObjectDescription> _function_2 = (IEObjectDescription x) -> {
            return ((!Objects.equal(x.getEObjectURI(), ontologyURI)) && OmlPackage.Literals.VOCABULARY_BUNDLE.isSuperTypeOf(x.getEClass()));
          };
          predicate = _function_2;
        } else {
          Keyword _includesKeyword_1 = this._omlGrammarAccess.getVocabularyBundleInclusionAccess().getIncludesKeyword_1();
          boolean _tripleEquals_3 = (keyword == _includesKeyword_1);
          if (_tripleEquals_3) {
            final Predicate<IEObjectDescription> _function_3 = (IEObjectDescription x) -> {
              return ((!Objects.equal(x.getEObjectURI(), ontologyURI)) && OmlPackage.Literals.VOCABULARY.isSuperTypeOf(x.getEClass()));
            };
            predicate = _function_3;
          } else {
            Keyword _extendsKeyword_1_2 = this._omlGrammarAccess.getDescriptionExtensionAccess().getExtendsKeyword_1();
            boolean _tripleEquals_4 = (keyword == _extendsKeyword_1_2);
            if (_tripleEquals_4) {
              final Predicate<IEObjectDescription> _function_4 = (IEObjectDescription x) -> {
                return ((!Objects.equal(x.getEObjectURI(), ontologyURI)) && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.getEClass()));
              };
              predicate = _function_4;
            } else {
              Keyword _usesKeyword_1_1 = this._omlGrammarAccess.getDescriptionUsageAccess().getUsesKeyword_1();
              boolean _tripleEquals_5 = (keyword == _usesKeyword_1_1);
              if (_tripleEquals_5) {
                final Predicate<IEObjectDescription> _function_5 = (IEObjectDescription x) -> {
                  return ((!Objects.equal(x.getEObjectURI(), ontologyURI)) && OmlPackage.Literals.VOCABULARY_BOX.isSuperTypeOf(x.getEClass()));
                };
                predicate = _function_5;
              } else {
                Keyword _extendsKeyword_1_3 = this._omlGrammarAccess.getDescriptionBundleExtensionAccess().getExtendsKeyword_1();
                boolean _tripleEquals_6 = (keyword == _extendsKeyword_1_3);
                if (_tripleEquals_6) {
                  final Predicate<IEObjectDescription> _function_6 = (IEObjectDescription x) -> {
                    return ((!Objects.equal(x.getEObjectURI(), ontologyURI)) && OmlPackage.Literals.DESCRIPTION_BUNDLE.isSuperTypeOf(x.getEClass()));
                  };
                  predicate = _function_6;
                } else {
                  Keyword _includesKeyword_1_1 = this._omlGrammarAccess.getDescriptionBundleInclusionAccess().getIncludesKeyword_1();
                  boolean _tripleEquals_7 = (keyword == _includesKeyword_1_1);
                  if (_tripleEquals_7) {
                    final Predicate<IEObjectDescription> _function_7 = (IEObjectDescription x) -> {
                      return ((!Objects.equal(x.getEObjectURI(), ontologyURI)) && OmlPackage.Literals.DESCRIPTION.isSuperTypeOf(x.getEClass()));
                    };
                    predicate = _function_7;
                  } else {
                    Keyword _usesKeyword_1_2 = this._omlGrammarAccess.getDescriptionBundleUsageAccess().getUsesKeyword_1();
                    boolean _tripleEquals_8 = (keyword == _usesKeyword_1_2);
                    if (_tripleEquals_8) {
                      final Predicate<IEObjectDescription> _function_8 = (IEObjectDescription x) -> {
                        return ((!Objects.equal(x.getEObjectURI(), ontologyURI)) && OmlPackage.Literals.VOCABULARY_BOX.isSuperTypeOf(x.getEClass()));
                      };
                      predicate = _function_8;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    final EReference eReference = EcoreFactory.eINSTANCE.createEReference();
    eReference.setEType(OmlPackage.Literals.ONTOLOGY);
    final IScope scope = this.omlGlobalScopeProvider.getScope(ontology.eResource(), eReference, predicate);
    final Consumer<IEObjectDescription> _function_9 = (IEObjectDescription o) -> {
      acceptor.accept(this.createCompletionProposal(this.qualifiedNameValueConverter.toString(o.getUserData("namespace")), context));
    };
    scope.getAllElements().forEach(_function_9);
  }

  @Override
  public void complete_ID(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    if ((model instanceof Import)) {
      final Import _import = ((Import) model);
      final EReference eReference = EcoreFactory.eINSTANCE.createEReference();
      eReference.setEType(OmlPackage.Literals.ONTOLOGY);
      final Predicate<IEObjectDescription> _function = (IEObjectDescription x) -> {
        String _userData = x.getUserData("namespace");
        String _namespace = _import.getNamespace();
        return Objects.equal(_userData, _namespace);
      };
      final IScope scope = this.omlGlobalScopeProvider.getScope(_import.eResource(), eReference, _function);
      final Consumer<IEObjectDescription> _function_1 = (IEObjectDescription o) -> {
        acceptor.accept(this.createCompletionProposal(o.getUserData("prefix"), context));
      };
      scope.getAllElements().forEach(_function_1);
    }
  }

  @Override
  protected boolean isValidProposal(final String proposal, final String prefix, final ContentAssistContext context) {
    String prefix2 = prefix;
    if (((prefix.contains(":") && proposal.startsWith("<")) && proposal.endsWith(">"))) {
      String[] _split = prefix.split(":");
      prefix2 = IterableExtensions.<String>last(new ArrayList<String>((Collection<? extends String>)Conversions.doWrapArray(_split)));
    }
    return super.isValidProposal(proposal, prefix2, context);
  }
}
