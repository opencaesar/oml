/**
 * Copyright 2019 California Institute of Technology ("Caltech").
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
package io.opencaesar.oml.dsl.formatting2;

import java.util.Arrays;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Inject;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DescriptionBundleExtension;
import io.opencaesar.oml.DescriptionBundleImport;
import io.opencaesar.oml.DescriptionBundleInclusion;
import io.opencaesar.oml.DescriptionBundleUsage;
import io.opencaesar.oml.DescriptionExtension;
import io.opencaesar.oml.DescriptionImport;
import io.opencaesar.oml.DescriptionStatement;
import io.opencaesar.oml.DescriptionUsage;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.FeaturePredicate;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.RelationRestrictionAxiom;
import io.opencaesar.oml.RelationTargetRestrictionAxiom;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyReference;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleImport;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyImport;
import io.opencaesar.oml.VocabularyStatement;
import io.opencaesar.oml.VocabularyUsage;
import io.opencaesar.oml.dsl.services.OmlGrammarAccess;

@SuppressWarnings("all")
public class OmlFormatter extends AbstractJavaFormatter {
  @Inject
  @Extension
  private OmlGrammarAccess _omlGrammarAccess;

  @Inject
  private IIndentationInformation indentationInformation;

  @Override
  protected void initialize(final FormatterRequest request) {
    final ITypedPreferenceValues preferences = request.getPreferences();
    if ((preferences instanceof MapBasedPreferenceValues)) {
      ((MapBasedPreferenceValues)preferences).<String>put(FormatterPreferenceKeys.indentation, this.indentationInformation.getIndentString());
    }
    super.initialize(request);
  }

  protected void _format(final Annotation _annotation, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(_annotation).keyword(this._omlGrammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()), _function);
    Literal _value = _annotation.getValue();
    Literal _format = null;
    if (_value!=null) {
      _format=document.<Literal>format(_value);
    }
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.<Literal>prepend(_format, _function_1);
  }

  protected void _format(final Vocabulary vocabulary, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(0, 0, 0);
      it.noSpace();
    };
    document.<Vocabulary>prepend(vocabulary, _function);
    final Consumer<Annotation> _function_1 = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_2);
    };
    vocabulary.getOwnedAnnotations().forEach(_function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(vocabulary).keyword(this._omlGrammarAccess.getVocabularyAccess().getVocabularyKeyword_1()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(vocabulary).keyword(this._omlGrammarAccess.getVocabularyAccess().getAsKeyword_3()), _function_3);
    this.formatBraces(vocabulary, document);
    final Consumer<VocabularyImport> _function_4 = (VocabularyImport it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<VocabularyImport>prepend(document.<VocabularyImport>format(it), _function_5);
    };
    vocabulary.getOwnedImports().forEach(_function_4);
    final Consumer<VocabularyStatement> _function_5 = (VocabularyStatement it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<VocabularyStatement>prepend(document.<VocabularyStatement>format(it), _function_6);
    };
    vocabulary.getOwnedStatements().forEach(_function_5);
  }

  protected void _format(final VocabularyBundle bundle, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(0, 0, 0);
      it.noSpace();
    };
    document.<VocabularyBundle>prepend(bundle, _function);
    final Consumer<Annotation> _function_1 = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_2);
    };
    bundle.getOwnedAnnotations().forEach(_function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(bundle).keyword(this._omlGrammarAccess.getVocabularyBundleAccess().getVocabularyKeyword_1()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(bundle).keyword(this._omlGrammarAccess.getVocabularyBundleAccess().getBundleKeyword_2()), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(bundle).keyword(this._omlGrammarAccess.getVocabularyBundleAccess().getAsKeyword_4()), _function_4);
    this.formatBraces(bundle, document);
    final Consumer<VocabularyBundleImport> _function_5 = (VocabularyBundleImport it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<VocabularyBundleImport>prepend(document.<VocabularyBundleImport>format(it), _function_6);
    };
    bundle.getOwnedImports().forEach(_function_5);
  }

  protected void _format(final Description description, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(0, 0, 0);
      it.noSpace();
    };
    document.<Description>prepend(description, _function);
    final Consumer<Annotation> _function_1 = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_2);
    };
    description.getOwnedAnnotations().forEach(_function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(description).keyword(this._omlGrammarAccess.getDescriptionAccess().getDescriptionKeyword_1()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(description).keyword(this._omlGrammarAccess.getDescriptionAccess().getAsKeyword_3()), _function_3);
    this.formatBraces(description, document);
    final Consumer<DescriptionImport> _function_4 = (DescriptionImport it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<DescriptionImport>prepend(document.<DescriptionImport>format(it), _function_5);
    };
    description.getOwnedImports().forEach(_function_4);
    final Consumer<DescriptionStatement> _function_5 = (DescriptionStatement it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<DescriptionStatement>prepend(document.<DescriptionStatement>format(it), _function_6);
    };
    description.getOwnedStatements().forEach(_function_5);
  }

  protected void _format(final DescriptionBundle bundle, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(0, 0, 0);
      it.noSpace();
    };
    document.<DescriptionBundle>prepend(bundle, _function);
    final Consumer<Annotation> _function_1 = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_2);
    };
    bundle.getOwnedAnnotations().forEach(_function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(bundle).keyword(this._omlGrammarAccess.getDescriptionBundleAccess().getDescriptionKeyword_1()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(bundle).keyword(this._omlGrammarAccess.getDescriptionBundleAccess().getBundleKeyword_2()), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(bundle).keyword(this._omlGrammarAccess.getDescriptionBundleAccess().getAsKeyword_4()), _function_4);
    this.formatBraces(bundle, document);
    final Consumer<DescriptionBundleImport> _function_5 = (DescriptionBundleImport it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<DescriptionBundleImport>prepend(document.<DescriptionBundleImport>format(it), _function_6);
    };
    bundle.getOwnedImports().forEach(_function_5);
  }

  protected void _format(final Aspect aspect, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    aspect.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(aspect).keyword(this._omlGrammarAccess.getAspectAccess().getAspectKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(aspect).keyword(this._omlGrammarAccess.getAspectAccess().getColonGreaterThanSignKeyword_3_0()), _function_2);
    this.formatCommas(aspect, document);
    this.formatBrackets(aspect, document);
    final Consumer<KeyAxiom> _function_3 = (KeyAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<KeyAxiom>prepend(document.<KeyAxiom>format(it), _function_4);
    };
    aspect.getOwnedKeys().forEach(_function_3);
    final Consumer<PropertyRestrictionAxiom> _function_4 = (PropertyRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyRestrictionAxiom>prepend(document.<PropertyRestrictionAxiom>format(it), _function_5);
    };
    aspect.getOwnedPropertyRestrictions().forEach(_function_4);
    final Consumer<RelationRestrictionAxiom> _function_5 = (RelationRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<RelationRestrictionAxiom>prepend(document.<RelationRestrictionAxiom>format(it), _function_6);
    };
    aspect.getOwnedRelationRestrictions().forEach(_function_5);
  }

  protected void _format(final Concept concept, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    concept.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(concept).keyword(this._omlGrammarAccess.getConceptAccess().getConceptKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(concept).keyword(this._omlGrammarAccess.getConceptAccess().getColonGreaterThanSignKeyword_3_0()), _function_2);
    this.formatCommas(concept, document);
    this.formatBrackets(concept, document);
    final Consumer<KeyAxiom> _function_3 = (KeyAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<KeyAxiom>prepend(document.<KeyAxiom>format(it), _function_4);
    };
    concept.getOwnedKeys().forEach(_function_3);
    final Consumer<PropertyRestrictionAxiom> _function_4 = (PropertyRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyRestrictionAxiom>prepend(document.<PropertyRestrictionAxiom>format(it), _function_5);
    };
    concept.getOwnedPropertyRestrictions().forEach(_function_4);
    final Consumer<RelationRestrictionAxiom> _function_5 = (RelationRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<RelationRestrictionAxiom>prepend(document.<RelationRestrictionAxiom>format(it), _function_6);
    };
    concept.getOwnedRelationRestrictions().forEach(_function_5);
  }

  protected void _format(final RelationEntity entity, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    entity.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getRelationKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getEntityKeyword_2()), _function_2);
    this.formatCommas(entity, document);
    this.formatBrackets(entity, document);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getFromKeyword_6()), _function_3), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getToKeyword_8()), _function_5), _function_6);
    ForwardRelation _forwardRelation = entity.getForwardRelation();
    ForwardRelation _format = null;
    if (_forwardRelation!=null) {
      _format=document.<ForwardRelation>format(_forwardRelation);
    }
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<ForwardRelation>prepend(_format, _function_7);
    ReverseRelation _reverseRelation = entity.getReverseRelation();
    ReverseRelation _format_1 = null;
    if (_reverseRelation!=null) {
      _format_1=document.<ReverseRelation>format(_reverseRelation);
    }
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<ReverseRelation>prepend(_format_1, _function_8);
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getFunctionalFunctionalKeyword_11_0_0()), _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getInverseFunctionalInverseKeyword_11_1_0_0()), _function_10);
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getSymmetricSymmetricKeyword_11_2_0()), _function_11);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getAsymmetricAsymmetricKeyword_11_3_0()), _function_12);
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getReflexiveReflexiveKeyword_11_4_0()), _function_13);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getIrreflexiveIrreflexiveKeyword_11_5_0()), _function_14);
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(entity).keyword(this._omlGrammarAccess.getRelationEntityAccess().getTransitiveTransitiveKeyword_11_6_0()), _function_15);
    final Consumer<KeyAxiom> _function_16 = (KeyAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_17 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<KeyAxiom>prepend(document.<KeyAxiom>format(it), _function_17);
    };
    entity.getOwnedKeys().forEach(_function_16);
    final Consumer<PropertyRestrictionAxiom> _function_17 = (PropertyRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_18 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyRestrictionAxiom>prepend(document.<PropertyRestrictionAxiom>format(it), _function_18);
    };
    entity.getOwnedPropertyRestrictions().forEach(_function_17);
    final Consumer<RelationRestrictionAxiom> _function_18 = (RelationRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_19 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<RelationRestrictionAxiom>prepend(document.<RelationRestrictionAxiom>format(it), _function_19);
    };
    entity.getOwnedRelationRestrictions().forEach(_function_18);
  }

  protected void _format(final Structure structure, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    structure.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(structure).keyword(this._omlGrammarAccess.getStructureAccess().getStructureKeyword_1()), _function_1);
    this.formatCommas(structure, document);
    this.formatBrackets(structure, document);
    final Consumer<PropertyRestrictionAxiom> _function_2 = (PropertyRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyRestrictionAxiom>prepend(document.<PropertyRestrictionAxiom>format(it), _function_3);
    };
    structure.getOwnedPropertyRestrictions().forEach(_function_2);
  }

  protected void _format(final AnnotationProperty property, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    property.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getAnnotationPropertyAccess().getAnnotationKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getAnnotationPropertyAccess().getPropertyKeyword_2()), _function_2);
    this.formatCommas(property, document);
  }

  protected void _format(final ScalarProperty property, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    property.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getScalarPropertyAccess().getScalarKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getScalarPropertyAccess().getPropertyKeyword_2()), _function_2);
    this.formatCommas(property, document);
    this.formatBrackets(property, document);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getScalarPropertyAccess().getDomainKeyword_5_1()), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getScalarPropertyAccess().getRangeKeyword_5_3()), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getScalarPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()), _function_5);
  }

  protected void _format(final StructuredProperty property, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    property.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getStructuredPropertyAccess().getStructuredKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getStructuredPropertyAccess().getPropertyKeyword_2()), _function_2);
    this.formatCommas(property, document);
    this.formatBrackets(property, document);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getStructuredPropertyAccess().getDomainKeyword_5_1()), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getStructuredPropertyAccess().getRangeKeyword_5_3()), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(property).keyword(this._omlGrammarAccess.getStructuredPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()), _function_5);
  }

  protected void _format(final FacetedScalar scalar, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    scalar.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getScalarKeyword_1()), _function_1);
    this.formatCommas(scalar, document);
    this.formatBrackets(scalar, document);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getLengthKeyword_4_1_0_0()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getMinLengthKeyword_4_1_1_0()), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getMaxLengthKeyword_4_1_2_0()), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getPatternKeyword_4_1_3_0()), _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getLanguageKeyword_4_1_4_0()), _function_6);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getMinInclusiveKeyword_4_1_5_0()), _function_7);
    Literal _minInclusive = scalar.getMinInclusive();
    Literal _format = null;
    if (_minInclusive!=null) {
      _format=document.<Literal>format(_minInclusive);
    }
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.<Literal>prepend(_format, _function_8);
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getMaxInclusiveKeyword_4_1_7_0()), _function_9);
    Literal _maxInclusive = scalar.getMaxInclusive();
    Literal _format_1 = null;
    if (_maxInclusive!=null) {
      _format_1=document.<Literal>format(_maxInclusive);
    }
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.<Literal>prepend(_format_1, _function_10);
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getMinExclusiveKeyword_4_1_6_0()), _function_11);
    Literal _minExclusive = scalar.getMinExclusive();
    Literal _format_2 = null;
    if (_minExclusive!=null) {
      _format_2=document.<Literal>format(_minExclusive);
    }
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.<Literal>prepend(_format_2, _function_12);
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getFacetedScalarAccess().getMaxExclusiveKeyword_4_1_8_0()), _function_13);
    Literal _maxExclusive = scalar.getMaxExclusive();
    Literal _format_3 = null;
    if (_maxExclusive!=null) {
      _format_3=document.<Literal>format(_maxExclusive);
    }
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.<Literal>prepend(_format_3, _function_14);
  }

  protected void _format(final EnumeratedScalar scalar, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    scalar.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getEnumeratedScalarAccess().getEnumeratedKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(scalar).keyword(this._omlGrammarAccess.getEnumeratedScalarAccess().getScalarKeyword_2()), _function_2);
    this.formatCommas(scalar, document);
    this.formatBrackets(scalar, document);
    final Consumer<Literal> _function_3 = (Literal it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Literal>prepend(document.<Literal>format(it), _function_4);
    };
    scalar.getLiterals().forEach(_function_3);
  }

  protected void _format(final ForwardRelation relation, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    relation.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(relation).keyword(this._omlGrammarAccess.getForwardRelationAccess().getForwardKeyword_1()), _function_1);
  }

  protected void _format(final ReverseRelation relation, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    relation.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(relation).keyword(this._omlGrammarAccess.getReverseRelationAccess().getReverseKeyword_1()), _function_1);
  }

  protected void _format(final Rule rule, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    rule.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(rule).keyword(this._omlGrammarAccess.getRuleAccess().getRuleKeyword_1()), _function_1);
    this.formatBrackets(rule, document);
    Predicate _head = IterableExtensions.<Predicate>head(rule.getAntecedent());
    Predicate _format = null;
    if (_head!=null) {
      _format=document.<Predicate>format(_head);
    }
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<Predicate>prepend(_format, _function_2);
    final Consumer<ISemanticRegion> _function_3 = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.surround(it, _function_4);
    };
    this.textRegionExtensions.regionFor(rule).keywords("^").forEach(_function_3);
    final Consumer<Predicate> _function_4 = (Predicate it) -> {
      document.<Predicate>format(it);
    };
    rule.getAntecedent().forEach(_function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(rule).keyword(this._omlGrammarAccess.getRuleAccess().getHyphenMinusGreaterThanSignKeyword_6()), _function_5);
    final Consumer<Predicate> _function_6 = (Predicate it) -> {
      document.<Predicate>format(it);
    };
    rule.getConsequent().forEach(_function_6);
  }

  protected void _format(final ConceptInstance instance, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    instance.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(instance).keyword(this._omlGrammarAccess.getConceptInstanceAccess().getCiKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(instance).keyword(this._omlGrammarAccess.getConceptInstanceAccess().getColonKeyword_3_0()), _function_2);
    this.formatCommas(instance, document);
    this.formatBrackets(instance, document);
    final Consumer<PropertyValueAssertion> _function_3 = (PropertyValueAssertion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyValueAssertion>prepend(document.<PropertyValueAssertion>format(it), _function_4);
    };
    instance.getOwnedPropertyValues().forEach(_function_3);
    final Consumer<LinkAssertion> _function_4 = (LinkAssertion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<LinkAssertion>prepend(document.<LinkAssertion>format(it), _function_5);
    };
    instance.getOwnedLinks().forEach(_function_4);
  }

  protected void _format(final RelationInstance instance, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    instance.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(instance).keyword(this._omlGrammarAccess.getRelationInstanceAccess().getRiKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(instance).keyword(this._omlGrammarAccess.getRelationInstanceAccess().getColonKeyword_3_0()), _function_2);
    this.formatCommas(instance, document);
    this.formatBrackets(instance, document);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(instance).keyword(this._omlGrammarAccess.getRelationInstanceAccess().getFromKeyword_5()), _function_3), _function_4);
    final Consumer<NamedInstance> _function_5 = (NamedInstance it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.<NamedInstance>prepend(document.<NamedInstance>format(it), _function_6);
    };
    instance.getSources().forEach(_function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(instance).keyword(this._omlGrammarAccess.getRelationInstanceAccess().getToKeyword_8()), _function_6), _function_7);
    final Consumer<NamedInstance> _function_8 = (NamedInstance it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.<NamedInstance>prepend(document.<NamedInstance>format(it), _function_9);
    };
    instance.getTargets().forEach(_function_8);
    final Consumer<PropertyValueAssertion> _function_9 = (PropertyValueAssertion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyValueAssertion>prepend(document.<PropertyValueAssertion>format(it), _function_10);
    };
    instance.getOwnedPropertyValues().forEach(_function_9);
    final Consumer<LinkAssertion> _function_10 = (LinkAssertion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<LinkAssertion>prepend(document.<LinkAssertion>format(it), _function_11);
    };
    instance.getOwnedLinks().forEach(_function_10);
  }

  protected void _format(final StructureInstance instance, @Extension final IFormattableDocument document) {
    this.formatBrackets(instance, document);
    final Consumer<PropertyValueAssertion> _function = (PropertyValueAssertion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyValueAssertion>prepend(document.<PropertyValueAssertion>format(it), _function_1);
    };
    instance.getOwnedPropertyValues().forEach(_function);
  }

  protected void _format(final AspectReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getAspectReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getAspectReferenceAccess().getAspectKeyword_2()), _function_2);
    this.formatCommas(reference, document);
    this.formatBrackets(reference, document);
    final Consumer<KeyAxiom> _function_3 = (KeyAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<KeyAxiom>prepend(document.<KeyAxiom>format(it), _function_4);
    };
    reference.getOwnedKeys().forEach(_function_3);
    final Consumer<PropertyRestrictionAxiom> _function_4 = (PropertyRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyRestrictionAxiom>prepend(document.<PropertyRestrictionAxiom>format(it), _function_5);
    };
    reference.getOwnedPropertyRestrictions().forEach(_function_4);
    final Consumer<RelationRestrictionAxiom> _function_5 = (RelationRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<RelationRestrictionAxiom>prepend(document.<RelationRestrictionAxiom>format(it), _function_6);
    };
    reference.getOwnedRelationRestrictions().forEach(_function_5);
  }

  protected void _format(final ConceptReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getConceptReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getConceptReferenceAccess().getConceptKeyword_2()), _function_2);
    this.formatCommas(reference, document);
    this.formatBrackets(reference, document);
    final Consumer<KeyAxiom> _function_3 = (KeyAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<KeyAxiom>prepend(document.<KeyAxiom>format(it), _function_4);
    };
    reference.getOwnedKeys().forEach(_function_3);
    final Consumer<PropertyRestrictionAxiom> _function_4 = (PropertyRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyRestrictionAxiom>prepend(document.<PropertyRestrictionAxiom>format(it), _function_5);
    };
    reference.getOwnedPropertyRestrictions().forEach(_function_4);
    final Consumer<RelationRestrictionAxiom> _function_5 = (RelationRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<RelationRestrictionAxiom>prepend(document.<RelationRestrictionAxiom>format(it), _function_6);
    };
    reference.getOwnedRelationRestrictions().forEach(_function_5);
  }

  protected void _format(final RelationEntityReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getRelationEntityReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getRelationEntityReferenceAccess().getRelationKeyword_2()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getRelationEntityReferenceAccess().getEntityKeyword_3()), _function_3);
    this.formatCommas(reference, document);
    this.formatBrackets(reference, document);
    final Consumer<KeyAxiom> _function_4 = (KeyAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<KeyAxiom>prepend(document.<KeyAxiom>format(it), _function_5);
    };
    reference.getOwnedKeys().forEach(_function_4);
    final Consumer<PropertyRestrictionAxiom> _function_5 = (PropertyRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyRestrictionAxiom>prepend(document.<PropertyRestrictionAxiom>format(it), _function_6);
    };
    reference.getOwnedPropertyRestrictions().forEach(_function_5);
    final Consumer<RelationRestrictionAxiom> _function_6 = (RelationRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<RelationRestrictionAxiom>prepend(document.<RelationRestrictionAxiom>format(it), _function_7);
    };
    reference.getOwnedRelationRestrictions().forEach(_function_6);
  }

  protected void _format(final StructureReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getStructureReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getStructureReferenceAccess().getStructureKeyword_2()), _function_2);
    this.formatCommas(reference, document);
    this.formatBrackets(reference, document);
    final Consumer<PropertyRestrictionAxiom> _function_3 = (PropertyRestrictionAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyRestrictionAxiom>prepend(document.<PropertyRestrictionAxiom>format(it), _function_4);
    };
    reference.getOwnedPropertyRestrictions().forEach(_function_3);
  }

  protected void _format(final AnnotationPropertyReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getAnnotationPropertyReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getAnnotationPropertyReferenceAccess().getAnnotationKeyword_2()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getAnnotationPropertyReferenceAccess().getPropertyKeyword_3()), _function_3);
    this.formatCommas(reference, document);
  }

  protected void _format(final ScalarPropertyReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getScalarPropertyReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getScalarPropertyReferenceAccess().getScalarKeyword_2()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getScalarPropertyReferenceAccess().getPropertyKeyword_3()), _function_3);
    this.formatCommas(reference, document);
  }

  protected void _format(final StructuredPropertyReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getStructuredPropertyReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getStructuredPropertyReferenceAccess().getStructuredKeyword_2()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getStructuredPropertyReferenceAccess().getPropertyKeyword_3()), _function_3);
    this.formatCommas(reference, document);
  }

  protected void _format(final FacetedScalarReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getFacetedScalarReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getFacetedScalarReferenceAccess().getScalarKeyword_2()), _function_2);
    this.formatCommas(reference, document);
  }

  protected void _format(final EnumeratedScalarReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getEnumeratedScalarReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getEnumeratedScalarReferenceAccess().getEnumeratedKeyword_2()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getEnumeratedScalarReferenceAccess().getScalarKeyword_3()), _function_3);
    this.formatCommas(reference, document);
  }

  protected void _format(final RelationReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getRelationReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getRelationReferenceAccess().getRelationKeyword_2()), _function_2);
  }

  protected void _format(final RuleReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getRuleReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getRuleReferenceAccess().getRuleKeyword_2()), _function_2);
  }

  protected void _format(final ConceptInstanceReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getConceptInstanceReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getConceptInstanceReferenceAccess().getCiKeyword_2()), _function_2);
    this.formatCommas(reference, document);
    this.formatBrackets(reference, document);
    final Consumer<PropertyValueAssertion> _function_3 = (PropertyValueAssertion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyValueAssertion>prepend(document.<PropertyValueAssertion>format(it), _function_4);
    };
    reference.getOwnedPropertyValues().forEach(_function_3);
    final Consumer<LinkAssertion> _function_4 = (LinkAssertion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<LinkAssertion>prepend(document.<LinkAssertion>format(it), _function_5);
    };
    reference.getOwnedLinks().forEach(_function_4);
  }

  protected void _format(final RelationInstanceReference reference, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    reference.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getRelationInstanceReferenceAccess().getRefKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(reference).keyword(this._omlGrammarAccess.getRelationInstanceReferenceAccess().getRiKeyword_2()), _function_2);
    this.formatCommas(reference, document);
    this.formatBrackets(reference, document);
    final Consumer<PropertyValueAssertion> _function_3 = (PropertyValueAssertion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<PropertyValueAssertion>prepend(document.<PropertyValueAssertion>format(it), _function_4);
    };
    reference.getOwnedPropertyValues().forEach(_function_3);
    final Consumer<LinkAssertion> _function_4 = (LinkAssertion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<LinkAssertion>prepend(document.<LinkAssertion>format(it), _function_5);
    };
    reference.getOwnedLinks().forEach(_function_4);
  }

  protected void _format(final VocabularyExtension _extension, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    _extension.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(_extension).keyword(this._omlGrammarAccess.getVocabularyExtensionAccess().getExtendsKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(_extension).keyword(this._omlGrammarAccess.getVocabularyExtensionAccess().getAsKeyword_3_0()), _function_2);
  }

  protected void _format(final VocabularyUsage usage, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    usage.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(usage).keyword(this._omlGrammarAccess.getVocabularyUsageAccess().getUsesKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(usage).keyword(this._omlGrammarAccess.getVocabularyUsageAccess().getAsKeyword_3_0()), _function_2);
  }

  protected void _format(final VocabularyBundleExtension _extension, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    _extension.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(_extension).keyword(this._omlGrammarAccess.getVocabularyBundleExtensionAccess().getExtendsKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(_extension).keyword(this._omlGrammarAccess.getVocabularyBundleExtensionAccess().getAsKeyword_3_0()), _function_2);
  }

  protected void _format(final VocabularyBundleInclusion inclusion, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    inclusion.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(inclusion).keyword(this._omlGrammarAccess.getVocabularyBundleInclusionAccess().getIncludesKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(inclusion).keyword(this._omlGrammarAccess.getVocabularyBundleInclusionAccess().getAsKeyword_3_0()), _function_2);
  }

  protected void _format(final DescriptionExtension _extension, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    _extension.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(_extension).keyword(this._omlGrammarAccess.getDescriptionExtensionAccess().getExtendsKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(_extension).keyword(this._omlGrammarAccess.getDescriptionExtensionAccess().getAsKeyword_3_0()), _function_2);
  }

  protected void _format(final DescriptionUsage usage, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    usage.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(usage).keyword(this._omlGrammarAccess.getDescriptionUsageAccess().getUsesKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(usage).keyword(this._omlGrammarAccess.getDescriptionUsageAccess().getAsKeyword_3_0()), _function_2);
  }

  protected void _format(final DescriptionBundleExtension _extension, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    _extension.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(_extension).keyword(this._omlGrammarAccess.getDescriptionBundleExtensionAccess().getExtendsKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(_extension).keyword(this._omlGrammarAccess.getDescriptionBundleExtensionAccess().getAsKeyword_3_0()), _function_2);
  }

  protected void _format(final DescriptionBundleInclusion inclusion, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    inclusion.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(inclusion).keyword(this._omlGrammarAccess.getDescriptionBundleInclusionAccess().getIncludesKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(inclusion).keyword(this._omlGrammarAccess.getDescriptionBundleInclusionAccess().getAsKeyword_3_0()), _function_2);
  }

  protected void _format(final DescriptionBundleUsage usage, @Extension final IFormattableDocument document) {
    final Consumer<Annotation> _function = (Annotation it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<Annotation>append(document.<Annotation>format(it), _function_1);
    };
    usage.getOwnedAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(usage).keyword(this._omlGrammarAccess.getDescriptionBundleUsageAccess().getUsesKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(usage).keyword(this._omlGrammarAccess.getDescriptionBundleUsageAccess().getAsKeyword_3_0()), _function_2);
  }

  protected void _format(final ScalarPropertyRangeRestrictionAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getScalarKeyword_2()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_3()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getToKeyword_5()), _function_3);
  }

  protected void _format(final ScalarPropertyCardinalityRestrictionAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getScalarKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_2()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getToKeyword_4()), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).feature(OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND), _function_4);
    Scalar _range = axiom.getRange();
    boolean _tripleNotEquals = (_range != null);
    if (_tripleNotEquals) {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.prepend(this.textRegionExtensions.regionFor(axiom).feature(OmlPackage.Literals.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE), _function_5);
    }
  }

  protected void _format(final ScalarPropertyValueRestrictionAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getScalarKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyKeyword_2()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getToKeyword_4()), _function_3);
  }

  protected void _format(final StructuredPropertyRangeRestrictionAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getStructuredKeyword_2()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_3()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getToKeyword_5()), _function_3);
  }

  protected void _format(final StructuredPropertyCardinalityRestrictionAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getStructuredKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_2()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getToKeyword_4()), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).feature(OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND), _function_4);
    Structure _range = axiom.getRange();
    boolean _tripleNotEquals = (_range != null);
    if (_tripleNotEquals) {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.prepend(this.textRegionExtensions.regionFor(axiom).feature(OmlPackage.Literals.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE), _function_5);
    }
  }

  protected void _format(final StructuredPropertyValueRestrictionAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getStructuredKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyKeyword_2()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getToKeyword_4()), _function_3);
  }

  protected void _format(final RelationRangeRestrictionAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getRelationRangeRestrictionAxiomAccess().getRestrictsKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationKeyword_2()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getRelationRangeRestrictionAxiomAccess().getToKeyword_4()), _function_2);
  }

  protected void _format(final RelationCardinalityRestrictionAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRestrictsKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getRelationCardinalityRestrictionAxiomAccess().getToKeyword_3()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).feature(OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__KIND), _function_3);
    Entity _range = axiom.getRange();
    boolean _tripleNotEquals = (_range != null);
    if (_tripleNotEquals) {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.prepend(this.textRegionExtensions.regionFor(axiom).feature(OmlPackage.Literals.RELATION_CARDINALITY_RESTRICTION_AXIOM__RANGE), _function_4);
    }
  }

  protected void _format(final RelationTargetRestrictionAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getRelationTargetRestrictionAxiomAccess().getRestrictsKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationKeyword_1()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getRelationTargetRestrictionAxiomAccess().getToKeyword_3()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(axiom).feature(OmlPackage.Literals.RELATION_TARGET_RESTRICTION_AXIOM__TARGET), _function_3);
  }

  protected void _format(final KeyAxiom axiom, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(axiom).keyword(this._omlGrammarAccess.getKeyAxiomAccess().getKeyKeyword_0()), _function);
    this.formatCommas(axiom, document);
  }

  protected void _format(final ScalarPropertyValueAssertion assertion, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(assertion).feature(OmlPackage.Literals.SCALAR_PROPERTY_VALUE_ASSERTION__PROPERTY), _function);
    Literal _value = assertion.getValue();
    Literal _format = null;
    if (_value!=null) {
      _format=document.<Literal>format(_value);
    }
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.<Literal>prepend(_format, _function_1);
  }

  protected void _format(final StructuredPropertyValueAssertion assertion, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(assertion).feature(OmlPackage.Literals.STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY), _function);
  }

  protected void _format(final LinkAssertion assertion, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(assertion).feature(OmlPackage.Literals.LINK_ASSERTION__RELATION), _function);
  }

  protected void _format(final TypePredicate predicate, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getTypePredicateAccess().getLeftParenthesisKeyword_1()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getTypePredicateAccess().getRightParenthesisKeyword_3()), _function_1);
  }

  protected void _format(final RelationEntityPredicate predicate, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getRelationEntityPredicateAccess().getLeftParenthesisKeyword_1()), _function);
    this.formatCommas(predicate, document);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getRelationEntityPredicateAccess().getRightParenthesisKeyword_7()), _function_1);
  }

  protected void _format(final FeaturePredicate predicate, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getFeaturePredicateAccess().getLeftParenthesisKeyword_1()), _function);
    this.formatCommas(predicate, document);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getFeaturePredicateAccess().getRightParenthesisKeyword_5()), _function_1);
  }

  protected void _format(final SameAsPredicate predicate, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getSameAsPredicateAccess().getLeftParenthesisKeyword_1()), _function);
    this.formatCommas(predicate, document);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getSameAsPredicateAccess().getRightParenthesisKeyword_5()), _function_1);
  }

  protected void _format(final DifferentFromPredicate predicate, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getDifferentFromPredicateAccess().getLeftParenthesisKeyword_1()), _function);
    this.formatCommas(predicate, document);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(predicate).keyword(this._omlGrammarAccess.getDifferentFromPredicateAccess().getRightParenthesisKeyword_5()), _function_1);
  }

  protected void _format(final QuotedLiteral literal, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(literal).keyword(this._omlGrammarAccess.getQuotedLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(literal).keyword(this._omlGrammarAccess.getQuotedLiteralAccess().getDollarSignKeyword_1_1_0()), _function_1);
  }

  public Pair<ISemanticRegion, ISemanticRegion> formatBrackets(final EObject e, @Extension final IFormattableDocument document) {
    Pair<ISemanticRegion, ISemanticRegion> _xblockexpression = null;
    {
      final ISemanticRegion open = this.textRegionExtensions.regionFor(e).keyword("[");
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.prepend(open, _function);
      final ISemanticRegion close = this.textRegionExtensions.regionFor(e).keyword("]");
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.newLine();
      };
      document.prepend(close, _function_1);
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.indent();
      };
      _xblockexpression = document.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_2);
    }
    return _xblockexpression;
  }

  public Pair<ISemanticRegion, ISemanticRegion> formatBraces(final EObject e, @Extension final IFormattableDocument document) {
    Pair<ISemanticRegion, ISemanticRegion> _xblockexpression = null;
    {
      final ISemanticRegion open = this.textRegionExtensions.regionFor(e).keyword("{");
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.prepend(open, _function);
      final ISemanticRegion close = this.textRegionExtensions.regionFor(e).keyword("}");
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.newLine();
      };
      document.prepend(close, _function_1);
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.indent();
      };
      _xblockexpression = document.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_2);
    }
    return _xblockexpression;
  }

  public void formatCommas(final EObject e, @Extension final IFormattableDocument document) {
    final Consumer<ISemanticRegion> _function = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.append(document.prepend(it, _function_1), _function_2);
    };
    this.textRegionExtensions.regionFor(e).keywords(",").forEach(_function);
  }

  public void format(final Object aspect, final IFormattableDocument document) {
    if (aspect instanceof Aspect) {
      _format((Aspect)aspect, document);
      return;
    } else if (aspect instanceof Concept) {
      _format((Concept)aspect, document);
      return;
    } else if (aspect instanceof RelationEntity) {
      _format((RelationEntity)aspect, document);
      return;
    } else if (aspect instanceof EnumeratedScalar) {
      _format((EnumeratedScalar)aspect, document);
      return;
    } else if (aspect instanceof FacetedScalar) {
      _format((FacetedScalar)aspect, document);
      return;
    } else if (aspect instanceof ScalarProperty) {
      _format((ScalarProperty)aspect, document);
      return;
    } else if (aspect instanceof Structure) {
      _format((Structure)aspect, document);
      return;
    } else if (aspect instanceof StructuredProperty) {
      _format((StructuredProperty)aspect, document);
      return;
    } else if (aspect instanceof AnnotationProperty) {
      _format((AnnotationProperty)aspect, document);
      return;
    } else if (aspect instanceof ForwardRelation) {
      _format((ForwardRelation)aspect, document);
      return;
    } else if (aspect instanceof ReverseRelation) {
      _format((ReverseRelation)aspect, document);
      return;
    } else if (aspect instanceof AspectReference) {
      _format((AspectReference)aspect, document);
      return;
    } else if (aspect instanceof ConceptReference) {
      _format((ConceptReference)aspect, document);
      return;
    } else if (aspect instanceof RelationEntityReference) {
      _format((RelationEntityReference)aspect, document);
      return;
    } else if (aspect instanceof ConceptInstance) {
      _format((ConceptInstance)aspect, document);
      return;
    } else if (aspect instanceof Description) {
      _format((Description)aspect, document);
      return;
    } else if (aspect instanceof DescriptionBundle) {
      _format((DescriptionBundle)aspect, document);
      return;
    } else if (aspect instanceof RelationInstance) {
      _format((RelationInstance)aspect, document);
      return;
    } else if (aspect instanceof ScalarPropertyCardinalityRestrictionAxiom) {
      _format((ScalarPropertyCardinalityRestrictionAxiom)aspect, document);
      return;
    } else if (aspect instanceof ScalarPropertyRangeRestrictionAxiom) {
      _format((ScalarPropertyRangeRestrictionAxiom)aspect, document);
      return;
    } else if (aspect instanceof ScalarPropertyValueRestrictionAxiom) {
      _format((ScalarPropertyValueRestrictionAxiom)aspect, document);
      return;
    } else if (aspect instanceof StructureReference) {
      _format((StructureReference)aspect, document);
      return;
    } else if (aspect instanceof StructuredPropertyCardinalityRestrictionAxiom) {
      _format((StructuredPropertyCardinalityRestrictionAxiom)aspect, document);
      return;
    } else if (aspect instanceof StructuredPropertyRangeRestrictionAxiom) {
      _format((StructuredPropertyRangeRestrictionAxiom)aspect, document);
      return;
    } else if (aspect instanceof StructuredPropertyValueRestrictionAxiom) {
      _format((StructuredPropertyValueRestrictionAxiom)aspect, document);
      return;
    } else if (aspect instanceof Vocabulary) {
      _format((Vocabulary)aspect, document);
      return;
    } else if (aspect instanceof VocabularyBundle) {
      _format((VocabularyBundle)aspect, document);
      return;
    } else if (aspect instanceof AnnotationPropertyReference) {
      _format((AnnotationPropertyReference)aspect, document);
      return;
    } else if (aspect instanceof ConceptInstanceReference) {
      _format((ConceptInstanceReference)aspect, document);
      return;
    } else if (aspect instanceof DescriptionBundleExtension) {
      _format((DescriptionBundleExtension)aspect, document);
      return;
    } else if (aspect instanceof DescriptionBundleInclusion) {
      _format((DescriptionBundleInclusion)aspect, document);
      return;
    } else if (aspect instanceof DescriptionBundleUsage) {
      _format((DescriptionBundleUsage)aspect, document);
      return;
    } else if (aspect instanceof DescriptionExtension) {
      _format((DescriptionExtension)aspect, document);
      return;
    } else if (aspect instanceof DescriptionUsage) {
      _format((DescriptionUsage)aspect, document);
      return;
    } else if (aspect instanceof EnumeratedScalarReference) {
      _format((EnumeratedScalarReference)aspect, document);
      return;
    } else if (aspect instanceof FacetedScalarReference) {
      _format((FacetedScalarReference)aspect, document);
      return;
    } else if (aspect instanceof RelationCardinalityRestrictionAxiom) {
      _format((RelationCardinalityRestrictionAxiom)aspect, document);
      return;
    } else if (aspect instanceof RelationInstanceReference) {
      _format((RelationInstanceReference)aspect, document);
      return;
    } else if (aspect instanceof RelationRangeRestrictionAxiom) {
      _format((RelationRangeRestrictionAxiom)aspect, document);
      return;
    } else if (aspect instanceof RelationTargetRestrictionAxiom) {
      _format((RelationTargetRestrictionAxiom)aspect, document);
      return;
    } else if (aspect instanceof Rule) {
      _format((Rule)aspect, document);
      return;
    } else if (aspect instanceof ScalarPropertyReference) {
      _format((ScalarPropertyReference)aspect, document);
      return;
    } else if (aspect instanceof StructuredPropertyReference) {
      _format((StructuredPropertyReference)aspect, document);
      return;
    } else if (aspect instanceof VocabularyBundleExtension) {
      _format((VocabularyBundleExtension)aspect, document);
      return;
    } else if (aspect instanceof VocabularyBundleInclusion) {
      _format((VocabularyBundleInclusion)aspect, document);
      return;
    } else if (aspect instanceof VocabularyExtension) {
      _format((VocabularyExtension)aspect, document);
      return;
    } else if (aspect instanceof VocabularyUsage) {
      _format((VocabularyUsage)aspect, document);
      return;
    } else if (aspect instanceof DifferentFromPredicate) {
      _format((DifferentFromPredicate)aspect, document);
      return;
    } else if (aspect instanceof FeaturePredicate) {
      _format((FeaturePredicate)aspect, document);
      return;
    } else if (aspect instanceof RelationEntityPredicate) {
      _format((RelationEntityPredicate)aspect, document);
      return;
    } else if (aspect instanceof RelationReference) {
      _format((RelationReference)aspect, document);
      return;
    } else if (aspect instanceof RuleReference) {
      _format((RuleReference)aspect, document);
      return;
    } else if (aspect instanceof SameAsPredicate) {
      _format((SameAsPredicate)aspect, document);
      return;
    } else if (aspect instanceof ScalarPropertyValueAssertion) {
      _format((ScalarPropertyValueAssertion)aspect, document);
      return;
    } else if (aspect instanceof StructuredPropertyValueAssertion) {
      _format((StructuredPropertyValueAssertion)aspect, document);
      return;
    } else if (aspect instanceof TypePredicate) {
      _format((TypePredicate)aspect, document);
      return;
    } else if (aspect instanceof KeyAxiom) {
      _format((KeyAxiom)aspect, document);
      return;
    } else if (aspect instanceof LinkAssertion) {
      _format((LinkAssertion)aspect, document);
      return;
    } else if (aspect instanceof QuotedLiteral) {
      _format((QuotedLiteral)aspect, document);
      return;
    } else if (aspect instanceof StructureInstance) {
      _format((StructureInstance)aspect, document);
      return;
    } else if (aspect instanceof XtextResource) {
      _format((XtextResource)aspect, document);
      return;
    } else if (aspect instanceof Annotation) {
      _format((Annotation)aspect, document);
      return;
    } else if (aspect instanceof EObject) {
      _format((EObject)aspect, document);
      return;
    } else if (aspect == null) {
      _format((Void)null, document);
      return;
    } else if (aspect != null) {
      _format(aspect, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(aspect, document).toString());
    }
  }
}
