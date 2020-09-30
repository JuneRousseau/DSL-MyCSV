package org.xtext.ide.contentassist.antlr.internal;

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
import org.xtext.services.MyCsvGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyCsvParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Print'", "'Projection'", "'Select'", "'Modify'", "'Insert'", "'Delete'", "'ExportJson'", "'Store'", "'Load'", "'NbField'", "'+'", "'-'", "'='", "'<'", "'<='", "'Count'", "'Sum'", "'Not'", "'('", "')'", "'['", "']'"
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

    	public void setGrammarAccess(MyCsvGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleProgramm"
    // InternalMyCsv.g:53:1: entryRuleProgramm : ruleProgramm EOF ;
    public final void entryRuleProgramm() throws RecognitionException {
        try {
            // InternalMyCsv.g:54:1: ( ruleProgramm EOF )
            // InternalMyCsv.g:55:1: ruleProgramm EOF
            {
             before(grammarAccess.getProgrammRule()); 
            pushFollow(FOLLOW_1);
            ruleProgramm();

            state._fsp--;

             after(grammarAccess.getProgrammRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProgramm"


    // $ANTLR start "ruleProgramm"
    // InternalMyCsv.g:62:1: ruleProgramm : ( ( rule__Programm__StmtsAssignment )* ) ;
    public final void ruleProgramm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:66:2: ( ( ( rule__Programm__StmtsAssignment )* ) )
            // InternalMyCsv.g:67:2: ( ( rule__Programm__StmtsAssignment )* )
            {
            // InternalMyCsv.g:67:2: ( ( rule__Programm__StmtsAssignment )* )
            // InternalMyCsv.g:68:3: ( rule__Programm__StmtsAssignment )*
            {
             before(grammarAccess.getProgrammAccess().getStmtsAssignment()); 
            // InternalMyCsv.g:69:3: ( rule__Programm__StmtsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=19)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyCsv.g:69:4: rule__Programm__StmtsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Programm__StmtsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getProgrammAccess().getStmtsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProgramm"


    // $ANTLR start "entryRuleStatement"
    // InternalMyCsv.g:78:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // InternalMyCsv.g:79:1: ( ruleStatement EOF )
            // InternalMyCsv.g:80:1: ruleStatement EOF
            {
             before(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalMyCsv.g:87:1: ruleStatement : ( ( rule__Statement__Group__0 ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:91:2: ( ( ( rule__Statement__Group__0 ) ) )
            // InternalMyCsv.g:92:2: ( ( rule__Statement__Group__0 ) )
            {
            // InternalMyCsv.g:92:2: ( ( rule__Statement__Group__0 ) )
            // InternalMyCsv.g:93:3: ( rule__Statement__Group__0 )
            {
             before(grammarAccess.getStatementAccess().getGroup()); 
            // InternalMyCsv.g:94:3: ( rule__Statement__Group__0 )
            // InternalMyCsv.g:94:4: rule__Statement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRulePrimitive"
    // InternalMyCsv.g:103:1: entryRulePrimitive : rulePrimitive EOF ;
    public final void entryRulePrimitive() throws RecognitionException {
        try {
            // InternalMyCsv.g:104:1: ( rulePrimitive EOF )
            // InternalMyCsv.g:105:1: rulePrimitive EOF
            {
             before(grammarAccess.getPrimitiveRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitive();

            state._fsp--;

             after(grammarAccess.getPrimitiveRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimitive"


    // $ANTLR start "rulePrimitive"
    // InternalMyCsv.g:112:1: rulePrimitive : ( ( rule__Primitive__Alternatives ) ) ;
    public final void rulePrimitive() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:116:2: ( ( ( rule__Primitive__Alternatives ) ) )
            // InternalMyCsv.g:117:2: ( ( rule__Primitive__Alternatives ) )
            {
            // InternalMyCsv.g:117:2: ( ( rule__Primitive__Alternatives ) )
            // InternalMyCsv.g:118:3: ( rule__Primitive__Alternatives )
            {
             before(grammarAccess.getPrimitiveAccess().getAlternatives()); 
            // InternalMyCsv.g:119:3: ( rule__Primitive__Alternatives )
            // InternalMyCsv.g:119:4: rule__Primitive__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Primitive__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitive"


    // $ANTLR start "entryRulePrint"
    // InternalMyCsv.g:128:1: entryRulePrint : rulePrint EOF ;
    public final void entryRulePrint() throws RecognitionException {
        try {
            // InternalMyCsv.g:129:1: ( rulePrint EOF )
            // InternalMyCsv.g:130:1: rulePrint EOF
            {
             before(grammarAccess.getPrintRule()); 
            pushFollow(FOLLOW_1);
            rulePrint();

            state._fsp--;

             after(grammarAccess.getPrintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrint"


    // $ANTLR start "rulePrint"
    // InternalMyCsv.g:137:1: rulePrint : ( 'Print' ) ;
    public final void rulePrint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:141:2: ( ( 'Print' ) )
            // InternalMyCsv.g:142:2: ( 'Print' )
            {
            // InternalMyCsv.g:142:2: ( 'Print' )
            // InternalMyCsv.g:143:3: 'Print'
            {
             before(grammarAccess.getPrintAccess().getPrintKeyword()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getPrintAccess().getPrintKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrint"


    // $ANTLR start "entryRuleProject"
    // InternalMyCsv.g:153:1: entryRuleProject : ruleProject EOF ;
    public final void entryRuleProject() throws RecognitionException {
        try {
            // InternalMyCsv.g:154:1: ( ruleProject EOF )
            // InternalMyCsv.g:155:1: ruleProject EOF
            {
             before(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            ruleProject();

            state._fsp--;

             after(grammarAccess.getProjectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalMyCsv.g:162:1: ruleProject : ( 'Projection' ) ;
    public final void ruleProject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:166:2: ( ( 'Projection' ) )
            // InternalMyCsv.g:167:2: ( 'Projection' )
            {
            // InternalMyCsv.g:167:2: ( 'Projection' )
            // InternalMyCsv.g:168:3: 'Projection'
            {
             before(grammarAccess.getProjectAccess().getProjectionKeyword()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getProjectionKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleSelect"
    // InternalMyCsv.g:178:1: entryRuleSelect : ruleSelect EOF ;
    public final void entryRuleSelect() throws RecognitionException {
        try {
            // InternalMyCsv.g:179:1: ( ruleSelect EOF )
            // InternalMyCsv.g:180:1: ruleSelect EOF
            {
             before(grammarAccess.getSelectRule()); 
            pushFollow(FOLLOW_1);
            ruleSelect();

            state._fsp--;

             after(grammarAccess.getSelectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSelect"


    // $ANTLR start "ruleSelect"
    // InternalMyCsv.g:187:1: ruleSelect : ( 'Select' ) ;
    public final void ruleSelect() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:191:2: ( ( 'Select' ) )
            // InternalMyCsv.g:192:2: ( 'Select' )
            {
            // InternalMyCsv.g:192:2: ( 'Select' )
            // InternalMyCsv.g:193:3: 'Select'
            {
             before(grammarAccess.getSelectAccess().getSelectKeyword()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getSelectKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelect"


    // $ANTLR start "entryRuleModify"
    // InternalMyCsv.g:203:1: entryRuleModify : ruleModify EOF ;
    public final void entryRuleModify() throws RecognitionException {
        try {
            // InternalMyCsv.g:204:1: ( ruleModify EOF )
            // InternalMyCsv.g:205:1: ruleModify EOF
            {
             before(grammarAccess.getModifyRule()); 
            pushFollow(FOLLOW_1);
            ruleModify();

            state._fsp--;

             after(grammarAccess.getModifyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModify"


    // $ANTLR start "ruleModify"
    // InternalMyCsv.g:212:1: ruleModify : ( 'Modify' ) ;
    public final void ruleModify() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:216:2: ( ( 'Modify' ) )
            // InternalMyCsv.g:217:2: ( 'Modify' )
            {
            // InternalMyCsv.g:217:2: ( 'Modify' )
            // InternalMyCsv.g:218:3: 'Modify'
            {
             before(grammarAccess.getModifyAccess().getModifyKeyword()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getModifyAccess().getModifyKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModify"


    // $ANTLR start "entryRuleInsert"
    // InternalMyCsv.g:228:1: entryRuleInsert : ruleInsert EOF ;
    public final void entryRuleInsert() throws RecognitionException {
        try {
            // InternalMyCsv.g:229:1: ( ruleInsert EOF )
            // InternalMyCsv.g:230:1: ruleInsert EOF
            {
             before(grammarAccess.getInsertRule()); 
            pushFollow(FOLLOW_1);
            ruleInsert();

            state._fsp--;

             after(grammarAccess.getInsertRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInsert"


    // $ANTLR start "ruleInsert"
    // InternalMyCsv.g:237:1: ruleInsert : ( 'Insert' ) ;
    public final void ruleInsert() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:241:2: ( ( 'Insert' ) )
            // InternalMyCsv.g:242:2: ( 'Insert' )
            {
            // InternalMyCsv.g:242:2: ( 'Insert' )
            // InternalMyCsv.g:243:3: 'Insert'
            {
             before(grammarAccess.getInsertAccess().getInsertKeyword()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getInsertAccess().getInsertKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInsert"


    // $ANTLR start "entryRuleDelete"
    // InternalMyCsv.g:253:1: entryRuleDelete : ruleDelete EOF ;
    public final void entryRuleDelete() throws RecognitionException {
        try {
            // InternalMyCsv.g:254:1: ( ruleDelete EOF )
            // InternalMyCsv.g:255:1: ruleDelete EOF
            {
             before(grammarAccess.getDeleteRule()); 
            pushFollow(FOLLOW_1);
            ruleDelete();

            state._fsp--;

             after(grammarAccess.getDeleteRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDelete"


    // $ANTLR start "ruleDelete"
    // InternalMyCsv.g:262:1: ruleDelete : ( 'Delete' ) ;
    public final void ruleDelete() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:266:2: ( ( 'Delete' ) )
            // InternalMyCsv.g:267:2: ( 'Delete' )
            {
            // InternalMyCsv.g:267:2: ( 'Delete' )
            // InternalMyCsv.g:268:3: 'Delete'
            {
             before(grammarAccess.getDeleteAccess().getDeleteKeyword()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getDeleteAccess().getDeleteKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDelete"


    // $ANTLR start "entryRuleExportJson"
    // InternalMyCsv.g:278:1: entryRuleExportJson : ruleExportJson EOF ;
    public final void entryRuleExportJson() throws RecognitionException {
        try {
            // InternalMyCsv.g:279:1: ( ruleExportJson EOF )
            // InternalMyCsv.g:280:1: ruleExportJson EOF
            {
             before(grammarAccess.getExportJsonRule()); 
            pushFollow(FOLLOW_1);
            ruleExportJson();

            state._fsp--;

             after(grammarAccess.getExportJsonRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExportJson"


    // $ANTLR start "ruleExportJson"
    // InternalMyCsv.g:287:1: ruleExportJson : ( 'ExportJson' ) ;
    public final void ruleExportJson() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:291:2: ( ( 'ExportJson' ) )
            // InternalMyCsv.g:292:2: ( 'ExportJson' )
            {
            // InternalMyCsv.g:292:2: ( 'ExportJson' )
            // InternalMyCsv.g:293:3: 'ExportJson'
            {
             before(grammarAccess.getExportJsonAccess().getExportJsonKeyword()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getExportJsonAccess().getExportJsonKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExportJson"


    // $ANTLR start "entryRuleStore"
    // InternalMyCsv.g:303:1: entryRuleStore : ruleStore EOF ;
    public final void entryRuleStore() throws RecognitionException {
        try {
            // InternalMyCsv.g:304:1: ( ruleStore EOF )
            // InternalMyCsv.g:305:1: ruleStore EOF
            {
             before(grammarAccess.getStoreRule()); 
            pushFollow(FOLLOW_1);
            ruleStore();

            state._fsp--;

             after(grammarAccess.getStoreRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStore"


    // $ANTLR start "ruleStore"
    // InternalMyCsv.g:312:1: ruleStore : ( 'Store' ) ;
    public final void ruleStore() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:316:2: ( ( 'Store' ) )
            // InternalMyCsv.g:317:2: ( 'Store' )
            {
            // InternalMyCsv.g:317:2: ( 'Store' )
            // InternalMyCsv.g:318:3: 'Store'
            {
             before(grammarAccess.getStoreAccess().getStoreKeyword()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getStoreAccess().getStoreKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStore"


    // $ANTLR start "entryRuleLoad"
    // InternalMyCsv.g:328:1: entryRuleLoad : ruleLoad EOF ;
    public final void entryRuleLoad() throws RecognitionException {
        try {
            // InternalMyCsv.g:329:1: ( ruleLoad EOF )
            // InternalMyCsv.g:330:1: ruleLoad EOF
            {
             before(grammarAccess.getLoadRule()); 
            pushFollow(FOLLOW_1);
            ruleLoad();

            state._fsp--;

             after(grammarAccess.getLoadRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLoad"


    // $ANTLR start "ruleLoad"
    // InternalMyCsv.g:337:1: ruleLoad : ( 'Load' ) ;
    public final void ruleLoad() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:341:2: ( ( 'Load' ) )
            // InternalMyCsv.g:342:2: ( 'Load' )
            {
            // InternalMyCsv.g:342:2: ( 'Load' )
            // InternalMyCsv.g:343:3: 'Load'
            {
             before(grammarAccess.getLoadAccess().getLoadKeyword()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getLoadAccess().getLoadKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLoad"


    // $ANTLR start "entryRuleExpression"
    // InternalMyCsv.g:353:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalMyCsv.g:354:1: ( ruleExpression EOF )
            // InternalMyCsv.g:355:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalMyCsv.g:362:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:366:2: ( ( ( rule__Expression__Alternatives ) ) )
            // InternalMyCsv.g:367:2: ( ( rule__Expression__Alternatives ) )
            {
            // InternalMyCsv.g:367:2: ( ( rule__Expression__Alternatives ) )
            // InternalMyCsv.g:368:3: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // InternalMyCsv.g:369:3: ( rule__Expression__Alternatives )
            // InternalMyCsv.g:369:4: rule__Expression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleNbField"
    // InternalMyCsv.g:378:1: entryRuleNbField : ruleNbField EOF ;
    public final void entryRuleNbField() throws RecognitionException {
        try {
            // InternalMyCsv.g:379:1: ( ruleNbField EOF )
            // InternalMyCsv.g:380:1: ruleNbField EOF
            {
             before(grammarAccess.getNbFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleNbField();

            state._fsp--;

             after(grammarAccess.getNbFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNbField"


    // $ANTLR start "ruleNbField"
    // InternalMyCsv.g:387:1: ruleNbField : ( 'NbField' ) ;
    public final void ruleNbField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:391:2: ( ( 'NbField' ) )
            // InternalMyCsv.g:392:2: ( 'NbField' )
            {
            // InternalMyCsv.g:392:2: ( 'NbField' )
            // InternalMyCsv.g:393:3: 'NbField'
            {
             before(grammarAccess.getNbFieldAccess().getNbFieldKeyword()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getNbFieldAccess().getNbFieldKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNbField"


    // $ANTLR start "entryRulePath"
    // InternalMyCsv.g:403:1: entryRulePath : rulePath EOF ;
    public final void entryRulePath() throws RecognitionException {
        try {
            // InternalMyCsv.g:404:1: ( rulePath EOF )
            // InternalMyCsv.g:405:1: rulePath EOF
            {
             before(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            rulePath();

            state._fsp--;

             after(grammarAccess.getPathRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalMyCsv.g:412:1: rulePath : ( ( rule__Path__ValueAssignment ) ) ;
    public final void rulePath() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:416:2: ( ( ( rule__Path__ValueAssignment ) ) )
            // InternalMyCsv.g:417:2: ( ( rule__Path__ValueAssignment ) )
            {
            // InternalMyCsv.g:417:2: ( ( rule__Path__ValueAssignment ) )
            // InternalMyCsv.g:418:3: ( rule__Path__ValueAssignment )
            {
             before(grammarAccess.getPathAccess().getValueAssignment()); 
            // InternalMyCsv.g:419:3: ( rule__Path__ValueAssignment )
            // InternalMyCsv.g:419:4: rule__Path__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Path__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPathAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleConst"
    // InternalMyCsv.g:428:1: entryRuleConst : ruleConst EOF ;
    public final void entryRuleConst() throws RecognitionException {
        try {
            // InternalMyCsv.g:429:1: ( ruleConst EOF )
            // InternalMyCsv.g:430:1: ruleConst EOF
            {
             before(grammarAccess.getConstRule()); 
            pushFollow(FOLLOW_1);
            ruleConst();

            state._fsp--;

             after(grammarAccess.getConstRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConst"


    // $ANTLR start "ruleConst"
    // InternalMyCsv.g:437:1: ruleConst : ( ( rule__Const__ValueAssignment ) ) ;
    public final void ruleConst() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:441:2: ( ( ( rule__Const__ValueAssignment ) ) )
            // InternalMyCsv.g:442:2: ( ( rule__Const__ValueAssignment ) )
            {
            // InternalMyCsv.g:442:2: ( ( rule__Const__ValueAssignment ) )
            // InternalMyCsv.g:443:3: ( rule__Const__ValueAssignment )
            {
             before(grammarAccess.getConstAccess().getValueAssignment()); 
            // InternalMyCsv.g:444:3: ( rule__Const__ValueAssignment )
            // InternalMyCsv.g:444:4: rule__Const__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Const__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getConstAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConst"


    // $ANTLR start "entryRuleField"
    // InternalMyCsv.g:453:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // InternalMyCsv.g:454:1: ( ruleField EOF )
            // InternalMyCsv.g:455:1: ruleField EOF
            {
             before(grammarAccess.getFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleField();

            state._fsp--;

             after(grammarAccess.getFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalMyCsv.g:462:1: ruleField : ( ( rule__Field__ValueAssignment ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:466:2: ( ( ( rule__Field__ValueAssignment ) ) )
            // InternalMyCsv.g:467:2: ( ( rule__Field__ValueAssignment ) )
            {
            // InternalMyCsv.g:467:2: ( ( rule__Field__ValueAssignment ) )
            // InternalMyCsv.g:468:3: ( rule__Field__ValueAssignment )
            {
             before(grammarAccess.getFieldAccess().getValueAssignment()); 
            // InternalMyCsv.g:469:3: ( rule__Field__ValueAssignment )
            // InternalMyCsv.g:469:4: rule__Field__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Field__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleBinOp"
    // InternalMyCsv.g:478:1: entryRuleBinOp : ruleBinOp EOF ;
    public final void entryRuleBinOp() throws RecognitionException {
        try {
            // InternalMyCsv.g:479:1: ( ruleBinOp EOF )
            // InternalMyCsv.g:480:1: ruleBinOp EOF
            {
             before(grammarAccess.getBinOpRule()); 
            pushFollow(FOLLOW_1);
            ruleBinOp();

            state._fsp--;

             after(grammarAccess.getBinOpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBinOp"


    // $ANTLR start "ruleBinOp"
    // InternalMyCsv.g:487:1: ruleBinOp : ( ( rule__BinOp__Alternatives ) ) ;
    public final void ruleBinOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:491:2: ( ( ( rule__BinOp__Alternatives ) ) )
            // InternalMyCsv.g:492:2: ( ( rule__BinOp__Alternatives ) )
            {
            // InternalMyCsv.g:492:2: ( ( rule__BinOp__Alternatives ) )
            // InternalMyCsv.g:493:3: ( rule__BinOp__Alternatives )
            {
             before(grammarAccess.getBinOpAccess().getAlternatives()); 
            // InternalMyCsv.g:494:3: ( rule__BinOp__Alternatives )
            // InternalMyCsv.g:494:4: rule__BinOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BinOp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBinOpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinOp"


    // $ANTLR start "entryRuleAggregat"
    // InternalMyCsv.g:503:1: entryRuleAggregat : ruleAggregat EOF ;
    public final void entryRuleAggregat() throws RecognitionException {
        try {
            // InternalMyCsv.g:504:1: ( ruleAggregat EOF )
            // InternalMyCsv.g:505:1: ruleAggregat EOF
            {
             before(grammarAccess.getAggregatRule()); 
            pushFollow(FOLLOW_1);
            ruleAggregat();

            state._fsp--;

             after(grammarAccess.getAggregatRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAggregat"


    // $ANTLR start "ruleAggregat"
    // InternalMyCsv.g:512:1: ruleAggregat : ( ( rule__Aggregat__Alternatives ) ) ;
    public final void ruleAggregat() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:516:2: ( ( ( rule__Aggregat__Alternatives ) ) )
            // InternalMyCsv.g:517:2: ( ( rule__Aggregat__Alternatives ) )
            {
            // InternalMyCsv.g:517:2: ( ( rule__Aggregat__Alternatives ) )
            // InternalMyCsv.g:518:3: ( rule__Aggregat__Alternatives )
            {
             before(grammarAccess.getAggregatAccess().getAlternatives()); 
            // InternalMyCsv.g:519:3: ( rule__Aggregat__Alternatives )
            // InternalMyCsv.g:519:4: rule__Aggregat__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Aggregat__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAggregatAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAggregat"


    // $ANTLR start "entryRuleUnaryOp"
    // InternalMyCsv.g:528:1: entryRuleUnaryOp : ruleUnaryOp EOF ;
    public final void entryRuleUnaryOp() throws RecognitionException {
        try {
            // InternalMyCsv.g:529:1: ( ruleUnaryOp EOF )
            // InternalMyCsv.g:530:1: ruleUnaryOp EOF
            {
             before(grammarAccess.getUnaryOpRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryOp();

            state._fsp--;

             after(grammarAccess.getUnaryOpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryOp"


    // $ANTLR start "ruleUnaryOp"
    // InternalMyCsv.g:537:1: ruleUnaryOp : ( ( rule__UnaryOp__Alternatives ) ) ;
    public final void ruleUnaryOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:541:2: ( ( ( rule__UnaryOp__Alternatives ) ) )
            // InternalMyCsv.g:542:2: ( ( rule__UnaryOp__Alternatives ) )
            {
            // InternalMyCsv.g:542:2: ( ( rule__UnaryOp__Alternatives ) )
            // InternalMyCsv.g:543:3: ( rule__UnaryOp__Alternatives )
            {
             before(grammarAccess.getUnaryOpAccess().getAlternatives()); 
            // InternalMyCsv.g:544:3: ( rule__UnaryOp__Alternatives )
            // InternalMyCsv.g:544:4: rule__UnaryOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryOp"


    // $ANTLR start "rule__Primitive__Alternatives"
    // InternalMyCsv.g:552:1: rule__Primitive__Alternatives : ( ( ruleLoad ) | ( ruleStore ) | ( ruleExportJson ) | ( ruleDelete ) | ( ruleInsert ) | ( ruleModify ) | ( ruleSelect ) | ( ruleProject ) | ( rulePrint ) );
    public final void rule__Primitive__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:556:1: ( ( ruleLoad ) | ( ruleStore ) | ( ruleExportJson ) | ( ruleDelete ) | ( ruleInsert ) | ( ruleModify ) | ( ruleSelect ) | ( ruleProject ) | ( rulePrint ) )
            int alt2=9;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 17:
                {
                alt2=3;
                }
                break;
            case 16:
                {
                alt2=4;
                }
                break;
            case 15:
                {
                alt2=5;
                }
                break;
            case 14:
                {
                alt2=6;
                }
                break;
            case 13:
                {
                alt2=7;
                }
                break;
            case 12:
                {
                alt2=8;
                }
                break;
            case 11:
                {
                alt2=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalMyCsv.g:557:2: ( ruleLoad )
                    {
                    // InternalMyCsv.g:557:2: ( ruleLoad )
                    // InternalMyCsv.g:558:3: ruleLoad
                    {
                     before(grammarAccess.getPrimitiveAccess().getLoadParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLoad();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveAccess().getLoadParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:563:2: ( ruleStore )
                    {
                    // InternalMyCsv.g:563:2: ( ruleStore )
                    // InternalMyCsv.g:564:3: ruleStore
                    {
                     before(grammarAccess.getPrimitiveAccess().getStoreParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleStore();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveAccess().getStoreParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:569:2: ( ruleExportJson )
                    {
                    // InternalMyCsv.g:569:2: ( ruleExportJson )
                    // InternalMyCsv.g:570:3: ruleExportJson
                    {
                     before(grammarAccess.getPrimitiveAccess().getExportJsonParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleExportJson();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveAccess().getExportJsonParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:575:2: ( ruleDelete )
                    {
                    // InternalMyCsv.g:575:2: ( ruleDelete )
                    // InternalMyCsv.g:576:3: ruleDelete
                    {
                     before(grammarAccess.getPrimitiveAccess().getDeleteParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleDelete();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveAccess().getDeleteParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:581:2: ( ruleInsert )
                    {
                    // InternalMyCsv.g:581:2: ( ruleInsert )
                    // InternalMyCsv.g:582:3: ruleInsert
                    {
                     before(grammarAccess.getPrimitiveAccess().getInsertParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleInsert();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveAccess().getInsertParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMyCsv.g:587:2: ( ruleModify )
                    {
                    // InternalMyCsv.g:587:2: ( ruleModify )
                    // InternalMyCsv.g:588:3: ruleModify
                    {
                     before(grammarAccess.getPrimitiveAccess().getModifyParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleModify();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveAccess().getModifyParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalMyCsv.g:593:2: ( ruleSelect )
                    {
                    // InternalMyCsv.g:593:2: ( ruleSelect )
                    // InternalMyCsv.g:594:3: ruleSelect
                    {
                     before(grammarAccess.getPrimitiveAccess().getSelectParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleSelect();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveAccess().getSelectParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalMyCsv.g:599:2: ( ruleProject )
                    {
                    // InternalMyCsv.g:599:2: ( ruleProject )
                    // InternalMyCsv.g:600:3: ruleProject
                    {
                     before(grammarAccess.getPrimitiveAccess().getProjectParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleProject();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveAccess().getProjectParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalMyCsv.g:605:2: ( rulePrint )
                    {
                    // InternalMyCsv.g:605:2: ( rulePrint )
                    // InternalMyCsv.g:606:3: rulePrint
                    {
                     before(grammarAccess.getPrimitiveAccess().getPrintParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    rulePrint();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveAccess().getPrintParserRuleCall_8()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primitive__Alternatives"


    // $ANTLR start "rule__Expression__Alternatives"
    // InternalMyCsv.g:615:1: rule__Expression__Alternatives : ( ( ( rule__Expression__Group_0__0 ) ) | ( ( rule__Expression__Group_1__0 ) ) | ( ( rule__Expression__Group_2__0 ) ) | ( ruleConst ) | ( ruleField ) | ( rulePath ) | ( ruleNbField ) | ( ( rule__Expression__Group_7__0 ) ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:619:1: ( ( ( rule__Expression__Group_0__0 ) ) | ( ( rule__Expression__Group_1__0 ) ) | ( ( rule__Expression__Group_2__0 ) ) | ( ruleConst ) | ( ruleField ) | ( rulePath ) | ( ruleNbField ) | ( ( rule__Expression__Group_7__0 ) ) )
            int alt3=8;
            switch ( input.LA(1) ) {
            case 22:
            case 28:
                {
                alt3=1;
                }
                break;
            case 29:
                {
                alt3=2;
                }
                break;
            case 26:
            case 27:
                {
                alt3=3;
                }
                break;
            case RULE_INT:
                {
                alt3=4;
                }
                break;
            case RULE_ID:
                {
                alt3=5;
                }
                break;
            case RULE_STRING:
                {
                alt3=6;
                }
                break;
            case 20:
                {
                alt3=7;
                }
                break;
            case 31:
                {
                alt3=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalMyCsv.g:620:2: ( ( rule__Expression__Group_0__0 ) )
                    {
                    // InternalMyCsv.g:620:2: ( ( rule__Expression__Group_0__0 ) )
                    // InternalMyCsv.g:621:3: ( rule__Expression__Group_0__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_0()); 
                    // InternalMyCsv.g:622:3: ( rule__Expression__Group_0__0 )
                    // InternalMyCsv.g:622:4: rule__Expression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:626:2: ( ( rule__Expression__Group_1__0 ) )
                    {
                    // InternalMyCsv.g:626:2: ( ( rule__Expression__Group_1__0 ) )
                    // InternalMyCsv.g:627:3: ( rule__Expression__Group_1__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_1()); 
                    // InternalMyCsv.g:628:3: ( rule__Expression__Group_1__0 )
                    // InternalMyCsv.g:628:4: rule__Expression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:632:2: ( ( rule__Expression__Group_2__0 ) )
                    {
                    // InternalMyCsv.g:632:2: ( ( rule__Expression__Group_2__0 ) )
                    // InternalMyCsv.g:633:3: ( rule__Expression__Group_2__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_2()); 
                    // InternalMyCsv.g:634:3: ( rule__Expression__Group_2__0 )
                    // InternalMyCsv.g:634:4: rule__Expression__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:638:2: ( ruleConst )
                    {
                    // InternalMyCsv.g:638:2: ( ruleConst )
                    // InternalMyCsv.g:639:3: ruleConst
                    {
                     before(grammarAccess.getExpressionAccess().getConstParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleConst();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getConstParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:644:2: ( ruleField )
                    {
                    // InternalMyCsv.g:644:2: ( ruleField )
                    // InternalMyCsv.g:645:3: ruleField
                    {
                     before(grammarAccess.getExpressionAccess().getFieldParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleField();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getFieldParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMyCsv.g:650:2: ( rulePath )
                    {
                    // InternalMyCsv.g:650:2: ( rulePath )
                    // InternalMyCsv.g:651:3: rulePath
                    {
                     before(grammarAccess.getExpressionAccess().getPathParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    rulePath();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getPathParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalMyCsv.g:656:2: ( ruleNbField )
                    {
                    // InternalMyCsv.g:656:2: ( ruleNbField )
                    // InternalMyCsv.g:657:3: ruleNbField
                    {
                     before(grammarAccess.getExpressionAccess().getNbFieldParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleNbField();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getNbFieldParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalMyCsv.g:662:2: ( ( rule__Expression__Group_7__0 ) )
                    {
                    // InternalMyCsv.g:662:2: ( ( rule__Expression__Group_7__0 ) )
                    // InternalMyCsv.g:663:3: ( rule__Expression__Group_7__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_7()); 
                    // InternalMyCsv.g:664:3: ( rule__Expression__Group_7__0 )
                    // InternalMyCsv.g:664:4: rule__Expression__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getGroup_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Alternatives"


    // $ANTLR start "rule__BinOp__Alternatives"
    // InternalMyCsv.g:672:1: rule__BinOp__Alternatives : ( ( '+' ) | ( '-' ) | ( '=' ) | ( '<' ) | ( '<=' ) );
    public final void rule__BinOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:676:1: ( ( '+' ) | ( '-' ) | ( '=' ) | ( '<' ) | ( '<=' ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt4=1;
                }
                break;
            case 22:
                {
                alt4=2;
                }
                break;
            case 23:
                {
                alt4=3;
                }
                break;
            case 24:
                {
                alt4=4;
                }
                break;
            case 25:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalMyCsv.g:677:2: ( '+' )
                    {
                    // InternalMyCsv.g:677:2: ( '+' )
                    // InternalMyCsv.g:678:3: '+'
                    {
                     before(grammarAccess.getBinOpAccess().getPlusSignKeyword_0()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getBinOpAccess().getPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:683:2: ( '-' )
                    {
                    // InternalMyCsv.g:683:2: ( '-' )
                    // InternalMyCsv.g:684:3: '-'
                    {
                     before(grammarAccess.getBinOpAccess().getHyphenMinusKeyword_1()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getBinOpAccess().getHyphenMinusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyCsv.g:689:2: ( '=' )
                    {
                    // InternalMyCsv.g:689:2: ( '=' )
                    // InternalMyCsv.g:690:3: '='
                    {
                     before(grammarAccess.getBinOpAccess().getEqualsSignKeyword_2()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getBinOpAccess().getEqualsSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyCsv.g:695:2: ( '<' )
                    {
                    // InternalMyCsv.g:695:2: ( '<' )
                    // InternalMyCsv.g:696:3: '<'
                    {
                     before(grammarAccess.getBinOpAccess().getLessThanSignKeyword_3()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getBinOpAccess().getLessThanSignKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyCsv.g:701:2: ( '<=' )
                    {
                    // InternalMyCsv.g:701:2: ( '<=' )
                    // InternalMyCsv.g:702:3: '<='
                    {
                     before(grammarAccess.getBinOpAccess().getLessThanSignEqualsSignKeyword_4()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getBinOpAccess().getLessThanSignEqualsSignKeyword_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinOp__Alternatives"


    // $ANTLR start "rule__Aggregat__Alternatives"
    // InternalMyCsv.g:711:1: rule__Aggregat__Alternatives : ( ( 'Count' ) | ( 'Sum' ) );
    public final void rule__Aggregat__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:715:1: ( ( 'Count' ) | ( 'Sum' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==26) ) {
                alt5=1;
            }
            else if ( (LA5_0==27) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalMyCsv.g:716:2: ( 'Count' )
                    {
                    // InternalMyCsv.g:716:2: ( 'Count' )
                    // InternalMyCsv.g:717:3: 'Count'
                    {
                     before(grammarAccess.getAggregatAccess().getCountKeyword_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getAggregatAccess().getCountKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:722:2: ( 'Sum' )
                    {
                    // InternalMyCsv.g:722:2: ( 'Sum' )
                    // InternalMyCsv.g:723:3: 'Sum'
                    {
                     before(grammarAccess.getAggregatAccess().getSumKeyword_1()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getAggregatAccess().getSumKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Aggregat__Alternatives"


    // $ANTLR start "rule__UnaryOp__Alternatives"
    // InternalMyCsv.g:732:1: rule__UnaryOp__Alternatives : ( ( '-' ) | ( 'Not' ) );
    public final void rule__UnaryOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:736:1: ( ( '-' ) | ( 'Not' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            else if ( (LA6_0==28) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyCsv.g:737:2: ( '-' )
                    {
                    // InternalMyCsv.g:737:2: ( '-' )
                    // InternalMyCsv.g:738:3: '-'
                    {
                     before(grammarAccess.getUnaryOpAccess().getHyphenMinusKeyword_0()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getUnaryOpAccess().getHyphenMinusKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyCsv.g:743:2: ( 'Not' )
                    {
                    // InternalMyCsv.g:743:2: ( 'Not' )
                    // InternalMyCsv.g:744:3: 'Not'
                    {
                     before(grammarAccess.getUnaryOpAccess().getNotKeyword_1()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getUnaryOpAccess().getNotKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOp__Alternatives"


    // $ANTLR start "rule__Statement__Group__0"
    // InternalMyCsv.g:753:1: rule__Statement__Group__0 : rule__Statement__Group__0__Impl rule__Statement__Group__1 ;
    public final void rule__Statement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:757:1: ( rule__Statement__Group__0__Impl rule__Statement__Group__1 )
            // InternalMyCsv.g:758:2: rule__Statement__Group__0__Impl rule__Statement__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Statement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Statement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group__0"


    // $ANTLR start "rule__Statement__Group__0__Impl"
    // InternalMyCsv.g:765:1: rule__Statement__Group__0__Impl : ( ( rule__Statement__PrimAssignment_0 ) ) ;
    public final void rule__Statement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:769:1: ( ( ( rule__Statement__PrimAssignment_0 ) ) )
            // InternalMyCsv.g:770:1: ( ( rule__Statement__PrimAssignment_0 ) )
            {
            // InternalMyCsv.g:770:1: ( ( rule__Statement__PrimAssignment_0 ) )
            // InternalMyCsv.g:771:2: ( rule__Statement__PrimAssignment_0 )
            {
             before(grammarAccess.getStatementAccess().getPrimAssignment_0()); 
            // InternalMyCsv.g:772:2: ( rule__Statement__PrimAssignment_0 )
            // InternalMyCsv.g:772:3: rule__Statement__PrimAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Statement__PrimAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getStatementAccess().getPrimAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group__0__Impl"


    // $ANTLR start "rule__Statement__Group__1"
    // InternalMyCsv.g:780:1: rule__Statement__Group__1 : rule__Statement__Group__1__Impl ;
    public final void rule__Statement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:784:1: ( rule__Statement__Group__1__Impl )
            // InternalMyCsv.g:785:2: rule__Statement__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group__1"


    // $ANTLR start "rule__Statement__Group__1__Impl"
    // InternalMyCsv.g:791:1: rule__Statement__Group__1__Impl : ( ( rule__Statement__ArgsAssignment_1 )* ) ;
    public final void rule__Statement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:795:1: ( ( ( rule__Statement__ArgsAssignment_1 )* ) )
            // InternalMyCsv.g:796:1: ( ( rule__Statement__ArgsAssignment_1 )* )
            {
            // InternalMyCsv.g:796:1: ( ( rule__Statement__ArgsAssignment_1 )* )
            // InternalMyCsv.g:797:2: ( rule__Statement__ArgsAssignment_1 )*
            {
             before(grammarAccess.getStatementAccess().getArgsAssignment_1()); 
            // InternalMyCsv.g:798:2: ( rule__Statement__ArgsAssignment_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)||LA7_0==20||LA7_0==22||(LA7_0>=26 && LA7_0<=29)||LA7_0==31) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMyCsv.g:798:3: rule__Statement__ArgsAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Statement__ArgsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getStatementAccess().getArgsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group__1__Impl"


    // $ANTLR start "rule__Expression__Group_0__0"
    // InternalMyCsv.g:807:1: rule__Expression__Group_0__0 : rule__Expression__Group_0__0__Impl rule__Expression__Group_0__1 ;
    public final void rule__Expression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:811:1: ( rule__Expression__Group_0__0__Impl rule__Expression__Group_0__1 )
            // InternalMyCsv.g:812:2: rule__Expression__Group_0__0__Impl rule__Expression__Group_0__1
            {
            pushFollow(FOLLOW_4);
            rule__Expression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_0__0"


    // $ANTLR start "rule__Expression__Group_0__0__Impl"
    // InternalMyCsv.g:819:1: rule__Expression__Group_0__0__Impl : ( ruleUnaryOp ) ;
    public final void rule__Expression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:823:1: ( ( ruleUnaryOp ) )
            // InternalMyCsv.g:824:1: ( ruleUnaryOp )
            {
            // InternalMyCsv.g:824:1: ( ruleUnaryOp )
            // InternalMyCsv.g:825:2: ruleUnaryOp
            {
             before(grammarAccess.getExpressionAccess().getUnaryOpParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryOp();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getUnaryOpParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_0__0__Impl"


    // $ANTLR start "rule__Expression__Group_0__1"
    // InternalMyCsv.g:834:1: rule__Expression__Group_0__1 : rule__Expression__Group_0__1__Impl ;
    public final void rule__Expression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:838:1: ( rule__Expression__Group_0__1__Impl )
            // InternalMyCsv.g:839:2: rule__Expression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_0__1"


    // $ANTLR start "rule__Expression__Group_0__1__Impl"
    // InternalMyCsv.g:845:1: rule__Expression__Group_0__1__Impl : ( ( rule__Expression__ArgAssignment_0_1 ) ) ;
    public final void rule__Expression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:849:1: ( ( ( rule__Expression__ArgAssignment_0_1 ) ) )
            // InternalMyCsv.g:850:1: ( ( rule__Expression__ArgAssignment_0_1 ) )
            {
            // InternalMyCsv.g:850:1: ( ( rule__Expression__ArgAssignment_0_1 ) )
            // InternalMyCsv.g:851:2: ( rule__Expression__ArgAssignment_0_1 )
            {
             before(grammarAccess.getExpressionAccess().getArgAssignment_0_1()); 
            // InternalMyCsv.g:852:2: ( rule__Expression__ArgAssignment_0_1 )
            // InternalMyCsv.g:852:3: rule__Expression__ArgAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Expression__ArgAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getArgAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_0__1__Impl"


    // $ANTLR start "rule__Expression__Group_1__0"
    // InternalMyCsv.g:861:1: rule__Expression__Group_1__0 : rule__Expression__Group_1__0__Impl rule__Expression__Group_1__1 ;
    public final void rule__Expression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:865:1: ( rule__Expression__Group_1__0__Impl rule__Expression__Group_1__1 )
            // InternalMyCsv.g:866:2: rule__Expression__Group_1__0__Impl rule__Expression__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__Expression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__0"


    // $ANTLR start "rule__Expression__Group_1__0__Impl"
    // InternalMyCsv.g:873:1: rule__Expression__Group_1__0__Impl : ( '(' ) ;
    public final void rule__Expression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:877:1: ( ( '(' ) )
            // InternalMyCsv.g:878:1: ( '(' )
            {
            // InternalMyCsv.g:878:1: ( '(' )
            // InternalMyCsv.g:879:2: '('
            {
             before(grammarAccess.getExpressionAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getLeftParenthesisKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__0__Impl"


    // $ANTLR start "rule__Expression__Group_1__1"
    // InternalMyCsv.g:888:1: rule__Expression__Group_1__1 : rule__Expression__Group_1__1__Impl rule__Expression__Group_1__2 ;
    public final void rule__Expression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:892:1: ( rule__Expression__Group_1__1__Impl rule__Expression__Group_1__2 )
            // InternalMyCsv.g:893:2: rule__Expression__Group_1__1__Impl rule__Expression__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__Expression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__1"


    // $ANTLR start "rule__Expression__Group_1__1__Impl"
    // InternalMyCsv.g:900:1: rule__Expression__Group_1__1__Impl : ( ( rule__Expression__LhsAssignment_1_1 ) ) ;
    public final void rule__Expression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:904:1: ( ( ( rule__Expression__LhsAssignment_1_1 ) ) )
            // InternalMyCsv.g:905:1: ( ( rule__Expression__LhsAssignment_1_1 ) )
            {
            // InternalMyCsv.g:905:1: ( ( rule__Expression__LhsAssignment_1_1 ) )
            // InternalMyCsv.g:906:2: ( rule__Expression__LhsAssignment_1_1 )
            {
             before(grammarAccess.getExpressionAccess().getLhsAssignment_1_1()); 
            // InternalMyCsv.g:907:2: ( rule__Expression__LhsAssignment_1_1 )
            // InternalMyCsv.g:907:3: rule__Expression__LhsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Expression__LhsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getLhsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__1__Impl"


    // $ANTLR start "rule__Expression__Group_1__2"
    // InternalMyCsv.g:915:1: rule__Expression__Group_1__2 : rule__Expression__Group_1__2__Impl rule__Expression__Group_1__3 ;
    public final void rule__Expression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:919:1: ( rule__Expression__Group_1__2__Impl rule__Expression__Group_1__3 )
            // InternalMyCsv.g:920:2: rule__Expression__Group_1__2__Impl rule__Expression__Group_1__3
            {
            pushFollow(FOLLOW_4);
            rule__Expression__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__2"


    // $ANTLR start "rule__Expression__Group_1__2__Impl"
    // InternalMyCsv.g:927:1: rule__Expression__Group_1__2__Impl : ( ruleBinOp ) ;
    public final void rule__Expression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:931:1: ( ( ruleBinOp ) )
            // InternalMyCsv.g:932:1: ( ruleBinOp )
            {
            // InternalMyCsv.g:932:1: ( ruleBinOp )
            // InternalMyCsv.g:933:2: ruleBinOp
            {
             before(grammarAccess.getExpressionAccess().getBinOpParserRuleCall_1_2()); 
            pushFollow(FOLLOW_2);
            ruleBinOp();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getBinOpParserRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__2__Impl"


    // $ANTLR start "rule__Expression__Group_1__3"
    // InternalMyCsv.g:942:1: rule__Expression__Group_1__3 : rule__Expression__Group_1__3__Impl rule__Expression__Group_1__4 ;
    public final void rule__Expression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:946:1: ( rule__Expression__Group_1__3__Impl rule__Expression__Group_1__4 )
            // InternalMyCsv.g:947:2: rule__Expression__Group_1__3__Impl rule__Expression__Group_1__4
            {
            pushFollow(FOLLOW_7);
            rule__Expression__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__3"


    // $ANTLR start "rule__Expression__Group_1__3__Impl"
    // InternalMyCsv.g:954:1: rule__Expression__Group_1__3__Impl : ( ( rule__Expression__RhsAssignment_1_3 ) ) ;
    public final void rule__Expression__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:958:1: ( ( ( rule__Expression__RhsAssignment_1_3 ) ) )
            // InternalMyCsv.g:959:1: ( ( rule__Expression__RhsAssignment_1_3 ) )
            {
            // InternalMyCsv.g:959:1: ( ( rule__Expression__RhsAssignment_1_3 ) )
            // InternalMyCsv.g:960:2: ( rule__Expression__RhsAssignment_1_3 )
            {
             before(grammarAccess.getExpressionAccess().getRhsAssignment_1_3()); 
            // InternalMyCsv.g:961:2: ( rule__Expression__RhsAssignment_1_3 )
            // InternalMyCsv.g:961:3: rule__Expression__RhsAssignment_1_3
            {
            pushFollow(FOLLOW_2);
            rule__Expression__RhsAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getRhsAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__3__Impl"


    // $ANTLR start "rule__Expression__Group_1__4"
    // InternalMyCsv.g:969:1: rule__Expression__Group_1__4 : rule__Expression__Group_1__4__Impl ;
    public final void rule__Expression__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:973:1: ( rule__Expression__Group_1__4__Impl )
            // InternalMyCsv.g:974:2: rule__Expression__Group_1__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__4"


    // $ANTLR start "rule__Expression__Group_1__4__Impl"
    // InternalMyCsv.g:980:1: rule__Expression__Group_1__4__Impl : ( ')' ) ;
    public final void rule__Expression__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:984:1: ( ( ')' ) )
            // InternalMyCsv.g:985:1: ( ')' )
            {
            // InternalMyCsv.g:985:1: ( ')' )
            // InternalMyCsv.g:986:2: ')'
            {
             before(grammarAccess.getExpressionAccess().getRightParenthesisKeyword_1_4()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getRightParenthesisKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1__4__Impl"


    // $ANTLR start "rule__Expression__Group_2__0"
    // InternalMyCsv.g:996:1: rule__Expression__Group_2__0 : rule__Expression__Group_2__0__Impl rule__Expression__Group_2__1 ;
    public final void rule__Expression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1000:1: ( rule__Expression__Group_2__0__Impl rule__Expression__Group_2__1 )
            // InternalMyCsv.g:1001:2: rule__Expression__Group_2__0__Impl rule__Expression__Group_2__1
            {
            pushFollow(FOLLOW_8);
            rule__Expression__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__0"


    // $ANTLR start "rule__Expression__Group_2__0__Impl"
    // InternalMyCsv.g:1008:1: rule__Expression__Group_2__0__Impl : ( ruleAggregat ) ;
    public final void rule__Expression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1012:1: ( ( ruleAggregat ) )
            // InternalMyCsv.g:1013:1: ( ruleAggregat )
            {
            // InternalMyCsv.g:1013:1: ( ruleAggregat )
            // InternalMyCsv.g:1014:2: ruleAggregat
            {
             before(grammarAccess.getExpressionAccess().getAggregatParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAggregat();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getAggregatParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__0__Impl"


    // $ANTLR start "rule__Expression__Group_2__1"
    // InternalMyCsv.g:1023:1: rule__Expression__Group_2__1 : rule__Expression__Group_2__1__Impl ;
    public final void rule__Expression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1027:1: ( rule__Expression__Group_2__1__Impl )
            // InternalMyCsv.g:1028:2: rule__Expression__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__1"


    // $ANTLR start "rule__Expression__Group_2__1__Impl"
    // InternalMyCsv.g:1034:1: rule__Expression__Group_2__1__Impl : ( ( rule__Expression__ArgAssignment_2_1 ) ) ;
    public final void rule__Expression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1038:1: ( ( ( rule__Expression__ArgAssignment_2_1 ) ) )
            // InternalMyCsv.g:1039:1: ( ( rule__Expression__ArgAssignment_2_1 ) )
            {
            // InternalMyCsv.g:1039:1: ( ( rule__Expression__ArgAssignment_2_1 ) )
            // InternalMyCsv.g:1040:2: ( rule__Expression__ArgAssignment_2_1 )
            {
             before(grammarAccess.getExpressionAccess().getArgAssignment_2_1()); 
            // InternalMyCsv.g:1041:2: ( rule__Expression__ArgAssignment_2_1 )
            // InternalMyCsv.g:1041:3: rule__Expression__ArgAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Expression__ArgAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getArgAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__1__Impl"


    // $ANTLR start "rule__Expression__Group_7__0"
    // InternalMyCsv.g:1050:1: rule__Expression__Group_7__0 : rule__Expression__Group_7__0__Impl rule__Expression__Group_7__1 ;
    public final void rule__Expression__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1054:1: ( rule__Expression__Group_7__0__Impl rule__Expression__Group_7__1 )
            // InternalMyCsv.g:1055:2: rule__Expression__Group_7__0__Impl rule__Expression__Group_7__1
            {
            pushFollow(FOLLOW_4);
            rule__Expression__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_7__0"


    // $ANTLR start "rule__Expression__Group_7__0__Impl"
    // InternalMyCsv.g:1062:1: rule__Expression__Group_7__0__Impl : ( '[' ) ;
    public final void rule__Expression__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1066:1: ( ( '[' ) )
            // InternalMyCsv.g:1067:1: ( '[' )
            {
            // InternalMyCsv.g:1067:1: ( '[' )
            // InternalMyCsv.g:1068:2: '['
            {
             before(grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_7_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_7__0__Impl"


    // $ANTLR start "rule__Expression__Group_7__1"
    // InternalMyCsv.g:1077:1: rule__Expression__Group_7__1 : rule__Expression__Group_7__1__Impl rule__Expression__Group_7__2 ;
    public final void rule__Expression__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1081:1: ( rule__Expression__Group_7__1__Impl rule__Expression__Group_7__2 )
            // InternalMyCsv.g:1082:2: rule__Expression__Group_7__1__Impl rule__Expression__Group_7__2
            {
            pushFollow(FOLLOW_9);
            rule__Expression__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Expression__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_7__1"


    // $ANTLR start "rule__Expression__Group_7__1__Impl"
    // InternalMyCsv.g:1089:1: rule__Expression__Group_7__1__Impl : ( ( rule__Expression__ExpAssignment_7_1 ) ) ;
    public final void rule__Expression__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1093:1: ( ( ( rule__Expression__ExpAssignment_7_1 ) ) )
            // InternalMyCsv.g:1094:1: ( ( rule__Expression__ExpAssignment_7_1 ) )
            {
            // InternalMyCsv.g:1094:1: ( ( rule__Expression__ExpAssignment_7_1 ) )
            // InternalMyCsv.g:1095:2: ( rule__Expression__ExpAssignment_7_1 )
            {
             before(grammarAccess.getExpressionAccess().getExpAssignment_7_1()); 
            // InternalMyCsv.g:1096:2: ( rule__Expression__ExpAssignment_7_1 )
            // InternalMyCsv.g:1096:3: rule__Expression__ExpAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Expression__ExpAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getExpAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_7__1__Impl"


    // $ANTLR start "rule__Expression__Group_7__2"
    // InternalMyCsv.g:1104:1: rule__Expression__Group_7__2 : rule__Expression__Group_7__2__Impl ;
    public final void rule__Expression__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1108:1: ( rule__Expression__Group_7__2__Impl )
            // InternalMyCsv.g:1109:2: rule__Expression__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_7__2"


    // $ANTLR start "rule__Expression__Group_7__2__Impl"
    // InternalMyCsv.g:1115:1: rule__Expression__Group_7__2__Impl : ( ']' ) ;
    public final void rule__Expression__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1119:1: ( ( ']' ) )
            // InternalMyCsv.g:1120:1: ( ']' )
            {
            // InternalMyCsv.g:1120:1: ( ']' )
            // InternalMyCsv.g:1121:2: ']'
            {
             before(grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_7_2()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_7__2__Impl"


    // $ANTLR start "rule__Programm__StmtsAssignment"
    // InternalMyCsv.g:1131:1: rule__Programm__StmtsAssignment : ( ruleStatement ) ;
    public final void rule__Programm__StmtsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1135:1: ( ( ruleStatement ) )
            // InternalMyCsv.g:1136:2: ( ruleStatement )
            {
            // InternalMyCsv.g:1136:2: ( ruleStatement )
            // InternalMyCsv.g:1137:3: ruleStatement
            {
             before(grammarAccess.getProgrammAccess().getStmtsStatementParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getProgrammAccess().getStmtsStatementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Programm__StmtsAssignment"


    // $ANTLR start "rule__Statement__PrimAssignment_0"
    // InternalMyCsv.g:1146:1: rule__Statement__PrimAssignment_0 : ( rulePrimitive ) ;
    public final void rule__Statement__PrimAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1150:1: ( ( rulePrimitive ) )
            // InternalMyCsv.g:1151:2: ( rulePrimitive )
            {
            // InternalMyCsv.g:1151:2: ( rulePrimitive )
            // InternalMyCsv.g:1152:3: rulePrimitive
            {
             before(grammarAccess.getStatementAccess().getPrimPrimitiveParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitive();

            state._fsp--;

             after(grammarAccess.getStatementAccess().getPrimPrimitiveParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__PrimAssignment_0"


    // $ANTLR start "rule__Statement__ArgsAssignment_1"
    // InternalMyCsv.g:1161:1: rule__Statement__ArgsAssignment_1 : ( ruleExpression ) ;
    public final void rule__Statement__ArgsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1165:1: ( ( ruleExpression ) )
            // InternalMyCsv.g:1166:2: ( ruleExpression )
            {
            // InternalMyCsv.g:1166:2: ( ruleExpression )
            // InternalMyCsv.g:1167:3: ruleExpression
            {
             before(grammarAccess.getStatementAccess().getArgsExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getStatementAccess().getArgsExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__ArgsAssignment_1"


    // $ANTLR start "rule__Expression__ArgAssignment_0_1"
    // InternalMyCsv.g:1176:1: rule__Expression__ArgAssignment_0_1 : ( ruleExpression ) ;
    public final void rule__Expression__ArgAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1180:1: ( ( ruleExpression ) )
            // InternalMyCsv.g:1181:2: ( ruleExpression )
            {
            // InternalMyCsv.g:1181:2: ( ruleExpression )
            // InternalMyCsv.g:1182:3: ruleExpression
            {
             before(grammarAccess.getExpressionAccess().getArgExpressionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getArgExpressionParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__ArgAssignment_0_1"


    // $ANTLR start "rule__Expression__LhsAssignment_1_1"
    // InternalMyCsv.g:1191:1: rule__Expression__LhsAssignment_1_1 : ( ruleExpression ) ;
    public final void rule__Expression__LhsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1195:1: ( ( ruleExpression ) )
            // InternalMyCsv.g:1196:2: ( ruleExpression )
            {
            // InternalMyCsv.g:1196:2: ( ruleExpression )
            // InternalMyCsv.g:1197:3: ruleExpression
            {
             before(grammarAccess.getExpressionAccess().getLhsExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getLhsExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__LhsAssignment_1_1"


    // $ANTLR start "rule__Expression__RhsAssignment_1_3"
    // InternalMyCsv.g:1206:1: rule__Expression__RhsAssignment_1_3 : ( ruleExpression ) ;
    public final void rule__Expression__RhsAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1210:1: ( ( ruleExpression ) )
            // InternalMyCsv.g:1211:2: ( ruleExpression )
            {
            // InternalMyCsv.g:1211:2: ( ruleExpression )
            // InternalMyCsv.g:1212:3: ruleExpression
            {
             before(grammarAccess.getExpressionAccess().getRhsExpressionParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getRhsExpressionParserRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__RhsAssignment_1_3"


    // $ANTLR start "rule__Expression__ArgAssignment_2_1"
    // InternalMyCsv.g:1221:1: rule__Expression__ArgAssignment_2_1 : ( ruleField ) ;
    public final void rule__Expression__ArgAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1225:1: ( ( ruleField ) )
            // InternalMyCsv.g:1226:2: ( ruleField )
            {
            // InternalMyCsv.g:1226:2: ( ruleField )
            // InternalMyCsv.g:1227:3: ruleField
            {
             before(grammarAccess.getExpressionAccess().getArgFieldParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleField();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getArgFieldParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__ArgAssignment_2_1"


    // $ANTLR start "rule__Expression__ExpAssignment_7_1"
    // InternalMyCsv.g:1236:1: rule__Expression__ExpAssignment_7_1 : ( ruleExpression ) ;
    public final void rule__Expression__ExpAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1240:1: ( ( ruleExpression ) )
            // InternalMyCsv.g:1241:2: ( ruleExpression )
            {
            // InternalMyCsv.g:1241:2: ( ruleExpression )
            // InternalMyCsv.g:1242:3: ruleExpression
            {
             before(grammarAccess.getExpressionAccess().getExpExpressionParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getExpExpressionParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__ExpAssignment_7_1"


    // $ANTLR start "rule__Path__ValueAssignment"
    // InternalMyCsv.g:1251:1: rule__Path__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Path__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1255:1: ( ( RULE_STRING ) )
            // InternalMyCsv.g:1256:2: ( RULE_STRING )
            {
            // InternalMyCsv.g:1256:2: ( RULE_STRING )
            // InternalMyCsv.g:1257:3: RULE_STRING
            {
             before(grammarAccess.getPathAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__ValueAssignment"


    // $ANTLR start "rule__Const__ValueAssignment"
    // InternalMyCsv.g:1266:1: rule__Const__ValueAssignment : ( RULE_INT ) ;
    public final void rule__Const__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1270:1: ( ( RULE_INT ) )
            // InternalMyCsv.g:1271:2: ( RULE_INT )
            {
            // InternalMyCsv.g:1271:2: ( RULE_INT )
            // InternalMyCsv.g:1272:3: RULE_INT
            {
             before(grammarAccess.getConstAccess().getValueINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getConstAccess().getValueINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Const__ValueAssignment"


    // $ANTLR start "rule__Field__ValueAssignment"
    // InternalMyCsv.g:1281:1: rule__Field__ValueAssignment : ( RULE_ID ) ;
    public final void rule__Field__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyCsv.g:1285:1: ( ( RULE_ID ) )
            // InternalMyCsv.g:1286:2: ( RULE_ID )
            {
            // InternalMyCsv.g:1286:2: ( RULE_ID )
            // InternalMyCsv.g:1287:3: RULE_ID
            {
             before(grammarAccess.getFieldAccess().getValueIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getValueIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__ValueAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000FF802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000BC500070L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000BC500072L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000003E00000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000100000000L});

}