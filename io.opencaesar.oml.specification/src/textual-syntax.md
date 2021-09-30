# Textual Syntax # {#Textual-Syntax}

## Textual Conventions ## {#Textual-Conventions}

**Whitespace**

Whitespace can be freely placed in an OML textual file to delimit tokens, but have no other significance.

**Comments**

Comments with the following syntaxes can be freely placed in an OML textual file:
```javascript
// single-line-comment

/* possibly
  multi-line
  comment */
```
However, notice that a comment is purely notational and hence will not be interchangeable with OML's other notations.

## Textual BNF ## {#Textual-BNF}

<pre class="highlight highlight-html">

<a id="Ontology-Syntax">Ontology</a>:
	VocabularyBox |
	DescriptionBox

<a id="VocabularyBox-Syntax">VocabularyBox</a>:
	Vocabulary |
	VocabularyBundle

<a id="Vocabulary-Syntax">Vocabulary</a>:
	Annotation*
	`vocabulary` NAMESPACE `as` ID  `{`
		VocabularyImport*
		VocabularyStatement*
	`}`

<a id="VocabularyBundle-Syntax">VocabularyBundle</a>:
	Annotation*
	`vocabulary` `bundle` NAMESPACE `as` ID `{`
		VocabularyBundleImport*
	`}`

<a id="DescriptionBox-Syntax">DescriptionBox</a>:
	Description |
	DescriptionBundle

<a id="Description-Syntax">Description</a>:
	Annotation*
	`description` NAMESPACE `as` ID `{`
		DescriptionImport*
		DescriptionStatement*
	`}`

<a id="DescriptionBundle-Syntax">DescriptionBundle</a>:
	Annotation*
	`description` `bundle` NAMESPACE `as` ID `{`
		DescriptionBundleImport*
	`}`

<a id="VocabularyImport-Syntax">VocabularyImport</a>:
	VocabularyExtension |
	VocabularyUsage

<a id="VocabularyExtension-Syntax">VocabularyExtension</a>:
	Annotation*
	`extends` NAMESPACE (`as` ID)?
    	
<a id="VocabularyUsage-Syntax">VocabularyUsage</a>:
	Annotation*
	`uses` NAMESPACE (`as` ID)?
    	
<a id="VocabularyBundleImport-Syntax">VocabularyBundleImport</a>:
	VocabularyBundleExtension |
	VocabularyBundleInclusion

<a id="VocabularyBundleInclusion-Syntax">VocabularyBundleInclusion</a>:
	Annotation*
	`includes` NAMESPACE (`as` ID)?

<a id="VocabularyBundleExtension-Syntax">VocabularyBundleExtension</a>:
	Annotation*
	`extends` NAMESPACE (`as` ID)?

<a id="DescriptionImport-Syntax">DescriptionImport</a>:
	DescriptionExtension |
	DescriptionUsage

<a id="DescriptionUsage-Syntax">DescriptionUsage</a>:
	Annotation*
	`uses` NAMESPACE (`as` ID)?

<a id="DescriptionExtension-Syntax">DescriptionExtension</a>:
	Annotation*
	`extends` NAMESPACE (`as` ID)?

<a id="DescriptionBundleImport-Syntax">DescriptionBundleImport</a>:
	DescriptionBundleExtension |
	DescriptionBundleInclusion |
	DescriptionBundleUsage

<a id="DescriptionBundleInclusion-Syntax">DescriptionBundleInclusion</a>:
	Annotation*
	`includes` NAMESPACE (`as` ID)?

<a id="DescriptionBundleExtension-Syntax">DescriptionBundleExtension</a>:
	Annotation*
	`extends` NAMESPACE (`as` ID)?

<a id="DescriptionBundleUsage-Syntax">DescriptionBundleUsage</a>:
	Annotation*
	`uses` NAMESPACE (`as` ID)?

<a id="VocabularyStatement-Syntax">VocabularyStatement</a>:
	SpecializableTerm |
	Rule |
	SpecializableTermReference |
	RuleReference |
	RelationReference

<a id="SpecializableTerm-Syntax">SpecializableTerm</a>:
	Type |
	Property
	
<a id="Type-Syntax">Type</a>:
	Classifier |
	Scalar	

<a id="Classifier-Syntax">Classifier</a>:
	Entity |
	Structure
	
<a id="Entity-Syntax">Entity</a>:
	Aspect |
	Concept |
	RelationEntity

<a id="Aspect-Syntax">Aspect</a>:
	Annotation*
	`aspect` ID (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		KeyAxiom* 
		PropertyRestrictionAxiom*
		RelationRestrictionAxiom*
	`]`)?

<a id="Concept-Syntax">Concept</a>:
	Annotation*
	`concept` ID (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		KeyAxiom* 
		PropertyRestrictionAxiom*
		RelationRestrictionAxiom*
	`]`)?
	
<a id="RelationEntity-Syntax">RelationEntity</a>:
	Annotation*
	`relation` `entity` ID (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? `[`
		`from` [Entity|REF]
		`to` [Entity|REF]
		ForwardRelation?
		ReverseRelation?
		`functional`?
		(`inverse` `functional`)?
		`symmetric`?
		`asymmetric`?
		`reflexive`?
		`irreflexive`?
		`transitive`?
		KeyAxiom*
		PropertyRestrictionAxiom*
		RelationRestrictionAxiom*
	`]`

<a id="ForwardRelation-Syntax">ForwardRelation</a>:
	Annotation*
	`forward` ID

<a id="ReverseRelation-Syntax">ReverseRelation</a>:
	Annotation*
	`reverse` ID

<a id="Structure-Syntax">Structure</a>:
	Annotation*
	`structure` ID (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		PropertyRestrictionAxiom*
	`]`)?

<a id="Scalar-Syntax">Scalar</a>:
	FacetedScalar |
	EnumeratedScalar

<a id="FacetedScalar-Syntax">FacetedScalar</a>:
	Annotation*
	`scalar` ID (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		 (`length` UnsignedInteger)?
		 (`minLength` UnsignedInteger)?
		 (`maxLength` UnsignedInteger)?
		 (`pattern` STRING)?
		 (`language` ID)?
		 (`minInclusive` Literal)?
		 (`minExclusive` Literal)?
		 (`maxInclusive` Literal)?
		 (`maxExclusive` Literal)?
	`]`)?

<a id="EnumeratedScalar-Syntax">EnumeratedScalar</a>:
	Annotation*
	`enumerated` `scalar` ID (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		Literal (`,` Literal)*
	`]`)?

<a id="Property-Syntax">Property</a>:
	AnnotationProperty |
	SemanticProperty

<a id="AnnotationProperty-Syntax">AnnotationProperty</a>:
	Annotation*
	`annotation` `property` ID (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)?

<a id="SemanticProperty-Syntax">SemanticProperty</a>:
	ScalarProperty |
	StructuredProperty

<a id="ScalarProperty-Syntax">ScalarProperty</a>:
	Annotation*
	`scalar` `property` ID (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		`domain` [Classifier|REF]
		`range` [Scalar|REF]
		`functional`?
	`]`)?

<a id="StructuredProperty-Syntax">StructuredProperty</a>:
	Annotation*
	`structured` `property` ID (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		`domain` [Classifier|REF]
		`range` [Structure|REF]
		`functional`?
	`]`)?

<a id="Rule-Syntax">Rule</a>:
	Annotation*
	`rule` ID `[`
		Predicate (`^` Predicate)* `->` Predicate (`^` Predicate)*
	`]`

<a id="Predicate-Syntax">Predicate</a>:
	UnaryPredicate |
	BinaryPredicate

<a id="UnaryPredicate-Syntax">UnaryPredicate</a>:
	TypePredicate
	
<a id="TypePredicate-Syntax">TypePredicate</a>:
	[Type|REF] `(` ID `)`
	
<a id="BinaryPredicate-Syntax">BinaryPredicate</a>:
	RelationEntityPredicate |
    FeaturePredicate |
    SameAsPredicate |
    DifferentFromPredicate

<a id="RelationEntityPredicate-Syntax">RelationEntityPredicate</a>:
	[RelationEntity|REF] `(` ID `,` ID `,` ID `)`

<a id="FeaturePredicate-Syntax">FeaturePredicate</a>:
	[Feature|REF] `(` ID `,` ID `)`

<a id="SameAsPredicate-Syntax">SameAsPredicate</a>:
	`sameAs` `(` ID `,` ID `)`

<a id="DifferentFromPredicate-Syntax">DifferentFromPredicate</a>:
	`differentFrom` `(` ID `,` ID `)`

<a id="DescriptionStatement-Syntax">DescriptionStatement</a>:
	NamedInstance |
	NamedInstanceReference
	
<a id="NamedInstance-Syntax">NamedInstance</a>:
	ConceptInstance |
	RelationInstance

<a id="ConceptInstance-Syntax">ConceptInstance</a>:
	Annotation*
	`ci` ID (`:` ConceptTypeAssertion (`,` ConceptTypeAssertion)*)? (`[`
		PropertyValueAssertion*
		LinkAssertion*
	`]`)?
	
<a id="RelationInstance-Syntax">RelationInstance</a>:
	Annotation*
	`ri` ID (`:` RelationTypeAssertion (`,` RelationTypeAssertion)*)? `[`
		`from` [NamedInstance|REF] (`,` [NamedInstance|REF])* 
		`to` [NamedInstance|REF] (`,` [NamedInstance|REF])*
		PropertyValueAssertion*
		LinkAssertion*
	`]`

<a id="StructureInstance-Syntax">StructureInstance</a>:
	type=[Structure|REF] `[`
		PropertyValueAssertion*
	`]`

<a id="SpecializableTermReference-Syntax">SpecializableTermReference</a>:
	ClassifierReference |
	FacetedScalarReference |
	EnumeratedScalarReference |
	AnnotationPropertyReference |
	ScalarPropertyReference |
	StructuredPropertyReference

<a id="ClassifierReference-Syntax">ClassifierReference</a>:
	EntityReference |
	StructureReference

<a id="EntityReference-Syntax">EntityReference</a>:
	AspectReference |
	ConceptReference |
	RelationEntityReference
	
<a id="AspectReference-Syntax">AspectReference</a>:
	Annotation*
	`ref` `aspect` [Aspect|REF] (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		KeyAxiom* 
		PropertyRestrictionAxiom*
		RelationRestrictionAxiom*
	`]`)?

<a id="ConceptReference-Syntax">ConceptReference</a>:
	Annotation*
	`ref` `concept` [Concept|REF] (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		KeyAxiom* 
		PropertyRestrictionAxiom*
		RelationRestrictionAxiom*
	`]`)?

<a id="RelationEntityReference-Syntax">RelationEntityReference</a>:
	Annotation*
	`ref` `relation` `entity` [RelationEntity|REF] (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		KeyAxiom* 
		PropertyRestrictionAxiom*
		RelationRestrictionAxiom*
	`]`)?

<a id="StructureReference-Syntax">StructureReference</a>:
	Annotation*
	`ref` `structure` [Structure|REF] (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)? (`[`
		PropertyRestrictionAxiom*
	`]`)?

<a id="AnnotationPropertyReference-Syntax">AnnotationPropertyReference</a>:
	Annotation*
	`ref` `annotation` `property` [AnnotationProperty|REF] (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)?

<a id="ScalarPropertyReference-Syntax">ScalarPropertyReference</a>:
	Annotation*
	`ref` `scalar` `property` [ScalarProperty|REF] (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)?

<a id="StructuredPropertyReference-Syntax">StructuredPropertyReference</a>:
	Annotation*
	`ref` `structured` `property` [StructuredProperty|REF] (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)?

<a id="FacetedScalarReference-Syntax">FacetedScalarReference</a>:
	Annotation*
	`ref` `scalar` [FacetedScalar|REF] (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)?

<a id="EnumeratedScalarReference-Syntax">EnumeratedScalarReference</a>:
	Annotation*
	`ref` `enumerated` `scalar` [EnumeratedScalar|REF] (`:>` SpecializationAxiom (`,` SpecializationAxiom)*)?

<a id="RelationReference-Syntax">RelationReference</a>:
	Annotation*
	`ref` `relation` [Relation|REF]
	
<a id="RuleReference-Syntax">RuleReference</a>:
	Annotation*
	`ref` `rule` [Rule|REF]

<a id="NamedInstanceReference-Syntax">NamedInstanceReference</a>:
	ConceptInstanceReference |
	RelationInstanceReference

<a id="ConceptInstanceReference-Syntax">ConceptInstanceReference</a>:
	Annotation*
	`ref` `ci` [ConceptInstance|REF] (`:` ConceptTypeAssertion (`,` ConceptTypeAssertion)*)? (`[`
		PropertyValueAssertion*
		LinkAssertion*
	`]`)?

<a id="RelationInstanceReference-Syntax">RelationInstanceReference</a>:
	Annotation*
	`ref` `ri` [RelationInstance|REF] (`:` RelationTypeAssertion (`,` RelationTypeAssertion)*)? (`[`
		PropertyValueAssertion*
		LinkAssertion*
	`]`)?

<a id="SpecializationAxiom-Syntax">SpecializationAxiom</a>:
	[SpecializableTerm|REF]
	
<a id="PropertyRestrictionAxiom-Syntax">PropertyRestrictionAxiom</a>:
	ScalarPropertyRestrictionAxiom |
	StructuredPropertyRestrictionAxiom

<a id="ScalarPropertyRestrictionAxiom-Syntax">ScalarPropertyRestrictionAxiom</a>:
	ScalarPropertyRangeRestrictionAxiom |
	ScalarPropertyCardinalityRestrictionAxiom |
	ScalarPropertyValueRestrictionAxiom

<a id="ScalarPropertyRangeRestrictionAxiom-Syntax">ScalarPropertyRangeRestrictionAxiom</a>:
	`restricts` RangeRestrictionKind `scalar` `property` [ScalarProperty|REF] `to` [Scalar|REF]

<a id="ScalarPropertyCardinalityRestrictionAxiom-Syntax">ScalarPropertyCardinalityRestrictionAxiom</a>:
	`restricts` `scalar` `property` [ScalarProperty|REF] `to` CardinalityRestrictionKind UnsignedInteger ([Scalar|REF])?

<a id="ScalarPropertyValueRestrictionAxiom-Syntax">ScalarPropertyValueRestrictionAxiom</a>:
	`restricts` `scalar` `property` [ScalarProperty|REF] `to` Literal

<a id="StructuredPropertyRestrictionAxiom-Syntax">StructuredPropertyRestrictionAxiom</a>:
	StructuredPropertyRangeRestrictionAxiom |
	StructuredPropertyCardinalityRestrictionAxiom |
	StructuredPropertyValueRestrictionAxiom

<a id="StructuredPropertyRangeRestrictionAxiom-Syntax">StructuredPropertyRangeRestrictionAxiom</a>:
	`restricts` RangeRestrictionKind `structured` `property` [StructuredProperty|REF] `to` [Structure|REF]

<a id="StructuredPropertyCardinalityRestrictionAxiom-Syntax">StructuredPropertyCardinalityRestrictionAxiom</a>:
	`restricts` `structured` `property` [StructuredProperty|REF] `to` CardinalityRestrictionKind UnsignedInteger [Structure|REF]?

<a id="StructuredPropertyValueRestrictionAxiom-Syntax">StructuredPropertyValueRestrictionAxiom</a>:
	`restricts` `structured` `property` [StructuredProperty|REF] `to` StructureInstance

<a id="RelationRestrictionAxiom-Syntax">RelationRestrictionAxiom</a>:
	RelationRangeRestrictionAxiom |
	RelationCardinalityRestrictionAxiom |
	RelationTargetRestrictionAxiom
	
<a id="RelationRangeRestrictionAxiom-Syntax">RelationRangeRestrictionAxiom</a>:
	`restricts` RangeRestrictionKind `relation` [Relation|REF] `to` [Entity|REF]

<a id="RelationCardinalityRestrictionAxiom-Syntax">RelationCardinalityRestrictionAxiom</a>:
	`restricts` `relation` [Relation|REF] `to` CardinalityRestrictionKind UnsignedInteger [Entity|REF]?

<a id="RelationTargetRestrictionAxiom-Syntax">RelationTargetRestrictionAxiom</a>:
	`restricts` `relation` [Relation|REF] `to` [NamedInstance|REF]

<a id="KeyAxiom-Syntax">KeyAxiom</a>:
	`key` [ScalarProperty|REF] (`,` [ScalarProperty|REF])*

<a id="ConceptTypeAssertion-Syntax">ConceptTypeAssertion</a>:
	[Concept|REF]

<a id="RelationTypeAssertion-Syntax">RelationTypeAssertion</a>:
	[RelationEntity|REF]

<a id="PropertyValueAssertion-Syntax">PropertyValueAssertion</a>:
	ScalarPropertyValueAssertion |
	StructuredPropertyValueAssertion

<a id="ScalarPropertyValueAssertion-Syntax">ScalarPropertyValueAssertion</a>:
	[ScalarProperty|REF] Literal

<a id="StructuredPropertyValueAssertion-Syntax">StructuredPropertyValueAssertion</a>:
	[StructuredProperty|REF] StructureInstance

<a id="LinkAssertion-Syntax">LinkAssertion</a>:
	[Relation|REF] [NamedInstance|REF]

<a id="Annotation-Syntax">Annotation</a>:
	`@` [AnnotationProperty|REF] Literal?

<a id="Literal-Syntax">Literal</a>:
	IntegerLiteral |
	DecimalLiteral |
	DoubleLiteral |
	BooleanLiteral |
	QuotedLiteral

<a id="IntegerLiteral-Syntax">IntegerLiteral</a>:
	Integer

<a id="DecimalLiteral-Syntax">DecimalLiteral</a>:
	Decimal

<a id="DoubleLiteral-Syntax">DoubleLiteral</a>:
	Double

<a id="BooleanLiteral-Syntax">BooleanLiteral</a>:
	Boolean

<a id="QuotedLiteral-Syntax">QuotedLiteral</a>:
	STRING ((`^^` [Scalar|REF]) | (`$` ID))?

<a id="RangeRestrictionKind-Syntax">RangeRestrictionKind</a>: 
	`all` | `some`

<a id="CardinalityRestrictionKind-Syntax">CardinalityRestrictionKind</a>: 
	`exactly` | `min` | `max`

<span id="Boolean-Syntax">Boolean</span>: 
	BOOLEAN_STR

<span id="UnsignedInteger-Syntax">UnsignedInteger</span>: 
	UNSIGNED_INTEGER_STR

<span id="Integer-Syntax">Integer</span>: 
	UNSIGNED_INTEGER_STR | 
	INTEGER_STR

<span id="Decimal-Syntax">Decimal</span>: 
	DECIMAL_STR

<span id="Double-Syntax">Double</span>: 
	DOUBLE_STR

<span id="BOOLEAN_STR-Syntax">BOOLEAN_STR</span>: 
	`false` | `true`

<span id="UNSIGNED_INTEGER_STR-Syntax">UNSIGNED_INTEGER_STR</span>: 
	DIGIT+

<span id="INTEGER_STR-Syntax">INTEGER_STR</span>: 
	(`+`|`-`)? DIGIT+

<span id="DECIMAL_STR-Syntax">DECIMAL_STR</span>: 
	(`+`|`-`)? (DIGIT+(`.`DIGIT*)? | (`.`DIGIT+))

<span id="DOUBLE_STR-Syntax">DOUBLE_STR</span>: 
	(`+`|`-`)? (DIGIT+(`.`DIGIT*)? | (`.`DIGIT+)) ((`e`|`E`) (`+`|`-`)? DIGIT+)?

<span id="STRING-Syntax">STRING</span>: 
	(`"` -> `"`) | (`'` -> `'`) | (`'''` -> `'''`) | (`"""` -> `"""`)

<span id="NAMESPACE-Syntax">NAMESPACE</span>: 
	`<` (!(`>`|\s|`#`))* (`#`|`/`) `>`

<span id="Ref-Syntax">REF</span>: 
	ID | ABBREVIATED_IRI | IRI

<span id="ID-Syntax">ID</span>: 
	`^`? (ALPHA|DIGIT|`_`) (ALPHA|DIGIT|`_`|`-`|`.`|`$`)*

<span id="IRI-Syntax">IRI</span>: 
	`<` (!(`>`|\s))* `>`

<span id="ABBREVIATED_IRI-Syntax">ABBREVIATED_IRI</span>: 
	ID `:` ID

<span id="ALPHA-Syntax">ALPHA</span>: 
	`a`..`z` | `A`..`Z`

<span id="DIGIT-Syntax">DIGIT</span>: 
	`0`..`9`

</pre>