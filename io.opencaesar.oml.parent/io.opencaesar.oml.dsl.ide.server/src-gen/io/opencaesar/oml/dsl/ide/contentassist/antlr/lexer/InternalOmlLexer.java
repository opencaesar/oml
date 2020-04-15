package io.opencaesar.oml.dsl.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOmlLexer extends Lexer {
    public static final int All=47;
    public static final int Vocabulary=17;
    public static final int Entity=37;
    public static final int DifferentFrom=4;
    public static final int RULE_INTEGER_STR=75;
    public static final int Ci=56;
    public static final int Asymmetric=12;
    public static final int RULE_ABBREV_IRI=81;
    public static final int Irreflexive=10;
    public static final int MaxLength=18;
    public static final int Aspect=34;
    public static final int Restricts=21;
    public static final int CircumflexAccentCircumflexAccent=54;
    public static final int LeftParenthesis=61;
    public static final int RULE_DECIMAL_STR=76;
    public static final int Inverse=32;
    public static final int To=58;
    public static final int Reflexive=20;
    public static final int Extends=30;
    public static final int RightSquareBracket=68;
    public static final int Concept=28;
    public static final int RULE_ID=80;
    public static final int RULE_BOOLEAN_STR=72;
    public static final int RightParenthesis=62;
    public static final int RULE_DIGIT=73;
    public static final int Structured=15;
    public static final int Range=41;
    public static final int ColonGreaterThanSign=53;
    public static final int Functional=14;
    public static final int Some=44;
    public static final int Min=50;
    public static final int RULE_UNSIGNED_INTEGER_STR=74;
    public static final int NumberSign=59;
    public static final int RULE_ML_COMMENT=83;
    public static final int LeftSquareBracket=67;
    public static final int Rule=43;
    public static final int Domain=36;
    public static final int RULE_DOUBLE_STR=77;
    public static final int Key=48;
    public static final int RULE_ALPHA=82;
    public static final int Description=9;
    public static final int Uses=45;
    public static final int Max=49;
    public static final int MaxExclusive=5;
    public static final int RULE_IRI=79;
    public static final int MinExclusive=7;
    public static final int Transitive=16;
    public static final int RULE_STRING=78;
    public static final int MaxInclusive=6;
    public static final int Scalar=40;
    public static final int With=46;
    public static final int RULE_SL_COMMENT=84;
    public static final int MinInclusive=8;
    public static final int Includes=24;
    public static final int Enumerated=13;
    public static final int Comma=63;
    public static final int Relation=27;
    public static final int As=55;
    public static final int Language=25;
    public static final int Ri=57;
    public static final int Solidus=64;
    public static final int Colon=65;
    public static final int RightCurlyBracket=71;
    public static final int Structure=22;
    public static final int EOF=-1;
    public static final int Property=26;
    public static final int Pattern=33;
    public static final int RULE_WS=85;
    public static final int Bundle=35;
    public static final int LeftCurlyBracket=70;
    public static final int MinLength=19;
    public static final int From=42;
    public static final int Annotation=11;
    public static final int CircumflexAccent=69;
    public static final int CommercialAt=66;
    public static final int Ref=51;
    public static final int SameAs=39;
    public static final int Exactly=29;
    public static final int Length=38;
    public static final int DollarSign=60;
    public static final int Forward=31;
    public static final int Symmetric=23;
    public static final int HyphenMinusGreaterThanSign=52;

    // delegates
    // delegators

    public InternalOmlLexer() {;} 
    public InternalOmlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalOmlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalOmlLexer.g"; }

    // $ANTLR start "DifferentFrom"
    public final void mDifferentFrom() throws RecognitionException {
        try {
            int _type = DifferentFrom;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:27:15: ( 'differentFrom' )
            // InternalOmlLexer.g:27:17: 'differentFrom'
            {
            match("differentFrom"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DifferentFrom"

    // $ANTLR start "MaxExclusive"
    public final void mMaxExclusive() throws RecognitionException {
        try {
            int _type = MaxExclusive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:29:14: ( 'maxExclusive' )
            // InternalOmlLexer.g:29:16: 'maxExclusive'
            {
            match("maxExclusive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MaxExclusive"

    // $ANTLR start "MaxInclusive"
    public final void mMaxInclusive() throws RecognitionException {
        try {
            int _type = MaxInclusive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:31:14: ( 'maxInclusive' )
            // InternalOmlLexer.g:31:16: 'maxInclusive'
            {
            match("maxInclusive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MaxInclusive"

    // $ANTLR start "MinExclusive"
    public final void mMinExclusive() throws RecognitionException {
        try {
            int _type = MinExclusive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:33:14: ( 'minExclusive' )
            // InternalOmlLexer.g:33:16: 'minExclusive'
            {
            match("minExclusive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MinExclusive"

    // $ANTLR start "MinInclusive"
    public final void mMinInclusive() throws RecognitionException {
        try {
            int _type = MinInclusive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:35:14: ( 'minInclusive' )
            // InternalOmlLexer.g:35:16: 'minInclusive'
            {
            match("minInclusive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MinInclusive"

    // $ANTLR start "Description"
    public final void mDescription() throws RecognitionException {
        try {
            int _type = Description;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:37:13: ( 'description' )
            // InternalOmlLexer.g:37:15: 'description'
            {
            match("description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Description"

    // $ANTLR start "Irreflexive"
    public final void mIrreflexive() throws RecognitionException {
        try {
            int _type = Irreflexive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:39:13: ( 'irreflexive' )
            // InternalOmlLexer.g:39:15: 'irreflexive'
            {
            match("irreflexive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Irreflexive"

    // $ANTLR start "Annotation"
    public final void mAnnotation() throws RecognitionException {
        try {
            int _type = Annotation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:41:12: ( 'annotation' )
            // InternalOmlLexer.g:41:14: 'annotation'
            {
            match("annotation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Annotation"

    // $ANTLR start "Asymmetric"
    public final void mAsymmetric() throws RecognitionException {
        try {
            int _type = Asymmetric;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:43:12: ( 'asymmetric' )
            // InternalOmlLexer.g:43:14: 'asymmetric'
            {
            match("asymmetric"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asymmetric"

    // $ANTLR start "Enumerated"
    public final void mEnumerated() throws RecognitionException {
        try {
            int _type = Enumerated;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:45:12: ( 'enumerated' )
            // InternalOmlLexer.g:45:14: 'enumerated'
            {
            match("enumerated"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Enumerated"

    // $ANTLR start "Functional"
    public final void mFunctional() throws RecognitionException {
        try {
            int _type = Functional;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:47:12: ( 'functional' )
            // InternalOmlLexer.g:47:14: 'functional'
            {
            match("functional"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Functional"

    // $ANTLR start "Structured"
    public final void mStructured() throws RecognitionException {
        try {
            int _type = Structured;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:49:12: ( 'structured' )
            // InternalOmlLexer.g:49:14: 'structured'
            {
            match("structured"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Structured"

    // $ANTLR start "Transitive"
    public final void mTransitive() throws RecognitionException {
        try {
            int _type = Transitive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:51:12: ( 'transitive' )
            // InternalOmlLexer.g:51:14: 'transitive'
            {
            match("transitive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Transitive"

    // $ANTLR start "Vocabulary"
    public final void mVocabulary() throws RecognitionException {
        try {
            int _type = Vocabulary;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:53:12: ( 'vocabulary' )
            // InternalOmlLexer.g:53:14: 'vocabulary'
            {
            match("vocabulary"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Vocabulary"

    // $ANTLR start "MaxLength"
    public final void mMaxLength() throws RecognitionException {
        try {
            int _type = MaxLength;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:55:11: ( 'maxLength' )
            // InternalOmlLexer.g:55:13: 'maxLength'
            {
            match("maxLength"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MaxLength"

    // $ANTLR start "MinLength"
    public final void mMinLength() throws RecognitionException {
        try {
            int _type = MinLength;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:57:11: ( 'minLength' )
            // InternalOmlLexer.g:57:13: 'minLength'
            {
            match("minLength"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MinLength"

    // $ANTLR start "Reflexive"
    public final void mReflexive() throws RecognitionException {
        try {
            int _type = Reflexive;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:59:11: ( 'reflexive' )
            // InternalOmlLexer.g:59:13: 'reflexive'
            {
            match("reflexive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Reflexive"

    // $ANTLR start "Restricts"
    public final void mRestricts() throws RecognitionException {
        try {
            int _type = Restricts;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:61:11: ( 'restricts' )
            // InternalOmlLexer.g:61:13: 'restricts'
            {
            match("restricts"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Restricts"

    // $ANTLR start "Structure"
    public final void mStructure() throws RecognitionException {
        try {
            int _type = Structure;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:63:11: ( 'structure' )
            // InternalOmlLexer.g:63:13: 'structure'
            {
            match("structure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Structure"

    // $ANTLR start "Symmetric"
    public final void mSymmetric() throws RecognitionException {
        try {
            int _type = Symmetric;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:65:11: ( 'symmetric' )
            // InternalOmlLexer.g:65:13: 'symmetric'
            {
            match("symmetric"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Symmetric"

    // $ANTLR start "Includes"
    public final void mIncludes() throws RecognitionException {
        try {
            int _type = Includes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:67:10: ( 'includes' )
            // InternalOmlLexer.g:67:12: 'includes'
            {
            match("includes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Includes"

    // $ANTLR start "Language"
    public final void mLanguage() throws RecognitionException {
        try {
            int _type = Language;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:69:10: ( 'language' )
            // InternalOmlLexer.g:69:12: 'language'
            {
            match("language"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Language"

    // $ANTLR start "Property"
    public final void mProperty() throws RecognitionException {
        try {
            int _type = Property;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:71:10: ( 'property' )
            // InternalOmlLexer.g:71:12: 'property'
            {
            match("property"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Property"

    // $ANTLR start "Relation"
    public final void mRelation() throws RecognitionException {
        try {
            int _type = Relation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:73:10: ( 'relation' )
            // InternalOmlLexer.g:73:12: 'relation'
            {
            match("relation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Relation"

    // $ANTLR start "Concept"
    public final void mConcept() throws RecognitionException {
        try {
            int _type = Concept;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:75:9: ( 'concept' )
            // InternalOmlLexer.g:75:11: 'concept'
            {
            match("concept"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Concept"

    // $ANTLR start "Exactly"
    public final void mExactly() throws RecognitionException {
        try {
            int _type = Exactly;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:77:9: ( 'exactly' )
            // InternalOmlLexer.g:77:11: 'exactly'
            {
            match("exactly"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Exactly"

    // $ANTLR start "Extends"
    public final void mExtends() throws RecognitionException {
        try {
            int _type = Extends;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:79:9: ( 'extends' )
            // InternalOmlLexer.g:79:11: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Extends"

    // $ANTLR start "Forward"
    public final void mForward() throws RecognitionException {
        try {
            int _type = Forward;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:81:9: ( 'forward' )
            // InternalOmlLexer.g:81:11: 'forward'
            {
            match("forward"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Forward"

    // $ANTLR start "Inverse"
    public final void mInverse() throws RecognitionException {
        try {
            int _type = Inverse;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:83:9: ( 'inverse' )
            // InternalOmlLexer.g:83:11: 'inverse'
            {
            match("inverse"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Inverse"

    // $ANTLR start "Pattern"
    public final void mPattern() throws RecognitionException {
        try {
            int _type = Pattern;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:85:9: ( 'pattern' )
            // InternalOmlLexer.g:85:11: 'pattern'
            {
            match("pattern"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Pattern"

    // $ANTLR start "Aspect"
    public final void mAspect() throws RecognitionException {
        try {
            int _type = Aspect;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:87:8: ( 'aspect' )
            // InternalOmlLexer.g:87:10: 'aspect'
            {
            match("aspect"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Aspect"

    // $ANTLR start "Bundle"
    public final void mBundle() throws RecognitionException {
        try {
            int _type = Bundle;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:89:8: ( 'bundle' )
            // InternalOmlLexer.g:89:10: 'bundle'
            {
            match("bundle"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Bundle"

    // $ANTLR start "Domain"
    public final void mDomain() throws RecognitionException {
        try {
            int _type = Domain;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:91:8: ( 'domain' )
            // InternalOmlLexer.g:91:10: 'domain'
            {
            match("domain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Domain"

    // $ANTLR start "Entity"
    public final void mEntity() throws RecognitionException {
        try {
            int _type = Entity;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:93:8: ( 'entity' )
            // InternalOmlLexer.g:93:10: 'entity'
            {
            match("entity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Entity"

    // $ANTLR start "Length"
    public final void mLength() throws RecognitionException {
        try {
            int _type = Length;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:95:8: ( 'length' )
            // InternalOmlLexer.g:95:10: 'length'
            {
            match("length"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Length"

    // $ANTLR start "SameAs"
    public final void mSameAs() throws RecognitionException {
        try {
            int _type = SameAs;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:97:8: ( 'sameAs' )
            // InternalOmlLexer.g:97:10: 'sameAs'
            {
            match("sameAs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SameAs"

    // $ANTLR start "Scalar"
    public final void mScalar() throws RecognitionException {
        try {
            int _type = Scalar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:99:8: ( 'scalar' )
            // InternalOmlLexer.g:99:10: 'scalar'
            {
            match("scalar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Scalar"

    // $ANTLR start "Range"
    public final void mRange() throws RecognitionException {
        try {
            int _type = Range;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:101:7: ( 'range' )
            // InternalOmlLexer.g:101:9: 'range'
            {
            match("range"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Range"

    // $ANTLR start "From"
    public final void mFrom() throws RecognitionException {
        try {
            int _type = From;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:103:6: ( 'from' )
            // InternalOmlLexer.g:103:8: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "From"

    // $ANTLR start "Rule"
    public final void mRule() throws RecognitionException {
        try {
            int _type = Rule;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:105:6: ( 'rule' )
            // InternalOmlLexer.g:105:8: 'rule'
            {
            match("rule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Rule"

    // $ANTLR start "Some"
    public final void mSome() throws RecognitionException {
        try {
            int _type = Some;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:107:6: ( 'some' )
            // InternalOmlLexer.g:107:8: 'some'
            {
            match("some"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Some"

    // $ANTLR start "Uses"
    public final void mUses() throws RecognitionException {
        try {
            int _type = Uses;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:109:6: ( 'uses' )
            // InternalOmlLexer.g:109:8: 'uses'
            {
            match("uses"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uses"

    // $ANTLR start "With"
    public final void mWith() throws RecognitionException {
        try {
            int _type = With;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:111:6: ( 'with' )
            // InternalOmlLexer.g:111:8: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "With"

    // $ANTLR start "All"
    public final void mAll() throws RecognitionException {
        try {
            int _type = All;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:113:5: ( 'all' )
            // InternalOmlLexer.g:113:7: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "All"

    // $ANTLR start "Key"
    public final void mKey() throws RecognitionException {
        try {
            int _type = Key;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:115:5: ( 'key' )
            // InternalOmlLexer.g:115:7: 'key'
            {
            match("key"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Key"

    // $ANTLR start "Max"
    public final void mMax() throws RecognitionException {
        try {
            int _type = Max;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:117:5: ( 'max' )
            // InternalOmlLexer.g:117:7: 'max'
            {
            match("max"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Max"

    // $ANTLR start "Min"
    public final void mMin() throws RecognitionException {
        try {
            int _type = Min;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:119:5: ( 'min' )
            // InternalOmlLexer.g:119:7: 'min'
            {
            match("min"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Min"

    // $ANTLR start "Ref"
    public final void mRef() throws RecognitionException {
        try {
            int _type = Ref;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:121:5: ( 'ref' )
            // InternalOmlLexer.g:121:7: 'ref'
            {
            match("ref"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ref"

    // $ANTLR start "HyphenMinusGreaterThanSign"
    public final void mHyphenMinusGreaterThanSign() throws RecognitionException {
        try {
            int _type = HyphenMinusGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:123:28: ( '->' )
            // InternalOmlLexer.g:123:30: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusGreaterThanSign"

    // $ANTLR start "ColonGreaterThanSign"
    public final void mColonGreaterThanSign() throws RecognitionException {
        try {
            int _type = ColonGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:125:22: ( ':>' )
            // InternalOmlLexer.g:125:24: ':>'
            {
            match(":>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ColonGreaterThanSign"

    // $ANTLR start "CircumflexAccentCircumflexAccent"
    public final void mCircumflexAccentCircumflexAccent() throws RecognitionException {
        try {
            int _type = CircumflexAccentCircumflexAccent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:127:34: ( '^^' )
            // InternalOmlLexer.g:127:36: '^^'
            {
            match("^^"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CircumflexAccentCircumflexAccent"

    // $ANTLR start "As"
    public final void mAs() throws RecognitionException {
        try {
            int _type = As;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:129:4: ( 'as' )
            // InternalOmlLexer.g:129:6: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "As"

    // $ANTLR start "Ci"
    public final void mCi() throws RecognitionException {
        try {
            int _type = Ci;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:131:4: ( 'ci' )
            // InternalOmlLexer.g:131:6: 'ci'
            {
            match("ci"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ci"

    // $ANTLR start "Ri"
    public final void mRi() throws RecognitionException {
        try {
            int _type = Ri;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:133:4: ( 'ri' )
            // InternalOmlLexer.g:133:6: 'ri'
            {
            match("ri"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ri"

    // $ANTLR start "To"
    public final void mTo() throws RecognitionException {
        try {
            int _type = To;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:135:4: ( 'to' )
            // InternalOmlLexer.g:135:6: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "To"

    // $ANTLR start "NumberSign"
    public final void mNumberSign() throws RecognitionException {
        try {
            int _type = NumberSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:137:12: ( '#' )
            // InternalOmlLexer.g:137:14: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSign"

    // $ANTLR start "DollarSign"
    public final void mDollarSign() throws RecognitionException {
        try {
            int _type = DollarSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:139:12: ( '$' )
            // InternalOmlLexer.g:139:14: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DollarSign"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:141:17: ( '(' )
            // InternalOmlLexer.g:141:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:143:18: ( ')' )
            // InternalOmlLexer.g:143:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:145:7: ( ',' )
            // InternalOmlLexer.g:145:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "Solidus"
    public final void mSolidus() throws RecognitionException {
        try {
            int _type = Solidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:147:9: ( '/' )
            // InternalOmlLexer.g:147:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Solidus"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:149:7: ( ':' )
            // InternalOmlLexer.g:149:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "CommercialAt"
    public final void mCommercialAt() throws RecognitionException {
        try {
            int _type = CommercialAt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:151:14: ( '@' )
            // InternalOmlLexer.g:151:16: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CommercialAt"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:153:19: ( '[' )
            // InternalOmlLexer.g:153:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:155:20: ( ']' )
            // InternalOmlLexer.g:155:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "CircumflexAccent"
    public final void mCircumflexAccent() throws RecognitionException {
        try {
            int _type = CircumflexAccent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:157:18: ( '^' )
            // InternalOmlLexer.g:157:20: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CircumflexAccent"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:159:18: ( '{' )
            // InternalOmlLexer.g:159:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:161:19: ( '}' )
            // InternalOmlLexer.g:161:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_BOOLEAN_STR"
    public final void mRULE_BOOLEAN_STR() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_STR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:163:18: ( ( 'false' | 'true' ) )
            // InternalOmlLexer.g:163:20: ( 'false' | 'true' )
            {
            // InternalOmlLexer.g:163:20: ( 'false' | 'true' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='f') ) {
                alt1=1;
            }
            else if ( (LA1_0=='t') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalOmlLexer.g:163:21: 'false'
                    {
                    match("false"); 


                    }
                    break;
                case 2 :
                    // InternalOmlLexer.g:163:29: 'true'
                    {
                    match("true"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN_STR"

    // $ANTLR start "RULE_UNSIGNED_INTEGER_STR"
    public final void mRULE_UNSIGNED_INTEGER_STR() throws RecognitionException {
        try {
            int _type = RULE_UNSIGNED_INTEGER_STR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:165:27: ( ( RULE_DIGIT )+ )
            // InternalOmlLexer.g:165:29: ( RULE_DIGIT )+
            {
            // InternalOmlLexer.g:165:29: ( RULE_DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalOmlLexer.g:165:29: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNSIGNED_INTEGER_STR"

    // $ANTLR start "RULE_INTEGER_STR"
    public final void mRULE_INTEGER_STR() throws RecognitionException {
        try {
            int _type = RULE_INTEGER_STR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:167:18: ( ( '+' | '-' )? ( RULE_DIGIT )+ )
            // InternalOmlLexer.g:167:20: ( '+' | '-' )? ( RULE_DIGIT )+
            {
            // InternalOmlLexer.g:167:20: ( '+' | '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='+'||LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalOmlLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalOmlLexer.g:167:31: ( RULE_DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOmlLexer.g:167:31: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER_STR"

    // $ANTLR start "RULE_DECIMAL_STR"
    public final void mRULE_DECIMAL_STR() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL_STR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:169:18: ( ( '+' | '-' )? ( ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )* )? | '.' ( RULE_DIGIT )+ ) )
            // InternalOmlLexer.g:169:20: ( '+' | '-' )? ( ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )* )? | '.' ( RULE_DIGIT )+ )
            {
            // InternalOmlLexer.g:169:20: ( '+' | '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='+'||LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalOmlLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalOmlLexer.g:169:31: ( ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )* )? | '.' ( RULE_DIGIT )+ )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                alt10=1;
            }
            else if ( (LA10_0=='.') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalOmlLexer.g:169:32: ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )* )?
                    {
                    // InternalOmlLexer.g:169:32: ( RULE_DIGIT )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalOmlLexer.g:169:32: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    // InternalOmlLexer.g:169:44: ( '.' ( RULE_DIGIT )* )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='.') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalOmlLexer.g:169:45: '.' ( RULE_DIGIT )*
                            {
                            match('.'); 
                            // InternalOmlLexer.g:169:49: ( RULE_DIGIT )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // InternalOmlLexer.g:169:49: RULE_DIGIT
                            	    {
                            	    mRULE_DIGIT(); 

                            	    }
                            	    break;

                            	default :
                            	    break loop7;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalOmlLexer.g:169:63: '.' ( RULE_DIGIT )+
                    {
                    match('.'); 
                    // InternalOmlLexer.g:169:67: ( RULE_DIGIT )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalOmlLexer.g:169:67: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECIMAL_STR"

    // $ANTLR start "RULE_DOUBLE_STR"
    public final void mRULE_DOUBLE_STR() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_STR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:171:17: ( ( '+' | '-' )? ( ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )* )? | '.' ( RULE_DIGIT )+ ) ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )? )
            // InternalOmlLexer.g:171:19: ( '+' | '-' )? ( ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )* )? | '.' ( RULE_DIGIT )+ ) ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )?
            {
            // InternalOmlLexer.g:171:19: ( '+' | '-' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='+'||LA11_0=='-') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalOmlLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalOmlLexer.g:171:30: ( ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )* )? | '.' ( RULE_DIGIT )+ )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                alt16=1;
            }
            else if ( (LA16_0=='.') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalOmlLexer.g:171:31: ( RULE_DIGIT )+ ( '.' ( RULE_DIGIT )* )?
                    {
                    // InternalOmlLexer.g:171:31: ( RULE_DIGIT )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalOmlLexer.g:171:31: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // InternalOmlLexer.g:171:43: ( '.' ( RULE_DIGIT )* )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='.') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalOmlLexer.g:171:44: '.' ( RULE_DIGIT )*
                            {
                            match('.'); 
                            // InternalOmlLexer.g:171:48: ( RULE_DIGIT )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // InternalOmlLexer.g:171:48: RULE_DIGIT
                            	    {
                            	    mRULE_DIGIT(); 

                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalOmlLexer.g:171:62: '.' ( RULE_DIGIT )+
                    {
                    match('.'); 
                    // InternalOmlLexer.g:171:66: ( RULE_DIGIT )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalOmlLexer.g:171:66: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);


                    }
                    break;

            }

            // InternalOmlLexer.g:171:79: ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='E'||LA19_0=='e') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalOmlLexer.g:171:80: ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalOmlLexer.g:171:90: ( '+' | '-' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='+'||LA17_0=='-') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalOmlLexer.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    // InternalOmlLexer.g:171:101: ( RULE_DIGIT )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalOmlLexer.g:171:101: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE_STR"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:173:13: ( ( '\"' (~ ( ( '\"' | '\\\\' ) ) | '\\\\' . )* '\"' | '\\'' (~ ( ( '\\'' | '\\\\' ) ) | '\\\\' . )* '\\'' | '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' | '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"' ) )
            // InternalOmlLexer.g:173:15: ( '\"' (~ ( ( '\"' | '\\\\' ) ) | '\\\\' . )* '\"' | '\\'' (~ ( ( '\\'' | '\\\\' ) ) | '\\\\' . )* '\\'' | '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' | '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"' )
            {
            // InternalOmlLexer.g:173:15: ( '\"' (~ ( ( '\"' | '\\\\' ) ) | '\\\\' . )* '\"' | '\\'' (~ ( ( '\\'' | '\\\\' ) ) | '\\\\' . )* '\\'' | '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' | '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"' )
            int alt24=4;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\"') ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1=='\"') ) {
                    int LA24_3 = input.LA(3);

                    if ( (LA24_3=='\"') ) {
                        alt24=4;
                    }
                    else {
                        alt24=1;}
                }
                else if ( ((LA24_1>='\u0000' && LA24_1<='!')||(LA24_1>='#' && LA24_1<='\uFFFF')) ) {
                    alt24=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA24_0=='\'') ) {
                int LA24_2 = input.LA(2);

                if ( (LA24_2=='\'') ) {
                    int LA24_5 = input.LA(3);

                    if ( (LA24_5=='\'') ) {
                        alt24=3;
                    }
                    else {
                        alt24=2;}
                }
                else if ( ((LA24_2>='\u0000' && LA24_2<='&')||(LA24_2>='(' && LA24_2<='\uFFFF')) ) {
                    alt24=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalOmlLexer.g:173:16: '\"' (~ ( ( '\"' | '\\\\' ) ) | '\\\\' . )* '\"'
                    {
                    match('\"'); 
                    // InternalOmlLexer.g:173:20: (~ ( ( '\"' | '\\\\' ) ) | '\\\\' . )*
                    loop20:
                    do {
                        int alt20=3;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>='\u0000' && LA20_0<='!')||(LA20_0>='#' && LA20_0<='[')||(LA20_0>=']' && LA20_0<='\uFFFF')) ) {
                            alt20=1;
                        }
                        else if ( (LA20_0=='\\') ) {
                            alt20=2;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalOmlLexer.g:173:21: ~ ( ( '\"' | '\\\\' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalOmlLexer.g:173:35: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalOmlLexer.g:173:48: '\\'' (~ ( ( '\\'' | '\\\\' ) ) | '\\\\' . )* '\\''
                    {
                    match('\''); 
                    // InternalOmlLexer.g:173:53: (~ ( ( '\\'' | '\\\\' ) ) | '\\\\' . )*
                    loop21:
                    do {
                        int alt21=3;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>='\u0000' && LA21_0<='&')||(LA21_0>='(' && LA21_0<='[')||(LA21_0>=']' && LA21_0<='\uFFFF')) ) {
                            alt21=1;
                        }
                        else if ( (LA21_0=='\\') ) {
                            alt21=2;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalOmlLexer.g:173:54: ~ ( ( '\\'' | '\\\\' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalOmlLexer.g:173:69: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;
                case 3 :
                    // InternalOmlLexer.g:173:83: '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\''
                    {
                    match("'''"); 

                    // InternalOmlLexer.g:173:92: ( options {greedy=false; } : . )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0=='\'') ) {
                            int LA22_1 = input.LA(2);

                            if ( (LA22_1=='\'') ) {
                                int LA22_3 = input.LA(3);

                                if ( (LA22_3=='\'') ) {
                                    alt22=2;
                                }
                                else if ( ((LA22_3>='\u0000' && LA22_3<='&')||(LA22_3>='(' && LA22_3<='\uFFFF')) ) {
                                    alt22=1;
                                }


                            }
                            else if ( ((LA22_1>='\u0000' && LA22_1<='&')||(LA22_1>='(' && LA22_1<='\uFFFF')) ) {
                                alt22=1;
                            }


                        }
                        else if ( ((LA22_0>='\u0000' && LA22_0<='&')||(LA22_0>='(' && LA22_0<='\uFFFF')) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalOmlLexer.g:173:120: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    match("'''"); 


                    }
                    break;
                case 4 :
                    // InternalOmlLexer.g:173:133: '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"'
                    {
                    match("\"\"\""); 

                    // InternalOmlLexer.g:173:139: ( options {greedy=false; } : . )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0=='\"') ) {
                            int LA23_1 = input.LA(2);

                            if ( (LA23_1=='\"') ) {
                                int LA23_3 = input.LA(3);

                                if ( (LA23_3=='\"') ) {
                                    alt23=2;
                                }
                                else if ( ((LA23_3>='\u0000' && LA23_3<='!')||(LA23_3>='#' && LA23_3<='\uFFFF')) ) {
                                    alt23=1;
                                }


                            }
                            else if ( ((LA23_1>='\u0000' && LA23_1<='!')||(LA23_1>='#' && LA23_1<='\uFFFF')) ) {
                                alt23=1;
                            }


                        }
                        else if ( ((LA23_0>='\u0000' && LA23_0<='!')||(LA23_0>='#' && LA23_0<='\uFFFF')) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalOmlLexer.g:173:167: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    match("\"\"\""); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_IRI"
    public final void mRULE_IRI() throws RecognitionException {
        try {
            int _type = RULE_IRI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:175:10: ( '<' (~ ( ( '>' | ' ' ) ) )* '>' )
            // InternalOmlLexer.g:175:12: '<' (~ ( ( '>' | ' ' ) ) )* '>'
            {
            match('<'); 
            // InternalOmlLexer.g:175:16: (~ ( ( '>' | ' ' ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='\u0000' && LA25_0<='\u001F')||(LA25_0>='!' && LA25_0<='=')||(LA25_0>='?' && LA25_0<='\uFFFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOmlLexer.g:175:16: ~ ( ( '>' | ' ' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IRI"

    // $ANTLR start "RULE_ABBREV_IRI"
    public final void mRULE_ABBREV_IRI() throws RecognitionException {
        try {
            int _type = RULE_ABBREV_IRI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:177:17: ( RULE_ID ':' RULE_ID )
            // InternalOmlLexer.g:177:19: RULE_ID ':' RULE_ID
            {
            mRULE_ID(); 
            match(':'); 
            mRULE_ID(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ABBREV_IRI"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:179:9: ( ( '^' )? ( RULE_ALPHA | RULE_DIGIT | '_' ) ( RULE_ALPHA | RULE_DIGIT | '_' | '-' | '.' )* )
            // InternalOmlLexer.g:179:11: ( '^' )? ( RULE_ALPHA | RULE_DIGIT | '_' ) ( RULE_ALPHA | RULE_DIGIT | '_' | '-' | '.' )*
            {
            // InternalOmlLexer.g:179:11: ( '^' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='^') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalOmlLexer.g:179:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalOmlLexer.g:179:44: ( RULE_ALPHA | RULE_DIGIT | '_' | '-' | '.' )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='-' && LA27_0<='.')||(LA27_0>='0' && LA27_0<='9')||(LA27_0>='A' && LA27_0<='Z')||LA27_0=='_'||(LA27_0>='a' && LA27_0<='z')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOmlLexer.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:181:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalOmlLexer.g:181:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalOmlLexer.g:181:24: ( options {greedy=false; } : . )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0=='*') ) {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1=='/') ) {
                        alt28=2;
                    }
                    else if ( ((LA28_1>='\u0000' && LA28_1<='.')||(LA28_1>='0' && LA28_1<='\uFFFF')) ) {
                        alt28=1;
                    }


                }
                else if ( ((LA28_0>='\u0000' && LA28_0<=')')||(LA28_0>='+' && LA28_0<='\uFFFF')) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOmlLexer.g:181:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:183:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalOmlLexer.g:183:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalOmlLexer.g:183:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='\u0000' && LA29_0<='\t')||(LA29_0>='\u000B' && LA29_0<='\f')||(LA29_0>='\u000E' && LA29_0<='\uFFFF')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOmlLexer.g:183:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // InternalOmlLexer.g:183:40: ( ( '\\r' )? '\\n' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0=='\n'||LA31_0=='\r') ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOmlLexer.g:183:41: ( '\\r' )? '\\n'
                    {
                    // InternalOmlLexer.g:183:41: ( '\\r' )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0=='\r') ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalOmlLexer.g:183:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOmlLexer.g:185:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalOmlLexer.g:185:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalOmlLexer.g:185:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>='\t' && LA32_0<='\n')||LA32_0=='\r'||LA32_0==' ') ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalOmlLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ALPHA"
    public final void mRULE_ALPHA() throws RecognitionException {
        try {
            // InternalOmlLexer.g:187:21: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // InternalOmlLexer.g:187:23: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ALPHA"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalOmlLexer.g:189:21: ( '0' .. '9' )
            // InternalOmlLexer.g:189:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    public void mTokens() throws RecognitionException {
        // InternalOmlLexer.g:1:8: ( DifferentFrom | MaxExclusive | MaxInclusive | MinExclusive | MinInclusive | Description | Irreflexive | Annotation | Asymmetric | Enumerated | Functional | Structured | Transitive | Vocabulary | MaxLength | MinLength | Reflexive | Restricts | Structure | Symmetric | Includes | Language | Property | Relation | Concept | Exactly | Extends | Forward | Inverse | Pattern | Aspect | Bundle | Domain | Entity | Length | SameAs | Scalar | Range | From | Rule | Some | Uses | With | All | Key | Max | Min | Ref | HyphenMinusGreaterThanSign | ColonGreaterThanSign | CircumflexAccentCircumflexAccent | As | Ci | Ri | To | NumberSign | DollarSign | LeftParenthesis | RightParenthesis | Comma | Solidus | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | CircumflexAccent | LeftCurlyBracket | RightCurlyBracket | RULE_BOOLEAN_STR | RULE_UNSIGNED_INTEGER_STR | RULE_INTEGER_STR | RULE_DECIMAL_STR | RULE_DOUBLE_STR | RULE_STRING | RULE_IRI | RULE_ABBREV_IRI | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS )
        int alt33=80;
        alt33 = dfa33.predict(input);
        switch (alt33) {
            case 1 :
                // InternalOmlLexer.g:1:10: DifferentFrom
                {
                mDifferentFrom(); 

                }
                break;
            case 2 :
                // InternalOmlLexer.g:1:24: MaxExclusive
                {
                mMaxExclusive(); 

                }
                break;
            case 3 :
                // InternalOmlLexer.g:1:37: MaxInclusive
                {
                mMaxInclusive(); 

                }
                break;
            case 4 :
                // InternalOmlLexer.g:1:50: MinExclusive
                {
                mMinExclusive(); 

                }
                break;
            case 5 :
                // InternalOmlLexer.g:1:63: MinInclusive
                {
                mMinInclusive(); 

                }
                break;
            case 6 :
                // InternalOmlLexer.g:1:76: Description
                {
                mDescription(); 

                }
                break;
            case 7 :
                // InternalOmlLexer.g:1:88: Irreflexive
                {
                mIrreflexive(); 

                }
                break;
            case 8 :
                // InternalOmlLexer.g:1:100: Annotation
                {
                mAnnotation(); 

                }
                break;
            case 9 :
                // InternalOmlLexer.g:1:111: Asymmetric
                {
                mAsymmetric(); 

                }
                break;
            case 10 :
                // InternalOmlLexer.g:1:122: Enumerated
                {
                mEnumerated(); 

                }
                break;
            case 11 :
                // InternalOmlLexer.g:1:133: Functional
                {
                mFunctional(); 

                }
                break;
            case 12 :
                // InternalOmlLexer.g:1:144: Structured
                {
                mStructured(); 

                }
                break;
            case 13 :
                // InternalOmlLexer.g:1:155: Transitive
                {
                mTransitive(); 

                }
                break;
            case 14 :
                // InternalOmlLexer.g:1:166: Vocabulary
                {
                mVocabulary(); 

                }
                break;
            case 15 :
                // InternalOmlLexer.g:1:177: MaxLength
                {
                mMaxLength(); 

                }
                break;
            case 16 :
                // InternalOmlLexer.g:1:187: MinLength
                {
                mMinLength(); 

                }
                break;
            case 17 :
                // InternalOmlLexer.g:1:197: Reflexive
                {
                mReflexive(); 

                }
                break;
            case 18 :
                // InternalOmlLexer.g:1:207: Restricts
                {
                mRestricts(); 

                }
                break;
            case 19 :
                // InternalOmlLexer.g:1:217: Structure
                {
                mStructure(); 

                }
                break;
            case 20 :
                // InternalOmlLexer.g:1:227: Symmetric
                {
                mSymmetric(); 

                }
                break;
            case 21 :
                // InternalOmlLexer.g:1:237: Includes
                {
                mIncludes(); 

                }
                break;
            case 22 :
                // InternalOmlLexer.g:1:246: Language
                {
                mLanguage(); 

                }
                break;
            case 23 :
                // InternalOmlLexer.g:1:255: Property
                {
                mProperty(); 

                }
                break;
            case 24 :
                // InternalOmlLexer.g:1:264: Relation
                {
                mRelation(); 

                }
                break;
            case 25 :
                // InternalOmlLexer.g:1:273: Concept
                {
                mConcept(); 

                }
                break;
            case 26 :
                // InternalOmlLexer.g:1:281: Exactly
                {
                mExactly(); 

                }
                break;
            case 27 :
                // InternalOmlLexer.g:1:289: Extends
                {
                mExtends(); 

                }
                break;
            case 28 :
                // InternalOmlLexer.g:1:297: Forward
                {
                mForward(); 

                }
                break;
            case 29 :
                // InternalOmlLexer.g:1:305: Inverse
                {
                mInverse(); 

                }
                break;
            case 30 :
                // InternalOmlLexer.g:1:313: Pattern
                {
                mPattern(); 

                }
                break;
            case 31 :
                // InternalOmlLexer.g:1:321: Aspect
                {
                mAspect(); 

                }
                break;
            case 32 :
                // InternalOmlLexer.g:1:328: Bundle
                {
                mBundle(); 

                }
                break;
            case 33 :
                // InternalOmlLexer.g:1:335: Domain
                {
                mDomain(); 

                }
                break;
            case 34 :
                // InternalOmlLexer.g:1:342: Entity
                {
                mEntity(); 

                }
                break;
            case 35 :
                // InternalOmlLexer.g:1:349: Length
                {
                mLength(); 

                }
                break;
            case 36 :
                // InternalOmlLexer.g:1:356: SameAs
                {
                mSameAs(); 

                }
                break;
            case 37 :
                // InternalOmlLexer.g:1:363: Scalar
                {
                mScalar(); 

                }
                break;
            case 38 :
                // InternalOmlLexer.g:1:370: Range
                {
                mRange(); 

                }
                break;
            case 39 :
                // InternalOmlLexer.g:1:376: From
                {
                mFrom(); 

                }
                break;
            case 40 :
                // InternalOmlLexer.g:1:381: Rule
                {
                mRule(); 

                }
                break;
            case 41 :
                // InternalOmlLexer.g:1:386: Some
                {
                mSome(); 

                }
                break;
            case 42 :
                // InternalOmlLexer.g:1:391: Uses
                {
                mUses(); 

                }
                break;
            case 43 :
                // InternalOmlLexer.g:1:396: With
                {
                mWith(); 

                }
                break;
            case 44 :
                // InternalOmlLexer.g:1:401: All
                {
                mAll(); 

                }
                break;
            case 45 :
                // InternalOmlLexer.g:1:405: Key
                {
                mKey(); 

                }
                break;
            case 46 :
                // InternalOmlLexer.g:1:409: Max
                {
                mMax(); 

                }
                break;
            case 47 :
                // InternalOmlLexer.g:1:413: Min
                {
                mMin(); 

                }
                break;
            case 48 :
                // InternalOmlLexer.g:1:417: Ref
                {
                mRef(); 

                }
                break;
            case 49 :
                // InternalOmlLexer.g:1:421: HyphenMinusGreaterThanSign
                {
                mHyphenMinusGreaterThanSign(); 

                }
                break;
            case 50 :
                // InternalOmlLexer.g:1:448: ColonGreaterThanSign
                {
                mColonGreaterThanSign(); 

                }
                break;
            case 51 :
                // InternalOmlLexer.g:1:469: CircumflexAccentCircumflexAccent
                {
                mCircumflexAccentCircumflexAccent(); 

                }
                break;
            case 52 :
                // InternalOmlLexer.g:1:502: As
                {
                mAs(); 

                }
                break;
            case 53 :
                // InternalOmlLexer.g:1:505: Ci
                {
                mCi(); 

                }
                break;
            case 54 :
                // InternalOmlLexer.g:1:508: Ri
                {
                mRi(); 

                }
                break;
            case 55 :
                // InternalOmlLexer.g:1:511: To
                {
                mTo(); 

                }
                break;
            case 56 :
                // InternalOmlLexer.g:1:514: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 57 :
                // InternalOmlLexer.g:1:525: DollarSign
                {
                mDollarSign(); 

                }
                break;
            case 58 :
                // InternalOmlLexer.g:1:536: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 59 :
                // InternalOmlLexer.g:1:552: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 60 :
                // InternalOmlLexer.g:1:569: Comma
                {
                mComma(); 

                }
                break;
            case 61 :
                // InternalOmlLexer.g:1:575: Solidus
                {
                mSolidus(); 

                }
                break;
            case 62 :
                // InternalOmlLexer.g:1:583: Colon
                {
                mColon(); 

                }
                break;
            case 63 :
                // InternalOmlLexer.g:1:589: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 64 :
                // InternalOmlLexer.g:1:602: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 65 :
                // InternalOmlLexer.g:1:620: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 66 :
                // InternalOmlLexer.g:1:639: CircumflexAccent
                {
                mCircumflexAccent(); 

                }
                break;
            case 67 :
                // InternalOmlLexer.g:1:656: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 68 :
                // InternalOmlLexer.g:1:673: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 69 :
                // InternalOmlLexer.g:1:691: RULE_BOOLEAN_STR
                {
                mRULE_BOOLEAN_STR(); 

                }
                break;
            case 70 :
                // InternalOmlLexer.g:1:708: RULE_UNSIGNED_INTEGER_STR
                {
                mRULE_UNSIGNED_INTEGER_STR(); 

                }
                break;
            case 71 :
                // InternalOmlLexer.g:1:734: RULE_INTEGER_STR
                {
                mRULE_INTEGER_STR(); 

                }
                break;
            case 72 :
                // InternalOmlLexer.g:1:751: RULE_DECIMAL_STR
                {
                mRULE_DECIMAL_STR(); 

                }
                break;
            case 73 :
                // InternalOmlLexer.g:1:768: RULE_DOUBLE_STR
                {
                mRULE_DOUBLE_STR(); 

                }
                break;
            case 74 :
                // InternalOmlLexer.g:1:784: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 75 :
                // InternalOmlLexer.g:1:796: RULE_IRI
                {
                mRULE_IRI(); 

                }
                break;
            case 76 :
                // InternalOmlLexer.g:1:805: RULE_ABBREV_IRI
                {
                mRULE_ABBREV_IRI(); 

                }
                break;
            case 77 :
                // InternalOmlLexer.g:1:821: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 78 :
                // InternalOmlLexer.g:1:829: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 79 :
                // InternalOmlLexer.g:1:845: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 80 :
                // InternalOmlLexer.g:1:861: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA33_eotS =
        "\1\uffff\21\53\1\uffff\1\123\1\125\5\uffff\1\130\5\uffff\1\132\4\uffff\1\53\1\uffff\4\53\2\uffff\5\53\1\151\15\53\1\172\4\53\1\u0081\5\53\1\u0087\4\53\1\uffff\1\u008c\7\uffff\1\u008f\1\uffff\1\132\1\53\1\u008f\3\53\1\u0099\1\u009d\6\53\1\uffff\1\u00a4\17\53\1\uffff\1\53\1\u00b6\4\53\1\uffff\5\53\1\uffff\3\53\1\u00c3\1\uffff\1\u008f\2\uffff\1\u008f\1\53\1\u008e\6\53\1\uffff\3\53\1\uffff\6\53\1\uffff\6\53\1\u00da\5\53\1\u00e0\1\53\1\u00e2\2\53\1\uffff\3\53\1\u00e8\6\53\1\u00ef\1\u00f0\1\uffff\1\u008f\25\53\1\uffff\1\u00e2\4\53\1\uffff\1\53\1\uffff\4\53\1\u010f\1\uffff\6\53\2\uffff\2\53\1\u0118\13\53\1\u0124\1\53\1\u0126\6\53\1\u012d\1\u012e\5\53\1\uffff\1\53\1\u0135\3\53\1\u0139\2\53\1\uffff\10\53\1\u0144\2\53\1\uffff\1\53\1\uffff\1\u0148\1\u0149\1\53\1\u014b\2\53\2\uffff\6\53\1\uffff\1\53\1\u0155\1\u0156\1\uffff\11\53\1\u0160\1\uffff\3\53\2\uffff\1\53\1\uffff\6\53\1\u016b\1\u016c\1\u016d\2\uffff\4\53\1\u0172\2\53\1\u0175\1\53\1\uffff\4\53\1\u017c\1\u017d\2\53\1\u0180\1\u0181\3\uffff\4\53\1\uffff\2\53\1\uffff\1\53\1\u0189\1\u018a\1\u018b\1\u018c\1\u018d\2\uffff\1\u018e\1\u018f\2\uffff\1\53\1\u0191\4\53\1\u0196\7\uffff\1\53\1\uffff\1\u0198\1\u0199\1\u019a\1\u019b\1\uffff\1\u019c\5\uffff";
    static final String DFA33_eofS =
        "\u019d\uffff";
    static final String DFA33_minS =
        "\1\11\21\55\1\56\1\76\1\60\5\uffff\1\52\5\uffff\1\55\1\56\1\60\2\uffff\1\55\1\uffff\4\55\2\uffff\43\55\1\uffff\1\56\7\uffff\1\55\1\uffff\1\55\1\53\1\60\13\55\1\uffff\20\55\1\uffff\6\55\1\uffff\5\55\1\uffff\4\55\1\uffff\1\60\2\uffff\11\55\1\uffff\3\55\1\uffff\6\55\1\uffff\21\55\1\uffff\14\55\1\uffff\1\60\25\55\1\uffff\5\55\1\uffff\1\55\1\uffff\5\55\1\uffff\6\55\2\uffff\36\55\1\uffff\10\55\1\uffff\13\55\1\uffff\1\55\1\uffff\6\55\2\uffff\6\55\1\uffff\3\55\1\uffff\12\55\1\uffff\3\55\2\uffff\1\55\1\uffff\11\55\2\uffff\11\55\1\uffff\12\55\3\uffff\4\55\1\uffff\2\55\1\uffff\6\55\2\uffff\2\55\2\uffff\7\55\7\uffff\1\55\1\uffff\4\55\1\uffff\1\55\5\uffff";
    static final String DFA33_maxS =
        "\1\175\21\172\2\76\1\172\5\uffff\1\57\5\uffff\1\172\2\71\2\uffff\1\172\1\uffff\4\172\2\uffff\43\172\1\uffff\1\145\7\uffff\1\172\1\uffff\2\172\1\145\13\172\1\uffff\20\172\1\uffff\6\172\1\uffff\5\172\1\uffff\4\172\1\uffff\1\145\2\uffff\11\172\1\uffff\3\172\1\uffff\6\172\1\uffff\21\172\1\uffff\14\172\1\uffff\1\145\25\172\1\uffff\5\172\1\uffff\1\172\1\uffff\5\172\1\uffff\6\172\2\uffff\36\172\1\uffff\10\172\1\uffff\13\172\1\uffff\1\172\1\uffff\6\172\2\uffff\6\172\1\uffff\3\172\1\uffff\12\172\1\uffff\3\172\2\uffff\1\172\1\uffff\11\172\2\uffff\11\172\1\uffff\12\172\3\uffff\4\172\1\uffff\2\172\1\uffff\6\172\2\uffff\2\172\2\uffff\7\172\7\uffff\1\172\1\uffff\4\172\1\uffff\1\172\5\uffff";
    static final String DFA33_acceptS =
        "\25\uffff\1\70\1\71\1\72\1\73\1\74\1\uffff\1\77\1\100\1\101\1\103\1\104\3\uffff\1\112\1\113\1\uffff\1\120\4\uffff\1\115\1\114\43\uffff\1\61\1\uffff\1\62\1\76\1\63\1\102\1\116\1\117\1\75\1\uffff\1\106\16\uffff\1\64\20\uffff\1\67\6\uffff\1\66\5\uffff\1\65\4\uffff\1\107\1\uffff\1\111\1\110\11\uffff\1\56\3\uffff\1\57\6\uffff\1\54\21\uffff\1\60\14\uffff\1\55\26\uffff\1\47\5\uffff\1\51\1\uffff\1\105\5\uffff\1\50\6\uffff\1\52\1\53\36\uffff\1\46\10\uffff\1\41\13\uffff\1\37\1\uffff\1\42\6\uffff\1\44\1\45\6\uffff\1\43\3\uffff\1\40\12\uffff\1\35\3\uffff\1\32\1\33\1\uffff\1\34\11\uffff\1\36\1\31\11\uffff\1\25\12\uffff\1\30\1\26\1\27\4\uffff\1\17\2\uffff\1\20\6\uffff\1\23\1\24\2\uffff\1\21\1\22\7\uffff\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\uffff\1\6\4\uffff\1\7\1\uffff\1\2\1\3\1\4\1\5\1\1";
    static final String DFA33_specialS =
        "\u019d\uffff}>";
    static final String[] DFA33_transitionS = {
            "\2\46\2\uffff\1\46\22\uffff\1\46\1\uffff\1\43\1\25\1\26\2\uffff\1\43\1\27\1\30\1\uffff\1\41\1\31\1\22\1\42\1\32\12\40\1\23\1\uffff\1\44\3\uffff\1\33\32\45\1\34\1\uffff\1\35\1\24\1\45\1\uffff\1\4\1\16\1\15\1\1\1\5\1\6\2\45\1\3\1\45\1\21\1\13\1\2\2\45\1\14\1\45\1\12\1\7\1\10\1\17\1\11\1\20\3\45\1\36\1\uffff\1\37",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\50\3\52\1\47\5\52\1\51\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\55\7\52\1\56\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\60\3\52\1\57\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\63\1\52\1\61\4\52\1\62\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\64\11\52\1\65\2\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\71\15\52\1\67\2\52\1\70\2\52\1\66\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\74\1\52\1\75\13\52\1\76\4\52\1\72\4\52\1\73\1\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\100\2\52\1\77\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\101\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\103\3\52\1\102\3\52\1\105\13\52\1\104\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\106\3\52\1\107\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\111\20\52\1\110\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\113\5\52\1\112\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\114\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\115\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\116\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\117\25\52",
            "\1\42\1\uffff\12\121\4\uffff\1\120",
            "\1\122",
            "\12\45\7\uffff\32\45\3\uffff\1\124\1\45\1\uffff\32\45",
            "",
            "",
            "",
            "",
            "",
            "\1\126\4\uffff\1\127",
            "",
            "",
            "",
            "",
            "",
            "\1\52\1\131\1\uffff\12\133\1\54\6\uffff\4\52\1\134\25\52\4\uffff\1\52\1\uffff\4\52\1\134\25\52",
            "\1\42\1\uffff\12\121",
            "\12\135",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\5\52\1\136\24\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\137\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\140\15\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\27\52\1\141\2\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\142\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\143\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\144\22\52\1\145\4\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\146\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\17\52\1\150\10\52\1\147\1\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\152\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\154\1\153\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\155\22\52\1\156\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\157\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\160\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\161\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\162\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\163\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\164\15\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\165\15\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\166\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\167\15\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\170\23\52\1\171\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\173\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\5\52\1\174\5\52\1\176\6\52\1\175\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\177\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u0080\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u0082\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u0083\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\u0084\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0085\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u0086\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u0088\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0089\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u008a\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\30\52\1\u008b\1\52",
            "",
            "\1\u008d\1\uffff\12\121\13\uffff\1\u008e\37\uffff\1\u008e",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\52\1\uffff\12\u0090\1\54\6\uffff\4\52\1\134\25\52\4\uffff\1\52\1\uffff\4\52\1\134\25\52",
            "",
            "\1\52\1\131\1\uffff\12\133\1\54\6\uffff\4\52\1\134\25\52\4\uffff\1\52\1\uffff\4\52\1\134\25\52",
            "\1\u008e\1\uffff\1\u0091\1\52\1\uffff\12\u0092\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\135\13\uffff\1\u008e\37\uffff\1\u008e",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\5\52\1\u0093\24\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u0094\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u0095\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\4\52\1\u0096\3\52\1\u0097\2\52\1\u0098\16\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\4\52\1\u009a\3\52\1\u009b\2\52\1\u009c\16\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u009e\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u009f\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00a0\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\u00a1\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\u00a2\15\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00a3\25\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\u00a5\15\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u00a6\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u00a7\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00a8\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u00a9\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\26\52\1\u00aa\3\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\u00ab\15\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u00ac\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\u00ad\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\u00ae\15\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00af\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u00b0\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00b1\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u00b2\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00b3\25\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u00b4\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u00b5\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u00b7\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u00b8\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\6\52\1\u00b9\23\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00ba\25\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\6\52\1\u00bb\23\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\6\52\1\u00bc\23\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\17\52\1\u00bd\12\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u00be\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u00bf\27\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\3\52\1\u00c0\26\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u00c1\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\7\52\1\u00c2\22\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\u00c4\13\uffff\1\u008e\37\uffff\1\u008e",
            "",
            "",
            "\2\52\1\uffff\12\u0090\1\54\6\uffff\4\52\1\134\25\52\4\uffff\1\52\1\uffff\4\52\1\134\25\52",
            "\2\52\1\uffff\12\u0092\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\u0092\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00c5\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u00c6\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u00c7\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\27\52\1\u00c8\2\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u00c9\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00ca\25\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\27\52\1\u00cb\2\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u00cc\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00cd\25\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\5\52\1\u00ce\24\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\u00cf\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u00d0\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u00d1\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\u00d2\15\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u00d3\27\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00d4\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u00d5\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u00d6\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u00d7\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u00d8\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u00d9\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00db\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u00dc\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00dd\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\1\u00de\31\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u00df\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u00e1\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\52\1\u00e3\30\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00e4\25\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u00e5\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u00e6\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00e7\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\u00e9\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u00ea\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00eb\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00ec\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00ed\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u00ee\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\u00c4\13\uffff\1\u008e\37\uffff\1\u008e",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u00f1\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u00f2\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u00f3\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u00f4\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u00f5\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u00f6\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u00f7\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u00f8\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u00f9\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u00fa\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\3\52\1\u00fb\26\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u00fc\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u00fd\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u00fe\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u00ff\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u0100\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\30\52\1\u0101\1\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u0102\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\3\52\1\u0103\26\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u0104\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u0105\10\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0106\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0107\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u0108\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u0109\10\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u010a\21\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\u010b\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\27\52\1\u010c\2\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u010d\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u010e\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u0110\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\7\52\1\u0111\22\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u0112\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u0113\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\17\52\1\u0114\12\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0115\25\52",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0116\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\17\52\1\u0117\12\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u0119\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u011a\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\6\52\1\u011b\23\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u011c\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u011d\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\6\52\1\u011e\23\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u011f\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0120\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0121\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0122\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0123\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u0125\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\30\52\1\u0127\1\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u0128\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\u0129\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\3\52\1\u012a\26\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\u012b\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u012c\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u012f\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u0130\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u0131\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u0132\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\u0133\13\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\6\52\1\u0134\23\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0136\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u0137\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0138\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u013a\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u013b\6\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\u013c\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\u013d\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u013e\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\u013f\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\24\52\1\u0140\5\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0141\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\27\52\1\u0142\2\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u0143\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u0145\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u0146\10\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0147\6\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u014a\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u014c\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u014d\21\52",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u014e\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u014f\31\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\25\52\1\u0150\4\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0151\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u0152\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0153\25\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\30\52\1\u0154\1\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\23\52\1\u0157\6\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u0158\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u0159\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u015a\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\7\52\1\u015b\22\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u015c\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u015d\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\7\52\1\u015e\22\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u015f\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\u0161\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u0162\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0163\25\52",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\1\u0164\31\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0165\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u0166\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\25\52\1\u0167\4\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u0168\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0169\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\22\52\1\u016a\7\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\5\52\1\u016e\24\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\u016f\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u0170\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u0171\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u0173\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\10\52\1\u0174\21\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\25\52\1\u0176\4\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u0177\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\2\52\1\u0178\27\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\3\52\1\u0179\26\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\13\52\1\u017a\16\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\3\52\1\u017b\26\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u017e\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\30\52\1\u017f\1\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\21\52\1\u0182\10\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\15\52\1\u0183\14\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\25\52\1\u0184\4\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\25\52\1\u0185\4\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\25\52\1\u0186\4\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\25\52\1\u0187\4\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0188\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\16\52\1\u0190\13\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0192\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0193\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0194\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\4\52\1\u0195\25\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\u0197\15\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\2\52\1\uffff\12\52\1\54\6\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( DifferentFrom | MaxExclusive | MaxInclusive | MinExclusive | MinInclusive | Description | Irreflexive | Annotation | Asymmetric | Enumerated | Functional | Structured | Transitive | Vocabulary | MaxLength | MinLength | Reflexive | Restricts | Structure | Symmetric | Includes | Language | Property | Relation | Concept | Exactly | Extends | Forward | Inverse | Pattern | Aspect | Bundle | Domain | Entity | Length | SameAs | Scalar | Range | From | Rule | Some | Uses | With | All | Key | Max | Min | Ref | HyphenMinusGreaterThanSign | ColonGreaterThanSign | CircumflexAccentCircumflexAccent | As | Ci | Ri | To | NumberSign | DollarSign | LeftParenthesis | RightParenthesis | Comma | Solidus | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | CircumflexAccent | LeftCurlyBracket | RightCurlyBracket | RULE_BOOLEAN_STR | RULE_UNSIGNED_INTEGER_STR | RULE_INTEGER_STR | RULE_DECIMAL_STR | RULE_DOUBLE_STR | RULE_STRING | RULE_IRI | RULE_ABBREV_IRI | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS );";
        }
    }
 

}