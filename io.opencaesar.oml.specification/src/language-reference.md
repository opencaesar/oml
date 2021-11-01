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

### Import ### {#Import-LR}

An ontology can import zero or more other ontologies, which allows it to cross-reference the imported ontologies' members. This is accomplished by an ontology adding an import statement in its body (before other kinds of statements). An import statement is declared using one of the `<import>` keywords (see [import syntax](#Import-Syntax) for details) followed by the imported ontology's NAMESPACE and optionally its ID.

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `<import>` NAMESPACE (`as` ID)?
}
</pre>
 
Note: An imported ontology's ID is only required in the import syntax when its members are cross-referenced using an ABBREVIATED_IRI syntax.

Note: An ontology's import closure is defined as all the ontologies that are imported directly or indirectly by an ontology

Note: An ontology whose members are referenced by another ontology needs to be directly imported (it is not enough to be indirectly imported).

### Member ### {#Member-LR}

An ontology can define zero or more members, which are named elements whose IRIs consist of their ontology's NAMESPACE concatenated to their own (name) IDs. For example, a member whose name ID is `AggregatedElement`, and is defined in an ontology with the IRI `http://imce.jpl.nasa.gov/foundation/base#`, has a member IRI `http://imce.jpl.nasa.gov/foundation/base#AggregatedElement`. 

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
    `<member>` ID
`}`
</pre>

Members can only be defined by their own ontology but can be referenced by other importing ontologies. Different ontology kinds define different member kinds (see the various ontology sections for details). The syntax for declaring members vary depending on the member kind, but at least consists of one of the `<member>` keywords (see [members](#Member-Syntax) for details) followed by the member's ID that must be unique within the ontology.

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

A [literal](#Literal-Syntax) represents a value typed by a [scalar](#Faceted-Scalar-LR) type (defined by a [vocabulary](#Vocabulary-LR)). OML supports specifying a literal as a quoted literal or as an abbreviated literal (for some specific scalars).

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

The optional scalar IRI is used to specify the scalar that a literal belongs to (*xsd:string* by default). However, the reference can be to any of OML's [standard scalars](#Faceted-Scalar-LR) only (i.e., not their specializations). It is specified by appending the `^^` characters to the lexical form followed by an IRI to the scalar. Examples of quoted literals with scalar references:

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

An Annotation describes a value for an [annotation property](#AnnotationProperty-LR) (defined by a [vocabulary](#Vocabulary-LR)) in the context of the annotated element (an [ontology](#Ontology-LR), a [member](#Member-LR), a [reference](#Reference-LR), or an [import](#Import-LR)). The general syntax of an annotation consists of a `@` symbol followed by an IRI to the an annotation property then an optional literal (value). If the value literal is missing, it is interpreted as a Boolean *true* literal.

<pre class="highlight highlight-html">
`@`[AnnotationProperty|IRI] Literal?
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
    `<member>` Member1
    `@`viewpoint:show  // a missing literal is interpreted as Boolean true literal
    `ref` `<member>` example2:Member2
`}`
</pre>

## Vocabulary ## {#Vocabulary-LR}

A [vocabulary](#Vocabulary-Syntax) is an ontology that defines a set of [terms](#Term-Syntax) and [rules](#Rule-Syntax) for a given domain and has [open world semantics](#Description-Logic-Semantics). A vocabulary is declared with the keyword `vocabulary` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID, as follows:

<pre class="highlight highlight-html">
`vocabulary` NAMESPACE `as` ID `{`
`}`
</pre>

For example, the following vocabulary allows describing a mission. It has the namespace *http://com.xyz/methodology/mission#* and the prefix *mission*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
`}`
</pre>

### Import ### {#Vocabulary-Import-LR}

This section outlines the kind of import statements that can be added to a vocabulary.

#### Extension #### {#Vocabulary-Extension-LR}

A [vocabulary extension](#VocabularyExtension) is a kind of [import](#Import) statement that can be added to a vocabulary to specify that it extends another vocabulary. This is typically needed when members of the extended vocabulary are cross-reference by the local members of the extending vocabulary.  A vocabulary extension is defined with the keyword `extends` followed by the imported vocabulary's NAMESPACE. If members of the imported vocabulary are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a namespace prefix ID that is unique within the vocabulary's imports.

<pre class="highlight highlight-html">
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

#### Usage #### {#Vocabulary-Usage-LR}

A [vocabulary usage](#VocabularyUsage) is a kind of [import](#Import) statement that can be added to a vocabulary to specify that it uses a [description](#Description-LR). This is typically needed when the vocabulary uses one or more of the description's instances in its restriction axioms. A vocabulary usage is defined with the keyword `extends` followed by the imported description's NAMESPACE. If members of the imported description are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a namespace prefix ID that is unique within the vocabulary's imports.

<pre class="highlight highlight-html">
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

Types that can be defined in a vocabulary are either *classifiers* (types of structured instances) or *scalars* (types of primitive values). Some classifiers (like `Aspect`, `Concept` and `Relation Entity`) are *entities*, meaning they can classify named instances, while others (like `Structure`) can only classify anonymous instances. Also, some scalars (like `Faceted Scalar`) can classify unlimited literals, while others (like `Enumerated Scalar`) can classify a limited set of literals.

Classifiers can specialize one or more classifiers, while scalars can only specialize one scalar only. These specializations are constrainted as discussed below for each type.

#### Aspect #### {#Aspect-LR}

An [aspect](#Concept-Syntax) is an entity defined in a vocabulary and represents a mixin type (or a capability) in a modeled domain. An aspect can only specialize other aspects, but can be specialized by any entity. An Aspect cannot be asserted as a type of instances in a description (there is no aspect instance), but can be inferred (by a DL reasoner) as such, if it is one of the supertypes of an asserted type.

An aspect is declared with the keyword `aspect` followed by the aspect's name ID. It can optionally specialize other aspects by following its name ID by the `:>` symbol then a comma-separated list of those supertypes' IRIs. An aspect can also optionally specify a list of axioms enclosed within a pair of square brackets `[` `]`.

<pre class="highlight highlight-html">
    `aspect` ID (`:>` [Aspect|IRI] (`,` [Aspect|IRI])*)? (`[`
        Axiom*
    `]`)?
</pre>

The following example vocabulary defines two aspects: *IdentifiedElement* and *NamedElement* where the latter specializes the former.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `aspect` IdentifiedElement
    `aspect` NamedElement :> IdentifiedElement
`}`
</pre>

Notice: that *IdentifiedElement* is referenced by its ID as a supertype, since it is defined locally within the same vocabulary.

#### Concept #### {#Concept-LR}

A [concept](#Concept-Syntax) is an entity defined in a vocabulary and represents a concrete type in a modeled domain. A concept can specialize other concepts or aspects, but can be specialized by other concepts only. It can also be asserted as a type of [concept instance](#ConceptInstance-LR) in a description. 

A concept is declared with the keyword `concept` followed by the concept's name ID. It can optionally specialize other concepts or aspects by following its name ID by the `:>` symbol then a comma-separated list of those supertypes' IRIs. A concept can also optionally specify a list of axioms enclosed within a pair of square brackets `[` `]`.

<pre class="highlight highlight-html">
    `concept` ID (`:>` [Concept|Aspect|IRI] (`,` [Concept|Aspect|IRI])*)? (`[`
        Axiom*
    `]`)?
</pre>

The following example vocabulary defines two concepts: *Component* and *Function*. The former concept specializes aspects *IdentifiedElement* and *ContainedElement* (which add these capabilities to the concept).

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `aspect` IdentifiedElement
    `aspect` ContainedElement
    `concept` Component :> IdentifiedElement, ContainedElement
    `concept` Function
`}`
</pre>

#### Relation Entity #### {#Relation-Entity-LR}

 is a term defined in a vocabulary and represents a reified relation between two entities (e.g., concepts), one of them playing the relation's source, while the other playing the relation's target. A relation entity is defined with the keywords `relation` `entity` followed by a name ID and a pair of square brackets `[` `]` that specify, by reference, the relation's `from` entity and `to` entity. A relation entity can optionally specify name IDs of two unreified [relations](#Relation-Syntax), a `forward` relation and a `reverse` relation, between the two entities.

<pre class="highlight highlight-html">
    `relation` `entity` ID `[`
        `from` [Entity|IRI]
        `to` [Entity|IRI]
        (`forward` ID)?
        (`reverse` ID)?
    `]`
</pre>

A diagram that visualizes the relation entity pattern is given below.

<pre><img src="images/Relation-Entity-Pattern.svg"/></pre>

The following example vocabulary defines a relation entity named *Performs* from the concept *Component* to the concept *Function with a forward relation named *performs* and a reverse relation called *isPerformedBy*. This forward relation can be used to specify that some concept performs some function, while the reverse relation can be used to specify that the function is performed by the component.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component
    `concept` Function
    `scalar` `property` hasId `[`
        `domain` Component
        `range` xsd:string
    `]`
    `scalar` `property` hasName `[`
        `domain` Function
        `range` xsd:string
    `]`
    `scalar` `property` isAbstract `[`
        `domain` Function
        `range` xsd:boolean
    `]`
    `relation` `entity` Performs `[`
        `from` Component
        `to` Function
        `forward` performs
        `reverse` isPerformedBy
    `]`
`}`
</pre>

A relation entity is both a [classifier](#Classifier-Syntax), allowing it to be a domain for a property, and an [entity](#Entity-Syntax), allowing it to be a source and target of a relation entity in a vocabulary. Also, by being reified, a relation entity can have instances (called [relation instances](#RelationInstance-Syntax)) in a description model that are typed by it. Such instances can specify values to their properties and be linked bo other related instances. On the other hand, the forward and the reverse relation are unreified, allowing them to only be types of links (vs. relation instances) between related instances in a description model, but cannot express any property values nor be themselves linked to/from related instances.

#### Structure #### {#Structure-LR}

#### Faceted Scalar #### {#Faceted-Scalar-LR}

A [scalar](#Scalar-Syntax) is a term defined in a vocabulary and represents a class of literal values (e.g., *1*, *"abc"*, *2.00*, *true*, etc.). 

OML uses some standard datatypes with the following IRIs:

<pre class="highlight highlight-html">

    // Number Scalars
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
    http://www.w3.org/2001/XMLSchema#double
    http://www.w3.org/2001/XMLSchema#float
    http://www.w3.org/2002/07/owl#real
    http://www.w3.org/2002/07/owl#rational

    // String Scalars
    http://www.w3.org/2001/XMLSchema#string
    http://www.w3.org/2001/XMLSchema#normalizedString
    http://www.w3.org/2001/XMLSchema#token
    http://www.w3.org/2001/XMLSchema#language
    http://www.w3.org/2001/XMLSchema#Name
    http://www.w3.org/2001/XMLSchema#NCName
    http://www.w3.org/2001/XMLSchema#NMTOKEN

    // Boolean Scalars
    http://www.w3.org/2001/XMLSchema#boolean

    // Binary Scalars
    http://www.w3.org/2001/XMLSchema#hexBinary
    http://www.w3.org/2001/XMLSchema#base64Binary
        
    // Time Scalars
    http://www.w3.org/2001/XMLSchema#dateTime
    http://www.w3.org/2001/XMLSchema#dateTimeStamp

    // IRI Scalars
    http://www.w3.org/2001/XMLSchema#anyURI

    // Literal Scalars
    http://www.w3.org/2000/01/rdf-schema#Literal
    http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral
    http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral

</pre>

Note: the definitions for these standard scalars are provided in their respective ([xsd](https://www.w3.org/TR/2012/REC-xmlschema11-2-20120405/#built-in-datatypes), and [owl](https://www.w3.org/TR/owl2-syntax/#Datatype_Maps)) standards.

#### Enumerated Scalar #### {#Enumerated-Scalar-LR}

**Structured Property**

### Properties ### {#Properties-LR}

#### Scalar Property #### {#Scalar-Property-LR}

A [scalar property](#ScalarProperty-Syntax) is a term defined in a vocabulary and represents a property whose domain is a classifier (e.g., concept), i.e., it can be asserted on instances of its classifier domain, and whose range is a scalar, i.e., its values are literals of that scalar. A scalar property is defined with the keywords `scalar` `property` followed by a name ID and a pair of square brackets `[` `]` that contain the property's `domain` (referencing a classifier) and `range` (referencing a scalar).

<pre class="highlight highlight-html">
    `scalar` `property` ID `[`
        `domain` [Classifier|IRI]
        `range` [Scalar|IRI]
    `]`
</pre>

The following example vocabulary defines three scalar properties named *hasId*, *hasName*, and *isAbstract*. The *hasId* property is in the domain of *Component* and can have *xsd:string* literals. The *hasName* property is in the domain of *Function* and can also have *xsd:string* literals. The *isAbstract* property is also in the domain of *Function* but can have *xsd:boolean* values.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` mission `{`
    `extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
    `concept` Component
    `concept` Function
    `scalar` `property` hasId `[`
        `domain` Component
        `range` xsd:string
    `]`
    `scalar` `property` hasName `[`
        `domain` Function
        `range` xsd:string
    `]`
    `scalar` `property` isAbstract `[`
        `domain` Function
        `range` xsd:boolean
    `]`
`}`
</pre>

#### Structured Property #### {#StructuredProperty-LR}

#### Annotation Property #### {#AnnotationProperty-LR}

### Axioms ### {#Axioms-LR}

#### Specialization #### {#Specialization-LR}

TermSpecialization

#### Key #### {#Key-LR}

KeyAxiom

#### Restriction #### {#Restriction-LR}

**Range Restriction Axioms**

ScalarPropertyRangeRestrictionAxiom

StructuredPropertyRangeRestrictionAxiom

RelationRangeRestrictionAxiom

**Cardinality Restriction Axioms**

ScalarPropertyCardinalityRestrictionAxiom

StructuredPropertyCardinalityRestrictionAxiom

RelationCardinalityRestrictionAxiom

**Value Restriction Axioms**

ScalarPropertyValueRestrictionAxiom

StructuredPropertyValueRestrictionAxiom

RelationTargetRestrictionAxiom

### Rule ### {#Rule-LR}

#### Predicates #### {#Predicates-LR}

TypePredicate

FeaturePredicate

RelationEntityPredicate

SameAsPredicate

DifferentFromPredicate

## Description ## {#Description-LR}

A [description](#Description-Syntax) is an ontology that uses terms in vocabularies to describe [named instances](#NamedInstance-Syntax) in a given domain. A description is declared with the keywords `description` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID.

<pre class="highlight highlight-html">
`description` NAMESPACE `as` ID `{`
`}`
</pre>

For example, the following description defines the components of a system and the functions they perform. It has the namespace *http://com.xyz/system/components#* and the prefix *components*.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
`}`
</pre>

### Import ### {#Description-Import-LR}

This section outlines the kind of import statements that can be added in a description's body.

#### Usage #### {#Description-Usage-LR}

A [description usage](#DescriptionUsage) is a kind of [import](#Import) statement that can be added to a description to specify a vocabulary that it uses. This is typically needed in order to use the terms (types and properties) of the vocabulary in the description's instance definitions. A description usage is defined with the keyword `uses` followed by the imported vocabulary's NAMESPACE. If members of the imported vocabulary are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID within the description's imports.

<pre class="highlight highlight-html">
`uses` NAMESPACE (`as` ID)?
</pre>

For example, the *components* description *uses* the *mission* vocabulary to describe components of a system and the functions they perform.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission

    `ci` System1 `:` mission:Component     // a cross-reference to concept Component
`}`
</pre>

#### Extension #### {#Description-Extension-LR}

A [description extension](#DescriptionExtension) is a kind of [import](#Import) statement that can be added to a description to specify that it extends another description. This can be used to split a system description into fragments that focus on different concerns or are contributed by different authorities. In this case, each description *extends* the other descriptions it depends on (e.g., by cross referencing named instances from them). A description extension is defined with the keyword `extends` followed by the imported description's NAMESPACE. If members of the imported description are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID within the description's imports.

<pre class="highlight highlight-html">
`extends` NAMESPACE (`as` ID)?
</pre>

For example, the *system1* description *extends* the *subsystem1* and *subsystem2* descriptions and defines component *System1* that aggregates components *Subsystem1* and *Subsystem2*, defined in these descriptions respectively.

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

#### Concept Instance #### {#ConceptInstance-LR}

A [concept instance](#ConceptInstance-Syntax) is a named instance defined in a description and can be typed by a concept (from some imported vocabulary). The concept instance is declared with the keyword `ci` and a name ID. It can optionally be followed by a `:` and an IRI to a concept that is the type of the instance. It can also optionally be followed by a pair of square brackets `[` `]` that holds other assertions about the instance.

<pre class="highlight highlight-html">
    `ci` ID (`:` [Concept|IRI])? (`[`
    `]`)?
</pre>

The following example description defines two concept instances: one named *component1* and typed by concept *mission:Component*, while the other is named *function1* and typed by concept *mission:Function*. Notice that the concepts are reference by ABBREVIIATED_IRI since they are imported with their vocabulary's namespace prefix.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
    `uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `ci` component1 `:` mission:Component
    `ci` function1 `:` mission:Function
`}`
</pre>

#### Relation Instance #### {#Relation-Instance-LR}

#### Structure Instance #### {#Structure-Instance-LR}

### Assertions ### {#Assertions-LR}

#### Scalar Property Value #### {#Scalar-Property-Value-LR}

A value for a scalar property can be [asserted](#ScalarPropertyValueAssertion-Syntax) on a named instance (e.g., concept instance) in a description. Such assertion can be added as one of the assertions between the square  brackets `[` `]` of the instance. Its syntax consists of an IRI to a [scalar property](#ScalarProperty-Syntax) from some vocabulary followed by a literal.

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

#### Structured Property Value #### {#Structured-Property-Value-LR}

#### Relation Link #### {#Link-LR}

A link, which is an unreified reference to a named instance (e.g., concept instance), can be [asserted](#ScalarPropertyValueAssertion-Syntax) on a named instance in a description. It represents a relation between the referencing instance (the source) and the referenced instance (the target). Such assertion can be added as one of the assertions between the square  brackets `[` `]` of the referencing instance. Its syntax consists of an IRI to a [relation](#Relation-Syntax) from some vocabulary followed by an IRI to a [named instance](#NamedInstance-Syntax) from some description.

<pre class="highlight highlight-html">
[Relation|IRI] [NamedInstance|IRI]
</pre>

The following example description defines two concept instances with a link asserted between them. Specifically, instance *component1* asserts a link of type *mission:performs* (the forward unreified relation of relation entity *mission:Performs*) to instance *function1*.

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

Note: a link is typed by an unreified (forward or reverse) relation, hence (unlike a [relation instance](#RelationInstance-Syntax)) cannot have its own assertions.

## Vocabulary Bundle ## {#Vocabulary-Bundle-LR}

A [vocabulary bundle](#VocabularyBundle-Syntax) is an ontology that bundles a set of vocabularies and allows description logic (DL) reasoning with [closed-world semantics](#Description-Logic-Semantics) using them (in contrast to a vocabulary that has [open-world semantics](#Description-Logic-Semantics)). A vocabulary bundle is declared with the keywords `vocabulary` `bundle` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID.

<pre class="highlight highlight-html">
`vocabulary` `bundle` NAMESPACE `as` ID `{`
`}`
</pre>

For example, the following vocabulary bundle has the namespace *http://com.xyz/methodology/foundation#* and the prefix *foundation*.

<pre class="highlight highlight-html">
`vocabulary` `bundle` `<`http://com.xyz/methodology/foundation#`>` `as` foundation `{`
`}`
</pre>

### Import ### {#Vocabulary-Bundle-Import-LR}

#### Inclusion #### {#Vocabulary-Bundle-Inclusion-LR}

An [vocabulary bundle inclusion](#VocabularyBundleInclusion) is a kind of [import](#Import) statement that can be added to a vocabulary bundle to specify that it includes a vocabulary. A vocabulary bundle inclusion is defined with the keyword `includes` followed by the imported vocabulary's NAMESPACE. If members of the imported vocabulary are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID in the bundle's imports.

<pre class="highlight highlight-html">
`includes` NAMESPACE (`as` ID)?
</pre>

For example, the *foundation* vocabulary bundle *includes* two vocabularies: *mission* and *project*.

<pre class="highlight highlight-html">
`vocabulary` `bundle` `<`http://com.xyz/methodology/foundation#`>` `as` foundation `{`
    `includes` `<`http://com.xyz/methodology/mission#`>` `as` mission
    `includes` `<`http://com.xyz/methodology/project#`>` `as` project
`}`
</pre>

#### Extends #### {#Vocabulary-Bundle-Extends-LR}

An [vocabulary bundle extends](#VocabularyBundleExtension) is a kind of [import](#Import) statement that can be added to a vocabulary bundle to specify that it extends another vocabulary bundle. This can be used to organize vocabulary bundles in layers that build on each other. Each bundle inherits the vocabularies contributed by its extended bundles and may optionally add to them other included vocabularies. This can, for example, be used to define a family of related vocabulary bundles that build on each other by tackling different incremental concerns. A vocabulary bundle extension is defined with the keyword `extends` followed by the imported vocabulary bundle's NAMESPACE.

<pre class="highlight highlight-html">
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

## Description Bundle ## {#Description-Bundle-LR}

A [description bundle](#DescriptionBundle-Syntax) is an ontology that bundles a set of descriptions and allows them to be reasoned on as a dataset using description logic (DL). A description bundle is declared with the keywords `description` `bundle` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID.

<pre class="highlight highlight-html">
`description` `bundle` NAMESPACE `as` ID `{`
`}`
</pre>

For example, the following description bundle has the namespace *http://com.xyz/missions/mission1#* and the prefix *mission1*.

<pre class="highlight highlight-html">
`description` `bundle` `<`http://com.xyz/missions/mission1#`>` `as` mission1 `{`
`}`
</pre>

### Import ### {#Description-Bundle-Import-LR}

#### Inclusion #### {#Description-Bundle-Inclusion-LR}

A [description bundle inclusion](#DescriptionBundleInclusion) is a kind of [import](#Import) statement that can be added to a description bundle to specify that it includes a description. A description bundle inclusion is defined with the keyword `includes` followed by the imported description's NAMESPACE. If members of the imported description are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID in the bundle's imports.

<pre class="highlight highlight-html">
`includes` NAMESPACE (`as` ID)?
</pre>

For example, the *mission1* description bundle *includes* two descriptions: *components* and *masses*.

<pre class="highlight highlight-html">
`description` `bundle` `<`http://com.xyz/missions/mission1#`>` `as` mission1 `{`
    `includes` `<`http://com.xyz/system/components#`>` `as` components
    `includes` `<`http://com.xyz/system/masses#`>` `as` masses
`}`
</pre>

#### Usage #### {#Description-Bundle-Usage-LR}

A [description bundle usage](#DescriptionBundleUsage) is a kind of [import](#Import) statement that can be added to a description bundle to specify that it uses a vocabulary bundle. This is typically done to specify the closed-world vocabulary bundle that this description bundle will be reasoned on with. A description bundle usage is defined with the keyword `uses` followed by the imported vocabulary bundle's NAMESPACE.

<pre class="highlight highlight-html">
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

#### Extension #### {#Description-Bundle-Extension-LR}

An [description bundle extension](#DescriptionBundleExtension) is a kind of [import](#Import) statement that can be added to a description bundle to specify that it extends another description bundle. This can be used to organize description bundles into layers that build on each other. Each bundle inherits the descriptions contributed by its extended bundles and optionally adds to them other descriptions. This can, for example, be used to define alternative datasets (e.g., representing alternative system designs) that extend a common dataset. A description bundle extension is defined with the keyword `extends` followed by the imported description bundle's NAMESPACE.

<pre class="highlight highlight-html">
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