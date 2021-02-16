# Concrete Syntax # {#ConcreteSyntax}

## Common ## {#Common-Syntax}

### Whitespace ### {#Whitespace-Grammar}

The OML textual language is free-form, meaning that whitespace characters can be freely placed to delimit tokens, but have no other significance.

### [=Ontology=] ### {#Ontology-Syntax}

An ontology is declared with of the ontology keywords, an `IRI`, a separator character (# or /), and a `PREFIX`. The `IRI` represents a globally unique namespace that identifies the ontology. The separator character is used to separate the ontology's `IRI` from the ontology member's `ID` in the member's `IRI` (e.g., `IRI#ID`). The `PREFIX` is a default short name for the ontology that can substitute for its `IRI` when used in an ontology member's abbreviated `IRI` notation (e.g., `PREFIX:ID`). An ontology can have statements added to its body between `{` and `}`. The statements can be <a href="#Import-Syntax">Import</a> statements or <a href="#Member-Syntax">Member</a> statements (placed after all <a href="#Import-Syntax">Import</a> statements).

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
&lt;ontology_keyword&gt; IRI <span style="font-weight:bold;color:purple">with</span> (# | /) <span style="font-weight:bold;color:purple">as</span> PREFIX {
	(<a href="#Import-Syntax">Import</a>)*
	(<a href="#Member-Syntax">Member</a>)*
}
</pre>

### [=Import=] ### {#Import-Syntax}

An ontology may import other ontologies using one of the import statements allowed for the ontology kind. An import statement is placed within the body of the ontology before any member statement. The syntax of an import statement starts with an import keyword that is supported by the ontology kind, followed by the imported ontology's `IRI`. However, notice that a temporary limitation exists in OML that requires an ontology to be imported using a relative physical IRI) (e.g., `../path/to/ontology.oml`). The import statement can optionally specify a different prefix for the imported ontology, using the syntax `as PREFIX`, that overrides the default prefix specified by the ontology. The new `PREFIX` masks the one specified by the imported ontology within the importing ontology.

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
&lt;import_keyword&gt; IRI (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
 </pre>

### [=Member=] ### {#Member-Syntax}

An ontology may declare members by adding them with member statements after all import statements. A new member is declared by one of the member keywords supported by the ontology kind, followed by the member's `ID`. Other details supported by the member's syntax may also be added.

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
&lt;member_keyword&gt; ID ... ([
	...
])?
</pre>

### [=Reference=] ### {#Reference-Syntax}

In addition to declaring a new <a href="#Member-Syntax">Member</a> , an ontology may also add statements about already declared members (within the ontology or by one of its imported ontologies). Those statements where the onology member is the subject are called <a href="#Reference-Syntax">Reference</a> statements. Such statement has a syntax that (more or less) resembles that of a member declaration, except that it is preceeded with the keyword `ref`, and a `MEMBER_IRI` is used instead of the ``ID`. Notice that it is more common to add such statement when the subject member is imported rather than local to the ontology, since in the latter case, it can be part of the member's declaration.

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">ref</span> &lt;member_keyword&gt; MEMBER_IRI ... ([
	...
])?
</pre>

### IRI ### {#IRI-Syntax}

An IRI is a globally unique identifier for an element (ontology or member). When an ontology is declared, its IRI typically has the syntax of a URL (e.g., http://ontology) but this is not a requirement. When members are declared within an ontology, their IRI is derived from that of their defining ontology as follow: Ontology_IRI + separator character (# | /) + MEMBER_ID (e.g., http://ontology#member). The member's IRI can also be abbreviated by replacing the defining ontology's IRI by its PREFIX (e.g., prefix:member). Notice that an importing ontology may override an imported ontology's prefix in the <a href="#Import-Syntax">Import</a> statement.

### Comment ### {#Comment-Syntax}

An ontology may have comments (descriptive text placed by ontology developers) that appear any where in the text using one of two syntaxes below. However, unlike an <a href="#Annotation-Syntax">Annotation</a>, which is part of the abstract syntax of an ontology, a <a href="#Comment-Syntax">Comment</a> is a purely notational element and hence may not be interchangeable with OML's other notations.

```javascript
// single-line-comment

/* possibly
  multi-line
  comment */
```

### [=Annotation=] ### {#Annotation-Syntax}

<pre class="highlight highlight-html">
@<a href="#AnnotationProperty-Syntax">AnnotationProperty_IRI</a> (<a href="#Literal-Syntax">Literal</a>)?
</pre>

### [=Literal=] ### {#Literal-Syntax}

<pre class="highlight highlight-html">
INTEGER | // literal is typed by xsd:integer
DECIMAL | // literal is typed by xsd:decimal
DOUBLE  | // literal is typed by xsd:double
BOOLEAN | // literal is typed by xsd:boolean
QUOTED_LITERAL (^^<a href="#FacetedScalar-Syntax">FacetedScalar_IRI</a> | $<a href="https://tools.ietf.org/html/bcp47#section-2">langTag</a>)?
</pre>

> For QUOTED_LITERAL, the [FacetedScalar_IRI](#FacetedScalar-Syntax) must be an IRI of one of the OWL2 [built-in datatypes](https://www.w3.org/TR/2012/REC-xmlschema11-2-20120405/#built-in-datatypes) only. If not specified, it defaults to xsd:string. (The OML API OmlRead.getTypeIRI(Literal) can be used to programmatically get the type IRI.)

### [Diagram] ### {#Diagram-Syntax}

The concrete syntax for each OML element is organized into tabs. The "Text" tab is showcased by default, displaying the textual syntax of the OML element. To see the graphical syntax of the element, click on the "Diagram" tab.

The symbols colored in orange, and the symbols boxed in gray, are there solely to communicate more information about the elements they are attached to. They will not show up in actual implementations of OML diagrams.

Elements with a blue hyperlink can be clicked on to redirect to a detailed description of their concrete syntax.

Diagram compartments are laid out in free form, and list compartments are laid out vertically.

## Vocabularies ## {#Vocabularies-Syntax}

### [=Vocabulary=] ### {#Vocabulary-Syntax}

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/vocabulary.md
    svgpath: images/vocabulary.svg
</pre>

### [=VocabularyExtension=] ### {#VocabularyExtension-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">extends</span> <a href="#Vocabulary-Syntax">Vocabulary_IRI</a> (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
 </pre>

### [=VocabularyUsage=] ### {#VocabularyUsage-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">uses</span> (<a href="#Description-Syntax">Description_IRI</a> | <a href="#DescriptionBundle-Syntax">DescriptionBundle_IRI</a>) (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
 </pre>

### [=Aspect=] ### {#Aspect-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/aspect.md
    svgpath: images/aspect.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/aspect_ref.md
	svgpath: images/aspect_ref.svg
</pre>

### [=Concept=] ### {#Concept-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/concept.md
    svgpath: images/concept.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/concept_ref.md
    svgpath: images/concept_ref.svg
</pre>

### [=RelationEntity=] ### {#RelationEntity-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/relation_entity.md
    svgpath: images/relation_entity.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/relation_entity_ref.md
    svgpath: images/relation_entity_ref.svg
</pre>

### [=ForwardRelation=] ### {#ForwardRelation-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/forward_relation.md
    svgpath: images/forward_relation.svg
</pre>

### [=ReverseRelation=] ### {#ReverseRelation-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/reverse_relation.md
    svgpath: images/reverse_relation.svg
</pre>

### [=SourceRelation=] ### {#SourceRelation-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/source_relation.md
    svgpath: images/source_relation.svg
</pre>

### [=InverseSourceRelation=] ### {#InverseSourceRelation-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/inverse_source_relation.md
    svgpath: images/inverse_source_relation.svg
</pre>

### [=TargetRelation=] ### {#TargetRelation-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/target_relation.md
    svgpath: images/target_relation.svg
</pre>

### [=InverseTargetRelation=] ### {#InverseTargetRelation-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/inverse_target_relation.md
    svgpath: images/inverse_target_relation.svg
</pre>

### [=RelationReference=] ### {#RelationReference-Syntax}

Reference

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">ref relation</span> (<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#ReverseRelation-Syntax">ReverseRelation_IRI</a> | <a href="#SourceRelation-Syntax">SourceRelation_IRI</a> | <a href="#InverseSourceRelation-Syntax">InverseSourceRelation_IRI</a> | <a href="#TargetRelation-Syntax">TargetRelation_IRI</a> | <a href="#InverseTargetRelation-Syntax">InverseTargetRelation_IRI</a>)
</pre>

### [=Structure=] ### {#Structure-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/structure.md
    svgpath: images/structure.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/structure_ref.md
    svgpath: images/structure_ref.svg
</pre>

### [=AnnotationProperty=] ### {#AnnotationProperty-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/annotation_property.md
    svgpath: images/annotation_property.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/annotation_property_ref.md
    svgpath: images/annotation_property_ref.svg
</pre>

### [=ScalarProperty=] ### {#ScalarProperty-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/scalar_property.md
    svgpath: images/id_range_label.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/scalar_property_ref.md
    svgpath: images/scalar_property_ref.svg
</pre>

### [=StructuredProperty=] ### {#StructuredProperty-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/structured_property.md
    svgpath: images/id_range_label.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/structured_property_ref.md
    svgpath: images/structured_property_ref.svg
</pre>

### [=FacetedScalar=] ### {#FacetedScalar-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/faceted_scalar.md
    svgpath: images/faceted_scalar.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/faceted_scalar_ref.md
    svgpath: images/faceted_scalar_ref.svg
</pre>

### [=EnumeratedScalar=] ### {#EnumeratedScalar-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/enumerated_scalar.md
    svgpath: images/enumerated_scalar.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/enumerated_scalar_ref.md
    svgpath: images/enumerated_scalar_ref.svg
</pre>

### [=Rule=] ### {#Rule-Syntax}

Declaration

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/rule.md
    svgpath: images/rule.svg
</pre>

Reference

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/rule_ref.md
    svgpath: images/rule_ref.svg
</pre>

### [=EntityPredicate=] ### {#EntityPredicate-Syntax}

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/entity_predicate.md
    svgpath: images/entity_predicate.svg
</pre>

### [=RelationPredicate=] ### {#RelationPredicate-Syntax}

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/relation_predicate.md
    svgpath: images/relation_predicate.svg
</pre>

### [=RelationEntityPredicate=] ### {#RelationEntityPredicate-Syntax}

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/relation_entity_predicate.md
    svgpath: images/relation_entity_predicate.svg
</pre>

### [=SameAsPredicate=] ### {#SameAsPredicate-Syntax}

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/same_as_predicate.md
    svgpath: images/same_as_predicate.svg
</pre>

### [=DifferentFromPredicate=] ### {#DifferentFromPredicate-Syntax}

<pre class="include">
path: tabs.md
macros:
	textpath: concrete_syntax/different_from_predicate.md
    svgpath: images/different_from_predicate.svg
</pre>

### [=SpecializationAxiom=] ### {#SpecializationAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
(<a href="#Aspect-Syntax">Aspect_IRI</a> | <a href="#Concept-Syntax">Concept_IRI</a> | <a href="#RelationEntity-Syntax">RelationEntity_IRI</a> | <a href="#Structure-Syntax">Structure_IRI</a> | <a href="#FacetedScalar-Syntax">FacetedScalar_IRI</a> | <a href="#EnumeratedScalar-Syntax">EnumeratedScalar_IRI</a> | <a href="#AnnotationProperty-Syntax">AnnotationProperty_IRI</a> | <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> | <a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a>)
</pre>

### [=ScalarPropertyRangeRestrictionAxiom=] ### {#ScalarPropertyRangeRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">restricts</span> (<span style="font-weight:bold;color:purple">all</span> | <span style="font-weight:bold;color:purple">some</span>) <span style="font-weight:bold;color:purple">scalar property</span> <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> <span style="font-weight:bold;color:purple">to</span> (<a href="#FacetedScalar-Syntax">FacetedScalar_IRI</a> | <a href="#EnumeratedScalar-Syntax">EnumeratedScalar_IRI</a>)
</pre>

### [=ScalarPropertyCardinalityRestrictionAxiom=] ### {#ScalarPropertyCardinalityRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">restricts scalar property</span> <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> <span style="font-weight:bold;color:purple">to</span> (<span style="font-weight:bold;color:purple">exactly</span> | <span style="font-weight:bold;color:purple">min</span> | <span style="font-weight:bold;color:purple">max</span>) INTEGER (<a href="#FacetedScalar-Syntax">FacetedScalar_IRI</a> | <a href="#EnumeratedScalar-Syntax">EnumeratedScalar_IRI</a>)?
</pre>

### [=ScalarPropertyValueRestrictionAxiom=] ### {#ScalarPropertyValueRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">restricts scalar property</span> <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> <span style="font-weight:bold;color:purple">to</span> <a href="#Literal-Syntax">Literal</a>
</pre>

### [=StructuredPropertyRangeRestrictionAxiom=] ### {#StructuredPropertyRangeRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">restricts</span> (<span style="font-weight:bold;color:purple">all</span> | <span style="font-weight:bold;color:purple">some</span>) <span style="font-weight:bold;color:purple">structured property</span> <a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a> <span style="font-weight:bold;color:purple">to</span> <a href="#Structure">Structure</a>
</pre>

### [=StructuredPropertyCardinalityRestrictionAxiom=] ### {#StructuredPropertyCardinalityRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">restricts structured property</span> <a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a> <span style="font-weight:bold;color:purple">to</span> (<span style="font-weight:bold;color:purple">exactly</span> | <span style="font-weight:bold;color:purple">min</span> | <span style="font-weight:bold;color:purple">max</span>) INTEGER (<a href="#Structure-Syntax">Structure_IRI</a>)?
</pre>

### [=StructuredPropertyValueRestrictionAxiom=] ### {#StructuredPropertyValueRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">restricts structured property</span> <a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a> <span style="font-weight:bold;color:purple">to</span> <a href="StructureInstance-Syntax">StructureInstance</a>
</pre>

### [=RelationRangeRestrictionAxiom=] ### {#RelationRangeRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">restricts</span> (<span style="font-weight:bold;color:purple">all</span> | <span style="font-weight:bold;color:purple">some</span>) <span style="font-weight:bold;color:purple">relation</span> (<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#ReverseRelation-Syntax">ReverseRelation_IRI</a> | <a href="#SourceRelation-Syntax">SourceRelation_IRI</a> | <a href="#InverseSourceRelation-Syntax">InverseSourceRelation_IRI</a> | <a href="#TargetRelation-Syntax">TargetRelation_IRI</a> | <a href="#InverseTargetRelation-Syntax">InverseTargetRelation_IRI</a>) <span style="font-weight:bold;color:purple">to</span> (<a href="#Aspect-Syntax">Aspect_IRI</a> | <a href="#Concept-Syntax">Concept_IRI</a> | <a href="#RelationEntity-Syntax">RelationEntity_IRI</a>)
</pre>

### [=RelationCardinalityRestrictionAxiom=] ### {#RelationCardinalityRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">restricts relation</span> (<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#ReverseRelation-Syntax">ReverseRelation_IRI</a> | <a href="#SourceRelation-Syntax">SourceRelation_IRI</a> | <a href="#InverseSourceRelation-Syntax">InverseSourceRelation_IRI</a> | <a href="#TargetRelation-Syntax">TargetRelation_IRI</a> | <a href="#InverseTargetRelation-Syntax">InverseTargetRelation_IRI</a>) <span style="font-weight:bold;color:purple">to</span> (<span style="font-weight:bold;color:purple">exactly</span> | <span style="font-weight:bold;color:purple">min</span> | <span style="font-weight:bold;color:purple">max</span>) INTEGER (<a href="#Aspect-Syntax">Aspect_IRI</a> | <a href="#Concept-Syntax">Concept_IRI</a> | <a href="#RelationEntity-Syntax">RelationEntity_IRI</a>)?
</pre>

### [=RelationTargetRestrictionAxiom=] ### {#RelationTargetRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">restricts relation</span> (<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#ReverseRelation-Syntax">ReverseRelation_IRI</a> | <a href="#SourceRelation-Syntax">SourceRelation_IRI</a> | <a href="#InverseSourceRelation-Syntax">InverseSourceRelation_IRI</a> | <a href="#TargetRelation-Syntax">TargetRelation_IRI</a> | <a href="#InverseTargetRelation-Syntax">InverseTargetRelation_IRI</a>) <span style="font-weight:bold;color:purple">to</span> (<a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> | <a href="#RelationInstance-Syntax">RelationInstance_IRI</a>)
</pre>

### [=KeyAxiom=] ### {#KeyAxiom-Syntax}

<pre class="highlight highlight-html">
<span style="font-weight:bold;color:purple">key</span> <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> (, <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a>)*
</pre>

## Vocabulary Bundles ## {#VocabularyBundles-Syntax}

### [=VocabularyBundle=] ### {#VocabularyBundle-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">vocabulary bundle</span> IRI <span style="font-weight:bold;color:purple">with</span> (# | /) <span style="font-weight:bold;color:purple">as</span> PREFIX {
	(<a href="VocabularyBundleExtension-Syntax">VocabularyBundleExtension</a> | <a href="#VocabularyBundleInclusion-Syntax">VocabularyBundleInclusion</a>)*
}
</pre>

### [=VocabularyBundleExtension=] ### {#VocabularyBundleExtension-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">extends</span> <a href="#VocabularyBundle-Syntax">VocabularyBundle_IRI</a> (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
</pre>

### [=VocabularyBundleInclusion=] ### {#VocabularyBundleInclusion-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">includes</span> <a href="#Vocabulary-Syntax">Vocabulary_IRI</a> (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
</pre>

## Descriptions ## {#Descriptions-Syntax-Syntax}

### [=Description=] ### {#Description-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">description</span> IRI <span style="font-weight:bold;color:purple">with</span> (# | /) <span style="font-weight:bold;color:purple">as</span> PREFIX {
	(<a href="#DescriptionExtension-Syntax">DescriptionExtension</a> | <a href="#DescriptionUsage-Syntax">DescriptionUsage</a>)*
	(<a href="#ConceptInstance-Syntax">ConceptInstance</a> | <a href="#RelationInstance-Syntax">RelationInstance</a>)*
}
</pre>

### [=DescriptionExtension=] ### {#DescriptionExtension-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">extends</span> <a href="#Description-Syntax">Description_IRI</a> (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
</pre>

### [=DescriptionUsage=] ### {#DescriptionUsage-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">uses</span> (<a href="#Vocabulary-Syntax">Vocabulary_IRI</a> | <a href="#VocabularyBundle-Syntax">VocabularyBundle_IRI</a>) (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
</pre>

### [=ConceptInstance=] ### {#ConceptInstance-Syntax}

Declaration

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">ci</span> ID (: <a href="#ConceptTypeAssertion-Syntax">ConceptTypeAssertion</a> (, <a href="#ConceptTypeAssertion-Syntax">ConceptTypeAssertion</a>)*)? ([
	(<a href="#ScalarPropertyValueAssertion-Syntax">ScalarPropertyValueAssertion</a> | <a href="#StructuredPropertyValueAssertion-Syntax">StructuredPropertyValueAssertion</a> )*
	(<a href="#LinkAssertion-Syntax">LinkAssertion</a>)*
])?
</pre>

Reference

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">ref ci</span> <a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> (: ownedTypes+=ConceptTypeAssertion (, ownedTypes+=ConceptTypeAssertion)*)? ([
	(<a href="#ScalarPropertyValueAssertion-Syntax">ScalarPropertyValueAssertion</a> | <a href="#StructuredPropertyValueAssertion-Syntax">StructuredPropertyValueAssertion</a> )*
	(<a href="#LinkAssertion-Syntax">LinkAssertion</a>)*
])?
</pre>

### [=RelationInstance=] ### {#RelationInstance-Syntax}

Declaration

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">ri</span> ID (: <a href="#RelationTypeAssertion-Syntax">RelationTypeAssertion</a> (, <a href="#RelationTypeAssertion-Syntax">RelationTypeAssertion</a>)*)? ([
	<span style="font-weight:bold;color:purple">from</span> (<a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> | <a href="#RelationInstance-Syntax">RelationInstance_IRI</a>)
	<span style="font-weight:bold;color:purple">to</span> (<a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> | <a href="#RelationInstance-Syntax">RelationInstance_IRI</a>)
	(<a href="#ScalarPropertyValueAssertion-Syntax">ScalarPropertyValueAssertion</a> | <a href="#StructuredPropertyValueAssertion-Syntax">StructuredPropertyValueAssertion</a> )*
	(<a href="#LinkAssertion-Syntax">LinkAssertion</a>)*
])?
</pre>

Reference

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">ref ri</span> <a href="#RelationInstance-Syntax">RelationInstance_IRI</a> (: <a href="#RelationTypeAssertion-Syntax">RelationTypeAssertion</a> (, <a href="#RelationTypeAssertion-Syntax">RelationTypeAssertion</a>)*)? ([
	(<a href="#ScalarPropertyValueAssertion-Syntax">ScalarPropertyValueAssertion</a> | <a href="#StructuredPropertyValueAssertion-Syntax">StructuredPropertyValueAssertion</a> )*
	(<a href="#LinkAssertion-Syntax">LinkAssertion</a>)*
])?
</pre>

### [=StructureInstance=] ### {#StructureInstance-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<a href="#Structure-Syntax">Structure_IRI</a> [
	(<a href="#ScalarPropertyValueAssertion-Syntax">ScalarPropertyValueAssertion</a> | <a href="#StructuredPropertyValueAssertion-Syntax">StructuredPropertyValueAssertion</a> )*
]
</pre>

### [=ConceptTypeAssertion=] ### {#ConceptTypeAssertion-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<a href="#Concept-Syntax">Concept_IRI</a>
</pre>

### [=RelationTypeAssertion=] ### {#RelationTypeAssertion-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<a href="#RelationEntity-Syntax">RelationEntity_IRI</a>
</pre>

### [=ScalarPropertyValueAssertion=] ### {#ScalarPropertyValueAssertion-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> <a href="#Literal-Syntax">Literal</a>
</pre>

### [=StructuredPropertyValueAssertion=] ### {#StructuredPropertyValueAssertion-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a> <a href="#StructureInstance-Syntax">StructureInstance</a>
</pre>

### [=LinkAssertion=] ### {#LinkAssertion-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
(<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#ReverseRelation-Syntax">ReverseRelation_IRI</a>) (<a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> | <a href="#RelationInstance-Syntax">RelationInstance_IRI</a>)
</pre>

## Description Bundles ## {#DescriptionBundles-Syntax}

### [=DescriptionBundle=] ### {#DescriptionBundle-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">description bundle</span> IRI <span style="font-weight:bold;color:purple">with</span> (# | /) <span style="font-weight:bold;color:purple">as</span> PREFIX {
	(<a href="#DescriptionBundleExtension-Syntax">DescriptionBundleExtension</a> | <a href="#DescriptionBundleInclusion-Syntax">DescriptionBundleInclusion</a> | <a href="#DescriptionBundleUsage-Syntax">DescriptionBundleUsage</a>)*
}
</pre>

### [=DescriptionBundleExtension=] ### {#DescriptionBundleExtension-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">extends</span> <a href="#DescriptionBundle-Syntax">DescriptionBundle_IRI</a> (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
</pre>

### [=DescriptionBundleInclusion=] ### {#DescriptionBundleInclusion-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">includes</span> <a href="#Description-Syntax">Description_IRI</a> (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
</pre>

### [=DescriptionBundleUsage=] ### {#DescriptionBundleUsage-Syntax}

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">uses</span> <a href="#VocabularyBundle-Syntax">VocabularyBundle_IRI</a> (<span style="font-weight:bold;color:purple">as</span> PREFIX)?
</pre>
