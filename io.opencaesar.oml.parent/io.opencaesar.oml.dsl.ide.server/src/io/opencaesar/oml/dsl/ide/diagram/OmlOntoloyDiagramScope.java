package io.opencaesar.oml.dsl.ide.diagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

import io.opencaesar.oml.*;
import io.opencaesar.oml.util.OmlIndex;
import io.opencaesar.oml.util.OmlRead;
import io.opencaesar.oml.util.OmlSearch;
import io.opencaesar.oml.util.OmlVisitor;

public class OmlOntoloyDiagramScope extends OmlVisitor<OmlOntoloyDiagramScope> {

	enum Mode {
		// Find all classifiers
		Phase1,
		// Find which features (incl. inherited) must be included
		Phase2
	}

	Mode mode;
	final Ontology ontology;
	final Set<Ontology> allImportedOntologies;
	final Set<Element> allImportedElements;
	final Map<Aspect, Set<Element>> aspects;
	final Map<Concept, Set<Element>> concepts;
	final Map<RelationEntity, Set<Element>> relationEntities;
	final Map<Scalar, Set<Element>> scalars;
	final Map<Structure, Set<Element>> structures;
	final Map<Classifier, Set<ScalarProperty>> scalarProperties;
	final Map<Classifier, Set<StructuredProperty>> structuredProperties;
	final Set<FeatureProperty> allFeatureProperties;
	final Map<Entity, Set<Axiom>> entityAxioms;
	
	// For a ConceptInstance or RelationInstance, the set of Assertions or RelationInstances.
	final Map<NamedInstance, Set<Element>> instanceAssertions;
	
	final Map<StructureInstance, Set<Assertion>> structureAssertions;
	final Set<Element> secondPhase;

	public OmlOntoloyDiagramScope(final Ontology ontology) {
		this.mode = Mode.Phase1;
		this.ontology = ontology;
		this.allImportedOntologies = new HashSet<>();
		this.allImportedElements = new HashSet<>();
		this.aspects = new HashMap<>();
		this.concepts = new HashMap<>();
		this.relationEntities = new HashMap<>();
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

	public boolean includes(final Element e) {
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
		return !scalarProperties.get(cls).isEmpty() || !structuredProperties.get(cls).isEmpty()
				|| !entityAxioms.get(cls).isEmpty();
	}

	private void analyze1Ontology(Ontology o) {
		if (null != o) {
			allImportedOntologies.add(o);
			IteratorExtensions.forEach(Iterators.filter(o.eAllContents(), Axiom.class),
					x -> allImportedElements.add(x));
			IteratorExtensions.forEach(Iterators.filter(o.eAllContents(), Type.class), x -> allImportedElements.add(x));
			IteratorExtensions.forEach(Iterators.filter(o.eAllContents(), FeatureProperty.class),
					x -> allImportedElements.add(x));
			IteratorExtensions.forEach(Iterators.filter(o.eAllContents(), NamedInstance.class),
					x -> allImportedElements.add(x));
			IteratorExtensions.forEach(Iterators.filter(o.eAllContents(), Assertion.class),
					x -> allImportedElements.add(x));
		}
	}

	public OmlOntoloyDiagramScope analyze() {
		analyze1Ontology(ontology);
		OmlRead.getAllImportsWithSource(ontology).forEach(i -> {
			Ontology o = OmlRead.getImportedOntology(i);
			analyze1Ontology(o);
		});

		IteratorExtensions.forEach(Iterators.filter(ontology.eAllContents(), Element.class), x -> doSwitch(x));
		mode = Mode.Phase2;
		secondPhase.forEach(e -> doSwitch(e));
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

	public void phase1InitializeEntity(final Entity e) {
		phase1InitializeClassifierProperties(e);
		if (!entityAxioms.containsKey(e)) {
			entityAxioms.put(e, new HashSet<>());
		}
	}

	public void phase1InitializeClassifierProperties(final Classifier cls) {
		if (!scalarProperties.containsKey(cls)) {
			scalarProperties.put(cls, new HashSet<>());
		}
		if (!structuredProperties.containsKey(cls)) {
			structuredProperties.put(cls, new HashSet<>());
		}
		Iterables.filter(OmlSearch.findAllSpecializedTermsInclusive(cls), Classifier.class).forEach(parent -> {
			OmlSearch.findFeaturePropertiesWithDomain(parent).forEach(f -> {
				if (allImportedElements.contains(f)) {
					allFeatureProperties.add(f);
				}
			});
		});
	}

	public void phase2AddClassifierScalarProperty(final Classifier cls, final ScalarProperty p) {
		scalarProperties.get(cls).add(p);
	}

	public void phase2AdClassifierStructuredProperty(final Classifier cls, final StructuredProperty p) {
		structuredProperties.get(cls).add(p);
	}

	public void phase2ScanAllClassifierProperties(final Classifier cls) {
		Iterables.filter(OmlSearch.findAllSpecializedTermsInclusive(cls), Classifier.class).forEach(parent -> {
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

	public void phase1ScanEntityAxioms(final Entity e, final Set<Element> others) {
		OmlSearch.findKeys(e).forEach(ax -> {
			if (allImportedElements.contains(ax)) {
				others.add(ax);
			}
		});
		OmlSearch.findSpecializationsWithSource(e).forEach(ax -> {
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

	public void phase2FilterEntityAxioms(final Entity e, final Set<Element> others) {
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
				if (includes(OmlRead.getEntity(x.getRelation()))) {
					ax.add(x);
				}
			} else if (o instanceof RelationRangeRestrictionAxiom) {
				RelationRangeRestrictionAxiom x = (RelationRangeRestrictionAxiom) o;
				if (includes(OmlRead.getEntity(x.getRelation())) && includes(x.getRange())) {
					ax.add(x);
				}
			} else if (o instanceof RelationTargetRestrictionAxiom) {
				RelationTargetRestrictionAxiom x = (RelationTargetRestrictionAxiom) o;
				if (includes(OmlRead.getEntity(x.getRelation())) && includes(x.getTarget())) {
					ax.add(x);
				}
			}
		});
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
		return this;
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
		return this;
	}

	public OmlOntoloyDiagramScope caseRelationEntity(final RelationEntity e) {
		switch (mode) {
		case Phase1:
			phase1InitializeEntity(e);
			if (!relationEntities.containsKey(e)) {
				relationEntities.put(e, new HashSet<>());
			}
			Set<Element> others = relationEntities.get(e);
			phase1ScanEntityAxioms(e, others);
			doSwitch(e.getSource());
			doSwitch(e.getTarget());
			secondPhase.add(e);
			break;
		case Phase2:
			phase2ScanAllClassifierProperties(e);
			phase2FilterEntityAxioms(e, relationEntities.get(e));
			break;
		}
		return this;
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
		return this;
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
		return this;
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
		return this;
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
		return this;
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
		return this;
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
