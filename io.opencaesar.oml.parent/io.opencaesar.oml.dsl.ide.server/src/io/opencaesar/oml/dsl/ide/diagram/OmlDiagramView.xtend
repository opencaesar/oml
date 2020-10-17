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
package io.opencaesar.oml.dsl.ide.diagram

import io.opencaesar.oml.Annotation
import io.opencaesar.oml.AnnotatedElement
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.Classifier
import io.opencaesar.oml.Concept
import io.opencaesar.oml.DifferentFromPredicate
import io.opencaesar.oml.Element
import io.opencaesar.oml.EntityPredicate
import io.opencaesar.oml.IdentifiedElement
import io.opencaesar.oml.Import
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.Predicate
import io.opencaesar.oml.RangeRestrictionKind
import io.opencaesar.oml.Reference
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.RelationEntityPredicate
import io.opencaesar.oml.RelationPredicate
import io.opencaesar.oml.RelationRangeRestrictionAxiom
import io.opencaesar.oml.Rule
import io.opencaesar.oml.SameAsPredicate
import io.opencaesar.oml.Scalar
import io.opencaesar.oml.ScalarProperty
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.Structure
import io.opencaesar.oml.StructuredProperty
import java.util.ArrayList
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.sprotty.LayoutOptions
import org.eclipse.sprotty.SModelElement
import org.eclipse.sprotty.util.IdCache

import static extension io.opencaesar.oml.util.OmlRead.*
import io.opencaesar.oml.KeyAxiom
import io.opencaesar.oml.Entity
import io.opencaesar.oml.RelationTargetRestrictionAxiom
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom
import io.opencaesar.oml.CardinalityRestrictionKind
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom
import io.opencaesar.oml.ConceptInstance

class OmlDiagramView {

	public static val String diagramIRI = "http://opencaesar.io/diagram"

	val Ontology ontology
	val IdCache<EObject> idCache
	var Map<EObject, Iterable<Annotation>> semantic2diagramAnnotations
	public val OmlOntologyScopeCalculator scope

	new(Ontology ontology, IdCache<EObject> idCache) {
		this.ontology = ontology
		this.idCache = idCache
		this.semantic2diagramAnnotations = new HashMap
		this.scope = new OmlOntologyScopeCalculator(ontology).analyze()
	}

	// GRAPHS
	
	def OmlGraph createGraph() {
		val id = idCache.uniqueId('root')
		newSElement(OmlGraph, id, 'graph') => [
			layoutOptions = new LayoutOptions [
				HAlign = 'left'
				HGap = 10.0
			]
		]
	}

	// NODES
	
	def OmlNode createNode(Ontology ontology) {
		val id = idCache.uniqueId(ontology, ontology.localName)
		newSElement(OmlNode, id, 'node:module') => [
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingTop = 5.0
				paddingBottom = 5.0
				paddingLeft = 5.0
				paddingRight = 5.0
			]
			children += newSElement(OmlCompartment, id + '.heading', 'comp:comp') => [
				layout = 'hbox'
				children += newSElement(OmlLabel, id + '.label', 'label:heading') => [
					text = id
				]
				children += newSElement(OmlButton, id + '.expand', 'button:expand')
			]
		]
	}

	def OmlNode createNode(Aspect aspect, Iterable<KeyAxiom> keys) {
		val id = idCache.uniqueId(aspect, aspect.localName)
		newSElement(OmlNode, id, 'node:class') => [
			cssClass = 'moduleNode'
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
			children += newTaggedHeader(id, 'A')
			keys.forEach [ k |
				children += aspect.createLabel(k)
			]
		]
	}

	def OmlNode createNode(Concept concept, Iterable<KeyAxiom> keys) {
		val id = idCache.uniqueId(concept, concept.localName)
		newSElement(OmlNode, id, 'node:class') => [
			cssClass = 'moduleNode'
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
			children += newTaggedHeader(id, 'C')
			keys.forEach [ k |
				children += concept.createLabel(k)
			]
		]
	}

	def OmlNode createNode(RelationEntity entity, SModelElement from, SModelElement to, Iterable<KeyAxiom> keys) {
		val id = idCache.uniqueId(entity, entity.localName)
		val node = newSElement(OmlNode, id, 'node:class') => [
			cssClass = 'moduleNode'
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
			children += newTaggedHeader(id, 'R')
			keys.forEach [ k |
				children += entity.createLabel(k)
			]
		]
		val edge1 = newEdge(from, node, id + '.start', "edge:straight")
		node.children += edge1
		val edge2 = newEdge(node, to, id + '.end', "edge:augments")
		node.children += edge2

		return node
	}

	def OmlNode createNode(Structure structure) {
		val id = idCache.uniqueId(structure, structure.localName)
		newSElement(OmlNode, id, 'node:class') => [
			cssClass = 'moduleNode'
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
			children += newTaggedHeader(id, 'S')
		]
	}

	def OmlNode createNode(Scalar scalar) {
		val id = idCache.uniqueId(scalar, scalar.localName)
		newSElement(OmlNode, id, 'node:class') => [
			cssClass = 'moduleNode'
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
			children += newTaggedHeader(id, 'C')
		]
	}

	def OmlNode createNode(Rule rule) {
		val id = idCache.uniqueId(rule, rule.localName)
		newSElement(OmlNode, id, 'node:class') => [
			cssClass = 'moduleNode'
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
			children += newTaglessHeader(id)
		]
	}

	def OmlNode createNode(ConceptInstance ci) {
		val id = idCache.uniqueId(ci, ci.localName)
		newSElement(OmlNode, id, 'node:class') => [
			cssClass = 'moduleNode'
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
			children += newTaggedHeader(id, 'CI')
		]
	}
	
	// COMPARTMENTS
	
	def OmlCompartment getPropertyCompartment(SModelElement element) {
		element.children.filter[id.endsWith('.property.compartment')].head as OmlCompartment
	}

	def OmlCompartment createPropertyCompartment(Classifier classifier) {
		val id = idCache.uniqueId(classifier, classifier.localName + '.property.compartment')
		newCompartment(id, 'comp:comp')
	}

	def OmlCompartment getAntecedentCompartment(SModelElement element) {
		element.children.filter[id.endsWith('.antecedent.compartment')].head as OmlCompartment
	}

	def OmlCompartment createAntecedentCompartment(Rule rule) {
		val id = idCache.getId(rule)
		newCompartment(id + '.antecedent.compartment', 'comp:comp')
	}

	def OmlCompartment getConsequentCompartment(SModelElement element) {
		element.children.filter[id.endsWith('.consequent.compartment')].head as OmlCompartment
	}

	def OmlCompartment createConsequentCompartment(Rule rule) {
		val id = idCache.getId(rule)
		newCompartment(id + '.consequent.compartment', 'comp:comp')
	}

	// LABELS
	def OmlLabel createLabel(Classifier cls, ScalarProperty property) {
		val id = idCache.uniqueId(property, cls.localName + '.' + property.localName)
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = property.name + ': ' + property.range.name
		]
	}

	def OmlLabel createLabel(Classifier cls, StructuredProperty property) {
		val id = idCache.uniqueId(property, cls.localName + '.' + property.localName)
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = '(R) ' + property.name + ': ' + property.range.name
		]
	}

	def OmlLabel createLabel(Entity e, KeyAxiom ax) {
		val id = idCache.uniqueId(ax, e.localName + '.key')
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = 'key: ' + ax.properties.map[abbreviatedIri].join(', ')
		]
	}

	def OmlLabel createLabel(Entity e, ScalarPropertyCardinalityRestrictionAxiom ax) {
		val id = idCache.uniqueId(ax, e.localName + '.cardinalityRestriction.' + ax.property.localName)
		val notation = switch ax.kind {
			case CardinalityRestrictionKind.EXACTLY:
				' = '
			case CardinalityRestrictionKind.MIN:
				' \u2265 '
			case CardinalityRestrictionKind.MAX:
				' \u2264 '
		}
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = ax.property.localName + notation + ax.cardinality
		]
	}

	def OmlLabel createLabel(Entity e, ScalarPropertyRangeRestrictionAxiom ax) {
		val id = idCache.uniqueId(ax, e.localName + '.rangeRestriction.' + ax.property.localName)
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = ax.property.localName + ' \u2282 ' + ax.range.localName
		]
	}

	def OmlLabel createLabel(Entity e, ScalarPropertyValueRestrictionAxiom ax) {
		val id = idCache.uniqueId(ax, e.localName + '.valueRestriction.' + ax.property.localName)
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = ax.property.localName + ' = ' + ax.value.lexicalValue
		]
	}

	def OmlLabel createAntecedentLabel(Predicate predicate) {
		val rule = predicate.antecedentRule
		val id = idCache.uniqueId(predicate, rule.localName + '.antecedent.' + rule.antecedent.indexOf(predicate))
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = predicate.toText
		]
	}

	def OmlLabel createConsequentLabel(RelationPredicate predicate) {
		val rule = predicate.consequentRule
		val id = idCache.uniqueId(predicate, rule.localName + '.consequent')
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = predicate.toText
		]
	}

	private def String toText(Predicate predicate) {
		switch predicate {
			EntityPredicate: predicate.entity.name + '(' + predicate.variable + ')'
			SameAsPredicate: 'SameAs' + '(' + predicate.variable1 + ', ' + predicate.variable2 + ')'
			DifferentFromPredicate: 'DifferentFrom' + '(' + predicate.variable1 + ', ' + predicate.variable2 + ')'
			RelationPredicate: predicate.relation.name + '(' + predicate.variable1 + ',' + predicate.variable2 + ')'
			RelationEntityPredicate: predicate.entity.name + '(' + predicate.variable1 + ', ' +
				predicate.entityVariable + ', ' + predicate.variable2 + ')'
			default: ''
		}
	}

	// EDGES
	def OmlEdge createEdge(Import _import, SModelElement from, SModelElement to) {
		val id = idCache.uniqueId('imports')
		newEdge(from, to, id, 'edge:import') => [
			children += newLeafSElement(OmlLabel, id + '.label', 'label:text') => [
				text = 'imports'
			]
		]
	}

	def OmlEdge createEdge(SpecializationAxiom axiom, SModelElement from, SModelElement to) {
		val id = idCache.uniqueId(axiom, from.id + '.specializes.' + to.id)
		newEdge(from, to, id, "edge:uses")
	}

	def OmlEdge createEdge(RelationEntity entity, SModelElement from, SModelElement to) {
		val id = idCache.uniqueId(entity, entity.forward.localName)
		newEdge(from, to, id, "edge:augments") => [
			children += newLeafSElement(OmlLabel, id + '.forward.label', 'label:relationship') => [
				text = entity.forward.localName
			]
		]
	}

	def OmlEdge createEdge(RelationCardinalityRestrictionAxiom axiom, SModelElement from, SModelElement to) {
		val id = idCache.uniqueId(axiom, from.id + '.restrictsCardinality.' + axiom.relation.localName)
		newEdge(from, to, id, 'edge:restricts') => [
			children += newLeafSElement(OmlLabel, id + '.label', 'label:restricts') => [
				val notation = switch axiom.kind {
					case CardinalityRestrictionKind.EXACTLY:
						' = '
					case CardinalityRestrictionKind.MIN:
						' \u2265 '
					case CardinalityRestrictionKind.MAX:
						' \u2264 '
				}
				text = axiom.relation.localName + notation + axiom.cardinality
			]
		]
	}

	def OmlEdge createEdge(RelationRangeRestrictionAxiom axiom, SModelElement from, SModelElement to) {
		val id = idCache.uniqueId(axiom, from.id + '.restrictsRange.' + axiom.relation.localName)
		newEdge(from, to, id, 'edge:restricts') => [
			children += newLeafSElement(OmlLabel, id + '.label', 'label:restricts') => [
				val notation = if(axiom.kind == RangeRestrictionKind.ALL) '\u2200' else '\u2203'
				text = notation + axiom.relation.localName
			]
		]
	}

	def OmlEdge createEdge(RelationTargetRestrictionAxiom axiom, SModelElement from, SModelElement to) {
		val id = idCache.uniqueId(axiom, from.id + '.restrictsTarget.' + axiom.relation.localName)
		newEdge(from, to, id, 'edge:restricts') => [
			children += newLeafSElement(OmlLabel, id + '.label', 'label:restricts') => [
				text = axiom.relation.localName + ' \u2282 '
			]
		]
	}

//------------------- HELPERS
	def boolean isDiagramVocabulary(Ontology o) {
		return o.iri == diagramIRI
	}

	def boolean isDiagramAnnotation(Annotation a) {
		val c = a.property.eContainer
		if (c instanceof IdentifiedElement) {
			return c.iri == diagramIRI
		}
		return false
	}

	def Iterable<Annotation> getDiagramAnnotations(EObject eObject) {
		var annotations = semantic2diagramAnnotations.get(eObject)
		if (annotations === null) {
			if (eObject instanceof AnnotatedElement) {
				annotations = eObject.ownedAnnotations.filter [ a |
					a.diagramAnnotation
				]
			} else if (eObject instanceof Reference) {
				annotations = eObject.ownedAnnotations.filter [ a |
					a.diagramAnnotation
				]
			}
			semantic2diagramAnnotations.put(eObject, annotations)
		}
		return annotations
	}

	private def <E extends SModelElement> E newSElement(Class<E> diagramElementClass, String idStr, String typeStr) {
		newLeafSElement(diagramElementClass, idStr, typeStr) => [
			children = new ArrayList<SModelElement>
		]
	}

	private def <E extends SModelElement> E newLeafSElement(Class<E> diagramElementClass, String idStr,
		String typeStr) {
		diagramElementClass.constructor.newInstance => [
			id = idStr
			type = typeStr
		]
	}

	private def OmlHeader newTaggedHeader(String id, String tag) {
		newSElement(OmlHeader, id + '.header', 'comp:classHeader') => [
			layout = 'hbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 8.0
				paddingRight = 8.0
				paddingTop = 8.0
				paddingBottom = 8.0
			]
			children = #[
				new OmlTag => [
					it.id = id + '.header.tag'
					type = 'tag'
					layout = 'stack'
					layoutOptions = new LayoutOptions [
						resizeContainer = false
						HAlign = 'center'
						VAlign = 'center'
					]
					children = #[
						new OmlLabel => [
							type = "label:tag"
							it.id = id + '.tag.text'
							text = tag
						]
					]
				],
				new OmlLabel => [
					type = "label:editable"
					it.id = id + '.header.label'
					text = id
				]
			]
		]
	}

	private def OmlTag newTaglessHeader(String id) {
		newSElement(OmlTag, id + '.header', 'comp:classHeader') => [
			layout = 'hbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 8.0
				paddingRight = 8.0
				paddingTop = 8.0
				paddingBottom = 8.0
			]
			children = #[
				new OmlLabel => [
					type = "label:classHeader"
					it.id = id + '.header.label'
					text = id
				]
			]
		]
	}

	def OmlEdge newEdge(SModelElement fromElement, SModelElement toElement, String edgeId, String edgeType) {
		newSElement(OmlEdge, edgeId, edgeType) => [
			sourceId = fromElement.id
			targetId = toElement.id
		]
	}

	private def OmlCompartment newCompartment(String id, String type) {
		newSElement(OmlCompartment, id, type) => [
			layout = 'vbox'
			layoutOptions = new LayoutOptions([
				paddingLeft = 12.0
				paddingRight = 12.0
				paddingTop = 12.0
				paddingBottom = 12.0
				VGap = 2.0
			])
			children = new ArrayList<SModelElement>
		]
	}

	private def String getLocalName(Element element) {
		if (element instanceof IdentifiedElement) {
			element.getNameIn(ontology)
		} else if (element instanceof Reference) {
			element.resolvedName
		}
	}
}
