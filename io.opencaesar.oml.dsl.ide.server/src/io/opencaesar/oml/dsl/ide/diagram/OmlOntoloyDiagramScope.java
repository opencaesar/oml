package io.opencaesar.oml.dsl.ide.diagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.PropertyCardinalityRestrictionAxiom;
import io.opencaesar.oml.PropertyRangeRestrictionAxiom;
import io.opencaesar.oml.PropertyValueRestrictionAxiom;
import io.opencaesar.oml.Relation;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.SemanticProperty;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.util.OmlRead;
import io.opencaesar.oml.util.OmlSearch;
import io.opencaesar.oml.util.OmlSwitch;

class OmlOntoloyDiagramScope {

	private enum Mode {
		// Find all classifiers
		Phase1,
		// Find which properties (incl. inherited) must be included
		Phase2
	}

	private Mode mode;
	private final Ontology ontology;
	private final DiagramVisitor visitor;

	private final Set<Ontology> allImportedOntologies;
	private final Set<Element> allImportedElements;

	private final Map<Aspect, Set<Element>> aspects;
	private final Map<Concept, Set<Element>> concepts;
	private final Map<RelationEntity, Set<Element>> relationEntities;
	private final Map<RelationEntity, Set<Element>> relationIncidentElements;
	private final Map<Scalar, Set<Element>> scalars;
	private final Map<Structure, Set<Element>> structures;
	private final Set<SemanticProperty> allSemanticProperties;

	final Map<Classifier, Set<ScalarProperty>> scalarProperties;
	final Map<Classifier, Set<StructuredProperty>> structuredProperties;
	final Map<Entity, Set<Axiom>> entityAxioms;

	// For a ConceptInstance or RelationInstance, the set of Assertions or
	// RelationInstances.
	final Map<NamedInstance, Set<Element>> instanceAssertions;

	private final Map<StructureInstance, Set<Assertion>> structureAssertions;
	private final Set<Element> secondPhase;

	public OmlOntoloyDiagramScope(final Ontology ontology) {
		this.mode = Mode.Phase1;
		this.ontology = ontology;
		this.visitor = new DiagramVisitor();
		this.allImportedOntologies = new HashSet<>();
		this.allImportedElements = new HashSet<>();
		this.aspects = new HashMap<>();
		this.concepts = new HashMap<>();
		this.relationEntities = new HashMap<>();
		this.relationIncidentElements = new HashMap<>();
		this.scalars = new HashMap<>();
		this.structures = new HashMap<>();
		this.scalarProperties = new HashMap<>();
		this.structuredProperties = new HashMap<>();
		this.allSemanticProperties = new HashSet<>();
		this.entityAxioms = new HashMap<>();
		this.instanceAssertions = new HashMap<>();
		this.structureAssertions = new HashMap<>();
		this.secondPhase = new HashSet<>();
	}

	private boolean includes(final EObject e) {
		if (e instanceof Aspect) {
			return aspects.containsKey((Aspect) e);
		} else if (e instanceof Concept) {
			return concepts.containsKey((Concept) e);
		} else if (e instanceof RelationEntity) {
			return relationEntities.containsKey((RelationEntity) e);
		} else if (e instanceof Scalar) {
			return scalars.containsKey((Scalar) e);
		} else if (e instanceof Structure) {
			return structures.containsKey((Structure) e);
		} else if (e instanceof SemanticProperty) {
			return allSemanticProperties.contains((SemanticProperty) e);
		} else if (e instanceof NamedInstance) {
			return instanceAssertions.containsKey((NamedInstance) e);
		} else if (e instanceof StructureInstance) {
			return structureAssertions.containsKey((StructureInstance) e);
		} else if (e instanceof SpecializationAxiom) {
			SpecializationAxiom ax = (SpecializationAxiom) e;
			return includes(ax.getSuperTerm()) && includes(ax.getOwningTerm());
		} else
			return false;
	}

	public boolean classifierHasPropertiesOrEdges(Classifier cls) {
		final boolean hasPropertiesOrEdges = !scalarProperties.get(cls).isEmpty() || !structuredProperties.get(cls).isEmpty() || !entityAxioms.get(cls).isEmpty();
		if (cls instanceof RelationEntity) {
			final RelationEntity re = (RelationEntity) cls;
			return hasPropertiesOrEdges || !relationIncidentElements.get(re).isEmpty();
		} else
			return hasPropertiesOrEdges;
	}

	private void analyze1Ontology(Ontology o) {
		if (null != o) {
			allImportedOntologies.add(o);
			TreeIterator<EObject> i = o.eAllContents();
			while (i.hasNext()) {
				EObject obj = i.next();
				if (obj instanceof Axiom || obj instanceof Type || obj instanceof SemanticProperty || obj instanceof NamedInstance || obj instanceof Assertion)
					allImportedElements.add((Element) obj);
			}
		}
	}

	public OmlOntoloyDiagramScope analyze() {
		analyze1Ontology(ontology);
		OmlRead.getAllImports(ontology).forEach(i -> {
			Ontology o = OmlRead.getImportedOntology(i);
			analyze1Ontology(o);
		});

		for (Iterator<EObject> i = ontology.eAllContents(); i.hasNext();) {
			EObject obj = i.next();
			if (obj instanceof Element) {
				visitor.doSwitch((Element) obj);
			}
		}
		mode = Mode.Phase2;
		secondPhase.forEach(e -> visitor.doSwitch(e));
		return this;
	}

	public Set<Element> scope() {
		Set<Element> s = new HashSet<>();
		s.addAll(aspects.keySet());
		s.addAll(concepts.keySet());
		s.addAll(scalars.keySet());
		s.addAll(structures.keySet());
		s.addAll(relationEntities.keySet());
		s.addAll(instanceAssertions.keySet());
		s.addAll(structureAssertions.keySet());
		return s;
	}

	private void phase1InitializeEntity(final Entity e) {
		phase1InitializeClassifierProperties(e);
		if (!entityAxioms.containsKey(e)) {
			entityAxioms.put(e, new HashSet<>());
		}
	}

	private void phase1InitializeClassifierProperties(final Classifier cls) {
		if (!scalarProperties.containsKey(cls)) {
			scalarProperties.put(cls, new HashSet<>());
		}
		if (!structuredProperties.containsKey(cls)) {
			structuredProperties.put(cls, new HashSet<>());
		}
		OmlSearch.findAllSuperTerms(cls, true).stream().map(t -> (Classifier) t).flatMap(c -> OmlSearch.findSemanticPropertiesWithDomain(c).stream()).filter(p -> allImportedElements.contains(p))
				.forEach(p -> allSemanticProperties.add(p));
	}

	private void phase2AddClassifierScalarProperty(final Classifier cls, final ScalarProperty p) {
		scalarProperties.get(cls).add(p);
	}

	private void phase2AdClassifierStructuredProperty(final Classifier cls, final StructuredProperty p) {
		structuredProperties.get(cls).add(p);
	}

	private void phase2ScanAllClassifierProperties(final Classifier cls) {
		OmlSearch.findAllSuperTerms(cls, true).stream().map(t -> (Classifier) t).forEach(parent -> {
			OmlSearch.findSemanticPropertiesWithDomain(parent).forEach(p -> {
				if (allImportedElements.contains(p)) {
					if (p instanceof ScalarProperty) {
						ScalarProperty sp = (ScalarProperty) p;
						if (includes(parent)) {
							phase2AddClassifierScalarProperty(parent, sp);
						} else {
							phase2AddClassifierScalarProperty(cls, sp);
						}
					} else if (p instanceof StructuredProperty) {
						StructuredProperty sp = (StructuredProperty) p;
						if (includes(parent)) {
							phase2AdClassifierStructuredProperty(parent, sp);
						} else {
							phase2AdClassifierStructuredProperty(cls, sp);
						}
					}
				}
			});
		});
	}

	private void phase1ScanEntityAxioms(final Entity e, final Set<Element> others) {
		OmlSearch.findKeyAxioms(e).forEach(ax -> {
			if (allImportedElements.contains(ax)) {
				others.add(ax);
			}
		});
		OmlSearch.findSpecializationAxiomsWithSubTerm(e).forEach(ax -> {
			if (allImportedElements.contains(ax)) {
				others.add(ax);
			}
		});
		OmlSearch.findPropertyRestrictionAxioms(e).forEach(ax -> {
			if (allImportedElements.contains(ax)) {
				others.add(ax);
			}
		});
	}

	private void phase2FilterEntityAxioms(final Entity e, final Set<Element> others) {
		final Set<Axiom> ax = entityAxioms.get(e);
		others.forEach(o -> {
			if (o instanceof KeyAxiom) {
				KeyAxiom x = (KeyAxiom) o;
				if (x.getProperties().stream().allMatch(p -> includes(p))) {
					ax.add(x);
				}
			} else if (o instanceof SpecializationAxiom) {
				SpecializationAxiom x = (SpecializationAxiom) o;
				if (includes(x.getSuperTerm())) {
					ax.add(x);
				}
			} else if (o instanceof PropertyRangeRestrictionAxiom) {
				PropertyRangeRestrictionAxiom x = (PropertyRangeRestrictionAxiom) o;
				boolean needToCheckRange = x.getProperty() instanceof Relation && x.getRange() != null;
				if (includes(x.getProperty()) && (!needToCheckRange || includes(x.getRange()))) {
					ax.add(x);
				}
			} else if (o instanceof PropertyCardinalityRestrictionAxiom) {
				PropertyCardinalityRestrictionAxiom x = (PropertyCardinalityRestrictionAxiom) o;
				boolean needToCheckRange = x.getProperty() instanceof Relation && x.getRange() != null;
				if (includes(x.getProperty()) && (!needToCheckRange || includes(x.getRange()))) {
					ax.add(x);
				}
			} else if (o instanceof PropertyValueRestrictionAxiom) {
				PropertyValueRestrictionAxiom x = (PropertyValueRestrictionAxiom) o;
				boolean needToCheckRange = x.getProperty() instanceof Relation;
				if (includes(x.getProperty()) && (!needToCheckRange || includes(x.getValue()))) {
					ax.add(x);
				}
			}
		});
	}

	private class DiagramVisitor extends OmlSwitch<OmlOntoloyDiagramScope> {

		@Override
		public OmlOntoloyDiagramScope doSwitch(EObject eObject) {
			OmlOntoloyDiagramScope result = OmlOntoloyDiagramScope.this;
			switch (mode) {
			case Phase1:
				if (!includes(eObject)) {
					result = super.doSwitch(eObject);
				}
				break;
			case Phase2:
				result = super.doSwitch(eObject);
				break;
			}
			return result;
		}

		public OmlOntoloyDiagramScope caseAspect(Aspect a) {
			a = (Aspect) a.resolve();
			switch (mode) {
			case Phase1:
				phase1InitializeEntity(a);
				if (!aspects.containsKey(a)) {
					aspects.put(a, new HashSet<>());
				}
				final Set<Element> others = aspects.get(a);
				phase1ScanEntityAxioms(a, others);
				secondPhase.add(a);
				break;
			case Phase2:
				phase2ScanAllClassifierProperties(a);
				phase2FilterEntityAxioms(a, aspects.get(a));
				break;
			}
			return OmlOntoloyDiagramScope.this;
		}

		public OmlOntoloyDiagramScope caseConcept(Concept c) {
			c = (Concept) c.resolve();
			switch (mode) {
			case Phase1:
				phase1InitializeEntity(c);
				if (!concepts.containsKey(c)) {
					concepts.put(c, new HashSet<>());
				}
				final Set<Element> others = concepts.get(c);
				phase1ScanEntityAxioms(c, others);
				secondPhase.add(c);
				break;
			case Phase2:
				phase2ScanAllClassifierProperties(c);
				phase2FilterEntityAxioms(c, concepts.get(c));
				break;
			}
			return OmlOntoloyDiagramScope.this;
		}

		public OmlOntoloyDiagramScope caseRelationEntity(RelationEntity e) {
			e = (RelationEntity) e.resolve();
			switch (mode) {
			case Phase1:
				phase1InitializeEntity(e);
				if (!relationEntities.containsKey(e)) {
					relationEntities.put(e, new HashSet<>());
				}
				if (!relationIncidentElements.containsKey(e)) {
					relationIncidentElements.put(e, new HashSet<>());
				}
				Set<Element> others = relationEntities.get(e);
				Set<Element> incident = relationIncidentElements.get(e);
				phase1ScanEntityAxioms(e, others);
				doSwitch(e.getSources().get(0));
				doSwitch(e.getTargets().get(0));
				OmlSearch.findSpecializationAxiomsWithSuperTerm(e).forEach(ax -> {
					if (allImportedElements.contains(ax)) {
						incident.add(ax);
					}
				});
				OmlSearch.findPropertyRangeRestrictionAxiomsWithRange(e).forEach(ax -> {
					if (allImportedElements.contains(ax)) {
						incident.add(ax);
					}
				});
				OmlSearch.findSourceRelations(e).forEach(r -> {
					if (allImportedElements.contains(r)) {
						incident.add(r);
					}
				});
				OmlSearch.findTargetRelations(e).forEach(r -> {
					if (allImportedElements.contains(r)) {
						incident.add(r);
					}
				});
				secondPhase.add(e);
				break;
			case Phase2:
				phase2ScanAllClassifierProperties(e);
				phase2FilterEntityAxioms(e, relationEntities.get(e));
				break;
			}
			return OmlOntoloyDiagramScope.this;
		}

		public OmlOntoloyDiagramScope caseScalar(Scalar s) {
			s = (Scalar) s.resolve();
			switch (mode) {
			case Phase1:
				if (!scalars.containsKey(s)) {
					scalars.put(s, new HashSet<>());
				}
				break;
			case Phase2:
				break;
			}
			return OmlOntoloyDiagramScope.this;
		}

		public OmlOntoloyDiagramScope caseStructure(Structure s) {
			s = (Structure) s.resolve();
			switch (mode) {
			case Phase1:
				phase1InitializeClassifierProperties(s);
				if (!structures.containsKey(s)) {
					structures.put(s, new HashSet<>());
				}
				secondPhase.add(s);
				break;
			case Phase2:
				phase2ScanAllClassifierProperties(s);
				break;
			}
			return OmlOntoloyDiagramScope.this;
		}

		public void phase1ScanInstanceAssertions(final NamedInstance i, final Set<Element> others) {
			OmlSearch.findPropertyValueAssertionsWithSubject(i).forEach(ax -> {
				if (allImportedElements.contains(ax)) {
					others.add(ax);
				}
			});
			OmlSearch.findRelationInstancesWithSource(i).forEach(ri -> {
				if (allImportedElements.contains(ri)) {
					others.add(ri);
				}
			});
		}

		public OmlOntoloyDiagramScope caseConceptInstance(ConceptInstance ci) {
			ci = (ConceptInstance) ci.resolve();
			switch (mode) {
			case Phase1:
				if (!instanceAssertions.containsKey(ci)) {
					instanceAssertions.put(ci, new HashSet<>());
				}
				final Set<Element> others = instanceAssertions.get(ci);
				phase1ScanInstanceAssertions(ci, others);
				break;
			case Phase2:
				break;
			}
			return OmlOntoloyDiagramScope.this;
		}

		public OmlOntoloyDiagramScope caseRelationInstance(RelationInstance ri) {
			ri = (RelationInstance) ri.resolve();
			switch (mode) {
			case Phase1:
				if (!instanceAssertions.containsKey(ri)) {
					instanceAssertions.put(ri, new HashSet<>());
				}
				final Set<Element> others = instanceAssertions.get(ri);
				phase1ScanInstanceAssertions(ri, others);
				break;
			case Phase2:
				break;
			}
			return OmlOntoloyDiagramScope.this;
		}

		public OmlOntoloyDiagramScope caseStructureInstance(final StructureInstance si) {
			switch (mode) {
			case Phase1:
				if (!structureAssertions.containsKey(si)) {
					structureAssertions.put(si, new HashSet<>());
				}
				break;
			case Phase2:
				break;
			}
			return OmlOntoloyDiagramScope.this;
		}

	}
}
