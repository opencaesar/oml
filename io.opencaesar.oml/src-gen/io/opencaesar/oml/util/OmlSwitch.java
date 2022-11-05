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
			case OmlPackage.ANNOTATED_ELEMENT: {
				AnnotatedElement annotatedElement = (AnnotatedElement)theEObject;
				T result = caseAnnotatedElement(annotatedElement);
				if (result == null) result = caseElement(annotatedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.IDENTIFIED_ELEMENT: {
				IdentifiedElement identifiedElement = (IdentifiedElement)theEObject;
				T result = caseIdentifiedElement(identifiedElement);
				if (result == null) result = caseAnnotatedElement(identifiedElement);
				if (result == null) result = caseElement(identifiedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ONTOLOGY: {
				Ontology ontology = (Ontology)theEObject;
				T result = caseOntology(ontology);
				if (result == null) result = caseIdentifiedElement(ontology);
				if (result == null) result = caseAnnotatedElement(ontology);
				if (result == null) result = caseElement(ontology);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_BOX: {
				VocabularyBox vocabularyBox = (VocabularyBox)theEObject;
				T result = caseVocabularyBox(vocabularyBox);
				if (result == null) result = caseOntology(vocabularyBox);
				if (result == null) result = caseIdentifiedElement(vocabularyBox);
				if (result == null) result = caseAnnotatedElement(vocabularyBox);
				if (result == null) result = caseElement(vocabularyBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY: {
				Vocabulary vocabulary = (Vocabulary)theEObject;
				T result = caseVocabulary(vocabulary);
				if (result == null) result = caseVocabularyBox(vocabulary);
				if (result == null) result = caseOntology(vocabulary);
				if (result == null) result = caseIdentifiedElement(vocabulary);
				if (result == null) result = caseAnnotatedElement(vocabulary);
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
				if (result == null) result = caseAnnotatedElement(vocabularyBundle);
				if (result == null) result = caseElement(vocabularyBundle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_BOX: {
				DescriptionBox descriptionBox = (DescriptionBox)theEObject;
				T result = caseDescriptionBox(descriptionBox);
				if (result == null) result = caseOntology(descriptionBox);
				if (result == null) result = caseIdentifiedElement(descriptionBox);
				if (result == null) result = caseAnnotatedElement(descriptionBox);
				if (result == null) result = caseElement(descriptionBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION: {
				Description description = (Description)theEObject;
				T result = caseDescription(description);
				if (result == null) result = caseDescriptionBox(description);
				if (result == null) result = caseOntology(description);
				if (result == null) result = caseIdentifiedElement(description);
				if (result == null) result = caseAnnotatedElement(description);
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
				if (result == null) result = caseAnnotatedElement(descriptionBundle);
				if (result == null) result = caseElement(descriptionBundle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.MEMBER: {
				Member member = (Member)theEObject;
				T result = caseMember(member);
				if (result == null) result = caseIdentifiedElement(member);
				if (result == null) result = caseAnnotatedElement(member);
				if (result == null) result = caseElement(member);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.TERM: {
				Term term = (Term)theEObject;
				T result = caseTerm(term);
				if (result == null) result = caseMember(term);
				if (result == null) result = caseIdentifiedElement(term);
				if (result == null) result = caseAnnotatedElement(term);
				if (result == null) result = caseElement(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SPECIALIZABLE_TERM: {
				SpecializableTerm specializableTerm = (SpecializableTerm)theEObject;
				T result = caseSpecializableTerm(specializableTerm);
				if (result == null) result = caseTerm(specializableTerm);
				if (result == null) result = caseVocabularyStatement(specializableTerm);
				if (result == null) result = caseMember(specializableTerm);
				if (result == null) result = caseStatement(specializableTerm);
				if (result == null) result = caseIdentifiedElement(specializableTerm);
				if (result == null) result = caseAnnotatedElement(specializableTerm);
				if (result == null) result = caseElement(specializableTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseSpecializableTerm(type);
				if (result == null) result = caseTerm(type);
				if (result == null) result = caseVocabularyStatement(type);
				if (result == null) result = caseMember(type);
				if (result == null) result = caseStatement(type);
				if (result == null) result = caseIdentifiedElement(type);
				if (result == null) result = caseAnnotatedElement(type);
				if (result == null) result = caseElement(type);
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
				if (result == null) result = caseMember(classifier);
				if (result == null) result = caseStatement(classifier);
				if (result == null) result = caseIdentifiedElement(classifier);
				if (result == null) result = caseAnnotatedElement(classifier);
				if (result == null) result = caseElement(classifier);
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
				if (result == null) result = caseMember(entity);
				if (result == null) result = caseStatement(entity);
				if (result == null) result = caseIdentifiedElement(entity);
				if (result == null) result = caseAnnotatedElement(entity);
				if (result == null) result = caseElement(entity);
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
				if (result == null) result = caseMember(aspect);
				if (result == null) result = caseStatement(aspect);
				if (result == null) result = caseIdentifiedElement(aspect);
				if (result == null) result = caseAnnotatedElement(aspect);
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
				if (result == null) result = caseMember(concept);
				if (result == null) result = caseStatement(concept);
				if (result == null) result = caseIdentifiedElement(concept);
				if (result == null) result = caseAnnotatedElement(concept);
				if (result == null) result = caseElement(concept);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_ENTITY: {
				RelationEntity relationEntity = (RelationEntity)theEObject;
				T result = caseRelationEntity(relationEntity);
				if (result == null) result = caseEntity(relationEntity);
				if (result == null) result = caseClassifier(relationEntity);
				if (result == null) result = caseType(relationEntity);
				if (result == null) result = caseSpecializableTerm(relationEntity);
				if (result == null) result = caseTerm(relationEntity);
				if (result == null) result = caseVocabularyStatement(relationEntity);
				if (result == null) result = caseMember(relationEntity);
				if (result == null) result = caseStatement(relationEntity);
				if (result == null) result = caseIdentifiedElement(relationEntity);
				if (result == null) result = caseAnnotatedElement(relationEntity);
				if (result == null) result = caseElement(relationEntity);
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
				if (result == null) result = caseMember(structure);
				if (result == null) result = caseStatement(structure);
				if (result == null) result = caseIdentifiedElement(structure);
				if (result == null) result = caseAnnotatedElement(structure);
				if (result == null) result = caseElement(structure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.FEATURE: {
				Feature feature = (Feature)theEObject;
				T result = caseFeature(feature);
				if (result == null) result = caseTerm(feature);
				if (result == null) result = caseMember(feature);
				if (result == null) result = caseIdentifiedElement(feature);
				if (result == null) result = caseAnnotatedElement(feature);
				if (result == null) result = caseElement(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseFeature(property);
				if (result == null) result = caseTerm(property);
				if (result == null) result = caseMember(property);
				if (result == null) result = caseIdentifiedElement(property);
				if (result == null) result = caseAnnotatedElement(property);
				if (result == null) result = caseElement(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ANNOTATION_PROPERTY: {
				AnnotationProperty annotationProperty = (AnnotationProperty)theEObject;
				T result = caseAnnotationProperty(annotationProperty);
				if (result == null) result = caseProperty(annotationProperty);
				if (result == null) result = caseSpecializableTerm(annotationProperty);
				if (result == null) result = caseFeature(annotationProperty);
				if (result == null) result = caseVocabularyStatement(annotationProperty);
				if (result == null) result = caseTerm(annotationProperty);
				if (result == null) result = caseStatement(annotationProperty);
				if (result == null) result = caseMember(annotationProperty);
				if (result == null) result = caseIdentifiedElement(annotationProperty);
				if (result == null) result = caseAnnotatedElement(annotationProperty);
				if (result == null) result = caseElement(annotationProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SEMANTIC_PROPERTY: {
				SemanticProperty semanticProperty = (SemanticProperty)theEObject;
				T result = caseSemanticProperty(semanticProperty);
				if (result == null) result = caseProperty(semanticProperty);
				if (result == null) result = caseFeature(semanticProperty);
				if (result == null) result = caseTerm(semanticProperty);
				if (result == null) result = caseMember(semanticProperty);
				if (result == null) result = caseIdentifiedElement(semanticProperty);
				if (result == null) result = caseAnnotatedElement(semanticProperty);
				if (result == null) result = caseElement(semanticProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SCALAR_PROPERTY: {
				ScalarProperty scalarProperty = (ScalarProperty)theEObject;
				T result = caseScalarProperty(scalarProperty);
				if (result == null) result = caseSemanticProperty(scalarProperty);
				if (result == null) result = caseSpecializableTerm(scalarProperty);
				if (result == null) result = caseProperty(scalarProperty);
				if (result == null) result = caseVocabularyStatement(scalarProperty);
				if (result == null) result = caseFeature(scalarProperty);
				if (result == null) result = caseStatement(scalarProperty);
				if (result == null) result = caseTerm(scalarProperty);
				if (result == null) result = caseMember(scalarProperty);
				if (result == null) result = caseIdentifiedElement(scalarProperty);
				if (result == null) result = caseAnnotatedElement(scalarProperty);
				if (result == null) result = caseElement(scalarProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURED_PROPERTY: {
				StructuredProperty structuredProperty = (StructuredProperty)theEObject;
				T result = caseStructuredProperty(structuredProperty);
				if (result == null) result = caseSemanticProperty(structuredProperty);
				if (result == null) result = caseSpecializableTerm(structuredProperty);
				if (result == null) result = caseProperty(structuredProperty);
				if (result == null) result = caseVocabularyStatement(structuredProperty);
				if (result == null) result = caseFeature(structuredProperty);
				if (result == null) result = caseStatement(structuredProperty);
				if (result == null) result = caseTerm(structuredProperty);
				if (result == null) result = caseMember(structuredProperty);
				if (result == null) result = caseIdentifiedElement(structuredProperty);
				if (result == null) result = caseAnnotatedElement(structuredProperty);
				if (result == null) result = caseElement(structuredProperty);
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
				if (result == null) result = caseMember(scalar);
				if (result == null) result = caseStatement(scalar);
				if (result == null) result = caseIdentifiedElement(scalar);
				if (result == null) result = caseAnnotatedElement(scalar);
				if (result == null) result = caseElement(scalar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.FACETED_SCALAR: {
				FacetedScalar facetedScalar = (FacetedScalar)theEObject;
				T result = caseFacetedScalar(facetedScalar);
				if (result == null) result = caseScalar(facetedScalar);
				if (result == null) result = caseType(facetedScalar);
				if (result == null) result = caseSpecializableTerm(facetedScalar);
				if (result == null) result = caseTerm(facetedScalar);
				if (result == null) result = caseVocabularyStatement(facetedScalar);
				if (result == null) result = caseMember(facetedScalar);
				if (result == null) result = caseStatement(facetedScalar);
				if (result == null) result = caseIdentifiedElement(facetedScalar);
				if (result == null) result = caseAnnotatedElement(facetedScalar);
				if (result == null) result = caseElement(facetedScalar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ENUMERATED_SCALAR: {
				EnumeratedScalar enumeratedScalar = (EnumeratedScalar)theEObject;
				T result = caseEnumeratedScalar(enumeratedScalar);
				if (result == null) result = caseScalar(enumeratedScalar);
				if (result == null) result = caseType(enumeratedScalar);
				if (result == null) result = caseSpecializableTerm(enumeratedScalar);
				if (result == null) result = caseTerm(enumeratedScalar);
				if (result == null) result = caseVocabularyStatement(enumeratedScalar);
				if (result == null) result = caseMember(enumeratedScalar);
				if (result == null) result = caseStatement(enumeratedScalar);
				if (result == null) result = caseIdentifiedElement(enumeratedScalar);
				if (result == null) result = caseAnnotatedElement(enumeratedScalar);
				if (result == null) result = caseElement(enumeratedScalar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION: {
				Relation relation = (Relation)theEObject;
				T result = caseRelation(relation);
				if (result == null) result = caseFeature(relation);
				if (result == null) result = caseTerm(relation);
				if (result == null) result = caseMember(relation);
				if (result == null) result = caseIdentifiedElement(relation);
				if (result == null) result = caseAnnotatedElement(relation);
				if (result == null) result = caseElement(relation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.FORWARD_RELATION: {
				ForwardRelation forwardRelation = (ForwardRelation)theEObject;
				T result = caseForwardRelation(forwardRelation);
				if (result == null) result = caseRelation(forwardRelation);
				if (result == null) result = caseFeature(forwardRelation);
				if (result == null) result = caseTerm(forwardRelation);
				if (result == null) result = caseMember(forwardRelation);
				if (result == null) result = caseIdentifiedElement(forwardRelation);
				if (result == null) result = caseAnnotatedElement(forwardRelation);
				if (result == null) result = caseElement(forwardRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.REVERSE_RELATION: {
				ReverseRelation reverseRelation = (ReverseRelation)theEObject;
				T result = caseReverseRelation(reverseRelation);
				if (result == null) result = caseRelation(reverseRelation);
				if (result == null) result = caseFeature(reverseRelation);
				if (result == null) result = caseTerm(reverseRelation);
				if (result == null) result = caseMember(reverseRelation);
				if (result == null) result = caseIdentifiedElement(reverseRelation);
				if (result == null) result = caseAnnotatedElement(reverseRelation);
				if (result == null) result = caseElement(reverseRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseMember(rule);
				if (result == null) result = caseVocabularyStatement(rule);
				if (result == null) result = caseIdentifiedElement(rule);
				if (result == null) result = caseStatement(rule);
				if (result == null) result = caseAnnotatedElement(rule);
				if (result == null) result = caseElement(rule);
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
			case OmlPackage.STRUCTURE_INSTANCE: {
				StructureInstance structureInstance = (StructureInstance)theEObject;
				T result = caseStructureInstance(structureInstance);
				if (result == null) result = caseInstance(structureInstance);
				if (result == null) result = caseElement(structureInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.NAMED_INSTANCE: {
				NamedInstance namedInstance = (NamedInstance)theEObject;
				T result = caseNamedInstance(namedInstance);
				if (result == null) result = caseMember(namedInstance);
				if (result == null) result = caseInstance(namedInstance);
				if (result == null) result = caseDescriptionStatement(namedInstance);
				if (result == null) result = caseIdentifiedElement(namedInstance);
				if (result == null) result = caseStatement(namedInstance);
				if (result == null) result = caseAnnotatedElement(namedInstance);
				if (result == null) result = caseElement(namedInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.CONCEPT_INSTANCE: {
				ConceptInstance conceptInstance = (ConceptInstance)theEObject;
				T result = caseConceptInstance(conceptInstance);
				if (result == null) result = caseNamedInstance(conceptInstance);
				if (result == null) result = caseMember(conceptInstance);
				if (result == null) result = caseInstance(conceptInstance);
				if (result == null) result = caseDescriptionStatement(conceptInstance);
				if (result == null) result = caseIdentifiedElement(conceptInstance);
				if (result == null) result = caseStatement(conceptInstance);
				if (result == null) result = caseAnnotatedElement(conceptInstance);
				if (result == null) result = caseElement(conceptInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_INSTANCE: {
				RelationInstance relationInstance = (RelationInstance)theEObject;
				T result = caseRelationInstance(relationInstance);
				if (result == null) result = caseNamedInstance(relationInstance);
				if (result == null) result = caseMember(relationInstance);
				if (result == null) result = caseInstance(relationInstance);
				if (result == null) result = caseDescriptionStatement(relationInstance);
				if (result == null) result = caseIdentifiedElement(relationInstance);
				if (result == null) result = caseStatement(relationInstance);
				if (result == null) result = caseAnnotatedElement(relationInstance);
				if (result == null) result = caseElement(relationInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.REFERENCE: {
				Reference reference = (Reference)theEObject;
				T result = caseReference(reference);
				if (result == null) result = caseElement(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SPECIALIZABLE_TERM_REFERENCE: {
				SpecializableTermReference specializableTermReference = (SpecializableTermReference)theEObject;
				T result = caseSpecializableTermReference(specializableTermReference);
				if (result == null) result = caseReference(specializableTermReference);
				if (result == null) result = caseVocabularyStatement(specializableTermReference);
				if (result == null) result = caseStatement(specializableTermReference);
				if (result == null) result = caseElement(specializableTermReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.CLASSIFIER_REFERENCE: {
				ClassifierReference classifierReference = (ClassifierReference)theEObject;
				T result = caseClassifierReference(classifierReference);
				if (result == null) result = caseSpecializableTermReference(classifierReference);
				if (result == null) result = caseReference(classifierReference);
				if (result == null) result = caseVocabularyStatement(classifierReference);
				if (result == null) result = caseStatement(classifierReference);
				if (result == null) result = caseElement(classifierReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ENTITY_REFERENCE: {
				EntityReference entityReference = (EntityReference)theEObject;
				T result = caseEntityReference(entityReference);
				if (result == null) result = caseClassifierReference(entityReference);
				if (result == null) result = caseSpecializableTermReference(entityReference);
				if (result == null) result = caseReference(entityReference);
				if (result == null) result = caseVocabularyStatement(entityReference);
				if (result == null) result = caseStatement(entityReference);
				if (result == null) result = caseElement(entityReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ASPECT_REFERENCE: {
				AspectReference aspectReference = (AspectReference)theEObject;
				T result = caseAspectReference(aspectReference);
				if (result == null) result = caseEntityReference(aspectReference);
				if (result == null) result = caseClassifierReference(aspectReference);
				if (result == null) result = caseSpecializableTermReference(aspectReference);
				if (result == null) result = caseReference(aspectReference);
				if (result == null) result = caseVocabularyStatement(aspectReference);
				if (result == null) result = caseStatement(aspectReference);
				if (result == null) result = caseElement(aspectReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.CONCEPT_REFERENCE: {
				ConceptReference conceptReference = (ConceptReference)theEObject;
				T result = caseConceptReference(conceptReference);
				if (result == null) result = caseEntityReference(conceptReference);
				if (result == null) result = caseClassifierReference(conceptReference);
				if (result == null) result = caseSpecializableTermReference(conceptReference);
				if (result == null) result = caseReference(conceptReference);
				if (result == null) result = caseVocabularyStatement(conceptReference);
				if (result == null) result = caseStatement(conceptReference);
				if (result == null) result = caseElement(conceptReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_ENTITY_REFERENCE: {
				RelationEntityReference relationEntityReference = (RelationEntityReference)theEObject;
				T result = caseRelationEntityReference(relationEntityReference);
				if (result == null) result = caseEntityReference(relationEntityReference);
				if (result == null) result = caseClassifierReference(relationEntityReference);
				if (result == null) result = caseSpecializableTermReference(relationEntityReference);
				if (result == null) result = caseReference(relationEntityReference);
				if (result == null) result = caseVocabularyStatement(relationEntityReference);
				if (result == null) result = caseStatement(relationEntityReference);
				if (result == null) result = caseElement(relationEntityReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURE_REFERENCE: {
				StructureReference structureReference = (StructureReference)theEObject;
				T result = caseStructureReference(structureReference);
				if (result == null) result = caseClassifierReference(structureReference);
				if (result == null) result = caseSpecializableTermReference(structureReference);
				if (result == null) result = caseReference(structureReference);
				if (result == null) result = caseVocabularyStatement(structureReference);
				if (result == null) result = caseStatement(structureReference);
				if (result == null) result = caseElement(structureReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ANNOTATION_PROPERTY_REFERENCE: {
				AnnotationPropertyReference annotationPropertyReference = (AnnotationPropertyReference)theEObject;
				T result = caseAnnotationPropertyReference(annotationPropertyReference);
				if (result == null) result = caseSpecializableTermReference(annotationPropertyReference);
				if (result == null) result = caseReference(annotationPropertyReference);
				if (result == null) result = caseVocabularyStatement(annotationPropertyReference);
				if (result == null) result = caseStatement(annotationPropertyReference);
				if (result == null) result = caseElement(annotationPropertyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SCALAR_PROPERTY_REFERENCE: {
				ScalarPropertyReference scalarPropertyReference = (ScalarPropertyReference)theEObject;
				T result = caseScalarPropertyReference(scalarPropertyReference);
				if (result == null) result = caseSpecializableTermReference(scalarPropertyReference);
				if (result == null) result = caseReference(scalarPropertyReference);
				if (result == null) result = caseVocabularyStatement(scalarPropertyReference);
				if (result == null) result = caseStatement(scalarPropertyReference);
				if (result == null) result = caseElement(scalarPropertyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURED_PROPERTY_REFERENCE: {
				StructuredPropertyReference structuredPropertyReference = (StructuredPropertyReference)theEObject;
				T result = caseStructuredPropertyReference(structuredPropertyReference);
				if (result == null) result = caseSpecializableTermReference(structuredPropertyReference);
				if (result == null) result = caseReference(structuredPropertyReference);
				if (result == null) result = caseVocabularyStatement(structuredPropertyReference);
				if (result == null) result = caseStatement(structuredPropertyReference);
				if (result == null) result = caseElement(structuredPropertyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.FACETED_SCALAR_REFERENCE: {
				FacetedScalarReference facetedScalarReference = (FacetedScalarReference)theEObject;
				T result = caseFacetedScalarReference(facetedScalarReference);
				if (result == null) result = caseSpecializableTermReference(facetedScalarReference);
				if (result == null) result = caseReference(facetedScalarReference);
				if (result == null) result = caseVocabularyStatement(facetedScalarReference);
				if (result == null) result = caseStatement(facetedScalarReference);
				if (result == null) result = caseElement(facetedScalarReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.ENUMERATED_SCALAR_REFERENCE: {
				EnumeratedScalarReference enumeratedScalarReference = (EnumeratedScalarReference)theEObject;
				T result = caseEnumeratedScalarReference(enumeratedScalarReference);
				if (result == null) result = caseSpecializableTermReference(enumeratedScalarReference);
				if (result == null) result = caseReference(enumeratedScalarReference);
				if (result == null) result = caseVocabularyStatement(enumeratedScalarReference);
				if (result == null) result = caseStatement(enumeratedScalarReference);
				if (result == null) result = caseElement(enumeratedScalarReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_REFERENCE: {
				RelationReference relationReference = (RelationReference)theEObject;
				T result = caseRelationReference(relationReference);
				if (result == null) result = caseReference(relationReference);
				if (result == null) result = caseVocabularyStatement(relationReference);
				if (result == null) result = caseStatement(relationReference);
				if (result == null) result = caseElement(relationReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RULE_REFERENCE: {
				RuleReference ruleReference = (RuleReference)theEObject;
				T result = caseRuleReference(ruleReference);
				if (result == null) result = caseReference(ruleReference);
				if (result == null) result = caseVocabularyStatement(ruleReference);
				if (result == null) result = caseStatement(ruleReference);
				if (result == null) result = caseElement(ruleReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.NAMED_INSTANCE_REFERENCE: {
				NamedInstanceReference namedInstanceReference = (NamedInstanceReference)theEObject;
				T result = caseNamedInstanceReference(namedInstanceReference);
				if (result == null) result = caseReference(namedInstanceReference);
				if (result == null) result = caseDescriptionStatement(namedInstanceReference);
				if (result == null) result = caseStatement(namedInstanceReference);
				if (result == null) result = caseElement(namedInstanceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.CONCEPT_INSTANCE_REFERENCE: {
				ConceptInstanceReference conceptInstanceReference = (ConceptInstanceReference)theEObject;
				T result = caseConceptInstanceReference(conceptInstanceReference);
				if (result == null) result = caseNamedInstanceReference(conceptInstanceReference);
				if (result == null) result = caseReference(conceptInstanceReference);
				if (result == null) result = caseDescriptionStatement(conceptInstanceReference);
				if (result == null) result = caseStatement(conceptInstanceReference);
				if (result == null) result = caseElement(conceptInstanceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_INSTANCE_REFERENCE: {
				RelationInstanceReference relationInstanceReference = (RelationInstanceReference)theEObject;
				T result = caseRelationInstanceReference(relationInstanceReference);
				if (result == null) result = caseNamedInstanceReference(relationInstanceReference);
				if (result == null) result = caseReference(relationInstanceReference);
				if (result == null) result = caseDescriptionStatement(relationInstanceReference);
				if (result == null) result = caseStatement(relationInstanceReference);
				if (result == null) result = caseElement(relationInstanceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = caseElement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_STATEMENT: {
				VocabularyStatement vocabularyStatement = (VocabularyStatement)theEObject;
				T result = caseVocabularyStatement(vocabularyStatement);
				if (result == null) result = caseStatement(vocabularyStatement);
				if (result == null) result = caseElement(vocabularyStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_STATEMENT: {
				DescriptionStatement descriptionStatement = (DescriptionStatement)theEObject;
				T result = caseDescriptionStatement(descriptionStatement);
				if (result == null) result = caseStatement(descriptionStatement);
				if (result == null) result = caseElement(descriptionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.IMPORT: {
				Import import_ = (Import)theEObject;
				T result = caseImport(import_);
				if (result == null) result = caseAnnotatedElement(import_);
				if (result == null) result = caseElement(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_IMPORT: {
				VocabularyImport vocabularyImport = (VocabularyImport)theEObject;
				T result = caseVocabularyImport(vocabularyImport);
				if (result == null) result = caseImport(vocabularyImport);
				if (result == null) result = caseAnnotatedElement(vocabularyImport);
				if (result == null) result = caseElement(vocabularyImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_EXTENSION: {
				VocabularyExtension vocabularyExtension = (VocabularyExtension)theEObject;
				T result = caseVocabularyExtension(vocabularyExtension);
				if (result == null) result = caseVocabularyImport(vocabularyExtension);
				if (result == null) result = caseImport(vocabularyExtension);
				if (result == null) result = caseAnnotatedElement(vocabularyExtension);
				if (result == null) result = caseElement(vocabularyExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_USAGE: {
				VocabularyUsage vocabularyUsage = (VocabularyUsage)theEObject;
				T result = caseVocabularyUsage(vocabularyUsage);
				if (result == null) result = caseVocabularyImport(vocabularyUsage);
				if (result == null) result = caseImport(vocabularyUsage);
				if (result == null) result = caseAnnotatedElement(vocabularyUsage);
				if (result == null) result = caseElement(vocabularyUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_BUNDLE_IMPORT: {
				VocabularyBundleImport vocabularyBundleImport = (VocabularyBundleImport)theEObject;
				T result = caseVocabularyBundleImport(vocabularyBundleImport);
				if (result == null) result = caseImport(vocabularyBundleImport);
				if (result == null) result = caseAnnotatedElement(vocabularyBundleImport);
				if (result == null) result = caseElement(vocabularyBundleImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_BUNDLE_EXTENSION: {
				VocabularyBundleExtension vocabularyBundleExtension = (VocabularyBundleExtension)theEObject;
				T result = caseVocabularyBundleExtension(vocabularyBundleExtension);
				if (result == null) result = caseVocabularyBundleImport(vocabularyBundleExtension);
				if (result == null) result = caseImport(vocabularyBundleExtension);
				if (result == null) result = caseAnnotatedElement(vocabularyBundleExtension);
				if (result == null) result = caseElement(vocabularyBundleExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.VOCABULARY_BUNDLE_INCLUSION: {
				VocabularyBundleInclusion vocabularyBundleInclusion = (VocabularyBundleInclusion)theEObject;
				T result = caseVocabularyBundleInclusion(vocabularyBundleInclusion);
				if (result == null) result = caseVocabularyBundleImport(vocabularyBundleInclusion);
				if (result == null) result = caseImport(vocabularyBundleInclusion);
				if (result == null) result = caseAnnotatedElement(vocabularyBundleInclusion);
				if (result == null) result = caseElement(vocabularyBundleInclusion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_IMPORT: {
				DescriptionImport descriptionImport = (DescriptionImport)theEObject;
				T result = caseDescriptionImport(descriptionImport);
				if (result == null) result = caseImport(descriptionImport);
				if (result == null) result = caseAnnotatedElement(descriptionImport);
				if (result == null) result = caseElement(descriptionImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_EXTENSION: {
				DescriptionExtension descriptionExtension = (DescriptionExtension)theEObject;
				T result = caseDescriptionExtension(descriptionExtension);
				if (result == null) result = caseDescriptionImport(descriptionExtension);
				if (result == null) result = caseImport(descriptionExtension);
				if (result == null) result = caseAnnotatedElement(descriptionExtension);
				if (result == null) result = caseElement(descriptionExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_USAGE: {
				DescriptionUsage descriptionUsage = (DescriptionUsage)theEObject;
				T result = caseDescriptionUsage(descriptionUsage);
				if (result == null) result = caseDescriptionImport(descriptionUsage);
				if (result == null) result = caseImport(descriptionUsage);
				if (result == null) result = caseAnnotatedElement(descriptionUsage);
				if (result == null) result = caseElement(descriptionUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_BUNDLE_IMPORT: {
				DescriptionBundleImport descriptionBundleImport = (DescriptionBundleImport)theEObject;
				T result = caseDescriptionBundleImport(descriptionBundleImport);
				if (result == null) result = caseImport(descriptionBundleImport);
				if (result == null) result = caseAnnotatedElement(descriptionBundleImport);
				if (result == null) result = caseElement(descriptionBundleImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_BUNDLE_EXTENSION: {
				DescriptionBundleExtension descriptionBundleExtension = (DescriptionBundleExtension)theEObject;
				T result = caseDescriptionBundleExtension(descriptionBundleExtension);
				if (result == null) result = caseDescriptionBundleImport(descriptionBundleExtension);
				if (result == null) result = caseImport(descriptionBundleExtension);
				if (result == null) result = caseAnnotatedElement(descriptionBundleExtension);
				if (result == null) result = caseElement(descriptionBundleExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_BUNDLE_INCLUSION: {
				DescriptionBundleInclusion descriptionBundleInclusion = (DescriptionBundleInclusion)theEObject;
				T result = caseDescriptionBundleInclusion(descriptionBundleInclusion);
				if (result == null) result = caseDescriptionBundleImport(descriptionBundleInclusion);
				if (result == null) result = caseImport(descriptionBundleInclusion);
				if (result == null) result = caseAnnotatedElement(descriptionBundleInclusion);
				if (result == null) result = caseElement(descriptionBundleInclusion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.DESCRIPTION_BUNDLE_USAGE: {
				DescriptionBundleUsage descriptionBundleUsage = (DescriptionBundleUsage)theEObject;
				T result = caseDescriptionBundleUsage(descriptionBundleUsage);
				if (result == null) result = caseDescriptionBundleImport(descriptionBundleUsage);
				if (result == null) result = caseImport(descriptionBundleUsage);
				if (result == null) result = caseAnnotatedElement(descriptionBundleUsage);
				if (result == null) result = caseElement(descriptionBundleUsage);
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
			case OmlPackage.SPECIALIZATION_AXIOM: {
				SpecializationAxiom specializationAxiom = (SpecializationAxiom)theEObject;
				T result = caseSpecializationAxiom(specializationAxiom);
				if (result == null) result = caseAxiom(specializationAxiom);
				if (result == null) result = caseElement(specializationAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RESTRICTION_AXIOM: {
				RestrictionAxiom restrictionAxiom = (RestrictionAxiom)theEObject;
				T result = caseRestrictionAxiom(restrictionAxiom);
				if (result == null) result = caseAxiom(restrictionAxiom);
				if (result == null) result = caseElement(restrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.PROPERTY_RESTRICTION_AXIOM: {
				PropertyRestrictionAxiom propertyRestrictionAxiom = (PropertyRestrictionAxiom)theEObject;
				T result = casePropertyRestrictionAxiom(propertyRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(propertyRestrictionAxiom);
				if (result == null) result = caseAxiom(propertyRestrictionAxiom);
				if (result == null) result = caseElement(propertyRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SCALAR_PROPERTY_RESTRICTION_AXIOM: {
				ScalarPropertyRestrictionAxiom scalarPropertyRestrictionAxiom = (ScalarPropertyRestrictionAxiom)theEObject;
				T result = caseScalarPropertyRestrictionAxiom(scalarPropertyRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(scalarPropertyRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(scalarPropertyRestrictionAxiom);
				if (result == null) result = caseAxiom(scalarPropertyRestrictionAxiom);
				if (result == null) result = caseElement(scalarPropertyRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SCALAR_PROPERTY_RANGE_RESTRICTION_AXIOM: {
				ScalarPropertyRangeRestrictionAxiom scalarPropertyRangeRestrictionAxiom = (ScalarPropertyRangeRestrictionAxiom)theEObject;
				T result = caseScalarPropertyRangeRestrictionAxiom(scalarPropertyRangeRestrictionAxiom);
				if (result == null) result = caseScalarPropertyRestrictionAxiom(scalarPropertyRangeRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(scalarPropertyRangeRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(scalarPropertyRangeRestrictionAxiom);
				if (result == null) result = caseAxiom(scalarPropertyRangeRestrictionAxiom);
				if (result == null) result = caseElement(scalarPropertyRangeRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SCALAR_PROPERTY_CARDINALITY_RESTRICTION_AXIOM: {
				ScalarPropertyCardinalityRestrictionAxiom scalarPropertyCardinalityRestrictionAxiom = (ScalarPropertyCardinalityRestrictionAxiom)theEObject;
				T result = caseScalarPropertyCardinalityRestrictionAxiom(scalarPropertyCardinalityRestrictionAxiom);
				if (result == null) result = caseScalarPropertyRestrictionAxiom(scalarPropertyCardinalityRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(scalarPropertyCardinalityRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(scalarPropertyCardinalityRestrictionAxiom);
				if (result == null) result = caseAxiom(scalarPropertyCardinalityRestrictionAxiom);
				if (result == null) result = caseElement(scalarPropertyCardinalityRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.SCALAR_PROPERTY_VALUE_RESTRICTION_AXIOM: {
				ScalarPropertyValueRestrictionAxiom scalarPropertyValueRestrictionAxiom = (ScalarPropertyValueRestrictionAxiom)theEObject;
				T result = caseScalarPropertyValueRestrictionAxiom(scalarPropertyValueRestrictionAxiom);
				if (result == null) result = caseScalarPropertyRestrictionAxiom(scalarPropertyValueRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(scalarPropertyValueRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(scalarPropertyValueRestrictionAxiom);
				if (result == null) result = caseAxiom(scalarPropertyValueRestrictionAxiom);
				if (result == null) result = caseElement(scalarPropertyValueRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURED_PROPERTY_RESTRICTION_AXIOM: {
				StructuredPropertyRestrictionAxiom structuredPropertyRestrictionAxiom = (StructuredPropertyRestrictionAxiom)theEObject;
				T result = caseStructuredPropertyRestrictionAxiom(structuredPropertyRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(structuredPropertyRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(structuredPropertyRestrictionAxiom);
				if (result == null) result = caseAxiom(structuredPropertyRestrictionAxiom);
				if (result == null) result = caseElement(structuredPropertyRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURED_PROPERTY_RANGE_RESTRICTION_AXIOM: {
				StructuredPropertyRangeRestrictionAxiom structuredPropertyRangeRestrictionAxiom = (StructuredPropertyRangeRestrictionAxiom)theEObject;
				T result = caseStructuredPropertyRangeRestrictionAxiom(structuredPropertyRangeRestrictionAxiom);
				if (result == null) result = caseStructuredPropertyRestrictionAxiom(structuredPropertyRangeRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(structuredPropertyRangeRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(structuredPropertyRangeRestrictionAxiom);
				if (result == null) result = caseAxiom(structuredPropertyRangeRestrictionAxiom);
				if (result == null) result = caseElement(structuredPropertyRangeRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURED_PROPERTY_CARDINALITY_RESTRICTION_AXIOM: {
				StructuredPropertyCardinalityRestrictionAxiom structuredPropertyCardinalityRestrictionAxiom = (StructuredPropertyCardinalityRestrictionAxiom)theEObject;
				T result = caseStructuredPropertyCardinalityRestrictionAxiom(structuredPropertyCardinalityRestrictionAxiom);
				if (result == null) result = caseStructuredPropertyRestrictionAxiom(structuredPropertyCardinalityRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(structuredPropertyCardinalityRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(structuredPropertyCardinalityRestrictionAxiom);
				if (result == null) result = caseAxiom(structuredPropertyCardinalityRestrictionAxiom);
				if (result == null) result = caseElement(structuredPropertyCardinalityRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURED_PROPERTY_VALUE_RESTRICTION_AXIOM: {
				StructuredPropertyValueRestrictionAxiom structuredPropertyValueRestrictionAxiom = (StructuredPropertyValueRestrictionAxiom)theEObject;
				T result = caseStructuredPropertyValueRestrictionAxiom(structuredPropertyValueRestrictionAxiom);
				if (result == null) result = caseStructuredPropertyRestrictionAxiom(structuredPropertyValueRestrictionAxiom);
				if (result == null) result = casePropertyRestrictionAxiom(structuredPropertyValueRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(structuredPropertyValueRestrictionAxiom);
				if (result == null) result = caseAxiom(structuredPropertyValueRestrictionAxiom);
				if (result == null) result = caseElement(structuredPropertyValueRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_RESTRICTION_AXIOM: {
				RelationRestrictionAxiom relationRestrictionAxiom = (RelationRestrictionAxiom)theEObject;
				T result = caseRelationRestrictionAxiom(relationRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(relationRestrictionAxiom);
				if (result == null) result = caseAxiom(relationRestrictionAxiom);
				if (result == null) result = caseElement(relationRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_RANGE_RESTRICTION_AXIOM: {
				RelationRangeRestrictionAxiom relationRangeRestrictionAxiom = (RelationRangeRestrictionAxiom)theEObject;
				T result = caseRelationRangeRestrictionAxiom(relationRangeRestrictionAxiom);
				if (result == null) result = caseRelationRestrictionAxiom(relationRangeRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(relationRangeRestrictionAxiom);
				if (result == null) result = caseAxiom(relationRangeRestrictionAxiom);
				if (result == null) result = caseElement(relationRangeRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_CARDINALITY_RESTRICTION_AXIOM: {
				RelationCardinalityRestrictionAxiom relationCardinalityRestrictionAxiom = (RelationCardinalityRestrictionAxiom)theEObject;
				T result = caseRelationCardinalityRestrictionAxiom(relationCardinalityRestrictionAxiom);
				if (result == null) result = caseRelationRestrictionAxiom(relationCardinalityRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(relationCardinalityRestrictionAxiom);
				if (result == null) result = caseAxiom(relationCardinalityRestrictionAxiom);
				if (result == null) result = caseElement(relationCardinalityRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_TARGET_RESTRICTION_AXIOM: {
				RelationTargetRestrictionAxiom relationTargetRestrictionAxiom = (RelationTargetRestrictionAxiom)theEObject;
				T result = caseRelationTargetRestrictionAxiom(relationTargetRestrictionAxiom);
				if (result == null) result = caseRelationRestrictionAxiom(relationTargetRestrictionAxiom);
				if (result == null) result = caseRestrictionAxiom(relationTargetRestrictionAxiom);
				if (result == null) result = caseAxiom(relationTargetRestrictionAxiom);
				if (result == null) result = caseElement(relationTargetRestrictionAxiom);
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
			case OmlPackage.ASSERTION: {
				Assertion assertion = (Assertion)theEObject;
				T result = caseAssertion(assertion);
				if (result == null) result = caseElement(assertion);
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
			case OmlPackage.CONCEPT_TYPE_ASSERTION: {
				ConceptTypeAssertion conceptTypeAssertion = (ConceptTypeAssertion)theEObject;
				T result = caseConceptTypeAssertion(conceptTypeAssertion);
				if (result == null) result = caseTypeAssertion(conceptTypeAssertion);
				if (result == null) result = caseAssertion(conceptTypeAssertion);
				if (result == null) result = caseElement(conceptTypeAssertion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_TYPE_ASSERTION: {
				RelationTypeAssertion relationTypeAssertion = (RelationTypeAssertion)theEObject;
				T result = caseRelationTypeAssertion(relationTypeAssertion);
				if (result == null) result = caseTypeAssertion(relationTypeAssertion);
				if (result == null) result = caseAssertion(relationTypeAssertion);
				if (result == null) result = caseElement(relationTypeAssertion);
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
			case OmlPackage.SCALAR_PROPERTY_VALUE_ASSERTION: {
				ScalarPropertyValueAssertion scalarPropertyValueAssertion = (ScalarPropertyValueAssertion)theEObject;
				T result = caseScalarPropertyValueAssertion(scalarPropertyValueAssertion);
				if (result == null) result = casePropertyValueAssertion(scalarPropertyValueAssertion);
				if (result == null) result = caseAssertion(scalarPropertyValueAssertion);
				if (result == null) result = caseElement(scalarPropertyValueAssertion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.STRUCTURED_PROPERTY_VALUE_ASSERTION: {
				StructuredPropertyValueAssertion structuredPropertyValueAssertion = (StructuredPropertyValueAssertion)theEObject;
				T result = caseStructuredPropertyValueAssertion(structuredPropertyValueAssertion);
				if (result == null) result = casePropertyValueAssertion(structuredPropertyValueAssertion);
				if (result == null) result = caseAssertion(structuredPropertyValueAssertion);
				if (result == null) result = caseElement(structuredPropertyValueAssertion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.LINK_ASSERTION: {
				LinkAssertion linkAssertion = (LinkAssertion)theEObject;
				T result = caseLinkAssertion(linkAssertion);
				if (result == null) result = caseAssertion(linkAssertion);
				if (result == null) result = caseElement(linkAssertion);
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
			case OmlPackage.UNARY_PREDICATE: {
				UnaryPredicate unaryPredicate = (UnaryPredicate)theEObject;
				T result = caseUnaryPredicate(unaryPredicate);
				if (result == null) result = casePredicate(unaryPredicate);
				if (result == null) result = caseElement(unaryPredicate);
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
			case OmlPackage.BINARY_PREDICATE: {
				BinaryPredicate binaryPredicate = (BinaryPredicate)theEObject;
				T result = caseBinaryPredicate(binaryPredicate);
				if (result == null) result = casePredicate(binaryPredicate);
				if (result == null) result = caseElement(binaryPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.RELATION_ENTITY_PREDICATE: {
				RelationEntityPredicate relationEntityPredicate = (RelationEntityPredicate)theEObject;
				T result = caseRelationEntityPredicate(relationEntityPredicate);
				if (result == null) result = caseBinaryPredicate(relationEntityPredicate);
				if (result == null) result = casePredicate(relationEntityPredicate);
				if (result == null) result = caseElement(relationEntityPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OmlPackage.FEATURE_PREDICATE: {
				FeaturePredicate featurePredicate = (FeaturePredicate)theEObject;
				T result = caseFeaturePredicate(featurePredicate);
				if (result == null) result = caseBinaryPredicate(featurePredicate);
				if (result == null) result = casePredicate(featurePredicate);
				if (result == null) result = caseElement(featurePredicate);
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
			case OmlPackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = caseElement(literal);
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
	 * Returns the result of interpreting the object as an instance of '<em>Annotated Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotated Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotatedElement(AnnotatedElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeature(Feature object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Faceted Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Faceted Scalar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetedScalar(FacetedScalar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerated Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerated Scalar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeratedScalar(EnumeratedScalar object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReference(Reference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specializable Term Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specializable Term Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializableTermReference(SpecializableTermReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierReference(ClassifierReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityReference(EntityReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aspect Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAspectReference(AspectReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptReference(ConceptReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Entity Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Entity Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationEntityReference(RelationEntityReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureReference(StructureReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Property Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationPropertyReference(AnnotationPropertyReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Property Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarPropertyReference(ScalarPropertyReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Property Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredPropertyReference(StructuredPropertyReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Faceted Scalar Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Faceted Scalar Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetedScalarReference(FacetedScalarReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerated Scalar Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerated Scalar Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeratedScalarReference(EnumeratedScalarReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationReference(RelationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleReference(RuleReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Instance Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Instance Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedInstanceReference(NamedInstanceReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Instance Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Instance Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptInstanceReference(ConceptInstanceReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Instance Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Instance Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationInstanceReference(RelationInstanceReference object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyImport(VocabularyImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyExtension(VocabularyExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyUsage(VocabularyUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Bundle Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Bundle Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyBundleImport(VocabularyBundleImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Bundle Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Bundle Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyBundleExtension(VocabularyBundleExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Bundle Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Bundle Inclusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyBundleInclusion(VocabularyBundleInclusion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionImport(DescriptionImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionExtension(DescriptionExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionUsage(DescriptionUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Bundle Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Bundle Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBundleImport(DescriptionBundleImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Bundle Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Bundle Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBundleExtension(DescriptionBundleExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Bundle Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Bundle Inclusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBundleInclusion(DescriptionBundleInclusion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Bundle Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Bundle Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBundleUsage(DescriptionBundleUsage object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRestrictionAxiom(RestrictionAxiom object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Property Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Property Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarPropertyRestrictionAxiom(ScalarPropertyRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Property Range Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Property Range Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarPropertyRangeRestrictionAxiom(ScalarPropertyRangeRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Property Cardinality Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Property Cardinality Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarPropertyCardinalityRestrictionAxiom(ScalarPropertyCardinalityRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Property Value Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Property Value Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarPropertyValueRestrictionAxiom(ScalarPropertyValueRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Property Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Property Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredPropertyRestrictionAxiom(StructuredPropertyRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Property Range Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Property Range Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredPropertyRangeRestrictionAxiom(StructuredPropertyRangeRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Property Cardinality Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Property Cardinality Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredPropertyCardinalityRestrictionAxiom(StructuredPropertyCardinalityRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Property Value Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Property Value Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredPropertyValueRestrictionAxiom(StructuredPropertyValueRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationRestrictionAxiom(RelationRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Range Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Range Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationRangeRestrictionAxiom(RelationRangeRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Cardinality Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Cardinality Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationCardinalityRestrictionAxiom(RelationCardinalityRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Target Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Target Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationTargetRestrictionAxiom(RelationTargetRestrictionAxiom object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Concept Type Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Type Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptTypeAssertion(ConceptTypeAssertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Type Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Type Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationTypeAssertion(RelationTypeAssertion object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Property Value Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Property Value Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarPropertyValueAssertion(ScalarPropertyValueAssertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Property Value Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Property Value Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredPropertyValueAssertion(StructuredPropertyValueAssertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkAssertion(LinkAssertion object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Feature Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturePredicate(FeaturePredicate object) {
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
