package io.opencaesar.oml.dsl.ide.diagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sprotty.LayoutOptions;
import org.eclipse.sprotty.SModelElement;
import org.eclipse.sprotty.util.IdCache;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.base.Objects;

import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.Argument;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.BinaryPredicate;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Literal;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.RangeRestrictionKind;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.UnaryPredicate;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlButton;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlCompartment;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlEdge;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlGraph;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlHeader;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlLabel;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlNode;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlTag;
import io.opencaesar.oml.util.OmlRead;

class OmlOntologyDiagramView {
	public static String viewpointIRI = "http://opencaesar.io/viewpoint";
	final Ontology ontology;
	final IdCache<EObject> idCache;
	final Map<EObject, List<Annotation>> semantic2viewpointAnnotations;

	public OmlOntologyDiagramView(final Ontology ontology, final IdCache<EObject> idCache) {
		this.ontology = ontology;
		this.idCache = idCache;
		this.semantic2viewpointAnnotations = new HashMap<>();
	}

	// GRAPHS

	public OmlGraph createGraph() {
		final String id = idCache.uniqueId("root");
		final OmlGraph g = newSElement(OmlGraph.class, id, OmlDiagramModule.OmlDiagram_SGrapView);
		final LayoutOptions lo = new LayoutOptions();
		lo.setHAlign("left");
		lo.setHGap(10.0);
		g.setLayoutOptions(lo);
		return g;
	}

	// NODES

	public OmlNode createNode(final Ontology o) {
		final String id = idCache.uniqueId(o, getLocalName(o));

		final OmlNode n = newSElement(OmlNode.class, id, OmlDiagramModule.ModuleNode_ModuleNodeView);
		n.setLayout("vbox");
		n.setLayoutOptions(makeLayoutOptions(5.0));

		final OmlCompartment c = newSElement(OmlCompartment.class, id + ".heading", OmlDiagramModule.SCompartment_SCompartmentView);
		c.setLayout("hbox");
		n.getChildren().add(c);

		final OmlLabel l = newSElement(OmlLabel.class, id + ".label", OmlDiagramModule.SLabel_SLabelView_heading);
		l.setText(id);
		c.getChildren().add(l);

		if (o == ontology) {
			final OmlButton b = newSElement(OmlButton.class, id + ".expand", OmlDiagramModule.SButton_ExpandButtonView);
			c.getChildren().add(b);
			n.setExpanded(true);
		}

		return n;
	}

	private OmlNode createMemberNode(final Member m, final String tag) {
		final String text = getLocalName(m);
		final String id = idCache.uniqueId(m, text);
		final OmlNode n = newSElement(OmlNode.class, id, OmlDiagramModule.OmlNode_ClassNodeView);
		n.setCssClass("moduleNode");
		n.setLayout("vbox");
		n.setLayoutOptions(makeLayoutOptions(0.0));
		n.getChildren().add(newTaggedHeader(id, tag, text));
		return n;
	}

	public OmlNode createNode(final Aspect aspect) {
		final OmlNode n = createMemberNode(aspect, "A");
		return n;
	}

	public OmlNode createNode(final Concept concept) {
		final OmlNode n = createMemberNode(concept, "C");
		return n;
	}

	public OmlNode createNode(final RelationEntity entity, final SModelElement from, final SModelElement to) {
		final OmlNode n = createMemberNode(entity, "R");
		n.getChildren().add(newEdge(from, n, n.getId() + ".start", OmlDiagramModule.OMlEdge_PolylineEdgeView));
		n.getChildren().add(newEdge(n, to, n.getId() + ".end", OmlDiagramModule.OmlEdge_RelationshipArrowEdgeView));
		return n;
	}

	public OmlNode createSourceNode(final RelationEntity entity, final SModelElement to) {
		final OmlNode n = createMemberNode(entity, "R");
		n.getChildren().add(newEdge(n, to, n.getId() + ".end", OmlDiagramModule.OmlEdge_RelationshipArrowEdgeView));
		return n;
	}

	public OmlNode createTargetNode(final RelationEntity entity, final SModelElement from) {
		final OmlNode n = createMemberNode(entity, "R");
		n.getChildren().add(newEdge(from, n, n.getId() + ".start", OmlDiagramModule.OMlEdge_PolylineEdgeView));
		return n;
	}

	public OmlNode createNode(final Structure structure) {
		final OmlNode n = createMemberNode(structure, "S");
		return n;
	}

	public OmlNode createNode(final Scalar scalar) {
		final OmlNode n = createMemberNode(scalar, "SC");
		return n;
	}

	public OmlNode createNode(final Rule rule) {
		final String id = idCache.uniqueId(rule, getLocalName(rule));
		final OmlNode n = newSElement(OmlNode.class, id, OmlDiagramModule.OmlNode_ClassNodeView);
		n.setCssClass("moduleNode");
		n.setLayout("vbox");
		n.setLayoutOptions(makeLayoutOptions(0.0));
		n.getChildren().add(newTaglessHeader(id));
		return n;
	}

	public OmlNode createNode(final ConceptInstance ci) {
		final String text = getLocalName(ci) + ": " + ci.getOwnedTypes().stream().map(a -> a.getType().getAbbreviatedIri()).collect(Collectors.joining(","));
		final String id = idCache.uniqueId(ci, text);
		final OmlNode n = newSElement(OmlNode.class, id, OmlDiagramModule.OmlNode_ClassNodeView);
		n.setCssClass("moduleNode");
		n.setLayout("vbox");
		n.setLayoutOptions(makeLayoutOptions(0.0));
		n.getChildren().add(newTaggedHeader(id, "CI", text));
		return n;
	}

	public OmlNode createNode(final RelationInstance ri, final SModelElement from, final SModelElement to) {
		final String text = getLocalName(ri) + ": " + ri.getOwnedTypes().stream().map(a -> a.getType().getAbbreviatedIri()).collect(Collectors.joining(","));
		final String id = idCache.uniqueId(ri, text);
		final OmlNode n = newSElement(OmlNode.class, id, OmlDiagramModule.OmlNode_ClassNodeView);
		n.setCssClass("moduleNode");
		n.setLayout("vbox");
		n.setLayoutOptions(makeLayoutOptions(0.0));
		n.getChildren().add(newTaggedHeader(id, "RI", text));
		n.getChildren().add(newEdge(from, n, id + ".start", OmlDiagramModule.OMlEdge_PolylineEdgeView));
		n.getChildren().add(newEdge(n, to, id + ".end", OmlDiagramModule.OmlEdge_RelationshipArrowEdgeView));
		return n;
	}

	// COMPARTMENTS

	public OmlCompartment getAxiomCompartment(final SModelElement element) {
		return (OmlCompartment) element.getChildren().stream().filter(it -> it.getId().endsWith(".axiom.compartment")).findFirst().orElse(null);
	}

	public OmlCompartment createAxiomCompartment(final Classifier classifier) {
		final String id = idCache.getId(classifier) + ".axiom.compartment";
		return newCompartment(id, OmlDiagramModule.SCompartment_SCompartmentView);
	}

	public OmlCompartment getPropertyCompartment(final SModelElement element) {
		return (OmlCompartment) element.getChildren().stream().filter(it -> it.getId().endsWith(".property.compartment")).findFirst().orElse(null);
	}

	public OmlCompartment createPropertyCompartment(final Classifier classifier) {
		final String id = idCache.getId(classifier) + ".property.compartment";
		return newCompartment(id, OmlDiagramModule.SCompartment_SCompartmentView);
	}

	public OmlCompartment createPropertyCompartment(final NamedInstance instance) {
		final String id = idCache.getId(instance) + ".property.compartment";
		return newCompartment(id, OmlDiagramModule.SCompartment_SCompartmentView);
	}

	public OmlCompartment getAntecedentCompartment(final SModelElement element) {
		return (OmlCompartment) element.getChildren().stream().filter(it -> it.getId().endsWith(".antecedent.compartment")).findFirst().orElse(null);
	}

	public OmlCompartment createAntecedentCompartment(final Rule rule) {
		final String id = idCache.getId(rule) + ".antecedent.compartment";
		return newCompartment(id, OmlDiagramModule.SCompartment_SCompartmentView);
	}

	public OmlCompartment getConsequentCompartment(final SModelElement element) {
		return (OmlCompartment) element.getChildren().stream().filter(it -> it.getId().endsWith(".consequent.compartment")).findFirst().orElse(null);
	}

	public OmlCompartment createConsequentCompartment(final Rule rule) {
		final String id = idCache.getId(rule) + ".consequent.compartment";
		return newCompartment(id, OmlDiagramModule.SCompartment_SCompartmentView);
	}

	// LABELS

	public OmlLabel createLabel(final Classifier cls, final ScalarProperty property) {
		final String id = idCache.uniqueId(property, getLocalName(cls) + ".scalar." + getLocalName(property));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(property.getName() + ": " + property.getRanges().get(0).getName());
		return l;
	}

	public OmlLabel createLabel(final Entity e, final KeyAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".key." + ax.getProperties().stream().map(p -> p.getAbbreviatedIri()).collect(Collectors.joining(",")));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText("key: " + ax.getProperties().stream().map(p -> p.getAbbreviatedIri()).collect(Collectors.joining(", ")));
		return l;
	}

	public OmlLabel createScalarRangeLabel(final Entity e, final PropertyRangeRestrictionAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".rangeRestriction." + getLocalName(ax.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(getLocalName(ax.getProperty()) + " ⊂ " + getLocalName(ax.getRange()));
		return l;
	}

	public OmlLabel createStructuredRangeLabel(final Entity e, final PropertyRangeRestrictionAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".rangeRestriction." + getLocalName(ax.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(getLocalName(ax.getProperty()) + " ⊂ " + getLocalName(ax.getRange()));
		return l;
	}

	public OmlLabel createScalarCardinalityLabel(final Entity e, final PropertyCardinalityRestrictionAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".cardinalityRestriction" + getLocalName(ax.getProperty()));
		String notation;
		switch (ax.getKind()) {
		case EXACTLY:
			notation = " = ";
			break;
		case MIN:
			notation = " ≥ ";
			break;
		case MAX:
			notation = " ≤ ";
			break;
		default:
			throw new IllegalArgumentException("Unknown ScalarPropertyCardinalityRestrictionAxiom kind: " + ax.getKind());
		}
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText("⎸" + getLocalName(ax.getProperty()) + "⎹" + notation + ax.getCardinality());
		return l;
	}

	public OmlLabel createStructuredCardinalityLabel(final Entity e, final PropertyCardinalityRestrictionAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".cardinalityRestriction" + getLocalName(ax.getProperty()));
		String notation;
		switch (ax.getKind()) {
		case EXACTLY:
			notation = " = ";
			break;
		case MIN:
			notation = " ≥ ";
			break;
		case MAX:
			notation = " ≤ ";
			break;
		default:
			throw new IllegalArgumentException("Unknown StructuredPropertyCardinalityRestrictionAxiom kind: " + ax.getKind());
		}
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText("⎸" + getLocalName(ax.getProperty()) + "⎹" + notation + ax.getCardinality());
		return l;
	}

	public OmlLabel createScalarValueLabel(final Entity e, final PropertyValueRestrictionAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".valueRestriction." + getLocalName(ax.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(getLocalName(ax.getProperty()) + " = " + ax.getLiteralValue().getLexicalValue());
		return l;
	}

	public OmlLabel createStructuredValueLabel(final Entity e, final PropertyValueRestrictionAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".valueRestriction." + getLocalName(ax.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(getLocalName(ax.getProperty()) + " = " + getLabel((StructureInstance) ax.getStructureInstanceValue()));
		return l;
	}

	public OmlLabel createAntecedentLabel(final Predicate predicate) {
		final Rule rule = predicate.getAntecedentRule();
		final String id = idCache.uniqueId(predicate, getLocalName(rule) + ".antecedent");
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(toText(predicate));
		return l;
	}

	public OmlLabel createConsequentLabel(final Predicate predicate) {
		final Rule rule = predicate.getConsequentRule();
		final String id = idCache.uniqueId(predicate, getLocalName(rule) + ".consequent");
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(toText(predicate));
		return l;
	}

	private String toText(final Predicate predicate) {
		if (predicate instanceof SameAsPredicate) {
			SameAsPredicate p = (SameAsPredicate) predicate;
			return "SameAs(" + toText(p.getArgument1()) + ", " + toText(p.getArgument2()) + ")";
		} else if (predicate instanceof DifferentFromPredicate) {
			DifferentFromPredicate p = (DifferentFromPredicate) predicate;
			return "DifferentFrom(" + toText(p.getArgument1()) + ", " + toText(p.getArgument2()) + ")";
		} else if (predicate instanceof RelationEntityPredicate) {
			RelationEntityPredicate p = (RelationEntityPredicate) predicate;
			return p.getType().getName() + "(" + toText(p.getArgument1()) + "," + toText(p.getArgument()) + "," + toText(p.getArgument2()) + ")";
		} else if (predicate instanceof BinaryPredicate) {
			BinaryPredicate p = (BinaryPredicate) predicate;
			return OmlRead.getTerm(p).getName() + "(" + toText(p.getArgument1()) + "," + toText(p.getArgument2()) + ")";
		} else if (predicate instanceof UnaryPredicate) {
			UnaryPredicate p = (UnaryPredicate) predicate;
			return OmlRead.getTerm(p).getName() + "(" + toText(p.getArgument()) + ")";
		} else
			throw new IllegalArgumentException("Unknown kind of predicate: " + predicate.eClass().getName());
	}

	private String toText(final Argument argument) {
		if (argument.getVariable() != null) {
			return argument.getVariable();
		} else if (argument.getLiteral() != null) {
			return getLabel(argument.getLiteral());
		} else if (argument.getInstance() != null) {
			getLabel(argument.getInstance());
		}
		return "<null>";
	}
	
	public OmlLabel createLabel(final NamedInstance i, final PropertyValueAssertion ax) {
		final String id = idCache.uniqueId(ax, getLocalName(i) + ".valueAssertion." + getLocalName(ax.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(getLocalName(ax.getProperty()) + " = " + getLabel(ax.getValue()));
		return l;
	}

	// EDGES

	public OmlEdge createEdge(final Import _import, final SModelElement from, final SModelElement to) {
		final String id = idCache.uniqueId(from.getId() + ".imports." + to.getId());
		final OmlLabel l = newLeafSElement(OmlLabel.class, id + ".label", OmlDiagramModule.SLabel_SLabelView_text);
		l.setText("imports");
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_ImportEdgeView);
		e.setChildren(CollectionLiterals.newArrayList(l));
		return e;
	}

	public OmlEdge createEdge(final SpecializationAxiom axiom, final SModelElement from, final SModelElement to) {
		final String id = idCache.uniqueId(axiom, from.getId() + ".specializes." + to.getId());
		return newEdge(from, to, id, OmlDiagramModule.OmlEdge_SpecializationArrowEdgeView);
	}

	public OmlEdge createEdge(final RelationEntity entity, final SModelElement from, final SModelElement to) {
		final String id = idCache.uniqueId(entity, getLocalName(entity.getForwardRelation()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id + ".forward.label", OmlDiagramModule.SLabel_RelationshipLabelView);
		l.setText(getLocalName(entity.getForwardRelation()));
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_RelationshipArrowEdgeView);
		e.setChildren(CollectionLiterals.newArrayList(l));
		return e;
	}

	public OmlEdge createEdge(final PropertyCardinalityRestrictionAxiom axiom, final SModelElement from, final SModelElement to) {
		final String id = idCache.uniqueId(axiom, from.getId() + ".restrictsCardinality." + getLocalName(axiom.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id + ".label", OmlDiagramModule.SLabel_RestrictsLabelView);
		final String notation;
		switch (axiom.getKind()) {
		case EXACTLY:
			notation = "=";
			break;
		case MIN:
			notation = " ≥ ";
			break;
		case MAX:
			notation = " ≤ ";
			break;
		default:
			throw new IllegalArgumentException("createEdge(RelationCardinalityRestrictionAxiom) -- unrecognized kind: " + axiom.getKind());
		}
		l.setText("⎸" + getLocalName(axiom.getProperty()) + "⎹" + notation + axiom.getCardinality());
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_RestrictsArrowEdgeView);
		e.setChildren(CollectionLiterals.newArrayList(l));
		return e;
	}

	public OmlEdge createEdge(final PropertyRangeRestrictionAxiom axiom, final SModelElement from, final SModelElement to) {
		final String id = idCache.uniqueId(axiom, from.getId() + ".restrictsRange." + getLocalName(axiom.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id + ".label", OmlDiagramModule.SLabel_RestrictsLabelView);
		final String notation = (axiom.getKind() == RangeRestrictionKind.ALL) ? "∀" : "∃";
		l.setText(notation + getLocalName(axiom.getProperty()));
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_RestrictsArrowEdgeView);
		e.getChildren().add(l);
		return e;
	}

	public OmlEdge createEdge(final PropertyValueRestrictionAxiom axiom, final SModelElement from, final SModelElement to) {
		final String id = idCache.uniqueId(axiom, from.getId() + ".restrictsTarget." + getLocalName(axiom.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id + ".label", OmlDiagramModule.SLabel_RestrictsLabelView);
		l.setText(getLocalName(axiom.getProperty()) + " ⊂ ");
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_RestrictsArrowEdgeView);
		e.getChildren().add(l);
		return e;
	}

	public OmlEdge createEdge(final Classifier cls, final StructuredProperty property, final SModelElement from, final SModelElement to) {
		final String id = idCache.uniqueId(property, getLocalName(cls) + ".structured-property." + getLocalName(property));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id + ".label", OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(property.getName());
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_RestrictsArrowEdgeView);
		e.getChildren().add(l);
		return e;
	}

	public OmlEdge createEdge(final RelationInstance ri, final SModelElement from, final SModelElement to) {
		final String id = idCache.uniqueId(ri, getLocalName(ri));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id + ".forward.label", OmlDiagramModule.SLabel_RelationshipLabelView);
		l.setText(getLocalName(ri));
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_RelationshipArrowEdgeView);
		e.setChildren(CollectionLiterals.newArrayList(l));
		return e;
	}

	// HELPERS

	public LayoutOptions makeLayoutOptions(Double padding) {
		final LayoutOptions lo = new LayoutOptions();
		lo.setPaddingTop(padding);
		lo.setPaddingBottom(padding);
		lo.setPaddingLeft(padding);
		lo.setPaddingRight(padding);
		return lo;
	}

	public boolean isViewpointVocabulary(final Ontology o) {
		final String iri = o.getIri();
		return Objects.equal(iri, viewpointIRI);
	}

	private <E extends SModelElement> E newSElement(final Class<E> diagramElementClass, final String idStr, final String typeStr) {
		E e = newLeafSElement(diagramElementClass, idStr, typeStr);
		e.setChildren(new ArrayList<>());
		return e;
	}

	private <E extends SModelElement> E newLeafSElement(final Class<E> diagramElementClass, final String idStr, final String typeStr) {
		try {
			E e = diagramElementClass.getConstructor().newInstance();
			e.setId(idStr);
			e.setType(typeStr);
			return e;
		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}

	private OmlHeader newTaggedHeader(final String id, final String tag, final String label) {
		final LayoutOptions lo1 = new LayoutOptions();
		lo1.setResizeContainer(false);
		lo1.setHAlign("center");
		lo1.setVAlign("center");

		final OmlLabel l1 = new OmlLabel();
		l1.setType(OmlDiagramModule.SLabel_SLabelView_tag);
		l1.setId(id + ".tag.text");
		l1.setText(tag);

		final OmlTag t = new OmlTag();
		t.setId(id + ".header.tag");
		t.setType(OmlDiagramModule.Tag_TagView);
		t.setLayout("stack");
		t.setLayoutOptions(lo1);
		t.setChildren(CollectionLiterals.newArrayList(l1));

		final OmlLabel l2 = new OmlLabel();
		l2.setType(OmlDiagramModule.OmlEditableLabel_SLabelView);
		l2.setId(id + ".header.label");
		l2.setText(label);

		final OmlHeader h = newSElement(OmlHeader.class, id + ".header", OmlDiagramModule.SCompartment_HeaderCompartmentView);
		h.setLayout("hbox");
		h.setLayoutOptions(makeLayoutOptions(8.0));
		h.setChildren(CollectionLiterals.newArrayList(t, l2));
		return h;
	}

	private OmlTag newTaglessHeader(final String id) {
		final OmlLabel l = new OmlLabel();
		l.setType(OmlDiagramModule.SLabel_SLabeliew_classHeader);
		l.setId(id + ".header.label");
		l.setText(id);

		OmlTag t = newSElement(OmlTag.class, id + ".header", OmlDiagramModule.SCompartment_HeaderCompartmentView);
		t.setLayout("hbox");
		t.setLayoutOptions(makeLayoutOptions(8.0));
		t.setChildren(CollectionLiterals.newArrayList(l));
		return t;
	}

	public OmlEdge newEdge(final SModelElement fromElement, final SModelElement toElement, final String edgeId, final String edgeType) {
		OmlEdge e = newSElement(OmlEdge.class, edgeId, edgeType);
		e.setSourceId(fromElement.getId());
		e.setTargetId(toElement.getId());
		return e;
	}

	private OmlCompartment newCompartment(final String id, final String type) {
		final LayoutOptions lo = makeLayoutOptions(12.0);
		lo.setVGap(2.0);

		OmlCompartment c = newSElement(OmlCompartment.class, id, type);
		c.setLayout("vbox");
		c.setLayoutOptions(lo);
		c.setChildren(new ArrayList<>());
		return c;
	}

	private String getLabel(final Element element) {
		if (element instanceof Literal)
			return ((Literal)element).getLexicalValue();
		else if (element instanceof StructureInstance)
			return ((StructureInstance) element).getType().getName();
		else if (element instanceof NamedInstance)
			return getLocalName((NamedInstance)element);
		return "";
	}
	
	private String getLocalName(final Element element) {
		if (element instanceof Ontology) {
			return OmlRead.getPrefixIn(((Ontology) element), ontology);
		} else if (element instanceof Member) {
			return OmlRead.getAbbreviatedIriIn(((Member) element), ontology);
		} else
			throw new IllegalArgumentException("No local name for element of kind: " + element.eClass().getName());
	}
}