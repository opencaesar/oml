/**
 * 
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
 * 
 */
package io.opencaesar.oml.util

import io.opencaesar.oml.Annotation
import io.opencaesar.oml.AnnotationProperty
import io.opencaesar.oml.AnnotationPropertyReference
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.AspectReference
import io.opencaesar.oml.Assertion
import io.opencaesar.oml.Axiom
import io.opencaesar.oml.BooleanLiteral
import io.opencaesar.oml.Bundle
import io.opencaesar.oml.BundleExtension
import io.opencaesar.oml.BundleInclusion
import io.opencaesar.oml.CardinalityRestrictionKind
import io.opencaesar.oml.Classifier
import io.opencaesar.oml.ClassifierReference
import io.opencaesar.oml.Concept
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.ConceptInstanceReference
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.ConceptTypeAssertion
import io.opencaesar.oml.DecimalLiteral
import io.opencaesar.oml.Description
import io.opencaesar.oml.DescriptionExtension
import io.opencaesar.oml.DescriptionStatement
import io.opencaesar.oml.DescriptionUsage
import io.opencaesar.oml.DifferentFromPredicate
import io.opencaesar.oml.DoubleLiteral
import io.opencaesar.oml.Element
import io.opencaesar.oml.Entity
import io.opencaesar.oml.EntityPredicate
import io.opencaesar.oml.EntityReference
import io.opencaesar.oml.EnumeratedScalar
import io.opencaesar.oml.EnumeratedScalarReference
import io.opencaesar.oml.FacetedScalar
import io.opencaesar.oml.FacetedScalarReference
import io.opencaesar.oml.ForwardRelation
import io.opencaesar.oml.IdentifiedElement
import io.opencaesar.oml.IntegerLiteral
import io.opencaesar.oml.KeyAxiom
import io.opencaesar.oml.LinkAssertion
import io.opencaesar.oml.Literal
import io.opencaesar.oml.Member
import io.opencaesar.oml.NamedInstance
import io.opencaesar.oml.NamedInstanceReference
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.Predicate
import io.opencaesar.oml.QuotedLiteral
import io.opencaesar.oml.RangeRestrictionKind
import io.opencaesar.oml.Reference
import io.opencaesar.oml.Relation
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.RelationEntityPredicate
import io.opencaesar.oml.RelationEntityReference
import io.opencaesar.oml.RelationInstance
import io.opencaesar.oml.RelationInstanceReference
import io.opencaesar.oml.RelationPredicate
import io.opencaesar.oml.RelationRangeRestrictionAxiom
import io.opencaesar.oml.RelationReference
import io.opencaesar.oml.RelationTargetRestrictionAxiom
import io.opencaesar.oml.RelationTypeAssertion
import io.opencaesar.oml.ReverseRelation
import io.opencaesar.oml.Rule
import io.opencaesar.oml.RuleReference
import io.opencaesar.oml.SameAsPredicate
import io.opencaesar.oml.Scalar
import io.opencaesar.oml.ScalarProperty
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyReference
import io.opencaesar.oml.ScalarPropertyValueAssertion
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom
import io.opencaesar.oml.SeparatorKind
import io.opencaesar.oml.SpecializableTerm
import io.opencaesar.oml.SpecializableTermReference
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.Structure
import io.opencaesar.oml.StructureInstance
import io.opencaesar.oml.StructureReference
import io.opencaesar.oml.StructuredProperty
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyReference
import io.opencaesar.oml.StructuredPropertyValueAssertion
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom
import io.opencaesar.oml.Vocabulary
import io.opencaesar.oml.VocabularyExtension
import io.opencaesar.oml.VocabularyStatement
import io.opencaesar.oml.VocabularyUsage
import java.math.BigDecimal
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EContentAdapter
import org.eclipse.emf.ecore.util.EcoreUtil

import static extension io.opencaesar.oml.util.OmlRead.*

class OmlWriter {
	
	val ResourceSet resourceSet
	val newResources = new HashSet<Resource>
	val cache = new HashMap<String, IdentifiedElement>
	val defer = new ArrayList<Runnable>
	
	new(ResourceSet resourceSet) {
		this.resourceSet = resourceSet
		resourceSet.eAdapters += new EContentAdapter {
  			override notifyChanged(Notification n) {
  				super.notifyChanged(n)
  				if (n.eventType == Notification.SET || n.eventType == Notification.ADD) {
	  				if (n.newValue instanceof IdentifiedElement) { 
						val element = n.newValue as IdentifiedElement
	  					if (n.feature === null) {
	  						if (element instanceof Ontology) {
				  				cache.put(element.iri, element)
		  						element.members.forEach[member|
			  						cache.put(member.iri, member)
			  					]
	  						}
	  					} else if ((n.feature as EReference).containment) {
							cache.put(element.iri, element)
						}
	  				} 
	  			}
  			}
		}
	}

	protected def <T extends Element> create(Class<T> type) {
		return OmlWrite.INSTANCE.create(type)
	}

	protected def <T extends IdentifiedElement> resolve(Class<T> type, String iri) {
		val element = cache.get(iri)
		if (element === null) {
			throw new RuntimeException("could not resolve iri "+iri)
		} 
		return element as T
	}
	
	protected def <T extends Reference> T getOrAddReference(Ontology ontology, Member member, Class<T> type) {
		var reference = ontology.references.findFirst[resolve == member] as T
		if (reference === null) {
			reference = member.createReference as T
			if (ontology instanceof Vocabulary) {
				ontology.ownedStatements.add(reference as VocabularyStatement) 
			} else if (ontology instanceof Description) {
				ontology.ownedStatements.add(reference as DescriptionStatement) 
			}
		}
		reference
	}

	protected def addToNewResource(Ontology ontology, URI resourceURI) {
		val resource = resourceSet.createResource(resourceURI)
		resource.contents += ontology
		newResources.add(resource)
	}
	
	def loadDependentResource(URI resourceURI) {
		resourceSet.getResource(resourceURI, true)
	}
	
	def start() {
		EcoreUtil.resolveAll(resourceSet)
	}
	
	def finish() {
		defer.forEach[run]
	}
	
	def save(Map<String, String> saveOptions) {
		newResources.forEach[resource| resource.save(saveOptions)]
	}	

	// Annotation

	def addAnnotation(Ontology ontology, String propertyIri, Literal value) {
		val annotation = create(Annotation)
		defer.add [annotation.property = resolve(AnnotationProperty, propertyIri)]
		annotation.value = value
		ontology.ownedAnnotations += annotation
		return annotation
	}

	def addAnnotation(Ontology ontology, String memberIri, String propertyIri, Literal value) {
		val annotation = create(Annotation)
		defer.add [annotation.property = resolve(AnnotationProperty, propertyIri)]
		annotation.value = value
		defer.add [
			val member = resolve(Member, memberIri)
			if (member.ontology == ontology) {
				member.ownedAnnotations += annotation
			} else {
				ontology.getOrAddReference(member, Reference).ownedAnnotations += annotation 
			}
		]
		return annotation
	}

	def addAnnotation(Axiom axiom, String propertyIri, Literal value) {
		val annotation = create(Annotation)
		defer.add [annotation.property = resolve(AnnotationProperty, propertyIri)]
		annotation.value = value
		axiom.ownedAnnotations += annotation
		return annotation
	}

	def addAnnotation(Assertion assertion, String propertyIri, Literal value) {
		val annotation = create(Annotation)
		defer.add [annotation.property = resolve(AnnotationProperty, propertyIri)]
		annotation.value = value
		assertion.ownedAnnotations += annotation
		return annotation
	}

	// Ontology
	
	def <T extends Ontology> createOntology(Class<T> type, String iri, SeparatorKind separator, String prefix, URI resourceURI) {
		val ontology = create(type)
		ontology.iri = iri
		ontology.separator = separator
		ontology.prefix = prefix
		ontology.addToNewResource(resourceURI)
		return ontology
	}

	// Vocabulary

	def createVocabulary(String iri, SeparatorKind separator, String name, URI resourceURI) {
		return createOntology(Vocabulary, iri, separator, name, resourceURI)
	}

	// Bundle
	
	def createBundle(String iri, SeparatorKind separator, String name, URI resourceURI) {
		return createOntology(Bundle, iri, separator, name, resourceURI)
	}

	// Description
	
	def createDescription(String iri, SeparatorKind separator, String name, URI resourceURI) {
		return createOntology(Description, iri, separator, name, resourceURI)
	}

	// Aspect

	def addAspect(Vocabulary vocabulary, String name) {
		val aspect = create(Aspect)
		aspect.name = name
		vocabulary.ownedStatements += aspect
		return aspect
	}
	
	// Concept

	def addConcept(Vocabulary vocabulary, String name) {
		val concept = create(Concept)
		concept.name = name
		vocabulary.ownedStatements += concept
		return concept
	}

	// RelationEntity
	
	def addRelationEntity(Vocabulary vocabulary, String name, String sourceIri, String targetIri, 
		boolean functional, boolean inverseFunctional, boolean symmetric, 
		boolean asymmetric, boolean reflexive, boolean irreflexive, boolean transitive) {
		val relation = create(RelationEntity)
		relation.name = name
		defer.add [relation.source = resolve(Entity, sourceIri)]
		defer.add [relation.target = resolve(Entity, targetIri)]
		relation.functional = functional
		relation.inverseFunctional = inverseFunctional
		relation.symmetric = symmetric
		relation.asymmetric = asymmetric
		relation.reflexive = reflexive
		relation.irreflexive = irreflexive
		relation.transitive = transitive
		vocabulary.ownedStatements += relation
		return relation
	}

	// Structure

	def addStructure(Vocabulary vocabulary, String name) {
		val structure = create(Structure)
		structure.name = name
		vocabulary.ownedStatements += structure
		return structure
	}
	
	// AnnotationProperty

	def addAnnotationProperty(Vocabulary vocabulary, String name) {
		val property = create(AnnotationProperty)
		property.name = name
		vocabulary.ownedStatements += property
		return property
	}
	
	// ScalarProperty

	def addScalarProperty(Vocabulary vocabulary, String name,
		String domainIri, String rangeIri, boolean functional) {
		val property = create(ScalarProperty)
		property.name = name
		defer.add [property.domain = resolve(Classifier, domainIri)]
		defer.add [property.range = resolve(Scalar, rangeIri)]
		property.functional = functional
		vocabulary.ownedStatements += property
		return property
	}
	
	// StructuredProperty

	def addStructuredProperty(Vocabulary vocabulary, String name, 
		String domainIri, String rangeIri, boolean functional) {
		val property = create(StructuredProperty)
		property.name = name
		defer.add [property.domain = resolve(Classifier, domainIri)]
		defer.add [property.range = resolve(Structure, rangeIri)]
		property.functional = functional
		vocabulary.ownedStatements += property
		return property
	}
	
	// FacetedScalar

	def addFacetedScalar(Vocabulary vocabulary, String name, Long length, Long minLength, Long maxLength, String pattern, 
		String language, Literal minInclusive, Literal minExclusive, Literal maxInclusive, Literal maxExclusive) {
		val scalar = create(FacetedScalar)
		scalar.name = name
		scalar.length = length
		scalar.minLength = minLength
		scalar.maxLength = maxLength
		scalar.pattern = pattern
		scalar.language = language
		scalar.minInclusive = minInclusive
		scalar.minExclusive = minExclusive
		scalar.maxInclusive = maxInclusive
		scalar.maxExclusive = maxExclusive
		vocabulary.ownedStatements += scalar
		return scalar
	}
		
	// EnumeratedScalar

	def addEnumeratedScalar(Vocabulary vocabulary, String name, Literal...literals) {
		val scalar = create(EnumeratedScalar)
		scalar.name = name
		scalar.literals += literals
		vocabulary.ownedStatements += scalar
		return scalar
	}
	
	// ForwardRelation

	def addForwardRelation(RelationEntity entity, String name) {
		val forward = create(ForwardRelation)
		forward.name = name
		entity.forward = forward
		return forward
	}

	// ReverseRelation

	def addReverseRelation(RelationEntity entity, String name) {
		val reverse = create(ReverseRelation)
		reverse.name = name
		entity.reverse = reverse
		return reverse
	}
	
	// Rule

	def addRule(Vocabulary vocabulary, String name, Predicate[] consequent, Predicate[] antecedent) {
		val rule = create(Rule)
		rule.name = name
		rule.consequent += consequent
		rule.antecedent += antecedent
		vocabulary.ownedStatements += rule
		return rule
	}
	
	// StructureInstance

	def createStructureInstance(String structureIri) {
		val instance = create(StructureInstance)
		defer.add [instance.type = resolve(Structure, structureIri)]
		return instance
	}
	
	// ConceptInstance

	def addConceptInstance(Description description, String name) {
		val instance = create(ConceptInstance)
		instance.name = name
		description.ownedStatements += instance
		return instance
	}
	
	// RelationInstance

	def addRelationInstance(Description description, String name, String sourceIri, String targetIri) {
		val instance = create(RelationInstance)
		instance.name = name
		defer.add [instance.source = resolve(NamedInstance, sourceIri)]
		defer.add [instance.target = resolve(NamedInstance, targetIri)]
		description.ownedStatements += instance
		return instance
	}

	// AspectReference
	
	def dispatch createReference(Aspect aspect) {
		val reference = create(AspectReference)
		reference.aspect = aspect
		return reference
	}

	// ConceptReference

	def dispatch createReference(Concept concept) {
		val reference = create(ConceptReference)
		reference.concept = concept
		return reference
	}
	
	// RelationEntityReference

	protected def dispatch createReference(RelationEntity entity) {
		val reference = create(RelationEntityReference)
		reference.entity = entity
		return reference
	}
	
	// StructureReference

	protected def dispatch createReference(Structure structure) {
		val reference = create(StructureReference)
		reference.structure = structure
		return reference
	}
	
	// AnnotationPropertyReference

	protected def dispatch createReference(AnnotationProperty property) {
		val reference = create(AnnotationPropertyReference)
		reference.property = property
		return reference
	}

	// ScalarPropertyReference

	protected def dispatch createReference(ScalarProperty property) {
		val reference = create(ScalarPropertyReference)
		reference.property = property
		return reference
	}
	
	// StructuredPropertyReference

	protected def dispatch createReference(StructuredProperty property) {
		val reference = create(StructuredPropertyReference)
		reference.property = property
		return reference
	}
	
	// FacetedScalarReference

	protected def dispatch createReference(FacetedScalar scalar) {
		val reference = create(FacetedScalarReference)
		reference.scalar = scalar
		return reference
	}
	
	// EnumeratedScalarReference

	protected def dispatch createReference(EnumeratedScalar scalar) {
		val reference = create(EnumeratedScalarReference)
		reference.scalar = scalar
		return reference
	}

	// RelationReference

	protected def dispatch createReference(Relation relation) {
		val reference = create(RelationReference)
		reference.relation = relation
		return reference
	}
	
	// RuleReference

	protected def dispatch createReference(Rule rule) {
		val reference = create(RuleReference)
		reference.rule = rule
		return reference
	}
	
	// IndividualReference

	protected def dispatch createReference(ConceptInstance instance) {
		val reference = create(ConceptInstanceReference)
		reference.instance = instance
		return reference
	}

	// RelationInstanceReference

	protected def dispatch createReference(RelationInstance instance) {
		val reference = create(RelationInstanceReference)
		reference.instance = instance
		return reference
	}
	
	// VocabularyExtension
	
	def addVocabularyExtension(Vocabulary vocabulary, String extenedVocabularyURI, String extenedVocabularyPrefix) {
		val _extension = create(VocabularyExtension)
		_extension.uri = extenedVocabularyURI
		_extension.prefix = extenedVocabularyPrefix
		vocabulary.ownedImports += _extension
		return _extension
	}

	// VocabularyUsage
	
	def addVocabularyUsage(Vocabulary vocabulary, String usingVocabularyURI, String usedDescriptionPrefix) {
		val _extension = create(VocabularyUsage)
		_extension.uri = usingVocabularyURI
		_extension.prefix = usedDescriptionPrefix
		vocabulary.ownedImports += _extension
		return _extension
	}

	// BundleInclusion
	
	def addBundleInclusion(Bundle bundle, String includedVocabularyURI, String includedVocabularyPrefix) {
		val inclusion = create(BundleInclusion)
		inclusion.uri = includedVocabularyURI
		inclusion.prefix = includedVocabularyPrefix
		bundle.ownedImports += inclusion
		return inclusion
	}

	// BundleExtension
	
	def addBundleExtension(Bundle bundle, String extenedBundleURI, String extenedBundlePrefix) {
		val _extension = create(BundleExtension)
		_extension.uri = extenedBundleURI
		_extension.prefix = extenedBundlePrefix
		bundle.ownedImports += _extension
		return _extension
	}

	// DescriptionUsage

	def addDescriptionUsage(Description description, String extenedTerminologyURI, String extenedTerminologyPrefix) {
		val usage = create(DescriptionUsage)
		usage.uri = extenedTerminologyURI
		usage.prefix = extenedTerminologyPrefix
		description.ownedImports += usage
		return usage
	}
	
	// DescriptionExtension	

	def addDescriptionExtension(Description description, String extenedDescriptionURI, String extenedDescriptionPrefix) {
		val _extension = create(DescriptionExtension)
		_extension.uri = extenedDescriptionURI
		_extension.prefix = extenedDescriptionPrefix
		description.ownedImports += _extension
		return _extension
	}
	
	// SpecializationAxiom

	def addSpecializationAxiom(Vocabulary vocabulary, String specializingIri, String specializedIri) {
		val axiom = create(SpecializationAxiom)
		defer.add [axiom.specializedTerm = resolve(SpecializableTerm, specializedIri)]
		defer.add [
			val specializing = resolve(SpecializableTerm, specializingIri)
			if (specializing.vocabulary == vocabulary) {
				specializing.ownedSpecializations += axiom
			} else {
				vocabulary.getOrAddReference(specializing, SpecializableTermReference).ownedSpecializations += axiom 
			}
		]
		return axiom
	}
	
	// ScalarPropertyRangeRestrictionAxiom

	def addScalarPropertyRangeRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, String rangeIri, RangeRestrictionKind kind) {
		val axiom = create(ScalarPropertyRangeRestrictionAxiom)
		axiom.kind = kind
		defer.add [axiom.property = resolve(ScalarProperty, propertyIri)]
		defer.add [axiom.range = resolve(Scalar, rangeIri)]
		defer.add [
			val type = resolve(Classifier, typeIri)
			if (type.vocabulary == vocabulary) {
				type.ownedPropertyRestrictions += axiom
			} else {
				vocabulary.getOrAddReference(type, ClassifierReference).ownedPropertyRestrictions += axiom 
			}
		]
		return axiom
	}

	// ScalarPropertyCardinalityRestrictionAxiom

	def addScalarPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, String entityIri, String propertyIri, CardinalityRestrictionKind kind, long cardinality, String rangeIri) {
		val axiom = create(ScalarPropertyCardinalityRestrictionAxiom)
		defer.add [axiom.property = resolve(ScalarProperty, propertyIri)]
		axiom.kind = kind
		axiom.cardinality = cardinality
		defer.add [axiom.range = resolve(Scalar, rangeIri)]
		defer.add [
			val entity = resolve(Entity, entityIri)
			if (entity.vocabulary == vocabulary) {
				entity.ownedPropertyRestrictions += axiom
			} else {
				vocabulary.getOrAddReference(entity, EntityReference).ownedPropertyRestrictions += axiom 
			}
		]
		return axiom
	}

	// ScalarPropertyValueRestrictionAxiom

	def addScalarPropertyValueRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, Literal value) {
		val axiom = create(ScalarPropertyValueRestrictionAxiom)
		defer.add [axiom.property = resolve(ScalarProperty, propertyIri)]
		axiom.value = value
		defer.add [
			val type = resolve(Classifier, typeIri)
			if (type.vocabulary == vocabulary) {
				type.ownedPropertyRestrictions += axiom
			} else {
				vocabulary.getOrAddReference(type, ClassifierReference).ownedPropertyRestrictions += axiom 
			}
		]
		return axiom
	}

	// StructuredPropertyRangeRestrictionAxiom

	def addStructuredPropertyRangeRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, String rangeIri, RangeRestrictionKind kind) {
		val axiom = create(StructuredPropertyRangeRestrictionAxiom)
		axiom.kind = kind
		defer.add [axiom.property = resolve(StructuredProperty, propertyIri)]
		defer.add [axiom.range = resolve(Structure, rangeIri)]
		defer.add [
			val type = resolve(Classifier, typeIri)
			if (type.vocabulary == vocabulary) {
				type.ownedPropertyRestrictions += axiom
			} else {
				vocabulary.getOrAddReference(type, ClassifierReference).ownedPropertyRestrictions += axiom 
			}
		]
		return axiom
	}

	// StructuredPropertyCardinalityRestrictionAxiom

	def addStructuredPropertyCardinalityRestrictionAxiom(Vocabulary vocabulary, String entityIri, String propertyIri, CardinalityRestrictionKind kind, long cardinality, String rangeIri) {
		val axiom = create(StructuredPropertyCardinalityRestrictionAxiom)
		defer.add [axiom.property = resolve(StructuredProperty, propertyIri)]
		axiom.kind = kind
		axiom.cardinality = cardinality
		defer.add [axiom.range = resolve(Structure, rangeIri)]
		defer.add [
			val entity = resolve(Entity, entityIri)
			if (entity.vocabulary == vocabulary) {
				entity.ownedPropertyRestrictions += axiom
			} else {
				vocabulary.getOrAddReference(entity, EntityReference).ownedPropertyRestrictions += axiom 
			}
		]
		return axiom
	}

	// StructuredPropertyValueRestrictionAxiom
	
	def addStructuredPropertyValueRestrictionAxiom(Vocabulary vocabulary, String typeIri, String propertyIri, StructureInstance value) {
		val axiom = create(StructuredPropertyValueRestrictionAxiom)
		defer.add [axiom.property = resolve(StructuredProperty, propertyIri)]
		axiom.value = value
		defer.add [
			val type = resolve(Classifier, typeIri)
			if (type.vocabulary == vocabulary) {
				type.ownedPropertyRestrictions += axiom
			} else {
				vocabulary.getOrAddReference(type, ClassifierReference).ownedPropertyRestrictions += axiom 
			}
		]
		return axiom
	}

	// RelationRangeRestrictionAxiom

	def addRelationRangeRestrictionAxiom(Vocabulary vocabulary, String entityIri, String relationIri, String rangeIri, RangeRestrictionKind kind) {
		val axiom = create(RelationRangeRestrictionAxiom)
		axiom.kind = kind
		defer.add [axiom.relation = resolve(Relation, relationIri)]
		defer.add [axiom.range = resolve(Entity, rangeIri)]
		defer.add [
			val entity = resolve(Entity, entityIri)
			if (entity.vocabulary == vocabulary) {
				entity.ownedRelationRestrictions += axiom
			} else {
				vocabulary.getOrAddReference(entity, EntityReference).ownedRelationRestrictions += axiom 
			}
		]
		return axiom
	}
	
	// RelationCardinalityRestrictionAxiom

	def addRelationCardinalityRestrictionAxiom(Vocabulary vocabulary, String entityIri, String relationIri, CardinalityRestrictionKind kind, long cardinality, String rangeIri) {
		val axiom = create(RelationCardinalityRestrictionAxiom)
		defer.add [axiom.relation = resolve(Relation, relationIri)]
		axiom.kind = kind
		axiom.cardinality = cardinality
		defer.add [axiom.range = resolve(Entity, rangeIri)]
		defer.add [
			val entity = resolve(Entity, entityIri)
			if (entity.vocabulary == vocabulary) {
				entity.ownedRelationRestrictions += axiom
			} else {
				vocabulary.getOrAddReference(entity, EntityReference).ownedRelationRestrictions += axiom 
			}
		]
		return axiom
	}

	// RelationTargetRestrictionAxiom
	
	def addRelationTargetRestrictionAxiom(Vocabulary vocabulary, String entityIri, String relationIri, NamedInstance target) {
		val axiom = create(RelationTargetRestrictionAxiom)
		defer.add [axiom.relation = resolve(Relation, relationIri)]
		axiom.target = target
		defer.add [
			val entity = resolve(Entity, entityIri)
			if (entity.vocabulary == vocabulary) {
				entity.ownedRelationRestrictions += axiom
			} else {
				vocabulary.getOrAddReference(entity, EntityReference).ownedRelationRestrictions += axiom 
			}
		]
		return axiom
	}

	// KeyAxiom

	def addKeyAxiom(Vocabulary vocabulary, String entityIri, Iterable<String> keyPropertyIris) {
		val axiom = create(KeyAxiom)
		defer.add [ axiom.properties += keyPropertyIris.map[iri|resolve(ScalarProperty, iri)]]
		defer.add [
			val entity = resolve(Entity, entityIri)
			if (entity.vocabulary == vocabulary) {
				entity.ownedKeys += axiom
			} else {
				vocabulary.getOrAddReference(entity, EntityReference).ownedKeys += axiom 
			}
		]
		return axiom
	}

	// ConceptTypeAssertion
	
	def addConceptTypeAssertion(Description description, String instanceIri, String typeIri) {
		val axiom = create(ConceptTypeAssertion)
		defer.add [axiom.type = resolve(Concept, typeIri)]
		defer.add [
			val instance = resolve(ConceptInstance, instanceIri)
			if (instance.description == description) {
				instance.ownedTypes += axiom
			} else {
				description.getOrAddReference(instance, ConceptInstanceReference).ownedTypes += axiom 
			}
		]
		return axiom
	}

	// RelationTypeAssertion

	def addRelationTypeAssertion(Description description, String instanceIri, String typeIri) {
		val axiom = create(RelationTypeAssertion)
		defer.add [axiom.type = resolve(RelationEntity, typeIri)]
		defer.add [
			val instance = resolve(RelationInstance, instanceIri)
			if (instance.description == description) {
				instance.ownedTypes += axiom
			} else {
				description.getOrAddReference(instance, RelationInstanceReference).ownedTypes += axiom 
			}
		]
		return axiom
	}

	// ScalarPropertyValueAssertion

	def addScalarPropertyValueAssertion(Description description, String instanceIri, String propertyIri, Literal value) {
		val assertion = create(ScalarPropertyValueAssertion)
		defer.add [assertion.property = resolve(ScalarProperty, propertyIri)]
		assertion.value = value
		defer.add [		
			val instance = resolve(NamedInstance, instanceIri)
			if (instance.description == description) {
				instance.ownedPropertyValues += assertion
			} else {
				description.getOrAddReference(instance, NamedInstanceReference).ownedPropertyValues += assertion 
			}
		]
		return assertion
	}

	def addScalarPropertyValueAssertion(Description description, StructureInstance instance, String propertyIri, Literal value) {
		val assertion = create(ScalarPropertyValueAssertion)
		defer.add [assertion.property = resolve(ScalarProperty, propertyIri)]
		assertion.value = value
		instance.ownedPropertyValues += assertion
		return assertion
	}
		
	// StructuredPropertyValueAssertion

	def addStructuredPropertyValueAssertion(Description description, String instanceIri, String propertyIri, StructureInstance value) {
		val assertion = create(StructuredPropertyValueAssertion)
		assertion.value = value
		defer.add [assertion.property = resolve(StructuredProperty, propertyIri)]
		defer.add [
			val instance = resolve(NamedInstance, instanceIri)
			if (instance.description == description) {
				instance.ownedPropertyValues += assertion
			} else {
				description.getOrAddReference(instance, NamedInstanceReference).ownedPropertyValues += assertion 
			}
		]
		return assertion
	}

	def addStructuredPropertyValueAssertion(StructureInstance instance, String propertyIri, StructureInstance value) {
		val assertion = create(StructuredPropertyValueAssertion)
		defer.add [assertion.property = resolve(StructuredProperty, propertyIri)]
		assertion.value = value
		instance.ownedPropertyValues += assertion
		return assertion
	}
		
	// LinkAssertion
		
	def addLinkAssertion(Description description, String instanceIri, String relationIri, String targetIri) {
		val assertion = create(LinkAssertion)
		defer.add [assertion.relation = resolve(Relation, relationIri)]
		defer.add [assertion.target = resolve(NamedInstance, targetIri)]
		defer.add [
			val instance = resolve(NamedInstance, instanceIri)
			if (instance.description == description) {
				instance.ownedLinks += assertion
			} else {
				description.getOrAddReference(instance, NamedInstanceReference).ownedLinks += assertion 
			}
		]
		return assertion
	}

	// EntityPredicate

	def createEntityPredicate(String entityIri, String variable) {
		val predicate = create(EntityPredicate)
		defer.add [predicate.entity = resolve(Entity, entityIri)]
		predicate.variable = variable
		return predicate
	}
	
	// RelationPredicate

	def createRelationPredicate(String relationIri, String variable1, String variable2) {
		val predicate = create(RelationPredicate)
		defer.add [predicate.relation = resolve(Relation, relationIri)]
		predicate.variable1 = variable1
		predicate.variable2 = variable2
		return predicate
	}
		
	// SameAsPredicate

	def createSameAsPredicate(String variable1, String variable2) {
		val predicate = create(SameAsPredicate)
		predicate.variable1 = variable1
		predicate.variable2 = variable2
		return predicate
	}

	// DifferentFromPredicate

	def createDifferentFromPredicate(String variable1, String variable2) {
		val predicate = create(DifferentFromPredicate)
		predicate.variable1 = variable1
		predicate.variable2 = variable2
		return predicate
	}

	// RelationEntityPredicate

	def createRelationEntityPredicate(String entityIri, String variable1, String entityVariable, String variable2) {
		val predicate = create(RelationEntityPredicate)
		defer.add [predicate.entity = resolve(RelationEntity, entityIri)]
		predicate.variable1 = variable1
		predicate.entityVariable = entityVariable
		predicate.variable2 = variable2
		return predicate
	}

	// QuotedLiteral

	def createQuotedLiteral(String value, String typeIri, String langTag) {
		val literal = create(QuotedLiteral)
		literal.value = value
		if (typeIri !== null) {
			defer.add [literal.type = resolve(Scalar, typeIri)]
		} else if (langTag !== null) {
			literal.langTag = langTag
		}
		return literal
	}
		
	// IntegerLiteral

	def createIntegerLiteral(int value, String typeIri) {
		val literal = create(IntegerLiteral)
		literal.value = value
		if (typeIri !== null) {
			defer.add [literal.type = resolve(Scalar, typeIri)]
		}
		return literal
	}
		
	// DecimalLiteral

	def createDecimalLiteral(BigDecimal value, String typeIri) {
		val literal = create(DecimalLiteral)
		literal.value = value
		if (typeIri !== null) {
			defer.add [literal.type = resolve(Scalar, typeIri)]
		}
		return literal
	}

	// DoubleLiteral

	def createDoubleLiteral(double value, String typeIri) {
		val literal = create(DoubleLiteral)
		literal.value = value
		if (typeIri !== null) {
			defer.add [literal.type = resolve(Scalar, typeIri)]
		}
		return literal
	}

	// BooleanLiteral
	
	def createBooleanLiteral(boolean value, String typeIri) {
		val literal = create(BooleanLiteral)
		literal.value = value
		if (typeIri !== null) {
			defer.add [literal.type = resolve(Scalar, typeIri)]
		}
		return literal
	}
	
}