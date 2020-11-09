package io.opencaesar.oml.dsl.ide.diagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sprotty.LayoutOptions;
import org.eclipse.sprotty.SModelElement;
import org.eclipse.sprotty.util.IdCache;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

import com.google.common.base.Objects;

import io.opencaesar.oml.AnnotatedElement;
import io.opencaesar.oml.Annotation;
import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.DifferentFromPredicate;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EntityPredicate;
import io.opencaesar.oml.IdentifiedElement;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.RangeRestrictionKind;
import io.opencaesar.oml.Reference;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityPredicate;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationPredicate;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationTargetRestrictionAxiom;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.SameAsPredicate;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.util.OmlRead;

public class OmlOntologyDiagramView {

	public static String diagramIRI = "http://opencaesar.io/diagram";

	final Ontology ontology;
	final IdCache<EObject> idCache;
	final Map<EObject, Iterable<Annotation>> semantic2diagramAnnotations;
	final OmlOntoloyDiagramScope scope;

	public OmlOntologyDiagramView(final Ontology ontology, final IdCache<EObject> idCache) {
		this.ontology = ontology;
		this.idCache = idCache;
		this.semantic2diagramAnnotations = new HashMap<>();
		this.scope = new OmlOntoloyDiagramScope(ontology).analyze();
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

	protected OmlNode createMemberNode(final Member m, final String tag) {
		final String text = getLocalName(m);
		final String id = idCache.uniqueId(m, text);
		final OmlNode n = newSElement(OmlNode.class, id, OmlDiagramModule.OmlNode_ClassNodeView);
		n.setCssClass("moduleNode");
		n.setLayout("vbox");
		n.setLayoutOptions(makeLayoutOptions(0.0));
		n.getChildren().add(newTaggedHeader(id, tag, text));
		return n;
	}

	public OmlNode createNode(final Aspect aspect, final Iterable<KeyAxiom> keys) {
		final OmlNode n = createMemberNode(aspect, "A");
		keys.forEach(key -> n.getChildren().add(createLabel(aspect, key)));
		return n;
	}

	public OmlNode createNode(final Concept concept, final Iterable<KeyAxiom> keys) {
		final OmlNode n = createMemberNode(concept, "C");
		keys.forEach(key -> n.getChildren().add(createLabel(concept, key)));
		return n;
	}

	public OmlNode createNode(final RelationEntity entity, final SModelElement from, final SModelElement to,
			final Iterable<KeyAxiom> keys) {
		final OmlNode n = createMemberNode(entity, "R");
		n.getChildren().add(newEdge(from, n, n.getId() + ".start", OmlDiagramModule.OMlEdge_PolylineEdgeView));
		n.getChildren().add(newEdge(n, to, n.getId() + ".end", OmlDiagramModule.OmlEdge_RelationshipArrowEdgeView));
		keys.forEach(key -> n.getChildren().add(createLabel(entity, key)));
		return n;
	}

	public OmlNode createSourceNode(final RelationEntity entity, final SModelElement to,
							  final Iterable<KeyAxiom> keys) {
		final OmlNode n = createMemberNode(entity, "R");
		n.getChildren().add(newEdge(n, to, n.getId() + ".end", OmlDiagramModule.OmlEdge_RelationshipArrowEdgeView));
		keys.forEach(key -> n.getChildren().add(createLabel(entity, key)));
		return n;
	}

	public OmlNode createTargetNode(final RelationEntity entity, final SModelElement from,
							  final Iterable<KeyAxiom> keys) {
		final OmlNode n = createMemberNode(entity, "R");
		n.getChildren().add(newEdge(from, n, n.getId() + ".start", OmlDiagramModule.OMlEdge_PolylineEdgeView));
		keys.forEach(key -> n.getChildren().add(createLabel(entity, key)));
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
		final String text = getLocalName(ci) + ": "
				+ IterableExtensions.join(ListExtensions.map(ci.getOwnedTypes(), cta -> OmlRead.getAbbreviatedIri(cta.getType())), ",");
		final String id = idCache.uniqueId(ci, text);
		final OmlNode n = newSElement(OmlNode.class, id, OmlDiagramModule.OmlNode_ClassNodeView);
		n.setCssClass("moduleNode");
		n.setLayout("vbox");
		n.setLayoutOptions(makeLayoutOptions(0.0));
		n.getChildren().add(newTaggedHeader(id, "CI", text));
		return n;
	}

	public OmlNode createNode(final RelationInstance ri, final SModelElement from, final SModelElement to) {
		final String text = getLocalName(ri) + ": " + IterableExtensions
				.join(ListExtensions.map(ri.getOwnedTypes(), rta -> OmlRead.getAbbreviatedIri(rta.getType())), ",");
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

	public OmlCompartment getPropertyCompartment(final SModelElement element) {
		return (OmlCompartment) IterableExtensions.head(IterableExtensions.filter(element.getChildren(),
				it -> Boolean.valueOf(it.getId().endsWith(".property.compartment"))));
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
		return (OmlCompartment) IterableExtensions.head(IterableExtensions.filter(element.getChildren(),
				it -> Boolean.valueOf(it.getId().endsWith(".antecedent.compartment"))));
	}

	public OmlCompartment createAntecedentCompartment(final Rule rule) {
		final String id = idCache.getId(rule) + ".antecedent.compartment";
		return newCompartment(id , OmlDiagramModule.SCompartment_SCompartmentView);
	}

	public OmlCompartment getConsequentCompartment(final SModelElement element) {
		return (OmlCompartment) IterableExtensions.head(IterableExtensions.filter(element.getChildren(),
				it -> Boolean.valueOf(it.getId().endsWith(".consequent.compartment"))));
	}

	public OmlCompartment createConsequentCompartment(final Rule rule) {
		final String id = idCache.getId(rule) + ".consequent.compartment";
		return newCompartment(id, OmlDiagramModule.SCompartment_SCompartmentView);
	}

	// LABELS

	public OmlLabel createLabel(final Classifier cls, final ScalarProperty property) {
		final String id = idCache.uniqueId(property, getLocalName(cls) + ".scalar." + getLocalName(property));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(property.getName() + ": " + property.getRange().getName());
		return l;
	}

	public OmlLabel createLabel(final Entity e, final KeyAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".key." + IterableExtensions
				.join(ListExtensions.map(ax.getProperties(), p -> OmlRead.getAbbreviatedIri(p)), ","));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText("key: " + IterableExtensions
				.join(ListExtensions.map(ax.getProperties(), p -> OmlRead.getAbbreviatedIri(p)), ", "));
		return l;
	}

	public OmlLabel createLabel(final Entity e, final ScalarPropertyCardinalityRestrictionAxiom ax) {
		final String id = idCache.uniqueId(ax,
				getLocalName(e) + ".cardinalityRestriction" + getLocalName(ax.getProperty()));
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
			throw new IllegalArgumentException(
					"Unknown ScalarPropertyCardinalityRestrictionAxiom kind: " + ax.getKind());
		}
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText("⎸" + getLocalName(ax.getProperty()) + "⎹" + notation + ax.getCardinality());
		return l;
	}

	public OmlLabel createLabel(final Entity e, final ScalarPropertyRangeRestrictionAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".rangeRestriction." + getLocalName(ax.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(getLocalName(ax.getProperty()) + " ⊂ " + getLocalName(ax.getRange()));
		return l;
	}

	public OmlLabel createLabel(final Entity e, final ScalarPropertyValueRestrictionAxiom ax) {
		final String id = idCache.uniqueId(ax, getLocalName(e) + ".valueRestriction." + getLocalName(ax.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(getLocalName(ax.getProperty()) + " = " + OmlRead.getLexicalValue(ax.getValue()));
		return l;
	}

	public OmlLabel createAntecedentLabel(final Predicate predicate) {
		final Rule rule = predicate.getAntecedentRule();
		final String id = idCache.uniqueId(predicate, getLocalName(rule) + ".antecedent");
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(toText(predicate));
		return l;
	}

	public OmlLabel createConsequentLabel(final RelationPredicate predicate) {
		final Rule rule = predicate.getConsequentRule();
		final String id = idCache.uniqueId(predicate, getLocalName(rule) + ".consequent");
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(toText(predicate));
		return l;
	}

	private String toText(final Predicate predicate) {
		if (predicate instanceof EntityPredicate) {
			EntityPredicate p = (EntityPredicate) predicate;
			return p.getEntity().getName() + "(" + p.getVariable() + ")";
		} else if (predicate instanceof SameAsPredicate) {
			SameAsPredicate p = (SameAsPredicate) predicate;
			return "SameAs(" + p.getVariable1() + ", " + p.getVariable2() + ")";
		} else if (predicate instanceof DifferentFromPredicate) {
			DifferentFromPredicate p = (DifferentFromPredicate) predicate;
			return "DifferentFrom(" + p.getVariable1() + ", " + p.getVariable2() + ")";
		} else if (predicate instanceof RelationPredicate) {
			RelationPredicate p = (RelationPredicate) predicate;
			return p.getRelation().getName() + "(" + p.getVariable1() + "," + p.getVariable2() + ")";
		} else if (predicate instanceof RelationEntityPredicate) {
			RelationEntityPredicate p = (RelationEntityPredicate) predicate;
			return p.getEntity().getName() + "(" + p.getVariable1() + "," + p.getEntityVariable() + ","
					+ p.getVariable2() + ")";
		} else
			throw new IllegalArgumentException("Unknown kind of predicate: " + predicate.eClass().getName());
	}

	public OmlLabel createLabel(final NamedInstance i, final ScalarPropertyValueAssertion ax) {
		final String id = idCache.uniqueId(ax, getLocalName(i) + ".valueAssertion." + getLocalName(ax.getProperty()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id, OmlDiagramModule.SLabel_SLabelView_text);
		l.setText(getLocalName(ax.getProperty()) + " = " + OmlRead.getLexicalValue(ax.getValue()));
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

	public OmlEdge createEdge(final RelationCardinalityRestrictionAxiom axiom, final SModelElement from,
			final SModelElement to) {
		final String id = idCache.uniqueId(axiom,
				from.getId() + ".restrictsCardinality." + getLocalName(axiom.getRelation()));
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
			throw new IllegalArgumentException(
					"createEdge(RelationCardinalityRestrictionAxiom) -- unrecognized kind: " + axiom.getKind());
		}
		l.setText("⎸" + getLocalName(axiom.getRelation()) + "⎹" + notation + axiom.getCardinality());
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_RestrictsArrowEdgeView);
		e.setChildren(CollectionLiterals.newArrayList(l));
		return e;
	}

	public OmlEdge createEdge(final RelationRangeRestrictionAxiom axiom, final SModelElement from,
			final SModelElement to) {
		final String id = idCache.uniqueId(axiom,
				from.getId() + ".restrictsRange." + getLocalName(axiom.getRelation()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id + ".label", OmlDiagramModule.SLabel_RestrictsLabelView);
		final String notation = (axiom.getKind() == RangeRestrictionKind.ALL) ? "∀" : "∃";
		l.setText(notation + getLocalName(axiom.getRelation()));
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_RestrictsArrowEdgeView);
		e.getChildren().add(l);
		return e;
	}

	public OmlEdge createEdge(final RelationTargetRestrictionAxiom axiom, final SModelElement from,
			final SModelElement to) {
		final String id = idCache.uniqueId(axiom,
				from.getId() + ".restrictsTarget." + getLocalName(axiom.getRelation()));
		final OmlLabel l = newLeafSElement(OmlLabel.class, id + ".label", OmlDiagramModule.SLabel_RestrictsLabelView);
		l.setText(getLocalName(axiom.getRelation()) + " ⊂ ");
		final OmlEdge e = newEdge(from, to, id, OmlDiagramModule.OmlEdge_RestrictsArrowEdgeView);
		e.getChildren().add(l);
		return e;
	}

	public OmlEdge createEdge(final Classifier cls, final StructuredProperty property, final SModelElement from,
			final SModelElement to) {
		final String id = idCache.uniqueId(property,
				getLocalName(cls) + ".structured-property." + getLocalName(property));
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

	public boolean isDiagramVocabulary(final Ontology o) {
		String iri = o.getIri();
		return Objects.equal(iri, diagramIRI);
	}

	public boolean isDiagramAnnotation(final Annotation a) {
		final EObject c = a.getProperty().eContainer();
		if (c instanceof IdentifiedElement) {
			String iri = OmlRead.getIri((IdentifiedElement) c);
			return Objects.equal(iri, diagramIRI);
		}
		return false;
	}

	public Iterable<Annotation> getDiagramAnnotations(final EObject eObject) {
		Iterable<Annotation> annotations = semantic2diagramAnnotations.get(eObject);
		if (annotations == null) {
			if (eObject instanceof AnnotatedElement) {
				AnnotatedElement ae = (AnnotatedElement) eObject;
				annotations = IterableExtensions.filter(ae.getOwnedAnnotations(),
						a -> Boolean.valueOf(isDiagramAnnotation(a)));
			} else if (eObject instanceof Reference) {
				Reference r = (Reference) eObject;
				annotations = IterableExtensions.filter(r.getOwnedAnnotations(),
						a -> Boolean.valueOf(isDiagramAnnotation(a)));
			} else
				throw new IllegalArgumentException(
						"No diagram annotations for eObject of type: " + eObject.eClass().getName());
		}
		return annotations;
	}

	private <E extends SModelElement> E newSElement(final Class<E> diagramElementClass, final String idStr,
			final String typeStr) {
		E e = newLeafSElement(diagramElementClass, idStr, typeStr);
		e.setChildren(new ArrayList<>());
		return e;
	}

	private <E extends SModelElement> E newLeafSElement(final Class<E> diagramElementClass, final String idStr,
			final String typeStr) {
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

	public OmlEdge newEdge(final SModelElement fromElement, final SModelElement toElement, final String edgeId,
			final String edgeType) {
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

	private String getLocalName(final Element element) {
		if (element instanceof IdentifiedElement) {
			return OmlRead.getNameIn(((IdentifiedElement) element), ontology);
		} else if (element instanceof Reference) {
			return OmlRead.getResolvedName(((Reference) element));
		} else
			throw new IllegalArgumentException("No local name for element of kind: " + element.eClass().getName());
	}
}
