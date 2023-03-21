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

import io.opencaesar.oml.Argument;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierEquivalenceAxiom;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.ImportKind;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationBase;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.Term;
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
        final Classifier restrictingDomain = object.getRestrictingDomain();
        final SemanticProperty property = object.getProperty();
        final Classifier domainType = (property!=null) ? property.getDomain() : null;
        if (restrictingDomain != null && domainType != null) {
	        final Collection<Term> allGeneralTerms = OmlRead.closure(restrictingDomain, true, t -> OmlSearch.findSuperTerms(t));
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
	        final Collection<Term> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
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
            final Collection<Term> allGeneralEntities = OmlRead.closure(restrictedRange, true, t -> OmlSearch.findSuperTerms(t));
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
        	} else if (property.getRange() != null && !OmlSearch.findIsOfKind(object.getLiteralValue(), ((ScalarProperty)property).getRange())) {
	            return report(Diagnostic.WARNING, diagnostics, object,
		                "The literal is not in the range of scalar property "+property.getAbbreviatedIri(), 
		                OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE);
        	}
        } else if (property instanceof StructuredProperty) {
        	if (object.getStructureInstanceValue() == null) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "A structure instance is expected as the restricted value of property "+property.getAbbreviatedIri(), 
	                OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
        	} else if (property.getRange() != null && !OmlSearch.findIsOfKind(object.getStructureInstanceValue(), ((StructuredProperty)property).getRange())) {
	            return report(Diagnostic.WARNING, diagnostics, object,
		                "The instance is not in the range of structured property "+property.getAbbreviatedIri(), 
		                OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__STRUCTURE_INSTANCE_VALUE);
        	}
        } else if (property instanceof Relation) {
        	if (object.getNamedInstanceValue() == null) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "A named instance IRI is expected as the restricted value of relation "+property.getAbbreviatedIri(), 
	                OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
        	} else if (property.getRange() != null && !OmlSearch.findIsOfKind(object.getNamedInstanceValue(), ((Relation)property).getRange())) {
	            return report(Diagnostic.WARNING, diagnostics, object,
		                "The instance is not in the range of relation "+property.getAbbreviatedIri(), 
		                OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__NAMED_INSTANCE_VALUE);
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
        final Term superTerm = object.getSuperTerm();
        final Term subTerm = object.getSubTerm();
        if (superTerm == subTerm) {
            return report(Diagnostic.WARNING, diagnostics, object,
	                "Term "+subTerm.getAbbreviatedIri()+" specializes itself", 
	                OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM);
        } 
        if (superTerm != null && !superTerm.eIsProxy()) {
	        final EClass superEClass = superTerm.eClass();
	        final EClass subEClass = subTerm.eClass();
	        if (!((OmlPackage.Literals.ASPECT == superEClass && OmlPackage.Literals.ENTITY.isSuperTypeOf(subEClass)) ||
	            (superEClass == subEClass))) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "Term "+superTerm.getAbbreviatedIri()+" cannot be specialized by "+subTerm.getAbbreviatedIri()+"", 
	                OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM);
	        }
        }
        return true;
    }

    // ClassifierEquivalenceAxiom
    
    /**
     * Checks if a classifier equivalence axiom is not between compatible classifier kinds
     * 
     * @param object The classifier equivalence axiom to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateClassifierEquivalenceAxiom(ClassifierEquivalenceAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final List<Classifier> superClassifiers = object.getSuperClassifiers();
        final Classifier subClassifier = object.getSubClassifier();
        if (superClassifiers.contains(subClassifier)) {
            return report(Diagnostic.WARNING, diagnostics, object,
	                "Classifier "+subClassifier.getAbbreviatedIri()+" specializes itself", 
	                OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS);
        } 
        final EClass subEClass = subClassifier.eClass();
        for(Classifier superClassifier : superClassifiers) {
	        if (!superClassifier.eIsProxy()) {
		        final EClass superEClass = superClassifier.eClass();
		        if (superEClass != subEClass) {
		            return report(Diagnostic.ERROR, diagnostics, object,
		                "Classifier "+superClassifier.getAbbreviatedIri()+" cannot be specialized by "+subClassifier.getAbbreviatedIri()+"", 
		                OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS);
		        }
	        }
        }
        return true;
    }

    // PropertyEquivalenceAxiom
    
    /**
     * Checks if a property equivalence axiom is not between compatible property kinds
     * 
     * @param object The property equivalence axiom to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyEquivalenceAxiom(PropertyEquivalenceAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Property superProperty = object.getSuperProperty();
        final Property subProperty = object.getSubProperty();
        if (superProperty == subProperty) {
            return report(Diagnostic.WARNING, diagnostics, object,
	                "Property "+subProperty.getAbbreviatedIri()+" specializes itself", 
	                OmlPackage.Literals.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY);
        } 
        if (superProperty != null && !superProperty.eIsProxy()) {
	        final EClass superEClass = superProperty.eClass();
	        final EClass subEClass = subProperty.eClass();
	        if (superEClass != subEClass) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "Property "+superProperty.getAbbreviatedIri()+" cannot be specialized by "+subProperty.getAbbreviatedIri()+"", 
	                OmlPackage.Literals.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY);
	        }
        }
        return true;
    }

    // Faceted Scalar
    
    /**
     * Checks the inheritance rules of scalars
     * 
     * @param object The scalar to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateScalarSupertype(Scalar object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	var specializations = object.getOwnedSpecializations();
    	if (!OmlRead.isStandardScalar(object)) {
    		if (specializations.size() == 0) {
                return report(Diagnostic.ERROR, diagnostics, object,
                	"Non-standard scalar "+object.getAbbreviatedIri()+" must specify a supertype", 
    	            OmlPackage.Literals.MEMBER__NAME);
	        }
    		if (object.getLanguage() != null ||
	        	object.getLength() != null ||
	            object.getMaxLength() != null ||
	        	object.getMinLength() != null ||
	        	object.getMaxExclusive() != null ||
	        	object.getMaxInclusive() != null ||
	        	object.getMinExclusive() != null ||
	        	object.getMinInclusive() != null) 
	        {
	        	if (specializations.size() > 1 || !OmlRead.isStandardScalar((Scalar) specializations.get(0).getSuperTerm())) {
	                return report(Diagnostic.ERROR, diagnostics, object,
	                	"Non-standard scalar "+object.getAbbreviatedIri()+" with facets must specify a single standard supertype", 
	    	            OmlPackage.Literals.MEMBER__NAME);
	        	}
	        }
    		if (object.getOwnedEnumeration() != null) {
    			for (Term superTerm : OmlRead.getSuperTerms(object)) {
    				Scalar superScalar = (Scalar) superTerm;
    				for (Literal literal : object.getOwnedEnumeration().getLiterals()) {
    		        	if (!OmlSearch.findIsOfKind(literal, superScalar)) {
    		                return report(Diagnostic.ERROR, diagnostics, object,
    		                	"Literal "+OmlRead.getLexicalValue(literal)+" is not in the range of literals of scalar "+superScalar.getAbbreviatedIri(), 
    		    	            OmlPackage.Literals.MEMBER__NAME);
    		        	}
    				}
    			}
	        	
	        }
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

    // Type Predicate

    /**
     * Checks if an argument is well formed
     * 
     * @param object The argument to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyPredicateArg2(Argument object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	int n1 = object.getVariable() != null ? 1 : 0;
    	int n2 = object.getLiteral() != null ? 1 : 0;
    	int n3 = object.getInstance() != null ? 1 : 0;
        if (n1+n2+n3 != 1) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "Argument must be either a variable, a literal or an instance.", OmlPackage.Literals.ARGUMENT__VARIABLE);
        }
        return true;
    }

    // Type Predicate

    /**
     * Checks if a type predicate is well formed
     * 
     * @param object The predicate to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validateTypePredicate(TypePredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getType() instanceof Scalar) {
        	if (object.getArgument().getInstance() != null) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "Scalar predicate cannot have a named instance as an argument", 
	                OmlPackage.Literals.TYPE_PREDICATE__TYPE);
        	}
        } else {
        	if (object.getArgument().getLiteral() != null) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                    "Entity predicate cannot have a literal as an argument", 
	                    OmlPackage.Literals.TYPE_PREDICATE__TYPE);
        	}
        }
        return true;
    }

    /**
     * Checks if a property predicate is well formed
     * 
     * @param object The predicate to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyPredicate(PropertyPredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	if (object.getArgument1().getLiteral() != null) {
            report(Diagnostic.ERROR, diagnostics, object,
                "Property predicate cannot have a literal as a first argument", 
                OmlPackage.Literals.TYPE_PREDICATE__TYPE);
            result = false;
    	}
        if (object.getProperty() instanceof ScalarProperty) {
        	if (object.getArgument2().getInstance() != null) {
	            report(Diagnostic.ERROR, diagnostics, object,
	                "Scala property predicate cannot have a named instance as a second argument", 
	                OmlPackage.Literals.TYPE_PREDICATE__TYPE);
	            result = false;
        	}
        } else if (object.getProperty() instanceof Relation) {
        	if (object.getArgument2().getLiteral() != null) {
	            report(Diagnostic.ERROR, diagnostics, object,
	                    "Relation predicate cannot have a literal as a second argument", 
	                    OmlPackage.Literals.TYPE_PREDICATE__TYPE);
	            result = false;
        	}
        }
        return result;
    }

    /**
     * Checks if a relation entity predicate is well formed
     * 
     * @param object The predicate to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    protected boolean validatePropertyPredicate(RelationEntityPredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean result = true;
    	if (object.getArgument1().getLiteral() != null) {
            report(Diagnostic.ERROR, diagnostics, object,
                "Relation entity predicate cannot have a literal as a first argument", 
                OmlPackage.Literals.TYPE_PREDICATE__TYPE);
            result = false;
    	}
    	if (object.getArgument().getLiteral() != null) {
            report(Diagnostic.ERROR, diagnostics, object,
                "Relation entity predicate cannot have a literal as a second argument", 
                OmlPackage.Literals.TYPE_PREDICATE__TYPE);
            result = false;
    	}
    	if (object.getArgument().getInstance() != null && !(object.getArgument().getInstance() instanceof RelationInstance)) {
            report(Diagnostic.ERROR, diagnostics, object,
                "Relation entity predicate cannot have a non-relation instance as a second argument", 
                OmlPackage.Literals.TYPE_PREDICATE__TYPE);
            result = false;
    	}
    	if (object.getArgument2().getLiteral() != null) {
            report(Diagnostic.ERROR, diagnostics, object,
                "Relation entity predicate cannot have a literal as a third argument", 
                OmlPackage.Literals.TYPE_PREDICATE__TYPE);
            result = false;
    	}
        return result;
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
    	if (scalar != null && !OmlRead.isStandardScalar(scalar)) {
            return report(Diagnostic.ERROR, diagnostics, object,
                "Quoted Literal \""+object.getValue()+"\" is not typed by a standard scalar", 
                OmlPackage.Literals.QUOTED_LITERAL__TYPE);
    	}
        return true;
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
        final var theSubject = object.getAssertingInstance();
        final SemanticProperty property = object.getProperty();
        final Classifier domainType = property.getDomain();
        if (!OmlSearch.findIsOfKind(theSubject, domainType)) {
        	return report(Diagnostic.WARNING, diagnostics, object,
                "Property "+property.getAbbreviatedIri()+" has a domain that does not include the asserting instance",
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
        if (property != null && property.getRange() != null && theObject != null) {
        	var validLiteral = theObject instanceof Literal && OmlSearch.findIsOfKind((Literal)theObject, (Scalar)property.getRange());
        	var validInstance = theObject instanceof Instance && OmlSearch.findIsOfKind((Instance)theObject, (Classifier)property.getRange());
	        if ((property instanceof ScalarProperty && !validLiteral) || 
	        	(property instanceof StructuredProperty && !validInstance) ||
	        	(property instanceof Relation && !validInstance)) {
		    	return report(Diagnostic.WARNING, diagnostics, object,
			            "Property "+property.getAbbreviatedIri()+" has a range that does not include the asserted value",
			            OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY);
	        }
        }
        return true;
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
        final var instance = object.getAssertingInstance();
        final var type = object.getType();
        if (type != null) {
	        if (((instance instanceof ConceptInstance) && !(type instanceof Concept || type instanceof Aspect)) || 
	        	((instance instanceof RelationInstance) && !(type instanceof RelationEntity || type instanceof Aspect))) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Type "+type.getAbbreviatedIri()+" cannot be a type for instance "+instance.getAbbreviatedIri() , 
	                OmlPackage.Literals.TYPE_ASSERTION__TYPE);
	        }
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
        if ((object.getName() == null && !object.isRef()) ||
        	(object.getName() != null && object.isRef())) {
        	report(Diagnostic.ERROR, diagnostics, object,
                "Member needs to either have a name or a ref to another member",
                OmlPackage.Literals.MEMBER__NAME);
        	result = false;
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