# Language Reference # {#Language-Reference}

This section presents the OML language features using its textual syntax as a notation. All the presented features exist in the other syntaxes except when noted otherwise. It is recommended that a reader starts with the common idioms section to gain an understanding of the language's basics, before reading the other sections.

## OML Idioms ## {#Common-Idioms-LR}

### White Space ### {#White-Space-LR}

Whitespace can be freely placed in the OML textual syntax (only) to delimit tokens, but otherwise has no other significance.

### Comment ### {#Comment-LR}

Comments with the following syntaxes can be freely placed in the OML textual syntax:
```javascript
// single-line-comment

/* possibly
  multi-line
  comment */
```

Note: A comment is a textual-syntax feature only, hence will not be preserved when a model is converted to OML's other syntaxes.

### Ontology ### {#Ontology-LR}

An ontology is the root element of an OML model and the unit of organizing ontological statements. It is defined with one of the `<ontology>` keywords (see [ontology syntax](#Ontology-Syntax) for details), a globally unique NAMESPACE, a locally unique ID (representing a NAMESPAC prefix), a set of imports (of other ontologies), and a set of statements.

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `<import>`*
    `<statement>`*
`}`
</pre>

An ontology's NAMESPACE is made up of an IRI and a separator character (either `#` or `/`). For example, `http://www.w3.org/2002/07/owl#` is a logical NAMESPACE that consists of IRI `http://www.w3.org/2002/07/owl` and separator character `#`. An ontology's IRI can be any opaque string but is usually specified as a URL in the format `http://<organization>/<path>`. An ontology's ID is a short name that is used as a NAMESPACE prefix (e.g., `owl` is a prefix for `http://www.w3.org/2002/07/owl#`) when referencing an ontology member using the ABBREVIATED_IRI syntax (see section [IRIs](#IRI-LR) below). 

OML supports 4 kinds of concrete ontologies that address different use cases:
- [Vocabulary](#Vocabulary-LR): allows definition of ontological terms and rules for a domain with open-world semantics
- [Vocabulary Bundle](#VocabularyBundle-LR): allows combining vocabularies into a DSL with closed-world semantics
- [Description](#Description-LR): allows definition of systems as instances characterized using some vocabulary
- [Description Bundle](#DescriptionBundle-LR): allows combining descriptions into a dataset that can be reasoned on.

### Import ### {#Import-LR}

An ontology can import zero or more other ontologies, which allows it to cross-reference the imported ontologies' members. This is accomplished by an ontology adding an import statement in its body (before other kinds of statements). An import statement is declared using one of the `<import>` keywords (see [import syntax](#Import-Syntax) for details) followed by the imported ontology's NAMESPACE and optionally a (preix) ID.

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `<import>` [Ontology|NAMESPACE] (`as` ID)?
}
</pre>
 
Note: An (prefix) ID is required in the import syntax only when imported members are cross-referenced using the ABBREVIATED_IRI syntax.

Note: An ontology's import closure is defined as all the ontologies that are imported directly or indirectly by the ontology

Note: An ontology whose members are referenced by another ontology needs to be directly imported by it (it is not enough to be indirectly imported).

OML supports several kinds of imports for each one of its ontology kinds:
- Vocabulary: [extends](#VocabularyExtension-LR) Vocabulary, [uses](#VocabularyUsage-LR) Description
- Vocabulary Bundle: [extends](#VocabularyBundleExtension-LR) VocabularyBundle, [includes](#VocabularyBundleInclusion-LR) Vocabulary
- Description: [extends](#DescriptionExtension-LR) Description, [uses](#DescriptionUsage-LR) Vocabulary
- Description Bundle: [extends](#DescriptionBundleExtension-LR) DescriptionBundle, [includes](#DescriptionBundleInclusion-LR) Description, [uses](#DescriptionBundleUsage-LR) Vocabulary, [uses](#DescriptionBundleUsage-LR) VocabularyBundle

### Member ### {#Member-LR}

An ontology can define zero or more members, which are named elements whose IRIs consist of their ontology's NAMESPACE concatenated to their own (name) IDs. For example, a member whose name ID is `AggregatedElement`, and is defined in an ontology with the IRI `http://imce.jpl.nasa.gov/foundation/base#`, has a member IRI `http://imce.jpl.nasa.gov/foundation/base#AggregatedElement`. 

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `<member>` ID
`}`
</pre>

Members are defined by their own ontology and referenced by importing ontologies. Different ontology kinds define different member kinds (see the various ontology sections for details). The syntax for declaring members vary depending on the member kind, but at least consists of one of the `<member>` keywords (see [members](#Member-Syntax) for details) followed by the member's ID that must be unique within the ontology.

OML supports several kinds of concrete members for each of its ontology kinds:

- Vocabulary: 
    - [Aspect](#Aspect-LR)
    - [Concept](#Concept-LR)
    - [Relation Entity](#RelationEntity-LR)
    - [Structure](#Structure-LR)
    - [Scalar](#Scalar-LR)
    - [Annotation Property](#AnnotationProperty-LR)
    - [Scalar Property](#ScalarProperty-LR)
    - [Structured Property](#StructuredProperty-LR)
    - [Unreified Relation](#UnreifiedRelation-LR)
    - [BuiltIn](#BuiltIn-LR) 
    - [Rule](#Rule-LR)
- Description: 
    - [Concept Instance](#ConceptInstance-LR)
    - [Relation Instance](#RelationInstance-LR)

### Reference ### {#Reference-LR}

An ontology can reference local or imported members in order to add extra statements on them. Unlike a new member that is defined syntactically with a `<member>` keyword and an \[ID](#ID-Syntax), a reference is defined syntatically with the keyword `ref` followed by a `<member>` keyword then the existing member's \[IRI](#IRI-Syntax), as follows:

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `ref` `<member>` IRI
`}`
</pre>

 An example of an extra statement that can be added on any reference is an [annotation](#Annotation-LR). However, other statement kinds may vary based on the kind of the referenced member. In most cases, those statements are the same kinds that can be added to a member definition. In few cases, they are only a subset of them. Sections on the specific member kinds will outline the statements that cannot be added to a reference.

### IRI ### {#IRI-LR}

Ontologies and their members have globally unique IRIs. The \[IRI](#IRI-Syntax) of an ontology is equivalent to its NAMESPACE minus its separator character (`#` or `/`). For example, an ontology with NAMESPACE *http://imce.jpl.nasa.gov/foundation/base#* has IRI *http://imce.jpl.nasa.gov/foundation/base*. The IRI of an ontology member consists of its ontology's NAMESPACE concatenated to its ID. For example, a member with ID `AggregatedElement` in an ontology with a NAMESPACE *http://imce.jpl.nasa.gov/foundation/base#* has IRI *http://imce.jpl.nasa.gov/foundation/base#AggreagedElement*. This is called the full IRI of a member. Such IRI can be written in an abbreviated syntax using the ontology's namespace prefix. It can also be shortened further to the simple ID of the member when used in the context of its defining ontology. The following is an elaboration of the three possible syntaxes for IRIs.

*Full IRI*

The full \[IRI](#IRI-Syntax) syntax in OML conforms to a subset of the [standard IRI](https://datatracker.ietf.org/doc/html/rfc3987) syntax. However, the OML textual syntax only, it is surrounded by `< >` (e.g., `<` http://www.w3.org/2002/07/owl#Thing `>`). Also, the syntax of an ontology's \[NAMESPACE](#NAMESPACE-Syntax) is surrounded by `< >` (e.g., `<`http://www.w3.org/2002/07/owl#`>`).

Note: the `< >` are stripped off when the value is parsed from the OML textual syntax.

*Abbreviated IRI*

OML also supports an \[ABBREVIATED_IRI](#ABBREVIATED_IRI-Syntax) syntax for ontology members. The syntax consists of the defining ontology's (prefix) ID and the member's (name) ID, delimited by the `:` character. For example, *owl:Thing* is an ABBREVIATED_IRI for a member with the IRI of *http://www.w3.org/2002/07/owl#Thing* when the ontology has a prefix ID of *owl*.

 The ontology's prefix ID that can be used in a member's ABBREVIATED_IRI either comes from the ontology definition (if the member is local to the ontology) or an import statement (if the member is imported). For example:

 <pre class="highlight highlight-html">
`<ontology>` NAMESPACE1 `as` X `{`
    `<import>` NAMESPACE2 `as` Y
    `<member>` M
    `ref` `<member>` M                     // reference to a local member
    `ref` `<member>` X:M                   // reference to a local member
    `ref` `<member>` Y:N                   // reference to an imported member
`}`

`<ontology>` NAMESPACE2 `as` Y `{`
    `<member>` N
`}`
</pre>

Moreover, while the prefix ID used in an import statement typically matches the prefix ID specified in the imported ontology's definition, it does not have to match. In fact, the ability to use a different prefix ID in an import statements allows disambiguating a prefix when it is already used by another import in the context. For example:

 <pre class="highlight highlight-html">
`<ontology>` NAMESPACE1 `as` X `{`
    `<import>` NAMESPACE2 `as` Y
    `<import>` NAMESPACE3 `as` Z         // the prefix is different from the definition's prefix below
    `ref` `<member>` Y:N2                // reference to a imported member from NAMESPACE2
    `ref` `<member>` Z:N3                // reference to a imported member from NAMESPACE3
`}`

`<ontology>` NAMESPACE2 `as` Y `{`
    `<member>` N2
`}`

`<ontology>` NAMESPACE3 `as` Y `{`
    `<member>` N3
`}`
</pre>

*ID*

IDs are strings used to specify the prefixes of ontologies and the names of ontology members. The [syntax](#ID-Syntax) of an ID consists of a sequence of letters, digits, and some other characters. 

A simple ID of a member can be used as an IRI for the member when the member is local, i.e., defined as a member in the same ontology. In the following example, the `ref` statement is referencing member Y by its simple ID, since the member is defined in the same ontology X.

 <pre class="highlight highlight-html">
`<ontology>` NAMESPACE1 `as` X `{`
    `<member>` Y
    `ref` `<member>` Y          // the simple ID is used as an IRI of a locally defined member
`}`
</pre>

In the OML textual syntax only, when a reserved keyword is used as an ID, it needs to escaped by `^` (e.g., `^concept`). For example, the member named *concept* has its name escaped since *concept* is a keyword in OML. When used as an IRI, the `^` has to be used as well.

 <pre class="highlight highlight-html">
`<ontology>` NAMESPACE1 `as` X `{`
    `<member>` ^concept                 // a `^` is used since concept is a keyword in OML
    `ref` `<member>` ^concept           // a `^` is used since concept is a keyword in OML
`}`
</pre>

### Literal ### {#Literal-LR}

A [literal](#Literal-Syntax) represents a value typed by a [scalar](#Scalar-LR) type (defined by a [vocabulary](#Vocabulary-LR)). OML supports specifying a literal as a quoted literal or as an abbreviated literal (for some specific scalars).

*Quoted Literal*

A quoted literal is a generic way of specifying a literal. It consists of the lexical form followed by a language tag, a scalar IRI, or neither. 

The lexical form consists of a set of characters surrounded by a pair of delimiters, which can be single quotes (`'value'`), double quotes, (`"value"`), three single quotes (`'''value'''`), or three double quotes (`"""value"""`). 

Note: The last two types of delimiters allow line break characters in the lexical form, while the first two do not.

Note: A delimiter can appear within a lexical form that is delimited by a different delimiter (e.g., "It's my responsibility")

Examples of quoted literals with different delimiters:

<pre class="highlight highlight-html">
"The system should be responsive"
'''First paragraph
Second Paragraph'''
'true'
"""This is really the engineer's fault"""
</pre>

The optional language tag is typically used with translatable string. It allows specifying the natural language the lexical form should be interpreted with. It is specified by appending the `$` character to the lexical form followed by one of the language tags specified in [BPB 47 - Tags for Identifying Languages](http://www.rfc-editor.org/rfc/bcp/bcp47.txt). Examples of quoted literals with language tags:

<pre class="highlight highlight-html">
"This is good"$en
"Ca va bien"$fr
</pre>

The optional scalar IRI is used to specify the scalar that a literal belongs to (*xsd:string* by default). However, the reference can be to any of OML's [standard scalars](#Scalar-LR) only (i.e., not their specializations). It is specified by appending the `^^` characters to the lexical form followed by an IRI to the scalar. Examples of quoted literals with scalar references:

<pre class="highlight highlight-html">
"Component"^^xsd:string
"2.0"^^xsd:double
'true'^^xsd:boolean
</pre>

*Abbreviated Literal*

In addition to the quoted literal syntax, OML supports abbreviated syntaxes for some of the standard scalar types: *xsd:integer*, *xsd:decimal*, *xsd:double*, and *xsd:boolean*. The abbreviated syntax consists only of an undelimited lexical form that gets interpreted as belonging to one of the supported scalars. Example abbreviated literals:

<pre class="highlight highlight-html">
123         // xsd:integer
-123.4      // xsd:decimal
.827        // xsd:decimal
123E+45     // xsd:double
true        // xsd:boolean
</pre>

Note: if an abbreviated literal belongs to multiple scalars, it gets interpreted as belonging to the least precise scalar.

### Annotation ### {#Annotation-LR}

An annotation allows describing information about an ontology, or one of its members, that does not have associated description logic (DL) semantics. Such information can be notational (e.g., how an element is to be displayed), tool-specific (e.g., how to export an element), or for any other purpose (e.g., who authored the ontology).

An Annotation describes a value for an [annotation property](#AnnotationProperty-LR) (defined by a [vocabulary](#Vocabulary-LR)) in the context of an identified element (an [ontology](#Ontology-LR) or a [member](#Member-LR),. The general syntax of an annotation consists of a `@` symbol followed by an IRI to the an annotation property then an optional (literal or member reference) value. If the value is missing, it is interpreted as a boolean *true* literal.

<pre class="highlight highlight-html">
`@`[AnnotationProperty|IRI] (Literal | [Member|IRI])?
</pre>

The following example shows several annotations. The ontology itself has a *dc:title* annotation as well as a *dc:date* annotation (notice how the value is a *xsd:date* literal). The member `Member1` has two annotations, both of them are *rdfs:comment* but one has an English (en) literal while the other has a French (fr) literal. Finally, the imported member `example2:Member2` has an annotation with *viewpoint:show* (notice that there is no literal value, which will be interpreted as a Boolean *true* literal).

<pre class="highlight highlight-html">
`@`dc:title "Example1 Ontology"
`@`dc:date "2/15/2021"^^xsd:dateTime
`<ontology>` `<`http://company.com/example1#`>` `as` example1 `{`
    `<import>` `<`http://purl.org/dc/elements/1.1/`>` `as` dc
    `<import>` `<`http://www.w3.org/2000/01/rdf-schema#`>` `as` rdfs
    `<import>` `<`http://www.w3.org/2001/XMLSchema#`>` `as` rdfs
    `<import>` `<`http://io.opencaesar/viewpoint#`>` `as` viewpoint
    `<import>` `<`http://company.com/example2#`>` `as` example2
    `@`rdfs:comment "This is member1"$en
    `@`rdfs:comment "C'est member1"$fr
	`@`rdfs:seeAlso example2:Member2
    `<member>` Member1
    `@`viewpoint:show  // a missing literal is interpreted as Boolean true literal
    `ref` `<member>` example2:Member2
`}`
</pre>

## Vocabulary ## {#Vocabulary-LR}

A [vocabulary](#Vocabulary-Syntax) is an ontology that defines a set of [terms](#Term-Syntax) and [rules](#Rule-Syntax) for a given domain and has [open world semantics](#Mapping-to-Owl-and-Swrl). A vocabulary is declared with the keyword `vocabulary` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID. It also has a body consisting of zero or more vocabulary imports and statements between two braces `{` `}`, as follows:

<pre class="highlight highlight-html">
Annotation*
`vocabulary` NAMESPACE `as` ID `{`
	Import*
	VocabularyStatement*
`}`
</pre>

For example, the following vocabulary allows describing a mission. It has the namespace *http://com.xyz/methodology/mission#* and the prefix *mission*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
`}`
</pre>

### Import ### {#VocabularyImport-LR}

This section outlines the kind of imports (extension and usage) that can be added to a vocabulary.

#### Extension #### {#VocabularyExtension-LR}

An [extension](#ImportKind) is a kind of [import](#Import) statement that can be added to a vocabulary to specify that it extends another vocabulary. This is typically needed when members of the extended vocabulary are cross-reference by the local members of the extending vocabulary.  A vocabulary extension is defined with the keyword `extends` followed by the extended vocabulary's NAMESPACE, followed by the keyword `as` and a unique prefix ID.

<pre class="highlight highlight-html">
Annotation*
`extends` [Vocabulary|NAMESPACE] `as` ID
</pre>

For example, the *mission* vocabulary *extends* the *xsd* vocabulary (in order to cross reference its scalars).

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component
    `scalar` `property` hasId [
        `domain` Component
        `range` xsd:string    // a cross-reference to scalar string
    ]
`}`
</pre>

#### Usage #### {#VocabularyUsage-LR}

A [usage](#ImportKind) is a kind of [import](#Import) statement that can be added to a vocabulary to specify that it uses a [description](#Description-LR). This is typically needed when the vocabulary uses one or more of the description's instances in its restriction axioms. A vocabulary usage is defined with the keyword `uses` followed by the used description's NAMESPACE, followed by the keyword `as` and a unique prefix ID.

<pre class="highlight highlight-html">
Annotation*
`uses` [Description|NAMESPACE] `as` ID
</pre>

For example, the *mission* vocabulary *uses* the *organizations* description (in order to cross-reference its instances).

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission1#`>` `as` mission1 `{`
    `extends` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `uses` `<`http://com.xyz/methodology/organizations#`>` `as` organizations
    `concept` Spacecraft [
        `restricts` mission:isResponsibilityOf `to` organization:NASA   // a cross-reference to instance NASA 
    ]
`}`
</pre>

Note: descriptions that are used by a vocabulary typically define notable instances that are cross-referenced by other descriptions using this vocabulary.

### Types ### {#Types-LR}

Types that can be defined in a vocabulary are either *classifiers* (structured types) or *scalars* (primitive types). Some classifiers ([Aspect](#Aspect-LR), [Concept](#Concept-LR) and [Relation Entity]((#RelationEntity-LR))) are *entities*, meaning they can classify named instances (that are unique by reference). Other classifiers ([Structure](#Structure-LR)) can only classify anonymous instances (that are unique by value). Also, scalars ([Scalar](#Scalar-LR)) can classify literals.


#### Aspect #### {#Aspect-LR}

An [=aspect=] is an entity defined in a vocabulary and represents a mixin type (or a capability) in a modeled domain. An aspect is declared with the keyword `aspect` followed by an `ID`. An existing (local or imported) aspect can be referenced by the keywords `ref` `aspect` followed by its `IRI`. Moreover, an spect can specify between a pair of `[` `]` brackets a set of [KeyAxioms](#KeyAxiom-LR). It can also be followed by an optional [ClassifierSpecializationAxiom](#ClassifierSpecializationAxiom-LR), and an optional [ClassifierEquivalenceAxiom](#ClassifierEquivalenceAxiom-LR), using the following syntax:

<pre class="highlight highlight-html">
    Annotation*
	(`aspect` ID | `ref` `aspect` [Aspect|Ref]) (`[`
		(KeyAxiom)* 
	`]`)? (ClassifierSpecializationAxiom)? (ClassifierEquivalenceAxiom)?
</pre>

The following example vocabulary defines an aspect: *IdentifiedElement*, and references an imported aspect *base:Container* to add some axioms to it.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    extends  `<`http://com.xyz/methodology/base#`>` `as` base
    `aspect` IdentifiedElement
    `ref` aspect base:Container [ .. ]
`}`
</pre>

Two special aspects defined by the owl vocabulary are: *owl:Thing* and *owl:Nothing*. Aspect *owl:Thing* represents the top of the specialization hierarchy and the implicit supertype of all entities. This means if an entity is declared with no supertype, then it has *owl:Thing* as its implicit supertype. On the other hand, aspect *owl:Nothing* is the bottom of all specialization hierarchies and the implicit subtype of all entities. It represents the empty set (has no instances).

<pre class="highlight highlight-html">
`vocabulary` `<`http://www.w3.org/2002/07/owl#`>` `as` mission `{`
    `aspect` Thing
    `aspect` Nothing
`}`
</pre>

#### Concept #### {#Concept-LR}

A [=concept=] is an entity defined in a vocabulary and represents a concrete type in a modeled domain. A concept is declared with the keyword `concept` followed by an `ID`. An existing (local or imported) concept can be referenced by the keywords `ref` `concept` followed by an existing `IRI`. Moreover, a concept can specify between a pair of `[` `]` bracketsa a set of [KeyAxioms](#KeyAxiom-RL] and an optional [InstanceEnumerationAxiom](#InstanceEnumerationAxiom-LR). It can also be followed by an optional [ClassifierSpecializationAxiom](#ClassifierSpecializationAxiom-LR) and an optional [ClassifierEquivalenceAxiom](#ClassifierEquivalenceAxiom-LR), using the following syntax.

<pre class="highlight highlight-html">
    Annotation*
	(`concept` ID | `ref` `concept` [Concept|IRI]) (`[`
		(KeyAxiom)* 
		(InstanceEnumerationAxiom)?
	`]`)? (ClassifierSpecialization)? (ClassifierEquivalence)?
</pre>

The following example vocabulary defines a concept *Component*, and references an imported concept *base:Package* to add some axioms to it.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    extends  `<`http://com.xyz/methodology/base#`>` `as` base
    `concept` Component
    `ref` `concept` base:Package [ .. ]
`}`
</pre>

#### Relation Entity #### {#RelationEntity-LR}

 A [relation entity](#RelationEntity-Syntax) is an entity defined in a vocabulary and represents a reified relation between two other entities in a modeled domain. A relation entity is declared with the keyword `relation` `entity` followed by an `ID`. An existing (local or imported) relation entity can be referenced by the keywords `ref` `relation` `entity` followed by its `IRI`. A relation entity specifies between a pair of `[` `]` brackets optional `from` (domain) entities and optional `to` (range) entities that can be inferred as types of instances related by this relation. When either is omitted, no type can be inferred for a related instance in that position. A relation entity can also specify optional names for non-reified `forward` relation (with the same domains and ranges) and `reverse` relation (with the opposite domains and ranges). Moreover, a relation entity can specify various DL flags (`functional`, `inverse functional`, `symmetric`, `assymetric`, `reflective`, `irreflexive`, and `transitive`) and a set of [KeyAxioms](#KeyAxiom-LR). It can also be followed by an optional [ClassifierSpecializationAxiom](#ClassifierSpecializationAxiom-LR) and an optional [ClassifierEquivalenceAxiom](#ClassifierEquivalenceAxiom-LR), using the following syntax.

<pre class="highlight highlight-html">
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
</pre>

The optional [forward relation](#ForwardRelation-Syntax) and [reverse relation](#ReverseRelation-Syntax) are specified by ID as part of the textual syntax a relation entity as shown belpw. When both are specified, the forward and reverse relations become inverse of each other, meaning if one is asserted (from named instance A to B), the other is inferred in the opposite direction (from named instance B to A).

<pre class="highlight highlight-html">
	Annotation*
	`forward` ID
</pre>

<pre class="highlight highlight-html">
	Annotation*
	`reverse` ID
</pre>

The DL flags that can be specified on a relation entity have the following logical semantics:

- The `functional` flag implies that a source instance can be related to a maximum of 1 target instance.
- The `inverse functional` flag implies that a target instance can be related to a maximum of 1 source instance.
- The `symmetric` flag implies that if a source instance is related to a target instance, then the target must also be related to the source.
- The `asymmetric` flag implies that if a source instance is related to a target instance, then the target cannot be related to the source.
- The `reflexive` flag implies that a source instance must be related to itself.
- The `irreflexive` flag implies that a source instance cannot be related to itself.
- The `transitive` flag implies if instance A is related to instance B, and instance B is related to instance C, then A is also related to C.


The following example vocabulary defines a relation entity named *Performs* `from` the concept *Component* (as domain) `to` the concept *Function* (as range). In this case a `forward` relation *performs* as well as a reverse relation *isPerformedBy* are also named. The flag `inverse functional` specifies that a function can be performed by a maximum of one component, the flag `asymmetric` specifies that a function cannot perform a component, and the flag `irreflexive` specifies that a component cannot perform itself.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `concept` Component
    `concept` Function
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
        `forward` performs
        `reverse` isPerformedBy
        inverse functional
        `asymmetric`
        `irreflexive`
    `]`
`}`
</pre>

#### Structure #### {#Structure-LR}

A [=structure=] is a classifier defined in a vocabulary and represents a structured datatype with anonymous instances in a modeled domain. A structure is declared with the keyword `structure` followed by an `ID`. An existing (local or imported) structure can be referenced by the keywords `ref` `structure` followed by its `IRI`. Moreover, a structure can be followed by an optional [ClassifierSpecializationAxiom](#ClassifierSpecializationAxiom-LR) and an optional [ClassifierEquivalenceAxiom](#ClassifierEquivalenceAxiom-LR), using the following syntax.

<pre class="highlight highlight-html">
Annotation*
(`structure` ID | `ref` `structure` [Structure|IRI])
(ClassifierSpecialization)? (ClassifierEquivalence)?
</pre>

The following example vocabulary defines the structure *Point* whose instances are anonymous points on a grid.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
     `structure` Point
`}`
</pre>

#### Scalar #### {#Scalar-LR}

A [=scalar=] is a type defined in a vocabulary and represents a primitive type that classifies a set of literals. A scalar is declared with the keyword `scalar` followed by an `ID`. An existing (local or imported) scalar can be referenced by the keywords `ref` `scalar` followed by its `IRI`. A scalar can also specify between a pair of `[` `]` brackets an optional [LiteralEnumerationAxiom](#LiteralEnumerationAxiom-LR). It can also be followed by an optional [ScalarSpecializationAxiom](#ScalarSpecializationAxiom-LR) and an optional [ScalarEquivalenceAxiom](#ScalarEquivalenceAxiom-LR) using the following syntax:

<pre class="highlight highlight-html">
Annotation*
(`scalar` ID | `ref` `scalar` [Scalar|IRI]) (`[`
   (LiteralEnumerationAxiom)?
`]`)? (ScalarSpecialization)? (ScalarEquivalence)?
</pre>

The following example vocabulary defines a scalar named *SSN*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://example.com/primitive-types#`>` `as` primitives `{`
`scalar ` SSN
`}`
</pre>

OML considers the following set of scalars, defined in the [owl](https://www.w3.org/TR/owl2-syntax/#Datatype_Maps) spec, as *standard*:

Note: the lexical and value spaces for these standard scalars are described in the ([xsd](https://www.w3.org/TR/2012/REC-xmlschema11-2-20120405/#built-in-datatypes), and [owl](https://www.w3.org/TR/owl2-syntax/#Datatype_Maps)) standards.

<pre class="highlight highlight-html">
// rdfs
http://www.w3.org/2000/01/rdf-schema#literal

// rdf
http://www.w3.org/1999/02/22-rdf-syntax-ns#Plainliteral
http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLliteral

// owl
http://www.w3.org/2002/07/owl#real
http://www.w3.org/2002/07/owl#rational

// xsd
// Decimal Numbers and Integers
http://www.w3.org/2001/XMLSchema#decimal
http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2001/XMLSchema#long
http://www.w3.org/2001/XMLSchema#int
http://www.w3.org/2001/XMLSchema#short
http://www.w3.org/2001/XMLSchema#byte
http://www.w3.org/2001/XMLSchema#nonNegativeInteger
http://www.w3.org/2001/XMLSchema#positiveInteger
http://www.w3.org/2001/XMLSchema#unsignedLong
http://www.w3.org/2001/XMLSchema#unsignedInt
http://www.w3.org/2001/XMLSchema#unsignedShort
http://www.w3.org/2001/XMLSchema#unsignedByte
http://www.w3.org/2001/XMLSchema#nonPositiveInteger
http://www.w3.org/2001/XMLSchema#negativeInteger
// Floating-Point Numbers
http://www.w3.org/2001/XMLSchema#double
http://www.w3.org/2001/XMLSchema#float
// Strings
http://www.w3.org/2001/XMLSchema#string
http://www.w3.org/2001/XMLSchema#normalizedString
http://www.w3.org/2001/XMLSchema#token
http://www.w3.org/2001/XMLSchema#language
http://www.w3.org/2001/XMLSchema#Name
http://www.w3.org/2001/XMLSchema#NCName
http://www.w3.org/2001/XMLSchema#NMTOKEN
// Boolean
http://www.w3.org/2001/XMLSchema#boolean
// Binary Data
http://www.w3.org/2001/XMLSchema#hexBinary
http://www.w3.org/2001/XMLSchema#base64Binary
// IRI
http://www.w3.org/2001/XMLSchema#anyURI
// Time
http://www.w3.org/2001/XMLSchema#dateTime
http://www.w3.org/2001/XMLSchema#dateTimeStamp
</pre>

Note: for the standard scalars above to be used (cross-referenced) in a project, their respective vocabularies must be mapped by the project's catalog.xml file. To achieve that, the project can specify a direct (or transitive) dependency on the `core-vocabularies` library (from Maven Central) in the project's build.gradle file. An example of this can be seen in the [oml-template](https://github.com/opencaesar/oml-template/blob/master/build.gradle#L54-L78) project.

### Properties ### {#Properties-LR}

Properties are characteristics of model elements. Two categories of properties can be defined in a vocabulary: *annotation properties* and *semantic properties*. An [Annotation Property](#AnnotationProperty-LR) has no logical semantics and can characterize any identified element (ontology or member). On the other hand, a semantic property ([Scalar Property](#ScalarProperty-LR), [Structured Property](#StructuredProperty-LR)) or [UnreifiedRelation](#UnreifiedRelation-LR)) has logical semantics and is specified with one or more *domains* representing classifiers (or entities in the case of a relation) whose instances can be characterized by such property, and one or more *ranges* representing types of values for the property.

#### Annotation Property #### {#AnnotationProperty-LR}

An [annotation property](#AnnotationProperty-Syntax) is a property defined in a vocabulary, has no logical-semantics, can be used in annotations on identified elements (ontology or member), and can have values that are either literals or references to members. An annotation property is defined with the keywords `annotation` `property` followed by a name ID. An existing (local or imported) annotation property can be referenced by the keywords `ref` `annotation` `property` followed by its `IRI`. It can also be followed by an optional [PropertySpecializationAxiom](#PropertySpecializationAxiom-LR) and an optional [PropertyEquivalenceAxiom](#PropertyEquivalenceAxiom-LR) using the following syntax: 

<pre class="highlight highlight-html">
	Annotation*
	(`annotation` `property` ID | `ref` `annotation` `property` [AnnotationProperty|IRI])
		(PropertySpecialization)? (PropertyEquivalence)?
</pre>

The following example shows two vocabularies: *viewpoint* and *mission*. The former defines an annotation property *visualizeAs*, and the latter defines two concepts *Component* and *Function*, and annotates them using the *visualizeAs* annotation.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/viewpoint#`>` `as` viewpoint `{`
    `annotation` `property` visualizeAs
`}`

`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://com.xyz/methodology/viewpoint#`>` `as` viewpoint
    `@`viewpoint:visualizeAs "Rectangle"
    `concept` Component
    `@`viewpoint:visualizeAs "Circle"
    `concept` Function
`}`
</pre>

It is common to define libraries of annotation properties for tooling purposes to enable building generic tools. The following are some of the standard annotation properties (more information about them can be found in the [rdf](https://www.w3.org/TR/rdf-syntax-grammar/), [rdfs](https://www.w3.org/TR/rdf-schema/), [owl](https://www.w3.org/TR/owl2-syntax/), and [dc](https://www.dublincore.org/specifications/dublin-core/dcmi-terms/) specifications):

<pre class="highlight highlight-html">
// rdf
http://www.w3.org/1999/02/22-rdf-syntax-ns#about

// rdfs
http://www.w3.org/2000/01/rdf-schema#comment
http://www.w3.org/2000/01/rdf-schema#isDefinedBy
http://www.w3.org/2000/01/rdf-schema#label
http://www.w3.org/2000/01/rdf-schema#seeAlso

// owl
http://www.w3.org/2002/07/owl#backwardCompatibleWith
http://www.w3.org/2002/07/owl#deprecated
http://www.w3.org/2002/07/owl#incompatibleWith
http://www.w3.org/2002/07/owl#priorVersion
http://www.w3.org/2002/07/owl#versionInfo

// dc
http://purl.org/dc/elements/1.1/contributor
http://purl.org/dc/elements/1.1/coverage
http://purl.org/dc/elements/1.1/creator
http://purl.org/dc/elements/1.1/date
http://purl.org/dc/elements/1.1/description
http://purl.org/dc/elements/1.1/format
http://purl.org/dc/elements/1.1/identifier
http://purl.org/dc/elements/1.1/language
http://purl.org/dc/elements/1.1/publisher
http://purl.org/dc/elements/1.1/relation
http://purl.org/dc/elements/1.1/rights
http://purl.org/dc/elements/1.1/source
http://purl.org/dc/elements/1.1/subject
http://purl.org/dc/elements/1.1/itle
http://purl.org/dc/elements/1.1/type
http://purl.org/dc/elements/1.1/hasVersion

</pre>

#### Scalar Property #### {#ScalarProperty-LR}

A [scalar property](#ScalarProperty-Syntax) is a semantic property defined in a vocabulary, whose domains can be classifiers ([Aspects](#Aspect-LR), [Concepts](#Concept-LR), [Relation Entities](#RelationEntity-LR), or [Structures](#Structure-LR)) and whose ranges can be ([Scalars](#Scalar-LR). This means the values of a scalar property are literals of those scalar ranges. A scalar property is defined with the keywords `scalar` `property` followed by a name ID. An existing (local or imported) scalar property can be referenced by the keywords `ref` `scalar` `property` followed by its `IRI`. It can also specify between a pair of `[` `]` brackets optional `domain` classifiers and optional `range` scalars that can be inferred as types of values related by this property. When either is omitted, no type can be inferred for the value in that position. It can slso specify an optional DL flag `functional`that specifies that this property can relate an instance of its domains to a maximum of one literal of its ranges. The property can also be followed an optional [PropertySpecializationAxiom](#PropertySpecializationAxiom-LR) and an optional [PropertyEquivalenceAxiom](#PropertyEquivalenceAxiom-LR), using the following syntax:

<pre class="highlight highlight-html">
	Annotation*
	(`scalar` `property` ID | `ref` `scalar` `property` [ScalarProperty|IRI]) (`[`
		(`domain` [Classifier|IRI] (`,` [Classifier|IRI])*)?
		(`range` [Scalar|IRI] (`,` [Scalar|IRI])*)?
		(`functional`)?
	`]`)? (PropertySpecialization)? (PropertyEquivalence)?
</pre>

The following example vocabulary defines three scalar properties named *hasId*, *hasName*, and *isAbstract*. The *hasId* property is functional and has a domain of *Component* and a range of *xsd:string*. The *hasName* property has a domain of *Function* and a range of *xsd:string*. Finally, the *isAbstract* property is functional and has the domain of *Function* and the range of *xsd:boolean*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component
    `concept` Function
    `scalar` `property` hasId `[`
        `domain` Component
        `range` xsd:string
        `functional`
    `]`
    `scalar` `property` hasName `[`
        `domain` Function
        `range` xsd:string
    `]`
    `scalar` `property` isAbstract `[`
        `domain` Function
        `range` xsd:boolean
        `functional`
    `]`
`}`
</pre>

#### Structured Property #### {#StructuredProperty-LR}

A [structured property](#StructuredProperty-Syntax) is a semantic property defined in a vocabulary, whose domains can be classifiers ([Aspects](#Aspect-LR), [Concepts](#Concept-LR), [Relation Entities](#RelationEntity-LR), or [Structures](#Structure-LR)) and whose ranges can be ([Structures](#Structure-LR). This means the values of a structured property are instances of those structures. A stuctured property is defined with the keywords `structured` `property` followed by a name ID. An existing (local or imported) structured property can be referenced by the keywords `ref` `structured` `property` followed by its `IRI`. It can also specify between a pair of `[` `]` brackets optional `domain` classifiers and optional `range` structures that can be inferred as types of values related by this property. When either is omitted, no type can be inferred for the value in that position. It can slso specify an optional DL flag `functional`that specifies that this property can relate an instance of its domains to a maximum of one instance of its ranges. The property can also be followed an optional [PropertySpecializationAxiom](#PropertySpecializationAxiom-LR) and an optional [PropertyEquivalenceAxiom](#PropertyEquivalenceAxiom-LR), using the following syntax:

<pre class="highlight highlight-html">
	Annotation*
	(`structured` `property` ID | `ref` `structured` `property` [StructuredProperty|IRI]) (`[`
		(`domain` [Classifier|IRI] (`,` [Classifier|IRI])*)?
		(`range` [Structure|IRI] (`,` [Structure|IRI])*)?
		(`functional`)?
	`]`)? (PropertySpecialization)? (PropertyEquivalence)?
</pre>

The following example vocabulary defines a structured property named *hasLocation* whose domain is concept *Shape* and whose range is structure *Point*. The latter is the domain of two scalar properties *hasX* and *hasY* that have a range of *xsd:int*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/graphics#`>` `as` graphics `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Shape
    `structure` Point
    `structured` `property` hasLocation `[`
        `domain` Shape
        `range` Point
        `functional`
    `]`
    `scalar` `property` hasX `[`
        `domain` Point
        `range` xsd:int
        `functional`
    `]`
    `scalar` `property` hasY `[`
        `domain` Point
        `range` xsd:int
        `functional`
    `]`
`}`
</pre>

#### Unreified Relation #### {#UnreifiedRelation-LR}

 An [unreified relation](#UnreifiedRelation-Syntax) is an relation defined in a vocabulary between two entities, a source entity and a target entity . An unreified relation is declared with the keyword `relation` followed by an `ID`. An existing (local or imported) unreified relation can be referenced by the keywords `ref` `relation` followed by its `IRI`. An unreified relation specifies between a pair of `[` `]` brackets optional `from` (domain) entities and optional `to` (range) entities that can be inferred as types of instances related by this relation. When either is omitted, no type can be inferred for a related instance in that position. An unreified relation can also specify an optional name for a non-reified `reverse` relation (with the opposite domains and ranges). Moreover, It can specify various DL flags (`functional`, `inverse functional`, `symmetric`, `assymetric`, `reflective`, `irreflexive`, and `transitive`). It can also be followed by an optional [PropertySpecializationAxiom](#PropertySpecializationAxiom-LR) and an optional [PropertyEquivalenceAxiom](#PropertyEquivalenceAxiom-LR), using the following syntax.

<pre class="highlight highlight-html">
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
</pre>

The DL flags that can be specified on an unreified relation have the following logical semantics:

- The `functional` flag implies that a source instance can be related to a maximum of 1 target instance.
- The `inverse functional` flag implies that a target instance can be related to a maximum of 1 source instance.
- The `symmetric` flag implies that if a source instance is related to a target instance, then the target must also be related to the source.
- The `asymmetric` flag implies that if a source instance is related to a target instance, then the target cannot be related to the source.
- The `reflexive` flag implies that a source instance must be related to itself.
- The `irreflexive` flag implies that a source instance cannot be related to itself.
- The `transitive` flag implies if instance A is related to instance B, and instance B is related to instance C, then A is also related to C.

The following example vocabulary defines an unreified relation named *presents* from the concept *Component* to the concept *Interface*. It also has a reverse relation called *isPresentedBy*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `concept` Component
    `concept` Function
    `relation` presents `[`
        `from` Component
        `to` Function
        `reverse` isPresentedBy
    `]`
`}`
</pre>

Note: A vocabulary author has the freedom to define a relation as a relation entity or an unreified relation. The downside of choosing the unreified option is the inability of describing relation instances and characterizing them with property values.

### Axioms ### {#Axioms-LR}

Axioms are statements about terms in a vocabulary that enrich their logical semantics. This section describes the supported axioms for term kinds.

#### Key Axiom #### {#KeyAxiom-LR}

A [key axiom](#KeyAxiom-Syntax) is an axiom defined on an entity ([Aspect](#Aspect-LR), [Concept](#Concept-LR), and [Relation Entity](#RelationEntity-LR)) that specifies a set of properties that together represent a unique key (id) for the entity. This means if two named instances have the same values of those properties, then they can be inferred to be aliases of the same instance. The syntax of a key axiom starts with the keyword `key` followed by one or more comma-separated properties specified by their IRIs.

<pre class="highlight highlight-html">
`key` [Property|IRI] (`,` [Property|IRI])*
</pre>

The following example vocabulary defines a key, consisting of scalar property *hasId*, for concept *Component*. This means any two differently named components with the same value for *hasId* will be inferred to be the same component.

<pre class="highlight highlight-html">
`vocabulary` `<`http://www.w3.org/1999/02/22-rdf-syntax-ns#`>` `as` rdf `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component [
        `key` hasId
    ]
    `scalar` `property` hasId `[`
        `domain` Component
        `range` xsd:string
        `functional`
    `]`
`}`
</pre>

An entity can define zero or more keys. When multiple keys are defined, the value of each key (a tuple of values of the key properties) must be unique for an instance of the entity. In the following example, concept *Component* has two keys, one key consists of the *hasUUID* property, while the other consists of both the *hasName* and the *hasAcroname* properties. This means for each unique component, the value of *hasUUID* has to be unique, as well as the value of a tuple made of the values of *hasName* and *hasAcroname* together.

<pre class="highlight highlight-html">
`vocabulary` `<`http://www.w3.org/1999/02/22-rdf-syntax-ns#`>` `as` rdf `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component [
        `key` hasUUID
        `key` hasName, hasAcroname
    ]
`}`
</pre>

#### Instance Enumeration Axiom #### {#InstanceEnumerationAxiom-LR}

An Instance Enumeration Axiom is an axiom that can be specified within the `[` `]` brackets of a [=Concept=] to enumerate certain [Concept Instances](#ConceptInstance-LR), defined in a description ontology, as its only instances. The syntax of the axiom is as follows:

<pre class="highlight highlight-html">
	`oneOf` [ConceptInstance|IRI] (`,` [ConceptInstance|IRI])*
</pre>

The following example vocabulary defines a concept *SolarSystemPlanet* with *ss:Earth*, *ss:Mars*, and *ss:Mercurity* ...etc. as its only enumerated planets.

<pre class="highlight highlight-html">
`vocabulary` `<`http://example.com/planets#`>` `as` planets `{`
    `uses` `<`http://example.com/solarsystem#`>` `as` ss
    `concept` SolarSystemPlanet `[`
	    `oneOf` ss:Earth `,` ss:Mars `,` ss:Mercury `,` ...
    `]`
`}`
`description` `<`http://example.com/solarsystem#`>` `as` ss `{`
    `instance` Earth
    `instance` Mars
    `instance` Mercury
    ...
`}`
</pre>

#### Literal Enumeration Axiom #### {#LiteralEnumerationAxiom-LR}

A Literal Enumeration Axiom is an axiom that can be specified within the `[` `]` brackets of a [=Scalar=] to enumerate certain [Literals](#Literal-LR) as its only literals. The syntax of the axiom is as follows:

<pre class="highlight highlight-html">
	`oneOf` Literal (`,` Literal)*
</pre>

The following example vocabulary defines a scalar *RGB* with *Red*, *Green*, and *Blue* as the only enumerated literals.

<pre class="highlight highlight-html">
`vocabulary` `<`http://example.com/primitive-types#`>` `as` primitives `{`
    `scaler` RGB `[`
        oneOf "Red", "Green", "Blue"
    `]`
`}`
</pre>

#### Classifier Specialization Axiom #### {#ClassifierSpecializationAxiom-LR}


A Classifier Specialization Axiom is one that can be specified on a [=Classifier=] to specify that it specializes other [=Classifiers=] and/or has [=PropertyRestrictionAxioms=]. Its syntax starts with `<` then a list of comma-separated [=Classifier=] and/or a list of [=PropertyRestrictionAxioms=] as follows:
<pre class="highlight highlight-html">
	`<` ([Classifier|IRI] (`,` [Classifier|IRI])* 
		|
		([Classifier|IRI] (`,` [Classifier|IRI])*)? `[`
			PropertyRestrictionAxiom*
		`]`)
</pre>

Examples of using Classifier Specialization Axioms can be seen in the following:

<pre class="highlight highlight-html">
    `aspect` Component `<` IdentifiableElement
    `concept` MechanicalComponent `<` Component `[`
        `restricts` `all` contains `to` MechanicalComponent
    `]`
</pre>

classifiers can only specialize classifiers of the same kind (e.g., concept speciailzes concept, structure specializes structure, etc.). The only exception to this is [=Aspect=] which can be specialized by any entity ([=Aspect=], [=Concept=], [=RelationEntity=]).

A [=RelationEntity=], being a kind of [=Classifier=], can also specialize another [-RelationEntity=]. This case has the following extra semantics:

- The intersection of the `from` entities of a sub relation entity specializes the intersection of the `from` entities of the super relation entity.
- The intersection of the `to` entities of a sub relation entity specializes the intersection of the `to` entities of the super relation entity.
- The `forward` relation (when named) of the sub relation entity specializes the `forward` relation of the super relation entity.
- The `reverse` relation (when named) of the sub relation entity specializes the `reverse` relation of the super relation entity.

An example of [=RelationEntity=] specialization is given below. In this case, what is inferred is the following a) entity *Assembly* specializes entity *component*, entity *Power* specializes entity *Function*, relation *provides* specializes *performs*, and relation *isProvidedBy* specializes *isPerformedBy*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `concept` Component
    `concept` Function
    `concept` Assembly
    `concept` Power
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
        `forward` performs
        `reverse` isPerformedBy
   `]`
    `relation` `entity` Provides < Performs `[`
        `from` Assembly
        `to` Power
        `forward` provides
        `reverse` isProvidedBy
   `]`
`}`
</pre>

#### Classifier Equivalence Axiom #### {#ClassifierEquivalenceAxiom-LR}

A Classifier Equivalence Axiom is one that can be specified on a [=Classifier=] to specify that it is equivalent to the intersection of other [=Classifiers=] and/or [=PropertyRestrictionAxioms=]. The syntax starts with `=` then a list of comma-separated [=ClassifierEquivalenceAxiom=], each of which consists of a `&` separated list of classifiers and/or a list of [=PropertyRestrictionAxioms=] between `[` `]` brackets as follows:

<pre class="highlight highlight-html">
`=` ClassifierEquivalenceAxiom (`,` ClassifierEquivalenceAxiom)*

&lt;ClassifierEquivalenceAxiom&gt;:
	[Classifier|IRI] (`&` [Classifier|IRI])*
	|
	([Classifier|IRI] (`&` [Classifier|IRI])*)? `[`
		PropertyRestrictionAxiom*
	`]`
</pre>

Examples of using Classifier Equivalence Axioms can be seen in the following:

<pre class="highlight highlight-html">
    `concept` FunctionalComponent `=` Component `[`
        `restricts` `some` hasRequirement `to` FunctionalRequirement
    `]`
    `concept` HawaianPizza `=` CheesyPizza `&` SaucyPizza `[`
        `restricts` `some` hasTopping `to` Ham
        `restricts` `some` hasTopping `to` Pineapple
    `]`
</pre>

Saying that classifier *A* is equivalent to *B* is like saying that *A* specializes *B* and *B* specializes *A*. Therefore, the semantic of classifier specialization described for [=ClassifierSpecializationAxiom] hold in both directions. This means if an instance is asserted to be typed by *A*, it will be inferred to be typed by *B* as well and vice versa (bidirectional inferencing). However, if *B* is an intersection of multiple [=Classifiers=] and/or [=PropertyRestrictionAxioms=] then the inverse specialization is not inferred until an instance of *A* is an instance of each of the intersecting components. In the example above, if an instance is a *Component* and has some of its requirements as *FunctionalRequirement*, then the instance can be inferred to be a *FunctionalComponent*.

Note: that equivalent classes must be of the same kind (e.g., concept is equivalent to concepts). The only exception is when an entity *A* is equivalent to an intersection of [=Classifiers=] and/or [=PropertyRestrictionAxioms=], in which case some of the equivalent classifiers could be [=Aspects=].

#### Scalar Specialization Axiom #### {#ScalarSpecializationAxiom-LR}

A Scalar Specialization Axiom is one that can be specified on a [=Scalar=] to specify that it specializes other [=Scalars=]. Its syntax starts with `<` then a list of comma-separated [=Scalars=] as follows:

<pre class="highlight highlight-html">
	`<` Scalar (`,` Scalar)*
</pre>

Note: a Scalar Specialization Axiom is only allowed on OML's [standard scalars](#Scalar-LR). Non-standard scalars can only specify [=ScalarEquivalenceAxioms=].

An example of a Scalar Specialization Axiom is as follows:

<pre class="highlight highlight-html">
	`scalar` rational `<` real
</pre>

#### Scalar Equivalence Axiom #### {#ScalarEquivalenceAxiom-LR}

A Scalar Equivalence Axiom is one that can be specified on a [=Scalar=] to specify that it is equivalent to other [=Scalars=] optionally with some facets (value restrictions). The syntax starts with `=` then a list of comma-separated [=ScalarEquivalenceAxiom=], each of which consists of a [=Scalar=] reference and optionally between `[` `]` bracketszero or more value-restricting faceets, as follows:

<pre class="highlight highlight-html">
`=` ScalarEquivalenceAxiom (`,` ScalarEquivalenceAxiom)*;

&lt;ScalarEquivalenceAxiom&gt;:
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
</pre>

Note: When facets are specified on a Scalar Equivalence Axiom, the referenced equivalent [=Scalar=] must be one of the [standard scalars](#Scalar-LR) of OML.

The facets have the following semantics (and applicability to certain kinds of standard scalars):

- Facet `length` specifies the exact length of the lexical representation (of strings and literals)
- Facet `minLength` specifies the minimum length of the lexical representation (of strings and literals)
- Facet `maxLength` specifies the maximum length of the lexical representation (of strings and literals)
- Facet `pattern` specifies a regular expression of the lexical representation (of strings and literals)
- Facet `language` specifies a natural language for the lexical representation (of strings and literals)
- Facet `minInclusive` specifies the minimum inclusive value (of numbers)
- Facet `minExclusive` specifies the minimum exclusive value (of numbers)
- Facet `maxInclusive` specifies the maximum inclusive value (of numbers)
- Facet `maxExclusive` specifies the maximum exclusive value (of numbers)

The following is an example of a Scalar Equivalence Axiom:

<pre class="highlight highlight-html">
`scalar ` SSN ` = ` xsd:string `[`
    `pattern` "^\d{3}-?\d{2}-?\d{4}$"
`]`
</pre>

#### Property Specialization Axiom #### {#PropertySpecializationAxiom-LR}

A Property Specialization Axiom is one that can be specified on a [=Property=] to specify that it specializes other [=Properties=] of the same kind (e.g., scalar property speciailzes scalar property). Its syntax starts with `<` then a list of comma-separated [=Properties=] as follows:

<pre class="highlight highlight-html">
	`<` Property (`,` Property)*
</pre>

Examples of using Property Specialization Axioms can be seen in the following:

<pre class="highlight highlight-html">
    `scalar` `property` hasEnglishName `[`
        `domain` Person
        `range` rdf:PlainLiteral
    `]` `<` hasName
    `relation` joins1 `[`
        `from` Interface
        `to` Interface
        `reverse` isJoinedBy1
    `]` `<` joins
</pre>

Note: a relation is a kind of property.

#### Property Equivalence Axiom #### {#PropertyEquivalenceAxiom-LR}

A Property Equivalence Axiom is one that can be specified on a [=Property=] to specify that it is equivalent to one or more other [=Properties=]. The syntax starts with `=` then a list of comma-separated [=PropertyEquivalenceAxiom=], each of which has a reference to a Property.

<pre class="highlight highlight-html">
`=` PropertyEquivalenceAxiom (`,` PropertyEquivalenceAxiom)*

&lt;PropertyEquivalenceAxiom&gt;:
	[Property|IRI]
</pre>

Examples of using Property Equivalence Axioms can be seen in the following:

<pre class="highlight highlight-html">
    `scalar` `property` hasRational `=` hasObjective
    `relation` hasUncle `[` 
        `from` Person
        `to` Person
        `forward` hasUncle
    `]` `=` hasParentBrother
</pre>

Saying that property *a* is equivalent to *b* is like saying that *a* specializes *b* and *b* specializes *a*. Therefore, the semantic of property specialization described for [PropertySpecializationAxiom](#PropertySpecializationAxiom-LR) hold in both directions. This means if an instance is asserted to have a value of property *a*, it will be inferred to have the same value for property *b* well and vice versa (bidirectional inferencing).

Note: that equivalent properties must be of the same kind (e.g., scalar property is equivalent to scalar property).

#### Property Value Restriction Axiom #### {#PropertyValueRestrictionAxiom-LR}

A [property value restriction axiom](#PropertyValueRestrictionAxiom-Syntax) is an axiom defined on a classifier ([Aspect](#Aspect-LR), [Concept](#Concept-LR), [Relation Entity](#RelationEntity-LR) and [Structure](#Structure-LR)) that restricts a semantic property in some way in the classifier's context. This property can be ([Scalar Property](#ScalarProperty-LR), [Structured Property](#StructuredProperty-LR), [Forward Relation](#RelationEntity-LR), [Reverse Relation](#RelationEntity-LR), or [Unreified Relation](#UnreifiedRelation-LR)) whose domain is the context type or one of its supertypes. The facets that can be restricted about those properties vary (like their range, cardinality, or value) resulting in different subtypes of restriction axioms.

Note: a structure can specify property value restriction axioms only on scalar and structures properties, but not relations (forward, reverse, or unreified) since a structure cannot be a source (domain) or target (range) of a relation.

<u>Property Range Restriction Axioms</u>

A range restriction axiom restricts the range of a property in the context of some classifier. The axiom specifies a restricted range that is a subtype of the property's original range. The syntax of a range restriction axioms starts with the keyword `restricts` followed by a restriction kind, which can either be `all` (requiring all values to conform to the restricted range) or `some` (requiring at least one value to conform to the restricted range). This is followed by the kind of property (`scalar property`, `structured property`, or `relation`) then a reference to the property by IRI. Finally, the keyword `to` is used followed by a reference to the restricted range (a scalar, a structure, or an entity) by IRI. The following shows the three supported syntaxes:

<pre class="highlight highlight-html">
	`restricts` [ `all` | `some` ] [ScalarProperty|IRI] `to` [Scalar|IRI]
	`restricts` [ `all` | `some` ] [StructuredProperty|IRI] `to` [Structure|IRI]
	`restricts` [ `all` | `some` ] [Relation|IRI] `to` [Entity|IRI]
</pre>

The following example shows a vocabulary that defines a concept *Assembly* with some range restrictions.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component
    `concept` Function
    `concept` Assembly < Component [
        `restricts` `all` hasId `to` ten-chars          // the hasId value must be 10-char strings
        `restricts` `some` hasPin `to` InputPin     // there must be at least one input pin
        `restricts` `all` performs `to` Power                  // power is the only performed function 
    ]
    `concept` Power < Function
    `scalar` ten-chars < xsd:string `[`
        `length` 10
    `]`
    `structure` Pin
    `structure` InputPin < Pin
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
        `forward` performs
        `reverse` isPerformedBy
   `]`
    `scalar` `property` hasId `[`
        `domain` Component
        `range` xsd:string
        `functional`
   `]`
    `structured` `property` hasPin `[`
        `domain` Component
        `range` Pin
        `functional`
   `]`
`}`
</pre>

<u>Property Cardinality Restriction Axioms</u>

A cardinality restriction axiom restricts the cardinality of a property in the context of some classifier. The axiom specifies a minimum, a maximum, or an exact number of values, conforming to the original range, or to a specified restricted range, that a property can have in that context. The syntax of a cardinality restriction axioms starts with the keyword `restricts` followed by the kind of property (`scalar property`, `structured property`, or `relation`) then a reference to the property by IRI. Then, the keyword `to` is used followed by a cardinality kind (`min`, `max`, or `exactly`), a cardinality value (positive integer), and finally an optional reference to a restricted range (a scalar, a structure, or an entity) by IRI. The following shows the three supported syntaxes:

<pre class="highlight highlight-html">
	`restricts` [ScalarProperty|IRI] `to` [ `max` | `min` | `exactly` ] UnsignedInteger [Scalar|IRI]?
	`restricts` [StructuredProperty|IRI] `to` [ `max` | `min` | `exactly` ] UnsignedInteger [Structure|IRI]?
	`restricts` [Relation|IRI] `to` [ `max` | `min` | `exactly` ] UnsignedInteger [Entity|IRI]?
</pre>

The following example shows a vocabulary that defines a concept *Assembly* with some cardinality restrictions.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component
    `concept` Function
    `concept` Assembly < Component [
        `restricts` hasId `to` exactly 1              // hasId must have a single value only
        `restricts` hasPin `to` max 2 InputPin    // there must be at most two input pins
        `restricts` performs `to` min 5                      // a minimum of 5 functions must be performed
    ]
    `structure` Pin
    `structure` InputPin < Pin
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
        `forward` performs
        `reverse` isPerformedBy
   `]`
    `scalar` `property` hasId `[`
        `domain` Component
        `range` xsd:string
        `functional`
   `]`
    `structured` `property` hasPin `[`
        `domain` Component
        `range` Pin
        `functional`
   `]`
`}`
</pre>

<u>Property Value Restriction Axioms</u>

A value restriction axiom restricts the value of a property in the context of some classifier. In the case of a relation, the restricted value represents the relation's target instance. The syntax of a value restriction axioms starts with the keyword `restricts` followed by a reference to the property by IRI. Then, the keyword `to` is used followed by a value that is suitable for each case (a [literal](#Literal-Syntax) for a scalar property, a [structure instance](#StructureInstance-Syntax) for a structured property, or a reference to a [named instance](#NamedInstance-Syntax) by IRI for a relation). The following shows the three supported syntaxes:

<pre class="highlight highlight-html">
	`restricts` [ScalarProperty|IRI] `to` Literal
	`restricts` [StructuredProperty|IRI] `to` StructureInstance
	`restricts` [Relation|IRI] `to` [NamedInstance|IRI]
</pre>

The following example shows a vocabulary that defines a concept *Assembly* with some value restrictions.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `uses` `<`http://com.xyz/methodology/functions#`>` `as` functions
    `concept` Component
    `concept` Function
    `concept` Assembly < Component [
        `restricts` hasId `to` "ABC"                          // hasId must have a value of "ABC"
        `restricts` hasPin `to` Pin `[` hasNumber 1 `]`   // hasPin must have a Pin with hasNumber of 1
        `restricts` performs `to` functions:F1                         // the performed function must be functions:F1
    ]
    `structure` Pin
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
        `forward` performs
        `reverse` isPerformedBy
   `]`
    `scalar` `property` hasId `[`
        `domain` Component
        `range` xsd:string
        `functional`
   `]`
    `structured` `property` hasPin `[`
        `domain` Component
        `range` Pin
        `functional`
   `]`
    `scalar` `property` hasNumber `[`
        `domain` Pin
        `range` xsd:int
        `functional`
   `]`
`}`

`description` `<`http://com.xyz/methodology/functions#`>` `as` functions `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `ci` F1 `:` mission:Function
}
</pre>

<u>Property Self Restriction Axioms</u>

A self restriction axiom restricts the value of a relation in the context of some classifier to the context itself. In other words, it restricts the instance that is the target of a relation to be the same one as the source of the relation. The syntax of a self restriction axioms starts with the keyword `restricts` followed by a reference to the relation by IRI, followed by the keyword `to` then finally the keyword `self`. The following shows the supported syntaxes:

<pre class="highlight highlight-html">
	`restricts` [Relation|IRI] `to` `self`
</pre>

The following example shows a concept *Person* with a self restrictions on relation `reliesOn`:

<pre class="highlight highlight-html">
`concept` Person [
    `restricts` reliesOn `to` `self`   // A person only relies on themselves
]
</pre>


### BuiltIn ### {#BuiltIn-LR}

A [builtin](#BuiltIn-Syntax) is a standard function that can be invoked from a [=Rule=]'s [=BuiltInPredicate=]. The syntax of a builtin  starts with the keyword `builtin` followed by a name ID. An existing (local or imported) builtin can be referenced by the keywords `ref` `builtin` followed by its `IRI` as follows:

<pre class="highlight highlight-html">
	Annotation*
	(`builtin` ID | `ref` `builtin` [BuiltIn|IRI])
</pre>

Note: OML supports all the stadard builtins from the [swrlb](https://www.w3.org/Submission/SWRL/#8) vocabulary. This vocabulary is included in the core-vocabularies library (from Maven Central) which is a project declare a dependency on in its build.gradle file.

An example of some of those builtins include:

<pre class="highlight highlight-html">
`vocabulary` `<`http://www.w3.org/2003/11/swrlb#`>` `as` swrlb `{`
    `builtin` equal
    `builtin` notEqual
    `builtin` lessThan
    `builtin` lessThanOrEqual
`}`
</pre>

### Rule ### {#Rule-LR}

A [rule](#Rule-Syntax) is a member of a vocabulary and represents an additional inference rule in the domain that can be used by a reasoner to generate entailments. A rule has two sets of predicates (patterns that must hold); the first set is called the rule's antecedent (predicates to match for the rule to trigger), and the second set is called the rule's consequent (predicates that are inferred once the antecedent is matched). The syntax of a rule starts with the keyword `rule` followed by a name ID, then a pair of square brackets `[` `]` that holds the rule's predicates. The antecedent predicates are specified first separated by the `&` symbol (which means a logical AND), followed by an implication arrow `->`, then the consequent predicates separated also by the `&` symbol.

<pre class="highlight highlight-html">
	Annotation*
	`rule` ID `[`
		Predicate (`&` Predicate)* `->` Predicate (`&` Predicate)*
	`]`
</pre>

A predicate represents a pattern in the model that can be matched or inferred, depending on whether it appears in a rule's antecedent or consequent, respectively. The set of supported predicates are the following:

Note: all the arguments to the predicats below can be one of three values: a) a variable ID (e.g., x, y), b) a literal (e.g., 3, "hello"), or c) a member reference (e.g., solar:Sun).

- [Type Predicate](#TypePredicate-Syntax)

     Matches an instance of a given type (specified by its IRI) and binds it to the argument.
    <pre class="highlight highlight-html">
    [Type|IRI] `(` Argument `)`
    </pre>

- [Relation Entity Predicate](#RelationEntityPredicate-Syntax)

    Matches a instance of a given relation entity (specified by its IRI) and binds it to argument0, its source to argument1, and its target 
    to argument2.
     <pre class="highlight highlight-html">
    [RelationEntity|IRI] `(` Argument1 `,` Argument0 `,` Argumen2 `)`
    </pre>

- [Property Predicate](#PropertyPredicate-Syntax)

    Matches an assertion of a given property (specified by its IRI) and binds its subject to argument1 and its object to argument2.
    <pre class="highlight highlight-html">
    [Property|IRI] `(` Argument1 `,` Argument2 `)`
    </pre>

- [Same As Predicate](#SameAsPredicate-Syntax)

    Matches when the value bound to argument1 is the same as the value bound to argument2 or a specific instance.
    <pre class="highlight highlight-html">
    `sameAs` `(` Argument1 `,` Argument2 `)`
    </pre>

- [Different From Predicate](#DifferentFromPredicate-Syntax)

    Matches when the value bound to argument1 is different from the value bound to argument2.
    <pre class="highlight highlight-html">
    `differentFrom` `(` Argument1 `,` Argument2 `)`
    </pre>

- [BuiltIn Predicate](#BuiltInPredicate-Syntax)

    Matches when the first argument is the result of invoking the referenced builtin function with the remaining arguments bound to its parameters.
    <pre class="highlight highlight-html">
    `builtIn` `(` [BuiltIn|IRI] `,` Argument (`,` Argument)* `)`
    </pre>

The following example vocabulary shows a couple of rules, *R1* and *R2*:

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `extends` `<`http://www.w3.org/2003/11/swrlb#`>` `as` swrlb
    `concept` Component
    `concept` AComponent < Component
    `concept` Function
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
        `forward` performs
        `reverse` isPerformedBy
   `]`
    `relation` `entity` Invokes `[`
        `from` Function
        `to` Function
        `forward` invokes
        `reverse` isInvokedBy
   `]`
    `scalar` `property` hasId `[`
        `domain` Component
        `range` xsd:string
        `functional`
   `]`
    // if a component performs a function that invokes another function, then the component invokes the latter too
   `rule` R1 `[`
        Component `(` c `)` `&` performs `(` c, f1 `)` `&` invokes `(` f1, f2 `)` `->` performs `(` c, f2 `)`
   `]`
    // if a component has a different id from another component, then they must be different components
   `rule` R2 `[`
        hasId `(` c1, i1 `)` `&` hasId `(` c2, i2 `)` `&` `differentFrom` `(` i1, i2 `)` `->` `differentFrom` `(` c1, c2 `)`
   `]`
   `rule` R3 `[`
       hasId(x, y) & `builtin` `(` swrlb:startsWith, y, "a" `)` `->` AComponent `(` x `)`
   `]`
`}`
</pre>

## Description ## {#Description-LR}

A [description](#Description-Syntax) is an ontology that uses vocabularies to describe [named instances](#NamedInstance-Syntax) in a given domain. A description is declared with the keywords `description` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID. It also has a body consisting of zero or more description imports and statements between two braces `{` `}`, as follows:

<pre class="highlight highlight-html">
Annotation*
`description` NAMESPACE `as` ID `{`
	Import*
	DescriptionStatement*
`}`
</pre>

The following example description is meant to describe the components of a system. It has the namespace *http://com.xyz/system/components#* and the prefix *components*.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
`}`
</pre>

### Imports ### {#DescriptionImports-LR}

This section outlines the kind of import statements (extension, usage) that can be added in a description's body.

#### Extension #### {#DescriptionExtension-LR}

An [extension](#ImportKind) is a kind of [import](#Import) statement that can be added to a description to specify that it extends another description. This can be used to split a system description into fragments that focus on different concerns or are contributed by different authorities. In this case, a description may extend other descriptions that it depends on. A description extension is defined with the keyword `extends` followed by the extended description's NAMESPACE, followed by the keyword `as` and a unique prefix ID.

<pre class="highlight highlight-html">
Annotation*
`extends` [Description|NAMESPACE] `as` ID
</pre>

The following example description *subsystem1* extends two other descriptions, *subsystem1* and *subsystem2*, and defines component *System1* that aggregates components *Subsystem1* and *Subsystem2* defined in these descriptions, respectively.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/system1#`>` `as` system1 `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `extends` `<`http://com.xyz/methodology/system1/subsystem1#`>` `as` subsystem1
    `extends` `<`http://com.xyz/methodology/system1/subsystem2#`>` `as` subsystem2

    `ci` System1 `:` mission:Component `[`
        mission:aggregates subsystem1:Subsystem1    // a cross-reference Subsystem subsystem1
        mission:aggregates subsystem2:Subsystem2    // a cross-reference Subsystem subsystem2
    `]`
`}`
</pre>

#### Usage #### {#DescriptionUsage-LR}

A [usage](#ImportKind) is a kind of [import](#Import) statement that can be added to a description to specify a vocabulary that it uses. This is typically needed in order to use the terms (types and properties) of the vocabulary in the description's instance definitions. A description usage is defined with the keyword `uses` followed by the used vocabulary's NAMESPACE, followed by the keyword `as` and a unique prefix ID.

<pre class="highlight highlight-html">
Annotation*
`uses` [Vocabulary|NAMESPACE] `as` ID
</pre>

In the following example description, the *mission* vocabulary is used to describe components of a system.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission

    `ci` System1 `:` mission:Component     // a cross-reference to concept Component
`}`
</pre>

### Instances ### {#Instances-LR}

Instances represent objects or data in a given system. They are described using terms (types and properties) from some vocabulary. Specifically, they can be given types and have assertions on properties in the domain of those types. Instances can either be named ([Concept Instance](#ConceptInstance-LR) and [Relation Instance](#RelationInstance-LR)), in which case they are specified as members of some description, or they can be anonymous ([Structure Instance](#StructureInstance-LR)), in which case they defined as values of properties (e.g., [structured properties](#StructuredProperty-LR)) in the context of other (named or anonymous) instances.

#### Concept Instance #### {#ConceptInstance-LR}

A [concept instance](#ConceptInstance-Syntax) is a named instance defined as a member of a description and can be typed by concepts (from some imported vocabulary). The concept instance is declared with the keyword `ci` and a name ID. It can optionally be followed by a `:` and the IRIs of one or more concepts that are considered types of the instance. It can also optionally be followed by a pair of square brackets `[` `]` that holds assertions about the instance.

<pre class="highlight highlight-html">
	Annotation*
	`ci` ID (`:` [Concept|IRI] (`,` [Concept|IRI])*)? (`[`
        Assertion*
    `]`)?
</pre>

The following example description defines two concept instances: one named *component1* and typed by concept *mission:Component*, while the other is named *function1* and typed by concept *mission:Function*.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `ci` component1 `:` mission:Component
    `ci` function1 `:` mission:Function
`}`
</pre>

#### Relation Instance #### {#RelationInstance-LR}

A [relation instance](#RelationInstance-Syntax) is a named instance defined as a member of a description and can be typed by relation entities (from some imported vocabulary). The relation instance is declared with the keyword `ri` and a name ID. It can optionally be followed by a `:` and the IRIs of one or more relation entities that are considered types of the instance. It is also followed by a pair of square brackets `[` `]` that allows specifying the sources and targets of the relation instance and holds assertions about the instance. The sources of the relation instance are specified with the keyword `from` followed by one or more IRIs of named instances. Similarly, the targets of the relation instance are specified with the keyword `to` followed by one or more IRIs of named instances.

Since a relation entity is a reified relation, it can be asserted as a type of a [relation instance](#RelationInstance-LR) between one or more source instances, and one or more target instances. Such instance can be annotated and characterized with assertions. 

<pre class="highlight highlight-html">
	Annotation*
	`ri` ID (`:` [RelationEntity|IRI] (`,` [RelationEntity|IRI])*)? `[`
		`from` [NamedInstance|IRI] (`,` [NamedInstance|IRI])* 
		`to` [NamedInstance|IRI] (`,` [NamedInstance|IRI])*
		Assertion*
	`]`
</pre>

The following example description defines three concept instances: *component1* typed by concept *mission:Component*, and *function1* and *function2* typed by concept *mission:Function*. It also defines a relation instance *performs1* typed by the *mission:Performs* relation entity that has *component1* as a source, and both *function1* and *function2* as targets.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `ci` component1 `:` mission:Component
    `ci` function1 `:` mission:Function
    `ci` function2 `:` mission:Function
    `ri` perform1 `:` mission:Performs `[`
        `from` component1
        `to` function1, function2
    `]`
`}`
</pre>

#### Structure Instance #### {#StructureInstance-LR}

A [structure instance](#StructureInstance-Syntax) is an anonymous instance that can be defined as a value of a structured property. Such value can either be specified in a [property value assertion](#PropertyValueAssertion-LR), defined in the context of some instance, or in a [property value restriction axiom](#PropertyValueRestrictionAxiom-LR) on some structured property in the context of some classifier. A structure instance is declared with the IRI of a structure followed by a pair of square brackets `[` `]` that holds assertions about the instance.

<pre class="highlight highlight-html">
	[Structure|IRI] `[`
		Assertion*
	`]`
</pre>

The following example shows .

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/system/components#`>` `as` components `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `uses` `<`http://com.xyz/methodology/functions#`>` `as` functions
    `concept` Component [
        `restricts` hasPin `to` Pin `[` hasNumber 1 `]`   // structure instance used as restricted value
    ]
    `structure` Pin
    `structured` `property` hasPin `[`
        `domain` Component
        `range` Pin
        `functional`
   `]`
    `scalar` `property` hasNumber `[`
        `domain` Pin
        `range` xsd:int
        `functional`
   `]`
`}`

`description` `<`http://com.xyz/methodology/functions#`>` `as` functions `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `ci` C1 `:` mission:Component `[`
        mission:hasPin Pin `[` mission:hasNumber 2 `]`                    // structure instance used in value assertion
    `]`
`}`
</pre>

### Assertions ### {#Assertions-LR}

Assertions are statements about instances that enable characterizing them. They appear in the body of an instance (either named or anonymous) between its two brackets `[` `]`. This section describes the supported assertions, which include a [property value assertion](#PropertyValueAssertion-LR) that can be specified on (concept, relation, or structure) instances.

#### Property Value Assertion #### {#PropertyValueAssertion-LR}

A value for a (scalar, structure, relation) property can be [asserted](#PropertyValueAssertion-Syntax) on an instance ([Concept Instance](#ConceptInstance-LR), [Relation Instance](#RelationInstance-LR), or [Structure Instance](#StructureInstance-LR)). Such assertion can be added as one of the assertions between the square  brackets `[` `]` of the instance. Its syntax consists of an IRI to a [property](#Property-Syntax) from some vocabulary followed by a value, which could be a literal (in the case of a scalar property), a structure instance (in the case of a structured property), or an IRI of a named instance (in the case of a relation).

<pre class="highlight highlight-html">
[ScalarProperty|IRI] Literal
[StructuredProperty|IRI] StuctureInstance
[Relation|IRI] [NamedInstance|IRI]
</pre>

Note: a structure instance can specify property value assertion only for scalar and structures properties, but not relations (forward, reverse, or unreified) since a structure cannot be a source (domain) or target (range) of a relation.

The following example description defines two concept instances that each makes a number of  property assertions. Specifically, instance *component1* asserts that the *mission:hasId* scalar property has a string value of *C1*, the *mission:hasPin* structured property as a structure instance (whose *mission:hasNumber* property value is asserted to be 2) as a value, and the *mission:performs* relation has the IRI of instance *function1* as a value. Also, instance *function1* asserts that its *mission:hasName* property has a string value of *F1*. 

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `ci` component1 `:` mission:Component `[`
        mission:hasId 'C1'        							// scalar property value assertion
        mission:hasPin Pin `[` mission:hasNumber 2 `]`      // structure property value assertion
        mission:performs function1    						// relation value assertion
    `]`
    `ci` function1 `:` mission:Function `[`
        mission:hasName 'F1'      							// scalar property value assertion
    `]`
`}`
</pre>

## Vocabulary Bundle ## {#VocabularyBundle-LR}

A [vocabulary bundle](#VocabularyBundle-Syntax) is an ontology that bundles a set of vocabularies and allows description logic (DL) reasoning with [closed-world semantics](#Mapping-to-Owl-and-Swrl) using them (in contrast to a vocabulary that has [open-world semantics](#Mapping-to-Owl-and-Swrl)). A vocabulary bundle is declared with the keywords `vocabulary` `bundle` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID. It also has a body consisting of zero or more vocabulary bundle imports between two braces `{` `}`, as follows:

<pre class="highlight highlight-html">
Annotation*
`vocabulary` `bundle` NAMESPACE `as` ID `{`
`}`
</pre>

For example, the following vocabulary bundle has the namespace *http://com.xyz/methodology/foundation#* and the prefix *foundation*.

<pre class="highlight highlight-html">
`vocabulary` `bundle` `<`http://com.xyz/methodology/foundation#`>` `as` foundation `{`
	VocabularyBundleImport*
`}`
</pre>

### Imports ### {#VocabularyBundleImports-LR}

This section outlines the kind of import statements that can be added in a vocabulary bundle's body.

#### Extension #### {#VocabularyBundleExtension-LR}

An [extension](#ImportKind) is a kind of [import](#Import) statement that can be added to a vocabulary bundle to specify that it extends another vocabulary bundle. This can be used to organize vocabulary bundles in layers that build on each other. Each bundle inherits the vocabularies contributed by its extended bundles and may optionally add to them other included vocabularies. This can, for example, be used to define a family of related vocabulary bundles that build on each other by tackling different incremental concerns. A vocabulary bundle extension is defined with the keyword `extends` followed by the extended vocabulary bundle's NAMESPACE.

<pre class="highlight highlight-html">
Annotation*
`extends` [VocabularyBundle|NAMESPACE]
</pre>

For example, the *cyber-physical* vocabulary bundle *extends* the *foundation* vocabulary bundle (which includes the *mission* vocabulary) to include two other vocabularies: *electrical* and *mechanical*, which are two disciplines used when describing cyber-physical systems.

<pre class="highlight highlight-html">
`vocabulary` `bundle` `<`http://com.xyz/methodology/cyber-physical#`>` `as` cyber-physical `{`
    `extends` `<`http://com.xyz/methodology/foundation#`>`
    `includes` `<`http://com.xyz/methodology/electrical#`>`
    `includes` `<`http://com.xyz/methodology/mechanical#`>`
`}`
</pre>

#### Inclusion #### {#VocabularyBundleInclusion-LR}

An [inclusion](#ImportKind) is a kind of [import](#Import) statement that can be added to a vocabulary bundle to specify that it includes a vocabulary. A vocabulary bundle inclusion is defined with the keyword `includes` followed by the included vocabulary's NAMESPACE.

<pre class="highlight highlight-html">
Annotation*
`includes` [Vocabulary|NAMESPACE]
</pre>

For example, the *foundation* vocabulary bundle *includes* two vocabularies: *mission* and *project*.

<pre class="highlight highlight-html">
`vocabulary` `bundle` `<`http://com.xyz/methodology/foundation#`>` `as` foundation `{`
    `includes` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `includes` `<`http://com.xyz/methodology/project#`>` `as` project
`}`
</pre>

## Description Bundle ## {#DescriptionBundle-LR}

A [description bundle](#DescriptionBundle-Syntax) is an ontology that bundles a set of descriptions and allows them to be reasoned on as a dataset using description logic (DL). A description bundle is declared with the keywords `description` `bundle` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID. It also has a body consisting of zero or more description bundle imports between two braces `{` `}`, as follows:

<pre class="highlight highlight-html">
Annotation*
`description` `bundle` NAMESPACE `as` ID `{`
	DescriptionBundleImport*
`}`
</pre>

For example, the following description bundle has the namespace *http://com.xyz/missions/mission1#* and the prefix *mission1*.

<pre class="highlight highlight-html">
`description` `bundle` `<`http://com.xyz/missions/mission1#`>` `as` mission1 `{`
`}`
</pre>

### Imports ### {#DescriptionBundleImports-LR}

This section outlines the kind of import statements that can be added in a description bundle's body.

#### Extension #### {#DescriptionBundleExtension-LR}

An [extension](#ImportKind) is a kind of [import](#Import) statement that can be added to a description bundle to specify that it extends another description bundle. This can be used to organize description bundles into layers that build on each other. Each bundle inherits the descriptions contributed by its extended bundles and optionally adds to them other descriptions. This can, for example, be used to define alternative datasets (e.g., representing alternative system designs) that extend a common dataset. A description bundle extension is defined with the keyword `extends` followed by the extended description bundle's NAMESPACE.

<pre class="highlight highlight-html">
Annotation*
`extends` [DescriptionBundle|NAMESPACE]
</pre>

For example, the *design1* description bundle *extends* the *mission1* description bundle and includes two additional descriptions: *electrical1* and *mechanical1*, which specify the details of this design variant.

<pre class="highlight highlight-html">
`description` `bundle` `<`http://com.xyz/missions/mission1/design1#`>` `as` design1 `{`
    `extends` `<`http://com.xyz/missions/mission1#`>`
    `includes` `<`http://com.xyz/missions/mission1/electrical1#`>`
    `includes` `<`http://com.xyz/missions/mission1/mechanical#`>`
`}`
</pre>

#### Usage #### {#DescriptionBundleUsage-LR}

A [usage](#ImportKind) is a kind of [import](#Import) statement that can be added to a description bundle to specify that it uses either a vocabulary bundle or a vocabulary. A description bundle should use at least one vocabulary bundle (to import its world-closure statements). In this case, the usage is defined with the keyword `uses` followed by the imported vocabulary bundle's NAMESPACE. The same syntax is used when a description bundle uses a vocabulary, except that the vocabulary's NAMESPACE can optionally be followed by the `as` keyword and a unique prefix ID,  when a member of the used vocabulary (typically an annotation property) is cross-referenced.

<pre class="highlight highlight-html">
Annotation*
`uses` ( ([VocabularyBundle|NAMESPACE]) | ([Vocabulary|NAMESPACE] (`as` ID)?) )
</pre>

For example, the *mission1* description bundle *uses* the *dc* vocabulary and the *foundation* vocabulary bundle.

<pre class="highlight highlight-html">
`@`dc:title "Mission1 Bundle"
`description` `bundle` `<`http://com.xyz/missions/mission1#`>` `as` mission1 `{`
    `uses` `<`http://purl.org/dc/elements/1.1/`>` `as` dc // vocabulary
    `uses` `<`http://com.xyz/methodology/foundation#`>` // vocabulary bundle
    `includes` `<`http://com.xyz/system/components#`>` `as` components
    `includes` `<`http://com.xyz/system/masses#`>` `as` masses
`}`
</pre>

#### Inclusion #### {#DescriptionBundleInclusion-LR}

An [inclusion](#ImportKind) is a kind of [import](#Import) statement that can be added to a description bundle to specify that it includes a description. A description bundle inclusion is defined with the keyword `includes` followed by the imported description's NAMESPACE.

<pre class="highlight highlight-html">
Annotation*
`includes` [Description|NAMESPACE]
</pre>

For example, the *mission1* description bundle *includes* two descriptions: *components* and *masses*.

<pre class="highlight highlight-html">
`description` `bundle` `<`http://com.xyz/missions/mission1#`>` `as` mission1 `{`
    `includes` `<`http://com.xyz/system/components#`>`
    `includes` `<`http://com.xyz/system/masses#`>`
`}`
</pre>