<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">rule</span> ID [
	(<a href="#EntityPredicate-Syntax">EntityPredicate</a> | <a href="#RelationPredicate-Syntax">RelationPredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a> | <a href="#SameAsPredicate-Syntax">SameAsPredicate</a> | <a href="#DifferentFromPredicate-Syntax">DifferentFromPredicate</a>)
	(^ (<a href="#EntityPredicate-Syntax">EntityPredicate</a> | <a href="#RelationPredicate-Syntax">RelationPredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a> | <a href="#SameAsPredicate-Syntax">SameAsPredicate</a> | <a href="#DifferentFromPredicate-Syntax">DifferentFromPredicate</a>))*
	->
	(<a href="#EntityPredicate-Syntax">EntityPredicate</a> | <a href="#RelationPredicate-Syntax">RelationPredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a> | <a href="#SameAsPredicate-Syntax">SameAsPredicate</a> | <a href="#DifferentFromPredicate-Syntax">DifferentFromPredicate</a>)
	(^ (<a href="#EntityPredicate-Syntax">EntityPredicate</a> | <a href="#RelationPredicate-Syntax">RelationPredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a> | <a href="#SameAsPredicate-Syntax">SameAsPredicate</a> | <a href="#DifferentFromPredicate-Syntax">DifferentFromPredicate</a>))*
]
</pre>
