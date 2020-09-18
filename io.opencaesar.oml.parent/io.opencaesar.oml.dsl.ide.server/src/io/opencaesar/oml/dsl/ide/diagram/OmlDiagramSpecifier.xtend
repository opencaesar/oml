package io.opencaesar.oml.dsl.ide.diagram

import com.google.common.collect.BiMap
import io.opencaesar.oml.AnnotatedElement
import io.opencaesar.oml.Annotation
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.Concept
import io.opencaesar.oml.IdentifiedElement
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.Reference
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject

import static extension io.opencaesar.oml.util.OmlRead.*
import static extension io.opencaesar.oml.util.OmlSearch.*
import io.opencaesar.oml.QuotedLiteral
import io.opencaesar.oml.Element
import io.opencaesar.oml.Member
import io.opencaesar.oml.IntegerLiteral
import java.util.ArrayList

class OmlDiagramSpecifier {
    
    val Ontology ontology
    public static val String diagramIRI = "http://imce.jpl.nasa.gov/foundation/diagram"
    public static val String SHORTEST_PATH = 'shortestPath'
    public static val String SHORTEST_PATH_HOPS = 'shortestPathHops'
    public static val String RELATE_TO = 'relateTo'
    public static val String RELATE_TO_HOPS = 'relateToHops'
    public static val String HIERARCHY = 'hierarchy'
    public static val String HIERARCHY_HOPS = 'hierarchyHops'
    
    public var isDiagramSpecifier = false
    public var Map<EObject, Iterable<Annotation>> semantic2diagramAnnotations
    public var BiMap<EObject, String> semantic2ID
    
    public val boolean includeAspects
    public val boolean includeConcepts
    public val boolean includeCompartments
    
    new(Ontology ontology) {
        this.ontology = ontology
        this.semantic2diagramAnnotations = new HashMap
        this.isDiagramSpecifier = ontology.diagramAnnotations.exists[a|
            a.property.name == "specifier"
        ]
        this.includeCompartments = ontology.includesCompartment
        this.includeAspects = ontology.includesAspects
        this.includeConcepts = ontology.includesConcepts
    }
    
    def boolean hasDiagramIRI(Ontology ontology) {
        return ontology.iri == diagramIRI
    }

    def boolean specify(EObject eObject) {
        if (!isDiagramSpecifier) return true

        return eObject.included
    }
    
    def boolean isIncluded(EObject eObject) {
        if (eObject.excluded) return false
        
        val diagramAnnotations = eObject.diagramAnnotations
        if (diagramAnnotations !== null) {
            return diagramAnnotations.exists[a|
                if (a.owningReference == eObject || a.owningElement == eObject) {
                    return a.property.name == 'include' && a.value === null
                }
                return false
            ]
        }
        return false
    }
    
    def boolean isExcluded(EObject eObject) {
        val diagramAnnotations = eObject.diagramAnnotations
        var excluded = false
        if (diagramAnnotations !== null) {
            excluded = diagramAnnotations.exists[a|
                a.property.name == 'exclude'
                && a.value === null
            ]
        }
        return excluded
    }
    
    def boolean includesProperties(EObject eObject) {
        val diagramAnnotations = eObject.diagramAnnotations
        var included = false
        if (diagramAnnotations !== null) {
            included = diagramAnnotations.exists[a|
                if (a.property.name == 'include') {
                    return a.findQuotedValue == 'properties'
                }
                return false
            ]
        }
        return included
    }

    def boolean includesCompartment(EObject eObject) {
        val diagramAnnotations = eObject.diagramAnnotations
        var excluded = false
        if (diagramAnnotations !== null) {
            excluded = diagramAnnotations.exists[a|
                if (a.property.name == 'exclude') {
                    return a.findQuotedValue == 'compartment'
                }
                return false
            ]
        }
        return !excluded
    }
    
    def boolean isDiagramImport(EObject eObject) {
        if (eObject instanceof IdentifiedElement) {
            return eObject.iri == diagramIRI
        }
        return false
    }
    
    def Iterable<Annotation> getDiagramAnnotations(EObject eObject) {
        var annotations = semantic2diagramAnnotations.get(eObject)
        if (annotations === null) {
            if (eObject instanceof AnnotatedElement) {
                annotations = eObject.findAnnotations.filter[a|
                    a.property.eContainer.diagramImport
                ]
            } else if (eObject instanceof Reference) {
                annotations = eObject.findAnnotations.filter[a|
                    a.property.eContainer.diagramImport
                ]
            }
            semantic2diagramAnnotations.put(eObject, annotations)
        }
        return annotations
    }
    
    def Iterable<Annotation> getDirectDiagramAnnotations(EObject eObject) {
    	var Iterable<Annotation> annotations = new ArrayList
    	if (eObject instanceof AnnotatedElement) {
    		annotations = eObject.ownedAnnotations.filter[a|
    			a.property.eContainer.diagramImport
    		]
    	} else if (eObject instanceof Reference) {
    		annotations = eObject.ownedAnnotations.filter[a|
    			a.property.eContainer.diagramImport
    		]
    	}
    	return annotations
    }
    
    def containsDiagramAnnotation(EObject eObject, String annotation) {
    	eObject.diagramAnnotations?.exists[a|
    		a.property.name == annotation
    	]
    }
    
    def containsDirectDiagramAnnotation(EObject eObject, String annotation) {
    	eObject.directDiagramAnnotations?.exists[a|
    		a.property.name == annotation
    	]
    }
    
    def String getDiagramStringProperty(EObject eObject, String property) {
        if (property === null) return null
        
        val diagramAnnotations = eObject.diagramAnnotations
        var String value = null
        if (diagramAnnotations !== null) {
            value = diagramAnnotations.map[a|
                if (a.property.name == property &&
                        (a.owningReference == eObject || a.owningElement == eObject)
                ) {
                    return a.findQuotedValue
                }
            ].findFirst[v|v !== null]
        }
        return value
    }
    
    def String getDirectDiagramStringProperty(EObject eObject, String property) {
        if (property === null) return null
        
        val diagramAnnotations = eObject.directDiagramAnnotations
        var String value = null
        if (diagramAnnotations !== null) {
            value = diagramAnnotations.map[a|
                if (a.property.name == property &&
                        (a.owningReference == eObject || a.owningElement == eObject)
                ) {
                    return a.findQuotedValue
                }
            ].findFirst[v|v !== null]
        }
        return value
    }
    
    def Integer getDiagramIntProperty(EObject eObject, String property) {
        if (property === null) return null;
        
        val diagramAnnotations = eObject.diagramAnnotations
        var Integer value = null
        if (diagramAnnotations !== null) {
            value = diagramAnnotations.map[a|
                if (a.property.name == property &&
                        (a.owningReference == eObject || a.owningElement == eObject)
                ) {
                    return a.findIntValue
                } else return null;
            ].findFirst[v|v !== null]
        }
        return value
    }
    
    def resolveSpecifierID(EObject eObject, String specifierID) {
        if (specifierID === null) return null
        
        val id2semantic = semantic2ID.inverse()
        val name = getLocalName(eObject as Element)
        id2semantic.get(name + '-' + specifierID)
    }
    
    def getDiagramID(EObject eObject) {
        val specifierID = eObject.getDiagramStringProperty('id')
        if (specifierID !== null) {
            val name = getLocalName(eObject as Element)
            return name + '-' + specifierID
        }
    }
    
    def setDiagramID(EObject eObject) {
        val id = eObject.getDiagramStringProperty('id')
        if (id !== null) {
            semantic2ID.put(eObject, getLocalName(eObject as Element) + '-' + id)
        }
    }
    
    def matchesURI(String URI, EObject eObject) {
    	if (URI == (eObject as Element).localName) return true
    	if (URI == (eObject as Member).name) return true
    	if (URI == (eObject as Member).iri) return true
    	if (URI == (eObject as Member).abbreviatedIri) return true
    	return false
    }
    
//------------------- HELPERS

    private def String getLocalName(Element element) {
        if (element instanceof IdentifiedElement) {
            element.getNameIn(ontology)
        } else if (element instanceof Reference) {
            element.resolvedName
        }
    }
    
    private def includesAspects(Ontology ontology) {
        val diagramAnnotations = ontology.diagramAnnotations
        var excluded = false
        if (diagramAnnotations !== null) {
            excluded = diagramAnnotations.exists[a|
                if (a.property.name == 'exclude') {
                    return a.findQuotedValue == 'aspects'
                }
                return false
            ]
        }
        return !excluded
    }
    
    private def includesConcepts(Ontology ontology) {
        val diagramAnnotations = ontology.diagramAnnotations
        var excluded = false
        if (diagramAnnotations !== null) {
            excluded = diagramAnnotations.exists[a|
                if (a.property.name == 'exclude') {
                    return a.findQuotedValue == 'concepts'
                }
                return false
            ]
        }
        return !excluded
    }
    
    private def findQuotedValue(Annotation annotation) {
        val lit = annotation.value
        if (lit instanceof QuotedLiteral) {
            return lit.value
        }
    }
    
    private def findIntValue(Annotation annotation) {
    	val lit = annotation.value
    	if (lit instanceof IntegerLiteral) {
    		return lit.value
    	}
    }
    
}
