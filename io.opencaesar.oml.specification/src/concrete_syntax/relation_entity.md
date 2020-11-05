<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">relation entity</span> ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
	<span style="font-weight:bold;color:purple">from</span> (<a href="#Aspect-Syntax">Aspect_IRI</a>|<a href="#Concept-Syntax">Concept_IRI</a>|<a href="#RelationEntity-Syntax">RelationEntity_IRI</a>)
	<span style="font-weight:bold;color:purple">to</span> (<a href="#Aspect-Syntax">Aspect_IRI</a>|<a href="#Concept-Syntax">Concept_IRI</a>|<a href="#RelationEntity-Syntax">RelationEntity_IRI</a>)
	(<a href="#ForwardRelation-Syntax">ForwardRelation</a>)?
	(<a href="#ReverseRelation-Syntax">ReverseRelation</a>)?
	(<a href="#SourceRelation-Syntax">SourceRelation</a>)?
	(<a href="#InverseSourceRelation-Syntax">InverseSourceRelation</a>)?
	(<a href="#TargetRelation-Syntax">TargetRelation</a>)?
	(<a href="#InverseTargetRelation-Syntax">InverseTargetRelation</a>)?
	(<span style="font-weight:bold;color:purple">functional</span>)?
	(<span style="font-weight:bold;color:purple">inverseFunctional</span>)?
	(<span style="font-weight:bold;color:purple">symmetric</span>)?
	(<span style="font-weight:bold;color:purple">asymmetric</span>)?
	(<span style="font-weight:bold;color:purple">reflexive</span>)?
	(<span style="font-weight:bold;color:purple">irreflexive</span>)?
	(<span style="font-weight:bold;color:purple">transitive</span>)?
	(<a href="#KeyAxiom-Syntax">KeyAxiom</a>)*
	(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
	(<a href="#RelationRangeRestrictionAxiom-Syntax">RelationRangeRestrictionAxiom</a> | <a href="#RelationCardinalityRestrictionAxiom-Syntax">RelationCardinalityRestrictionAxiom</a> | <a href="#RelationTargetRestrictionAxiom-Syntax">RelationTargetRestrictionAxiom</a>)*
])?
</pre>
