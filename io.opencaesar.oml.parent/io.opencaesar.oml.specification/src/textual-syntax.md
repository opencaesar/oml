# Textual Syntax # {#TextualSyntax}

## Common ## {#Common-Syntax}

### Whitespace ### {#Whitespace-Grammar}

The OML textual language is free-form, meaning that whitespace characters can be freely placed to delimit tokens, but have no other significance.

### [=Ontology=] ### {#Ontology-Syntax}

An ontology is declared with of the ontology keywords, an ```IRI```, a separator character (# or /), and a ```PREFIX```. The  ```IRI``` represents a globally unique namespace that identifies the ontology. The separator character is used to separate the ontology's ```IRI``` from the ontology member's ```ID``` in the member's ```IRI``` (e.g., ```IRI#ID```). The ```PREFIX``` is a default short name for the ontology that can substitute for its ```IRI``` when used in an ontology member's abbreviated ```IRI``` notation (e.g., ```PREFIX:ID```). An ontology can have statements added to its body between ```{``` and ```}```. The statements can be <a href="#Import-Syntax">Import</a> statements or <a href="#Member-Syntax">Member</a>  statements (placed after all <a href="#Import-Syntax">Import</a> statements).

<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
ontology_keyword IRI with (# | /) as PREFIX {
   (<a href="#Import-Syntax">Import</a>)*
   (<a href="#Member-Syntax">Member</a>)*
}
</pre>

### [=Import=] ### {#Import-Syntax}

An ontology may import other ontologies using one of the import statements allowed for the ontology kind. An import statement is placed within the body of the ontology before any member statement. The syntax of an import statement starts with an import keyword that is supported by the ontology kind, followed by the imported ontology's ```IRI```. However, notice that a temporary limitation exists in OML that requires an ontology to be imported using a relative physical IRI) (e.g., ```../path/to/ontology.oml```). The import statement can optionally specify a different prefix for the imported ontology, using the syntax ```as PREFIX```, that overrides the default prefix specified by the ontology. The new ```PREFIX``` masks the one specified by the imported ontology within the importing ontology.

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	import_keyword IRI (as PREFIX)?
 </pre> 

### [=Member=] ### {#Member-Syntax}

An ontology may declare members by adding them with member statements after all import statements. A new member is declared by one of the member keywords supported by the ontology kind, followed by the member's ```ID```. Other details supported by the member's syntax may also be added.

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	member_keyword ID  ... ([
		...
	])?
</pre>

### [=Reference=] ### {#Reference-Syntax}

In addition to declaring a new <a href="#Member-Syntax">Member</a> , an ontology may also add statements about already declared members (within the ontology or by one of its imported ontologies). Those statements where the onology member is the subject are called <a href="#Reference-Syntax">Reference</a> statements. Such statement has a syntx that (more or less) resembles that of a member declaration, except that it is preceeded with the keyword ```ref```, and a ```MEMBER_IRI``` is used instead of the ```ID``. Notice that it is more common to add such statement when the subject member is imported rather than local to the ontology, since in the latter case, it can be part of the member's declaration.

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref member_keyword MEMBER_IRI ... ([
        ...
	])?
</pre>

### IRI ### {#IRI-Syntax}

An IRI is a globally unique identifier for an element (ontology or member). When an ontology is declared, its IRI typically has the syntax of a URL (e.g., http://ontology) but this is not a requirement. When members are declared within an ontology, their IRI is derived from that of their defining ontology as follow: Ontology_IRI + separator character (# | /) + MEMBER_ID (e.g., http://ontology#member). The member's IRI can also be abbreviated by replacing the defining ontology's IRI by its PREFIX (e.g., prefix:member). Notice that an importing ontology may override an imported ontology's prefix in the <a href="#Import-Syntax">Import</a> statement.
 
### Comment ### {#Comment-Syntax}

An ontology may have comments (descriptive text placed by ontology developers) that appear any where in the text using one of two syntaxes below. However, unlike an  <a href="#Annotation-Syntax">Annotation</a>, which is part of the abstract syntax of an ontology, a  <a href="#Comment-Syntax">Comment</a> is a purely notational element and hence may not be interchangeable with OML's other notations.

```javascript
// single-line-comment

/* possibly
    multi-line 
    comment  */
```

### [=Annotation=] ### {#Annotation-Syntax}

<pre class="highlight highlight-html">
	@<a href="#AnnotationProperty-Syntax">AnnotationProperty_IRI</a> (<a href="#Literal-Syntax">Literal</a>)?
</pre>

### [=Literal=] ### {#Literal-Syntax}

<pre class="highlight highlight-html">
	(INTEGER | DECIMAL | DOUBLE | BOOLEAN | STRING) (^^(<a href="#FacetedScalar-Syntax">[FacetedScalar_IRI]</a> | <a href="#EnumeratedScalar-Syntax">[EnumeratedScalar_IRI]</a>))?
</pre>

## Vocabularies ## {#Vocabularies-Syntax}
	
### [=Vocabulary=] ### {#Vocabulary-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	vocabulary IRI with (# | /) as PREFIX  {
		(<a href="#VocabularyExtension-Syntax">VocabularyExtension</a> | <a href="#VocabularyUsage-Syntax">VocabularyUsage</a>)*
		(<a href="#Aspect-Syntax">Aspect</a> | <a href="#Concept-Syntax">Concept</a> | <a href="#RelationEntity-Syntax">RelationEntity</a> | <a href="#RelationReference-Syntax">RelationReference</a> | <a href="#Structure-Syntax">Structure</a> | <a href="#FacetedScalar-Syntax">FacetedScalar</a> | <a href="#EnumeratedScalar-Syntax">EnumeratedScalar</a> | <a href="#ScalarProperty-Syntax">ScalarProperty</a> | <a href="#StructuredProperty-Syntax">StructuredProperty</a> | <a href="#AnnotationProperty-Syntax">AnnotationProperty</a> | <a href="#Rule-Syntax">Rule</a>)*
	}
</pre>

### [=VocabularyExtension=] ### {#VocabularyExtension-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	extends <a href="#Vocabulary-Syntax">Vocabulary_IRI</a> (as PREFIX)?
 </pre> 	

### [=VocabularyUsage=] ### {#VocabularyUsage-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	uses <a href="#Description-Syntax">Description_IRI</a> (as PREFIX)?
 </pre> 	

### [=Aspect=] ### {#Aspect-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	aspect ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		(<a href="#KeyAxiom-Syntax">KeyAxiom</a>)* 
		(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
		(<a href="#RelationRangeRestrictionAxiom-Syntax">RelationRangeRestrictionAxiom</a> | <a href="#RelationCardinalityRestrictionAxiom-Syntax">RelationCardinalityRestrictionAxiom</a> | <a href="#RelationTargetRestrictionAxiom-Syntax">RelationTargetRestrictionAxiom</a>)*
	])?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref aspect <a href="#Aspect-Syntax">Aspect_IRI</a> (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		(<a href="#KeyAxiom-Syntax">KeyAxiom</a>)*
		(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
		(<a href="#RelationRangeRestrictionAxiom-Syntax">RelationRangeRestrictionAxiom</a> | <a href="#RelationCardinalityRestrictionAxiom-Syntax">RelationCardinalityRestrictionAxiom</a> | <a href="#RelationTargetRestrictionAxiom-Syntax">RelationTargetRestrictionAxiom</a>)*
	])?
</pre>

### [=Concept=] ### {#Concept-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	concept ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		(<a href="#KeyAxiom-Syntax">KeyAxiom</a>)*
		(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
		(<a href="#RelationRangeRestrictionAxiom-Syntax">RelationRangeRestrictionAxiom</a> | <a href="#RelationCardinalityRestrictionAxiom-Syntax">RelationCardinalityRestrictionAxiom</a> | <a href="#RelationTargetRestrictionAxiom-Syntax">RelationTargetRestrictionAxiom</a>)*
	])?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref concept <a href="#Concept-Syntax">Concept_IRI</a> (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		(<a href="#KeyAxiom-Syntax">KeyAxiom</a>)*
		(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
		(<a href="#RelationRangeRestrictionAxiom-Syntax">RelationRangeRestrictionAxiom</a> | <a href="#RelationCardinalityRestrictionAxiom-Syntax">RelationCardinalityRestrictionAxiom</a> | <a href="#RelationTargetRestrictionAxiom-Syntax">RelationTargetRestrictionAxiom</a>)*
	])?
</pre>
	
### [=RelationEntity=] ### {#RelationEntity-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	relation entity ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		from (<a href="#Aspect-Syntax">Aspect_IRI</a>|<a href="#Concept-Syntax">Concept_IRI</a>|<a href="#RelationEntity-Syntax">RelationEntity_IRI</a>)
		to (<a href="#Aspect-Syntax">Aspect_IRI</a>|<a href="#Concept-Syntax">Concept_IRI</a>|<a href="#RelationEntity-Syntax">RelationEntity_IRI</a>)
		<a href="#ForwardRelation-Syntax">ForwardRelation</a>
		(<a href="#InverseRelation-Syntax">InverseRelation</a>)?
		(functional)?
		(inverseFunctional)?
		(symmetric)?
		(asymmetric)?
		(reflexive)?
		(irreflexive)?
		(transitive)?
		(<a href="#KeyAxiom-Syntax">KeyAxiom</a>)*
		(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
		(<a href="#RelationRangeRestrictionAxiom-Syntax">RelationRangeRestrictionAxiom</a> | <a href="#RelationCardinalityRestrictionAxiom-Syntax">RelationCardinalityRestrictionAxiom</a> | <a href="#RelationTargetRestrictionAxiom-Syntax">RelationTargetRestrictionAxiom</a>)*
	])?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref relation entity <a href="#RelationEntity-Syntax">RelationEntity_IRI</a> (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>  (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		(<a href="#KeyAxiom-Syntax">KeyAxiom</a>)*
		(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
		(<a href="#RelationRangeRestrictionAxiom-Syntax">RelationRangeRestrictionAxiom</a> | <a href="#RelationCardinalityRestrictionAxiom-Syntax">RelationCardinalityRestrictionAxiom</a> | <a href="#RelationTargetRestrictionAxiom-Syntax">RelationTargetRestrictionAxiom</a>)*
	])?
</pre>

### [=ForwardRelation=] ### {#ForwardRelation-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	forward ID
</pre>

### [=InverseRelation=] ### {#InverseRelation-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	inverse ID
</pre>

### [=RelationReference=] ### {#RelationReference-Syntax}

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref relation (<a href="#InverseRelation-Syntax">InverseRelation_IRI</a> | <a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a>)
</pre>
		
### [=Structure=] ### {#Structure-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	structure ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>  (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
	])?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref structure <a href="#Structure-Syntax">Structure_IRI</a> (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		(<a href="#ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a> | <a href="#ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a> | <a href="#ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a> | <a href="#StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a> | <a href="#StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a> | <a href="#StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>)*
	])?
</pre>

### [=AnnotationProperty=] ### {#AnnotationProperty-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	annotation property ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref annotation property <a href="#AnnotationProperty-Syntax">AnnotationProperty_IRI</a> (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)?
</pre>

### [=ScalarProperty=] ### {#ScalarProperty-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	scalar property ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		domain (<a href="#Aspect-Syntax">Aspect_IRI</a> | <a href="#Concept-Syntax">Concept_IRI</a>|<a href="#RelationEntity-Syntax">RelationEntity_IRI</a> | <a href="#Structure-Syntax">Structure_IRI</a>)
		range (<a href="#FacetedScalar-Syntax">FacetedScalar_IRI</a> | <a href="#EnumeratedScalar-Syntax">EnumeratedScalar_IRI</a>)
		(functional)?
	])?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref scalar property <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a>( :> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)?
</pre>

### [=StructuredProperty=] ### {#StructuredProperty-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	structured property ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		domain (<a href="#Aspect-Syntax">Aspect_IRI</a> | <a href="#Concept-Syntax">Concept_IRI</a> | <a href="#RelationEntity-Syntax">RelationEntity_IRI</a> | <a href="#Structure-Syntax">Structure_IRI</a>)
		range <a href="#Structure-Syntax">Structure_IRI</a>
		(functional)?
	])?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref structured property <a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a> (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)?
</pre>

### [=FacetedScalar=] ### {#FacetedScalar-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	scalar ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		 (length INTEGER)?
		 (minLength INTEGER)?
		 (maxLength INTEGER)?
		 (pattern STRING)?
		 (language LANGUAGE)?
		 (minInclusive <a href="#Literal-Syntax">Literal</a>)?
		 (minExclusive <a href="#Literal-Syntax">Literal</a>)?
		 (maxInclusive <a href="#Literal-Syntax">Literal</a>)?
		 (maxExclusive <a href="#Literal-Syntax">Literal</a>)?
	])?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref scalar <a href="#FacetedScalar-Syntax">FacetedScalar_IRI</a> (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)?
</pre>

### [=EnumeratedScalar=] ### {#EnumeratedScalar-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	enumerated scalar ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
		<a href="#Literal-Syntax">Literal</a> (, <a href="#Literal-Syntax">Literal</a>)*
	])?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref enumerated scalar <a href="#EnumeratedScalar-Syntax">EnumeratedScalar_IRI</a> (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)?
</pre>

### [=Rule=] ### {#Rule-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	rule ID [
		(<a href="#EntityPredicate-Syntax">EntityPredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a>  | <a href="#RelationPredicate-Syntax">RelationPredicate</a> ) (& (<a href="#EntityPredicate-Syntax">EntityPredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a>  | <a href="#RelationPredicate-Syntax">RelationPredicate</a> ))* 
		=> <a href="#RelationPredicate-Syntax">RelationPredicate</a>
	]
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref rule <a href="#Rule-Syntax">Rule_IRI</a>
</pre>

### [=EntityPredicate=] ### {#EntityPredicate-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	(<a href="#Aspect-Syntax">Aspect_IRI</a> | <a href="#Concept-Syntax">Concept_IRI</a> | <a href="#RelationEntity-Syntax">RelationEntity_IRI</a>) ( VARIABLE )
</pre>
	
### [=RelationEntityPredicate=] ### {#RelationEntityPredicate-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	<a href="#RelationEntity-Syntax">RelationEntity_IRI</a> (VARIABLE1 (<-: | ->: | :->| :<-) VARIABLE2)
</pre>

### [=RelationPredicate=] ### {#RelationPredicate-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	(<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#InverseRelation-Syntax">InverseRelation_IRI</a>) (VARIABLE1 (<- | ->) VARIABLE2)
</pre>

### [=SpecializationAxiom=] ### {#SpecializationAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	(<a href="#Aspect-Syntax">Aspect_IRI</a> | <a href="#Concept-Syntax">Concept_IRI</a> | <a href="#RelationEntity-Syntax">RelationEntity_IRI</a> | <a href="#Structure-Syntax">Structure_IRI</a> | <a href="#FacetedScalar-Syntax">FacetedScalar_IRI</a> | <a href="#EnumeratedScalar-Syntax">EnumeratedScalar_IRI</a> | <a href="#AnnotationProperty-Syntax">AnnotationProperty_IRI</a> | <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> | <a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a>)
</pre>

### [=ScalarPropertyRangeRestrictionAxiom=] ### {#ScalarPropertyRangeRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	restricts (all | some) scalar property <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> to (<a href="#FacetedScalar-Syntax">FacetedScalar_IRI</a> | <a href="#EnumeratedScalar-Syntax">EnumeratedScalar_IRI</a>)
</pre>

### [=ScalarPropertyCardinalityRestrictionAxiom=] ### {#ScalarPropertyCardinalityRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	restricts scalar property <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> to (exactly | min | max) INTEGER (<a href="#FacetedScalar-Syntax">FacetedScalar_IRI</a> | <a href="#EnumeratedScalar-Syntax">EnumeratedScalar_IRI</a>)?
</pre>

### [=ScalarPropertyValueRestrictionAxiom=] ### {#ScalarPropertyValueRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	restricts scalar property <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> to <a href="#Literal-Syntax">Literal</a>
</pre>

### [=StructuredPropertyRangeRestrictionAxiom=] ### {#StructuredPropertyRangeRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	restricts (all | some) structured property <a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a> to <a href="#Structure">Structure</a>
</pre>

### [=StructuredPropertyCardinalityRestrictionAxiom=] ### {#StructuredPropertyCardinalityRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	restricts structured property <a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a> to (exactly | min | max) INTEGER (<a href="#Structure-Syntax">Structure_IRI</a>)?
</pre>

### [=StructuredPropertyValueRestrictionAxiom=] ### {#StructuredPropertyValueRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	restricts structured property <a href="#StructuredProperty-Syntax">StructuredProperty_IRI</a> to <a href="StructureInstance-Syntax">StructureInstance</a>
</pre>

### [=RelationRangeRestrictionAxiom=] ### {#RelationRangeRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	restricts (all | some) relation (<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#InverseRelation-Syntax">InverseRelation_IRI</a>) to (<a href="#Aspect-Syntax">Aspect_IRI</a> | <a href="#Concept-Syntax">Concept_IRI</a> | <a href="#RelationEntity-Syntax">RelationEntity_IRI</a>)
</pre>

### [=RelationCardinalityRestrictionAxiom=] ### {#RelationCardinalityRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	restricts relation (<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#InverseRelation-Syntax">InverseRelation_IRI</a>) to (exactly | min | max) INTEGER (<a href="#Aspect-Syntax">Aspect_IRI</a> | <a href="#Concept-Syntax">Concept_IRI</a> | <a href="#RelationEntity-Syntax">RelationEntity_IRI</a>)?
</pre>

### [=RelationTargetRestrictionAxiom=] ### {#RelationTargetRestrictionAxiom-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	restricts relation (<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#InverseRelation-Syntax">InverseRelation_IRI</a>) to (<a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> | <a href="#RelationInstance-Syntax">RelationInstance_IRI</a>)
</pre>

### [=KeyAxiom=] ### {#KeyAxiom-Syntax}

<pre class="highlight highlight-html">
	key <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a> (, <a href="#ScalarProperty-Syntax">ScalarProperty_IRI</a>)*
</pre>

## Bundles ## {#Bundles-Syntax}

### [=Bundle=] ### {#Bundle-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	bundle IRI with (# | /) as PREFIX {
		(<a href="BundleExtension-Syntax">BundleExtension</a> | <a href="#BundleInclusion-Syntax">BundleInclusion</a>)*
	}
</pre>

### [=BundleInclusion=] ### {#BundleInclusion-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	includes <a href="#Vocabulary-Syntax">Vocabulary_IRI</a> (as PREFIX)?
</pre>

### [=BundleExtension=] ### {#BundleExtension-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	extends <a href="#Bundle-Syntax">Bundle_IRI</a> (as PREFIX)?
</pre>

## Descriptions ## {#Descriptions-Syntax-Syntax}
	
### [=Description=] ### {#Description-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	description IRI with (# | /) as PREFIX {
		(<a href="#DescriptionExtension-Syntax">DescriptionExtension</a> | <a href="#DescriptionUsage-Syntax">DescriptionUsage</a>)*
		(<a href="#ConceptInstance-Syntax">ConceptInstance</a> | <a href="#RelationInstance-Syntax">RelationInstance</a>)*
	}
</pre>

### [=DescriptionUsage=] ### {#DescriptionUsage-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	uses (<a href="#Vocabulary-Syntax">Vocabulary_IRI</a> | <a href="#Bundle-Syntax">Bundle_IRI</a>) (as PREFIX)?
</pre>

### [=DescriptionExtension=] ### {#DescriptionExtension-Syntax}

<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	extends <a href="#Description-Syntax">Description_IRI</a> (as PREFIX)?
</pre>

### [=ConceptInstance=] ### {#ConceptInstance-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ci ID (: <a href="#ConceptTypeAssertion-Syntax">ConceptTypeAssertion</a> (, <a href="#ConceptTypeAssertion-Syntax">ConceptTypeAssertion</a>)*)? ([
		(<a href="#ScalarPropertyValueAssertion-Syntax">ScalarPropertyValueAssertion</a> | <a href="#StructuredPropertyValueAssertion-Syntax">StructuredPropertyValueAssertion</a> )*
		(<a href="#LinkAssertion-Syntax">LinkAssertion</a>)*
	])?
</pre>

Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref ci <a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> (: ownedTypes+=ConceptTypeAssertion (, ownedTypes+=ConceptTypeAssertion)*)? ([
		(<a href="#ScalarPropertyValueAssertion-Syntax">ScalarPropertyValueAssertion</a> | <a href="#StructuredPropertyValueAssertion-Syntax">StructuredPropertyValueAssertion</a> )*
		(<a href="#LinkAssertion-Syntax">LinkAssertion</a>)*
	])?
</pre>
	
### [=RelationInstance=] ### {#RelationInstance-Syntax}

Declaration
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ri ID (: <a href="#RelationTypeAssertion-Syntax">RelationTypeAssertion</a> (, <a href="#RelationTypeAssertion-Syntax">RelationTypeAssertion</a>)*)?  ([
		from (<a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> | <a href="#RelationInstance-Syntax">RelationInstance_IRI</a>)
		to (<a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> | <a href="#RelationInstance-Syntax">RelationInstance_IRI</a>)
		(<a href="#ScalarPropertyValueAssertion-Syntax">ScalarPropertyValueAssertion</a> | <a href="#StructuredPropertyValueAssertion-Syntax">StructuredPropertyValueAssertion</a> )*
		(<a href="#LinkAssertion-Syntax">LinkAssertion</a>)*
	])?
</pre>
		
Reference
<pre class="highlight highlight-html">
	(<a href="#Annotation-Syntax">Annotation</a>)*
	ref ri <a href="#RelationInstance-Syntax">RelationInstance_IRI</a> (: <a href="#RelationTypeAssertion-Syntax">RelationTypeAssertion</a> (, <a href="#RelationTypeAssertion-Syntax">RelationTypeAssertion</a>)*)? ([
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
	(<a href="#ForwardRelation-Syntax">ForwardRelation_IRI</a> | <a href="#InverseRelation-Syntax">InverseRelation_IRI</a>) (<a href="#ConceptInstance-Syntax">ConceptInstance_IRI</a> | <a href="#RelationInstance-Syntax">RelationInstance_IRI</a>)
</pre>