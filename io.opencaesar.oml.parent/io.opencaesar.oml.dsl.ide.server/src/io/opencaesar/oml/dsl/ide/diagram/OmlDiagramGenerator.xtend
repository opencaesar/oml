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

import com.google.inject.Inject
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.Concept
import io.opencaesar.oml.Element
import io.opencaesar.oml.EnumeratedScalarReference
import io.opencaesar.oml.FacetedScalarReference
import io.opencaesar.oml.Import
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.Predicate
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.RelationPredicate
import io.opencaesar.oml.RelationRangeRestrictionAxiom
import io.opencaesar.oml.Rule
import io.opencaesar.oml.RuleReference
import io.opencaesar.oml.Scalar
import io.opencaesar.oml.ScalarProperty
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.Structure
import io.opencaesar.oml.StructuredProperty
import io.opencaesar.oml.util.OmlVisitor
import java.util.HashMap
import java.util.Map
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.sprotty.SModelElement
import org.eclipse.sprotty.SModelRoot
import org.eclipse.sprotty.xtext.IDiagramGenerator
import org.eclipse.sprotty.xtext.SIssueMarkerDecorator
import org.eclipse.sprotty.xtext.tracing.ITraceProvider

import static extension io.opencaesar.oml.util.OmlRead.*
import io.opencaesar.oml.Classifier

class OmlDiagramGenerator extends OmlVisitor<SModelElement> implements IDiagramGenerator {

	static val LOG = Logger.getLogger(OmlDiagramGenerator)

	@Inject extension ITraceProvider traceProvider
	@Inject extension SIssueMarkerDecorator

	var extension Context context
	var extension OmlDiagramView view
	var OmlGraph graph
	var OmlNode frame
	var Map<Element, SModelElement> semantic2diagram

	override SModelRoot generate(Context context) {
		try {
			this.context = context
			this.semantic2diagram = new HashMap

			val ontology = context.resource.ontology
			this.view = new OmlDiagramView(ontology, context.idCache)
			this.graph = view.createGraph

			this.frame = ontology.doSwitch as OmlNode
			// ontology.contentsToVisualize.forEach[doSwitch]
			this.view.scope.scope.forEach[doSwitch]

			return graph
		} catch (Exception e) {
			LOG.log(Level.ERROR, "exception", e)
			return null
		}
	}

//	private def getContentsToVisualize(Ontology ontology) {
//		val fQuery = context.state.options.get("filterAction")
//		if (fQuery !== null) {
//			ontology.statements.filter[getLocalName(ontology) == fQuery].iterator
//		} else {
//			ontology.eAllContents.filter(Element)
//		}	
//	}
//	private def String getLocalName(Element element, Ontology ontology) {
//		if (element instanceof IdentifiedElement) {
//			element.getNameIn(ontology)
//		} else if (element instanceof Reference) {
//			element.resolvedName
//		}
//	}
	override doSwitch(EObject eObject) {
		val element = semantic2diagram.get(eObject)
		if (element !== null) {
			element
		} else {
			super.doSwitch(eObject)
		}
	}

	override caseOntology(Ontology ontology) {
		val node = ontology.createNode
		graph.children += node
		node.traceAndMark(ontology, context)

		if (context.state.currentModel.type == 'NONE') {
			context.state.expandedElements.add(node.id)
		}
		node.expanded = context.state.expandedElements.contains(node.id)

		return node
	}

	override caseAspect(Aspect aspect) {
		if (frame.expanded) {
			val node = aspect.createNode
			frame.children += node
			node.traceAndMark(aspect, context)
			addClassifierFeatures(aspect)
			return node
		}
	}

//	override caseAspectReference(AspectReference reference) {
//		val a = reference.aspect
//		if (a !== null) {
//			val node = a.doSwitch
//			val properties = a.findFeaturePropertiesWithDomain
//			properties.forEach[doSwitch]
//			return node
//		}
//	}
	override caseConcept(Concept concept) {
		if (frame.expanded) {
			val node = concept.createNode
			frame.children += node
			node.traceAndMark(concept, context)
			addClassifierFeatures(concept)
			return node
		}
	}

//	override caseConceptReference(ConceptReference reference) {
//		val c = reference.concept
//		if (c !== null) {
//			val node = c.doSwitch
//			val properties = c.findFeaturePropertiesWithDomain
//			properties.forEach[doSwitch]
//			return node
//		}
//	}
	override caseStructure(Structure structure) {
		if (frame.expanded) {
			val node = structure.createNode
			frame.children += node
			node.traceAndMark(structure, context)
			addClassifierFeatures(structure)
			return node
		}
	}

//	override caseStructureReference(StructureReference reference) {
//		if (reference.structure !== null) {
//			return reference.structure.doSwitch
//		}
//	}
	override caseScalar(Scalar scalar) {
		if (frame.expanded) {
			val node = scalar.createNode
			frame.children += node
			node.traceAndMark(scalar, context)
			return node
		}
	}

	override caseFacetedScalarReference(FacetedScalarReference reference) {
		if (reference.scalar !== null) {
			return reference.scalar.doSwitch
		}
	}

	override caseEnumeratedScalarReference(EnumeratedScalarReference reference) {
		if (reference.scalar !== null) {
			return reference.scalar.doSwitch
		}
	}

	override caseRule(Rule rule) {
		if (frame.expanded) {
			val node = rule.createNode
			frame.children += node
			node.traceAndMark(rule, context)
			return node
		}
	}

	override caseRuleReference(RuleReference reference) {
		if (reference.rule !== null) {
			return reference.rule.doSwitch
		}
	}

	override casePredicate(Predicate predicate) {}

	def caseAntecedentPredicate(Predicate predicate) {}

	def caseConsequentPredicate(RelationPredicate predicate) {}

	override caseScalarProperty(ScalarProperty property) {
		val domain = property.domain
		var domainNode = domain?.doSwitch
		if (domainNode === null) {
			return null
		}

		var compartment = domainNode.propertyCompartment
		if (compartment === null) {
			compartment = domain.createPropertyCompartment
			domainNode.children += compartment
		}

		var propertyLabel = property.createLabel
		compartment.children += propertyLabel
		propertyLabel.traceAndMark(property, context)

		return propertyLabel
	}

	override caseStructuredProperty(StructuredProperty property) {}

	// Show OML imports except if the imported ontology is the diagram vocabulary.
	override caseImport(Import _import) {
		val importingNode = _import.importingOntology?.doSwitch as OmlNode
		val importedOntology = _import.importedOntology
		if (importedOntology !== null && !importedOntology.diagramVocabulary) {
			val importedNode = importedOntology.doSwitch as OmlNode
			if (importingNode !== null && importedNode !== null) {
				val edge = _import.createEdge(importingNode, importedNode)
				graph.children += edge
				edge.traceAndMark(_import, context)
				return edge
			}
		}
	}

	override caseSpecializationAxiom(SpecializationAxiom axiom) {
		val specializingNode = axiom.specializingTerm?.doSwitch as OmlNode
		val specializedNode = axiom.specializedTerm?.doSwitch as OmlNode

		if (specializedNode !== null && specializingNode !== null) {
			val edge = axiom.createEdge(specializingNode, specializedNode)
			frame.children += edge
			edge.traceAndMark(axiom, context)
			return edge
		}
	}

	override caseRelationEntity(RelationEntity entity) {
		if (frame.expanded) {
			var source = entity.source?.doSwitch
			var target = entity.target?.doSwitch

			if (source !== null && target !== null) {
				if (view.scope.classifierHasFeaturesOrEdges(entity)) {
					val node = entity.createNode(source, target)
					frame.children += node
					node.traceAndMark(entity, context)
					return node
				} else {
					val node = entity.createEdge(source, target)
					frame.children += node
//					frame.createChildEdges(entity, source, node, target)
					node.traceAndMark(entity, context)
					return node
				}
			}
		}
	}

//	override caseRelationEntityReference(RelationEntityReference reference) {
//		val e = reference.entity
//		if (e !== null) {
//			val node = e.doSwitch	
//			val properties = e.findFeaturePropertiesWithDomain
//			properties.forEach[doSwitch]
//			return node
//		}	
//	}
	override caseRelationRangeRestrictionAxiom(RelationRangeRestrictionAxiom axiom) {
		var source = axiom.restrictingEntity?.doSwitch
		var target = axiom.range?.doSwitch

		if (source !== null && target !== null && axiom.relation !== null) {
			val edge = axiom.createEdge(source, target)
			frame.children += edge
			edge.traceAndMark(axiom, context)
			return edge
		}
	}

//------------------- HELPERS
	def addClassifierFeatures(Classifier cls) {
		view.scope.scalarProperties.get(cls).forEach[doSwitch]
		view.scope.structuredProperties.get(cls).forEach[doSwitch]
	}

	private def <T extends SModelElement> T traceAndMark(T sElement, Element element, Context context) {
		semantic2diagram.put(element, sElement)
		sElement.trace(element).addIssueMarkers(element, context)
	}

}
