package io.opencaesar.oml.dsl.ide.diagram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sprotty.SModelElement;
import org.eclipse.sprotty.SModelRoot;
import org.eclipse.sprotty.xtext.IDiagramGenerator;
import org.eclipse.sprotty.xtext.SIssueMarkerDecorator;
import org.eclipse.sprotty.xtext.tracing.ITraceProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.inject.Inject;

import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyValueAssertion;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlCompartment;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlEdge;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlGraph;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlLabel;
import io.opencaesar.oml.dsl.ide.diagram.model.OmlNode;
import io.opencaesar.oml.util.OmlRead;
import io.opencaesar.oml.util.OmlSwitch;

class OmlDiagramViewGenerator extends OmlSwitch<SModelElement> implements IDiagramGenerator {

	private static final Logger LOG = Logger.getLogger(OmlDiagramViewGenerator.class);

	@Inject
	private ITraceProvider traceProvider;

	@Inject
	private SIssueMarkerDecorator _sIssueMarkerDecorator;

	private IDiagramGenerator.Context context;

	private OmlOntologyDiagramView view;

	private OmlGraph graph;

	private OmlNode frame;

	private Map<Element, SModelElement> semantic2diagram;

	private OmlOntoloyDiagramScope scope;

	@Override
	public SModelRoot generate(final IDiagramGenerator.Context context) {
		try {
			this.context = context;
			this.semantic2diagram = new HashMap<>();

			final Ontology ontology = OmlRead.getOntology(context.getResource());
			LOG.info("generate: " + ontology.getIri());

			this.view = new OmlOntologyDiagramView(ontology, context.getIdCache());
			this.graph = view.createGraph();

			this.frame = (OmlNode) doSwitch(ontology);

			this.scope = new OmlOntoloyDiagramScope(ontology).analyze();
			this.scope.scope().forEach(e -> doSwitch(e));
			this.scope.entityAxioms.forEach((e, axs) -> {
				axs.forEach(ax -> showAxiom(e, ax));
			});

			return this.graph;
		} catch (final Throwable t) {
			if (t instanceof Exception) {
				final Exception e = (Exception) t;
				LOG.log(Level.ERROR, "exception", e);
				return null;
			} else {
				throw Exceptions.sneakyThrow(t);
			}
		}
	}

	@Override
	public SModelElement doSwitch(final EObject eObject) {
		if (null == eObject)
			return null;

		SModelElement s = semantic2diagram.get(eObject);
		if (null != s)
			return s;
		else
			return super.doSwitch(eObject);
	}

	@Override
	public SModelElement caseOntology(final Ontology o) {
		final OmlNode node = view.createNode(o);
		graph.getChildren().add(node);
		traceAndMark(node, o, context);

		if ("NONE".equals(context.getState().getCurrentModel().getType())) {
			context.getState().getExpandedElements().add(node.getId());
		}
		node.setExpanded(context.getState().getExpandedElements().contains(node.getId()));

		// This will transitively show all imports since caseImport() below visits the
		// imported ontology.
		// OmlRead.getImportsWithSource(o).forEach(i -> doSwitch(i));

		return node;
	}

	@Override
	public SModelElement caseImport(final Import i) {
		final Ontology importingOntology = OmlRead.getImportingOntology(i);
		final Ontology importedOntology = OmlRead.getImportedOntology(i);
		if (null != importingOntology && null != importedOntology && !view.isViewpointVocabulary(importedOntology)) {
			final OmlNode importingNode = (OmlNode) doSwitch(importingOntology);
			final OmlNode importedNode = (OmlNode) doSwitch(importedOntology);
			if (null != importingNode && null != importedNode) {
				final OmlEdge edge = view.createEdge(i, importingNode, importedNode);
				graph.getChildren().add(edge);
				return edge;
			}
		}
		return null;
	}

	@Override
	public SModelElement caseAspect(final Aspect aspect) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(aspect);
		if (null != s)
			return s;

		final OmlNode node = view.createNode(aspect);

		frame.getChildren().add(node);
		traceAndMark(node, aspect, context);
		addClassifierFeatures(aspect, node);
		return node;
	}

	@Override
	public SModelElement caseConcept(final Concept concept) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(concept);
		if (null != s)
			return s;

		final OmlNode node = view.createNode(concept);

		frame.getChildren().add(node);
		traceAndMark(node, concept, context);
		addClassifierFeatures(concept, node);
		return node;
	}

	@Override
	public SModelElement caseRelationEntity(final RelationEntity entity) {
		if (!isFrameExpanded())
			return null;

		final SModelElement es = semantic2diagram.get(entity);
		if (null != es)
			return es;

		// TEMPORARY
		if (entity.getSources().size() != 1 || entity.getTargets().size() != 1)
			return null;
		
		final Entity s = entity.getSources().get(0);
		final Entity t = entity.getTargets().get(0);

		final List<KeyAxiom> keys = scope.entityAxioms.get(entity).stream().filter(a -> a instanceof KeyAxiom).map(a -> (KeyAxiom) a).collect(Collectors.toList());

		if (entity == s) {
			final SModelElement ts = doSwitch(t);
			if (null != ts) {
				final OmlNode node = view.createSourceNode(entity, ts);
				frame.getChildren().add(node);
				traceAndMark(node, entity, context);
				addClassifierFeatures(entity, node);
				return node;
			}
		} else if (entity == t) {
			final SModelElement ss = doSwitch(s);
			if (null != ss) {
				final OmlNode node = view.createTargetNode(entity, ss);
				frame.getChildren().add(node);
				traceAndMark(node, entity, context);
				addClassifierFeatures(entity, node);
				return node;
			}
		} else {
			final SModelElement ss = doSwitch(s);
			final SModelElement ts = doSwitch(t);
			if (null != ss && null != ts) {
				if (scope.classifierHasPropertiesOrEdges(entity) || !keys.isEmpty()) {
					final OmlNode node = view.createNode(entity, ss, ts);
					frame.getChildren().add(node);
					traceAndMark(node, entity, context);
					addClassifierFeatures(entity, node);
					return node;
				} else {
					final OmlEdge edge = view.createEdge(entity, ss, ts);
					frame.getChildren().add(edge);
					traceAndMark(edge, entity, context);
					return edge;
				}
			}
		}

		return null;
	}

	@Override
	public SModelElement caseStructure(final Structure structure) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(structure);
		if (null != s)
			return s;

		final OmlNode node = view.createNode(structure);
		frame.getChildren().add(node);
		traceAndMark(node, structure, context);
		addClassifierFeatures(structure, node);
		return node;
	}

	@Override
	public SModelElement caseScalar(final Scalar scalar) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(scalar);
		if (null != s)
			return s;

		final OmlNode node = view.createNode(scalar);
		frame.getChildren().add(node);
		traceAndMark(node, scalar, context);
		return node;
	}

	@Override
	public SModelElement caseRule(final Rule rule) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(rule);
		if (null != s)
			return s;

		final OmlNode node = view.createNode(rule);
		frame.getChildren().add(node);
		traceAndMark(node, rule, context);
		return node;
	}

	@Override
	public SModelElement caseConceptInstance(final ConceptInstance ci) {
		if (!isFrameExpanded())
			return null;

		final OmlNode node = view.createNode(ci);
		frame.getChildren().add(node);
		traceAndMark(node, ci, context);
		return node;
	}

	@Override
	public SModelElement caseRelationInstance(final RelationInstance ri) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(ri);
		if (null != s)
			return s;

		if (ri.getSources().size() == 1 && ri.getTargets().size() == 1) {
			final SModelElement source = doSwitch(ri.getSources().get(0));
			final SModelElement target = doSwitch(ri.getTargets().get(0));
			if (null != source && null != target) {
				if (!scope.instanceAssertions.get(ri).isEmpty()) {
					final OmlNode node = view.createNode(ri, source, target);
					frame.getChildren().add(node);
					traceAndMark(node, ri, context);
					addInstanceFeatures(ri, node);
					return node;
				} else {
					final OmlEdge edge = view.createEdge(ri, source, target);
					frame.getChildren().add(edge);
					traceAndMark(edge, ri, context);
					return edge;
				}
			}
		}
		return null;
	}

	private void showAxiom(final Entity e, final Axiom ax) {
		if (!isFrameExpanded())
			return;

		if (ax instanceof SpecializationAxiom) {
			showAxiomInternal(e, (SpecializationAxiom) ax);
		} else if (ax instanceof KeyAxiom) {
			showAxiomInternal(e, (KeyAxiom) ax);
		} else if (ax instanceof PropertyRangeRestrictionAxiom) {
			PropertyRangeRestrictionAxiom axiom = (PropertyRangeRestrictionAxiom) ax;
			SemanticProperty p = axiom.getProperty();
			if (p instanceof ScalarProperty)
				showScalarRangeAxiomInternal(e, axiom);
			else if (p instanceof StructuredProperty)
				showStructuredRangeAxiomInternal(e, axiom);
			if (p instanceof Relation)
				showRelationRangeAxiomInternal(e, axiom);
		} else if (ax instanceof PropertyCardinalityRestrictionAxiom) {
			PropertyCardinalityRestrictionAxiom axiom = (PropertyCardinalityRestrictionAxiom) ax;
			SemanticProperty p = axiom.getProperty();
			if (p instanceof ScalarProperty)
				showScalarCardinalityAxiomInternal(e, axiom);
			if (p instanceof StructuredProperty)
				showStructuredCardinalityAxiomInternal(e, axiom);
			if (p instanceof Relation)
				showRelationCardinalityAxiomInternal(e, axiom);
		} else if (ax instanceof PropertyValueRestrictionAxiom) {
			PropertyValueRestrictionAxiom axiom = (PropertyValueRestrictionAxiom) ax;
			SemanticProperty p = axiom.getProperty();
			if (p instanceof ScalarProperty)
				showScalarValueAxiomInternal(e, axiom);
			if (p instanceof StructuredProperty)
				showStructuredValueAxiomInternal(e, axiom);
			if (p instanceof Relation)
				showRelationValueAxiomInternal(e, axiom);
		} else {
			throw new IllegalArgumentException("showAxiom: unhandled case for entity: " + e.eClass().getName() + " and axiom: " + ax.eClass().getName());
		}
	}

	private void showAxiomInternal(final Entity e, final SpecializationAxiom ax) {
		final SModelElement specializingNode = semantic2diagram.get(e);
		if (null == specializingNode)
			throw new IllegalArgumentException("no entity node for showAxiom(SpecializationAxiom): " + e.getAbbreviatedIri());
		final SModelElement specializedNode = semantic2diagram.get(ax.getSuperTerm());
		if (null == specializedNode)
			throw new IllegalArgumentException("no entity node for showAxiom(SpecializationAxiom): " + ax.getSuperTerm().getAbbreviatedIri());
		final OmlEdge edge = view.createEdge(ax, specializingNode, specializedNode);
		frame.getChildren().add(edge);
		traceAndMark(edge, ax, context);
	}

	private void showAxiomInternal(final Entity e, final KeyAxiom ax) {
		final SModelElement node = semantic2diagram.get(e);
		if (null == node)
			throw new IllegalArgumentException("no entity node for showAxiom(KeyAxiom): " + e.getAbbreviatedIri());
		OmlCompartment compartment = view.getAxiomCompartment(node);
		if (null == compartment) {
			compartment = view.createAxiomCompartment(e);
			node.getChildren().add(compartment);
		}
		final OmlLabel label = view.createLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	private void showScalarRangeAxiomInternal(final Entity e, final PropertyRangeRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(ScalarPropertyRangeRestrictionAxiom) " + e.getAbbreviatedIri());
		OmlCompartment compartment = view.getAxiomCompartment(source);
		if (null == compartment) {
			compartment = view.createAxiomCompartment(e);
			source.getChildren().add(compartment);
		}
		final OmlLabel label = view.createScalarRangeLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	private void showStructuredRangeAxiomInternal(final Entity e, final PropertyRangeRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(StructuredPropertyRangeRestrictionAxiom) " + e.getAbbreviatedIri());
		OmlCompartment compartment = view.getAxiomCompartment(source);
		if (null == compartment) {
			compartment = view.createAxiomCompartment(e);
			source.getChildren().add(compartment);
		}
		final OmlLabel label = view.createStructuredRangeLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	private void showRelationRangeAxiomInternal(final Entity e, final PropertyRangeRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationRangeRestrictionAxiom): " + e.getAbbreviatedIri());
		final SModelElement target = semantic2diagram.get(ax.getRange());
		if (null == target)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationRangeRestrictionAxiom): " + ax.getRange().getAbbreviatedIri());
		final OmlEdge edge = view.createEdge(ax, source, target);
		frame.getChildren().add(edge);
		traceAndMark(edge, ax, context);
	}

	private void showScalarCardinalityAxiomInternal(final Entity e, final PropertyCardinalityRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(ScalarPropertyCardinalityRestrictionAxiom) " + e.getAbbreviatedIri());
		OmlCompartment compartment = view.getAxiomCompartment(source);
		if (null == compartment) {
			compartment = view.createAxiomCompartment(e);
			source.getChildren().add(compartment);
		}
		final OmlLabel label = view.createScalarCardinalityLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	private void showStructuredCardinalityAxiomInternal(final Entity e, final PropertyCardinalityRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(StructuredPropertyCardinalityRestrictionAxiom) " + e.getAbbreviatedIri());
		OmlCompartment compartment = view.getAxiomCompartment(source);
		if (null == compartment) {
			compartment = view.createAxiomCompartment(e);
			source.getChildren().add(compartment);
		}
		final OmlLabel label = view.createStructuredCardinalityLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	private void showRelationCardinalityAxiomInternal(final Entity e, final PropertyCardinalityRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationCardinalityRestrictionAxiom): " + e.getAbbreviatedIri());
		final SModelElement target = semantic2diagram.get(ax.getProperty().getRangeList().get(0));
		if (null == target)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationCardinalityRestrictionAxiom): " + ax.getProperty().getAbbreviatedIri());
		final OmlEdge edge = view.createEdge(ax, source, target);
		frame.getChildren().add(edge);
		traceAndMark(edge, ax, context);
	}

	private void showScalarValueAxiomInternal(final Entity e, final PropertyValueRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(ScalarPropertyValueRestrictionAxiom) " + e.getAbbreviatedIri());
		OmlCompartment compartment = view.getAxiomCompartment(source);
		if (null == compartment) {
			compartment = view.createAxiomCompartment(e);
			source.getChildren().add(compartment);
		}
		final OmlLabel label = view.createScalarValueLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	private void showStructuredValueAxiomInternal(final Entity e, final PropertyValueRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(StructuredPropertyValueRestrictionAxiom) " + e.getAbbreviatedIri());
		OmlCompartment compartment = view.getAxiomCompartment(source);
		if (null == compartment) {
			compartment = view.createAxiomCompartment(e);
			source.getChildren().add(compartment);
		}
		final OmlLabel label = view.createStructuredValueLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	private void showRelationValueAxiomInternal(final Entity e, final PropertyValueRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationTargetRestrictionAxiom): " + e.getAbbreviatedIri());
		final SModelElement target = semantic2diagram.get(ax.getValue());
		if (null == target)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationTargetRestrictionAxiom): " + ax.getNamedInstanceValue().getAbbreviatedIri());
		final OmlEdge edge = view.createEdge(ax, source, target);
		frame.getChildren().add(edge);
		traceAndMark(edge, ax, context);
	}

	// HELPERS

	private boolean isFrameExpanded() {
		Boolean b = frame.getExpanded();
		return (null == b) || b.booleanValue();
	}

	private void addClassifierFeatures(final Classifier cls, final OmlNode node) {
		scope.scalarProperties.get(cls).stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).forEach(f -> {
			if (null == semantic2diagram.get(f)) {
				OmlCompartment compartment = view.getPropertyCompartment(node);
				if (null == compartment) {
					compartment = view.createPropertyCompartment(cls);
					node.getChildren().add(compartment);
				}
				final OmlLabel label = view.createLabel(cls, f);
				compartment.getChildren().add(label);
				traceAndMark(label, f, context);
			}
		});
		scope.structuredProperties.get(cls).stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).forEach(f -> {
			if (null == semantic2diagram.get(f)) {
				final SModelElement source = doSwitch(cls);
				final SModelElement target = doSwitch(f.getRanges().get(0));
				final OmlEdge edge = view.createEdge(cls, f, source, target);
				frame.getChildren().add(edge);
				traceAndMark(edge, f, context);
			}
		});
	}

	private void addInstanceFeatures(final NamedInstance i, final OmlNode node) {
		scope.instanceAssertions.get(i).forEach(a -> {
			if (a instanceof PropertyValueAssertion) {
				if (null == semantic2diagram.get(a)) {
					PropertyValueAssertion ax = (PropertyValueAssertion) a;
					OmlCompartment compartment = view.getPropertyCompartment(node);
					if (null == compartment) {
						compartment = view.createPropertyCompartment(i);
						node.getChildren().add(compartment);
					}
					final OmlLabel label = view.createLabel(i, ax);
					compartment.getChildren().add(label);
					traceAndMark(label, a, context);
				}
			}
		});
	}

	private <T extends SModelElement> T traceAndMark(final T sElement, final Element element, final IDiagramGenerator.Context context) {
		semantic2diagram.put(element, sElement);
		return _sIssueMarkerDecorator.addIssueMarkers(traceProvider.trace(sElement, element), element, context);
	}
}
