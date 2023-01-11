/**
 * 
 * Copyright 2019-2021 California Institute of Technology ("Caltech").
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
package io.opencaesar.oml.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import io.opencaesar.oml.BinaryPredicate;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.ImportKind;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializableTerm;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBox;
import io.opencaesar.oml.VocabularyBundle;

/**
 * The <b>Validator2</b> for the model. It adds additional semantic rules that go beyond the EMF syntax rules. 
 * 
 * @author elaasar
 */
public final class OmlValidator2 {
    
	private static final String OWL_NOTHING = "owl:Nothing";
	
    /**
     * The singleton instance of this class
     */
    public static final OmlValidator2 INSTANCE = new OmlValidator2();
        
    private Map<EClass, List<Method>> methodMap;
    
    private OmlValidator2() {}
    
    /**
     * Validates the given Oml element by this validator's rules 
     * 
     * @param element The element to validate
     * @param diagnostics The diagnostics found during validation
     * @param context An object to object context map used in producing the error messages
     * @return True if the element is valid; False otherwise
     */
    public boolean run(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (methodMap == null) {
            collectValidates();
        }
        final List<Method> methods = methodMap.get(element.eClass());
        if (methods != null) {
            for (Method method : methods) {
                try {
                    method.invoke(this, element, diagnostics, context);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }
    
    private void collectValidates() {
        methodMap = new HashMap<>();
        final List<Method> methods = Arrays.stream(OmlValidator2.class.getDeclaredMethods()).
            filter(m -> m.getName().startsWith("validate") && m.getParameterTypes().length == 3)
            .collect(Collectors.toList());
        OmlPackage.eINSTANCE.getEClassifiers().stream().
            filter(EClass.class::isInstance).
            map(EClass.class::cast).
            filter(c -> !c.isAbstract()).
            forEach(eClass -> {
                methods.forEach(method -> {
                    final Class<?> paramType = method.getParameterTypes()[0];
                    if (paramType.isAssignableFrom(eClass.getInstanceClass())) {
                        List<Method> list = methodMap.get(eClass);
                        if (list == null) {
                            methodMap.put(eClass, list = new ArrayList<Method>());
                        }
                        list.add(method);
                    }
                });
            });
    }
    
    private boolean report(int kind, DiagnosticChain diagnostics, EObject object, String message, EStructuralFeature feature) {
        diagnostics.add(new BasicDiagnostic(
             kind,
             OmlValidator.DIAGNOSTIC_SOURCE,
             OmlValidator.ELEMENT__EXTRA_VALIDATE, // all checks will have the same code for now!
             message,
             new Object[]{object, feature}));
         return false;
    }
    
    //--------------------------------
    
    // Import
    
    /**
     * Checks if an ontology has unused import statements
     * 
     * @param object The ontology to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    @SuppressWarnings("unchecked")
	protected boolean validateOntologyHasUnusedImports(Ontology object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	var referencedNSs = new HashSet<String>();
    	for (var i = object.eAllContents(); i.hasNext();) {
    		var element = i.next();
    		var eClass = element.eClass();
    		for (var eReference : eClass.getEAllReferences()) {
    			if (!eReference.isContainment()) {
	    			var refs = element.eGet(eReference);
	    			if (eReference.isMany()) {
	    				((List<Element>)refs).forEach(ref -> {
		    				var ontology = ((Element)ref).getOntology();
		    				if (ontology != null) {
		    					referencedNSs.add(ontology.getNamespace());
		    				}
	    				});
	    			} else if (refs != null) {
    					var ontology = ((Element)refs).getOntology();
	    				if (ontology != null) {
	    					referencedNSs.add(ontology.getNamespace());
	    				}
	    			}
    			}
    		}
    	}
    	var returnValue = true;
        for (var import_ : object.getOwnedImports()) {
        	if (import_.getPrefix() != null && !referencedNSs.contains(import_.getNamespace())) {
	            report(Diagnostic.WARNING, diagnostics, import_,
	                "Import <"+import_.getNamespace()+"> with prefix is not used", null);
	            returnValue = false;
        	}
        }
        return returnValue;
    }

    /**
     * Checks if an ontology has duplicate import statements
     * 
     * @param object The ontology to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
	protected boolean validateOntologyHasDuplicateImports(Ontology object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean returnValue = true;
    	var imports = object.getOwnedImports();
    	for (var import_ : imports) {
        	if (imports.stream().anyMatch(i -> i != import_ && i.getNamespace() != null && i.getNamespace().equals(import_.getNamespace()))) {
	            report(Diagnostic.WARNING, diagnostics, import_,
	                "Import <"+import_.getNamespace()+"> is a duplicate", null);
	            returnValue = false;
        	}
        }
        return returnValue;
    }

    /**
     * Checks if an ontology has self import statements
     * 
     * @param object The ontology to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
	protected boolean validateOntologyHasSelfImports(Ontology object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean returnValue = true;
    	var imports = object.getOwnedImports();
    	for (var import_ : imports) {
        	if (imports.stream().anyMatch(i -> i.getNamespace() != null && i.getNamespace().equals(object.getNamespace()))) {
	            report(Diagnostic.WARNING, diagnostics, import_,
	                "Import <"+import_.getNamespace()+"> is to self", null);
	            returnValue = false;
        	}
        }
        return returnValue;
    }

    /**
     * Checks if an ontology's iri does not resolve to its file URI
     * 
     * @param object The ontology to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
	protected boolean validateOntologyIri(Ontology object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean returnValue = true;
    	var iri = object.getIri();
    	var uri = object.eResource().getURI();
    	if (OmlRead.isUriMappedByCatalog(uri) && !uri.equals(OmlRead.getUriByIri(object.eResource(), iri))) {
            report(Diagnostic.ERROR, diagnostics, object,
                object.eClass().getName()+" namespace '"+object.getNamespace()+"' does not resolve to its file using the catalog", 
                OmlPackage.Literals.ONTOLOGY__NAMESPACE);
            returnValue = false;
    	}
        return returnValue;
    }

	// Extension
    
    /**
     * Checks if an extension import resolves to an ontology of the right kind
     * 
     * @param object The import to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateExtensionURI(Import object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	if (object.getKind() == ImportKind.EXTENSION) {
	    	if (object.eContainer() instanceof Vocabulary) {
	    		if (!(OmlRead.getImportedOntology(object) instanceof Vocabulary)) {
		            return report(Diagnostic.ERROR, diagnostics, object,
		                "Namespace <"+object.getNamespace()+"> could not be resolved to a vocabulary", 
		                OmlPackage.Literals.IMPORT__NAMESPACE);
	        	}
	    	} else if (object.eContainer() instanceof VocabularyBundle) {
	    		if (!(OmlRead.getImportedOntology(object) instanceof VocabularyBundle)) {
		            return report(Diagnostic.ERROR, diagnostics, object,
		                "Namespace <"+object.getNamespace()+"> could not be resolved to a vocabulary bundle", 
		                OmlPackage.Literals.IMPORT__NAMESPACE);
	        	}
	    	} else if (object.eContainer() instanceof Description) {
	    		if (!(OmlRead.getImportedOntology(object) instanceof Description)) {
		            return report(Diagnostic.ERROR, diagnostics, object,
		                "Namespace <"+object.getNamespace()+"> could not be resolved to an description", 
		                OmlPackage.Literals.IMPORT__NAMESPACE);
	    		}
	    	} else if (object.eContainer() instanceof DescriptionBundle) {
	    		if  (!(OmlRead.getImportedOntology(object) instanceof DescriptionBundle)) {
		            return report(Diagnostic.ERROR, diagnostics, object,
		                "Namespace <"+object.getNamespace()+"> could not be resolved to an description bundle", 
		                OmlPackage.Literals.IMPORT__NAMESPACE);
	        	}
	    	}
    	}
    	return true;
    }
    
    // Usage
    
    /**
     * Checks if a usage import resolves to the ontology of the right kind
     * 
     * @param object The import to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateUsageURI(Import object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	if (object.getKind() == ImportKind.USAGE) {
	    	if (object.eContainer() instanceof Vocabulary) {
	        	if (!(OmlRead.getImportedOntology(object) instanceof Description)) {
		            return report(Diagnostic.ERROR, diagnostics, object,
		                "Namespace <"+object.getNamespace()+"> could not be resolved to a description", 
		                OmlPackage.Literals.IMPORT__NAMESPACE);
	        	}
	    	} else if (object.eContainer() instanceof Description) {
	            if (!(OmlRead.getImportedOntology(object) instanceof Vocabulary)) {
	                return report(Diagnostic.ERROR, diagnostics, object,
	                    "Namespace <"+object.getNamespace()+"> could not be resolved to a vocabulary", 
	                    OmlPackage.Literals.IMPORT__NAMESPACE);
	            }
	    	} else if (object.eContainer() instanceof DescriptionBundle) {
	            if (!(OmlRead.getImportedOntology(object) instanceof VocabularyBox)) {
	                return report(Diagnostic.ERROR, diagnostics, object,
	                    "Namespace <"+object.getNamespace()+"> could not be resolved to a vocabulary or a vocabulary bundle", 
	                    OmlPackage.Literals.IMPORT__NAMESPACE);
	            }
	    	}
    	}
    	return true;
    }
    
    // Inclusion
    
    /**
     * Checks if an inclusion import resolves to an ontology of the right kind
     * 
     * @param object The import to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateInclusionURI(Import object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	if (object.getKind() == ImportKind.INCLUSION) {
	    	if (object.eContainer() instanceof VocabularyBundle) {
	    		if (!(OmlRead.getImportedOntology(object) instanceof Vocabulary)) {
		            return report(Diagnostic.ERROR, diagnostics, object,
		                "Namespace <"+object.getNamespace()+"> could not be resolved to a vocabulary", 
		                OmlPackage.Literals.IMPORT__NAMESPACE);
	    		}
	    	} else if (object.eContainer() instanceof DescriptionBundle) {
	    		if (!(OmlRead.getImportedOntology(object) instanceof Description)) {
		            return report(Diagnostic.ERROR, diagnostics, object,
		                "Namespace <"+object.getNamespace()+"> could not be resolved to a description", 
		                OmlPackage.Literals.IMPORT__NAMESPACE);
	    		}
	    	}
    	}
    	return true;
    }
    
    // PropertyRestrictionAxiom
    
    /**
     * Checks if the domain of a restricted property is the same as or a super type of the restricting classifier
     * 
     * @param object The property restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyRestrictionAxiomDomain(PropertyRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Classifier restrictingDomain = OmlRead.getRestrictingDomain(object);
        final SemanticProperty property = object.getProperty();
        final Classifier domainType = (property!=null) ? property.getDomain() : null;
        if (restrictingDomain != null && domainType != null) {
	        final Collection<SpecializableTerm> allGeneralTerms = OmlRead.closure(restrictingDomain, true, t -> OmlSearch.findSuperTerms(t));
	        if (!allGeneralTerms.stream().filter(t -> t == domainType).findAny().isPresent()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Property "+object.getProperty().getAbbreviatedIri()+" has a domain "+object.getProperty().getDomain().getAbbreviatedIri()+" that is not the same as or a super type of "+restrictingDomain.getAbbreviatedIri(), 
	                OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
	        }
        }
        return true;
    }

    // PropertyRangeRestrictionAxiom

    /**
     * Checks if the range of a property range restriction is the same as or a sub type of the restricted property's range
     * 
     * @param object The property range restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyRangeRestrictionAxiomRange(PropertyRangeRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Type restrictedRange = object.getRange();
        final SemanticProperty property = object.getProperty();
        final Type rangeType = (property!=null) ? property.getRange() : null;
        if (rangeType != null && restrictedRange != null && !restrictedRange.getAbbreviatedIri().equals(OWL_NOTHING)) {
	        final Collection<SpecializableTerm> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
	        if (!allGeneralEntities.stream().filter(t -> t == rangeType).findAny().isPresent()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Type "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of "+rangeType.getAbbreviatedIri(), 
	                OmlPackage.Literals.PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE);
	        }
        }
        return true;
    }

    // PropertyCardinalityRestrictionAxiom

    /**
     * Checks if the range of a property cardinality restriction is the same as or a sub type of the restricted property's range
     * 
     * @param object The property cardinality restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyCardinalityRestrictionAxiomRange(PropertyCardinalityRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Type restrictedRange = object.getRange();
        final SemanticProperty property = object.getProperty();
        final Type rangeType = (property!=null) ? property.getRange() : null;
        if (rangeType != null && restrictedRange != null && !restrictedRange.getAbbreviatedIri().equals(OWL_NOTHING)) {
            final Collection<SpecializableTerm> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
            if (!allGeneralEntities.stream().filter(t -> t == rangeType).findAny().isPresent()) {
                return report(Diagnostic.WARNING, diagnostics, object,
                    "Type "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of "+rangeType.getAbbreviatedIri(), 
                    OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE);
            }
        }
        return true;
    }

    // PropertyValueRestrictionAxiom

    /**
     * Checks if the value of a property cardinality restriction is appropriate for the restricted property kind
     * 
     * @param object The property value restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyValueRestrictionAxiomValue(PropertyValueRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final SemanticProperty property = object.getProperty();
        if (property instanceof ScalarProperty) {
        	if (object.getLiteralValue() == null) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "A literal is expected as the restricted value of property "+property.getAbbreviatedIri(), 
	                OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
        	}
        } else if (property instanceof StructuredProperty) {
        	if (object.getStructureInstanceValue() == null) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "A structure instance is expected as the restricted value of property "+property.getAbbreviatedIri(), 
	                OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
        	}
        } else if (property instanceof Relation) {
        	if (object.getNamedInstanceValue() == null) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "A named instance IRI is expected as the restricted value of relation "+property.getAbbreviatedIri(), 
	                OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
        	}
        }
        return true;
    }

    // SpecializationAxiom
    
    /**
     * Checks if a specialization axiom is not between compatible term kinds
     * 
     * @param object The specialization axiom to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateSpecializationAxiomSpecializedTermKind(SpecializationAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final SpecializableTerm superTerm = OmlRead.getSuperTerm(object);
        final SpecializableTerm subTerm = OmlRead.getSubTerm(object);
        if (superTerm == subTerm) {
            return report(Diagnostic.WARNING, diagnostics, object,
	                "SpecializableTerm "+superTerm.getAbbreviatedIri()+" specializes itself", 
	                OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
        } else if (superTerm != null && !superTerm.eIsProxy()) {
	        final EClass superEClass = superTerm.eClass();
	        final EClass subEClass = subTerm.eClass();
	        if (!((OmlPackage.Literals.ASPECT == superEClass && OmlPackage.Literals.ENTITY.isSuperTypeOf(subEClass)) ||
	            (OmlPackage.Literals.FACETED_SCALAR == superEClass && OmlPackage.Literals.ENUMERATED_SCALAR == subEClass) ||
	            (superEClass == subEClass))) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "SpecializableTerm "+superTerm.getAbbreviatedIri()+" cannot be specialized by "+subTerm.getAbbreviatedIri()+"", 
	                OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
	        }
        }
        return true;
    }
    
    // Faceted Scalar
    
    /**
     * Checks the inheritance rules of faceted scalars
     * 
     * @param object The faceted scalar to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateFacetedScalarSupertype(FacetedScalar object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getLanguage() != null ||
        	object.getLength() != null ||
            object.getMaxLength() != null ||
        	object.getMinLength() != null ||
        	object.getMaxExclusive() != null ||
        	object.getMaxInclusive() != null ||
        	object.getMinExclusive() != null ||
        	object.getMinInclusive() != null) {
        	var singleStandardGeneral = false;
        	var specializations = object.getOwnedSpecializations();
        	if (specializations.size() == 1) {
        		var general = (Scalar) specializations.get(0).getSpecializedTerm();
            	singleStandardGeneral = isStandardScalar(general);
        	}
        	if (!singleStandardGeneral) {
                return report(Diagnostic.ERROR, diagnostics, object,
                	"Faceted scalar "+object.getAbbreviatedIri()+" with facets must specify a single standard supertype", 
    	            OmlPackage.Literals.MEMBER__NAME);
        	}
        } else {
        	var specializations = object.getOwnedSpecializations();
            if (specializations.isEmpty() && !isStandardScalar(object)) {
                return report(Diagnostic.ERROR, diagnostics, object,
                	"Faceted scalar "+object.getAbbreviatedIri()+" is non-standard hence must specify a supertype", 
    	            OmlPackage.Literals.MEMBER__NAME);
            }
        }
        return true;
    }

    // Enumerated Scalar

    /**
     * Checks an enumerated scalar's literals and supertype rules
     * 
     * @param object The enumerated scalar to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateEnumeratedScalarLiterals(EnumeratedScalar object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	if (object.getLiterals().isEmpty() && object.getOwnedSpecializations().isEmpty()) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "Enumerated scalar "+object.getAbbreviatedIri()+" must specify literals or supertypes", 
                OmlPackage.Literals.MEMBER__NAME);
    	}
        return true;
    }

    // Classifier Predicate

    /**
     * Checks if a type predicate references an invalid type in a rule's consequent
     * 
     * @param object The type predicate to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateTypePredicateAsConsequent(TypePredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getConsequentRule() != null) {
	       if (object.getType() instanceof Structure) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "Structure "+object.getType().getAbbreviatedIri()+" cannot be used as a consequent predicate", 
	                OmlPackage.Literals.TYPE_PREDICATE__TYPE);
	        } else if (object.getType() instanceof Scalar) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                    "Scalar "+object.getType().getAbbreviatedIri()+" cannot be used as a consequent predicate", 
	                    OmlPackage.Literals.TYPE_PREDICATE__TYPE);
	        }
        }
        return true;
    }

    // Property Predicate

    /**
     * Checks if a property predicate references invalid properties is in a rule's consequent
     * 
     * @param object The property predicate to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyPredicateAsConsequent(PropertyPredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getConsequentRule() != null && object.getProperty() instanceof StructuredProperty) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "Structured property "+object.getProperty().getAbbreviatedIri()+" cannot be used as a consequent predicate", 
                OmlPackage.Literals.PROPERTY_PREDICATE__PROPERTY);
        }
        return true;
    }

    // Binary Predicate

    /**
     * Checks if a property predicate has a second argument
     * 
     * @param object The property predicate to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyPredicateArg2(BinaryPredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getVariable2() == null &&
        	object.getInstance2() == null &&
        	(!(object instanceof PropertyPredicate) || ((PropertyPredicate)object).getLiteral2() == null)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "Binary predicate must have a second argument", 
                OmlPackage.Literals.BINARY_PREDICATE__VARIABLE2);
        }
        return true;
    }

    // Quoted Literal

    /**
     * Checks if a quoted literal is typed by one of the standard scalar types
     * 
     * @param object The quoted literal to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateQuotedLiteral(QuotedLiteral object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	var scalar = object.getType();
    	if (scalar != null) {
	    	if (!isStandardScalar(scalar)) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "Quoted Literal \""+object.getValue()+"\" is not typed by a standard scalar", 
	                OmlPackage.Literals.QUOTED_LITERAL__TYPE);
	        }
    	}
        return true;
    }
    
    /*
     * Returns if the given scalar iis a standard one
     *  
     * @param scalar the given scalar
     * @return whetehr the scalar is standard
     */
    private boolean isStandardScalar(Scalar scalar) {
    	var ontology = scalar.getOntology();
    	if (ontology != null) {
	    	var ontologyNs = ontology.getNamespace();
	    	return ontologyNs.equals(OmlConstants.XSD_NS) ||
	            	ontologyNs.equals(OmlConstants.RDF_NS) ||
	            	ontologyNs.equals(OmlConstants.RDFS_NS) ||
	            	ontologyNs.equals(OmlConstants.OWL_NS);
    	}
    	return false;
    }
    
    // Assertions

    /**
     * Checks if the subject of a property value assertion has a type that is the same or a subtype of the property's domain
     * 
     * @param object The property value assertion to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyValueRestrictionAxiomSubject(PropertyValueAssertion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final var theSubject = OmlRead.getSubject(object);
        final SemanticProperty property = object.getProperty();
        final Classifier domainType = property.getDomain();
        if (!OmlSearch.findIsKindOf(theSubject, domainType)) {
        	return report(Diagnostic.WARNING, diagnostics, object,
                "Property "+property.getAbbreviatedIri()+" has a domain that is not the same as or a super type of the assertion's subject",
                OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY);
        }
        return true;
    }

    /**
     * Checks if the object of a property value assertion has a type that is the same or a subtype of the property's range
     * 
     * @param object The property value assertion to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyValueRestrictionAxiomObject(PropertyValueAssertion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final var theObject = OmlRead.getObject(object);
        final SemanticProperty property = object.getProperty();
        if (property instanceof ScalarProperty) {
        	if (theObject instanceof Literal && OmlSearch.findIsKindOf((Literal)theObject, (Scalar)property.getRange())) {
        		return true;
        	}
        } else {
        	if (theObject instanceof Instance && OmlSearch.findIsKindOf((Instance)theObject, (Classifier)property.getRange())) {
        		return true;
        	}
        }
    	return report(Diagnostic.WARNING, diagnostics, object,
            "Property "+property.getAbbreviatedIri()+" has a range that is not the same as or a super type of the assertion's value",
            OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY);
    }

    /**
     * Checks that the type assertion is asserted by the proper kind for the instance
     * 
     * @param object The type assertion to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateTypeRestriction(TypeAssertion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final var instance = OmlRead.getAssertingInstance(object);
        final var type = object.getType();
        if (((instance instanceof ConceptInstance) && !(type instanceof Concept)) || 
        	((instance instanceof RelationInstance) && !(type instanceof RelationEntity))) {
        	return report(Diagnostic.ERROR, diagnostics, object,
                "Type "+type.getAbbreviatedIri()+" cannot be a type for instance "+instance.getAbbreviatedIri() , 
                OmlPackage.Literals.TYPE_ASSERTION__TYPE);
        }
        return true;
    }

    /**
     * Checks that a member has correct feature cardinalities
     * 
     * @param object The member to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateMemberCardinalities(Member object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = true;
        if ((object.getName() == null && object.getRef() == null) ||
        	(object.getName() != null && object.getRef() != null)) {
        	report(Diagnostic.ERROR, diagnostics, object,
                "Member needs to either have a name or a ref to another member",
                OmlPackage.Literals.MEMBER__NAME);
        	result = false;
        }
        return result;
    }

    /**
     * Checks that a concept has correct feature cardinalities
     * 
     * @param object The concept to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateConceptCardinalities(Concept object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = true;
        if (object.getName() == null) {
        	if (!object.getEnumeratedInstances().isEmpty()) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Concept "+object.getAbbreviatedIri()+" cannot respecify enumerated instances",
	                OmlPackage.Literals.CONCEPT__ENUMERATED_INSTANCES);
	        	result = false;
        	}
        }
        return result;
    }

    /**
     * Checks that a relation base has correct feature cardinalities
     * 
     * @param object The relation base to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateRelationBaseCardinalities(RelationBase object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = true;
    	if (object.getName() != null) {
        	if (object.getSource() == null) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Relation "+object.getAbbreviatedIri()+" needs to specify a source",
	                OmlPackage.Literals.MEMBER__NAME);
	        	result = false;
        	}
        	if (object.getTarget() == null) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Relation "+object.getAbbreviatedIri()+" needs to specify a target",
	                OmlPackage.Literals.MEMBER__NAME);
	        	result = false;
        	}
        } else {
        	if (object.getSource() != null) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Relation "+object.getAbbreviatedIri()+" cannot respecify a source",
	                OmlPackage.Literals.RELATION_BASE__SOURCE);
	        	result = false;
        	}
        	if (object.getTarget() != null) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Relation "+object.getAbbreviatedIri()+" cannot respecify a target",
	                OmlPackage.Literals.RELATION_BASE__TARGET);
	        	result = false;
        	}
        	if (object.getReverseRelation() != null) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Relation "+object.getAbbreviatedIri()+" cannot respecify a reverse relation",
	                OmlPackage.Literals.RELATION_BASE__REVERSE_RELATION);
	        	result = false;
        	}
        }
        return result;
    }

    /**
     * Checks that a relation base has correct feature cardinalities
     * 
     * @param object The relation base to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateRelationEntityCardinalities(RelationEntity object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = true;
    	if (object.getName() == null) {
        	if (object.getForwardRelation() != null) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Relation "+object.getAbbreviatedIri()+" cannot respecify a forward relation",
	                OmlPackage.Literals.RELATION_ENTITY__FORWARD_RELATION);
	        	result = false;
        	}
        }
        return result;
    }
    
    /**
     * Checks that an enumerated scalar has correct feature cardinalities
     * 
     * @param object The scalar to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateEnumeratedScalarCardinalities(EnumeratedScalar object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = true;
    	if (object.getName() == null) {
        	if (!object.getLiterals().isEmpty()) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Scalar "+object.getAbbreviatedIri()+" cannot respecify enumerated literals",
	                OmlPackage.Literals.ENUMERATED_SCALAR__LITERALS);
	        	result = false;
        	}
        }
        return result;
    }

    /**
     * Checks that a scalar property base the correct feature cardinalities
     * 
     * @param object The property to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateScalarPropertyCardinalities(ScalarProperty object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getName() != null) {
        	if (object.getDomain() == null) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Propertys "+object.getAbbreviatedIri()+" needs to specify a domain",
	                OmlPackage.Literals.MEMBER__NAME);
        	}
        	else if (object.getRange() == null) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Property "+object.getAbbreviatedIri()+" needs to specify a range",
	                OmlPackage.Literals.MEMBER__NAME);
        	}
        } else {
        	if (object.getDomain() != null) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Propertys "+object.getAbbreviatedIri()+" cannot respecify a domain",
	                OmlPackage.Literals.SCALAR_PROPERTY__DOMAIN);
        	}
        	else if (object.getRange() != null) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Property "+object.getAbbreviatedIri()+" cannot respecify a range",
	                OmlPackage.Literals.SCALAR_PROPERTY__RANGE);
        	}
        }
        return true;
    }

    /**
     * Checks that a structured property base the correct feature cardinalities
     * 
     * @param object The property to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateStructuredPropertyCardinalities(StructuredProperty object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getName() != null) {
        	if (object.getDomain() == null) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Propertys "+object.getAbbreviatedIri()+" needs to specify a domain",
	                OmlPackage.Literals.MEMBER__NAME);
        	}
        	else if (object.getRange() == null) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Property "+object.getAbbreviatedIri()+" needs to specify a range",
	                OmlPackage.Literals.MEMBER__NAME);
        	}
        } else {
        	if (object.getDomain() != null) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Propertys "+object.getAbbreviatedIri()+" cannot respecify a domain",
	                OmlPackage.Literals.STRUCTURED_PROPERTY__DOMAIN);
        	}
        	else if (object.getRange() != null) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Property "+object.getAbbreviatedIri()+" cannot respecify a range",
	                OmlPackage.Literals.STRUCTURED_PROPERTY__RANGE);
        	}
        }
        return true;
    }

    /**
     * Checks that a rule has the correct feature cardinalities
     * 
     * @param object The rule to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateRuleCardinalities(Rule object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getName() != null) {
        	if (object.getAntecedent().isEmpty()) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Rule "+object.getAbbreviatedIri()+" needs to specify some predicates as antecedent",
	                OmlPackage.Literals.MEMBER__NAME);
        	}
        	else if (object.getConsequent().isEmpty()) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Rule "+object.getAbbreviatedIri()+" needs to specify some predicates as consequent",
	                OmlPackage.Literals.MEMBER__NAME);
        	}
        } else {
        	boolean result = true;
        	if (!object.getAntecedent().isEmpty()) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Rule "+object.getAbbreviatedIri()+" cannot respecify a predeicate as antecedent",
	                OmlPackage.Literals.RULE__ANTECEDENT);
	        	result = false;
        	}
        	if (!object.getConsequent().isEmpty()) {
	        	report(Diagnostic.ERROR, diagnostics, object,
	                "Rule "+object.getAbbreviatedIri()+" cannot respecify a predicate as consequent",
	                OmlPackage.Literals.RULE__CONSEQUENT);
	        	result = false;
        	}
        	return result;
        }
        return true;
    }

    /**
     * Checks that a relation instance has the correct feature cardinalities
     * 
     * @param object The relation instance to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateRelationInstanceCardinalities(RelationInstance object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getName() != null) {
        	if (object.getSources().isEmpty()) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Relation instance "+object.getAbbreviatedIri()+" needs to specify at least one source",
	                OmlPackage.Literals.MEMBER__NAME);
        	}
        	else if (object.getTargets().isEmpty()) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Relation instance "+object.getAbbreviatedIri()+" needs to specify at least one target",
	                OmlPackage.Literals.MEMBER__NAME);
        	}
        }
        return true;
    }

    //////// Utilities
    
    /**
     * Checks if col1 intersect with col2
     * 
     * @param col1 The first collection
     * @param col2 The second collection
     * @return whether the two collections intersect
     */
    protected boolean instersect(Collection<?> col1, Collection<?> col2) {
    	return col1.stream().anyMatch(i -> col2.contains(i));
    }
    
}