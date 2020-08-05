package io.opencaesar.oml.dsl.ide.diagram

import io.opencaesar.oml.AnnotatedElement
import io.opencaesar.oml.Annotation
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.Concept
import io.opencaesar.oml.IdentifiedElement
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.Reference
import java.util.Map
import org.eclipse.emf.ecore.EObject

import static extension io.opencaesar.oml.util.OmlRead.*
import static extension io.opencaesar.oml.util.OmlSearch.*
import io.opencaesar.oml.QuotedLiteral

class OmlDiagramSpecifier {
    
    static val String diagramIRI = "http://imce.jpl.nasa.gov/foundation/diagram"
    
    public static var isDiagramSpecifier = false
    public static var Map<EObject, Iterable<Annotation>> semantic2diagramAnnotations
    
    public static var includeAspects = true
    public static var includeCompartments = false
    
    static def isSpecifier(Ontology ontology) {
        isDiagramSpecifier = ontology.diagramAnnotations.exists[a|
            a.property.name == "specifier"
        ]
        if (isDiagramSpecifier) {
            includeCompartments = ontology.includesCompartment
            includeAspects = ontology.includesAspects
        }
    }
    
    static def boolean hasDiagramIRI(Ontology ontology) {
        return ontology.iri == diagramIRI
    }

    static def boolean specify(EObject eObject) {
        if (!isDiagramSpecifier) return true

        return eObject.included
    }
    
    static def boolean isIncluded(EObject eObject) {
        if (eObject.excluded) return false
        
        val diagramAnnotations = eObject.diagramAnnotations
        if (diagramAnnotations !== null) {
            return diagramAnnotations.exists[a|
                a.property.name == 'include'
                && a.value === null
            ]
        }
        return false
    }
    
    static def boolean isExcluded(EObject eObject) {
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
    
    static def boolean includesProperties(EObject eObject) {
        val diagramAnnotations = eObject.diagramAnnotations
        var included = false
        if (diagramAnnotations !== null) {
            included = diagramAnnotations.exists[a|
                if (a.property.name == 'include') {
                    val lit = a.value
                    if (lit instanceof QuotedLiteral) {
                        return lit.value == 'properties'
                    }
                }
                return false
            ]
        }
        return included
    }
    
    static def boolean includesCompartment(EObject eObject) {
        val diagramAnnotations = eObject.diagramAnnotations
        var excluded = false
        if (diagramAnnotations !== null) {
            excluded = diagramAnnotations.exists[a|
                if (a.property.name == 'exclude') {
                    val lit = a.value
                    if (lit instanceof QuotedLiteral) {
                        return lit.value == 'compartment'
                    }
                }
                return false
            ]
        }
        return !excluded
    }
    
    static def boolean isDiagramImport(EObject eObject) {
        if (eObject instanceof IdentifiedElement) {
            return eObject.iri == diagramIRI
        }
        return false
    }
    
    static def Iterable<Annotation> getDiagramAnnotations(EObject eObject) {
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
    
    static def includesAspects(Ontology ontology) {
        val diagramAnnotations = ontology.diagramAnnotations
        var excluded = false
        if (diagramAnnotations !== null) {
            excluded = diagramAnnotations.exists[a|
                if (a.property.name == 'exclude') {
                    val lit = a.value
                    if (lit instanceof QuotedLiteral) {
                        return lit.value == 'aspects'
                    }
                }
                return false
            ]
        }
        return !excluded
    }
    
}
