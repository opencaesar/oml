# Version Migration # {#Version-Migration}

The OML syntax and APIs have significantly changed from v1 to v2. This section summarizes these changes and provides guidance on migration.

**Syntax Changes**

1. In v1 ontologies, only a subset of details could be specified on a `ref` to a `<Member>`. In v2, (almost) all details can be specified on a `ref`. This widens significantly the ability to split statements about a member in different ontologies, which better supports the ability to federate and extend descriptions. This also means that (most of) the previously required details of members have been relaxed to be optional. For example:

	<pre class="highlight highlight-html">
	`ref relation entity` R1 [
		`from` C1 // this adds C1 as another source of R1
	]

	`ref scalar property` name [
		`domain` Pet // this adds Pet as another domain of name
		`functional` // this adds the fsunctional flag
	]
	</pre>
	
1. In v2 ontologies, an annotation have now specify a value that is either a literal (as before) or an IRI of a `member` (new capability). For example:

	<pre class="highlight highlight-html">
	@rdfs:label "Aggregates" // literal
	@rdfs:seeAlso base:Contains // reference to base:Contains
	`relation entity` Aggregtes
	</pre>

1. In v2 vocabularies, the specialization axiom symbol `:>` has changed into `<` to better align with the semantics that a subclass is a subset of its superclass.

1. In v2 vocabularies (since v2.3), the `restricts` statement syntax does not have property kind (`scalar property`, `structured property`, and `relation`) keywords any longer. For example:

	<pre class="highlight highlight-html">
	`restricts all` performs `to` mission:Function
	</pre>

1. In v2 vocabularies, it has been clarified that the `restricts` statements, which used to be placed with other details about a term between `[]`,  actually belong to the specialization axiom. 

	This has caused the general term syntax to change from:

	<pre class="highlight highlight-html">
	 Term ::= <keyword> NAME (`<` Specializations)? (`[` Details? Restrictions? `]`)?
	 Specializations ::= REF (`,` REF)*
	</pre>

	to:

	<pre class="highlight highlight-html">
	 Term ::= <keyword> NAME (`[` Details `]`)? (`<` Specializations)?
	 Specializations ::= (REF (`,` REF)*)? (`[` Restriction*`]`)?
	</pre>
  
	For example:

	<pre class="highlight highlight-html">
	`aspect` A1 [
		`key` id // detail
	] < A2

	`concept` C1 [
		`oneOf` c11, c12, c13 // detail
	] < C2, C3 [
	  `restricts all` p1 `to` "abc"
	]

	`concept` C2 < C3, C4, C5 [
	  `restricts all` p1 `to` "abc"
	  `restricts` p2 `to` 2.0
	]

	`relation entity` R1 [ 
		`from` C1	  // detail
		`to` A1		 // detail
		`forward` r1  // detail
	] < R2 [
		`restricts some` p2 `to` 2.0
	]

	`scalar` S1 [
		`oneOf` "abc", "xyz" // detail
	] < S2

	`scalar property` p1 [
		`domain` D1	// detail
		`range` R1	 // detail
	] < p2
	</pre>

1. In v2 vocabularies, a new equivalence axiom (`=`) has been added to the term syntax in addition to the specialization axiom (`<`). While a specialization axiom says that a term is a sub of another term, an equivalence axiom says that the term is both a sub and a super of another term. The general term's syntax is now:

	<pre class="highlight highlight-html">
	Term ::= <keyword> NAME (`[` Details `]`)? (`<` Specializations)? (`=` Equivalences)?
	Specializations ::= (REF (`,` REF)*)? (`[` Restriction*`]`)?
	Equivalences ::= Equivalence (`,` Equivalance)*
	</pre>
	
	In the case of classifiers, a single equivalence has the syntax:
	
	<pre class="highlight highlight-html">
	Equivalence ::= (REF (`&` REF)*)? (`[` Restriction*`]`)  // equals the intersection of other named terms and restrictions
	</pre>
	
	In the case of scalars and properties, a single equivalence has the syntax:
	
	<pre class="highlight highlight-html">
	Equivalence ::= REF // equals another named term
	</pre>

	For example:
	
	<pre class="highlight highlight-html">
	// A pizza that has a spicy topping is classified as a spicy pizza
	`concept` SpicyPizza = Pizza [
		`restricts some` hasTopping `to` SpicyTopping
	]
	// A woman that is married is classified as a married woman
	`aspect` MarriedWoman = Married & Woman
	// A string that has a particular pattern is an SSN
	`scalar` ssn = xsd:string [
		`pattern` "[0-9]{3}-[0-9]{2}-[0-9]{4}"
	]
	// Saying food is spicy is the same as saying that it is hot and vice versa
	`scalar property` isSpicy [
		`domain` Food
		`range` xsd:boolean
		`functional`
	] = isHot
	</pre>

1. In v2 vocabularies, a concept or scalar enumeration can now be specified consistently with a `oneOf` statement in the the details between `[]`. This also removes the special type `enumerated scalar` in v1 and retains only the `scalar` type.

	For enumerated literals, the syntax has changed from:
	
	<pre class="highlight highlight-html">
	EnumeratedScalar ::= `enumerated scalar` NAME `[`
		Literal (`,` Literal)*
	`]`
	</pre>
	
	to
	
	<pre class="highlight highlight-html">
	Scalar ::= `scalar` NAME `[`
		(`oneOf` Literal (`,` Literal)*)?
		// other details ...
	`]`
	</pre>

	For enumerated concept instances, the syntax has changed from:
	
	<pre class="highlight highlight-html">
	Concept ::= `concept` NAME `[`
		(`enumerates` REF (`,` REF)*)?
		// other details ...
	`]`
	</pre>
	
	to
	
	<pre class="highlight highlight-html">
	Concept ::= `concept` NAME `[`
		(`oneOf` REF (`,` REF)*)?
		// other details ...
	`]`
	</pre>

	For example:
	
	<pre class="highlight highlight-html">
	`scalar` RGB [
		`oneOf` "Red", "Green", "Blue" // literals
	]

	`concept` RockyPlanet [
		`oneOf` Mercury, Venus, Earth, Mars // instances
	]
	</pre>

1. In v2 vocabularies, it has been clarified that scalar facets (e.g., length, pattern, etc.) do not belong to the scalar's details between `[]`, but rather to the new scalar equivalence axiom. This allows such facets to be specified on a per equivalence basis.

	For example:
	
	<pre class="highlight highlight-html">
	`scalar` ssn = xsd:string [
		`pattern` "[0-9]{3}-[0-9]{2}-[0-9]{4}"
	]

	`scalar` positiveReal = xsd:real [
		`minInclusive` 0
	], xsd:real [
		`maxInclusive` 9999
	]
	</pre>

1. In v2 vocabularies, the `structure` type (which was used in v1 as a type for anonymous instances) has been removed and replaced by a simple `concept` in (which can have either named or anonymous instances). Similarly, a `structured property` (which was typed by a `structure` in v1) has been removed and replaced by a simple `relation`.

	For example:
	
	In a vocabulary:

	<pre class="highlight highlight-html">
	`concept` Point // used to be a structure
	`scalar` `property` x [ `domain` Point `range` xsd:int ]
	`scalar` `property` y [ `domain` Point `range` xsd:int ]
	`concept` Shape
	`relation` top-left [ `from` Shape `to` Point ] // used to be a structured property
	`relation` bottom-right [ `from` Shape `to` Point ] // used to be a structured property
	</pre>

	In a description:

	<pre class="highlight highlight-html">
	`instance` p1 : Point [ x 10 y 20] // named instance
	`instance` s1 : Shape [
		top-left : Point [ x 30 y 40 ] // anonymous instance
		bottom-right [ x 90 y 100 ] // anonymous instance
	]
	</pre>


2. In v2 vocabularies, a new (unreified) `relation` can now be specified as an alternative to a (refieid) `relation entity`. This supports cases where instances of the relation are not foreseen in descriptions. It also helps avoid synthesizing relation entity names when mapping vocabularies from other formats that do not natively support reified relations. The syntax of an unreified `relation` resembles closely that of a `relation entity` (except for the `forward` statement). The syntax of an unreieifed `relation` is (partially) as follows:

	<pre class="highlight highlight-html">
	Relation ::= `relation` NAME (`[`
		`from` REF
		`to` REF
		(`reverse` NAME)? // notice there is no forward NAME statement
		// other details in a relation entity
	`]`)? // specialization and equivalence axioms to other relations
	</pre>
	
	For example:
	
	<pre class="highlight highlight-html">
	`relation` isHusbandOf [
		`from` Man
		`to` Woman
		`reverse` isWifeOf
	]

	`relation entity` IsTeacherOf [
		`from` Teacher
		`to` Student
		`forward` isTeacherOf
		`reverse` isStudentOf
	]
	</pre>

3. In v2 vocabularies, an unreified relation can now be referenced anywhere other relations (like `forward`, `reverse`) can. This includes restriction statements (`restricts REL_REF`), specialization statements (`< REL_REF`), equivalence statements (`= REL_REF`), rule predicates (`REL_REF(ARG1, ARG2)`), assertion axioms (`REL_REF TARGET_REF`), etc. Also, a relation is a kind of property in v2, whereas a relation entity is a kind of type. Therefore, a relation cannot be a supertype of a relation entity (and vice versa). But, an unreified relation can have any relation (including forward and reverse) as a super relstion.

4. In v2 vocabularies, the `from` and `to` statements (of relations), as well as the `domain` and `range` statements (of properties), can now specify more than one type as a value (both on the original definition or on a `ref` of the member). The semantics of having multiple types is equivalent to the intersection of those types. This makes a value asserted as a subject (or object) of a property (or relation) to be classified by all the types at once.

	For example:
	
	<pre class="highlight highlight-html">
	// In a vocabulary
	`relation` isBoxedIn [
		`from` Red, Ball
		`to` Box
	]
	`relation` isPetOf [
		`from` Cat, Dog
		`to` Person
	]
	// In a description
	`instance` Ball1 [
		isBoxedIn Box1 // this will cause Ball1 to be classified by both Red and Ball
	]
	`instance` Tom [
		isPetOf Jack // this will cause Tom to be classified by both Cat and Dog
	]
	</pre>

5. In v2 vocabularies, the symbol `^` separating rule predicates has changed to `&` to better reflect the AND semantics between predicates.

6. In v2 vocabularies, a new term `builtIn` has been added to define a builtin function that can be referenced by a rule antecedant predicate. A standard set of builtins has been added to the `core-vocabularies` library in the `<http://www.w3.org/2003/11/swrlb#>` vocabulary. Note that a custom `builtIn` function cannot be specified yet.

	<pre class="highlight highlight-html">
	 // in the "http://www.w3.org/2003/11/swrlb#" vocabulary
	 
	 @rdfs:comment "Satisfied iff the first argument is equal to the string ..."
	 `builtin` stringConcat

	 // in a vocabulary
	 
	 `rule` FullName [
			 firstName(?x, ?first) & 
			 lastName(?x, ?last) &
			 swrlb:stringConcat(?full, ?first, " ", ?last) // builtins can only be referenced in antecedent
			 -> fullName(?x, ?full)
	 ]
	</pre>

7. In v2 descriptions, the symbol `ci` for a concept instance has now changed to the more readable `instance`. Also, such instances can also now be typed by both `Concepts` and `Aspects` (whereas only `Concepts` were the only valid types in v1).

8.  In v2 descriptions, the symbol `ri` for a relation instance has now changed to the more readable `relation instance`. Also, such instances can also now be typed by both `Relation Entities` and `Aspects` (whereas only `Relation Entities` were the only valid types in v1).

**API Changes**

The above changes to the OML textual syntax have induced some changes to the OML Java API. Other changes were done done to simplify the API. The following is a list of main changes to the OML API:

1. Merged (and removed) class `AnnotatedElement` into class `IdentifiedElement` (the impact is that `Import` statements can no longer be annotated).
1. Collapsed the `Import` class  hierarchy into a single `Import` class with an enumeration kind that has literals: `extends`, `uses`, and `includes`.
1. Renamed class `Feature` to `Property`, made the latter the supertype of classes `AnnotatedProperty` and `SemanticProperty`, and made class `Relation` extend from `SemanticProperty`.
1. Collapsed the `Restriction` class hierarchy into 3 subclasses restricting range, cardinality, or value of a property, and made class `Entity` has a single collection for restrictions.
1. Removed class `LinkAssertion` (replaced by `PropertyValueAssertion`) and made class `NamedInstance` has a single collection of property value assertions.
1. Moved the types collection (now of concrete type `TypeAssertion`) from both classes `ConceptInstance` and `RelationInstance` into their superclass `NamedInstance`.
1. Made class `RelationEntityPredicate` a subclass of both `UniaryPredicate` and `BinaryPredicate`.
1. Removed the `Reference` class hierarchy entirely and merged it into the `Member` class hierarchy (a member can have either a name or a ref to another member).

**Migration Guide**

Migrating OML v1 textual syntax to that of v2 can be done in a text editor using the following process:

1. Replace the symbol `:>` by `<`.

1. Replace the symbol `ci ` by `instance `.

1. Replace the symbol `ri ` by `relation instance `.

1. Replace the syntax `keyword NAME < REFS [Details]` by the syntax `keyword NAME [Details] < REFs`.

1. Replace the syntax `keyword NAME [Restrictions]` by the syntax `keyword NAME < [Restrictions]`.

1. Replace the syntax `keyword NAME < REFS [Details Restrictions]` by the syntax `keyword NAME [Details] < REFS [Restrictions]`.

1. Replace the syntax `concept NAME [ enumerates REFS ]` by the syntax `concept NAME [ oneOf REFS ]`.

1. Replace the syntax `enumerated scalar NAME < REFS [ LITERALS ]` by the syntax `scalar NAME [ oneOf LITERALS ]`.

1. Replace the syntax `scalar NAME < REFS [ FACETS ]` by the syntax `scalar NAME = REFS [ FACETS ]`.


Migrating OML v1 XMI syntax for Descriptions to that of v2 can be done in a text editor using the following process:

1. Replace `ConceptTypeAssertion` by `TypeAssertion`.

1. Replace `ScalarPropertyValueAssertion` by `PropertyValueAssertion`.

1. Replace `LinkAssertion` by `PropertyValueAssertion`.

1. Replace `<value` by `<literalValue`.

1. Replace `<ownedLinks` by `<ownedPropertyValues`.

1. Replace `<relation` by `<property`.

1. Replace `target=` by `referencedValue=`.

Note: some of the above steps can be automated by the use of this [script](https://github.com/opencaesar/oml/tree/master/scripts).