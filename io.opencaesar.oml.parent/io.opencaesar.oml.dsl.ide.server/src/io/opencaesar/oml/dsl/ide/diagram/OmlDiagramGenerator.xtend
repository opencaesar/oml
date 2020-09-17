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

import com.google.common.collect.HashBiMap
import com.google.inject.Inject
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.AspectReference
import io.opencaesar.oml.Classifier
import io.opencaesar.oml.Concept
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.ConceptInstanceReference
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.Element
import io.opencaesar.oml.Entity
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
import io.opencaesar.oml.RelationInstance
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
import io.opencaesar.oml.LinkAssertion
import io.opencaesar.oml.ScalarPropertyValueAssertion
import io.opencaesar.oml.Member
import java.util.Queue
import io.opencaesar.oml.SpecializableTerm
import java.util.HashSet
import java.util.Deque
import java.util.ArrayDeque

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
	
	override SModelRoot generate(Context context) {
		try {
			this.context = context
			val ontology = context.resource.ontology
            this.specifier = new OmlDiagramSpecifier(ontology)

			this.semantic2diagram = new HashMap
			semantic2ID = HashBiMap.create()
			this.view =  new OmlDiagramView(ontology, context.idCache)
			this.graph = view.createGraph

			ontology.doSwitch as OmlNode

			return graph
		} catch (Exception e) {
			LOG.log(Level.ERROR, "exception", e)
			return null
		}
	}

	private def getContentsToVisualize(Ontology ontology) {
		val fQuery = context.state.options.get("filterAction")
		if (fQuery !== null && fQuery.length > 0) {
			ontology.statements.filter[getLocalName(ontology) == fQuery].iterator
		} else {
			ontology.eAllContents.filter(Element)
		}	
	}

	override doSwitch(EObject eObject) {
		val element = semantic2diagram.get(eObject)
		if (element !== null) {
			element
   		} else if (!semantic2diagram.containsKey(eObject)) {
	   		val node = super.doSwitch(eObject)
	   		semantic2diagram.put(eObject as Element, node)
	   		if (node !== null) {
    	   		if (eObject instanceof Reference) {
    	   		    if (semantic2diagram.get(eObject.resolve) === null)
                        frame.children += node
    	   		} else if (!(eObject instanceof Ontology)) {
    	   		    frame.children += node
    	   		}
	   		}
	   		eObject.renderShortestPath
	   		eObject.renderHierarchy
	   		eObject.renderRelated
	   		return node
   		} else {
   		    return null
   		}
  	}
  	
  	def SModelElement forceSwitch(EObject eObject) {
  	    if (eObject.excluded) return null
  	    
        val node = super.doSwitch(eObject)
        if (node !== null)
            semantic2diagram.put(eObject as Element, node)
        return node
  	}
	
	override caseOntology(Ontology ontology) {
		val node = ontology.createNode
		frame = node
		graph.children += node
		node.traceAndMark(ontology)
		semantic2diagram.put(ontology, node)
		
		if (context.state.currentModel.type == 'NONE') {
			context.state.expandedElements.add(node.id)
		}
		node.expanded = context.state.expandedElements.contains(node.id)
		
		if (node.expanded) {
            ontology.contentsToVisualize.forEach[el|
                if (el.specify) {
                    if (isDiagramSpecifier)
                        el.setDiagramID
                    val childNode = el.doSwitch
                    if (childNode !== null && childNode instanceof OmlNode) {
                        el.renderChildren(childNode)
                        el.track(childNode)
                    }
                }
            ]
		}
		
		return node
	}

	override caseAspect(Aspect aspect) {
        if (semantic2diagram.get(aspect) === null) {
            val node = aspect.createNode(null,null)
            node.traceAndMark(aspect)
            return node
        }
	}

	override caseAspectReference(AspectReference reference) {
        val diagramID = semantic2ID.get(reference)
	    if (isDiagramSpecifier && diagramID !== null) {
	        val node = reference.aspect.createNode(reference, diagramID)
	        node.traceAndMark(reference.aspect)
            return node
	    } else {
	        return reference.aspect.doSwitch
	    }
	}
	
	override caseConcept(Concept concept) {
        if (semantic2diagram.get(concept) === null) {
            val node = concept.createNode(null,null)
            node.traceAndMark(concept)
            return node
        }
	}

	override caseConceptReference(ConceptReference reference) {
        val diagramID = semantic2ID.get(reference)
        if (isDiagramSpecifier && diagramID !== null) {
            val node = reference.concept.createNode(reference, diagramID)
            node.traceAndMark(reference.concept) 
            return node
        } else {
            return reference.concept.doSwitch
        }
	}
	
	override caseConceptInstance(ConceptInstance ci) {
        return ci.createNode(null, null).traceAndMark(ci)
	}
	
    override caseConceptInstanceReference(ConceptInstanceReference reference) {
        val diagramID = semantic2ID.get(reference)
        if (isDiagramSpecifier && diagramID !== null) {
            val node = reference.instance.createNode(reference, diagramID)
            node.traceAndMark(reference.instance) 
            return node
        } else {
            val node = reference.instance.doSwitch
            return node
        }
    }

    // TODO: Specify multiple
	override caseStructure(Structure structure) {
		val node = structure.createNode
		node.traceAndMark(structure)
		return node
	}

    // TODO: Specify multiple
	override caseStructureReference(StructureReference reference) {
		if (reference.structure !== null) {
			return reference.structure.doSwitch
		}
	}

    // TODO: Specify multiple
	override caseScalar(Scalar scalar) {
		val node = scalar.createNode
		node.traceAndMark(scalar)
		return node
	}

    // TODO: Specify multiple
	override caseFacetedScalarReference(FacetedScalarReference reference) {
		if (reference.scalar !== null) {
			return reference.scalar.doSwitch
		}
	}

    // TODO: Specify multiple	
	override caseEnumeratedScalarReference(EnumeratedScalarReference reference) {
		if (reference.scalar !== null) {
			return reference.scalar.doSwitch
		}
	}

    // TODO: Specify multiple
	override caseRule(Rule rule) {
		val node = rule.createNode
		node.traceAndMark(rule)
		return node
	}

    // TODO: Specify multiple
	override caseRuleReference(RuleReference reference) {
		if (reference.rule !== null) {
			return reference.rule.doSwitch
		}
	}
	
	override casePredicate(Predicate predicate) {}

	def caseAntecedentPredicate(Predicate predicate) {}
	
	def caseConsequentPredicate(RelationPredicate predicate) {}

	override caseScalarProperty(ScalarProperty property) {
	    return property.createLabel.traceAndMark(property)
	}
	
	override caseScalarPropertyValueAssertion(ScalarPropertyValueAssertion prop) {
	    val parent = prop.eContainer
	    val parentNode = parent.doSwitch
	    if (parentNode !== null) {
	        val compartment = findCompartment(parent as Member, null, parentNode)
	        val label = prop.createLabel.traceAndMark(prop)
	        if (label !== null)
	           compartment.children += label
	    }
	    
	    return null
	}
	
	override caseStructuredProperty(StructuredProperty property) {}

    // TODO: This method recursively renders all imports now. Need to look into this
//	override caseImport(Import _import) {
//		val importingNode = _import.importingOntology?.doSwitch as OmlNode
//		val importedNode = _import.importedOntology?.doSwitch as OmlNode
//		
//		if (importingNode !== null && importedNode !== null) {			
//			val edge = _import.createEdge(importingNode, importedNode)
//			graph.children += edge
//			edge.traceAndMark(_import)
//			return edge
//		}
//	}

    // TODO: Specify multiple
	override caseSpecializationAxiom(SpecializationAxiom axiom) {
		val specializingNode = axiom.specializingTerm?.doSwitch as OmlNode
		val specializedNode = axiom.specializedTerm?.doSwitch as OmlNode
		
		if (specializedNode !== null && specializingNode !== null) {
			val edge = axiom.createEdge(specializingNode, specializedNode)
//			frame.children += edge
			edge.traceAndMark(axiom)
			return edge
		}
	}

	override caseRelationEntity(RelationEntity entity) {
		var source = entity.source?.doSwitch
		var target = entity.target?.doSwitch

		if (source !== null && target !== null) {
			val node = entity.createNode(source, target)
			node.children += newEdge(source, node, node.id+'.start', "edge:straight")
			node.children += newEdge(node, target, node.id+'.end', "edge:augments")
			node.traceAndMark(entity)
			return node
		}
	}

	override caseRelationEntityReference(RelationEntityReference reference) {
        if (reference.entity !== null) {
            if (isDiagramSpecifier) {
                    return reference.entity.createNode(reference)
            } else {
                reference.entity.doSwitch
            }
	    }
	}
	
	// TODO: Specify multiple
	override caseRelationInstance(RelationInstance instance) {
	    val shouldAddSource = semantic2diagram.get(instance.source) === null
        var source = instance.source?.doSwitch
//	    if (shouldAddSource && source !== null){
//            frame.children += source
//	    }
	    
	    val shouldAddTarget = semantic2diagram.get(instance.target) === null
	    var target = instance.target?.doSwitch
//        if (shouldAddTarget && target !== null) {
//            frame.children += target
//	    }
	    
	    if (source !== null && target !== null) {
	        val node = instance.createNode(source, target)
	        node.children += newEdge(source, node, node.id+'start', "edge:straight")
	        node.children += newEdge(node, target, node.id+'.end', "edge:augments")
	        node.traceAndMark(instance)
	        return node
	    }
	}

    // TODO: Specify multiple
	override caseRelationRangeRestrictionAxiom(RelationRangeRestrictionAxiom axiom) {
		var source = axiom.restrictingEntity?.doSwitch
		var target = axiom.range?.doSwitch
		
		if (source !== null && target !== null && axiom.relation !== null) {
			val edge = axiom.createEdge(source, target)
//			frame.children += edge
			edge.traceAndMark(axiom)
			return edge
		}
		return null
	}
	
	// TODO: Specify multiple
	override caseLinkAssertion(LinkAssertion link) {
	    var Element source = link.owningReference
	    if (source === null)
            source = link.owningInstance
        var sourceNode = source?.doSwitch
//        if (shouldAddSource && sourceNode !== null) {
//            frame.children += sourceNode
//        }
        
        val shouldAddTarget = semantic2diagram.get(link.target) === null
        var targetNode = link.target?.doSwitch
//        if (shouldAddTarget && targetNode !== null) {
//            frame.children += targetNode
//        }
        
        if (sourceNode !== null && targetNode !== null && link.relation !== null) {
            val edge = link.createEdge(sourceNode, targetNode)
//            frame.children += edge
            edge.traceAndMark(link)
            return edge
        }
        
        return null
	}

//------------------- HELPERS

	private def renderShortestPath(EObject eObject) {
		val relatedElement = eObject.getDiagramStringProperty(OmlDiagramSpecifier.SHORTEST_PATH)
		if (relatedElement === null) return;
		
		val Integer hops = eObject.getDiagramIntProperty(OmlDiagramSpecifier.SHORTEST_PATH_HOPS)
		val Queue<Deque<EObject>> paths = new ArrayDeque()
		val firstPath = new ArrayDeque
		val start = eObject instanceof Reference ? eObject.resolve : eObject
		firstPath.add(start)
		paths.add(firstPath)
		val explored = new HashSet()
		
		while (!paths.empty) {
			val next = paths.remove
			
			if (hops === null || next.size / 2 <= hops) {
				val iterator = next.descendingIterator
				var node = iterator.next
				if (node instanceof SpecializationAxiom) {
					next.add(node.specializedTerm)
					node = next.last
				} else if (node instanceof RelationEntity) {
					val prevNode = iterator.next
					if (node.source == prevNode) {
						next.add(node.target)
						node = node.target
					} else if ((node as RelationEntity).target == prevNode) {
						next.add ((node as RelationEntity).source)
						node = (node as RelationEntity).source
					}
				}
				
				if (!explored.contains(node)) {
					if (relatedElement.matchesURI(node)) {
						paths.clear
						renderPath(next)
					} else {
						explored.add(node)
						node.findLinks.forEach[l|
							val newPath = new ArrayDeque<EObject>(next)
							newPath.addLast(l)
							paths.add(newPath)
						]
					}
				}
			}
		}
	}
	
	private def renderRelated(EObject eObject) {
		val relatedElement = eObject.getDiagramStringProperty(OmlDiagramSpecifier.RELATE_TO)
		if (relatedElement === null) return;
		
		val Integer hops = eObject.getDiagramIntProperty(OmlDiagramSpecifier.RELATE_TO_HOPS)
		val Queue<Deque<EObject>> paths = new ArrayDeque
		val firstPath = new ArrayDeque
		val start = eObject instanceof Reference ? eObject.resolve : eObject
		firstPath.add(start)
		paths.add(firstPath)
		val explored = new HashSet
		val pathsToRender = new ArrayDeque
		
		while (!paths.empty) {
			val next = paths.remove
			val currentHops = next.size / 2
			if (hops === null || currentHops <= hops) {
				val iterator = next.descendingIterator
				var node = iterator.next
				if (next.length > 1) {
					if (node instanceof SpecializationAxiom) {
						val prevNode = iterator.next
						if (node.specializedTerm == prevNode) {
							next.add(node.specializingTerm)
							node = node.specializingTerm
						} else {
							val specializedTerm = (node as SpecializationAxiom).specializedTerm
							next.add(specializedTerm)
							node = specializedTerm
						}
					} else if (node instanceof RelationEntity) {
						val prevNode = iterator.next
						if (node.source == prevNode) {
							next.add(node.target)
							node = node.target
						} else if ((node as RelationEntity).target == prevNode) {
							next.add ((node as RelationEntity).source)
							node = (node as RelationEntity).source
						}
					}
				}
				
				if (!explored.contains(node)) {
					if (relatedElement.matchesURI(node)) {
						pathsToRender.add(next)
					} else {
						explored.add(node)
						node.findLinks.forEach[l|
							val newPath = new ArrayDeque<EObject>(next)
							newPath.addLast(l)
							paths.add(newPath)
						]
					}
				}
			}
		}
		
		val renderList = new HashSet
		pathsToRender.forEach[p|
			p.forEach[el|
				renderList.add(el)
			]
		]
		renderPath(renderList)
	}
	
	private def renderHierarchy(EObject eObject) {
		if (!eObject.containsDiagramAnnotation(OmlDiagramSpecifier.HIERARCHY)) return;
		
		val Integer hops = eObject.getDiagramIntProperty(OmlDiagramSpecifier.HIERARCHY_HOPS)
		val Queue<Deque<EObject>> paths = new ArrayDeque
		val firstPath = new ArrayDeque<EObject>
		val start = eObject instanceof Reference ? eObject.resolve : eObject
		firstPath.add(start)
		paths.add(firstPath)
		val elementsToRender = new HashSet
		
		do {
			val next = paths.remove
			val iterator = next.descendingIterator
			var node = iterator.next
			val currentHops = next.size / 2
			val branches = (node as Classifier).findSpecializationsWithSource
			if (!branches.empty && (hops === null || currentHops <= hops)) {
				branches.forEach[b|
					val newPath = new ArrayDeque<EObject>(next)
					newPath.addLast(b)
					newPath.addLast(b.specializedTerm)
					paths.add(newPath)
				]
			} else {
				next.forEach[el| elementsToRender.add(el)]
			}
		} while (!paths.empty)
		
		renderPath(elementsToRender)
	}
	
	private def renderPath(Iterable<EObject> path) {
		path.forEach[doSwitch]
	}
	
	private def Iterable<EObject> findLinks(EObject eObject) {
		var links = new HashSet<EObject>
		if (eObject instanceof Classifier) {
			links += eObject.findSpecializationsWithSource
			links += eObject.findSpecializationsWithTarget
		}
		if (eObject instanceof Entity) {
			links += eObject.findRelationEntitiesWithSource
			links += eObject.findRelationEntitiesWithTarget
		}
		return links
	}

    private def renderChildren(EObject eObject, SModelElement node) {
        if (node.children !== null) {
            if (includeCompartments) {
                if (eObject instanceof Classifier)
                    renderProperties(eObject, null, node)
                else if (eObject instanceof Reference) {
                    val obj = eObject.resolve
                    if (obj instanceof Classifier) {
                        renderProperties(obj, eObject, node)                        
                    }
                }
            }
            if (eObject instanceof RelationEntityReference) {
                if (isDiagramSpecifier)
                    eObject.renderRelationEdges(node)
            }
        }
    }
    
    private def renderProperties(Classifier el, Reference ref, SModelElement parent) {
        val obj = ref ?: el
        val diagramID = semantic2ID.get(obj) ?: idCache.getId(obj)
        val properties = el.properties
        if (!properties.empty) {
            if (!isDiagramSpecifier || obj.includesProperties && obj.includesCompartment) {
                val compartment = el.findCompartment(ref, parent)
                el.properties.forEach[renderProperty(compartment, diagramID)]
            }
        }
    }
    
    private def renderProperty(FeatureProperty prop, SModelElement compartment, String diagramID) {
        val label = prop.forceSwitch
        if (label !== null) {
            if (diagramID !== null)
                label.id = label.id + '-' + diagramID
            compartment.children += label
            label.traceAndMark(prop)
        }
    }
    
    private def renderRelationEdges(RelationEntityReference ref, SModelElement parent) {
        val source = ref.entity.source.resolveSpecifierID(ref.getDiagramStringProperty('source'))
        val target = ref.entity.target.resolveSpecifierID(ref.getDiagramStringProperty('target'))
        
        var sourceNode = semantic2diagram.get(source)
        var targetNode = semantic2diagram.get(target)
        
        if (sourceNode === null) {
            sourceNode = ref.entity.source?.doSwitch
//            frame.children += sourceNode
        }
        if (targetNode === null){
            targetNode = ref.entity.target?.doSwitch
//            if (targetNode !== sourceNode)
//                frame.children += targetNode
        }
        
        if (targetNode !== null && sourceNode !== null) {
            parent.children += newEdge(sourceNode, parent, parent.id+'.start', "edge:straight")
            parent.children += newEdge(parent, targetNode, parent.id+'.end', "edge:augments")
        }
    }
    
    private def findCompartment(Member el, Reference ref, SModelElement node) {
        var compartment = node?.propertyCompartment
        if (compartment === null) {
            compartment = ref.createPropertyCompartment ?: el.createPropertyCompartment
                
            node.children += compartment
        }
        return compartment
    }

    private def Iterable<FeatureProperty> getProperties(Classifier element) {
            return element.findFeaturePropertiesWithDomain
    }
    
    private def track(Element element, SModelElement sElement) {
        if (semantic2diagram.get(element) === null) {
            semantic2diagram.put(element, sElement)
        }
        if (semantic2ID.get(element) === null) {
            semantic2ID.put(element, sElement.id)
        }
    }

	private def <T extends SModelElement> T traceAndMark(T sElement, Element element) {
		sElement.trace(element).addIssueMarkers(element, context)
	}

}
