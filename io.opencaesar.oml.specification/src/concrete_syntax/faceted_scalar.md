<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">scalar</span> ID (:> <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a> (, <a href="#SpecializationAxiom-Syntax">[SpecializationAxiom]</a>)*)? ([
	(<span style="font-weight:bold;color:purple">length</span> INTEGER)?
	(<span style="font-weight:bold;color:purple">minLength</span> INTEGER)?
	(<span style="font-weight:bold;color:purple">maxLength</span> INTEGER)?
	(<span style="font-weight:bold;color:purple">pattern</span> STRING)?
	(<span style="font-weight:bold;color:purple">language</span> LANGUAGE)?
	(<span style="font-weight:bold;color:purple">minInclusive</span> <a href="#Literal-Syntax">Literal</a>)?
	(<span style="font-weight:bold;color:purple">minExclusive</span> <a href="#Literal-Syntax">Literal</a>)?
	(<span style="font-weight:bold;color:purple">maxInclusive</span> <a href="#Literal-Syntax">Literal</a>)?
	(<span style="font-weight:bold;color:purple">maxExclusive</span> <a href="#Literal-Syntax">Literal</a>)?
])?
</pre>
