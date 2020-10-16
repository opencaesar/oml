package io.opencaesar.oml.util

import io.opencaesar.oml.Ontology
import java.util.Set
import java.util.HashSet

import static extension io.opencaesar.oml.util.OmlRead.*
import io.opencaesar.oml.Aspect
import io.opencaesar.oml.Concept
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.Scalar
import io.opencaesar.oml.Structure
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.RelationInstance
import io.opencaesar.oml.StructureInstance
import java.util.Map
import java.util.HashMap
import io.opencaesar.oml.Element
import io.opencaesar.oml.AspectReference
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.RelationEntityReference
import io.opencaesar.oml.StructureReference
import io.opencaesar.oml.ConceptInstanceReference
import io.opencaesar.oml.RelationInstanceReference

import static extension io.opencaesar.oml.util.OmlRead.*
import static extension io.opencaesar.oml.util.OmlSearch.*
import io.opencaesar.oml.Classifier
import io.opencaesar.oml.ScalarProperty
import io.opencaesar.oml.StructuredProperty
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.FeatureProperty
import io.opencaesar.oml.Axiom
import io.opencaesar.oml.Type

class OmlOntologyScopeCalculator extends OmlVisitor<OmlOntologyScopeCalculator> {

	enum Mode {
		// Find all classifiers
		Phase1,
		// Find which features (incl. inherited) must be included
		Phase2
	}

	var Mode mode
	val Ontology ontology
	val Set<Ontology> allImportedOntologies
	val Set<Element> allImportedElements

	// An ontology induces a scope of elements either directly via assertions or indirectly via references.
	// Each kind of element has a set of candidate elements for inclusion in the scope; the candidates come
	// from the transitive closure of the ontology imports.
	// A candidate will be included iff and only if all of its OML element references are included in the scope.
	public val Map<Aspect, Set<Element>> aspects
	public val Map<Concept, Set<Element>> concepts
	public val Map<RelationEntity, Set<Element>> relationEntities
	public val Map<Scalar, Set<Element>> scalars
	public val Map<Structure, Set<Element>> structures
	public val Map<ConceptInstance, Set<Element>> conceptInstances
	public val Map<RelationInstance, Set<Element>> relationInstances
	public val Map<StructureInstance, Set<Element>> structureInstances

	public val Map<Classifier, Set<ScalarProperty>> scalarProperties
	public val Map<Classifier, Set<StructuredProperty>> structuredProperties
	public val Map<Classifier, Set<Axiom>> classifierAxioms

	public val Set<Element> secondPhase

	new(Ontology ontology) {
		this.mode = Mode.Phase1
		this.ontology = ontology
		this.allImportedOntologies = new HashSet
		this.allImportedElements = new HashSet
		this.aspects = new HashMap
		this.concepts = new HashMap
		this.relationEntities = new HashMap
		this.scalars = new HashMap
		this.structures = new HashMap
		this.conceptInstances = new HashMap
		this.relationInstances = new HashMap
		this.structureInstances = new HashMap
		this.scalarProperties = new HashMap
		this.structuredProperties = new HashMap
		this.classifierAxioms = new HashMap
		this.secondPhase = new HashSet
	}

	def boolean includes(Element e) {
		switch e {
			Aspect:
				aspects.containsKey(e)
			Concept:
				concepts.containsKey(e)
			RelationEntity:
				relationEntities.containsKey(e)
			Scalar:
				scalars.containsKey(e)
			Structure:
				structures.containsKey(e)
			ConceptInstance:
				conceptInstances.containsKey(e)
			RelationInstance:
				relationInstances.containsKey(e)
			StructureInstance:
				structureInstances.containsKey(e)
			SpecializationAxiom:
				includes(e.specializedTerm) && includes(e.owningTerm)
			default:
				false
		}
	}
	
	def boolean classifierHasFeaturesOrEdges(Classifier cls) {
		!scalarProperties.get(cls).isEmpty ||
		!structuredProperties.get(cls).isEmpty ||
		!classifierAxioms.get(cls).isEmpty
	}

	def OmlOntologyScopeCalculator analyze() {
		ontology.allImportsWithSource.forEach [ i |
			val o = i.importedOntology
			if (null !== o) {
				allImportedOntologies.add(o)
				o.eAllContents.filter(Axiom).forEach [ x |
					allImportedElements.add(x)
				]
				o.eAllContents.filter(Type).forEach [ x |
					allImportedElements.add(x)
				]
				o.eAllContents.filter(FeatureProperty).forEach [ x |
					allImportedElements.add(x)
				]
			}
		]
		val elements = ontology.eAllContents.filter(Element)
		elements.forEach[Element e|doSwitch(e)]
		mode = Mode.Phase2
		secondPhase.forEach[Element e|doSwitch(e)]
		this
	}

	def Set<Element> scope() {
		val s = new HashSet<Element>
		s.addAll(aspects.keySet)
		s.addAll(concepts.keySet)
		s.addAll(relationEntities.keySet)
		s.addAll(scalars.keySet)
		s.addAll(structures.keySet)
		s.addAll(conceptInstances.keySet)
		s.addAll(relationInstances.keySet)
		s.addAll(structureInstances.keySet)
		s
	}

	def initializeClassifier(Classifier cls) {
		initializeClassifierScalarProperties(cls)
		initializeClassifierStructuredProperties(cls)
		if (!classifierAxioms.containsKey(cls)) {
			classifierAxioms.put(cls, new HashSet)
		}
	}
	
	def initializeClassifierScalarProperties(Classifier cls) {
		if (!scalarProperties.containsKey(cls)) {
			scalarProperties.put(cls, new HashSet)
		}
	}

	def addClassifierScalarProperty(Classifier cls, ScalarProperty p) {
		initializeClassifierScalarProperties(cls)
		scalarProperties.get(cls).add(p)
	}

	def initializeClassifierStructuredProperties(Classifier cls) {
		if (!structuredProperties.containsKey(cls)) {
			structuredProperties.put(cls, new HashSet)
		}
	}

	def addClassifierStructuredProperty(Classifier cls, StructuredProperty p) {
		initializeClassifierStructuredProperties(cls)
		structuredProperties.get(cls).add(p)
	}

	def scanAllClassifierProperties(Classifier cls) {
		cls.findAllSpecializedClassifiers.forEach [ parent |
			parent.findFeaturePropertiesWithDomain.forEach [ p |
				if (allImportedElements.contains(p)) {
					switch p {
						ScalarProperty:
							if (includes(parent)) {
								addClassifierScalarProperty(parent, p)
							} else {
								addClassifierScalarProperty(cls, p)
							}
						StructuredProperty:
							if (includes(parent)) {
								addClassifierStructuredProperty(parent, p)
							} else {
								addClassifierStructuredProperty(cls, p)
							}
					}
					return
				}
			]
		]
	}

	def scanClassifierSpecializations(Classifier cls, Set<Element> others) {
		cls.findSpecializationsWithSource.forEach [ ax |
			if (allImportedElements.contains(ax)) {
				others.add(ax)
			}
		]
		cls.findSpecializationsWithTarget.forEach [ ax |
			if (allImportedElements.contains(ax)) {
				others.add(ax)
			}
		]
	}

	def recordSpecializationAxioms(Classifier cls, Set<Element> others) {
		val ax = classifierAxioms.get(cls)
		others.forEach [ o |
			switch o {
				SpecializationAxiom: {
					if (includes(o)) {
						ax.add(o)
					}
				}
			}
		]
	}

	override caseAspect(Aspect a) {
		switch (mode) {
			case Mode.Phase1: {
				initializeClassifier(a)
				if (!aspects.containsKey(a)) {
					aspects.put(a, new HashSet)
				}
				val others = aspects.get(a)
				scanClassifierSpecializations(a, others)
				secondPhase.add(a)
				this
			}
			case Mode.Phase2: {
				scanAllClassifierProperties(a)
				recordSpecializationAxioms(a, aspects.get(a))
				this
			}
		}
	}

	override caseConcept(Concept c) {
		switch (mode) {
			case Mode.Phase1: {
				initializeClassifier(c)
				if (!concepts.containsKey(c)) {
					concepts.put(c, new HashSet)
				}
				val others = concepts.get(c)
				scanClassifierSpecializations(c, others)
				secondPhase.add(c)
				this
			}
			case Mode.Phase2: {
				scanAllClassifierProperties(c)
				recordSpecializationAxioms(c, concepts.get(c))
				this
			}
		}
	}

	override caseRelationEntity(RelationEntity e) {
		switch (mode) {
			case Mode.Phase1: {
				initializeClassifier(e)
				if (!relationEntities.containsKey(e)) {
					relationEntities.put(e, new HashSet)
				}
				val others = relationEntities.get(e)
				scanClassifierSpecializations(e, others)
				e.source.doSwitch
				e.target.doSwitch
				secondPhase.add(e)
				this
			}
			case Mode.Phase2: {
				scanAllClassifierProperties(e)
				recordSpecializationAxioms(e, relationEntities.get(e))
				this
			}
		}
	}

	override caseScalar(Scalar s) {
		switch (mode) {
			case Mode.Phase1: {
				if (!scalars.containsKey(s)) {
					scalars.put(s, new HashSet)
				}
				this
			}
			case Mode.Phase2:
				this
		}
	}

	override caseStructure(Structure s) {
		switch (mode) {
			case Mode.Phase1: {
				initializeClassifierScalarProperties(s)
				initializeClassifierStructuredProperties(s)
				if (!structures.containsKey(s)) {
					structures.put(s, new HashSet)
				}
				this
			}
			case Mode.Phase2: {
				scanAllClassifierProperties(s)
				this
			}
		}
	}

	override caseConceptInstance(ConceptInstance ci) {
		switch (mode) {
			case Mode.Phase1: {
				if (!conceptInstances.containsKey(ci)) {
					conceptInstances.put(ci, new HashSet)
				}
				this
			}
			case Mode.Phase2:
				this
		}
	}

	override caseRelationInstance(RelationInstance ri) {
		switch (mode) {
			case Mode.Phase1: {
				if (!relationInstances.containsKey(ri)) {
					relationInstances.put(ri, new HashSet)
				}
				this
			}
			case Mode.Phase2:
				this
		}
	}

	override caseStructureInstance(StructureInstance si) {
		switch (mode) {
			case Mode.Phase1: {
				if (!structureInstances.containsKey(si)) {
					structureInstances.put(si, new HashSet)
				}
				this
			}
			case Mode.Phase2:
				this
		}
	}

	override caseAspectReference(AspectReference a) {
		caseAspect(a.aspect)
	}

	override caseConceptReference(ConceptReference c) {
		caseConcept(c.concept)
	}

	override caseRelationEntityReference(RelationEntityReference e) {
		caseRelationEntity(e.entity)
	}

	override caseStructureReference(StructureReference s) {
		caseStructure(s.structure)
	}

	override caseConceptInstanceReference(ConceptInstanceReference ci) {
		caseConceptInstance(ci.instance)
	}

	override caseRelationInstanceReference(RelationInstanceReference ri) {
		caseRelationInstance(ri.instance)
	}

}
