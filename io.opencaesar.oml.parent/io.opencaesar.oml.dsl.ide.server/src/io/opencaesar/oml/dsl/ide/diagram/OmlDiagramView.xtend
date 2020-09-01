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
import org.eclipse.emf.ecore.EObject
import org.eclipse.sprotty.LayoutOptions
import org.eclipse.sprotty.SModelElement
import org.eclipse.sprotty.util.IdCache

import static extension io.opencaesar.oml.util.OmlRead.*
import io.opencaesar.oml.AspectReference
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.Member
import io.opencaesar.oml.RelationEntityReference
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.ConceptInstanceReference
import io.opencaesar.oml.RelationInstance
import io.opencaesar.oml.LinkAssertion
import io.opencaesar.oml.ScalarPropertyValueAssertion
import io.opencaesar.oml.QuotedLiteral

class OmlDiagramView {
	
	val Ontology ontology
	val IdCache<EObject> idCache
	
	new(Ontology ontology, IdCache<EObject> idCache) {
		this.ontology = ontology
		this.idCache = idCache
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
			children += newSElement(OmlCompartment, id+'.heading', 'comp:comp') => [
				layout = 'hbox'
				children += newSElement(OmlLabel, id+'.label', 'label:heading') => [
					text = id
				]
				children += newSElement(OmlButton, id+'.expand', 'button:expand')
			]
		]
	}

	def OmlNode createNode(Aspect aspect, AspectReference ref, String diagramID) {
		val el = ref ?: aspect
		val name = el.localName
        val id = idCache.uniqueId(el, diagramID ?: name)
		newSElement(OmlNode, id, 'node:class') => [
			cssClass = 'moduleNode'
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
			children += newTaggedHeader(id, 'aspect', name)
		]
	}

	def OmlNode createNode(Concept concept, ConceptReference ref, String diagramID) {
        val el = ref ?: concept
        val name = el.localName
        val idMod = diagramID ?: ''
        val id = idCache.uniqueId(el, name + idMod)
        newSElement(OmlNode, id, 'node:class') => [
            cssClass = 'moduleNode'
            layout = 'vbox'
            layoutOptions = new LayoutOptions [
                paddingLeft = 0.0
                paddingRight = 0.0
                paddingTop = 0.0
                paddingBottom = 0.0
            ]
            children += newTaggedHeader(id, 'concept', name)
        ]
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
			children += newTaggedHeader(id, 'structure')
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
			children += newTaggedHeader(id, 'scalar')
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
	
    
    def OmlNode createNode(ConceptInstance ci, ConceptInstanceReference ref, String diagramID) {
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
            children += newTaggedHeader(id, "concept instance")
        ]
    }

	// COMPARTMENTS

	def OmlCompartment getPropertyCompartment(SModelElement element) {
		element.children.
			filter[id.endsWith('.property.compartment')]
                .head as OmlCompartment
	}
	
    def OmlCompartment createPropertyCompartment(Reference ref) {
        if (ref === null) return null
        
        val id = idCache.getId(ref)
        if (id !== null)
            newCompartment(id + '.property.compartment', 'comp:comp')
        else
            createPropertyCompartment(ref.resolve)
    }
    
	def OmlCompartment createPropertyCompartment(Member member) {
		val id = idCache.getId(member)
		newCompartment(id + '.property.compartment', 'comp:comp')
	}

	def OmlCompartment getAntecedentCompartment(SModelElement element) {
		element.children.
			filter[id.endsWith('.antecedent.compartment')].
			head as OmlCompartment
	}

	def OmlCompartment createAntecedentCompartment(Rule rule) {
		val id = idCache.getId(rule)
		newCompartment(id + '.antecedent.compartment', 'comp:comp')
	}

	def OmlCompartment getConsequentCompartment(SModelElement element) {
		element.children.
			filter[id.endsWith('.consequent.compartment')].
			head as OmlCompartment
	}

	def OmlCompartment createConsequentCompartment(Rule rule) {
		val id = idCache.getId(rule)
		newCompartment(id + '.consequent.compartment', 'comp:comp')
	}

	// LABELS

	def OmlLabel createLabel(ScalarProperty property) {
		val id = idCache.uniqueId(property, property.localName)
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = property.name + ': ' + property.range.name
		]
	}
	
	def OmlLabel createLabel(ScalarPropertyValueAssertion prop) {
	    val id = idCache.uniqueId(prop, prop.property.localName + '-' + getLocalName(prop.eContainer as Element))
	    newLeafSElement(OmlLabel, id, 'label:text') => [
	        text = prop.property.name + ' = ' + prop.resolveValue
	    ]
	}
	
	private def resolveValue(ScalarPropertyValueAssertion prop) {
	    val value = prop.value
	    if (value instanceof QuotedLiteral) {
	        return value.value
	    }
	}
	
	def OmlLabel createLabel(StructuredProperty property) {
		val id = idCache.uniqueId(property, property.localName)
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = '(R) ' + property.name + ': ' + property.range.name
		]
	}

	def OmlLabel createAntecedentLabel(Predicate predicate) {
		val rule = predicate.antecedentRule
		val id = idCache.uniqueId(predicate, rule.localName+'.antecedent.'+rule.antecedent.indexOf(predicate))
		newLeafSElement(OmlLabel, id, 'label:text') => [
			text = predicate.toText
		]
	}

	def OmlLabel createConsequentLabel(RelationPredicate predicate) {
		val rule = predicate.consequentRule
		val id = idCache.uniqueId(predicate, rule.localName+'.consequent')
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
			RelationEntityPredicate: predicate.entity.name + '(' + predicate.variable1 + ', ' + predicate.entityVariable + ', ' + predicate.variable2 + ')'
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
		val id = idCache.uniqueId(axiom, from.id+'.specializes.'+to.id)
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

    def OmlEdge createEdge(RelationInstance instance, SModelElement from, SModelElement to) {
        val id = idCache.uniqueId(instance, instance.localName)
        newEdge(from, to, id, "edge:augments") => [
            children += newLeafSElement(OmlLabel, id + '.forward.label', 'label:relationship') => [
                text = instance.localName
            ]
        ]
    }

	def OmlNode createNode(RelationEntity entity, SModelElement from, SModelElement to) {
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
			children += newTaggedHeader(id, 'relation entity')
		]
		return node
	}
	
    def OmlNode createNode(RelationEntity entity, RelationEntityReference ref) {
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
            children += newTaggedHeader(id, 'relation entity')
        ]
        return node
    }
    
    def OmlNode createNode(RelationInstance instance, SModelElement from, SModelElement to) {
        val id = idCache.uniqueId(instance, instance.localName)
        val node = newSElement(OmlNode, id, 'node:class') => [
            cssClass = 'moduleNode'
            layout = 'vbox'
            layoutOptions = new LayoutOptions [
                paddingLeft = 0.0
                paddingRight = 0.0
                paddingTop = 0.0
                paddingBottom = 0.0
            ]
            children += newTaggedHeader(id, instance.ownedTypes.findFirst[t|t!==null].type.localName)
        ]
        return node
    }
	
    def OmlEdge newEdge(SModelElement fromElement, SModelElement toElement, String edgeId, String edgeType) {
        newSElement(OmlEdge, edgeId, edgeType) => [
            sourceId = fromElement.id
            targetId = toElement.id
        ]
     }

	def OmlEdge createEdge(RelationRangeRestrictionAxiom axiom, SModelElement from, SModelElement to) {
		val id = idCache.uniqueId(axiom, from.id+'.restricts.'+axiom.relation.localName)
		newEdge(from, to, id, 'edge:restricts') => [
			children += newLeafSElement(OmlLabel, id + '.label', 'label:restricts') => [
				val notation = if (axiom.kind == RangeRestrictionKind.ALL) '\u2200' else '\u2203'
				text = notation + axiom.relation.localName
			]
		]
	}
	
    def OmlEdge createEdge(LinkAssertion link, SModelElement from, SModelElement to) {
        val idProposal = from.id + '_' + link.relation.name + '_' + to.id
        val id = idCache.uniqueId(link, idProposal)
        newEdge(from, to, id, "edge:augments") => [
            children += newLeafSElement(OmlLabel, id + '.forward.label', 'label:relationship') => [
                text = link.relation.localName
            ]
        ]
    }
	
    def String getLocalName(Element element) {
        if (element instanceof IdentifiedElement) {
            element.getNameIn(ontology)
        } else if (element instanceof Reference) {
            element.resolvedName
        }
    }
	
//------------------- HELPERS

	private def <E extends SModelElement> E newSElement(Class<E> diagramElementClass, String idStr, String typeStr) {
		newLeafSElement(diagramElementClass, idStr, typeStr) => [
			children = new ArrayList<SModelElement>
		]
	}

	private def <E extends SModelElement> E newLeafSElement(Class<E> diagramElementClass, String idStr, String typeStr) {
		diagramElementClass.constructor.newInstance => [
			id = idStr
			type = typeStr
		]
	}
	
    private def OmlHeader newTaggedHeader(String id, String tag) {
        newSElement(OmlHeader, id + '.header', 'comp:classHeader') => [
            layout = 'vbox'
            layoutOptions = new LayoutOptions [
                paddingLeft = 8.0
                paddingRight = 8.0
                paddingTop = 8.0
                paddingBottom = 8.0
            ]
            children = #[
                new OmlLabel => [
                    type = "label:editable"
                    it.id = id + '.type.label'
                    text = "«" + tag + "»"
                    layoutOptions = new LayoutOptions [
                        HAlign = 'center'
                    ]
                ],
                new OmlLabel => [
                    type = "label:classHeader"
                    it.id = id + '.header.label'
                    text = id
                    layoutOptions = new LayoutOptions [
                        HAlign = 'center'
                    ]
                ]
            ]
        ]
    }

	private def OmlHeader newTaggedHeader(String id, String tag, String name) {
		newSElement(OmlHeader, id + '.header', 'comp:classHeader') => [
			layout = 'vbox'
			layoutOptions = new LayoutOptions [
				paddingLeft = 8.0
				paddingRight = 8.0
				paddingTop = 8.0
				paddingBottom = 8.0
			]
			children = #[
                new OmlLabel => [
                    type = "label:editable"
                    it.id = id + '.type.label'
                    text = "«" + tag + "»"
                    layoutOptions = new LayoutOptions [
                        HAlign = 'center'
                    ]
                ],
				new OmlLabel => [
					type = "label:classHeader"
					it.id = id + '.header.label'
					text = name
					layoutOptions = new LayoutOptions [
					    HAlign = 'center'
					]
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
}