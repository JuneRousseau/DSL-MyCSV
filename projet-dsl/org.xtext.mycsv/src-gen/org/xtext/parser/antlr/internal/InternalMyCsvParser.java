package org.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Print'", "'Projection'", "'Select'", "'Modify'", "'Insert'", "'Delete'", "'ExportJson'", "'Store'", "'Load'", "'('", "')'", "'['", "']'", "'NbField'", "'+'", "'-'", "'='", "'<'", "'<='", "'Count'", "'Sum'", "'Not'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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
        	return "Programm";
       	}

       	@Override
       	protected MyCsvGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgramm"
    // InternalMyCsv.g:64:1: entryRuleProgramm returns [EObject current=null] : iv_ruleProgramm= ruleProgramm EOF ;
    public final EObject entryRuleProgramm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramm = null;


        try {
            // InternalMyCsv.g:64:49: (iv_ruleProgramm= ruleProgramm EOF )
            // InternalMyCsv.g:65:2: iv_ruleProgramm= ruleProgramm EOF
            {
             newCompositeNode(grammarAccess.getProgrammRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgramm=ruleProgramm();

            state._fsp--;

             current =iv_ruleProgramm; 
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
    // $ANTLR end "entryRuleProgramm"


    // $ANTLR start "ruleProgramm"
    // InternalMyCsv.g:71:1: ruleProgramm returns [EObject current=null] : ( (lv_stmts_0_0= ruleStatement ) )* ;
    public final EObject ruleProgramm() throws RecognitionException {
        EObject current = null;

        EObject lv_stmts_0_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:77:2: ( ( (lv_stmts_0_0= ruleStatement ) )* )
            // InternalMyCsv.g:78:2: ( (lv_stmts_0_0= ruleStatement ) )*
            {
            // InternalMyCsv.g:78:2: ( (lv_stmts_0_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=19)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyCsv.g:79:3: (lv_stmts_0_0= ruleStatement )
            	    {
            	    // InternalMyCsv.g:79:3: (lv_stmts_0_0= ruleStatement )
            	    // InternalMyCsv.g:80:4: lv_stmts_0_0= ruleStatement
            	    {

            	    				newCompositeNode(grammarAccess.getProgrammAccess().getStmtsStatementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_stmts_0_0=ruleStatement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getProgrammRule());
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
            	    break loop1;
                }
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
    // $ANTLR end "ruleProgramm"


    // $ANTLR start "entryRuleStatement"
    // InternalMyCsv.g:100:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalMyCsv.g:100:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalMyCsv.g:101:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalMyCsv.g:107:1: ruleStatement returns [EObject current=null] : ( ( (lv_prim_0_0= rulePrimitive ) ) ( (lv_args_1_0= ruleExpression ) )* ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_prim_0_0 = null;

        EObject lv_args_1_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:113:2: ( ( ( (lv_prim_0_0= rulePrimitive ) ) ( (lv_args_1_0= ruleExpression ) )* ) )
            // InternalMyCsv.g:114:2: ( ( (lv_prim_0_0= rulePrimitive ) ) ( (lv_args_1_0= ruleExpression ) )* )
            {
            // InternalMyCsv.g:114:2: ( ( (lv_prim_0_0= rulePrimitive ) ) ( (lv_args_1_0= ruleExpression ) )* )
            // InternalMyCsv.g:115:3: ( (lv_prim_0_0= rulePrimitive ) ) ( (lv_args_1_0= ruleExpression ) )*
            {
            // InternalMyCsv.g:115:3: ( (lv_prim_0_0= rulePrimitive ) )
            // InternalMyCsv.g:116:4: (lv_prim_0_0= rulePrimitive )
            {
            // InternalMyCsv.g:116:4: (lv_prim_0_0= rulePrimitive )
            // InternalMyCsv.g:117:5: lv_prim_0_0= rulePrimitive
            {

            					newCompositeNode(grammarAccess.getStatementAccess().getPrimPrimitiveParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_prim_0_0=rulePrimitive();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStatementRule());
            					}
            					add(
            						current,
            						"prim",
            						lv_prim_0_0,
            						"org.xtext.MyCsv.Primitive");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyCsv.g:134:3: ( (lv_args_1_0= ruleExpression ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)||LA2_0==20||LA2_0==22||LA2_0==24||LA2_0==26||(LA2_0>=30 && LA2_0<=32)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyCsv.g:135:4: (lv_args_1_0= ruleExpression )
            	    {
            	    // InternalMyCsv.g:135:4: (lv_args_1_0= ruleExpression )
            	    // InternalMyCsv.g:136:5: lv_args_1_0= ruleExpression
            	    {

            	    					newCompositeNode(grammarAccess.getStatementAccess().getArgsExpressionParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_args_1_0=ruleExpression();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"args",
            	    						lv_args_1_0,
            	    						"org.xtext.MyCsv.Expression");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRulePrimitive"
    // InternalMyCsv.g:157:1: entryRulePrimitive returns [String current=null] : iv_rulePrimitive= rulePrimitive EOF ;
    public final String entryRulePrimitive() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitive = null;


        try {
            // InternalMyCsv.g:157:49: (iv_rulePrimitive= rulePrimitive EOF )
            // InternalMyCsv.g:158:2: iv_rulePrimitive= rulePrimitive EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitive=rulePrimitive();

            state._fsp--;

             current =iv_rulePrimitive.getText(); 
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
    // $ANTLR end "entryRulePrimitive"


    // $ANTLR start "rulePrimitive"
    // InternalMyCsv.g:164:1: rulePrimitive returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Load_0= ruleLoad | this_Store_1= ruleStore | this_ExportJson_2= ruleExportJson | this_Delete_3= ruleDelete | this_Insert_4= ruleInsert | this_Modify_5= ruleModify | this_Select_6= ruleSelect | this_Project_7= ruleProject | this_Print_8= rulePrint ) ;
    public final AntlrDatatypeRuleToken rulePrimitive() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Load_0 = null;

        AntlrDatatypeRuleToken this_Store_1 = null;

        AntlrDatatypeRuleToken this_ExportJson_2 = null;

        AntlrDatatypeRuleToken this_Delete_3 = null;

        AntlrDatatypeRuleToken this_Insert_4 = null;

        AntlrDatatypeRuleToken this_Modify_5 = null;

        AntlrDatatypeRuleToken this_Select_6 = null;

        AntlrDatatypeRuleToken this_Project_7 = null;

        AntlrDatatypeRuleToken this_Print_8 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:170:2: ( (this_Load_0= ruleLoad | this_Store_1= ruleStore | this_ExportJson_2= ruleExportJson | this_Delete_3= ruleDelete | this_Insert_4= ruleInsert | this_Modify_5= ruleModify | this_Select_6= ruleSelect | this_Project_7= ruleProject | this_Print_8= rulePrint ) )
            // InternalMyCsv.g:171:2: (this_Load_0= ruleLoad | this_Store_1= ruleStore | this_ExportJson_2= ruleExportJson | this_Delete_3= ruleDelete | this_Insert_4= ruleInsert | this_Modify_5= ruleModify | this_Select_6= ruleSelect | this_Project_7= ruleProject | this_Print_8= rulePrint )
            {
            // InternalMyCsv.g:171:2: (this_Load_0= ruleLoad | this_Store_1= ruleStore | this_ExportJson_2= ruleExportJson | this_Delete_3= ruleDelete | this_Insert_4= ruleInsert | this_Modify_5= ruleModify | this_Select_6= ruleSelect | this_Project_7= ruleProject | this_Print_8= rulePrint )
            int alt3=9;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt3=1;
                }
                break;
            case 18:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            case 16:
                {
                alt3=4;
                }
                break;
            case 15:
                {
                alt3=5;
                }
                break;
            case 14:
                {
                alt3=6;
                }
                break;
            case 13:
                {
                alt3=7;
                }
                break;
            case 12:
                {
                alt3=8;
                }
                break;
            case 11:
                {
                alt3=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalMyCsv.g:172:3: this_Load_0= ruleLoad
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveAccess().getLoadParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Load_0=ruleLoad();

                    state._fsp--;


                    			current.merge(this_Load_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:183:3: this_Store_1= ruleStore
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveAccess().getStoreParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Store_1=ruleStore();

                    state._fsp--;


                    			current.merge(this_Store_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:194:3: this_ExportJson_2= ruleExportJson
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveAccess().getExportJsonParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExportJson_2=ruleExportJson();

                    state._fsp--;


                    			current.merge(this_ExportJson_2);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:205:3: this_Delete_3= ruleDelete
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveAccess().getDeleteParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Delete_3=ruleDelete();

                    state._fsp--;


                    			current.merge(this_Delete_3);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:216:3: this_Insert_4= ruleInsert
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveAccess().getInsertParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Insert_4=ruleInsert();

                    state._fsp--;


                    			current.merge(this_Insert_4);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyCsv.g:227:3: this_Modify_5= ruleModify
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveAccess().getModifyParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Modify_5=ruleModify();

                    state._fsp--;


                    			current.merge(this_Modify_5);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyCsv.g:238:3: this_Select_6= ruleSelect
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveAccess().getSelectParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Select_6=ruleSelect();

                    state._fsp--;


                    			current.merge(this_Select_6);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyCsv.g:249:3: this_Project_7= ruleProject
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveAccess().getProjectParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Project_7=ruleProject();

                    state._fsp--;


                    			current.merge(this_Project_7);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalMyCsv.g:260:3: this_Print_8= rulePrint
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveAccess().getPrintParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Print_8=rulePrint();

                    state._fsp--;


                    			current.merge(this_Print_8);
                    		

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
    // $ANTLR end "rulePrimitive"


    // $ANTLR start "entryRulePrint"
    // InternalMyCsv.g:274:1: entryRulePrint returns [String current=null] : iv_rulePrint= rulePrint EOF ;
    public final String entryRulePrint() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrint = null;


        try {
            // InternalMyCsv.g:274:45: (iv_rulePrint= rulePrint EOF )
            // InternalMyCsv.g:275:2: iv_rulePrint= rulePrint EOF
            {
             newCompositeNode(grammarAccess.getPrintRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrint=rulePrint();

            state._fsp--;

             current =iv_rulePrint.getText(); 
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
    // InternalMyCsv.g:281:1: rulePrint returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Print' ;
    public final AntlrDatatypeRuleToken rulePrint() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:287:2: (kw= 'Print' )
            // InternalMyCsv.g:288:2: kw= 'Print'
            {
            kw=(Token)match(input,11,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPrintAccess().getPrintKeyword());
            	

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


    // $ANTLR start "entryRuleProject"
    // InternalMyCsv.g:296:1: entryRuleProject returns [String current=null] : iv_ruleProject= ruleProject EOF ;
    public final String entryRuleProject() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleProject = null;


        try {
            // InternalMyCsv.g:296:47: (iv_ruleProject= ruleProject EOF )
            // InternalMyCsv.g:297:2: iv_ruleProject= ruleProject EOF
            {
             newCompositeNode(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProject=ruleProject();

            state._fsp--;

             current =iv_ruleProject.getText(); 
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
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalMyCsv.g:303:1: ruleProject returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Projection' ;
    public final AntlrDatatypeRuleToken ruleProject() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:309:2: (kw= 'Projection' )
            // InternalMyCsv.g:310:2: kw= 'Projection'
            {
            kw=(Token)match(input,12,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getProjectAccess().getProjectionKeyword());
            	

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
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleSelect"
    // InternalMyCsv.g:318:1: entryRuleSelect returns [String current=null] : iv_ruleSelect= ruleSelect EOF ;
    public final String entryRuleSelect() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSelect = null;


        try {
            // InternalMyCsv.g:318:46: (iv_ruleSelect= ruleSelect EOF )
            // InternalMyCsv.g:319:2: iv_ruleSelect= ruleSelect EOF
            {
             newCompositeNode(grammarAccess.getSelectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelect=ruleSelect();

            state._fsp--;

             current =iv_ruleSelect.getText(); 
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
    // InternalMyCsv.g:325:1: ruleSelect returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Select' ;
    public final AntlrDatatypeRuleToken ruleSelect() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:331:2: (kw= 'Select' )
            // InternalMyCsv.g:332:2: kw= 'Select'
            {
            kw=(Token)match(input,13,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getSelectAccess().getSelectKeyword());
            	

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


    // $ANTLR start "entryRuleModify"
    // InternalMyCsv.g:340:1: entryRuleModify returns [String current=null] : iv_ruleModify= ruleModify EOF ;
    public final String entryRuleModify() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModify = null;


        try {
            // InternalMyCsv.g:340:46: (iv_ruleModify= ruleModify EOF )
            // InternalMyCsv.g:341:2: iv_ruleModify= ruleModify EOF
            {
             newCompositeNode(grammarAccess.getModifyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModify=ruleModify();

            state._fsp--;

             current =iv_ruleModify.getText(); 
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
    // InternalMyCsv.g:347:1: ruleModify returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Modify' ;
    public final AntlrDatatypeRuleToken ruleModify() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:353:2: (kw= 'Modify' )
            // InternalMyCsv.g:354:2: kw= 'Modify'
            {
            kw=(Token)match(input,14,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getModifyAccess().getModifyKeyword());
            	

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


    // $ANTLR start "entryRuleInsert"
    // InternalMyCsv.g:362:1: entryRuleInsert returns [String current=null] : iv_ruleInsert= ruleInsert EOF ;
    public final String entryRuleInsert() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInsert = null;


        try {
            // InternalMyCsv.g:362:46: (iv_ruleInsert= ruleInsert EOF )
            // InternalMyCsv.g:363:2: iv_ruleInsert= ruleInsert EOF
            {
             newCompositeNode(grammarAccess.getInsertRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInsert=ruleInsert();

            state._fsp--;

             current =iv_ruleInsert.getText(); 
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
    // InternalMyCsv.g:369:1: ruleInsert returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Insert' ;
    public final AntlrDatatypeRuleToken ruleInsert() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:375:2: (kw= 'Insert' )
            // InternalMyCsv.g:376:2: kw= 'Insert'
            {
            kw=(Token)match(input,15,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getInsertAccess().getInsertKeyword());
            	

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


    // $ANTLR start "entryRuleDelete"
    // InternalMyCsv.g:384:1: entryRuleDelete returns [String current=null] : iv_ruleDelete= ruleDelete EOF ;
    public final String entryRuleDelete() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDelete = null;


        try {
            // InternalMyCsv.g:384:46: (iv_ruleDelete= ruleDelete EOF )
            // InternalMyCsv.g:385:2: iv_ruleDelete= ruleDelete EOF
            {
             newCompositeNode(grammarAccess.getDeleteRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDelete=ruleDelete();

            state._fsp--;

             current =iv_ruleDelete.getText(); 
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
    // InternalMyCsv.g:391:1: ruleDelete returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Delete' ;
    public final AntlrDatatypeRuleToken ruleDelete() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:397:2: (kw= 'Delete' )
            // InternalMyCsv.g:398:2: kw= 'Delete'
            {
            kw=(Token)match(input,16,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getDeleteAccess().getDeleteKeyword());
            	

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


    // $ANTLR start "entryRuleExportJson"
    // InternalMyCsv.g:406:1: entryRuleExportJson returns [String current=null] : iv_ruleExportJson= ruleExportJson EOF ;
    public final String entryRuleExportJson() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExportJson = null;


        try {
            // InternalMyCsv.g:406:50: (iv_ruleExportJson= ruleExportJson EOF )
            // InternalMyCsv.g:407:2: iv_ruleExportJson= ruleExportJson EOF
            {
             newCompositeNode(grammarAccess.getExportJsonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExportJson=ruleExportJson();

            state._fsp--;

             current =iv_ruleExportJson.getText(); 
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
    // InternalMyCsv.g:413:1: ruleExportJson returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'ExportJson' ;
    public final AntlrDatatypeRuleToken ruleExportJson() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:419:2: (kw= 'ExportJson' )
            // InternalMyCsv.g:420:2: kw= 'ExportJson'
            {
            kw=(Token)match(input,17,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getExportJsonAccess().getExportJsonKeyword());
            	

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


    // $ANTLR start "entryRuleStore"
    // InternalMyCsv.g:428:1: entryRuleStore returns [String current=null] : iv_ruleStore= ruleStore EOF ;
    public final String entryRuleStore() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStore = null;


        try {
            // InternalMyCsv.g:428:45: (iv_ruleStore= ruleStore EOF )
            // InternalMyCsv.g:429:2: iv_ruleStore= ruleStore EOF
            {
             newCompositeNode(grammarAccess.getStoreRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStore=ruleStore();

            state._fsp--;

             current =iv_ruleStore.getText(); 
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
    // InternalMyCsv.g:435:1: ruleStore returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Store' ;
    public final AntlrDatatypeRuleToken ruleStore() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:441:2: (kw= 'Store' )
            // InternalMyCsv.g:442:2: kw= 'Store'
            {
            kw=(Token)match(input,18,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getStoreAccess().getStoreKeyword());
            	

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


    // $ANTLR start "entryRuleLoad"
    // InternalMyCsv.g:450:1: entryRuleLoad returns [String current=null] : iv_ruleLoad= ruleLoad EOF ;
    public final String entryRuleLoad() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLoad = null;


        try {
            // InternalMyCsv.g:450:44: (iv_ruleLoad= ruleLoad EOF )
            // InternalMyCsv.g:451:2: iv_ruleLoad= ruleLoad EOF
            {
             newCompositeNode(grammarAccess.getLoadRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoad=ruleLoad();

            state._fsp--;

             current =iv_ruleLoad.getText(); 
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
    // InternalMyCsv.g:457:1: ruleLoad returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Load' ;
    public final AntlrDatatypeRuleToken ruleLoad() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:463:2: (kw= 'Load' )
            // InternalMyCsv.g:464:2: kw= 'Load'
            {
            kw=(Token)match(input,19,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getLoadAccess().getLoadKeyword());
            	

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


    // $ANTLR start "entryRuleExpression"
    // InternalMyCsv.g:472:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalMyCsv.g:472:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalMyCsv.g:473:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalMyCsv.g:479:1: ruleExpression returns [EObject current=null] : ( ( ruleUnaryOp ( (lv_arg_1_0= ruleExpression ) ) ) | (otherlv_2= '(' ( (lv_lhs_3_0= ruleExpression ) ) ruleBinOp ( (lv_rhs_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( ruleAggregat ( (lv_arg_8_0= ruleField ) ) ) | this_Const_9= ruleConst | this_Field_10= ruleField | this_Path_11= rulePath | ruleNbField | (otherlv_13= '[' ( (lv_exp_14_0= ruleExpression ) ) otherlv_15= ']' ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_6=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_arg_1_0 = null;

        EObject lv_lhs_3_0 = null;

        EObject lv_rhs_5_0 = null;

        EObject lv_arg_8_0 = null;

        EObject this_Const_9 = null;

        EObject this_Field_10 = null;

        EObject this_Path_11 = null;

        EObject lv_exp_14_0 = null;



        	enterRule();

        try {
            // InternalMyCsv.g:485:2: ( ( ( ruleUnaryOp ( (lv_arg_1_0= ruleExpression ) ) ) | (otherlv_2= '(' ( (lv_lhs_3_0= ruleExpression ) ) ruleBinOp ( (lv_rhs_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( ruleAggregat ( (lv_arg_8_0= ruleField ) ) ) | this_Const_9= ruleConst | this_Field_10= ruleField | this_Path_11= rulePath | ruleNbField | (otherlv_13= '[' ( (lv_exp_14_0= ruleExpression ) ) otherlv_15= ']' ) ) )
            // InternalMyCsv.g:486:2: ( ( ruleUnaryOp ( (lv_arg_1_0= ruleExpression ) ) ) | (otherlv_2= '(' ( (lv_lhs_3_0= ruleExpression ) ) ruleBinOp ( (lv_rhs_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( ruleAggregat ( (lv_arg_8_0= ruleField ) ) ) | this_Const_9= ruleConst | this_Field_10= ruleField | this_Path_11= rulePath | ruleNbField | (otherlv_13= '[' ( (lv_exp_14_0= ruleExpression ) ) otherlv_15= ']' ) )
            {
            // InternalMyCsv.g:486:2: ( ( ruleUnaryOp ( (lv_arg_1_0= ruleExpression ) ) ) | (otherlv_2= '(' ( (lv_lhs_3_0= ruleExpression ) ) ruleBinOp ( (lv_rhs_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( ruleAggregat ( (lv_arg_8_0= ruleField ) ) ) | this_Const_9= ruleConst | this_Field_10= ruleField | this_Path_11= rulePath | ruleNbField | (otherlv_13= '[' ( (lv_exp_14_0= ruleExpression ) ) otherlv_15= ']' ) )
            int alt4=8;
            switch ( input.LA(1) ) {
            case 26:
            case 32:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                alt4=2;
                }
                break;
            case 30:
            case 31:
                {
                alt4=3;
                }
                break;
            case RULE_INT:
                {
                alt4=4;
                }
                break;
            case RULE_ID:
                {
                alt4=5;
                }
                break;
            case RULE_STRING:
                {
                alt4=6;
                }
                break;
            case 24:
                {
                alt4=7;
                }
                break;
            case 22:
                {
                alt4=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalMyCsv.g:487:3: ( ruleUnaryOp ( (lv_arg_1_0= ruleExpression ) ) )
                    {
                    // InternalMyCsv.g:487:3: ( ruleUnaryOp ( (lv_arg_1_0= ruleExpression ) ) )
                    // InternalMyCsv.g:488:4: ruleUnaryOp ( (lv_arg_1_0= ruleExpression ) )
                    {

                    				newCompositeNode(grammarAccess.getExpressionAccess().getUnaryOpParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_5);
                    ruleUnaryOp();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			
                    // InternalMyCsv.g:495:4: ( (lv_arg_1_0= ruleExpression ) )
                    // InternalMyCsv.g:496:5: (lv_arg_1_0= ruleExpression )
                    {
                    // InternalMyCsv.g:496:5: (lv_arg_1_0= ruleExpression )
                    // InternalMyCsv.g:497:6: lv_arg_1_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getExpressionAccess().getArgExpressionParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_arg_1_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpressionRule());
                    						}
                    						set(
                    							current,
                    							"arg",
                    							lv_arg_1_0,
                    							"org.xtext.MyCsv.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:516:3: (otherlv_2= '(' ( (lv_lhs_3_0= ruleExpression ) ) ruleBinOp ( (lv_rhs_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalMyCsv.g:516:3: (otherlv_2= '(' ( (lv_lhs_3_0= ruleExpression ) ) ruleBinOp ( (lv_rhs_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalMyCsv.g:517:4: otherlv_2= '(' ( (lv_lhs_3_0= ruleExpression ) ) ruleBinOp ( (lv_rhs_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,20,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalMyCsv.g:521:4: ( (lv_lhs_3_0= ruleExpression ) )
                    // InternalMyCsv.g:522:5: (lv_lhs_3_0= ruleExpression )
                    {
                    // InternalMyCsv.g:522:5: (lv_lhs_3_0= ruleExpression )
                    // InternalMyCsv.g:523:6: lv_lhs_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getExpressionAccess().getLhsExpressionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_lhs_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpressionRule());
                    						}
                    						set(
                    							current,
                    							"lhs",
                    							lv_lhs_3_0,
                    							"org.xtext.MyCsv.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    				newCompositeNode(grammarAccess.getExpressionAccess().getBinOpParserRuleCall_1_2());
                    			
                    pushFollow(FOLLOW_5);
                    ruleBinOp();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			
                    // InternalMyCsv.g:547:4: ( (lv_rhs_5_0= ruleExpression ) )
                    // InternalMyCsv.g:548:5: (lv_rhs_5_0= ruleExpression )
                    {
                    // InternalMyCsv.g:548:5: (lv_rhs_5_0= ruleExpression )
                    // InternalMyCsv.g:549:6: lv_rhs_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getExpressionAccess().getRhsExpressionParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_rhs_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpressionRule());
                    						}
                    						set(
                    							current,
                    							"rhs",
                    							lv_rhs_5_0,
                    							"org.xtext.MyCsv.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getExpressionAccess().getRightParenthesisKeyword_1_4());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:572:3: ( ruleAggregat ( (lv_arg_8_0= ruleField ) ) )
                    {
                    // InternalMyCsv.g:572:3: ( ruleAggregat ( (lv_arg_8_0= ruleField ) ) )
                    // InternalMyCsv.g:573:4: ruleAggregat ( (lv_arg_8_0= ruleField ) )
                    {

                    				newCompositeNode(grammarAccess.getExpressionAccess().getAggregatParserRuleCall_2_0());
                    			
                    pushFollow(FOLLOW_8);
                    ruleAggregat();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			
                    // InternalMyCsv.g:580:4: ( (lv_arg_8_0= ruleField ) )
                    // InternalMyCsv.g:581:5: (lv_arg_8_0= ruleField )
                    {
                    // InternalMyCsv.g:581:5: (lv_arg_8_0= ruleField )
                    // InternalMyCsv.g:582:6: lv_arg_8_0= ruleField
                    {

                    						newCompositeNode(grammarAccess.getExpressionAccess().getArgFieldParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_arg_8_0=ruleField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpressionRule());
                    						}
                    						set(
                    							current,
                    							"arg",
                    							lv_arg_8_0,
                    							"org.xtext.MyCsv.Field");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:601:3: this_Const_9= ruleConst
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getConstParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Const_9=ruleConst();

                    state._fsp--;


                    			current = this_Const_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:610:3: this_Field_10= ruleField
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getFieldParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Field_10=ruleField();

                    state._fsp--;


                    			current = this_Field_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyCsv.g:619:3: this_Path_11= rulePath
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getPathParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Path_11=rulePath();

                    state._fsp--;


                    			current = this_Path_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyCsv.g:628:3: ruleNbField
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getNbFieldParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    ruleNbField();

                    state._fsp--;


                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyCsv.g:636:3: (otherlv_13= '[' ( (lv_exp_14_0= ruleExpression ) ) otherlv_15= ']' )
                    {
                    // InternalMyCsv.g:636:3: (otherlv_13= '[' ( (lv_exp_14_0= ruleExpression ) ) otherlv_15= ']' )
                    // InternalMyCsv.g:637:4: otherlv_13= '[' ( (lv_exp_14_0= ruleExpression ) ) otherlv_15= ']'
                    {
                    otherlv_13=(Token)match(input,22,FOLLOW_5); 

                    				newLeafNode(otherlv_13, grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_7_0());
                    			
                    // InternalMyCsv.g:641:4: ( (lv_exp_14_0= ruleExpression ) )
                    // InternalMyCsv.g:642:5: (lv_exp_14_0= ruleExpression )
                    {
                    // InternalMyCsv.g:642:5: (lv_exp_14_0= ruleExpression )
                    // InternalMyCsv.g:643:6: lv_exp_14_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getExpressionAccess().getExpExpressionParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_exp_14_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpressionRule());
                    						}
                    						set(
                    							current,
                    							"exp",
                    							lv_exp_14_0,
                    							"org.xtext.MyCsv.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,23,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_7_2());
                    			

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleNbField"
    // InternalMyCsv.g:669:1: entryRuleNbField returns [String current=null] : iv_ruleNbField= ruleNbField EOF ;
    public final String entryRuleNbField() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNbField = null;


        try {
            // InternalMyCsv.g:669:47: (iv_ruleNbField= ruleNbField EOF )
            // InternalMyCsv.g:670:2: iv_ruleNbField= ruleNbField EOF
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
    // InternalMyCsv.g:676:1: ruleNbField returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'NbField' ;
    public final AntlrDatatypeRuleToken ruleNbField() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:682:2: (kw= 'NbField' )
            // InternalMyCsv.g:683:2: kw= 'NbField'
            {
            kw=(Token)match(input,24,FOLLOW_2); 

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


    // $ANTLR start "entryRulePath"
    // InternalMyCsv.g:691:1: entryRulePath returns [EObject current=null] : iv_rulePath= rulePath EOF ;
    public final EObject entryRulePath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePath = null;


        try {
            // InternalMyCsv.g:691:45: (iv_rulePath= rulePath EOF )
            // InternalMyCsv.g:692:2: iv_rulePath= rulePath EOF
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
    // InternalMyCsv.g:698:1: rulePath returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject rulePath() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMyCsv.g:704:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalMyCsv.g:705:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalMyCsv.g:705:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalMyCsv.g:706:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalMyCsv.g:706:3: (lv_value_0_0= RULE_STRING )
            // InternalMyCsv.g:707:4: lv_value_0_0= RULE_STRING
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


    // $ANTLR start "entryRuleConst"
    // InternalMyCsv.g:726:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalMyCsv.g:726:46: (iv_ruleConst= ruleConst EOF )
            // InternalMyCsv.g:727:2: iv_ruleConst= ruleConst EOF
            {
             newCompositeNode(grammarAccess.getConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConst=ruleConst();

            state._fsp--;

             current =iv_ruleConst; 
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
    // $ANTLR end "entryRuleConst"


    // $ANTLR start "ruleConst"
    // InternalMyCsv.g:733:1: ruleConst returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMyCsv.g:739:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalMyCsv.g:740:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalMyCsv.g:740:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalMyCsv.g:741:3: (lv_value_0_0= RULE_INT )
            {
            // InternalMyCsv.g:741:3: (lv_value_0_0= RULE_INT )
            // InternalMyCsv.g:742:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getConstAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getConstRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
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
    // $ANTLR end "ruleConst"


    // $ANTLR start "entryRuleField"
    // InternalMyCsv.g:761:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalMyCsv.g:761:46: (iv_ruleField= ruleField EOF )
            // InternalMyCsv.g:762:2: iv_ruleField= ruleField EOF
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
    // InternalMyCsv.g:768:1: ruleField returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMyCsv.g:774:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalMyCsv.g:775:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalMyCsv.g:775:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalMyCsv.g:776:3: (lv_value_0_0= RULE_ID )
            {
            // InternalMyCsv.g:776:3: (lv_value_0_0= RULE_ID )
            // InternalMyCsv.g:777:4: lv_value_0_0= RULE_ID
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


    // $ANTLR start "entryRuleBinOp"
    // InternalMyCsv.g:796:1: entryRuleBinOp returns [String current=null] : iv_ruleBinOp= ruleBinOp EOF ;
    public final String entryRuleBinOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinOp = null;


        try {
            // InternalMyCsv.g:796:45: (iv_ruleBinOp= ruleBinOp EOF )
            // InternalMyCsv.g:797:2: iv_ruleBinOp= ruleBinOp EOF
            {
             newCompositeNode(grammarAccess.getBinOpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinOp=ruleBinOp();

            state._fsp--;

             current =iv_ruleBinOp.getText(); 
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
    // $ANTLR end "entryRuleBinOp"


    // $ANTLR start "ruleBinOp"
    // InternalMyCsv.g:803:1: ruleBinOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' | kw= '=' | kw= '<' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleBinOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:809:2: ( (kw= '+' | kw= '-' | kw= '=' | kw= '<' | kw= '<=' ) )
            // InternalMyCsv.g:810:2: (kw= '+' | kw= '-' | kw= '=' | kw= '<' | kw= '<=' )
            {
            // InternalMyCsv.g:810:2: (kw= '+' | kw= '-' | kw= '=' | kw= '<' | kw= '<=' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt5=1;
                }
                break;
            case 26:
                {
                alt5=2;
                }
                break;
            case 27:
                {
                alt5=3;
                }
                break;
            case 28:
                {
                alt5=4;
                }
                break;
            case 29:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalMyCsv.g:811:3: kw= '+'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinOpAccess().getPlusSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:817:3: kw= '-'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinOpAccess().getHyphenMinusKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:823:3: kw= '='
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinOpAccess().getEqualsSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:829:3: kw= '<'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinOpAccess().getLessThanSignKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:835:3: kw= '<='
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBinOpAccess().getLessThanSignEqualsSignKeyword_4());
                    		

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
    // $ANTLR end "ruleBinOp"


    // $ANTLR start "entryRuleAggregat"
    // InternalMyCsv.g:844:1: entryRuleAggregat returns [String current=null] : iv_ruleAggregat= ruleAggregat EOF ;
    public final String entryRuleAggregat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAggregat = null;


        try {
            // InternalMyCsv.g:844:48: (iv_ruleAggregat= ruleAggregat EOF )
            // InternalMyCsv.g:845:2: iv_ruleAggregat= ruleAggregat EOF
            {
             newCompositeNode(grammarAccess.getAggregatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAggregat=ruleAggregat();

            state._fsp--;

             current =iv_ruleAggregat.getText(); 
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
    // $ANTLR end "entryRuleAggregat"


    // $ANTLR start "ruleAggregat"
    // InternalMyCsv.g:851:1: ruleAggregat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Count' | kw= 'Sum' ) ;
    public final AntlrDatatypeRuleToken ruleAggregat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:857:2: ( (kw= 'Count' | kw= 'Sum' ) )
            // InternalMyCsv.g:858:2: (kw= 'Count' | kw= 'Sum' )
            {
            // InternalMyCsv.g:858:2: (kw= 'Count' | kw= 'Sum' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==30) ) {
                alt6=1;
            }
            else if ( (LA6_0==31) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyCsv.g:859:3: kw= 'Count'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAggregatAccess().getCountKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:865:3: kw= 'Sum'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAggregatAccess().getSumKeyword_1());
                    		

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


    // $ANTLR start "entryRuleUnaryOp"
    // InternalMyCsv.g:874:1: entryRuleUnaryOp returns [String current=null] : iv_ruleUnaryOp= ruleUnaryOp EOF ;
    public final String entryRuleUnaryOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOp = null;


        try {
            // InternalMyCsv.g:874:47: (iv_ruleUnaryOp= ruleUnaryOp EOF )
            // InternalMyCsv.g:875:2: iv_ruleUnaryOp= ruleUnaryOp EOF
            {
             newCompositeNode(grammarAccess.getUnaryOpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOp=ruleUnaryOp();

            state._fsp--;

             current =iv_ruleUnaryOp.getText(); 
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
    // $ANTLR end "entryRuleUnaryOp"


    // $ANTLR start "ruleUnaryOp"
    // InternalMyCsv.g:881:1: ruleUnaryOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'Not' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyCsv.g:887:2: ( (kw= '-' | kw= 'Not' ) )
            // InternalMyCsv.g:888:2: (kw= '-' | kw= 'Not' )
            {
            // InternalMyCsv.g:888:2: (kw= '-' | kw= 'Not' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==26) ) {
                alt7=1;
            }
            else if ( (LA7_0==32) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMyCsv.g:889:3: kw= '-'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnaryOpAccess().getHyphenMinusKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:895:3: kw= 'Not'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnaryOpAccess().getNotKeyword_1());
                    		

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
    // $ANTLR end "ruleUnaryOp"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000FF802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000001C5500072L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000001C5500070L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000003E000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000800000L});

}