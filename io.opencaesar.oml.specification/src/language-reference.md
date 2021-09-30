# Language Reference # {#LanguageReference}

**Ontology**

An ontology is declared with one of the ontology keywords (see sections 2.2-2.5), a globally unique `NAMESPACE`, and a locally unique `ID` as namespace prefix.

<pre class="highlight highlight-html">
Annotation*
`<ontology_keyword>` NAMESPACE `as` ID {
	Import*
	Member*
}
</pre>

The `NAMESPACE` consists of an `IRI` that is postfixed with a separator character (`#` or `/`), e.g., &lt;http://www.w3.org/2002/07/owl#. The `ID` is a default short name for the ontology that can substitute for its `IRI` when used in an ontology member's abbreviated `IRI` notation (e.g., `ID:ID`). An ontology can have statements added to its body between `{` and `}`. The statements can be `Import` statements or `Member` statements (placed after all `Import` statements).

**Import**

An ontology may import other ontologies using one of the import statements allowed for the ontology kind. An import statement is placed within the body of the ontology before any member statement. The syntax of an import statement starts with an import keyword, that is supported by the ontology kind, followed by the imported ontology's `NAMESPACE`. If members of the imported ontology would be referenced using `ABBREVIATED_IRI` notation (`ID:ID`), the corresponding import statement must also specify the prefix using the syntax `as ID`.

<pre class="highlight highlight-html">
Annotation*
`<import_keyword>` IRI (`as` ID)?
 </pre>

**Member**

An ontology may declare members by adding them with member statements after all import statements. A new member is declared by one of the member keywords supported by the ontology kind, followed by the member's `ID`. Other details supported by the member's syntax may also be added.

<pre class="highlight highlight-html">
Annotation*
`<member_keyword>` ID ... ([
	...
])?
</pre>

**Reference**

In addition to declaring a new `Member` , an ontology may also add statements about already declared members (within the ontology or by one of its imported ontologies). Those statements where the onology member is the subject are called `Reference` statements. Such statement has a syntax that (more or less) resembles that of a member declaration, except that it is preceeded with the keyword `ref`, and a `REF` is used instead of the `ID`. Notice that it is more common to add such statement when the subject member is imported rather than local to the ontology, since in the latter case, it can be part of the member's declaration.

<pre class="highlight highlight-html">
Annotation*
`ref` `<member_keyword>` REF ... ([
	...
])?
</pre>

**IRI**

An IRI is a globally unique identifier for an element (ontology or member). When an ontology is declared, its IRI typically has the syntax of a URL (e.g., http://ontology) but this is not a requirement. When members are declared within an ontology, their IRI is derived from their `ID` and the `NAMESPACE` of their defining ontology as follow: `NAMESPACE` + `ID` (e.g., http://ontology#member). The member's `IRI` can also be abbreviated by replacing the defining ontology's `IRI` by its prefix `ID` (e.g., `ID`:`ID`). Notice that an importing ontology may override an imported ontology's prefix in the `Import` statement.

**Annotation**

<pre class="highlight highlight-html">
@[AnnotationProperty|REF] Literal?
</pre>

**Literal**

<pre class="highlight highlight-html">
INTEGER | // literal is typed by xsd:integer
DECIMAL | // literal is typed by xsd:decimal
DOUBLE  | // literal is typed by xsd:double
BOOLEAN | // literal is typed by xsd:boolean
QUOTED_LITERAL (^^[FacetedScalar|REF] | $ID)?
</pre>

> For QUOTED_LITERAL, the [FacetedScalar|REF] must be a REF of one of the OWL2 [built-in datatypes](https://www.w3.org/TR/2012/REC-xmlschema11-2-20120405/#built-in-datatypes) only. If not specified, it defaults to xsd:string. (The OML API OmlRead.getTypeIRI(Literal) can be used to programmatically get the type IRI.)