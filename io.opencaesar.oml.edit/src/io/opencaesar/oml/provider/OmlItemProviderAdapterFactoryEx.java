package io.opencaesar.oml.provider;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.Extension;
import io.opencaesar.oml.FacetedScalar;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.Inclusion;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.RelationValueRestrictionAxiom;
import io.opencaesar.oml.ReverseRelation;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.StructuredPropertyReference;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.StructuredPropertyValueRestrictionAxiom;
import io.opencaesar.oml.TypePredicate;
import io.opencaesar.oml.Usage;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyBundle;
import io.opencaesar.oml.util.OmlRead;

/**
 * Provides custom labels for elements in OML descriptions
 */
public class OmlItemProviderAdapterFactoryEx extends OmlItemProviderAdapterFactory {
	
	// Vocabularies, its bundle and their imports

	@Override
	public Adapter createVocabularyAdapter() {
		if (vocabularyItemProvider == null) vocabularyItemProvider = new VocabularyItemProvider(this) {
			@Override
			public String getText(Object object) {
				Vocabulary vocabulary = (Vocabulary)object;
				StringBuilder label = new StringBuilder("vocabulary");
				if (vocabulary.getNamespace() != null) {
					label.append(" <").append(vocabulary.getNamespace()).append(">");
				}
				if (vocabulary.getPrefix() != null) {
					label.append(" as ").append(vocabulary.getPrefix());
				}
				return label.toString();
			}
		};
		return vocabularyItemProvider;
	}
	
	@Override
	public Adapter createVocabularyBundleAdapter() {
		if (vocabularyBundleItemProvider == null) vocabularyBundleItemProvider = new VocabularyBundleItemProvider(this) {
			@Override
			public String getText(Object object) {
				VocabularyBundle bundle = (VocabularyBundle)object;
				StringBuilder label = new StringBuilder("vocabulary bundle");
				if (bundle.getNamespace() != null) {
					label.append(" <").append(bundle.getNamespace()).append(">");
				}
				if (bundle.getPrefix() != null) {
					label.append(" as ").append(bundle.getPrefix());
				}
				return label.toString();
			}
		};
		return vocabularyBundleItemProvider;
	}

	@Override
	public Adapter createExtensionAdapter() {
		if (extensionItemProvider == null) extensionItemProvider = new ExtensionItemProvider(this) {
			@Override
			public String getText(Object object) {
				Extension extension = (Extension)object;
				StringBuilder label = new StringBuilder("extends <");
				if (extension.getNamespace() != null) {
					label.append(extension.getNamespace());
				}
				label.append(">");
				if (extension.getPrefix() != null) {
					label.append(" as ").append(extension.getPrefix());
				}
				return label.toString();
			}
		};
		return extensionItemProvider;
	}
	
	@Override
	public Adapter createUsageAdapter() {
		if (usageItemProvider == null) usageItemProvider = new UsageItemProvider(this) {
			@Override
			public String getText(Object object) {
				Usage usage = (Usage)object;
				StringBuilder label = new StringBuilder("uses <");
				if (usage.getNamespace() != null) {
					label.append(usage.getNamespace());
				}
				label.append(">");
				if (usage.getPrefix() != null) {
					label.append(" as ").append(usage.getPrefix());
				}
				return label.toString();
			}
		};
		return usageItemProvider;
	}
	
	@Override
	public Adapter createInclusionAdapter() {
		if (inclusionItemProvider == null) inclusionItemProvider = new InclusionItemProvider(this) {
			@Override
			public String getText(Object object) {
				Inclusion inclusion = (Inclusion)object;
				StringBuilder label = new StringBuilder("includes <");
				if (inclusion.getNamespace() != null) {
					label.append(inclusion.getNamespace());
				}
				label.append(">");
				if (inclusion.getPrefix() != null) {
					label.append(" as ").append(inclusion.getPrefix());
				}
				return label.toString();
			}
		};
		return inclusionItemProvider;
	}

	// Description, its bundle and their imports
	
	@Override
	public Adapter createDescriptionAdapter() {
		if (descriptionItemProvider == null) descriptionItemProvider = new DescriptionItemProvider(this) {
			@Override
			public String getText(Object object) {
				Description description = (Description)object;
				StringBuilder label = new StringBuilder("description");
				if (description.getNamespace() != null) {
					label.append(" <").append(description.getNamespace()).append(">");
				}
				if (description.getPrefix() != null) {
					label.append(" as ").append(description.getPrefix());
				}
				return label.toString();
			}
		};
		return descriptionItemProvider;
	}
	
	@Override
	public Adapter createDescriptionBundleAdapter() {
		if (descriptionBundleItemProvider == null) descriptionBundleItemProvider = new DescriptionBundleItemProvider(this) {
			@Override
			public String getText(Object object) {
				DescriptionBundle bundle = (DescriptionBundle)object;
				StringBuilder label = new StringBuilder("description bundle");
				if (bundle.getNamespace() != null) {
					label.append(" <").append(bundle.getNamespace()).append(">");
				}
				if (bundle.getPrefix() != null) {
					label.append(" as ").append(bundle.getPrefix());
				}
				return label.toString();
			}
		};
		return descriptionBundleItemProvider;
	}

	// Types (aspect, concept, relation entity, structure)
	
	@Override
	public Adapter createAspectAdapter() {
		if (aspectItemProvider == null) aspectItemProvider = new AspectItemProvider(this) {
			@Override
			public String getText(Object object) {
				Aspect aspect = (Aspect)object;
				if (aspect.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)aspect).eProxyURI().fragment(), "utf-8");
						return "aspect <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "aspect " + getLabel(aspect);
				}
			}
		};
		return aspectItemProvider;
	}

	@Override
	public Adapter createConceptAdapter() {
		if (conceptItemProvider == null) conceptItemProvider = new ConceptItemProvider(this) {
			@Override
			public String getText(Object object) {
				Concept concept = (Concept)object;
				if (concept.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)concept).eProxyURI().fragment(), "utf-8");
						return "concept <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "concept " + getLabel(concept);
				}
			}
		};
		return conceptItemProvider;
	}

	@Override
	public Adapter createRelationEntityAdapter() {
		if (relationEntityItemProvider == null) relationEntityItemProvider = new RelationEntityItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationEntity entity = (RelationEntity)object;
				if (entity.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)entity).eProxyURI().fragment(), "utf-8");
						return "relation entity <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "relation entity " + getLabel(entity);
				}
			}
		};
		return relationEntityItemProvider;
	}

	@Override
	public Adapter createStructureAdapter() {
		if (structureItemProvider == null) structureItemProvider = new StructureItemProvider(this) {
			@Override
			public String getText(Object object) {
				Structure structure = (Structure)object;
				if (structure.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)structure).eProxyURI().fragment(), "utf-8");
						return "structure <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "structure " + getLabel(structure);
				}
			}
		};
		return structureItemProvider;
	}
	
	@Override
	public Adapter createFacetedScalarAdapter() {
		if (facetedScalarItemProvider == null) facetedScalarItemProvider = new FacetedScalarItemProvider(this) {
			@Override
			public String getText(Object object) {
				FacetedScalar scalar = (FacetedScalar)object;
				if (scalar.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)scalar).eProxyURI().fragment(), "utf-8");
						return "scalar <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "scalar " + getLabel(scalar);
				}
			}
		};
		return facetedScalarItemProvider;
	}

	@Override
	public Adapter createEnumeratedScalarAdapter() {
		if (enumeratedScalarItemProvider == null) enumeratedScalarItemProvider = new EnumeratedScalarItemProvider(this) {
			@Override
			public String getText(Object object) {
				EnumeratedScalar scalar = (EnumeratedScalar)object;
				if (scalar.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)scalar).eProxyURI().fragment(), "utf-8");
						return "enumerated scalar <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "enumerated scalar " + getLabel(scalar);
				}
			}
		};
		return enumeratedScalarItemProvider;
	}

	// Properties (annotation, scalar, structured)

	@Override
	public Adapter createAnnotationPropertyAdapter() {
		if (annotationPropertyItemProvider == null) annotationPropertyItemProvider = new AnnotationPropertyItemProvider(this) {
			@Override
			public String getText(Object object) {
				AnnotationProperty property = (AnnotationProperty)object;
				if (property.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)property).eProxyURI().fragment(), "utf-8");
						return "annotation property <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "annotation property " + getLabel(property);
				}
			}
		};
		return annotationPropertyItemProvider;
	}

	@Override
	public Adapter createScalarPropertyAdapter() {
		if (scalarPropertyItemProvider == null) scalarPropertyItemProvider = new ScalarPropertyItemProvider(this) {
			@Override
			public String getText(Object object) {
				ScalarProperty property = (ScalarProperty)object;
				if (property.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)property).eProxyURI().fragment(), "utf-8");
						return "scalar property <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "scalar property " + getLabel(property);
				}
			}
		};
		return scalarPropertyItemProvider;
	}

	@Override
	public Adapter createStructuredPropertyAdapter() {
		if (structuredPropertyItemProvider == null) structuredPropertyItemProvider = new StructuredPropertyItemProvider(this) {
			@Override
			public String getText(Object object) {
				StructuredProperty property = (StructuredProperty)object;
				if (property.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)property).eProxyURI().fragment(), "utf-8");
						return "structured property <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "structured property " + getLabel(property);
				}
			}
		};
		return structuredPropertyItemProvider;
	}

	// Relations (forward, reverse, source, target, inverse source, inverse target)

	@Override
	public Adapter createForwardRelationAdapter() {
		if (forwardRelationItemProvider == null) forwardRelationItemProvider = new ForwardRelationItemProvider(this) {
			@Override
			public String getText(Object object) {
				ForwardRelation relation = (ForwardRelation)object;
				if (relation.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)relation).eProxyURI().fragment(), "utf-8");
						return "forward <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "forward " + getLabel(relation);
				}
			}
		};
		return forwardRelationItemProvider;
	}

	@Override
	public Adapter createReverseRelationAdapter() {
		if (reverseRelationItemProvider == null) reverseRelationItemProvider = new ReverseRelationItemProvider(this) {
			@Override
			public String getText(Object object) {
				ReverseRelation relation = (ReverseRelation)object;
				if (relation.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)relation).eProxyURI().fragment(), "utf-8");
						return "reverse <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "reverse " + getLabel(relation);
				}
			}
		};
		return reverseRelationItemProvider;
	}

	// Rules and predicates (entity, relation entity, relation, sameAs, differentFrom)

	@Override
	public Adapter createRuleAdapter() {
		if (ruleItemProvider == null) ruleItemProvider = new RuleItemProvider(this) {
			@Override
			public String getText(Object object) {
				Rule rule = (Rule)object;
				if (rule.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)rule).eProxyURI().fragment(), "utf-8");
						return "rule <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "rule " + getLabel(rule);
				}
			}
		};
		return ruleItemProvider;
	}

	@Override
	public Adapter createTypePredicateAdapter() {
		if (typePredicateItemProvider == null) typePredicateItemProvider = new TypePredicateItemProvider(this) {
			@Override
			public String getText(Object object) {
				TypePredicate predicate = (TypePredicate)object;
				return getPredicateDirection(predicate) + getLabel(predicate.getType(), predicate) + "("+predicate.getVariable()+")";
			}
		};
		return typePredicateItemProvider;
	}


	@Override
	public Adapter createRelationEntityPredicateAdapter() {
		if (relationEntityPredicateItemProvider == null) relationEntityPredicateItemProvider = new RelationEntityPredicateItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationEntityPredicate predicate = (RelationEntityPredicate)object;
				return getPredicateDirection(predicate) + getLabel(predicate.getEntity(), predicate) + "("+predicate.getVariable1()+", "+predicate.getEntityVariable()+", "+predicate.getVariable2()+")";
			}
		};
		return relationEntityPredicateItemProvider;
	}

	@Override
	public Adapter createPropertyPredicateAdapter() {
		if (propertyPredicateItemProvider == null) propertyPredicateItemProvider = new PropertyPredicateItemProvider(this) {
			@Override
			public String getText(Object object) {
				PropertyPredicate predicate = (PropertyPredicate)object;
				return getPredicateDirection(predicate) + getLabel(predicate.getProperty(), predicate) + "("+predicate.getVariable1()+", "+predicate.getVariable2()+")";
			}
		};
		return propertyPredicateItemProvider;
	}

	@Override
	public Adapter createSameAsPredicateAdapter() {
		if (sameAsPredicateItemProvider == null) sameAsPredicateItemProvider = new SameAsPredicateItemProvider(this) {
			@Override
			public String getText(Object object) {
				SameAsPredicate predicate = (SameAsPredicate)object;
				return getPredicateDirection(predicate) + "sameAs("+predicate.getVariable1()+", "+predicate.getVariable2()+")";
			}
		};
		return sameAsPredicateItemProvider;
	}

	@Override
	public Adapter createDifferentFromPredicateAdapter() {
		if (differentFromPredicateItemProvider == null) differentFromPredicateItemProvider = new DifferentFromPredicateItemProvider(this) {
			@Override
			public String getText(Object object) {
				DifferentFromPredicate predicate = (DifferentFromPredicate)object;
				return getPredicateDirection(predicate) + "differentFrom("+predicate.getVariable1()+", "+predicate.getVariable2()+")";
			}
		};
		return differentFromPredicateItemProvider;
	}
	
	// Axioms (specialization, key, and restriction)
	
	@Override
	public Adapter createSpecializationAxiomAdapter() {
		if (specializationAxiomItemProvider == null) specializationAxiomItemProvider = new SpecializationAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				SpecializationAxiom axiom = (SpecializationAxiom)object;
				return "extends " + getLabel(axiom.getSpecializedTerm(), axiom);
			}
		};
		return specializationAxiomItemProvider;
	}

	@Override
	public Adapter createKeyAxiomAdapter() {
		if (keyAxiomItemProvider == null) keyAxiomItemProvider = new KeyAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				KeyAxiom axiom = (KeyAxiom)object;
				return "key " + axiom.getProperties().stream().map(p -> getLabel(p, axiom)).collect(Collectors.joining(", "));
			}
		};
		return keyAxiomItemProvider;
	}
	
	@Override
	public Adapter createScalarPropertyRangeRestrictionAxiomAdapter() {
		if (scalarPropertyRangeRestrictionAxiomItemProvider == null) scalarPropertyRangeRestrictionAxiomItemProvider = new ScalarPropertyRangeRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				ScalarPropertyRangeRestrictionAxiom axiom = (ScalarPropertyRangeRestrictionAxiom)object;
				return "restricts " + axiom.getKind() + " scalar property " + getLabel(axiom.getProperty(), axiom)+ " to " + getLabel(axiom.getRange(), axiom);
			}
		};
		return scalarPropertyRangeRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createScalarPropertyCardinalityRestrictionAxiomAdapter() {
		if (scalarPropertyCardinalityRestrictionAxiomItemProvider == null) scalarPropertyCardinalityRestrictionAxiomItemProvider = new ScalarPropertyCardinalityRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				ScalarPropertyCardinalityRestrictionAxiom axiom = (ScalarPropertyCardinalityRestrictionAxiom)object;
				return "restricts scalar property " + getLabel(axiom.getProperty(), axiom)+ " to " + axiom.getKind() + " " + axiom.getCardinality();
			}
		};
		return scalarPropertyCardinalityRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createScalarPropertyValueRestrictionAxiomAdapter() {
		if (scalarPropertyValueRestrictionAxiomItemProvider == null) scalarPropertyValueRestrictionAxiomItemProvider = new ScalarPropertyValueRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				ScalarPropertyValueRestrictionAxiom axiom = (ScalarPropertyValueRestrictionAxiom)object;
				return "restricts scalar property " + getLabel(axiom.getProperty(), axiom)+ " to " + getLiteralLabel(new StringBuilder(), axiom.getValue());
			}
		};
		return scalarPropertyValueRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createStructuredPropertyRangeRestrictionAxiomAdapter() {
		if (structuredPropertyRangeRestrictionAxiomItemProvider == null) structuredPropertyRangeRestrictionAxiomItemProvider = new StructuredPropertyRangeRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				StructuredPropertyRangeRestrictionAxiom axiom = (StructuredPropertyRangeRestrictionAxiom)object;
				return "restricts " + axiom.getKind() + " structured property " + getLabel(axiom.getProperty(), axiom)+ " to " + getLabel(axiom.getRange(), axiom);
			}
		};
		return structuredPropertyRangeRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createStructuredPropertyCardinalityRestrictionAxiomAdapter() {
		if (structuredPropertyCardinalityRestrictionAxiomItemProvider == null) structuredPropertyCardinalityRestrictionAxiomItemProvider = new StructuredPropertyCardinalityRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				StructuredPropertyCardinalityRestrictionAxiom axiom = (StructuredPropertyCardinalityRestrictionAxiom)object;
				return "restricts structured property " + getLabel(axiom.getProperty(), axiom)+ " to " + axiom.getKind() + " " + axiom.getCardinality();
			}
		};
		return structuredPropertyCardinalityRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createStructuredPropertyValueRestrictionAxiomAdapter() {
		if (structuredPropertyValueRestrictionAxiomItemProvider == null) structuredPropertyValueRestrictionAxiomItemProvider = new StructuredPropertyValueRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				StructuredPropertyValueRestrictionAxiom axiom = (StructuredPropertyValueRestrictionAxiom)object;
				StructureInstance instance = axiom.getValue();
				String value = "<none>";
				if (instance.getType() != null) {
					value = getLabel(instance.getType(), instance);
				}
				return "restricts structured property " + getLabel(axiom.getProperty(), axiom)+ " to " + value;
			}
		};
		return structuredPropertyValueRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createRelationRangeRestrictionAxiomAdapter() {
		if (relationRangeRestrictionAxiomItemProvider == null) relationRangeRestrictionAxiomItemProvider = new RelationRangeRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationRangeRestrictionAxiom axiom = (RelationRangeRestrictionAxiom)object;
				return "restricts " + axiom.getKind() + " relation " + getLabel(axiom.getProperty(), axiom)+ " to " + getLabel(axiom.getRange(), axiom);
			}
		};
		return relationRangeRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createRelationCardinalityRestrictionAxiomAdapter() {
		if (relationCardinalityRestrictionAxiomItemProvider == null) relationCardinalityRestrictionAxiomItemProvider = new RelationCardinalityRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationCardinalityRestrictionAxiom axiom = (RelationCardinalityRestrictionAxiom)object;
				return "restricts relation " + getLabel(axiom.getProperty(), axiom)+ " to " + axiom.getKind() + " " + axiom.getCardinality();
			}
		};
		return relationCardinalityRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createRelationValueRestrictionAxiomAdapter() {
		if (relationValueRestrictionAxiomItemProvider == null) relationValueRestrictionAxiomItemProvider = new RelationValueRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationValueRestrictionAxiom axiom = (RelationValueRestrictionAxiom)object;
				return "restricts relation " + getLabel(axiom.getProperty(), axiom)+ " to " + getLabel(axiom.getValue(), axiom);
			}
		};
		return relationValueRestrictionAxiomItemProvider;
	}

	// Property values (annotation, scalar, structured, link)

	@Override
	public Adapter createAnnotationAdapter() {
		if (annotationItemProvider == null) annotationItemProvider = new AnnotationItemProvider(this) {
			@Override
			public String getText(Object object) {
				Annotation annotation = (Annotation)object;
				return "@" + getPropertyLabel(annotation.getProperty(), annotation.getValue(), annotation);
			}
		};
		return annotationItemProvider;
	}
	
	@Override
	public Adapter createScalarPropertyValueAssertionAdapter() {
		if (scalarPropertyValueAssertionItemProvider == null) scalarPropertyValueAssertionItemProvider = new ScalarPropertyValueAssertionItemProvider(this) {
			@Override
			public String getText(Object object) {
				ScalarPropertyValueAssertion assertion = (ScalarPropertyValueAssertion)object;
				return getPropertyLabel(assertion.getProperty(), assertion.getValue(), assertion);
			}
		};
		return scalarPropertyValueAssertionItemProvider;
	}
	
	@Override
	public Adapter createStructuredPropertyValueAssertionAdapter() {
		if (structuredPropertyValueAssertionItemProvider == null) structuredPropertyValueAssertionItemProvider = new StructuredPropertyValueAssertionItemProvider(this) {
			@Override
			public String getText(Object object) {
				StructuredPropertyValueAssertion assertion = (StructuredPropertyValueAssertion)object;
				return getPropertyLabel(assertion.getProperty(), assertion.getValue(), assertion);
			}
		};
		return structuredPropertyValueAssertionItemProvider;
	}
	
	@Override
	public Adapter createLinkAssertionAdapter() {
		if (linkAssertionItemProvider == null) linkAssertionItemProvider = new LinkAssertionItemProvider(this) {
			@Override
			public String getText(Object object) {
				LinkAssertion linkAssertion = (LinkAssertion)object;
				return getLabel(linkAssertion.getProperty(), linkAssertion) + " " + getLabel(linkAssertion.getValue(), linkAssertion);
			}
		};
		return linkAssertionItemProvider;
	}
	
	// Instances (concept, relation, structure)

	@Override
	public Adapter createConceptInstanceAdapter() {
		if (conceptInstanceItemProvider == null) conceptInstanceItemProvider = new ConceptInstanceItemProvider(this) {
			@Override
			public String getText(Object object) {
				ConceptInstance instance = (ConceptInstance)object;
				if (instance.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)instance).eProxyURI().fragment(), "utf-8");
						return "ci <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "ci " + getLabel(instance);
				}
			}
		};
		return conceptInstanceItemProvider;
	}

	@Override
	public Adapter createRelationInstanceAdapter() {
		if (relationInstanceItemProvider == null) relationInstanceItemProvider = new RelationInstanceItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationInstance instance = (RelationInstance)object;
				StringBuilder label = new StringBuilder("ri ");
				if (instance.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)instance).eProxyURI().fragment(), "utf-8");
						label.append("<" + fragment + ">");
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					label.append(getLabel(instance));
				}
				if (!instance.getSources().isEmpty()) {
					List<String> labels = instance.getSources().stream().map(i -> getLabel(i, instance)).collect(Collectors.toList());
					label.append(" from ").append(String.join(", ", labels));
				}
				if (!instance.getTargets().isEmpty()) {
					List<String> labels = instance.getTargets().stream().map(i -> getLabel(i, instance)).collect(Collectors.toList());
					label.append(" to ").append(String.join(", ", labels));
				}
				return label.toString();
			}
		};
		return relationInstanceItemProvider;
	}

	@Override
	public Adapter createStructureInstanceAdapter() {
		if (structureInstanceItemProvider == null) structureInstanceItemProvider = new StructureInstanceItemProvider(this) {
			@Override
			public String getText(Object object) {
				StructureInstance instance = (StructureInstance) object;
				if (instance.getType() != null) {
					return getLabel(instance.getType(), instance);
				} else {
					return "<no structure type>";
				}
			}
		};
		return structureInstanceItemProvider;
	}
	
	// Type assertions (concept, relation)

	@Override
	public Adapter createConceptTypeAssertionAdapter() {
		if (conceptTypeAssertionItemProvider == null) conceptTypeAssertionItemProvider = new ConceptTypeAssertionItemProvider(this) {
			@Override
			public String getText(Object object) {
				ConceptTypeAssertion conceptTypeAssertion = (ConceptTypeAssertion)object;
				return "is-a " + getLabel(conceptTypeAssertion.getType(), conceptTypeAssertion);
			}
		};
		return conceptTypeAssertionItemProvider;
	}

	@Override
	public Adapter createRelationTypeAssertionAdapter() {
		if (relationTypeAssertionItemProvider == null) relationTypeAssertionItemProvider = new RelationTypeAssertionItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationTypeAssertion relationTypeAssertion = (RelationTypeAssertion)object;
				return "is-a " + getLabel(relationTypeAssertion.getType(), relationTypeAssertion);
			}
		};
		return relationTypeAssertionItemProvider;
	}

	// References (concept instance, relation instance)

	@Override
	public Adapter createAspectReferenceAdapter() {
		if (aspectReferenceItemProvider == null) aspectReferenceItemProvider = new AspectReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				AspectReference reference = (AspectReference)object;
				return "ref aspect " + getLabel(reference.getAspect(), reference);
			}
		};
		return aspectReferenceItemProvider;
	}

	@Override
	public Adapter createConceptReferenceAdapter() {
		if (conceptReferenceItemProvider == null) conceptReferenceItemProvider = new ConceptReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				ConceptReference reference = (ConceptReference)object;
				return "ref concept " + getLabel(reference.getConcept(), reference);
			}
		};
		return conceptReferenceItemProvider;
	}

	@Override
	public Adapter createRelationEntityReferenceAdapter() {
		if (relationEntityReferenceItemProvider == null) relationEntityReferenceItemProvider = new RelationEntityReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationEntityReference reference = (RelationEntityReference)object;
				return "ref relation entity " + getLabel(reference.getEntity(), reference);
			}
		};
		return relationEntityReferenceItemProvider;
	}

	@Override
	public Adapter createStructureReferenceAdapter() {
		if (structureReferenceItemProvider == null) structureReferenceItemProvider = new StructureReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				StructureReference reference = (StructureReference)object;
				return "ref structure " + getLabel(reference.getStructure(), reference);
			}
		};
		return structureReferenceItemProvider;
	}

	@Override
	public Adapter createAnnotationPropertyReferenceAdapter() {
		if (annotationPropertyReferenceItemProvider == null) annotationPropertyReferenceItemProvider = new AnnotationPropertyReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				AnnotationPropertyReference reference = (AnnotationPropertyReference)object;
				return "ref annotation property " + getLabel(reference.getProperty(), reference);
			}
		};
		return annotationPropertyReferenceItemProvider;
	}

	@Override
	public Adapter createScalarPropertyReferenceAdapter() {
		if (scalarPropertyReferenceItemProvider == null) scalarPropertyReferenceItemProvider = new ScalarPropertyReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				ScalarPropertyReference reference = (ScalarPropertyReference)object;
				return "ref scalar property " + getLabel(reference.getProperty(), reference);
			}
		};
		return scalarPropertyReferenceItemProvider;
	}

	@Override
	public Adapter createStructuredPropertyReferenceAdapter() {
		if (structuredPropertyReferenceItemProvider == null) structuredPropertyReferenceItemProvider = new StructuredPropertyReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				StructuredPropertyReference reference = (StructuredPropertyReference)object;
				return "ref structured property " + getLabel(reference.getProperty(), reference);
			}
		};
		return structuredPropertyReferenceItemProvider;
	}

	@Override
	public Adapter createFacetedScalarReferenceAdapter() {
		if (facetedScalarReferenceItemProvider == null) facetedScalarReferenceItemProvider = new FacetedScalarReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				FacetedScalarReference reference = (FacetedScalarReference)object;
				return "ref scalar " + getLabel(reference.getScalar(), reference);
			}
		};
		return facetedScalarReferenceItemProvider;
	}

	@Override
	public Adapter createEnumeratedScalarReferenceAdapter() {
		if (enumeratedScalarReferenceItemProvider == null) enumeratedScalarReferenceItemProvider = new EnumeratedScalarReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				EnumeratedScalarReference reference = (EnumeratedScalarReference)object;
				return "ref enumerated scalar " + getLabel(reference.getScalar(), reference);
			}
		};
		return enumeratedScalarReferenceItemProvider;
	}

	@Override
	public Adapter createRelationReferenceAdapter() {
		if (relationReferenceItemProvider == null) relationReferenceItemProvider = new RelationReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationReference reference = (RelationReference)object;
				return "ref relation " + getLabel(reference.getRelation(), reference);
			}
		};
		return relationReferenceItemProvider;
	}

	@Override
	public Adapter createRuleReferenceAdapter() {
		if (ruleReferenceItemProvider == null) ruleReferenceItemProvider = new RuleReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				RuleReference reference = (RuleReference)object;
				return "ref rule " + getLabel(reference.getRule(), reference);
			}
		};
		return ruleReferenceItemProvider;
	}

	@Override
	public Adapter createConceptInstanceReferenceAdapter() {
		if (conceptInstanceReferenceItemProvider == null) conceptInstanceReferenceItemProvider = new ConceptInstanceReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				ConceptInstanceReference reference = (ConceptInstanceReference)object;
				return "ref ci " + getLabel(reference.getInstance(), reference);
			}
		};
		return conceptInstanceReferenceItemProvider;
	}
	
	@Override
	public Adapter createRelationInstanceReferenceAdapter() {
		if (relationInstanceReferenceItemProvider == null) relationInstanceReferenceItemProvider = new RelationInstanceReferenceItemProvider(this) {
			@Override
			public String getText(Object object) {
				RelationInstanceReference reference = (RelationInstanceReference)object;
				return "ref ri " + getLabel(reference.getInstance(), reference);
			}
		};
		return relationInstanceReferenceItemProvider;
	}
	
	// Literals (quoted, integer, decimal, double, boolean)

	@Override
	public Adapter createQuotedLiteralAdapter() {
		if (quotedLiteralItemProvider == null) quotedLiteralItemProvider = new QuotedLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel(new StringBuilder(), (Literal)object).toString();
			}
		};
		return quotedLiteralItemProvider;
	}

	@Override
	public Adapter createIntegerLiteralAdapter() {
		if (integerLiteralItemProvider == null) integerLiteralItemProvider = new IntegerLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel(new StringBuilder(), (Literal)object).toString();
			}
		};
		return integerLiteralItemProvider;
	}

	@Override
	public Adapter createDecimalLiteralAdapter() {
		if (decimalLiteralItemProvider == null) decimalLiteralItemProvider = new DecimalLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel(new StringBuilder(), (Literal)object).toString();
			}
		};
		return decimalLiteralItemProvider;
	}
	
	@Override
	public Adapter createDoubleLiteralAdapter() {
		if (doubleLiteralItemProvider == null) doubleLiteralItemProvider = new DoubleLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel(new StringBuilder(), (Literal)object).toString();
			}
		};
		return doubleLiteralItemProvider;
	}
	
	@Override
	public Adapter createBooleanLiteralAdapter() {
		if (booleanLiteralItemProvider == null) booleanLiteralItemProvider = new BooleanLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel(new StringBuilder(), (Literal)object).toString();
			}
		};
		return booleanLiteralItemProvider;
	}
	
	// Utility functions
	
	/**
	 * Get the property label appended with the literal label (if present)
	 */
	static String getPropertyLabel(Member property, Object value, Element element) {
		StringBuilder label = new StringBuilder();
		if (property == null) {
			label.append("<no property>");
		} else {
			label.append(getLabel(property, element));
		}
		if (value instanceof Literal) {
			label.append(" ");
			getLiteralLabel(label, (Literal)value);
		}
		if (value instanceof StructureInstance) {
			label.append(" ");
			StructureInstance instance = (StructureInstance)value;
			if (instance.getType() != null) {
				label.append(getLabel(instance.getType(), instance));
			}
		}
		return label.toString();
	}
	
	/**
	 * Get a referenced Member name prefixed by namespace for non-proxy objects, or the URI of the
	 * referenced Member for proxy objects.
	 */
	static String getLabel(Member member, Element element) {
		if (member == null) {
			return "<null>";
		} else if (member.eIsProxy()) {
			return "<" + EcoreUtil.getURI(member) + ">";
		} else if (element != null) {
			String label = OmlRead.getAbbreviatedIriIn(member, element.getOntology());
			if (label != null) {
				return label;
			}
		}
		return getLabel(member);
	}
	
	private static String getLabel(Member member) {
		String name = member.getName();
		return (name != null) ? name : "<none>"; 
	}

	/**
	 * Get the value (including scalar type and lang tag) of a literal
	 */
	private static StringBuilder getLiteralLabel(StringBuilder label, Literal literal) {
		if (literal instanceof QuotedLiteral) {
			QuotedLiteral quotedLiteral = (QuotedLiteral)literal;
			if (quotedLiteral.getValue() != null) {
				label.append("\"").append(quotedLiteral.getValue()).append("\"");
			} else {
				label.append("<no value>");
			}
			if (quotedLiteral.getLangTag() != null) {
				label.append("$").append(quotedLiteral.getLangTag());
			}
			if (quotedLiteral.getType() != null) {
				label.append("^^").append(getLabel(quotedLiteral.getType(), literal));
			}
		} else if (literal instanceof IntegerLiteral) {
			label.append(((IntegerLiteral) literal).getValue());
		} else if (literal instanceof DecimalLiteral) {
			label.append(((DecimalLiteral) literal).getValue());
		} else if (literal instanceof DoubleLiteral) {
			label.append(((DoubleLiteral) literal).getValue());
		} else if (literal instanceof BooleanLiteral) {
			label.append(((BooleanLiteral) literal).isValue());
		}
		return label;
	}
	
	private static String getPredicateDirection(Predicate predicate) {
		if (predicate.eContainmentFeature().equals(OmlPackage.Literals.RULE__ANTECEDENT)) {
			return "antecedent ";
		} else if (predicate.eContainmentFeature().equals(OmlPackage.Literals.RULE__CONSEQUENT)) {
			return "consequent ";
		}
		return "";
	}
	
}