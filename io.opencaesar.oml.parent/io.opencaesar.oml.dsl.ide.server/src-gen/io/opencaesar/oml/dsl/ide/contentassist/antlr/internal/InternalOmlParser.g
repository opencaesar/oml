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
parser grammar InternalOmlParser;

options {
	tokenVocab=InternalOmlLexer;
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
}

@header {
package io.opencaesar.oml.dsl.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import io.opencaesar.oml.dsl.services.OmlGrammarAccess;

}
@members {
	private OmlGrammarAccess grammarAccess;
	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
	
	{
		tokenNameToValue.put("NumberSign", "'#'");
		tokenNameToValue.put("DollarSign", "'\\u0024'");
		tokenNameToValue.put("LeftParenthesis", "'('");
		tokenNameToValue.put("RightParenthesis", "')'");
		tokenNameToValue.put("Comma", "','");
		tokenNameToValue.put("Solidus", "'/'");
		tokenNameToValue.put("Colon", "':'");
		tokenNameToValue.put("CommercialAt", "'@'");
		tokenNameToValue.put("LeftSquareBracket", "'['");
		tokenNameToValue.put("RightSquareBracket", "']'");
		tokenNameToValue.put("CircumflexAccent", "'^'");
		tokenNameToValue.put("LeftCurlyBracket", "'{'");
		tokenNameToValue.put("RightCurlyBracket", "'}'");
		tokenNameToValue.put("HyphenMinusGreaterThanSign", "'->'");
		tokenNameToValue.put("ColonGreaterThanSign", "':>'");
		tokenNameToValue.put("CircumflexAccentCircumflexAccent", "'^^'");
		tokenNameToValue.put("As", "'as'");
		tokenNameToValue.put("Ci", "'ci'");
		tokenNameToValue.put("Ri", "'ri'");
		tokenNameToValue.put("To", "'to'");
		tokenNameToValue.put("All", "'all'");
		tokenNameToValue.put("Key", "'key'");
		tokenNameToValue.put("Max", "'max'");
		tokenNameToValue.put("Min", "'min'");
		tokenNameToValue.put("Ref", "'ref'");
		tokenNameToValue.put("From", "'from'");
		tokenNameToValue.put("Rule", "'rule'");
		tokenNameToValue.put("Some", "'some'");
		tokenNameToValue.put("Uses", "'uses'");
		tokenNameToValue.put("With", "'with'");
		tokenNameToValue.put("Range", "'range'");
		tokenNameToValue.put("Aspect", "'aspect'");
		tokenNameToValue.put("Bundle", "'bundle'");
		tokenNameToValue.put("Domain", "'domain'");
		tokenNameToValue.put("Entity", "'entity'");
		tokenNameToValue.put("Length", "'length'");
		tokenNameToValue.put("SameAs", "'sameAs'");
		tokenNameToValue.put("Scalar", "'scalar'");
		tokenNameToValue.put("Concept", "'concept'");
		tokenNameToValue.put("Exactly", "'exactly'");
		tokenNameToValue.put("Extends", "'extends'");
		tokenNameToValue.put("Forward", "'forward'");
		tokenNameToValue.put("Inverse", "'inverse'");
		tokenNameToValue.put("Pattern", "'pattern'");
		tokenNameToValue.put("Includes", "'includes'");
		tokenNameToValue.put("Language", "'language'");
		tokenNameToValue.put("Property", "'property'");
		tokenNameToValue.put("Relation", "'relation'");
		tokenNameToValue.put("MaxLength", "'maxLength'");
		tokenNameToValue.put("MinLength", "'minLength'");
		tokenNameToValue.put("Reflexive", "'reflexive'");
		tokenNameToValue.put("Restricts", "'restricts'");
		tokenNameToValue.put("Structure", "'structure'");
		tokenNameToValue.put("Symmetric", "'symmetric'");
		tokenNameToValue.put("Annotation", "'annotation'");
		tokenNameToValue.put("Asymmetric", "'asymmetric'");
		tokenNameToValue.put("Enumerated", "'enumerated'");
		tokenNameToValue.put("Functional", "'functional'");
		tokenNameToValue.put("Structured", "'structured'");
		tokenNameToValue.put("Transitive", "'transitive'");
		tokenNameToValue.put("Vocabulary", "'vocabulary'");
		tokenNameToValue.put("Description", "'description'");
		tokenNameToValue.put("Irreflexive", "'irreflexive'");
		tokenNameToValue.put("MaxExclusive", "'maxExclusive'");
		tokenNameToValue.put("MaxInclusive", "'maxInclusive'");
		tokenNameToValue.put("MinExclusive", "'minExclusive'");
		tokenNameToValue.put("MinInclusive", "'minInclusive'");
		tokenNameToValue.put("DifferentFrom", "'differentFrom'");
	}

	public void setGrammarAccess(OmlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		String result = tokenNameToValue.get(tokenName);
		if (result == null)
			result = tokenName;
		return result;
	}
}

// Entry rule entryRuleOntology
entryRuleOntology
:
{ before(grammarAccess.getOntologyRule()); }
	 ruleOntology
{ after(grammarAccess.getOntologyRule()); } 
	 EOF 
;

// Rule Ontology
ruleOntology 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOntologyAccess().getAlternatives()); }
		(rule__Ontology__Alternatives)
		{ after(grammarAccess.getOntologyAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnnotation
entryRuleAnnotation
:
{ before(grammarAccess.getAnnotationRule()); }
	 ruleAnnotation
{ after(grammarAccess.getAnnotationRule()); } 
	 EOF 
;

// Rule Annotation
ruleAnnotation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnotationAccess().getGroup()); }
		(rule__Annotation__Group__0)
		{ after(grammarAccess.getAnnotationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnnotatedElement
entryRuleAnnotatedElement
:
{ before(grammarAccess.getAnnotatedElementRule()); }
	 ruleAnnotatedElement
{ after(grammarAccess.getAnnotatedElementRule()); } 
	 EOF 
;

// Rule AnnotatedElement
ruleAnnotatedElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnotatedElementAccess().getAlternatives()); }
		(rule__AnnotatedElement__Alternatives)
		{ after(grammarAccess.getAnnotatedElementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIdentifiedElement
entryRuleIdentifiedElement
:
{ before(grammarAccess.getIdentifiedElementRule()); }
	 ruleIdentifiedElement
{ after(grammarAccess.getIdentifiedElementRule()); } 
	 EOF 
;

// Rule IdentifiedElement
ruleIdentifiedElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIdentifiedElementAccess().getAlternatives()); }
		(rule__IdentifiedElement__Alternatives)
		{ after(grammarAccess.getIdentifiedElementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminology
entryRuleTerminology
:
{ before(grammarAccess.getTerminologyRule()); }
	 ruleTerminology
{ after(grammarAccess.getTerminologyRule()); } 
	 EOF 
;

// Rule Terminology
ruleTerminology 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminologyAccess().getAlternatives()); }
		(rule__Terminology__Alternatives)
		{ after(grammarAccess.getTerminologyAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVocabulary
entryRuleVocabulary
:
{ before(grammarAccess.getVocabularyRule()); }
	 ruleVocabulary
{ after(grammarAccess.getVocabularyRule()); } 
	 EOF 
;

// Rule Vocabulary
ruleVocabulary 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVocabularyAccess().getGroup()); }
		(rule__Vocabulary__Group__0)
		{ after(grammarAccess.getVocabularyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBundle
entryRuleBundle
:
{ before(grammarAccess.getBundleRule()); }
	 ruleBundle
{ after(grammarAccess.getBundleRule()); } 
	 EOF 
;

// Rule Bundle
ruleBundle 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBundleAccess().getGroup()); }
		(rule__Bundle__Group__0)
		{ after(grammarAccess.getBundleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDescription
entryRuleDescription
:
{ before(grammarAccess.getDescriptionRule()); }
	 ruleDescription
{ after(grammarAccess.getDescriptionRule()); } 
	 EOF 
;

// Rule Description
ruleDescription 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDescriptionAccess().getGroup()); }
		(rule__Description__Group__0)
		{ after(grammarAccess.getDescriptionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleMember
entryRuleMember
:
{ before(grammarAccess.getMemberRule()); }
	 ruleMember
{ after(grammarAccess.getMemberRule()); } 
	 EOF 
;

// Rule Member
ruleMember 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMemberAccess().getAlternatives()); }
		(rule__Member__Alternatives)
		{ after(grammarAccess.getMemberAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerm
entryRuleTerm
:
{ before(grammarAccess.getTermRule()); }
	 ruleTerm
{ after(grammarAccess.getTermRule()); } 
	 EOF 
;

// Rule Term
ruleTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTermAccess().getAlternatives()); }
		(rule__Term__Alternatives)
		{ after(grammarAccess.getTermAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSpecializableTerm
entryRuleSpecializableTerm
:
{ before(grammarAccess.getSpecializableTermRule()); }
	 ruleSpecializableTerm
{ after(grammarAccess.getSpecializableTermRule()); } 
	 EOF 
;

// Rule SpecializableTerm
ruleSpecializableTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSpecializableTermAccess().getAlternatives()); }
		(rule__SpecializableTerm__Alternatives)
		{ after(grammarAccess.getSpecializableTermAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleType
entryRuleType
:
{ before(grammarAccess.getTypeRule()); }
	 ruleType
{ after(grammarAccess.getTypeRule()); } 
	 EOF 
;

// Rule Type
ruleType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeAccess().getAlternatives()); }
		(rule__Type__Alternatives)
		{ after(grammarAccess.getTypeAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleClassifier
entryRuleClassifier
:
{ before(grammarAccess.getClassifierRule()); }
	 ruleClassifier
{ after(grammarAccess.getClassifierRule()); } 
	 EOF 
;

// Rule Classifier
ruleClassifier 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getClassifierAccess().getAlternatives()); }
		(rule__Classifier__Alternatives)
		{ after(grammarAccess.getClassifierAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntity
entryRuleEntity
:
{ before(grammarAccess.getEntityRule()); }
	 ruleEntity
{ after(grammarAccess.getEntityRule()); } 
	 EOF 
;

// Rule Entity
ruleEntity 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityAccess().getAlternatives()); }
		(rule__Entity__Alternatives)
		{ after(grammarAccess.getEntityAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAspect
entryRuleAspect
:
{ before(grammarAccess.getAspectRule()); }
	 ruleAspect
{ after(grammarAccess.getAspectRule()); } 
	 EOF 
;

// Rule Aspect
ruleAspect 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAspectAccess().getGroup()); }
		(rule__Aspect__Group__0)
		{ after(grammarAccess.getAspectAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConcept
entryRuleConcept
:
{ before(grammarAccess.getConceptRule()); }
	 ruleConcept
{ after(grammarAccess.getConceptRule()); } 
	 EOF 
;

// Rule Concept
ruleConcept 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptAccess().getGroup()); }
		(rule__Concept__Group__0)
		{ after(grammarAccess.getConceptAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationEntity
entryRuleRelationEntity
:
{ before(grammarAccess.getRelationEntityRule()); }
	 ruleRelationEntity
{ after(grammarAccess.getRelationEntityRule()); } 
	 EOF 
;

// Rule RelationEntity
ruleRelationEntity 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationEntityAccess().getGroup()); }
		(rule__RelationEntity__Group__0)
		{ after(grammarAccess.getRelationEntityAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructure
entryRuleStructure
:
{ before(grammarAccess.getStructureRule()); }
	 ruleStructure
{ after(grammarAccess.getStructureRule()); } 
	 EOF 
;

// Rule Structure
ruleStructure 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructureAccess().getGroup()); }
		(rule__Structure__Group__0)
		{ after(grammarAccess.getStructureAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleProperty
entryRuleProperty
:
{ before(grammarAccess.getPropertyRule()); }
	 ruleProperty
{ after(grammarAccess.getPropertyRule()); } 
	 EOF 
;

// Rule Property
ruleProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPropertyAccess().getAlternatives()); }
		(rule__Property__Alternatives)
		{ after(grammarAccess.getPropertyAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnnotationProperty
entryRuleAnnotationProperty
:
{ before(grammarAccess.getAnnotationPropertyRule()); }
	 ruleAnnotationProperty
{ after(grammarAccess.getAnnotationPropertyRule()); } 
	 EOF 
;

// Rule AnnotationProperty
ruleAnnotationProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnotationPropertyAccess().getGroup()); }
		(rule__AnnotationProperty__Group__0)
		{ after(grammarAccess.getAnnotationPropertyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFeatureProperty
entryRuleFeatureProperty
:
{ before(grammarAccess.getFeaturePropertyRule()); }
	 ruleFeatureProperty
{ after(grammarAccess.getFeaturePropertyRule()); } 
	 EOF 
;

// Rule FeatureProperty
ruleFeatureProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFeaturePropertyAccess().getAlternatives()); }
		(rule__FeatureProperty__Alternatives)
		{ after(grammarAccess.getFeaturePropertyAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarProperty
entryRuleScalarProperty
:
{ before(grammarAccess.getScalarPropertyRule()); }
	 ruleScalarProperty
{ after(grammarAccess.getScalarPropertyRule()); } 
	 EOF 
;

// Rule ScalarProperty
ruleScalarProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarPropertyAccess().getGroup()); }
		(rule__ScalarProperty__Group__0)
		{ after(grammarAccess.getScalarPropertyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructuredProperty
entryRuleStructuredProperty
:
{ before(grammarAccess.getStructuredPropertyRule()); }
	 ruleStructuredProperty
{ after(grammarAccess.getStructuredPropertyRule()); } 
	 EOF 
;

// Rule StructuredProperty
ruleStructuredProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructuredPropertyAccess().getGroup()); }
		(rule__StructuredProperty__Group__0)
		{ after(grammarAccess.getStructuredPropertyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalar
entryRuleScalar
:
{ before(grammarAccess.getScalarRule()); }
	 ruleScalar
{ after(grammarAccess.getScalarRule()); } 
	 EOF 
;

// Rule Scalar
ruleScalar 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarAccess().getAlternatives()); }
		(rule__Scalar__Alternatives)
		{ after(grammarAccess.getScalarAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFacetedScalar
entryRuleFacetedScalar
:
{ before(grammarAccess.getFacetedScalarRule()); }
	 ruleFacetedScalar
{ after(grammarAccess.getFacetedScalarRule()); } 
	 EOF 
;

// Rule FacetedScalar
ruleFacetedScalar 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getGroup()); }
		(rule__FacetedScalar__Group__0)
		{ after(grammarAccess.getFacetedScalarAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEnumeratedScalar
entryRuleEnumeratedScalar
:
{ before(grammarAccess.getEnumeratedScalarRule()); }
	 ruleEnumeratedScalar
{ after(grammarAccess.getEnumeratedScalarRule()); } 
	 EOF 
;

// Rule EnumeratedScalar
ruleEnumeratedScalar 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEnumeratedScalarAccess().getGroup()); }
		(rule__EnumeratedScalar__Group__0)
		{ after(grammarAccess.getEnumeratedScalarAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelation
entryRuleRelation
:
{ before(grammarAccess.getRelationRule()); }
	 ruleRelation
{ after(grammarAccess.getRelationRule()); } 
	 EOF 
;

// Rule Relation
ruleRelation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationAccess().getAlternatives()); }
		(rule__Relation__Alternatives)
		{ after(grammarAccess.getRelationAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleForwardRelation
entryRuleForwardRelation
:
{ before(grammarAccess.getForwardRelationRule()); }
	 ruleForwardRelation
{ after(grammarAccess.getForwardRelationRule()); } 
	 EOF 
;

// Rule ForwardRelation
ruleForwardRelation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getForwardRelationAccess().getGroup()); }
		(rule__ForwardRelation__Group__0)
		{ after(grammarAccess.getForwardRelationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInverseRelation
entryRuleInverseRelation
:
{ before(grammarAccess.getInverseRelationRule()); }
	 ruleInverseRelation
{ after(grammarAccess.getInverseRelationRule()); } 
	 EOF 
;

// Rule InverseRelation
ruleInverseRelation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInverseRelationAccess().getGroup()); }
		(rule__InverseRelation__Group__0)
		{ after(grammarAccess.getInverseRelationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRule
entryRuleRule
:
{ before(grammarAccess.getRuleRule()); }
	 ruleRule
{ after(grammarAccess.getRuleRule()); } 
	 EOF 
;

// Rule Rule
ruleRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRuleAccess().getGroup()); }
		(rule__Rule__Group__0)
		{ after(grammarAccess.getRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInstance
entryRuleInstance
:
{ before(grammarAccess.getInstanceRule()); }
	 ruleInstance
{ after(grammarAccess.getInstanceRule()); } 
	 EOF 
;

// Rule Instance
ruleInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInstanceAccess().getAlternatives()); }
		(rule__Instance__Alternatives)
		{ after(grammarAccess.getInstanceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructureInstance
entryRuleStructureInstance
:
{ before(grammarAccess.getStructureInstanceRule()); }
	 ruleStructureInstance
{ after(grammarAccess.getStructureInstanceRule()); } 
	 EOF 
;

// Rule StructureInstance
ruleStructureInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructureInstanceAccess().getGroup()); }
		(rule__StructureInstance__Group__0)
		{ after(grammarAccess.getStructureInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNamedInstance
entryRuleNamedInstance
:
{ before(grammarAccess.getNamedInstanceRule()); }
	 ruleNamedInstance
{ after(grammarAccess.getNamedInstanceRule()); } 
	 EOF 
;

// Rule NamedInstance
ruleNamedInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNamedInstanceAccess().getAlternatives()); }
		(rule__NamedInstance__Alternatives)
		{ after(grammarAccess.getNamedInstanceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConceptInstance
entryRuleConceptInstance
:
{ before(grammarAccess.getConceptInstanceRule()); }
	 ruleConceptInstance
{ after(grammarAccess.getConceptInstanceRule()); } 
	 EOF 
;

// Rule ConceptInstance
ruleConceptInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getGroup()); }
		(rule__ConceptInstance__Group__0)
		{ after(grammarAccess.getConceptInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationInstance
entryRuleRelationInstance
:
{ before(grammarAccess.getRelationInstanceRule()); }
	 ruleRelationInstance
{ after(grammarAccess.getRelationInstanceRule()); } 
	 EOF 
;

// Rule RelationInstance
ruleRelationInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationInstanceAccess().getGroup()); }
		(rule__RelationInstance__Group__0)
		{ after(grammarAccess.getRelationInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReference
entryRuleReference
:
{ before(grammarAccess.getReferenceRule()); }
	 ruleReference
{ after(grammarAccess.getReferenceRule()); } 
	 EOF 
;

// Rule Reference
ruleReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReferenceAccess().getAlternatives()); }
		(rule__Reference__Alternatives)
		{ after(grammarAccess.getReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVocabularyMemberReference
entryRuleVocabularyMemberReference
:
{ before(grammarAccess.getVocabularyMemberReferenceRule()); }
	 ruleVocabularyMemberReference
{ after(grammarAccess.getVocabularyMemberReferenceRule()); } 
	 EOF 
;

// Rule VocabularyMemberReference
ruleVocabularyMemberReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVocabularyMemberReferenceAccess().getAlternatives()); }
		(rule__VocabularyMemberReference__Alternatives)
		{ after(grammarAccess.getVocabularyMemberReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSpecializableTermReference
entryRuleSpecializableTermReference
:
{ before(grammarAccess.getSpecializableTermReferenceRule()); }
	 ruleSpecializableTermReference
{ after(grammarAccess.getSpecializableTermReferenceRule()); } 
	 EOF 
;

// Rule SpecializableTermReference
ruleSpecializableTermReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSpecializableTermReferenceAccess().getAlternatives()); }
		(rule__SpecializableTermReference__Alternatives)
		{ after(grammarAccess.getSpecializableTermReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityReference
entryRuleEntityReference
:
{ before(grammarAccess.getEntityReferenceRule()); }
	 ruleEntityReference
{ after(grammarAccess.getEntityReferenceRule()); } 
	 EOF 
;

// Rule EntityReference
ruleEntityReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityReferenceAccess().getAlternatives()); }
		(rule__EntityReference__Alternatives)
		{ after(grammarAccess.getEntityReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAspectReference
entryRuleAspectReference
:
{ before(grammarAccess.getAspectReferenceRule()); }
	 ruleAspectReference
{ after(grammarAccess.getAspectReferenceRule()); } 
	 EOF 
;

// Rule AspectReference
ruleAspectReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAspectReferenceAccess().getGroup()); }
		(rule__AspectReference__Group__0)
		{ after(grammarAccess.getAspectReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConceptReference
entryRuleConceptReference
:
{ before(grammarAccess.getConceptReferenceRule()); }
	 ruleConceptReference
{ after(grammarAccess.getConceptReferenceRule()); } 
	 EOF 
;

// Rule ConceptReference
ruleConceptReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptReferenceAccess().getGroup()); }
		(rule__ConceptReference__Group__0)
		{ after(grammarAccess.getConceptReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationEntityReference
entryRuleRelationEntityReference
:
{ before(grammarAccess.getRelationEntityReferenceRule()); }
	 ruleRelationEntityReference
{ after(grammarAccess.getRelationEntityReferenceRule()); } 
	 EOF 
;

// Rule RelationEntityReference
ruleRelationEntityReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationEntityReferenceAccess().getGroup()); }
		(rule__RelationEntityReference__Group__0)
		{ after(grammarAccess.getRelationEntityReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructureReference
entryRuleStructureReference
:
{ before(grammarAccess.getStructureReferenceRule()); }
	 ruleStructureReference
{ after(grammarAccess.getStructureReferenceRule()); } 
	 EOF 
;

// Rule StructureReference
ruleStructureReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructureReferenceAccess().getGroup()); }
		(rule__StructureReference__Group__0)
		{ after(grammarAccess.getStructureReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnnotationPropertyReference
entryRuleAnnotationPropertyReference
:
{ before(grammarAccess.getAnnotationPropertyReferenceRule()); }
	 ruleAnnotationPropertyReference
{ after(grammarAccess.getAnnotationPropertyReferenceRule()); } 
	 EOF 
;

// Rule AnnotationPropertyReference
ruleAnnotationPropertyReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getGroup()); }
		(rule__AnnotationPropertyReference__Group__0)
		{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarPropertyReference
entryRuleScalarPropertyReference
:
{ before(grammarAccess.getScalarPropertyReferenceRule()); }
	 ruleScalarPropertyReference
{ after(grammarAccess.getScalarPropertyReferenceRule()); } 
	 EOF 
;

// Rule ScalarPropertyReference
ruleScalarPropertyReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarPropertyReferenceAccess().getGroup()); }
		(rule__ScalarPropertyReference__Group__0)
		{ after(grammarAccess.getScalarPropertyReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructuredPropertyReference
entryRuleStructuredPropertyReference
:
{ before(grammarAccess.getStructuredPropertyReferenceRule()); }
	 ruleStructuredPropertyReference
{ after(grammarAccess.getStructuredPropertyReferenceRule()); } 
	 EOF 
;

// Rule StructuredPropertyReference
ruleStructuredPropertyReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructuredPropertyReferenceAccess().getGroup()); }
		(rule__StructuredPropertyReference__Group__0)
		{ after(grammarAccess.getStructuredPropertyReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFacetedScalarReference
entryRuleFacetedScalarReference
:
{ before(grammarAccess.getFacetedScalarReferenceRule()); }
	 ruleFacetedScalarReference
{ after(grammarAccess.getFacetedScalarReferenceRule()); } 
	 EOF 
;

// Rule FacetedScalarReference
ruleFacetedScalarReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFacetedScalarReferenceAccess().getGroup()); }
		(rule__FacetedScalarReference__Group__0)
		{ after(grammarAccess.getFacetedScalarReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEnumeratedScalarReference
entryRuleEnumeratedScalarReference
:
{ before(grammarAccess.getEnumeratedScalarReferenceRule()); }
	 ruleEnumeratedScalarReference
{ after(grammarAccess.getEnumeratedScalarReferenceRule()); } 
	 EOF 
;

// Rule EnumeratedScalarReference
ruleEnumeratedScalarReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getGroup()); }
		(rule__EnumeratedScalarReference__Group__0)
		{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationReference
entryRuleRelationReference
:
{ before(grammarAccess.getRelationReferenceRule()); }
	 ruleRelationReference
{ after(grammarAccess.getRelationReferenceRule()); } 
	 EOF 
;

// Rule RelationReference
ruleRelationReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationReferenceAccess().getGroup()); }
		(rule__RelationReference__Group__0)
		{ after(grammarAccess.getRelationReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRuleReference
entryRuleRuleReference
:
{ before(grammarAccess.getRuleReferenceRule()); }
	 ruleRuleReference
{ after(grammarAccess.getRuleReferenceRule()); } 
	 EOF 
;

// Rule RuleReference
ruleRuleReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRuleReferenceAccess().getGroup()); }
		(rule__RuleReference__Group__0)
		{ after(grammarAccess.getRuleReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDescriptionMemberReference
entryRuleDescriptionMemberReference
:
{ before(grammarAccess.getDescriptionMemberReferenceRule()); }
	 ruleDescriptionMemberReference
{ after(grammarAccess.getDescriptionMemberReferenceRule()); } 
	 EOF 
;

// Rule DescriptionMemberReference
ruleDescriptionMemberReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDescriptionMemberReferenceAccess().getNamedInstanceReferenceParserRuleCall()); }
		ruleNamedInstanceReference
		{ after(grammarAccess.getDescriptionMemberReferenceAccess().getNamedInstanceReferenceParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNamedInstanceReference
entryRuleNamedInstanceReference
:
{ before(grammarAccess.getNamedInstanceReferenceRule()); }
	 ruleNamedInstanceReference
{ after(grammarAccess.getNamedInstanceReferenceRule()); } 
	 EOF 
;

// Rule NamedInstanceReference
ruleNamedInstanceReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNamedInstanceReferenceAccess().getAlternatives()); }
		(rule__NamedInstanceReference__Alternatives)
		{ after(grammarAccess.getNamedInstanceReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConceptInstanceReference
entryRuleConceptInstanceReference
:
{ before(grammarAccess.getConceptInstanceReferenceRule()); }
	 ruleConceptInstanceReference
{ after(grammarAccess.getConceptInstanceReferenceRule()); } 
	 EOF 
;

// Rule ConceptInstanceReference
ruleConceptInstanceReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptInstanceReferenceAccess().getGroup()); }
		(rule__ConceptInstanceReference__Group__0)
		{ after(grammarAccess.getConceptInstanceReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationInstanceReference
entryRuleRelationInstanceReference
:
{ before(grammarAccess.getRelationInstanceReferenceRule()); }
	 ruleRelationInstanceReference
{ after(grammarAccess.getRelationInstanceReferenceRule()); } 
	 EOF 
;

// Rule RelationInstanceReference
ruleRelationInstanceReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationInstanceReferenceAccess().getGroup()); }
		(rule__RelationInstanceReference__Group__0)
		{ after(grammarAccess.getRelationInstanceReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStatement
entryRuleStatement
:
{ before(grammarAccess.getStatementRule()); }
	 ruleStatement
{ after(grammarAccess.getStatementRule()); } 
	 EOF 
;

// Rule Statement
ruleStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStatementAccess().getAlternatives()); }
		(rule__Statement__Alternatives)
		{ after(grammarAccess.getStatementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVocabularyStatement
entryRuleVocabularyStatement
:
{ before(grammarAccess.getVocabularyStatementRule()); }
	 ruleVocabularyStatement
{ after(grammarAccess.getVocabularyStatementRule()); } 
	 EOF 
;

// Rule VocabularyStatement
ruleVocabularyStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVocabularyStatementAccess().getAlternatives()); }
		(rule__VocabularyStatement__Alternatives)
		{ after(grammarAccess.getVocabularyStatementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDescriptionStatement
entryRuleDescriptionStatement
:
{ before(grammarAccess.getDescriptionStatementRule()); }
	 ruleDescriptionStatement
{ after(grammarAccess.getDescriptionStatementRule()); } 
	 EOF 
;

// Rule DescriptionStatement
ruleDescriptionStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDescriptionStatementAccess().getAlternatives()); }
		(rule__DescriptionStatement__Alternatives)
		{ after(grammarAccess.getDescriptionStatementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleImport
entryRuleImport
:
{ before(grammarAccess.getImportRule()); }
	 ruleImport
{ after(grammarAccess.getImportRule()); } 
	 EOF 
;

// Rule Import
ruleImport 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getImportAccess().getAlternatives()); }
		(rule__Import__Alternatives)
		{ after(grammarAccess.getImportAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVocabularyImport
entryRuleVocabularyImport
:
{ before(grammarAccess.getVocabularyImportRule()); }
	 ruleVocabularyImport
{ after(grammarAccess.getVocabularyImportRule()); } 
	 EOF 
;

// Rule VocabularyImport
ruleVocabularyImport 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVocabularyImportAccess().getAlternatives()); }
		(rule__VocabularyImport__Alternatives)
		{ after(grammarAccess.getVocabularyImportAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVocabularyExtension
entryRuleVocabularyExtension
:
{ before(grammarAccess.getVocabularyExtensionRule()); }
	 ruleVocabularyExtension
{ after(grammarAccess.getVocabularyExtensionRule()); } 
	 EOF 
;

// Rule VocabularyExtension
ruleVocabularyExtension 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVocabularyExtensionAccess().getGroup()); }
		(rule__VocabularyExtension__Group__0)
		{ after(grammarAccess.getVocabularyExtensionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVocabularyUsage
entryRuleVocabularyUsage
:
{ before(grammarAccess.getVocabularyUsageRule()); }
	 ruleVocabularyUsage
{ after(grammarAccess.getVocabularyUsageRule()); } 
	 EOF 
;

// Rule VocabularyUsage
ruleVocabularyUsage 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVocabularyUsageAccess().getGroup()); }
		(rule__VocabularyUsage__Group__0)
		{ after(grammarAccess.getVocabularyUsageAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBundleImport
entryRuleBundleImport
:
{ before(grammarAccess.getBundleImportRule()); }
	 ruleBundleImport
{ after(grammarAccess.getBundleImportRule()); } 
	 EOF 
;

// Rule BundleImport
ruleBundleImport 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBundleImportAccess().getAlternatives()); }
		(rule__BundleImport__Alternatives)
		{ after(grammarAccess.getBundleImportAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBundleInclusion
entryRuleBundleInclusion
:
{ before(grammarAccess.getBundleInclusionRule()); }
	 ruleBundleInclusion
{ after(grammarAccess.getBundleInclusionRule()); } 
	 EOF 
;

// Rule BundleInclusion
ruleBundleInclusion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBundleInclusionAccess().getGroup()); }
		(rule__BundleInclusion__Group__0)
		{ after(grammarAccess.getBundleInclusionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBundleExtension
entryRuleBundleExtension
:
{ before(grammarAccess.getBundleExtensionRule()); }
	 ruleBundleExtension
{ after(grammarAccess.getBundleExtensionRule()); } 
	 EOF 
;

// Rule BundleExtension
ruleBundleExtension 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBundleExtensionAccess().getGroup()); }
		(rule__BundleExtension__Group__0)
		{ after(grammarAccess.getBundleExtensionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDescriptionImport
entryRuleDescriptionImport
:
{ before(grammarAccess.getDescriptionImportRule()); }
	 ruleDescriptionImport
{ after(grammarAccess.getDescriptionImportRule()); } 
	 EOF 
;

// Rule DescriptionImport
ruleDescriptionImport 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDescriptionImportAccess().getAlternatives()); }
		(rule__DescriptionImport__Alternatives)
		{ after(grammarAccess.getDescriptionImportAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDescriptionUsage
entryRuleDescriptionUsage
:
{ before(grammarAccess.getDescriptionUsageRule()); }
	 ruleDescriptionUsage
{ after(grammarAccess.getDescriptionUsageRule()); } 
	 EOF 
;

// Rule DescriptionUsage
ruleDescriptionUsage 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDescriptionUsageAccess().getGroup()); }
		(rule__DescriptionUsage__Group__0)
		{ after(grammarAccess.getDescriptionUsageAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDescriptionExtension
entryRuleDescriptionExtension
:
{ before(grammarAccess.getDescriptionExtensionRule()); }
	 ruleDescriptionExtension
{ after(grammarAccess.getDescriptionExtensionRule()); } 
	 EOF 
;

// Rule DescriptionExtension
ruleDescriptionExtension 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDescriptionExtensionAccess().getGroup()); }
		(rule__DescriptionExtension__Group__0)
		{ after(grammarAccess.getDescriptionExtensionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAxiom
entryRuleAxiom
:
{ before(grammarAccess.getAxiomRule()); }
	 ruleAxiom
{ after(grammarAccess.getAxiomRule()); } 
	 EOF 
;

// Rule Axiom
ruleAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAxiomAccess().getAlternatives()); }
		(rule__Axiom__Alternatives)
		{ after(grammarAccess.getAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSpecializationAxiom
entryRuleSpecializationAxiom
:
{ before(grammarAccess.getSpecializationAxiomRule()); }
	 ruleSpecializationAxiom
{ after(grammarAccess.getSpecializationAxiomRule()); } 
	 EOF 
;

// Rule SpecializationAxiom
ruleSpecializationAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSpecializationAxiomAccess().getGroup()); }
		(rule__SpecializationAxiom__Group__0)
		{ after(grammarAccess.getSpecializationAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRestrictionAxiom
entryRuleRestrictionAxiom
:
{ before(grammarAccess.getRestrictionAxiomRule()); }
	 ruleRestrictionAxiom
{ after(grammarAccess.getRestrictionAxiomRule()); } 
	 EOF 
;

// Rule RestrictionAxiom
ruleRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRestrictionAxiomAccess().getAlternatives()); }
		(rule__RestrictionAxiom__Alternatives)
		{ after(grammarAccess.getRestrictionAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePropertyRestrictionAxiom
entryRulePropertyRestrictionAxiom
:
{ before(grammarAccess.getPropertyRestrictionAxiomRule()); }
	 rulePropertyRestrictionAxiom
{ after(grammarAccess.getPropertyRestrictionAxiomRule()); } 
	 EOF 
;

// Rule PropertyRestrictionAxiom
rulePropertyRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPropertyRestrictionAxiomAccess().getAlternatives()); }
		(rule__PropertyRestrictionAxiom__Alternatives)
		{ after(grammarAccess.getPropertyRestrictionAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarPropertyRestrictionAxiom
entryRuleScalarPropertyRestrictionAxiom
:
{ before(grammarAccess.getScalarPropertyRestrictionAxiomRule()); }
	 ruleScalarPropertyRestrictionAxiom
{ after(grammarAccess.getScalarPropertyRestrictionAxiomRule()); } 
	 EOF 
;

// Rule ScalarPropertyRestrictionAxiom
ruleScalarPropertyRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarPropertyRestrictionAxiomAccess().getAlternatives()); }
		(rule__ScalarPropertyRestrictionAxiom__Alternatives)
		{ after(grammarAccess.getScalarPropertyRestrictionAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarPropertyRangeRestrictionAxiom
entryRuleScalarPropertyRangeRestrictionAxiom
:
{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomRule()); }
	 ruleScalarPropertyRangeRestrictionAxiom
{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomRule()); } 
	 EOF 
;

// Rule ScalarPropertyRangeRestrictionAxiom
ruleScalarPropertyRangeRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getGroup()); }
		(rule__ScalarPropertyRangeRestrictionAxiom__Group__0)
		{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarPropertyCardinalityRestrictionAxiom
entryRuleScalarPropertyCardinalityRestrictionAxiom
:
{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomRule()); }
	 ruleScalarPropertyCardinalityRestrictionAxiom
{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomRule()); } 
	 EOF 
;

// Rule ScalarPropertyCardinalityRestrictionAxiom
ruleScalarPropertyCardinalityRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getGroup()); }
		(rule__ScalarPropertyCardinalityRestrictionAxiom__Group__0)
		{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarPropertyValueRestrictionAxiom
entryRuleScalarPropertyValueRestrictionAxiom
:
{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomRule()); }
	 ruleScalarPropertyValueRestrictionAxiom
{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomRule()); } 
	 EOF 
;

// Rule ScalarPropertyValueRestrictionAxiom
ruleScalarPropertyValueRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getGroup()); }
		(rule__ScalarPropertyValueRestrictionAxiom__Group__0)
		{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructuredPropertyRestrictionAxiom
entryRuleStructuredPropertyRestrictionAxiom
:
{ before(grammarAccess.getStructuredPropertyRestrictionAxiomRule()); }
	 ruleStructuredPropertyRestrictionAxiom
{ after(grammarAccess.getStructuredPropertyRestrictionAxiomRule()); } 
	 EOF 
;

// Rule StructuredPropertyRestrictionAxiom
ruleStructuredPropertyRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructuredPropertyRestrictionAxiomAccess().getAlternatives()); }
		(rule__StructuredPropertyRestrictionAxiom__Alternatives)
		{ after(grammarAccess.getStructuredPropertyRestrictionAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructuredPropertyRangeRestrictionAxiom
entryRuleStructuredPropertyRangeRestrictionAxiom
:
{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomRule()); }
	 ruleStructuredPropertyRangeRestrictionAxiom
{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomRule()); } 
	 EOF 
;

// Rule StructuredPropertyRangeRestrictionAxiom
ruleStructuredPropertyRangeRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getGroup()); }
		(rule__StructuredPropertyRangeRestrictionAxiom__Group__0)
		{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructuredPropertyCardinalityRestrictionAxiom
entryRuleStructuredPropertyCardinalityRestrictionAxiom
:
{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomRule()); }
	 ruleStructuredPropertyCardinalityRestrictionAxiom
{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomRule()); } 
	 EOF 
;

// Rule StructuredPropertyCardinalityRestrictionAxiom
ruleStructuredPropertyCardinalityRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getGroup()); }
		(rule__StructuredPropertyCardinalityRestrictionAxiom__Group__0)
		{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructuredPropertyValueRestrictionAxiom
entryRuleStructuredPropertyValueRestrictionAxiom
:
{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomRule()); }
	 ruleStructuredPropertyValueRestrictionAxiom
{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomRule()); } 
	 EOF 
;

// Rule StructuredPropertyValueRestrictionAxiom
ruleStructuredPropertyValueRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getGroup()); }
		(rule__StructuredPropertyValueRestrictionAxiom__Group__0)
		{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationRestrictionAxiom
entryRuleRelationRestrictionAxiom
:
{ before(grammarAccess.getRelationRestrictionAxiomRule()); }
	 ruleRelationRestrictionAxiom
{ after(grammarAccess.getRelationRestrictionAxiomRule()); } 
	 EOF 
;

// Rule RelationRestrictionAxiom
ruleRelationRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationRestrictionAxiomAccess().getAlternatives()); }
		(rule__RelationRestrictionAxiom__Alternatives)
		{ after(grammarAccess.getRelationRestrictionAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationRangeRestrictionAxiom
entryRuleRelationRangeRestrictionAxiom
:
{ before(grammarAccess.getRelationRangeRestrictionAxiomRule()); }
	 ruleRelationRangeRestrictionAxiom
{ after(grammarAccess.getRelationRangeRestrictionAxiomRule()); } 
	 EOF 
;

// Rule RelationRangeRestrictionAxiom
ruleRelationRangeRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getGroup()); }
		(rule__RelationRangeRestrictionAxiom__Group__0)
		{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationCardinalityRestrictionAxiom
entryRuleRelationCardinalityRestrictionAxiom
:
{ before(grammarAccess.getRelationCardinalityRestrictionAxiomRule()); }
	 ruleRelationCardinalityRestrictionAxiom
{ after(grammarAccess.getRelationCardinalityRestrictionAxiomRule()); } 
	 EOF 
;

// Rule RelationCardinalityRestrictionAxiom
ruleRelationCardinalityRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getGroup()); }
		(rule__RelationCardinalityRestrictionAxiom__Group__0)
		{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationTargetRestrictionAxiom
entryRuleRelationTargetRestrictionAxiom
:
{ before(grammarAccess.getRelationTargetRestrictionAxiomRule()); }
	 ruleRelationTargetRestrictionAxiom
{ after(grammarAccess.getRelationTargetRestrictionAxiomRule()); } 
	 EOF 
;

// Rule RelationTargetRestrictionAxiom
ruleRelationTargetRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getGroup()); }
		(rule__RelationTargetRestrictionAxiom__Group__0)
		{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleKeyAxiom
entryRuleKeyAxiom
:
{ before(grammarAccess.getKeyAxiomRule()); }
	 ruleKeyAxiom
{ after(grammarAccess.getKeyAxiomRule()); } 
	 EOF 
;

// Rule KeyAxiom
ruleKeyAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getKeyAxiomAccess().getGroup()); }
		(rule__KeyAxiom__Group__0)
		{ after(grammarAccess.getKeyAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAssertion
entryRuleAssertion
:
{ before(grammarAccess.getAssertionRule()); }
	 ruleAssertion
{ after(grammarAccess.getAssertionRule()); } 
	 EOF 
;

// Rule Assertion
ruleAssertion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssertionAccess().getAlternatives()); }
		(rule__Assertion__Alternatives)
		{ after(grammarAccess.getAssertionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTypeAssertion
entryRuleTypeAssertion
:
{ before(grammarAccess.getTypeAssertionRule()); }
	 ruleTypeAssertion
{ after(grammarAccess.getTypeAssertionRule()); } 
	 EOF 
;

// Rule TypeAssertion
ruleTypeAssertion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeAssertionAccess().getAlternatives()); }
		(rule__TypeAssertion__Alternatives)
		{ after(grammarAccess.getTypeAssertionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConceptTypeAssertion
entryRuleConceptTypeAssertion
:
{ before(grammarAccess.getConceptTypeAssertionRule()); }
	 ruleConceptTypeAssertion
{ after(grammarAccess.getConceptTypeAssertionRule()); } 
	 EOF 
;

// Rule ConceptTypeAssertion
ruleConceptTypeAssertion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptTypeAssertionAccess().getGroup()); }
		(rule__ConceptTypeAssertion__Group__0)
		{ after(grammarAccess.getConceptTypeAssertionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationTypeAssertion
entryRuleRelationTypeAssertion
:
{ before(grammarAccess.getRelationTypeAssertionRule()); }
	 ruleRelationTypeAssertion
{ after(grammarAccess.getRelationTypeAssertionRule()); } 
	 EOF 
;

// Rule RelationTypeAssertion
ruleRelationTypeAssertion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationTypeAssertionAccess().getGroup()); }
		(rule__RelationTypeAssertion__Group__0)
		{ after(grammarAccess.getRelationTypeAssertionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePropertyValueAssertion
entryRulePropertyValueAssertion
:
{ before(grammarAccess.getPropertyValueAssertionRule()); }
	 rulePropertyValueAssertion
{ after(grammarAccess.getPropertyValueAssertionRule()); } 
	 EOF 
;

// Rule PropertyValueAssertion
rulePropertyValueAssertion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPropertyValueAssertionAccess().getAlternatives()); }
		(rule__PropertyValueAssertion__Alternatives)
		{ after(grammarAccess.getPropertyValueAssertionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarPropertyValueAssertion
entryRuleScalarPropertyValueAssertion
:
{ before(grammarAccess.getScalarPropertyValueAssertionRule()); }
	 ruleScalarPropertyValueAssertion
{ after(grammarAccess.getScalarPropertyValueAssertionRule()); } 
	 EOF 
;

// Rule ScalarPropertyValueAssertion
ruleScalarPropertyValueAssertion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarPropertyValueAssertionAccess().getGroup()); }
		(rule__ScalarPropertyValueAssertion__Group__0)
		{ after(grammarAccess.getScalarPropertyValueAssertionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructuredPropertyValueAssertion
entryRuleStructuredPropertyValueAssertion
:
{ before(grammarAccess.getStructuredPropertyValueAssertionRule()); }
	 ruleStructuredPropertyValueAssertion
{ after(grammarAccess.getStructuredPropertyValueAssertionRule()); } 
	 EOF 
;

// Rule StructuredPropertyValueAssertion
ruleStructuredPropertyValueAssertion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructuredPropertyValueAssertionAccess().getGroup()); }
		(rule__StructuredPropertyValueAssertion__Group__0)
		{ after(grammarAccess.getStructuredPropertyValueAssertionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLinkAssertion
entryRuleLinkAssertion
:
{ before(grammarAccess.getLinkAssertionRule()); }
	 ruleLinkAssertion
{ after(grammarAccess.getLinkAssertionRule()); } 
	 EOF 
;

// Rule LinkAssertion
ruleLinkAssertion 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLinkAssertionAccess().getGroup()); }
		(rule__LinkAssertion__Group__0)
		{ after(grammarAccess.getLinkAssertionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePredicate
entryRulePredicate
:
{ before(grammarAccess.getPredicateRule()); }
	 rulePredicate
{ after(grammarAccess.getPredicateRule()); } 
	 EOF 
;

// Rule Predicate
rulePredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPredicateAccess().getAlternatives()); }
		(rule__Predicate__Alternatives)
		{ after(grammarAccess.getPredicateAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUnaryPredicate
entryRuleUnaryPredicate
:
{ before(grammarAccess.getUnaryPredicateRule()); }
	 ruleUnaryPredicate
{ after(grammarAccess.getUnaryPredicateRule()); } 
	 EOF 
;

// Rule UnaryPredicate
ruleUnaryPredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUnaryPredicateAccess().getEntityPredicateParserRuleCall()); }
		ruleEntityPredicate
		{ after(grammarAccess.getUnaryPredicateAccess().getEntityPredicateParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityPredicate
entryRuleEntityPredicate
:
{ before(grammarAccess.getEntityPredicateRule()); }
	 ruleEntityPredicate
{ after(grammarAccess.getEntityPredicateRule()); } 
	 EOF 
;

// Rule EntityPredicate
ruleEntityPredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityPredicateAccess().getGroup()); }
		(rule__EntityPredicate__Group__0)
		{ after(grammarAccess.getEntityPredicateAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBinaryPredicate
entryRuleBinaryPredicate
:
{ before(grammarAccess.getBinaryPredicateRule()); }
	 ruleBinaryPredicate
{ after(grammarAccess.getBinaryPredicateRule()); } 
	 EOF 
;

// Rule BinaryPredicate
ruleBinaryPredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBinaryPredicateAccess().getAlternatives()); }
		(rule__BinaryPredicate__Alternatives)
		{ after(grammarAccess.getBinaryPredicateAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationPredicate
entryRuleRelationPredicate
:
{ before(grammarAccess.getRelationPredicateRule()); }
	 ruleRelationPredicate
{ after(grammarAccess.getRelationPredicateRule()); } 
	 EOF 
;

// Rule RelationPredicate
ruleRelationPredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationPredicateAccess().getGroup()); }
		(rule__RelationPredicate__Group__0)
		{ after(grammarAccess.getRelationPredicateAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSameAsPredicate
entryRuleSameAsPredicate
:
{ before(grammarAccess.getSameAsPredicateRule()); }
	 ruleSameAsPredicate
{ after(grammarAccess.getSameAsPredicateRule()); } 
	 EOF 
;

// Rule SameAsPredicate
ruleSameAsPredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSameAsPredicateAccess().getGroup()); }
		(rule__SameAsPredicate__Group__0)
		{ after(grammarAccess.getSameAsPredicateAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDifferentFromPredicate
entryRuleDifferentFromPredicate
:
{ before(grammarAccess.getDifferentFromPredicateRule()); }
	 ruleDifferentFromPredicate
{ after(grammarAccess.getDifferentFromPredicateRule()); } 
	 EOF 
;

// Rule DifferentFromPredicate
ruleDifferentFromPredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDifferentFromPredicateAccess().getGroup()); }
		(rule__DifferentFromPredicate__Group__0)
		{ after(grammarAccess.getDifferentFromPredicateAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationEntityPredicate
entryRuleRelationEntityPredicate
:
{ before(grammarAccess.getRelationEntityPredicateRule()); }
	 ruleRelationEntityPredicate
{ after(grammarAccess.getRelationEntityPredicateRule()); } 
	 EOF 
;

// Rule RelationEntityPredicate
ruleRelationEntityPredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationEntityPredicateAccess().getGroup()); }
		(rule__RelationEntityPredicate__Group__0)
		{ after(grammarAccess.getRelationEntityPredicateAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteral
entryRuleLiteral
:
{ before(grammarAccess.getLiteralRule()); }
	 ruleLiteral
{ after(grammarAccess.getLiteralRule()); } 
	 EOF 
;

// Rule Literal
ruleLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralAccess().getAlternatives()); }
		(rule__Literal__Alternatives)
		{ after(grammarAccess.getLiteralAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIntegerLiteral
entryRuleIntegerLiteral
:
{ before(grammarAccess.getIntegerLiteralRule()); }
	 ruleIntegerLiteral
{ after(grammarAccess.getIntegerLiteralRule()); } 
	 EOF 
;

// Rule IntegerLiteral
ruleIntegerLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIntegerLiteralAccess().getGroup()); }
		(rule__IntegerLiteral__Group__0)
		{ after(grammarAccess.getIntegerLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDecimalLiteral
entryRuleDecimalLiteral
:
{ before(grammarAccess.getDecimalLiteralRule()); }
	 ruleDecimalLiteral
{ after(grammarAccess.getDecimalLiteralRule()); } 
	 EOF 
;

// Rule DecimalLiteral
ruleDecimalLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDecimalLiteralAccess().getGroup()); }
		(rule__DecimalLiteral__Group__0)
		{ after(grammarAccess.getDecimalLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDoubleLiteral
entryRuleDoubleLiteral
:
{ before(grammarAccess.getDoubleLiteralRule()); }
	 ruleDoubleLiteral
{ after(grammarAccess.getDoubleLiteralRule()); } 
	 EOF 
;

// Rule DoubleLiteral
ruleDoubleLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDoubleLiteralAccess().getGroup()); }
		(rule__DoubleLiteral__Group__0)
		{ after(grammarAccess.getDoubleLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral
:
{ before(grammarAccess.getBooleanLiteralRule()); }
	 ruleBooleanLiteral
{ after(grammarAccess.getBooleanLiteralRule()); } 
	 EOF 
;

// Rule BooleanLiteral
ruleBooleanLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getGroup()); }
		(rule__BooleanLiteral__Group__0)
		{ after(grammarAccess.getBooleanLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQuotedLiteral
entryRuleQuotedLiteral
:
{ before(grammarAccess.getQuotedLiteralRule()); }
	 ruleQuotedLiteral
{ after(grammarAccess.getQuotedLiteralRule()); } 
	 EOF 
;

// Rule QuotedLiteral
ruleQuotedLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQuotedLiteralAccess().getGroup()); }
		(rule__QuotedLiteral__Group__0)
		{ after(grammarAccess.getQuotedLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRef
entryRuleRef
:
{ before(grammarAccess.getRefRule()); }
	 ruleRef
{ after(grammarAccess.getRefRule()); } 
	 EOF 
;

// Rule Ref
ruleRef 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRefAccess().getAlternatives()); }
		(rule__Ref__Alternatives)
		{ after(grammarAccess.getRefAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBoolean
entryRuleBoolean
:
{ before(grammarAccess.getBooleanRule()); }
	 ruleBoolean
{ after(grammarAccess.getBooleanRule()); } 
	 EOF 
;

// Rule Boolean
ruleBoolean 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBooleanAccess().getBOOLEAN_STRTerminalRuleCall()); }
		RULE_BOOLEAN_STR
		{ after(grammarAccess.getBooleanAccess().getBOOLEAN_STRTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUnsignedInteger
entryRuleUnsignedInteger
:
{ before(grammarAccess.getUnsignedIntegerRule()); }
	 ruleUnsignedInteger
{ after(grammarAccess.getUnsignedIntegerRule()); } 
	 EOF 
;

// Rule UnsignedInteger
ruleUnsignedInteger 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUnsignedIntegerAccess().getUNSIGNED_INTEGER_STRTerminalRuleCall()); }
		RULE_UNSIGNED_INTEGER_STR
		{ after(grammarAccess.getUnsignedIntegerAccess().getUNSIGNED_INTEGER_STRTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInteger
entryRuleInteger
:
{ before(grammarAccess.getIntegerRule()); }
	 ruleInteger
{ after(grammarAccess.getIntegerRule()); } 
	 EOF 
;

// Rule Integer
ruleInteger 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIntegerAccess().getAlternatives()); }
		(rule__Integer__Alternatives)
		{ after(grammarAccess.getIntegerAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDecimal
entryRuleDecimal
:
{ before(grammarAccess.getDecimalRule()); }
	 ruleDecimal
{ after(grammarAccess.getDecimalRule()); } 
	 EOF 
;

// Rule Decimal
ruleDecimal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDecimalAccess().getDECIMAL_STRTerminalRuleCall()); }
		RULE_DECIMAL_STR
		{ after(grammarAccess.getDecimalAccess().getDECIMAL_STRTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDouble
entryRuleDouble
:
{ before(grammarAccess.getDoubleRule()); }
	 ruleDouble
{ after(grammarAccess.getDoubleRule()); } 
	 EOF 
;

// Rule Double
ruleDouble 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDoubleAccess().getDOUBLE_STRTerminalRuleCall()); }
		RULE_DOUBLE_STR
		{ after(grammarAccess.getDoubleAccess().getDOUBLE_STRTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule SeparatorKind
ruleSeparatorKind
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSeparatorKindAccess().getAlternatives()); }
		(rule__SeparatorKind__Alternatives)
		{ after(grammarAccess.getSeparatorKindAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule RangeRestrictionKind
ruleRangeRestrictionKind
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRangeRestrictionKindAccess().getAlternatives()); }
		(rule__RangeRestrictionKind__Alternatives)
		{ after(grammarAccess.getRangeRestrictionKindAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule CardinalityRestrictionKind
ruleCardinalityRestrictionKind
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictionKindAccess().getAlternatives()); }
		(rule__CardinalityRestrictionKind__Alternatives)
		{ after(grammarAccess.getCardinalityRestrictionKindAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Ontology__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOntologyAccess().getTerminologyParserRuleCall_0()); }
		ruleTerminology
		{ after(grammarAccess.getOntologyAccess().getTerminologyParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getOntologyAccess().getDescriptionParserRuleCall_1()); }
		ruleDescription
		{ after(grammarAccess.getOntologyAccess().getDescriptionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotatedElement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotatedElementAccess().getIdentifiedElementParserRuleCall_0()); }
		(ruleIdentifiedElement)
		{ after(grammarAccess.getAnnotatedElementAccess().getIdentifiedElementParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotatedElementAccess().getInstanceParserRuleCall_1()); }
		(ruleInstance)
		{ after(grammarAccess.getAnnotatedElementAccess().getInstanceParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotatedElementAccess().getImportParserRuleCall_2()); }
		(ruleImport)
		{ after(grammarAccess.getAnnotatedElementAccess().getImportParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotatedElementAccess().getAxiomParserRuleCall_3()); }
		(ruleAxiom)
		{ after(grammarAccess.getAnnotatedElementAccess().getAxiomParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotatedElementAccess().getAssertionParserRuleCall_4()); }
		(ruleAssertion)
		{ after(grammarAccess.getAnnotatedElementAccess().getAssertionParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotatedElementAccess().getPredicateParserRuleCall_5()); }
		(rulePredicate)
		{ after(grammarAccess.getAnnotatedElementAccess().getPredicateParserRuleCall_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifiedElement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIdentifiedElementAccess().getOntologyParserRuleCall_0()); }
		ruleOntology
		{ after(grammarAccess.getIdentifiedElementAccess().getOntologyParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getIdentifiedElementAccess().getMemberParserRuleCall_1()); }
		ruleMember
		{ after(grammarAccess.getIdentifiedElementAccess().getMemberParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Terminology__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyAccess().getVocabularyParserRuleCall_0()); }
		ruleVocabulary
		{ after(grammarAccess.getTerminologyAccess().getVocabularyParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminologyAccess().getBundleParserRuleCall_1()); }
		ruleBundle
		{ after(grammarAccess.getTerminologyAccess().getBundleParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTermParserRuleCall_0()); }
		ruleTerm
		{ after(grammarAccess.getMemberAccess().getTermParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getRuleParserRuleCall_1()); }
		ruleRule
		{ after(grammarAccess.getMemberAccess().getRuleParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getNamedInstanceParserRuleCall_2()); }
		ruleNamedInstance
		{ after(grammarAccess.getMemberAccess().getNamedInstanceParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Term__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTermAccess().getSpecializableTermParserRuleCall_0()); }
		ruleSpecializableTerm
		{ after(grammarAccess.getTermAccess().getSpecializableTermParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTermAccess().getRelationParserRuleCall_1()); }
		ruleRelation
		{ after(grammarAccess.getTermAccess().getRelationParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecializableTerm__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSpecializableTermAccess().getTypeParserRuleCall_0()); }
		ruleType
		{ after(grammarAccess.getSpecializableTermAccess().getTypeParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getSpecializableTermAccess().getPropertyParserRuleCall_1()); }
		ruleProperty
		{ after(grammarAccess.getSpecializableTermAccess().getPropertyParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getClassifierParserRuleCall_0()); }
		ruleClassifier
		{ after(grammarAccess.getTypeAccess().getClassifierParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTypeAccess().getScalarParserRuleCall_1()); }
		ruleScalar
		{ after(grammarAccess.getTypeAccess().getScalarParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Classifier__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClassifierAccess().getEntityParserRuleCall_0()); }
		ruleEntity
		{ after(grammarAccess.getClassifierAccess().getEntityParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getClassifierAccess().getStructureParserRuleCall_1()); }
		ruleStructure
		{ after(grammarAccess.getClassifierAccess().getStructureParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Entity__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityAccess().getAspectParserRuleCall_0()); }
		ruleAspect
		{ after(grammarAccess.getEntityAccess().getAspectParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getEntityAccess().getConceptParserRuleCall_1()); }
		ruleConcept
		{ after(grammarAccess.getEntityAccess().getConceptParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getEntityAccess().getRelationEntityParserRuleCall_2()); }
		ruleRelationEntity
		{ after(grammarAccess.getEntityAccess().getRelationEntityParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Property__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPropertyAccess().getAnnotationPropertyParserRuleCall_0()); }
		ruleAnnotationProperty
		{ after(grammarAccess.getPropertyAccess().getAnnotationPropertyParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyAccess().getFeaturePropertyParserRuleCall_1()); }
		ruleFeatureProperty
		{ after(grammarAccess.getPropertyAccess().getFeaturePropertyParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureProperty__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFeaturePropertyAccess().getScalarPropertyParserRuleCall_0()); }
		ruleScalarProperty
		{ after(grammarAccess.getFeaturePropertyAccess().getScalarPropertyParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getFeaturePropertyAccess().getStructuredPropertyParserRuleCall_1()); }
		ruleStructuredProperty
		{ after(grammarAccess.getFeaturePropertyAccess().getStructuredPropertyParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scalar__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarAccess().getFacetedScalarParserRuleCall_0()); }
		ruleFacetedScalar
		{ after(grammarAccess.getScalarAccess().getFacetedScalarParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getScalarAccess().getEnumeratedScalarParserRuleCall_1()); }
		ruleEnumeratedScalar
		{ after(grammarAccess.getScalarAccess().getEnumeratedScalarParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Relation__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationAccess().getForwardRelationParserRuleCall_0()); }
		ruleForwardRelation
		{ after(grammarAccess.getRelationAccess().getForwardRelationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getRelationAccess().getInverseRelationParserRuleCall_1()); }
		ruleInverseRelation
		{ after(grammarAccess.getRelationAccess().getInverseRelationParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Instance__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInstanceAccess().getNamedInstanceParserRuleCall_0()); }
		ruleNamedInstance
		{ after(grammarAccess.getInstanceAccess().getNamedInstanceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getInstanceAccess().getStructureInstanceParserRuleCall_1()); }
		ruleStructureInstance
		{ after(grammarAccess.getInstanceAccess().getStructureInstanceParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedInstance__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNamedInstanceAccess().getConceptInstanceParserRuleCall_0()); }
		ruleConceptInstance
		{ after(grammarAccess.getNamedInstanceAccess().getConceptInstanceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getNamedInstanceAccess().getRelationInstanceParserRuleCall_1()); }
		ruleRelationInstance
		{ after(grammarAccess.getNamedInstanceAccess().getRelationInstanceParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReferenceAccess().getVocabularyMemberReferenceParserRuleCall_0()); }
		ruleVocabularyMemberReference
		{ after(grammarAccess.getReferenceAccess().getVocabularyMemberReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getReferenceAccess().getDescriptionMemberReferenceParserRuleCall_1()); }
		ruleDescriptionMemberReference
		{ after(grammarAccess.getReferenceAccess().getDescriptionMemberReferenceParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyMemberReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyMemberReferenceAccess().getSpecializableTermReferenceParserRuleCall_0()); }
		ruleSpecializableTermReference
		{ after(grammarAccess.getVocabularyMemberReferenceAccess().getSpecializableTermReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getVocabularyMemberReferenceAccess().getRelationReferenceParserRuleCall_1()); }
		ruleRelationReference
		{ after(grammarAccess.getVocabularyMemberReferenceAccess().getRelationReferenceParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getVocabularyMemberReferenceAccess().getRuleReferenceParserRuleCall_2()); }
		ruleRuleReference
		{ after(grammarAccess.getVocabularyMemberReferenceAccess().getRuleReferenceParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecializableTermReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSpecializableTermReferenceAccess().getEntityReferenceParserRuleCall_0()); }
		ruleEntityReference
		{ after(grammarAccess.getSpecializableTermReferenceAccess().getEntityReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getSpecializableTermReferenceAccess().getStructureReferenceParserRuleCall_1()); }
		ruleStructureReference
		{ after(grammarAccess.getSpecializableTermReferenceAccess().getStructureReferenceParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getSpecializableTermReferenceAccess().getAnnotationPropertyReferenceParserRuleCall_2()); }
		ruleAnnotationPropertyReference
		{ after(grammarAccess.getSpecializableTermReferenceAccess().getAnnotationPropertyReferenceParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getSpecializableTermReferenceAccess().getScalarPropertyReferenceParserRuleCall_3()); }
		ruleScalarPropertyReference
		{ after(grammarAccess.getSpecializableTermReferenceAccess().getScalarPropertyReferenceParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getSpecializableTermReferenceAccess().getStructuredPropertyReferenceParserRuleCall_4()); }
		ruleStructuredPropertyReference
		{ after(grammarAccess.getSpecializableTermReferenceAccess().getStructuredPropertyReferenceParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getSpecializableTermReferenceAccess().getFacetedScalarReferenceParserRuleCall_5()); }
		ruleFacetedScalarReference
		{ after(grammarAccess.getSpecializableTermReferenceAccess().getFacetedScalarReferenceParserRuleCall_5()); }
	)
	|
	(
		{ before(grammarAccess.getSpecializableTermReferenceAccess().getEnumeratedScalarReferenceParserRuleCall_6()); }
		ruleEnumeratedScalarReference
		{ after(grammarAccess.getSpecializableTermReferenceAccess().getEnumeratedScalarReferenceParserRuleCall_6()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityReferenceAccess().getAspectReferenceParserRuleCall_0()); }
		ruleAspectReference
		{ after(grammarAccess.getEntityReferenceAccess().getAspectReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getEntityReferenceAccess().getConceptReferenceParserRuleCall_1()); }
		ruleConceptReference
		{ after(grammarAccess.getEntityReferenceAccess().getConceptReferenceParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getEntityReferenceAccess().getRelationEntityReferenceParserRuleCall_2()); }
		ruleRelationEntityReference
		{ after(grammarAccess.getEntityReferenceAccess().getRelationEntityReferenceParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedInstanceReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNamedInstanceReferenceAccess().getConceptInstanceReferenceParserRuleCall_0()); }
		ruleConceptInstanceReference
		{ after(grammarAccess.getNamedInstanceReferenceAccess().getConceptInstanceReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getNamedInstanceReferenceAccess().getRelationInstanceReferenceParserRuleCall_1()); }
		ruleRelationInstanceReference
		{ after(grammarAccess.getNamedInstanceReferenceAccess().getRelationInstanceReferenceParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Statement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStatementAccess().getVocabularyStatementParserRuleCall_0()); }
		ruleVocabularyStatement
		{ after(grammarAccess.getStatementAccess().getVocabularyStatementParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getStatementAccess().getDescriptionStatementParserRuleCall_1()); }
		ruleDescriptionStatement
		{ after(grammarAccess.getStatementAccess().getDescriptionStatementParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyStatement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyStatementAccess().getSpecializableTermParserRuleCall_0()); }
		ruleSpecializableTerm
		{ after(grammarAccess.getVocabularyStatementAccess().getSpecializableTermParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getVocabularyStatementAccess().getRuleParserRuleCall_1()); }
		ruleRule
		{ after(grammarAccess.getVocabularyStatementAccess().getRuleParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getVocabularyStatementAccess().getSpecializableTermReferenceParserRuleCall_2()); }
		ruleSpecializableTermReference
		{ after(grammarAccess.getVocabularyStatementAccess().getSpecializableTermReferenceParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getVocabularyStatementAccess().getRuleReferenceParserRuleCall_3()); }
		ruleRuleReference
		{ after(grammarAccess.getVocabularyStatementAccess().getRuleReferenceParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getVocabularyStatementAccess().getRelationReferenceParserRuleCall_4()); }
		ruleRelationReference
		{ after(grammarAccess.getVocabularyStatementAccess().getRelationReferenceParserRuleCall_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionStatement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionStatementAccess().getNamedInstanceParserRuleCall_0()); }
		ruleNamedInstance
		{ after(grammarAccess.getDescriptionStatementAccess().getNamedInstanceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionStatementAccess().getNamedInstanceReferenceParserRuleCall_1()); }
		ruleNamedInstanceReference
		{ after(grammarAccess.getDescriptionStatementAccess().getNamedInstanceReferenceParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Import__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getImportAccess().getVocabularyImportParserRuleCall_0()); }
		(ruleVocabularyImport)
		{ after(grammarAccess.getImportAccess().getVocabularyImportParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getImportAccess().getBundleImportParserRuleCall_1()); }
		(ruleBundleImport)
		{ after(grammarAccess.getImportAccess().getBundleImportParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getImportAccess().getDescriptionImportParserRuleCall_2()); }
		(ruleDescriptionImport)
		{ after(grammarAccess.getImportAccess().getDescriptionImportParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyImport__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyImportAccess().getVocabularyExtensionParserRuleCall_0()); }
		ruleVocabularyExtension
		{ after(grammarAccess.getVocabularyImportAccess().getVocabularyExtensionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getVocabularyImportAccess().getVocabularyUsageParserRuleCall_1()); }
		ruleVocabularyUsage
		{ after(grammarAccess.getVocabularyImportAccess().getVocabularyUsageParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleImport__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleImportAccess().getBundleInclusionParserRuleCall_0()); }
		ruleBundleInclusion
		{ after(grammarAccess.getBundleImportAccess().getBundleInclusionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getBundleImportAccess().getBundleExtensionParserRuleCall_1()); }
		ruleBundleExtension
		{ after(grammarAccess.getBundleImportAccess().getBundleExtensionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionImport__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionImportAccess().getDescriptionUsageParserRuleCall_0()); }
		ruleDescriptionUsage
		{ after(grammarAccess.getDescriptionImportAccess().getDescriptionUsageParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionImportAccess().getDescriptionExtensionParserRuleCall_1()); }
		ruleDescriptionExtension
		{ after(grammarAccess.getDescriptionImportAccess().getDescriptionExtensionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Axiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAxiomAccess().getSpecializationAxiomParserRuleCall_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getAxiomAccess().getSpecializationAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAxiomAccess().getRestrictionAxiomParserRuleCall_1()); }
		ruleRestrictionAxiom
		{ after(grammarAccess.getAxiomAccess().getRestrictionAxiomParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getAxiomAccess().getKeyAxiomParserRuleCall_2()); }
		ruleKeyAxiom
		{ after(grammarAccess.getAxiomAccess().getKeyAxiomParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionAxiomAccess().getPropertyRestrictionAxiomParserRuleCall_0()); }
		rulePropertyRestrictionAxiom
		{ after(grammarAccess.getRestrictionAxiomAccess().getPropertyRestrictionAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictionAxiomAccess().getRelationRestrictionAxiomParserRuleCall_1()); }
		ruleRelationRestrictionAxiom
		{ after(grammarAccess.getRestrictionAxiomAccess().getRelationRestrictionAxiomParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyRestrictionAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPropertyRestrictionAxiomAccess().getScalarPropertyRestrictionAxiomParserRuleCall_0()); }
		ruleScalarPropertyRestrictionAxiom
		{ after(grammarAccess.getPropertyRestrictionAxiomAccess().getScalarPropertyRestrictionAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyRestrictionAxiomAccess().getStructuredPropertyRestrictionAxiomParserRuleCall_1()); }
		ruleStructuredPropertyRestrictionAxiom
		{ after(grammarAccess.getPropertyRestrictionAxiomAccess().getStructuredPropertyRestrictionAxiomParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRestrictionAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyRestrictionAxiomAccess().getScalarPropertyRangeRestrictionAxiomParserRuleCall_0()); }
		ruleScalarPropertyRangeRestrictionAxiom
		{ after(grammarAccess.getScalarPropertyRestrictionAxiomAccess().getScalarPropertyRangeRestrictionAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getScalarPropertyRestrictionAxiomAccess().getScalarPropertyCardinalityRestrictionAxiomParserRuleCall_1()); }
		ruleScalarPropertyCardinalityRestrictionAxiom
		{ after(grammarAccess.getScalarPropertyRestrictionAxiomAccess().getScalarPropertyCardinalityRestrictionAxiomParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getScalarPropertyRestrictionAxiomAccess().getScalarPropertyValueRestrictionAxiomParserRuleCall_2()); }
		ruleScalarPropertyValueRestrictionAxiom
		{ after(grammarAccess.getScalarPropertyRestrictionAxiomAccess().getScalarPropertyValueRestrictionAxiomParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRestrictionAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyRestrictionAxiomAccess().getStructuredPropertyRangeRestrictionAxiomParserRuleCall_0()); }
		ruleStructuredPropertyRangeRestrictionAxiom
		{ after(grammarAccess.getStructuredPropertyRestrictionAxiomAccess().getStructuredPropertyRangeRestrictionAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getStructuredPropertyRestrictionAxiomAccess().getStructuredPropertyCardinalityRestrictionAxiomParserRuleCall_1()); }
		ruleStructuredPropertyCardinalityRestrictionAxiom
		{ after(grammarAccess.getStructuredPropertyRestrictionAxiomAccess().getStructuredPropertyCardinalityRestrictionAxiomParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getStructuredPropertyRestrictionAxiomAccess().getStructuredPropertyValueRestrictionAxiomParserRuleCall_2()); }
		ruleStructuredPropertyValueRestrictionAxiom
		{ after(grammarAccess.getStructuredPropertyRestrictionAxiomAccess().getStructuredPropertyValueRestrictionAxiomParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRestrictionAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationRestrictionAxiomAccess().getRelationRangeRestrictionAxiomParserRuleCall_0()); }
		ruleRelationRangeRestrictionAxiom
		{ after(grammarAccess.getRelationRestrictionAxiomAccess().getRelationRangeRestrictionAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getRelationRestrictionAxiomAccess().getRelationCardinalityRestrictionAxiomParserRuleCall_1()); }
		ruleRelationCardinalityRestrictionAxiom
		{ after(grammarAccess.getRelationRestrictionAxiomAccess().getRelationCardinalityRestrictionAxiomParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getRelationRestrictionAxiomAccess().getRelationTargetRestrictionAxiomParserRuleCall_2()); }
		ruleRelationTargetRestrictionAxiom
		{ after(grammarAccess.getRelationRestrictionAxiomAccess().getRelationTargetRestrictionAxiomParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assertion__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssertionAccess().getTypeAssertionParserRuleCall_0()); }
		ruleTypeAssertion
		{ after(grammarAccess.getAssertionAccess().getTypeAssertionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAssertionAccess().getPropertyValueAssertionParserRuleCall_1()); }
		rulePropertyValueAssertion
		{ after(grammarAccess.getAssertionAccess().getPropertyValueAssertionParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getAssertionAccess().getLinkAssertionParserRuleCall_2()); }
		ruleLinkAssertion
		{ after(grammarAccess.getAssertionAccess().getLinkAssertionParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeAssertion__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAssertionAccess().getConceptTypeAssertionParserRuleCall_0()); }
		(ruleConceptTypeAssertion)
		{ after(grammarAccess.getTypeAssertionAccess().getConceptTypeAssertionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTypeAssertionAccess().getRelationTypeAssertionParserRuleCall_1()); }
		(ruleRelationTypeAssertion)
		{ after(grammarAccess.getTypeAssertionAccess().getRelationTypeAssertionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyValueAssertion__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPropertyValueAssertionAccess().getScalarPropertyValueAssertionParserRuleCall_0()); }
		ruleScalarPropertyValueAssertion
		{ after(grammarAccess.getPropertyValueAssertionAccess().getScalarPropertyValueAssertionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyValueAssertionAccess().getStructuredPropertyValueAssertionParserRuleCall_1()); }
		ruleStructuredPropertyValueAssertion
		{ after(grammarAccess.getPropertyValueAssertionAccess().getStructuredPropertyValueAssertionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predicate__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicateAccess().getUnaryPredicateParserRuleCall_0()); }
		ruleUnaryPredicate
		{ after(grammarAccess.getPredicateAccess().getUnaryPredicateParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getPredicateAccess().getBinaryPredicateParserRuleCall_1()); }
		ruleBinaryPredicate
		{ after(grammarAccess.getPredicateAccess().getBinaryPredicateParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryPredicate__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryPredicateAccess().getSameAsPredicateParserRuleCall_0()); }
		ruleSameAsPredicate
		{ after(grammarAccess.getBinaryPredicateAccess().getSameAsPredicateParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getBinaryPredicateAccess().getDifferentFromPredicateParserRuleCall_1()); }
		ruleDifferentFromPredicate
		{ after(grammarAccess.getBinaryPredicateAccess().getDifferentFromPredicateParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getBinaryPredicateAccess().getRelationPredicateParserRuleCall_2()); }
		ruleRelationPredicate
		{ after(grammarAccess.getBinaryPredicateAccess().getRelationPredicateParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getBinaryPredicateAccess().getRelationEntityPredicateParserRuleCall_3()); }
		ruleRelationEntityPredicate
		{ after(grammarAccess.getBinaryPredicateAccess().getRelationEntityPredicateParserRuleCall_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Literal__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralAccess().getIntegerLiteralParserRuleCall_0()); }
		ruleIntegerLiteral
		{ after(grammarAccess.getLiteralAccess().getIntegerLiteralParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralAccess().getDecimalLiteralParserRuleCall_1()); }
		ruleDecimalLiteral
		{ after(grammarAccess.getLiteralAccess().getDecimalLiteralParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralAccess().getDoubleLiteralParserRuleCall_2()); }
		ruleDoubleLiteral
		{ after(grammarAccess.getLiteralAccess().getDoubleLiteralParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_3()); }
		ruleBooleanLiteral
		{ after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralAccess().getQuotedLiteralParserRuleCall_4()); }
		ruleQuotedLiteral
		{ after(grammarAccess.getLiteralAccess().getQuotedLiteralParserRuleCall_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQuotedLiteralAccess().getGroup_1_0()); }
		(rule__QuotedLiteral__Group_1_0__0)
		{ after(grammarAccess.getQuotedLiteralAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getQuotedLiteralAccess().getGroup_1_1()); }
		(rule__QuotedLiteral__Group_1_1__0)
		{ after(grammarAccess.getQuotedLiteralAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Ref__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRefAccess().getIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getRefAccess().getIDTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getRefAccess().getABBREV_IRITerminalRuleCall_1()); }
		RULE_ABBREV_IRI
		{ after(grammarAccess.getRefAccess().getABBREV_IRITerminalRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getRefAccess().getIRITerminalRuleCall_2()); }
		RULE_IRI
		{ after(grammarAccess.getRefAccess().getIRITerminalRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Integer__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIntegerAccess().getUNSIGNED_INTEGER_STRTerminalRuleCall_0()); }
		RULE_UNSIGNED_INTEGER_STR
		{ after(grammarAccess.getIntegerAccess().getUNSIGNED_INTEGER_STRTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getIntegerAccess().getINTEGER_STRTerminalRuleCall_1()); }
		RULE_INTEGER_STR
		{ after(grammarAccess.getIntegerAccess().getINTEGER_STRTerminalRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SeparatorKind__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSeparatorKindAccess().getHashEnumLiteralDeclaration_0()); }
		(NumberSign)
		{ after(grammarAccess.getSeparatorKindAccess().getHashEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getSeparatorKindAccess().getSlashEnumLiteralDeclaration_1()); }
		(Solidus)
		{ after(grammarAccess.getSeparatorKindAccess().getSlashEnumLiteralDeclaration_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RangeRestrictionKind__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRangeRestrictionKindAccess().getAllEnumLiteralDeclaration_0()); }
		(All)
		{ after(grammarAccess.getRangeRestrictionKindAccess().getAllEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getRangeRestrictionKindAccess().getSomeEnumLiteralDeclaration_1()); }
		(Some)
		{ after(grammarAccess.getRangeRestrictionKindAccess().getSomeEnumLiteralDeclaration_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictionKind__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictionKindAccess().getExactlyEnumLiteralDeclaration_0()); }
		(Exactly)
		{ after(grammarAccess.getCardinalityRestrictionKindAccess().getExactlyEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getCardinalityRestrictionKindAccess().getMinEnumLiteralDeclaration_1()); }
		(Min)
		{ after(grammarAccess.getCardinalityRestrictionKindAccess().getMinEnumLiteralDeclaration_1()); }
	)
	|
	(
		{ before(grammarAccess.getCardinalityRestrictionKindAccess().getMaxEnumLiteralDeclaration_2()); }
		(Max)
		{ after(grammarAccess.getCardinalityRestrictionKindAccess().getMaxEnumLiteralDeclaration_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Annotation__Group__0__Impl
	rule__Annotation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); }
	CommercialAt
	{ after(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Annotation__Group__1__Impl
	rule__Annotation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationAccess().getPropertyAssignment_1()); }
	(rule__Annotation__PropertyAssignment_1)
	{ after(grammarAccess.getAnnotationAccess().getPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Annotation__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationAccess().getValueAssignment_2()); }
	(rule__Annotation__ValueAssignment_2)?
	{ after(grammarAccess.getAnnotationAccess().getValueAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Vocabulary__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__0__Impl
	rule__Vocabulary__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__Vocabulary__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getVocabularyAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__1__Impl
	rule__Vocabulary__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getVocabularyKeyword_1()); }
	Vocabulary
	{ after(grammarAccess.getVocabularyAccess().getVocabularyKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__2__Impl
	rule__Vocabulary__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getIriAssignment_2()); }
	(rule__Vocabulary__IriAssignment_2)
	{ after(grammarAccess.getVocabularyAccess().getIriAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__3__Impl
	rule__Vocabulary__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getWithKeyword_3()); }
	With
	{ after(grammarAccess.getVocabularyAccess().getWithKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__4__Impl
	rule__Vocabulary__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getSeparatorAssignment_4()); }
	(rule__Vocabulary__SeparatorAssignment_4)
	{ after(grammarAccess.getVocabularyAccess().getSeparatorAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__5__Impl
	rule__Vocabulary__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getAsKeyword_5()); }
	As
	{ after(grammarAccess.getVocabularyAccess().getAsKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__6__Impl
	rule__Vocabulary__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getPrefixAssignment_6()); }
	(rule__Vocabulary__PrefixAssignment_6)
	{ after(grammarAccess.getVocabularyAccess().getPrefixAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__7__Impl
	rule__Vocabulary__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getLeftCurlyBracketKeyword_7()); }
	LeftCurlyBracket
	{ after(grammarAccess.getVocabularyAccess().getLeftCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__8__Impl
	rule__Vocabulary__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getOwnedImportsAssignment_8()); }
	(rule__Vocabulary__OwnedImportsAssignment_8)*
	{ after(grammarAccess.getVocabularyAccess().getOwnedImportsAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__9__Impl
	rule__Vocabulary__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getOwnedStatementsAssignment_9()); }
	(rule__Vocabulary__OwnedStatementsAssignment_9)*
	{ after(grammarAccess.getVocabularyAccess().getOwnedStatementsAssignment_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Vocabulary__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyAccess().getRightCurlyBracketKeyword_10()); }
	RightCurlyBracket
	{ after(grammarAccess.getVocabularyAccess().getRightCurlyBracketKeyword_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Bundle__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__0__Impl
	rule__Bundle__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__Bundle__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getBundleAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__1__Impl
	rule__Bundle__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getBundleKeyword_1()); }
	Bundle
	{ after(grammarAccess.getBundleAccess().getBundleKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__2__Impl
	rule__Bundle__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getIriAssignment_2()); }
	(rule__Bundle__IriAssignment_2)
	{ after(grammarAccess.getBundleAccess().getIriAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__3__Impl
	rule__Bundle__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getWithKeyword_3()); }
	With
	{ after(grammarAccess.getBundleAccess().getWithKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__4__Impl
	rule__Bundle__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getSeparatorAssignment_4()); }
	(rule__Bundle__SeparatorAssignment_4)
	{ after(grammarAccess.getBundleAccess().getSeparatorAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__5__Impl
	rule__Bundle__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getAsKeyword_5()); }
	As
	{ after(grammarAccess.getBundleAccess().getAsKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__6__Impl
	rule__Bundle__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getPrefixAssignment_6()); }
	(rule__Bundle__PrefixAssignment_6)
	{ after(grammarAccess.getBundleAccess().getPrefixAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__7__Impl
	rule__Bundle__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_7()); }
	LeftCurlyBracket
	{ after(grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__8__Impl
	rule__Bundle__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getOwnedImportsAssignment_8()); }
	(rule__Bundle__OwnedImportsAssignment_8)*
	{ after(grammarAccess.getBundleAccess().getOwnedImportsAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_9()); }
	RightCurlyBracket
	{ after(grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Description__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__0__Impl
	rule__Description__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__Description__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getDescriptionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__1__Impl
	rule__Description__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getDescriptionKeyword_1()); }
	Description
	{ after(grammarAccess.getDescriptionAccess().getDescriptionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__2__Impl
	rule__Description__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getIriAssignment_2()); }
	(rule__Description__IriAssignment_2)
	{ after(grammarAccess.getDescriptionAccess().getIriAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__3__Impl
	rule__Description__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getWithKeyword_3()); }
	With
	{ after(grammarAccess.getDescriptionAccess().getWithKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__4__Impl
	rule__Description__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getSeparatorAssignment_4()); }
	(rule__Description__SeparatorAssignment_4)
	{ after(grammarAccess.getDescriptionAccess().getSeparatorAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__5__Impl
	rule__Description__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getAsKeyword_5()); }
	As
	{ after(grammarAccess.getDescriptionAccess().getAsKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__6__Impl
	rule__Description__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getPrefixAssignment_6()); }
	(rule__Description__PrefixAssignment_6)
	{ after(grammarAccess.getDescriptionAccess().getPrefixAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__7__Impl
	rule__Description__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getLeftCurlyBracketKeyword_7()); }
	LeftCurlyBracket
	{ after(grammarAccess.getDescriptionAccess().getLeftCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__8__Impl
	rule__Description__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getOwnedImportsAssignment_8()); }
	(rule__Description__OwnedImportsAssignment_8)*
	{ after(grammarAccess.getDescriptionAccess().getOwnedImportsAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__9__Impl
	rule__Description__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getOwnedStatementsAssignment_9()); }
	(rule__Description__OwnedStatementsAssignment_9)*
	{ after(grammarAccess.getDescriptionAccess().getOwnedStatementsAssignment_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Description__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionAccess().getRightCurlyBracketKeyword_10()); }
	RightCurlyBracket
	{ after(grammarAccess.getDescriptionAccess().getRightCurlyBracketKeyword_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Aspect__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__0__Impl
	rule__Aspect__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__Aspect__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getAspectAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__1__Impl
	rule__Aspect__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getAspectKeyword_1()); }
	Aspect
	{ after(grammarAccess.getAspectAccess().getAspectKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__2__Impl
	rule__Aspect__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getNameAssignment_2()); }
	(rule__Aspect__NameAssignment_2)
	{ after(grammarAccess.getAspectAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__3__Impl
	rule__Aspect__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getGroup_3()); }
	(rule__Aspect__Group_3__0)?
	{ after(grammarAccess.getAspectAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getGroup_4()); }
	(rule__Aspect__Group_4__0)?
	{ after(grammarAccess.getAspectAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Aspect__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_3__0__Impl
	rule__Aspect__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getColonGreaterThanSignKeyword_3_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getAspectAccess().getColonGreaterThanSignKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_3__1__Impl
	rule__Aspect__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getOwnedSpecializationsAssignment_3_1()); }
	(rule__Aspect__OwnedSpecializationsAssignment_3_1)
	{ after(grammarAccess.getAspectAccess().getOwnedSpecializationsAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getGroup_3_2()); }
	(rule__Aspect__Group_3_2__0)*
	{ after(grammarAccess.getAspectAccess().getGroup_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Aspect__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_3_2__0__Impl
	rule__Aspect__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getCommaKeyword_3_2_0()); }
	Comma
	{ after(grammarAccess.getAspectAccess().getCommaKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getOwnedSpecializationsAssignment_3_2_1()); }
	(rule__Aspect__OwnedSpecializationsAssignment_3_2_1)
	{ after(grammarAccess.getAspectAccess().getOwnedSpecializationsAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Aspect__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_4__0__Impl
	rule__Aspect__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getLeftSquareBracketKeyword_4_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getAspectAccess().getLeftSquareBracketKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_4__1__Impl
	rule__Aspect__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getOwnedKeysAssignment_4_1()); }
	(rule__Aspect__OwnedKeysAssignment_4_1)*
	{ after(grammarAccess.getAspectAccess().getOwnedKeysAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_4__2__Impl
	rule__Aspect__Group_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getOwnedPropertyRestrictionsAssignment_4_2()); }
	(rule__Aspect__OwnedPropertyRestrictionsAssignment_4_2)*
	{ after(grammarAccess.getAspectAccess().getOwnedPropertyRestrictionsAssignment_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_4__3__Impl
	rule__Aspect__Group_4__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getOwnedRelationRestrictionsAssignment_4_3()); }
	(rule__Aspect__OwnedRelationRestrictionsAssignment_4_3)*
	{ after(grammarAccess.getAspectAccess().getOwnedRelationRestrictionsAssignment_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_4__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_4__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_4__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getRightSquareBracketKeyword_4_4()); }
	RightSquareBracket
	{ after(grammarAccess.getAspectAccess().getRightSquareBracketKeyword_4_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Concept__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group__0__Impl
	rule__Concept__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__Concept__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getConceptAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group__1__Impl
	rule__Concept__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getConceptKeyword_1()); }
	Concept
	{ after(grammarAccess.getConceptAccess().getConceptKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group__2__Impl
	rule__Concept__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getNameAssignment_2()); }
	(rule__Concept__NameAssignment_2)
	{ after(grammarAccess.getConceptAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group__3__Impl
	rule__Concept__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getGroup_3()); }
	(rule__Concept__Group_3__0)?
	{ after(grammarAccess.getConceptAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getGroup_4()); }
	(rule__Concept__Group_4__0)?
	{ after(grammarAccess.getConceptAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Concept__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_3__0__Impl
	rule__Concept__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getColonGreaterThanSignKeyword_3_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getConceptAccess().getColonGreaterThanSignKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_3__1__Impl
	rule__Concept__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getOwnedSpecializationsAssignment_3_1()); }
	(rule__Concept__OwnedSpecializationsAssignment_3_1)
	{ after(grammarAccess.getConceptAccess().getOwnedSpecializationsAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getGroup_3_2()); }
	(rule__Concept__Group_3_2__0)*
	{ after(grammarAccess.getConceptAccess().getGroup_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Concept__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_3_2__0__Impl
	rule__Concept__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getCommaKeyword_3_2_0()); }
	Comma
	{ after(grammarAccess.getConceptAccess().getCommaKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getOwnedSpecializationsAssignment_3_2_1()); }
	(rule__Concept__OwnedSpecializationsAssignment_3_2_1)
	{ after(grammarAccess.getConceptAccess().getOwnedSpecializationsAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Concept__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_4__0__Impl
	rule__Concept__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getLeftSquareBracketKeyword_4_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getConceptAccess().getLeftSquareBracketKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_4__1__Impl
	rule__Concept__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getOwnedKeysAssignment_4_1()); }
	(rule__Concept__OwnedKeysAssignment_4_1)*
	{ after(grammarAccess.getConceptAccess().getOwnedKeysAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_4__2__Impl
	rule__Concept__Group_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getOwnedPropertyRestrictionsAssignment_4_2()); }
	(rule__Concept__OwnedPropertyRestrictionsAssignment_4_2)*
	{ after(grammarAccess.getConceptAccess().getOwnedPropertyRestrictionsAssignment_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_4__3__Impl
	rule__Concept__Group_4__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getOwnedRelationRestrictionsAssignment_4_3()); }
	(rule__Concept__OwnedRelationRestrictionsAssignment_4_3)*
	{ after(grammarAccess.getConceptAccess().getOwnedRelationRestrictionsAssignment_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_4__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group_4__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group_4__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getRightSquareBracketKeyword_4_4()); }
	RightSquareBracket
	{ after(grammarAccess.getConceptAccess().getRightSquareBracketKeyword_4_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntity__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group__0__Impl
	rule__RelationEntity__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationEntity__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationEntityAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group__1__Impl
	rule__RelationEntity__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getRelationKeyword_1()); }
	Relation
	{ after(grammarAccess.getRelationEntityAccess().getRelationKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group__2__Impl
	rule__RelationEntity__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getEntityKeyword_2()); }
	Entity
	{ after(grammarAccess.getRelationEntityAccess().getEntityKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group__3__Impl
	rule__RelationEntity__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getNameAssignment_3()); }
	(rule__RelationEntity__NameAssignment_3)
	{ after(grammarAccess.getRelationEntityAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group__4__Impl
	rule__RelationEntity__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getGroup_4()); }
	(rule__RelationEntity__Group_4__0)?
	{ after(grammarAccess.getRelationEntityAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getGroup_5()); }
	(rule__RelationEntity__Group_5__0)?
	{ after(grammarAccess.getRelationEntityAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntity__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_4__0__Impl
	rule__RelationEntity__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getColonGreaterThanSignKeyword_4_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getRelationEntityAccess().getColonGreaterThanSignKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_4__1__Impl
	rule__RelationEntity__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsAssignment_4_1()); }
	(rule__RelationEntity__OwnedSpecializationsAssignment_4_1)
	{ after(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getGroup_4_2()); }
	(rule__RelationEntity__Group_4_2__0)*
	{ after(grammarAccess.getRelationEntityAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntity__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_4_2__0__Impl
	rule__RelationEntity__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getRelationEntityAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsAssignment_4_2_1()); }
	(rule__RelationEntity__OwnedSpecializationsAssignment_4_2_1)
	{ after(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntity__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__0__Impl
	rule__RelationEntity__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getLeftSquareBracketKeyword_5_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getRelationEntityAccess().getLeftSquareBracketKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__1__Impl
	rule__RelationEntity__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getFromKeyword_5_1()); }
	From
	{ after(grammarAccess.getRelationEntityAccess().getFromKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__2__Impl
	rule__RelationEntity__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getSourceAssignment_5_2()); }
	(rule__RelationEntity__SourceAssignment_5_2)
	{ after(grammarAccess.getRelationEntityAccess().getSourceAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__3__Impl
	rule__RelationEntity__Group_5__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getToKeyword_5_3()); }
	To
	{ after(grammarAccess.getRelationEntityAccess().getToKeyword_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__4__Impl
	rule__RelationEntity__Group_5__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getTargetAssignment_5_4()); }
	(rule__RelationEntity__TargetAssignment_5_4)
	{ after(grammarAccess.getRelationEntityAccess().getTargetAssignment_5_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__5__Impl
	rule__RelationEntity__Group_5__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getForwardAssignment_5_5()); }
	(rule__RelationEntity__ForwardAssignment_5_5)
	{ after(grammarAccess.getRelationEntityAccess().getForwardAssignment_5_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__6__Impl
	rule__RelationEntity__Group_5__7
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getInverseAssignment_5_6()); }
	(rule__RelationEntity__InverseAssignment_5_6)?
	{ after(grammarAccess.getRelationEntityAccess().getInverseAssignment_5_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__7__Impl
	rule__RelationEntity__Group_5__8
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7()); }
	(rule__RelationEntity__UnorderedGroup_5_7)
	{ after(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__8__Impl
	rule__RelationEntity__Group_5__9
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getOwnedKeysAssignment_5_8()); }
	(rule__RelationEntity__OwnedKeysAssignment_5_8)*
	{ after(grammarAccess.getRelationEntityAccess().getOwnedKeysAssignment_5_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__9__Impl
	rule__RelationEntity__Group_5__10
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getOwnedPropertyRestrictionsAssignment_5_9()); }
	(rule__RelationEntity__OwnedPropertyRestrictionsAssignment_5_9)*
	{ after(grammarAccess.getRelationEntityAccess().getOwnedPropertyRestrictionsAssignment_5_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__10__Impl
	rule__RelationEntity__Group_5__11
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getOwnedRelationRestrictionsAssignment_5_10()); }
	(rule__RelationEntity__OwnedRelationRestrictionsAssignment_5_10)*
	{ after(grammarAccess.getRelationEntityAccess().getOwnedRelationRestrictionsAssignment_5_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__11
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5__11__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5__11__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getRightSquareBracketKeyword_5_11()); }
	RightSquareBracket
	{ after(grammarAccess.getRelationEntityAccess().getRightSquareBracketKeyword_5_11()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntity__Group_5_7_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5_7_1__0__Impl
	rule__RelationEntity__Group_5_7_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5_7_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getInverseFunctionalAssignment_5_7_1_0()); }
	(rule__RelationEntity__InverseFunctionalAssignment_5_7_1_0)
	{ after(grammarAccess.getRelationEntityAccess().getInverseFunctionalAssignment_5_7_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5_7_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__Group_5_7_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__Group_5_7_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityAccess().getFunctionalKeyword_5_7_1_1()); }
	Functional
	{ after(grammarAccess.getRelationEntityAccess().getFunctionalKeyword_5_7_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Structure__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group__0__Impl
	rule__Structure__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__Structure__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getStructureAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group__1__Impl
	rule__Structure__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getStructureKeyword_1()); }
	Structure
	{ after(grammarAccess.getStructureAccess().getStructureKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group__2__Impl
	rule__Structure__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getNameAssignment_2()); }
	(rule__Structure__NameAssignment_2)
	{ after(grammarAccess.getStructureAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group__3__Impl
	rule__Structure__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getGroup_3()); }
	(rule__Structure__Group_3__0)?
	{ after(grammarAccess.getStructureAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getGroup_4()); }
	(rule__Structure__Group_4__0)?
	{ after(grammarAccess.getStructureAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Structure__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group_3__0__Impl
	rule__Structure__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getColonGreaterThanSignKeyword_3_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getStructureAccess().getColonGreaterThanSignKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group_3__1__Impl
	rule__Structure__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getOwnedSpecializationsAssignment_3_1()); }
	(rule__Structure__OwnedSpecializationsAssignment_3_1)
	{ after(grammarAccess.getStructureAccess().getOwnedSpecializationsAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getGroup_3_2()); }
	(rule__Structure__Group_3_2__0)*
	{ after(grammarAccess.getStructureAccess().getGroup_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Structure__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group_3_2__0__Impl
	rule__Structure__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getCommaKeyword_3_2_0()); }
	Comma
	{ after(grammarAccess.getStructureAccess().getCommaKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getOwnedSpecializationsAssignment_3_2_1()); }
	(rule__Structure__OwnedSpecializationsAssignment_3_2_1)
	{ after(grammarAccess.getStructureAccess().getOwnedSpecializationsAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Structure__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group_4__0__Impl
	rule__Structure__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getLeftSquareBracketKeyword_4_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getStructureAccess().getLeftSquareBracketKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group_4__1__Impl
	rule__Structure__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getOwnedPropertyRestrictionsAssignment_4_1()); }
	(rule__Structure__OwnedPropertyRestrictionsAssignment_4_1)*
	{ after(grammarAccess.getStructureAccess().getOwnedPropertyRestrictionsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getRightSquareBracketKeyword_4_2()); }
	RightSquareBracket
	{ after(grammarAccess.getStructureAccess().getRightSquareBracketKeyword_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationProperty__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group__0__Impl
	rule__AnnotationProperty__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__AnnotationProperty__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getAnnotationPropertyAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group__1__Impl
	rule__AnnotationProperty__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getAnnotationKeyword_1()); }
	Annotation
	{ after(grammarAccess.getAnnotationPropertyAccess().getAnnotationKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group__2__Impl
	rule__AnnotationProperty__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getPropertyKeyword_2()); }
	Property
	{ after(grammarAccess.getAnnotationPropertyAccess().getPropertyKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group__3__Impl
	rule__AnnotationProperty__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getNameAssignment_3()); }
	(rule__AnnotationProperty__NameAssignment_3)
	{ after(grammarAccess.getAnnotationPropertyAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getGroup_4()); }
	(rule__AnnotationProperty__Group_4__0)?
	{ after(grammarAccess.getAnnotationPropertyAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationProperty__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group_4__0__Impl
	rule__AnnotationProperty__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getColonGreaterThanSignKeyword_4_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getAnnotationPropertyAccess().getColonGreaterThanSignKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group_4__1__Impl
	rule__AnnotationProperty__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsAssignment_4_1()); }
	(rule__AnnotationProperty__OwnedSpecializationsAssignment_4_1)
	{ after(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getGroup_4_2()); }
	(rule__AnnotationProperty__Group_4_2__0)*
	{ after(grammarAccess.getAnnotationPropertyAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationProperty__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group_4_2__0__Impl
	rule__AnnotationProperty__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getAnnotationPropertyAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsAssignment_4_2_1()); }
	(rule__AnnotationProperty__OwnedSpecializationsAssignment_4_2_1)
	{ after(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarProperty__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group__0__Impl
	rule__ScalarProperty__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ScalarProperty__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarPropertyAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group__1__Impl
	rule__ScalarProperty__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getScalarKeyword_1()); }
	Scalar
	{ after(grammarAccess.getScalarPropertyAccess().getScalarKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group__2__Impl
	rule__ScalarProperty__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getPropertyKeyword_2()); }
	Property
	{ after(grammarAccess.getScalarPropertyAccess().getPropertyKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group__3__Impl
	rule__ScalarProperty__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getNameAssignment_3()); }
	(rule__ScalarProperty__NameAssignment_3)
	{ after(grammarAccess.getScalarPropertyAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group__4__Impl
	rule__ScalarProperty__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getGroup_4()); }
	(rule__ScalarProperty__Group_4__0)?
	{ after(grammarAccess.getScalarPropertyAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getGroup_5()); }
	(rule__ScalarProperty__Group_5__0)?
	{ after(grammarAccess.getScalarPropertyAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarProperty__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_4__0__Impl
	rule__ScalarProperty__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getColonGreaterThanSignKeyword_4_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getScalarPropertyAccess().getColonGreaterThanSignKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_4__1__Impl
	rule__ScalarProperty__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsAssignment_4_1()); }
	(rule__ScalarProperty__OwnedSpecializationsAssignment_4_1)
	{ after(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getGroup_4_2()); }
	(rule__ScalarProperty__Group_4_2__0)*
	{ after(grammarAccess.getScalarPropertyAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarProperty__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_4_2__0__Impl
	rule__ScalarProperty__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getScalarPropertyAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsAssignment_4_2_1()); }
	(rule__ScalarProperty__OwnedSpecializationsAssignment_4_2_1)
	{ after(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarProperty__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_5__0__Impl
	rule__ScalarProperty__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getLeftSquareBracketKeyword_5_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getScalarPropertyAccess().getLeftSquareBracketKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_5__1__Impl
	rule__ScalarProperty__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getDomainKeyword_5_1()); }
	Domain
	{ after(grammarAccess.getScalarPropertyAccess().getDomainKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_5__2__Impl
	rule__ScalarProperty__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getDomainAssignment_5_2()); }
	(rule__ScalarProperty__DomainAssignment_5_2)
	{ after(grammarAccess.getScalarPropertyAccess().getDomainAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_5__3__Impl
	rule__ScalarProperty__Group_5__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getRangeKeyword_5_3()); }
	Range
	{ after(grammarAccess.getScalarPropertyAccess().getRangeKeyword_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_5__4__Impl
	rule__ScalarProperty__Group_5__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getRangeAssignment_5_4()); }
	(rule__ScalarProperty__RangeAssignment_5_4)
	{ after(grammarAccess.getScalarPropertyAccess().getRangeAssignment_5_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_5__5__Impl
	rule__ScalarProperty__Group_5__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getFunctionalAssignment_5_5()); }
	(rule__ScalarProperty__FunctionalAssignment_5_5)?
	{ after(grammarAccess.getScalarPropertyAccess().getFunctionalAssignment_5_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarProperty__Group_5__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__Group_5__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyAccess().getRightSquareBracketKeyword_5_6()); }
	RightSquareBracket
	{ after(grammarAccess.getScalarPropertyAccess().getRightSquareBracketKeyword_5_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredProperty__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group__0__Impl
	rule__StructuredProperty__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__StructuredProperty__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getStructuredPropertyAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group__1__Impl
	rule__StructuredProperty__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getStructuredKeyword_1()); }
	Structured
	{ after(grammarAccess.getStructuredPropertyAccess().getStructuredKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group__2__Impl
	rule__StructuredProperty__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getPropertyKeyword_2()); }
	Property
	{ after(grammarAccess.getStructuredPropertyAccess().getPropertyKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group__3__Impl
	rule__StructuredProperty__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getNameAssignment_3()); }
	(rule__StructuredProperty__NameAssignment_3)
	{ after(grammarAccess.getStructuredPropertyAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group__4__Impl
	rule__StructuredProperty__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getGroup_4()); }
	(rule__StructuredProperty__Group_4__0)?
	{ after(grammarAccess.getStructuredPropertyAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getGroup_5()); }
	(rule__StructuredProperty__Group_5__0)?
	{ after(grammarAccess.getStructuredPropertyAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredProperty__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_4__0__Impl
	rule__StructuredProperty__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getColonGreaterThanSignKeyword_4_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getStructuredPropertyAccess().getColonGreaterThanSignKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_4__1__Impl
	rule__StructuredProperty__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsAssignment_4_1()); }
	(rule__StructuredProperty__OwnedSpecializationsAssignment_4_1)
	{ after(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getGroup_4_2()); }
	(rule__StructuredProperty__Group_4_2__0)*
	{ after(grammarAccess.getStructuredPropertyAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredProperty__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_4_2__0__Impl
	rule__StructuredProperty__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getStructuredPropertyAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsAssignment_4_2_1()); }
	(rule__StructuredProperty__OwnedSpecializationsAssignment_4_2_1)
	{ after(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredProperty__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_5__0__Impl
	rule__StructuredProperty__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getLeftSquareBracketKeyword_5_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getStructuredPropertyAccess().getLeftSquareBracketKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_5__1__Impl
	rule__StructuredProperty__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getDomainKeyword_5_1()); }
	Domain
	{ after(grammarAccess.getStructuredPropertyAccess().getDomainKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_5__2__Impl
	rule__StructuredProperty__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getDomainAssignment_5_2()); }
	(rule__StructuredProperty__DomainAssignment_5_2)
	{ after(grammarAccess.getStructuredPropertyAccess().getDomainAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_5__3__Impl
	rule__StructuredProperty__Group_5__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getRangeKeyword_5_3()); }
	Range
	{ after(grammarAccess.getStructuredPropertyAccess().getRangeKeyword_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_5__4__Impl
	rule__StructuredProperty__Group_5__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getRangeAssignment_5_4()); }
	(rule__StructuredProperty__RangeAssignment_5_4)
	{ after(grammarAccess.getStructuredPropertyAccess().getRangeAssignment_5_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_5__5__Impl
	rule__StructuredProperty__Group_5__6
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getFunctionalAssignment_5_5()); }
	(rule__StructuredProperty__FunctionalAssignment_5_5)?
	{ after(grammarAccess.getStructuredPropertyAccess().getFunctionalAssignment_5_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredProperty__Group_5__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__Group_5__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyAccess().getRightSquareBracketKeyword_5_6()); }
	RightSquareBracket
	{ after(grammarAccess.getStructuredPropertyAccess().getRightSquareBracketKeyword_5_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group__0__Impl
	rule__FacetedScalar__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__FacetedScalar__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getFacetedScalarAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group__1__Impl
	rule__FacetedScalar__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getScalarKeyword_1()); }
	Scalar
	{ after(grammarAccess.getFacetedScalarAccess().getScalarKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group__2__Impl
	rule__FacetedScalar__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getNameAssignment_2()); }
	(rule__FacetedScalar__NameAssignment_2)
	{ after(grammarAccess.getFacetedScalarAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group__3__Impl
	rule__FacetedScalar__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getGroup_3()); }
	(rule__FacetedScalar__Group_3__0)?
	{ after(grammarAccess.getFacetedScalarAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getGroup_4()); }
	(rule__FacetedScalar__Group_4__0)?
	{ after(grammarAccess.getFacetedScalarAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_3__0__Impl
	rule__FacetedScalar__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getColonGreaterThanSignKeyword_3_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getFacetedScalarAccess().getColonGreaterThanSignKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_3__1__Impl
	rule__FacetedScalar__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsAssignment_3_1()); }
	(rule__FacetedScalar__OwnedSpecializationsAssignment_3_1)
	{ after(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getGroup_3_2()); }
	(rule__FacetedScalar__Group_3_2__0)*
	{ after(grammarAccess.getFacetedScalarAccess().getGroup_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_3_2__0__Impl
	rule__FacetedScalar__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getCommaKeyword_3_2_0()); }
	Comma
	{ after(grammarAccess.getFacetedScalarAccess().getCommaKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsAssignment_3_2_1()); }
	(rule__FacetedScalar__OwnedSpecializationsAssignment_3_2_1)
	{ after(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4__0__Impl
	rule__FacetedScalar__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getLeftSquareBracketKeyword_4_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getFacetedScalarAccess().getLeftSquareBracketKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4__1__Impl
	rule__FacetedScalar__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1()); }
	(rule__FacetedScalar__UnorderedGroup_4_1)
	{ after(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getRightSquareBracketKeyword_4_2()); }
	RightSquareBracket
	{ after(grammarAccess.getFacetedScalarAccess().getRightSquareBracketKeyword_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_0__0__Impl
	rule__FacetedScalar__Group_4_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getLengthKeyword_4_1_0_0()); }
	Length
	{ after(grammarAccess.getFacetedScalarAccess().getLengthKeyword_4_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getLengthAssignment_4_1_0_1()); }
	(rule__FacetedScalar__LengthAssignment_4_1_0_1)
	{ after(grammarAccess.getFacetedScalarAccess().getLengthAssignment_4_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_1__0__Impl
	rule__FacetedScalar__Group_4_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMinLengthKeyword_4_1_1_0()); }
	MinLength
	{ after(grammarAccess.getFacetedScalarAccess().getMinLengthKeyword_4_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMinLengthAssignment_4_1_1_1()); }
	(rule__FacetedScalar__MinLengthAssignment_4_1_1_1)
	{ after(grammarAccess.getFacetedScalarAccess().getMinLengthAssignment_4_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_2__0__Impl
	rule__FacetedScalar__Group_4_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMaxLengthKeyword_4_1_2_0()); }
	MaxLength
	{ after(grammarAccess.getFacetedScalarAccess().getMaxLengthKeyword_4_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMaxLengthAssignment_4_1_2_1()); }
	(rule__FacetedScalar__MaxLengthAssignment_4_1_2_1)
	{ after(grammarAccess.getFacetedScalarAccess().getMaxLengthAssignment_4_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_3__0__Impl
	rule__FacetedScalar__Group_4_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getPatternKeyword_4_1_3_0()); }
	Pattern
	{ after(grammarAccess.getFacetedScalarAccess().getPatternKeyword_4_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getPatternAssignment_4_1_3_1()); }
	(rule__FacetedScalar__PatternAssignment_4_1_3_1)
	{ after(grammarAccess.getFacetedScalarAccess().getPatternAssignment_4_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4_1_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_4__0__Impl
	rule__FacetedScalar__Group_4_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getLanguageKeyword_4_1_4_0()); }
	Language
	{ after(grammarAccess.getFacetedScalarAccess().getLanguageKeyword_4_1_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getLanguageAssignment_4_1_4_1()); }
	(rule__FacetedScalar__LanguageAssignment_4_1_4_1)
	{ after(grammarAccess.getFacetedScalarAccess().getLanguageAssignment_4_1_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4_1_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_5__0__Impl
	rule__FacetedScalar__Group_4_1_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMinInclusiveKeyword_4_1_5_0()); }
	MinInclusive
	{ after(grammarAccess.getFacetedScalarAccess().getMinInclusiveKeyword_4_1_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMinInclusiveAssignment_4_1_5_1()); }
	(rule__FacetedScalar__MinInclusiveAssignment_4_1_5_1)
	{ after(grammarAccess.getFacetedScalarAccess().getMinInclusiveAssignment_4_1_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4_1_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_6__0__Impl
	rule__FacetedScalar__Group_4_1_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMinExclusiveKeyword_4_1_6_0()); }
	MinExclusive
	{ after(grammarAccess.getFacetedScalarAccess().getMinExclusiveKeyword_4_1_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMinExclusiveAssignment_4_1_6_1()); }
	(rule__FacetedScalar__MinExclusiveAssignment_4_1_6_1)
	{ after(grammarAccess.getFacetedScalarAccess().getMinExclusiveAssignment_4_1_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4_1_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_7__0__Impl
	rule__FacetedScalar__Group_4_1_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMaxInclusiveKeyword_4_1_7_0()); }
	MaxInclusive
	{ after(grammarAccess.getFacetedScalarAccess().getMaxInclusiveKeyword_4_1_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMaxInclusiveAssignment_4_1_7_1()); }
	(rule__FacetedScalar__MaxInclusiveAssignment_4_1_7_1)
	{ after(grammarAccess.getFacetedScalarAccess().getMaxInclusiveAssignment_4_1_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__Group_4_1_8__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_8__0__Impl
	rule__FacetedScalar__Group_4_1_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_8__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMaxExclusiveKeyword_4_1_8_0()); }
	MaxExclusive
	{ after(grammarAccess.getFacetedScalarAccess().getMaxExclusiveKeyword_4_1_8_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_8__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__Group_4_1_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__Group_4_1_8__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarAccess().getMaxExclusiveAssignment_4_1_8_1()); }
	(rule__FacetedScalar__MaxExclusiveAssignment_4_1_8_1)
	{ after(grammarAccess.getFacetedScalarAccess().getMaxExclusiveAssignment_4_1_8_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumeratedScalar__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group__0__Impl
	rule__EnumeratedScalar__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__EnumeratedScalar__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getEnumeratedScalarAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group__1__Impl
	rule__EnumeratedScalar__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getEnumeratedKeyword_1()); }
	Enumerated
	{ after(grammarAccess.getEnumeratedScalarAccess().getEnumeratedKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group__2__Impl
	rule__EnumeratedScalar__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getScalarKeyword_2()); }
	Scalar
	{ after(grammarAccess.getEnumeratedScalarAccess().getScalarKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group__3__Impl
	rule__EnumeratedScalar__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getNameAssignment_3()); }
	(rule__EnumeratedScalar__NameAssignment_3)
	{ after(grammarAccess.getEnumeratedScalarAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group__4__Impl
	rule__EnumeratedScalar__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getGroup_4()); }
	(rule__EnumeratedScalar__Group_4__0)?
	{ after(grammarAccess.getEnumeratedScalarAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getGroup_5()); }
	(rule__EnumeratedScalar__Group_5__0)?
	{ after(grammarAccess.getEnumeratedScalarAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumeratedScalar__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_4__0__Impl
	rule__EnumeratedScalar__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getColonGreaterThanSignKeyword_4_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getEnumeratedScalarAccess().getColonGreaterThanSignKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_4__1__Impl
	rule__EnumeratedScalar__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsAssignment_4_1()); }
	(rule__EnumeratedScalar__OwnedSpecializationsAssignment_4_1)
	{ after(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getGroup_4_2()); }
	(rule__EnumeratedScalar__Group_4_2__0)*
	{ after(grammarAccess.getEnumeratedScalarAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumeratedScalar__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_4_2__0__Impl
	rule__EnumeratedScalar__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getEnumeratedScalarAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsAssignment_4_2_1()); }
	(rule__EnumeratedScalar__OwnedSpecializationsAssignment_4_2_1)
	{ after(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumeratedScalar__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_5__0__Impl
	rule__EnumeratedScalar__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getLeftSquareBracketKeyword_5_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getEnumeratedScalarAccess().getLeftSquareBracketKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_5__1__Impl
	rule__EnumeratedScalar__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getLiteralsAssignment_5_1()); }
	(rule__EnumeratedScalar__LiteralsAssignment_5_1)
	{ after(grammarAccess.getEnumeratedScalarAccess().getLiteralsAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_5__2__Impl
	rule__EnumeratedScalar__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getGroup_5_2()); }
	(rule__EnumeratedScalar__Group_5_2__0)*
	{ after(grammarAccess.getEnumeratedScalarAccess().getGroup_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_5__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getRightSquareBracketKeyword_5_3()); }
	RightSquareBracket
	{ after(grammarAccess.getEnumeratedScalarAccess().getRightSquareBracketKeyword_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumeratedScalar__Group_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_5_2__0__Impl
	rule__EnumeratedScalar__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getCommaKeyword_5_2_0()); }
	Comma
	{ after(grammarAccess.getEnumeratedScalarAccess().getCommaKeyword_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalar__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__Group_5_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarAccess().getLiteralsAssignment_5_2_1()); }
	(rule__EnumeratedScalar__LiteralsAssignment_5_2_1)
	{ after(grammarAccess.getEnumeratedScalarAccess().getLiteralsAssignment_5_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ForwardRelation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForwardRelation__Group__0__Impl
	rule__ForwardRelation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ForwardRelation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForwardRelationAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ForwardRelation__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getForwardRelationAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForwardRelation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForwardRelation__Group__1__Impl
	rule__ForwardRelation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ForwardRelation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForwardRelationAccess().getForwardKeyword_1()); }
	Forward
	{ after(grammarAccess.getForwardRelationAccess().getForwardKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForwardRelation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForwardRelation__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ForwardRelation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForwardRelationAccess().getNameAssignment_2()); }
	(rule__ForwardRelation__NameAssignment_2)
	{ after(grammarAccess.getForwardRelationAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InverseRelation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InverseRelation__Group__0__Impl
	rule__InverseRelation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InverseRelation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInverseRelationAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__InverseRelation__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getInverseRelationAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InverseRelation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InverseRelation__Group__1__Impl
	rule__InverseRelation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InverseRelation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInverseRelationAccess().getInverseKeyword_1()); }
	Inverse
	{ after(grammarAccess.getInverseRelationAccess().getInverseKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InverseRelation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InverseRelation__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InverseRelation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInverseRelationAccess().getNameAssignment_2()); }
	(rule__InverseRelation__NameAssignment_2)
	{ after(grammarAccess.getInverseRelationAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Rule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__0__Impl
	rule__Rule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__Rule__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRuleAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__1__Impl
	rule__Rule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getRuleKeyword_1()); }
	Rule
	{ after(grammarAccess.getRuleAccess().getRuleKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__2__Impl
	rule__Rule__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getNameAssignment_2()); }
	(rule__Rule__NameAssignment_2)
	{ after(grammarAccess.getRuleAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__3__Impl
	rule__Rule__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getLeftSquareBracketKeyword_3()); }
	LeftSquareBracket
	{ after(grammarAccess.getRuleAccess().getLeftSquareBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__4__Impl
	rule__Rule__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getAntecedentAssignment_4()); }
	(rule__Rule__AntecedentAssignment_4)
	{ after(grammarAccess.getRuleAccess().getAntecedentAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__5__Impl
	rule__Rule__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getGroup_5()); }
	(rule__Rule__Group_5__0)*
	{ after(grammarAccess.getRuleAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__6__Impl
	rule__Rule__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getHyphenMinusGreaterThanSignKeyword_6()); }
	HyphenMinusGreaterThanSign
	{ after(grammarAccess.getRuleAccess().getHyphenMinusGreaterThanSignKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__7__Impl
	rule__Rule__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getConsequentAssignment_7()); }
	(rule__Rule__ConsequentAssignment_7)
	{ after(grammarAccess.getRuleAccess().getConsequentAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__8__Impl
	rule__Rule__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getGroup_8()); }
	(rule__Rule__Group_8__0)*
	{ after(grammarAccess.getRuleAccess().getGroup_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getRightSquareBracketKeyword_9()); }
	RightSquareBracket
	{ after(grammarAccess.getRuleAccess().getRightSquareBracketKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Rule__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group_5__0__Impl
	rule__Rule__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getCircumflexAccentKeyword_5_0()); }
	CircumflexAccent
	{ after(grammarAccess.getRuleAccess().getCircumflexAccentKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getAntecedentAssignment_5_1()); }
	(rule__Rule__AntecedentAssignment_5_1)
	{ after(grammarAccess.getRuleAccess().getAntecedentAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Rule__Group_8__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group_8__0__Impl
	rule__Rule__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group_8__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getCircumflexAccentKeyword_8_0()); }
	CircumflexAccent
	{ after(grammarAccess.getRuleAccess().getCircumflexAccentKeyword_8_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group_8__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Rule__Group_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__Group_8__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleAccess().getConsequentAssignment_8_1()); }
	(rule__Rule__ConsequentAssignment_8_1)
	{ after(grammarAccess.getRuleAccess().getConsequentAssignment_8_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructureInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureInstance__Group__0__Impl
	rule__StructureInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureInstanceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__StructureInstance__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getStructureInstanceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureInstance__Group__1__Impl
	rule__StructureInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureInstanceAccess().getTypeAssignment_1()); }
	(rule__StructureInstance__TypeAssignment_1)
	{ after(grammarAccess.getStructureInstanceAccess().getTypeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureInstance__Group__2__Impl
	rule__StructureInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureInstanceAccess().getLeftSquareBracketKeyword_2()); }
	LeftSquareBracket
	{ after(grammarAccess.getStructureInstanceAccess().getLeftSquareBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureInstance__Group__3__Impl
	rule__StructureInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureInstanceAccess().getOwnedPropertyValuesAssignment_3()); }
	(rule__StructureInstance__OwnedPropertyValuesAssignment_3)*
	{ after(grammarAccess.getStructureInstanceAccess().getOwnedPropertyValuesAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureInstance__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureInstanceAccess().getRightSquareBracketKeyword_4()); }
	RightSquareBracket
	{ after(grammarAccess.getStructureInstanceAccess().getRightSquareBracketKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__0__Impl
	rule__ConceptInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ConceptInstance__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getConceptInstanceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__1__Impl
	rule__ConceptInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getCiKeyword_1()); }
	Ci
	{ after(grammarAccess.getConceptInstanceAccess().getCiKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__2__Impl
	rule__ConceptInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getNameAssignment_2()); }
	(rule__ConceptInstance__NameAssignment_2)
	{ after(grammarAccess.getConceptInstanceAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__3__Impl
	rule__ConceptInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getGroup_3()); }
	(rule__ConceptInstance__Group_3__0)?
	{ after(grammarAccess.getConceptInstanceAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getGroup_4()); }
	(rule__ConceptInstance__Group_4__0)?
	{ after(grammarAccess.getConceptInstanceAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptInstance__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group_3__0__Impl
	rule__ConceptInstance__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getColonKeyword_3_0()); }
	Colon
	{ after(grammarAccess.getConceptInstanceAccess().getColonKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group_3__1__Impl
	rule__ConceptInstance__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getOwnedTypesAssignment_3_1()); }
	(rule__ConceptInstance__OwnedTypesAssignment_3_1)
	{ after(grammarAccess.getConceptInstanceAccess().getOwnedTypesAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getGroup_3_2()); }
	(rule__ConceptInstance__Group_3_2__0)*
	{ after(grammarAccess.getConceptInstanceAccess().getGroup_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptInstance__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group_3_2__0__Impl
	rule__ConceptInstance__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getCommaKeyword_3_2_0()); }
	Comma
	{ after(grammarAccess.getConceptInstanceAccess().getCommaKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getOwnedTypesAssignment_3_2_1()); }
	(rule__ConceptInstance__OwnedTypesAssignment_3_2_1)
	{ after(grammarAccess.getConceptInstanceAccess().getOwnedTypesAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptInstance__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group_4__0__Impl
	rule__ConceptInstance__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getLeftSquareBracketKeyword_4_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getConceptInstanceAccess().getLeftSquareBracketKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group_4__1__Impl
	rule__ConceptInstance__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getOwnedPropertyValuesAssignment_4_1()); }
	(rule__ConceptInstance__OwnedPropertyValuesAssignment_4_1)*
	{ after(grammarAccess.getConceptInstanceAccess().getOwnedPropertyValuesAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group_4__2__Impl
	rule__ConceptInstance__Group_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getOwnedLinksAssignment_4_2()); }
	(rule__ConceptInstance__OwnedLinksAssignment_4_2)*
	{ after(grammarAccess.getConceptInstanceAccess().getOwnedLinksAssignment_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getRightSquareBracketKeyword_4_3()); }
	RightSquareBracket
	{ after(grammarAccess.getConceptInstanceAccess().getRightSquareBracketKeyword_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group__0__Impl
	rule__RelationInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationInstance__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationInstanceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group__1__Impl
	rule__RelationInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getRiKeyword_1()); }
	Ri
	{ after(grammarAccess.getRelationInstanceAccess().getRiKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group__2__Impl
	rule__RelationInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getNameAssignment_2()); }
	(rule__RelationInstance__NameAssignment_2)
	{ after(grammarAccess.getRelationInstanceAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group__3__Impl
	rule__RelationInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getGroup_3()); }
	(rule__RelationInstance__Group_3__0)?
	{ after(grammarAccess.getRelationInstanceAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getGroup_4()); }
	(rule__RelationInstance__Group_4__0)?
	{ after(grammarAccess.getRelationInstanceAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationInstance__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_3__0__Impl
	rule__RelationInstance__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getColonKeyword_3_0()); }
	Colon
	{ after(grammarAccess.getRelationInstanceAccess().getColonKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_3__1__Impl
	rule__RelationInstance__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getOwnedTypesAssignment_3_1()); }
	(rule__RelationInstance__OwnedTypesAssignment_3_1)
	{ after(grammarAccess.getRelationInstanceAccess().getOwnedTypesAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getGroup_3_2()); }
	(rule__RelationInstance__Group_3_2__0)*
	{ after(grammarAccess.getRelationInstanceAccess().getGroup_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationInstance__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_3_2__0__Impl
	rule__RelationInstance__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getCommaKeyword_3_2_0()); }
	Comma
	{ after(grammarAccess.getRelationInstanceAccess().getCommaKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getOwnedTypesAssignment_3_2_1()); }
	(rule__RelationInstance__OwnedTypesAssignment_3_2_1)
	{ after(grammarAccess.getRelationInstanceAccess().getOwnedTypesAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationInstance__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_4__0__Impl
	rule__RelationInstance__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getLeftSquareBracketKeyword_4_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getRelationInstanceAccess().getLeftSquareBracketKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_4__1__Impl
	rule__RelationInstance__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getFromKeyword_4_1()); }
	From
	{ after(grammarAccess.getRelationInstanceAccess().getFromKeyword_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_4__2__Impl
	rule__RelationInstance__Group_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getSourceAssignment_4_2()); }
	(rule__RelationInstance__SourceAssignment_4_2)
	{ after(grammarAccess.getRelationInstanceAccess().getSourceAssignment_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_4__3__Impl
	rule__RelationInstance__Group_4__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getToKeyword_4_3()); }
	To
	{ after(grammarAccess.getRelationInstanceAccess().getToKeyword_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_4__4__Impl
	rule__RelationInstance__Group_4__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getTargetAssignment_4_4()); }
	(rule__RelationInstance__TargetAssignment_4_4)
	{ after(grammarAccess.getRelationInstanceAccess().getTargetAssignment_4_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_4__5__Impl
	rule__RelationInstance__Group_4__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getOwnedPropertyValuesAssignment_4_5()); }
	(rule__RelationInstance__OwnedPropertyValuesAssignment_4_5)*
	{ after(grammarAccess.getRelationInstanceAccess().getOwnedPropertyValuesAssignment_4_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_4__6__Impl
	rule__RelationInstance__Group_4__7
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getOwnedLinksAssignment_4_6()); }
	(rule__RelationInstance__OwnedLinksAssignment_4_6)*
	{ after(grammarAccess.getRelationInstanceAccess().getOwnedLinksAssignment_4_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstance__Group_4__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__Group_4__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceAccess().getRightSquareBracketKeyword_4_7()); }
	RightSquareBracket
	{ after(grammarAccess.getRelationInstanceAccess().getRightSquareBracketKeyword_4_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AspectReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group__0__Impl
	rule__AspectReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__AspectReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getAspectReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group__1__Impl
	rule__AspectReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getAspectReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group__2__Impl
	rule__AspectReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getAspectKeyword_2()); }
	Aspect
	{ after(grammarAccess.getAspectReferenceAccess().getAspectKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group__3__Impl
	rule__AspectReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getAspectAssignment_3()); }
	(rule__AspectReference__AspectAssignment_3)
	{ after(grammarAccess.getAspectReferenceAccess().getAspectAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group__4__Impl
	rule__AspectReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getGroup_4()); }
	(rule__AspectReference__Group_4__0)?
	{ after(grammarAccess.getAspectReferenceAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getGroup_5()); }
	(rule__AspectReference__Group_5__0)?
	{ after(grammarAccess.getAspectReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AspectReference__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_4__0__Impl
	rule__AspectReference__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getColonGreaterThanSignKeyword_4_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getAspectReferenceAccess().getColonGreaterThanSignKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_4__1__Impl
	rule__AspectReference__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsAssignment_4_1()); }
	(rule__AspectReference__OwnedSpecializationsAssignment_4_1)
	{ after(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getGroup_4_2()); }
	(rule__AspectReference__Group_4_2__0)*
	{ after(grammarAccess.getAspectReferenceAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AspectReference__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_4_2__0__Impl
	rule__AspectReference__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getAspectReferenceAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsAssignment_4_2_1()); }
	(rule__AspectReference__OwnedSpecializationsAssignment_4_2_1)
	{ after(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AspectReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_5__0__Impl
	rule__AspectReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getAspectReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_5__1__Impl
	rule__AspectReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getOwnedKeysAssignment_5_1()); }
	(rule__AspectReference__OwnedKeysAssignment_5_1)*
	{ after(grammarAccess.getAspectReferenceAccess().getOwnedKeysAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_5__2__Impl
	rule__AspectReference__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getOwnedPropertyRestrictionsAssignment_5_2()); }
	(rule__AspectReference__OwnedPropertyRestrictionsAssignment_5_2)*
	{ after(grammarAccess.getAspectReferenceAccess().getOwnedPropertyRestrictionsAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_5__3__Impl
	rule__AspectReference__Group_5__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getOwnedRelationRestrictionsAssignment_5_3()); }
	(rule__AspectReference__OwnedRelationRestrictionsAssignment_5_3)*
	{ after(grammarAccess.getAspectReferenceAccess().getOwnedRelationRestrictionsAssignment_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_5__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectReference__Group_5__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__Group_5__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectReferenceAccess().getRightSquareBracketKeyword_5_4()); }
	RightSquareBracket
	{ after(grammarAccess.getAspectReferenceAccess().getRightSquareBracketKeyword_5_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group__0__Impl
	rule__ConceptReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ConceptReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getConceptReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group__1__Impl
	rule__ConceptReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getConceptReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group__2__Impl
	rule__ConceptReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getConceptKeyword_2()); }
	Concept
	{ after(grammarAccess.getConceptReferenceAccess().getConceptKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group__3__Impl
	rule__ConceptReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getConceptAssignment_3()); }
	(rule__ConceptReference__ConceptAssignment_3)
	{ after(grammarAccess.getConceptReferenceAccess().getConceptAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group__4__Impl
	rule__ConceptReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getGroup_4()); }
	(rule__ConceptReference__Group_4__0)?
	{ after(grammarAccess.getConceptReferenceAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getGroup_5()); }
	(rule__ConceptReference__Group_5__0)?
	{ after(grammarAccess.getConceptReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptReference__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_4__0__Impl
	rule__ConceptReference__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getColonGreaterThanSignKeyword_4_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getConceptReferenceAccess().getColonGreaterThanSignKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_4__1__Impl
	rule__ConceptReference__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsAssignment_4_1()); }
	(rule__ConceptReference__OwnedSpecializationsAssignment_4_1)
	{ after(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getGroup_4_2()); }
	(rule__ConceptReference__Group_4_2__0)*
	{ after(grammarAccess.getConceptReferenceAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptReference__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_4_2__0__Impl
	rule__ConceptReference__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getConceptReferenceAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsAssignment_4_2_1()); }
	(rule__ConceptReference__OwnedSpecializationsAssignment_4_2_1)
	{ after(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_5__0__Impl
	rule__ConceptReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getConceptReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_5__1__Impl
	rule__ConceptReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getOwnedKeysAssignment_5_1()); }
	(rule__ConceptReference__OwnedKeysAssignment_5_1)*
	{ after(grammarAccess.getConceptReferenceAccess().getOwnedKeysAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_5__2__Impl
	rule__ConceptReference__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getOwnedPropertyRestrictionsAssignment_5_2()); }
	(rule__ConceptReference__OwnedPropertyRestrictionsAssignment_5_2)*
	{ after(grammarAccess.getConceptReferenceAccess().getOwnedPropertyRestrictionsAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_5__3__Impl
	rule__ConceptReference__Group_5__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getOwnedRelationRestrictionsAssignment_5_3()); }
	(rule__ConceptReference__OwnedRelationRestrictionsAssignment_5_3)*
	{ after(grammarAccess.getConceptReferenceAccess().getOwnedRelationRestrictionsAssignment_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_5__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptReference__Group_5__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__Group_5__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptReferenceAccess().getRightSquareBracketKeyword_5_4()); }
	RightSquareBracket
	{ after(grammarAccess.getConceptReferenceAccess().getRightSquareBracketKeyword_5_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntityReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group__0__Impl
	rule__RelationEntityReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationEntityReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group__1__Impl
	rule__RelationEntityReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getRelationEntityReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group__2__Impl
	rule__RelationEntityReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getRelationKeyword_2()); }
	Relation
	{ after(grammarAccess.getRelationEntityReferenceAccess().getRelationKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group__3__Impl
	rule__RelationEntityReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getEntityKeyword_3()); }
	Entity
	{ after(grammarAccess.getRelationEntityReferenceAccess().getEntityKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group__4__Impl
	rule__RelationEntityReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getEntityAssignment_4()); }
	(rule__RelationEntityReference__EntityAssignment_4)
	{ after(grammarAccess.getRelationEntityReferenceAccess().getEntityAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group__5__Impl
	rule__RelationEntityReference__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getGroup_5()); }
	(rule__RelationEntityReference__Group_5__0)?
	{ after(grammarAccess.getRelationEntityReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getGroup_6()); }
	(rule__RelationEntityReference__Group_6__0)?
	{ after(grammarAccess.getRelationEntityReferenceAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntityReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_5__0__Impl
	rule__RelationEntityReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getRelationEntityReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_5__1__Impl
	rule__RelationEntityReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
	(rule__RelationEntityReference__OwnedSpecializationsAssignment_5_1)
	{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getGroup_5_2()); }
	(rule__RelationEntityReference__Group_5_2__0)*
	{ after(grammarAccess.getRelationEntityReferenceAccess().getGroup_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntityReference__Group_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_5_2__0__Impl
	rule__RelationEntityReference__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getCommaKeyword_5_2_0()); }
	Comma
	{ after(grammarAccess.getRelationEntityReferenceAccess().getCommaKeyword_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_5_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_5_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
	(rule__RelationEntityReference__OwnedSpecializationsAssignment_5_2_1)
	{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntityReference__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_6__0__Impl
	rule__RelationEntityReference__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getLeftSquareBracketKeyword_6_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getRelationEntityReferenceAccess().getLeftSquareBracketKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_6__1__Impl
	rule__RelationEntityReference__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedKeysAssignment_6_1()); }
	(rule__RelationEntityReference__OwnedKeysAssignment_6_1)*
	{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedKeysAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_6__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_6__2__Impl
	rule__RelationEntityReference__Group_6__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_6__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedPropertyRestrictionsAssignment_6_2()); }
	(rule__RelationEntityReference__OwnedPropertyRestrictionsAssignment_6_2)*
	{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedPropertyRestrictionsAssignment_6_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_6__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_6__3__Impl
	rule__RelationEntityReference__Group_6__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_6__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedRelationRestrictionsAssignment_6_3()); }
	(rule__RelationEntityReference__OwnedRelationRestrictionsAssignment_6_3)*
	{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedRelationRestrictionsAssignment_6_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_6__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityReference__Group_6__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__Group_6__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityReferenceAccess().getRightSquareBracketKeyword_6_4()); }
	RightSquareBracket
	{ after(grammarAccess.getRelationEntityReferenceAccess().getRightSquareBracketKeyword_6_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructureReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group__0__Impl
	rule__StructureReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__StructureReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getStructureReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group__1__Impl
	rule__StructureReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getStructureReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group__2__Impl
	rule__StructureReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getStructureKeyword_2()); }
	Structure
	{ after(grammarAccess.getStructureReferenceAccess().getStructureKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group__3__Impl
	rule__StructureReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getStructureAssignment_3()); }
	(rule__StructureReference__StructureAssignment_3)
	{ after(grammarAccess.getStructureReferenceAccess().getStructureAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group__4__Impl
	rule__StructureReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getGroup_4()); }
	(rule__StructureReference__Group_4__0)?
	{ after(grammarAccess.getStructureReferenceAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getGroup_5()); }
	(rule__StructureReference__Group_5__0)?
	{ after(grammarAccess.getStructureReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructureReference__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group_4__0__Impl
	rule__StructureReference__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getColonGreaterThanSignKeyword_4_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getStructureReferenceAccess().getColonGreaterThanSignKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group_4__1__Impl
	rule__StructureReference__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsAssignment_4_1()); }
	(rule__StructureReference__OwnedSpecializationsAssignment_4_1)
	{ after(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getGroup_4_2()); }
	(rule__StructureReference__Group_4_2__0)*
	{ after(grammarAccess.getStructureReferenceAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructureReference__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group_4_2__0__Impl
	rule__StructureReference__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getStructureReferenceAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsAssignment_4_2_1()); }
	(rule__StructureReference__OwnedSpecializationsAssignment_4_2_1)
	{ after(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructureReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group_5__0__Impl
	rule__StructureReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getStructureReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group_5__1__Impl
	rule__StructureReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getOwnedPropertyRestrictionsAssignment_5_1()); }
	(rule__StructureReference__OwnedPropertyRestrictionsAssignment_5_1)*
	{ after(grammarAccess.getStructureReferenceAccess().getOwnedPropertyRestrictionsAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructureReference__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureReferenceAccess().getRightSquareBracketKeyword_5_2()); }
	RightSquareBracket
	{ after(grammarAccess.getStructureReferenceAccess().getRightSquareBracketKeyword_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationPropertyReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group__0__Impl
	rule__AnnotationPropertyReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__AnnotationPropertyReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group__1__Impl
	rule__AnnotationPropertyReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group__2__Impl
	rule__AnnotationPropertyReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getAnnotationKeyword_2()); }
	Annotation
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getAnnotationKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group__3__Impl
	rule__AnnotationPropertyReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getPropertyKeyword_3()); }
	Property
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getPropertyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group__4__Impl
	rule__AnnotationPropertyReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getPropertyAssignment_4()); }
	(rule__AnnotationPropertyReference__PropertyAssignment_4)
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getGroup_5()); }
	(rule__AnnotationPropertyReference__Group_5__0)?
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationPropertyReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group_5__0__Impl
	rule__AnnotationPropertyReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group_5__1__Impl
	rule__AnnotationPropertyReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
	(rule__AnnotationPropertyReference__OwnedSpecializationsAssignment_5_1)
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getGroup_5_2()); }
	(rule__AnnotationPropertyReference__Group_5_2__0)*
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getGroup_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationPropertyReference__Group_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group_5_2__0__Impl
	rule__AnnotationPropertyReference__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getCommaKeyword_5_2_0()); }
	Comma
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getCommaKeyword_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group_5_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyReference__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__Group_5_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
	(rule__AnnotationPropertyReference__OwnedSpecializationsAssignment_5_2_1)
	{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarPropertyReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group__0__Impl
	rule__ScalarPropertyReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ScalarPropertyReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group__1__Impl
	rule__ScalarPropertyReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group__2__Impl
	rule__ScalarPropertyReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getScalarKeyword_2()); }
	Scalar
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getScalarKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group__3__Impl
	rule__ScalarPropertyReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getPropertyKeyword_3()); }
	Property
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getPropertyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group__4__Impl
	rule__ScalarPropertyReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getPropertyAssignment_4()); }
	(rule__ScalarPropertyReference__PropertyAssignment_4)
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getGroup_5()); }
	(rule__ScalarPropertyReference__Group_5__0)?
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarPropertyReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group_5__0__Impl
	rule__ScalarPropertyReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group_5__1__Impl
	rule__ScalarPropertyReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
	(rule__ScalarPropertyReference__OwnedSpecializationsAssignment_5_1)
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getGroup_5_2()); }
	(rule__ScalarPropertyReference__Group_5_2__0)*
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getGroup_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarPropertyReference__Group_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group_5_2__0__Impl
	rule__ScalarPropertyReference__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getCommaKeyword_5_2_0()); }
	Comma
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getCommaKeyword_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group_5_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyReference__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__Group_5_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
	(rule__ScalarPropertyReference__OwnedSpecializationsAssignment_5_2_1)
	{ after(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredPropertyReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group__0__Impl
	rule__StructuredPropertyReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__StructuredPropertyReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group__1__Impl
	rule__StructuredPropertyReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group__2__Impl
	rule__StructuredPropertyReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getStructuredKeyword_2()); }
	Structured
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getStructuredKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group__3__Impl
	rule__StructuredPropertyReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getPropertyKeyword_3()); }
	Property
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getPropertyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group__4__Impl
	rule__StructuredPropertyReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getPropertyAssignment_4()); }
	(rule__StructuredPropertyReference__PropertyAssignment_4)
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getGroup_5()); }
	(rule__StructuredPropertyReference__Group_5__0)?
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredPropertyReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group_5__0__Impl
	rule__StructuredPropertyReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group_5__1__Impl
	rule__StructuredPropertyReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
	(rule__StructuredPropertyReference__OwnedSpecializationsAssignment_5_1)
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getGroup_5_2()); }
	(rule__StructuredPropertyReference__Group_5_2__0)*
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getGroup_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredPropertyReference__Group_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group_5_2__0__Impl
	rule__StructuredPropertyReference__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getCommaKeyword_5_2_0()); }
	Comma
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getCommaKeyword_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group_5_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyReference__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__Group_5_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
	(rule__StructuredPropertyReference__OwnedSpecializationsAssignment_5_2_1)
	{ after(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalarReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group__0__Impl
	rule__FacetedScalarReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__FacetedScalarReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group__1__Impl
	rule__FacetedScalarReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group__2__Impl
	rule__FacetedScalarReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getScalarKeyword_2()); }
	Scalar
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getScalarKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group__3__Impl
	rule__FacetedScalarReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getScalarAssignment_3()); }
	(rule__FacetedScalarReference__ScalarAssignment_3)
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getScalarAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getGroup_4()); }
	(rule__FacetedScalarReference__Group_4__0)?
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalarReference__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group_4__0__Impl
	rule__FacetedScalarReference__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getColonGreaterThanSignKeyword_4_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getColonGreaterThanSignKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group_4__1__Impl
	rule__FacetedScalarReference__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsAssignment_4_1()); }
	(rule__FacetedScalarReference__OwnedSpecializationsAssignment_4_1)
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getGroup_4_2()); }
	(rule__FacetedScalarReference__Group_4_2__0)*
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalarReference__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group_4_2__0__Impl
	rule__FacetedScalarReference__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalarReference__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsAssignment_4_2_1()); }
	(rule__FacetedScalarReference__OwnedSpecializationsAssignment_4_2_1)
	{ after(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumeratedScalarReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group__0__Impl
	rule__EnumeratedScalarReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__EnumeratedScalarReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group__1__Impl
	rule__EnumeratedScalarReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group__2__Impl
	rule__EnumeratedScalarReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getEnumeratedKeyword_2()); }
	Enumerated
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getEnumeratedKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group__3__Impl
	rule__EnumeratedScalarReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getScalarKeyword_3()); }
	Scalar
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getScalarKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group__4__Impl
	rule__EnumeratedScalarReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getScalarAssignment_4()); }
	(rule__EnumeratedScalarReference__ScalarAssignment_4)
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getScalarAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getGroup_5()); }
	(rule__EnumeratedScalarReference__Group_5__0)?
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumeratedScalarReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group_5__0__Impl
	rule__EnumeratedScalarReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
	ColonGreaterThanSign
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getColonGreaterThanSignKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group_5__1__Impl
	rule__EnumeratedScalarReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
	(rule__EnumeratedScalarReference__OwnedSpecializationsAssignment_5_1)
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getGroup_5_2()); }
	(rule__EnumeratedScalarReference__Group_5_2__0)*
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getGroup_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumeratedScalarReference__Group_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group_5_2__0__Impl
	rule__EnumeratedScalarReference__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getCommaKeyword_5_2_0()); }
	Comma
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getCommaKeyword_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group_5_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumeratedScalarReference__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__Group_5_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
	(rule__EnumeratedScalarReference__OwnedSpecializationsAssignment_5_2_1)
	{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsAssignment_5_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationReference__Group__0__Impl
	rule__RelationReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationReference__Group__1__Impl
	rule__RelationReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getRelationReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationReference__Group__2__Impl
	rule__RelationReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationReferenceAccess().getRelationKeyword_2()); }
	Relation
	{ after(grammarAccess.getRelationReferenceAccess().getRelationKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationReference__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationReferenceAccess().getRelationAssignment_3()); }
	(rule__RelationReference__RelationAssignment_3)
	{ after(grammarAccess.getRelationReferenceAccess().getRelationAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleReference__Group__0__Impl
	rule__RuleReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RuleReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRuleReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleReference__Group__1__Impl
	rule__RuleReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getRuleReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleReference__Group__2__Impl
	rule__RuleReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleReferenceAccess().getRuleKeyword_2()); }
	Rule
	{ after(grammarAccess.getRuleReferenceAccess().getRuleKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleReference__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleReferenceAccess().getRuleAssignment_3()); }
	(rule__RuleReference__RuleAssignment_3)
	{ after(grammarAccess.getRuleReferenceAccess().getRuleAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptInstanceReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group__0__Impl
	rule__ConceptInstanceReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ConceptInstanceReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group__1__Impl
	rule__ConceptInstanceReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group__2__Impl
	rule__ConceptInstanceReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getCiKeyword_2()); }
	Ci
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getCiKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group__3__Impl
	rule__ConceptInstanceReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getInstanceAssignment_3()); }
	(rule__ConceptInstanceReference__InstanceAssignment_3)
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getInstanceAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group__4__Impl
	rule__ConceptInstanceReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getGroup_4()); }
	(rule__ConceptInstanceReference__Group_4__0)?
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getGroup_5()); }
	(rule__ConceptInstanceReference__Group_5__0)?
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptInstanceReference__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group_4__0__Impl
	rule__ConceptInstanceReference__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getColonKeyword_4_0()); }
	Colon
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getColonKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group_4__1__Impl
	rule__ConceptInstanceReference__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesAssignment_4_1()); }
	(rule__ConceptInstanceReference__OwnedTypesAssignment_4_1)
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getGroup_4_2()); }
	(rule__ConceptInstanceReference__Group_4_2__0)*
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptInstanceReference__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group_4_2__0__Impl
	rule__ConceptInstanceReference__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesAssignment_4_2_1()); }
	(rule__ConceptInstanceReference__OwnedTypesAssignment_4_2_1)
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptInstanceReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group_5__0__Impl
	rule__ConceptInstanceReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group_5__1__Impl
	rule__ConceptInstanceReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedPropertyValuesAssignment_5_1()); }
	(rule__ConceptInstanceReference__OwnedPropertyValuesAssignment_5_1)*
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedPropertyValuesAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group_5__2__Impl
	rule__ConceptInstanceReference__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedLinksAssignment_5_2()); }
	(rule__ConceptInstanceReference__OwnedLinksAssignment_5_2)*
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedLinksAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstanceReference__Group_5__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceReferenceAccess().getRightSquareBracketKeyword_5_3()); }
	RightSquareBracket
	{ after(grammarAccess.getConceptInstanceReferenceAccess().getRightSquareBracketKeyword_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationInstanceReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group__0__Impl
	rule__RelationInstanceReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationInstanceReference__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group__1__Impl
	rule__RelationInstanceReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getRefKeyword_1()); }
	Ref
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getRefKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group__2__Impl
	rule__RelationInstanceReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getRiKeyword_2()); }
	Ri
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getRiKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group__3__Impl
	rule__RelationInstanceReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getInstanceAssignment_3()); }
	(rule__RelationInstanceReference__InstanceAssignment_3)
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getInstanceAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group__4__Impl
	rule__RelationInstanceReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getGroup_4()); }
	(rule__RelationInstanceReference__Group_4__0)?
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getGroup_5()); }
	(rule__RelationInstanceReference__Group_5__0)?
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationInstanceReference__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group_4__0__Impl
	rule__RelationInstanceReference__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getColonKeyword_4_0()); }
	Colon
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getColonKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group_4__1__Impl
	rule__RelationInstanceReference__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesAssignment_4_1()); }
	(rule__RelationInstanceReference__OwnedTypesAssignment_4_1)
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getGroup_4_2()); }
	(rule__RelationInstanceReference__Group_4_2__0)*
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationInstanceReference__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group_4_2__0__Impl
	rule__RelationInstanceReference__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getCommaKeyword_4_2_0()); }
	Comma
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesAssignment_4_2_1()); }
	(rule__RelationInstanceReference__OwnedTypesAssignment_4_2_1)
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationInstanceReference__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group_5__0__Impl
	rule__RelationInstanceReference__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
	LeftSquareBracket
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getLeftSquareBracketKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group_5__1__Impl
	rule__RelationInstanceReference__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedPropertyValuesAssignment_5_1()); }
	(rule__RelationInstanceReference__OwnedPropertyValuesAssignment_5_1)*
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedPropertyValuesAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group_5__2__Impl
	rule__RelationInstanceReference__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedLinksAssignment_5_2()); }
	(rule__RelationInstanceReference__OwnedLinksAssignment_5_2)*
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedLinksAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationInstanceReference__Group_5__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationInstanceReferenceAccess().getRightSquareBracketKeyword_5_3()); }
	RightSquareBracket
	{ after(grammarAccess.getRelationInstanceReferenceAccess().getRightSquareBracketKeyword_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VocabularyExtension__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyExtension__Group__0__Impl
	rule__VocabularyExtension__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyExtensionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__VocabularyExtension__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getVocabularyExtensionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyExtension__Group__1__Impl
	rule__VocabularyExtension__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyExtensionAccess().getExtendsKeyword_1()); }
	Extends
	{ after(grammarAccess.getVocabularyExtensionAccess().getExtendsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyExtension__Group__2__Impl
	rule__VocabularyExtension__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyExtensionAccess().getUriAssignment_2()); }
	(rule__VocabularyExtension__UriAssignment_2)
	{ after(grammarAccess.getVocabularyExtensionAccess().getUriAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyExtension__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyExtensionAccess().getGroup_3()); }
	(rule__VocabularyExtension__Group_3__0)?
	{ after(grammarAccess.getVocabularyExtensionAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VocabularyExtension__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyExtension__Group_3__0__Impl
	rule__VocabularyExtension__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyExtensionAccess().getAsKeyword_3_0()); }
	As
	{ after(grammarAccess.getVocabularyExtensionAccess().getAsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyExtension__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyExtensionAccess().getPrefixAssignment_3_1()); }
	(rule__VocabularyExtension__PrefixAssignment_3_1)
	{ after(grammarAccess.getVocabularyExtensionAccess().getPrefixAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VocabularyUsage__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyUsage__Group__0__Impl
	rule__VocabularyUsage__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyUsageAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__VocabularyUsage__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getVocabularyUsageAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyUsage__Group__1__Impl
	rule__VocabularyUsage__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyUsageAccess().getUsesKeyword_1()); }
	Uses
	{ after(grammarAccess.getVocabularyUsageAccess().getUsesKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyUsage__Group__2__Impl
	rule__VocabularyUsage__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyUsageAccess().getUriAssignment_2()); }
	(rule__VocabularyUsage__UriAssignment_2)
	{ after(grammarAccess.getVocabularyUsageAccess().getUriAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyUsage__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyUsageAccess().getGroup_3()); }
	(rule__VocabularyUsage__Group_3__0)?
	{ after(grammarAccess.getVocabularyUsageAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VocabularyUsage__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyUsage__Group_3__0__Impl
	rule__VocabularyUsage__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyUsageAccess().getAsKeyword_3_0()); }
	As
	{ after(grammarAccess.getVocabularyUsageAccess().getAsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VocabularyUsage__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVocabularyUsageAccess().getPrefixAssignment_3_1()); }
	(rule__VocabularyUsage__PrefixAssignment_3_1)
	{ after(grammarAccess.getVocabularyUsageAccess().getPrefixAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BundleInclusion__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleInclusion__Group__0__Impl
	rule__BundleInclusion__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleInclusionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__BundleInclusion__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getBundleInclusionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleInclusion__Group__1__Impl
	rule__BundleInclusion__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleInclusionAccess().getIncludesKeyword_1()); }
	Includes
	{ after(grammarAccess.getBundleInclusionAccess().getIncludesKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleInclusion__Group__2__Impl
	rule__BundleInclusion__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleInclusionAccess().getUriAssignment_2()); }
	(rule__BundleInclusion__UriAssignment_2)
	{ after(grammarAccess.getBundleInclusionAccess().getUriAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleInclusion__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleInclusionAccess().getGroup_3()); }
	(rule__BundleInclusion__Group_3__0)?
	{ after(grammarAccess.getBundleInclusionAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BundleInclusion__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleInclusion__Group_3__0__Impl
	rule__BundleInclusion__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleInclusionAccess().getAsKeyword_3_0()); }
	As
	{ after(grammarAccess.getBundleInclusionAccess().getAsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleInclusion__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleInclusionAccess().getPrefixAssignment_3_1()); }
	(rule__BundleInclusion__PrefixAssignment_3_1)
	{ after(grammarAccess.getBundleInclusionAccess().getPrefixAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BundleExtension__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleExtension__Group__0__Impl
	rule__BundleExtension__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleExtensionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__BundleExtension__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getBundleExtensionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleExtension__Group__1__Impl
	rule__BundleExtension__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleExtensionAccess().getExtendsKeyword_1()); }
	Extends
	{ after(grammarAccess.getBundleExtensionAccess().getExtendsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleExtension__Group__2__Impl
	rule__BundleExtension__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleExtensionAccess().getUriAssignment_2()); }
	(rule__BundleExtension__UriAssignment_2)
	{ after(grammarAccess.getBundleExtensionAccess().getUriAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleExtension__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleExtensionAccess().getGroup_3()); }
	(rule__BundleExtension__Group_3__0)?
	{ after(grammarAccess.getBundleExtensionAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BundleExtension__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleExtension__Group_3__0__Impl
	rule__BundleExtension__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleExtensionAccess().getAsKeyword_3_0()); }
	As
	{ after(grammarAccess.getBundleExtensionAccess().getAsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundleExtension__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleExtensionAccess().getPrefixAssignment_3_1()); }
	(rule__BundleExtension__PrefixAssignment_3_1)
	{ after(grammarAccess.getBundleExtensionAccess().getPrefixAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DescriptionUsage__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionUsage__Group__0__Impl
	rule__DescriptionUsage__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionUsageAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__DescriptionUsage__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getDescriptionUsageAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionUsage__Group__1__Impl
	rule__DescriptionUsage__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionUsageAccess().getUsesKeyword_1()); }
	Uses
	{ after(grammarAccess.getDescriptionUsageAccess().getUsesKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionUsage__Group__2__Impl
	rule__DescriptionUsage__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionUsageAccess().getUriAssignment_2()); }
	(rule__DescriptionUsage__UriAssignment_2)
	{ after(grammarAccess.getDescriptionUsageAccess().getUriAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionUsage__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionUsageAccess().getGroup_3()); }
	(rule__DescriptionUsage__Group_3__0)?
	{ after(grammarAccess.getDescriptionUsageAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DescriptionUsage__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionUsage__Group_3__0__Impl
	rule__DescriptionUsage__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionUsageAccess().getAsKeyword_3_0()); }
	As
	{ after(grammarAccess.getDescriptionUsageAccess().getAsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionUsage__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionUsageAccess().getPrefixAssignment_3_1()); }
	(rule__DescriptionUsage__PrefixAssignment_3_1)
	{ after(grammarAccess.getDescriptionUsageAccess().getPrefixAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DescriptionExtension__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionExtension__Group__0__Impl
	rule__DescriptionExtension__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionExtensionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__DescriptionExtension__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getDescriptionExtensionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionExtension__Group__1__Impl
	rule__DescriptionExtension__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionExtensionAccess().getExtendsKeyword_1()); }
	Extends
	{ after(grammarAccess.getDescriptionExtensionAccess().getExtendsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionExtension__Group__2__Impl
	rule__DescriptionExtension__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionExtensionAccess().getUriAssignment_2()); }
	(rule__DescriptionExtension__UriAssignment_2)
	{ after(grammarAccess.getDescriptionExtensionAccess().getUriAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionExtension__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionExtensionAccess().getGroup_3()); }
	(rule__DescriptionExtension__Group_3__0)?
	{ after(grammarAccess.getDescriptionExtensionAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DescriptionExtension__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionExtension__Group_3__0__Impl
	rule__DescriptionExtension__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionExtensionAccess().getAsKeyword_3_0()); }
	As
	{ after(grammarAccess.getDescriptionExtensionAccess().getAsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionExtension__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionExtensionAccess().getPrefixAssignment_3_1()); }
	(rule__DescriptionExtension__PrefixAssignment_3_1)
	{ after(grammarAccess.getDescriptionExtensionAccess().getPrefixAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SpecializationAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SpecializationAxiom__Group__0__Impl
	rule__SpecializationAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecializationAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSpecializationAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__SpecializationAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getSpecializationAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecializationAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SpecializationAxiom__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecializationAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSpecializationAxiomAccess().getSpecializedTermAssignment_1()); }
	(rule__SpecializationAxiom__SpecializedTermAssignment_1)
	{ after(grammarAccess.getSpecializationAxiomAccess().getSpecializedTermAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarPropertyRangeRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyRangeRestrictionAxiom__Group__0__Impl
	rule__ScalarPropertyRangeRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ScalarPropertyRangeRestrictionAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyRangeRestrictionAxiom__Group__1__Impl
	rule__ScalarPropertyRangeRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_1()); }
	Restricts
	{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyRangeRestrictionAxiom__Group__2__Impl
	rule__ScalarPropertyRangeRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getKindAssignment_2()); }
	(rule__ScalarPropertyRangeRestrictionAxiom__KindAssignment_2)
	{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getKindAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyRangeRestrictionAxiom__Group__3__Impl
	rule__ScalarPropertyRangeRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getScalarKeyword_3()); }
	Scalar
	{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getScalarKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyRangeRestrictionAxiom__Group__4__Impl
	rule__ScalarPropertyRangeRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_4()); }
	Property
	{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyRangeRestrictionAxiom__Group__5__Impl
	rule__ScalarPropertyRangeRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyAssignment_5()); }
	(rule__ScalarPropertyRangeRestrictionAxiom__PropertyAssignment_5)
	{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyRangeRestrictionAxiom__Group__6__Impl
	rule__ScalarPropertyRangeRestrictionAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getToKeyword_6()); }
	To
	{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getToKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyRangeRestrictionAxiom__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRangeAssignment_7()); }
	(rule__ScalarPropertyRangeRestrictionAxiom__RangeAssignment_7)
	{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRangeAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarPropertyCardinalityRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__0__Impl
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ScalarPropertyCardinalityRestrictionAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__1__Impl
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_1()); }
	Restricts
	{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__2__Impl
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getScalarKeyword_2()); }
	Scalar
	{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getScalarKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__3__Impl
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_3()); }
	Property
	{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__4__Impl
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyAssignment_4()); }
	(rule__ScalarPropertyCardinalityRestrictionAxiom__PropertyAssignment_4)
	{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__5__Impl
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getToKeyword_5()); }
	To
	{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getToKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__6__Impl
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getKindAssignment_6()); }
	(rule__ScalarPropertyCardinalityRestrictionAxiom__KindAssignment_6)
	{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getKindAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__7__Impl
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getCardinalityAssignment_7()); }
	(rule__ScalarPropertyCardinalityRestrictionAxiom__CardinalityAssignment_7)
	{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getCardinalityAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyCardinalityRestrictionAxiom__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRangeAssignment_8()); }
	(rule__ScalarPropertyCardinalityRestrictionAxiom__RangeAssignment_8)?
	{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRangeAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarPropertyValueRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueRestrictionAxiom__Group__0__Impl
	rule__ScalarPropertyValueRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ScalarPropertyValueRestrictionAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueRestrictionAxiom__Group__1__Impl
	rule__ScalarPropertyValueRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_1()); }
	Restricts
	{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueRestrictionAxiom__Group__2__Impl
	rule__ScalarPropertyValueRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getScalarKeyword_2()); }
	Scalar
	{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getScalarKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueRestrictionAxiom__Group__3__Impl
	rule__ScalarPropertyValueRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyKeyword_3()); }
	Property
	{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueRestrictionAxiom__Group__4__Impl
	rule__ScalarPropertyValueRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyAssignment_4()); }
	(rule__ScalarPropertyValueRestrictionAxiom__PropertyAssignment_4)
	{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueRestrictionAxiom__Group__5__Impl
	rule__ScalarPropertyValueRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getToKeyword_5()); }
	To
	{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getToKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueRestrictionAxiom__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getValueAssignment_6()); }
	(rule__ScalarPropertyValueRestrictionAxiom__ValueAssignment_6)
	{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getValueAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredPropertyRangeRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyRangeRestrictionAxiom__Group__0__Impl
	rule__StructuredPropertyRangeRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__StructuredPropertyRangeRestrictionAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyRangeRestrictionAxiom__Group__1__Impl
	rule__StructuredPropertyRangeRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_1()); }
	Restricts
	{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRestrictsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyRangeRestrictionAxiom__Group__2__Impl
	rule__StructuredPropertyRangeRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getKindAssignment_2()); }
	(rule__StructuredPropertyRangeRestrictionAxiom__KindAssignment_2)
	{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getKindAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyRangeRestrictionAxiom__Group__3__Impl
	rule__StructuredPropertyRangeRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getStructuredKeyword_3()); }
	Structured
	{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getStructuredKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyRangeRestrictionAxiom__Group__4__Impl
	rule__StructuredPropertyRangeRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_4()); }
	Property
	{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyRangeRestrictionAxiom__Group__5__Impl
	rule__StructuredPropertyRangeRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyAssignment_5()); }
	(rule__StructuredPropertyRangeRestrictionAxiom__PropertyAssignment_5)
	{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyRangeRestrictionAxiom__Group__6__Impl
	rule__StructuredPropertyRangeRestrictionAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getToKeyword_6()); }
	To
	{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getToKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyRangeRestrictionAxiom__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRangeAssignment_7()); }
	(rule__StructuredPropertyRangeRestrictionAxiom__RangeAssignment_7)
	{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRangeAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredPropertyCardinalityRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__0__Impl
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__StructuredPropertyCardinalityRestrictionAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__1__Impl
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_1()); }
	Restricts
	{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRestrictsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__2__Impl
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getStructuredKeyword_2()); }
	Structured
	{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getStructuredKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__3__Impl
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_3()); }
	Property
	{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__4__Impl
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyAssignment_4()); }
	(rule__StructuredPropertyCardinalityRestrictionAxiom__PropertyAssignment_4)
	{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__5__Impl
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getToKeyword_5()); }
	To
	{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getToKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__6__Impl
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getKindAssignment_6()); }
	(rule__StructuredPropertyCardinalityRestrictionAxiom__KindAssignment_6)
	{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getKindAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__7__Impl
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getCardinalityAssignment_7()); }
	(rule__StructuredPropertyCardinalityRestrictionAxiom__CardinalityAssignment_7)
	{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getCardinalityAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyCardinalityRestrictionAxiom__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRangeAssignment_8()); }
	(rule__StructuredPropertyCardinalityRestrictionAxiom__RangeAssignment_8)?
	{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRangeAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredPropertyValueRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueRestrictionAxiom__Group__0__Impl
	rule__StructuredPropertyValueRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__StructuredPropertyValueRestrictionAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueRestrictionAxiom__Group__1__Impl
	rule__StructuredPropertyValueRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_1()); }
	Restricts
	{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getRestrictsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueRestrictionAxiom__Group__2__Impl
	rule__StructuredPropertyValueRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getStructuredKeyword_2()); }
	Structured
	{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getStructuredKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueRestrictionAxiom__Group__3__Impl
	rule__StructuredPropertyValueRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyKeyword_3()); }
	Property
	{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueRestrictionAxiom__Group__4__Impl
	rule__StructuredPropertyValueRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyAssignment_4()); }
	(rule__StructuredPropertyValueRestrictionAxiom__PropertyAssignment_4)
	{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueRestrictionAxiom__Group__5__Impl
	rule__StructuredPropertyValueRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getToKeyword_5()); }
	To
	{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getToKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueRestrictionAxiom__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getValueAssignment_6()); }
	(rule__StructuredPropertyValueRestrictionAxiom__ValueAssignment_6)
	{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getValueAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationRangeRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationRangeRestrictionAxiom__Group__0__Impl
	rule__RelationRangeRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationRangeRestrictionAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationRangeRestrictionAxiom__Group__1__Impl
	rule__RelationRangeRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRestrictsKeyword_1()); }
	Restricts
	{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRestrictsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationRangeRestrictionAxiom__Group__2__Impl
	rule__RelationRangeRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getKindAssignment_2()); }
	(rule__RelationRangeRestrictionAxiom__KindAssignment_2)
	{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getKindAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationRangeRestrictionAxiom__Group__3__Impl
	rule__RelationRangeRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationKeyword_3()); }
	Relation
	{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationRangeRestrictionAxiom__Group__4__Impl
	rule__RelationRangeRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationAssignment_4()); }
	(rule__RelationRangeRestrictionAxiom__RelationAssignment_4)
	{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationRangeRestrictionAxiom__Group__5__Impl
	rule__RelationRangeRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getToKeyword_5()); }
	To
	{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getToKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationRangeRestrictionAxiom__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRangeAssignment_6()); }
	(rule__RelationRangeRestrictionAxiom__RangeAssignment_6)
	{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationCardinalityRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationCardinalityRestrictionAxiom__Group__0__Impl
	rule__RelationCardinalityRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationCardinalityRestrictionAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationCardinalityRestrictionAxiom__Group__1__Impl
	rule__RelationCardinalityRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRestrictsKeyword_1()); }
	Restricts
	{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRestrictsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationCardinalityRestrictionAxiom__Group__2__Impl
	rule__RelationCardinalityRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationKeyword_2()); }
	Relation
	{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationCardinalityRestrictionAxiom__Group__3__Impl
	rule__RelationCardinalityRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationAssignment_3()); }
	(rule__RelationCardinalityRestrictionAxiom__RelationAssignment_3)
	{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationCardinalityRestrictionAxiom__Group__4__Impl
	rule__RelationCardinalityRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getToKeyword_4()); }
	To
	{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getToKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationCardinalityRestrictionAxiom__Group__5__Impl
	rule__RelationCardinalityRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getKindAssignment_5()); }
	(rule__RelationCardinalityRestrictionAxiom__KindAssignment_5)
	{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getKindAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationCardinalityRestrictionAxiom__Group__6__Impl
	rule__RelationCardinalityRestrictionAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getCardinalityAssignment_6()); }
	(rule__RelationCardinalityRestrictionAxiom__CardinalityAssignment_6)
	{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getCardinalityAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationCardinalityRestrictionAxiom__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRangeAssignment_7()); }
	(rule__RelationCardinalityRestrictionAxiom__RangeAssignment_7)?
	{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRangeAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationTargetRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationTargetRestrictionAxiom__Group__0__Impl
	rule__RelationTargetRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationTargetRestrictionAxiom__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationTargetRestrictionAxiom__Group__1__Impl
	rule__RelationTargetRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRestrictsKeyword_1()); }
	Restricts
	{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRestrictsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationTargetRestrictionAxiom__Group__2__Impl
	rule__RelationTargetRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationKeyword_2()); }
	Relation
	{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationTargetRestrictionAxiom__Group__3__Impl
	rule__RelationTargetRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationAssignment_3()); }
	(rule__RelationTargetRestrictionAxiom__RelationAssignment_3)
	{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationTargetRestrictionAxiom__Group__4__Impl
	rule__RelationTargetRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getToKeyword_4()); }
	To
	{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getToKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationTargetRestrictionAxiom__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getTargetAssignment_5()); }
	(rule__RelationTargetRestrictionAxiom__TargetAssignment_5)
	{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getTargetAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__KeyAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__KeyAxiom__Group__0__Impl
	rule__KeyAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getKeyAxiomAccess().getKeyKeyword_0()); }
	Key
	{ after(grammarAccess.getKeyAxiomAccess().getKeyKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__KeyAxiom__Group__1__Impl
	rule__KeyAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getKeyAxiomAccess().getPropertiesAssignment_1()); }
	(rule__KeyAxiom__PropertiesAssignment_1)
	{ after(grammarAccess.getKeyAxiomAccess().getPropertiesAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__KeyAxiom__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getKeyAxiomAccess().getGroup_2()); }
	(rule__KeyAxiom__Group_2__0)*
	{ after(grammarAccess.getKeyAxiomAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__KeyAxiom__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__KeyAxiom__Group_2__0__Impl
	rule__KeyAxiom__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getKeyAxiomAccess().getCommaKeyword_2_0()); }
	Comma
	{ after(grammarAccess.getKeyAxiomAccess().getCommaKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__KeyAxiom__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getKeyAxiomAccess().getPropertiesAssignment_2_1()); }
	(rule__KeyAxiom__PropertiesAssignment_2_1)
	{ after(grammarAccess.getKeyAxiomAccess().getPropertiesAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptTypeAssertion__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptTypeAssertion__Group__0__Impl
	rule__ConceptTypeAssertion__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptTypeAssertion__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptTypeAssertionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ConceptTypeAssertion__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getConceptTypeAssertionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptTypeAssertion__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptTypeAssertion__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptTypeAssertion__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptTypeAssertionAccess().getTypeAssignment_1()); }
	(rule__ConceptTypeAssertion__TypeAssignment_1)
	{ after(grammarAccess.getConceptTypeAssertionAccess().getTypeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationTypeAssertion__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationTypeAssertion__Group__0__Impl
	rule__RelationTypeAssertion__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTypeAssertion__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationTypeAssertionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationTypeAssertion__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationTypeAssertionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTypeAssertion__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationTypeAssertion__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTypeAssertion__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationTypeAssertionAccess().getTypeAssignment_1()); }
	(rule__RelationTypeAssertion__TypeAssignment_1)
	{ after(grammarAccess.getRelationTypeAssertionAccess().getTypeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarPropertyValueAssertion__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueAssertion__Group__0__Impl
	rule__ScalarPropertyValueAssertion__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueAssertion__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueAssertionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__ScalarPropertyValueAssertion__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarPropertyValueAssertionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueAssertion__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueAssertion__Group__1__Impl
	rule__ScalarPropertyValueAssertion__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueAssertion__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueAssertionAccess().getPropertyAssignment_1()); }
	(rule__ScalarPropertyValueAssertion__PropertyAssignment_1)
	{ after(grammarAccess.getScalarPropertyValueAssertionAccess().getPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueAssertion__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarPropertyValueAssertion__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueAssertion__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarPropertyValueAssertionAccess().getValueAssignment_2()); }
	(rule__ScalarPropertyValueAssertion__ValueAssignment_2)
	{ after(grammarAccess.getScalarPropertyValueAssertionAccess().getValueAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredPropertyValueAssertion__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueAssertion__Group__0__Impl
	rule__StructuredPropertyValueAssertion__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueAssertion__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueAssertionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__StructuredPropertyValueAssertion__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getStructuredPropertyValueAssertionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueAssertion__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueAssertion__Group__1__Impl
	rule__StructuredPropertyValueAssertion__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueAssertion__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueAssertionAccess().getPropertyAssignment_1()); }
	(rule__StructuredPropertyValueAssertion__PropertyAssignment_1)
	{ after(grammarAccess.getStructuredPropertyValueAssertionAccess().getPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueAssertion__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredPropertyValueAssertion__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueAssertion__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredPropertyValueAssertionAccess().getValueAssignment_2()); }
	(rule__StructuredPropertyValueAssertion__ValueAssignment_2)
	{ after(grammarAccess.getStructuredPropertyValueAssertionAccess().getValueAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LinkAssertion__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LinkAssertion__Group__0__Impl
	rule__LinkAssertion__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LinkAssertion__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLinkAssertionAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__LinkAssertion__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getLinkAssertionAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LinkAssertion__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LinkAssertion__Group__1__Impl
	rule__LinkAssertion__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LinkAssertion__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLinkAssertionAccess().getRelationAssignment_1()); }
	(rule__LinkAssertion__RelationAssignment_1)
	{ after(grammarAccess.getLinkAssertionAccess().getRelationAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LinkAssertion__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LinkAssertion__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LinkAssertion__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLinkAssertionAccess().getTargetAssignment_2()); }
	(rule__LinkAssertion__TargetAssignment_2)
	{ after(grammarAccess.getLinkAssertionAccess().getTargetAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityPredicate__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityPredicate__Group__0__Impl
	rule__EntityPredicate__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityPredicateAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__EntityPredicate__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getEntityPredicateAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityPredicate__Group__1__Impl
	rule__EntityPredicate__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityPredicateAccess().getEntityAssignment_1()); }
	(rule__EntityPredicate__EntityAssignment_1)
	{ after(grammarAccess.getEntityPredicateAccess().getEntityAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityPredicate__Group__2__Impl
	rule__EntityPredicate__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityPredicateAccess().getLeftParenthesisKeyword_2()); }
	LeftParenthesis
	{ after(grammarAccess.getEntityPredicateAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityPredicate__Group__3__Impl
	rule__EntityPredicate__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityPredicateAccess().getVariableAssignment_3()); }
	(rule__EntityPredicate__VariableAssignment_3)
	{ after(grammarAccess.getEntityPredicateAccess().getVariableAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityPredicate__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityPredicateAccess().getRightParenthesisKeyword_4()); }
	RightParenthesis
	{ after(grammarAccess.getEntityPredicateAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationPredicate__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationPredicate__Group__0__Impl
	rule__RelationPredicate__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationPredicateAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationPredicate__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationPredicateAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationPredicate__Group__1__Impl
	rule__RelationPredicate__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationPredicateAccess().getRelationAssignment_1()); }
	(rule__RelationPredicate__RelationAssignment_1)
	{ after(grammarAccess.getRelationPredicateAccess().getRelationAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationPredicate__Group__2__Impl
	rule__RelationPredicate__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationPredicateAccess().getLeftParenthesisKeyword_2()); }
	LeftParenthesis
	{ after(grammarAccess.getRelationPredicateAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationPredicate__Group__3__Impl
	rule__RelationPredicate__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationPredicateAccess().getVariable1Assignment_3()); }
	(rule__RelationPredicate__Variable1Assignment_3)
	{ after(grammarAccess.getRelationPredicateAccess().getVariable1Assignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationPredicate__Group__4__Impl
	rule__RelationPredicate__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationPredicateAccess().getCommaKeyword_4()); }
	Comma
	{ after(grammarAccess.getRelationPredicateAccess().getCommaKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationPredicate__Group__5__Impl
	rule__RelationPredicate__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationPredicateAccess().getVariable2Assignment_5()); }
	(rule__RelationPredicate__Variable2Assignment_5)
	{ after(grammarAccess.getRelationPredicateAccess().getVariable2Assignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationPredicate__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationPredicateAccess().getRightParenthesisKeyword_6()); }
	RightParenthesis
	{ after(grammarAccess.getRelationPredicateAccess().getRightParenthesisKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SameAsPredicate__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SameAsPredicate__Group__0__Impl
	rule__SameAsPredicate__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSameAsPredicateAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__SameAsPredicate__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getSameAsPredicateAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SameAsPredicate__Group__1__Impl
	rule__SameAsPredicate__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSameAsPredicateAccess().getSameAsKeyword_1()); }
	SameAs
	{ after(grammarAccess.getSameAsPredicateAccess().getSameAsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SameAsPredicate__Group__2__Impl
	rule__SameAsPredicate__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSameAsPredicateAccess().getLeftParenthesisKeyword_2()); }
	LeftParenthesis
	{ after(grammarAccess.getSameAsPredicateAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SameAsPredicate__Group__3__Impl
	rule__SameAsPredicate__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSameAsPredicateAccess().getVariable1Assignment_3()); }
	(rule__SameAsPredicate__Variable1Assignment_3)
	{ after(grammarAccess.getSameAsPredicateAccess().getVariable1Assignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SameAsPredicate__Group__4__Impl
	rule__SameAsPredicate__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSameAsPredicateAccess().getCommaKeyword_4()); }
	Comma
	{ after(grammarAccess.getSameAsPredicateAccess().getCommaKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SameAsPredicate__Group__5__Impl
	rule__SameAsPredicate__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSameAsPredicateAccess().getVariable2Assignment_5()); }
	(rule__SameAsPredicate__Variable2Assignment_5)
	{ after(grammarAccess.getSameAsPredicateAccess().getVariable2Assignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SameAsPredicate__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSameAsPredicateAccess().getRightParenthesisKeyword_6()); }
	RightParenthesis
	{ after(grammarAccess.getSameAsPredicateAccess().getRightParenthesisKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DifferentFromPredicate__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DifferentFromPredicate__Group__0__Impl
	rule__DifferentFromPredicate__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDifferentFromPredicateAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__DifferentFromPredicate__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getDifferentFromPredicateAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DifferentFromPredicate__Group__1__Impl
	rule__DifferentFromPredicate__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDifferentFromPredicateAccess().getDifferentFromKeyword_1()); }
	DifferentFrom
	{ after(grammarAccess.getDifferentFromPredicateAccess().getDifferentFromKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DifferentFromPredicate__Group__2__Impl
	rule__DifferentFromPredicate__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDifferentFromPredicateAccess().getLeftParenthesisKeyword_2()); }
	LeftParenthesis
	{ after(grammarAccess.getDifferentFromPredicateAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DifferentFromPredicate__Group__3__Impl
	rule__DifferentFromPredicate__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDifferentFromPredicateAccess().getVariable1Assignment_3()); }
	(rule__DifferentFromPredicate__Variable1Assignment_3)
	{ after(grammarAccess.getDifferentFromPredicateAccess().getVariable1Assignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DifferentFromPredicate__Group__4__Impl
	rule__DifferentFromPredicate__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDifferentFromPredicateAccess().getCommaKeyword_4()); }
	Comma
	{ after(grammarAccess.getDifferentFromPredicateAccess().getCommaKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DifferentFromPredicate__Group__5__Impl
	rule__DifferentFromPredicate__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDifferentFromPredicateAccess().getVariable2Assignment_5()); }
	(rule__DifferentFromPredicate__Variable2Assignment_5)
	{ after(grammarAccess.getDifferentFromPredicateAccess().getVariable2Assignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DifferentFromPredicate__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDifferentFromPredicateAccess().getRightParenthesisKeyword_6()); }
	RightParenthesis
	{ after(grammarAccess.getDifferentFromPredicateAccess().getRightParenthesisKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntityPredicate__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityPredicate__Group__0__Impl
	rule__RelationEntityPredicate__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityPredicateAccess().getOwnedAnnotationsAssignment_0()); }
	(rule__RelationEntityPredicate__OwnedAnnotationsAssignment_0)*
	{ after(grammarAccess.getRelationEntityPredicateAccess().getOwnedAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityPredicate__Group__1__Impl
	rule__RelationEntityPredicate__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityPredicateAccess().getEntityAssignment_1()); }
	(rule__RelationEntityPredicate__EntityAssignment_1)
	{ after(grammarAccess.getRelationEntityPredicateAccess().getEntityAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityPredicate__Group__2__Impl
	rule__RelationEntityPredicate__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityPredicateAccess().getLeftParenthesisKeyword_2()); }
	LeftParenthesis
	{ after(grammarAccess.getRelationEntityPredicateAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityPredicate__Group__3__Impl
	rule__RelationEntityPredicate__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityPredicateAccess().getVariable1Assignment_3()); }
	(rule__RelationEntityPredicate__Variable1Assignment_3)
	{ after(grammarAccess.getRelationEntityPredicateAccess().getVariable1Assignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityPredicate__Group__4__Impl
	rule__RelationEntityPredicate__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityPredicateAccess().getCommaKeyword_4()); }
	Comma
	{ after(grammarAccess.getRelationEntityPredicateAccess().getCommaKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityPredicate__Group__5__Impl
	rule__RelationEntityPredicate__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityPredicateAccess().getEntityVariableAssignment_5()); }
	(rule__RelationEntityPredicate__EntityVariableAssignment_5)
	{ after(grammarAccess.getRelationEntityPredicateAccess().getEntityVariableAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityPredicate__Group__6__Impl
	rule__RelationEntityPredicate__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityPredicateAccess().getCommaKeyword_6()); }
	Comma
	{ after(grammarAccess.getRelationEntityPredicateAccess().getCommaKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityPredicate__Group__7__Impl
	rule__RelationEntityPredicate__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityPredicateAccess().getVariable2Assignment_7()); }
	(rule__RelationEntityPredicate__Variable2Assignment_7)
	{ after(grammarAccess.getRelationEntityPredicateAccess().getVariable2Assignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntityPredicate__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationEntityPredicateAccess().getRightParenthesisKeyword_8()); }
	RightParenthesis
	{ after(grammarAccess.getRelationEntityPredicateAccess().getRightParenthesisKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IntegerLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IntegerLiteral__Group__0__Impl
	rule__IntegerLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIntegerLiteralAccess().getValueAssignment_0()); }
	(rule__IntegerLiteral__ValueAssignment_0)
	{ after(grammarAccess.getIntegerLiteralAccess().getValueAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IntegerLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIntegerLiteralAccess().getGroup_1()); }
	(rule__IntegerLiteral__Group_1__0)?
	{ after(grammarAccess.getIntegerLiteralAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IntegerLiteral__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IntegerLiteral__Group_1__0__Impl
	rule__IntegerLiteral__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerLiteral__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIntegerLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0()); }
	CircumflexAccentCircumflexAccent
	{ after(grammarAccess.getIntegerLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerLiteral__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IntegerLiteral__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerLiteral__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIntegerLiteralAccess().getTypeAssignment_1_1()); }
	(rule__IntegerLiteral__TypeAssignment_1_1)
	{ after(grammarAccess.getIntegerLiteralAccess().getTypeAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DecimalLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DecimalLiteral__Group__0__Impl
	rule__DecimalLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DecimalLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDecimalLiteralAccess().getValueAssignment_0()); }
	(rule__DecimalLiteral__ValueAssignment_0)
	{ after(grammarAccess.getDecimalLiteralAccess().getValueAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DecimalLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DecimalLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DecimalLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDecimalLiteralAccess().getGroup_1()); }
	(rule__DecimalLiteral__Group_1__0)?
	{ after(grammarAccess.getDecimalLiteralAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DecimalLiteral__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DecimalLiteral__Group_1__0__Impl
	rule__DecimalLiteral__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DecimalLiteral__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDecimalLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0()); }
	CircumflexAccentCircumflexAccent
	{ after(grammarAccess.getDecimalLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DecimalLiteral__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DecimalLiteral__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DecimalLiteral__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDecimalLiteralAccess().getTypeAssignment_1_1()); }
	(rule__DecimalLiteral__TypeAssignment_1_1)
	{ after(grammarAccess.getDecimalLiteralAccess().getTypeAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DoubleLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DoubleLiteral__Group__0__Impl
	rule__DoubleLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDoubleLiteralAccess().getValueAssignment_0()); }
	(rule__DoubleLiteral__ValueAssignment_0)
	{ after(grammarAccess.getDoubleLiteralAccess().getValueAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DoubleLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDoubleLiteralAccess().getGroup_1()); }
	(rule__DoubleLiteral__Group_1__0)?
	{ after(grammarAccess.getDoubleLiteralAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DoubleLiteral__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DoubleLiteral__Group_1__0__Impl
	rule__DoubleLiteral__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleLiteral__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDoubleLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0()); }
	CircumflexAccentCircumflexAccent
	{ after(grammarAccess.getDoubleLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleLiteral__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DoubleLiteral__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleLiteral__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDoubleLiteralAccess().getTypeAssignment_1_1()); }
	(rule__DoubleLiteral__TypeAssignment_1_1)
	{ after(grammarAccess.getDoubleLiteralAccess().getTypeAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BooleanLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanLiteral__Group__0__Impl
	rule__BooleanLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanLiteralAccess().getValueAssignment_0()); }
	(rule__BooleanLiteral__ValueAssignment_0)
	{ after(grammarAccess.getBooleanLiteralAccess().getValueAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanLiteralAccess().getGroup_1()); }
	(rule__BooleanLiteral__Group_1__0)?
	{ after(grammarAccess.getBooleanLiteralAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BooleanLiteral__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanLiteral__Group_1__0__Impl
	rule__BooleanLiteral__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0()); }
	CircumflexAccentCircumflexAccent
	{ after(grammarAccess.getBooleanLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanLiteral__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanLiteralAccess().getTypeAssignment_1_1()); }
	(rule__BooleanLiteral__TypeAssignment_1_1)
	{ after(grammarAccess.getBooleanLiteralAccess().getTypeAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QuotedLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QuotedLiteral__Group__0__Impl
	rule__QuotedLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQuotedLiteralAccess().getValueAssignment_0()); }
	(rule__QuotedLiteral__ValueAssignment_0)
	{ after(grammarAccess.getQuotedLiteralAccess().getValueAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QuotedLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQuotedLiteralAccess().getAlternatives_1()); }
	(rule__QuotedLiteral__Alternatives_1)?
	{ after(grammarAccess.getQuotedLiteralAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QuotedLiteral__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QuotedLiteral__Group_1_0__0__Impl
	rule__QuotedLiteral__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQuotedLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0_0()); }
	CircumflexAccentCircumflexAccent
	{ after(grammarAccess.getQuotedLiteralAccess().getCircumflexAccentCircumflexAccentKeyword_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QuotedLiteral__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQuotedLiteralAccess().getTypeAssignment_1_0_1()); }
	(rule__QuotedLiteral__TypeAssignment_1_0_1)
	{ after(grammarAccess.getQuotedLiteralAccess().getTypeAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QuotedLiteral__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QuotedLiteral__Group_1_1__0__Impl
	rule__QuotedLiteral__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQuotedLiteralAccess().getDollarSignKeyword_1_1_0()); }
	DollarSign
	{ after(grammarAccess.getQuotedLiteralAccess().getDollarSignKeyword_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QuotedLiteral__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQuotedLiteralAccess().getLangTagAssignment_1_1_1()); }
	(rule__QuotedLiteral__LangTagAssignment_1_1_1)
	{ after(grammarAccess.getQuotedLiteralAccess().getLangTagAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationEntity__UnorderedGroup_5_7
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7());
	}
:
	rule__RelationEntity__UnorderedGroup_5_7__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7());
	restoreStackSize(stackSize);
}

rule__RelationEntity__UnorderedGroup_5_7__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getRelationEntityAccess().getFunctionalAssignment_5_7_0()); }
					(rule__RelationEntity__FunctionalAssignment_5_7_0)
					{ after(grammarAccess.getRelationEntityAccess().getFunctionalAssignment_5_7_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getRelationEntityAccess().getGroup_5_7_1()); }
					(rule__RelationEntity__Group_5_7_1__0)
					{ after(grammarAccess.getRelationEntityAccess().getGroup_5_7_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getRelationEntityAccess().getSymmetricAssignment_5_7_2()); }
					(rule__RelationEntity__SymmetricAssignment_5_7_2)
					{ after(grammarAccess.getRelationEntityAccess().getSymmetricAssignment_5_7_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getRelationEntityAccess().getAsymmetricAssignment_5_7_3()); }
					(rule__RelationEntity__AsymmetricAssignment_5_7_3)
					{ after(grammarAccess.getRelationEntityAccess().getAsymmetricAssignment_5_7_3()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 4)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 4);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getRelationEntityAccess().getReflexiveAssignment_5_7_4()); }
					(rule__RelationEntity__ReflexiveAssignment_5_7_4)
					{ after(grammarAccess.getRelationEntityAccess().getReflexiveAssignment_5_7_4()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 5)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 5);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getRelationEntityAccess().getIrreflexiveAssignment_5_7_5()); }
					(rule__RelationEntity__IrreflexiveAssignment_5_7_5)
					{ after(grammarAccess.getRelationEntityAccess().getIrreflexiveAssignment_5_7_5()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 6)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7(), 6);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getRelationEntityAccess().getTransitiveAssignment_5_7_6()); }
					(rule__RelationEntity__TransitiveAssignment_5_7_6)
					{ after(grammarAccess.getRelationEntityAccess().getTransitiveAssignment_5_7_6()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRelationEntityAccess().getUnorderedGroup_5_7());
	restoreStackSize(stackSize);
}

rule__RelationEntity__UnorderedGroup_5_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__UnorderedGroup_5_7__Impl
	rule__RelationEntity__UnorderedGroup_5_7__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__UnorderedGroup_5_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__UnorderedGroup_5_7__Impl
	rule__RelationEntity__UnorderedGroup_5_7__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__UnorderedGroup_5_7__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__UnorderedGroup_5_7__Impl
	rule__RelationEntity__UnorderedGroup_5_7__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__UnorderedGroup_5_7__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__UnorderedGroup_5_7__Impl
	rule__RelationEntity__UnorderedGroup_5_7__4?
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__UnorderedGroup_5_7__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__UnorderedGroup_5_7__Impl
	rule__RelationEntity__UnorderedGroup_5_7__5?
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__UnorderedGroup_5_7__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__UnorderedGroup_5_7__Impl
	rule__RelationEntity__UnorderedGroup_5_7__6?
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__UnorderedGroup_5_7__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationEntity__UnorderedGroup_5_7__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__FacetedScalar__UnorderedGroup_4_1
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1());
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1());
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getFacetedScalarAccess().getGroup_4_1_0()); }
					(rule__FacetedScalar__Group_4_1_0__0)
					{ after(grammarAccess.getFacetedScalarAccess().getGroup_4_1_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getFacetedScalarAccess().getGroup_4_1_1()); }
					(rule__FacetedScalar__Group_4_1_1__0)
					{ after(grammarAccess.getFacetedScalarAccess().getGroup_4_1_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getFacetedScalarAccess().getGroup_4_1_2()); }
					(rule__FacetedScalar__Group_4_1_2__0)
					{ after(grammarAccess.getFacetedScalarAccess().getGroup_4_1_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getFacetedScalarAccess().getGroup_4_1_3()); }
					(rule__FacetedScalar__Group_4_1_3__0)
					{ after(grammarAccess.getFacetedScalarAccess().getGroup_4_1_3()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 4)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 4);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getFacetedScalarAccess().getGroup_4_1_4()); }
					(rule__FacetedScalar__Group_4_1_4__0)
					{ after(grammarAccess.getFacetedScalarAccess().getGroup_4_1_4()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 5)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 5);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getFacetedScalarAccess().getGroup_4_1_5()); }
					(rule__FacetedScalar__Group_4_1_5__0)
					{ after(grammarAccess.getFacetedScalarAccess().getGroup_4_1_5()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 6)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 6);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getFacetedScalarAccess().getGroup_4_1_6()); }
					(rule__FacetedScalar__Group_4_1_6__0)
					{ after(grammarAccess.getFacetedScalarAccess().getGroup_4_1_6()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 7)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 7);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getFacetedScalarAccess().getGroup_4_1_7()); }
					(rule__FacetedScalar__Group_4_1_7__0)
					{ after(grammarAccess.getFacetedScalarAccess().getGroup_4_1_7()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 8)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1(), 8);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getFacetedScalarAccess().getGroup_4_1_8()); }
					(rule__FacetedScalar__Group_4_1_8__0)
					{ after(grammarAccess.getFacetedScalarAccess().getGroup_4_1_8()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFacetedScalarAccess().getUnorderedGroup_4_1());
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__Impl
	rule__FacetedScalar__UnorderedGroup_4_1__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__Impl
	rule__FacetedScalar__UnorderedGroup_4_1__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__Impl
	rule__FacetedScalar__UnorderedGroup_4_1__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__Impl
	rule__FacetedScalar__UnorderedGroup_4_1__4?
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__Impl
	rule__FacetedScalar__UnorderedGroup_4_1__5?
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__Impl
	rule__FacetedScalar__UnorderedGroup_4_1__6?
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__Impl
	rule__FacetedScalar__UnorderedGroup_4_1__7?
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__Impl
	rule__FacetedScalar__UnorderedGroup_4_1__8?
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__UnorderedGroup_4_1__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FacetedScalar__UnorderedGroup_4_1__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__Annotation__PropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyCrossReference_1_0()); }
		(
			{ before(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__ValueAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationAccess().getValueLiteralParserRuleCall_2_0()); }
		ruleLiteral
		{ after(grammarAccess.getAnnotationAccess().getValueLiteralParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getVocabularyAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__IriAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyAccess().getIriIRITerminalRuleCall_2_0()); }
		RULE_IRI
		{ after(grammarAccess.getVocabularyAccess().getIriIRITerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__SeparatorAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyAccess().getSeparatorSeparatorKindEnumRuleCall_4_0()); }
		ruleSeparatorKind
		{ after(grammarAccess.getVocabularyAccess().getSeparatorSeparatorKindEnumRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__PrefixAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyAccess().getPrefixIDTerminalRuleCall_6_0()); }
		RULE_ID
		{ after(grammarAccess.getVocabularyAccess().getPrefixIDTerminalRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__OwnedImportsAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyAccess().getOwnedImportsVocabularyImportParserRuleCall_8_0()); }
		ruleVocabularyImport
		{ after(grammarAccess.getVocabularyAccess().getOwnedImportsVocabularyImportParserRuleCall_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Vocabulary__OwnedStatementsAssignment_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyAccess().getOwnedStatementsVocabularyStatementParserRuleCall_9_0()); }
		ruleVocabularyStatement
		{ after(grammarAccess.getVocabularyAccess().getOwnedStatementsVocabularyStatementParserRuleCall_9_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getBundleAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__IriAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_2_0()); }
		RULE_IRI
		{ after(grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__SeparatorAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getSeparatorSeparatorKindEnumRuleCall_4_0()); }
		ruleSeparatorKind
		{ after(grammarAccess.getBundleAccess().getSeparatorSeparatorKindEnumRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__PrefixAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getPrefixIDTerminalRuleCall_6_0()); }
		RULE_ID
		{ after(grammarAccess.getBundleAccess().getPrefixIDTerminalRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__OwnedImportsAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getOwnedImportsBundleImportParserRuleCall_8_0()); }
		ruleBundleImport
		{ after(grammarAccess.getBundleAccess().getOwnedImportsBundleImportParserRuleCall_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getDescriptionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__IriAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionAccess().getIriIRITerminalRuleCall_2_0()); }
		RULE_IRI
		{ after(grammarAccess.getDescriptionAccess().getIriIRITerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__SeparatorAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionAccess().getSeparatorSeparatorKindEnumRuleCall_4_0()); }
		ruleSeparatorKind
		{ after(grammarAccess.getDescriptionAccess().getSeparatorSeparatorKindEnumRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__PrefixAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionAccess().getPrefixIDTerminalRuleCall_6_0()); }
		RULE_ID
		{ after(grammarAccess.getDescriptionAccess().getPrefixIDTerminalRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__OwnedImportsAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionAccess().getOwnedImportsDescriptionImportParserRuleCall_8_0()); }
		ruleDescriptionImport
		{ after(grammarAccess.getDescriptionAccess().getOwnedImportsDescriptionImportParserRuleCall_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__OwnedStatementsAssignment_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionAccess().getOwnedStatementsDescriptionStatementParserRuleCall_9_0()); }
		ruleDescriptionStatement
		{ after(grammarAccess.getDescriptionAccess().getOwnedStatementsDescriptionStatementParserRuleCall_9_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getAspectAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__OwnedSpecializationsAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getAspectAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__OwnedSpecializationsAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getAspectAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__OwnedKeysAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getOwnedKeysKeyAxiomParserRuleCall_4_1_0()); }
		ruleKeyAxiom
		{ after(grammarAccess.getAspectAccess().getOwnedKeysKeyAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__OwnedPropertyRestrictionsAssignment_4_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_4_2_0()); }
		rulePropertyRestrictionAxiom
		{ after(grammarAccess.getAspectAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_4_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__OwnedRelationRestrictionsAssignment_4_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_4_3_0()); }
		ruleRelationRestrictionAxiom
		{ after(grammarAccess.getAspectAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_4_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getConceptAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__OwnedSpecializationsAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getConceptAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__OwnedSpecializationsAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getConceptAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__OwnedKeysAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getOwnedKeysKeyAxiomParserRuleCall_4_1_0()); }
		ruleKeyAxiom
		{ after(grammarAccess.getConceptAccess().getOwnedKeysKeyAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__OwnedPropertyRestrictionsAssignment_4_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_4_2_0()); }
		rulePropertyRestrictionAxiom
		{ after(grammarAccess.getConceptAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_4_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__OwnedRelationRestrictionsAssignment_4_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_4_3_0()); }
		ruleRelationRestrictionAxiom
		{ after(grammarAccess.getConceptAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_4_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationEntityAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getRelationEntityAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__OwnedSpecializationsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__OwnedSpecializationsAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getRelationEntityAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__SourceAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getSourceEntityCrossReference_5_2_0()); }
		(
			{ before(grammarAccess.getRelationEntityAccess().getSourceEntityRefParserRuleCall_5_2_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationEntityAccess().getSourceEntityRefParserRuleCall_5_2_0_1()); }
		)
		{ after(grammarAccess.getRelationEntityAccess().getSourceEntityCrossReference_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__TargetAssignment_5_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getTargetEntityCrossReference_5_4_0()); }
		(
			{ before(grammarAccess.getRelationEntityAccess().getTargetEntityRefParserRuleCall_5_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationEntityAccess().getTargetEntityRefParserRuleCall_5_4_0_1()); }
		)
		{ after(grammarAccess.getRelationEntityAccess().getTargetEntityCrossReference_5_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__ForwardAssignment_5_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getForwardForwardRelationParserRuleCall_5_5_0()); }
		ruleForwardRelation
		{ after(grammarAccess.getRelationEntityAccess().getForwardForwardRelationParserRuleCall_5_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__InverseAssignment_5_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getInverseInverseRelationParserRuleCall_5_6_0()); }
		ruleInverseRelation
		{ after(grammarAccess.getRelationEntityAccess().getInverseInverseRelationParserRuleCall_5_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__FunctionalAssignment_5_7_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getFunctionalFunctionalKeyword_5_7_0_0()); }
		(
			{ before(grammarAccess.getRelationEntityAccess().getFunctionalFunctionalKeyword_5_7_0_0()); }
			Functional
			{ after(grammarAccess.getRelationEntityAccess().getFunctionalFunctionalKeyword_5_7_0_0()); }
		)
		{ after(grammarAccess.getRelationEntityAccess().getFunctionalFunctionalKeyword_5_7_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__InverseFunctionalAssignment_5_7_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getInverseFunctionalInverseKeyword_5_7_1_0_0()); }
		(
			{ before(grammarAccess.getRelationEntityAccess().getInverseFunctionalInverseKeyword_5_7_1_0_0()); }
			Inverse
			{ after(grammarAccess.getRelationEntityAccess().getInverseFunctionalInverseKeyword_5_7_1_0_0()); }
		)
		{ after(grammarAccess.getRelationEntityAccess().getInverseFunctionalInverseKeyword_5_7_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__SymmetricAssignment_5_7_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getSymmetricSymmetricKeyword_5_7_2_0()); }
		(
			{ before(grammarAccess.getRelationEntityAccess().getSymmetricSymmetricKeyword_5_7_2_0()); }
			Symmetric
			{ after(grammarAccess.getRelationEntityAccess().getSymmetricSymmetricKeyword_5_7_2_0()); }
		)
		{ after(grammarAccess.getRelationEntityAccess().getSymmetricSymmetricKeyword_5_7_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__AsymmetricAssignment_5_7_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getAsymmetricAsymmetricKeyword_5_7_3_0()); }
		(
			{ before(grammarAccess.getRelationEntityAccess().getAsymmetricAsymmetricKeyword_5_7_3_0()); }
			Asymmetric
			{ after(grammarAccess.getRelationEntityAccess().getAsymmetricAsymmetricKeyword_5_7_3_0()); }
		)
		{ after(grammarAccess.getRelationEntityAccess().getAsymmetricAsymmetricKeyword_5_7_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__ReflexiveAssignment_5_7_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getReflexiveReflexiveKeyword_5_7_4_0()); }
		(
			{ before(grammarAccess.getRelationEntityAccess().getReflexiveReflexiveKeyword_5_7_4_0()); }
			Reflexive
			{ after(grammarAccess.getRelationEntityAccess().getReflexiveReflexiveKeyword_5_7_4_0()); }
		)
		{ after(grammarAccess.getRelationEntityAccess().getReflexiveReflexiveKeyword_5_7_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__IrreflexiveAssignment_5_7_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getIrreflexiveIrreflexiveKeyword_5_7_5_0()); }
		(
			{ before(grammarAccess.getRelationEntityAccess().getIrreflexiveIrreflexiveKeyword_5_7_5_0()); }
			Irreflexive
			{ after(grammarAccess.getRelationEntityAccess().getIrreflexiveIrreflexiveKeyword_5_7_5_0()); }
		)
		{ after(grammarAccess.getRelationEntityAccess().getIrreflexiveIrreflexiveKeyword_5_7_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__TransitiveAssignment_5_7_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getTransitiveTransitiveKeyword_5_7_6_0()); }
		(
			{ before(grammarAccess.getRelationEntityAccess().getTransitiveTransitiveKeyword_5_7_6_0()); }
			Transitive
			{ after(grammarAccess.getRelationEntityAccess().getTransitiveTransitiveKeyword_5_7_6_0()); }
		)
		{ after(grammarAccess.getRelationEntityAccess().getTransitiveTransitiveKeyword_5_7_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__OwnedKeysAssignment_5_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getOwnedKeysKeyAxiomParserRuleCall_5_8_0()); }
		ruleKeyAxiom
		{ after(grammarAccess.getRelationEntityAccess().getOwnedKeysKeyAxiomParserRuleCall_5_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__OwnedPropertyRestrictionsAssignment_5_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_5_9_0()); }
		rulePropertyRestrictionAxiom
		{ after(grammarAccess.getRelationEntityAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_5_9_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntity__OwnedRelationRestrictionsAssignment_5_10
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_5_10_0()); }
		ruleRelationRestrictionAxiom
		{ after(grammarAccess.getRelationEntityAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_5_10_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getStructureAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__OwnedSpecializationsAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getStructureAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__OwnedSpecializationsAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getStructureAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__OwnedPropertyRestrictionsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_4_1_0()); }
		rulePropertyRestrictionAxiom
		{ after(grammarAccess.getStructureAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getAnnotationPropertyAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getAnnotationPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__OwnedSpecializationsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__OwnedSpecializationsAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getAnnotationPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getScalarPropertyAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getScalarPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__OwnedSpecializationsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__OwnedSpecializationsAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getScalarPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__DomainAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyAccess().getDomainClassifierCrossReference_5_2_0()); }
		(
			{ before(grammarAccess.getScalarPropertyAccess().getDomainClassifierRefParserRuleCall_5_2_0_1()); }
			ruleRef
			{ after(grammarAccess.getScalarPropertyAccess().getDomainClassifierRefParserRuleCall_5_2_0_1()); }
		)
		{ after(grammarAccess.getScalarPropertyAccess().getDomainClassifierCrossReference_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__RangeAssignment_5_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyAccess().getRangeScalarCrossReference_5_4_0()); }
		(
			{ before(grammarAccess.getScalarPropertyAccess().getRangeScalarRefParserRuleCall_5_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getScalarPropertyAccess().getRangeScalarRefParserRuleCall_5_4_0_1()); }
		)
		{ after(grammarAccess.getScalarPropertyAccess().getRangeScalarCrossReference_5_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarProperty__FunctionalAssignment_5_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()); }
		(
			{ before(grammarAccess.getScalarPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()); }
			Functional
			{ after(grammarAccess.getScalarPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()); }
		)
		{ after(grammarAccess.getScalarPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getStructuredPropertyAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getStructuredPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__OwnedSpecializationsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__OwnedSpecializationsAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getStructuredPropertyAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__DomainAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyAccess().getDomainClassifierCrossReference_5_2_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyAccess().getDomainClassifierRefParserRuleCall_5_2_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructuredPropertyAccess().getDomainClassifierRefParserRuleCall_5_2_0_1()); }
		)
		{ after(grammarAccess.getStructuredPropertyAccess().getDomainClassifierCrossReference_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__RangeAssignment_5_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyAccess().getRangeStructureCrossReference_5_4_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyAccess().getRangeStructureRefParserRuleCall_5_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructuredPropertyAccess().getRangeStructureRefParserRuleCall_5_4_0_1()); }
		)
		{ after(grammarAccess.getStructuredPropertyAccess().getRangeStructureCrossReference_5_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredProperty__FunctionalAssignment_5_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()); }
			Functional
			{ after(grammarAccess.getStructuredPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()); }
		)
		{ after(grammarAccess.getStructuredPropertyAccess().getFunctionalFunctionalKeyword_5_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getFacetedScalarAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getFacetedScalarAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__OwnedSpecializationsAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__OwnedSpecializationsAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getFacetedScalarAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__LengthAssignment_4_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getLengthUnsignedIntegerParserRuleCall_4_1_0_1_0()); }
		ruleUnsignedInteger
		{ after(grammarAccess.getFacetedScalarAccess().getLengthUnsignedIntegerParserRuleCall_4_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__MinLengthAssignment_4_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getMinLengthUnsignedIntegerParserRuleCall_4_1_1_1_0()); }
		ruleUnsignedInteger
		{ after(grammarAccess.getFacetedScalarAccess().getMinLengthUnsignedIntegerParserRuleCall_4_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__MaxLengthAssignment_4_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getMaxLengthUnsignedIntegerParserRuleCall_4_1_2_1_0()); }
		ruleUnsignedInteger
		{ after(grammarAccess.getFacetedScalarAccess().getMaxLengthUnsignedIntegerParserRuleCall_4_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__PatternAssignment_4_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getPatternSTRINGTerminalRuleCall_4_1_3_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getFacetedScalarAccess().getPatternSTRINGTerminalRuleCall_4_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__LanguageAssignment_4_1_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getLanguageIDTerminalRuleCall_4_1_4_1_0()); }
		RULE_ID
		{ after(grammarAccess.getFacetedScalarAccess().getLanguageIDTerminalRuleCall_4_1_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__MinInclusiveAssignment_4_1_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getMinInclusiveLiteralParserRuleCall_4_1_5_1_0()); }
		ruleLiteral
		{ after(grammarAccess.getFacetedScalarAccess().getMinInclusiveLiteralParserRuleCall_4_1_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__MinExclusiveAssignment_4_1_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getMinExclusiveLiteralParserRuleCall_4_1_6_1_0()); }
		ruleLiteral
		{ after(grammarAccess.getFacetedScalarAccess().getMinExclusiveLiteralParserRuleCall_4_1_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__MaxInclusiveAssignment_4_1_7_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getMaxInclusiveLiteralParserRuleCall_4_1_7_1_0()); }
		ruleLiteral
		{ after(grammarAccess.getFacetedScalarAccess().getMaxInclusiveLiteralParserRuleCall_4_1_7_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalar__MaxExclusiveAssignment_4_1_8_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarAccess().getMaxExclusiveLiteralParserRuleCall_4_1_8_1_0()); }
		ruleLiteral
		{ after(grammarAccess.getFacetedScalarAccess().getMaxExclusiveLiteralParserRuleCall_4_1_8_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getEnumeratedScalarAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getEnumeratedScalarAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__OwnedSpecializationsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__OwnedSpecializationsAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getEnumeratedScalarAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__LiteralsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarAccess().getLiteralsLiteralParserRuleCall_5_1_0()); }
		ruleLiteral
		{ after(grammarAccess.getEnumeratedScalarAccess().getLiteralsLiteralParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalar__LiteralsAssignment_5_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarAccess().getLiteralsLiteralParserRuleCall_5_2_1_0()); }
		ruleLiteral
		{ after(grammarAccess.getEnumeratedScalarAccess().getLiteralsLiteralParserRuleCall_5_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForwardRelation__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getForwardRelationAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getForwardRelationAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForwardRelation__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getForwardRelationAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getForwardRelationAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InverseRelation__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInverseRelationAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getInverseRelationAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InverseRelation__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInverseRelationAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getInverseRelationAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRuleAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__AntecedentAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleAccess().getAntecedentPredicateParserRuleCall_4_0()); }
		rulePredicate
		{ after(grammarAccess.getRuleAccess().getAntecedentPredicateParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__AntecedentAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleAccess().getAntecedentPredicateParserRuleCall_5_1_0()); }
		rulePredicate
		{ after(grammarAccess.getRuleAccess().getAntecedentPredicateParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__ConsequentAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleAccess().getConsequentPredicateParserRuleCall_7_0()); }
		rulePredicate
		{ after(grammarAccess.getRuleAccess().getConsequentPredicateParserRuleCall_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Rule__ConsequentAssignment_8_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleAccess().getConsequentPredicateParserRuleCall_8_1_0()); }
		rulePredicate
		{ after(grammarAccess.getRuleAccess().getConsequentPredicateParserRuleCall_8_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureInstanceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getStructureInstanceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__TypeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureInstanceAccess().getTypeStructureCrossReference_1_0()); }
		(
			{ before(grammarAccess.getStructureInstanceAccess().getTypeStructureRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructureInstanceAccess().getTypeStructureRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getStructureInstanceAccess().getTypeStructureCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureInstance__OwnedPropertyValuesAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureInstanceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_3_0()); }
		rulePropertyValueAssertion
		{ after(grammarAccess.getStructureInstanceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getConceptInstanceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__OwnedTypesAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getOwnedTypesConceptTypeAssertionParserRuleCall_3_1_0()); }
		ruleConceptTypeAssertion
		{ after(grammarAccess.getConceptInstanceAccess().getOwnedTypesConceptTypeAssertionParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__OwnedTypesAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getOwnedTypesConceptTypeAssertionParserRuleCall_3_2_1_0()); }
		ruleConceptTypeAssertion
		{ after(grammarAccess.getConceptInstanceAccess().getOwnedTypesConceptTypeAssertionParserRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__OwnedPropertyValuesAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_4_1_0()); }
		rulePropertyValueAssertion
		{ after(grammarAccess.getConceptInstanceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__OwnedLinksAssignment_4_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getOwnedLinksLinkAssertionParserRuleCall_4_2_0()); }
		ruleLinkAssertion
		{ after(grammarAccess.getConceptInstanceAccess().getOwnedLinksLinkAssertionParserRuleCall_4_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationInstanceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getRelationInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__OwnedTypesAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceAccess().getOwnedTypesRelationTypeAssertionParserRuleCall_3_1_0()); }
		ruleRelationTypeAssertion
		{ after(grammarAccess.getRelationInstanceAccess().getOwnedTypesRelationTypeAssertionParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__OwnedTypesAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceAccess().getOwnedTypesRelationTypeAssertionParserRuleCall_3_2_1_0()); }
		ruleRelationTypeAssertion
		{ after(grammarAccess.getRelationInstanceAccess().getOwnedTypesRelationTypeAssertionParserRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__SourceAssignment_4_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceAccess().getSourceNamedInstanceCrossReference_4_2_0()); }
		(
			{ before(grammarAccess.getRelationInstanceAccess().getSourceNamedInstanceRefParserRuleCall_4_2_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationInstanceAccess().getSourceNamedInstanceRefParserRuleCall_4_2_0_1()); }
		)
		{ after(grammarAccess.getRelationInstanceAccess().getSourceNamedInstanceCrossReference_4_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__TargetAssignment_4_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceAccess().getTargetNamedInstanceCrossReference_4_4_0()); }
		(
			{ before(grammarAccess.getRelationInstanceAccess().getTargetNamedInstanceRefParserRuleCall_4_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationInstanceAccess().getTargetNamedInstanceRefParserRuleCall_4_4_0_1()); }
		)
		{ after(grammarAccess.getRelationInstanceAccess().getTargetNamedInstanceCrossReference_4_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__OwnedPropertyValuesAssignment_4_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_4_5_0()); }
		rulePropertyValueAssertion
		{ after(grammarAccess.getRelationInstanceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_4_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstance__OwnedLinksAssignment_4_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceAccess().getOwnedLinksLinkAssertionParserRuleCall_4_6_0()); }
		ruleLinkAssertion
		{ after(grammarAccess.getRelationInstanceAccess().getOwnedLinksLinkAssertionParserRuleCall_4_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getAspectReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__AspectAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectReferenceAccess().getAspectAspectCrossReference_3_0()); }
		(
			{ before(grammarAccess.getAspectReferenceAccess().getAspectAspectRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getAspectReferenceAccess().getAspectAspectRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getAspectReferenceAccess().getAspectAspectCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__OwnedSpecializationsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__OwnedSpecializationsAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getAspectReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__OwnedKeysAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectReferenceAccess().getOwnedKeysKeyAxiomParserRuleCall_5_1_0()); }
		ruleKeyAxiom
		{ after(grammarAccess.getAspectReferenceAccess().getOwnedKeysKeyAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__OwnedPropertyRestrictionsAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectReferenceAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_5_2_0()); }
		rulePropertyRestrictionAxiom
		{ after(grammarAccess.getAspectReferenceAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectReference__OwnedRelationRestrictionsAssignment_5_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectReferenceAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_5_3_0()); }
		ruleRelationRestrictionAxiom
		{ after(grammarAccess.getAspectReferenceAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_5_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getConceptReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__ConceptAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptReferenceAccess().getConceptConceptCrossReference_3_0()); }
		(
			{ before(grammarAccess.getConceptReferenceAccess().getConceptConceptRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getConceptReferenceAccess().getConceptConceptRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getConceptReferenceAccess().getConceptConceptCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__OwnedSpecializationsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__OwnedSpecializationsAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getConceptReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__OwnedKeysAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptReferenceAccess().getOwnedKeysKeyAxiomParserRuleCall_5_1_0()); }
		ruleKeyAxiom
		{ after(grammarAccess.getConceptReferenceAccess().getOwnedKeysKeyAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__OwnedPropertyRestrictionsAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptReferenceAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_5_2_0()); }
		rulePropertyRestrictionAxiom
		{ after(grammarAccess.getConceptReferenceAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptReference__OwnedRelationRestrictionsAssignment_5_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptReferenceAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_5_3_0()); }
		ruleRelationRestrictionAxiom
		{ after(grammarAccess.getConceptReferenceAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_5_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__EntityAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityReferenceAccess().getEntityRelationEntityCrossReference_4_0()); }
		(
			{ before(grammarAccess.getRelationEntityReferenceAccess().getEntityRelationEntityRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationEntityReferenceAccess().getEntityRelationEntityRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getRelationEntityReferenceAccess().getEntityRelationEntityCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__OwnedSpecializationsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__OwnedSpecializationsAssignment_5_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__OwnedKeysAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedKeysKeyAxiomParserRuleCall_6_1_0()); }
		ruleKeyAxiom
		{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedKeysKeyAxiomParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__OwnedPropertyRestrictionsAssignment_6_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_6_2_0()); }
		rulePropertyRestrictionAxiom
		{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_6_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityReference__OwnedRelationRestrictionsAssignment_6_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityReferenceAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_6_3_0()); }
		ruleRelationRestrictionAxiom
		{ after(grammarAccess.getRelationEntityReferenceAccess().getOwnedRelationRestrictionsRelationRestrictionAxiomParserRuleCall_6_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getStructureReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__StructureAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureReferenceAccess().getStructureStructureCrossReference_3_0()); }
		(
			{ before(grammarAccess.getStructureReferenceAccess().getStructureStructureRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructureReferenceAccess().getStructureStructureRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getStructureReferenceAccess().getStructureStructureCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__OwnedSpecializationsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__OwnedSpecializationsAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getStructureReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructureReference__OwnedPropertyRestrictionsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureReferenceAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_5_1_0()); }
		rulePropertyRestrictionAxiom
		{ after(grammarAccess.getStructureReferenceAccess().getOwnedPropertyRestrictionsPropertyRestrictionAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__PropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getPropertyAnnotationPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getPropertyAnnotationPropertyRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getPropertyAnnotationPropertyRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getPropertyAnnotationPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__OwnedSpecializationsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyReference__OwnedSpecializationsAssignment_5_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getAnnotationPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getScalarPropertyReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__PropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyReferenceAccess().getPropertyScalarPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getScalarPropertyReferenceAccess().getPropertyScalarPropertyRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getScalarPropertyReferenceAccess().getPropertyScalarPropertyRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getScalarPropertyReferenceAccess().getPropertyScalarPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__OwnedSpecializationsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyReference__OwnedSpecializationsAssignment_5_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getScalarPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__PropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyReferenceAccess().getPropertyStructuredPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyReferenceAccess().getPropertyStructuredPropertyRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructuredPropertyReferenceAccess().getPropertyStructuredPropertyRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getStructuredPropertyReferenceAccess().getPropertyStructuredPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__OwnedSpecializationsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyReference__OwnedSpecializationsAssignment_5_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getStructuredPropertyReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getFacetedScalarReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__ScalarAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarReferenceAccess().getScalarFacetedScalarCrossReference_3_0()); }
		(
			{ before(grammarAccess.getFacetedScalarReferenceAccess().getScalarFacetedScalarRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getFacetedScalarReferenceAccess().getScalarFacetedScalarRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getFacetedScalarReferenceAccess().getScalarFacetedScalarCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__OwnedSpecializationsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FacetedScalarReference__OwnedSpecializationsAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getFacetedScalarReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__ScalarAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getScalarEnumeratedScalarCrossReference_4_0()); }
		(
			{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getScalarEnumeratedScalarRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getScalarEnumeratedScalarRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getScalarEnumeratedScalarCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__OwnedSpecializationsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumeratedScalarReference__OwnedSpecializationsAssignment_5_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getEnumeratedScalarReferenceAccess().getOwnedSpecializationsSpecializationAxiomParserRuleCall_5_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationReference__RelationAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationReferenceAccess().getRelationRelationCrossReference_3_0()); }
		(
			{ before(grammarAccess.getRelationReferenceAccess().getRelationRelationRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationReferenceAccess().getRelationRelationRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getRelationReferenceAccess().getRelationRelationCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRuleReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleReference__RuleAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleReferenceAccess().getRuleRuleCrossReference_3_0()); }
		(
			{ before(grammarAccess.getRuleReferenceAccess().getRuleRuleRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getRuleReferenceAccess().getRuleRuleRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getRuleReferenceAccess().getRuleRuleCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__InstanceAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceReferenceAccess().getInstanceConceptInstanceCrossReference_3_0()); }
		(
			{ before(grammarAccess.getConceptInstanceReferenceAccess().getInstanceConceptInstanceRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getConceptInstanceReferenceAccess().getInstanceConceptInstanceRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getConceptInstanceReferenceAccess().getInstanceConceptInstanceCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__OwnedTypesAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesConceptTypeAssertionParserRuleCall_4_1_0()); }
		ruleConceptTypeAssertion
		{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesConceptTypeAssertionParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__OwnedTypesAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesConceptTypeAssertionParserRuleCall_4_2_1_0()); }
		ruleConceptTypeAssertion
		{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedTypesConceptTypeAssertionParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__OwnedPropertyValuesAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_5_1_0()); }
		rulePropertyValueAssertion
		{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstanceReference__OwnedLinksAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceReferenceAccess().getOwnedLinksLinkAssertionParserRuleCall_5_2_0()); }
		ruleLinkAssertion
		{ after(grammarAccess.getConceptInstanceReferenceAccess().getOwnedLinksLinkAssertionParserRuleCall_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__InstanceAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceReferenceAccess().getInstanceRelationInstanceCrossReference_3_0()); }
		(
			{ before(grammarAccess.getRelationInstanceReferenceAccess().getInstanceRelationInstanceRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationInstanceReferenceAccess().getInstanceRelationInstanceRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getRelationInstanceReferenceAccess().getInstanceRelationInstanceCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__OwnedTypesAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesRelationTypeAssertionParserRuleCall_4_1_0()); }
		ruleRelationTypeAssertion
		{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesRelationTypeAssertionParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__OwnedTypesAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesRelationTypeAssertionParserRuleCall_4_2_1_0()); }
		ruleRelationTypeAssertion
		{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedTypesRelationTypeAssertionParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__OwnedPropertyValuesAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_5_1_0()); }
		rulePropertyValueAssertion
		{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedPropertyValuesPropertyValueAssertionParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationInstanceReference__OwnedLinksAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationInstanceReferenceAccess().getOwnedLinksLinkAssertionParserRuleCall_5_2_0()); }
		ruleLinkAssertion
		{ after(grammarAccess.getRelationInstanceReferenceAccess().getOwnedLinksLinkAssertionParserRuleCall_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyExtensionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getVocabularyExtensionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__UriAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyExtensionAccess().getUriIRITerminalRuleCall_2_0()); }
		RULE_IRI
		{ after(grammarAccess.getVocabularyExtensionAccess().getUriIRITerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyExtension__PrefixAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyExtensionAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
		RULE_ID
		{ after(grammarAccess.getVocabularyExtensionAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyUsageAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getVocabularyUsageAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__UriAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyUsageAccess().getUriIRITerminalRuleCall_2_0()); }
		RULE_IRI
		{ after(grammarAccess.getVocabularyUsageAccess().getUriIRITerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VocabularyUsage__PrefixAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVocabularyUsageAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
		RULE_ID
		{ after(grammarAccess.getVocabularyUsageAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleInclusionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getBundleInclusionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__UriAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleInclusionAccess().getUriIRITerminalRuleCall_2_0()); }
		RULE_IRI
		{ after(grammarAccess.getBundleInclusionAccess().getUriIRITerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleInclusion__PrefixAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleInclusionAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
		RULE_ID
		{ after(grammarAccess.getBundleInclusionAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleExtensionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getBundleExtensionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__UriAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleExtensionAccess().getUriIRITerminalRuleCall_2_0()); }
		RULE_IRI
		{ after(grammarAccess.getBundleExtensionAccess().getUriIRITerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundleExtension__PrefixAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleExtensionAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
		RULE_ID
		{ after(grammarAccess.getBundleExtensionAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionUsageAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getDescriptionUsageAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__UriAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionUsageAccess().getUriIRITerminalRuleCall_2_0()); }
		RULE_IRI
		{ after(grammarAccess.getDescriptionUsageAccess().getUriIRITerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionUsage__PrefixAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionUsageAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
		RULE_ID
		{ after(grammarAccess.getDescriptionUsageAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionExtensionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getDescriptionExtensionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__UriAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionExtensionAccess().getUriIRITerminalRuleCall_2_0()); }
		RULE_IRI
		{ after(grammarAccess.getDescriptionExtensionAccess().getUriIRITerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionExtension__PrefixAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionExtensionAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
		RULE_ID
		{ after(grammarAccess.getDescriptionExtensionAccess().getPrefixIDTerminalRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecializationAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSpecializationAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getSpecializationAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecializationAxiom__SpecializedTermAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSpecializationAxiomAccess().getSpecializedTermSpecializableTermCrossReference_1_0()); }
		(
			{ before(grammarAccess.getSpecializationAxiomAccess().getSpecializedTermSpecializableTermRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getSpecializationAxiomAccess().getSpecializedTermSpecializableTermRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getSpecializationAxiomAccess().getSpecializedTermSpecializableTermCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__KindAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getKindRangeRestrictionKindEnumRuleCall_2_0()); }
		ruleRangeRestrictionKind
		{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getKindRangeRestrictionKindEnumRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__PropertyAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyScalarPropertyCrossReference_5_0()); }
		(
			{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyScalarPropertyRefParserRuleCall_5_0_1()); }
			ruleRef
			{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyScalarPropertyRefParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getPropertyScalarPropertyCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyRangeRestrictionAxiom__RangeAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRangeScalarCrossReference_7_0()); }
		(
			{ before(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRangeScalarRefParserRuleCall_7_0_1()); }
			ruleRef
			{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRangeScalarRefParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getScalarPropertyRangeRestrictionAxiomAccess().getRangeScalarCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__PropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyScalarPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyScalarPropertyRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyScalarPropertyRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getPropertyScalarPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__KindAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getKindCardinalityRestrictionKindEnumRuleCall_6_0()); }
		ruleCardinalityRestrictionKind
		{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getKindCardinalityRestrictionKindEnumRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__CardinalityAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getCardinalityUnsignedIntegerParserRuleCall_7_0()); }
		ruleUnsignedInteger
		{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getCardinalityUnsignedIntegerParserRuleCall_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyCardinalityRestrictionAxiom__RangeAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRangeScalarCrossReference_8_0()); }
		(
			{ before(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRangeScalarRefParserRuleCall_8_0_1()); }
			ruleRef
			{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRangeScalarRefParserRuleCall_8_0_1()); }
		)
		{ after(grammarAccess.getScalarPropertyCardinalityRestrictionAxiomAccess().getRangeScalarCrossReference_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__PropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyScalarPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyScalarPropertyRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyScalarPropertyRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getPropertyScalarPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueRestrictionAxiom__ValueAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getValueLiteralParserRuleCall_6_0()); }
		ruleLiteral
		{ after(grammarAccess.getScalarPropertyValueRestrictionAxiomAccess().getValueLiteralParserRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__KindAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getKindRangeRestrictionKindEnumRuleCall_2_0()); }
		ruleRangeRestrictionKind
		{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getKindRangeRestrictionKindEnumRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__PropertyAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyStructuredPropertyCrossReference_5_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyStructuredPropertyRefParserRuleCall_5_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyStructuredPropertyRefParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getPropertyStructuredPropertyCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyRangeRestrictionAxiom__RangeAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRangeStructureCrossReference_7_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRangeStructureRefParserRuleCall_7_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRangeStructureRefParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getStructuredPropertyRangeRestrictionAxiomAccess().getRangeStructureCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__PropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyStructuredPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyStructuredPropertyRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyStructuredPropertyRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getPropertyStructuredPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__KindAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getKindCardinalityRestrictionKindEnumRuleCall_6_0()); }
		ruleCardinalityRestrictionKind
		{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getKindCardinalityRestrictionKindEnumRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__CardinalityAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getCardinalityUnsignedIntegerParserRuleCall_7_0()); }
		ruleUnsignedInteger
		{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getCardinalityUnsignedIntegerParserRuleCall_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyCardinalityRestrictionAxiom__RangeAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRangeStructureCrossReference_8_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRangeStructureRefParserRuleCall_8_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRangeStructureRefParserRuleCall_8_0_1()); }
		)
		{ after(grammarAccess.getStructuredPropertyCardinalityRestrictionAxiomAccess().getRangeStructureCrossReference_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__PropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyStructuredPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyStructuredPropertyRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyStructuredPropertyRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getPropertyStructuredPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueRestrictionAxiom__ValueAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getValueStructureInstanceParserRuleCall_6_0()); }
		ruleStructureInstance
		{ after(grammarAccess.getStructuredPropertyValueRestrictionAxiomAccess().getValueStructureInstanceParserRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__KindAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getKindRangeRestrictionKindEnumRuleCall_2_0()); }
		ruleRangeRestrictionKind
		{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getKindRangeRestrictionKindEnumRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__RelationAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationRelationCrossReference_4_0()); }
		(
			{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationRelationRefParserRuleCall_4_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationRelationRefParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRelationRelationCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationRangeRestrictionAxiom__RangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRangeEntityCrossReference_6_0()); }
		(
			{ before(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRangeEntityRefParserRuleCall_6_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRangeEntityRefParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getRelationRangeRestrictionAxiomAccess().getRangeEntityCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__RelationAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationRelationCrossReference_3_0()); }
		(
			{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationRelationRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationRelationRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRelationRelationCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__KindAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getKindCardinalityRestrictionKindEnumRuleCall_5_0()); }
		ruleCardinalityRestrictionKind
		{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getKindCardinalityRestrictionKindEnumRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__CardinalityAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getCardinalityUnsignedIntegerParserRuleCall_6_0()); }
		ruleUnsignedInteger
		{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getCardinalityUnsignedIntegerParserRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationCardinalityRestrictionAxiom__RangeAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRangeEntityCrossReference_7_0()); }
		(
			{ before(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRangeEntityRefParserRuleCall_7_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRangeEntityRefParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getRelationCardinalityRestrictionAxiomAccess().getRangeEntityCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__RelationAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationRelationCrossReference_3_0()); }
		(
			{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationRelationRefParserRuleCall_3_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationRelationRefParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getRelationRelationCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTargetRestrictionAxiom__TargetAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getTargetNamedInstanceCrossReference_5_0()); }
		(
			{ before(grammarAccess.getRelationTargetRestrictionAxiomAccess().getTargetNamedInstanceRefParserRuleCall_5_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getTargetNamedInstanceRefParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getRelationTargetRestrictionAxiomAccess().getTargetNamedInstanceCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__PropertiesAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getKeyAxiomAccess().getPropertiesScalarPropertyCrossReference_1_0()); }
		(
			{ before(grammarAccess.getKeyAxiomAccess().getPropertiesScalarPropertyRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getKeyAxiomAccess().getPropertiesScalarPropertyRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getKeyAxiomAccess().getPropertiesScalarPropertyCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyAxiom__PropertiesAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getKeyAxiomAccess().getPropertiesScalarPropertyCrossReference_2_1_0()); }
		(
			{ before(grammarAccess.getKeyAxiomAccess().getPropertiesScalarPropertyRefParserRuleCall_2_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getKeyAxiomAccess().getPropertiesScalarPropertyRefParserRuleCall_2_1_0_1()); }
		)
		{ after(grammarAccess.getKeyAxiomAccess().getPropertiesScalarPropertyCrossReference_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptTypeAssertion__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptTypeAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getConceptTypeAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptTypeAssertion__TypeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptTypeAssertionAccess().getTypeConceptCrossReference_1_0()); }
		(
			{ before(grammarAccess.getConceptTypeAssertionAccess().getTypeConceptRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getConceptTypeAssertionAccess().getTypeConceptRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getConceptTypeAssertionAccess().getTypeConceptCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTypeAssertion__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationTypeAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationTypeAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationTypeAssertion__TypeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationTypeAssertionAccess().getTypeRelationEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getRelationTypeAssertionAccess().getTypeRelationEntityRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationTypeAssertionAccess().getTypeRelationEntityRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getRelationTypeAssertionAccess().getTypeRelationEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueAssertion__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyValueAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getScalarPropertyValueAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueAssertion__PropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyValueAssertionAccess().getPropertyScalarPropertyCrossReference_1_0()); }
		(
			{ before(grammarAccess.getScalarPropertyValueAssertionAccess().getPropertyScalarPropertyRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getScalarPropertyValueAssertionAccess().getPropertyScalarPropertyRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getScalarPropertyValueAssertionAccess().getPropertyScalarPropertyCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarPropertyValueAssertion__ValueAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarPropertyValueAssertionAccess().getValueLiteralParserRuleCall_2_0()); }
		ruleLiteral
		{ after(grammarAccess.getScalarPropertyValueAssertionAccess().getValueLiteralParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueAssertion__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyValueAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getStructuredPropertyValueAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueAssertion__PropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyValueAssertionAccess().getPropertyStructuredPropertyCrossReference_1_0()); }
		(
			{ before(grammarAccess.getStructuredPropertyValueAssertionAccess().getPropertyStructuredPropertyRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getStructuredPropertyValueAssertionAccess().getPropertyStructuredPropertyRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getStructuredPropertyValueAssertionAccess().getPropertyStructuredPropertyCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredPropertyValueAssertion__ValueAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredPropertyValueAssertionAccess().getValueStructureInstanceParserRuleCall_2_0()); }
		ruleStructureInstance
		{ after(grammarAccess.getStructuredPropertyValueAssertionAccess().getValueStructureInstanceParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LinkAssertion__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLinkAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getLinkAssertionAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LinkAssertion__RelationAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLinkAssertionAccess().getRelationRelationCrossReference_1_0()); }
		(
			{ before(grammarAccess.getLinkAssertionAccess().getRelationRelationRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getLinkAssertionAccess().getRelationRelationRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getLinkAssertionAccess().getRelationRelationCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LinkAssertion__TargetAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLinkAssertionAccess().getTargetNamedInstanceCrossReference_2_0()); }
		(
			{ before(grammarAccess.getLinkAssertionAccess().getTargetNamedInstanceRefParserRuleCall_2_0_1()); }
			ruleRef
			{ after(grammarAccess.getLinkAssertionAccess().getTargetNamedInstanceRefParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getLinkAssertionAccess().getTargetNamedInstanceCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getEntityPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__EntityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityPredicateAccess().getEntityEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getEntityPredicateAccess().getEntityEntityRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getEntityPredicateAccess().getEntityEntityRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getEntityPredicateAccess().getEntityEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityPredicate__VariableAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityPredicateAccess().getVariableIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getEntityPredicateAccess().getVariableIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__RelationAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationPredicateAccess().getRelationRelationCrossReference_1_0()); }
		(
			{ before(grammarAccess.getRelationPredicateAccess().getRelationRelationRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationPredicateAccess().getRelationRelationRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getRelationPredicateAccess().getRelationRelationCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Variable1Assignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationPredicateAccess().getVariable1IDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getRelationPredicateAccess().getVariable1IDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationPredicate__Variable2Assignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationPredicateAccess().getVariable2IDTerminalRuleCall_5_0()); }
		RULE_ID
		{ after(grammarAccess.getRelationPredicateAccess().getVariable2IDTerminalRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSameAsPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getSameAsPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Variable1Assignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSameAsPredicateAccess().getVariable1IDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getSameAsPredicateAccess().getVariable1IDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SameAsPredicate__Variable2Assignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSameAsPredicateAccess().getVariable2IDTerminalRuleCall_5_0()); }
		RULE_ID
		{ after(grammarAccess.getSameAsPredicateAccess().getVariable2IDTerminalRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDifferentFromPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getDifferentFromPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Variable1Assignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDifferentFromPredicateAccess().getVariable1IDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getDifferentFromPredicateAccess().getVariable1IDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DifferentFromPredicate__Variable2Assignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDifferentFromPredicateAccess().getVariable2IDTerminalRuleCall_5_0()); }
		RULE_ID
		{ after(grammarAccess.getDifferentFromPredicateAccess().getVariable2IDTerminalRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__OwnedAnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getRelationEntityPredicateAccess().getOwnedAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__EntityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityPredicateAccess().getEntityRelationEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getRelationEntityPredicateAccess().getEntityRelationEntityRefParserRuleCall_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getRelationEntityPredicateAccess().getEntityRelationEntityRefParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getRelationEntityPredicateAccess().getEntityRelationEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Variable1Assignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityPredicateAccess().getVariable1IDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getRelationEntityPredicateAccess().getVariable1IDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__EntityVariableAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityPredicateAccess().getEntityVariableIDTerminalRuleCall_5_0()); }
		RULE_ID
		{ after(grammarAccess.getRelationEntityPredicateAccess().getEntityVariableIDTerminalRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationEntityPredicate__Variable2Assignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationEntityPredicateAccess().getVariable2IDTerminalRuleCall_7_0()); }
		RULE_ID
		{ after(grammarAccess.getRelationEntityPredicateAccess().getVariable2IDTerminalRuleCall_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerLiteral__ValueAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIntegerLiteralAccess().getValueIntegerParserRuleCall_0_0()); }
		ruleInteger
		{ after(grammarAccess.getIntegerLiteralAccess().getValueIntegerParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerLiteral__TypeAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIntegerLiteralAccess().getTypeScalarCrossReference_1_1_0()); }
		(
			{ before(grammarAccess.getIntegerLiteralAccess().getTypeScalarRefParserRuleCall_1_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getIntegerLiteralAccess().getTypeScalarRefParserRuleCall_1_1_0_1()); }
		)
		{ after(grammarAccess.getIntegerLiteralAccess().getTypeScalarCrossReference_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DecimalLiteral__ValueAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDecimalLiteralAccess().getValueDecimalParserRuleCall_0_0()); }
		ruleDecimal
		{ after(grammarAccess.getDecimalLiteralAccess().getValueDecimalParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DecimalLiteral__TypeAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDecimalLiteralAccess().getTypeScalarCrossReference_1_1_0()); }
		(
			{ before(grammarAccess.getDecimalLiteralAccess().getTypeScalarRefParserRuleCall_1_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getDecimalLiteralAccess().getTypeScalarRefParserRuleCall_1_1_0_1()); }
		)
		{ after(grammarAccess.getDecimalLiteralAccess().getTypeScalarCrossReference_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleLiteral__ValueAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDoubleLiteralAccess().getValueDoubleParserRuleCall_0_0()); }
		ruleDouble
		{ after(grammarAccess.getDoubleLiteralAccess().getValueDoubleParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleLiteral__TypeAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDoubleLiteralAccess().getTypeScalarCrossReference_1_1_0()); }
		(
			{ before(grammarAccess.getDoubleLiteralAccess().getTypeScalarRefParserRuleCall_1_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getDoubleLiteralAccess().getTypeScalarRefParserRuleCall_1_1_0_1()); }
		)
		{ after(grammarAccess.getDoubleLiteralAccess().getTypeScalarCrossReference_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__ValueAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getValueBooleanParserRuleCall_0_0()); }
		ruleBoolean
		{ after(grammarAccess.getBooleanLiteralAccess().getValueBooleanParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__TypeAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getTypeScalarCrossReference_1_1_0()); }
		(
			{ before(grammarAccess.getBooleanLiteralAccess().getTypeScalarRefParserRuleCall_1_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getBooleanLiteralAccess().getTypeScalarRefParserRuleCall_1_1_0_1()); }
		)
		{ after(grammarAccess.getBooleanLiteralAccess().getTypeScalarCrossReference_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__ValueAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQuotedLiteralAccess().getValueSTRINGTerminalRuleCall_0_0()); }
		RULE_STRING
		{ after(grammarAccess.getQuotedLiteralAccess().getValueSTRINGTerminalRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__TypeAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQuotedLiteralAccess().getTypeScalarCrossReference_1_0_1_0()); }
		(
			{ before(grammarAccess.getQuotedLiteralAccess().getTypeScalarRefParserRuleCall_1_0_1_0_1()); }
			ruleRef
			{ after(grammarAccess.getQuotedLiteralAccess().getTypeScalarRefParserRuleCall_1_0_1_0_1()); }
		)
		{ after(grammarAccess.getQuotedLiteralAccess().getTypeScalarCrossReference_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__QuotedLiteral__LangTagAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQuotedLiteralAccess().getLangTagIDTerminalRuleCall_1_1_1_0()); }
		RULE_ID
		{ after(grammarAccess.getQuotedLiteralAccess().getLangTagIDTerminalRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}
