/**
 * 
 * Copyright 2019-2022 California Institute of Technology ("Caltech").
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
package io.opencaesar.oml.impl;

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.BinaryPredicate;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.CardinalityRestrictionKind;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierReference;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBox;
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
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityReference;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.Feature;
import io.opencaesar.oml.FeaturePredicate;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.NamedInstanceReference;
import io.opencaesar.oml.OmlFactory;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RangeRestrictionKind;
import io.opencaesar.oml.Reference;
import io.opencaesar.oml.Relation;
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
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.RestrictionAxiom;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SeparatorKind;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializableTermReference;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Statement;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyReference;
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.UnaryPredicate;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBox;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.VocabularyBundleExtension;
import io.opencaesar.oml.VocabularyBundleImport;
import io.opencaesar.oml.VocabularyBundleInclusion;
import io.opencaesar.oml.VocabularyExtension;
import io.opencaesar.oml.VocabularyImport;
import io.opencaesar.oml.VocabularyStatement;
import io.opencaesar.oml.VocabularyUsage;

import io.opencaesar.oml.util.OmlValidator;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OmlPackageImpl extends EPackageImpl implements OmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotatedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ontologyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyBundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializableTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aspectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass semanticPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetedScalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumeratedScalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forwardRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reverseRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializableTermReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aspectReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEntityReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationPropertyReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarPropertyReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredPropertyReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetedScalarReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumeratedScalarReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedInstanceReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptInstanceReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationInstanceReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyBundleImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyBundleExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyBundleInclusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBundleImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBundleExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBundleInclusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBundleUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarPropertyRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarPropertyRangeRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarPropertyCardinalityRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarPropertyValueRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredPropertyRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredPropertyRangeRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredPropertyCardinalityRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredPropertyValueRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationRangeRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationCardinalityRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationTargetRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptTypeAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationTypeAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyValueAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarPropertyValueAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredPropertyValueAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEntityPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featurePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sameAsPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass differentFromPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quotedLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decimalLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum separatorKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rangeRestrictionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cardinalityRestrictionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unsignedIntEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unsignedIntegerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType decimalEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType idEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType namespaceEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see io.opencaesar.oml.OmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OmlPackageImpl() {
		super(eNS_URI, OmlFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link OmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OmlPackage init() {
		if (isInited) return (OmlPackage)EPackage.Registry.INSTANCE.getEPackage(OmlPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredOmlPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		OmlPackageImpl theOmlPackage = registeredOmlPackage instanceof OmlPackageImpl ? (OmlPackageImpl)registeredOmlPackage : new OmlPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOmlPackage.createPackageContents();

		// Initialize created meta-data
		theOmlPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theOmlPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return OmlValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theOmlPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OmlPackage.eNS_URI, theOmlPackage);
		return theOmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getElement__ExtraValidate__DiagnosticChain_Map() {
		return elementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getElement__GetOntology() {
		return elementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotation_Property() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotation_Value() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotation_ReferenceValue() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotation_OwningElement() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotation_OwningReference() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnnotatedElement() {
		return annotatedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotatedElement_OwnedAnnotations() {
		return (EReference)annotatedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIdentifiedElement() {
		return identifiedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIdentifiedElement__GetIri() {
		return identifiedElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOntology() {
		return ontologyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOntology_Namespace() {
		return (EAttribute)ontologyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOntology_Prefix() {
		return (EAttribute)ontologyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOntology__GetIri() {
		return ontologyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOntology__GetSeparator() {
		return ontologyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyBox() {
		return vocabularyBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabulary() {
		return vocabularyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVocabulary_OwnedImports() {
		return (EReference)vocabularyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVocabulary_OwnedStatements() {
		return (EReference)vocabularyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyBundle() {
		return vocabularyBundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVocabularyBundle_OwnedImports() {
		return (EReference)vocabularyBundleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionBox() {
		return descriptionBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescription() {
		return descriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescription_OwnedImports() {
		return (EReference)descriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescription_OwnedStatements() {
		return (EReference)descriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionBundle() {
		return descriptionBundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptionBundle_OwnedImports() {
		return (EReference)descriptionBundleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMember() {
		return memberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMember_Name() {
		return (EAttribute)memberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMember__GetIri() {
		return memberEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMember__GetAbbreviatedIri() {
		return memberEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpecializableTerm() {
		return specializableTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecializableTerm_OwnedSpecializations() {
		return (EReference)specializableTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassifier() {
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassifier_OwnedPropertyRestrictions() {
		return (EReference)classifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntity_OwnedRelationRestrictions() {
		return (EReference)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntity_OwnedKeys() {
		return (EReference)entityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAspect() {
		return aspectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConcept() {
		return conceptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConcept_EnumeratedInstances() {
		return (EReference)conceptEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationEntity() {
		return relationEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationEntity_Source() {
		return (EReference)relationEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationEntity_Target() {
		return (EReference)relationEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationEntity_ForwardRelation() {
		return (EReference)relationEntityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationEntity_ReverseRelation() {
		return (EReference)relationEntityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationEntity_Functional() {
		return (EAttribute)relationEntityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationEntity_InverseFunctional() {
		return (EAttribute)relationEntityEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationEntity_Symmetric() {
		return (EAttribute)relationEntityEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationEntity_Asymmetric() {
		return (EAttribute)relationEntityEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationEntity_Reflexive() {
		return (EAttribute)relationEntityEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationEntity_Irreflexive() {
		return (EAttribute)relationEntityEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationEntity_Transitive() {
		return (EAttribute)relationEntityEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructure() {
		return structureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnnotationProperty() {
		return annotationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSemanticProperty() {
		return semanticPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSemanticProperty__IsFunctional() {
		return semanticPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSemanticProperty__GetDomain() {
		return semanticPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSemanticProperty__GetRange() {
		return semanticPropertyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalarProperty() {
		return scalarPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarProperty_Functional() {
		return (EAttribute)scalarPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarProperty_Domain() {
		return (EReference)scalarPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarProperty_Range() {
		return (EReference)scalarPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuredProperty() {
		return structuredPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStructuredProperty_Functional() {
		return (EAttribute)structuredPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredProperty_Domain() {
		return (EReference)structuredPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredProperty_Range() {
		return (EReference)structuredPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalar() {
		return scalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFacetedScalar() {
		return facetedScalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFacetedScalar_Length() {
		return (EAttribute)facetedScalarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFacetedScalar_MinLength() {
		return (EAttribute)facetedScalarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFacetedScalar_MaxLength() {
		return (EAttribute)facetedScalarEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFacetedScalar_Pattern() {
		return (EAttribute)facetedScalarEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFacetedScalar_Language() {
		return (EAttribute)facetedScalarEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFacetedScalar_MinInclusive() {
		return (EReference)facetedScalarEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFacetedScalar_MinExclusive() {
		return (EReference)facetedScalarEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFacetedScalar_MaxInclusive() {
		return (EReference)facetedScalarEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFacetedScalar_MaxExclusive() {
		return (EReference)facetedScalarEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumeratedScalar() {
		return enumeratedScalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumeratedScalar_Literals() {
		return (EReference)enumeratedScalarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Domain() {
		return (EReference)relationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Range() {
		return (EReference)relationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Inverse() {
		return (EReference)relationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__GetRelationEntity() {
		return relationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__DeriveDomain() {
		return relationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__DeriveRange() {
		return relationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__DeriveInverse() {
		return relationEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForwardRelation() {
		return forwardRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForwardRelation_RelationEntity() {
		return (EReference)forwardRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__DeriveDomain() {
		return forwardRelationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__DeriveRange() {
		return forwardRelationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getForwardRelation__DeriveInverse() {
		return forwardRelationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReverseRelation() {
		return reverseRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReverseRelation_RelationEntity() {
		return (EReference)reverseRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__DeriveDomain() {
		return reverseRelationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__DeriveRange() {
		return reverseRelationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReverseRelation__DeriveInverse() {
		return reverseRelationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Antecedent() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Consequent() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInstance() {
		return instanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstance_OwnedPropertyValues() {
		return (EReference)instanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructureInstance() {
		return structureInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_Type() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_OwningAxiom() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_OwningAssertion() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedInstance() {
		return namedInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNamedInstance_OwnedLinks() {
		return (EReference)namedInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConceptInstance() {
		return conceptInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConceptInstance_OwnedTypes() {
		return (EReference)conceptInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationInstance() {
		return relationInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationInstance_OwnedTypes() {
		return (EReference)relationInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationInstance_Sources() {
		return (EReference)relationInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationInstance_Targets() {
		return (EReference)relationInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReference() {
		return referenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReference_OwnedAnnotations() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpecializableTermReference() {
		return specializableTermReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecializableTermReference_OwnedSpecializations() {
		return (EReference)specializableTermReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassifierReference() {
		return classifierReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassifierReference_OwnedPropertyRestrictions() {
		return (EReference)classifierReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntityReference() {
		return entityReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntityReference_OwnedRelationRestrictions() {
		return (EReference)entityReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntityReference_OwnedKeys() {
		return (EReference)entityReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAspectReference() {
		return aspectReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAspectReference_Aspect() {
		return (EReference)aspectReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConceptReference() {
		return conceptReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConceptReference_Concept() {
		return (EReference)conceptReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationEntityReference() {
		return relationEntityReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationEntityReference_Entity() {
		return (EReference)relationEntityReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructureReference() {
		return structureReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureReference_Structure() {
		return (EReference)structureReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnnotationPropertyReference() {
		return annotationPropertyReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnnotationPropertyReference_Property() {
		return (EReference)annotationPropertyReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalarPropertyReference() {
		return scalarPropertyReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarPropertyReference_Property() {
		return (EReference)scalarPropertyReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuredPropertyReference() {
		return structuredPropertyReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredPropertyReference_Property() {
		return (EReference)structuredPropertyReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFacetedScalarReference() {
		return facetedScalarReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFacetedScalarReference_Scalar() {
		return (EReference)facetedScalarReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumeratedScalarReference() {
		return enumeratedScalarReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumeratedScalarReference_Scalar() {
		return (EReference)enumeratedScalarReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationReference() {
		return relationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationReference_Relation() {
		return (EReference)relationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRuleReference() {
		return ruleReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRuleReference_Rule() {
		return (EReference)ruleReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedInstanceReference() {
		return namedInstanceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNamedInstanceReference_OwnedPropertyValues() {
		return (EReference)namedInstanceReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNamedInstanceReference_OwnedLinks() {
		return (EReference)namedInstanceReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConceptInstanceReference() {
		return conceptInstanceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConceptInstanceReference_Instance() {
		return (EReference)conceptInstanceReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConceptInstanceReference_OwnedTypes() {
		return (EReference)conceptInstanceReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationInstanceReference() {
		return relationInstanceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationInstanceReference_Instance() {
		return (EReference)relationInstanceReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationInstanceReference_OwnedTypes() {
		return (EReference)relationInstanceReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyStatement() {
		return vocabularyStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVocabularyStatement_OwningVocabulary() {
		return (EReference)vocabularyStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionStatement() {
		return descriptionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptionStatement_OwningDescription() {
		return (EReference)descriptionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImport() {
		return importEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_Namespace() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_Prefix() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getImport__GetIri() {
		return importEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getImport__GetSeparator() {
		return importEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyImport() {
		return vocabularyImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVocabularyImport_OwningVocabulary() {
		return (EReference)vocabularyImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyExtension() {
		return vocabularyExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyUsage() {
		return vocabularyUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyBundleImport() {
		return vocabularyBundleImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVocabularyBundleImport_OwningVocabularyBundle() {
		return (EReference)vocabularyBundleImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyBundleExtension() {
		return vocabularyBundleExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocabularyBundleInclusion() {
		return vocabularyBundleInclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionImport() {
		return descriptionImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptionImport_OwningDescription() {
		return (EReference)descriptionImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionExtension() {
		return descriptionExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionUsage() {
		return descriptionUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionBundleImport() {
		return descriptionBundleImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptionBundleImport_OwningDescriptionBundle() {
		return (EReference)descriptionBundleImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionBundleExtension() {
		return descriptionBundleExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionBundleInclusion() {
		return descriptionBundleInclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionBundleUsage() {
		return descriptionBundleUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAxiom() {
		return axiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpecializationAxiom() {
		return specializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecializationAxiom_SpecializedTerm() {
		return (EReference)specializationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecializationAxiom_OwningTerm() {
		return (EReference)specializationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecializationAxiom_OwningReference() {
		return (EReference)specializationAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRestrictionAxiom() {
		return restrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyRestrictionAxiom() {
		return propertyRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyRestrictionAxiom_OwningClassifier() {
		return (EReference)propertyRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyRestrictionAxiom_OwningReference() {
		return (EReference)propertyRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalarPropertyRestrictionAxiom() {
		return scalarPropertyRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarPropertyRestrictionAxiom_Property() {
		return (EReference)scalarPropertyRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalarPropertyRangeRestrictionAxiom() {
		return scalarPropertyRangeRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarPropertyRangeRestrictionAxiom_Range() {
		return (EReference)scalarPropertyRangeRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarPropertyRangeRestrictionAxiom_Kind() {
		return (EAttribute)scalarPropertyRangeRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalarPropertyCardinalityRestrictionAxiom() {
		return scalarPropertyCardinalityRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarPropertyCardinalityRestrictionAxiom_Cardinality() {
		return (EAttribute)scalarPropertyCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScalarPropertyCardinalityRestrictionAxiom_Kind() {
		return (EAttribute)scalarPropertyCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarPropertyCardinalityRestrictionAxiom_Range() {
		return (EReference)scalarPropertyCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalarPropertyValueRestrictionAxiom() {
		return scalarPropertyValueRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarPropertyValueRestrictionAxiom_Value() {
		return (EReference)scalarPropertyValueRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuredPropertyRestrictionAxiom() {
		return structuredPropertyRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredPropertyRestrictionAxiom_Property() {
		return (EReference)structuredPropertyRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuredPropertyRangeRestrictionAxiom() {
		return structuredPropertyRangeRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredPropertyRangeRestrictionAxiom_Range() {
		return (EReference)structuredPropertyRangeRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStructuredPropertyRangeRestrictionAxiom_Kind() {
		return (EAttribute)structuredPropertyRangeRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuredPropertyCardinalityRestrictionAxiom() {
		return structuredPropertyCardinalityRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStructuredPropertyCardinalityRestrictionAxiom_Cardinality() {
		return (EAttribute)structuredPropertyCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStructuredPropertyCardinalityRestrictionAxiom_Kind() {
		return (EAttribute)structuredPropertyCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredPropertyCardinalityRestrictionAxiom_Range() {
		return (EReference)structuredPropertyCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuredPropertyValueRestrictionAxiom() {
		return structuredPropertyValueRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredPropertyValueRestrictionAxiom_Value() {
		return (EReference)structuredPropertyValueRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationRestrictionAxiom() {
		return relationRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationRestrictionAxiom_Relation() {
		return (EReference)relationRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationRestrictionAxiom_OwningEntity() {
		return (EReference)relationRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationRestrictionAxiom_OwningReference() {
		return (EReference)relationRestrictionAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationRangeRestrictionAxiom() {
		return relationRangeRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationRangeRestrictionAxiom_Range() {
		return (EReference)relationRangeRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationRangeRestrictionAxiom_Kind() {
		return (EAttribute)relationRangeRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationCardinalityRestrictionAxiom() {
		return relationCardinalityRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationCardinalityRestrictionAxiom_Cardinality() {
		return (EAttribute)relationCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationCardinalityRestrictionAxiom_Kind() {
		return (EAttribute)relationCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationCardinalityRestrictionAxiom_Range() {
		return (EReference)relationCardinalityRestrictionAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationTargetRestrictionAxiom() {
		return relationTargetRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationTargetRestrictionAxiom_Target() {
		return (EReference)relationTargetRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKeyAxiom() {
		return keyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyAxiom_Properties() {
		return (EReference)keyAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyAxiom_OwningEntity() {
		return (EReference)keyAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyAxiom_OwningReference() {
		return (EReference)keyAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssertion() {
		return assertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeAssertion() {
		return typeAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTypeAssertion__GetType() {
		return typeAssertionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConceptTypeAssertion() {
		return conceptTypeAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConceptTypeAssertion_Type() {
		return (EReference)conceptTypeAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConceptTypeAssertion_OwningInstance() {
		return (EReference)conceptTypeAssertionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConceptTypeAssertion_OwningReference() {
		return (EReference)conceptTypeAssertionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationTypeAssertion() {
		return relationTypeAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationTypeAssertion_Type() {
		return (EReference)relationTypeAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationTypeAssertion_OwningInstance() {
		return (EReference)relationTypeAssertionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationTypeAssertion_OwningReference() {
		return (EReference)relationTypeAssertionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyValueAssertion() {
		return propertyValueAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueAssertion_OwningInstance() {
		return (EReference)propertyValueAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyValueAssertion_OwningReference() {
		return (EReference)propertyValueAssertionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyValueAssertion__GetProperty() {
		return propertyValueAssertionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyValueAssertion__GetValue() {
		return propertyValueAssertionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScalarPropertyValueAssertion() {
		return scalarPropertyValueAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarPropertyValueAssertion_Property() {
		return (EReference)scalarPropertyValueAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScalarPropertyValueAssertion_Value() {
		return (EReference)scalarPropertyValueAssertionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuredPropertyValueAssertion() {
		return structuredPropertyValueAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredPropertyValueAssertion_Property() {
		return (EReference)structuredPropertyValueAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredPropertyValueAssertion_Value() {
		return (EReference)structuredPropertyValueAssertionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLinkAssertion() {
		return linkAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLinkAssertion_Relation() {
		return (EReference)linkAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLinkAssertion_Target() {
		return (EReference)linkAssertionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLinkAssertion_OwningInstance() {
		return (EReference)linkAssertionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLinkAssertion_OwningReference() {
		return (EReference)linkAssertionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPredicate() {
		return predicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicate_AntecedentRule() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicate_ConsequentRule() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnaryPredicate() {
		return unaryPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnaryPredicate_Variable() {
		return (EAttribute)unaryPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypePredicate() {
		return typePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypePredicate_Type() {
		return (EReference)typePredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBinaryPredicate() {
		return binaryPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBinaryPredicate_Variable1() {
		return (EAttribute)binaryPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBinaryPredicate_Variable2() {
		return (EAttribute)binaryPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryPredicate_Instance2() {
		return (EReference)binaryPredicateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationEntityPredicate() {
		return relationEntityPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationEntityPredicate_Entity() {
		return (EReference)relationEntityPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationEntityPredicate_EntityVariable() {
		return (EAttribute)relationEntityPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeaturePredicate() {
		return featurePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeaturePredicate_Feature() {
		return (EReference)featurePredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeaturePredicate_Literal2() {
		return (EReference)featurePredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSameAsPredicate() {
		return sameAsPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDifferentFromPredicate() {
		return differentFromPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQuotedLiteral() {
		return quotedLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQuotedLiteral_Value() {
		return (EAttribute)quotedLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQuotedLiteral_LangTag() {
		return (EAttribute)quotedLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQuotedLiteral_Type() {
		return (EReference)quotedLiteralEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntegerLiteral() {
		return integerLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerLiteral_Value() {
		return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDecimalLiteral() {
		return decimalLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDecimalLiteral_Value() {
		return (EAttribute)decimalLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDoubleLiteral() {
		return doubleLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDoubleLiteral_Value() {
		return (EAttribute)doubleLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanLiteral() {
		return booleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanLiteral_Value() {
		return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSeparatorKind() {
		return separatorKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getRangeRestrictionKind() {
		return rangeRestrictionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCardinalityRestrictionKind() {
		return cardinalityRestrictionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getUnsignedInt() {
		return unsignedIntEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getUnsignedInteger() {
		return unsignedIntegerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDecimal() {
		return decimalEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getID() {
		return idEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getNamespace() {
		return namespaceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OmlFactory getOmlFactory() {
		return (OmlFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		elementEClass = createEClass(ELEMENT);
		createEOperation(elementEClass, ELEMENT___EXTRA_VALIDATE__DIAGNOSTICCHAIN_MAP);
		createEOperation(elementEClass, ELEMENT___GET_ONTOLOGY);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__PROPERTY);
		createEReference(annotationEClass, ANNOTATION__VALUE);
		createEReference(annotationEClass, ANNOTATION__REFERENCE_VALUE);
		createEReference(annotationEClass, ANNOTATION__OWNING_ELEMENT);
		createEReference(annotationEClass, ANNOTATION__OWNING_REFERENCE);

		annotatedElementEClass = createEClass(ANNOTATED_ELEMENT);
		createEReference(annotatedElementEClass, ANNOTATED_ELEMENT__OWNED_ANNOTATIONS);

		identifiedElementEClass = createEClass(IDENTIFIED_ELEMENT);
		createEOperation(identifiedElementEClass, IDENTIFIED_ELEMENT___GET_IRI);

		ontologyEClass = createEClass(ONTOLOGY);
		createEAttribute(ontologyEClass, ONTOLOGY__NAMESPACE);
		createEAttribute(ontologyEClass, ONTOLOGY__PREFIX);
		createEOperation(ontologyEClass, ONTOLOGY___GET_IRI);
		createEOperation(ontologyEClass, ONTOLOGY___GET_SEPARATOR);

		vocabularyBoxEClass = createEClass(VOCABULARY_BOX);

		vocabularyEClass = createEClass(VOCABULARY);
		createEReference(vocabularyEClass, VOCABULARY__OWNED_IMPORTS);
		createEReference(vocabularyEClass, VOCABULARY__OWNED_STATEMENTS);

		vocabularyBundleEClass = createEClass(VOCABULARY_BUNDLE);
		createEReference(vocabularyBundleEClass, VOCABULARY_BUNDLE__OWNED_IMPORTS);

		descriptionBoxEClass = createEClass(DESCRIPTION_BOX);

		descriptionEClass = createEClass(DESCRIPTION);
		createEReference(descriptionEClass, DESCRIPTION__OWNED_IMPORTS);
		createEReference(descriptionEClass, DESCRIPTION__OWNED_STATEMENTS);

		descriptionBundleEClass = createEClass(DESCRIPTION_BUNDLE);
		createEReference(descriptionBundleEClass, DESCRIPTION_BUNDLE__OWNED_IMPORTS);

		memberEClass = createEClass(MEMBER);
		createEAttribute(memberEClass, MEMBER__NAME);
		createEOperation(memberEClass, MEMBER___GET_IRI);
		createEOperation(memberEClass, MEMBER___GET_ABBREVIATED_IRI);

		termEClass = createEClass(TERM);

		specializableTermEClass = createEClass(SPECIALIZABLE_TERM);
		createEReference(specializableTermEClass, SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS);

		typeEClass = createEClass(TYPE);

		classifierEClass = createEClass(CLASSIFIER);
		createEReference(classifierEClass, CLASSIFIER__OWNED_PROPERTY_RESTRICTIONS);

		entityEClass = createEClass(ENTITY);
		createEReference(entityEClass, ENTITY__OWNED_RELATION_RESTRICTIONS);
		createEReference(entityEClass, ENTITY__OWNED_KEYS);

		aspectEClass = createEClass(ASPECT);

		conceptEClass = createEClass(CONCEPT);
		createEReference(conceptEClass, CONCEPT__ENUMERATED_INSTANCES);

		relationEntityEClass = createEClass(RELATION_ENTITY);
		createEReference(relationEntityEClass, RELATION_ENTITY__SOURCE);
		createEReference(relationEntityEClass, RELATION_ENTITY__TARGET);
		createEReference(relationEntityEClass, RELATION_ENTITY__FORWARD_RELATION);
		createEReference(relationEntityEClass, RELATION_ENTITY__REVERSE_RELATION);
		createEAttribute(relationEntityEClass, RELATION_ENTITY__FUNCTIONAL);
		createEAttribute(relationEntityEClass, RELATION_ENTITY__INVERSE_FUNCTIONAL);
		createEAttribute(relationEntityEClass, RELATION_ENTITY__SYMMETRIC);
		createEAttribute(relationEntityEClass, RELATION_ENTITY__ASYMMETRIC);
		createEAttribute(relationEntityEClass, RELATION_ENTITY__REFLEXIVE);
		createEAttribute(relationEntityEClass, RELATION_ENTITY__IRREFLEXIVE);
		createEAttribute(relationEntityEClass, RELATION_ENTITY__TRANSITIVE);

		structureEClass = createEClass(STRUCTURE);

		featureEClass = createEClass(FEATURE);

		propertyEClass = createEClass(PROPERTY);

		annotationPropertyEClass = createEClass(ANNOTATION_PROPERTY);

		semanticPropertyEClass = createEClass(SEMANTIC_PROPERTY);
		createEOperation(semanticPropertyEClass, SEMANTIC_PROPERTY___IS_FUNCTIONAL);
		createEOperation(semanticPropertyEClass, SEMANTIC_PROPERTY___GET_DOMAIN);
		createEOperation(semanticPropertyEClass, SEMANTIC_PROPERTY___GET_RANGE);

		scalarPropertyEClass = createEClass(SCALAR_PROPERTY);
		createEAttribute(scalarPropertyEClass, SCALAR_PROPERTY__FUNCTIONAL);
		createEReference(scalarPropertyEClass, SCALAR_PROPERTY__DOMAIN);
		createEReference(scalarPropertyEClass, SCALAR_PROPERTY__RANGE);

		structuredPropertyEClass = createEClass(STRUCTURED_PROPERTY);
		createEAttribute(structuredPropertyEClass, STRUCTURED_PROPERTY__FUNCTIONAL);
		createEReference(structuredPropertyEClass, STRUCTURED_PROPERTY__DOMAIN);
		createEReference(structuredPropertyEClass, STRUCTURED_PROPERTY__RANGE);

		scalarEClass = createEClass(SCALAR);

		facetedScalarEClass = createEClass(FACETED_SCALAR);
		createEAttribute(facetedScalarEClass, FACETED_SCALAR__LENGTH);
		createEAttribute(facetedScalarEClass, FACETED_SCALAR__MIN_LENGTH);
		createEAttribute(facetedScalarEClass, FACETED_SCALAR__MAX_LENGTH);
		createEAttribute(facetedScalarEClass, FACETED_SCALAR__PATTERN);
		createEAttribute(facetedScalarEClass, FACETED_SCALAR__LANGUAGE);
		createEReference(facetedScalarEClass, FACETED_SCALAR__MIN_INCLUSIVE);
		createEReference(facetedScalarEClass, FACETED_SCALAR__MIN_EXCLUSIVE);
		createEReference(facetedScalarEClass, FACETED_SCALAR__MAX_INCLUSIVE);
		createEReference(facetedScalarEClass, FACETED_SCALAR__MAX_EXCLUSIVE);

		enumeratedScalarEClass = createEClass(ENUMERATED_SCALAR);
		createEReference(enumeratedScalarEClass, ENUMERATED_SCALAR__LITERALS);

		relationEClass = createEClass(RELATION);
		createEReference(relationEClass, RELATION__DOMAIN);
		createEReference(relationEClass, RELATION__RANGE);
		createEReference(relationEClass, RELATION__INVERSE);
		createEOperation(relationEClass, RELATION___GET_RELATION_ENTITY);
		createEOperation(relationEClass, RELATION___DERIVE_DOMAIN);
		createEOperation(relationEClass, RELATION___DERIVE_RANGE);
		createEOperation(relationEClass, RELATION___DERIVE_INVERSE);

		forwardRelationEClass = createEClass(FORWARD_RELATION);
		createEReference(forwardRelationEClass, FORWARD_RELATION__RELATION_ENTITY);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___DERIVE_DOMAIN);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___DERIVE_RANGE);
		createEOperation(forwardRelationEClass, FORWARD_RELATION___DERIVE_INVERSE);

		reverseRelationEClass = createEClass(REVERSE_RELATION);
		createEReference(reverseRelationEClass, REVERSE_RELATION__RELATION_ENTITY);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___DERIVE_DOMAIN);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___DERIVE_RANGE);
		createEOperation(reverseRelationEClass, REVERSE_RELATION___DERIVE_INVERSE);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__ANTECEDENT);
		createEReference(ruleEClass, RULE__CONSEQUENT);

		instanceEClass = createEClass(INSTANCE);
		createEReference(instanceEClass, INSTANCE__OWNED_PROPERTY_VALUES);

		structureInstanceEClass = createEClass(STRUCTURE_INSTANCE);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__TYPE);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__OWNING_AXIOM);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__OWNING_ASSERTION);

		namedInstanceEClass = createEClass(NAMED_INSTANCE);
		createEReference(namedInstanceEClass, NAMED_INSTANCE__OWNED_LINKS);

		conceptInstanceEClass = createEClass(CONCEPT_INSTANCE);
		createEReference(conceptInstanceEClass, CONCEPT_INSTANCE__OWNED_TYPES);

		relationInstanceEClass = createEClass(RELATION_INSTANCE);
		createEReference(relationInstanceEClass, RELATION_INSTANCE__OWNED_TYPES);
		createEReference(relationInstanceEClass, RELATION_INSTANCE__SOURCES);
		createEReference(relationInstanceEClass, RELATION_INSTANCE__TARGETS);

		referenceEClass = createEClass(REFERENCE);
		createEReference(referenceEClass, REFERENCE__OWNED_ANNOTATIONS);

		specializableTermReferenceEClass = createEClass(SPECIALIZABLE_TERM_REFERENCE);
		createEReference(specializableTermReferenceEClass, SPECIALIZABLE_TERM_REFERENCE__OWNED_SPECIALIZATIONS);

		classifierReferenceEClass = createEClass(CLASSIFIER_REFERENCE);
		createEReference(classifierReferenceEClass, CLASSIFIER_REFERENCE__OWNED_PROPERTY_RESTRICTIONS);

		entityReferenceEClass = createEClass(ENTITY_REFERENCE);
		createEReference(entityReferenceEClass, ENTITY_REFERENCE__OWNED_RELATION_RESTRICTIONS);
		createEReference(entityReferenceEClass, ENTITY_REFERENCE__OWNED_KEYS);

		aspectReferenceEClass = createEClass(ASPECT_REFERENCE);
		createEReference(aspectReferenceEClass, ASPECT_REFERENCE__ASPECT);

		conceptReferenceEClass = createEClass(CONCEPT_REFERENCE);
		createEReference(conceptReferenceEClass, CONCEPT_REFERENCE__CONCEPT);

		relationEntityReferenceEClass = createEClass(RELATION_ENTITY_REFERENCE);
		createEReference(relationEntityReferenceEClass, RELATION_ENTITY_REFERENCE__ENTITY);

		structureReferenceEClass = createEClass(STRUCTURE_REFERENCE);
		createEReference(structureReferenceEClass, STRUCTURE_REFERENCE__STRUCTURE);

		annotationPropertyReferenceEClass = createEClass(ANNOTATION_PROPERTY_REFERENCE);
		createEReference(annotationPropertyReferenceEClass, ANNOTATION_PROPERTY_REFERENCE__PROPERTY);

		scalarPropertyReferenceEClass = createEClass(SCALAR_PROPERTY_REFERENCE);
		createEReference(scalarPropertyReferenceEClass, SCALAR_PROPERTY_REFERENCE__PROPERTY);

		structuredPropertyReferenceEClass = createEClass(STRUCTURED_PROPERTY_REFERENCE);
		createEReference(structuredPropertyReferenceEClass, STRUCTURED_PROPERTY_REFERENCE__PROPERTY);

		facetedScalarReferenceEClass = createEClass(FACETED_SCALAR_REFERENCE);
		createEReference(facetedScalarReferenceEClass, FACETED_SCALAR_REFERENCE__SCALAR);

		enumeratedScalarReferenceEClass = createEClass(ENUMERATED_SCALAR_REFERENCE);
		createEReference(enumeratedScalarReferenceEClass, ENUMERATED_SCALAR_REFERENCE__SCALAR);

		relationReferenceEClass = createEClass(RELATION_REFERENCE);
		createEReference(relationReferenceEClass, RELATION_REFERENCE__RELATION);

		ruleReferenceEClass = createEClass(RULE_REFERENCE);
		createEReference(ruleReferenceEClass, RULE_REFERENCE__RULE);

		namedInstanceReferenceEClass = createEClass(NAMED_INSTANCE_REFERENCE);
		createEReference(namedInstanceReferenceEClass, NAMED_INSTANCE_REFERENCE__OWNED_PROPERTY_VALUES);
		createEReference(namedInstanceReferenceEClass, NAMED_INSTANCE_REFERENCE__OWNED_LINKS);

		conceptInstanceReferenceEClass = createEClass(CONCEPT_INSTANCE_REFERENCE);
		createEReference(conceptInstanceReferenceEClass, CONCEPT_INSTANCE_REFERENCE__INSTANCE);
		createEReference(conceptInstanceReferenceEClass, CONCEPT_INSTANCE_REFERENCE__OWNED_TYPES);

		relationInstanceReferenceEClass = createEClass(RELATION_INSTANCE_REFERENCE);
		createEReference(relationInstanceReferenceEClass, RELATION_INSTANCE_REFERENCE__INSTANCE);
		createEReference(relationInstanceReferenceEClass, RELATION_INSTANCE_REFERENCE__OWNED_TYPES);

		statementEClass = createEClass(STATEMENT);

		vocabularyStatementEClass = createEClass(VOCABULARY_STATEMENT);
		createEReference(vocabularyStatementEClass, VOCABULARY_STATEMENT__OWNING_VOCABULARY);

		descriptionStatementEClass = createEClass(DESCRIPTION_STATEMENT);
		createEReference(descriptionStatementEClass, DESCRIPTION_STATEMENT__OWNING_DESCRIPTION);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__NAMESPACE);
		createEAttribute(importEClass, IMPORT__PREFIX);
		createEOperation(importEClass, IMPORT___GET_IRI);
		createEOperation(importEClass, IMPORT___GET_SEPARATOR);

		vocabularyImportEClass = createEClass(VOCABULARY_IMPORT);
		createEReference(vocabularyImportEClass, VOCABULARY_IMPORT__OWNING_VOCABULARY);

		vocabularyExtensionEClass = createEClass(VOCABULARY_EXTENSION);

		vocabularyUsageEClass = createEClass(VOCABULARY_USAGE);

		vocabularyBundleImportEClass = createEClass(VOCABULARY_BUNDLE_IMPORT);
		createEReference(vocabularyBundleImportEClass, VOCABULARY_BUNDLE_IMPORT__OWNING_VOCABULARY_BUNDLE);

		vocabularyBundleExtensionEClass = createEClass(VOCABULARY_BUNDLE_EXTENSION);

		vocabularyBundleInclusionEClass = createEClass(VOCABULARY_BUNDLE_INCLUSION);

		descriptionImportEClass = createEClass(DESCRIPTION_IMPORT);
		createEReference(descriptionImportEClass, DESCRIPTION_IMPORT__OWNING_DESCRIPTION);

		descriptionExtensionEClass = createEClass(DESCRIPTION_EXTENSION);

		descriptionUsageEClass = createEClass(DESCRIPTION_USAGE);

		descriptionBundleImportEClass = createEClass(DESCRIPTION_BUNDLE_IMPORT);
		createEReference(descriptionBundleImportEClass, DESCRIPTION_BUNDLE_IMPORT__OWNING_DESCRIPTION_BUNDLE);

		descriptionBundleExtensionEClass = createEClass(DESCRIPTION_BUNDLE_EXTENSION);

		descriptionBundleInclusionEClass = createEClass(DESCRIPTION_BUNDLE_INCLUSION);

		descriptionBundleUsageEClass = createEClass(DESCRIPTION_BUNDLE_USAGE);

		axiomEClass = createEClass(AXIOM);

		specializationAxiomEClass = createEClass(SPECIALIZATION_AXIOM);
		createEReference(specializationAxiomEClass, SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
		createEReference(specializationAxiomEClass, SPECIALIZATION_AXIOM__OWNING_TERM);
		createEReference(specializationAxiomEClass, SPECIALIZATION_AXIOM__OWNING_REFERENCE);

		restrictionAxiomEClass = createEClass(RESTRICTION_AXIOM);

		propertyRestrictionAxiomEClass = createEClass(PROPERTY_RESTRICTION_AXIOM);
		createEReference(propertyRestrictionAxiomEClass, PROPERTY_RESTRICTION_AXIOM__OWNING_CLASSIFIER);
		createEReference(propertyRestrictionAxiomEClass, PROPERTY_RESTRICTION_AXIOM__OWNING_REFERENCE);

		scalarPropertyRestrictionAxiomEClass = createEClass(SCALAR_PROPERTY_RESTRICTION_AXIOM);
		createEReference(scalarPropertyRestrictionAxiomEClass, SCALAR_PROPERTY_RESTRICTION_AXIOM__PROPERTY);

		scalarPropertyRangeRestrictionAxiomEClass = createEClass(SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM);
		createEReference(scalarPropertyRangeRestrictionAxiomEClass, SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE);
		createEAttribute(scalarPropertyRangeRestrictionAxiomEClass, SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM__KIND);

		scalarPropertyCardinalityRestrictionAxiomEClass = createEClass(SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM);
		createEAttribute(scalarPropertyCardinalityRestrictionAxiomEClass, SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY);
		createEAttribute(scalarPropertyCardinalityRestrictionAxiomEClass, SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND);
		createEReference(scalarPropertyCardinalityRestrictionAxiomEClass, SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE);

		scalarPropertyValueRestrictionAxiomEClass = createEClass(SCALAR_PROPERTY_VALUE_RESTRICTION_AXIOM);
		createEReference(scalarPropertyValueRestrictionAxiomEClass, SCALAR_PROPERTY_VALUE_RESTRICTION_AXIOM__VALUE);

		structuredPropertyRestrictionAxiomEClass = createEClass(STRUCTURED_PROPERTY_RESTRICTION_AXIOM);
		createEReference(structuredPropertyRestrictionAxiomEClass, STRUCTURED_PROPERTY_RESTRICTION_AXIOM__PROPERTY);

		structuredPropertyRangeRestrictionAxiomEClass = createEClass(STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM);
		createEReference(structuredPropertyRangeRestrictionAxiomEClass, STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE);
		createEAttribute(structuredPropertyRangeRestrictionAxiomEClass, STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM__KIND);

		structuredPropertyCardinalityRestrictionAxiomEClass = createEClass(STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM);
		createEAttribute(structuredPropertyCardinalityRestrictionAxiomEClass, STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY);
		createEAttribute(structuredPropertyCardinalityRestrictionAxiomEClass, STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__KIND);
		createEReference(structuredPropertyCardinalityRestrictionAxiomEClass, STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE);

		structuredPropertyValueRestrictionAxiomEClass = createEClass(STRUCTURED_PROPERTY_VALUE_RESTRICTION_AXIOM);
		createEReference(structuredPropertyValueRestrictionAxiomEClass, STRUCTURED_PROPERTY_VALUE_RESTRICTION_AXIOM__VALUE);

		relationRestrictionAxiomEClass = createEClass(RELATION_RESTRICTION_AXIOM);
		createEReference(relationRestrictionAxiomEClass, RELATION_RESTRICTION_AXIOM__RELATION);
		createEReference(relationRestrictionAxiomEClass, RELATION_RESTRICTION_AXIOM__OWNING_ENTITY);
		createEReference(relationRestrictionAxiomEClass, RELATION_RESTRICTION_AXIOM__OWNING_REFERENCE);

		relationRangeRestrictionAxiomEClass = createEClass(RELATION_RANGE_RESTRICTION_AXIOM);
		createEReference(relationRangeRestrictionAxiomEClass, RELATION_RANGE_RESTRICTION_AXIOM__RANGE);
		createEAttribute(relationRangeRestrictionAxiomEClass, RELATION_RANGE_RESTRICTION_AXIOM__KIND);

		relationCardinalityRestrictionAxiomEClass = createEClass(RELATION_CARDINALITY_RESTRICTION_AXIOM);
		createEAttribute(relationCardinalityRestrictionAxiomEClass, RELATION_CARDINALITY_RESTRICTION_AXIOM__CARDINALITY);
		createEAttribute(relationCardinalityRestrictionAxiomEClass, RELATION_CARDINALITY_RESTRICTION_AXIOM__KIND);
		createEReference(relationCardinalityRestrictionAxiomEClass, RELATION_CARDINALITY_RESTRICTION_AXIOM__RANGE);

		relationTargetRestrictionAxiomEClass = createEClass(RELATION_TARGET_RESTRICTION_AXIOM);
		createEReference(relationTargetRestrictionAxiomEClass, RELATION_TARGET_RESTRICTION_AXIOM__TARGET);

		keyAxiomEClass = createEClass(KEY_AXIOM);
		createEReference(keyAxiomEClass, KEY_AXIOM__PROPERTIES);
		createEReference(keyAxiomEClass, KEY_AXIOM__OWNING_ENTITY);
		createEReference(keyAxiomEClass, KEY_AXIOM__OWNING_REFERENCE);

		assertionEClass = createEClass(ASSERTION);

		typeAssertionEClass = createEClass(TYPE_ASSERTION);
		createEOperation(typeAssertionEClass, TYPE_ASSERTION___GET_TYPE);

		conceptTypeAssertionEClass = createEClass(CONCEPT_TYPE_ASSERTION);
		createEReference(conceptTypeAssertionEClass, CONCEPT_TYPE_ASSERTION__TYPE);
		createEReference(conceptTypeAssertionEClass, CONCEPT_TYPE_ASSERTION__OWNING_INSTANCE);
		createEReference(conceptTypeAssertionEClass, CONCEPT_TYPE_ASSERTION__OWNING_REFERENCE);

		relationTypeAssertionEClass = createEClass(RELATION_TYPE_ASSERTION);
		createEReference(relationTypeAssertionEClass, RELATION_TYPE_ASSERTION__TYPE);
		createEReference(relationTypeAssertionEClass, RELATION_TYPE_ASSERTION__OWNING_INSTANCE);
		createEReference(relationTypeAssertionEClass, RELATION_TYPE_ASSERTION__OWNING_REFERENCE);

		propertyValueAssertionEClass = createEClass(PROPERTY_VALUE_ASSERTION);
		createEReference(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION__OWNING_INSTANCE);
		createEReference(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION__OWNING_REFERENCE);
		createEOperation(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION___GET_PROPERTY);
		createEOperation(propertyValueAssertionEClass, PROPERTY_VALUE_ASSERTION___GET_VALUE);

		scalarPropertyValueAssertionEClass = createEClass(SCALAR_PROPERTY_VALUE_ASSERTION);
		createEReference(scalarPropertyValueAssertionEClass, SCALAR_PROPERTY_VALUE_ASSERTION__PROPERTY);
		createEReference(scalarPropertyValueAssertionEClass, SCALAR_PROPERTY_VALUE_ASSERTION__VALUE);

		structuredPropertyValueAssertionEClass = createEClass(STRUCTURED_PROPERTY_VALUE_ASSERTION);
		createEReference(structuredPropertyValueAssertionEClass, STRUCTURED_PROPERTY_VALUE_ASSERTION__PROPERTY);
		createEReference(structuredPropertyValueAssertionEClass, STRUCTURED_PROPERTY_VALUE_ASSERTION__VALUE);

		linkAssertionEClass = createEClass(LINK_ASSERTION);
		createEReference(linkAssertionEClass, LINK_ASSERTION__RELATION);
		createEReference(linkAssertionEClass, LINK_ASSERTION__TARGET);
		createEReference(linkAssertionEClass, LINK_ASSERTION__OWNING_INSTANCE);
		createEReference(linkAssertionEClass, LINK_ASSERTION__OWNING_REFERENCE);

		predicateEClass = createEClass(PREDICATE);
		createEReference(predicateEClass, PREDICATE__ANTECEDENT_RULE);
		createEReference(predicateEClass, PREDICATE__CONSEQUENT_RULE);

		unaryPredicateEClass = createEClass(UNARY_PREDICATE);
		createEAttribute(unaryPredicateEClass, UNARY_PREDICATE__VARIABLE);

		typePredicateEClass = createEClass(TYPE_PREDICATE);
		createEReference(typePredicateEClass, TYPE_PREDICATE__TYPE);

		binaryPredicateEClass = createEClass(BINARY_PREDICATE);
		createEAttribute(binaryPredicateEClass, BINARY_PREDICATE__VARIABLE1);
		createEAttribute(binaryPredicateEClass, BINARY_PREDICATE__VARIABLE2);
		createEReference(binaryPredicateEClass, BINARY_PREDICATE__INSTANCE2);

		relationEntityPredicateEClass = createEClass(RELATION_ENTITY_PREDICATE);
		createEReference(relationEntityPredicateEClass, RELATION_ENTITY_PREDICATE__ENTITY);
		createEAttribute(relationEntityPredicateEClass, RELATION_ENTITY_PREDICATE__ENTITY_VARIABLE);

		featurePredicateEClass = createEClass(FEATURE_PREDICATE);
		createEReference(featurePredicateEClass, FEATURE_PREDICATE__FEATURE);
		createEReference(featurePredicateEClass, FEATURE_PREDICATE__LITERAL2);

		sameAsPredicateEClass = createEClass(SAME_AS_PREDICATE);

		differentFromPredicateEClass = createEClass(DIFFERENT_FROM_PREDICATE);

		literalEClass = createEClass(LITERAL);

		quotedLiteralEClass = createEClass(QUOTED_LITERAL);
		createEAttribute(quotedLiteralEClass, QUOTED_LITERAL__VALUE);
		createEAttribute(quotedLiteralEClass, QUOTED_LITERAL__LANG_TAG);
		createEReference(quotedLiteralEClass, QUOTED_LITERAL__TYPE);

		integerLiteralEClass = createEClass(INTEGER_LITERAL);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);

		decimalLiteralEClass = createEClass(DECIMAL_LITERAL);
		createEAttribute(decimalLiteralEClass, DECIMAL_LITERAL__VALUE);

		doubleLiteralEClass = createEClass(DOUBLE_LITERAL);
		createEAttribute(doubleLiteralEClass, DOUBLE_LITERAL__VALUE);

		booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
		createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

		// Create enums
		separatorKindEEnum = createEEnum(SEPARATOR_KIND);
		rangeRestrictionKindEEnum = createEEnum(RANGE_RESTRICTION_KIND);
		cardinalityRestrictionKindEEnum = createEEnum(CARDINALITY_RESTRICTION_KIND);

		// Create data types
		unsignedIntEDataType = createEDataType(UNSIGNED_INT);
		unsignedIntegerEDataType = createEDataType(UNSIGNED_INTEGER);
		decimalEDataType = createEDataType(DECIMAL);
		idEDataType = createEDataType(ID);
		namespaceEDataType = createEDataType(NAMESPACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		annotationEClass.getESuperTypes().add(this.getElement());
		annotatedElementEClass.getESuperTypes().add(this.getElement());
		identifiedElementEClass.getESuperTypes().add(this.getAnnotatedElement());
		ontologyEClass.getESuperTypes().add(this.getIdentifiedElement());
		vocabularyBoxEClass.getESuperTypes().add(this.getOntology());
		vocabularyEClass.getESuperTypes().add(this.getVocabularyBox());
		vocabularyBundleEClass.getESuperTypes().add(this.getVocabularyBox());
		descriptionBoxEClass.getESuperTypes().add(this.getOntology());
		descriptionEClass.getESuperTypes().add(this.getDescriptionBox());
		descriptionBundleEClass.getESuperTypes().add(this.getDescriptionBox());
		memberEClass.getESuperTypes().add(this.getIdentifiedElement());
		termEClass.getESuperTypes().add(this.getMember());
		specializableTermEClass.getESuperTypes().add(this.getTerm());
		specializableTermEClass.getESuperTypes().add(this.getVocabularyStatement());
		typeEClass.getESuperTypes().add(this.getSpecializableTerm());
		classifierEClass.getESuperTypes().add(this.getType());
		entityEClass.getESuperTypes().add(this.getClassifier());
		aspectEClass.getESuperTypes().add(this.getEntity());
		conceptEClass.getESuperTypes().add(this.getEntity());
		relationEntityEClass.getESuperTypes().add(this.getEntity());
		structureEClass.getESuperTypes().add(this.getClassifier());
		featureEClass.getESuperTypes().add(this.getTerm());
		propertyEClass.getESuperTypes().add(this.getFeature());
		annotationPropertyEClass.getESuperTypes().add(this.getProperty());
		annotationPropertyEClass.getESuperTypes().add(this.getSpecializableTerm());
		semanticPropertyEClass.getESuperTypes().add(this.getProperty());
		scalarPropertyEClass.getESuperTypes().add(this.getSemanticProperty());
		scalarPropertyEClass.getESuperTypes().add(this.getSpecializableTerm());
		structuredPropertyEClass.getESuperTypes().add(this.getSemanticProperty());
		structuredPropertyEClass.getESuperTypes().add(this.getSpecializableTerm());
		scalarEClass.getESuperTypes().add(this.getType());
		facetedScalarEClass.getESuperTypes().add(this.getScalar());
		enumeratedScalarEClass.getESuperTypes().add(this.getScalar());
		relationEClass.getESuperTypes().add(this.getFeature());
		forwardRelationEClass.getESuperTypes().add(this.getRelation());
		reverseRelationEClass.getESuperTypes().add(this.getRelation());
		ruleEClass.getESuperTypes().add(this.getMember());
		ruleEClass.getESuperTypes().add(this.getVocabularyStatement());
		instanceEClass.getESuperTypes().add(this.getElement());
		structureInstanceEClass.getESuperTypes().add(this.getInstance());
		namedInstanceEClass.getESuperTypes().add(this.getMember());
		namedInstanceEClass.getESuperTypes().add(this.getInstance());
		namedInstanceEClass.getESuperTypes().add(this.getDescriptionStatement());
		conceptInstanceEClass.getESuperTypes().add(this.getNamedInstance());
		relationInstanceEClass.getESuperTypes().add(this.getNamedInstance());
		referenceEClass.getESuperTypes().add(this.getElement());
		specializableTermReferenceEClass.getESuperTypes().add(this.getReference());
		specializableTermReferenceEClass.getESuperTypes().add(this.getVocabularyStatement());
		classifierReferenceEClass.getESuperTypes().add(this.getSpecializableTermReference());
		entityReferenceEClass.getESuperTypes().add(this.getClassifierReference());
		aspectReferenceEClass.getESuperTypes().add(this.getEntityReference());
		conceptReferenceEClass.getESuperTypes().add(this.getEntityReference());
		relationEntityReferenceEClass.getESuperTypes().add(this.getEntityReference());
		structureReferenceEClass.getESuperTypes().add(this.getClassifierReference());
		annotationPropertyReferenceEClass.getESuperTypes().add(this.getSpecializableTermReference());
		scalarPropertyReferenceEClass.getESuperTypes().add(this.getSpecializableTermReference());
		structuredPropertyReferenceEClass.getESuperTypes().add(this.getSpecializableTermReference());
		facetedScalarReferenceEClass.getESuperTypes().add(this.getSpecializableTermReference());
		enumeratedScalarReferenceEClass.getESuperTypes().add(this.getSpecializableTermReference());
		relationReferenceEClass.getESuperTypes().add(this.getReference());
		relationReferenceEClass.getESuperTypes().add(this.getVocabularyStatement());
		ruleReferenceEClass.getESuperTypes().add(this.getReference());
		ruleReferenceEClass.getESuperTypes().add(this.getVocabularyStatement());
		namedInstanceReferenceEClass.getESuperTypes().add(this.getReference());
		namedInstanceReferenceEClass.getESuperTypes().add(this.getDescriptionStatement());
		conceptInstanceReferenceEClass.getESuperTypes().add(this.getNamedInstanceReference());
		relationInstanceReferenceEClass.getESuperTypes().add(this.getNamedInstanceReference());
		statementEClass.getESuperTypes().add(this.getElement());
		vocabularyStatementEClass.getESuperTypes().add(this.getStatement());
		descriptionStatementEClass.getESuperTypes().add(this.getStatement());
		importEClass.getESuperTypes().add(this.getAnnotatedElement());
		vocabularyImportEClass.getESuperTypes().add(this.getImport());
		vocabularyExtensionEClass.getESuperTypes().add(this.getVocabularyImport());
		vocabularyUsageEClass.getESuperTypes().add(this.getVocabularyImport());
		vocabularyBundleImportEClass.getESuperTypes().add(this.getImport());
		vocabularyBundleExtensionEClass.getESuperTypes().add(this.getVocabularyBundleImport());
		vocabularyBundleInclusionEClass.getESuperTypes().add(this.getVocabularyBundleImport());
		descriptionImportEClass.getESuperTypes().add(this.getImport());
		descriptionExtensionEClass.getESuperTypes().add(this.getDescriptionImport());
		descriptionUsageEClass.getESuperTypes().add(this.getDescriptionImport());
		descriptionBundleImportEClass.getESuperTypes().add(this.getImport());
		descriptionBundleExtensionEClass.getESuperTypes().add(this.getDescriptionBundleImport());
		descriptionBundleInclusionEClass.getESuperTypes().add(this.getDescriptionBundleImport());
		descriptionBundleUsageEClass.getESuperTypes().add(this.getDescriptionBundleImport());
		axiomEClass.getESuperTypes().add(this.getElement());
		specializationAxiomEClass.getESuperTypes().add(this.getAxiom());
		restrictionAxiomEClass.getESuperTypes().add(this.getAxiom());
		propertyRestrictionAxiomEClass.getESuperTypes().add(this.getRestrictionAxiom());
		scalarPropertyRestrictionAxiomEClass.getESuperTypes().add(this.getPropertyRestrictionAxiom());
		scalarPropertyRangeRestrictionAxiomEClass.getESuperTypes().add(this.getScalarPropertyRestrictionAxiom());
		scalarPropertyCardinalityRestrictionAxiomEClass.getESuperTypes().add(this.getScalarPropertyRestrictionAxiom());
		scalarPropertyValueRestrictionAxiomEClass.getESuperTypes().add(this.getScalarPropertyRestrictionAxiom());
		structuredPropertyRestrictionAxiomEClass.getESuperTypes().add(this.getPropertyRestrictionAxiom());
		structuredPropertyRangeRestrictionAxiomEClass.getESuperTypes().add(this.getStructuredPropertyRestrictionAxiom());
		structuredPropertyCardinalityRestrictionAxiomEClass.getESuperTypes().add(this.getStructuredPropertyRestrictionAxiom());
		structuredPropertyValueRestrictionAxiomEClass.getESuperTypes().add(this.getStructuredPropertyRestrictionAxiom());
		relationRestrictionAxiomEClass.getESuperTypes().add(this.getRestrictionAxiom());
		relationRangeRestrictionAxiomEClass.getESuperTypes().add(this.getRelationRestrictionAxiom());
		relationCardinalityRestrictionAxiomEClass.getESuperTypes().add(this.getRelationRestrictionAxiom());
		relationTargetRestrictionAxiomEClass.getESuperTypes().add(this.getRelationRestrictionAxiom());
		keyAxiomEClass.getESuperTypes().add(this.getAxiom());
		assertionEClass.getESuperTypes().add(this.getElement());
		typeAssertionEClass.getESuperTypes().add(this.getAssertion());
		conceptTypeAssertionEClass.getESuperTypes().add(this.getTypeAssertion());
		relationTypeAssertionEClass.getESuperTypes().add(this.getTypeAssertion());
		propertyValueAssertionEClass.getESuperTypes().add(this.getAssertion());
		scalarPropertyValueAssertionEClass.getESuperTypes().add(this.getPropertyValueAssertion());
		structuredPropertyValueAssertionEClass.getESuperTypes().add(this.getPropertyValueAssertion());
		linkAssertionEClass.getESuperTypes().add(this.getAssertion());
		predicateEClass.getESuperTypes().add(this.getElement());
		unaryPredicateEClass.getESuperTypes().add(this.getPredicate());
		typePredicateEClass.getESuperTypes().add(this.getUnaryPredicate());
		binaryPredicateEClass.getESuperTypes().add(this.getPredicate());
		relationEntityPredicateEClass.getESuperTypes().add(this.getBinaryPredicate());
		featurePredicateEClass.getESuperTypes().add(this.getBinaryPredicate());
		sameAsPredicateEClass.getESuperTypes().add(this.getBinaryPredicate());
		differentFromPredicateEClass.getESuperTypes().add(this.getBinaryPredicate());
		literalEClass.getESuperTypes().add(this.getElement());
		quotedLiteralEClass.getESuperTypes().add(this.getLiteral());
		integerLiteralEClass.getESuperTypes().add(this.getLiteral());
		decimalLiteralEClass.getESuperTypes().add(this.getLiteral());
		doubleLiteralEClass.getESuperTypes().add(this.getLiteral());
		booleanLiteralEClass.getESuperTypes().add(this.getLiteral());

		// Initialize classes, features, and operations; add parameters
		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getElement__ExtraValidate__DiagnosticChain_Map(), theEcorePackage.getEBoolean(), "extraValidate", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, !IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(theEcorePackage.getEMap());
		EGenericType g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getElement__GetOntology(), this.getOntology(), "getOntology", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_Property(), this.getAnnotationProperty(), null, "property", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_Value(), this.getLiteral(), null, "value", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_ReferenceValue(), this.getMember(), null, "referenceValue", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_OwningElement(), this.getAnnotatedElement(), this.getAnnotatedElement_OwnedAnnotations(), "owningElement", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_OwningReference(), this.getReference(), this.getReference_OwnedAnnotations(), "owningReference", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotatedElementEClass, AnnotatedElement.class, "AnnotatedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotatedElement_OwnedAnnotations(), this.getAnnotation(), this.getAnnotation_OwningElement(), "ownedAnnotations", null, 0, -1, AnnotatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifiedElementEClass, IdentifiedElement.class, "IdentifiedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getIdentifiedElement__GetIri(), theEcorePackage.getEString(), "getIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ontologyEClass, Ontology.class, "Ontology", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOntology_Namespace(), this.getNamespace(), "namespace", null, 1, 1, Ontology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOntology_Prefix(), this.getID(), "prefix", null, 1, 1, Ontology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getOntology__GetIri(), theEcorePackage.getEString(), "getIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getOntology__GetSeparator(), this.getSeparatorKind(), "getSeparator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(vocabularyBoxEClass, VocabularyBox.class, "VocabularyBox", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vocabularyEClass, Vocabulary.class, "Vocabulary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVocabulary_OwnedImports(), this.getVocabularyImport(), this.getVocabularyImport_OwningVocabulary(), "ownedImports", null, 0, -1, Vocabulary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVocabulary_OwnedStatements(), this.getVocabularyStatement(), this.getVocabularyStatement_OwningVocabulary(), "ownedStatements", null, 0, -1, Vocabulary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vocabularyBundleEClass, VocabularyBundle.class, "VocabularyBundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVocabularyBundle_OwnedImports(), this.getVocabularyBundleImport(), this.getVocabularyBundleImport_OwningVocabularyBundle(), "ownedImports", null, 0, -1, VocabularyBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionBoxEClass, DescriptionBox.class, "DescriptionBox", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionEClass, Description.class, "Description", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescription_OwnedImports(), this.getDescriptionImport(), this.getDescriptionImport_OwningDescription(), "ownedImports", null, 0, -1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescription_OwnedStatements(), this.getDescriptionStatement(), this.getDescriptionStatement_OwningDescription(), "ownedStatements", null, 0, -1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionBundleEClass, DescriptionBundle.class, "DescriptionBundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionBundle_OwnedImports(), this.getDescriptionBundleImport(), this.getDescriptionBundleImport_OwningDescriptionBundle(), "ownedImports", null, 0, -1, DescriptionBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memberEClass, Member.class, "Member", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMember_Name(), this.getID(), "name", null, 1, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMember__GetIri(), theEcorePackage.getEString(), "getIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMember__GetAbbreviatedIri(), theEcorePackage.getEString(), "getAbbreviatedIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(termEClass, Term.class, "Term", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(specializableTermEClass, SpecializableTerm.class, "SpecializableTerm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecializableTerm_OwnedSpecializations(), this.getSpecializationAxiom(), this.getSpecializationAxiom_OwningTerm(), "ownedSpecializations", null, 0, -1, SpecializableTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierEClass, Classifier.class, "Classifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifier_OwnedPropertyRestrictions(), this.getPropertyRestrictionAxiom(), this.getPropertyRestrictionAxiom_OwningClassifier(), "ownedPropertyRestrictions", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntity_OwnedRelationRestrictions(), this.getRelationRestrictionAxiom(), this.getRelationRestrictionAxiom_OwningEntity(), "ownedRelationRestrictions", null, 0, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntity_OwnedKeys(), this.getKeyAxiom(), this.getKeyAxiom_OwningEntity(), "ownedKeys", null, 0, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aspectEClass, Aspect.class, "Aspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptEClass, Concept.class, "Concept", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConcept_EnumeratedInstances(), this.getConceptInstance(), null, "enumeratedInstances", null, 0, -1, Concept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationEntityEClass, RelationEntity.class, "RelationEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationEntity_Source(), this.getEntity(), null, "source", null, 1, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationEntity_Target(), this.getEntity(), null, "target", null, 1, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationEntity_ForwardRelation(), this.getForwardRelation(), this.getForwardRelation_RelationEntity(), "forwardRelation", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationEntity_ReverseRelation(), this.getReverseRelation(), this.getReverseRelation_RelationEntity(), "reverseRelation", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationEntity_Functional(), theEcorePackage.getEBoolean(), "functional", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationEntity_InverseFunctional(), theEcorePackage.getEBoolean(), "inverseFunctional", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationEntity_Symmetric(), theEcorePackage.getEBoolean(), "symmetric", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationEntity_Asymmetric(), theEcorePackage.getEBoolean(), "asymmetric", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationEntity_Reflexive(), theEcorePackage.getEBoolean(), "reflexive", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationEntity_Irreflexive(), theEcorePackage.getEBoolean(), "irreflexive", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationEntity_Transitive(), theEcorePackage.getEBoolean(), "transitive", null, 0, 1, RelationEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureEClass, Feature.class, "Feature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(annotationPropertyEClass, AnnotationProperty.class, "AnnotationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(semanticPropertyEClass, SemanticProperty.class, "SemanticProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getSemanticProperty__IsFunctional(), theEcorePackage.getEBoolean(), "isFunctional", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSemanticProperty__GetDomain(), this.getClassifier(), "getDomain", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSemanticProperty__GetRange(), this.getType(), "getRange", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(scalarPropertyEClass, ScalarProperty.class, "ScalarProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScalarProperty_Functional(), theEcorePackage.getEBoolean(), "functional", null, 0, 1, ScalarProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarProperty_Domain(), this.getClassifier(), null, "domain", null, 1, 1, ScalarProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarProperty_Range(), this.getScalar(), null, "range", null, 1, 1, ScalarProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredPropertyEClass, StructuredProperty.class, "StructuredProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStructuredProperty_Functional(), theEcorePackage.getEBoolean(), "functional", null, 0, 1, StructuredProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredProperty_Domain(), this.getClassifier(), null, "domain", null, 1, 1, StructuredProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredProperty_Range(), this.getStructure(), null, "range", null, 1, 1, StructuredProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalarEClass, Scalar.class, "Scalar", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(facetedScalarEClass, FacetedScalar.class, "FacetedScalar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFacetedScalar_Length(), this.getUnsignedInteger(), "length", null, 0, 1, FacetedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetedScalar_MinLength(), this.getUnsignedInteger(), "minLength", null, 0, 1, FacetedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetedScalar_MaxLength(), this.getUnsignedInteger(), "maxLength", null, 0, 1, FacetedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetedScalar_Pattern(), theEcorePackage.getEString(), "pattern", null, 0, 1, FacetedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetedScalar_Language(), theEcorePackage.getEString(), "language", null, 0, 1, FacetedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetedScalar_MinInclusive(), this.getLiteral(), null, "minInclusive", null, 0, 1, FacetedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetedScalar_MinExclusive(), this.getLiteral(), null, "minExclusive", null, 0, 1, FacetedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetedScalar_MaxInclusive(), this.getLiteral(), null, "maxInclusive", null, 0, 1, FacetedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetedScalar_MaxExclusive(), this.getLiteral(), null, "maxExclusive", null, 0, 1, FacetedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumeratedScalarEClass, EnumeratedScalar.class, "EnumeratedScalar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumeratedScalar_Literals(), this.getLiteral(), null, "literals", null, 0, -1, EnumeratedScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationEClass, Relation.class, "Relation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelation_Domain(), this.getEntity(), null, "domain", null, 1, 1, Relation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Range(), this.getEntity(), null, "range", null, 1, 1, Relation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Inverse(), this.getRelation(), null, "inverse", null, 0, 1, Relation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getRelation__GetRelationEntity(), this.getRelationEntity(), "getRelationEntity", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__DeriveDomain(), this.getEntity(), "deriveDomain", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__DeriveRange(), this.getEntity(), "deriveRange", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelation__DeriveInverse(), this.getRelation(), "deriveInverse", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(forwardRelationEClass, ForwardRelation.class, "ForwardRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForwardRelation_RelationEntity(), this.getRelationEntity(), this.getRelationEntity_ForwardRelation(), "relationEntity", null, 1, 1, ForwardRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getForwardRelation__DeriveDomain(), this.getEntity(), "deriveDomain", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__DeriveRange(), this.getEntity(), "deriveRange", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getForwardRelation__DeriveInverse(), this.getRelation(), "deriveInverse", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reverseRelationEClass, ReverseRelation.class, "ReverseRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReverseRelation_RelationEntity(), this.getRelationEntity(), this.getRelationEntity_ReverseRelation(), "relationEntity", null, 1, 1, ReverseRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReverseRelation__DeriveDomain(), this.getEntity(), "deriveDomain", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__DeriveRange(), this.getEntity(), "deriveRange", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReverseRelation__DeriveInverse(), this.getRelation(), "deriveInverse", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_Antecedent(), this.getPredicate(), this.getPredicate_AntecedentRule(), "antecedent", null, 1, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Consequent(), this.getPredicate(), this.getPredicate_ConsequentRule(), "consequent", null, 1, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instanceEClass, Instance.class, "Instance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstance_OwnedPropertyValues(), this.getPropertyValueAssertion(), this.getPropertyValueAssertion_OwningInstance(), "ownedPropertyValues", null, 0, -1, Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureInstanceEClass, StructureInstance.class, "StructureInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureInstance_Type(), this.getStructure(), null, "type", null, 1, 1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_OwningAxiom(), this.getStructuredPropertyValueRestrictionAxiom(), this.getStructuredPropertyValueRestrictionAxiom_Value(), "owningAxiom", null, 0, 1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_OwningAssertion(), this.getStructuredPropertyValueAssertion(), this.getStructuredPropertyValueAssertion_Value(), "owningAssertion", null, 0, 1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedInstanceEClass, NamedInstance.class, "NamedInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedInstance_OwnedLinks(), this.getLinkAssertion(), this.getLinkAssertion_OwningInstance(), "ownedLinks", null, 0, -1, NamedInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptInstanceEClass, ConceptInstance.class, "ConceptInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptInstance_OwnedTypes(), this.getConceptTypeAssertion(), this.getConceptTypeAssertion_OwningInstance(), "ownedTypes", null, 0, -1, ConceptInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationInstanceEClass, RelationInstance.class, "RelationInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationInstance_OwnedTypes(), this.getRelationTypeAssertion(), this.getRelationTypeAssertion_OwningInstance(), "ownedTypes", null, 0, -1, RelationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationInstance_Sources(), this.getNamedInstance(), null, "sources", null, 1, -1, RelationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationInstance_Targets(), this.getNamedInstance(), null, "targets", null, 1, -1, RelationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReference_OwnedAnnotations(), this.getAnnotation(), this.getAnnotation_OwningReference(), "ownedAnnotations", null, 0, -1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specializableTermReferenceEClass, SpecializableTermReference.class, "SpecializableTermReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecializableTermReference_OwnedSpecializations(), this.getSpecializationAxiom(), this.getSpecializationAxiom_OwningReference(), "ownedSpecializations", null, 0, -1, SpecializableTermReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classifierReferenceEClass, ClassifierReference.class, "ClassifierReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierReference_OwnedPropertyRestrictions(), this.getPropertyRestrictionAxiom(), this.getPropertyRestrictionAxiom_OwningReference(), "ownedPropertyRestrictions", null, 0, -1, ClassifierReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityReferenceEClass, EntityReference.class, "EntityReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityReference_OwnedRelationRestrictions(), this.getRelationRestrictionAxiom(), this.getRelationRestrictionAxiom_OwningReference(), "ownedRelationRestrictions", null, 0, -1, EntityReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityReference_OwnedKeys(), this.getKeyAxiom(), this.getKeyAxiom_OwningReference(), "ownedKeys", null, 0, -1, EntityReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aspectReferenceEClass, AspectReference.class, "AspectReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAspectReference_Aspect(), this.getAspect(), null, "aspect", null, 1, 1, AspectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptReferenceEClass, ConceptReference.class, "ConceptReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptReference_Concept(), this.getConcept(), null, "concept", null, 1, 1, ConceptReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationEntityReferenceEClass, RelationEntityReference.class, "RelationEntityReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationEntityReference_Entity(), this.getRelationEntity(), null, "entity", null, 1, 1, RelationEntityReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureReferenceEClass, StructureReference.class, "StructureReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureReference_Structure(), this.getStructure(), null, "structure", null, 1, 1, StructureReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationPropertyReferenceEClass, AnnotationPropertyReference.class, "AnnotationPropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationPropertyReference_Property(), this.getAnnotationProperty(), null, "property", null, 1, 1, AnnotationPropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalarPropertyReferenceEClass, ScalarPropertyReference.class, "ScalarPropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarPropertyReference_Property(), this.getScalarProperty(), null, "property", null, 1, 1, ScalarPropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredPropertyReferenceEClass, StructuredPropertyReference.class, "StructuredPropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredPropertyReference_Property(), this.getStructuredProperty(), null, "property", null, 1, 1, StructuredPropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facetedScalarReferenceEClass, FacetedScalarReference.class, "FacetedScalarReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFacetedScalarReference_Scalar(), this.getFacetedScalar(), null, "scalar", null, 1, 1, FacetedScalarReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumeratedScalarReferenceEClass, EnumeratedScalarReference.class, "EnumeratedScalarReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumeratedScalarReference_Scalar(), this.getEnumeratedScalar(), null, "scalar", null, 1, 1, EnumeratedScalarReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationReferenceEClass, RelationReference.class, "RelationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationReference_Relation(), this.getRelation(), null, "relation", null, 1, 1, RelationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleReferenceEClass, RuleReference.class, "RuleReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleReference_Rule(), this.getRule(), null, "rule", null, 1, 1, RuleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedInstanceReferenceEClass, NamedInstanceReference.class, "NamedInstanceReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedInstanceReference_OwnedPropertyValues(), this.getPropertyValueAssertion(), this.getPropertyValueAssertion_OwningReference(), "ownedPropertyValues", null, 0, -1, NamedInstanceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedInstanceReference_OwnedLinks(), this.getLinkAssertion(), this.getLinkAssertion_OwningReference(), "ownedLinks", null, 0, -1, NamedInstanceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptInstanceReferenceEClass, ConceptInstanceReference.class, "ConceptInstanceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptInstanceReference_Instance(), this.getConceptInstance(), null, "instance", null, 1, 1, ConceptInstanceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptInstanceReference_OwnedTypes(), this.getConceptTypeAssertion(), this.getConceptTypeAssertion_OwningReference(), "ownedTypes", null, 0, -1, ConceptInstanceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationInstanceReferenceEClass, RelationInstanceReference.class, "RelationInstanceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationInstanceReference_Instance(), this.getRelationInstance(), null, "instance", null, 1, 1, RelationInstanceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationInstanceReference_OwnedTypes(), this.getRelationTypeAssertion(), this.getRelationTypeAssertion_OwningReference(), "ownedTypes", null, 0, -1, RelationInstanceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vocabularyStatementEClass, VocabularyStatement.class, "VocabularyStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVocabularyStatement_OwningVocabulary(), this.getVocabulary(), this.getVocabulary_OwnedStatements(), "owningVocabulary", null, 1, 1, VocabularyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionStatementEClass, DescriptionStatement.class, "DescriptionStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionStatement_OwningDescription(), this.getDescription(), this.getDescription_OwnedStatements(), "owningDescription", null, 1, 1, DescriptionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importEClass, Import.class, "Import", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_Namespace(), this.getNamespace(), "namespace", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImport_Prefix(), this.getID(), "prefix", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getImport__GetIri(), theEcorePackage.getEString(), "getIri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getImport__GetSeparator(), this.getSeparatorKind(), "getSeparator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(vocabularyImportEClass, VocabularyImport.class, "VocabularyImport", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVocabularyImport_OwningVocabulary(), this.getVocabulary(), this.getVocabulary_OwnedImports(), "owningVocabulary", null, 1, 1, VocabularyImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vocabularyExtensionEClass, VocabularyExtension.class, "VocabularyExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vocabularyUsageEClass, VocabularyUsage.class, "VocabularyUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vocabularyBundleImportEClass, VocabularyBundleImport.class, "VocabularyBundleImport", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVocabularyBundleImport_OwningVocabularyBundle(), this.getVocabularyBundle(), this.getVocabularyBundle_OwnedImports(), "owningVocabularyBundle", null, 1, 1, VocabularyBundleImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vocabularyBundleExtensionEClass, VocabularyBundleExtension.class, "VocabularyBundleExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vocabularyBundleInclusionEClass, VocabularyBundleInclusion.class, "VocabularyBundleInclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionImportEClass, DescriptionImport.class, "DescriptionImport", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionImport_OwningDescription(), this.getDescription(), this.getDescription_OwnedImports(), "owningDescription", null, 1, 1, DescriptionImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionExtensionEClass, DescriptionExtension.class, "DescriptionExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionUsageEClass, DescriptionUsage.class, "DescriptionUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionBundleImportEClass, DescriptionBundleImport.class, "DescriptionBundleImport", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionBundleImport_OwningDescriptionBundle(), this.getDescriptionBundle(), this.getDescriptionBundle_OwnedImports(), "owningDescriptionBundle", null, 1, 1, DescriptionBundleImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionBundleExtensionEClass, DescriptionBundleExtension.class, "DescriptionBundleExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionBundleInclusionEClass, DescriptionBundleInclusion.class, "DescriptionBundleInclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptionBundleUsageEClass, DescriptionBundleUsage.class, "DescriptionBundleUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(axiomEClass, Axiom.class, "Axiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(specializationAxiomEClass, SpecializationAxiom.class, "SpecializationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecializationAxiom_SpecializedTerm(), this.getSpecializableTerm(), null, "specializedTerm", null, 1, 1, SpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationAxiom_OwningTerm(), this.getSpecializableTerm(), this.getSpecializableTerm_OwnedSpecializations(), "owningTerm", null, 0, 1, SpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationAxiom_OwningReference(), this.getSpecializableTermReference(), this.getSpecializableTermReference_OwnedSpecializations(), "owningReference", null, 0, 1, SpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(restrictionAxiomEClass, RestrictionAxiom.class, "RestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyRestrictionAxiomEClass, PropertyRestrictionAxiom.class, "PropertyRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyRestrictionAxiom_OwningClassifier(), this.getClassifier(), this.getClassifier_OwnedPropertyRestrictions(), "owningClassifier", null, 0, 1, PropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyRestrictionAxiom_OwningReference(), this.getClassifierReference(), this.getClassifierReference_OwnedPropertyRestrictions(), "owningReference", null, 0, 1, PropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalarPropertyRestrictionAxiomEClass, ScalarPropertyRestrictionAxiom.class, "ScalarPropertyRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarPropertyRestrictionAxiom_Property(), this.getScalarProperty(), null, "property", null, 1, 1, ScalarPropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalarPropertyRangeRestrictionAxiomEClass, ScalarPropertyRangeRestrictionAxiom.class, "ScalarPropertyRangeRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarPropertyRangeRestrictionAxiom_Range(), this.getScalar(), null, "range", null, 1, 1, ScalarPropertyRangeRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarPropertyRangeRestrictionAxiom_Kind(), this.getRangeRestrictionKind(), "kind", null, 1, 1, ScalarPropertyRangeRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalarPropertyCardinalityRestrictionAxiomEClass, ScalarPropertyCardinalityRestrictionAxiom.class, "ScalarPropertyCardinalityRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScalarPropertyCardinalityRestrictionAxiom_Cardinality(), this.getUnsignedInt(), "cardinality", "1", 1, 1, ScalarPropertyCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarPropertyCardinalityRestrictionAxiom_Kind(), this.getCardinalityRestrictionKind(), "kind", null, 1, 1, ScalarPropertyCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarPropertyCardinalityRestrictionAxiom_Range(), this.getScalar(), null, "range", null, 0, 1, ScalarPropertyCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalarPropertyValueRestrictionAxiomEClass, ScalarPropertyValueRestrictionAxiom.class, "ScalarPropertyValueRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarPropertyValueRestrictionAxiom_Value(), this.getLiteral(), null, "value", null, 1, 1, ScalarPropertyValueRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredPropertyRestrictionAxiomEClass, StructuredPropertyRestrictionAxiom.class, "StructuredPropertyRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredPropertyRestrictionAxiom_Property(), this.getStructuredProperty(), null, "property", null, 1, 1, StructuredPropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredPropertyRangeRestrictionAxiomEClass, StructuredPropertyRangeRestrictionAxiom.class, "StructuredPropertyRangeRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredPropertyRangeRestrictionAxiom_Range(), this.getStructure(), null, "range", null, 1, 1, StructuredPropertyRangeRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructuredPropertyRangeRestrictionAxiom_Kind(), this.getRangeRestrictionKind(), "kind", null, 1, 1, StructuredPropertyRangeRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredPropertyCardinalityRestrictionAxiomEClass, StructuredPropertyCardinalityRestrictionAxiom.class, "StructuredPropertyCardinalityRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStructuredPropertyCardinalityRestrictionAxiom_Cardinality(), this.getUnsignedInt(), "cardinality", "1", 1, 1, StructuredPropertyCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructuredPropertyCardinalityRestrictionAxiom_Kind(), this.getCardinalityRestrictionKind(), "kind", null, 1, 1, StructuredPropertyCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredPropertyCardinalityRestrictionAxiom_Range(), this.getStructure(), null, "range", null, 0, 1, StructuredPropertyCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredPropertyValueRestrictionAxiomEClass, StructuredPropertyValueRestrictionAxiom.class, "StructuredPropertyValueRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredPropertyValueRestrictionAxiom_Value(), this.getStructureInstance(), this.getStructureInstance_OwningAxiom(), "value", null, 1, 1, StructuredPropertyValueRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationRestrictionAxiomEClass, RelationRestrictionAxiom.class, "RelationRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationRestrictionAxiom_Relation(), this.getRelation(), null, "relation", null, 1, 1, RelationRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationRestrictionAxiom_OwningEntity(), this.getEntity(), this.getEntity_OwnedRelationRestrictions(), "owningEntity", null, 0, 1, RelationRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationRestrictionAxiom_OwningReference(), this.getEntityReference(), this.getEntityReference_OwnedRelationRestrictions(), "owningReference", null, 0, 1, RelationRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationRangeRestrictionAxiomEClass, RelationRangeRestrictionAxiom.class, "RelationRangeRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationRangeRestrictionAxiom_Range(), this.getEntity(), null, "range", null, 1, 1, RelationRangeRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationRangeRestrictionAxiom_Kind(), this.getRangeRestrictionKind(), "kind", null, 1, 1, RelationRangeRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationCardinalityRestrictionAxiomEClass, RelationCardinalityRestrictionAxiom.class, "RelationCardinalityRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationCardinalityRestrictionAxiom_Cardinality(), this.getUnsignedInt(), "cardinality", "1", 1, 1, RelationCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationCardinalityRestrictionAxiom_Kind(), this.getCardinalityRestrictionKind(), "kind", null, 1, 1, RelationCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCardinalityRestrictionAxiom_Range(), this.getEntity(), null, "range", null, 0, 1, RelationCardinalityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationTargetRestrictionAxiomEClass, RelationTargetRestrictionAxiom.class, "RelationTargetRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationTargetRestrictionAxiom_Target(), this.getNamedInstance(), null, "target", null, 1, 1, RelationTargetRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyAxiomEClass, KeyAxiom.class, "KeyAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyAxiom_Properties(), this.getFeature(), null, "properties", null, 1, -1, KeyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyAxiom_OwningEntity(), this.getEntity(), this.getEntity_OwnedKeys(), "owningEntity", null, 0, 1, KeyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyAxiom_OwningReference(), this.getEntityReference(), this.getEntityReference_OwnedKeys(), "owningReference", null, 0, 1, KeyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertionEClass, Assertion.class, "Assertion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeAssertionEClass, TypeAssertion.class, "TypeAssertion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTypeAssertion__GetType(), this.getEntity(), "getType", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptTypeAssertionEClass, ConceptTypeAssertion.class, "ConceptTypeAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptTypeAssertion_Type(), this.getConcept(), null, "type", null, 1, 1, ConceptTypeAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptTypeAssertion_OwningInstance(), this.getConceptInstance(), this.getConceptInstance_OwnedTypes(), "owningInstance", null, 0, 1, ConceptTypeAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptTypeAssertion_OwningReference(), this.getConceptInstanceReference(), this.getConceptInstanceReference_OwnedTypes(), "owningReference", null, 0, 1, ConceptTypeAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationTypeAssertionEClass, RelationTypeAssertion.class, "RelationTypeAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationTypeAssertion_Type(), this.getRelationEntity(), null, "type", null, 1, 1, RelationTypeAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationTypeAssertion_OwningInstance(), this.getRelationInstance(), this.getRelationInstance_OwnedTypes(), "owningInstance", null, 0, 1, RelationTypeAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationTypeAssertion_OwningReference(), this.getRelationInstanceReference(), this.getRelationInstanceReference_OwnedTypes(), "owningReference", null, 0, 1, RelationTypeAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyValueAssertionEClass, PropertyValueAssertion.class, "PropertyValueAssertion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyValueAssertion_OwningInstance(), this.getInstance(), this.getInstance_OwnedPropertyValues(), "owningInstance", null, 0, 1, PropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyValueAssertion_OwningReference(), this.getNamedInstanceReference(), this.getNamedInstanceReference_OwnedPropertyValues(), "owningReference", null, 0, 1, PropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPropertyValueAssertion__GetProperty(), this.getSemanticProperty(), "getProperty", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getPropertyValueAssertion__GetValue(), this.getElement(), "getValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(scalarPropertyValueAssertionEClass, ScalarPropertyValueAssertion.class, "ScalarPropertyValueAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarPropertyValueAssertion_Property(), this.getScalarProperty(), null, "property", null, 1, 1, ScalarPropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarPropertyValueAssertion_Value(), this.getLiteral(), null, "value", null, 1, 1, ScalarPropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredPropertyValueAssertionEClass, StructuredPropertyValueAssertion.class, "StructuredPropertyValueAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredPropertyValueAssertion_Property(), this.getStructuredProperty(), null, "property", null, 1, 1, StructuredPropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredPropertyValueAssertion_Value(), this.getStructureInstance(), this.getStructureInstance_OwningAssertion(), "value", null, 1, 1, StructuredPropertyValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkAssertionEClass, LinkAssertion.class, "LinkAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkAssertion_Relation(), this.getRelation(), null, "relation", null, 1, 1, LinkAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkAssertion_Target(), this.getNamedInstance(), null, "target", null, 1, 1, LinkAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkAssertion_OwningInstance(), this.getNamedInstance(), this.getNamedInstance_OwnedLinks(), "owningInstance", null, 0, 1, LinkAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkAssertion_OwningReference(), this.getNamedInstanceReference(), this.getNamedInstanceReference_OwnedLinks(), "owningReference", null, 0, 1, LinkAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(predicateEClass, Predicate.class, "Predicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredicate_AntecedentRule(), this.getRule(), this.getRule_Antecedent(), "antecedentRule", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_ConsequentRule(), this.getRule(), this.getRule_Consequent(), "consequentRule", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryPredicateEClass, UnaryPredicate.class, "UnaryPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryPredicate_Variable(), this.getID(), "variable", null, 1, 1, UnaryPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typePredicateEClass, TypePredicate.class, "TypePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypePredicate_Type(), this.getType(), null, "type", null, 1, 1, TypePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryPredicateEClass, BinaryPredicate.class, "BinaryPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryPredicate_Variable1(), this.getID(), "variable1", null, 1, 1, BinaryPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryPredicate_Variable2(), this.getID(), "variable2", null, 0, 1, BinaryPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryPredicate_Instance2(), this.getNamedInstance(), null, "instance2", null, 0, 1, BinaryPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationEntityPredicateEClass, RelationEntityPredicate.class, "RelationEntityPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationEntityPredicate_Entity(), this.getRelationEntity(), null, "entity", null, 1, 1, RelationEntityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationEntityPredicate_EntityVariable(), this.getID(), "entityVariable", null, 1, 1, RelationEntityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featurePredicateEClass, FeaturePredicate.class, "FeaturePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeaturePredicate_Feature(), this.getFeature(), null, "feature", null, 1, 1, FeaturePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeaturePredicate_Literal2(), this.getLiteral(), null, "literal2", null, 0, 1, FeaturePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sameAsPredicateEClass, SameAsPredicate.class, "SameAsPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(differentFromPredicateEClass, DifferentFromPredicate.class, "DifferentFromPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(quotedLiteralEClass, QuotedLiteral.class, "QuotedLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuotedLiteral_Value(), theEcorePackage.getEString(), "value", null, 1, 1, QuotedLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuotedLiteral_LangTag(), theEcorePackage.getEString(), "langTag", null, 0, 1, QuotedLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuotedLiteral_Type(), this.getScalar(), null, "type", null, 0, 1, QuotedLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteral_Value(), theEcorePackage.getEInt(), "value", null, 0, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decimalLiteralEClass, DecimalLiteral.class, "DecimalLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDecimalLiteral_Value(), this.getDecimal(), "value", null, 1, 1, DecimalLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleLiteralEClass, DoubleLiteral.class, "DoubleLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleLiteral_Value(), theEcorePackage.getEDouble(), "value", null, 0, 1, DoubleLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteral_Value(), theEcorePackage.getEBoolean(), "value", null, 0, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(separatorKindEEnum, SeparatorKind.class, "SeparatorKind");
		addEEnumLiteral(separatorKindEEnum, SeparatorKind.HASH);
		addEEnumLiteral(separatorKindEEnum, SeparatorKind.SLASH);

		initEEnum(rangeRestrictionKindEEnum, RangeRestrictionKind.class, "RangeRestrictionKind");
		addEEnumLiteral(rangeRestrictionKindEEnum, RangeRestrictionKind.ALL);
		addEEnumLiteral(rangeRestrictionKindEEnum, RangeRestrictionKind.SOME);

		initEEnum(cardinalityRestrictionKindEEnum, CardinalityRestrictionKind.class, "CardinalityRestrictionKind");
		addEEnumLiteral(cardinalityRestrictionKindEEnum, CardinalityRestrictionKind.EXACTLY);
		addEEnumLiteral(cardinalityRestrictionKindEEnum, CardinalityRestrictionKind.MIN);
		addEEnumLiteral(cardinalityRestrictionKindEEnum, CardinalityRestrictionKind.MAX);

		// Initialize data types
		initEDataType(unsignedIntEDataType, long.class, "UnsignedInt", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(unsignedIntegerEDataType, Long.class, "UnsignedInteger", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(decimalEDataType, BigDecimal.class, "Decimal", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(idEDataType, String.class, "ID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(namespaceEDataType, String.class, "Namespace", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// https://tabatkins.github.io/bikeshed/headings
		createHeadingsAnnotations();
		// https://tabatkins.github.io/bikeshed
		createBikeshedAnnotations();
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
		// https://opencaesar.io/oml/Ecore
		createEcoreAnnotations();
		// https://www.eclipse.org/emf/2002/Ecore
		createEcore_1Annotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>https://tabatkins.github.io/bikeshed/headings</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createHeadingsAnnotations() {
		String source = "https://tabatkins.github.io/bikeshed/headings";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "Elements", "",
			   "Literals", "",
			   "Ontologies", "",
			   "Vocabularies", "",
			   "Types", "",
			   "Features", "",
			   "Rules", "",
			   "Axioms", "",
			   "Descriptions", "",
			   "Instances", "",
			   "Assertions", "",
			   "References", ""
		   });
	}

	/**
	 * Initializes the annotations for <b>https://tabatkins.github.io/bikeshed</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createBikeshedAnnotations() {
		String source = "https://tabatkins.github.io/bikeshed";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "heading", "Abstract-Syntax"
		   });
		addAnnotation
		  (elementEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (annotationEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (annotatedElementEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (identifiedElementEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (ontologyEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (vocabularyBoxEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (vocabularyEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (vocabularyBundleEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (descriptionBoxEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (descriptionEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (descriptionBundleEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (memberEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (termEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (specializableTermEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (typeEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (classifierEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (entityEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (aspectEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (conceptEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (relationEntityEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (structureEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (featureEClass,
		   source,
		   new String[] {
			   "heading", "Features"
		   });
		addAnnotation
		  (propertyEClass,
		   source,
		   new String[] {
			   "heading", "Features"
		   });
		addAnnotation
		  (annotationPropertyEClass,
		   source,
		   new String[] {
			   "heading", "Features"
		   });
		addAnnotation
		  (semanticPropertyEClass,
		   source,
		   new String[] {
			   "heading", "Features"
		   });
		addAnnotation
		  (scalarPropertyEClass,
		   source,
		   new String[] {
			   "heading", "Features"
		   });
		addAnnotation
		  (structuredPropertyEClass,
		   source,
		   new String[] {
			   "heading", "Features"
		   });
		addAnnotation
		  (scalarEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (facetedScalarEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (enumeratedScalarEClass,
		   source,
		   new String[] {
			   "heading", "Types"
		   });
		addAnnotation
		  (relationEClass,
		   source,
		   new String[] {
			   "heading", "Features"
		   });
		addAnnotation
		  (forwardRelationEClass,
		   source,
		   new String[] {
			   "heading", "Features"
		   });
		addAnnotation
		  (reverseRelationEClass,
		   source,
		   new String[] {
			   "heading", "Features"
		   });
		addAnnotation
		  (ruleEClass,
		   source,
		   new String[] {
			   "heading", "Rules"
		   });
		addAnnotation
		  (instanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (structureInstanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (namedInstanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (conceptInstanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (relationInstanceEClass,
		   source,
		   new String[] {
			   "heading", "Instances"
		   });
		addAnnotation
		  (referenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (specializableTermReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (classifierReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (entityReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (aspectReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (conceptReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (relationEntityReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (structureReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (annotationPropertyReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (scalarPropertyReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (structuredPropertyReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (facetedScalarReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (enumeratedScalarReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (relationReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (ruleReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (namedInstanceReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (conceptInstanceReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (relationInstanceReferenceEClass,
		   source,
		   new String[] {
			   "heading", "References"
		   });
		addAnnotation
		  (statementEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (vocabularyStatementEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (descriptionStatementEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (importEClass,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (vocabularyImportEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (vocabularyExtensionEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (vocabularyUsageEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (vocabularyBundleImportEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (vocabularyBundleExtensionEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (vocabularyBundleInclusionEClass,
		   source,
		   new String[] {
			   "heading", "Vocabularies"
		   });
		addAnnotation
		  (descriptionImportEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (descriptionExtensionEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (descriptionUsageEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (descriptionBundleImportEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (descriptionBundleExtensionEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (descriptionBundleInclusionEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (descriptionBundleUsageEClass,
		   source,
		   new String[] {
			   "heading", "Descriptions"
		   });
		addAnnotation
		  (axiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (specializationAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (restrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (propertyRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (scalarPropertyRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (scalarPropertyRangeRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (scalarPropertyCardinalityRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (scalarPropertyValueRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (structuredPropertyRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (structuredPropertyRangeRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (structuredPropertyCardinalityRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (structuredPropertyValueRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (relationRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (relationRangeRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (relationCardinalityRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (relationTargetRestrictionAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (keyAxiomEClass,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (assertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (typeAssertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (conceptTypeAssertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (relationTypeAssertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (propertyValueAssertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (scalarPropertyValueAssertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (structuredPropertyValueAssertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (linkAssertionEClass,
		   source,
		   new String[] {
			   "heading", "Assertions"
		   });
		addAnnotation
		  (predicateEClass,
		   source,
		   new String[] {
			   "heading", "Rules"
		   });
		addAnnotation
		  (unaryPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Rules"
		   });
		addAnnotation
		  (typePredicateEClass,
		   source,
		   new String[] {
			   "heading", "Rules"
		   });
		addAnnotation
		  (binaryPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Rules"
		   });
		addAnnotation
		  (relationEntityPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Rules"
		   });
		addAnnotation
		  (featurePredicateEClass,
		   source,
		   new String[] {
			   "heading", "Rules"
		   });
		addAnnotation
		  (sameAsPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Rules"
		   });
		addAnnotation
		  (differentFromPredicateEClass,
		   source,
		   new String[] {
			   "heading", "Rules"
		   });
		addAnnotation
		  (literalEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (quotedLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (integerLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (decimalLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (doubleLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (booleanLiteralEClass,
		   source,
		   new String[] {
			   "heading", "Literals"
		   });
		addAnnotation
		  (separatorKindEEnum,
		   source,
		   new String[] {
			   "heading", "Elements"
		   });
		addAnnotation
		  (rangeRestrictionKindEEnum,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
		addAnnotation
		  (cardinalityRestrictionKindEEnum,
		   source,
		   new String[] {
			   "heading", "Axioms"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2011/Xcore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "Bikeshed", "https://tabatkins.github.io/bikeshed",
			   "BikeshedHeadings", "https://tabatkins.github.io/bikeshed/headings",
			   "Ecore", "https://www.eclipse.org/emf/2002/Ecore",
			   "OmlEcore", "https://opencaesar.io/oml/Ecore"
		   });
	}

	/**
	 * Initializes the annotations for <b>https://opencaesar.io/oml/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "https://opencaesar.io/oml/Ecore";
		addAnnotation
		  (getOntology_Namespace(),
		   source,
		   new String[] {
			   "identifier", "true"
		   });
		addAnnotation
		  (getOntology_Prefix(),
		   source,
		   new String[] {
			   "identifier", "true"
		   });
	}

	/**
	 * Initializes the annotations for <b>https://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcore_1Annotations() {
		String source = "https://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (getSemanticProperty__IsFunctional(),
		   source,
		   new String[] {
			   "getterOf", "functional"
		   });
		addAnnotation
		  (getSemanticProperty__GetDomain(),
		   source,
		   new String[] {
			   "getterOf", "domain"
		   });
		addAnnotation
		  (getSemanticProperty__GetRange(),
		   source,
		   new String[] {
			   "getterOf", "range"
		   });
		addAnnotation
		  (getRelation__GetRelationEntity(),
		   source,
		   new String[] {
			   "getterOf", "relationEntity"
		   });
		addAnnotation
		  (getTypeAssertion__GetType(),
		   source,
		   new String[] {
			   "getterOf", "type"
		   });
		addAnnotation
		  (getPropertyValueAssertion__GetProperty(),
		   source,
		   new String[] {
			   "getterOf", "property"
		   });
		addAnnotation
		  (getPropertyValueAssertion__GetValue(),
		   source,
		   new String[] {
			   "getterOf", "value"
		   });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (unsignedIntEDataType,
		   source,
		   new String[] {
			   "minInclusive", "0",
			   "maxInclusive", "4294967295"
		   });
		addAnnotation
		  (unsignedIntegerEDataType,
		   source,
		   new String[] {
			   "minInclusive", "0",
			   "maxInclusive", "4294967295"
		   });
		addAnnotation
		  (decimalEDataType,
		   source,
		   new String[] {
			   "baseType", "http://www.w3.org/2001/XMLSchema#decimal"
		   });
		addAnnotation
		  (idEDataType,
		   source,
		   new String[] {
			   "pattern", "[a-zA-Z0-9_]([a-zA-Z0-9_\\-.$])*"
		   });
		addAnnotation
		  (namespaceEDataType,
		   source,
		   new String[] {
			   "pattern", "([^\\s#])*(#|/)",
			   "minLength", "2"
		   });
	}

} //OmlPackageImpl
