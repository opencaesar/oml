# Language Reference # {#Language-Reference}

This section presents the OML language features using its textual syntax as a notation. All the presented features exist in the other syntaxes except when noted otherwise. It is recommended that a reader starts with the common idioms section to gain an understanding of the language's basics, before reading the other sections.

## Common Idioms ## {#Common-Idioms-LR}

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

An ontology is the root element of an OML model and the unit of organizing ontological statements. It is defined with one of the `<ontology>` keywords (see [ontology syntax](#Ontology-Syntax) for details), a globally unique NAMESPACE, a locally unique ID (representing a NAMESPAC prefix), a set of imports (of other ontologies), and a set of statements (members and/or references).

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `<import>`*
    `<member`|`reference>`*
`}`
</pre>

An ontology's NAMESPACE is made up of an IRI and a separator character (either `#` or `/`). For example, `http://www.w3.org/2002/07/owl#` is a logical NAMESPACE that consists of IRI `http://www.w3.org/2002/07/owl` and separator character `#`. An ontology's IRI can be any opaque string but is usually specified as a URL in the format `http://<organization>/<path>`. An ontology's ID is a short name that is used as a NAMESPACE prefix (e.g., `owl` is a prefix for `http://www.w3.org/2002/07/owl#`) when referencing an ontology member using the ABBREVIATED_IRI syntax (see section [IRIs](#IRI-LR) below). 

OML supports 4 kinds of concrete ontologies that address different use cases:
- [Vocabulary](#Vocabulary-LR): allows definition of ontological terms and rules for a domain with open-world semantics
- [Vocabulary Bundle](#VocabularyBundle-LR): allows combining vocabularies into a methodology with closed-world semantics
- [Description](#Description-LR): allows definition of systems as instances characterized using some vocabulary
- [Description Bundle](#DescriptionBundle-LR): allows combining descriptions into a dataset that can be reasoned on.

### Import ### {#Import-LR}

An ontology can import zero or more other ontologies, which allows it to cross-reference the imported ontologies' members. This is accomplished by an ontology adding an import statement in its body (before other kinds of statements). An import statement is declared using one of the `<import>` keywords (see [import syntax](#Import-Syntax) for details) followed by the imported ontology's NAMESPACE and optionally its ID.

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `<import>` NAMESPACE (`as` ID)?
}
</pre>
 
Note: An ID is required in the import syntax only when imported members are cross-referenced using the ABBREVIATED_IRI syntax.

Note: An ontology's import closure is defined as all the ontologies that are imported directly or indirectly by the ontology

Note: An ontology whose members are referenced by another ontology needs to be directly imported by it (it is not enough to be indirectly imported).

OML supports several kinds of concret imports for each one of its ontology kinds:
- Vocabulary:[Extension](#VocabularyExtension-LR), [Usage](#VocabularyUsage-LR)
- Vocabulary Bundle: [Extension](#VocabularyBundleExtension-LR), [Inclusion](#VocabularyBundleInclusion-LR)
- Description: [Extension](#DescriptionExtension-LR), [Usage](#DescriptionUsage-LR)
- Description Bundle: [Extension](#DescriptionBundleExtension-LR), [Inclusion](#DescriptionBundleInclusion-LR), [Usage](#DescriptionBundleUsage-LR)

### Member ### {#Member-LR}

An ontology can define zero or more members, which are named elements whose IRIs consist of their ontology's NAMESPACE concatenated to their own (name) IDs. For example, a member whose name ID is `AggregatedElement`, and is defined in an ontology with the IRI `http://imce.jpl.nasa.gov/foundation/base#`, has a member IRI `http://imce.jpl.nasa.gov/foundation/base#AggregatedElement`. 

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `<member>` ID
`}`
</pre>

Members can only be defined by their own ontology but can be referenced by other importing ontologies. Different ontology kinds define different member kinds (see the various ontology sections for details). The syntax for declaring members vary depending on the member kind, but at least consists of one of the `<member>` keywords (see [members](#Member-Syntax) for details) followed by the member's ID that must be unique within the ontology.

OML supports several kinds of concrete members for each of its ontology kinds:

- Vocabulary: [Aspect](#Aspect-LR), [Concept](#Concept-LR), [Relation Entity](#RelationEntity-LR), [Structure](#Structure-LR), [Faceted Scalar](#FacetedScalar-LR), [Enumerated Scalar](#EnumeratedScalar-LR), [Scalar Property](#ScalarProperty-LR), [Structured Property](#StructuredProperty-LR), [Annotation Property](#AnnotationProperty-LR), [Rule](#Rule-LR)
- Description: [Concept Instance](#ConceptInstance-LR), [Relation Instance](#RelationInstance-LR)

### Reference ### {#Reference-LR}

An ontology can have zero or more references, which are constructs that allow adding extra statements about existing members (as opposed to defining new ones). The referenced members may either be local to the ontology or external (i.e., defined by another ontology in its import closure). A syntax of a reference consists of the keyword `ref` followed by the one of the `<member>` keywords and then the member's IRI. The IRI can either be the member ID (when it is local to the ontology only), its FULL_IRI or its ABBREVIATED_IRI. 

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `ref` `<member>` IRI
`}`
</pre>

 An example of an extra statement that can be added on any reference is an [annotation](#Annotation-LR). However, other statement kinds may vary based on the kind of the referenced member. In many cases, those statements are the same kinds that can be added to a member definition. In other cases, they are only a subset of them. Sections on the specific member kinds will outline the statements that can or cannot be added to a reference (refer to the [Reference](#Reference-Syntax) syntax for all the details).

### IRI ### {#IRI-LR}

Ontologies and their members have globally unique IRIs within a given context (an ontology and its import closure). The IRI of an ontology is equivalent to its NAMESPACE minus its separator character (`#` or `/`). For example, an ontology with NAMESPACE *http://imce.jpl.nasa.gov/foundation/base#* has IRI *http://imce.jpl.nasa.gov/foundation/base*. The IRI of an ontology member consists of its ontology's NAMESPACE concatenated to its ID. For example, a member with ID `AggregatedElement` in an ontology with a NAMESPACE *http://imce.jpl.nasa.gov/foundation/base#* has IRI *http://imce.jpl.nasa.gov/foundation/base#AggreagedElement*. This is called the full IRI of a member. Such IRI can be written in an abbreviated syntax using the ontology's namespace prefix. It can also be shortened further to the simple ID of the member when used in the context of its defining ontology. The following is an elaboration of the three possible syntaxes for IRIs.

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

A [literal](#Literal-Syntax) represents a value typed by a [scalar](#FacetedScalar-LR) type (defined by a [vocabulary](#Vocabulary-LR)). OML supports specifying a literal as a quoted literal or as an abbreviated literal (for some specific scalars).

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

The optional scalar IRI is used to specify the scalar that a literal belongs to (*xsd:string* by default). However, the reference can be to any of OML's [standard scalars](#FacetedScalar-LR) only (i.e., not their specializations). It is specified by appending the `^^` characters to the lexical form followed by an IRI to the scalar. Examples of quoted literals with scalar references:

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

An Annotation describes a value for an [annotation property](#AnnotationProperty-LR) (defined by a [vocabulary](#Vocabulary-LR)) in the context of the annotated element (an [ontology](#Ontology-LR), a [member](#Member-LR), a [reference](#Reference-LR), or an [import](#Import-LR)). The general syntax of an annotation consists of a `@` symbol followed by an IRI to the an annotation property then an optional (literal or member reference) value. If the value is missing, it is interpreted as a boolean *true* literal.

<pre class="highlight highlight-html">
`@`[AnnotationProperty|IRI] (Literal | [Member|IRI])?
</pre>

The following example shows several annotations. The ontology itself has a *dc:title* annotation as well as a *dc:date* annotation (notice how the value is a *xsd:date* literal). The first import statement of the ontology has a *rdfs:comment* annotation. Also, the member Member1 has two annotations, both of them are *rdfs:comment* but one has an English (en) literal while the other has a French (fr) literal. Finally, the imported member example2:Member2 is annotation with *viewpoint:show* (notice that there is no literal value, which will be interpreted similar to a Boolean *true* literal).

<pre class="highlight highlight-html">
`@`dc:title "Example1 Ontology"
`@`dc:date "2/15/2021"^^xsd:dateTime
`<ontology>` `<`http://company.com/example1#`>` `as` example1 `{`
    `@`rdfs:comment "This is needed to reference dc annotation properties"
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

A [vocabulary](#Vocabulary-Syntax) is an ontology that defines a set of [terms](#Term-Syntax) and [rules](#Rule-Syntax) for a given domain and has [open world semantics](#Description-Logic-Semantics). A vocabulary is declared with the keyword `vocabulary` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID. It also has a body consisting of zero or more vocabulary imports and statements between two braces `{` `}`, as follows:

<pre class="highlight highlight-html">
Annotation*
`vocabulary` NAMESPACE `as` ID `{`
	VocabularyImport*
	VocabularyStatement*
`}`
</pre>

For example, the following vocabulary allows describing a mission. It has the namespace *http://com.xyz/methodology/mission#* and the prefix *mission*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
`}`
</pre>

### Imports ### {#VocabularyImports-LR}

This section outlines the kind of import statements that can be added to a vocabulary.

#### Extension #### {#VocabularyExtension-LR}

A [vocabulary extension](#VocabularyExtension) is a kind of [import](#Import) statement that can be added to a vocabulary to specify that it extends another vocabulary. This is typically needed when members of the extended vocabulary are cross-reference by the local members of the extending vocabulary.  A vocabulary extension is defined with the keyword `extends` followed by the imported vocabulary's NAMESPACE. If members of the imported vocabulary are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a namespace prefix ID that is unique within the vocabulary's imports.

<pre class="highlight highlight-html">
Annotation*
`extends` NAMESPACE (`as` ID)?
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

A [vocabulary usage](#VocabularyUsage) is a kind of [import](#Import) statement that can be added to a vocabulary to specify that it uses a [description](#Description-LR). This is typically needed when the vocabulary uses one or more of the description's instances in its restriction axioms. A vocabulary usage is defined with the keyword `extends` followed by the imported description's NAMESPACE. If members of the imported description are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a namespace prefix ID that is unique within the vocabulary's imports.

<pre class="highlight highlight-html">
Annotation*
`uses` NAMESPACE (`as` ID)?
</pre>

For example, the *mission* vocabulary *uses* the *organizations* description (in order to cross-reference its instances).

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission1#`>` `as` mission1 `{`
    `extends` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `uses` `<`http://com.xyz/methodology/organizations#`>` `as` organizations
    `concept` Component1 `:> ` Component [
        `restricts` `relation` mission:isResponsibilityOf `to` organization:NASA   // a cross-reference to instance NASA 
    ]
`}`
</pre>

Note: descriptions that are used by a vocabulary typically define notable instances that are cross-referenced by other descriptions using this vocabulary.

### Types ### {#Types-LR}

Types that can be defined in a vocabulary are either *classifiers* (structured types) or *scalars* (primitive types). Some classifiers ([Aspect](#Aspect-LR), [Concept](#Concept-LR) and [Relation Entity]((#RelationEntity-LR))) are *entities*, meaning they can classify named instances (that are unique by reference). Other classifiers ([Structure](#Structure-LR)) can only classify anonymous instances (that are unique by value). Also, some scalars ([Faceted Scalar](#FacetedScalar-LR)) can classify an unlimited set of literals, while other scalars ([Enumerated Scalar](#EnumeratedScalar-LR)) can only classify a limited set of literals.

Classifiers can specialize one or more classifiers (multiple-inheritance), while scalars can only specialize one scalar only (single-inheritance). These specializations are further constrained for each type as discussed below.

#### Aspect #### {#Aspect-LR}

An [aspect](#Concept-Syntax) is an entity defined in a vocabulary and represents a mixin type (or a capability) in a modeled domain. An aspect can only specialize other aspects, but can be specialized by any entity. An Aspect cannot be asserted as a type of instances in a description (there is no aspect instance), but can be inferred (by a DL reasoner) as such, if it is one of the supertypes of an asserted type.

An aspect is declared with the keyword `aspect` followed by the aspect's name ID. It can optionally specialize other aspects by following its name ID by the `:>` symbol then a comma-separated list of those supertypes' IRIs. An aspect can also optionally specify a list of axioms enclosed within a pair of square brackets `[` `]`.

<pre class="highlight highlight-html">
    Annotation*
   `aspect` ID (`:>` [Aspect|IRI] (`,` [Aspect|IRI])*)? (`[`
        Axiom*
    `]`)?
</pre>

The following example vocabulary defines two aspects: *IdentifiedElement* and *NamedElement* where the latter specializes the former (notice how *IdentifiedElement* is referenced by its ID as a supertype, since it is defined locally within the same vocabulary).

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `aspect` IdentifiedElement
    `aspect` NamedElement :> IdentifiedElement
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

A [concept](#Concept-Syntax) is an entity defined in a vocabulary and represents a concrete type in a modeled domain. A concept can specialize other concepts or aspects, but can be specialized by other concepts only. It can also be asserted as a type of a [concept instance](#ConceptInstance-LR). 

A concept is declared with the keyword `concept` followed by the concept's name ID. It can optionally specialize other concepts or aspects by following its name ID by the `:>` symbol then a comma-separated list of those supertypes' IRIs. A concept can also optionally specify a list of axioms enclosed within a pair of square brackets `[` `]`.

<pre class="highlight highlight-html">
    Annotation*
    `concept` ID (`:>` [Concept|Aspect|IRI] (`,` [Concept|Aspect|IRI])*)? (`[`
        Axiom*
    `]`)?
</pre>

The following example vocabulary defines two concepts: *Component* and *Function*, where the former specializes two aspects *IdentifiedElement* and *ContainedElement*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `aspect` IdentifiedElement
    `aspect` ContainedElement
    `concept` Component :> IdentifiedElement, ContainedElement
    `concept` Function
`}`
</pre>

#### Relation Entity #### {#RelationEntity-LR}

 A [Relation Entity](#RelationEntity-LR) is an entity defined in a vocabulary and represents a type of reified relation between two other entities, a source entity and a target entity. A relation entity is defined with the keywords `relation` `entity` followed by a name ID. It can optionally specialize other relation entities or aspects by following its name ID by the `:>` symbol then a comma-separated list of those supertypes' IRIs. A relation entity also has a body, which is a pair of square brackets `[` `]` that specify by IRI the relation's `from` (source) entity and `to` (target) entity, and optionally the names of unreified relations, semantic flags, and/or axioms.
 
<pre class="highlight highlight-html">
    Annotation*
    `relation` `entity` ID (`:>` [RelationEntity|Aspect|IRI] (`,` [RelationEntity|Aspect|IRI])*)? (`[`
        `from` [Entity|IRI]                 // the relation entity's source
        `to` [Entity|IRI]                   // the relation entity's target
        Annotation*
        (`forward` ID)?                     // an unreified relation from source to target
        Annotation*
        (`reverse` ID)?                     // an unreified relation from target to source
        `functional`?                       // each source can be related to a maximum of 1 target
        (`inverse` `functional`)?             // each target can be related to a maximum of 1 source
        `symmetric`?                        // if a source is related to a target, then the target must also related to the source
        `asymmetric`?                       // if a source is related to a target, then the target cannot be related to the source
        `reflexive`?                        // a source must be related to itself
        `irreflexive`?                      // a source cannot be related to itself
        `transitive`?                       // if A is related to B, and B is related to C, then A is related to C
        Axiom*                            // zero or more axioms of the relation entity
   `]`
</pre>

The following example vocabulary defines a relation entity named *Performs* from the concept *Component* to the concept *Function*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `concept` Component
    `concept` Function
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
    `]`
`}`
</pre>

 Since a relation entity is a reified relation, it can be asserted as a type of a [relation instance](#RelationInstance-LR) between one or more source instances, and one or more target instances. Such instance can be annotated and characterized with assertions. However, a relation entity can also optionally specify (in its body) one or two companion unreified relations that can be asserted as simple (uncharacterized) [links](#LinkAssertion-LR) between a source and a target instance. One of those unrefied relations is declared with the keyword `forward`  followed by a name ID, while the other is declared with the keyword `reverse` followed by a name ID. The forward relation has the `from` entity as its domain, and the `to` entity as its range, while the reverse relation has the opposite. When both are declared, the forward and reverse relations become inverse of each other, meaning if one is used to link a source instance to a target instance, the other is inferred as a link from the target to the source. Also, when a relation instance is typed by a relation entity, which has one ore more unreifed relations, such relations are inferred as links between the set of related sources and target instances. The following diagram depicts the design pattern implied by a relation entity.

<pre><img src="images/Relation-Entity-Pattern.svg"/></pre>

The example vocabulary below refines the *Performs* relation entity with two unreifed relations: *performs* (as forward) and *isPerformedBy* (as reverse).

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `concept` Component
    `concept` Function
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
        `forward` performs
        `reverse` isPerformedBy
   `]`
`}`
</pre>

When a relation entity has supertypes, its source entity becomes a subtype of the super relations' source, and its target entity becomes a subtype of the super relation's target. Also, when named, its forward and reverse relations become sub relations of the supertype's forward and reverse relations.

The following example vocabulary defines two relation entities, *Performs* and *Provides*, where the latter specializes the former. In this case, what is infererd is that *Assembly* specializes *Component*, *Power* specializes *Function*, *provides* specializes *performs*, and lastly, *isProvidedBy* specializes *isPerformedBy*. Some of these inferred specializations can also be specified explicitly (e.g., Assembly `:>` Component).

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
    `relation` `entity` Provides :> Performs `[`
        `from` Assembly
        `to` Power
        `forward` provides
        `reverse` isProvidedBy
   `]`
`}`
</pre>

A relation entity can optionally specify one or more semantic flags (within its body) that define its logical semantics:

- The `functional` flag implies that a source instance can be related to a maximum of 1 target instance.
- The `inverse functional` flag implies that a target instance can be related to a maximum of 1 source instance.
- The `symmetric` flag implies that if a source instance is related to a target instance, then the target must also be related to the source.
- The `asymmetric` flag implies that if a source instance is related to a target instance, then the target cannot be related to the source.
- The `reflexive` flag implies that a source instance must be related to itself.
- The `irreflexive` flag implies that a source instance cannot be related to itself.
- The `transitive` flag implies if instance A is related to instance B, and instance B is related to instance C, then A is also related to C.

The example vocabulary below refines the *Performs* relation to add the flag `inverse functional` (to specify that a function can be performed by a maximum of one component), the flag `asymmetric` (to specify that a function cannot perform a component), and the flag `irreflexive` (to specify that a component cannot perform itself).

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `concept` Component
    `concept` Function
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
        `forward` performs
        `reverse` isPerformedBy
        `inverse functional`
        `asymmetric`
        `irreflexive`
   `]`
`}`
</pre>

#### Structure #### {#Structure-LR}

A [structure](#Structure-Syntax) is a classifier defined in a vocabulary and represents a structured datatype with anonymous instances in a modeled domain. A structure can specialize and be specialized by other structures. It can also be asserted as a type of a [structure instance](#StructureInstance-LR), which can be used as a value of a [structured property](#StructuredProperty-LR).

A structure is declared with the keyword `structure` followed by the structure's name ID. It can optionally specialize other structures by following its name ID by the `:>` symbol then a comma-separated list of those supertypes' IRIs. A structure can also optionally specify a list of axioms enclosed within a pair of square brackets `[` `]`.

<pre class="highlight highlight-html">
    Annotation*
    `structure` ID (`:>` [Structure|IRI] (`,` [Structure|IRI])*)? (`[`
        Axiom*
    `]`)?
</pre>

The following example vocabulary defines the structure *Point* whose instances are anonymous points on a grid.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `structure` Point
`}`
</pre>

#### Faceted Scalar #### {#FacetedScalar-LR}

A [scalar](#Scalar-Syntax) is a type defined in a vocabulary and represents a primitive type that classifies an unlimited set of literals. A faceted scalar is declared with the keyword `scalar` followed by the scalar's name ID. It can optionally specialize another faceted scalar as a supertype by following its name ID by the `:>` symbol then the IRI of the supertype. A scalar can also optionally specify a list of facets enclosed within a pair of square brackets `[` `]`.

<pre class="highlight highlight-html">
    Annotation*
	`scalar` ID (`:>` [Scalar|IRI] (`,` [Scalar|IRI])*)? (`[`
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

OML considers a following set of faceted scalars as *standard*:

<pre class="highlight highlight-html">
`vocabulary` `<`http://www.w3.org/2000/01/rdf-schema#`>` `as` rdfs `{`
	// Literals
	`scalar` Literal
`}`

`vocabulary` `<`http://www.w3.org/1999/02/22-rdf-syntax-ns#`>` `as` rdf `{`
	`extends` `<`http://www.w3.org/2000/01/rdf-schema#`>` `as` rdfs

	// Literals
	`scalar` PlainLiteral `:>` rdfs:Literal
	`scalar` XMLLiteral `:>` rdfs:Literal
`}`

`vocabulary` `<`http://www.w3.org/2002/07/owl#`>` `as` owl `{`
	`extends` `<`http://www.w3.org/2000/01/rdf-schema#`>` `as` rdfs

	// Literals
	`scalar` real `:>` rdfs:Literal
	`scalar` rational `:>` real
`}`

`vocabulary` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd `{`
	`extends` `<`http://www.w3.org/2000/01/rdf-schema#`>` `as` rdfs
	`extends` `<`http://www.w3.org/2002/07/owl#`>` `as` owl

	// Decimal Numbers and Integers
	`scalar` decimal `:>` owl:Rational
	`scalar` integer `:>` decimal
	`scalar` long `:>` integer
	`scalar` int `:>` long
	`scalar` short `:>` int
	`scalar` byte `:>` short
	`scalar` nonNegativeInteger `:>` integer
	`scalar` positiveInteger `:>` nonNegativeInteger
	`scalar` unsignedLong `:>` nonNegativeInteger
	`scalar` unsignedInt `:>` unsignedLong
	`scalar` unsignedShort `:>` unsignedInt
	`scalar` unsignedByte `:>` unsignedShort
	`scalar` nonPositiveInteger `:>` integer
	`scalar` negativeInteger `:>` nonPositiveInteger
	
	// Floating-Point Numbers
	`scalar` double `:>` rdfs:Literal
	`scalar` float `:>` rdfs:Literal
	
	// Strings
	`scalar` string `:>` rdfs:Literal
	`scalar` normalizedString `:>` string
	`scalar` token `:>` normalizedString
	`scalar` ^language `:>` token
	`scalar` Name `:>` token
	`scalar` NCName `:>` Name
	`scalar` NMTOKEN `:>` token

	// Boolean
	`scalar` boolean `:>` rdfs:Literal

	// Binary Data
	`scalar` hexBinary `:>` rdfs:Literal
	`scalar` base64Binary `:>` rdfs:Literal
	
	// IRI
	`scalar` anyURI `:>` rdfs:Literal
	
	// Time Instants
	`scalar` dateTime `:>` rdfs:Literal
	`scalar` dateTimeStamp `:>` dateTime
`}`
</pre>

Note: the lexical and value spaces for these standard scalars are described in the ([xsd](https://www.w3.org/TR/2012/REC-xmlschema11-2-20120405/#built-in-datatypes), and [owl](https://www.w3.org/TR/owl2-syntax/#Datatype_Maps)) standards.

Furthermore, other faceted scalars can be defined only as specializations of the standard ones (maximum one supertype per scalar is allowed). They can also be optionally restricted with one or more facets. A facet is a restriction on the lexical or value space of a standard scalar. The following facets are supported:

- Facet `length` specifies the exact length of the lexical representation (of strings and literals)
- Facet `minLength` specifies the minimum length of the lexical representation (of strings and literals)
- Facet `maxLength` specifies the maximum length of the lexical representation (of strings and literals)
- Facet `pattern` specifies a regular expression of the lexical representation (of strings and literals)
- Facet `language` specifies a natural language for the lexical representation (of strings and literals)
- Facet `minInclusive` specifies the minimum inclusive value (of numbers)
- Facet `minExclusive` specifies the minimum exclusive value (of numbers)
- Facet `maxInclusive` specifies the maximum inclusive value (of numbers)
- Facet `maxExclusive` specifies the maximum exclusive value (of numbers)

The following example vocabulary defines two faceted scalars: *SSN* (representing strings with the social security number pattern) and *TeenAge* (representing positive integers from 13 and 19 inclusive).

<pre class="highlight highlight-html">
`vocabulary` `<`http://example.com/primitive-types#`>` `as` primitives `{`
	`extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
	`scalar` SSN `:>` xsd:string `[`
		`pattern` "^\d{3}-?\d{2}-?\d{4}$"
	`]`
	`scalar` TeenAge `:>` xsd:positiveInteger `[`
		`minInclusive` 13
		`maxInclusive` 19
	`]`
`}`
</pre>

#### Enumerated Scalar #### {#EnumeratedScalar-LR}

An [enumerated scalar](#EnumeratedScalar-Syntax) is a type defined in a vocabulary and represents a primitive type that classifies a limited set of literals. An enumerated scalar is declared with the keywords `enumerated scalar` followed by the scalar's name ID. It can also optionally specialize another enumerated scalar as a supertype by following its name ID by the `:>` symbol then the IRI of the supertype. It can also optionally specify a list of one or more comma-separated literals enclosed within a pair of square brackets `[` `]`. Those literals represent the limited set that is classified by the scalar. Although both are optional, an enumerated scalar cannot specify a set of literals and a supertype at the same time. if a supertype is specified, the subtype is considered simply as an alias of the supertype and inherits its set of literals.

<pre class="highlight highlight-html">
    Annotation*
    `enumerated` `scalar` ID (`:>` [EnumeratedScalar|IRI] (`,` [EnumeratedScalar|IRI])*)? (`[`
        (Literal (`,` Literal)*)?
    `]`)?
</pre>

The following example vocabulary defines an enumerated scalar *RGB* that enumerates three string literals for the colors: *Red*, *Green*, and *Blue*.

<pre class="highlight highlight-html">
	`enumerated` `scalar` RGB `[`
        "Red",
        "Green",
        "Blue"
	`]`
</pre>

### Properties ### {#Properties-LR}

Properties that can be defined in a vocabulary include *semantic properties* and *annotation properties*. A semantic property ([Scalar Property](#ScalarProperty-LR) or [Structured Property](#StructuredProperty-LR)) has logical semantics and is specified with a domain and a range. The domain represents a classifier whose instances can be characterized by such property, while the range represents a type that classifies a set of allowed characterization values. An [Annotation Property](#AnnotationProperty-LR), on the other hand, has no logical semantics and enables the annotation of an element (ontology, import, or member) with non-semantic information.

#### Scalar Property #### {#ScalarProperty-LR}

A [scalar property](#ScalarProperty-Syntax) is a semantic property defined in a vocabulary, whose domain is a classifier ([Aspect](#Aspect-LR), [Concept](#Concept-LR), [Relation Entity](#RelationEntity-LR), or [Structure](#Structure-LR)) and whose range is a scalar ([Faceted Scalar](#FacetedScalar-LR) or [Enumerated Scalar](#EnumeratedScalar-LR)). This means the values of a scalar property are literals of that scalar range. A scalar property is defined with the keywords `scalar` `property` followed by a name ID. It can also optionally specialize other scalar properties by following its name ID by the `:>` symbol then a comma-separated list of those super properties' IRIs. It also has a pair of square brackets `[` `]` that contain the property's `domain` (referencing a classifier), `range` (referencing a scalar), and optionally a semantic flag (`functional`) that specifies whether instances of the domain can have a single value maximum for this property.

<pre class="highlight highlight-html">
	Annotation*
	`scalar` `property` ID (`:>` [ScalarProperty|IRI] (`,` [ScalarProperty|IRI])*)? (`[`
		`domain` [Classifier|IRI]
		`range` [Scalar|IRI]
		`functional`?                // each instance can have a maximum of 1 value for this property
	`]`)?
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

A [structured property](#StructuredProperty-Syntax) is a semantic property defined in a vocabulary, whose domain is a classifier ([Aspect](#Aspect-LR), [Concept](#Concept-LR), [Relation Entity](#RelationEntity-LR), or [Structure](#Structure-LR)) and whose range is a [Structure](#Structure-LR). This means the values of a structured property are anonymous [Structure Instances](#StructureInstance-LR). A structured property is defined with the keywords `structured` `property` followed by a name ID. It can also optionally specialize other structured properties by following its name ID by the `:>` symbol then a comma-separated list of those super properties' IRIs. It also has a pair of square brackets `[` `]` that contain the property's `domain` (referencing a classifier), `range` (referencing a structure), and optionally a semantic flag (`functional`) that specifies whether instances of the domain can have a single value maximum for this property.

<pre class="highlight highlight-html">
	Annotation*
	`structure` `property` ID (`:>` [StructuredProperty|IRI] (`,` [StructuredProperty|IRI])*)? (`[`
		`domain` [Classifier|IRI]
		`range` [Structure|IRI]
		`functional`?                // each instance can have a maximum of 1 value for this property
	`]`)?
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


#### Annotation Property #### {#AnnotationProperty-LR}

An [annotation property](#AnnotationProperty-Syntax) is a property defined in a vocabulary, whose domain is implicitly any annotated element (ontology, import, or member) and whose range is implicitly any literal. An annotation property is defined with the keywords `annotation` `property` followed by a name ID. It can also optionally specialize other annotation properties by following its name ID by the `:>` symbol then a comma-separated list of those super properties' IRIs. 

<pre class="highlight highlight-html">
	Annotation*
	`annotation` `property` ID (`:>` [AnnotationProperty|IRI] (`,` [AnnotationProperty|IRI])*)?
</pre>

An annotation property is a non-semantic property, meaning that it has no logical semantics and thus is ignored by a logical reasoner. However, it allows specifying annotations on elements like ontologies, their imports, and their members.

The following example shows two vocabularies: *viewpoint* and *mission*. The former defines an annotation property *visualizeAs*, and the latter defines two concept *Component* and *Function*, and annotates them using the *visualizeAs* annotation.

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
`vocabulary` `<`http://www.w3.org/1999/02/22-rdf-syntax-ns#`>` `as` rdf `{`
    `annotation` `property` about
`}`

`vocabulary` `<`http://www.w3.org/2000/01/rdf-schema#`>` `as` rdfs `{`
    `annotation` `property` comment
    `annotation` `property` isDefinedBy
    `annotation` `property` label
    `annotation` `property` seeAlso
`}`

`vocabulary` `<`http://www.w3.org/2002/07/owl#`>` `as` owl `{`
    `annotation` `property` backwardCompatibleWith
    `annotation` `property` deprecated
    `annotation` `property` incompatibleWith
    `annotation` `property` priorVersion
    `annotation` `property` versionInfo
`}`

`vocabulary` `<`http://purl.org/dc/elements/1.1/`>` `as` dc `{`
    `annotation` `property` contributor
    `annotation` `property` coverage
    `annotation` `property` creator
    `annotation` `property` date
    `annotation` `property` ^description
    `annotation` `property` format
    `annotation` `property` identifier
    `annotation` `property` ^language
    `annotation` `property` publisher
    `annotation` `property` ^relation
    `annotation` `property` rights
    `annotation` `property` ^source
    `annotation` `property` subject
    `annotation` `property` title
    `annotation` `property` type
    `annotation` `property` hasVersion
`}`
</pre>

### Axioms ### {#Axioms-LR}

Axioms are statements about terms in a vocabulary that enrich their logical semantics. They appear in the body of a term between its two brackets `[` `]`. This section describes the supported axioms, which include a [key axiom](#KeyAxiom-LR) (specified on entities) and a [restriction axioms](#RestrictionAxioms-LR) (specified on classifiers). 

Note: that a term that has supertypes semantically inherits axioms defined on its supertypes in addition to its own axioms.

#### Key Axiom #### {#KeyAxiom-LR}

A [key axiom](#KeyAxiom-Syntax) is an axiom defined on an entity ([Aspect](#Aspect-LR), [Concept](#Concept-LR), and [Relation Entity](#RelationEntity-LR)) that specifies a set of properties that together represent a unique key (id) for the entity. This means if two named instances have the same values of those properties, then they can be inferred to be aliases of the same instance. The syntax of a key axiom starts with the keyword `key` followed by one or more comma-separated properties specified by their IRIs.

<pre class="highlight highlight-html">
`key` [Feature|IRI] (`,` [Feature|IRI])*
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

#### Restriction Axioms #### {#RestrictionAxioms-LR}

A [restriction axiom](#RestrictionAxiom-Syntax) is an axiom defined on a classifier ([Aspect](#Aspect-LR), [Concept](#Concept-LR), [Relation Entity](#RelationEntity-LR) and [Structure](#Structure-LR)) that restricts a feature (a property or a relation) in some way in the classifier's context. This feature can be a property ([Scalar Property](#ScalarProperty-LR) or [Structured Property](#StructuredProperty-LR)) whose domain is the context classifier or one of its supertypes, or a relation ([Forward Relation](#RelationEntity-LR) or [Reverse Relation](#RelationEntity-LR)) whose source is the context entity or one of its supertypes. The facets that can be restricted about those features vary (like their range, cardinality, or value) resulting in different subtypes of restriction axioms.

<u>Range Restriction Axioms</u>

A range restriction axiom restricts the range of a feature in the context of some classifier. The axiom specifies a restricted range that is a subtype of the feature's original range. The syntax of a range restriction axioms starts with the keyword `restricts` followed by a restriction kind, which can either be `all` (requiring all values to conform to the restricted range) or `some` (requiring at least one value to conform to the restricted range). This is followed by the kind of feature (`scalar property`, `structured property`, or `relation`) then a reference to the feature by IRI. Finally, the keyword `to` is used followed by a reference to the restricted range (a scalar, a structure, or an entity) by IRI. The following shows the three supported syntaxes:

<pre class="highlight highlight-html">
	`restricts` [ `all` | `some` ] `scalar` `property` [ScalarProperty|IRI] `to` [Scalar|IRI]
	`restricts` [ `all` | `some` ] `structured` `property` [StructuredProperty|IRI] `to` [Structure|IRI]
	`restricts` [ `all` | `some` ] `relation` [Relation|IRI] `to` [Entity|IRI]
</pre>

The following example shows a vocabulary that defines a concept *Assembly* with some range restrictions.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component
    `concept` Function
    `concept` Assembly :> Component [
        `restricts` `all` `scalar` `property` hasId `to` ten-chars          // the hasId value must be 10-char strings
        `restricts` `some` `structured` `property` hasPin `to` InputPin     // there must be at least one input pin
        `restricts` `all` `relation` performs `to` Power                  // power is the only performed function 
    ]
    `concept` Power :> Function
    `scalar` ten-chars :> xsd:string `[`
        `length` 10
    `]`
    `structure` Pin
    `structure` InputPin :> Pin
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

<u>Cardinality Restriction Axioms</u>

A cardinality restriction axiom restricts the cardinality of a feature in the context of some classifier. The axiom specifies a minimum, a maximum, or an exact number of values, conforming to the original range, or to a specified restricted range, that a feature can have in that context. The syntax of a cardinality restriction axioms starts with the keyword `restricts` followed by the kind of feature (`scalar property`, `structured property`, or `relation`) then a reference to the feature by IRI. Then, the keyword `to` is used followed by a cardinality kind (`min`, `max`, or `exactly`), a cardinality value (positive integer), and finally an optional reference to a restricted range (a scalar, a structure, or an entity) by IRI. The following shows the three supported syntaxes:

<pre class="highlight highlight-html">
	`restricts` `scalar` `property` [ScalarProperty|IRI] `to` [ `max` | `min` | `exactly` ] UnsignedInteger [Scalar|IRI]?
	`restricts` `structured` `property` [StructuredProperty|IRI] `to` [ `max` | `min` | `exactly` ] UnsignedInteger [Structure|IRI]?
	`restricts` `relation` [Relation|IRI] `to` [ `max` | `min` | `exactly` ] UnsignedInteger [Entity|IRI]?
</pre>

The following example shows a vocabulary that defines a concept *Assembly* with some cardinality restrictions.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component
    `concept` Function
    `concept` Assembly :> Component [
        `restricts` `scalar` `property` hasId `to` exactly 1              // hasId must have a single value only
        `restricts` `structured` `property` hasPin `to` max 2 InputPin    // there must be at most two input pins
        `restricts` `relation` performs `to` min 5                      // a minimum of 5 functions must be performed
    ]
    `structure` Pin
    `structure` InputPin :> Pin
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

<u>Value Restriction Axioms</u>

A value restriction axiom restricts the value of a feature in the context of some classifier. In the case of a relation, the restricted value represents the relation's target instance. The syntax of a value restriction axioms starts with the keyword `restricts` followed by the kind of feature (`scalar property`, `structured property`, or `relation`) then a reference to the feature by IRI. Then, the keyword `to` is used followed by a value that is suitable for each case (a [literal](#Literal-Syntax) for a scalar property, a [structure instance](#StructureInstance-Syntax) for a structured property, or a reference to a [named instance](#NamedInstance-Syntax) by IRI for a relation). The following shows the three supported syntaxes:

<pre class="highlight highlight-html">
	`restricts` `scalar` `property` [ScalarProperty|IRI] `to` Literal
	`restricts` `structured` `property` [StructuredProperty|IRI] `to` StructureInstance
	`restricts` `relation` [Relation|IRI] `to` [NamedInstance|IRI]
</pre>

The following example shows a vocabulary that defines a concept *Assembly* with some value restrictions.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `uses` `<`http://com.xyz/methodology/functions#`>` `as` functions
    `concept` Component
    `concept` Function
    `concept` Assembly :> Component [
        `restricts` `scalar` `property` hasId `to` "ABC"                          // hasId must have a value of "ABC"
        `restricts` `structured` `property` hasPin `to` Pin `[` hasNumber 1 `]`   // hasPin must have a Pin with hasNumber of 1
        `restricts` `relation` performs `to` functions:F1                         // the performed function must be functions:F1
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

### Rule ### {#Rule-LR}

A [rule](#Rule-Syntax) is a member of a vocabulary and represents an additional inference rule in the domain that can be used by a reasoner to generate entailments. A rule has two sets of predicates (patterns that must hold); the first set is called the rule's antecedent (predicates to match for the rule to trigger), and the second set is called the rule's consequent (predicates that are inferred once the antecedent is matched). The syntax of a rule starts with the keyword `rule` followed by a name ID, then a pair of square brackets `[` `]` that holds the rule's predicates. The antecedent predicates are specified first separated by the `^` symbol (which means a logical AND), followed by an implication arrow `->`, then the consequent predicates separated also by the `^` symbol.

<pre class="highlight highlight-html">
	Annotation*
	`rule` ID `[`
		Predicate (`^` Predicate)* `->` Predicate (`^` Predicate)*
	`]`
</pre>

A predicate represents a pattern in the model that can be matched or inferred, depending on whether it appears in a rule's antecedent or consequent, respectively. The set of supported predicates are the following:

- [Type Predicate](#TypePredicate-Syntax)

     Matches an instance of a given type (specified by its IRI) and binds it to variable ID.
    <pre class="highlight highlight-html">
    [Type|IRI] `(` ID `)`
    </pre>

- [Relation Entity Predicate](#RelationEntityPredicate-Syntax)

    Matches a instance of a given relation entity (specified by its IRI) and binds it to variable ID0, its source to variable ID1, and its target 
    to either variable ID2 or to a specific instance.
     <pre class="highlight highlight-html">
    [RelationEntity|IRI] `(` ID1 `,` ID0 `,` (ID2 | [NamedInstance|IRI]) `)`
    </pre>

- [Feature Predicate](#FeaturePredicate-Syntax)

    Matches an assertion of a given feature (specified by its IRI) and binds its subject to variable ID1 and its object to variable ID2 or to a specific 
    instance or literal.
    <pre class="highlight highlight-html">
    [Feature|IRI] `(` ID1 `,` (ID2 | [NamedInstance|IRI] | Literal) `)`
    </pre>

- [Same As Predicate](#SameAsPredicate-Syntax)

    Matches when the value bound to variable ID1 is the same as the value bound to variable ID2 or a specific instance.
    <pre class="highlight highlight-html">
    `sameAs` `(` ID1 `,` (ID2 | [NamedInstance|IRI]) `)`
    </pre>

- [Different From Predicate](#DifferentFromPredicate-Syntax)

    Matches when the value bound to variable ID1 is different from the value bound to variable ID2 or a specific instance.
    <pre class="highlight highlight-html">
    `differentFrom` `(` ID1 `,` (ID2 | [NamedInstance|IRI]) `)`
    </pre>

The following example vocabulary shows a couple of rules, *R1* and *R2*:

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component
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
        Component `(` c `)` `^` performs `(` c, f1 `)` `^` invokes `(` f1, f2 `)` `->` performs `(` c, f2 `)`
   `]`
    // if a component has a different id from another component, then they must be different components
   `rule` R2 `[`
        hasId `(` c1, i1 `)` `^` hasId `(` c2, i2 `)` `^` `differentFrom` `(` i1, i2 `)` `->` `differentFrom` `(` c1, c2 `)`
   `]`
`}`
</pre>

## Description ## {#Description-LR}

A [description](#Description-Syntax) is an ontology that uses vocabularies to describe [named instances](#NamedInstance-Syntax) in a given domain. A description is declared with the keywords `description` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID. It also has a body consisting of zero or more description imports and statements between two braces `{` `}`, as follows:

<pre class="highlight highlight-html">
Annotation*
`description` NAMESPACE `as` ID `{`
	DescriptionImport*
	DescriptionStatement*
`}`
</pre>

The following example description is meant to describe the components of a system. It has the namespace *http://com.xyz/system/components#* and the prefix *components*.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
`}`
</pre>

### Imports ### {#DescriptionImports-LR}

This section outlines the kind of import statements that can be added in a description's body.

#### Usage #### {#DescriptionUsage-LR}

A [description usage](#DescriptionUsage) is a kind of [import](#Import) statement that can be added to a description to specify a vocabulary that it uses. This is typically needed in order to use the terms (types and properties) of the vocabulary in the description's instance definitions. A description usage is defined with the keyword `uses` followed by the imported vocabulary's NAMESPACE. If members of the imported vocabulary are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID within the description's imports.

<pre class="highlight highlight-html">
Annotation*
`uses` NAMESPACE (`as` ID)?
</pre>

In the following example description, the *mission* vocabulary is used to describe components of a system.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission

    `ci` System1 `:` mission:Component     // a cross-reference to concept Component
`}`
</pre>

#### Extension #### {#DescriptionExtension-LR}

A [description extension](#DescriptionExtension) is a kind of [import](#Import) statement that can be added to a description to specify that it extends another description. This can be used to split a system description into fragments that focus on different concerns or are contributed by different authorities. In this case, a description may extend other descriptions that it depends on. A description extension is defined with the keyword `extends` followed by the imported description's NAMESPACE. If members of the imported description are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID within the description's imports.

<pre class="highlight highlight-html">
Annotation*
`extends` NAMESPACE (`as` ID)?
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

### Instances ### {#Instances-LR}

Instances represent objects or data in a given system. They are described using terms (types and properties) from some vocabulary. Specifically, they can be given types and have assertions on features in the domain of those types. Instances can either be named ([Concept Instance](#ConceptInstance-LR) and [Relation Instance](#RelationInstance-LR)), in which case they are specified as members of some description, or they can be anonymous ([Structure Instance](#StructureInstance-LR)), in which case they defined as values of features (e.g., [structured properties](#StructuredProperty-LR)) in the context of other (named or anonymous) instances.

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

A [structure instance](#StructureInstance-Syntax) is an anonymous instance that can be defined as a value of a structured property. Such value can either be specified in a [structured property value assertion](#StructuredPropertyValueAssertion-LR), defined in the context of some instance, or in a [value restriction axiom](#RestrictionAxioms-LR) on some structured property in the context of some classifier. A structure instance is declared with the IRI of a structure followed by a pair of square brackets `[` `]` that holds assertions about the instance.

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
        `restricts` `structured` `property` hasPin `to` Pin `[` hasNumber 1 `]`   // structure instance used as restricted value
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

Assertions are statements about instances that enable characterizing them. They appear in the body of an instance (either named or anonymous) between its two brackets `[` `]`. This section describes the supported assertions, which include a [scalar property value assertion](#ScalarPropertyValueAssertion-LR) (specified on instances), [structured property value assertion](#StructuredPropertyValueAssertion-LR) (specified on instances), and a [link assertion](#LinkAssertion-LR) (specified on named instances).

#### Scalar Property Value Assertion #### {#ScalarPropertyValueAssertion-LR}

A value for a scalar property can be [asserted](#ScalarPropertyValueAssertion-Syntax) on an instance ([Concept Instance](#ConceptInstance-LR), [Relation Instance](#RelationInstance-LR), or [Structure Instance](#StructureInstance-LR)). Such assertion can be added as one of the assertions between the square  brackets `[` `]` of the instance. Its syntax consists of an IRI to a [scalar property](#ScalarProperty-Syntax) from some vocabulary followed by a literal.

<pre class="highlight highlight-html">
[ScalarProperty|IRI] Literal
</pre>

The following example description defines two concept instances that each makes a number of scalar property assertions. Specifically, instance *component1* asserts that its *mission:hasId* property has a string value of *C1*, while instance *function1* asserts that its *mission:hasName* property has a string value of *F1* and its *mission:isAbstract* property has a Boolean value of *true*. 

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `ci` component1 `:` mission:Component `[`
        mission:hasId 'C1'        // property value assertion
    `]`
    `ci` function1 `:` mission:Function `[`
        mission:hasName 'F1'      // property value assertion
        mission:isAbstract true   // property value assertion
    `]`
`}`
</pre>

#### Structured Property Value Assertion #### {#StructuredPropertyValueAssertion-LR}

A value for a structured property can be [asserted](#StructuredPropertyValueAssertion-Syntax) on an instance ([Concept Instance](#ConceptInstance-LR), [Relation Instance](#RelationInstance-LR), or [Structure Instance](#StructureInstance-LR)). Such assertion can be added as one of the assertions between the square  brackets `[` `]` of the instance. Its syntax consists of an IRI to a [structured property](#ScalarProperty-Syntax) from some vocabulary followed by a [structure instance](#StructureInstance-LR).

<pre class="highlight highlight-html">
[StructuredProperty|IRI] StuctureInstance
</pre>

The following example description defines a concept instance *C1* which asserts a value for structured property *mission:hasPin* to have a structure instance whose *mission:hasNumber* property value is asserted to be 2.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/methodology/functions#`>` `as` functions `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `ci` C1 `:` mission:Component `[`
        mission:hasPin Pin `[` mission:hasNumber 2 `]`       // structure instance used in value assertion
    `]`
`}`
</pre>

#### Link Assertion #### {#LinkAssertion-LR}

A named instance can be [asserted](#LinkAssertion-Syntax) as a target of a link typed by an unreified relation ([Forward Relation](#RelationEntity-LR) or [Reverse Relation](#RelationEntity-LR)) on a named instance representing the link's source.  A link is a light-weight alternative to a [relation instance](#RelationInstance-LR) in the sense that it relates two named instances but does not define a new instance for the relation itself. Therefore, unlike a relation instance, a link cannot be characterized by assertions. Also, unlike a relation instance, which can relate one or more sources or one or more targets, a link can only relate a single source to a single target. A link assertion can be added between the square brackets `[` `]` of a named instance (the source). Its syntax consists of an IRI to a [relation](#Relation-Syntax) followed by an IRI of a [named instance](#NamedInstance-Syntax) (the target).

<pre class="highlight highlight-html">
[Relation|IRI] [NamedInstance|IRI]
</pre>

The following example description defines two concept instances with a link asserted between them. Specifically, instance *component1* asserts a link of type *mission:performs* (the forward relation of relation entity *mission:Performs*) to instance *function1*.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `ci` component1 `:` mission:Component `[`
        mission:hasId 'C1'
        mission:performs function1    // link assertion
    `]`
    `ci` function1 `:` mission:Function `[`
        mission:hasName 'F1'
        mission:isAbstract true
    `]`
`}`
</pre>

## Vocabulary Bundle ## {#VocabularyBundle-LR}

A [vocabulary bundle](#VocabularyBundle-Syntax) is an ontology that bundles a set of vocabularies and allows description logic (DL) reasoning with [closed-world semantics](#Description-Logic-Semantics) using them (in contrast to a vocabulary that has [open-world semantics](#Description-Logic-Semantics)). A vocabulary bundle is declared with the keywords `vocabulary` `bundle` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID. It also has a body consisting of zero or more vocabulary bundle imports between two braces `{` `}`, as follows:

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

#### Inclusion #### {#VocabularyBundleInclusion-LR}

An [vocabulary bundle inclusion](#VocabularyBundleInclusion) is a kind of [import](#Import) statement that can be added to a vocabulary bundle to specify that it includes a vocabulary. A vocabulary bundle inclusion is defined with the keyword `includes` followed by the imported vocabulary's NAMESPACE. If members of the imported vocabulary are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID in the bundle's imports.

<pre class="highlight highlight-html">
Annotation*
`includes` NAMESPACE (`as` ID)?
</pre>

For example, the *foundation* vocabulary bundle *includes* two vocabularies: *mission* and *project*.

<pre class="highlight highlight-html">
`vocabulary` `bundle` `<`http://com.xyz/methodology/foundation#`>` `as` foundation `{`
    `includes` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `includes` `<`http://com.xyz/methodology/project#`>` `as` project
`}`
</pre>

#### Extends #### {#VocabularyBundleExtension-LR}

An [vocabulary bundle extends](#VocabularyBundleExtension) is a kind of [import](#Import) statement that can be added to a vocabulary bundle to specify that it extends another vocabulary bundle. This can be used to organize vocabulary bundles in layers that build on each other. Each bundle inherits the vocabularies contributed by its extended bundles and may optionally add to them other included vocabularies. This can, for example, be used to define a family of related vocabulary bundles that build on each other by tackling different incremental concerns. A vocabulary bundle extension is defined with the keyword `extends` followed by the imported vocabulary bundle's NAMESPACE.

<pre class="highlight highlight-html">
Annotation*
`extends` NAMESPACE
</pre>

For example, the *cyber-physical* vocabulary bundle *extends* the *foundation* vocabulary bundle (which includes the *mission* vocabulary) to include two other vocabularies: *electrical* and *mechanical*, which are two disciplines used when describing cyber-physical systems.

<pre class="highlight highlight-html">
`vocabulary` `bundle` `<`http://com.xyz/methodology/cyber-physical#`>` `as` cyber-physical `{`
    `extends` `<`http://com.xyz/methodology/foundation#`>`
    `includes` `<`http://com.xyz/methodology/electrical#`>`
    `includes` `<`http://com.xyz/methodology/mechanical#`>`
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

#### Inclusion #### {#DescriptionBundleInclusion-LR}

A [description bundle inclusion](#DescriptionBundleInclusion) is a kind of [import](#Import) statement that can be added to a description bundle to specify that it includes a description. A description bundle inclusion is defined with the keyword `includes` followed by the imported description's NAMESPACE. If members of the imported description are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID in the bundle's imports.

<pre class="highlight highlight-html">
Annotation*
`includes` NAMESPACE (`as` ID)?
</pre>

For example, the *mission1* description bundle *includes* two descriptions: *components* and *masses*.

<pre class="highlight highlight-html">
`description` `bundle` `<`http://com.xyz/missions/mission1#`>` `as` mission1 `{`
    `includes` `<`http://com.xyz/system/components#`>` `as` components
    `includes` `<`http://com.xyz/system/masses#`>` `as` masses
`}`
</pre>

#### Usage #### {#DescriptionBundleUsage-LR}

A [description bundle usage](#DescriptionBundleUsage) is a kind of [import](#Import) statement that can be added to a description bundle to specify that it uses a vocabulary bundle. This is typically done to specify the closed-world vocabulary bundle that this description bundle will be reasoned on with. A description bundle usage is defined with the keyword `uses` followed by the imported vocabulary bundle's NAMESPACE.

<pre class="highlight highlight-html">
Annotation*
`uses` NAMESPACE
</pre>

For example, the *mission1* description bundle *uses* the *foundation* vocabulary bundle.

<pre class="highlight highlight-html">
`description` `bundle` `<`http://com.xyz/missions/mission1#`>` `as` mission1 `{`
    `includes` `<`http://com.xyz/system/components#`>` `as` components
    `includes` `<`http://com.xyz/system/masses#`>` `as` masses
    `uses` `<`http://com.xyz/methodology/foundation#`>`
`}`
</pre>

#### Extension #### {#DescriptionBundleExtension-LR}

An [description bundle extension](#DescriptionBundleExtension) is a kind of [import](#Import) statement that can be added to a description bundle to specify that it extends another description bundle. This can be used to organize description bundles into layers that build on each other. Each bundle inherits the descriptions contributed by its extended bundles and optionally adds to them other descriptions. This can, for example, be used to define alternative datasets (e.g., representing alternative system designs) that extend a common dataset. A description bundle extension is defined with the keyword `extends` followed by the imported description bundle's NAMESPACE.

<pre class="highlight highlight-html">
Annotation*
`extends` NAMESPACE
</pre>

For example, the *design1* description bundle *extends* the *mission1* description bundle and includes two additional descriptions: *electrical1* and *mechanical1*, which specify the details of this design variant.

<pre class="highlight highlight-html">
`description` `bundle` `<`http://com.xyz/missions/mission1/design1#`>` `as` design1 `{`
    `extends` `<`http://com.xyz/missions/mission1#`>`
    `includes` `<`http://com.xyz/missions/mission1/electrical1#`>`
    `includes` `<`http://com.xyz/missions/mission1/mechanical#`>`
`}`
</pre>
