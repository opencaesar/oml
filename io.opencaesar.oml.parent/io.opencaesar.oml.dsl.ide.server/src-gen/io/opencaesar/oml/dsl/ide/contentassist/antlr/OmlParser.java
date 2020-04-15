/*
 * Copyright 2019 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opencaesar.oml.dsl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.opencaesar.oml.dsl.ide.contentassist.antlr.internal.InternalOmlParser;
import io.opencaesar.oml.dsl.services.OmlGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class OmlParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(OmlGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, OmlGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getOntologyAccess().getAlternatives(), "rule__Ontology__Alternatives");
			builder.put(grammarAccess.getElementAccess().getAlternatives(), "rule__Element__Alternatives");
			builder.put(grammarAccess.getAnnotatedElementAccess().getAlternatives(), "rule__AnnotatedElement__Alternatives");
			builder.put(grammarAccess.getIdentifiedElementAccess().getAlternatives(), "rule__IdentifiedElement__Alternatives");
			builder.put(grammarAccess.getTerminologyAccess().getAlternatives(), "rule__Terminology__Alternatives");
			builder.put(grammarAccess.getMemberAccess().getAlternatives(), "rule__Member__Alternatives");
			builder.put(grammarAccess.getTermAccess().getAlternatives(), "rule__Term__Alternatives");
			builder.put(grammarAccess.getSpecializableTermAccess().getAlternatives(), "rule__SpecializableTerm__Alternatives");
			builder.put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
			builder.put(grammarAccess.getClassifierAccess().getAlternatives(), "rule__Classifier__Alternatives");
			builder.put(grammarAccess.getEntityAccess().getAlternatives(), "rule__Entity__Alternatives");
			builder.put(grammarAccess.getPropertyAccess().getAlternatives(), "rule__Property__Alternatives");
			builder.put(grammarAccess.getFeaturePropertyAccess().getAlternatives(), "rule__FeatureProperty__Alternatives");
			builder.put(grammarAccess.getScalarAccess().getAlternatives(), "rule__Scalar__Alternatives");
			builder.put(grammarAccess.getRelationAccess().getAlternatives(), "rule__Relation__Alternatives");
			builder.put(grammarAccess.getInstanceAccess().getAlternatives(), "rule__Instance__Alternatives");
			builder.put(grammarAccess.getNamedInstanceAccess().getAlternatives(), "rule__NamedInstance__Alternatives");
			builder.put(grammarAccess.getReferenceAccess().getAlternatives(), "rule__Reference__Alternatives");
			builder.put(grammarAccess.getVocabularyMemberReferenceAccess().getAlternatives(), "rule__VocabularyMemberReference__Alternatives");
			builder.put(grammarAccess.getSpecializableTermReferenceAccess().getAlternatives(), "rule__SpecializableTermReference__Alternatives");
			builder.put(grammarAccess.getEntityReferenceAccess().getAlternatives(), "rule__EntityReference__Alternatives");
			builder.put(grammarAccess.getNamedInstanceReferenceAccess().getAlternatives(), "rule__NamedInstanceReference__Alternatives");
			builder.put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
			builder.put(grammarAccess.getVocabularyStatementAccess().getAlternatives(), "rule__VocabularyStatement__Alternatives");
			builder.put(grammarAccess.getDescriptionStatementAccess().getAlternatives(), "rule__DescriptionStatement__Alternatives");
			builder.put(grammarAccess.getImportAccess().getAlternatives(), "rule__Import__Alternatives");
			builder.put(grammarAccess.getVocabularyImportAccess().getAlternatives(), "rule__VocabularyImport__Alternatives");
			builder.put(grammarAccess.getBundleImportAccess().getAlternatives(), "rule__BundleImport__Alternatives");
			builder.put(grammarAccess.getDescriptionImportAccess().getAlternatives(), "rule__DescriptionImport__Alternatives");
			builder.put(grammarAccess.getAxiomAccess().getAlternatives(), "rule__Axiom__Alternatives");
			builder.put(grammarAccess.getRestrictionAxiomAccess().getAlternatives(), "rule__RestrictionAxiom__Alternatives");
			builder.put(grammarAccess.getPropertyRestrictionAxiomAccess().getAlternatives(), "rule__PropertyRestrictionAxiom__Alternatives");
			builder.put(grammarAccess.getScalarPropertyRestrictionAxiomAccess().getAlternatives(), "rule__ScalarPropertyRestrictionAxiom__Alternatives");
			builder.put(grammarAccess.getStructuredPropertyRestrictionAxiomAccess().getAlternatives(), "rule__StructuredPropertyRestrictionAxiom__Alternatives");
			builder.put(grammarAccess.getRelationRestrictionAxiomAccess().getAlternatives(), "rule__RelationRestrictionAxiom__Alternatives");
			builder.put(grammarAccess.getAssertionAccess().getAlternatives(), "rule__Assertion__Alternatives");
			builder.put(grammarAccess.getTypeAssertionAccess().getAlternatives(), "rule__TypeAssertion__Alternatives");
			builder.put(grammarAccess.getPropertyValueAssertionAccess().getAlternatives(), "rule__PropertyValueAssertion__Alternatives");
			builder.put(grammarAccess.getPredicateAccess().getAlternatives(), "rule__Predicate__Alternatives");
			builder.put(grammarAccess.getBinaryPredicateAccess().getAlternatives(), "rule__BinaryPredicate__Alternatives");
			builder.put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
			builder.put(grammarAccess.getQuotedLiteralAccess().getAlternatives_1(), "rule__QuotedLiteral__Alternatives_1");
			builder.put(grammarAccess.getRefAccess().getAlternatives(), "rule__Ref__Alternatives");
			builder.put(grammarAccess.getIntegerAccess().getAlternatives(), "rule__Integer__Alternatives");
			builder.put(grammarAccess.getSeparatorKindAccess().getAlternatives(), "rule__SeparatorKind__Alternatives");
			builder.put(grammarAccess.getRangeRestrictionKindAccess().getAlternatives(), "rule__RangeRestrictionKind__Alternatives");
			builder.put(grammarAccess.getCardinalityRestrictionKindAccess().getAlternatives(), "rule__CardinalityRestrictionKind__Alternatives");
			builder.put(grammarAccess.getAnnotationAccess().getGroup(), "rule__Annotation__Group__0");
			builder.put(grammarAccess.getVocabularyAccess().getGroup(), "rule__Vocabulary__Group__0");
			builder.put(grammarAccess.getBundleAccess().getGroup(), "rule__Bundle__Group__0");
			builder.put(grammarAccess.getDescriptionAccess().getGroup(), "rule__Description__Group__0");
			builder.put(grammarAccess.getAspectAccess().getGroup(), "rule__Aspect__Group__0");
			builder.put(grammarAccess.getAspectAccess().getGroup_3(), "rule__Aspect__Group_3__0");
			builder.put(grammarAccess.getAspectAccess().getGroup_3_2(), "rule__Aspect__Group_3_2__0");
			builder.put(grammarAccess.getAspectAccess().getGroup_4(), "rule__Aspect__Group_4__0");
			builder.put(grammarAccess.getConceptAccess().getGroup(), "rule__Concept__Group__0");
			builder.put(grammarAccess.getConceptAccess().getGroup_3(), "rule__Concept__Group_3__0");
			builder.put(grammarAccess.getConceptAccess().getGroup_3_2(), "rule__Concept__Group_3_2__0");
			builder.put(grammarAccess.getConceptAccess().getGroup_4(), "rule__Concept__Group_4__0");
			builder.put(grammarAccess.getRelationEntityAccess().getGroup(), "rule__RelationEntity__Group__0");
			builder.put(grammarAccess.getRelationEntityAccess().getGroup_4(), "rule__RelationEntity__Group_4__0");
			builder.put(grammarAccess.getRelationEntityAccess().getGroup_4_2(), "rule__RelationEntity__Group_4_2__0");
			builder.put(grammarAccess.getRelationEntityAccess().getGroup_5(), "rule__RelationEntity__Group_5__0");
			builder.put(grammarAccess.getRelationEntityAccess().getGroup_5_7_1(), "rule__RelationEntity__Group_5_7_1__0");
			builder.put(grammarAccess.getStructureAccess().getGroup(), "rule__Structure__Group__0");
			builder.put(grammarAccess.getStructureAccess().getGroup_3(), "rule__Structure__Group_3__0");
			builder.put(grammarAccess.getStructureAccess().getGroup_3_2(), "rule__Structure__Group_3_2__0");
			builder.put(grammarAccess.getStructureAccess().getGroup_4(), "rule__Structure__Group_4__0");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getGroup(), "rule__AnnotationProperty__Group__0");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getGroup_4(), "rule__AnnotationProperty__Group_4__0");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getGroup_4_2(), "rule__AnnotationProperty__Group_4_2__0");
			builder.put(grammarAccess.getScalarPropertyAccess().getGroup(), "rule__ScalarProperty__Group__0");
			builder.put(grammarAccess.getScalarPropertyAccess().getGroup_4(), "rule__ScalarProperty__Group_4__0");
			builder.put(grammarAccess.getScalarPropertyAccess().getGroup_4_2(), "rule__ScalarProperty__Group_4_2__0");
			builder.put(grammarAccess.getScalarPropertyAccess().getGroup_5(), "rule__ScalarProperty__Group_5__0");
			builder.put(grammarAccess.getStructuredPropertyAccess().getGroup(), "rule__StructuredProperty__Group__0");
			builder.put(grammarAccess.getStructuredPropertyAccess().getGroup_4(), "rule__StructuredProperty__Group_4__0");
			builder.put(grammarAccess.getStructuredPropertyAccess().getGroup_4_2(), "rule__StructuredProperty__Group_4_2__0");
			builder.put(grammarAccess.getStructuredPropertyAccess().getGroup_5(), "rule__StructuredProperty__Group_5__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup(), "rule__FacetedScalar__Group__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_3(), "rule__FacetedScalar__Group_3__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_3_2(), "rule__FacetedScalar__Group_3_2__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4(), "rule__FacetedScalar__Group_4__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4_1_0(), "rule__FacetedScalar__Group_4_1_0__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4_1_1(), "rule__FacetedScalar__Group_4_1_1__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4_1_2(), "rule__FacetedScalar__Group_4_1_2__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4_1_3(), "rule__FacetedScalar__Group_4_1_3__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4_1_4(), "rule__FacetedScalar__Group_4_1_4__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4_1_5(), "rule__FacetedScalar__Group_4_1_5__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4_1_6(), "rule__FacetedScalar__Group_4_1_6__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4_1_7(), "rule__FacetedScalar__Group_4_1_7__0");
			builder.put(grammarAccess.getFacetedScalarAccess().getGroup_4_1_8(), "rule__FacetedScalar__Group_4_1_8__0");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getGroup(), "rule__EnumeratedScalar__Group__0");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getGroup_4(), "rule__EnumeratedScalar__Group_4__0");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getGroup_4_2(), "rule__EnumeratedScalar__Group_4_2__0");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getGroup_5(), "rule__EnumeratedScalar__Group_5__0");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getGroup_5_2(), "rule__EnumeratedScalar__Group_5_2__0");
			builder.put(grammarAccess.getForwardRelationAccess().getGroup(), "rule__ForwardRelation__Group__0");
			builder.put(grammarAccess.getInverseRelationAccess().getGroup(), "rule__InverseRelation__Group__0");
			builder.put(grammarAccess.getRuleAccess().getGroup(), "rule__Rule__Group__0");
			builder.put(grammarAccess.getRuleAccess().getGroup_5(), "rule__Rule__Group_5__0");
			builder.put(grammarAccess.getRuleAccess().getGroup_8(), "rule__Rule__Group_8__0");
			builder.put(grammarAccess.getStructureInstanceAccess().getGroup(), "rule__StructureInstance__Group__0");
			builder.put(grammarAccess.getConceptInstanceAccess().getGroup(), "rule__ConceptInstance__Group__0");
			builder.put(grammarAccess.getConceptInstanceAccess().getGroup_3(), "rule__ConceptInstance__Group_3__0");
			builder.put(grammarAccess.getConceptInstanceAccess().getGroup_3_2(), "rule__ConceptInstance__Group_3_2__0");
			builder.put(grammarAccess.getConceptInstanceAccess().getGroup_4(), "rule__ConceptInstance__Group_4__0");
			builder.put(grammarAccess.getRelationInstanceAccess().getGroup(), "rule__RelationInstance__Group__0");
			builder.put(grammarAccess.getRelationInstanceAccess().getGroup_3(), "rule__RelationInstance__Group_3__0");
			builder.put(grammarAccess.getRelationInstanceAccess().getGroup_3_2(), "rule__RelationInstance__Group_3_2__0");
			builder.put(grammarAccess.getRelationInstanceAccess().getGroup_4(), "rule__RelationInstance__Group_4__0");
			builder.put(grammarAccess.getAspectReferenceAccess().getGroup(), "rule__AspectReference__Group__0");
			builder.put(grammarAccess.getAspectReferenceAccess().getGroup_4(), "rule__AspectReference__Group_4__0");
			builder.put(grammarAccess.getAspectReferenceAccess().getGroup_4_2(), "rule__AspectReference__Group_4_2__0");
			builder.put(grammarAccess.getAspectReferenceAccess().getGroup_5(), "rule__AspectReference__Group_5__0");
			builder.put(grammarAccess.getConceptReferenceAccess().getGroup(), "rule__ConceptReference__Group__0");
			builder.put(grammarAccess.getConceptReferenceAccess().getGroup_4(), "rule__ConceptReference__Group_4__0");
			builder.put(grammarAccess.getConceptReferenceAccess().getGroup_4_2(), "rule__ConceptReference__Group_4_2__0");
			builder.put(grammarAccess.getConceptReferenceAccess().getGroup_5(), "rule__ConceptReference__Group_5__0");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getGroup(), "rule__RelationEntityReference__Group__0");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getGroup_5(), "rule__RelationEntityReference__Group_5__0");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getGroup_5_2(), "rule__RelationEntityReference__Group_5_2__0");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getGroup_6(), "rule__RelationEntityReference__Group_6__0");
			builder.put(grammarAccess.getStructureReferenceAccess().getGroup(), "rule__StructureReference__Group__0");
			builder.put(grammarAccess.getStructureReferenceAccess().getGroup_4(), "rule__StructureReference__Group_4__0");
			builder.put(grammarAccess.getStructureReferenceAccess().getGroup_4_2(), "rule__StructureReference__Group_4_2__0");
			builder.put(grammarAccess.getStructureReferenceAccess().getGroup_5(), "rule__StructureReference__Group_5__0");
			builder.put(grammarAccess.getAnnotationPropertyReferenceAccess().getGroup(), "rule__AnnotationPropertyReference__Group__0");
			builder.put(grammarAccess.getAnnotationPropertyReferenceAccess().getGroup_5(), "rule__AnnotationPropertyReference__Group_5__0");
			builder.put(grammarAccess.getAnnotationPropertyReferenceAccess().getGroup_5_2(), "rule__AnnotationPropertyReference__Group_5_2__0");
			builder.put(grammarAccess.getScalarPropertyReferenceAccess().getGroup(), "rule__ScalarPropertyReference__Group__0");
			builder.put(grammarAccess.getScalarPropertyReferenceAccess().getGroup_5(), "rule__ScalarPropertyReference__Group_5__0");
			builder.put(grammarAccess.getScalarPropertyReferenceAccess().getGroup_5_2(), "rule__ScalarPropertyReference__Group_5_2__0");
			builder.put(grammarAccess.getStructuredPropertyReferenceAccess().getGroup(), "rule__StructuredPropertyReference__Group__0");
			builder.put(grammarAccess.getStructuredPropertyReferenceAccess().getGroup_5(), "rule__StructuredPropertyReference__Group_5__0");
			builder.put(grammarAccess.getStructuredPropertyReferenceAccess().getGroup_5_2(), "rule__StructuredPropertyReference__Group_5_2__0");
			builder.put(grammarAccess.getFacetedScalarReferenceAccess().getGroup(), "rule__FacetedScalarReference__Group__0");
			builder.put(grammarAccess.getFacetedScalarReferenceAccess().getGroup_4(), "rule__FacetedScalarReference__Group_4__0");
			builder.put(grammarAccess.getFacetedScalarReferenceAccess().getGroup_4_2(), "rule__FacetedScalarReference__Group_4_2__0");
			builder.put(grammarAccess.getEnumeratedScalarReferenceAccess().getGroup(), "rule__EnumeratedScalarReference__Group__0");
			builder.put(grammarAccess.getEnumeratedScalarReferenceAccess().getGroup_5(), "rule__EnumeratedScalarReference__Group_5__0");
			builder.put(grammarAccess.getEnumeratedScalarReferenceAccess().getGroup_5_2(), "rule__EnumeratedScalarReference__Group_5_2__0");
			builder.put(grammarAccess.getRelationReferenceAccess().getGroup(), "rule__RelationReference__Group__0");
			builder.put(grammarAccess.getRuleReferenceAccess().getGroup(), "rule__RuleReference__Group__0");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getGroup(), "rule__ConceptInstanceReference__Group__0");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getGroup_4(), "rule__ConceptInstanceReference__Group_4__0");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getGroup_4_2(), "rule__ConceptInstanceReference__Group_4_2__0");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getGroup_5(), "rule__ConceptInstanceReference__Group_5__0");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getGroup(), "rule__RelationInstanceReference__Group__0");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getGroup_4(), "rule__RelationInstanceReference__Group_4__0");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getGroup_4_2(), "rule__RelationInstanceReference__Group_4_2__0");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getGroup_5(), "rule__RelationInstanceReference__Group_5__0");
			builder.put(grammarAccess.getVocabularyExtensionAccess().getGroup(), "rule__VocabularyExtension__Group__0");
			builder.put(grammarAccess.getVocabularyExtensionAccess().getGroup_3(), "rule__VocabularyExtension__Group_3__0");
			builder.put(grammarAccess.getVocabularyUsageAccess().getGroup(), "rule__VocabularyUsage__Group__0");
			builder.put(grammarAccess.getVocabularyUsageAccess().getGroup_3(), "rule__VocabularyUsage__Group_3__0");
			builder.put(grammarAccess.getBundleInclusionAccess().getGroup(), "rule__BundleInclusion__Group__0");
			builder.put(grammarAccess.getBundleInclusionAccess().getGroup_3(), "rule__BundleInclusion__Group_3__0");
			builder.put(grammarAccess.getBundleExtensionAccess().getGroup(), "rule__BundleExtension__Group__0");
			builder.put(grammarAccess.getBundleExtensionAccess().getGroup_3(), "rule__BundleExtension__Group_3__0");
			builder.put(grammarAccess.getDescriptionUsageAccess().getGroup(), "rule__DescriptionUsage__Group__0");
			builder.put(grammarAccess.getDescriptionUsageAccess().getGroup_3(), "rule__DescriptionUsage__Group_3__0");
			builder.put(grammarAccess.getDescriptionExtensionAccess().getGroup(), "rule__DescriptionExtension__Group__0");
			builder.put(grammarAccess.getDescriptionExtensionAccess().getGroup_3(), "rule__DescriptionExtension__Group_3__0");
			builder.put(grammarAccess.getSpecializationAxiomAccess().getGroup(), "rule__SpecializationAxiom__Group__0");
			builder.put(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getGroup(), "rule__ScalarPropertyRangeRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getGroup(), "rule__ScalarPropertyCardinalityRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getGroup(), "rule__ScalarPropertyValueRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getGroup(), "rule__StructuredPropertyRangeRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getGroup(), "rule__StructuredPropertyCardinalityRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getGroup(), "rule__StructuredPropertyValueRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getRelationRangeRestrictionAxiomAccess().getGroup(), "rule__RelationRangeRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getGroup(), "rule__RelationCardinalityRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getRelationTargetRestrictionAxiomAccess().getGroup(), "rule__RelationTargetRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getKeyAxiomAccess().getGroup(), "rule__KeyAxiom__Group__0");
			builder.put(grammarAccess.getKeyAxiomAccess().getGroup_2(), "rule__KeyAxiom__Group_2__0");
			builder.put(grammarAccess.getConceptTypeAssertionAccess().getGroup(), "rule__ConceptTypeAssertion__Group__0");
			builder.put(grammarAccess.getRelationTypeAssertionAccess().getGroup(), "rule__RelationTypeAssertion__Group__0");
			builder.put(grammarAccess.getScalarPropertyValueAssertionAccess().getGroup(), "rule__ScalarPropertyValueAssertion__Group__0");
			builder.put(grammarAccess.getStructuredPropertyValueAssertionAccess().getGroup(), "rule__StructuredPropertyValueAssertion__Group__0");
			builder.put(grammarAccess.getLinkAssertionAccess().getGroup(), "rule__LinkAssertion__Group__0");
			builder.put(grammarAccess.getEntityPredicateAccess().getGroup(), "rule__EntityPredicate__Group__0");
			builder.put(grammarAccess.getRelationPredicateAccess().getGroup(), "rule__RelationPredicate__Group__0");
			builder.put(grammarAccess.getSameAsPredicateAccess().getGroup(), "rule__SameAsPredicate__Group__0");
			builder.put(grammarAccess.getDifferentFromPredicateAccess().getGroup(), "rule__DifferentFromPredicate__Group__0");
			builder.put(grammarAccess.getRelationEntityPredicateAccess().getGroup(), "rule__RelationEntityPredicate__Group__0");
			builder.put(grammarAccess.getIntegerLiteralAccess().getGroup(), "rule__IntegerLiteral__Group__0");
			builder.put(grammarAccess.getIntegerLiteralAccess().getGroup_1(), "rule__IntegerLiteral__Group_1__0");
			builder.put(grammarAccess.getDecimalLiteralAccess().getGroup(), "rule__DecimalLiteral__Group__0");
			builder.put(grammarAccess.getDecimalLiteralAccess().getGroup_1(), "rule__DecimalLiteral__Group_1__0");
			builder.put(grammarAccess.getDoubleLiteralAccess().getGroup(), "rule__DoubleLiteral__Group__0");
			builder.put(grammarAccess.getDoubleLiteralAccess().getGroup_1(), "rule__DoubleLiteral__Group_1__0");
			builder.put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
			builder.put(grammarAccess.getBooleanLiteralAccess().getGroup_1(), "rule__BooleanLiteral__Group_1__0");
			builder.put(grammarAccess.getQuotedLiteralAccess().getGroup(), "rule__QuotedLiteral__Group__0");
			builder.put(grammarAccess.getQuotedLiteralAccess().getGroup_1_0(), "rule__QuotedLiteral__Group_1_0__0");
			builder.put(grammarAccess.getQuotedLiteralAccess().getGroup_1_1(), "rule__QuotedLiteral__Group_1_1__0");
			builder.put(grammarAccess.getAnnotationAccess().getPropertyAssignment_1(), "rule__Annotation__PropertyAssignment_1");
			builder.put(grammarAccess.getAnnotationAccess().getValueAssignment_2(), "rule__Annotation__ValueAssignment_2");
			builder.put(grammarAccess.getVocabularyAccess().getOwnedAnnotationsAssignment_0(), "rule__Vocabulary__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getVocabularyAccess().getIriAssignment_2(), "rule__Vocabulary__IriAssignment_2");
			builder.put(grammarAccess.getVocabularyAccess().getSeparatorAssignment_4(), "rule__Vocabulary__SeparatorAssignment_4");
			builder.put(grammarAccess.getVocabularyAccess().getPrefixAssignment_6(), "rule__Vocabulary__PrefixAssignment_6");
			builder.put(grammarAccess.getVocabularyAccess().getOwnedImportsAssignment_8(), "rule__Vocabulary__OwnedImportsAssignment_8");
			builder.put(grammarAccess.getVocabularyAccess().getOwnedStatementsAssignment_9(), "rule__Vocabulary__OwnedStatementsAssignment_9");
			builder.put(grammarAccess.getBundleAccess().getOwnedAnnotationsAssignment_0(), "rule__Bundle__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getBundleAccess().getIriAssignment_2(), "rule__Bundle__IriAssignment_2");
			builder.put(grammarAccess.getBundleAccess().getSeparatorAssignment_4(), "rule__Bundle__SeparatorAssignment_4");
			builder.put(grammarAccess.getBundleAccess().getPrefixAssignment_6(), "rule__Bundle__PrefixAssignment_6");
			builder.put(grammarAccess.getBundleAccess().getOwnedImportsAssignment_8(), "rule__Bundle__OwnedImportsAssignment_8");
			builder.put(grammarAccess.getDescriptionAccess().getOwnedAnnotationsAssignment_0(), "rule__Description__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getDescriptionAccess().getIriAssignment_2(), "rule__Description__IriAssignment_2");
			builder.put(grammarAccess.getDescriptionAccess().getSeparatorAssignment_4(), "rule__Description__SeparatorAssignment_4");
			builder.put(grammarAccess.getDescriptionAccess().getPrefixAssignment_6(), "rule__Description__PrefixAssignment_6");
			builder.put(grammarAccess.getDescriptionAccess().getOwnedImportsAssignment_8(), "rule__Description__OwnedImportsAssignment_8");
			builder.put(grammarAccess.getDescriptionAccess().getOwnedStatementsAssignment_9(), "rule__Description__OwnedStatementsAssignment_9");
			builder.put(grammarAccess.getAspectAccess().getOwnedAnnotationsAssignment_0(), "rule__Aspect__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getAspectAccess().getNameAssignment_2(), "rule__Aspect__NameAssignment_2");
			builder.put(grammarAccess.getAspectAccess().getOwnedSpecializationsAssignment_3_1(), "rule__Aspect__OwnedSpecializationsAssignment_3_1");
			builder.put(grammarAccess.getAspectAccess().getOwnedSpecializationsAssignment_3_2_1(), "rule__Aspect__OwnedSpecializationsAssignment_3_2_1");
			builder.put(grammarAccess.getAspectAccess().getOwnedKeysAssignment_4_1(), "rule__Aspect__OwnedKeysAssignment_4_1");
			builder.put(grammarAccess.getAspectAccess().getOwnedPropertyRestrictionsAssignment_4_2(), "rule__Aspect__OwnedPropertyRestrictionsAssignment_4_2");
			builder.put(grammarAccess.getAspectAccess().getOwnedRelationRestrictionsAssignment_4_3(), "rule__Aspect__OwnedRelationRestrictionsAssignment_4_3");
			builder.put(grammarAccess.getConceptAccess().getOwnedAnnotationsAssignment_0(), "rule__Concept__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getConceptAccess().getNameAssignment_2(), "rule__Concept__NameAssignment_2");
			builder.put(grammarAccess.getConceptAccess().getOwnedSpecializationsAssignment_3_1(), "rule__Concept__OwnedSpecializationsAssignment_3_1");
			builder.put(grammarAccess.getConceptAccess().getOwnedSpecializationsAssignment_3_2_1(), "rule__Concept__OwnedSpecializationsAssignment_3_2_1");
			builder.put(grammarAccess.getConceptAccess().getOwnedKeysAssignment_4_1(), "rule__Concept__OwnedKeysAssignment_4_1");
			builder.put(grammarAccess.getConceptAccess().getOwnedPropertyRestrictionsAssignment_4_2(), "rule__Concept__OwnedPropertyRestrictionsAssignment_4_2");
			builder.put(grammarAccess.getConceptAccess().getOwnedRelationRestrictionsAssignment_4_3(), "rule__Concept__OwnedRelationRestrictionsAssignment_4_3");
			builder.put(grammarAccess.getRelationEntityAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationEntity__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationEntityAccess().getNameAssignment_3(), "rule__RelationEntity__NameAssignment_3");
			builder.put(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsAssignment_4_1(), "rule__RelationEntity__OwnedSpecializationsAssignment_4_1");
			builder.put(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsAssignment_4_2_1(), "rule__RelationEntity__OwnedSpecializationsAssignment_4_2_1");
			builder.put(grammarAccess.getRelationEntityAccess().getSourceAssignment_5_2(), "rule__RelationEntity__SourceAssignment_5_2");
			builder.put(grammarAccess.getRelationEntityAccess().getTargetAssignment_5_4(), "rule__RelationEntity__TargetAssignment_5_4");
			builder.put(grammarAccess.getRelationEntityAccess().getForwardAssignment_5_5(), "rule__RelationEntity__ForwardAssignment_5_5");
			builder.put(grammarAccess.getRelationEntityAccess().getInverseAssignment_5_6(), "rule__RelationEntity__InverseAssignment_5_6");
			builder.put(grammarAccess.getRelationEntityAccess().getFunctionalAssignment_5_7_0(), "rule__RelationEntity__FunctionalAssignment_5_7_0");
			builder.put(grammarAccess.getRelationEntityAccess().getInverseFunctionalAssignment_5_7_1_0(), "rule__RelationEntity__InverseFunctionalAssignment_5_7_1_0");
			builder.put(grammarAccess.getRelationEntityAccess().getSymmetricAssignment_5_7_2(), "rule__RelationEntity__SymmetricAssignment_5_7_2");
			builder.put(grammarAccess.getRelationEntityAccess().getAsymmetricAssignment_5_7_3(), "rule__RelationEntity__AsymmetricAssignment_5_7_3");
			builder.put(grammarAccess.getRelationEntityAccess().getReflexiveAssignment_5_7_4(), "rule__RelationEntity__ReflexiveAssignment_5_7_4");
			builder.put(grammarAccess.getRelationEntityAccess().getIrreflexiveAssignment_5_7_5(), "rule__RelationEntity__IrreflexiveAssignment_5_7_5");
			builder.put(grammarAccess.getRelationEntityAccess().getTransitiveAssignment_5_7_6(), "rule__RelationEntity__TransitiveAssignment_5_7_6");
			builder.put(grammarAccess.getRelationEntityAccess().getOwnedKeysAssignment_5_8(), "rule__RelationEntity__OwnedKeysAssignment_5_8");
			builder.put(grammarAccess.getRelationEntityAccess().getOwnedPropertyRestrictionsAssignment_5_9(), "rule__RelationEntity__OwnedPropertyRestrictionsAssignment_5_9");
			builder.put(grammarAccess.getRelationEntityAccess().getOwnedRelationRestrictionsAssignment_5_10(), "rule__RelationEntity__OwnedRelationRestrictionsAssignment_5_10");
			builder.put(grammarAccess.getStructureAccess().getOwnedAnnotationsAssignment_0(), "rule__Structure__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getStructureAccess().getNameAssignment_2(), "rule__Structure__NameAssignment_2");
			builder.put(grammarAccess.getStructureAccess().getOwnedSpecializationsAssignment_3_1(), "rule__Structure__OwnedSpecializationsAssignment_3_1");
			builder.put(grammarAccess.getStructureAccess().getOwnedSpecializationsAssignment_3_2_1(), "rule__Structure__OwnedSpecializationsAssignment_3_2_1");
			builder.put(grammarAccess.getStructureAccess().getOwnedPropertyRestrictionsAssignment_4_1(), "rule__Structure__OwnedPropertyRestrictionsAssignment_4_1");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getOwnedAnnotationsAssignment_0(), "rule__AnnotationProperty__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getNameAssignment_3(), "rule__AnnotationProperty__NameAssignment_3");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsAssignment_4_1(), "rule__AnnotationProperty__OwnedSpecializationsAssignment_4_1");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsAssignment_4_2_1(), "rule__AnnotationProperty__OwnedSpecializationsAssignment_4_2_1");
			builder.put(grammarAccess.getScalarPropertyAccess().getOwnedAnnotationsAssignment_0(), "rule__ScalarProperty__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarPropertyAccess().getNameAssignment_3(), "rule__ScalarProperty__NameAssignment_3");
			builder.put(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsAssignment_4_1(), "rule__ScalarProperty__OwnedSpecializationsAssignment_4_1");
			builder.put(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsAssignment_4_2_1(), "rule__ScalarProperty__OwnedSpecializationsAssignment_4_2_1");
			builder.put(grammarAccess.getScalarPropertyAccess().getDomainAssignment_5_2(), "rule__ScalarProperty__DomainAssignment_5_2");
			builder.put(grammarAccess.getScalarPropertyAccess().getRangeAssignment_5_4(), "rule__ScalarProperty__RangeAssignment_5_4");
			builder.put(grammarAccess.getScalarPropertyAccess().getFunctionalAssignment_5_5(), "rule__ScalarProperty__FunctionalAssignment_5_5");
			builder.put(grammarAccess.getStructuredPropertyAccess().getOwnedAnnotationsAssignment_0(), "rule__StructuredProperty__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getStructuredPropertyAccess().getNameAssignment_3(), "rule__StructuredProperty__NameAssignment_3");
			builder.put(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsAssignment_4_1(), "rule__StructuredProperty__OwnedSpecializationsAssignment_4_1");
			builder.put(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsAssignment_4_2_1(), "rule__StructuredProperty__OwnedSpecializationsAssignment_4_2_1");
			builder.put(grammarAccess.getStructuredPropertyAccess().getDomainAssignment_5_2(), "rule__StructuredProperty__DomainAssignment_5_2");
			builder.put(grammarAccess.getStructuredPropertyAccess().getRangeAssignment_5_4(), "rule__StructuredProperty__RangeAssignment_5_4");
			builder.put(grammarAccess.getStructuredPropertyAccess().getFunctionalAssignment_5_5(), "rule__StructuredProperty__FunctionalAssignment_5_5");
			builder.put(grammarAccess.getFacetedScalarAccess().getOwnedAnnotationsAssignment_0(), "rule__FacetedScalar__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getFacetedScalarAccess().getNameAssignment_2(), "rule__FacetedScalar__NameAssignment_2");
			builder.put(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsAssignment_3_1(), "rule__FacetedScalar__OwnedSpecializationsAssignment_3_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsAssignment_3_2_1(), "rule__FacetedScalar__OwnedSpecializationsAssignment_3_2_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getLengthAssignment_4_1_0_1(), "rule__FacetedScalar__LengthAssignment_4_1_0_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getMinLengthAssignment_4_1_1_1(), "rule__FacetedScalar__MinLengthAssignment_4_1_1_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getMaxLengthAssignment_4_1_2_1(), "rule__FacetedScalar__MaxLengthAssignment_4_1_2_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getPatternAssignment_4_1_3_1(), "rule__FacetedScalar__PatternAssignment_4_1_3_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getLanguageAssignment_4_1_4_1(), "rule__FacetedScalar__LanguageAssignment_4_1_4_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getMinInclusiveAssignment_4_1_5_1(), "rule__FacetedScalar__MinInclusiveAssignment_4_1_5_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getMinExclusiveAssignment_4_1_6_1(), "rule__FacetedScalar__MinExclusiveAssignment_4_1_6_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getMaxInclusiveAssignment_4_1_7_1(), "rule__FacetedScalar__MaxInclusiveAssignment_4_1_7_1");
			builder.put(grammarAccess.getFacetedScalarAccess().getMaxExclusiveAssignment_4_1_8_1(), "rule__FacetedScalar__MaxExclusiveAssignment_4_1_8_1");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getOwnedAnnotationsAssignment_0(), "rule__EnumeratedScalar__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getNameAssignment_3(), "rule__EnumeratedScalar__NameAssignment_3");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsAssignment_4_1(), "rule__EnumeratedScalar__OwnedSpecializationsAssignment_4_1");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsAssignment_4_2_1(), "rule__EnumeratedScalar__OwnedSpecializationsAssignment_4_2_1");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getLiteralsAssignment_5_1(), "rule__EnumeratedScalar__LiteralsAssignment_5_1");
			builder.put(grammarAccess.getEnumeratedScalarAccess().getLiteralsAssignment_5_2_1(), "rule__EnumeratedScalar__LiteralsAssignment_5_2_1");
			builder.put(grammarAccess.getForwardRelationAccess().getOwnedAnnotationsAssignment_0(), "rule__ForwardRelation__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getForwardRelationAccess().getNameAssignment_2(), "rule__ForwardRelation__NameAssignment_2");
			builder.put(grammarAccess.getInverseRelationAccess().getOwnedAnnotationsAssignment_0(), "rule__InverseRelation__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getInverseRelationAccess().getNameAssignment_2(), "rule__InverseRelation__NameAssignment_2");
			builder.put(grammarAccess.getRuleAccess().getOwnedAnnotationsAssignment_0(), "rule__Rule__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRuleAccess().getNameAssignment_2(), "rule__Rule__NameAssignment_2");
			builder.put(grammarAccess.getRuleAccess().getAntecedentAssignment_4(), "rule__Rule__AntecedentAssignment_4");
			builder.put(grammarAccess.getRuleAccess().getAntecedentAssignment_5_1(), "rule__Rule__AntecedentAssignment_5_1");
			builder.put(grammarAccess.getRuleAccess().getConsequentAssignment_7(), "rule__Rule__ConsequentAssignment_7");
			builder.put(grammarAccess.getRuleAccess().getConsequentAssignment_8_1(), "rule__Rule__ConsequentAssignment_8_1");
			builder.put(grammarAccess.getStructureInstanceAccess().getOwnedAnnotationsAssignment_0(), "rule__StructureInstance__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getStructureInstanceAccess().getTypeAssignment_1(), "rule__StructureInstance__TypeAssignment_1");
			builder.put(grammarAccess.getStructureInstanceAccess().getOwnedPropertyValuesAssignment_3(), "rule__StructureInstance__OwnedPropertyValuesAssignment_3");
			builder.put(grammarAccess.getConceptInstanceAccess().getOwnedAnnotationsAssignment_0(), "rule__ConceptInstance__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getConceptInstanceAccess().getNameAssignment_2(), "rule__ConceptInstance__NameAssignment_2");
			builder.put(grammarAccess.getConceptInstanceAccess().getOwnedTypesAssignment_3_1(), "rule__ConceptInstance__OwnedTypesAssignment_3_1");
			builder.put(grammarAccess.getConceptInstanceAccess().getOwnedTypesAssignment_3_2_1(), "rule__ConceptInstance__OwnedTypesAssignment_3_2_1");
			builder.put(grammarAccess.getConceptInstanceAccess().getOwnedPropertyValuesAssignment_4_1(), "rule__ConceptInstance__OwnedPropertyValuesAssignment_4_1");
			builder.put(grammarAccess.getConceptInstanceAccess().getOwnedLinksAssignment_4_2(), "rule__ConceptInstance__OwnedLinksAssignment_4_2");
			builder.put(grammarAccess.getRelationInstanceAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationInstance__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationInstanceAccess().getNameAssignment_2(), "rule__RelationInstance__NameAssignment_2");
			builder.put(grammarAccess.getRelationInstanceAccess().getOwnedTypesAssignment_3_1(), "rule__RelationInstance__OwnedTypesAssignment_3_1");
			builder.put(grammarAccess.getRelationInstanceAccess().getOwnedTypesAssignment_3_2_1(), "rule__RelationInstance__OwnedTypesAssignment_3_2_1");
			builder.put(grammarAccess.getRelationInstanceAccess().getSourceAssignment_4_2(), "rule__RelationInstance__SourceAssignment_4_2");
			builder.put(grammarAccess.getRelationInstanceAccess().getTargetAssignment_4_4(), "rule__RelationInstance__TargetAssignment_4_4");
			builder.put(grammarAccess.getRelationInstanceAccess().getOwnedPropertyValuesAssignment_4_5(), "rule__RelationInstance__OwnedPropertyValuesAssignment_4_5");
			builder.put(grammarAccess.getRelationInstanceAccess().getOwnedLinksAssignment_4_6(), "rule__RelationInstance__OwnedLinksAssignment_4_6");
			builder.put(grammarAccess.getAspectReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__AspectReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getAspectReferenceAccess().getAspectAssignment_3(), "rule__AspectReference__AspectAssignment_3");
			builder.put(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsAssignment_4_1(), "rule__AspectReference__OwnedSpecializationsAssignment_4_1");
			builder.put(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsAssignment_4_2_1(), "rule__AspectReference__OwnedSpecializationsAssignment_4_2_1");
			builder.put(grammarAccess.getAspectReferenceAccess().getOwnedKeysAssignment_5_1(), "rule__AspectReference__OwnedKeysAssignment_5_1");
			builder.put(grammarAccess.getAspectReferenceAccess().getOwnedPropertyRestrictionsAssignment_5_2(), "rule__AspectReference__OwnedPropertyRestrictionsAssignment_5_2");
			builder.put(grammarAccess.getAspectReferenceAccess().getOwnedRelationRestrictionsAssignment_5_3(), "rule__AspectReference__OwnedRelationRestrictionsAssignment_5_3");
			builder.put(grammarAccess.getConceptReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__ConceptReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getConceptReferenceAccess().getConceptAssignment_3(), "rule__ConceptReference__ConceptAssignment_3");
			builder.put(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsAssignment_4_1(), "rule__ConceptReference__OwnedSpecializationsAssignment_4_1");
			builder.put(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsAssignment_4_2_1(), "rule__ConceptReference__OwnedSpecializationsAssignment_4_2_1");
			builder.put(grammarAccess.getConceptReferenceAccess().getOwnedKeysAssignment_5_1(), "rule__ConceptReference__OwnedKeysAssignment_5_1");
			builder.put(grammarAccess.getConceptReferenceAccess().getOwnedPropertyRestrictionsAssignment_5_2(), "rule__ConceptReference__OwnedPropertyRestrictionsAssignment_5_2");
			builder.put(grammarAccess.getConceptReferenceAccess().getOwnedRelationRestrictionsAssignment_5_3(), "rule__ConceptReference__OwnedRelationRestrictionsAssignment_5_3");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationEntityReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getEntityAssignment_4(), "rule__RelationEntityReference__EntityAssignment_4");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsAssignment_5_1(), "rule__RelationEntityReference__OwnedSpecializationsAssignment_5_1");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsAssignment_5_2_1(), "rule__RelationEntityReference__OwnedSpecializationsAssignment_5_2_1");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getOwnedKeysAssignment_6_1(), "rule__RelationEntityReference__OwnedKeysAssignment_6_1");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getOwnedPropertyRestrictionsAssignment_6_2(), "rule__RelationEntityReference__OwnedPropertyRestrictionsAssignment_6_2");
			builder.put(grammarAccess.getRelationEntityReferenceAccess().getOwnedRelationRestrictionsAssignment_6_3(), "rule__RelationEntityReference__OwnedRelationRestrictionsAssignment_6_3");
			builder.put(grammarAccess.getStructureReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__StructureReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getStructureReferenceAccess().getStructureAssignment_3(), "rule__StructureReference__StructureAssignment_3");
			builder.put(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsAssignment_4_1(), "rule__StructureReference__OwnedSpecializationsAssignment_4_1");
			builder.put(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsAssignment_4_2_1(), "rule__StructureReference__OwnedSpecializationsAssignment_4_2_1");
			builder.put(grammarAccess.getStructureReferenceAccess().getOwnedPropertyRestrictionsAssignment_5_1(), "rule__StructureReference__OwnedPropertyRestrictionsAssignment_5_1");
			builder.put(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__AnnotationPropertyReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getAnnotationPropertyReferenceAccess().getPropertyAssignment_4(), "rule__AnnotationPropertyReference__PropertyAssignment_4");
			builder.put(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_1(), "rule__AnnotationPropertyReference__OwnedSpecializationsAssignment_5_1");
			builder.put(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_2_1(), "rule__AnnotationPropertyReference__OwnedSpecializationsAssignment_5_2_1");
			builder.put(grammarAccess.getScalarPropertyReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__ScalarPropertyReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarPropertyReferenceAccess().getPropertyAssignment_4(), "rule__ScalarPropertyReference__PropertyAssignment_4");
			builder.put(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_1(), "rule__ScalarPropertyReference__OwnedSpecializationsAssignment_5_1");
			builder.put(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_2_1(), "rule__ScalarPropertyReference__OwnedSpecializationsAssignment_5_2_1");
			builder.put(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__StructuredPropertyReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getStructuredPropertyReferenceAccess().getPropertyAssignment_4(), "rule__StructuredPropertyReference__PropertyAssignment_4");
			builder.put(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_1(), "rule__StructuredPropertyReference__OwnedSpecializationsAssignment_5_1");
			builder.put(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_2_1(), "rule__StructuredPropertyReference__OwnedSpecializationsAssignment_5_2_1");
			builder.put(grammarAccess.getFacetedScalarReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__FacetedScalarReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getFacetedScalarReferenceAccess().getScalarAssignment_3(), "rule__FacetedScalarReference__ScalarAssignment_3");
			builder.put(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsAssignment_4_1(), "rule__FacetedScalarReference__OwnedSpecializationsAssignment_4_1");
			builder.put(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsAssignment_4_2_1(), "rule__FacetedScalarReference__OwnedSpecializationsAssignment_4_2_1");
			builder.put(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__EnumeratedScalarReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getEnumeratedScalarReferenceAccess().getScalarAssignment_4(), "rule__EnumeratedScalarReference__ScalarAssignment_4");
			builder.put(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsAssignment_5_1(), "rule__EnumeratedScalarReference__OwnedSpecializationsAssignment_5_1");
			builder.put(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsAssignment_5_2_1(), "rule__EnumeratedScalarReference__OwnedSpecializationsAssignment_5_2_1");
			builder.put(grammarAccess.getRelationReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationReferenceAccess().getRelationAssignment_3(), "rule__RelationReference__RelationAssignment_3");
			builder.put(grammarAccess.getRuleReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__RuleReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRuleReferenceAccess().getRuleAssignment_3(), "rule__RuleReference__RuleAssignment_3");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__ConceptInstanceReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getInstanceAssignment_3(), "rule__ConceptInstanceReference__InstanceAssignment_3");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesAssignment_4_1(), "rule__ConceptInstanceReference__OwnedTypesAssignment_4_1");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesAssignment_4_2_1(), "rule__ConceptInstanceReference__OwnedTypesAssignment_4_2_1");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getOwnedPropertyValuesAssignment_5_1(), "rule__ConceptInstanceReference__OwnedPropertyValuesAssignment_5_1");
			builder.put(grammarAccess.getConceptInstanceReferenceAccess().getOwnedLinksAssignment_5_2(), "rule__ConceptInstanceReference__OwnedLinksAssignment_5_2");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationInstanceReference__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getInstanceAssignment_3(), "rule__RelationInstanceReference__InstanceAssignment_3");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesAssignment_4_1(), "rule__RelationInstanceReference__OwnedTypesAssignment_4_1");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesAssignment_4_2_1(), "rule__RelationInstanceReference__OwnedTypesAssignment_4_2_1");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getOwnedPropertyValuesAssignment_5_1(), "rule__RelationInstanceReference__OwnedPropertyValuesAssignment_5_1");
			builder.put(grammarAccess.getRelationInstanceReferenceAccess().getOwnedLinksAssignment_5_2(), "rule__RelationInstanceReference__OwnedLinksAssignment_5_2");
			builder.put(grammarAccess.getVocabularyExtensionAccess().getOwnedAnnotationsAssignment_0(), "rule__VocabularyExtension__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getVocabularyExtensionAccess().getUriAssignment_2(), "rule__VocabularyExtension__UriAssignment_2");
			builder.put(grammarAccess.getVocabularyExtensionAccess().getPrefixAssignment_3_1(), "rule__VocabularyExtension__PrefixAssignment_3_1");
			builder.put(grammarAccess.getVocabularyUsageAccess().getOwnedAnnotationsAssignment_0(), "rule__VocabularyUsage__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getVocabularyUsageAccess().getUriAssignment_2(), "rule__VocabularyUsage__UriAssignment_2");
			builder.put(grammarAccess.getVocabularyUsageAccess().getPrefixAssignment_3_1(), "rule__VocabularyUsage__PrefixAssignment_3_1");
			builder.put(grammarAccess.getBundleInclusionAccess().getOwnedAnnotationsAssignment_0(), "rule__BundleInclusion__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getBundleInclusionAccess().getUriAssignment_2(), "rule__BundleInclusion__UriAssignment_2");
			builder.put(grammarAccess.getBundleInclusionAccess().getPrefixAssignment_3_1(), "rule__BundleInclusion__PrefixAssignment_3_1");
			builder.put(grammarAccess.getBundleExtensionAccess().getOwnedAnnotationsAssignment_0(), "rule__BundleExtension__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getBundleExtensionAccess().getUriAssignment_2(), "rule__BundleExtension__UriAssignment_2");
			builder.put(grammarAccess.getBundleExtensionAccess().getPrefixAssignment_3_1(), "rule__BundleExtension__PrefixAssignment_3_1");
			builder.put(grammarAccess.getDescriptionUsageAccess().getOwnedAnnotationsAssignment_0(), "rule__DescriptionUsage__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getDescriptionUsageAccess().getUriAssignment_2(), "rule__DescriptionUsage__UriAssignment_2");
			builder.put(grammarAccess.getDescriptionUsageAccess().getPrefixAssignment_3_1(), "rule__DescriptionUsage__PrefixAssignment_3_1");
			builder.put(grammarAccess.getDescriptionExtensionAccess().getOwnedAnnotationsAssignment_0(), "rule__DescriptionExtension__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getDescriptionExtensionAccess().getUriAssignment_2(), "rule__DescriptionExtension__UriAssignment_2");
			builder.put(grammarAccess.getDescriptionExtensionAccess().getPrefixAssignment_3_1(), "rule__DescriptionExtension__PrefixAssignment_3_1");
			builder.put(grammarAccess.getSpecializationAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__SpecializationAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getSpecializationAxiomAccess().getSpecializedTermAssignment_1(), "rule__SpecializationAxiom__SpecializedTermAssignment_1");
			builder.put(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__ScalarPropertyRangeRestrictionAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getKindAssignment_2(), "rule__ScalarPropertyRangeRestrictionAxiom__KindAssignment_2");
			builder.put(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyAssignment_5(), "rule__ScalarPropertyRangeRestrictionAxiom__PropertyAssignment_5");
			builder.put(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRangeAssignment_7(), "rule__ScalarPropertyRangeRestrictionAxiom__RangeAssignment_7");
			builder.put(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__ScalarPropertyCardinalityRestrictionAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyAssignment_4(), "rule__ScalarPropertyCardinalityRestrictionAxiom__PropertyAssignment_4");
			builder.put(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getKindAssignment_6(), "rule__ScalarPropertyCardinalityRestrictionAxiom__KindAssignment_6");
			builder.put(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getCardinalityAssignment_7(), "rule__ScalarPropertyCardinalityRestrictionAxiom__CardinalityAssignment_7");
			builder.put(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRangeAssignment_8(), "rule__ScalarPropertyCardinalityRestrictionAxiom__RangeAssignment_8");
			builder.put(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__ScalarPropertyValueRestrictionAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyAssignment_4(), "rule__ScalarPropertyValueRestrictionAxiom__PropertyAssignment_4");
			builder.put(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getValueAssignment_6(), "rule__ScalarPropertyValueRestrictionAxiom__ValueAssignment_6");
			builder.put(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__StructuredPropertyRangeRestrictionAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getKindAssignment_2(), "rule__StructuredPropertyRangeRestrictionAxiom__KindAssignment_2");
			builder.put(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyAssignment_5(), "rule__StructuredPropertyRangeRestrictionAxiom__PropertyAssignment_5");
			builder.put(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRangeAssignment_7(), "rule__StructuredPropertyRangeRestrictionAxiom__RangeAssignment_7");
			builder.put(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__StructuredPropertyCardinalityRestrictionAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyAssignment_4(), "rule__StructuredPropertyCardinalityRestrictionAxiom__PropertyAssignment_4");
			builder.put(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getKindAssignment_6(), "rule__StructuredPropertyCardinalityRestrictionAxiom__KindAssignment_6");
			builder.put(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getCardinalityAssignment_7(), "rule__StructuredPropertyCardinalityRestrictionAxiom__CardinalityAssignment_7");
			builder.put(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRangeAssignment_8(), "rule__StructuredPropertyCardinalityRestrictionAxiom__RangeAssignment_8");
			builder.put(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__StructuredPropertyValueRestrictionAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyAssignment_4(), "rule__StructuredPropertyValueRestrictionAxiom__PropertyAssignment_4");
			builder.put(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getValueAssignment_6(), "rule__StructuredPropertyValueRestrictionAxiom__ValueAssignment_6");
			builder.put(grammarAccess.getRelationRangeRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationRangeRestrictionAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationRangeRestrictionAxiomAccess().getKindAssignment_2(), "rule__RelationRangeRestrictionAxiom__KindAssignment_2");
			builder.put(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationAssignment_4(), "rule__RelationRangeRestrictionAxiom__RelationAssignment_4");
			builder.put(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRangeAssignment_6(), "rule__RelationRangeRestrictionAxiom__RangeAssignment_6");
			builder.put(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationCardinalityRestrictionAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationAssignment_3(), "rule__RelationCardinalityRestrictionAxiom__RelationAssignment_3");
			builder.put(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getKindAssignment_5(), "rule__RelationCardinalityRestrictionAxiom__KindAssignment_5");
			builder.put(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getCardinalityAssignment_6(), "rule__RelationCardinalityRestrictionAxiom__CardinalityAssignment_6");
			builder.put(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRangeAssignment_7(), "rule__RelationCardinalityRestrictionAxiom__RangeAssignment_7");
			builder.put(grammarAccess.getRelationTargetRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationTargetRestrictionAxiom__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationAssignment_3(), "rule__RelationTargetRestrictionAxiom__RelationAssignment_3");
			builder.put(grammarAccess.getRelationTargetRestrictionAxiomAccess().getTargetAssignment_5(), "rule__RelationTargetRestrictionAxiom__TargetAssignment_5");
			builder.put(grammarAccess.getKeyAxiomAccess().getPropertiesAssignment_1(), "rule__KeyAxiom__PropertiesAssignment_1");
			builder.put(grammarAccess.getKeyAxiomAccess().getPropertiesAssignment_2_1(), "rule__KeyAxiom__PropertiesAssignment_2_1");
			builder.put(grammarAccess.getConceptTypeAssertionAccess().getOwnedAnnotationsAssignment_0(), "rule__ConceptTypeAssertion__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getConceptTypeAssertionAccess().getTypeAssignment_1(), "rule__ConceptTypeAssertion__TypeAssignment_1");
			builder.put(grammarAccess.getRelationTypeAssertionAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationTypeAssertion__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationTypeAssertionAccess().getTypeAssignment_1(), "rule__RelationTypeAssertion__TypeAssignment_1");
			builder.put(grammarAccess.getScalarPropertyValueAssertionAccess().getOwnedAnnotationsAssignment_0(), "rule__ScalarPropertyValueAssertion__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarPropertyValueAssertionAccess().getPropertyAssignment_1(), "rule__ScalarPropertyValueAssertion__PropertyAssignment_1");
			builder.put(grammarAccess.getScalarPropertyValueAssertionAccess().getValueAssignment_2(), "rule__ScalarPropertyValueAssertion__ValueAssignment_2");
			builder.put(grammarAccess.getStructuredPropertyValueAssertionAccess().getOwnedAnnotationsAssignment_0(), "rule__StructuredPropertyValueAssertion__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getStructuredPropertyValueAssertionAccess().getPropertyAssignment_1(), "rule__StructuredPropertyValueAssertion__PropertyAssignment_1");
			builder.put(grammarAccess.getStructuredPropertyValueAssertionAccess().getValueAssignment_2(), "rule__StructuredPropertyValueAssertion__ValueAssignment_2");
			builder.put(grammarAccess.getLinkAssertionAccess().getOwnedAnnotationsAssignment_0(), "rule__LinkAssertion__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getLinkAssertionAccess().getRelationAssignment_1(), "rule__LinkAssertion__RelationAssignment_1");
			builder.put(grammarAccess.getLinkAssertionAccess().getTargetAssignment_2(), "rule__LinkAssertion__TargetAssignment_2");
			builder.put(grammarAccess.getEntityPredicateAccess().getOwnedAnnotationsAssignment_0(), "rule__EntityPredicate__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getEntityPredicateAccess().getEntityAssignment_1(), "rule__EntityPredicate__EntityAssignment_1");
			builder.put(grammarAccess.getEntityPredicateAccess().getVariableAssignment_3(), "rule__EntityPredicate__VariableAssignment_3");
			builder.put(grammarAccess.getRelationPredicateAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationPredicate__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationPredicateAccess().getRelationAssignment_1(), "rule__RelationPredicate__RelationAssignment_1");
			builder.put(grammarAccess.getRelationPredicateAccess().getVariable1Assignment_3(), "rule__RelationPredicate__Variable1Assignment_3");
			builder.put(grammarAccess.getRelationPredicateAccess().getVariable2Assignment_5(), "rule__RelationPredicate__Variable2Assignment_5");
			builder.put(grammarAccess.getSameAsPredicateAccess().getOwnedAnnotationsAssignment_0(), "rule__SameAsPredicate__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getSameAsPredicateAccess().getVariable1Assignment_3(), "rule__SameAsPredicate__Variable1Assignment_3");
			builder.put(grammarAccess.getSameAsPredicateAccess().getVariable2Assignment_5(), "rule__SameAsPredicate__Variable2Assignment_5");
			builder.put(grammarAccess.getDifferentFromPredicateAccess().getOwnedAnnotationsAssignment_0(), "rule__DifferentFromPredicate__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getDifferentFromPredicateAccess().getVariable1Assignment_3(), "rule__DifferentFromPredicate__Variable1Assignment_3");
			builder.put(grammarAccess.getDifferentFromPredicateAccess().getVariable2Assignment_5(), "rule__DifferentFromPredicate__Variable2Assignment_5");
			builder.put(grammarAccess.getRelationEntityPredicateAccess().getOwnedAnnotationsAssignment_0(), "rule__RelationEntityPredicate__OwnedAnnotationsAssignment_0");
			builder.put(grammarAccess.getRelationEntityPredicateAccess().getEntityAssignment_1(), "rule__RelationEntityPredicate__EntityAssignment_1");
			builder.put(grammarAccess.getRelationEntityPredicateAccess().getVariable1Assignment_3(), "rule__RelationEntityPredicate__Variable1Assignment_3");
			builder.put(grammarAccess.getRelationEntityPredicateAccess().getEntityVariableAssignment_5(), "rule__RelationEntityPredicate__EntityVariableAssignment_5");
			builder.put(grammarAccess.getRelationEntityPredicateAccess().getVariable2Assignment_7(), "rule__RelationEntityPredicate__Variable2Assignment_7");
			builder.put(grammarAccess.getIntegerLiteralAccess().getValueAssignment_0(), "rule__IntegerLiteral__ValueAssignment_0");
			builder.put(grammarAccess.getIntegerLiteralAccess().getTypeAssignment_1_1(), "rule__IntegerLiteral__TypeAssignment_1_1");
			builder.put(grammarAccess.getDecimalLiteralAccess().getValueAssignment_0(), "rule__DecimalLiteral__ValueAssignment_0");
			builder.put(grammarAccess.getDecimalLiteralAccess().getTypeAssignment_1_1(), "rule__DecimalLiteral__TypeAssignment_1_1");
			builder.put(grammarAccess.getDoubleLiteralAccess().getValueAssignment_0(), "rule__DoubleLiteral__ValueAssignment_0");
			builder.put(grammarAccess.getDoubleLiteralAccess().getTypeAssignment_1_1(), "rule__DoubleLiteral__TypeAssignment_1_1");
			builder.put(grammarAccess.getBooleanLiteralAccess().getValueAssignment_0(), "rule__BooleanLiteral__ValueAssignment_0");
			builder.put(grammarAccess.getBooleanLiteralAccess().getTypeAssignment_1_1(), "rule__BooleanLiteral__TypeAssignment_1_1");
			builder.put(grammarAccess.getQuotedLiteralAccess().getValueAssignment_0(), "rule__QuotedLiteral__ValueAssignment_0");
			builder.put(grammarAccess.getQuotedLiteralAccess().getTypeAssignment_1_0_1(), "rule__QuotedLiteral__TypeAssignment_1_0_1");
			builder.put(grammarAccess.getQuotedLiteralAccess().getLangTagAssignment_1_1_1(), "rule__QuotedLiteral__LangTagAssignment_1_1_1");
			builder.put(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), "rule__RelationEntity__UnorderedGroup_5_7");
			builder.put(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), "rule__FacetedScalar__UnorderedGroup_4_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private OmlGrammarAccess grammarAccess;

	@Override
	protected InternalOmlParser createParser() {
		InternalOmlParser result = new InternalOmlParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public OmlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(OmlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
