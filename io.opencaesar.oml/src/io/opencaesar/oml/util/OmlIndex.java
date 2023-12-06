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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.Argument;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.BuiltIn;
import io.opencaesar.oml.BuiltInPredicate;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.ClassifierEquivalenceAxiom;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.InstanceEnumerationAxiom;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
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
import io.opencaesar.oml.ScalarEquivalenceAxiom;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.Term;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.UnreifiedRelation;

/**
 * The <b>Index</b> API for the model. It allows looking up cross references of OML objects in the resource set by using two lookup mechanisms:
 * 
 * 1) Fast: looking up cross references in a cache if a {@link ECrossReferenceAdapter} is installed in the resource set
 * 2) Slow: iterating over the content of a resource set to look for cross referencers 
 *  
 * @author elaasar
 */
public class OmlIndex {
    
    /*
     * Looks up cross references to the given object in the given adapter within the given resources scope
     * 
     * This is the FAST METHOD
     *  
     * @param object The object to search for cross refs to
     * @param eReference The eReference to filter the cross refs by
     * @param adapter The adapter that caches cross refs to the object
     * @param scope The scope of the search (can be null)
     * @return A set of Setting objects including the cross referencing objects and the features they reference with
     */
    private static Collection<Setting> lookupNonNavigableInverseReferences(EObject object, EReference eReference, ECrossReferenceAdapter adapter, Set<Resource> scope) {
    	Collection<Setting> settings = new LinkedList<>();
    	// look up cross referencers in the index
    	Collection<Setting> referencers = adapter.getNonNavigableInverseReferences(object);
        // filter on the used eReference
    	Iterator<Setting> i = referencers.iterator();
    	while (i.hasNext()) {
    		Setting setting = i.next();
    		if (eReference == null || eReference == setting.getEStructuralFeature()) {
    			settings.add(setting);
        	}
    	}
    	// filter on the relevant resources
        if (scope != null && !settings.isEmpty()) {
            i = settings.iterator();
        	while (i.hasNext()) {
        		Setting setting = i.next();
        		if (!scope.contains(setting.getEObject().eResource())) {
        			i.remove();
        		}
        	}
    	}
    	return settings;
    }

    /*
     * Searches the given scope for cross references to the given object (slow method)
     * 
     * This is the SLOW METHOD
     *  
     * @param object The object to search for cross refs to
     * @param eReference The eReference to filter the cross refs by
     * @param scope The scope of the search (can be null)
     * @return A set of Setting objects including the cross referencing objects and the features they reference with
     */
    private static Collection<Setting> searchForNonNavigableInverseReferences(EObject object, EReference eReference, Set<Resource> scope) {
    	Collection<Setting> settings = new ArrayList<Setting>();
    	// loop through relevant resources looking for cross references
    	if (scope != null) {
			for (Resource resource : scope) {
				settings.addAll(UsageCrossReferencer.find(object, resource));
			}
	    } else {
    		settings.addAll(UsageCrossReferencer.find(object, object.eResource().getResourceSet()));
    	}
    	// filter on the used eReference
        Iterator<Setting> i = settings.iterator();
    	while (i.hasNext()) {
    		Setting setting = i.next();
    		if (eReference != null && eReference != setting.getEStructuralFeature()) {
        		i.remove();
        	}
    	}
    	return settings;
    }
    
    /**
     * Finds all objects that cross reference a given object conforming to a given Java type and using a given EReference in the given scope
     * 
     * @param object The object to search for cross refs to
     * @param eReference The eReference to filter the cross refs by
     * @param type The Java type to filter the cross refs by
     * @param scope The scope of the search (can be null)
     * @return A set of objects that cross reference the given object based on the criteria
     */
    static <T extends EObject> Set<T> findInverseReferencers(EObject object, EReference eReference, Class<T> type, Set<Resource> scope) {
    	final ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
        Collection<Setting> settings;
        if (adapter != null) {
            // the fast method
            settings = lookupNonNavigableInverseReferences(object, eReference, adapter, scope);
        } else {
            // the slow method
            settings = searchForNonNavigableInverseReferences(object, eReference, scope);
        };
        // filter on the type
        final Set<T> referencers = new LinkedHashSet<>();
        for (Setting setting : settings) {
        	var referencer = setting.getEObject();
            if (type.isInstance(referencer)) {
                referencers.add(type.cast(referencer));
            }
        }
        return referencers;
    }
    
    // Annotation
    
    /**
     * Finds annotations referencing the given property
     * 
     * @param property The referenced property
     * @param scope The scope of the search (can be null)
     * @return A set of referencing annotations
     */
    public static Set<Annotation> findAnnotationsWithProperty(AnnotationProperty property, Set<Resource> scope) {
        return findInverseReferencers(property, OmlPackage.Literals.ANNOTATION__PROPERTY, Annotation.class, scope);
    }

    /**
     * Finds annotations referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing annotations
     * @deprecated As of 2.5.0. Use {{@link #findAnnotationsWithProperty(AnnotationProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Annotation> findAnnotationsWithProperty(AnnotationProperty property) {
        return findAnnotationsWithProperty(property, null);
    }

    /**
     * Finds annotations referencing the given referenced value
     * 
     * @param value The referenced value
     * @param scope The scope of the search (can be null)
     * @return A set of referencing annotations
     */
    public static Set<Annotation> findAnnotationsWithReferencedValue(Member value, Set<Resource> scope) {
        return findInverseReferencers(value, OmlPackage.Literals.ANNOTATION__REFERENCED_VALUE, Annotation.class, scope);
    }

    /**
     * Finds annotations referencing the given referenced value
     * 
     * @param value The referenced value
     * @return A set of referencing annotations
     * @deprecated As of 2.5.0. Use {{@link #findAnnotationsWithReferencedValue(Member, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Annotation> findAnnotationsWithReferencedValue(Member value) {
        return findAnnotationsWithReferencedValue(value, null);
    }

    // Enumeration Axiom

    /**
     * Finds instance enumeration axioms that references the given instance
     * 
     * @param instance The given instance
     * @param scope The scope of the search (can be null)
     * @return A set of instance enumeration axioms enumerating the given instance
     */
    public static Set<InstanceEnumerationAxiom> findInstanceEnumerationAxiomsWithInstance(ConceptInstance instance, Set<Resource> scope) {
        return findInverseReferencers(instance, OmlPackage.Literals.INSTANCE_ENUMERATION_AXIOM__INSTANCES, InstanceEnumerationAxiom.class, scope);
    }

    /**
     * Finds instance enumeration axioms that references the given instance
     * 
     * @param instance The given instance
     * @return A set of instance enumeration axioms enumerating the given instance
     * @deprecated As of 2.5.0. Use {{@link #findInstanceEnumerationAxiomsWithInstance(ConceptInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<InstanceEnumerationAxiom> findInstanceEnumerationAxiomsWithInstance(ConceptInstance instance) {
        return findInstanceEnumerationAxiomsWithInstance(instance, null);
    }

    // RelationBase
    
    /**
     * Finds relation bases referencing the given entity as source
     * 
     * @param source The referenced entity
     * @param scope The scope of the search (can be null)
     * @return A set of referencing relation bases
     */
    public static Set<RelationBase> findRelationBasesWithSource(Entity source, Set<Resource> scope) {
        return findInverseReferencers(source, OmlPackage.Literals.RELATION_BASE__SOURCES, RelationBase.class, scope);
    }
    
    /**
     * Finds relation bases referencing the given entity as source
     * 
     * @param source The referenced entity
     * @return A set of referencing relation bases
     * @deprecated As of 2.5.0. Use {{@link #findRelationBasesWithSource(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<RelationBase> findRelationBasesWithSource(Entity source) {
        return findRelationBasesWithSource(source, null);
    }

    /**
     * Finds relation bases referencing the given entity as target
     * 
     * @param target The referenced entity
     * @param scope The scope of the search (can be null)
     * @return A set of referencing relation bases
     */
    public static Set<RelationBase> findRelationBasesWithTarget(Entity target, Set<Resource> scope) {
        return findInverseReferencers(target, OmlPackage.Literals.RELATION_BASE__TARGETS, RelationBase.class, scope);
    }
    
    /**
     * Finds relation bases referencing the given entity as target
     * 
     * @param target The referenced entity
     * @return A set of referencing relation bases
     * @deprecated As of 2.5.0. Use {{@link #findRelationBasesWithTarget(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<RelationBase> findRelationBasesWithTarget(Entity target) {
        return findRelationBasesWithTarget(target, null);
    }

    // ScalarProperty
    
    /**
     * Finds scalar properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @param scope The scope of the search (can be null)
     * @return A set of referencing scalar properties
     */
    public static Set<ScalarProperty> findScalarPropertiesWithDomain(Classifier domain, Set<Resource> scope) {
        return findInverseReferencers(domain, OmlPackage.Literals.SCALAR_PROPERTY__DOMAINS, ScalarProperty.class, scope);
    }

    /**
     * Finds scalar properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @return A set of referencing scalar properties
     * @deprecated As of 2.5.0. Use {{@link #findScalarPropertiesWithDomain(Classifier, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<ScalarProperty> findScalarPropertiesWithDomain(Classifier domain) {
        return findScalarPropertiesWithDomain(domain, null);
    }

    /**
     * Finds scalar properties referencing the given scalar as range
     * 
     * @param range The referenced scalar
     * @param scope The scope of the search (can be null)
     * @return A set of referencing scalar properties
     */
    public static Set<ScalarProperty> findScalarPropertiesWithRange(Scalar range, Set<Resource> scope) {
        return findInverseReferencers(range, OmlPackage.Literals.SCALAR_PROPERTY__RANGES, ScalarProperty.class, scope);
    }
    
    /**
     * Finds scalar properties referencing the given scalar as range
     * 
     * @param range The referenced scalar
     * @return A set of referencing scalar properties
     * @deprecated As of 2.5.0. Use {{@link #findScalarPropertiesWithRange(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<ScalarProperty> findScalarPropertiesWithRange( Scalar range) {
        return findScalarPropertiesWithRange(range, null);
    }

    // StructuredProperty
    
    /**
     * Finds structured properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @param scope The scope of the search (can be null)
     * @return A set of referencing scalar properties
     */
    public static Set<StructuredProperty> findStructuredPropertiesWithDomain(Classifier domain, Set<Resource> scope) {
        return findInverseReferencers(domain, OmlPackage.Literals.STRUCTURED_PROPERTY__DOMAINS, StructuredProperty.class, scope);
    }

    /**
     * Finds structured properties referencing the given classifier as domain
     * 
     * @param domain The referenced classifier
     * @return A set of referencing scalar properties
     * @deprecated As of 2.5.0. Use {{@link #findStructuredPropertiesWithDomain(Classifier, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<StructuredProperty> findStructuredPropertiesWithDomain(Classifier domain) {
        return findStructuredPropertiesWithDomain(domain, null);
    }

    /**
     * Finds structured properties referencing the given structure as range
     * 
     * @param range The referenced structure
     * @param scope The scope of the search (can be null)
     * @return A set of referencing structured properties
     */
    public static Set<StructuredProperty> findStructuredPropertiesWithRange(Structure range, Set<Resource> scope) {
        return findInverseReferencers(range, OmlPackage.Literals.STRUCTURED_PROPERTY__RANGES, StructuredProperty.class, scope);
    }
    
    /**
     * Finds structured properties referencing the given structure as range
     * 
     * @param range The referenced structure
     * @return A set of referencing structured properties
     * @deprecated As of 2.5.0. Use {{@link #findStructuredPropertiesWithRange(Structure, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<StructuredProperty> findStructuredPropertiesWithRange(Structure range) {
        return findStructuredPropertiesWithRange(range, null);
    }

    // StructureInstance
    
    /**
     * Finds structure instances referencing the given structure as type
     * 
     * @param type The referenced structure
     * @param scope The scope of the search (can be null)
     * @return A set of referencing structure instances
     */
    public static Set<StructureInstance> findStructureInstancesWithType(Structure type, Set<Resource> scope) {
        return findInverseReferencers(type, OmlPackage.Literals.STRUCTURE_INSTANCE__TYPE, StructureInstance.class, scope);
    }
    
    /**
     * Finds structure instances referencing the given structure as type
     * 
     * @param type The referenced structure
     * @return A set of referencing structure instances
     * @deprecated As of 2.5.0. Use {{@link #findStructureInstancesWithType(Structure, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<StructureInstance> findStructureInstancesWithType(Structure type) {
        return findStructureInstancesWithType(type, null);
    }

    // RelationInstance
    
    /**
     * Finds relation instances referencing the given named instance as source
     * 
     * @param source The referenced named instance
     * @param scope The scope of the search (can be null)
     * @return A set of referencing relation instances
     */
    public static Set<RelationInstance> findRelationInstancesWithSource(NamedInstance source, Set<Resource> scope) {
        return findInverseReferencers(source, OmlPackage.Literals.RELATION_INSTANCE__SOURCES, RelationInstance.class, scope);
    }
    
    /**
     * Finds relation instances referencing the given named instance as source
     * 
     * @param source The referenced named instance
     * @return A set of referencing relation instances
     * @deprecated As of 2.5.0. Use {{@link #findRelationInstancesWithSource(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<RelationInstance> findRelationInstancesWithSource(NamedInstance source) {
        return findRelationInstancesWithSource(source, null);
    }

    /**
     * Finds relation instances referencing the given named instance as target
     * 
     * @param target The referenced named instance
     * @param scope The scope of the search (can be null)
     * @return A set of referencing relation instances
     */
    public static Set<RelationInstance> findRelationInstancesWithTarget(NamedInstance target, Set<Resource> scope) {
        return findInverseReferencers(target, OmlPackage.Literals.RELATION_INSTANCE__TARGETS, RelationInstance.class, scope);
    }
    
    /**
     * Finds relation instances referencing the given named instance as target
     * 
     * @param target The referenced named instance
     * @return A set of referencing relation instances
     * @deprecated As of 2.5.0. Use {{@link #findRelationInstancesWithTarget(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<RelationInstance> findRelationInstancesWithTarget(NamedInstance target) {
        return findRelationInstancesWithTarget(target, null);
    }

    // Aspect
    
    /**
     * Finds aspects referencing the given aspect
     * 
     * @param aspect The referenced aspect
     * @param scope The scope of the search (can be null)
     * @return A set of referencing aspects
     */
    public static Set<Aspect> findAspectsWithRef(Aspect aspect, Set<Resource> scope) {
        return findInverseReferencers(aspect, OmlPackage.Literals.ASPECT__REF, Aspect.class, scope);
    }
    
    /**
     * Finds aspects referencing the given aspect
     * 
     * @param aspect The referenced aspect
     * @return A set of referencing aspects
     * @deprecated As of 2.5.0. Use {{@link #findAspectsWithRef(Aspect, Set<Resource>)} instead
     */
    @Deprecated
   public static Set<Aspect> findAspectsWithRef(Aspect aspect) {
        return findAspectsWithRef(aspect, null);
    }

    // Concept
    
    /**
     * Finds concept referencing the given concept
     * 
     * @param concept The referenced concept
     * @param scope The scope of the search (can be null)
     * @return A set of referencing concepts
     */
    public static Set<Concept> findConceptsWithRef(Concept concept, Set<Resource> scope) {
        return findInverseReferencers(concept, OmlPackage.Literals.CONCEPT__REF, Concept.class, scope);
    }
    
    /**
     * Finds concept referencing the given concept
     * 
     * @param concept The referenced concept
     * @return A set of referencing concepts
     * @deprecated As of 2.5.0. Use {{@link #findConceptsWithRef(Concept, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Concept> findConceptsWithRef(Concept concept) {
        return findConceptsWithRef(concept, null);
    }

    // RelationEntity
    
    /**
     * Finds relation entity referencing the given relation entity
     * 
     * @param entity The referenced relation entity
     * @param scope The scope of the search (can be null)
     * @return A set of referencing relation entities
     */
    public static Set<RelationEntity> findRelationEntitiesWithRef(RelationEntity entity, Set<Resource> scope) {
        return findInverseReferencers(entity, OmlPackage.Literals.RELATION_ENTITY__REF, RelationEntity.class, scope);
    }
    
    /**
     * Finds relation entity referencing the given relation entity
     * 
     * @param entity The referenced relation entity
     * @return A set of referencing relation entities
     * @deprecated As of 2.5.0. Use {{@link #findRelationEntitiesWithRef(RelationEntity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<RelationEntity> findRelationEntitiesWithRef(RelationEntity entity) {
        return findRelationEntitiesWithRef(entity, null);
    }

    // Structure
    
    /**
     * Finds structure referencing the given structure
     * 
     * @param structure The referenced structure
     * @param scope The scope of the search (can be null)
     * @return A set of referencing structures
     */
    public static Set<Structure> findStructuresWithRef(Structure structure, Set<Resource> scope) {
        return findInverseReferencers(structure, OmlPackage.Literals.STRUCTURE__REF, Structure.class, scope);
    }
    
    /**
     * Finds structure referencing the given structure
     * 
     * @param structure The referenced structure
     * @return A set of referencing structures
     * @deprecated As of 2.5.0. Use {{@link #findStructuresWithRef(Structure, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Structure> findStructuresWithRef(Structure structure) {
        return findStructuresWithRef(structure, null);
    }

    // AnnotationProperty
    
    /**
     * Finds annotation property referencing the given annotation property
     * 
     * @param property The referenced annotation property
     * @param scope The scope of the search (can be null)
     * @return A set of referencing annotation properties
     */
    public static Set<AnnotationProperty> findAnnotationPropertiesWithRef(AnnotationProperty property, Set<Resource> scope) {
        return findInverseReferencers(property, OmlPackage.Literals.ANNOTATION_PROPERTY__REF, AnnotationProperty.class, scope);
    }
    
    /**
     * Finds annotation property referencing the given annotation property
     * 
     * @param property The referenced annotation property
     * @return A set of referencing annotation properties
     * @deprecated As of 2.5.0. Use {{@link #findAnnotationPropertiesWithRef(AnnotationProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<AnnotationProperty> findAnnotationPropertiesWithRef(AnnotationProperty property) {
        return findAnnotationPropertiesWithRef(property, null);
    }

    // ScalarProperty
    
    /**
     * Finds scalar property referencing the given scalar property
     * 
     * @param property The referenced scalar property
     * @param scope The scope of the search (can be null)
     * @return A set of referencing scalar properties
     */
    public static Set<ScalarProperty> findScalarPropertiesWithRef(ScalarProperty property, Set<Resource> scope) {
        return findInverseReferencers(property, OmlPackage.Literals.SCALAR_PROPERTY__REF, ScalarProperty.class, scope);
    }
    
    /**
     * Finds scalar property referencing the given scalar property
     * 
     * @param property The referenced scalar property
     * @return A set of referencing scalar properties
     * @deprecated As of 2.5.0. Use {{@link #findScalarPropertiesWithRef(ScalarProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<ScalarProperty> findScalarPropertiesWithRef(ScalarProperty property) {
        return findScalarPropertiesWithRef(property, null);
    }

    // StructuredProperty
    
    /**
     * Finds structured property referencing the given structured property
     * 
     * @param property The referenced structured property
     * @param scope The scope of the search (can be null)
     * @return A set of referencing structured properties
     */
    public static Set<StructuredProperty> findStructuredPropertiesWithRef(StructuredProperty property, Set<Resource> scope) {
        return findInverseReferencers(property, OmlPackage.Literals.STRUCTURED_PROPERTY__REF, StructuredProperty.class, scope);
    }
    
    /**
     * Finds structured property referencing the given structured property
     * 
     * @param property The referenced structured property
     * @return A set of referencing structured properties
     * @deprecated As of 2.5.0. Use {{@link #findStructuredPropertiesWithRef(StructuredProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<StructuredProperty> findStructuredPropertiesWithRef(StructuredProperty property) {
        return findStructuredPropertiesWithRef(property, null);
    }

    // Scalar
    
    /**
     * Finds scalar referencing the given scalar
     * 
     * @param scalar The referenced scalar
     * @param scope The scope of the search (can be null)
     * @return A set of referencing scalars
     */
    public static Set<Scalar> findScalarsWithRef(Scalar scalar, Set<Resource> scope) {
        return findInverseReferencers(scalar, OmlPackage.Literals.SCALAR__REF, Scalar.class, scope);
    }
    
    /**
     * Finds scalar referencing the given scalar
     * 
     * @param scalar The referenced scalar
     * @return A set of referencing scalars
     * @deprecated As of 2.5.0. Use {{@link #findScalarsWithRef(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Scalar> findScalarsWithRef(Scalar scalar) {
        return findScalarsWithRef(scalar, null);
    }

    // UnreifiedRelation
    
    /**
     * Finds unreified relations referencing the given relation
     * 
     * @param relation The referenced relation
     * @param scope The scope of the search (can be null)
     * @return A set of referencing relations
     */
    public static Set<UnreifiedRelation> findUnreifiedRelationsWithRef(Relation relation, Set<Resource> scope) {
        return findInverseReferencers(relation, OmlPackage.Literals.UNREIFIED_RELATION__REF, UnreifiedRelation.class, scope);
    }
    
    /**
     * Finds unreified relations referencing the given relation
     * 
     * @param relation The referenced relation
     * @return A set of referencing relations
     * @deprecated As of 2.5.0. Use {{@link #findUnreifiedRelationsWithRef(Relation, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<UnreifiedRelation> findUnreifiedRelationsWithRef(Relation relation) {
        return findUnreifiedRelationsWithRef(relation, null);
    }

    // Rule
    
    /**
     * Finds rule referencing the given rule
     * 
     * @param rule The referenced rule
     * @param scope The scope of the search (can be null)
     * @return A set of referencing rules
     */
    public static Set<Rule> findRulesWithRef(Rule rule, Set<Resource> scope) {
        return findInverseReferencers(rule, OmlPackage.Literals.RULE__REF, Rule.class, scope);
    }
    
    /**
     * Finds rule referencing the given rule
     * 
     * @param rule The referenced rule
     * @return A set of referencing rules
     * @deprecated As of 2.5.0. Use {{@link #findRulesWithRef(Rule, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Rule> findRulesWithRef(Rule rule) {
        return findRulesWithRef(rule, null);
    }

    // BuiltIn
    
    /**
     * Finds builtIn referencing the given builtIn
     * 
     * @param builtIn The referenced builtIn
     * @param scope The scope of the search (can be null)
     * @return A set of referencing builtIn
     */
    public static Set<BuiltIn> findBuiltInsWithRef(BuiltIn builtIn, Set<Resource> scope) {
        return findInverseReferencers(builtIn, OmlPackage.Literals.BUILT_IN__REF, BuiltIn.class, scope);
    }

    /**
     * Finds builtIn referencing the given builtIn
     * 
     * @param builtIn The referenced builtIn
     * @return A set of referencing builtIn
     * @deprecated As of 2.5.0. Use {{@link #findBuiltInsWithRef(BuiltIn, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<BuiltIn> findBuiltInsWithRef(BuiltIn builtIn) {
        return findBuiltInsWithRef(builtIn, null);
    }

    // ConceptInstance
    
    /**
     * Finds concept instance referencing the given concept instance
     * 
     * @param instance The referenced concept instance
     * @param scope The scope of the search (can be null)
     * @return A set of referencing concept instances
     */
    public static Set<ConceptInstance> findConceptInstancesWithRef(ConceptInstance instance, Set<Resource> scope) {
        return findInverseReferencers(instance, OmlPackage.Literals.CONCEPT_INSTANCE__REF, ConceptInstance.class, scope);
    }
    
    /**
     * Finds concept instance referencing the given concept instance
     * 
     * @param instance The referenced concept instance
     * @return A set of referencing concept instances
     * @deprecated As of 2.5.0. Use {{@link #findConceptInstancesWithRef(ConceptInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<ConceptInstance> findConceptInstancesWithRef(ConceptInstance instance) {
        return findConceptInstancesWithRef(instance, null);
    }

    // RelationInstance
    
    /**
     * Finds relation instance referencing the given relation instance
     * 
     * @param instance The referenced relation instance
     * @param scope The scope of the search (can be null)
     * @return A set of referencing relation instances
     */
    public static Set<RelationInstance> findRelationInstancesWithRef(RelationInstance instance, Set<Resource> scope) {
        return findInverseReferencers(instance, OmlPackage.Literals.RELATION_INSTANCE__REF, RelationInstance.class, scope); 
    }
    
    /**
     * Finds relation instance referencing the given relation instance
     * 
     * @param instance The referenced relation instance
     * @return A set of referencing relation instances
     * @deprecated As of 2.5.0. Use {{@link #findRelationInstancesWithRef(RelationInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<RelationInstance> findRelationInstancesWithRef(RelationInstance instance) {
        return findRelationInstancesWithRef(instance, null); 
    }

    // SpecializationAxiom
    
    /**
     * Finds specialization axioms referencing the given super term
     * 
     * @param term The referenced super term
     * @param scope The scope of the search (can be null)
     * @return A set of referencing specialization axioms
     */
    public static Set<SpecializationAxiom> findSpecializationAxiomsWithSuperTerm(Term term, Set<Resource> scope) {
        return findInverseReferencers(term, OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM, SpecializationAxiom.class, scope);
    }
    
    /**
     * Finds specialization axioms referencing the given super term
     * 
     * @param term The referenced super term
     * @return A set of referencing specialization axioms
     * @deprecated As of 2.5.0. Use {{@link #findSpecializationAxiomsWithSuperTerm(Term, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<SpecializationAxiom> findSpecializationAxiomsWithSuperTerm(Term term) {
        return findSpecializationAxiomsWithSuperTerm(term, null);
    }

    // ClassifierEquivalenceAxiom
    
    /**
     * Finds classifier equivalence axioms referencing the given classifier
     * 
     * @param classifier The referenced classifier
     * @param scope The scope of the search (can be null)
     * @return A set of referencing classifier equivalence axioms
     */
    public static Set<ClassifierEquivalenceAxiom> findClassifierEquivalenceAxiomsWithSuperClassifier(Classifier classifier, Set<Resource> scope) {
        return findInverseReferencers(classifier, OmlPackage.Literals.CLASSIFIER_EQUIVALENCE_AXIOM__SUPER_CLASSIFIERS, ClassifierEquivalenceAxiom.class, scope);
    }

    /**
     * Finds classifier equivalence axioms referencing the given classifier
     * 
     * @param classifier The referenced classifier
     * @return A set of referencing classifier equivalence axioms
     * @deprecated As of 2.5.0. Use {{@link #findClassifierEquivalenceAxiomsWithSuperClassifier(Classifier, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<ClassifierEquivalenceAxiom> findClassifierEquivalenceAxiomsWithSuperClassifier(Classifier classifier) {
        return findClassifierEquivalenceAxiomsWithSuperClassifier(classifier, null);
    }

    // ScalarEquivalenceAxiom
    
    /**
     * Finds scalars equivalence axioms referencing the given scalar
     * 
     * @param scalar The referenced scalar
     * @param scope The scope of the search (can be null)
     * @return A set of referencing scalar equivalence axioms
     */
    public static Set<ScalarEquivalenceAxiom> findScalarEquivalenceAxiomsWithSuperScalar(Scalar scalar, Set<Resource> scope) {
        return findInverseReferencers(scalar, OmlPackage.Literals.SCALAR_EQUIVALENCE_AXIOM__SUPER_SCALAR, ScalarEquivalenceAxiom.class, scope);
    }

    /**
     * Finds scalars equivalence axioms referencing the given scalar
     * 
     * @param scalar The referenced scalar
     * @return A set of referencing scalar equivalence axioms
     * @deprecated As of 2.5.0. Use {{@link #findScalarEquivalenceAxiomsWithSuperScalar(Scalar, Set<Resource>)} instead
     */
    @Deprecated
   public static Set<ScalarEquivalenceAxiom> findScalarEquivalenceAxiomsWithSuperScalar(Scalar scalar) {
        return findScalarEquivalenceAxiomsWithSuperScalar(scalar, null);
    }

    // PropertyEquivalenceAxiom
    
    /**
     * Finds property equivalence axioms referencing the given property
     * 
     * @param property The referenced property
     * @param scope The scope of the search (can be null)
     * @return A set of referencing property equivalence axioms
     */
    public static Set<PropertyEquivalenceAxiom> findPropertyEquivalenceAxiomsWithSuperProperty(Property property, Set<Resource> scope) {
        return findInverseReferencers(property, OmlPackage.Literals.PROPERTY_EQUIVALENCE_AXIOM__SUPER_PROPERTY, PropertyEquivalenceAxiom.class, scope);
    }

    /**
     * Finds property equivalence axioms referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing property equivalence axioms
     * @deprecated As of 2.5.0. Use {{@link #findPropertyEquivalenceAxiomsWithSuperProperty(Property, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyEquivalenceAxiom> findPropertyEquivalenceAxiomsWithSuperProperty(Property property) {
        return findPropertyEquivalenceAxiomsWithSuperProperty(property, null);
    }

    // PropertyRestrictionAxiom
    
    /**
     * Finds property restriction axioms referencing the given property
     * 
     * @param property The referenced property
     * @param scope The scope of the search (can be null)
     * @return A set of referencing property restriction axioms
     */
    public static Set<PropertyRestrictionAxiom> findPropertyRestrictionAxiomsWithProperty(Property property, Set<Resource> scope) {
        return findInverseReferencers(property, OmlPackage.Literals.PROPERTY_RESTRICTION_AXIOM__PROPERTY, PropertyRestrictionAxiom.class, scope);
    }
    
    /**
     * Finds property restriction axioms referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing property restriction axioms
     * @deprecated As of 2.5.0. Use {{@link #findPropertyRestrictionAxiomsWithProperty(Property, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyRestrictionAxiom> findPropertyRestrictionAxiomsWithProperty(Property property) {
        return findPropertyRestrictionAxiomsWithProperty(property, null);
    }

    // PropertyRangeRestrictionAxiom
    
    /**
     * Finds property range restriction axioms referencing the given range
     * 
     * @param range The given range
     * @param scope The scope of the search (can be null)
     * @return A set of referencing property range restriction axioms
     */
    public static Set<PropertyRangeRestrictionAxiom> findPropertyRangeRestrictionAxiomsWithRange(Type range, Set<Resource> scope) {
        return findInverseReferencers(range, OmlPackage.Literals.PROPERTY_RANGE_RESTRICTION_AXIOM__RANGE, PropertyRangeRestrictionAxiom.class, scope);
    }
    
    /**
     * Finds property range restriction axioms referencing the given range
     * 
     * @param range The given range
     * @return A set of referencing property range restriction axioms
     * @deprecated As of 2.5.0. Use {{@link #findPropertyRangeRestrictionAxiomsWithRange(Type, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyRangeRestrictionAxiom> findPropertyRangeRestrictionAxiomsWithRange(Type range) {
        return findPropertyRangeRestrictionAxiomsWithRange(range, null);
    }

    // PropertyCardinalityRestrictionAxiom
    
    /**
     * Finds property cardinality restriction axioms referencing the given range
     * 
     * @param range The given range
     * @param scope The scope of the search (can be null)
     * @return A set of referencing property cardinality restriction axioms
     */
    public static Set<PropertyCardinalityRestrictionAxiom> findPropertyCardinalityRestrictionAxiomsWithRange(Type range, Set<Resource> scope) {
        return findInverseReferencers(range, OmlPackage.Literals.PROPERTY_CARDINALITY_RESTRICTION_AXIOM__RANGE, PropertyCardinalityRestrictionAxiom.class, scope);
    }
    
    /**
     * Finds property cardinality restriction axioms referencing the given range
     * 
     * @param range The given range
     * @return A set of referencing property cardinality restriction axioms
     * @deprecated As of 2.5.0. Use {{@link #findPropertyCardinalityRestrictionAxiomsWithRange(Type, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyCardinalityRestrictionAxiom> findPropertyCardinalityRestrictionAxiomsWithRange(Type range) {
        return findPropertyCardinalityRestrictionAxiomsWithRange(range, null);
    }

    // PropertyValueRestrictionAxiom
    
    /**
     * Finds property value restriction axioms referencing the given referenced value
     * 
     * @param value The given referenced value
     * @param scope The scope of the search (can be null)
     * @return A set of referencing property value restriction axioms
     */
    public static Set<PropertyValueRestrictionAxiom> findPropertyValueRestrictionAxiomsWithReferencedValue(NamedInstance value, Set<Resource> scope) {
        return findInverseReferencers(value, OmlPackage.Literals.PROPERTY_VALUE_RESTRICTION_AXIOM__REFERENCED_VALUE, PropertyValueRestrictionAxiom.class, scope);
    }
    
    /**
     * Finds property value restriction axioms referencing the given referenced value
     * 
     * @param value The given referenced value
     * @return A set of referencing property value restriction axioms
     * @deprecated As of 2.5.0. Use {{@link #findPropertyValueRestrictionAxiomsWithReferencedValue(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyValueRestrictionAxiom> findPropertyValueRestrictionAxiomsWithReferencedValue(NamedInstance value) {
        return findPropertyValueRestrictionAxiomsWithReferencedValue(value, null);
    }

    // KeyAxiom
    
    /**
     * Finds key axioms referencing the given property
     * 
     * @param property The referenced property
     * @param scope The scope of the search (can be null)
     * @return A set of referencing key axioms
     */
    public static Set<KeyAxiom> findKeyAxiomsWithProperty(Property property, Set<Resource> scope) {
        return findInverseReferencers(property, OmlPackage.Literals.KEY_AXIOM__PROPERTIES, KeyAxiom.class, scope);
    }
    
    /**
     * Finds key axioms referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing key axioms
     * @deprecated As of 2.5.0. Use {{@link #findKeyAxiomsWithProperty(Property, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<KeyAxiom> findKeyAxiomsWithProperty(Property property) {
        return findKeyAxiomsWithProperty(property, null);
    }

    // TypeAssertion
    
    /**
     * Finds type assertions referencing the given type
     * 
     * @param type The referenced type
     * @param scope The scope of the search (can be null)
     * @return A set of referencing type assertions
     */
    public static Set<TypeAssertion> findTypeAssertionsWithType(Entity type, Set<Resource> scope) {
        return findInverseReferencers(type, OmlPackage.Literals.TYPE_ASSERTION__TYPE, TypeAssertion.class, scope);
    }
        
    /**
     * Finds type assertions referencing the given type
     * 
     * @param type The referenced type
     * @return A set of referencing type assertions
     * @deprecated As of 2.5.0. Use {{@link #findTypeAssertionsWithType(Entity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<TypeAssertion> findTypeAssertionsWithType(Entity type) {
        return findTypeAssertionsWithType(type, null);
    }

    // PropertyValueAssertion
    
    /**
     * Finds property value assertions referencing the given property
     * 
     * @param property The referenced property
     * @param scope The scope of the search (can be null)
     * @return A set of referencing property value assertions
     */
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithProperty(SemanticProperty property, Set<Resource> scope) {
        return findInverseReferencers(property, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__PROPERTY, PropertyValueAssertion.class, scope);
    }
    
    /**
     * Finds property value assertions referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing property value assertions
     * @deprecated As of 2.5.0. Use {{@link #findPropertyValueAssertionsWithProperty(SemanticProperty, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithProperty(SemanticProperty property) {
        return findPropertyValueAssertionsWithProperty(property, null);
    }

    /**
     * Finds property value assertions referencing the given referenced value
     * 
     * @param value The referenced value
     * @param scope The scope of the search (can be null)
     * @return A set of referencing property value assertions
     */
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithReferencedValue(NamedInstance value, Set<Resource> scope) {
        return findInverseReferencers(value, OmlPackage.Literals.PROPERTY_VALUE_ASSERTION__REFERENCED_VALUE, PropertyValueAssertion.class, scope);
    }
    
    /**
     * Finds property value assertions referencing the given referenced value
     * 
     * @param value The referenced value
     * @return A set of referencing property value assertions
     * @deprecated As of 2.5.0. Use {{@link #findPropertyValueAssertionsWithReferencedValue(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyValueAssertion> findPropertyValueAssertionsWithReferencedValue(NamedInstance value) {
        return findPropertyValueAssertionsWithReferencedValue(value, null);
    }

    // TypePredicate
    
    /**
     * Finds type predicates referencing the given type
     * 
     * @param type The referenced type
     * @param scope The scope of the search (can be null)
     * @return A set of referencing type predicates
     */
    public static Set<TypePredicate> findTypePredicatesWithType(Type type, Set<Resource> scope) {
        return findInverseReferencers(type, OmlPackage.Literals.TYPE_PREDICATE__TYPE, TypePredicate.class, scope);
    }
    
    /**
     * Finds type predicates referencing the given type
     * 
     * @param type The referenced type
     * @return A set of referencing type predicates
     * @deprecated As of 2.5.0. Use {{@link #findTypePredicatesWithType(Type, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<TypePredicate> findTypePredicatesWithType(Type type) {
        return findTypePredicatesWithType(type, null);
    }

    // RelationEntityPredicate
    
    /**
     * Finds relation entity predicates referencing the given relation entity
     * 
     * @param type The referenced relation entity
     * @param scope The scope of the search (can be null)
     * @return A set of referencing relation entity predicates
     */
    public static Set<RelationEntityPredicate> findRelationEntityPredicatesWithType(RelationEntity type, Set<Resource> scope) {
        return findInverseReferencers(type, OmlPackage.Literals.RELATION_ENTITY_PREDICATE__TYPE, RelationEntityPredicate.class, scope);
    }
    
    /**
     * Finds relation entity predicates referencing the given relation entity
     * 
     * @param type The referenced relation entity
     * @return A set of referencing relation entity predicates
     * @deprecated As of 2.5.0. Use {{@link #findRelationEntityPredicatesWithType(RelationEntity, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<RelationEntityPredicate> findRelationEntityPredicatesWithType(RelationEntity type) {
        return findRelationEntityPredicatesWithType(type, null);
    }

    // PropertyPredicate
    
    /**
     * Finds property predicates referencing the given property
     * 
     * @param property The referenced property
     * @param scope The scope of the search (can be null)
     * @return A set of referencing property predicates
     */
    public static Set<PropertyPredicate> findPropertyPredicatesWithProperty(Property property, Set<Resource> scope) {
        return findInverseReferencers(property, OmlPackage.Literals.PROPERTY_PREDICATE__PROPERTY, PropertyPredicate.class, scope);
    }
    
    /**
     * Finds property predicates referencing the given property
     * 
     * @param property The referenced property
     * @return A set of referencing property predicates
     * @deprecated As of 2.5.0. Use {{@link #findPropertyPredicatesWithProperty(Property, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<PropertyPredicate> findPropertyPredicatesWithProperty(Property property) {
        return findPropertyPredicatesWithProperty(property, null);
    }

    // BuiltInPredicate
    
    /**
     * Finds builtIn predicates referencing the given builtIn
     * 
     * @param builtIn The referenced builtIn
     * @param scope The scope of the search (can be null)
     * @return A set of referencing builtIn predicates
     */
    public static Set<BuiltInPredicate> findBuiltInPredicatesWithBuiltIn(BuiltIn builtIn, Set<Resource> scope) {
        return findInverseReferencers(builtIn, OmlPackage.Literals.BUILT_IN_PREDICATE__BUILT_IN, BuiltInPredicate.class, scope);
    }

    /**
     * Finds builtIn predicates referencing the given builtIn
     * 
     * @param builtIn The referenced builtIn
     * @return A set of referencing builtIn predicates
     * @deprecated As of 2.5.0. Use {{@link #findBuiltInPredicatesWithBuiltIn(BuiltIn, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<BuiltInPredicate> findBuiltInPredicatesWithBuiltIn(BuiltIn builtIn) {
        return findBuiltInPredicatesWithBuiltIn(builtIn, null);
    }

    // QuotedLiteral
    
    /**
     * Finds quoted literals referencing the given scalar as type
     * 
     * @param type The referenced scalar
     * @param scope The scope of the search (can be null)
     * @return A set of referencing quoted literals
     */
    public static Set<QuotedLiteral> findQuotedLiteralsWithType(Scalar type, Set<Resource> scope) {
        return findInverseReferencers(type, OmlPackage.Literals.QUOTED_LITERAL__TYPE, QuotedLiteral.class, scope);
    }
    
    /**
     * Finds quoted literals referencing the given scalar as type
     * 
     * @param type The referenced scalar
     * @return A set of referencing quoted literals
     * @deprecated As of 2.5.0. Use {{@link #findQuotedLiteralsWithType(Scalar, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<QuotedLiteral> findQuotedLiteralsWithType(Scalar type) {
        return findQuotedLiteralsWithType(type, null);
    }

    // Argument
    
    /**
     * Finds arguments referencing the given named instance
     * 
     * @param instance The referenced instance
     * @param scope The scope of the search (can be null)
     * @return A set of referencing arguments
     */
    public static Set<Argument> findArgumentsWithInstance(NamedInstance instance, Set<Resource> scope) {
        return findInverseReferencers(instance, OmlPackage.Literals.ARGUMENT__INSTANCE, Argument.class, scope);
    }

    /**
     * Finds arguments referencing the given named instance
     * 
     * @param instance The referenced instance
     * @return A set of referencing arguments
     * @deprecated As of 2.5.0. Use {{@link #findArgumentsWithInstance(NamedInstance, Set<Resource>)} instead
     */
    @Deprecated
    public static Set<Argument> findArgumentsWithInstance(NamedInstance instance) {
        return findArgumentsWithInstance(instance, null);
    }

}