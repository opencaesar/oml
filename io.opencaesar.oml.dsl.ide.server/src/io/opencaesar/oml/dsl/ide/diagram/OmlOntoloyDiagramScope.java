package io.opencaesar.oml.dsl.ide.diagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

import io.opencaesar.oml.Aspect;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.Assertion;
import io.opencaesar.oml.Axiom;
import io.opencaesar.oml.Classifier;
import io.opencaesar.oml.Concept;
import io.opencaesar.oml.ConceptInstance;
import io.opencaesar.oml.ConceptInstanceReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.FeatureProperty;
import io.opencaesar.oml.KeyAxiom;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.RelationCardinalityRestrictionAxiom;
import io.opencaesar.oml.RelationEntity;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationInstance;
import io.opencaesar.oml.RelationInstanceReference;
import io.opencaesar.oml.RelationRangeRestrictionAxiom;
import io.opencaesar.oml.RelationTargetRestrictionAxiom;
import io.opencaesar.oml.Scalar;
import io.opencaesar.oml.ScalarProperty;
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom;
import io.opencaesar.oml.SpecializationAxiom;
import io.opencaesar.oml.Structure;
import io.opencaesar.oml.StructureInstance;
import io.opencaesar.oml.StructureReference;
import io.opencaesar.oml.StructuredProperty;
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom;
import io.opencaesar.oml.Type;
import io.opencaesar.oml.util.OmlIndex;
import io.opencaesar.oml.util.OmlRead;
import io.opencaesar.oml.util.OmlSearch;
import io.opencaesar.oml.util.OmlVisitor;

public class OmlOntoloyDiagramScope {

	private enum Mode {
		// Find all classifiers
		Phase1,
		// Find which features (incl. inherited) must be included
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
	private final Set<FeatureProperty> allFeatureProperties;
	
	final Map<Classifier, Set<ScalarProperty>> scalarProperties;
	final Map<Classifier, Set<StructuredProperty>> structuredProperties;
	final Map<Entity, Set<Axiom>> entityAxioms;
	
	// For a ConceptInstance or RelationInstance, the set of Assertions or RelationInstances.
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
		this.allFeatureProperties = new HashSet<>();
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
		} else if (e instanceof FeatureProperty) {
			return allFeatureProperties.contains((FeatureProperty) e);
		} else if (e instanceof NamedInstance) {
			return instanceAssertions.containsKey((NamedInstance) e);
		} else if (e instanceof StructureInstance) {
			return structureAssertions.containsKey((StructureInstance) e);
		} else if (e instanceof SpecializationAxiom) {
			SpecializationAxiom ax = (SpecializationAxiom) e;
			return includes(ax.getSpecializedTerm()) && includes(ax.getOwningTerm());
		} else
			return false;
	}

	public boolean classifierHasFeaturesOrEdges(Classifier cls) {
		final boolean hasFeaturesOrEdges = !scalarProperties.get(cls).isEmpty() || !structuredProperties.get(cls).isEmpty()
				|| !entityAxioms.get(cls).isEmpty();
		if (cls instanceof RelationEntity) {
			final RelationEntity re = (RelationEntity) cls;
			return hasFeaturesOrEdges || !relationIncidentElements.get(re).isEmpty();
		} else
			return hasFeaturesOrEdges;
	}

	private void analyze1Ontology(Ontology o) {
		if (null != o) {
			allImportedOntologies.add(o);
			TreeIterator<EObject> i = o.eAllContents();
			while (i.hasNext()) {
				EObject obj = i.next();
				if (obj instanceof Axiom ||
					obj instanceof Type ||
					obj instanceof FeatureProperty ||
					obj instanceof NamedInstance ||
					obj instanceof Assertion)
					allImportedElements.add((Element)obj);
			}
		}
	}

	public OmlOntoloyDiagramScope analyze() {
		analyze1Ontology(ontology);
		OmlRead.getAllImportsWithSource(ontology).forEach(i -> {
			Ontology o = OmlRead.getImportedOntology(i);
			analyze1Ontology(o);
		});

		IteratorExtensions.forEach(Iterators.filter(ontology.eAllContents(), Element.class), x -> visitor.doSwitch(x));
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
		Iterables.filter(OmlSearch.findAllGeneralTermsInclusive(cls), Classifier.class).forEach(parent -> {
			OmlSearch.findFeaturePropertiesWithDomain(parent).forEach(f -> {
				if (allImportedElements.contains(f)) {
					allFeatureProperties.add(f);
				}
			});
		});
	}

	private void phase2AddClassifierScalarProperty(final Classifier cls, final ScalarProperty p) {
		scalarProperties.get(cls).add(p);
	}

	private void phase2AdClassifierStructuredProperty(final Classifier cls, final StructuredProperty p) {
		structuredProperties.get(cls).add(p);
	}

	private void phase2ScanAllClassifierProperties(final Classifier cls) {
		Iterables.filter(OmlSearch.findAllGeneralTermsInclusive(cls), Classifier.class).forEach(parent -> {
			OmlIndex.findFeaturePropertiesWithDomain(parent).forEach(p -> {
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
		OmlSearch.findKeys(e).forEach(ax -> {
			if (allImportedElements.contains(ax)) {
				others.add(ax);
			}
		});
		OmlSearch.findSpecializationAxiomsWithSpecificTerm(e).forEach(ax -> {
			if (allImportedElements.contains(ax)) {
				others.add(ax);
			}
		});
		OmlSearch.findPropertyRestrictions(e).forEach(ax -> {
			if (allImportedElements.contains(ax)) {
				others.add(ax);
			}
		});
		OmlSearch.findRelationRestrictions(e).forEach(ax -> {
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
				if (IterableExtensions.forall(x.getProperties(), p -> includes(p))) {
					ax.add(x);
				}
			} else if (o instanceof SpecializationAxiom) {
				SpecializationAxiom x = (SpecializationAxiom) o;
				if (includes(x.getSpecializedTerm())) {
					ax.add(x);
				}
			} else if (o instanceof ScalarPropertyRestrictionAxiom) {
				ScalarPropertyRestrictionAxiom x = (ScalarPropertyRestrictionAxiom) o;
				if (includes(x.getProperty())) {
					ax.add(x);
				}
			} else if (o instanceof StructuredPropertyRestrictionAxiom) {
				StructuredPropertyRestrictionAxiom x = (StructuredPropertyRestrictionAxiom) o;
				if (includes(x.getProperty())) {
					ax.add(x);
				}
			} else if (o instanceof RelationCardinalityRestrictionAxiom) {
				RelationCardinalityRestrictionAxiom x = (RelationCardinalityRestrictionAxiom) o;
				if (includes(OmlRead.getRelationEntity(x.getRelation()))) {
					ax.add(x);
				}
			} else if (o instanceof RelationRangeRestrictionAxiom) {
				RelationRangeRestrictionAxiom x = (RelationRangeRestrictionAxiom) o;
				if (includes(OmlRead.getRelationEntity(x.getRelation())) && includes(x.getRange())) {
					ax.add(x);
				}
			} else if (o instanceof RelationTargetRestrictionAxiom) {
				RelationTargetRestrictionAxiom x = (RelationTargetRestrictionAxiom) o;
				if (includes(OmlRead.getRelationEntity(x.getRelation())) && includes(x.getTarget())) {
					ax.add(x);
				}
			}
		});
	}

	private class DiagramVisitor extends OmlVisitor<OmlOntoloyDiagramScope> {
	
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
	
		public OmlOntoloyDiagramScope caseAspect(final Aspect a) {
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
	
		public OmlOntoloyDiagramScope caseConcept(final Concept c) {
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
	
		public OmlOntoloyDiagramScope caseRelationEntity(final RelationEntity e) {
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
				doSwitch(e.getSource());
				doSwitch(e.getTarget());
				OmlSearch.findSpecializationAxiomsWithGeneralTerm(e).forEach(ax -> {
					if (allImportedElements.contains(ax)) {
						incident.add(ax);
					}
				});
				OmlSearch.findRelationRangeRestrictionAxiomsWithRange(e).forEach(ax -> {
					if (allImportedElements.contains(ax)) {
						incident.add(ax);
					}
				});
				OmlSearch.findRelationsWithSource(e).forEach(r -> {
					if (allImportedElements.contains(r)) {
						incident.add(r);
					}
				});
				OmlSearch.findRelationsWithTarget(e).forEach(r -> {
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
	
		public OmlOntoloyDiagramScope caseScalar(final Scalar s) {
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
	
		public OmlOntoloyDiagramScope caseStructure(final Structure s) {
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
			OmlSearch.findPropertyValueAssertions(i).forEach(ax -> {
				if (allImportedElements.contains(ax)) {
					others.add(ax);
				}
			});
			OmlSearch.findLinkAssertionsWithSource(i).forEach(l -> {
				if (allImportedElements.contains(l)) {
					others.add(l);
				}
			});
			OmlIndex.findRelationInstancesWithSource(i).forEach(ri -> {
				if (allImportedElements.contains(ri)) {
					others.add(ri);
				}
			});
		}
	
		public OmlOntoloyDiagramScope caseConceptInstance(final ConceptInstance ci) {
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
	
		public OmlOntoloyDiagramScope caseRelationInstance(final RelationInstance ri) {
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
	
		public OmlOntoloyDiagramScope caseAspectReference(final AspectReference a) {
			return caseAspect(a.getAspect());
		}
	
		public OmlOntoloyDiagramScope caseConceptReference(final ConceptReference c) {
			return caseConcept(c.getConcept());
		}
	
		public OmlOntoloyDiagramScope caseRelationEntityReference(final RelationEntityReference e) {
			return caseRelationEntity(e.getEntity());
		}
	
		public OmlOntoloyDiagramScope caseStructureReference(final StructureReference s) {
			return caseStructure(s.getStructure());
		}
	
		public OmlOntoloyDiagramScope caseConceptInstanceReference(final ConceptInstanceReference ci) {
			return caseConceptInstance(ci.getInstance());
		}
	
		public OmlOntoloyDiagramScope caseRelationInstanceReference(final RelationInstanceReference ri) {
			return caseRelationInstance(ri.getInstance());
		}
	}
}
