# Textual BNF # {#Textual-BNF}

<pre class="highlight highlight-html">

<a id="Ontology-Syntax">Ontology</a> ::=
	VocabularyBox |
	DescriptionBox

<a id="Annotation-Syntax">Annotation</a> ::=
	"@" [AnnotationProperty|IRI] ((Literal | [Member|IRI]) ("," (Literal | [Member|IRI]))*)?

<a id="VocabularyBox-Syntax">VocabularyBox</a> ::=
	Vocabulary |
	VocabularyBundle

<a id="Vocabulary-Syntax">Vocabulary</a> ::=
	Annotation*
	"vocabulary" NAMESPACE "as" ID  "{"
		(Extension|Usage)*
		VocabularyStatement*
	"}"

<a id="VocabularyBundle-Syntax">VocabularyBundle</a> ::=
	Annotation*
	"vocabulary" "bundle" NAMESPACE "as" ID "{"
		(Extension|Inclusion)*
	"}"

<a id="DescriptionBox-Syntax">DescriptionBox</a> ::=
	Description |
	DescriptionBundle
	
<a id="Description-Syntax">Description</a> ::=
	Annotation*
	"description" NAMESPACE "as" ID "{"
		(Extension|Usage)*
		DescriptionStatement*
	"}"

<a id="DescriptionBundle-Syntax">DescriptionBundle</a> ::=
	Annotation*
	"description" "bundle" NAMESPACE "as" ID "{"
		(Extension|Usage|Inclusion)*
	"}"

<a id="SpecializableTerm-Syntax">SpecializableTerm</a> ::=
	Type |
	AnnotationProperty |
	ScalarProperty |
	UnreifiedRelation

<a id="Type-Syntax">Type</a> ::=
	Entity |
	Scalar	
	
<a id="Entity-Syntax">Entity</a> ::=
	Aspect |
	Concept |
	RelationEntity

<a id="Aspect-Syntax">Aspect</a> ::=
	Annotation*
	("aspect" ID | "ref" "aspect" [Aspect|IRI]) ("["
		(KeyAxiom)* 
	"]")? (EntitySpecialization)? (EntityEquivalence)?

<a id="Concept-Syntax">Concept</a> ::=
	Annotation*
	("concept" ID | "ref" "concept" [Concept|IRI]) ("["
		(InstanceEnumerationAxiom)?
		(KeyAxiom)* 
	"]")? (EntitySpecialization)? (EntityEquivalence)?
	
<a id="RelationEntity-Syntax">RelationEntity</a> ::=
	Annotation*
	("relation" "entity" ID | "ref" "relation" "entity" [RelationEntity|IRI]) ("["
		("from" [Entity|IRI] ("," [Entity|IRI])*)?
		("to" [Entity|IRI] ("," [Entity|IRI])*)?
		(ForwardRelation)?
		(ReverseRelation)?
		("functional")?
		("inverse" "functional")?
		("symmetric")?
		("asymmetric")?
		("reflexive")?
		("irreflexive")?
		("transitive")?
		(KeyAxiom)*
	"]")? (EntitySpecialization)? (EntityEquivalence)?
	
<span id="EntitySpecialization-Syntax">EntitySpecialization</span> ::=
	"<" (Entity ("," Entity)* 
		|
		(Entity ("," Entity)*)? "["
			PropertyRestrictionAxiom*
		"]")

<span id="EntityEquivalence-Syntax">EntityEquivalence</span> ::=
	"=" EntityEquivalenceAxiom ("," EntityEquivalenceAxiom)*

<a id="EntityEquivalenceAxiom-Syntax">EntityEquivalenceAxiom</a> ::=
	[Entity|IRI] ("&" [Entity|IRI])*
	|
	{EntityEquivalenceAxiom} 
	([Entity|IRI] ("&" [Entity|IRI])*)? "["
		PropertyRestrictionAxiom*
	"]"

<a id="Scalar-Syntax">Scalar</a> ::=
	Annotation*
	("scalar" ID | "ref" "scalar" [Scalar|IRI]) ("["
		 (LiteralEnumerationAxiom)?
	"]")? (ScalarSpecialization)? (ScalarEquivalence)?

<span id="ScalarSpecialization-Syntax">ScalarSpecialization</span> ::=
	"<" Scalar ("," Scalar)*

<span id="ScalarEquivalence-Syntax">ScalarEquivalence</span> ::=
	"=" ScalarEquivalenceAxiom ("," ScalarEquivalenceAxiom)*;

<span id="ScalarEquivalenceAxiom-Syntax">ScalarEquivalenceAxiom</span> ::=
	[Scalar|IRI] ("["
		 ("length" UnsignedInteger)? 
		 ("minLength" UnsignedInteger)?
		 ("maxLength" UnsignedInteger)?
		 ("pattern" STRING)?
		 ("language" ID)?
		 ("minInclusive" Literal)?
		 ("minExclusive" Literal)?
		 ("maxInclusive" Literal)?
		 ("maxExclusive" Literal)?
	"]")?

<a id="Property-Syntax">Property</a> ::=
	AnnotationProperty |
	SemanticProperty

<a id="AnnotationProperty-Syntax">AnnotationProperty</a> ::=
	Annotation*
	("annotation" "property" ID | "ref" "annotation" "property" [AnnotationProperty|IRI])
		(PropertySpecialization)? (PropertyEquivalence)?

<a id="SemanticProperty-Syntax">SemanticProperty</a> ::=
	ScalarProperty |
	Relation

<a id="ScalarProperty-Syntax">ScalarProperty</a> ::=
	Annotation*
	("scalar" "property" ID | "ref" "scalar" "property" [ScalarProperty|IRI]) ("["
		("domain" [Entity|IRI] ("," [Entity|IRI])*)?
		("range" [Scalar|IRI] ("," [Scalar|IRI])*)?
		("functional")?
	"]")? (PropertySpecialization)? (PropertyEquivalence)?

<a id="Relation-Syntax">Relation</a> ::=
	ForwardRelation |
	ReverseRelation |
	UnreifiedRelation

<a id="ForwardRelation-Syntax">ForwardRelation</a> ::=
	Annotation*
	"forward" ID

<a id="ReverseRelation-Syntax">ReverseRelation</a> ::=
	Annotation*
	"reverse" ID

<a id="UnreifiedRelation-Syntax">UnreifiedRelation</a> ::=
	Annotation*
	("relation" ID | "ref" "relation" [Relation|IRI]) ("["
		("from" [Entity|IRI] ("," [Entity|IRI])*)?
		("to" [Entity|IRI] ("," [Entity|IRI])*)?
		(ReverseRelation)?
		("functional")? 
		("inverse" "functional")?
		("symmetric")?
		("asymmetric")?
		("reflexive")?
		("irreflexive")?
		("transitive")?
	"]")? (PropertySpecialization)? (PropertyEquivalence)?

<span id="PropertySpecialization-Syntax">PropertySpecialization</span> ::=
	"<" Property ("," Property)*

<span id="PropertyEquivalence-Syntax">PropertyEquivalence</span> ::=
	"=" PropertyEquivalenceAxiom ("," PropertyEquivalenceAxiom)*

<a id="PropertyEquivalenceAxiom-Syntax">PropertyEquivalenceAxiom</a> ::=
	[Property|IRI]

<a id="Rule-Syntax">Rule</a> ::=
	Annotation*
	("rule" ID | "ref" "rule" [Rule|IRI]) ("["
		(Predicate ("&" Predicate)* "->" Predicate ("&" Predicate)*)?
	"]")?

<a id="BuiltIn-Syntax">BuiltIn</a> ::=
	Annotation*
	("builtin" ID | "ref" "builtin" [BuiltIn|IRI])

<a id="AnonymousInstance-Syntax">AnonymousInstance</a> ::=	
	AnonymousConceptInstance |
	AnonymousRelationInstance

<a id="AnonymousConceptInstance-Syntax">AnonymousConceptInstance</a> ::=	
	(":" [Entity|IRI])? "["
		PropertyValueAssertion*
	"]"
	
<a id="AnonymousRelationInstance-Syntax">AnonymousRelationInstance</a> ::=	
	[NamedInstance|IRI] "["
		PropertyValueAssertion*
	"]"

<a id="NamedInstance-Syntax">NamedInstance</a> ::=
	ConceptInstance |
	RelationInstance

<a id="ConceptInstance-Syntax">ConceptInstance</a> ::=
	Annotation*
	("instance" ID | "ref" "instance" [ConceptInstance|IRI]) (":" ConceptTypeAssertion ("," ConceptTypeAssertion)*)? ("["
		PropertyValueAssertion*
	"]")?
	
<a id="RelationInstance-Syntax">RelationInstance</a> ::=
	Annotation*
	("relation" "instance" ID | "ref" "relation" "instance" [RelationInstance|IRI]) (":" RelationTypeAssertion ("," RelationTypeAssertion)*)? ("["
		("from" [NamedInstance|IRI] ("," [NamedInstance|IRI])*)? 
		("to" [NamedInstance|IRI] ("," [NamedInstance|IRI])*)?
		PropertyValueAssertion*
	"]")?

<a id="Member-Syntax">Member</a> ::=
	VocabularyMember |
	DescriptionMember |
	Statement

<a id="VocabularyMember-Syntax">VocabularyMember</a> ::=
	VocabularyStatement |
	Term

<a id="DescriptionMember-Syntax">DescriptionMember</a> ::=
	DescriptionStatement

<a id="Statement-Syntax">Statement</a> ::=
	VocabularyStatement |
	DescriptionStatement

<a id="VocabularyStatement-Syntax">VocabularyStatement</a> ::=
	Rule |
	BuiltIn |
	SpecializableTerm
	
<a id="DescriptionStatement-Syntax">DescriptionStatement</a> ::=
	NamedInstance

<a id="Term-Syntax">Term</a> ::=
	Property |
	SpecializableTerm

<a id="Import-Syntax">Import</a> ::=
	Extension |
	Usage |
	Inclusion

<span id="Extension-Syntax">Extension</span> ::=
	Extends NAMESPACE ("as" ID)?
    	
<span id="Usage-Syntax">Usage</span> ::=
	Uses NAMESPACE ("as" ID)?
    	
<span id="Inclusion-Syntax">Inclusion</span> ::=
	Includes NAMESPACE ("as" ID)?

<a id="PropertyRestrictionAxiom-Syntax">PropertyRestrictionAxiom</a> ::=
	PropertySelfRestrictionAxiom |
	PropertyRangeRestrictionAxiom |
	PropertyCardinalityRestrictionAxiom |
	PropertyValueRestrictionAxiom

<a id="PropertyRangeRestrictionAxiom-Syntax">PropertyRangeRestrictionAxiom</a> ::=
	"restricts" RangeRestrictionKind [SemanticProperty|IRI] "to" [Type|IRI]

<a id="PropertyCardinalityRestrictionAxiom-Syntax">PropertyCardinalityRestrictionAxiom</a> ::=
	"restricts" [SemanticProperty|IRI] "to" CardinalityRestrictionKind UnsignedInteger ([Type|IRI])?

<a id="PropertyValueRestrictionAxiom-Syntax">PropertyValueRestrictionAxiom</a> ::=
	"restricts" [SemanticProperty|IRI] "to" (Literal | AnonymousInstance | [NamedInstance|IRI])

<a id="PropertySelfRestrictionAxiom-Syntax">PropertySelfRestrictionAxiom</a> ::=
	"restricts" [SemanticProperty|IRI] "to" "self"

<a id="KeyAxiom-Syntax">KeyAxiom</a> ::=
	"key" [Property|IRI] ("," [Property|IRI])*

<a id="InstanceEnumerationAxiom-Syntax">InstanceEnumerationAxiom</a> ::=
	"oneOf" [ConceptInstance|IRI] ("," [ConceptInstance|IRI])*

<a id="LiteralEnumerationAxiom-Syntax">LiteralEnumerationAxiom</a> ::=
	"oneOf" Literal ("," Literal)*

<span id="ConceptTypeAssertion-Syntax">ConceptTypeAssertion</span> ::=
	[Concept|IRI]

<span id="RelationTypeAssertion-Syntax">RelationTypeAssertion</span> ::=
	[RelationEntity|IRI]

<a id="PropertyValueAssertion-Syntax">PropertyValueAssertion</a> ::=
	[SemanticProperty|IRI] (Literal | AnonymousInstance | [NamedInstance|IRI])  ("," (Literal | AnonymousInstance | [NamedInstance|IRI]))*

<a id="Predicate-Syntax">Predicate</a> ::=
	UnaryPredicate |
	BinaryPredicate |
	BuiltInPredicate

<a id="UnaryPredicate-Syntax">UnaryPredicate</a> ::=
	TypePredicate |
	RelationEntityPredicate
	
<a id="BinaryPredicate-Syntax">BinaryPredicate</a> ::=
    PropertyPredicate |
    SameAsPredicate |
    DifferentFromPredicate

<a id="TypePredicate-Syntax">TypePredicate</a> ::=
	[Type|IRI] "(" Argument ")"
	
<a id="RelationEntityPredicate-Syntax">RelationEntityPredicate</a> ::=
    [RelationEntity|IRI] "(" Argument "," Argument "," Argument ")"

<a id="PropertyPredicate-Syntax">PropertyPredicate</a> ::=
	[Property|IRI] "(" Argument "," Argument ")"

<a id="SameAsPredicate-Syntax">SameAsPredicate</a> ::=
    "sameAs" "(" Argument "," Argument ")"

<a id="DifferentFromPredicate-Syntax">DifferentFromPredicate</a> ::=
    "differentFrom" "(" Argument "," Argument ")"

<a id="BuiltInPredicate-Syntax">BuiltInPredicate</a> ::=
    "builtIn" "(" [BuiltIn|IRI] "," Argument ("," Argument)* ")"

<a id="Argument-Syntax">Argument</a> ::=
	ID | Literal | [NamedInstance|REF]


<a id="Literal-Syntax">Literal</a> ::=
	IntegerLiteral |
	DecimalLiteral |
	DoubleLiteral |
	BooleanLiteral |
	QuotedLiteral

<a id="IntegerLiteral-Syntax">IntegerLiteral</a> ::=
	Integer

<a id="DecimalLiteral-Syntax">DecimalLiteral</a> ::=
	Decimal

<a id="DoubleLiteral-Syntax">DoubleLiteral</a> ::=
	Double

<a id="BooleanLiteral-Syntax">BooleanLiteral</a> ::=
	Boolean

<a id="QuotedLiteral-Syntax">QuotedLiteral</a> ::=
	STRING (("^^" [Scalar|IRI]) | ("$" ID))?

<a id="RangeRestrictionKind-Syntax">RangeRestrictionKind</a> ::=
	all |
	some

<a id="CardinalityRestrictionKind-Syntax">CardinalityRestrictionKind</a> ::=
	exactly |
	min |
	max

<span id="Extends-Syntax">Extends</span> ::=
	"extends"

<span id="Uses-Syntax">Uses</span> ::=
	"uses"

<span id="Includes-Syntax">Includes</span> ::=
	"includes"

<span id="Boolean-Syntax">Boolean</span> ::= 
	BOOLEAN_STR

<span id="UnsignedInteger-Syntax">UnsignedInteger</span> ::= 
	UNSIGNED_INTEGER_STR

<span id="Integer-Syntax">Integer</span> ::= 
	UNSIGNED_INTEGER_STR | INTEGER_STR

<span id="Decimal-Syntax">Decimal</span> ::=
	DECIMAL_STR

<span id="Double-Syntax">Double</span> ::=
	DOUBLE_STR

<span id="BOOLEAN_STR-Syntax">BOOLEAN_STR</span> ::= 
	"false" | "true"

<span id="UNSIGNED_INTEGER_STR-Syntax">UNSIGNED_INTEGER_STR</span> ::= 
	NUMERIC+

<span id="INTEGER_STR-Syntax">INTEGER_STR</span> ::= 
	("+"|"-")? NUMERIC+

<span id="DECIMAL_STR-Syntax">DECIMAL_STR</span> ::= 
	("+"|"-")? (NUMERIC+("."NUMERIC*)? | ("."NUMERIC+))

<span id="DOUBLE_STR-Syntax">DOUBLE_STR</span> ::= 
	("+"|"-")? (NUMERIC+("."NUMERIC*)? | ("."NUMERIC+)) (("e"|"E") ("+"|"-")? NUMERIC+)?

<span id="STRING-Syntax">STRING</span> ::= 
	(""" -> """) | ("'" -> "'") | ("'''" -> "'''") | ("\"\"\"" -> "\"\"\"")

<span id="NAMESPACE-Syntax">NAMESPACE</span> ::= 
	"<" (!(">"|\s|"#"))* ("#"|"/") ">"

<span id="IRI-Syntax">IRI</span> ::= 
	ID | REF

<span id="REF-Syntax">REF</span> ::=
	FULL_IRI | ABBREVIATED_IRI

<span id="FULL_IRI-Syntax">FULL_IRI</span> ::= 
	"<" (!(">"|\s|"#"))* ">"

<span id="ABBREVIATED_IRI-Syntax">ABBREVIATED_IRI</span> ::= 
	ID ":" ID

<span id="ID-Syntax">ID</span> ::= 
	"^"? (ALPHA|NUMERIC|SPECIAL) (ALPHA|NUMERIC|SPECIAL|"$")*

<span id="ALPHA-Syntax">ALPHA</span> ::= 
	"a".."z" | "A".."Z"

<span id="NUMERIC-Syntax">NUMERIC</span> ::= 
	"0".."9"

<span id="SPECIAL-Syntax">SPECIAL</span> ::= 
	"_"|"-"|"."|"~"|"%"

</pre>