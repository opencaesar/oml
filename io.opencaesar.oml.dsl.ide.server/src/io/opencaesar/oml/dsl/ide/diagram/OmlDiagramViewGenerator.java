package io.opencaesar.oml.dsl.ide.diagram;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sprotty.SModelElement;
import org.eclipse.sprotty.SModelRoot;
import org.eclipse.sprotty.xtext.IDiagramGenerator;
import org.eclipse.sprotty.xtext.SIssueMarkerDecorator;
import org.eclipse.sprotty.xtext.tracing.ITraceProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
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
import io.opencaesar.oml.Predicate;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationPredicate;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationTargetRestrictionAxiom;
import io.opencaesar.oml.Rule;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarPropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyRangeRestrictionAxiom;
import io.opencaesar.oml.ScalarPropertyValueAssertion;
import io.opencaesar.oml.ScalarPropertyValueRestrictionAxiom;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.util.OmlRead;
import io.opencaesar.oml.util.OmlVisitor;

public class OmlDiagramViewGenerator extends OmlVisitor<SModelElement> implements IDiagramGenerator {

	static final Logger LOG = Logger.getLogger(OmlDiagramViewGenerator.class);

	@Inject
	@Extension
	private ITraceProvider traceProvider;

	@Inject
	@Extension
	private SIssueMarkerDecorator _sIssueMarkerDecorator;

	@Extension
	private IDiagramGenerator.Context context;

	@Extension
	private OmlOntologyDiagramView view;

	private OmlGraph graph;

	private OmlNode frame;

	private Map<Element, SModelElement> semantic2diagram;

	public SModelRoot generate(final IDiagramGenerator.Context context) {
		try {
			this.context = context;
			this.semantic2diagram = new HashMap<>();

			final Ontology ontology = OmlRead.getOntology(context.getResource());
			LOG.info("generate: " + ontology.getIri());

			this.view = new OmlOntologyDiagramView(ontology, context.getIdCache());
			this.graph = view.createGraph();

			this.frame = (OmlNode) doSwitch(ontology);

			this.view.scope.scope().forEach(e -> doSwitch(e));
			this.view.scope.entityAxioms.forEach((e, axs) -> {
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

	public SModelElement doSwitch(final EObject eObject) {
		if (null == eObject)
			return null;
		
		SModelElement s = semantic2diagram.get(eObject);
		if (null != s)
			return s;
		else
			return super.doSwitch(eObject);
	}

	public SModelElement caseOntology(final Ontology o) {
		final OmlNode node = view.createNode(o);
		graph.getChildren().add(node);
		traceAndMark(node, o, context);
		if (Objects.equal(context.getState().getCurrentModel().getType(), "NONE")) {
			context.getState().getExpandedElements().add(node.getId());
		}
		node.setExpanded(context.getState().getExpandedElements().contains(node.getId()));

		// This will transitively show all imports since caseImport() below visits the
		// imported ontology.
		OmlRead.getImportsWithSource(o).forEach(i -> doSwitch(i));
		return node;
	}

	public SModelElement caseAspect(final Aspect aspect) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(aspect);
		if (null != s)
			return s;

		final OmlNode node = view.createNode(aspect,
				Iterables.filter(view.scope.entityAxioms.get(aspect), KeyAxiom.class));
		frame.getChildren().add(node);
		traceAndMark(node, aspect, context);
		addClassifierFeatures(aspect, node);
		return node;
	}

	public SModelElement caseConcept(final Concept concept) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(concept);
		if (null != s)
			return s;

		final OmlNode node = view.createNode(concept,
				Iterables.filter(view.scope.entityAxioms.get(concept), KeyAxiom.class));
		frame.getChildren().add(node);
		traceAndMark(node, concept, context);
		addClassifierFeatures(concept, node);
		return node;
	}

	public SModelElement caseRelationEntity(final RelationEntity entity) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(entity);
		if (null != s)
			return s;

		final SModelElement source = doSwitch(entity.getSource());
		final SModelElement target = doSwitch(entity.getTarget());
		if (null != source && null != target) {
			final Iterable<KeyAxiom> keys = Iterables.filter(view.scope.entityAxioms.get(entity), KeyAxiom.class);
			if (view.scope.classifierHasFeaturesOrEdges(entity) || !IterableExtensions.isEmpty(keys)) {
				final OmlNode node = view.createNode(entity, source, target, keys);
				frame.getChildren().add(node);
				traceAndMark(node, entity, context);
				addClassifierFeatures(entity, node);
				return node;
			} else {
				final OmlEdge edge = view.createEdge(entity, source, target);
				frame.getChildren().add(edge);
				traceAndMark(edge, entity, context);
				return edge;
			}
		}

		return null;
	}

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

	public SModelElement casePredicate(final Predicate predicate) {
		return null;
	}

	public Object caseAntecedentPredicate(final Predicate predicate) {
		return null;
	}

	public Object caseConsequentPredicate(final RelationPredicate predicate) {
		return null;
	}

	public SModelElement caseConceptInstance(final ConceptInstance ci) {
		if (!isFrameExpanded())
			return null;

		final OmlNode node = view.createNode(ci);
		frame.getChildren().add(node);
		traceAndMark(node, ci, context);
		return node;
	}

	public SModelElement caseRelationInstance(final RelationInstance ri) {
		if (!isFrameExpanded())
			return null;

		final SModelElement s = semantic2diagram.get(ri);
		if (null != s)
			return s;

		if (ri.getSources().size()==1 && ri.getTargets().size()==1) {
			final SModelElement source = doSwitch(ri.getSources().get(0));
			final SModelElement target = doSwitch(ri.getTargets().get(0));
			if (null != source && null != target) {
				if (!view.scope.instanceAssertions.get(ri).isEmpty()) {
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

	public SModelElement caseImport(final Import i) {
		final Ontology importingOntology = OmlRead.getImportingOntology(i);
		final Ontology importedOntology = OmlRead.getImportedOntology(i);
		if (null != importingOntology && null != importedOntology && !view.isDiagramVocabulary(importedOntology)) {
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

	public void showAxiom(final Entity e, final Axiom ax) {
		if (!isFrameExpanded())
			return;

		if (ax instanceof ScalarPropertyCardinalityRestrictionAxiom) {
			showAxiomInternal(e, (ScalarPropertyCardinalityRestrictionAxiom) ax);
		} else if (ax instanceof ScalarPropertyRangeRestrictionAxiom) {
			showAxiomInternal(e, (ScalarPropertyRangeRestrictionAxiom) ax);
		} else if (ax instanceof ScalarPropertyValueRestrictionAxiom) {
			showAxiomInternal(e, (ScalarPropertyValueRestrictionAxiom) ax);
		} else if (ax instanceof RelationCardinalityRestrictionAxiom) {
			showAxiomInternal(e, (RelationCardinalityRestrictionAxiom) ax);
		} else if (ax instanceof RelationRangeRestrictionAxiom) {
			showAxiomInternal(e, (RelationRangeRestrictionAxiom) ax);
		} else if (ax instanceof RelationTargetRestrictionAxiom) {
			showAxiomInternal(e, (RelationTargetRestrictionAxiom) ax);
		} else if (ax instanceof SpecializationAxiom) {
			showAxiomInternal(e, (SpecializationAxiom) ax);
		} else {
			throw new IllegalArgumentException("showAxiom: unhandled case for entity: " + e.eClass().getName()
					+ " and axiom: " + ax.eClass().getName());
		}
	}

	protected void showAxiomInternal(final Entity e, final SpecializationAxiom ax) {
		final SModelElement specializingNode = semantic2diagram.get(e);
		if (null == specializingNode)
			throw new IllegalArgumentException(
					"no entity node for showAxiom(SpecializationAxiom): " + OmlRead.getAbbreviatedIri(e));
		final SModelElement specializedNode = semantic2diagram.get(ax.getSpecializedTerm());
		if (null == specializedNode)
			throw new IllegalArgumentException("no entity node for showAxiom(SpecializationAxiom): "
					+ OmlRead.getAbbreviatedIri(ax.getSpecializedTerm()));
		final OmlEdge edge = view.createEdge(ax, specializingNode, specializedNode);
		frame.getChildren().add(edge);
		traceAndMark(edge, ax, context);
	}

	protected void showAxiomInternal(final Entity e, final ScalarPropertyCardinalityRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException(
					"no entity node for showAxiom(ScalarPropertyCardinalityRestrictionAxiom) "
							+ OmlRead.getAbbreviatedIri(e));
		OmlCompartment compartment = view.getPropertyCompartment(source);
		if (null == compartment) {
			compartment = view.createPropertyCompartment(e);
			source.getChildren().add(compartment);
		}
		final OmlLabel label = view.createLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	protected void showAxiomInternal(final Entity e, final ScalarPropertyRangeRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(ScalarPropertyRangeRestrictionAxiom) "
					+ OmlRead.getAbbreviatedIri(e));
		OmlCompartment compartment = view.getPropertyCompartment(source);
		if (null == compartment) {
			compartment = view.createPropertyCompartment(e);
			source.getChildren().add(compartment);
		}
		final OmlLabel label = view.createLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	protected void showAxiomInternal(final Entity e, final ScalarPropertyValueRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(ScalarPropertyValueRestrictionAxiom) "
					+ OmlRead.getAbbreviatedIri(e));
		OmlCompartment compartment = view.getPropertyCompartment(source);
		if (null == compartment) {
			compartment = view.createPropertyCompartment(e);
			source.getChildren().add(compartment);
		}
		final OmlLabel label = view.createLabel(e, ax);
		compartment.getChildren().add(label);
		traceAndMark(label, ax, context);
	}

	protected void showAxiomInternal(final Entity e, final RelationCardinalityRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationCardinalityRestrictionAxiom): "
					+ OmlRead.getAbbreviatedIri(e));
		final SModelElement target = semantic2diagram.get(OmlRead.getRelationEntity(ax.getRelation()).getTarget());
		if (null == target)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationCardinalityRestrictionAxiom): "
					+ OmlRead.getAbbreviatedIri(ax.getRelation()));
		final OmlEdge edge = view.createEdge(ax, source, target);
		frame.getChildren().add(edge);
		traceAndMark(edge, ax, context);
	}

	protected void showAxiomInternal(final Entity e, final RelationRangeRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException(
					"no entity node for showAxiom(RelationRangeRestrictionAxiom): " + OmlRead.getAbbreviatedIri(e));
		final SModelElement target = semantic2diagram.get(ax.getRange());
		if (null == target)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationRangeRestrictionAxiom): "
					+ OmlRead.getAbbreviatedIri(ax.getRange()));
		final OmlEdge edge = view.createEdge(ax, source, target);
		frame.getChildren().add(edge);
		traceAndMark(edge, ax, context);
	}

	protected void showAxiomInternal(final Entity e, final RelationTargetRestrictionAxiom ax) {
		final SModelElement source = semantic2diagram.get(e);
		if (null == source)
			throw new IllegalArgumentException(
					"no entity node for showAxiom(RelationTargetRestrictionAxiom): " + OmlRead.getAbbreviatedIri(e));
		final SModelElement target = semantic2diagram.get(ax.getTarget());
		if (null == target)
			throw new IllegalArgumentException("no entity node for showAxiom(RelationTargetRestrictionAxiom): "
					+ OmlRead.getAbbreviatedIri(ax.getTarget()));
		final OmlEdge edge = view.createEdge(ax, source, target);
		frame.getChildren().add(edge);
		traceAndMark(edge, ax, context);
	}

	// HELPERS

	public boolean isFrameExpanded() {
		Boolean b = frame.getExpanded();
		return (null == b) || b.booleanValue();
	}

	public void addClassifierFeatures(final Classifier cls, final OmlNode node) {
		view.scope.scalarProperties.get(cls).forEach(f -> {
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
		view.scope.structuredProperties.get(cls).forEach(f -> {
			if (null == semantic2diagram.get(f)) {
				final SModelElement source = doSwitch(cls);
				final SModelElement target = doSwitch(f.getRange());
				final OmlEdge edge = view.createEdge(cls, f, source, target);
				frame.getChildren().add(edge);
				traceAndMark(edge, f, context);
			}
		});
	}

	public void addInstanceFeatures(final NamedInstance i, final OmlNode node) {
		view.scope.instanceAssertions.get(i).forEach(a -> {
			if (a instanceof ScalarPropertyValueAssertion) {
				if (null == semantic2diagram.get(a)) {
					ScalarPropertyValueAssertion ax = (ScalarPropertyValueAssertion) a;
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

	private <T extends SModelElement> T traceAndMark(final T sElement, final Element element,
			final IDiagramGenerator.Context context) {
		semantic2diagram.put(element, sElement);
		return _sIssueMarkerDecorator.addIssueMarkers(traceProvider.trace(sElement, element), element, context);
	}
}
