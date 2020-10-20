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
import io.opencaesar.oml.Axiom
import io.opencaesar.oml.KeyAxiom
import io.opencaesar.oml.Entity
import io.opencaesar.oml.RelationTargetRestrictionAxiom
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.RelationInstance

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
			LOG.info("generate: " + ontology.getIri())
			
			this.view = new OmlDiagramView(ontology, context.idCache)
			this.graph = view.createGraph
			
			
			this.frame = ontology.doSwitch as OmlNode
			
			this.view.scope.scope.forEach[doSwitch]
			this.view.scope.entityAxioms.forEach[e, axs|
				axs.forEach[ax|
					e.showAxiom(ax)
				]
			]

			return graph
		} catch (Exception e) {
			LOG.log(Level.ERROR, "exception \u23b8 \u23b9 ", e)
			return null
		}
	}

	override doSwitch(EObject eObject) {
		val element = semantic2diagram.get(eObject)
		if (element !== null) {
			element
		} else {
			super.doSwitch(eObject)
		}
	}

	override caseOntology(Ontology o) {
		val node = o.createNode
		graph.children += node
		node.traceAndMark(o, context)

		if (context.state.currentModel.type == 'NONE') {
			context.state.expandedElements.add(node.id)
		}
		node.expanded = context.state.expandedElements.contains(node.id)
		
		// This will transitively show all imports since caseImport() below visits the imported ontology.
		o.importsWithSource.forEach[doSwitch]
		return node
	}

	override caseAspect(Aspect aspect) {
		if (frame.expanded) {
			val node = aspect.createNode(view.scope.entityAxioms.get(aspect).filter(KeyAxiom))
			frame.children += node
			node.traceAndMark(aspect, context)
			addClassifierFeatures(aspect, node)
			return node
		}
	}

	override caseConcept(Concept concept) {
		if (frame.expanded) {
			val node = concept.createNode(view.scope.entityAxioms.get(concept).filter(KeyAxiom))
			frame.children += node
			node.traceAndMark(concept, context)
			addClassifierFeatures(concept, node)
			return node
		}
	}

	override caseRelationEntity(RelationEntity entity) {
		if (frame.expanded) {
			val source = entity.source?.doSwitch
			val target = entity.target?.doSwitch
			val keys = view.scope.entityAxioms.get(entity).filter(KeyAxiom)
			
			if (source !== null && target !== null) {
				if (view.scope.classifierHasFeaturesOrEdges(entity) || !keys.isEmpty) {
					val node = entity.createNode(source, target, keys)
					frame.children += node
					node.traceAndMark(entity, context)
					addClassifierFeatures(entity, node)
					return node
				} else {
					val node = entity.createEdge(source, target)
					frame.children += node
					node.traceAndMark(entity, context)
					return node
				}
			}
		}
	}

	override caseStructure(Structure structure) {
		if (frame.expanded) {
			val node = structure.createNode
			frame.children += node
			node.traceAndMark(structure, context)
			addClassifierFeatures(structure, node)
			return node
		}
	}

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

	override caseConceptInstance(ConceptInstance ci) {
		
	}
	
	override caseRelationInstance(RelationInstance ri) {
		
	}
	
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

	def dispatch showAxiom(Entity e, Axiom ax) {}
	
	def dispatch showAxiom(Entity e, SpecializationAxiom ax) {
		if (frame.expanded) {
			val specializingNode = semantic2diagram.get(e)
			if (specializingNode === null)
				throw new IllegalArgumentException("no entity node for showAxiom(SpecializationAxiom) " + e.abbreviatedIri)
			val specializedNode = semantic2diagram.get(ax.specializedTerm)
			if (specializedNode === null)
				throw new IllegalArgumentException("no sup node for showAxiom: " + e.abbreviatedIri + " sup=" + ax.specializedTerm.abbreviatedIri)
			val edge = ax.createEdge(specializingNode, specializedNode)
			frame.children += edge
			edge.traceAndMark(ax, context)
		}
	}
	
	def dispatch showAxiom(Entity e, ScalarPropertyCardinalityRestrictionAxiom ax) {
		if (frame.expanded) {
			val source = semantic2diagram.get(e)
			if (source === null)
				throw new IllegalArgumentException("no entity node for showAxiom(ScalarPropertyCardinalityRestrictionAxiom): " + e.abbreviatedIri)
			var compartment = source.propertyCompartment
			if (compartment === null) {
				compartment = e.createPropertyCompartment
				source.children += compartment
			}
			val label = e.createLabel(ax)
			compartment.children += label
			label.traceAndMark(ax, context)
		}
	}
	
	def dispatch showAxiom(Entity e, ScalarPropertyRangeRestrictionAxiom ax) {
		if (frame.expanded) {
			val source = semantic2diagram.get(e)
			if (source === null)
				throw new IllegalArgumentException("no entity node for showAxiom(ScalarPropertyRangeRestrictionAxiom): " + e.abbreviatedIri)
			var compartment = source.propertyCompartment
			if (compartment === null) {
				compartment = e.createPropertyCompartment
				source.children += compartment
			}
			val label = e.createLabel(ax)
			compartment.children += label
			label.traceAndMark(ax, context)
		}
	}
	
	def dispatch showAxiom(Entity e, ScalarPropertyValueRestrictionAxiom ax) {
		if (frame.expanded) {
			val source = semantic2diagram.get(e)
			if (source === null)
				throw new IllegalArgumentException("no entity node for showAxiom(ScalarPropertyValueRestrictionAxiom): " + e.abbreviatedIri)
			var compartment = source.propertyCompartment
			if (compartment === null) {
				compartment = e.createPropertyCompartment
				source.children += compartment
			}
			val label = e.createLabel(ax)
			compartment.children += label
			label.traceAndMark(ax, context)
		}
	}
	
	def dispatch showAxiom(Entity e, RelationCardinalityRestrictionAxiom ax) {
		if (frame.expanded) {
			val source = semantic2diagram.get(e)
			if (source === null)
				throw new IllegalArgumentException("no entity node for showAxiom(RelationCardinalityRestrictionAxiom): " + e.abbreviatedIri)
			val target = semantic2diagram.get(ax.range)
			if (target === null)
				throw new IllegalArgumentException("no range node for showAxiom(RelationCardinalityRestrictionAxiom): " + e.abbreviatedIri + " range=" + ax.range.abbreviatedIri)
			val edge = ax.createEdge(source, target)
			frame.children += edge
			edge.traceAndMark(ax, context)
		}
	}
	
	def dispatch showAxiom(Entity e, RelationRangeRestrictionAxiom ax) {
		if (frame.expanded) {
			val source = semantic2diagram.get(e)
			if (source === null)
				throw new IllegalArgumentException("no entity node for showAxiom(RelationRangeRestrictionAxiom): " + e.abbreviatedIri)
			val target = semantic2diagram.get(ax.range)
			if (target === null)
				throw new IllegalArgumentException("no range node for showAxiom(RelationRangeRestrictionAxiom): " + e.abbreviatedIri + " range=" + ax.range.abbreviatedIri)
			val edge = ax.createEdge(source, target)
			frame.children += edge
			edge.traceAndMark(ax, context)
		}
	}
	
	def dispatch showAxiom(Entity e, RelationTargetRestrictionAxiom ax) {
		if (frame.expanded) {
			val source = semantic2diagram.get(e)
			if (source === null)
				throw new IllegalArgumentException("no entity node for showAxiom(RelationTargetRestrictionAxiom): " + e.abbreviatedIri)
			val target = semantic2diagram.get(ax.target)
			if (target === null)
				throw new IllegalArgumentException("no range node for showAxiom(RelationTargetRestrictionAxiom): " + e.abbreviatedIri + " target=" + ax.target.abbreviatedIri)
			val edge = ax.createEdge(source, target)
			frame.children += edge
			edge.traceAndMark(ax, context)
		}
	}
	
//------------------- HELPERS

	def addClassifierFeatures(Classifier cls, OmlNode node) {
		view.scope.scalarProperties.get(cls).forEach[f|
			var compartment = node.propertyCompartment
			if (compartment === null) {
				compartment = cls.createPropertyCompartment
				node.children += compartment
			}
			val label = cls.createLabel(f)
			compartment.children += label
			label.traceAndMark(f, context)
		]
		view.scope.structuredProperties.get(cls).forEach[f|
			var compartment = node.propertyCompartment
			if (compartment === null) {
				compartment = cls.createPropertyCompartment
				node.children += compartment
			}
			val label = cls.createLabel(f)
			compartment.children += label
			label.traceAndMark(f, context)
		]
	}

	private def <T extends SModelElement> T traceAndMark(T sElement, Element element, Context context) {
		semantic2diagram.put(element, sElement)
		sElement.trace(element).addIssueMarkers(element, context)
	}

}
