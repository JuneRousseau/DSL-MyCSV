/*
 * generated by Xtext 2.23.0
 */
package org.xtext.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.xtext.services.MyCsvGrammarAccess;

@SuppressWarnings("all")
public class MyCsvSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MyCsvGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Values_LeftSquareBracketKeyword_0_q;
	protected AbstractElementAlias match_Values_RightSquareBracketKeyword_3_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MyCsvGrammarAccess) access;
		match_Values_LeftSquareBracketKeyword_0_q = new TokenAlias(false, true, grammarAccess.getValuesAccess().getLeftSquareBracketKeyword_0());
		match_Values_RightSquareBracketKeyword_3_q = new TokenAlias(false, true, grammarAccess.getValuesAccess().getRightSquareBracketKeyword_3());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getNbFieldRule())
			return getNbFieldToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getPrintTableRule())
			return getPrintTableToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * NbField:
	 * 	'NbField'
	 * ;
	 */
	protected String getNbFieldToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "NbField";
	}
	
	/**
	 * PrintTable:
	 * 	'table'
	 * ;
	 */
	protected String getPrintTableToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "table";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Values_LeftSquareBracketKeyword_0_q.equals(syntax))
				emit_Values_LeftSquareBracketKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Values_RightSquareBracketKeyword_3_q.equals(syntax))
				emit_Values_RightSquareBracketKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '['?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) values+=Value
	 */
	protected void emit_Values_LeftSquareBracketKeyword_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ']'?
	 *
	 * This ambiguous syntax occurs at:
	 *     values+=Value (ambiguity) (rule end)
	 */
	protected void emit_Values_RightSquareBracketKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}