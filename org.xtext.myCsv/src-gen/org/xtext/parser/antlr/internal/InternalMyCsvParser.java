package org.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.services.MyCsvGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyCsvParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "','", "')'", "'['", "';'", "']'", "'Load'", "'sep'", "'='", "'no'", "'header'", "'Store'", "'ExportJson'", "'Projection'", "'Select'", "'Delete'", "'line'", "'field'", "'Insert'", "':'", "'Modify'", "'with'", "'cell'", "'Print'", "'table'", "'expr'", "'Rename'", "':='", "'or'", "'and'", "'not'", "'-'", "'NbField'", "'.'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'Count'", "'Sum'", "'Product'", "'Mean'", "'+'", "'*'", "'/'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMyCsvParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyCsvParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyCsvParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyCsv.g"; }



     	private MyCsvGrammarAccess grammarAccess;

        public InternalMyCsvParser(TokenStream input, MyCsvGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Program";
       	}

       	@Override
       	protected MyCsvGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgram"
    // InternalMyCsv.g:65:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalMyCsv.g:65:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalMyCsv.g:66:2: iv_ruleProgram= ruleProgram EOF
            {
             newCompositeNode(grammarAccess.getProgramRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalMyCsv.g:72:1: ruleProgram returns [EObject current=null] : ( (lv_stmts_0_0= ruleStatement ) )+ ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_stmts_0_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:78:2: ( ( (lv_stmts_0_0= ruleStatement ) )+ )
            // InternalMyCsv.g:79:2: ( (lv_stmts_0_0= ruleStatement ) )+
            {
            // InternalMyCsv.g:79:2: ( (lv_stmts_0_0= ruleStatement ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17||(LA1_0>=22 && LA1_0<=26)||LA1_0==29||LA1_0==31||LA1_0==34||LA1_0==37) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyCsv.g:80:3: (lv_stmts_0_0= ruleStatement )
            	    {
            	    // InternalMyCsv.g:80:3: (lv_stmts_0_0= ruleStatement )
            	    // InternalMyCsv.g:81:4: lv_stmts_0_0= ruleStatement
            	    {

            	    				newCompositeNode(grammarAccess.getProgramAccess().getStmtsStatementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_stmts_0_0=ruleStatement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getProgramRule());
            	    				}
            	    				add(
            	    					current,
            	    					"stmts",
            	    					lv_stmts_0_0,
            	    					"org.xtext.MyCsv.Statement");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleLineIndex"
    // InternalMyCsv.g:101:1: entryRuleLineIndex returns [EObject current=null] : iv_ruleLineIndex= ruleLineIndex EOF ;
    public final EObject entryRuleLineIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLineIndex = null;


        try {
            // InternalMyCsv.g:101:50: (iv_ruleLineIndex= ruleLineIndex EOF )
            // InternalMyCsv.g:102:2: iv_ruleLineIndex= ruleLineIndex EOF
            {
             newCompositeNode(grammarAccess.getLineIndexRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLineIndex=ruleLineIndex();

            state._fsp--;

             current =iv_ruleLineIndex; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLineIndex"


    // $ANTLR start "ruleLineIndex"
    // InternalMyCsv.g:108:1: ruleLineIndex returns [EObject current=null] : (this_LineIndexCond_0= ruleLineIndexCond | this_LineIndexNum_1= ruleLineIndexNum ) ;
    public final EObject ruleLineIndex() throws RecognitionException {
        EObject current = null;

        EObject this_LineIndexCond_0 = null;

        EObject this_LineIndexNum_1 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:114:2: ( (this_LineIndexCond_0= ruleLineIndexCond | this_LineIndexNum_1= ruleLineIndexNum ) )
            // InternalMyCsv.g:115:2: (this_LineIndexCond_0= ruleLineIndexCond | this_LineIndexNum_1= ruleLineIndexNum )
            {
            // InternalMyCsv.g:115:2: (this_LineIndexCond_0= ruleLineIndexCond | this_LineIndexNum_1= ruleLineIndexNum )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||LA2_0==11||LA2_0==41) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_INT) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyCsv.g:116:3: this_LineIndexCond_0= ruleLineIndexCond
                    {

                    			newCompositeNode(grammarAccess.getLineIndexAccess().getLineIndexCondParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LineIndexCond_0=ruleLineIndexCond();

                    state._fsp--;


                    			current = this_LineIndexCond_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:125:3: this_LineIndexNum_1= ruleLineIndexNum
                    {

                    			newCompositeNode(grammarAccess.getLineIndexAccess().getLineIndexNumParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LineIndexNum_1=ruleLineIndexNum();

                    state._fsp--;


                    			current = this_LineIndexNum_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineIndex"


    // $ANTLR start "entryRuleLineIndexCond"
    // InternalMyCsv.g:137:1: entryRuleLineIndexCond returns [EObject current=null] : iv_ruleLineIndexCond= ruleLineIndexCond EOF ;
    public final EObject entryRuleLineIndexCond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLineIndexCond = null;


        try {
            // InternalMyCsv.g:137:54: (iv_ruleLineIndexCond= ruleLineIndexCond EOF )
            // InternalMyCsv.g:138:2: iv_ruleLineIndexCond= ruleLineIndexCond EOF
            {
             newCompositeNode(grammarAccess.getLineIndexCondRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLineIndexCond=ruleLineIndexCond();

            state._fsp--;

             current =iv_ruleLineIndexCond; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLineIndexCond"


    // $ANTLR start "ruleLineIndexCond"
    // InternalMyCsv.g:144:1: ruleLineIndexCond returns [EObject current=null] : ( (lv_cond_0_0= ruleExpressionLog ) ) ;
    public final EObject ruleLineIndexCond() throws RecognitionException {
        EObject current = null;

        EObject lv_cond_0_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:150:2: ( ( (lv_cond_0_0= ruleExpressionLog ) ) )
            // InternalMyCsv.g:151:2: ( (lv_cond_0_0= ruleExpressionLog ) )
            {
            // InternalMyCsv.g:151:2: ( (lv_cond_0_0= ruleExpressionLog ) )
            // InternalMyCsv.g:152:3: (lv_cond_0_0= ruleExpressionLog )
            {
            // InternalMyCsv.g:152:3: (lv_cond_0_0= ruleExpressionLog )
            // InternalMyCsv.g:153:4: lv_cond_0_0= ruleExpressionLog
            {

            				newCompositeNode(grammarAccess.getLineIndexCondAccess().getCondExpressionLogParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_cond_0_0=ruleExpressionLog();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getLineIndexCondRule());
            				}
            				set(
            					current,
            					"cond",
            					lv_cond_0_0,
            					"org.xtext.MyCsv.ExpressionLog");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineIndexCond"


    // $ANTLR start "entryRuleLineIndexNum"
    // InternalMyCsv.g:173:1: entryRuleLineIndexNum returns [EObject current=null] : iv_ruleLineIndexNum= ruleLineIndexNum EOF ;
    public final EObject entryRuleLineIndexNum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLineIndexNum = null;


        try {
            // InternalMyCsv.g:173:53: (iv_ruleLineIndexNum= ruleLineIndexNum EOF )
            // InternalMyCsv.g:174:2: iv_ruleLineIndexNum= ruleLineIndexNum EOF
            {
             newCompositeNode(grammarAccess.getLineIndexNumRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLineIndexNum=ruleLineIndexNum();

            state._fsp--;

             current =iv_ruleLineIndexNum; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLineIndexNum"


    // $ANTLR start "ruleLineIndexNum"
    // InternalMyCsv.g:180:1: ruleLineIndexNum returns [EObject current=null] : ( (lv_lines_0_0= RULE_INT ) )+ ;
    public final EObject ruleLineIndexNum() throws RecognitionException {
        EObject current = null;

        Token lv_lines_0_0=null;


        	enterRule();

        try {
            // InternalMyCsv.g:186:2: ( ( (lv_lines_0_0= RULE_INT ) )+ )
            // InternalMyCsv.g:187:2: ( (lv_lines_0_0= RULE_INT ) )+
            {
            // InternalMyCsv.g:187:2: ( (lv_lines_0_0= RULE_INT ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_INT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMyCsv.g:188:3: (lv_lines_0_0= RULE_INT )
            	    {
            	    // InternalMyCsv.g:188:3: (lv_lines_0_0= RULE_INT )
            	    // InternalMyCsv.g:189:4: lv_lines_0_0= RULE_INT
            	    {
            	    lv_lines_0_0=(Token)match(input,RULE_INT,FOLLOW_4); 

            	    				newLeafNode(lv_lines_0_0, grammarAccess.getLineIndexNumAccess().getLinesINTTerminalRuleCall_0());
            	    			

            	    				if (current==null) {
            	    					current = createModelElement(grammarAccess.getLineIndexNumRule());
            	    				}
            	    				addWithLastConsumed(
            	    					current,
            	    					"lines",
            	    					lv_lines_0_0,
            	    					"org.eclipse.xtext.common.Terminals.INT");
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineIndexNum"


    // $ANTLR start "entryRuleFieldIndex"
    // InternalMyCsv.g:208:1: entryRuleFieldIndex returns [EObject current=null] : iv_ruleFieldIndex= ruleFieldIndex EOF ;
    public final EObject entryRuleFieldIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldIndex = null;


        try {
            // InternalMyCsv.g:208:51: (iv_ruleFieldIndex= ruleFieldIndex EOF )
            // InternalMyCsv.g:209:2: iv_ruleFieldIndex= ruleFieldIndex EOF
            {
             newCompositeNode(grammarAccess.getFieldIndexRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldIndex=ruleFieldIndex();

            state._fsp--;

             current =iv_ruleFieldIndex; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldIndex"


    // $ANTLR start "ruleFieldIndex"
    // InternalMyCsv.g:215:1: ruleFieldIndex returns [EObject current=null] : (this_FieldIndexName_0= ruleFieldIndexName | this_FieldIndexNum_1= ruleFieldIndexNum ) ;
    public final EObject ruleFieldIndex() throws RecognitionException {
        EObject current = null;

        EObject this_FieldIndexName_0 = null;

        EObject this_FieldIndexNum_1 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:221:2: ( (this_FieldIndexName_0= ruleFieldIndexName | this_FieldIndexNum_1= ruleFieldIndexNum ) )
            // InternalMyCsv.g:222:2: (this_FieldIndexName_0= ruleFieldIndexName | this_FieldIndexNum_1= ruleFieldIndexNum )
            {
            // InternalMyCsv.g:222:2: (this_FieldIndexName_0= ruleFieldIndexName | this_FieldIndexNum_1= ruleFieldIndexNum )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMyCsv.g:223:3: this_FieldIndexName_0= ruleFieldIndexName
                    {

                    			newCompositeNode(grammarAccess.getFieldIndexAccess().getFieldIndexNameParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FieldIndexName_0=ruleFieldIndexName();

                    state._fsp--;


                    			current = this_FieldIndexName_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:232:3: this_FieldIndexNum_1= ruleFieldIndexNum
                    {

                    			newCompositeNode(grammarAccess.getFieldIndexAccess().getFieldIndexNumParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FieldIndexNum_1=ruleFieldIndexNum();

                    state._fsp--;


                    			current = this_FieldIndexNum_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldIndex"


    // $ANTLR start "entryRuleFieldIndexName"
    // InternalMyCsv.g:244:1: entryRuleFieldIndexName returns [EObject current=null] : iv_ruleFieldIndexName= ruleFieldIndexName EOF ;
    public final EObject entryRuleFieldIndexName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldIndexName = null;


        try {
            // InternalMyCsv.g:244:55: (iv_ruleFieldIndexName= ruleFieldIndexName EOF )
            // InternalMyCsv.g:245:2: iv_ruleFieldIndexName= ruleFieldIndexName EOF
            {
             newCompositeNode(grammarAccess.getFieldIndexNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldIndexName=ruleFieldIndexName();

            state._fsp--;

             current =iv_ruleFieldIndexName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldIndexName"


    // $ANTLR start "ruleFieldIndexName"
    // InternalMyCsv.g:251:1: ruleFieldIndexName returns [EObject current=null] : ( (lv_fields_0_0= ruleField ) )+ ;
    public final EObject ruleFieldIndexName() throws RecognitionException {
        EObject current = null;

        EObject lv_fields_0_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:257:2: ( ( (lv_fields_0_0= ruleField ) )+ )
            // InternalMyCsv.g:258:2: ( (lv_fields_0_0= ruleField ) )+
            {
            // InternalMyCsv.g:258:2: ( (lv_fields_0_0= ruleField ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMyCsv.g:259:3: (lv_fields_0_0= ruleField )
            	    {
            	    // InternalMyCsv.g:259:3: (lv_fields_0_0= ruleField )
            	    // InternalMyCsv.g:260:4: lv_fields_0_0= ruleField
            	    {

            	    				newCompositeNode(grammarAccess.getFieldIndexNameAccess().getFieldsFieldParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_5);
            	    lv_fields_0_0=ruleField();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getFieldIndexNameRule());
            	    				}
            	    				add(
            	    					current,
            	    					"fields",
            	    					lv_fields_0_0,
            	    					"org.xtext.MyCsv.Field");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldIndexName"


    // $ANTLR start "entryRuleFieldIndexNum"
    // InternalMyCsv.g:280:1: entryRuleFieldIndexNum returns [EObject current=null] : iv_ruleFieldIndexNum= ruleFieldIndexNum EOF ;
    public final EObject entryRuleFieldIndexNum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldIndexNum = null;


        try {
            // InternalMyCsv.g:280:54: (iv_ruleFieldIndexNum= ruleFieldIndexNum EOF )
            // InternalMyCsv.g:281:2: iv_ruleFieldIndexNum= ruleFieldIndexNum EOF
            {
             newCompositeNode(grammarAccess.getFieldIndexNumRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldIndexNum=ruleFieldIndexNum();

            state._fsp--;

             current =iv_ruleFieldIndexNum; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldIndexNum"


    // $ANTLR start "ruleFieldIndexNum"
    // InternalMyCsv.g:287:1: ruleFieldIndexNum returns [EObject current=null] : ( (lv_columns_0_0= RULE_INT ) )+ ;
    public final EObject ruleFieldIndexNum() throws RecognitionException {
        EObject current = null;

        Token lv_columns_0_0=null;


        	enterRule();

        try {
            // InternalMyCsv.g:293:2: ( ( (lv_columns_0_0= RULE_INT ) )+ )
            // InternalMyCsv.g:294:2: ( (lv_columns_0_0= RULE_INT ) )+
            {
            // InternalMyCsv.g:294:2: ( (lv_columns_0_0= RULE_INT ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_INT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMyCsv.g:295:3: (lv_columns_0_0= RULE_INT )
            	    {
            	    // InternalMyCsv.g:295:3: (lv_columns_0_0= RULE_INT )
            	    // InternalMyCsv.g:296:4: lv_columns_0_0= RULE_INT
            	    {
            	    lv_columns_0_0=(Token)match(input,RULE_INT,FOLLOW_4); 

            	    				newLeafNode(lv_columns_0_0, grammarAccess.getFieldIndexNumAccess().getColumnsINTTerminalRuleCall_0());
            	    			

            	    				if (current==null) {
            	    					current = createModelElement(grammarAccess.getFieldIndexNumRule());
            	    				}
            	    				addWithLastConsumed(
            	    					current,
            	    					"columns",
            	    					lv_columns_0_0,
            	    					"org.eclipse.xtext.common.Terminals.INT");
            	    			

            	    }


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


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldIndexNum"


    // $ANTLR start "entryRuleCellIndex"
    // InternalMyCsv.g:315:1: entryRuleCellIndex returns [EObject current=null] : iv_ruleCellIndex= ruleCellIndex EOF ;
    public final EObject entryRuleCellIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCellIndex = null;


        try {
            // InternalMyCsv.g:315:50: (iv_ruleCellIndex= ruleCellIndex EOF )
            // InternalMyCsv.g:316:2: iv_ruleCellIndex= ruleCellIndex EOF
            {
             newCompositeNode(grammarAccess.getCellIndexRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCellIndex=ruleCellIndex();

            state._fsp--;

             current =iv_ruleCellIndex; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCellIndex"


    // $ANTLR start "ruleCellIndex"
    // InternalMyCsv.g:322:1: ruleCellIndex returns [EObject current=null] : (otherlv_0= '(' ( (lv_line_1_0= RULE_INT ) ) otherlv_2= ',' ( ( (lv_colnum_3_0= RULE_INT ) ) | ( (lv_colname_4_0= ruleField ) ) ) otherlv_5= ')' ) ;
    public final EObject ruleCellIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_line_1_0=null;
        Token otherlv_2=null;
        Token lv_colnum_3_0=null;
        Token otherlv_5=null;
        EObject lv_colname_4_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:328:2: ( (otherlv_0= '(' ( (lv_line_1_0= RULE_INT ) ) otherlv_2= ',' ( ( (lv_colnum_3_0= RULE_INT ) ) | ( (lv_colname_4_0= ruleField ) ) ) otherlv_5= ')' ) )
            // InternalMyCsv.g:329:2: (otherlv_0= '(' ( (lv_line_1_0= RULE_INT ) ) otherlv_2= ',' ( ( (lv_colnum_3_0= RULE_INT ) ) | ( (lv_colname_4_0= ruleField ) ) ) otherlv_5= ')' )
            {
            // InternalMyCsv.g:329:2: (otherlv_0= '(' ( (lv_line_1_0= RULE_INT ) ) otherlv_2= ',' ( ( (lv_colnum_3_0= RULE_INT ) ) | ( (lv_colname_4_0= ruleField ) ) ) otherlv_5= ')' )
            // InternalMyCsv.g:330:3: otherlv_0= '(' ( (lv_line_1_0= RULE_INT ) ) otherlv_2= ',' ( ( (lv_colnum_3_0= RULE_INT ) ) | ( (lv_colname_4_0= ruleField ) ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getCellIndexAccess().getLeftParenthesisKeyword_0());
            		
            // InternalMyCsv.g:334:3: ( (lv_line_1_0= RULE_INT ) )
            // InternalMyCsv.g:335:4: (lv_line_1_0= RULE_INT )
            {
            // InternalMyCsv.g:335:4: (lv_line_1_0= RULE_INT )
            // InternalMyCsv.g:336:5: lv_line_1_0= RULE_INT
            {
            lv_line_1_0=(Token)match(input,RULE_INT,FOLLOW_7); 

            					newLeafNode(lv_line_1_0, grammarAccess.getCellIndexAccess().getLineINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCellIndexRule());
            					}
            					setWithLastConsumed(
            						current,
            						"line",
            						lv_line_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getCellIndexAccess().getCommaKeyword_2());
            		
            // InternalMyCsv.g:356:3: ( ( (lv_colnum_3_0= RULE_INT ) ) | ( (lv_colname_4_0= ruleField ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_INT) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMyCsv.g:357:4: ( (lv_colnum_3_0= RULE_INT ) )
                    {
                    // InternalMyCsv.g:357:4: ( (lv_colnum_3_0= RULE_INT ) )
                    // InternalMyCsv.g:358:5: (lv_colnum_3_0= RULE_INT )
                    {
                    // InternalMyCsv.g:358:5: (lv_colnum_3_0= RULE_INT )
                    // InternalMyCsv.g:359:6: lv_colnum_3_0= RULE_INT
                    {
                    lv_colnum_3_0=(Token)match(input,RULE_INT,FOLLOW_9); 

                    						newLeafNode(lv_colnum_3_0, grammarAccess.getCellIndexAccess().getColnumINTTerminalRuleCall_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCellIndexRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"colnum",
                    							lv_colnum_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:376:4: ( (lv_colname_4_0= ruleField ) )
                    {
                    // InternalMyCsv.g:376:4: ( (lv_colname_4_0= ruleField ) )
                    // InternalMyCsv.g:377:5: (lv_colname_4_0= ruleField )
                    {
                    // InternalMyCsv.g:377:5: (lv_colname_4_0= ruleField )
                    // InternalMyCsv.g:378:6: lv_colname_4_0= ruleField
                    {

                    						newCompositeNode(grammarAccess.getCellIndexAccess().getColnameFieldParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_colname_4_0=ruleField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCellIndexRule());
                    						}
                    						set(
                    							current,
                    							"colname",
                    							lv_colname_4_0,
                    							"org.xtext.MyCsv.Field");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getCellIndexAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCellIndex"


    // $ANTLR start "entryRuleValue"
    // InternalMyCsv.g:404:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalMyCsv.g:404:46: (iv_ruleValue= ruleValue EOF )
            // InternalMyCsv.g:405:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalMyCsv.g:411:1: ruleValue returns [EObject current=null] : (this_ExpressionCalcul_0= ruleExpressionCalcul | this_LitteralString_1= ruleLitteralString ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_ExpressionCalcul_0 = null;

        EObject this_LitteralString_1 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:417:2: ( (this_ExpressionCalcul_0= ruleExpressionCalcul | this_LitteralString_1= ruleLitteralString ) )
            // InternalMyCsv.g:418:2: (this_ExpressionCalcul_0= ruleExpressionCalcul | this_LitteralString_1= ruleLitteralString )
            {
            // InternalMyCsv.g:418:2: (this_ExpressionCalcul_0= ruleExpressionCalcul | this_LitteralString_1= ruleLitteralString )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT||LA8_0==11||(LA8_0>=42 && LA8_0<=43)||(LA8_0>=51 && LA8_0<=54)) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_STRING) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyCsv.g:419:3: this_ExpressionCalcul_0= ruleExpressionCalcul
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getExpressionCalculParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExpressionCalcul_0=ruleExpressionCalcul();

                    state._fsp--;


                    			current = this_ExpressionCalcul_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:428:3: this_LitteralString_1= ruleLitteralString
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getLitteralStringParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LitteralString_1=ruleLitteralString();

                    state._fsp--;


                    			current = this_LitteralString_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleValues"
    // InternalMyCsv.g:440:1: entryRuleValues returns [EObject current=null] : iv_ruleValues= ruleValues EOF ;
    public final EObject entryRuleValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValues = null;


        try {
            // InternalMyCsv.g:440:47: (iv_ruleValues= ruleValues EOF )
            // InternalMyCsv.g:441:2: iv_ruleValues= ruleValues EOF
            {
             newCompositeNode(grammarAccess.getValuesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValues=ruleValues();

            state._fsp--;

             current =iv_ruleValues; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValues"


    // $ANTLR start "ruleValues"
    // InternalMyCsv.g:447:1: ruleValues returns [EObject current=null] : ( (otherlv_0= '[' )? ( (lv_values_1_0= ruleValue ) ) (otherlv_2= ';' ( (lv_values_3_0= ruleValue ) ) )* (otherlv_4= ']' )? ) ;
    public final EObject ruleValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:453:2: ( ( (otherlv_0= '[' )? ( (lv_values_1_0= ruleValue ) ) (otherlv_2= ';' ( (lv_values_3_0= ruleValue ) ) )* (otherlv_4= ']' )? ) )
            // InternalMyCsv.g:454:2: ( (otherlv_0= '[' )? ( (lv_values_1_0= ruleValue ) ) (otherlv_2= ';' ( (lv_values_3_0= ruleValue ) ) )* (otherlv_4= ']' )? )
            {
            // InternalMyCsv.g:454:2: ( (otherlv_0= '[' )? ( (lv_values_1_0= ruleValue ) ) (otherlv_2= ';' ( (lv_values_3_0= ruleValue ) ) )* (otherlv_4= ']' )? )
            // InternalMyCsv.g:455:3: (otherlv_0= '[' )? ( (lv_values_1_0= ruleValue ) ) (otherlv_2= ';' ( (lv_values_3_0= ruleValue ) ) )* (otherlv_4= ']' )?
            {
            // InternalMyCsv.g:455:3: (otherlv_0= '[' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMyCsv.g:456:4: otherlv_0= '['
                    {
                    otherlv_0=(Token)match(input,14,FOLLOW_10); 

                    				newLeafNode(otherlv_0, grammarAccess.getValuesAccess().getLeftSquareBracketKeyword_0());
                    			

                    }
                    break;

            }

            // InternalMyCsv.g:461:3: ( (lv_values_1_0= ruleValue ) )
            // InternalMyCsv.g:462:4: (lv_values_1_0= ruleValue )
            {
            // InternalMyCsv.g:462:4: (lv_values_1_0= ruleValue )
            // InternalMyCsv.g:463:5: lv_values_1_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getValuesAccess().getValuesValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
            lv_values_1_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getValuesRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.MyCsv.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:480:3: (otherlv_2= ';' ( (lv_values_3_0= ruleValue ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMyCsv.g:481:4: otherlv_2= ';' ( (lv_values_3_0= ruleValue ) )
            	    {
            	    otherlv_2=(Token)match(input,15,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getValuesAccess().getSemicolonKeyword_2_0());
            	    			
            	    // InternalMyCsv.g:485:4: ( (lv_values_3_0= ruleValue ) )
            	    // InternalMyCsv.g:486:5: (lv_values_3_0= ruleValue )
            	    {
            	    // InternalMyCsv.g:486:5: (lv_values_3_0= ruleValue )
            	    // InternalMyCsv.g:487:6: lv_values_3_0= ruleValue
            	    {

            	    						newCompositeNode(grammarAccess.getValuesAccess().getValuesValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_values_3_0=ruleValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getValuesRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.MyCsv.Value");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalMyCsv.g:505:3: (otherlv_4= ']' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyCsv.g:506:4: otherlv_4= ']'
                    {
                    otherlv_4=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getValuesAccess().getRightSquareBracketKeyword_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValues"


    // $ANTLR start "entryRulePath"
    // InternalMyCsv.g:515:1: entryRulePath returns [EObject current=null] : iv_rulePath= rulePath EOF ;
    public final EObject entryRulePath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePath = null;


        try {
            // InternalMyCsv.g:515:45: (iv_rulePath= rulePath EOF )
            // InternalMyCsv.g:516:2: iv_rulePath= rulePath EOF
            {
             newCompositeNode(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;

             current =iv_rulePath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalMyCsv.g:522:1: rulePath returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject rulePath() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMyCsv.g:528:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalMyCsv.g:529:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalMyCsv.g:529:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalMyCsv.g:530:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalMyCsv.g:530:3: (lv_value_0_0= RULE_STRING )
            // InternalMyCsv.g:531:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getPathAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPathRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleField"
    // InternalMyCsv.g:550:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalMyCsv.g:550:46: (iv_ruleField= ruleField EOF )
            // InternalMyCsv.g:551:2: iv_ruleField= ruleField EOF
            {
             newCompositeNode(grammarAccess.getFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalMyCsv.g:557:1: ruleField returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMyCsv.g:563:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalMyCsv.g:564:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalMyCsv.g:564:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalMyCsv.g:565:3: (lv_value_0_0= RULE_ID )
            {
            // InternalMyCsv.g:565:3: (lv_value_0_0= RULE_ID )
            // InternalMyCsv.g:566:4: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getFieldAccess().getValueIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getFieldRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleStatement"
    // InternalMyCsv.g:585:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalMyCsv.g:585:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalMyCsv.g:586:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalMyCsv.g:592:1: ruleStatement returns [EObject current=null] : (this_Load_0= ruleLoad | this_Store_1= ruleStore | this_ExportJson_2= ruleExportJson | this_Projection_3= ruleProjection | this_Select_4= ruleSelect | this_Delete_5= ruleDelete | this_Insert_6= ruleInsert | this_Modify_7= ruleModify | this_Print_8= rulePrint | this_RenameField_9= ruleRenameField ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Load_0 = null;

        EObject this_Store_1 = null;

        EObject this_ExportJson_2 = null;

        EObject this_Projection_3 = null;

        EObject this_Select_4 = null;

        EObject this_Delete_5 = null;

        EObject this_Insert_6 = null;

        EObject this_Modify_7 = null;

        EObject this_Print_8 = null;

        EObject this_RenameField_9 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:598:2: ( (this_Load_0= ruleLoad | this_Store_1= ruleStore | this_ExportJson_2= ruleExportJson | this_Projection_3= ruleProjection | this_Select_4= ruleSelect | this_Delete_5= ruleDelete | this_Insert_6= ruleInsert | this_Modify_7= ruleModify | this_Print_8= rulePrint | this_RenameField_9= ruleRenameField ) )
            // InternalMyCsv.g:599:2: (this_Load_0= ruleLoad | this_Store_1= ruleStore | this_ExportJson_2= ruleExportJson | this_Projection_3= ruleProjection | this_Select_4= ruleSelect | this_Delete_5= ruleDelete | this_Insert_6= ruleInsert | this_Modify_7= ruleModify | this_Print_8= rulePrint | this_RenameField_9= ruleRenameField )
            {
            // InternalMyCsv.g:599:2: (this_Load_0= ruleLoad | this_Store_1= ruleStore | this_ExportJson_2= ruleExportJson | this_Projection_3= ruleProjection | this_Select_4= ruleSelect | this_Delete_5= ruleDelete | this_Insert_6= ruleInsert | this_Modify_7= ruleModify | this_Print_8= rulePrint | this_RenameField_9= ruleRenameField )
            int alt12=10;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt12=1;
                }
                break;
            case 22:
                {
                alt12=2;
                }
                break;
            case 23:
                {
                alt12=3;
                }
                break;
            case 24:
                {
                alt12=4;
                }
                break;
            case 25:
                {
                alt12=5;
                }
                break;
            case 26:
                {
                alt12=6;
                }
                break;
            case 29:
                {
                alt12=7;
                }
                break;
            case 31:
                {
                alt12=8;
                }
                break;
            case 34:
                {
                alt12=9;
                }
                break;
            case 37:
                {
                alt12=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalMyCsv.g:600:3: this_Load_0= ruleLoad
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getLoadParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Load_0=ruleLoad();

                    state._fsp--;


                    			current = this_Load_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:609:3: this_Store_1= ruleStore
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getStoreParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Store_1=ruleStore();

                    state._fsp--;


                    			current = this_Store_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:618:3: this_ExportJson_2= ruleExportJson
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getExportJsonParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExportJson_2=ruleExportJson();

                    state._fsp--;


                    			current = this_ExportJson_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:627:3: this_Projection_3= ruleProjection
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getProjectionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Projection_3=ruleProjection();

                    state._fsp--;


                    			current = this_Projection_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:636:3: this_Select_4= ruleSelect
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getSelectParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Select_4=ruleSelect();

                    state._fsp--;


                    			current = this_Select_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyCsv.g:645:3: this_Delete_5= ruleDelete
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getDeleteParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Delete_5=ruleDelete();

                    state._fsp--;


                    			current = this_Delete_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyCsv.g:654:3: this_Insert_6= ruleInsert
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getInsertParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Insert_6=ruleInsert();

                    state._fsp--;


                    			current = this_Insert_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyCsv.g:663:3: this_Modify_7= ruleModify
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getModifyParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Modify_7=ruleModify();

                    state._fsp--;


                    			current = this_Modify_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalMyCsv.g:672:3: this_Print_8= rulePrint
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getPrintParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Print_8=rulePrint();

                    state._fsp--;


                    			current = this_Print_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalMyCsv.g:681:3: this_RenameField_9= ruleRenameField
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getRenameFieldParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_RenameField_9=ruleRenameField();

                    state._fsp--;


                    			current = this_RenameField_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleLoad"
    // InternalMyCsv.g:693:1: entryRuleLoad returns [EObject current=null] : iv_ruleLoad= ruleLoad EOF ;
    public final EObject entryRuleLoad() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoad = null;


        try {
            // InternalMyCsv.g:693:45: (iv_ruleLoad= ruleLoad EOF )
            // InternalMyCsv.g:694:2: iv_ruleLoad= ruleLoad EOF
            {
             newCompositeNode(grammarAccess.getLoadRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoad=ruleLoad();

            state._fsp--;

             current =iv_ruleLoad; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoad"


    // $ANTLR start "ruleLoad"
    // InternalMyCsv.g:700:1: ruleLoad returns [EObject current=null] : (otherlv_0= 'Load' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )? ) ;
    public final EObject ruleLoad() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_sepDefined_2_0=null;
        Token otherlv_3=null;
        Token lv_sep_4_0=null;
        Token lv_noHeader_5_0=null;
        Token otherlv_6=null;
        EObject lv_path_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:706:2: ( (otherlv_0= 'Load' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )? ) )
            // InternalMyCsv.g:707:2: (otherlv_0= 'Load' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )? )
            {
            // InternalMyCsv.g:707:2: (otherlv_0= 'Load' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )? )
            // InternalMyCsv.g:708:3: otherlv_0= 'Load' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getLoadAccess().getLoadKeyword_0());
            		
            // InternalMyCsv.g:712:3: ( (lv_path_1_0= rulePath ) )
            // InternalMyCsv.g:713:4: (lv_path_1_0= rulePath )
            {
            // InternalMyCsv.g:713:4: (lv_path_1_0= rulePath )
            // InternalMyCsv.g:714:5: lv_path_1_0= rulePath
            {

            					newCompositeNode(grammarAccess.getLoadAccess().getPathPathParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_path_1_0=rulePath();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLoadRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_1_0,
            						"org.xtext.MyCsv.Path");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:731:3: ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyCsv.g:732:4: ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) )
                    {
                    // InternalMyCsv.g:732:4: ( (lv_sepDefined_2_0= 'sep' ) )
                    // InternalMyCsv.g:733:5: (lv_sepDefined_2_0= 'sep' )
                    {
                    // InternalMyCsv.g:733:5: (lv_sepDefined_2_0= 'sep' )
                    // InternalMyCsv.g:734:6: lv_sepDefined_2_0= 'sep'
                    {
                    lv_sepDefined_2_0=(Token)match(input,18,FOLLOW_14); 

                    						newLeafNode(lv_sepDefined_2_0, grammarAccess.getLoadAccess().getSepDefinedSepKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoadRule());
                    						}
                    						setWithLastConsumed(current, "sepDefined", lv_sepDefined_2_0 != null, "sep");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getLoadAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalMyCsv.g:750:4: ( (lv_sep_4_0= RULE_STRING ) )
                    // InternalMyCsv.g:751:5: (lv_sep_4_0= RULE_STRING )
                    {
                    // InternalMyCsv.g:751:5: (lv_sep_4_0= RULE_STRING )
                    // InternalMyCsv.g:752:6: lv_sep_4_0= RULE_STRING
                    {
                    lv_sep_4_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

                    						newLeafNode(lv_sep_4_0, grammarAccess.getLoadAccess().getSepSTRINGTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoadRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"sep",
                    							lv_sep_4_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyCsv.g:769:3: ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMyCsv.g:770:4: ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header'
                    {
                    // InternalMyCsv.g:770:4: ( (lv_noHeader_5_0= 'no' ) )
                    // InternalMyCsv.g:771:5: (lv_noHeader_5_0= 'no' )
                    {
                    // InternalMyCsv.g:771:5: (lv_noHeader_5_0= 'no' )
                    // InternalMyCsv.g:772:6: lv_noHeader_5_0= 'no'
                    {
                    lv_noHeader_5_0=(Token)match(input,20,FOLLOW_16); 

                    						newLeafNode(lv_noHeader_5_0, grammarAccess.getLoadAccess().getNoHeaderNoKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoadRule());
                    						}
                    						setWithLastConsumed(current, "noHeader", lv_noHeader_5_0 != null, "no");
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getLoadAccess().getHeaderKeyword_3_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoad"


    // $ANTLR start "entryRuleStore"
    // InternalMyCsv.g:793:1: entryRuleStore returns [EObject current=null] : iv_ruleStore= ruleStore EOF ;
    public final EObject entryRuleStore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStore = null;


        try {
            // InternalMyCsv.g:793:46: (iv_ruleStore= ruleStore EOF )
            // InternalMyCsv.g:794:2: iv_ruleStore= ruleStore EOF
            {
             newCompositeNode(grammarAccess.getStoreRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStore=ruleStore();

            state._fsp--;

             current =iv_ruleStore; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStore"


    // $ANTLR start "ruleStore"
    // InternalMyCsv.g:800:1: ruleStore returns [EObject current=null] : (otherlv_0= 'Store' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )? ) ;
    public final EObject ruleStore() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_sepDefined_2_0=null;
        Token otherlv_3=null;
        Token lv_sep_4_0=null;
        Token lv_noHeader_5_0=null;
        Token otherlv_6=null;
        EObject lv_path_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:806:2: ( (otherlv_0= 'Store' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )? ) )
            // InternalMyCsv.g:807:2: (otherlv_0= 'Store' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )? )
            {
            // InternalMyCsv.g:807:2: (otherlv_0= 'Store' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )? )
            // InternalMyCsv.g:808:3: otherlv_0= 'Store' ( (lv_path_1_0= rulePath ) ) ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )? ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getStoreAccess().getStoreKeyword_0());
            		
            // InternalMyCsv.g:812:3: ( (lv_path_1_0= rulePath ) )
            // InternalMyCsv.g:813:4: (lv_path_1_0= rulePath )
            {
            // InternalMyCsv.g:813:4: (lv_path_1_0= rulePath )
            // InternalMyCsv.g:814:5: lv_path_1_0= rulePath
            {

            					newCompositeNode(grammarAccess.getStoreAccess().getPathPathParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_path_1_0=rulePath();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStoreRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_1_0,
            						"org.xtext.MyCsv.Path");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:831:3: ( ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyCsv.g:832:4: ( (lv_sepDefined_2_0= 'sep' ) ) otherlv_3= '=' ( (lv_sep_4_0= RULE_STRING ) )
                    {
                    // InternalMyCsv.g:832:4: ( (lv_sepDefined_2_0= 'sep' ) )
                    // InternalMyCsv.g:833:5: (lv_sepDefined_2_0= 'sep' )
                    {
                    // InternalMyCsv.g:833:5: (lv_sepDefined_2_0= 'sep' )
                    // InternalMyCsv.g:834:6: lv_sepDefined_2_0= 'sep'
                    {
                    lv_sepDefined_2_0=(Token)match(input,18,FOLLOW_14); 

                    						newLeafNode(lv_sepDefined_2_0, grammarAccess.getStoreAccess().getSepDefinedSepKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStoreRule());
                    						}
                    						setWithLastConsumed(current, "sepDefined", lv_sepDefined_2_0 != null, "sep");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getStoreAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalMyCsv.g:850:4: ( (lv_sep_4_0= RULE_STRING ) )
                    // InternalMyCsv.g:851:5: (lv_sep_4_0= RULE_STRING )
                    {
                    // InternalMyCsv.g:851:5: (lv_sep_4_0= RULE_STRING )
                    // InternalMyCsv.g:852:6: lv_sep_4_0= RULE_STRING
                    {
                    lv_sep_4_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

                    						newLeafNode(lv_sep_4_0, grammarAccess.getStoreAccess().getSepSTRINGTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStoreRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"sep",
                    							lv_sep_4_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyCsv.g:869:3: ( ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMyCsv.g:870:4: ( (lv_noHeader_5_0= 'no' ) ) otherlv_6= 'header'
                    {
                    // InternalMyCsv.g:870:4: ( (lv_noHeader_5_0= 'no' ) )
                    // InternalMyCsv.g:871:5: (lv_noHeader_5_0= 'no' )
                    {
                    // InternalMyCsv.g:871:5: (lv_noHeader_5_0= 'no' )
                    // InternalMyCsv.g:872:6: lv_noHeader_5_0= 'no'
                    {
                    lv_noHeader_5_0=(Token)match(input,20,FOLLOW_16); 

                    						newLeafNode(lv_noHeader_5_0, grammarAccess.getStoreAccess().getNoHeaderNoKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStoreRule());
                    						}
                    						setWithLastConsumed(current, "noHeader", lv_noHeader_5_0 != null, "no");
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getStoreAccess().getHeaderKeyword_3_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStore"


    // $ANTLR start "entryRuleExportJson"
    // InternalMyCsv.g:893:1: entryRuleExportJson returns [EObject current=null] : iv_ruleExportJson= ruleExportJson EOF ;
    public final EObject entryRuleExportJson() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExportJson = null;


        try {
            // InternalMyCsv.g:893:51: (iv_ruleExportJson= ruleExportJson EOF )
            // InternalMyCsv.g:894:2: iv_ruleExportJson= ruleExportJson EOF
            {
             newCompositeNode(grammarAccess.getExportJsonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExportJson=ruleExportJson();

            state._fsp--;

             current =iv_ruleExportJson; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExportJson"


    // $ANTLR start "ruleExportJson"
    // InternalMyCsv.g:900:1: ruleExportJson returns [EObject current=null] : (otherlv_0= 'ExportJson' ( (lv_path_1_0= rulePath ) ) ) ;
    public final EObject ruleExportJson() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_path_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:906:2: ( (otherlv_0= 'ExportJson' ( (lv_path_1_0= rulePath ) ) ) )
            // InternalMyCsv.g:907:2: (otherlv_0= 'ExportJson' ( (lv_path_1_0= rulePath ) ) )
            {
            // InternalMyCsv.g:907:2: (otherlv_0= 'ExportJson' ( (lv_path_1_0= rulePath ) ) )
            // InternalMyCsv.g:908:3: otherlv_0= 'ExportJson' ( (lv_path_1_0= rulePath ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getExportJsonAccess().getExportJsonKeyword_0());
            		
            // InternalMyCsv.g:912:3: ( (lv_path_1_0= rulePath ) )
            // InternalMyCsv.g:913:4: (lv_path_1_0= rulePath )
            {
            // InternalMyCsv.g:913:4: (lv_path_1_0= rulePath )
            // InternalMyCsv.g:914:5: lv_path_1_0= rulePath
            {

            					newCompositeNode(grammarAccess.getExportJsonAccess().getPathPathParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_path_1_0=rulePath();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExportJsonRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_1_0,
            						"org.xtext.MyCsv.Path");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExportJson"


    // $ANTLR start "entryRuleProjection"
    // InternalMyCsv.g:935:1: entryRuleProjection returns [EObject current=null] : iv_ruleProjection= ruleProjection EOF ;
    public final EObject entryRuleProjection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjection = null;


        try {
            // InternalMyCsv.g:935:51: (iv_ruleProjection= ruleProjection EOF )
            // InternalMyCsv.g:936:2: iv_ruleProjection= ruleProjection EOF
            {
             newCompositeNode(grammarAccess.getProjectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProjection=ruleProjection();

            state._fsp--;

             current =iv_ruleProjection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProjection"


    // $ANTLR start "ruleProjection"
    // InternalMyCsv.g:942:1: ruleProjection returns [EObject current=null] : (otherlv_0= 'Projection' ( (lv_field_1_0= ruleFieldIndex ) ) ) ;
    public final EObject ruleProjection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_field_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:948:2: ( (otherlv_0= 'Projection' ( (lv_field_1_0= ruleFieldIndex ) ) ) )
            // InternalMyCsv.g:949:2: (otherlv_0= 'Projection' ( (lv_field_1_0= ruleFieldIndex ) ) )
            {
            // InternalMyCsv.g:949:2: (otherlv_0= 'Projection' ( (lv_field_1_0= ruleFieldIndex ) ) )
            // InternalMyCsv.g:950:3: otherlv_0= 'Projection' ( (lv_field_1_0= ruleFieldIndex ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getProjectionAccess().getProjectionKeyword_0());
            		
            // InternalMyCsv.g:954:3: ( (lv_field_1_0= ruleFieldIndex ) )
            // InternalMyCsv.g:955:4: (lv_field_1_0= ruleFieldIndex )
            {
            // InternalMyCsv.g:955:4: (lv_field_1_0= ruleFieldIndex )
            // InternalMyCsv.g:956:5: lv_field_1_0= ruleFieldIndex
            {

            					newCompositeNode(grammarAccess.getProjectionAccess().getFieldFieldIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_field_1_0=ruleFieldIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProjectionRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_1_0,
            						"org.xtext.MyCsv.FieldIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjection"


    // $ANTLR start "entryRuleSelect"
    // InternalMyCsv.g:977:1: entryRuleSelect returns [EObject current=null] : iv_ruleSelect= ruleSelect EOF ;
    public final EObject entryRuleSelect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelect = null;


        try {
            // InternalMyCsv.g:977:47: (iv_ruleSelect= ruleSelect EOF )
            // InternalMyCsv.g:978:2: iv_ruleSelect= ruleSelect EOF
            {
             newCompositeNode(grammarAccess.getSelectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelect=ruleSelect();

            state._fsp--;

             current =iv_ruleSelect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelect"


    // $ANTLR start "ruleSelect"
    // InternalMyCsv.g:984:1: ruleSelect returns [EObject current=null] : (otherlv_0= 'Select' ( (lv_line_1_0= ruleLineIndex ) ) ) ;
    public final EObject ruleSelect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_line_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:990:2: ( (otherlv_0= 'Select' ( (lv_line_1_0= ruleLineIndex ) ) ) )
            // InternalMyCsv.g:991:2: (otherlv_0= 'Select' ( (lv_line_1_0= ruleLineIndex ) ) )
            {
            // InternalMyCsv.g:991:2: (otherlv_0= 'Select' ( (lv_line_1_0= ruleLineIndex ) ) )
            // InternalMyCsv.g:992:3: otherlv_0= 'Select' ( (lv_line_1_0= ruleLineIndex ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectAccess().getSelectKeyword_0());
            		
            // InternalMyCsv.g:996:3: ( (lv_line_1_0= ruleLineIndex ) )
            // InternalMyCsv.g:997:4: (lv_line_1_0= ruleLineIndex )
            {
            // InternalMyCsv.g:997:4: (lv_line_1_0= ruleLineIndex )
            // InternalMyCsv.g:998:5: lv_line_1_0= ruleLineIndex
            {

            					newCompositeNode(grammarAccess.getSelectAccess().getLineLineIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_line_1_0=ruleLineIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectRule());
            					}
            					set(
            						current,
            						"line",
            						lv_line_1_0,
            						"org.xtext.MyCsv.LineIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelect"


    // $ANTLR start "entryRuleDelete"
    // InternalMyCsv.g:1019:1: entryRuleDelete returns [EObject current=null] : iv_ruleDelete= ruleDelete EOF ;
    public final EObject entryRuleDelete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelete = null;


        try {
            // InternalMyCsv.g:1019:47: (iv_ruleDelete= ruleDelete EOF )
            // InternalMyCsv.g:1020:2: iv_ruleDelete= ruleDelete EOF
            {
             newCompositeNode(grammarAccess.getDeleteRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDelete=ruleDelete();

            state._fsp--;

             current =iv_ruleDelete; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDelete"


    // $ANTLR start "ruleDelete"
    // InternalMyCsv.g:1026:1: ruleDelete returns [EObject current=null] : (otherlv_0= 'Delete' (this_DeleteLine_1= ruleDeleteLine | this_DeleteField_2= ruleDeleteField ) ) ;
    public final EObject ruleDelete() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_DeleteLine_1 = null;

        EObject this_DeleteField_2 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1032:2: ( (otherlv_0= 'Delete' (this_DeleteLine_1= ruleDeleteLine | this_DeleteField_2= ruleDeleteField ) ) )
            // InternalMyCsv.g:1033:2: (otherlv_0= 'Delete' (this_DeleteLine_1= ruleDeleteLine | this_DeleteField_2= ruleDeleteField ) )
            {
            // InternalMyCsv.g:1033:2: (otherlv_0= 'Delete' (this_DeleteLine_1= ruleDeleteLine | this_DeleteField_2= ruleDeleteField ) )
            // InternalMyCsv.g:1034:3: otherlv_0= 'Delete' (this_DeleteLine_1= ruleDeleteLine | this_DeleteField_2= ruleDeleteField )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getDeleteAccess().getDeleteKeyword_0());
            		
            // InternalMyCsv.g:1038:3: (this_DeleteLine_1= ruleDeleteLine | this_DeleteField_2= ruleDeleteField )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            else if ( (LA17_0==28) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyCsv.g:1039:4: this_DeleteLine_1= ruleDeleteLine
                    {

                    				newCompositeNode(grammarAccess.getDeleteAccess().getDeleteLineParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_2);
                    this_DeleteLine_1=ruleDeleteLine();

                    state._fsp--;


                    				current = this_DeleteLine_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:1048:4: this_DeleteField_2= ruleDeleteField
                    {

                    				newCompositeNode(grammarAccess.getDeleteAccess().getDeleteFieldParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_DeleteField_2=ruleDeleteField();

                    state._fsp--;


                    				current = this_DeleteField_2;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDelete"


    // $ANTLR start "entryRuleDeleteLine"
    // InternalMyCsv.g:1061:1: entryRuleDeleteLine returns [EObject current=null] : iv_ruleDeleteLine= ruleDeleteLine EOF ;
    public final EObject entryRuleDeleteLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeleteLine = null;


        try {
            // InternalMyCsv.g:1061:51: (iv_ruleDeleteLine= ruleDeleteLine EOF )
            // InternalMyCsv.g:1062:2: iv_ruleDeleteLine= ruleDeleteLine EOF
            {
             newCompositeNode(grammarAccess.getDeleteLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeleteLine=ruleDeleteLine();

            state._fsp--;

             current =iv_ruleDeleteLine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeleteLine"


    // $ANTLR start "ruleDeleteLine"
    // InternalMyCsv.g:1068:1: ruleDeleteLine returns [EObject current=null] : (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) ) ;
    public final EObject ruleDeleteLine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_lines_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1074:2: ( (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) ) )
            // InternalMyCsv.g:1075:2: (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) )
            {
            // InternalMyCsv.g:1075:2: (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) )
            // InternalMyCsv.g:1076:3: otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getDeleteLineAccess().getLineKeyword_0());
            		
            // InternalMyCsv.g:1080:3: ( (lv_lines_1_0= ruleLineIndex ) )
            // InternalMyCsv.g:1081:4: (lv_lines_1_0= ruleLineIndex )
            {
            // InternalMyCsv.g:1081:4: (lv_lines_1_0= ruleLineIndex )
            // InternalMyCsv.g:1082:5: lv_lines_1_0= ruleLineIndex
            {

            					newCompositeNode(grammarAccess.getDeleteLineAccess().getLinesLineIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_lines_1_0=ruleLineIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeleteLineRule());
            					}
            					set(
            						current,
            						"lines",
            						lv_lines_1_0,
            						"org.xtext.MyCsv.LineIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeleteLine"


    // $ANTLR start "entryRuleDeleteField"
    // InternalMyCsv.g:1103:1: entryRuleDeleteField returns [EObject current=null] : iv_ruleDeleteField= ruleDeleteField EOF ;
    public final EObject entryRuleDeleteField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeleteField = null;


        try {
            // InternalMyCsv.g:1103:52: (iv_ruleDeleteField= ruleDeleteField EOF )
            // InternalMyCsv.g:1104:2: iv_ruleDeleteField= ruleDeleteField EOF
            {
             newCompositeNode(grammarAccess.getDeleteFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeleteField=ruleDeleteField();

            state._fsp--;

             current =iv_ruleDeleteField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeleteField"


    // $ANTLR start "ruleDeleteField"
    // InternalMyCsv.g:1110:1: ruleDeleteField returns [EObject current=null] : (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) ) ;
    public final EObject ruleDeleteField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_fields_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1116:2: ( (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) ) )
            // InternalMyCsv.g:1117:2: (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) )
            {
            // InternalMyCsv.g:1117:2: (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) )
            // InternalMyCsv.g:1118:3: otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getDeleteFieldAccess().getFieldKeyword_0());
            		
            // InternalMyCsv.g:1122:3: ( (lv_fields_1_0= ruleFieldIndex ) )
            // InternalMyCsv.g:1123:4: (lv_fields_1_0= ruleFieldIndex )
            {
            // InternalMyCsv.g:1123:4: (lv_fields_1_0= ruleFieldIndex )
            // InternalMyCsv.g:1124:5: lv_fields_1_0= ruleFieldIndex
            {

            					newCompositeNode(grammarAccess.getDeleteFieldAccess().getFieldsFieldIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_fields_1_0=ruleFieldIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeleteFieldRule());
            					}
            					set(
            						current,
            						"fields",
            						lv_fields_1_0,
            						"org.xtext.MyCsv.FieldIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeleteField"


    // $ANTLR start "entryRuleInsert"
    // InternalMyCsv.g:1145:1: entryRuleInsert returns [EObject current=null] : iv_ruleInsert= ruleInsert EOF ;
    public final EObject entryRuleInsert() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInsert = null;


        try {
            // InternalMyCsv.g:1145:47: (iv_ruleInsert= ruleInsert EOF )
            // InternalMyCsv.g:1146:2: iv_ruleInsert= ruleInsert EOF
            {
             newCompositeNode(grammarAccess.getInsertRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInsert=ruleInsert();

            state._fsp--;

             current =iv_ruleInsert; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInsert"


    // $ANTLR start "ruleInsert"
    // InternalMyCsv.g:1152:1: ruleInsert returns [EObject current=null] : (otherlv_0= 'Insert' (this_InsertLine_1= ruleInsertLine | this_InsertField_2= ruleInsertField ) ) ;
    public final EObject ruleInsert() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_InsertLine_1 = null;

        EObject this_InsertField_2 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1158:2: ( (otherlv_0= 'Insert' (this_InsertLine_1= ruleInsertLine | this_InsertField_2= ruleInsertField ) ) )
            // InternalMyCsv.g:1159:2: (otherlv_0= 'Insert' (this_InsertLine_1= ruleInsertLine | this_InsertField_2= ruleInsertField ) )
            {
            // InternalMyCsv.g:1159:2: (otherlv_0= 'Insert' (this_InsertLine_1= ruleInsertLine | this_InsertField_2= ruleInsertField ) )
            // InternalMyCsv.g:1160:3: otherlv_0= 'Insert' (this_InsertLine_1= ruleInsertLine | this_InsertField_2= ruleInsertField )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getInsertAccess().getInsertKeyword_0());
            		
            // InternalMyCsv.g:1164:3: (this_InsertLine_1= ruleInsertLine | this_InsertField_2= ruleInsertField )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            else if ( (LA18_0==28) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalMyCsv.g:1165:4: this_InsertLine_1= ruleInsertLine
                    {

                    				newCompositeNode(grammarAccess.getInsertAccess().getInsertLineParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_2);
                    this_InsertLine_1=ruleInsertLine();

                    state._fsp--;


                    				current = this_InsertLine_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:1174:4: this_InsertField_2= ruleInsertField
                    {

                    				newCompositeNode(grammarAccess.getInsertAccess().getInsertFieldParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_InsertField_2=ruleInsertField();

                    state._fsp--;


                    				current = this_InsertField_2;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInsert"


    // $ANTLR start "entryRuleInsertLine"
    // InternalMyCsv.g:1187:1: entryRuleInsertLine returns [EObject current=null] : iv_ruleInsertLine= ruleInsertLine EOF ;
    public final EObject entryRuleInsertLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInsertLine = null;


        try {
            // InternalMyCsv.g:1187:51: (iv_ruleInsertLine= ruleInsertLine EOF )
            // InternalMyCsv.g:1188:2: iv_ruleInsertLine= ruleInsertLine EOF
            {
             newCompositeNode(grammarAccess.getInsertLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInsertLine=ruleInsertLine();

            state._fsp--;

             current =iv_ruleInsertLine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInsertLine"


    // $ANTLR start "ruleInsertLine"
    // InternalMyCsv.g:1194:1: ruleInsertLine returns [EObject current=null] : (otherlv_0= 'line' ( (lv_values_1_0= ruleValues ) ) ) ;
    public final EObject ruleInsertLine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_values_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1200:2: ( (otherlv_0= 'line' ( (lv_values_1_0= ruleValues ) ) ) )
            // InternalMyCsv.g:1201:2: (otherlv_0= 'line' ( (lv_values_1_0= ruleValues ) ) )
            {
            // InternalMyCsv.g:1201:2: (otherlv_0= 'line' ( (lv_values_1_0= ruleValues ) ) )
            // InternalMyCsv.g:1202:3: otherlv_0= 'line' ( (lv_values_1_0= ruleValues ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getInsertLineAccess().getLineKeyword_0());
            		
            // InternalMyCsv.g:1206:3: ( (lv_values_1_0= ruleValues ) )
            // InternalMyCsv.g:1207:4: (lv_values_1_0= ruleValues )
            {
            // InternalMyCsv.g:1207:4: (lv_values_1_0= ruleValues )
            // InternalMyCsv.g:1208:5: lv_values_1_0= ruleValues
            {

            					newCompositeNode(grammarAccess.getInsertLineAccess().getValuesValuesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_values_1_0=ruleValues();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInsertLineRule());
            					}
            					set(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.MyCsv.Values");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInsertLine"


    // $ANTLR start "entryRuleInsertField"
    // InternalMyCsv.g:1229:1: entryRuleInsertField returns [EObject current=null] : iv_ruleInsertField= ruleInsertField EOF ;
    public final EObject entryRuleInsertField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInsertField = null;


        try {
            // InternalMyCsv.g:1229:52: (iv_ruleInsertField= ruleInsertField EOF )
            // InternalMyCsv.g:1230:2: iv_ruleInsertField= ruleInsertField EOF
            {
             newCompositeNode(grammarAccess.getInsertFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInsertField=ruleInsertField();

            state._fsp--;

             current =iv_ruleInsertField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInsertField"


    // $ANTLR start "ruleInsertField"
    // InternalMyCsv.g:1236:1: ruleInsertField returns [EObject current=null] : (otherlv_0= 'field' ( (lv_fieldname_1_0= ruleField ) ) otherlv_2= ':' ( (lv_values_3_0= ruleValues ) ) ) ;
    public final EObject ruleInsertField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_fieldname_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1242:2: ( (otherlv_0= 'field' ( (lv_fieldname_1_0= ruleField ) ) otherlv_2= ':' ( (lv_values_3_0= ruleValues ) ) ) )
            // InternalMyCsv.g:1243:2: (otherlv_0= 'field' ( (lv_fieldname_1_0= ruleField ) ) otherlv_2= ':' ( (lv_values_3_0= ruleValues ) ) )
            {
            // InternalMyCsv.g:1243:2: (otherlv_0= 'field' ( (lv_fieldname_1_0= ruleField ) ) otherlv_2= ':' ( (lv_values_3_0= ruleValues ) ) )
            // InternalMyCsv.g:1244:3: otherlv_0= 'field' ( (lv_fieldname_1_0= ruleField ) ) otherlv_2= ':' ( (lv_values_3_0= ruleValues ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getInsertFieldAccess().getFieldKeyword_0());
            		
            // InternalMyCsv.g:1248:3: ( (lv_fieldname_1_0= ruleField ) )
            // InternalMyCsv.g:1249:4: (lv_fieldname_1_0= ruleField )
            {
            // InternalMyCsv.g:1249:4: (lv_fieldname_1_0= ruleField )
            // InternalMyCsv.g:1250:5: lv_fieldname_1_0= ruleField
            {

            					newCompositeNode(grammarAccess.getInsertFieldAccess().getFieldnameFieldParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_22);
            lv_fieldname_1_0=ruleField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInsertFieldRule());
            					}
            					set(
            						current,
            						"fieldname",
            						lv_fieldname_1_0,
            						"org.xtext.MyCsv.Field");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getInsertFieldAccess().getColonKeyword_2());
            		
            // InternalMyCsv.g:1271:3: ( (lv_values_3_0= ruleValues ) )
            // InternalMyCsv.g:1272:4: (lv_values_3_0= ruleValues )
            {
            // InternalMyCsv.g:1272:4: (lv_values_3_0= ruleValues )
            // InternalMyCsv.g:1273:5: lv_values_3_0= ruleValues
            {

            					newCompositeNode(grammarAccess.getInsertFieldAccess().getValuesValuesParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_values_3_0=ruleValues();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInsertFieldRule());
            					}
            					set(
            						current,
            						"values",
            						lv_values_3_0,
            						"org.xtext.MyCsv.Values");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInsertField"


    // $ANTLR start "entryRuleModify"
    // InternalMyCsv.g:1294:1: entryRuleModify returns [EObject current=null] : iv_ruleModify= ruleModify EOF ;
    public final EObject entryRuleModify() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModify = null;


        try {
            // InternalMyCsv.g:1294:47: (iv_ruleModify= ruleModify EOF )
            // InternalMyCsv.g:1295:2: iv_ruleModify= ruleModify EOF
            {
             newCompositeNode(grammarAccess.getModifyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModify=ruleModify();

            state._fsp--;

             current =iv_ruleModify; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModify"


    // $ANTLR start "ruleModify"
    // InternalMyCsv.g:1301:1: ruleModify returns [EObject current=null] : (otherlv_0= 'Modify' (this_ModifyLine_1= ruleModifyLine | this_ModifyField_2= ruleModifyField | this_ModifyCell_3= ruleModifyCell ) ) ;
    public final EObject ruleModify() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_ModifyLine_1 = null;

        EObject this_ModifyField_2 = null;

        EObject this_ModifyCell_3 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1307:2: ( (otherlv_0= 'Modify' (this_ModifyLine_1= ruleModifyLine | this_ModifyField_2= ruleModifyField | this_ModifyCell_3= ruleModifyCell ) ) )
            // InternalMyCsv.g:1308:2: (otherlv_0= 'Modify' (this_ModifyLine_1= ruleModifyLine | this_ModifyField_2= ruleModifyField | this_ModifyCell_3= ruleModifyCell ) )
            {
            // InternalMyCsv.g:1308:2: (otherlv_0= 'Modify' (this_ModifyLine_1= ruleModifyLine | this_ModifyField_2= ruleModifyField | this_ModifyCell_3= ruleModifyCell ) )
            // InternalMyCsv.g:1309:3: otherlv_0= 'Modify' (this_ModifyLine_1= ruleModifyLine | this_ModifyField_2= ruleModifyField | this_ModifyCell_3= ruleModifyCell )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getModifyAccess().getModifyKeyword_0());
            		
            // InternalMyCsv.g:1313:3: (this_ModifyLine_1= ruleModifyLine | this_ModifyField_2= ruleModifyField | this_ModifyCell_3= ruleModifyCell )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt19=1;
                }
                break;
            case 28:
                {
                alt19=2;
                }
                break;
            case 33:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalMyCsv.g:1314:4: this_ModifyLine_1= ruleModifyLine
                    {

                    				newCompositeNode(grammarAccess.getModifyAccess().getModifyLineParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_2);
                    this_ModifyLine_1=ruleModifyLine();

                    state._fsp--;


                    				current = this_ModifyLine_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:1323:4: this_ModifyField_2= ruleModifyField
                    {

                    				newCompositeNode(grammarAccess.getModifyAccess().getModifyFieldParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_ModifyField_2=ruleModifyField();

                    state._fsp--;


                    				current = this_ModifyField_2;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:1332:4: this_ModifyCell_3= ruleModifyCell
                    {

                    				newCompositeNode(grammarAccess.getModifyAccess().getModifyCellParserRuleCall_1_2());
                    			
                    pushFollow(FOLLOW_2);
                    this_ModifyCell_3=ruleModifyCell();

                    state._fsp--;


                    				current = this_ModifyCell_3;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModify"


    // $ANTLR start "entryRuleModifyLine"
    // InternalMyCsv.g:1345:1: entryRuleModifyLine returns [EObject current=null] : iv_ruleModifyLine= ruleModifyLine EOF ;
    public final EObject entryRuleModifyLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyLine = null;


        try {
            // InternalMyCsv.g:1345:51: (iv_ruleModifyLine= ruleModifyLine EOF )
            // InternalMyCsv.g:1346:2: iv_ruleModifyLine= ruleModifyLine EOF
            {
             newCompositeNode(grammarAccess.getModifyLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModifyLine=ruleModifyLine();

            state._fsp--;

             current =iv_ruleModifyLine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifyLine"


    // $ANTLR start "ruleModifyLine"
    // InternalMyCsv.g:1352:1: ruleModifyLine returns [EObject current=null] : (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) ) ) ;
    public final EObject ruleModifyLine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_lines_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1358:2: ( (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) ) ) )
            // InternalMyCsv.g:1359:2: (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) ) )
            {
            // InternalMyCsv.g:1359:2: (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) ) )
            // InternalMyCsv.g:1360:3: otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getModifyLineAccess().getLineKeyword_0());
            		
            // InternalMyCsv.g:1364:3: ( (lv_lines_1_0= ruleLineIndex ) )
            // InternalMyCsv.g:1365:4: (lv_lines_1_0= ruleLineIndex )
            {
            // InternalMyCsv.g:1365:4: (lv_lines_1_0= ruleLineIndex )
            // InternalMyCsv.g:1366:5: lv_lines_1_0= ruleLineIndex
            {

            					newCompositeNode(grammarAccess.getModifyLineAccess().getLinesLineIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
            lv_lines_1_0=ruleLineIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModifyLineRule());
            					}
            					set(
            						current,
            						"lines",
            						lv_lines_1_0,
            						"org.xtext.MyCsv.LineIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getModifyLineAccess().getWithKeyword_2());
            		
            // InternalMyCsv.g:1387:3: ( (lv_values_3_0= ruleValues ) )
            // InternalMyCsv.g:1388:4: (lv_values_3_0= ruleValues )
            {
            // InternalMyCsv.g:1388:4: (lv_values_3_0= ruleValues )
            // InternalMyCsv.g:1389:5: lv_values_3_0= ruleValues
            {

            					newCompositeNode(grammarAccess.getModifyLineAccess().getValuesValuesParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_values_3_0=ruleValues();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModifyLineRule());
            					}
            					set(
            						current,
            						"values",
            						lv_values_3_0,
            						"org.xtext.MyCsv.Values");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifyLine"


    // $ANTLR start "entryRuleModifyField"
    // InternalMyCsv.g:1410:1: entryRuleModifyField returns [EObject current=null] : iv_ruleModifyField= ruleModifyField EOF ;
    public final EObject entryRuleModifyField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyField = null;


        try {
            // InternalMyCsv.g:1410:52: (iv_ruleModifyField= ruleModifyField EOF )
            // InternalMyCsv.g:1411:2: iv_ruleModifyField= ruleModifyField EOF
            {
             newCompositeNode(grammarAccess.getModifyFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModifyField=ruleModifyField();

            state._fsp--;

             current =iv_ruleModifyField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifyField"


    // $ANTLR start "ruleModifyField"
    // InternalMyCsv.g:1417:1: ruleModifyField returns [EObject current=null] : (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) ) ) ;
    public final EObject ruleModifyField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_fields_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1423:2: ( (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) ) ) )
            // InternalMyCsv.g:1424:2: (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) ) )
            {
            // InternalMyCsv.g:1424:2: (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) ) )
            // InternalMyCsv.g:1425:3: otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) otherlv_2= 'with' ( (lv_values_3_0= ruleValues ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getModifyFieldAccess().getFieldKeyword_0());
            		
            // InternalMyCsv.g:1429:3: ( (lv_fields_1_0= ruleFieldIndex ) )
            // InternalMyCsv.g:1430:4: (lv_fields_1_0= ruleFieldIndex )
            {
            // InternalMyCsv.g:1430:4: (lv_fields_1_0= ruleFieldIndex )
            // InternalMyCsv.g:1431:5: lv_fields_1_0= ruleFieldIndex
            {

            					newCompositeNode(grammarAccess.getModifyFieldAccess().getFieldsFieldIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
            lv_fields_1_0=ruleFieldIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModifyFieldRule());
            					}
            					set(
            						current,
            						"fields",
            						lv_fields_1_0,
            						"org.xtext.MyCsv.FieldIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getModifyFieldAccess().getWithKeyword_2());
            		
            // InternalMyCsv.g:1452:3: ( (lv_values_3_0= ruleValues ) )
            // InternalMyCsv.g:1453:4: (lv_values_3_0= ruleValues )
            {
            // InternalMyCsv.g:1453:4: (lv_values_3_0= ruleValues )
            // InternalMyCsv.g:1454:5: lv_values_3_0= ruleValues
            {

            					newCompositeNode(grammarAccess.getModifyFieldAccess().getValuesValuesParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_values_3_0=ruleValues();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModifyFieldRule());
            					}
            					set(
            						current,
            						"values",
            						lv_values_3_0,
            						"org.xtext.MyCsv.Values");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifyField"


    // $ANTLR start "entryRuleModifyCell"
    // InternalMyCsv.g:1475:1: entryRuleModifyCell returns [EObject current=null] : iv_ruleModifyCell= ruleModifyCell EOF ;
    public final EObject entryRuleModifyCell() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyCell = null;


        try {
            // InternalMyCsv.g:1475:51: (iv_ruleModifyCell= ruleModifyCell EOF )
            // InternalMyCsv.g:1476:2: iv_ruleModifyCell= ruleModifyCell EOF
            {
             newCompositeNode(grammarAccess.getModifyCellRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModifyCell=ruleModifyCell();

            state._fsp--;

             current =iv_ruleModifyCell; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifyCell"


    // $ANTLR start "ruleModifyCell"
    // InternalMyCsv.g:1482:1: ruleModifyCell returns [EObject current=null] : (otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) ) otherlv_2= 'with' ( (lv_value_3_0= ruleValue ) ) ) ;
    public final EObject ruleModifyCell() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_cell_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1488:2: ( (otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) ) otherlv_2= 'with' ( (lv_value_3_0= ruleValue ) ) ) )
            // InternalMyCsv.g:1489:2: (otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) ) otherlv_2= 'with' ( (lv_value_3_0= ruleValue ) ) )
            {
            // InternalMyCsv.g:1489:2: (otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) ) otherlv_2= 'with' ( (lv_value_3_0= ruleValue ) ) )
            // InternalMyCsv.g:1490:3: otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) ) otherlv_2= 'with' ( (lv_value_3_0= ruleValue ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getModifyCellAccess().getCellKeyword_0());
            		
            // InternalMyCsv.g:1494:3: ( (lv_cell_1_0= ruleCellIndex ) )
            // InternalMyCsv.g:1495:4: (lv_cell_1_0= ruleCellIndex )
            {
            // InternalMyCsv.g:1495:4: (lv_cell_1_0= ruleCellIndex )
            // InternalMyCsv.g:1496:5: lv_cell_1_0= ruleCellIndex
            {

            					newCompositeNode(grammarAccess.getModifyCellAccess().getCellCellIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
            lv_cell_1_0=ruleCellIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModifyCellRule());
            					}
            					set(
            						current,
            						"cell",
            						lv_cell_1_0,
            						"org.xtext.MyCsv.CellIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getModifyCellAccess().getWithKeyword_2());
            		
            // InternalMyCsv.g:1517:3: ( (lv_value_3_0= ruleValue ) )
            // InternalMyCsv.g:1518:4: (lv_value_3_0= ruleValue )
            {
            // InternalMyCsv.g:1518:4: (lv_value_3_0= ruleValue )
            // InternalMyCsv.g:1519:5: lv_value_3_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getModifyCellAccess().getValueValueParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModifyCellRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.xtext.MyCsv.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifyCell"


    // $ANTLR start "entryRulePrint"
    // InternalMyCsv.g:1540:1: entryRulePrint returns [EObject current=null] : iv_rulePrint= rulePrint EOF ;
    public final EObject entryRulePrint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrint = null;


        try {
            // InternalMyCsv.g:1540:46: (iv_rulePrint= rulePrint EOF )
            // InternalMyCsv.g:1541:2: iv_rulePrint= rulePrint EOF
            {
             newCompositeNode(grammarAccess.getPrintRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrint=rulePrint();

            state._fsp--;

             current =iv_rulePrint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrint"


    // $ANTLR start "rulePrint"
    // InternalMyCsv.g:1547:1: rulePrint returns [EObject current=null] : (otherlv_0= 'Print' (this_PrintLine_1= rulePrintLine | this_PrintField_2= rulePrintField | this_PrintCell_3= rulePrintCell | ( () rulePrintTable ) | this_PrintExpr_6= rulePrintExpr ) ) ;
    public final EObject rulePrint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_PrintLine_1 = null;

        EObject this_PrintField_2 = null;

        EObject this_PrintCell_3 = null;

        EObject this_PrintExpr_6 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1553:2: ( (otherlv_0= 'Print' (this_PrintLine_1= rulePrintLine | this_PrintField_2= rulePrintField | this_PrintCell_3= rulePrintCell | ( () rulePrintTable ) | this_PrintExpr_6= rulePrintExpr ) ) )
            // InternalMyCsv.g:1554:2: (otherlv_0= 'Print' (this_PrintLine_1= rulePrintLine | this_PrintField_2= rulePrintField | this_PrintCell_3= rulePrintCell | ( () rulePrintTable ) | this_PrintExpr_6= rulePrintExpr ) )
            {
            // InternalMyCsv.g:1554:2: (otherlv_0= 'Print' (this_PrintLine_1= rulePrintLine | this_PrintField_2= rulePrintField | this_PrintCell_3= rulePrintCell | ( () rulePrintTable ) | this_PrintExpr_6= rulePrintExpr ) )
            // InternalMyCsv.g:1555:3: otherlv_0= 'Print' (this_PrintLine_1= rulePrintLine | this_PrintField_2= rulePrintField | this_PrintCell_3= rulePrintCell | ( () rulePrintTable ) | this_PrintExpr_6= rulePrintExpr )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getPrintAccess().getPrintKeyword_0());
            		
            // InternalMyCsv.g:1559:3: (this_PrintLine_1= rulePrintLine | this_PrintField_2= rulePrintField | this_PrintCell_3= rulePrintCell | ( () rulePrintTable ) | this_PrintExpr_6= rulePrintExpr )
            int alt20=5;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt20=1;
                }
                break;
            case 28:
                {
                alt20=2;
                }
                break;
            case 33:
                {
                alt20=3;
                }
                break;
            case 35:
                {
                alt20=4;
                }
                break;
            case 36:
                {
                alt20=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalMyCsv.g:1560:4: this_PrintLine_1= rulePrintLine
                    {

                    				newCompositeNode(grammarAccess.getPrintAccess().getPrintLineParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_2);
                    this_PrintLine_1=rulePrintLine();

                    state._fsp--;


                    				current = this_PrintLine_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:1569:4: this_PrintField_2= rulePrintField
                    {

                    				newCompositeNode(grammarAccess.getPrintAccess().getPrintFieldParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_PrintField_2=rulePrintField();

                    state._fsp--;


                    				current = this_PrintField_2;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:1578:4: this_PrintCell_3= rulePrintCell
                    {

                    				newCompositeNode(grammarAccess.getPrintAccess().getPrintCellParserRuleCall_1_2());
                    			
                    pushFollow(FOLLOW_2);
                    this_PrintCell_3=rulePrintCell();

                    state._fsp--;


                    				current = this_PrintCell_3;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:1587:4: ( () rulePrintTable )
                    {
                    // InternalMyCsv.g:1587:4: ( () rulePrintTable )
                    // InternalMyCsv.g:1588:5: () rulePrintTable
                    {
                    // InternalMyCsv.g:1588:5: ()
                    // InternalMyCsv.g:1589:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getPrintAccess().getPrintTableAction_1_3_0(),
                    							current);
                    					

                    }


                    					newCompositeNode(grammarAccess.getPrintAccess().getPrintTableParserRuleCall_1_3_1());
                    				
                    pushFollow(FOLLOW_2);
                    rulePrintTable();

                    state._fsp--;


                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:1604:4: this_PrintExpr_6= rulePrintExpr
                    {

                    				newCompositeNode(grammarAccess.getPrintAccess().getPrintExprParserRuleCall_1_4());
                    			
                    pushFollow(FOLLOW_2);
                    this_PrintExpr_6=rulePrintExpr();

                    state._fsp--;


                    				current = this_PrintExpr_6;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrint"


    // $ANTLR start "entryRulePrintLine"
    // InternalMyCsv.g:1617:1: entryRulePrintLine returns [EObject current=null] : iv_rulePrintLine= rulePrintLine EOF ;
    public final EObject entryRulePrintLine() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrintLine = null;


        try {
            // InternalMyCsv.g:1617:50: (iv_rulePrintLine= rulePrintLine EOF )
            // InternalMyCsv.g:1618:2: iv_rulePrintLine= rulePrintLine EOF
            {
             newCompositeNode(grammarAccess.getPrintLineRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrintLine=rulePrintLine();

            state._fsp--;

             current =iv_rulePrintLine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrintLine"


    // $ANTLR start "rulePrintLine"
    // InternalMyCsv.g:1624:1: rulePrintLine returns [EObject current=null] : (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) ) ;
    public final EObject rulePrintLine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_lines_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1630:2: ( (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) ) )
            // InternalMyCsv.g:1631:2: (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) )
            {
            // InternalMyCsv.g:1631:2: (otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) ) )
            // InternalMyCsv.g:1632:3: otherlv_0= 'line' ( (lv_lines_1_0= ruleLineIndex ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getPrintLineAccess().getLineKeyword_0());
            		
            // InternalMyCsv.g:1636:3: ( (lv_lines_1_0= ruleLineIndex ) )
            // InternalMyCsv.g:1637:4: (lv_lines_1_0= ruleLineIndex )
            {
            // InternalMyCsv.g:1637:4: (lv_lines_1_0= ruleLineIndex )
            // InternalMyCsv.g:1638:5: lv_lines_1_0= ruleLineIndex
            {

            					newCompositeNode(grammarAccess.getPrintLineAccess().getLinesLineIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_lines_1_0=ruleLineIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrintLineRule());
            					}
            					set(
            						current,
            						"lines",
            						lv_lines_1_0,
            						"org.xtext.MyCsv.LineIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrintLine"


    // $ANTLR start "entryRulePrintField"
    // InternalMyCsv.g:1659:1: entryRulePrintField returns [EObject current=null] : iv_rulePrintField= rulePrintField EOF ;
    public final EObject entryRulePrintField() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrintField = null;


        try {
            // InternalMyCsv.g:1659:51: (iv_rulePrintField= rulePrintField EOF )
            // InternalMyCsv.g:1660:2: iv_rulePrintField= rulePrintField EOF
            {
             newCompositeNode(grammarAccess.getPrintFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrintField=rulePrintField();

            state._fsp--;

             current =iv_rulePrintField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrintField"


    // $ANTLR start "rulePrintField"
    // InternalMyCsv.g:1666:1: rulePrintField returns [EObject current=null] : (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) ) ;
    public final EObject rulePrintField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_fields_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1672:2: ( (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) ) )
            // InternalMyCsv.g:1673:2: (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) )
            {
            // InternalMyCsv.g:1673:2: (otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) ) )
            // InternalMyCsv.g:1674:3: otherlv_0= 'field' ( (lv_fields_1_0= ruleFieldIndex ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getPrintFieldAccess().getFieldKeyword_0());
            		
            // InternalMyCsv.g:1678:3: ( (lv_fields_1_0= ruleFieldIndex ) )
            // InternalMyCsv.g:1679:4: (lv_fields_1_0= ruleFieldIndex )
            {
            // InternalMyCsv.g:1679:4: (lv_fields_1_0= ruleFieldIndex )
            // InternalMyCsv.g:1680:5: lv_fields_1_0= ruleFieldIndex
            {

            					newCompositeNode(grammarAccess.getPrintFieldAccess().getFieldsFieldIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_fields_1_0=ruleFieldIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrintFieldRule());
            					}
            					set(
            						current,
            						"fields",
            						lv_fields_1_0,
            						"org.xtext.MyCsv.FieldIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrintField"


    // $ANTLR start "entryRulePrintCell"
    // InternalMyCsv.g:1701:1: entryRulePrintCell returns [EObject current=null] : iv_rulePrintCell= rulePrintCell EOF ;
    public final EObject entryRulePrintCell() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrintCell = null;


        try {
            // InternalMyCsv.g:1701:50: (iv_rulePrintCell= rulePrintCell EOF )
            // InternalMyCsv.g:1702:2: iv_rulePrintCell= rulePrintCell EOF
            {
             newCompositeNode(grammarAccess.getPrintCellRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrintCell=rulePrintCell();

            state._fsp--;

             current =iv_rulePrintCell; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrintCell"


    // $ANTLR start "rulePrintCell"
    // InternalMyCsv.g:1708:1: rulePrintCell returns [EObject current=null] : (otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) ) ) ;
    public final EObject rulePrintCell() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_cell_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1714:2: ( (otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) ) ) )
            // InternalMyCsv.g:1715:2: (otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) ) )
            {
            // InternalMyCsv.g:1715:2: (otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) ) )
            // InternalMyCsv.g:1716:3: otherlv_0= 'cell' ( (lv_cell_1_0= ruleCellIndex ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getPrintCellAccess().getCellKeyword_0());
            		
            // InternalMyCsv.g:1720:3: ( (lv_cell_1_0= ruleCellIndex ) )
            // InternalMyCsv.g:1721:4: (lv_cell_1_0= ruleCellIndex )
            {
            // InternalMyCsv.g:1721:4: (lv_cell_1_0= ruleCellIndex )
            // InternalMyCsv.g:1722:5: lv_cell_1_0= ruleCellIndex
            {

            					newCompositeNode(grammarAccess.getPrintCellAccess().getCellCellIndexParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_cell_1_0=ruleCellIndex();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrintCellRule());
            					}
            					set(
            						current,
            						"cell",
            						lv_cell_1_0,
            						"org.xtext.MyCsv.CellIndex");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrintCell"


    // $ANTLR start "entryRulePrintTable"
    // InternalMyCsv.g:1743:1: entryRulePrintTable returns [String current=null] : iv_rulePrintTable= rulePrintTable EOF ;
    public final String entryRulePrintTable() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrintTable = null;


        try {
            // InternalMyCsv.g:1743:50: (iv_rulePrintTable= rulePrintTable EOF )
            // InternalMyCsv.g:1744:2: iv_rulePrintTable= rulePrintTable EOF
            {
             newCompositeNode(grammarAccess.getPrintTableRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrintTable=rulePrintTable();

            state._fsp--;

             current =iv_rulePrintTable.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrintTable"


    // $ANTLR start "rulePrintTable"
    // InternalMyCsv.g:1750:1: rulePrintTable returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'table' ;
    public final AntlrDatatypeRuleToken rulePrintTable() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:1756:2: (kw= 'table' )
            // InternalMyCsv.g:1757:2: kw= 'table'
            {
            kw=(Token)match(input,35,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPrintTableAccess().getTableKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrintTable"


    // $ANTLR start "entryRulePrintExpr"
    // InternalMyCsv.g:1765:1: entryRulePrintExpr returns [EObject current=null] : iv_rulePrintExpr= rulePrintExpr EOF ;
    public final EObject entryRulePrintExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrintExpr = null;


        try {
            // InternalMyCsv.g:1765:50: (iv_rulePrintExpr= rulePrintExpr EOF )
            // InternalMyCsv.g:1766:2: iv_rulePrintExpr= rulePrintExpr EOF
            {
             newCompositeNode(grammarAccess.getPrintExprRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrintExpr=rulePrintExpr();

            state._fsp--;

             current =iv_rulePrintExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrintExpr"


    // $ANTLR start "rulePrintExpr"
    // InternalMyCsv.g:1772:1: rulePrintExpr returns [EObject current=null] : (otherlv_0= 'expr' ( (lv_exp_1_0= ruleValue ) ) ) ;
    public final EObject rulePrintExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1778:2: ( (otherlv_0= 'expr' ( (lv_exp_1_0= ruleValue ) ) ) )
            // InternalMyCsv.g:1779:2: (otherlv_0= 'expr' ( (lv_exp_1_0= ruleValue ) ) )
            {
            // InternalMyCsv.g:1779:2: (otherlv_0= 'expr' ( (lv_exp_1_0= ruleValue ) ) )
            // InternalMyCsv.g:1780:3: otherlv_0= 'expr' ( (lv_exp_1_0= ruleValue ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getPrintExprAccess().getExprKeyword_0());
            		
            // InternalMyCsv.g:1784:3: ( (lv_exp_1_0= ruleValue ) )
            // InternalMyCsv.g:1785:4: (lv_exp_1_0= ruleValue )
            {
            // InternalMyCsv.g:1785:4: (lv_exp_1_0= ruleValue )
            // InternalMyCsv.g:1786:5: lv_exp_1_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getPrintExprAccess().getExpValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_1_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrintExprRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_1_0,
            						"org.xtext.MyCsv.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrintExpr"


    // $ANTLR start "entryRuleRenameField"
    // InternalMyCsv.g:1807:1: entryRuleRenameField returns [EObject current=null] : iv_ruleRenameField= ruleRenameField EOF ;
    public final EObject entryRuleRenameField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRenameField = null;


        try {
            // InternalMyCsv.g:1807:52: (iv_ruleRenameField= ruleRenameField EOF )
            // InternalMyCsv.g:1808:2: iv_ruleRenameField= ruleRenameField EOF
            {
             newCompositeNode(grammarAccess.getRenameFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRenameField=ruleRenameField();

            state._fsp--;

             current =iv_ruleRenameField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRenameField"


    // $ANTLR start "ruleRenameField"
    // InternalMyCsv.g:1814:1: ruleRenameField returns [EObject current=null] : (otherlv_0= 'Rename' otherlv_1= 'field' ( (lv_last_field_2_0= ruleField ) ) otherlv_3= ':=' ( (lv_new_field_4_0= ruleField ) ) ) ;
    public final EObject ruleRenameField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_last_field_2_0 = null;

        EObject lv_new_field_4_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1820:2: ( (otherlv_0= 'Rename' otherlv_1= 'field' ( (lv_last_field_2_0= ruleField ) ) otherlv_3= ':=' ( (lv_new_field_4_0= ruleField ) ) ) )
            // InternalMyCsv.g:1821:2: (otherlv_0= 'Rename' otherlv_1= 'field' ( (lv_last_field_2_0= ruleField ) ) otherlv_3= ':=' ( (lv_new_field_4_0= ruleField ) ) )
            {
            // InternalMyCsv.g:1821:2: (otherlv_0= 'Rename' otherlv_1= 'field' ( (lv_last_field_2_0= ruleField ) ) otherlv_3= ':=' ( (lv_new_field_4_0= ruleField ) ) )
            // InternalMyCsv.g:1822:3: otherlv_0= 'Rename' otherlv_1= 'field' ( (lv_last_field_2_0= ruleField ) ) otherlv_3= ':=' ( (lv_new_field_4_0= ruleField ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getRenameFieldAccess().getRenameKeyword_0());
            		
            otherlv_1=(Token)match(input,28,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getRenameFieldAccess().getFieldKeyword_1());
            		
            // InternalMyCsv.g:1830:3: ( (lv_last_field_2_0= ruleField ) )
            // InternalMyCsv.g:1831:4: (lv_last_field_2_0= ruleField )
            {
            // InternalMyCsv.g:1831:4: (lv_last_field_2_0= ruleField )
            // InternalMyCsv.g:1832:5: lv_last_field_2_0= ruleField
            {

            					newCompositeNode(grammarAccess.getRenameFieldAccess().getLast_fieldFieldParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_29);
            lv_last_field_2_0=ruleField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRenameFieldRule());
            					}
            					set(
            						current,
            						"last_field",
            						lv_last_field_2_0,
            						"org.xtext.MyCsv.Field");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,38,FOLLOW_30); 

            			newLeafNode(otherlv_3, grammarAccess.getRenameFieldAccess().getColonEqualsSignKeyword_3());
            		
            // InternalMyCsv.g:1853:3: ( (lv_new_field_4_0= ruleField ) )
            // InternalMyCsv.g:1854:4: (lv_new_field_4_0= ruleField )
            {
            // InternalMyCsv.g:1854:4: (lv_new_field_4_0= ruleField )
            // InternalMyCsv.g:1855:5: lv_new_field_4_0= ruleField
            {

            					newCompositeNode(grammarAccess.getRenameFieldAccess().getNew_fieldFieldParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_new_field_4_0=ruleField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRenameFieldRule());
            					}
            					set(
            						current,
            						"new_field",
            						lv_new_field_4_0,
            						"org.xtext.MyCsv.Field");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRenameField"


    // $ANTLR start "entryRuleExpressionLog"
    // InternalMyCsv.g:1876:1: entryRuleExpressionLog returns [EObject current=null] : iv_ruleExpressionLog= ruleExpressionLog EOF ;
    public final EObject entryRuleExpressionLog() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionLog = null;


        try {
            // InternalMyCsv.g:1876:54: (iv_ruleExpressionLog= ruleExpressionLog EOF )
            // InternalMyCsv.g:1877:2: iv_ruleExpressionLog= ruleExpressionLog EOF
            {
             newCompositeNode(grammarAccess.getExpressionLogRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionLog=ruleExpressionLog();

            state._fsp--;

             current =iv_ruleExpressionLog; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionLog"


    // $ANTLR start "ruleExpressionLog"
    // InternalMyCsv.g:1883:1: ruleExpressionLog returns [EObject current=null] : ( (lv_expr_0_0= ruleOrExpression ) ) ;
    public final EObject ruleExpressionLog() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1889:2: ( ( (lv_expr_0_0= ruleOrExpression ) ) )
            // InternalMyCsv.g:1890:2: ( (lv_expr_0_0= ruleOrExpression ) )
            {
            // InternalMyCsv.g:1890:2: ( (lv_expr_0_0= ruleOrExpression ) )
            // InternalMyCsv.g:1891:3: (lv_expr_0_0= ruleOrExpression )
            {
            // InternalMyCsv.g:1891:3: (lv_expr_0_0= ruleOrExpression )
            // InternalMyCsv.g:1892:4: lv_expr_0_0= ruleOrExpression
            {

            				newCompositeNode(grammarAccess.getExpressionLogAccess().getExprOrExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_expr_0_0=ruleOrExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getExpressionLogRule());
            				}
            				set(
            					current,
            					"expr",
            					lv_expr_0_0,
            					"org.xtext.MyCsv.OrExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionLog"


    // $ANTLR start "entryRuleOrExpression"
    // InternalMyCsv.g:1912:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalMyCsv.g:1912:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalMyCsv.g:1913:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;

             current =iv_ruleOrExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalMyCsv.g:1919:1: ruleOrExpression returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleAndExpression ) ) (otherlv_1= 'or' ( (lv_rhs_2_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_2_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1925:2: ( ( ( (lv_lhs_0_0= ruleAndExpression ) ) (otherlv_1= 'or' ( (lv_rhs_2_0= ruleAndExpression ) ) )* ) )
            // InternalMyCsv.g:1926:2: ( ( (lv_lhs_0_0= ruleAndExpression ) ) (otherlv_1= 'or' ( (lv_rhs_2_0= ruleAndExpression ) ) )* )
            {
            // InternalMyCsv.g:1926:2: ( ( (lv_lhs_0_0= ruleAndExpression ) ) (otherlv_1= 'or' ( (lv_rhs_2_0= ruleAndExpression ) ) )* )
            // InternalMyCsv.g:1927:3: ( (lv_lhs_0_0= ruleAndExpression ) ) (otherlv_1= 'or' ( (lv_rhs_2_0= ruleAndExpression ) ) )*
            {
            // InternalMyCsv.g:1927:3: ( (lv_lhs_0_0= ruleAndExpression ) )
            // InternalMyCsv.g:1928:4: (lv_lhs_0_0= ruleAndExpression )
            {
            // InternalMyCsv.g:1928:4: (lv_lhs_0_0= ruleAndExpression )
            // InternalMyCsv.g:1929:5: lv_lhs_0_0= ruleAndExpression
            {

            					newCompositeNode(grammarAccess.getOrExpressionAccess().getLhsAndExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_31);
            lv_lhs_0_0=ruleAndExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_0_0,
            						"org.xtext.MyCsv.AndExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:1946:3: (otherlv_1= 'or' ( (lv_rhs_2_0= ruleAndExpression ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==39) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMyCsv.g:1947:4: otherlv_1= 'or' ( (lv_rhs_2_0= ruleAndExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,39,FOLLOW_32); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrExpressionAccess().getOrKeyword_1_0());
            	    			
            	    // InternalMyCsv.g:1951:4: ( (lv_rhs_2_0= ruleAndExpression ) )
            	    // InternalMyCsv.g:1952:5: (lv_rhs_2_0= ruleAndExpression )
            	    {
            	    // InternalMyCsv.g:1952:5: (lv_rhs_2_0= ruleAndExpression )
            	    // InternalMyCsv.g:1953:6: lv_rhs_2_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionAccess().getRhsAndExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_rhs_2_0=ruleAndExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rhs",
            	    							lv_rhs_2_0,
            	    							"org.xtext.MyCsv.AndExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalMyCsv.g:1975:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalMyCsv.g:1975:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalMyCsv.g:1976:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalMyCsv.g:1982:1: ruleAndExpression returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleUnaryLogExpression ) ) (otherlv_1= 'and' ( (lv_rhs_2_0= ruleUnaryLogExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_2_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:1988:2: ( ( ( (lv_lhs_0_0= ruleUnaryLogExpression ) ) (otherlv_1= 'and' ( (lv_rhs_2_0= ruleUnaryLogExpression ) ) )* ) )
            // InternalMyCsv.g:1989:2: ( ( (lv_lhs_0_0= ruleUnaryLogExpression ) ) (otherlv_1= 'and' ( (lv_rhs_2_0= ruleUnaryLogExpression ) ) )* )
            {
            // InternalMyCsv.g:1989:2: ( ( (lv_lhs_0_0= ruleUnaryLogExpression ) ) (otherlv_1= 'and' ( (lv_rhs_2_0= ruleUnaryLogExpression ) ) )* )
            // InternalMyCsv.g:1990:3: ( (lv_lhs_0_0= ruleUnaryLogExpression ) ) (otherlv_1= 'and' ( (lv_rhs_2_0= ruleUnaryLogExpression ) ) )*
            {
            // InternalMyCsv.g:1990:3: ( (lv_lhs_0_0= ruleUnaryLogExpression ) )
            // InternalMyCsv.g:1991:4: (lv_lhs_0_0= ruleUnaryLogExpression )
            {
            // InternalMyCsv.g:1991:4: (lv_lhs_0_0= ruleUnaryLogExpression )
            // InternalMyCsv.g:1992:5: lv_lhs_0_0= ruleUnaryLogExpression
            {

            					newCompositeNode(grammarAccess.getAndExpressionAccess().getLhsUnaryLogExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_33);
            lv_lhs_0_0=ruleUnaryLogExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_0_0,
            						"org.xtext.MyCsv.UnaryLogExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:2009:3: (otherlv_1= 'and' ( (lv_rhs_2_0= ruleUnaryLogExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==40) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalMyCsv.g:2010:4: otherlv_1= 'and' ( (lv_rhs_2_0= ruleUnaryLogExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,40,FOLLOW_32); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAndExpressionAccess().getAndKeyword_1_0());
            	    			
            	    // InternalMyCsv.g:2014:4: ( (lv_rhs_2_0= ruleUnaryLogExpression ) )
            	    // InternalMyCsv.g:2015:5: (lv_rhs_2_0= ruleUnaryLogExpression )
            	    {
            	    // InternalMyCsv.g:2015:5: (lv_rhs_2_0= ruleUnaryLogExpression )
            	    // InternalMyCsv.g:2016:6: lv_rhs_2_0= ruleUnaryLogExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRhsUnaryLogExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_33);
            	    lv_rhs_2_0=ruleUnaryLogExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rhs",
            	    							lv_rhs_2_0,
            	    							"org.xtext.MyCsv.UnaryLogExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleUnaryLogExpression"
    // InternalMyCsv.g:2038:1: entryRuleUnaryLogExpression returns [EObject current=null] : iv_ruleUnaryLogExpression= ruleUnaryLogExpression EOF ;
    public final EObject entryRuleUnaryLogExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryLogExpression = null;


        try {
            // InternalMyCsv.g:2038:59: (iv_ruleUnaryLogExpression= ruleUnaryLogExpression EOF )
            // InternalMyCsv.g:2039:2: iv_ruleUnaryLogExpression= ruleUnaryLogExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryLogExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryLogExpression=ruleUnaryLogExpression();

            state._fsp--;

             current =iv_ruleUnaryLogExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryLogExpression"


    // $ANTLR start "ruleUnaryLogExpression"
    // InternalMyCsv.g:2045:1: ruleUnaryLogExpression returns [EObject current=null] : ( ( (lv_not_0_0= 'not' ) )? ( (lv_expr_1_0= ruleExpressionLogPrimary ) ) ) ;
    public final EObject ruleUnaryLogExpression() throws RecognitionException {
        EObject current = null;

        Token lv_not_0_0=null;
        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2051:2: ( ( ( (lv_not_0_0= 'not' ) )? ( (lv_expr_1_0= ruleExpressionLogPrimary ) ) ) )
            // InternalMyCsv.g:2052:2: ( ( (lv_not_0_0= 'not' ) )? ( (lv_expr_1_0= ruleExpressionLogPrimary ) ) )
            {
            // InternalMyCsv.g:2052:2: ( ( (lv_not_0_0= 'not' ) )? ( (lv_expr_1_0= ruleExpressionLogPrimary ) ) )
            // InternalMyCsv.g:2053:3: ( (lv_not_0_0= 'not' ) )? ( (lv_expr_1_0= ruleExpressionLogPrimary ) )
            {
            // InternalMyCsv.g:2053:3: ( (lv_not_0_0= 'not' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==41) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMyCsv.g:2054:4: (lv_not_0_0= 'not' )
                    {
                    // InternalMyCsv.g:2054:4: (lv_not_0_0= 'not' )
                    // InternalMyCsv.g:2055:5: lv_not_0_0= 'not'
                    {
                    lv_not_0_0=(Token)match(input,41,FOLLOW_32); 

                    					newLeafNode(lv_not_0_0, grammarAccess.getUnaryLogExpressionAccess().getNotNotKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryLogExpressionRule());
                    					}
                    					setWithLastConsumed(current, "not", lv_not_0_0 != null, "not");
                    				

                    }


                    }
                    break;

            }

            // InternalMyCsv.g:2067:3: ( (lv_expr_1_0= ruleExpressionLogPrimary ) )
            // InternalMyCsv.g:2068:4: (lv_expr_1_0= ruleExpressionLogPrimary )
            {
            // InternalMyCsv.g:2068:4: (lv_expr_1_0= ruleExpressionLogPrimary )
            // InternalMyCsv.g:2069:5: lv_expr_1_0= ruleExpressionLogPrimary
            {

            					newCompositeNode(grammarAccess.getUnaryLogExpressionAccess().getExprExpressionLogPrimaryParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_expr_1_0=ruleExpressionLogPrimary();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryLogExpressionRule());
            					}
            					set(
            						current,
            						"expr",
            						lv_expr_1_0,
            						"org.xtext.MyCsv.ExpressionLogPrimary");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryLogExpression"


    // $ANTLR start "entryRuleExpressionLogPrimary"
    // InternalMyCsv.g:2090:1: entryRuleExpressionLogPrimary returns [EObject current=null] : iv_ruleExpressionLogPrimary= ruleExpressionLogPrimary EOF ;
    public final EObject entryRuleExpressionLogPrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionLogPrimary = null;


        try {
            // InternalMyCsv.g:2090:61: (iv_ruleExpressionLogPrimary= ruleExpressionLogPrimary EOF )
            // InternalMyCsv.g:2091:2: iv_ruleExpressionLogPrimary= ruleExpressionLogPrimary EOF
            {
             newCompositeNode(grammarAccess.getExpressionLogPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionLogPrimary=ruleExpressionLogPrimary();

            state._fsp--;

             current =iv_ruleExpressionLogPrimary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionLogPrimary"


    // $ANTLR start "ruleExpressionLogPrimary"
    // InternalMyCsv.g:2097:1: ruleExpressionLogPrimary returns [EObject current=null] : (this_ExpressionRel_0= ruleExpressionRel | this_NestedLogExpression_1= ruleNestedLogExpression ) ;
    public final EObject ruleExpressionLogPrimary() throws RecognitionException {
        EObject current = null;

        EObject this_ExpressionRel_0 = null;

        EObject this_NestedLogExpression_1 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2103:2: ( (this_ExpressionRel_0= ruleExpressionRel | this_NestedLogExpression_1= ruleNestedLogExpression ) )
            // InternalMyCsv.g:2104:2: (this_ExpressionRel_0= ruleExpressionRel | this_NestedLogExpression_1= ruleNestedLogExpression )
            {
            // InternalMyCsv.g:2104:2: (this_ExpressionRel_0= ruleExpressionRel | this_NestedLogExpression_1= ruleNestedLogExpression )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            else if ( (LA24_0==11) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalMyCsv.g:2105:3: this_ExpressionRel_0= ruleExpressionRel
                    {

                    			newCompositeNode(grammarAccess.getExpressionLogPrimaryAccess().getExpressionRelParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExpressionRel_0=ruleExpressionRel();

                    state._fsp--;


                    			current = this_ExpressionRel_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:2114:3: this_NestedLogExpression_1= ruleNestedLogExpression
                    {

                    			newCompositeNode(grammarAccess.getExpressionLogPrimaryAccess().getNestedLogExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NestedLogExpression_1=ruleNestedLogExpression();

                    state._fsp--;


                    			current = this_NestedLogExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionLogPrimary"


    // $ANTLR start "entryRuleNestedLogExpression"
    // InternalMyCsv.g:2126:1: entryRuleNestedLogExpression returns [EObject current=null] : iv_ruleNestedLogExpression= ruleNestedLogExpression EOF ;
    public final EObject entryRuleNestedLogExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedLogExpression = null;


        try {
            // InternalMyCsv.g:2126:60: (iv_ruleNestedLogExpression= ruleNestedLogExpression EOF )
            // InternalMyCsv.g:2127:2: iv_ruleNestedLogExpression= ruleNestedLogExpression EOF
            {
             newCompositeNode(grammarAccess.getNestedLogExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNestedLogExpression=ruleNestedLogExpression();

            state._fsp--;

             current =iv_ruleNestedLogExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNestedLogExpression"


    // $ANTLR start "ruleNestedLogExpression"
    // InternalMyCsv.g:2133:1: ruleNestedLogExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionLog ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedLogExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2139:2: ( (otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionLog ) ) otherlv_2= ')' ) )
            // InternalMyCsv.g:2140:2: (otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionLog ) ) otherlv_2= ')' )
            {
            // InternalMyCsv.g:2140:2: (otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionLog ) ) otherlv_2= ')' )
            // InternalMyCsv.g:2141:3: otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionLog ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getNestedLogExpressionAccess().getLeftParenthesisKeyword_0());
            		
            // InternalMyCsv.g:2145:3: ( (lv_expr_1_0= ruleExpressionLog ) )
            // InternalMyCsv.g:2146:4: (lv_expr_1_0= ruleExpressionLog )
            {
            // InternalMyCsv.g:2146:4: (lv_expr_1_0= ruleExpressionLog )
            // InternalMyCsv.g:2147:5: lv_expr_1_0= ruleExpressionLog
            {

            					newCompositeNode(grammarAccess.getNestedLogExpressionAccess().getExprExpressionLogParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
            lv_expr_1_0=ruleExpressionLog();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNestedLogExpressionRule());
            					}
            					set(
            						current,
            						"expr",
            						lv_expr_1_0,
            						"org.xtext.MyCsv.ExpressionLog");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getNestedLogExpressionAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedLogExpression"


    // $ANTLR start "entryRuleExpressionRel"
    // InternalMyCsv.g:2172:1: entryRuleExpressionRel returns [EObject current=null] : iv_ruleExpressionRel= ruleExpressionRel EOF ;
    public final EObject entryRuleExpressionRel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRel = null;


        try {
            // InternalMyCsv.g:2172:54: (iv_ruleExpressionRel= ruleExpressionRel EOF )
            // InternalMyCsv.g:2173:2: iv_ruleExpressionRel= ruleExpressionRel EOF
            {
             newCompositeNode(grammarAccess.getExpressionRelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionRel=ruleExpressionRel();

            state._fsp--;

             current =iv_ruleExpressionRel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionRel"


    // $ANTLR start "ruleExpressionRel"
    // InternalMyCsv.g:2179:1: ruleExpressionRel returns [EObject current=null] : ( ( (lv_field_0_0= ruleField ) ) ( (lv_op_1_0= ruleBinOpRel ) ) ( (lv_val_2_0= ruleValue ) ) ) ;
    public final EObject ruleExpressionRel() throws RecognitionException {
        EObject current = null;

        EObject lv_field_0_0 = null;

        Enumerator lv_op_1_0 = null;

        EObject lv_val_2_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2185:2: ( ( ( (lv_field_0_0= ruleField ) ) ( (lv_op_1_0= ruleBinOpRel ) ) ( (lv_val_2_0= ruleValue ) ) ) )
            // InternalMyCsv.g:2186:2: ( ( (lv_field_0_0= ruleField ) ) ( (lv_op_1_0= ruleBinOpRel ) ) ( (lv_val_2_0= ruleValue ) ) )
            {
            // InternalMyCsv.g:2186:2: ( ( (lv_field_0_0= ruleField ) ) ( (lv_op_1_0= ruleBinOpRel ) ) ( (lv_val_2_0= ruleValue ) ) )
            // InternalMyCsv.g:2187:3: ( (lv_field_0_0= ruleField ) ) ( (lv_op_1_0= ruleBinOpRel ) ) ( (lv_val_2_0= ruleValue ) )
            {
            // InternalMyCsv.g:2187:3: ( (lv_field_0_0= ruleField ) )
            // InternalMyCsv.g:2188:4: (lv_field_0_0= ruleField )
            {
            // InternalMyCsv.g:2188:4: (lv_field_0_0= ruleField )
            // InternalMyCsv.g:2189:5: lv_field_0_0= ruleField
            {

            					newCompositeNode(grammarAccess.getExpressionRelAccess().getFieldFieldParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_34);
            lv_field_0_0=ruleField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpressionRelRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_0_0,
            						"org.xtext.MyCsv.Field");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:2206:3: ( (lv_op_1_0= ruleBinOpRel ) )
            // InternalMyCsv.g:2207:4: (lv_op_1_0= ruleBinOpRel )
            {
            // InternalMyCsv.g:2207:4: (lv_op_1_0= ruleBinOpRel )
            // InternalMyCsv.g:2208:5: lv_op_1_0= ruleBinOpRel
            {

            					newCompositeNode(grammarAccess.getExpressionRelAccess().getOpBinOpRelEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_op_1_0=ruleBinOpRel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpressionRelRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_1_0,
            						"org.xtext.MyCsv.BinOpRel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:2225:3: ( (lv_val_2_0= ruleValue ) )
            // InternalMyCsv.g:2226:4: (lv_val_2_0= ruleValue )
            {
            // InternalMyCsv.g:2226:4: (lv_val_2_0= ruleValue )
            // InternalMyCsv.g:2227:5: lv_val_2_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getExpressionRelAccess().getValValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_val_2_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpressionRelRule());
            					}
            					set(
            						current,
            						"val",
            						lv_val_2_0,
            						"org.xtext.MyCsv.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionRel"


    // $ANTLR start "entryRuleExpressionCalcul"
    // InternalMyCsv.g:2248:1: entryRuleExpressionCalcul returns [EObject current=null] : iv_ruleExpressionCalcul= ruleExpressionCalcul EOF ;
    public final EObject entryRuleExpressionCalcul() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionCalcul = null;


        try {
            // InternalMyCsv.g:2248:57: (iv_ruleExpressionCalcul= ruleExpressionCalcul EOF )
            // InternalMyCsv.g:2249:2: iv_ruleExpressionCalcul= ruleExpressionCalcul EOF
            {
             newCompositeNode(grammarAccess.getExpressionCalculRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionCalcul=ruleExpressionCalcul();

            state._fsp--;

             current =iv_ruleExpressionCalcul; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionCalcul"


    // $ANTLR start "ruleExpressionCalcul"
    // InternalMyCsv.g:2255:1: ruleExpressionCalcul returns [EObject current=null] : ( (lv_expr_0_0= ruleAdditiveExpression ) ) ;
    public final EObject ruleExpressionCalcul() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2261:2: ( ( (lv_expr_0_0= ruleAdditiveExpression ) ) )
            // InternalMyCsv.g:2262:2: ( (lv_expr_0_0= ruleAdditiveExpression ) )
            {
            // InternalMyCsv.g:2262:2: ( (lv_expr_0_0= ruleAdditiveExpression ) )
            // InternalMyCsv.g:2263:3: (lv_expr_0_0= ruleAdditiveExpression )
            {
            // InternalMyCsv.g:2263:3: (lv_expr_0_0= ruleAdditiveExpression )
            // InternalMyCsv.g:2264:4: lv_expr_0_0= ruleAdditiveExpression
            {

            				newCompositeNode(grammarAccess.getExpressionCalculAccess().getExprAdditiveExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_expr_0_0=ruleAdditiveExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getExpressionCalculRule());
            				}
            				set(
            					current,
            					"expr",
            					lv_expr_0_0,
            					"org.xtext.MyCsv.AdditiveExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionCalcul"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalMyCsv.g:2284:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalMyCsv.g:2284:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalMyCsv.g:2285:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalMyCsv.g:2291:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleMultiplicativeExpression ) ) ( (lv_rhs_1_0= ruleAdditiveExpressionRhs ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2297:2: ( ( ( (lv_lhs_0_0= ruleMultiplicativeExpression ) ) ( (lv_rhs_1_0= ruleAdditiveExpressionRhs ) )* ) )
            // InternalMyCsv.g:2298:2: ( ( (lv_lhs_0_0= ruleMultiplicativeExpression ) ) ( (lv_rhs_1_0= ruleAdditiveExpressionRhs ) )* )
            {
            // InternalMyCsv.g:2298:2: ( ( (lv_lhs_0_0= ruleMultiplicativeExpression ) ) ( (lv_rhs_1_0= ruleAdditiveExpressionRhs ) )* )
            // InternalMyCsv.g:2299:3: ( (lv_lhs_0_0= ruleMultiplicativeExpression ) ) ( (lv_rhs_1_0= ruleAdditiveExpressionRhs ) )*
            {
            // InternalMyCsv.g:2299:3: ( (lv_lhs_0_0= ruleMultiplicativeExpression ) )
            // InternalMyCsv.g:2300:4: (lv_lhs_0_0= ruleMultiplicativeExpression )
            {
            // InternalMyCsv.g:2300:4: (lv_lhs_0_0= ruleMultiplicativeExpression )
            // InternalMyCsv.g:2301:5: lv_lhs_0_0= ruleMultiplicativeExpression
            {

            					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLhsMultiplicativeExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_35);
            lv_lhs_0_0=ruleMultiplicativeExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_0_0,
            						"org.xtext.MyCsv.MultiplicativeExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:2318:3: ( (lv_rhs_1_0= ruleAdditiveExpressionRhs ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==42||LA25_0==55) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalMyCsv.g:2319:4: (lv_rhs_1_0= ruleAdditiveExpressionRhs )
            	    {
            	    // InternalMyCsv.g:2319:4: (lv_rhs_1_0= ruleAdditiveExpressionRhs )
            	    // InternalMyCsv.g:2320:5: lv_rhs_1_0= ruleAdditiveExpressionRhs
            	    {

            	    					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRhsAdditiveExpressionRhsParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_35);
            	    lv_rhs_1_0=ruleAdditiveExpressionRhs();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rhs",
            	    						lv_rhs_1_0,
            	    						"org.xtext.MyCsv.AdditiveExpressionRhs");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionRhs"
    // InternalMyCsv.g:2341:1: entryRuleAdditiveExpressionRhs returns [EObject current=null] : iv_ruleAdditiveExpressionRhs= ruleAdditiveExpressionRhs EOF ;
    public final EObject entryRuleAdditiveExpressionRhs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionRhs = null;


        try {
            // InternalMyCsv.g:2341:62: (iv_ruleAdditiveExpressionRhs= ruleAdditiveExpressionRhs EOF )
            // InternalMyCsv.g:2342:2: iv_ruleAdditiveExpressionRhs= ruleAdditiveExpressionRhs EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRhsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpressionRhs=ruleAdditiveExpressionRhs();

            state._fsp--;

             current =iv_ruleAdditiveExpressionRhs; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpressionRhs"


    // $ANTLR start "ruleAdditiveExpressionRhs"
    // InternalMyCsv.g:2348:1: ruleAdditiveExpressionRhs returns [EObject current=null] : ( ( (lv_op_0_0= ruleBinOpAdd ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionRhs() throws RecognitionException {
        EObject current = null;

        Enumerator lv_op_0_0 = null;

        EObject lv_rhs_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2354:2: ( ( ( (lv_op_0_0= ruleBinOpAdd ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalMyCsv.g:2355:2: ( ( (lv_op_0_0= ruleBinOpAdd ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalMyCsv.g:2355:2: ( ( (lv_op_0_0= ruleBinOpAdd ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpression ) ) )
            // InternalMyCsv.g:2356:3: ( (lv_op_0_0= ruleBinOpAdd ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalMyCsv.g:2356:3: ( (lv_op_0_0= ruleBinOpAdd ) )
            // InternalMyCsv.g:2357:4: (lv_op_0_0= ruleBinOpAdd )
            {
            // InternalMyCsv.g:2357:4: (lv_op_0_0= ruleBinOpAdd )
            // InternalMyCsv.g:2358:5: lv_op_0_0= ruleBinOpAdd
            {

            					newCompositeNode(grammarAccess.getAdditiveExpressionRhsAccess().getOpBinOpAddEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_36);
            lv_op_0_0=ruleBinOpAdd();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdditiveExpressionRhsRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_0_0,
            						"org.xtext.MyCsv.BinOpAdd");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:2375:3: ( (lv_rhs_1_0= ruleMultiplicativeExpression ) )
            // InternalMyCsv.g:2376:4: (lv_rhs_1_0= ruleMultiplicativeExpression )
            {
            // InternalMyCsv.g:2376:4: (lv_rhs_1_0= ruleMultiplicativeExpression )
            // InternalMyCsv.g:2377:5: lv_rhs_1_0= ruleMultiplicativeExpression
            {

            					newCompositeNode(grammarAccess.getAdditiveExpressionRhsAccess().getRhsMultiplicativeExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_rhs_1_0=ruleMultiplicativeExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdditiveExpressionRhsRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_1_0,
            						"org.xtext.MyCsv.MultiplicativeExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpressionRhs"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalMyCsv.g:2398:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalMyCsv.g:2398:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalMyCsv.g:2399:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalMyCsv.g:2405:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleUnaryExpression ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpressionRhs ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2411:2: ( ( ( (lv_lhs_0_0= ruleUnaryExpression ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpressionRhs ) )* ) )
            // InternalMyCsv.g:2412:2: ( ( (lv_lhs_0_0= ruleUnaryExpression ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpressionRhs ) )* )
            {
            // InternalMyCsv.g:2412:2: ( ( (lv_lhs_0_0= ruleUnaryExpression ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpressionRhs ) )* )
            // InternalMyCsv.g:2413:3: ( (lv_lhs_0_0= ruleUnaryExpression ) ) ( (lv_rhs_1_0= ruleMultiplicativeExpressionRhs ) )*
            {
            // InternalMyCsv.g:2413:3: ( (lv_lhs_0_0= ruleUnaryExpression ) )
            // InternalMyCsv.g:2414:4: (lv_lhs_0_0= ruleUnaryExpression )
            {
            // InternalMyCsv.g:2414:4: (lv_lhs_0_0= ruleUnaryExpression )
            // InternalMyCsv.g:2415:5: lv_lhs_0_0= ruleUnaryExpression
            {

            					newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLhsUnaryExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_37);
            lv_lhs_0_0=ruleUnaryExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_0_0,
            						"org.xtext.MyCsv.UnaryExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:2432:3: ( (lv_rhs_1_0= ruleMultiplicativeExpressionRhs ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=56 && LA26_0<=57)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalMyCsv.g:2433:4: (lv_rhs_1_0= ruleMultiplicativeExpressionRhs )
            	    {
            	    // InternalMyCsv.g:2433:4: (lv_rhs_1_0= ruleMultiplicativeExpressionRhs )
            	    // InternalMyCsv.g:2434:5: lv_rhs_1_0= ruleMultiplicativeExpressionRhs
            	    {

            	    					newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRhsMultiplicativeExpressionRhsParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_37);
            	    lv_rhs_1_0=ruleMultiplicativeExpressionRhs();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rhs",
            	    						lv_rhs_1_0,
            	    						"org.xtext.MyCsv.MultiplicativeExpressionRhs");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleMultiplicativeExpressionRhs"
    // InternalMyCsv.g:2455:1: entryRuleMultiplicativeExpressionRhs returns [EObject current=null] : iv_ruleMultiplicativeExpressionRhs= ruleMultiplicativeExpressionRhs EOF ;
    public final EObject entryRuleMultiplicativeExpressionRhs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionRhs = null;


        try {
            // InternalMyCsv.g:2455:68: (iv_ruleMultiplicativeExpressionRhs= ruleMultiplicativeExpressionRhs EOF )
            // InternalMyCsv.g:2456:2: iv_ruleMultiplicativeExpressionRhs= ruleMultiplicativeExpressionRhs EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRhsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpressionRhs=ruleMultiplicativeExpressionRhs();

            state._fsp--;

             current =iv_ruleMultiplicativeExpressionRhs; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpressionRhs"


    // $ANTLR start "ruleMultiplicativeExpressionRhs"
    // InternalMyCsv.g:2462:1: ruleMultiplicativeExpressionRhs returns [EObject current=null] : ( ( (lv_op_0_0= ruleBinOpMult ) ) ( (lv_rhs_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionRhs() throws RecognitionException {
        EObject current = null;

        Enumerator lv_op_0_0 = null;

        EObject lv_rhs_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2468:2: ( ( ( (lv_op_0_0= ruleBinOpMult ) ) ( (lv_rhs_1_0= ruleUnaryExpression ) ) ) )
            // InternalMyCsv.g:2469:2: ( ( (lv_op_0_0= ruleBinOpMult ) ) ( (lv_rhs_1_0= ruleUnaryExpression ) ) )
            {
            // InternalMyCsv.g:2469:2: ( ( (lv_op_0_0= ruleBinOpMult ) ) ( (lv_rhs_1_0= ruleUnaryExpression ) ) )
            // InternalMyCsv.g:2470:3: ( (lv_op_0_0= ruleBinOpMult ) ) ( (lv_rhs_1_0= ruleUnaryExpression ) )
            {
            // InternalMyCsv.g:2470:3: ( (lv_op_0_0= ruleBinOpMult ) )
            // InternalMyCsv.g:2471:4: (lv_op_0_0= ruleBinOpMult )
            {
            // InternalMyCsv.g:2471:4: (lv_op_0_0= ruleBinOpMult )
            // InternalMyCsv.g:2472:5: lv_op_0_0= ruleBinOpMult
            {

            					newCompositeNode(grammarAccess.getMultiplicativeExpressionRhsAccess().getOpBinOpMultEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_36);
            lv_op_0_0=ruleBinOpMult();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRhsRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_0_0,
            						"org.xtext.MyCsv.BinOpMult");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:2489:3: ( (lv_rhs_1_0= ruleUnaryExpression ) )
            // InternalMyCsv.g:2490:4: (lv_rhs_1_0= ruleUnaryExpression )
            {
            // InternalMyCsv.g:2490:4: (lv_rhs_1_0= ruleUnaryExpression )
            // InternalMyCsv.g:2491:5: lv_rhs_1_0= ruleUnaryExpression
            {

            					newCompositeNode(grammarAccess.getMultiplicativeExpressionRhsAccess().getRhsUnaryExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_rhs_1_0=ruleUnaryExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRhsRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_1_0,
            						"org.xtext.MyCsv.UnaryExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpressionRhs"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalMyCsv.g:2512:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalMyCsv.g:2512:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalMyCsv.g:2513:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalMyCsv.g:2519:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= '-' ) )? ( (lv_expr_1_0= ruleExpressionCalculPrimary ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2525:2: ( ( ( (lv_op_0_0= '-' ) )? ( (lv_expr_1_0= ruleExpressionCalculPrimary ) ) ) )
            // InternalMyCsv.g:2526:2: ( ( (lv_op_0_0= '-' ) )? ( (lv_expr_1_0= ruleExpressionCalculPrimary ) ) )
            {
            // InternalMyCsv.g:2526:2: ( ( (lv_op_0_0= '-' ) )? ( (lv_expr_1_0= ruleExpressionCalculPrimary ) ) )
            // InternalMyCsv.g:2527:3: ( (lv_op_0_0= '-' ) )? ( (lv_expr_1_0= ruleExpressionCalculPrimary ) )
            {
            // InternalMyCsv.g:2527:3: ( (lv_op_0_0= '-' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==42) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMyCsv.g:2528:4: (lv_op_0_0= '-' )
                    {
                    // InternalMyCsv.g:2528:4: (lv_op_0_0= '-' )
                    // InternalMyCsv.g:2529:5: lv_op_0_0= '-'
                    {
                    lv_op_0_0=(Token)match(input,42,FOLLOW_36); 

                    					newLeafNode(lv_op_0_0, grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryExpressionRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalMyCsv.g:2541:3: ( (lv_expr_1_0= ruleExpressionCalculPrimary ) )
            // InternalMyCsv.g:2542:4: (lv_expr_1_0= ruleExpressionCalculPrimary )
            {
            // InternalMyCsv.g:2542:4: (lv_expr_1_0= ruleExpressionCalculPrimary )
            // InternalMyCsv.g:2543:5: lv_expr_1_0= ruleExpressionCalculPrimary
            {

            					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprExpressionCalculPrimaryParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_expr_1_0=ruleExpressionCalculPrimary();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
            					}
            					set(
            						current,
            						"expr",
            						lv_expr_1_0,
            						"org.xtext.MyCsv.ExpressionCalculPrimary");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleExpressionCalculPrimary"
    // InternalMyCsv.g:2564:1: entryRuleExpressionCalculPrimary returns [EObject current=null] : iv_ruleExpressionCalculPrimary= ruleExpressionCalculPrimary EOF ;
    public final EObject entryRuleExpressionCalculPrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionCalculPrimary = null;


        try {
            // InternalMyCsv.g:2564:64: (iv_ruleExpressionCalculPrimary= ruleExpressionCalculPrimary EOF )
            // InternalMyCsv.g:2565:2: iv_ruleExpressionCalculPrimary= ruleExpressionCalculPrimary EOF
            {
             newCompositeNode(grammarAccess.getExpressionCalculPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionCalculPrimary=ruleExpressionCalculPrimary();

            state._fsp--;

             current =iv_ruleExpressionCalculPrimary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionCalculPrimary"


    // $ANTLR start "ruleExpressionCalculPrimary"
    // InternalMyCsv.g:2571:1: ruleExpressionCalculPrimary returns [EObject current=null] : ( ( () ruleNbField ) | this_AggregatExpression_2= ruleAggregatExpression | this_LitteralInt_3= ruleLitteralInt | this_LitteralFloat_4= ruleLitteralFloat | this_NestedExpressionCalcul_5= ruleNestedExpressionCalcul ) ;
    public final EObject ruleExpressionCalculPrimary() throws RecognitionException {
        EObject current = null;

        EObject this_AggregatExpression_2 = null;

        EObject this_LitteralInt_3 = null;

        EObject this_LitteralFloat_4 = null;

        EObject this_NestedExpressionCalcul_5 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2577:2: ( ( ( () ruleNbField ) | this_AggregatExpression_2= ruleAggregatExpression | this_LitteralInt_3= ruleLitteralInt | this_LitteralFloat_4= ruleLitteralFloat | this_NestedExpressionCalcul_5= ruleNestedExpressionCalcul ) )
            // InternalMyCsv.g:2578:2: ( ( () ruleNbField ) | this_AggregatExpression_2= ruleAggregatExpression | this_LitteralInt_3= ruleLitteralInt | this_LitteralFloat_4= ruleLitteralFloat | this_NestedExpressionCalcul_5= ruleNestedExpressionCalcul )
            {
            // InternalMyCsv.g:2578:2: ( ( () ruleNbField ) | this_AggregatExpression_2= ruleAggregatExpression | this_LitteralInt_3= ruleLitteralInt | this_LitteralFloat_4= ruleLitteralFloat | this_NestedExpressionCalcul_5= ruleNestedExpressionCalcul )
            int alt28=5;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt28=1;
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
                {
                alt28=2;
                }
                break;
            case RULE_INT:
                {
                int LA28_3 = input.LA(2);

                if ( (LA28_3==EOF||LA28_3==13||(LA28_3>=15 && LA28_3<=17)||(LA28_3>=22 && LA28_3<=26)||LA28_3==29||(LA28_3>=31 && LA28_3<=32)||LA28_3==34||LA28_3==37||(LA28_3>=39 && LA28_3<=40)||LA28_3==42||(LA28_3>=55 && LA28_3<=57)) ) {
                    alt28=3;
                }
                else if ( (LA28_3==44) ) {
                    alt28=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;
                }
                }
                break;
            case 11:
                {
                alt28=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalMyCsv.g:2579:3: ( () ruleNbField )
                    {
                    // InternalMyCsv.g:2579:3: ( () ruleNbField )
                    // InternalMyCsv.g:2580:4: () ruleNbField
                    {
                    // InternalMyCsv.g:2580:4: ()
                    // InternalMyCsv.g:2581:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getExpressionCalculPrimaryAccess().getNbFieldAction_0_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getExpressionCalculPrimaryAccess().getNbFieldParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleNbField();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:2596:3: this_AggregatExpression_2= ruleAggregatExpression
                    {

                    			newCompositeNode(grammarAccess.getExpressionCalculPrimaryAccess().getAggregatExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AggregatExpression_2=ruleAggregatExpression();

                    state._fsp--;


                    			current = this_AggregatExpression_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:2605:3: this_LitteralInt_3= ruleLitteralInt
                    {

                    			newCompositeNode(grammarAccess.getExpressionCalculPrimaryAccess().getLitteralIntParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_LitteralInt_3=ruleLitteralInt();

                    state._fsp--;


                    			current = this_LitteralInt_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:2614:3: this_LitteralFloat_4= ruleLitteralFloat
                    {

                    			newCompositeNode(grammarAccess.getExpressionCalculPrimaryAccess().getLitteralFloatParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_LitteralFloat_4=ruleLitteralFloat();

                    state._fsp--;


                    			current = this_LitteralFloat_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:2623:3: this_NestedExpressionCalcul_5= ruleNestedExpressionCalcul
                    {

                    			newCompositeNode(grammarAccess.getExpressionCalculPrimaryAccess().getNestedExpressionCalculParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_NestedExpressionCalcul_5=ruleNestedExpressionCalcul();

                    state._fsp--;


                    			current = this_NestedExpressionCalcul_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionCalculPrimary"


    // $ANTLR start "entryRuleAggregatExpression"
    // InternalMyCsv.g:2635:1: entryRuleAggregatExpression returns [EObject current=null] : iv_ruleAggregatExpression= ruleAggregatExpression EOF ;
    public final EObject entryRuleAggregatExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregatExpression = null;


        try {
            // InternalMyCsv.g:2635:59: (iv_ruleAggregatExpression= ruleAggregatExpression EOF )
            // InternalMyCsv.g:2636:2: iv_ruleAggregatExpression= ruleAggregatExpression EOF
            {
             newCompositeNode(grammarAccess.getAggregatExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAggregatExpression=ruleAggregatExpression();

            state._fsp--;

             current =iv_ruleAggregatExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAggregatExpression"


    // $ANTLR start "ruleAggregatExpression"
    // InternalMyCsv.g:2642:1: ruleAggregatExpression returns [EObject current=null] : ( ( (lv_aggregatOp_0_0= ruleAggregat ) ) ( (lv_arg_1_0= ruleField ) ) ) ;
    public final EObject ruleAggregatExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_aggregatOp_0_0 = null;

        EObject lv_arg_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2648:2: ( ( ( (lv_aggregatOp_0_0= ruleAggregat ) ) ( (lv_arg_1_0= ruleField ) ) ) )
            // InternalMyCsv.g:2649:2: ( ( (lv_aggregatOp_0_0= ruleAggregat ) ) ( (lv_arg_1_0= ruleField ) ) )
            {
            // InternalMyCsv.g:2649:2: ( ( (lv_aggregatOp_0_0= ruleAggregat ) ) ( (lv_arg_1_0= ruleField ) ) )
            // InternalMyCsv.g:2650:3: ( (lv_aggregatOp_0_0= ruleAggregat ) ) ( (lv_arg_1_0= ruleField ) )
            {
            // InternalMyCsv.g:2650:3: ( (lv_aggregatOp_0_0= ruleAggregat ) )
            // InternalMyCsv.g:2651:4: (lv_aggregatOp_0_0= ruleAggregat )
            {
            // InternalMyCsv.g:2651:4: (lv_aggregatOp_0_0= ruleAggregat )
            // InternalMyCsv.g:2652:5: lv_aggregatOp_0_0= ruleAggregat
            {

            					newCompositeNode(grammarAccess.getAggregatExpressionAccess().getAggregatOpAggregatEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_30);
            lv_aggregatOp_0_0=ruleAggregat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAggregatExpressionRule());
            					}
            					set(
            						current,
            						"aggregatOp",
            						lv_aggregatOp_0_0,
            						"org.xtext.MyCsv.Aggregat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:2669:3: ( (lv_arg_1_0= ruleField ) )
            // InternalMyCsv.g:2670:4: (lv_arg_1_0= ruleField )
            {
            // InternalMyCsv.g:2670:4: (lv_arg_1_0= ruleField )
            // InternalMyCsv.g:2671:5: lv_arg_1_0= ruleField
            {

            					newCompositeNode(grammarAccess.getAggregatExpressionAccess().getArgFieldParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_arg_1_0=ruleField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAggregatExpressionRule());
            					}
            					set(
            						current,
            						"arg",
            						lv_arg_1_0,
            						"org.xtext.MyCsv.Field");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAggregatExpression"


    // $ANTLR start "entryRuleLitteralInt"
    // InternalMyCsv.g:2692:1: entryRuleLitteralInt returns [EObject current=null] : iv_ruleLitteralInt= ruleLitteralInt EOF ;
    public final EObject entryRuleLitteralInt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLitteralInt = null;


        try {
            // InternalMyCsv.g:2692:52: (iv_ruleLitteralInt= ruleLitteralInt EOF )
            // InternalMyCsv.g:2693:2: iv_ruleLitteralInt= ruleLitteralInt EOF
            {
             newCompositeNode(grammarAccess.getLitteralIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLitteralInt=ruleLitteralInt();

            state._fsp--;

             current =iv_ruleLitteralInt; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLitteralInt"


    // $ANTLR start "ruleLitteralInt"
    // InternalMyCsv.g:2699:1: ruleLitteralInt returns [EObject current=null] : ( (lv_val_0_0= RULE_INT ) ) ;
    public final EObject ruleLitteralInt() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalMyCsv.g:2705:2: ( ( (lv_val_0_0= RULE_INT ) ) )
            // InternalMyCsv.g:2706:2: ( (lv_val_0_0= RULE_INT ) )
            {
            // InternalMyCsv.g:2706:2: ( (lv_val_0_0= RULE_INT ) )
            // InternalMyCsv.g:2707:3: (lv_val_0_0= RULE_INT )
            {
            // InternalMyCsv.g:2707:3: (lv_val_0_0= RULE_INT )
            // InternalMyCsv.g:2708:4: lv_val_0_0= RULE_INT
            {
            lv_val_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_val_0_0, grammarAccess.getLitteralIntAccess().getValINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getLitteralIntRule());
            				}
            				setWithLastConsumed(
            					current,
            					"val",
            					lv_val_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLitteralInt"


    // $ANTLR start "entryRuleLitteralFloat"
    // InternalMyCsv.g:2727:1: entryRuleLitteralFloat returns [EObject current=null] : iv_ruleLitteralFloat= ruleLitteralFloat EOF ;
    public final EObject entryRuleLitteralFloat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLitteralFloat = null;


        try {
            // InternalMyCsv.g:2727:54: (iv_ruleLitteralFloat= ruleLitteralFloat EOF )
            // InternalMyCsv.g:2728:2: iv_ruleLitteralFloat= ruleLitteralFloat EOF
            {
             newCompositeNode(grammarAccess.getLitteralFloatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLitteralFloat=ruleLitteralFloat();

            state._fsp--;

             current =iv_ruleLitteralFloat; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLitteralFloat"


    // $ANTLR start "ruleLitteralFloat"
    // InternalMyCsv.g:2734:1: ruleLitteralFloat returns [EObject current=null] : ( (lv_val_0_0= ruleFLOAT ) ) ;
    public final EObject ruleLitteralFloat() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_val_0_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2740:2: ( ( (lv_val_0_0= ruleFLOAT ) ) )
            // InternalMyCsv.g:2741:2: ( (lv_val_0_0= ruleFLOAT ) )
            {
            // InternalMyCsv.g:2741:2: ( (lv_val_0_0= ruleFLOAT ) )
            // InternalMyCsv.g:2742:3: (lv_val_0_0= ruleFLOAT )
            {
            // InternalMyCsv.g:2742:3: (lv_val_0_0= ruleFLOAT )
            // InternalMyCsv.g:2743:4: lv_val_0_0= ruleFLOAT
            {

            				newCompositeNode(grammarAccess.getLitteralFloatAccess().getValFLOATParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_val_0_0=ruleFLOAT();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getLitteralFloatRule());
            				}
            				set(
            					current,
            					"val",
            					lv_val_0_0,
            					"org.xtext.MyCsv.FLOAT");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLitteralFloat"


    // $ANTLR start "entryRuleLitteralString"
    // InternalMyCsv.g:2763:1: entryRuleLitteralString returns [EObject current=null] : iv_ruleLitteralString= ruleLitteralString EOF ;
    public final EObject entryRuleLitteralString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLitteralString = null;


        try {
            // InternalMyCsv.g:2763:55: (iv_ruleLitteralString= ruleLitteralString EOF )
            // InternalMyCsv.g:2764:2: iv_ruleLitteralString= ruleLitteralString EOF
            {
             newCompositeNode(grammarAccess.getLitteralStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLitteralString=ruleLitteralString();

            state._fsp--;

             current =iv_ruleLitteralString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLitteralString"


    // $ANTLR start "ruleLitteralString"
    // InternalMyCsv.g:2770:1: ruleLitteralString returns [EObject current=null] : ( (lv_val_0_0= RULE_STRING ) ) ;
    public final EObject ruleLitteralString() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalMyCsv.g:2776:2: ( ( (lv_val_0_0= RULE_STRING ) ) )
            // InternalMyCsv.g:2777:2: ( (lv_val_0_0= RULE_STRING ) )
            {
            // InternalMyCsv.g:2777:2: ( (lv_val_0_0= RULE_STRING ) )
            // InternalMyCsv.g:2778:3: (lv_val_0_0= RULE_STRING )
            {
            // InternalMyCsv.g:2778:3: (lv_val_0_0= RULE_STRING )
            // InternalMyCsv.g:2779:4: lv_val_0_0= RULE_STRING
            {
            lv_val_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_val_0_0, grammarAccess.getLitteralStringAccess().getValSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getLitteralStringRule());
            				}
            				setWithLastConsumed(
            					current,
            					"val",
            					lv_val_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLitteralString"


    // $ANTLR start "entryRuleNestedExpressionCalcul"
    // InternalMyCsv.g:2798:1: entryRuleNestedExpressionCalcul returns [EObject current=null] : iv_ruleNestedExpressionCalcul= ruleNestedExpressionCalcul EOF ;
    public final EObject entryRuleNestedExpressionCalcul() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpressionCalcul = null;


        try {
            // InternalMyCsv.g:2798:63: (iv_ruleNestedExpressionCalcul= ruleNestedExpressionCalcul EOF )
            // InternalMyCsv.g:2799:2: iv_ruleNestedExpressionCalcul= ruleNestedExpressionCalcul EOF
            {
             newCompositeNode(grammarAccess.getNestedExpressionCalculRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNestedExpressionCalcul=ruleNestedExpressionCalcul();

            state._fsp--;

             current =iv_ruleNestedExpressionCalcul; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNestedExpressionCalcul"


    // $ANTLR start "ruleNestedExpressionCalcul"
    // InternalMyCsv.g:2805:1: ruleNestedExpressionCalcul returns [EObject current=null] : (otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionCalcul ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpressionCalcul() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:2811:2: ( (otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionCalcul ) ) otherlv_2= ')' ) )
            // InternalMyCsv.g:2812:2: (otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionCalcul ) ) otherlv_2= ')' )
            {
            // InternalMyCsv.g:2812:2: (otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionCalcul ) ) otherlv_2= ')' )
            // InternalMyCsv.g:2813:3: otherlv_0= '(' ( (lv_expr_1_0= ruleExpressionCalcul ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_36); 

            			newLeafNode(otherlv_0, grammarAccess.getNestedExpressionCalculAccess().getLeftParenthesisKeyword_0());
            		
            // InternalMyCsv.g:2817:3: ( (lv_expr_1_0= ruleExpressionCalcul ) )
            // InternalMyCsv.g:2818:4: (lv_expr_1_0= ruleExpressionCalcul )
            {
            // InternalMyCsv.g:2818:4: (lv_expr_1_0= ruleExpressionCalcul )
            // InternalMyCsv.g:2819:5: lv_expr_1_0= ruleExpressionCalcul
            {

            					newCompositeNode(grammarAccess.getNestedExpressionCalculAccess().getExprExpressionCalculParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
            lv_expr_1_0=ruleExpressionCalcul();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNestedExpressionCalculRule());
            					}
            					set(
            						current,
            						"expr",
            						lv_expr_1_0,
            						"org.xtext.MyCsv.ExpressionCalcul");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getNestedExpressionCalculAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedExpressionCalcul"


    // $ANTLR start "entryRuleNbField"
    // InternalMyCsv.g:2844:1: entryRuleNbField returns [String current=null] : iv_ruleNbField= ruleNbField EOF ;
    public final String entryRuleNbField() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNbField = null;


        try {
            // InternalMyCsv.g:2844:47: (iv_ruleNbField= ruleNbField EOF )
            // InternalMyCsv.g:2845:2: iv_ruleNbField= ruleNbField EOF
            {
             newCompositeNode(grammarAccess.getNbFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNbField=ruleNbField();

            state._fsp--;

             current =iv_ruleNbField.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNbField"


    // $ANTLR start "ruleNbField"
    // InternalMyCsv.g:2851:1: ruleNbField returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'NbField' ;
    public final AntlrDatatypeRuleToken ruleNbField() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:2857:2: (kw= 'NbField' )
            // InternalMyCsv.g:2858:2: kw= 'NbField'
            {
            kw=(Token)match(input,43,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getNbFieldAccess().getNbFieldKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNbField"


    // $ANTLR start "entryRuleFLOAT"
    // InternalMyCsv.g:2866:1: entryRuleFLOAT returns [String current=null] : iv_ruleFLOAT= ruleFLOAT EOF ;
    public final String entryRuleFLOAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFLOAT = null;


        try {
            // InternalMyCsv.g:2866:45: (iv_ruleFLOAT= ruleFLOAT EOF )
            // InternalMyCsv.g:2867:2: iv_ruleFLOAT= ruleFLOAT EOF
            {
             newCompositeNode(grammarAccess.getFLOATRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFLOAT=ruleFLOAT();

            state._fsp--;

             current =iv_ruleFLOAT.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFLOAT"


    // $ANTLR start "ruleFLOAT"
    // InternalMyCsv.g:2873:1: ruleFLOAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleFLOAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalMyCsv.g:2879:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalMyCsv.g:2880:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalMyCsv.g:2880:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalMyCsv.g:2881:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_38); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getFLOATAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,44,FOLLOW_6); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getFLOATAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getFLOATAccess().getINTTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFLOAT"


    // $ANTLR start "ruleBinOpRel"
    // InternalMyCsv.g:2904:1: ruleBinOpRel returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) ;
    public final Enumerator ruleBinOpRel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalMyCsv.g:2910:2: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) )
            // InternalMyCsv.g:2911:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            {
            // InternalMyCsv.g:2911:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            int alt29=6;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt29=1;
                }
                break;
            case 46:
                {
                alt29=2;
                }
                break;
            case 47:
                {
                alt29=3;
                }
                break;
            case 48:
                {
                alt29=4;
                }
                break;
            case 49:
                {
                alt29=5;
                }
                break;
            case 50:
                {
                alt29=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalMyCsv.g:2912:3: (enumLiteral_0= '>' )
                    {
                    // InternalMyCsv.g:2912:3: (enumLiteral_0= '>' )
                    // InternalMyCsv.g:2913:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getBinOpRelAccess().getGtEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBinOpRelAccess().getGtEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:2920:3: (enumLiteral_1= '<' )
                    {
                    // InternalMyCsv.g:2920:3: (enumLiteral_1= '<' )
                    // InternalMyCsv.g:2921:4: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getBinOpRelAccess().getLtEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBinOpRelAccess().getLtEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:2928:3: (enumLiteral_2= '>=' )
                    {
                    // InternalMyCsv.g:2928:3: (enumLiteral_2= '>=' )
                    // InternalMyCsv.g:2929:4: enumLiteral_2= '>='
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getBinOpRelAccess().getGeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBinOpRelAccess().getGeEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:2936:3: (enumLiteral_3= '<=' )
                    {
                    // InternalMyCsv.g:2936:3: (enumLiteral_3= '<=' )
                    // InternalMyCsv.g:2937:4: enumLiteral_3= '<='
                    {
                    enumLiteral_3=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getBinOpRelAccess().getLeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getBinOpRelAccess().getLeEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:2944:3: (enumLiteral_4= '==' )
                    {
                    // InternalMyCsv.g:2944:3: (enumLiteral_4= '==' )
                    // InternalMyCsv.g:2945:4: enumLiteral_4= '=='
                    {
                    enumLiteral_4=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getBinOpRelAccess().getEqEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getBinOpRelAccess().getEqEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMyCsv.g:2952:3: (enumLiteral_5= '!=' )
                    {
                    // InternalMyCsv.g:2952:3: (enumLiteral_5= '!=' )
                    // InternalMyCsv.g:2953:4: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getBinOpRelAccess().getNeqEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getBinOpRelAccess().getNeqEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinOpRel"


    // $ANTLR start "ruleAggregat"
    // InternalMyCsv.g:2963:1: ruleAggregat returns [Enumerator current=null] : ( (enumLiteral_0= 'Count' ) | (enumLiteral_1= 'Sum' ) | (enumLiteral_2= 'Product' ) | (enumLiteral_3= 'Mean' ) ) ;
    public final Enumerator ruleAggregat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMyCsv.g:2969:2: ( ( (enumLiteral_0= 'Count' ) | (enumLiteral_1= 'Sum' ) | (enumLiteral_2= 'Product' ) | (enumLiteral_3= 'Mean' ) ) )
            // InternalMyCsv.g:2970:2: ( (enumLiteral_0= 'Count' ) | (enumLiteral_1= 'Sum' ) | (enumLiteral_2= 'Product' ) | (enumLiteral_3= 'Mean' ) )
            {
            // InternalMyCsv.g:2970:2: ( (enumLiteral_0= 'Count' ) | (enumLiteral_1= 'Sum' ) | (enumLiteral_2= 'Product' ) | (enumLiteral_3= 'Mean' ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt30=1;
                }
                break;
            case 52:
                {
                alt30=2;
                }
                break;
            case 53:
                {
                alt30=3;
                }
                break;
            case 54:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalMyCsv.g:2971:3: (enumLiteral_0= 'Count' )
                    {
                    // InternalMyCsv.g:2971:3: (enumLiteral_0= 'Count' )
                    // InternalMyCsv.g:2972:4: enumLiteral_0= 'Count'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getAggregatAccess().getCountEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAggregatAccess().getCountEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:2979:3: (enumLiteral_1= 'Sum' )
                    {
                    // InternalMyCsv.g:2979:3: (enumLiteral_1= 'Sum' )
                    // InternalMyCsv.g:2980:4: enumLiteral_1= 'Sum'
                    {
                    enumLiteral_1=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getAggregatAccess().getSumEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAggregatAccess().getSumEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:2987:3: (enumLiteral_2= 'Product' )
                    {
                    // InternalMyCsv.g:2987:3: (enumLiteral_2= 'Product' )
                    // InternalMyCsv.g:2988:4: enumLiteral_2= 'Product'
                    {
                    enumLiteral_2=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getAggregatAccess().getProductEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAggregatAccess().getProductEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:2995:3: (enumLiteral_3= 'Mean' )
                    {
                    // InternalMyCsv.g:2995:3: (enumLiteral_3= 'Mean' )
                    // InternalMyCsv.g:2996:4: enumLiteral_3= 'Mean'
                    {
                    enumLiteral_3=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getAggregatAccess().getMeanEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getAggregatAccess().getMeanEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAggregat"


    // $ANTLR start "ruleBinOpAdd"
    // InternalMyCsv.g:3006:1: ruleBinOpAdd returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleBinOpAdd() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMyCsv.g:3012:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalMyCsv.g:3013:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalMyCsv.g:3013:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==55) ) {
                alt31=1;
            }
            else if ( (LA31_0==42) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalMyCsv.g:3014:3: (enumLiteral_0= '+' )
                    {
                    // InternalMyCsv.g:3014:3: (enumLiteral_0= '+' )
                    // InternalMyCsv.g:3015:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getBinOpAddAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBinOpAddAccess().getPlusEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:3022:3: (enumLiteral_1= '-' )
                    {
                    // InternalMyCsv.g:3022:3: (enumLiteral_1= '-' )
                    // InternalMyCsv.g:3023:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getBinOpAddAccess().getMinusEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBinOpAddAccess().getMinusEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinOpAdd"


    // $ANTLR start "ruleBinOpMult"
    // InternalMyCsv.g:3033:1: ruleBinOpMult returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) ) ;
    public final Enumerator ruleBinOpMult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMyCsv.g:3039:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) ) )
            // InternalMyCsv.g:3040:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) )
            {
            // InternalMyCsv.g:3040:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==56) ) {
                alt32=1;
            }
            else if ( (LA32_0==57) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalMyCsv.g:3041:3: (enumLiteral_0= '*' )
                    {
                    // InternalMyCsv.g:3041:3: (enumLiteral_0= '*' )
                    // InternalMyCsv.g:3042:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getBinOpMultAccess().getTimesEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBinOpMultAccess().getTimesEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:3049:3: (enumLiteral_1= '/' )
                    {
                    // InternalMyCsv.g:3049:3: (enumLiteral_1= '/' )
                    // InternalMyCsv.g:3050:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getBinOpMultAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBinOpMultAccess().getDivEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinOpMult"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000024A7C20002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00780C0000000830L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0007E20000000850L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00780C0000004830L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000218000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001A18000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000004000000040L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0007E20000000840L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0007E00000000040L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0080040000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00780C0000000810L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000100000000000L});

}