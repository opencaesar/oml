# Textual BNF # {#Textual-BNF}

<pre class="highlight highlight-html">

&lt;<a id="Ontology-Syntax">Ontology</a>&gt;:
	VocabularyBox |
	DescriptionBox

&lt;<a id="Annotation-Syntax">Annotation</a>&gt;:
	`@` [AnnotationProperty|IRI] (Literal | [Member|IRI])?

&lt;<a id="VocabularyBox-Syntax">VocabularyBox</a>&gt;:
	Vocabulary |
	VocabularyBundle

&lt;<a id="Vocabulary-Syntax">Vocabulary</a>&gt;:
	Annotation*
	`vocabulary` NAMESPACE `as` ID  `{`
		(Extension|Usage)*
		VocabularyStatement*
	`}`

&lt;<a id="VocabularyBundle-Syntax">VocabularyBundle</a>&gt;:
	Annotation*
	`vocabulary` `bundle` NAMESPACE `as` ID `{`
		(Extension|Inclusion)*
	`}`

&lt;<a id="DescriptionBox-Syntax">DescriptionBox</a>&gt;:
	Description |
	DescriptionBundle
	
&lt;<a id="Description-Syntax">Description</a>&gt;:
	Annotation*
	`description` NAMESPACE `as` ID `{`
		(Extension|Usage)*
		DescriptionStatement*
	`}`

&lt;<a id="DescriptionBundle-Syntax">DescriptionBundle</a>&gt;:
	Annotation*
	`description` `bundle` NAMESPACE `as` ID `{`
		(Extension|Usage|Inclusion)*
	`}`

&lt;<a id="SpecializableTerm-Syntax">SpecializableTerm</a>&gt;:
	Type |
	AnnotationProperty |
	ScalarProperty |
	StructuredProperty |
	UnreifiedRelation

&lt;<a id="Type-Syntax">Type</a>&gt;:
	Classifier |
	Scalar	

&lt;<a id="Classifier-Syntax">Classifier</a>&gt;:
	Entity |
	Structure
	
&lt;<a id="Entity-Syntax">Entity</a>&gt;:
	Aspect |
	Concept |
	RelationEntity

&lt;<a id="Aspect-Syntax">Aspect</a>&gt;:
	Annotation*
	(`aspect` ID | `ref` `aspect` [Aspect|IRI]) (`[`
		(KeyAxiom)* 
	`]`)? (ClassifierSpecialization)? (ClassifierEquivalence)?

&lt;<a id="Concept-Syntax">Concept</a>&gt;:
	Annotation*
	(`concept` ID | `ref` `concept` [Concept|IRI]) (`[`
		(InstanceEnumerationAxiom)?
		(KeyAxiom)* 
	`]`)? (ClassifierSpecialization)? (ClassifierEquivalence)?
	
&lt;<a id="RelationEntity-Syntax">RelationEntity</a>&gt;:
	Annotation*
	(`relation` `entity` ID | `ref` `relation` `entity` [RelationEntity|IRI]) (`[`
		(`from` [Entity|IRI] (`,` [Entity|IRI])*)?
		(`to` [Entity|IRI] (`,` [Entity|IRI])*)?
		(ForwardRelation)?
		(ReverseRelation)?
		(`functional`)?
		(`inverse` `functional`)?
		(`symmetric`)?
		(`asymmetric`)?
		(`reflexive`)?
		(`irreflexive`)?
		(`transitive`)?
		(KeyAxiom)*
	`]`)? (ClassifierSpecialization)? (ClassifierEquivalence)?
	
&lt;<a id="Structure-Syntax">Structure</a>&gt;:
	Annotation*
	(`structure` ID | `ref` `structure` [Structure|IRI])
		(ClassifierSpecialization)? (ClassifierEquivalence)?

&lt;<span id="ClassifierSpecialization-Syntax">ClassifierSpecialization</span>&gt;:
	`<` (Classifier (`,` Classifier)* 
		|
		(Classifier (`,` Classifier)*)? `[`
			PropertyRestrictionAxiom*
		`]`)

&lt;<span id="ClassifierEquivalence-Syntax">ClassifierEquivalence</span>&gt;:
	`=` ClassifierEquivalenceAxiom (`,` ClassifierEquivalenceAxiom)*

&lt;<a id="ClassifierEquivalenceAxiom-Syntax">ClassifierEquivalenceAxiom</a>&gt;:
	[Classifier|IRI] (`&` [Classifier|IRI])*
	|
	{ClassifierEquivalenceAxiom} 
	([Classifier|IRI] (`&` [Classifier|IRI])*)? `[`
		PropertyRestrictionAxiom*
	`]`

&lt;<a id="Scalar-Syntax">Scalar</a>&gt;:
	Annotation*
	(`scalar` ID | `ref` `scalar` [Scalar|IRI]) (`[`
		 (LiteralEnumerationAxiom)?
	`]`)? (ScalarSpecialization)? (ScalarEquivalence)?

&lt;<span id="ScalarSpecialization-Syntax">ScalarSpecialization</span>&gt;:
	`<` Scalar (`,` Scalar)*

&lt;<span id="ScalarEquivalence-Syntax">ScalarEquivalence</span>&gt;:
	`=` ScalarEquivalenceAxiom (`,` ScalarEquivalenceAxiom)*;

&lt;<span id="ScalarEquivalenceAxiom-Syntax">ScalarEquivalenceAxiom</span>&gt;:
	[Scalar|IRI] (`[`
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

&lt;<a id="Property-Syntax">Property</a>&gt;:
	AnnotationProperty |
	SemanticProperty

&lt;<a id="AnnotationProperty-Syntax">AnnotationProperty</a>&gt;:
	Annotation*
	(`annotation` `property` ID | `ref` `annotation` `property` [AnnotationProperty|IRI])
		(PropertySpecialization)? (PropertyEquivalence)?

&lt;<a id="SemanticProperty-Syntax">SemanticProperty</a>&gt;:
	ScalarProperty |
	StructuredProperty |
	Relation

&lt;<a id="ScalarProperty-Syntax">ScalarProperty</a>&gt;:
	Annotation*
	(`scalar` `property` ID | `ref` `scalar` `property` [ScalarProperty|IRI]) (`[`
		(`domain` [Classifier|IRI] (`,` [Classifier|IRI])*)?
		(`range` [Scalar|IRI] (`,` [Scalar|IRI])*)?
		(`functional`)?
	`]`)? (PropertySpecialization)? (PropertyEquivalence)?

&lt;<a id="StructuredProperty-Syntax">StructuredProperty</a>&gt;:
	Annotation*
	(`structured` `property` ID | `ref` `structured` `property` [StructuredProperty|IRI]) (`[`
		(`domain` [Classifier|IRI] (`,` [Classifier|IRI])*)?
		(`range` [Structure|IRI] (`,` [Structure|IRI])*)?
		(`functional`)?
	`]`)? (PropertySpecialization)? (PropertyEquivalence)?

&lt;<a id="Relation-Syntax">Relation</a>&gt;:
	ForwardRelation |
	ReverseRelation |
	UnreifiedRelation

&lt;<a id="ForwardRelation-Syntax">ForwardRelation</a>&gt;:
	Annotation*
	`forward` ID

&lt;<a id="ReverseRelation-Syntax">ReverseRelation</a>&gt;:
	Annotation*
	`reverse` ID

&lt;<a id="UnreifiedRelation-Syntax">UnreifiedRelation</a>&gt;:
	Annotation*
	(`relation` ID | `ref` `relation` [Relation|IRI]) (`[`
		(`from` [Entity|IRI] (`,` [Entity|IRI])*)?
		(`to` [Entity|IRI] (`,` [Entity|IRI])*)?
		(ReverseRelation)?
		(`functional`)? 
		(`inverse` `functional`)?
		(`symmetric`)?
		(`asymmetric`)?
		(`reflexive`)?
		(`irreflexive`)?
		(`transitive`)?
	`]`)? (PropertySpecialization)? (PropertyEquivalence)?

&lt;<span id="PropertySpecialization-Syntax">PropertySpecialization</span>&gt;:
	`<` Property (`,` Property)*

&lt;<span id="PropertyEquivalence-Syntax">PropertyEquivalence</span>&gt;:
	`=` PropertyEquivalenceAxiom (`,` PropertyEquivalenceAxiom)*

&lt;<a id="PropertyEquivalenceAxiom-Syntax">PropertyEquivalenceAxiom</a>&gt;:
	[Property|IRI]

&lt;<a id="Rule-Syntax">Rule</a>&gt;:
	Annotation*
	(`rule` ID | `ref` `rule` [Rule|IRI]) (`[`
		(Predicate (`&` Predicate)* `->` Predicate (`&` Predicate)*)?
	`]`)?

&lt;<a id="BuiltIn-Syntax">BuiltIn</a>&gt;:
	Annotation*
	(`builtin` ID | `ref` `builtin` [BuiltIn|IRI])

&lt;<a id="StructureInstance-Syntax">StructureInstance</a>&gt;:	
	[Structure|IRI] `[`
		PropertyValueAssertion*
	`]`
	
&lt;<a id="NamedInstance-Syntax">NamedInstance</a>&gt;:
	ConceptInstance |
	RelationInstance

&lt;<a id="ConceptInstance-Syntax">ConceptInstance</a>&gt;:
	Annotation*
	(`instance` ID | `ref` `instance` [ConceptInstance|IRI]) (`:` ConceptTypeAssertion (`,` ConceptTypeAssertion)*)? (`[`
		PropertyValueAssertion*
	`]`)?
	
&lt;<a id="RelationInstance-Syntax">RelationInstance</a>&gt;:
	Annotation*
	(`relation` `instance` ID | `ref` `relation` `instance` [RelationInstance|IRI]) (`:` RelationTypeAssertion (`,` RelationTypeAssertion)*)? (`[`
		(`from` [NamedInstance|IRI] (`,` [NamedInstance|IRI])*)? 
		(`to` [NamedInstance|IRI] (`,` [NamedInstance|IRI])*)?
		PropertyValueAssertion*
	`]`)?

&lt;<a id="Member-Syntax">Member</a>&gt;:
	VocabularyMember |
	DescriptionMember |
	Statement

&lt;<a id="VocabularyMember-Syntax">VocabularyMember</a>&gt;:
	VocabularyStatement |
	Term

&lt;<a id="DescriptionMember-Syntax">DescriptionMember</a>&gt;:
	DescriptionStatement

&lt;<a id="Statement-Syntax">Statement</a>&gt;:
	VocabularyStatement |
	DescriptionStatement

&lt;<a id="VocabularyStatement-Syntax">VocabularyStatement</a>&gt;:
	Rule |
	BuiltIn |
	SpecializableTerm
	
&lt;<a id="DescriptionStatement-Syntax">DescriptionStatement</a>&gt;:
	NamedInstance

&lt;<a id="Term-Syntax">Term</a>&gt;:
	Property |
	SpecializableTerm

&lt;<a id="Import-Syntax">Import</a>&gt;:
	Extension |
	Usage |
	Inclusion

&lt;<span id="Extension-Syntax">Extension</span>&gt;:
	Extends NAMESPACE (`as` ID)?
    	
&lt;<span id="Usage-Syntax">Usage</span>&gt;:
	Uses NAMESPACE (`as` ID)?
    	
&lt;<span id="Inclusion-Syntax">Inclusion</span>&gt;:
	Includes NAMESPACE (`as` ID)?

&lt;<a id="PropertyRestrictionAxiom-Syntax">PropertyRestrictionAxiom</a>&gt;:
	PropertySelfRestrictionAxiom |
	PropertyRangeRestrictionAxiom |
	PropertyCardinalityRestrictionAxiom |
	PropertyValueRestrictionAxiom

&lt;<a id="PropertyRangeRestrictionAxiom-Syntax">PropertyRangeRestrictionAxiom</a>&gt;:
	`restricts` RangeRestrictionKind [SemanticProperty|IRI] `to` [Type|IRI]

&lt;<a id="PropertyCardinalityRestrictionAxiom-Syntax">PropertyCardinalityRestrictionAxiom</a>&gt;:
	`restricts` [SemanticProperty|IRI] `to` CardinalityRestrictionKind UnsignedInteger ([Type|IRI])?

&lt;<a id="PropertyValueRestrictionAxiom-Syntax">PropertyValueRestrictionAxiom</a>&gt;:
	`restricts` [SemanticProperty|IRI] `to` (Literal | StructureInstance | [NamedInstance|IRI])

&lt;<a id="PropertySelfRestrictionAxiom-Syntax">PropertySelfRestrictionAxiom</a>&gt;:
	`restricts` [SemanticProperty|IRI] `to` `self`

&lt;<a id="KeyAxiom-Syntax">KeyAxiom</a>&gt;:
	`key` [Property|IRI] (`,` [Property|IRI])*

&lt;<a id="InstanceEnumerationAxiom-Syntax">InstanceEnumerationAxiom</a>&gt;:
	`oneOf` [ConceptInstance|IRI] (`,` [ConceptInstance|IRI])*

&lt;<a id="LiteralEnumerationAxiom-Syntax">LiteralEnumerationAxiom</a>&gt;:
	`oneOf` Literal (`,` Literal)*

&lt;<span id="ConceptTypeAssertion-Syntax">ConceptTypeAssertion</span>&gt;:
	[Concept|IRI]

&lt;<span id="RelationTypeAssertion-Syntax">RelationTypeAssertion</span>&gt;:
	[RelationEntity|IRI]

&lt;<a id="PropertyValueAssertion-Syntax">PropertyValueAssertion</a>&gt;:
	[SemanticProperty|IRI] (Literal | StructureInstance | [NamedInstance|IRI])

&lt;<a id="Predicate-Syntax">Predicate</a>&gt;:
	UnaryPredicate |
	BinaryPredicate |
	BuiltInPredicate

&lt;<a id="UnaryPredicate-Syntax">UnaryPredicate</a>&gt;:
	TypePredicate |
	RelationEntityPredicate
	
&lt;<a id="BinaryPredicate-Syntax">BinaryPredicate</a>&gt;:
    PropertyPredicate |
    SameAsPredicate |
    DifferentFromPredicate

&lt;<a id="TypePredicate-Syntax">TypePredicate</a>&gt;:
	[Type|IRI] `(` Argument `)`
	
&lt;<a id="RelationEntityPredicate-Syntax">RelationEntityPredicate</a>&gt;:
    [RelationEntity|IRI] `(` Argument `,` Argument `,` Argument `)`

&lt;<a id="PropertyPredicate-Syntax">PropertyPredicate</a>&gt;:
	[Property|IRI] `(` Argument `,` Argument `)`

&lt;<a id="SameAsPredicate-Syntax">SameAsPredicate</a>&gt;:
    `sameAs` `(` Argument `,` Argument `)`

&lt;<a id="DifferentFromPredicate-Syntax">DifferentFromPredicate</a>&gt;:
    `differentFrom` `(` Argument `,` Argument `)`

&lt;<a id="BuiltInPredicate-Syntax">BuiltInPredicate</a>&gt;:
    `builtIn` `(` [BuiltIn|IRI] `,` Argument (`,` Argument)* `)`

&lt;<a id="Argument-Syntax">Argument</a>&gt;:
	ID | Literal | [NamedInstance|REF]


&lt;<a id="Literal-Syntax">Literal</a>&gt;:
	IntegerLiteral |
	DecimalLiteral |
	DoubleLiteral |
	BooleanLiteral |
	QuotedLiteral

&lt;<a id="IntegerLiteral-Syntax">IntegerLiteral</a>&gt;:
	Integer

&lt;<a id="DecimalLiteral-Syntax">DecimalLiteral</a>&gt;:
	Decimal

&lt;<a id="DoubleLiteral-Syntax">DoubleLiteral</a>&gt;:
	Double

&lt;<a id="BooleanLiteral-Syntax">BooleanLiteral</a>&gt;:
	Boolean

&lt;<a id="QuotedLiteral-Syntax">QuotedLiteral</a>&gt;:
	STRING ((`^^` [Scalar|IRI]) | (`$` ID))?

&lt;<a id="RangeRestrictionKind-Syntax">RangeRestrictionKind</a>&gt;:
	all |
	some

&lt;<a id="CardinalityRestrictionKind-Syntax">CardinalityRestrictionKind</a>&gt;:
	exactly |
	min |
	max

&lt;<span id="Extends-Syntax">Extends</span>&gt;:
	`extends`

&lt;<span id="Uses-Syntax">Uses</span>&gt;:
	`uses`

&lt;<span id="Includes-Syntax">Includes</span>&gt;:
	`includes`

&lt;<span id="Boolean-Syntax">Boolean</span>&gt;: 
	BOOLEAN_STR

&lt;<span id="UnsignedInteger-Syntax">UnsignedInteger</span>&gt;: 
	UNSIGNED_INTEGER_STR

&lt;<span id="Integer-Syntax">Integer</span>&gt;: 
	UNSIGNED_INTEGER_STR | INTEGER_STR

&lt;<span id="Decimal-Syntax">Decimal</span>&gt;:
	DECIMAL_STR

&lt;<span id="Double-Syntax">Double</span>&gt;:
	DOUBLE_STR

&lt;<span id="BOOLEAN_STR-Syntax">BOOLEAN_STR</span>&gt;: 
	`false` | `true`

&lt;<span id="UNSIGNED_INTEGER_STR-Syntax">UNSIGNED_INTEGER_STR</span>&gt;: 
	DIGIT+

&lt;<span id="INTEGER_STR-Syntax">INTEGER_STR</span>&gt;: 
	(`+`|`-`)? DIGIT+

&lt;<span id="DECIMAL_STR-Syntax">DECIMAL_STR</span>&gt;: 
	(`+`|`-`)? (DIGIT+(`.`DIGIT*)? | (`.`DIGIT+))

&lt;<span id="DOUBLE_STR-Syntax">DOUBLE_STR</span>&gt;: 
	(`+`|`-`)? (DIGIT+(`.`DIGIT*)? | (`.`DIGIT+)) ((`e`|`E`) (`+`|`-`)? DIGIT+)?

&lt;<span id="STRING-Syntax">STRING</span>&gt;: 
	(`"` -> `"`) | (`'` -> `'`) | (`'''` -> `'''`) | (`"""` -> `"""`)

&lt;<span id="NAMESPACE-Syntax">NAMESPACE</span>&gt;: 
	`<` (!(`>`|\s|`#`))* (`#`|`/`) `>`

&lt;<span id="IRI-Syntax">IRI</span>&gt;: 
	ID | REF

&lt;<span id="REF-Syntax">REF</span>&gt;:
	FULL_IRI | ABBREVIATED_IRI

&lt;<span id="FULL_IRI-Syntax">FULL_IRI</span>&gt;: 
	`<` (!(`>`|\s|`#`))* `>`

&lt;<span id="ABBREVIATED_IRI-Syntax">ABBREVIATED_IRI</span>&gt;: 
	ID `:` ID

&lt;<span id="ID-Syntax">ID</span>&gt;: 
	`^`? (ALPHA|DIGIT|`_`) (ALPHA|DIGIT|`_`|`-`|`.`|`$`)*

&lt;<span id="ALPHA-Syntax">ALPHA</span>&gt;: 
	`a`..`z` | `A`..`Z`

&lt;<span id="DIGIT-Syntax">DIGIT</span>&gt;: 
	`0`..`9`

</pre>