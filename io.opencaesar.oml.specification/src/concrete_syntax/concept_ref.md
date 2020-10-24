<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
ref concept <a href="#Concept-Syntax">Concept_IRI</a> (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
	(<a href="#KeyAxiom-Syntax">KeyAxiom</a>)*
	(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
	(<a href="#RelationRangeRestrictionAxiom-Syntax">RelationRangeRestrictionAxiom</a> | <a href="#RelationCardinalityRestrictionAxiom-Syntax">RelationCardinalityRestrictionAxiom</a> | <a href="#RelationTargetRestrictionAxiom-Syntax">RelationTargetRestrictionAxiom</a>)*
])?
</pre>
