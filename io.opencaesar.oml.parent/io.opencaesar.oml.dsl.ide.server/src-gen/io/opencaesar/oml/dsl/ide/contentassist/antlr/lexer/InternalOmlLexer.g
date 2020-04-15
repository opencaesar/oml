/*
 * Copyright 2019 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
lexer grammar InternalOmlLexer;

@header {
package io.opencaesar.oml.dsl.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

DifferentFrom : 'differentFrom';

MaxExclusive : 'maxExclusive';

MaxInclusive : 'maxInclusive';

MinExclusive : 'minExclusive';

MinInclusive : 'minInclusive';

Description : 'description';

Irreflexive : 'irreflexive';

Annotation : 'annotation';

Asymmetric : 'asymmetric';

Enumerated : 'enumerated';

Functional : 'functional';

Structured : 'structured';

Transitive : 'transitive';

Vocabulary : 'vocabulary';

MaxLength : 'maxLength';

MinLength : 'minLength';

Reflexive : 'reflexive';

Restricts : 'restricts';

Structure : 'structure';

Symmetric : 'symmetric';

Includes : 'includes';

Language : 'language';

Property : 'property';

Relation : 'relation';

Concept : 'concept';

Exactly : 'exactly';

Extends : 'extends';

Forward : 'forward';

Inverse : 'inverse';

Pattern : 'pattern';

Aspect : 'aspect';

Bundle : 'bundle';

Domain : 'domain';

Entity : 'entity';

Length : 'length';

SameAs : 'sameAs';

Scalar : 'scalar';

Range : 'range';

From : 'from';

Rule : 'rule';

Some : 'some';

Uses : 'uses';

With : 'with';

All : 'all';

Key : 'key';

Max : 'max';

Min : 'min';

Ref : 'ref';

HyphenMinusGreaterThanSign : '->';

ColonGreaterThanSign : ':>';

CircumflexAccentCircumflexAccent : '^^';

As : 'as';

Ci : 'ci';

Ri : 'ri';

To : 'to';

NumberSign : '#';

DollarSign : '$';

LeftParenthesis : '(';

RightParenthesis : ')';

Comma : ',';

Solidus : '/';

Colon : ':';

CommercialAt : '@';

LeftSquareBracket : '[';

RightSquareBracket : ']';

CircumflexAccent : '^';

LeftCurlyBracket : '{';

RightCurlyBracket : '}';

RULE_BOOLEAN_STR : ('false'|'true');

RULE_UNSIGNED_INTEGER_STR : RULE_DIGIT+;

RULE_INTEGER_STR : ('+'|'-')? RULE_DIGIT+;

RULE_DECIMAL_STR : ('+'|'-')? (RULE_DIGIT+ ('.' RULE_DIGIT*)?|'.' RULE_DIGIT+);

RULE_DOUBLE_STR : ('+'|'-')? (RULE_DIGIT+ ('.' RULE_DIGIT*)?|'.' RULE_DIGIT+) (('e'|'E') ('+'|'-')? RULE_DIGIT+)?;

RULE_STRING : ('"' (~(('"'|'\\'))|'\\' .)* '"'|'\'' (~(('\''|'\\'))|'\\' .)* '\''|'\'\'\'' ( options {greedy=false;} : . )*'\'\'\''|'"""' ( options {greedy=false;} : . )*'"""');

RULE_IRI : '<' ~(('>'|' '))* '>';

RULE_ABBREV_IRI : RULE_ID ':' RULE_ID;

RULE_ID : '^'? (RULE_ALPHA|RULE_DIGIT|'_') (RULE_ALPHA|RULE_DIGIT|'_'|'-'|'.')*;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

fragment RULE_ALPHA : ('a'..'z'|'A'..'Z');

fragment RULE_DIGIT : '0'..'9';
