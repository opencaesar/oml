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

import com.google.common.collect.Table
import com.google.inject.Inject
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.AspectReference
import io.opencaesar.oml.Classifier
import io.opencaesar.oml.Concept
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.Element
import io.opencaesar.oml.EnumeratedScalarReference
import io.opencaesar.oml.FacetedScalarReference
import io.opencaesar.oml.FeatureProperty
import io.opencaesar.oml.IdentifiedElement
import io.opencaesar.oml.Import
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.Predicate
import io.opencaesar.oml.Reference
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.RelationEntityReference
import io.opencaesar.oml.RelationPredicate
import io.opencaesar.oml.RelationRangeRestrictionAxiom
import io.opencaesar.oml.Rule
import io.opencaesar.oml.RuleReference
import io.opencaesar.oml.Scalar
import io.opencaesar.oml.ScalarProperty
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.Structure
import io.opencaesar.oml.StructureReference
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
import static extension io.opencaesar.oml.util.OmlSearch.*
import com.google.common.collect.HashBasedTable
import io.opencaesar.oml.Entity

class OmlDiagramGenerator extends OmlVisitor<SModelElement> implements IDiagramGenerator {
	
	static val LOG = Logger.getLogger(OmlDiagramGenerator)

	@Inject extension ITraceProvider traceProvider
	@Inject extension SIssueMarkerDecorator

	var extension Context context
	var extension OmlDiagramView view
	var extension OmlDiagramSpecifier specifier
	var OmlGraph graph
	var OmlNode frame
	var Map<Element, SModelElement> semantic2diagram
	var Table<Element, String, SModelElement> semantic3diagram
	
	override SModelRoot generate(Context context) {
		try {
			this.context = context
			val ontology = context.resource.ontology
            this.specifier = new OmlDiagramSpecifier(ontology)

			this.semantic2diagram = new HashMap
			id2semantic = new HashMap
			this.semantic3diagram = HashBasedTable.create()
			this.view =  new OmlDiagramView(ontology, context.idCache)
			this.graph = view.createGraph

			this.frame = ontology.doSwitch  as OmlNode
			ontology.contentsToVisualize.forEach[doSwitch]

			return graph
		} catch (Exception e) {
			LOG.log(Level.ERROR, "exception", e)
			return null
		}
	}

	private def getContentsToVisualize(Ontology ontology) {
		val fQuery = context.state.options.get("filterAction")
		if (fQuery !== null) {
			ontology.statements.filter[getLocalName(ontology) == fQuery].iterator
		} else {
			ontology.eAllContents.filter(Element)
		}	
	}

	private def String getLocalName(Element element, Ontology ontology) {
		if (element instanceof IdentifiedElement) {
			element.getNameIn(ontology)
		} else if (element instanceof Reference) {
			element.resolvedName
		}
	}

	override doSwitch(EObject eObject) {
	    if (!(eObject instanceof Ontology) && isDiagramSpecifier) {
	        if (!eObject.specify || eObject.diagramImport) {
               return null
           }
	    }

		val element = semantic2diagram.get(eObject)
		if (element !== null) {
			element
   		} else if (!semantic2diagram.containsKey(eObject)) {
	   		super.doSwitch(eObject)
   		} else {
   		    return null
   		}
  	}
  	
  	def SModelElement forceSwitch(EObject eObject) {
  	    if (eObject.excluded) return null
  	    
        val element = semantic2diagram.get(eObject)
        if (element !== null) {
            element
        } else if (!semantic2diagram.containsKey(eObject)) {
            super.doSwitch(eObject)
        } else {
            return null
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
		if  (frame.expanded && includeAspects) {
			val node = aspect.createNode(null, null)
			frame.children += node
			node.traceAndMark(aspect, context)
			if (includeCompartments && aspect.includesProperties && aspect.includesCompartment)
		        aspect.properties.forEach[forceSwitch]
			return node
		}
	}

	override caseAspectReference(AspectReference reference) {
		if (reference.aspect !== null && frame.expanded) {
		    if (isDiagramSpecifier) {
		        val id = reference.getDiagramProperty('id')
		        if (id !== null)
                    id2semantic.put(id,reference)
                else {
                    val aspect = reference.aspect
                    val node = aspect.forceSwitch
                    if (includeCompartments && aspect.includesProperties && aspect.includesCompartment)
                        aspect.properties
                            .forEach[p|caseScalarProperty(p as ScalarProperty)]
//                          .forEach[p|caseScalarPropertyOnRef(p as ScalarProperty,id)]
                        return node
                }
		        val node = reference.aspect.createNode(reference, id)
		        frame.children += node
		        node.traceAndMark(reference, context)
		        if (includeCompartments && reference.includesProperties && reference.includesCompartment)
		          reference.aspect.properties
		              .forEach[p|caseScalarPropertyOnRef(p as ScalarProperty,id)]
		        return node
		    }
		    else {
    			reference.aspect.doSwitch
		    }
		}
	}
	
	override caseConcept(Concept concept) {
		if  (frame.expanded) {
			val node = concept.createNode(null, null)
			frame.children += node
			node.traceAndMark(concept, context)
			if (concept.includesProperties)
			    concept.properties.forEach[forceSwitch]
			return node
		}
	}

	override caseConceptReference(ConceptReference reference) {
//		if (reference.concept !== null) {
//			return reference.concept.doSwitch
//		}
        if (reference.concept !== null && frame.expanded) {
            if (isDiagramSpecifier) {
                val id = reference.getDiagramProperty('id')
                if (id !== null)
                    id2semantic.put(id,reference)
                else {
                    val node = reference.concept.forceSwitch
                    if (includeCompartments && reference.includesProperties && reference.includesCompartment)
                      reference.concept.properties
                          .forEach[p|caseScalarPropertyOnRef(p as ScalarProperty,id)]
                    return node
                }
                val node = reference.concept.createNode(reference, id)
                frame.children += node
                node.traceAndMark(reference, context)
                if (includeCompartments && reference.includesProperties && reference.includesCompartment)
                  reference.concept.properties
                      .forEach[p|caseScalarPropertyOnRef(p as ScalarProperty,id)]
                return node
            }
            else {
                reference.concept.doSwitch
            }
        }
	}

	override caseStructure(Structure structure) {
		if  (frame.expanded) {
			val node = structure.createNode
			frame.children += node
			node.traceAndMark(structure, context)
			return node
		}
	}

	override caseStructureReference(StructureReference reference) {
		if (reference.structure !== null) {
			return reference.structure.doSwitch
		}
	}

	override caseScalar(Scalar scalar) {
		if  (frame.expanded) {
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
		if  (frame.expanded) {
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
	
	def caseScalarPropertyOnRef(ScalarProperty property, String domainId) {
	    if (property.excluded) return null
	    
	    var Element domain = id2semantic.get(domainId) as Reference
	    if (domain === null) {
	        if (domain instanceof AspectReference) {
	            domain = domain.aspect
	        } else if (domain instanceof ConceptReference) {
	            domain = domain.concept
	        } else if (domain instanceof RelationEntityReference) {
	            domain = domain.entity
	        }
	    }
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

	override caseImport(Import _import) {
		val importingNode = _import.importingOntology?.doSwitch as OmlNode
		val importedNode = _import.importedOntology?.doSwitch as OmlNode
		
		if (importingNode !== null && importedNode !== null) {			
			val edge = _import.createEdge(importingNode, importedNode)
			graph.children += edge
			edge.traceAndMark(_import, context)
			return edge
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
		var source = entity.source?.doSwitch
		var target = entity.target?.doSwitch

		if (source !== null && target !== null) {
			val node = entity.createNode(source, target)
			frame.children += node
			node.traceAndMark(entity, context)
			return node
		}
	}
	
    def caseRelationEntity(RelationEntity entity, EObject source, EObject target) {
        var sourceNode = semantic2diagram.get(source) ?: entity.source?.doSwitch
        var targetNode = semantic2diagram.get(target) ?: entity.target?.doSwitch

        if (sourceNode !== null && targetNode !== null) {
            val node = entity.createNode(sourceNode, targetNode)
            frame.children += node
            node.traceAndMark(entity, context)
            return node
        }
    }
	
	override caseRelationEntityReference(RelationEntityReference reference) {
        if (reference.entity !== null) {
            if (isDiagramSpecifier) {
                val sourceID = reference.getDiagramProperty('source')
                val targetID = reference.getDiagramProperty('target')
                if (sourceID !== null && targetID !== null) {
                    val source = id2semantic.get(sourceID)
                    val target = id2semantic.get(targetID)
                    caseRelationEntity(reference.entity, source, target)
                }    	            
            }
	        reference.entity.doSwitch
	    }
	}

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

    private def SModelElement getDiagramElement(EObject element, String id) {
        if (isDiagramSpecifier) {
            return semantic3diagram.get(element, id)
        } else {
            return semantic2diagram.get(element)
        }
    }

    private def Iterable<FeatureProperty> getProperties(EObject element) {
        if (element instanceof Classifier) {
            return element.findFeaturePropertiesWithDomain
        }
    }

	private def <T extends SModelElement> T traceAndMark(T sElement, Element element, Context context) {
		semantic2diagram.put(element, sElement)
		sElement.trace(element).addIssueMarkers(element, context)
	}

}
