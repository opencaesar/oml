package io.opencaesar.oml.provider;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.AnnotationProperty;
import io.opencaesar.oml.AnonymousConceptInstance;
import io.opencaesar.oml.AnonymousRelationInstance;
import io.opencaesar.oml.Argument;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.BuiltIn;
import io.opencaesar.oml.BuiltInPredicate;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionBundle;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.ForwardRelation;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.ImportKind;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyPredicate;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
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
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.TypeAssertion;
import io.opencaesar.oml.TypePredicate;
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
	public Adapter createImportAdapter() {
		if (importItemProvider == null) importItemProvider = new ImportItemProvider(this) {
			@Override
			public String getText(Object object) {
				Import import_ = (Import)object;
				String kind = 
						(import_.getKind() == ImportKind.EXTENSION) ? "extends" :
						(import_.getKind() == ImportKind.USAGE) ? "uses" :
						(import_.getKind() == ImportKind.INCLUSION) ? "includes" : "";
				StringBuilder label = new StringBuilder(kind+" <");
				if (import_.getNamespace() != null) {
					label.append(import_.getNamespace());
				}
				label.append(">");
				if (import_.getPrefix() != null) {
					label.append(" as ").append(import_.getPrefix());
				}
				return label.toString();
			}
		};
		return importItemProvider;
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

	// Types (aspect, concept, relation entity)
	
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
				} else if (aspect.isRef()){
					return "ref aspect " + getLabel(aspect.resolve(), aspect);
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
				} else if (concept.isRef()){
					return "ref concept " + getLabel(concept.resolve(), concept);
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
				} else if (entity.isRef()){
					return "ref relation entity " + getLabel(entity.resolve(), entity);
				} else {
					return "relation entity " + getLabel(entity);
				}
			}
		};
		return relationEntityItemProvider;
	}

	@Override
	public Adapter createScalarAdapter() {
		if (scalarItemProvider == null) scalarItemProvider = new ScalarItemProvider(this) {
			@Override
			public String getText(Object object) {
				Scalar scalar = (Scalar)object;
				if (scalar.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)scalar).eProxyURI().fragment(), "utf-8");
						return "scalar <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else if (scalar.isRef()){
					return "ref scalar " + getLabel(scalar.resolve(), scalar);
				} else {
					return "scalar " + getLabel(scalar);
				}
			}
		};
		return scalarItemProvider;
	}

	// Properties (annotation, scalar, relation)

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
				} else if (property.isRef()){
					return "ref annotation property " + getLabel(property.resolve(), property);
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
				} else if (property.isRef()){
					return "ref scalar property " + getLabel(property.resolve(), property);
				} else {
					return "scalar property " + getLabel(property);
				}
			}
		};
		return scalarPropertyItemProvider;
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
				} else if (rule.isRef()){
					return "ref rule " + getLabel(rule.resolve(), rule);
				} else {
					return "rule " + getLabel(rule);
				}
			}
		};
		return ruleItemProvider;
	}

	// Rules and predicates (entity, relation entity, relation, sameAs, differentFrom)

	@Override
	public Adapter createBuiltInAdapter() {
		if (builtInItemProvider == null) builtInItemProvider = new BuiltInItemProvider(this) {
			@Override
			public String getText(Object object) {
				BuiltIn builtIn = (BuiltIn)object;
				if (builtIn.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)builtIn).eProxyURI().fragment(), "utf-8");
						return "builtin <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else if (builtIn.isRef()){
					return "ref builtin " + getLabel(builtIn.resolve(), builtIn);
				} else {
					return "builtin " + getLabel(builtIn);
				}
			}
		};
		return builtInItemProvider;
	}

	@Override
	public Adapter createTypePredicateAdapter() {
		if (typePredicateItemProvider == null) typePredicateItemProvider = new TypePredicateItemProvider(this) {
			@Override
			public String getText(Object object) {
				TypePredicate predicate = (TypePredicate)object;
				return getPredicateDirection(predicate) + getLabel(predicate.getType(), predicate) + "("+getLabel(predicate.getArgument(), predicate)+")";
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
				return getPredicateDirection(predicate) + getLabel(predicate.getType(), predicate) + "("+getLabel(predicate.getArgument1(), predicate)+", "+getLabel(predicate.getArgument(), predicate)+", "+getLabel(predicate.getArgument2(), predicate)+")";
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
				return getPredicateDirection(predicate) + getLabel(predicate.getProperty(), predicate) + "("+getLabel(predicate.getArgument1(), predicate)+", "+getLabel(predicate.getArgument2(), predicate)+")";
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
				return getPredicateDirection(predicate) + "sameAs("+getLabel(predicate.getArgument1(), predicate)+", "+getLabel(predicate.getArgument2(), predicate)+")";
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
				return getPredicateDirection(predicate) + "differentFrom("+getLabel(predicate.getArgument1(), predicate)+", "+getLabel(predicate.getArgument2(), predicate)+")";
			}
		};
		return differentFromPredicateItemProvider;
	}
	
	@Override
	public Adapter createBuiltInPredicateAdapter() {
		if (builtInPredicateItemProvider == null) builtInPredicateItemProvider = new BuiltInPredicateItemProvider(this) {
			@Override
			public String getText(Object object) {
				BuiltInPredicate predicate = (BuiltInPredicate)object;
				StringBuffer arguments = new StringBuffer();
				predicate.getArguments().forEach(i -> arguments.append(", "+getLabel(i, predicate)));
				return getPredicateDirection(predicate) + "builtIn("+getLabel(predicate.getBuiltIn(), predicate)+arguments+")";
			}
		};
		return builtInPredicateItemProvider;
	}

	// Axioms (specialization, key, and restriction)
	
	@Override
	public Adapter createSpecializationAxiomAdapter() {
		if (specializationAxiomItemProvider == null) specializationAxiomItemProvider = new SpecializationAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				SpecializationAxiom axiom = (SpecializationAxiom)object;
				return "extends " + getLabel(axiom.getSuperTerm(), axiom);
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
	public Adapter createPropertyRangeRestrictionAxiomAdapter() {
		if (propertyRangeRestrictionAxiomItemProvider == null) propertyRangeRestrictionAxiomItemProvider = new PropertyRangeRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				PropertyRangeRestrictionAxiom axiom = (PropertyRangeRestrictionAxiom)object;
				String propertyKind = "";
				if (axiom.getProperty() instanceof ScalarProperty) {
					propertyKind = "scalar property";
				} else if (axiom.getProperty() instanceof Relation) {
					propertyKind = "relation";
				}
				return "restricts " + axiom.getKind() + " "+propertyKind+" " + getLabel(axiom.getProperty(), axiom)+ " to " + getLabel(axiom.getRange(), axiom);
			}
		};
		return propertyRangeRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createPropertyCardinalityRestrictionAxiomAdapter() {
		if (propertyCardinalityRestrictionAxiomItemProvider == null) propertyCardinalityRestrictionAxiomItemProvider = new PropertyCardinalityRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				PropertyCardinalityRestrictionAxiom axiom = (PropertyCardinalityRestrictionAxiom)object;
				String propertyKind = "";
				if (axiom.getProperty() instanceof ScalarProperty) {
					propertyKind = "scalar property";
				} else if (axiom.getProperty() instanceof Relation) {
					propertyKind = "relation";
				}
				return "restricts "+propertyKind+" " + getLabel(axiom.getProperty(), axiom)+ " to " + axiom.getKind() + " " + axiom.getCardinality();
			}
		};
		return propertyCardinalityRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createPropertyValueRestrictionAxiomAdapter() {
		if (propertyValueRestrictionAxiomItemProvider == null) propertyValueRestrictionAxiomItemProvider = new PropertyValueRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				PropertyValueRestrictionAxiom axiom = (PropertyValueRestrictionAxiom)object;
				String valueLabel = "";
				if (axiom.getLiteralValue() != null) {
					valueLabel = getLiteralLabel(axiom.getLiteralValue()).toString();
				} else if (axiom.getContainedValue() instanceof AnonymousConceptInstance) {
					var instance = (AnonymousConceptInstance) axiom.getContainedValue();
					var type = instance.getEntity();
					if (type != null) {
						valueLabel = getLabel(type, instance);
					}
				} else if (axiom.getContainedValue() instanceof AnonymousRelationInstance) {
					var instance = (AnonymousRelationInstance) axiom.getContainedValue();
					var type = instance.getRelationEntity();
					if (type != null) {
						valueLabel = getLabel(type, instance);
					}
				} else if (axiom.getReferencedValue() != null) {
					valueLabel = getLabel(axiom.getReferencedValue(), axiom);
				}
				return "restricts " + getLabel(axiom.getProperty(), axiom)+ " to " + valueLabel;
			}
		};
		return propertyValueRestrictionAxiomItemProvider;
	}

	@Override
	public Adapter createPropertySelfRestrictionAxiomAdapter() {
		if (propertySelfRestrictionAxiomItemProvider == null) propertySelfRestrictionAxiomItemProvider = new PropertySelfRestrictionAxiomItemProvider(this) {
			@Override
			public String getText(Object object) {
				PropertySelfRestrictionAxiom axiom = (PropertySelfRestrictionAxiom)object;
				return "restricts relation " + getLabel(axiom.getProperty(), axiom)+ " to self";
			}
		};
		return propertySelfRestrictionAxiomItemProvider;
	}
	
	// Property values (annotation, scalar, relation)

	@Override
	public Adapter createAnnotationAdapter() {
		if (annotationItemProvider == null) annotationItemProvider = new AnnotationItemProvider(this) {
			@Override
			public String getText(Object object) {
				Annotation annotation = (Annotation)object;
				return "@" + getPropertyLabel(annotation.getProperty(), annotation.getValues(), annotation);
			}
		};
		return annotationItemProvider;
	}
	
	@Override
	public Adapter createPropertyValueAssertionAdapter() {
		if (propertyValueAssertionItemProvider == null) propertyValueAssertionItemProvider = new PropertyValueAssertionItemProvider(this) {
			@Override
			public String getText(Object object) {
				PropertyValueAssertion assertion = (PropertyValueAssertion)object;
				return getPropertyLabel(assertion.getProperty(), assertion.getValues(), assertion);
			}
		};
		return propertyValueAssertionItemProvider;
	}
		
	// Instances (concept, relation)

	@Override
	public Adapter createConceptInstanceAdapter() {
		if (conceptInstanceItemProvider == null) conceptInstanceItemProvider = new ConceptInstanceItemProvider(this) {
			@Override
			public String getText(Object object) {
				ConceptInstance instance = (ConceptInstance)object;
				if (instance.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)instance).eProxyURI().fragment(), "utf-8");
						return "instance <" + fragment + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else if (instance.isRef()){
					return "ref instance " + getLabel(instance.resolve(), instance);
				} else {
					return "instance " + getLabel(instance);
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
				StringBuilder label = new StringBuilder("");
				if (instance.eIsProxy()) {
					try {
						String fragment = URLDecoder.decode(((InternalEObject)instance).eProxyURI().fragment(), "utf-8");
						label.append("relation instance <" + fragment + ">");
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else if (instance.isRef()){
					label.append("ref relation instance " + getLabel(instance.resolve(), instance));
				} else {
					label.append("relation instance " + getLabel(instance));
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
	public Adapter createAnonymousConceptInstanceAdapter() {
		if (anonymousConceptInstanceItemProvider == null) anonymousConceptInstanceItemProvider = new AnonymousConceptInstanceItemProvider(this) {
			@Override
			public String getText(Object object) {
				AnonymousConceptInstance instance = (AnonymousConceptInstance) object;
				if (instance.getEntity() != null) {
					return getLabel(instance.getEntity(), instance);
				} else {
					return "<no instance type>";
				}
			}
		};
		return anonymousConceptInstanceItemProvider;
	}
	
	@Override
	public Adapter createAnonymousRelationInstanceAdapter() {
		if (anonymousRelationInstanceItemProvider == null) anonymousRelationInstanceItemProvider = new AnonymousRelationInstanceItemProvider(this) {
			@Override
			public String getText(Object object) {
				AnonymousRelationInstance instance = (AnonymousRelationInstance) object;
				if (instance.getRelationEntity() != null) {
					return getLabel(instance.getRelationEntity(), instance);
				} else {
					return "<no instance type>";
				}
			}
		};
		return anonymousRelationInstanceItemProvider;
	}

	// Type assertion

	@Override
	public Adapter createTypeAssertionAdapter() {
		if (typeAssertionItemProvider == null) typeAssertionItemProvider = new TypeAssertionItemProvider(this) {
			@Override
			public String getText(Object object) {
				TypeAssertion typeAssertion = (TypeAssertion)object;
				return "is-a " + getLabel(typeAssertion.getType(), typeAssertion);
			}
		};
		return typeAssertionItemProvider;
	}

	// Literals (quoted, integer, decimal, double, boolean)

	@Override
	public Adapter createQuotedLiteralAdapter() {
		if (quotedLiteralItemProvider == null) quotedLiteralItemProvider = new QuotedLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel((Literal)object).toString();
			}
		};
		return quotedLiteralItemProvider;
	}

	@Override
	public Adapter createIntegerLiteralAdapter() {
		if (integerLiteralItemProvider == null) integerLiteralItemProvider = new IntegerLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel((Literal)object).toString();
			}
		};
		return integerLiteralItemProvider;
	}

	@Override
	public Adapter createDecimalLiteralAdapter() {
		if (decimalLiteralItemProvider == null) decimalLiteralItemProvider = new DecimalLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel((Literal)object).toString();
			}
		};
		return decimalLiteralItemProvider;
	}
	
	@Override
	public Adapter createDoubleLiteralAdapter() {
		if (doubleLiteralItemProvider == null) doubleLiteralItemProvider = new DoubleLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel((Literal)object).toString();
			}
		};
		return doubleLiteralItemProvider;
	}
	
	@Override
	public Adapter createBooleanLiteralAdapter() {
		if (booleanLiteralItemProvider == null) booleanLiteralItemProvider = new BooleanLiteralItemProvider(this) {
			@Override
			public String getText(Object object) {
				return getLiteralLabel((Literal)object).toString();
			}
		};
		return booleanLiteralItemProvider;
	}
	
	// Utility functions
	
	/**
	 * Get the property label appended with the literal label (if present)
	 */
	static String getPropertyLabel(Member property, List<Element> values, Element element) {
		StringBuilder label = new StringBuilder();
		if (property == null) {
			label.append("<no property>");
		} else {
			label.append(getLabel(property, element));
		}
		List<String> valuesLabels = new ArrayList<>();
		for (Element value : values) {
			if (value instanceof Literal) {
				valuesLabels.add(getLiteralLabel((Literal)value));
			} else if (value instanceof AnonymousConceptInstance) {
				var instance = (AnonymousConceptInstance) value;
				valuesLabels.add(getLabel(instance.getType(), instance));
			} else if (value instanceof AnonymousRelationInstance) {
				var instance = (AnonymousRelationInstance) value;
				valuesLabels.add(getLabel(instance.getTarget(), instance));
			} else if (value instanceof NamedInstance) {
				valuesLabels.add(getLabel((NamedInstance)value, element));
			}
		}
		label.append(" ");
		label.append(valuesLabels.stream().collect(Collectors.joining(", ")));
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
		} else {
			String label = OmlRead.getAbbreviatedIriIn(member, element.getOntology());
			if (label != null) {
				return label;
			}
		}
		return getLabel(member);
	}

	static String getLabel(Argument argument, Element element) {
		if (argument == null) {
			return "<null>";
		} else if (argument.getVariable() != null) {
			return argument.getVariable();
		} else if (argument.getLiteral() != null) {
			return getLiteralLabel(argument.getLiteral()).toString();
		} else if (argument.getInstance() != null) {
			if (argument.getInstance().eIsProxy()) {
				return "<" + EcoreUtil.getURI(argument.getInstance()) + ">";
			} else if (element != null) {
				String label = OmlRead.getAbbreviatedIriIn(argument.getInstance(), element.getOntology());
				if (label != null) {
					return label;
				}
			}
			return getLabel(argument.getInstance());
		}
		return "<null>";
	}
	
	
	private static String getLabel(Member member) {
		String name = member.getName();
		return (name != null) ? name : "<none>"; 
	}

	/**
	 * Get the value (including scalar type and lang tag) of a literal
	 */
	private static String getLiteralLabel(Literal literal) {
		StringBuilder label = new StringBuilder();
		if (literal instanceof QuotedLiteral) {
			QuotedLiteral quotedLiteral = (QuotedLiteral)literal;
			if (quotedLiteral.getValue() != null) {
				label.append("\"").append(quotedLiteral.getValue().replaceAll("\n", "")).append("\"");
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
		return label.toString();
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