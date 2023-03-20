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
package io.opencaesar.oml.util;

import io.opencaesar.oml.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see io.opencaesar.oml.OmlPackage
 * @generated
 */
public class OmlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OmlSwitch() {
		if (modelPackage == null) {
			modelPackage = OmlPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OmlPackage.ELEMENT: {
				Element element = (Element)theEObject;
				T result = caseElement(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = caseElement(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.IDENTIFIED_ELEMENT: {
				IdentifiedElement identifiedElement = (IdentifiedElement)theEObject;
				T result = caseIdentifiedElement(identifiedElement);
				if (result == null) result = caseElement(identifiedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.IMPORT: {
				Import import_ = (Import)theEObject;
				T result = caseImport(import_);
				if (result == null) result = caseElement(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.INSTANCE: {
				Instance instance = (Instance)theEObject;
				T result = caseInstance(instance);
				if (result == null) result = caseElement(instance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.AXIOM: {
				Axiom axiom = (Axiom)theEObject;
				T result = caseAxiom(axiom);
				if (result == null) result = caseElement(axiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ASSERTION: {
				Assertion assertion = (Assertion)theEObject;
				T result = caseAssertion(assertion);
				if (result == null) result = caseElement(assertion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PREDICATE: {
				Predicate predicate = (Predicate)theEObject;
				T result = casePredicate(predicate);
				if (result == null) result = caseElement(predicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ARGUMENT: {
				Argument argument = (Argument)theEObject;
				T result = caseArgument(argument);
				if (result == null) result = caseElement(argument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = caseElement(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ONTOLOGY: {
				Ontology ontology = (Ontology)theEObject;
				T result = caseOntology(ontology);
				if (result == null) result = caseIdentifiedElement(ontology);
				if (result == null) result = caseElement(ontology);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.MEMBER: {
				Member member = (Member)theEObject;
				T result = caseMember(member);
				if (result == null) result = caseIdentifiedElement(member);
				if (result == null) result = caseElement(member);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_BOX: {
				VocabularyBox vocabularyBox = (VocabularyBox)theEObject;
				T result = caseVocabularyBox(vocabularyBox);
				if (result == null) result = caseOntology(vocabularyBox);
				if (result == null) result = caseIdentifiedElement(vocabularyBox);
				if (result == null) result = caseElement(vocabularyBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_BOX: {
				DescriptionBox descriptionBox = (DescriptionBox)theEObject;
				T result = caseDescriptionBox(descriptionBox);
				if (result == null) result = caseOntology(descriptionBox);
				if (result == null) result = caseIdentifiedElement(descriptionBox);
				if (result == null) result = caseElement(descriptionBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY: {
				Vocabulary vocabulary = (Vocabulary)theEObject;
				T result = caseVocabulary(vocabulary);
				if (result == null) result = caseVocabularyBox(vocabulary);
				if (result == null) result = caseOntology(vocabulary);
				if (result == null) result = caseIdentifiedElement(vocabulary);
				if (result == null) result = caseElement(vocabulary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_BUNDLE: {
				VocabularyBundle vocabularyBundle = (VocabularyBundle)theEObject;
				T result = caseVocabularyBundle(vocabularyBundle);
				if (result == null) result = caseVocabularyBox(vocabularyBundle);
				if (result == null) result = caseOntology(vocabularyBundle);
				if (result == null) result = caseIdentifiedElement(vocabularyBundle);
				if (result == null) result = caseElement(vocabularyBundle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION: {
				Description description = (Description)theEObject;
				T result = caseDescription(description);
				if (result == null) result = caseDescriptionBox(description);
				if (result == null) result = caseOntology(description);
				if (result == null) result = caseIdentifiedElement(description);
				if (result == null) result = caseElement(description);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_BUNDLE: {
				DescriptionBundle descriptionBundle = (DescriptionBundle)theEObject;
				T result = caseDescriptionBundle(descriptionBundle);
				if (result == null) result = caseDescriptionBox(descriptionBundle);
				if (result == null) result = caseOntology(descriptionBundle);
				if (result == null) result = caseIdentifiedElement(descriptionBundle);
				if (result == null) result = caseElement(descriptionBundle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = caseMember(statement);
				if (result == null) result = caseIdentifiedElement(statement);
				if (result == null) result = caseElement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_MEMBER: {
				VocabularyMember vocabularyMember = (VocabularyMember)theEObject;
				T result = caseVocabularyMember(vocabularyMember);
				if (result == null) result = caseMember(vocabularyMember);
				if (result == null) result = caseIdentifiedElement(vocabularyMember);
				if (result == null) result = caseElement(vocabularyMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_MEMBER: {
				DescriptionMember descriptionMember = (DescriptionMember)theEObject;
				T result = caseDescriptionMember(descriptionMember);
				if (result == null) result = caseMember(descriptionMember);
				if (result == null) result = caseIdentifiedElement(descriptionMember);
				if (result == null) result = caseElement(descriptionMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_STATEMENT: {
				VocabularyStatement vocabularyStatement = (VocabularyStatement)theEObject;
				T result = caseVocabularyStatement(vocabularyStatement);
				if (result == null) result = caseStatement(vocabularyStatement);
				if (result == null) result = caseVocabularyMember(vocabularyStatement);
				if (result == null) result = caseMember(vocabularyStatement);
				if (result == null) result = caseIdentifiedElement(vocabularyStatement);
				if (result == null) result = caseElement(vocabularyStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_STATEMENT: {
				DescriptionStatement descriptionStatement = (DescriptionStatement)theEObject;
				T result = caseDescriptionStatement(descriptionStatement);
				if (result == null) result = caseStatement(descriptionStatement);
				if (result == null) result = caseDescriptionMember(descriptionStatement);
				if (result == null) result = caseMember(descriptionStatement);
				if (result == null) result = caseIdentifiedElement(descriptionStatement);
				if (result == null) result = caseElement(descriptionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.TERM: {
				Term term = (Term)theEObject;
				T result = caseTerm(term);
				if (result == null) result = caseVocabularyMember(term);
				if (result == null) result = caseMember(term);
				if (result == null) result = caseIdentifiedElement(term);
				if (result == null) result = caseElement(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseVocabularyStatement(rule);
				if (result == null) result = caseStatement(rule);
				if (result == null) result = caseVocabularyMember(rule);
				if (result == null) result = caseMember(rule);
				if (result == null) result = caseIdentifiedElement(rule);
				if (result == null) result = caseElement(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.BUILT_IN: {
				BuiltIn builtIn = (BuiltIn)theEObject;
				T result = caseBuiltIn(builtIn);
				if (result == null) result = caseVocabularyStatement(builtIn);
				if (result == null) result = caseStatement(builtIn);
				if (result == null) result = caseVocabularyMember(builtIn);
				if (result == null) result = caseMember(builtIn);
				if (result == null) result = caseIdentifiedElement(builtIn);
				if (result == null) result = caseElement(builtIn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SPECIALIZABLE_TERM: {
				SpecializableTerm specializableTerm = (SpecializableTerm)theEObject;
				T result = caseSpecializableTerm(specializableTerm);
				if (result == null) result = caseTerm(specializableTerm);
				if (result == null) result = caseVocabularyStatement(specializableTerm);
				if (result == null) result = caseVocabularyMember(specializableTerm);
				if (result == null) result = caseStatement(specializableTerm);
				if (result == null) result = caseMember(specializableTerm);
				if (result == null) result = caseIdentifiedElement(specializableTerm);
				if (result == null) result = caseElement(specializableTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseTerm(property);
				if (result == null) result = caseVocabularyMember(property);
				if (result == null) result = caseMember(property);
				if (result == null) result = caseIdentifiedElement(property);
				if (result == null) result = caseElement(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseSpecializableTerm(type);
				if (result == null) result = caseTerm(type);
				if (result == null) result = caseVocabularyStatement(type);
				if (result == null) result = caseVocabularyMember(type);
				if (result == null) result = caseStatement(type);
				if (result == null) result = caseMember(type);
				if (result == null) result = caseIdentifiedElement(type);
				if (result == null) result = caseElement(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_BASE: {
				RelationBase relationBase = (RelationBase)theEObject;
				T result = caseRelationBase(relationBase);
				if (result == null) result = caseSpecializableTerm(relationBase);
				if (result == null) result = caseTerm(relationBase);
				if (result == null) result = caseVocabularyStatement(relationBase);
				if (result == null) result = caseVocabularyMember(relationBase);
				if (result == null) result = caseStatement(relationBase);
				if (result == null) result = caseMember(relationBase);
				if (result == null) result = caseIdentifiedElement(relationBase);
				if (result == null) result = caseElement(relationBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SPECIALIZABLE_PROPERTY: {
				SpecializableProperty specializableProperty = (SpecializableProperty)theEObject;
				T result = caseSpecializableProperty(specializableProperty);
				if (result == null) result = caseSpecializableTerm(specializableProperty);
				if (result == null) result = caseProperty(specializableProperty);
				if (result == null) result = caseTerm(specializableProperty);
				if (result == null) result = caseVocabularyStatement(specializableProperty);
				if (result == null) result = caseVocabularyMember(specializableProperty);
				if (result == null) result = caseStatement(specializableProperty);
				if (result == null) result = caseMember(specializableProperty);
				if (result == null) result = caseIdentifiedElement(specializableProperty);
				if (result == null) result = caseElement(specializableProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.CLASSIFIER: {
				Classifier classifier = (Classifier)theEObject;
				T result = caseClassifier(classifier);
				if (result == null) result = caseType(classifier);
				if (result == null) result = caseSpecializableTerm(classifier);
				if (result == null) result = caseTerm(classifier);
				if (result == null) result = caseVocabularyStatement(classifier);
				if (result == null) result = caseVocabularyMember(classifier);
				if (result == null) result = caseStatement(classifier);
				if (result == null) result = caseMember(classifier);
				if (result == null) result = caseIdentifiedElement(classifier);
				if (result == null) result = caseElement(classifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SCALAR: {
				Scalar scalar = (Scalar)theEObject;
				T result = caseScalar(scalar);
				if (result == null) result = caseType(scalar);
				if (result == null) result = caseSpecializableTerm(scalar);
				if (result == null) result = caseTerm(scalar);
				if (result == null) result = caseVocabularyStatement(scalar);
				if (result == null) result = caseVocabularyMember(scalar);
				if (result == null) result = caseStatement(scalar);
				if (result == null) result = caseMember(scalar);
				if (result == null) result = caseIdentifiedElement(scalar);
				if (result == null) result = caseElement(scalar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ENTITY: {
				Entity entity = (Entity)theEObject;
				T result = caseEntity(entity);
				if (result == null) result = caseClassifier(entity);
				if (result == null) result = caseType(entity);
				if (result == null) result = caseSpecializableTerm(entity);
				if (result == null) result = caseTerm(entity);
				if (result == null) result = caseVocabularyStatement(entity);
				if (result == null) result = caseVocabularyMember(entity);
				if (result == null) result = caseStatement(entity);
				if (result == null) result = caseMember(entity);
				if (result == null) result = caseIdentifiedElement(entity);
				if (result == null) result = caseElement(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURE: {
				Structure structure = (Structure)theEObject;
				T result = caseStructure(structure);
				if (result == null) result = caseClassifier(structure);
				if (result == null) result = caseType(structure);
				if (result == null) result = caseSpecializableTerm(structure);
				if (result == null) result = caseTerm(structure);
				if (result == null) result = caseVocabularyStatement(structure);
				if (result == null) result = caseVocabularyMember(structure);
				if (result == null) result = caseStatement(structure);
				if (result == null) result = caseMember(structure);
				if (result == null) result = caseIdentifiedElement(structure);
				if (result == null) result = caseElement(structure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ASPECT: {
				Aspect aspect = (Aspect)theEObject;
				T result = caseAspect(aspect);
				if (result == null) result = caseEntity(aspect);
				if (result == null) result = caseClassifier(aspect);
				if (result == null) result = caseType(aspect);
				if (result == null) result = caseSpecializableTerm(aspect);
				if (result == null) result = caseTerm(aspect);
				if (result == null) result = caseVocabularyStatement(aspect);
				if (result == null) result = caseVocabularyMember(aspect);
				if (result == null) result = caseStatement(aspect);
				if (result == null) result = caseMember(aspect);
				if (result == null) result = caseIdentifiedElement(aspect);
				if (result == null) result = caseElement(aspect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.CONCEPT: {
				Concept concept = (Concept)theEObject;
				T result = caseConcept(concept);
				if (result == null) result = caseEntity(concept);
				if (result == null) result = caseClassifier(concept);
				if (result == null) result = caseType(concept);
				if (result == null) result = caseSpecializableTerm(concept);
				if (result == null) result = caseTerm(concept);
				if (result == null) result = caseVocabularyStatement(concept);
				if (result == null) result = caseVocabularyMember(concept);
				if (result == null) result = caseStatement(concept);
				if (result == null) result = caseMember(concept);
				if (result == null) result = caseIdentifiedElement(concept);
				if (result == null) result = caseElement(concept);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_ENTITY: {
				RelationEntity relationEntity = (RelationEntity)theEObject;
				T result = caseRelationEntity(relationEntity);
				if (result == null) result = caseEntity(relationEntity);
				if (result == null) result = caseRelationBase(relationEntity);
				if (result == null) result = caseClassifier(relationEntity);
				if (result == null) result = caseType(relationEntity);
				if (result == null) result = caseSpecializableTerm(relationEntity);
				if (result == null) result = caseTerm(relationEntity);
				if (result == null) result = caseVocabularyStatement(relationEntity);
				if (result == null) result = caseVocabularyMember(relationEntity);
				if (result == null) result = caseStatement(relationEntity);
				if (result == null) result = caseMember(relationEntity);
				if (result == null) result = caseIdentifiedElement(relationEntity);
				if (result == null) result = caseElement(relationEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ANNOTATION_PROPERTY: {
				AnnotationProperty annotationProperty = (AnnotationProperty)theEObject;
				T result = caseAnnotationProperty(annotationProperty);
				if (result == null) result = caseSpecializableProperty(annotationProperty);
				if (result == null) result = caseSpecializableTerm(annotationProperty);
				if (result == null) result = caseProperty(annotationProperty);
				if (result == null) result = caseTerm(annotationProperty);
				if (result == null) result = caseVocabularyStatement(annotationProperty);
				if (result == null) result = caseVocabularyMember(annotationProperty);
				if (result == null) result = caseStatement(annotationProperty);
				if (result == null) result = caseMember(annotationProperty);
				if (result == null) result = caseIdentifiedElement(annotationProperty);
				if (result == null) result = caseElement(annotationProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SEMANTIC_PROPERTY: {
				SemanticProperty semanticProperty = (SemanticProperty)theEObject;
				T result = caseSemanticProperty(semanticProperty);
				if (result == null) result = caseProperty(semanticProperty);
				if (result == null) result = caseTerm(semanticProperty);
				if (result == null) result = caseVocabularyMember(semanticProperty);
				if (result == null) result = caseMember(semanticProperty);
				if (result == null) result = caseIdentifiedElement(semanticProperty);
				if (result == null) result = caseElement(semanticProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SCALAR_PROPERTY: {
				ScalarProperty scalarProperty = (ScalarProperty)theEObject;
				T result = caseScalarProperty(scalarProperty);
				if (result == null) result = caseSemanticProperty(scalarProperty);
				if (result == null) result = caseSpecializableProperty(scalarProperty);
				if (result == null) result = caseProperty(scalarProperty);
				if (result == null) result = caseSpecializableTerm(scalarProperty);
				if (result == null) result = caseTerm(scalarProperty);
				if (result == null) result = caseVocabularyStatement(scalarProperty);
				if (result == null) result = caseVocabularyMember(scalarProperty);
				if (result == null) result = caseStatement(scalarProperty);
				if (result == null) result = caseMember(scalarProperty);
				if (result == null) result = caseIdentifiedElement(scalarProperty);
				if (result == null) result = caseElement(scalarProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURED_PROPERTY: {
				StructuredProperty structuredProperty = (StructuredProperty)theEObject;
				T result = caseStructuredProperty(structuredProperty);
				if (result == null) result = caseSemanticProperty(structuredProperty);
				if (result == null) result = caseSpecializableProperty(structuredProperty);
				if (result == null) result = caseProperty(structuredProperty);
				if (result == null) result = caseSpecializableTerm(structuredProperty);
				if (result == null) result = caseTerm(structuredProperty);
				if (result == null) result = caseVocabularyStatement(structuredProperty);
				if (result == null) result = caseVocabularyMember(structuredProperty);
				if (result == null) result = caseStatement(structuredProperty);
				if (result == null) result = caseMember(structuredProperty);
				if (result == null) result = caseIdentifiedElement(structuredProperty);
				if (result == null) result = caseElement(structuredProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION: {
				Relation relation = (Relation)theEObject;
				T result = caseRelation(relation);
				if (result == null) result = caseSemanticProperty(relation);
				if (result == null) result = caseProperty(relation);
				if (result == null) result = caseTerm(relation);
				if (result == null) result = caseVocabularyMember(relation);
				if (result == null) result = caseMember(relation);
				if (result == null) result = caseIdentifiedElement(relation);
				if (result == null) result = caseElement(relation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.FORWARD_RELATION: {
				ForwardRelation forwardRelation = (ForwardRelation)theEObject;
				T result = caseForwardRelation(forwardRelation);
				if (result == null) result = caseRelation(forwardRelation);
				if (result == null) result = caseSemanticProperty(forwardRelation);
				if (result == null) result = caseProperty(forwardRelation);
				if (result == null) result = caseTerm(forwardRelation);
				if (result == null) result = caseVocabularyMember(forwardRelation);
				if (result == null) result = caseMember(forwardRelation);
				if (result == null) result = caseIdentifiedElement(forwardRelation);
				if (result == null) result = caseElement(forwardRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.REVERSE_RELATION: {
				ReverseRelation reverseRelation = (ReverseRelation)theEObject;
				T result = caseReverseRelation(reverseRelation);
				if (result == null) result = caseRelation(reverseRelation);
				if (result == null) result = caseSemanticProperty(reverseRelation);
				if (result == null) result = caseProperty(reverseRelation);
				if (result == null) result = caseTerm(reverseRelation);
				if (result == null) result = caseVocabularyMember(reverseRelation);
				if (result == null) result = caseMember(reverseRelation);
				if (result == null) result = caseIdentifiedElement(reverseRelation);
				if (result == null) result = caseElement(reverseRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.UNREIFIED_RELATION: {
				UnreifiedRelation unreifiedRelation = (UnreifiedRelation)theEObject;
				T result = caseUnreifiedRelation(unreifiedRelation);
				if (result == null) result = caseRelation(unreifiedRelation);
				if (result == null) result = caseRelationBase(unreifiedRelation);
				if (result == null) result = caseSpecializableProperty(unreifiedRelation);
				if (result == null) result = caseSemanticProperty(unreifiedRelation);
				if (result == null) result = caseSpecializableTerm(unreifiedRelation);
				if (result == null) result = caseProperty(unreifiedRelation);
				if (result == null) result = caseVocabularyStatement(unreifiedRelation);
				if (result == null) result = caseTerm(unreifiedRelation);
				if (result == null) result = caseStatement(unreifiedRelation);
				if (result == null) result = caseVocabularyMember(unreifiedRelation);
				if (result == null) result = caseMember(unreifiedRelation);
				if (result == null) result = caseIdentifiedElement(unreifiedRelation);
				if (result == null) result = caseElement(unreifiedRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.NAMED_INSTANCE: {
				NamedInstance namedInstance = (NamedInstance)theEObject;
				T result = caseNamedInstance(namedInstance);
				if (result == null) result = caseDescriptionStatement(namedInstance);
				if (result == null) result = caseInstance(namedInstance);
				if (result == null) result = caseStatement(namedInstance);
				if (result == null) result = caseDescriptionMember(namedInstance);
				if (result == null) result = caseMember(namedInstance);
				if (result == null) result = caseIdentifiedElement(namedInstance);
				if (result == null) result = caseElement(namedInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.CONCEPT_INSTANCE: {
				ConceptInstance conceptInstance = (ConceptInstance)theEObject;
				T result = caseConceptInstance(conceptInstance);
				if (result == null) result = caseNamedInstance(conceptInstance);
				if (result == null) result = caseDescriptionStatement(conceptInstance);
				if (result == null) result = caseInstance(conceptInstance);
				if (result == null) result = caseStatement(conceptInstance);
				if (result == null) result = caseDescriptionMember(conceptInstance);
				if (result == null) result = caseMember(conceptInstance);
				if (result == null) result = caseIdentifiedElement(conceptInstance);
				if (result == null) result = caseElement(conceptInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_INSTANCE: {
				RelationInstance relationInstance = (RelationInstance)theEObject;
				T result = caseRelationInstance(relationInstance);
				if (result == null) result = caseNamedInstance(relationInstance);
				if (result == null) result = caseDescriptionStatement(relationInstance);
				if (result == null) result = caseInstance(relationInstance);
				if (result == null) result = caseStatement(relationInstance);
				if (result == null) result = caseDescriptionMember(relationInstance);
				if (result == null) result = caseMember(relationInstance);
				if (result == null) result = caseIdentifiedElement(relationInstance);
				if (result == null) result = caseElement(relationInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURE_INSTANCE: {
				StructureInstance structureInstance = (StructureInstance)theEObject;
				T result = caseStructureInstance(structureInstance);
				if (result == null) result = caseInstance(structureInstance);
				if (result == null) result = caseElement(structureInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.KEY_AXIOM: {
				KeyAxiom keyAxiom = (KeyAxiom)theEObject;
				T result = caseKeyAxiom(keyAxiom);
				if (result == null) result = caseAxiom(keyAxiom);
				if (result == null) result = caseElement(keyAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SPECIALIZATION_AXIOM: {
				SpecializationAxiom specializationAxiom = (SpecializationAxiom)theEObject;
				T result = caseSpecializationAxiom(specializationAxiom);
				if (result == null) result = caseAxiom(specializationAxiom);
				if (result == null) result = caseElement(specializationAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.INSTANCE_ENUMERATION_AXIOM: {
				InstanceEnumerationAxiom instanceEnumerationAxiom = (InstanceEnumerationAxiom)theEObject;
				T result = caseInstanceEnumerationAxiom(instanceEnumerationAxiom);
				if (result == null) result = caseAxiom(instanceEnumerationAxiom);
				if (result == null) result = caseElement(instanceEnumerationAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM: {
				PropertyRestrictionAxiom propertyRestrictionAxiom = (PropertyRestrictionAxiom)theEObject;
				T result = casePropertyRestrictionAxiom(propertyRestrictionAxiom);
				if (result == null) result = caseAxiom(propertyRestrictionAxiom);
				if (result == null) result = caseElement(propertyRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.LITERAL_ENUMERATION_AXIOM: {
				LiteralEnumerationAxiom literalEnumerationAxiom = (LiteralEnumerationAxiom)theEObject;
				T result = caseLiteralEnumerationAxiom(literalEnumerationAxiom);
				if (result == null) result = caseAxiom(literalEnumerationAxiom);
				if (result == null) result = caseElement(literalEnumerationAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.CLASSIFIER_EQUIVALENCE_AXIOM: {
				ClassifierEquivalenceAxiom classifierEquivalenceAxiom = (ClassifierEquivalenceAxiom)theEObject;
				T result = caseClassifierEquivalenceAxiom(classifierEquivalenceAxiom);
				if (result == null) result = caseAxiom(classifierEquivalenceAxiom);
				if (result == null) result = caseElement(classifierEquivalenceAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY_EQUIVALENCE_AXIOM: {
				PropertyEquivalenceAxiom propertyEquivalenceAxiom = (PropertyEquivalenceAxiom)theEObject;
				T result = casePropertyEquivalenceAxiom(propertyEquivalenceAxiom);
				if (result == null) result = caseAxiom(propertyEquivalenceAxiom);
				if (result == null) result = caseElement(propertyEquivalenceAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY_RANGE_RESTRICTION_AXIOM: {
				PropertyRangeRestrictionAxiom propertyRangeRestrictionAxiom = (PropertyRangeRestrictionAxiom)theEObject;
				T result = casePropertyRangeRestrictionAxiom(propertyRangeRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(propertyRangeRestrictionAxiom);
				if (result == null) result = caseAxiom(propertyRangeRestrictionAxiom);
				if (result == null) result = caseElement(propertyRangeRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY_CARDINALITY_RESTRICTION_AXIOM: {
				PropertyCardinalityRestrictionAxiom propertyCardinalityRestrictionAxiom = (PropertyCardinalityRestrictionAxiom)theEObject;
				T result = casePropertyCardinalityRestrictionAxiom(propertyCardinalityRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(propertyCardinalityRestrictionAxiom);
				if (result == null) result = caseAxiom(propertyCardinalityRestrictionAxiom);
				if (result == null) result = caseElement(propertyCardinalityRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY_VALUE_RESTRICTION_AXIOM: {
				PropertyValueRestrictionAxiom propertyValueRestrictionAxiom = (PropertyValueRestrictionAxiom)theEObject;
				T result = casePropertyValueRestrictionAxiom(propertyValueRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(propertyValueRestrictionAxiom);
				if (result == null) result = caseAxiom(propertyValueRestrictionAxiom);
				if (result == null) result = caseElement(propertyValueRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.TYPE_ASSERTION: {
				TypeAssertion typeAssertion = (TypeAssertion)theEObject;
				T result = caseTypeAssertion(typeAssertion);
				if (result == null) result = caseAssertion(typeAssertion);
				if (result == null) result = caseElement(typeAssertion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY_VALUE_ASSERTION: {
				PropertyValueAssertion propertyValueAssertion = (PropertyValueAssertion)theEObject;
				T result = casePropertyValueAssertion(propertyValueAssertion);
				if (result == null) result = caseAssertion(propertyValueAssertion);
				if (result == null) result = caseElement(propertyValueAssertion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.UNARY_PREDICATE: {
				UnaryPredicate unaryPredicate = (UnaryPredicate)theEObject;
				T result = caseUnaryPredicate(unaryPredicate);
				if (result == null) result = casePredicate(unaryPredicate);
				if (result == null) result = caseElement(unaryPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.BINARY_PREDICATE: {
				BinaryPredicate binaryPredicate = (BinaryPredicate)theEObject;
				T result = caseBinaryPredicate(binaryPredicate);
				if (result == null) result = casePredicate(binaryPredicate);
				if (result == null) result = caseElement(binaryPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.BUILT_IN_PREDICATE: {
				BuiltInPredicate builtInPredicate = (BuiltInPredicate)theEObject;
				T result = caseBuiltInPredicate(builtInPredicate);
				if (result == null) result = casePredicate(builtInPredicate);
				if (result == null) result = caseElement(builtInPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.TYPE_PREDICATE: {
				TypePredicate typePredicate = (TypePredicate)theEObject;
				T result = caseTypePredicate(typePredicate);
				if (result == null) result = caseUnaryPredicate(typePredicate);
				if (result == null) result = casePredicate(typePredicate);
				if (result == null) result = caseElement(typePredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_ENTITY_PREDICATE: {
				RelationEntityPredicate relationEntityPredicate = (RelationEntityPredicate)theEObject;
				T result = caseRelationEntityPredicate(relationEntityPredicate);
				if (result == null) result = caseUnaryPredicate(relationEntityPredicate);
				if (result == null) result = caseBinaryPredicate(relationEntityPredicate);
				if (result == null) result = casePredicate(relationEntityPredicate);
				if (result == null) result = caseElement(relationEntityPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY_PREDICATE: {
				PropertyPredicate propertyPredicate = (PropertyPredicate)theEObject;
				T result = casePropertyPredicate(propertyPredicate);
				if (result == null) result = caseBinaryPredicate(propertyPredicate);
				if (result == null) result = casePredicate(propertyPredicate);
				if (result == null) result = caseElement(propertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SAME_AS_PREDICATE: {
				SameAsPredicate sameAsPredicate = (SameAsPredicate)theEObject;
				T result = caseSameAsPredicate(sameAsPredicate);
				if (result == null) result = caseBinaryPredicate(sameAsPredicate);
				if (result == null) result = casePredicate(sameAsPredicate);
				if (result == null) result = caseElement(sameAsPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DIFFERENT_FROM_PREDICATE: {
				DifferentFromPredicate differentFromPredicate = (DifferentFromPredicate)theEObject;
				T result = caseDifferentFromPredicate(differentFromPredicate);
				if (result == null) result = caseBinaryPredicate(differentFromPredicate);
				if (result == null) result = casePredicate(differentFromPredicate);
				if (result == null) result = caseElement(differentFromPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.QUOTED_LITERAL: {
				QuotedLiteral quotedLiteral = (QuotedLiteral)theEObject;
				T result = caseQuotedLiteral(quotedLiteral);
				if (result == null) result = caseLiteral(quotedLiteral);
				if (result == null) result = caseElement(quotedLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.INTEGER_LITERAL: {
				IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
				T result = caseIntegerLiteral(integerLiteral);
				if (result == null) result = caseLiteral(integerLiteral);
				if (result == null) result = caseElement(integerLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DECIMAL_LITERAL: {
				DecimalLiteral decimalLiteral = (DecimalLiteral)theEObject;
				T result = caseDecimalLiteral(decimalLiteral);
				if (result == null) result = caseLiteral(decimalLiteral);
				if (result == null) result = caseElement(decimalLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DOUBLE_LITERAL: {
				DoubleLiteral doubleLiteral = (DoubleLiteral)theEObject;
				T result = caseDoubleLiteral(doubleLiteral);
				if (result == null) result = caseLiteral(doubleLiteral);
				if (result == null) result = caseElement(doubleLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.BOOLEAN_LITERAL: {
				BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
				T result = caseBooleanLiteral(booleanLiteral);
				if (result == null) result = caseLiteral(booleanLiteral);
				if (result == null) result = caseElement(booleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identified Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identified Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiedElement(IdentifiedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstance(Instance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAxiom(Axiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertion(Assertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicate(Predicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArgument(Argument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ontology</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ontology</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOntology(Ontology object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMember(Member object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyBox(VocabularyBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBox(DescriptionBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabulary(Vocabulary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Bundle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyBundle(VocabularyBundle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescription(Description object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Bundle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBundle(DescriptionBundle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyMember(VocabularyMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionMember(DescriptionMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyStatement(VocabularyStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionStatement(DescriptionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerm(Term object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Built In</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Built In</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltIn(BuiltIn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specializable Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specializable Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializableTerm(SpecializableTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationBase(RelationBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specializable Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specializable Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializableProperty(SpecializableProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifier(Classifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalar(Scalar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructure(Structure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAspect(Aspect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcept(Concept object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationEntity(RelationEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationProperty(AnnotationProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticProperty(SemanticProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarProperty(ScalarProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredProperty(StructuredProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelation(Relation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Forward Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forward Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForwardRelation(ForwardRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reverse Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reverse Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReverseRelation(ReverseRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unreified Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unreified Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnreifiedRelation(UnreifiedRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedInstance(NamedInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptInstance(ConceptInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationInstance(RelationInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureInstance(StructureInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyAxiom(KeyAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specialization Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specialization Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializationAxiom(SpecializationAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Enumeration Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Enumeration Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceEnumerationAxiom(InstanceEnumerationAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyRestrictionAxiom(PropertyRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Enumeration Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Enumeration Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralEnumerationAxiom(LiteralEnumerationAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Equivalence Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Equivalence Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierEquivalenceAxiom(ClassifierEquivalenceAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Equivalence Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Equivalence Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyEquivalenceAxiom(PropertyEquivalenceAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Range Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Range Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyRangeRestrictionAxiom(PropertyRangeRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Cardinality Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Cardinality Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyCardinalityRestrictionAxiom(PropertyCardinalityRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Value Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Value Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyValueRestrictionAxiom(PropertyValueRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeAssertion(TypeAssertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Value Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Value Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyValueAssertion(PropertyValueAssertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryPredicate(UnaryPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryPredicate(BinaryPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Built In Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Built In Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltInPredicate(BuiltInPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypePredicate(TypePredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Entity Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Entity Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationEntityPredicate(RelationEntityPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyPredicate(PropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Same As Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Same As Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSameAsPredicate(SameAsPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Different From Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Different From Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDifferentFromPredicate(DifferentFromPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quoted Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quoted Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuotedLiteral(QuotedLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteral(IntegerLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decimal Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decimal Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecimalLiteral(DecimalLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleLiteral(DoubleLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //OmlSwitch
