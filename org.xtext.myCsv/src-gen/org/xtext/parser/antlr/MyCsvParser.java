/*
 * generated by Xtext 2.23.0
 */
package org.xtext.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.xtext.parser.antlr.internal.InternalMyCsvParser;
import org.xtext.services.MyCsvGrammarAccess;

public class MyCsvParser extends AbstractAntlrParser {

	@Inject
	private MyCsvGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalMyCsvParser createParser(XtextTokenStream stream) {
		return new InternalMyCsvParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Program";
	}

	public MyCsvGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MyCsvGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}