<pre class="highlight highlight-html">
(<a href="#Annotation-Syntax">Annotation</a>)*
<span style="font-weight:bold;color:purple">rule</span> ID [
	(<a href="#TypePredicate-Syntax">TypePredicate</a> | <a href="#FeaturePredicate-Syntax">FeaturePredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a> | <a href="#SameAsPredicate-Syntax">SameAsPredicate</a> | <a href="#DifferentFromPredicate-Syntax">DifferentFromPredicate</a>)
	(^ (<a href="#TypePredicate-Syntax">TypePredicate</a> | <a href="#FeaturePredicate-Syntax">FeaturePredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a> | <a href="#SameAsPredicate-Syntax">SameAsPredicate</a> | <a href="#DifferentFromPredicate-Syntax">DifferentFromPredicate</a>))*
	->
	(<a href="#TypePredicate-Syntax">TypePredicate</a> | <a href="#FeaturePredicate-Syntax">FeaturePredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a> | <a href="#SameAsPredicate-Syntax">SameAsPredicate</a> | <a href="#DifferentFromPredicate-Syntax">DifferentFromPredicate</a>)
	(^ (<a href="#TypePredicate-Syntax">TypePredicate</a> | <a href="#FeaturePredicate-Syntax">FeaturePredicate</a> | <a href="#RelationEntityPredicate-Syntax">RelationEntityPredicate</a> | <a href="#SameAsPredicate-Syntax">SameAsPredicate</a> | <a href="#DifferentFromPredicate-Syntax">DifferentFromPredicate</a>))*
]
</pre>
