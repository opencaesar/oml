package io.opencaesar.oml.provider;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.BooleanLiteral;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptTypeAssertion;
import io.opencaesar.oml.DecimalLiteral;
import io.opencaesar.oml.Description;
import io.opencaesar.oml.DescriptionExtension;
import io.opencaesar.oml.DescriptionUsage;
import io.opencaesar.oml.DoubleLiteral;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.IntegerLiteral;
import io.opencaesar.oml.LinkAssertion;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationTypeAssertion;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredPropertyValueAssertion;
import io.opencaesar.oml.provider.OmlItemProviderAdapterFactory;
import io.opencaesar.oml.util.OmlRead;

/**
 * Provides custom labels for elements in OML descriptions
 */
public class OmlItemProviderAdapterFactoryEx extends OmlItemProviderAdapterFactory {
	
	// Description ontology, imports, extends
	
	@Override
	public Adapter createDescriptionAdapter() {
		if (descriptionItemProvider == null) descriptionItemProvider = new DescriptionItemProvider(this) {
			@Override
			public String getText(Object object) {
				Description description = (Description)object;
				StringBuilder label = new StringBuilder("description ");
				if (description.getIri() != null) {
					label.append("<").append(description.getIri()).append("> ");
				}
				label.append("with ").append(description.getSeparator());
				if (description.getPrefix() != null) {
					label.append(" as ").append(description.getPrefix());
				}
				return label.toString();
			}
		};
		return descriptionItemProvider;
	}
	
	@Override
	public Adapter createDescriptionUsageAdapter() {
		if (descriptionUsageItemProvider == null) descriptionUsageItemProvider = new DescriptionUsageItemProvider(this) {
			@Override
			public String getText(Object object) {
				DescriptionUsage usage = (DescriptionUsage)object;
				StringBuilder label = new StringBuilder("uses <");
				if (usage.getUri() != null) {
					label.append(usage.getUri());
				}
				label.append(">");
				if (usage.getPrefix() != null) {
					label.append(" as ").append(usage.getPrefix());
				}
				return label.toString();
			}
		};
		return descriptionUsageItemProvider;
	}
	
	@Override
	public Adapter createDescriptionExtensionAdapter() {
		if (descriptionExtensionItemProvider == null) descriptionExtensionItemProvider = new DescriptionExtensionItemProvider(this) {
			@Override
			public String getText(Object object) {
				DescriptionExtension extension = (DescriptionExtension)object;
				StringBuilder label = new StringBuilder("extends <");
				if (extension.getUri() != null) {
					label.append(extension.getUri());
				}
				label.append(">");
				if (extension.getPrefix() != null) {
					label.append(" as ").append(extension.getPrefix());
				}
				return label.toString();
			}
		};
		return descriptionExtensionItemProvider;
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
				return getLabel(linkAssertion.getRelation(), linkAssertion) + " " + getLabel(linkAssertion.getTarget(), linkAssertion);
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
						String iri = URLDecoder.decode(((InternalEObject)instance).eProxyURI().fragment(), "utf-8");
						return "ci <" + iri + ">";
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					return "ci " + OmlRead.getAbbreviatedIri(instance);
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
						String iri = URLDecoder.decode(((InternalEObject)instance).eProxyURI().fragment(), "utf-8");
						label.append("<").append(iri).append(">");
					} catch (UnsupportedEncodingException e) {
						throw new AssertionError(e);
					}
				} else {
					label.append(OmlRead.getAbbreviatedIri(instance));
				}
				if (instance.getSource() != null) {
					label.append(" from ").append(getLabel(instance.getSource(), instance));
				}
				if (instance.getTarget() != null) {
					label.append(" to ").append(getLabel(instance.getTarget(), instance));
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
			String label = OmlRead.getNameIn(member, OmlRead.getOntology(element));
			if (label != null) {
				return label;
			}
		}
		return OmlRead.getAbbreviatedIri(member);
	}
	
	/**
	 * Get the value (including scalar type and lang tag) of a literal
	 */
	private static StringBuilder getLiteralLabel(StringBuilder label, Literal literal) {
		if (literal instanceof QuotedLiteral) {
			QuotedLiteral quotedLiteral = (QuotedLiteral)literal;
			if (quotedLiteral.getValue() != null) {
				label.append("'").append(quotedLiteral.getValue()).append("'");
			} else {
				label.append("<no value>");
			}
			if (quotedLiteral.getLangTag() != null) {
				label.append("$").append(quotedLiteral.getLangTag());
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
		if (literal.getType() != null) {
			label.append("^^").append(getLabel(literal.getType(), literal));
		}
		return label;
	}
	
}