package io.opencaesar.oml.dsl.ide.diagram

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

class OmlDiagramSpecifier {
    
    val String diagramIRI = "http://imce.jpl.nasa.gov/foundation/diagram"
    
    public var isDiagramSpecifier = false
    public var Map<EObject, Iterable<Annotation>> semantic2diagramAnnotations
    public var Map<String, EObject> id2semantic
    
    public val boolean includeAspects
    public val boolean includeCompartments
    
    new(Ontology ontology) {
        this.semantic2diagramAnnotations = new HashMap
        this.isDiagramSpecifier = ontology.diagramAnnotations.exists[a|
            a.property.name == "specifier"
        ]
        this.includeCompartments = ontology.includesCompartment
        this.includeAspects = ontology.includesAspects
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
                    return a.quotedValue == 'properties'
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
                    return a.quotedValue == 'compartment'
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
    
    def String getDiagramProperty(EObject eObject, String property) {
        if (property === null) return null
        
        val diagramAnnotations = eObject.diagramAnnotations
        var String value = null
        if (diagramAnnotations !== null) {
            value = diagramAnnotations.map[a|
                if (a.property.name == property &&
                        (a.owningReference == eObject || a.owningElement == eObject)
                ) {
                    return a.quotedValue
                }
            ].findFirst[v|v !== null]
        }
        return value
    }
    
//------------------- HELPERS
    
    private def includesAspects(Ontology ontology) {
        val diagramAnnotations = ontology.diagramAnnotations
        var excluded = false
        if (diagramAnnotations !== null) {
            excluded = diagramAnnotations.exists[a|
                if (a.property.name == 'exclude') {
                    return a.quotedValue == 'aspects'
                }
                return false
            ]
        }
        return !excluded
    }
    
    private def getQuotedValue(Annotation annotation) {
        val lit = annotation.value
        if (lit instanceof QuotedLiteral) {
            return lit.value
        }
    }
    
}
