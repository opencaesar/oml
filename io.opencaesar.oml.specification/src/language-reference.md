# Language Reference # {#Language-Reference}

This section describes the features of the OML language. It is recommended for the reader to first read the [Organizational Features](#Organizational-Features-LR) section to gain an understanding of the common idioms and patterns of the language. The next section to read would be the [Basic Features](#Basic-Features-LR), which will describes the fundamental constructs of the language. Once the reader is comfortable with that, they can move on to the the section [Advanced Features](#Advanced-Features-LR) to gain knowledge about OML's advanced constructs.

## Organizational Features ## {#Organizational-Features-LR}

### Projects ### {#Projects-LR}

An OML project is a folder that is typically organized as follows:

<pre class="highlight highlight-html">
.
├── build
│   └── oml
│       └── www.w3.org
│           └── 2001
│               └── XMLSchema.oml
│           └── 2002
│               └── 07
│                   └── owl.oml
├── src
│   └── oml
│       ├── imce.jpl.nasa.gov
│       │    └── foundation
│       │	    ├── base.oml
│       │	    ├── analysis.oml
│       │	    └── mission.oml
│       └── europa.jpl.nasa.gov
│           └── lander
│       	    ├── assemblies.omlxmi
│       	    ├── endcircuits.omlxmi
│       	    └── functions.omlxmi
└── catalog.xml
</pre>

OML files either have the extension `oml` (if they use the OML textual syntax) or the extension `omlxmi` (if they use the OML XMI syntax). They can be organized in a folder structure nested under the project folder. Typically, OML files that are authored manually are nested under a `src/oml` folder, whereas those that are derived by a build process are nested under a `build/oml` folder (such folder is typically ignored when the project is placed under source control). Under either of these folders, the nesting hierarchy corresponds to that specified by the ontologies' IRIs (see [Ontologies](#Ontologies-LR) below).

Note: the Language Reference section focuses on describing OML using its textual notation (i.e., `oml` files rather than `omlxmi` files).

A `catalog.xml` file is typically placed at the root folder and provides a mapping from the OML ontologies' logical IRIs to their physical URIs (file paths) (see [Catalogs](#Catalogs-LR) below).

### Ontologies ### {#Ontologies-LR}

An ontology is the root element of an OML model and the unit of organizing ontological statements. It is defined with one of the `<ontology>` keywords (see [ontology syntax](#Ontology-Syntax) for details), a globally unique NAMESPACE, a locally unique ID (representing a NAMESPAC prefix), a set of imports (of other ontologies), and a set of statements (members and/or references).

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
	`<import>`*
	`<member`|`reference>`*
`}`
</pre>

An ontology's NAMESPACE is made up of an IRI and a separator character (either `#` or `/`). For example, `http://www.w3.org/2002/07/owl#` is a logical NAMESPACE that consists of IRI `http://www.w3.org/2002/07/owl` and separator charachter `#`. An ontology's IRI can be any opaque string but is usually specified as a URL in the format `http://<organization>/<path>`. An ontology's ID is a short name that is used as a NAMESPACE prefix (e.g., `owl` is a prefix for `http://www.w3.org/2002/07/owl#`) when referencing an ontology member using the ABBREVIATED_IRI syntax (see section [IRIs](#IRIs-LR) below). 

Each ontology is persisted in a separate file (with extension `oml` or `omlxmi`) under the project. The path to that file is specified by a `catalog.xml` file (see section [Catalogs](#Catalogs-LR) for details), so that it can be resolved when imported by another otology file (see [Imports](#Imports-LR) for details).

### Imports ### {#Imports-LR}

An ontology can import zero or more other ontologies, which allows it to gain access to the imported ontologies' statements (e.g., cross reference their members). This is accomplished by an ontology adding an import statement in its body (before other kinds of statements). An import statement is declared using one of the `<import>` keywords (see [import syntax](#Import-Syntax) for details) followed by the imported ontology's NAMESPACE and optionally its ID.

<pre class="highlight highlight-html">
`<import>` NAMESPACE (`as` ID)?
</pre>
 
Note: An imported ontology's ID is only needed in the import syntax when its members are cross-referenced using an ABBREVIATED_IRI syntax.

Note: An ontology's import closure is defined as all the ontologies that are imported directly or indirectly by an ontology

Note: An ontology whose members are referenced by another ontology needs to be directly imported, even if it is indirectly imported by the import closure.

### Catalogs ### {#Catalogs-LR}

For the ontology import mechanism to work, there must be a `catalog.xml` file in the ontology file's path (in one of its containing folders but more commonly at the project's root) that has a mapping from the imported ontology's logical IRI to physical URI (file path). The `catalog.xml` file is formatted according to the [OASIS XML Catalog](https://www.oasis-open.org/committees/entity/spec-2001-08-06.html). It contains mapping rules from the ontology logical IRIs to their phsyical file paths. One particular mapping rule kind that is often used is a `RewriteURI` rule.  It has an attribute `uriStartString` that specifies an IRI prefix, and an attribute `rewritePrefix` that specifies the corresponding path prefix that would replace it. For example, using the catalog below, the IRI `http://imce.jpl.nasa.gov/foundation/base` would map to the file path `src/oml/imce.jpl.nasa.gov/foundation/base.oml`, whle the IRI `http://www.w3.org/2002/07/owl` would map to the file path `build/oml/www.w3.org/2002/07/owl.oml`.

<pre class="highlight highlight-html">
<`?xml` `version`='1.0'`?`>
<`catalog` `xmlns`="urn:oasis:names:tc:entity:xmlns:xml:catalog" `prefer`="public">
	<`rewriteURI` `uriStartString`="http://imce.jpl.nasa.gov/" `rewritePrefix`="src/oml/imce.jpl.nasa.gov/" />
	<`rewriteURI` `uriStartString`="http://" rewritePrefix="build/oml/" />
<`/catalog`>
</pre>

Note: If an IRI is mappable by one or more catalog rules, the most specific rule is used.

Note: If an ontology's path contains two or more `catalog.xml` files, the one in the inner most folder is used.

Note: Catalog resolution checks the existence of files with extension `oml` first before checking extension `omlxmi`.

Note: OML files can only be recognized by the OML builder if their location is mapped by some `catalog.xml` files in their paths.

### Members ### {#Members-LR}

An ontology can have statements that define members, which are named elements whose IRIs consist of the NAMESPACE of their ontology followed by their own ID (name). For example, a member whose name is `AggregatedElement`, and defined in an ontology whose IRI is `http://imce.jpl.nasa.gov/foundation/base#`, has a member IRI `http://imce.jpl.nasa.gov/foundation/base#AggregatedElement`. 

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
	`<member>` ID
`}`
</pre>

Members can only be defined by their own ontology but can be refrenced by other importing ontologies. Different ontology kinds define different member kinds.The syntax for declaring members vary depending on the member kind, but at least consists of one of the `<member>` keywords (see [members](#Member-Syntax) for details) followed by the member's ID that must be unique within the ontology. The sections [Basic Features](#Basic-Features-LR) and [Advanced Features](#Advanced-Features-LR) introduce the various kinds of members in OML.

### References ### {#References-LR}

While members are defined only by their own ontology, they can be referenced by any ontology that has access to them (this includes their defining ontology or any ontology that imports it). Members can be referenced by specifying their REFERENCE, which can either be their IDs (only within their defining ontology) or their IRIs or ABBREVIATED_IRIs (within any ontology that has access to them). A member REFERENCE can be used any where in the OML [textual syntax](#Textual-Syntax) that a reference to a member is expected. 

However, OML has a special syntax when the reference is used as an ontology statement about a member. The syntax starts with the keyword `ref` followed by the one of the `<member>` keywords and then a REFERENCE. Such a statement, declaring a member reference, can be used to add extra information (e.g., annotations) about the member that was not added when it was originally defined. However, the extra information that can be added to a memner reference vs. to a member definition may vary (refer to the [Reference](#Reference-Syntax) syntax for details).

<pre class="highlight highlight-html">
`<ontology>` NAMESPACE `as` ID `{`
	`ref` `<member>` REFERENCE
`}`
</pre>

### IRIs ### {#IRIs-LR}

Both ontologies and members have globally unique IRIs withiin an OML model (and its import closure). The IRI of an ontology is equivalent to its NAMESPACE minus the separator character (`#` or `/`). For example, an ontology with the NAMESPACE `http://imce.jpl.nasa.gov/foundation/base#` has the IRI `http://imce.jpl.nasa.gov/foundation/base`. The IRI of an ontology member consists of its ontology's NAMESPACE concatenated to it the member's ID. For example, a member with the ID `AggregatedElement` in an ontology with a NAMESPACE `http://imce.jpl.nasa.gov/foundation/base#` has the IRI `http://imce.jpl.nasa.gov/foundation/base#AggreagedElement`. This is called the full IRI of amember. Such IRI can be written in an abbreviiated syntax using the ontology's namespace prefix. It can also be shorted further to the simple ID of the member when it is used in the context of its defining ontology. The following is an elaboration of the three possible syntaxes for IRIs.

**Full IRI**

The full \[IRI](#IRI-Syntax) syntax in OML conforms to a subset of the [standard IRI](https://datatracker.ietf.org/doc/html/rfc3987) syntax. However, the OML textual syntax only, it is surrounded by `< >` (e.g., `<http://www.w3.org/2002/07/owl#Thing>`). Also, the syntax of an ontology's \[NAMESPACE](#NAMESPACE-Syntax) is surrounded by `< >` (e.g., `<http://www.w3.org/2002/07/owl#>`).

Note: the `< >` are stripped off when the value is parsed from the OML textual syntax.

**Abbreviated IRI**

 The aforementiioned IRI syntax of OML is called the full IRI syntax. OML also supports an \[ABBREVIATED_IRI](#ABBREVIATED_IRI-Syntax) syntax for ontology members only. The syntax consists of the defining ontology's (prefix) ID and the member's (name) ID, delimited by the `:` character. For example, `owl:Thing` is an ABBREVIATED_IRI for a member with the IRI of `http://www.w3.org/2002/07/owl#Thing` when the ontology has a prefix ID of `owl`.

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

Moreover, while prefix ID used in an import statement typically matches the prefix ID specified in the imported ontology's definition, it does not have to match. In fact, the ability to use a different prefix ID in import statements allows disambuguating similar prefixes in the context of the importing ontology. For example:

 <pre class="highlight highlight-html">
`<ontology>` NAMESPACE1 `as` X `{`
	`<import>` NAMESPACE2 `as` Z         // the prefix is different from the definition's prefix below
	`ref` `<member>` Z:N                 // reference to an imported member
`}`

`<ontology>` NAMESPACE2 `as` Y `{`
	`<member>` N
`}`
</pre>

**ID**

IDs are strings used to specify the prefixes of ontologies and the names of ontology members. The [syntax](#ID-Syntax) of an ID consists of a sequence of letters, digits, and some other characters. 

Note: In OML textual syntax only, when a reserved keyword (e.g., `concept`) is used as an ID, it needs to escaped by `^` (e.g., `^concept`).


## Basic Features ## {#Basic-Features-LR}

This section overviews the basic features of OML that enable the reader to author simple OML ontologies. When read sequentially, it provides a good overview of the modeling process with OML:

1. First, it defines a [vocabulary](#Vocabulary-Syntax) where the concepts of a given domain are defined, a long with their scalar properties and relations. 
2. Then, it defines a [vocabulary bundle](#VocabularyBundle-Syntax) that includes the defined vocabulary (from step 1). 
3. Then, it defines a [description](#Description-Syntax) that uses the vocabulary (from step 1) to describe concept instances along with values for their scalar properties and links representing their relations to other instances.
4. Finally, it defines a [description bundle](#DescriptionBundle) that uses the vocabulary bundle (from step 2), and includes the description (from step 3).

### Vocabularies ### {#Vocabularies-LR}

**Vocabulary**

A [vocabulary](#Vocabulary-Syntax) is an ontology that defines a set of [terms](#Term-Syntax) and [rules](#Rule-Syntax) for a given domain and allows description logic reasoning with [open world semantics](#Description-Logic-Reasoning) using them. A vocabulary is declared with the keyword `vocabulary` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID.

<pre class="highlight highlight-html">
`vocabulary` NAMESPACE `as` ID `{`
`}`
</pre>

For example, the following vocabulary is meant to define a mission description methodology. It has the namespace *http://com.xyz/methodology/mission#* and the prefix *mission*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` missiom `{`
`}`
</pre>

**Vocabulary Extension**

A [vocabulary extension](#VocabularyExtension) is a kind of [import](#Import) statement that can be added to a vocabulary to specify that it extends another vocabulary. A vocabulary extension is defined with the keyword `extends` followed by the imported vocabulary's NAMESPACE. If members of the imported vocabulary are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID.

<pre class="highlight highlight-html">
`extends` NAMESPACE (`as` ID)?
</pre>

The following example vocabulary extends the vocabulary *http://www.w3.org/2001/XMLSchema#*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` missiom `{`
	`extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
`}`
</pre>

**Concept**

A [concept](#Concept-Syntax) is a term defined in a vocabulary and repersents a class of things in a modeled domain. A concept is declared with the keyword `concept` and followed by the concept's name ID.

<pre class="highlight highlight-html">
	`concept` ID
</pre>

The following example vocabulary defines two concepts: *Component* and *Function*. These concepts can be used as types of instances in a description model.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` missiom `{`
	`extends` `<`http://www.w3.org/2001/XMLSchema#`>` `as` xsd
	`concept` Component
	`concept` Function
`}`
</pre>

A concept is both a [classifier](#Classifier-Syntax), allowing it to be a domain for a property, and an [entity](#Entity-Syntax), allowing it to be a source and target of a relation entity.

**Scalar**

A [scalar](#Scalar-Syntax) is a term defined in a vocabulary and represents a class of literal values (e.g., *1*, *"abc"*, *2.00*, *true*, etc.). OML uses some standard datatypes with the following IRIs:

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

**Scalar Property**

A [scalar proeprty](#ScalarProperty-Syntax) is a term defined in a vocabulary and represents a property whose domain is a classifier (e.g., concept) and whose range is a scalar. This means a scalar property can be given values that are instances of its domain and those values can be literals of its scalar range. A scalar property is defined with the keywords `scalar` `property` followed by a name ID and a pair of square brackets `[` `]` that contain the property's `domain` (referencing a classifier) and `range` (referencing a scalar).

<pre class="highlight highlight-html">
	`scalar` `property` ID `[`
		`domain` [Classifir|REFERENCE]
		`range` [Scalar|REFERENCE]
	`]`
</pre>

The following example vocabulary defines three scalar properties named *hasId*, *hasName*, and *isAbstract*. The *hasId* property is in the domain of *Component* and can have literal values that are typed by *xsd:string*. The *hasName* property is in the domain of *Function* and can have literal values that are also typed by *xsd:string*. The *isAbstract* property is also in the domain of *Function* but can have literal values that are typed by *xsd:boolean*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` missiom `{`
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

**Relation Entity**

 is a term defined in a vocabulary and represents a reified relation between two entities (e.g., concepts), one of them playing the relation's source, while the other playing the relation's target. A relation entity is defined with the keywords `relation` `entity` followed by a name ID and a pair of square brackets `[` `]` that specify, by reference, the relation's `from` entity and `to` entity. A relation entity can optionally specify name IDs of two unreified [relations](#Relation-Syntax), a `forward` relation and a `reverse` relation, between the two entities.

<pre class="highlight highlight-html">
	`relation` `entity` ID `[`
		`from` [Entity|REFERENCE]
		`to` [Entity|REFERENCE]
		(`forward` ID)?
		(`reverse` ID)?
	`]`
</pre>

A diagram that visualizes the relation entity pattern is given below.

<pre><img src="images/Relation-Entity-Pattern.svg"/></pre>

The following example vocabulary defines a relation entity named *Performs* from the concept *Component* to the concept *Function with a forward relation named *performs* and a reverse relation called *isPerformedBy*. This forward relation can be used to specify that some concept performs some function, while the reverse relation can be used to specify that the function is performed by the componnet (see [desriptions](#Descriptions-LR) for details).

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/mission#`>` `as` missiom `{`
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

A relation entity is both a [classifier](#Classifier-Syntax), allowing it to be a domain for a property, and an [entity](#Entity-Syntax), allowing it to be a source and target of a relation entity in a vocabulary. Also, by being reified, a relation entity can have instances (called [relation instances](#RelationInstance-Syntax)) in a description model that are typed by it. Such instances can specify values to their propeties and be linked bo other related instances. On the other hand, the forward and the reverse relation are unreified, allowing them to only be types of links (vs. relation instances) between related instances in a description model, but cannot express any property values nor be themselves linked to/from related instances.

### Vocabulary Bundles ### {#Vocabulary-Bundles-LR}

A vocabulary has open-world semantics meaning that its most specialized concept terms are not disjuncted with each other, allowing them to be mixed together as types of instances.

**Vocabulary Bundle**

A [vocabulary bundle](#VocabularyBundle-Syntax) is an ontology that bundles a set of vocabularies and allows description logic reasoning with [closed-world semantics](#Description-Logic-Reasoning) using them. A vocabulary bundle is declared with the keywords `vocabulary` `bundle` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID.

<pre class="highlight highlight-html">
`vocabulary` `bundle` NAMESPACE `as` ID `{`
`}`
</pre>

For example, the following vocabulary has the namespace *http://com.xyz/methodology/foundation#* and the prefix *foundation*.

<pre class="highlight highlight-html">
`vocabulary` `bundle` `<`http://com.xyz/methodology/foundation#`>` `as` foundation `{`
`}`
</pre>

**Vocabulary Bundle Inclusion**

A [vocabulary bundle inclusion](#VocabularyBundleInclusion) is a kind of [import](#Import) statement that can be added to a vocabulary bundle to specify that it includes a vocabulary. A vocabulary bundle inclusion is defined with the keyword `includes` followed by the imported vocabulary's NAMESPACE. If members of the imported vocabulary are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID.

<pre class="highlight highlight-html">
`includes` NAMESPACE (`as` ID)?
</pre>

The following example vocabulary bundle is meant to define the foundation bundle. It includes the single vocabulary *http://com.xyz/methodology/mission#*.

<pre class="highlight highlight-html">
`vocabulary` `<`http://com.xyz/methodology/foundation#`>` `as` foundation `{`
	`includes` `<`http://com.xyz/methodology/mission#`>` `as` mission
`}`
</pre>

### Descriptions ### {#Descriptions-LR}

**Description**

A [description](#Description-Syntax) is an ontology that uses terms in vocabularies to describe [named instances](#NamedInstance-Syntax) in a given domain. A description is declared with the keywords `description` as its ontology kind, followed by its NAMESPACE, the keyword `as`, and its prefix ID.

<pre class="highlight highlight-html">
`description` NAMESPACE `as` ID `{`
`}`
</pre>

For example, the following description is meant to describe some of the components of a system and the functions they perform. It has the namespace *http://com.xyz/system/components#* and the prefix *components*.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
`}`
</pre>

**Description Usage**

A [description usage](#DescriptionUsage) is a kind of [import](#Import) statement that can be added to a description to specify a vocabulary that it uses. A description usage is defined with the keyword `uses` followed by the imported vocabulary's NAMESPACE. If members of the imported vocabulary are to be referenced using their ABBREVIATED_IRIs, then the NAMESPACE needs to be followed by the keyword `as` and a unique prefix ID.

<pre class="highlight highlight-html">
`uses` NAMESPACE (`as` ID)?
</pre>

The following example description uses the vocabulary *http://com.xyz/methodology/mission#* to describe components of a system and the functions they perform.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
	`uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
`}`
</pre>

**Concept Instance**

A [concept instance](#ConceptInstance-Syntax) is a kind of named instance in a description model that cab be typed by a concept from a used vocabulary. The concpet instance is declared with the keyword `ci` and a name ID. It can optionally be followed by a `:` and a REFERENCE to a concept that is the type if the instance. It can also optioinally be followed by a pair of square brackets `[` `]` that holds other assertions about the instance.

<pre class="highlight highlight-html">
	`ci` ID (`:` [Concept|REFERENCE])? (`[`
	`]`)?
</pre>

The following example description defines two concept instances: one named *component1* and typed by concept *mission:Component*, while the other is named *function1* and typed by concept *mission:Function*. Notice that the concepts are reference by ABBREVIIATED_IRI since they are defined in the used (imported) vocabulary.

<pre class="highlight highlight-html">
`description` `<`http://com.xyz/system/components#`>` `as` components `{`
	`uses` `<`http://com.xyz/methodology/mission#`>` `as` mission
	`ci` component1 `:` mission:Component
	`ci` function1 `:` mission:Function
`}`
</pre>

**Literals**

A [literal](#Literal-Syntax) represents a value that is typed by a scalar. OML supports several [standard scalars](#Vocabularies-LR). Each one of those scalars defines the syntax for its literal values. However, OML has a general 

**Scalar Property Value**

ScalarPropertyValueAssertion

**Link**

LinkAssertion

### Description Bundles ### {#Description-Bundles-LR}

**Description Bundle**

DescriptionBundle

DescriptionInclusion

DescriptionUsage

### Description Logic Reasoning ### {#Description-Logic-Reasoning}


## Advanced Features ## {#Advanced-Features-LR}

### Other Imports ### {#Other-Imports-LR}

**Ontology Extension**

VocabularyExtension

VocabularyBundleExtension

DescriptionExtension

DescriptionBundleExtension

**Vocabulary Usage**

VocabularyUsage

### Relation Instance ### {#Relation-Instance-LR}

RelationInstance

### Multi Classification ### {#Multo-Classification}

### Other Terms ### {#Other-Terms-LR}

**Aspect**

Aspect

**Structure**

Structure

**Structured Property**

StructuredProperty

**Structure Instance**

StructureInstance

**Faceted Scalar**

FacetedScalar

**Enumerated Scalar**

EnumeratedScalar

**Property Semantic Variants**

ScalarProperty

StructureProperty

**Relation Entity Semantic Variants**

RelationEntity

### Axioms ### {#Axioms-LR}

**Term Specialization**

TermSpecialization

**Key Axiom**

KeyAxiom

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

### Rules ### {#Rules-LR}

**Rules**

Rule

TypePredicate

FeaturePredicate

RelationEntityPredicate

SameAsPredicate

DifferentFromPredicate

### Annotations ### {#Annotation-LR}

**Annotation Property**

AnnotationProperty

**Annotation**

Annotation