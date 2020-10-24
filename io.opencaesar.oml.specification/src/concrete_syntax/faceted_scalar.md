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
