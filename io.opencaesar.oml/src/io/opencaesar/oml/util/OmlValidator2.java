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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnonymousConceptInstance;
import io.opencaesar.oml.AnonymousInstance;
import io.opencaesar.oml.AnonymousRelationInstance;
import io.opencaesar.oml.Argument;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityEquivalenceAxiom;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.ImportKind;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Property;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyEquivalenceAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyRestrictionAxiom;
import io.opencaesar.oml.PropertySelfRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarEquivalenceAxiom;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializationAxiom;
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
    
	private static final String CACHE = "ValidationCache";

	private class Cache {
    	private Map<Property, Set<Entity>> propertyToDomains = new HashMap<>();
    	private Map<Property, Set<Type>> propertyToRanges = new HashMap<>();
    	private Map<Set<Entity>, Set<Entity>> entityToSupers = new HashMap<>();
    	private Map<Scalar, Set<Scalar>> scalarToSupers = new HashMap<>();
    	private Map<Set<Type>, Set<Literal>> scalarToLiterals = new HashMap<>();

    	public Set<Resource> scope;
    	public Cache(Set<Resource> scope) {
    		this.scope = scope;
    	}
    	public Set<Entity> getDomains(SemanticProperty property) {
            Set<Entity> domains = propertyToDomains.get(property);
            if (domains == null) {
            	propertyToDomains.put(property, domains =  OmlSearch.findAllDomains(property, scope));
            }
            return domains;
    	}
    	public Set<Type> getRanges(SemanticProperty property) {
            Set<Type> ranges = propertyToRanges.get(property);
            if (ranges == null) {
            	propertyToRanges.put(property, ranges =  OmlSearch.findAllRanges(property, scope));
            }
            return ranges;
    	}
    	public Set<Entity> getAllTypes(Instance instance) {
            final Set<Entity> types = OmlSearch.findTypes(instance, scope);
            Set<Entity> supers = entityToSupers.get(types);
            if (supers == null) {
            	entityToSupers.put(types, supers =  OmlSearch.findAllTypes(instance, scope));
            }
            return supers;
    	}
    	public Set<Scalar> getAllTypes(Literal literal) {
            final Scalar type = OmlRead.getType(literal);
            Set<Scalar> supers = scalarToSupers.get(type);
            if (supers == null) {
            	scalarToSupers.put(type, supers =  OmlSearch.findAllTypes(literal, scope));
            }
            return supers;
    	}
    	public Set<Literal> getEnumLiterals(Set<Type> types) {
        	var enumLiterals = scalarToLiterals.get(types);
        	if (enumLiterals == null) {
	        	scalarToLiterals.put(types, enumLiterals = types.stream()
	        			.map(r -> (Scalar)r)
	        			.flatMap(s -> OmlSearch.findEnumerationLiterals(s, scope).stream())
	        			.collect(Collectors.toSet()));
        	}
        	return enumLiterals;
    	}
    }
    	
    /**
     * Constructor
     */
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
    	Cache cache = (Cache) context.get(CACHE);
    	if (cache == null) {
    		context.put(CACHE, new Cache(OmlRead.getImportScope(element.getOntology())));
    	}
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
	boolean validateOntologyHasUnusedImports(Ontology object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	boolean validateOntologyHasDuplicateImports(Ontology object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	boolean validateOntologyHasSelfImports(Ontology object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	boolean validateOntologyIri(Ontology object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean returnValue = true;
    	var iri = object.getIri();
    	var uri = object.eResource().getURI();
    	if (!OmlRead.isResolvedUri(uri) || !uri.equals(OmlRead.getResolvedUri(object.eResource(), iri))) {
            report(Diagnostic.ERROR, diagnostics, object,
                object.eClass().getName()+" iri '"+iri+"' does not resolve to '"+uri+"' using the catalog", 
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
    boolean validateImportURI(Import object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
    	} else if (object.getKind() == ImportKind.USAGE) {
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
    	} else if (object.getKind() == ImportKind.INCLUSION) {
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
     * Checks if the domain of a restricted property is the same as or a super type of the restricting entity
     * 
     * @param object The property restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validatePropertyRestrictionAxiomDomain(PropertyRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Cache cache = (Cache) context.get(CACHE);
    	final Entity restrictingDomain = object.getRestrictingDomain();
        final SemanticProperty property = object.getProperty();
        final Set<Entity> domainTypes = (property!=null) ? OmlSearch.findAllDomains(property, cache.scope) : Collections.emptySet();
        if (restrictingDomain != null && !domainTypes.isEmpty()) {
	        final Collection<Term> allSuperTerms = OmlSearch.findAllSuperTerms(restrictingDomain, true, cache.scope);
	        allSuperTerms.retainAll(domainTypes);
	        if (allSuperTerms.isEmpty()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Property "+object.getProperty().getAbbreviatedIri()+" has no domain that is the same as or a super type of "+restrictingDomain.getAbbreviatedIri(), 
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
    boolean validatePropertyRangeRestrictionAxiomRange(PropertyRangeRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Cache cache = (Cache) context.get(CACHE);
        final Type restrictedRange = object.getRange();
        final SemanticProperty property = object.getProperty();
        final Set<Type> rangeTypes = (property!=null) ? OmlSearch.findAllRanges(property, cache.scope) : Collections.emptySet();
        if (!rangeTypes.isEmpty() && restrictedRange != null && !restrictedRange.getAbbreviatedIri().equals(OWL_NOTHING)) {
	        final Collection<Term> allSuperTerms = OmlSearch.findAllSuperTerms(restrictedRange, true, cache.scope);
	        allSuperTerms.retainAll(rangeTypes);
	        if (allSuperTerms.isEmpty()) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "Type "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of the range of "+property.getAbbreviatedIri(), 
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
    boolean validatePropertyCardinalityRestrictionAxiomRange(PropertyCardinalityRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Cache cache = (Cache) context.get(CACHE);
        final Type restrictedRange = object.getRange();
        final SemanticProperty property = object.getProperty();
        final Set<Type> rangeTypes = (property!=null) ? OmlSearch.findAllRanges(property, cache.scope) : Collections.emptySet();
        if (!rangeTypes.isEmpty() && restrictedRange != null && !restrictedRange.getAbbreviatedIri().equals(OWL_NOTHING)) {
	        final Collection<Term> allSuperTerms = OmlSearch.findAllSuperTerms(restrictedRange, true, cache.scope);
	        allSuperTerms.retainAll(rangeTypes);
	        if (allSuperTerms.isEmpty()) {
                return report(Diagnostic.WARNING, diagnostics, object,
                    "Type "+restrictedRange.getAbbreviatedIri()+" is not the same as or a sub type of the range of "+property.getAbbreviatedIri(), 
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
    boolean validatePropertyValueRestrictionAxiomValue(PropertyValueRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Cache cache = (Cache) context.get(CACHE);
        final SemanticProperty property = object.getProperty();
        if (property instanceof ScalarProperty) {
        	if (object.getLiteralValue() == null) {
	            return report(Diagnostic.WARNING, diagnostics, object,
	                "A literal is expected as the restricted value of property "+property.getAbbreviatedIri(), 
	                OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
        	} else if (!OmlSearch.findAllRanges(property, cache.scope).stream().allMatch(t -> OmlSearch.findIsKindOf(object.getLiteralValue(), (Scalar)t, cache.scope))) {
	            return report(Diagnostic.WARNING, diagnostics, object,
		                "The literal is not in the range of scalar property "+property.getAbbreviatedIri(), 
		                OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__LITERAL_VALUE);
        	}
        } else if (property instanceof Relation) {
        	if (object.getReferencedValue() != null) {
        		if (!OmlSearch.findAllRanges(property, cache.scope).stream().allMatch(t -> OmlSearch.findIsKindOf(object.getReferencedValue(), (Entity)t, cache.scope))) {
		            return report(Diagnostic.WARNING, diagnostics, object,
			                "The instance is not in the range of relation "+property.getAbbreviatedIri(), 
			                OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE);
        		}
        	} else if (object.getContainedValue() != null) {
        		var instance = (AnonymousRelationInstance) object.getContainedValue();
        		if (!OmlSearch.findAllRanges(property, cache.scope).stream().allMatch(t -> OmlSearch.findIsKindOf(instance.getTarget(), (Entity)t, cache.scope))) {
    	            return report(Diagnostic.WARNING, diagnostics, object,
    		                "The instance is not in the range of relation "+property.getAbbreviatedIri(), 
    		                OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__CONTAINED_VALUE);
            	}        		
        	} else {
	            return report(Diagnostic.WARNING, diagnostics, object,
		                "A named instance IRI is expected as the restricted value of relation "+property.getAbbreviatedIri(), 
		                OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
        	}
        }
        return true;
    }

    // PropertyCardinalityRestrictionAxiom

    /**
     * Checks if the property of a property self restriction is a relation
     * 
     * @param object The property self restriction to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validatePropertySelfRestrictionAxiomProperty(PropertySelfRestrictionAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final SemanticProperty property = object.getProperty();
        if (!(property instanceof Relation)) {
            return report(Diagnostic.WARNING, diagnostics, object,
                "Property "+property.getAbbreviatedIri()+" cannot be used in a self restriction (only relations are allowed)", 
                OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY);
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
    boolean validateSpecializationAxiomSpecializedTermKind(SpecializationAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	        	(superTerm instanceof Relation && subTerm instanceof Relation) ||	
	            (superEClass == subEClass))) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "Term "+superTerm.getAbbreviatedIri()+" cannot be specialized by "+subTerm.getAbbreviatedIri()+"", 
	                OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM);
	        }
        }
        return true;
    }

    // EntityEquivalenceAxiom
    
    /**
     * Checks if a entity equivalence axiom is not between compatible entity kinds
     * 
     * @param object The entity equivalence axiom to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateEntityEquivalenceAxiom(EntityEquivalenceAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final List<Entity> superEntities = object.getSuperEntities();
        final Entity subEntity = object.getSubEntity();
        if (superEntities.contains(subEntity)) {
            return report(Diagnostic.WARNING, diagnostics, object,
	                "Entity "+subEntity.getAbbreviatedIri()+" specializes itself", 
	                OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES);
        } 
        if (superEntities.size() == 1) {
	        if (!superEntities.get(0).eIsProxy()) {
		        if (!(superEntities.get(0).eClass() == subEntity.eClass())) {
		            return report(Diagnostic.ERROR, diagnostics, object,
		                "Entity "+superEntities.get(0).getAbbreviatedIri()+" cannot be specialized by "+subEntity.getAbbreviatedIri()+"", 
		                OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES);
		        }
	        }
        } else {
	        for(Entity superEntity : superEntities) {
		        if (!superEntity.eIsProxy()) {
			        if (!(superEntity.eClass() == subEntity.eClass() ||
			        		subEntity instanceof Entity && superEntity instanceof Aspect)) {
			            return report(Diagnostic.ERROR, diagnostics, object,
			                "Entity "+superEntity.getAbbreviatedIri()+" cannot be specialized by "+subEntity.getAbbreviatedIri()+"", 
			                OmlPackage.Literals.ENTITY_EQUIVALENCE_AXIOM__SUPER_ENTITIES);
			        }
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
    boolean validatePropertyEquivalenceAxiom(PropertyEquivalenceAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	        if (!((subProperty instanceof Relation && superProperty instanceof Relation) || (superEClass == subEClass))) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                "Property "+superProperty.getAbbreviatedIri()+" cannot be specialized by "+subProperty.getAbbreviatedIri()+"", 
	                OmlPackage.Literals.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY);
	        }
        }
        return true;
    }

    // Scalar
    
    /**
     * Checks scalar supertypes
     * 
     * @param object The scalar to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateScalarSupertypes(Scalar object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean isStandardType = OmlRead.isStandardScalar(object);
    	boolean hasSpecializations = !object.getOwnedSpecializations().isEmpty();
    	if (!isStandardType && hasSpecializations) {
            return report(Diagnostic.ERROR, diagnostics, object,
            	"Non-standard Scalar "+object.getAbbreviatedIri()+" cannot have specializations", 
	            OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS);
        }
    	boolean hasAllStandardSupers = OmlRead.getSpecializationSuperTerms(object).stream()
			.filter(i -> i instanceof Scalar)
			.allMatch(i -> OmlRead.isStandardScalar((Scalar)i));
    	if (!hasAllStandardSupers) {
            return report(Diagnostic.ERROR, diagnostics, object,
            	"Standard scalar "+object.getAbbreviatedIri()+" can only specialize standard scalars", 
	            OmlPackage.Literals.SPECIALIZABLE_TERM__OWNED_SPECIALIZATIONS);
        }
        return true;
    }

    /**
     * Checks enumerated scalars
     * 
     * @param object The scalar to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateScalarEnumeration(Scalar object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Cache cache = (Cache) context.get(CACHE);
		if (object.getOwnedEnumeration() != null) {
			for (Term superTerm : OmlRead.getSuperTerms(object)) {
				Scalar superScalar = (Scalar) superTerm;
				for (Literal literal : object.getOwnedEnumeration().getLiterals()) {
		        	if (!OmlSearch.findIsKindOf(literal, superScalar, cache.scope)) {
		                return report(Diagnostic.ERROR, diagnostics, object,
		                	literal.getLexicalValue()+" is not a literal of scalar "+superScalar.getAbbreviatedIri(), 
		    	            OmlPackage.Literals.SCALAR__OWNED_ENUMERATION);
		        	}
				}
			}
        	
        }
        return true;
    }

    // Scalar Equivalence Axiom

    /**
     * Checks scalar equivalence axioms
     * 
     * @param object The scalar to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateScalarEquivalenceAxioms(ScalarEquivalenceAxiom object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean isStandardSuper = OmlRead.isStandardScalar(object.getSuperScalar());
		int facets = OmlRead.getNumberOfFacets(object);
		if (facets > 0 && !isStandardSuper) {
            return report(Diagnostic.ERROR, diagnostics, object,
            	"Facets can only restrict standard super scalars", 
	            OmlPackage.Literals.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR);
        }
        return true;
    }

    // Entity Predicate

    /**
     * Checks if a type predicate references an invalid type in a rule's consequent
     * 
     * @param object The type predicate to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateTypePredicateAsConsequent(TypePredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getConsequentRule() != null) {
	       if (object.getType() instanceof Scalar) {
	            return report(Diagnostic.ERROR, diagnostics, object,
	                    "Scalar "+object.getType().getAbbreviatedIri()+" cannot be used as a consequent predicate", 
	                    OmlPackage.Literals.TYPE_PREDICATE__TYPE);
	        }
        }
        return true;
    }

    // Argument

    /**
     * Checks if an argument is well formed
     * 
     * @param object The argument to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validatePropertyPredicateArg2(Argument object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
    boolean validateTypePredicate(TypePredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
    boolean validatePropertyPredicate(PropertyPredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
    boolean validatePropertyPredicate(RelationEntityPredicate object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
    boolean validateQuotedLiteral(QuotedLiteral object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
     * Checks if the assertion's subject is already in the domain of the assertion's property
     * 
     * @param object The property value assertion to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validatePropertyValueRestrictionSubject(PropertyValueAssertion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Cache cache = (Cache) context.get(CACHE);
        final SemanticProperty property = object.getProperty();
        final Instance theSubject = object.getSubject();
        
        final Set<Entity> domains = cache.getDomains(property);
        
        final Set<Entity> allTypes = cache.getAllTypes(theSubject);
        
        if (!domains.stream().allMatch(d -> allTypes.contains(d))) {
        	return report(Diagnostic.WARNING, diagnostics, object,
	            "The subject of the assertion is not already in the domain of "+property.getAbbreviatedIri(),
                OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY);
        }
        return true;
    }

    /**
     * Checks if the assertion's object is already in the range of the assertion's property
     * 
     * @param object The property value assertion to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validatePropertyValueRestrictionObject(PropertyValueAssertion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final Cache cache = (Cache) context.get(CACHE);
        final SemanticProperty property = object.getProperty();
        
        final Set<Type> ranges = cache.getRanges(property);

        for (Element theObject : object.getObject()) {
        
	        // if the range has an enumerated scalar, check if the object is one of the literals
	        if (property instanceof ScalarProperty) {
	        	final var enumLiterals = cache.getEnumLiterals(ranges);
	        	if (!enumLiterals.isEmpty()) {
	        		if (enumLiterals.stream().anyMatch(l -> OmlRead.isEqual(l, (Literal)theObject))) {
	        			return true;
	        		}
	        	}
	        }
	
	        // check if the object's type is asserted to be in the property's ranges
	        if (theObject instanceof NamedInstance) {
	        	NamedInstance instance = ((NamedInstance)theObject);
	            final Set<Entity> allTypes = cache.getAllTypes(instance);
	            if (!ranges.stream().allMatch(d -> allTypes.contains(d))) {
	            	return report(Diagnostic.WARNING, diagnostics, object,
	            		instance.getAbbreviatedIri()+" is not asserted to be in the range of "+property.getAbbreviatedIri(),
	                    OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUES);
	            }
	        } else if (theObject instanceof AnonymousInstance) {
	            final Set<Entity> allTypes = cache.getAllTypes((Instance)theObject);
	            if (!ranges.stream().allMatch(d -> allTypes.contains(d))) {
	            	return report(Diagnostic.WARNING, diagnostics, object,
	    	            "The object of the assertion is not asserted to be in the range of "+property.getAbbreviatedIri(),
	                    OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__CONTAINED_VALUES);
	            }
	        } else {
	        	Literal literal = (Literal) theObject;
	            final Set<Scalar> allTypes = cache.getAllTypes(literal);
	            if (!ranges.stream().allMatch(d -> allTypes.contains(d))) {
	            	return report(Diagnostic.WARNING, diagnostics, object,
	            		literal.getLexicalValue()+" is not asserted to be in the range of "+property.getAbbreviatedIri(),
	                    OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__LITERAL_VALUES);
	            }
	        }
        }
        
        return false;
    }

    /**
     * Checks that the type assertion is asserted by the proper kind for the instance
     * 
     * @param object The type assertion to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateTypeRestriction(TypeAssertion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        final var instance = object.getSubject();
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
    boolean validateMemberCardinalities(Member object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
     * Checks that a reverse relation is not specified on a ref to relation base
     * 
     * @param object The reverse relation base to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateReverseRelation(ReverseRelation object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	if (object.getRelationBase().isRef()) {
        	return report(Diagnostic.ERROR, diagnostics, object,
	            "Cannot name a reverse relation on a ref to "+object.getRelationBase().getAbbreviatedIri(),
                OmlPackage.Literals.MEMBER__NAME);
        }
        return true;
    }

    /**
     * Checks that a forward relation is not specified on a ref to relation entity
     * 
     * @param object The forward relation to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateForwardRelation(ForwardRelation object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	if (object.getRelationEntity().isRef()) {
        	return report(Diagnostic.ERROR, diagnostics, object,
	            "Cannot name a forward relation on a ref to "+object.getRelationEntity().getAbbreviatedIri(),
                OmlPackage.Literals.MEMBER__NAME);
        }
        return true;
    }

    /**
     * Checks that a relation base has correct feature cardinalities
     * 
     * @param object The relation base to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateRelationEntityCardinalities(RelationEntity object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!object.isRef() && object.getForwardRelation() == null) {
        	return report(Diagnostic.ERROR, diagnostics, object,
	            "Must name a forward relation on "+object.getAbbreviatedIri(),
                OmlPackage.Literals.RELATION_ENTITY__FORWARD_RELATION);
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
    boolean validateRuleCardinalities(Rule object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
    boolean validateRelationInstanceCardinalities(RelationInstance object, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

    /**
     * Checks if the anonymous concept instance has a type
     * @return True if the member is deprecated; False otherwise
     */
    boolean validateAnonymousConceptInstanceType(AnonymousConceptInstance object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getEntity() == null) {
        	return report(Diagnostic.ERROR, diagnostics, object,
                "Anonymous concept instance needs to specify a type",
                OmlPackage.Literals.ANONYMOUS_CONCEPT_INSTANCE__TYPE);
        }
        return true;
    }

    /**
     * Checks that a property value assertion with an anonymous relation instance as a subject has a valid property
     * 
     * @param object The property value assertion to check
     * @param diagnostics The validation diagnostics
     * @param context The object-to-object context map
     * @return True if the rules is satisfied; False otherwise
     */
    boolean validateAnonymousRelationInstancePredicate(PropertyValueAssertion object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (object.getValue() instanceof AnonymousRelationInstance) {
        	if (!(object.getProperty() instanceof ForwardRelation || object.getProperty() instanceof ReverseRelation)) {
	        	return report(Diagnostic.ERROR, diagnostics, object,
	                "Property "+object.getProperty().getAbbreviatedIri()+" is not a forwrd nor a reverse relation",
	                OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY);
        	}
        }
        return true;
    }

    // Member
    
    /**
     * Checks if the member is deprecated
     * @return True if the member is deprecated; False otherwise
     */
    boolean validateDeprecatedReference(Element object, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	var result = true;
		final var deprecatedProperty = (AnnotationProperty) OmlRead.getMemberByIri(object.eResource().getResourceSet(), "http://www.w3.org/2002/07/owl#deprecated");
		if (deprecatedProperty != null) {
	    	final var cache = (Cache) context.get(CACHE);
			for (var eRef : object.eClass().getEAllReferences()) {
				if (!eRef.isContainment() && !eRef.isContainer() && OmlPackage.Literals.MEMBER.isSuperTypeOf(eRef.getEReferenceType())) {
					List<Member> members = getValues(object, eRef);
					for (var member : members) {
						if (OmlSearch.findIsAnnotatedBy(member, deprecatedProperty, cache.scope)) {
							report(Diagnostic.WARNING, diagnostics, object,
									"Member "+member.getAbbreviatedIri()+" is deprecated", eRef);
						}
					}
				}
			}
		}
		return result;
    }

    @SuppressWarnings("unchecked")
	private <T> List<T> getValues(EObject eObj, EReference eRef) {
    	if (eRef.isMany()) {
    		return (List<T>) eObj.eGet(eRef);
    	} else if (eObj.eGet(eRef) != null) {
    		return Collections.singletonList((T)eObj.eGet(eRef));
    	} else {
    		return Collections.emptyList();
    	}
    }

}