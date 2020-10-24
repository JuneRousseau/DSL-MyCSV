package org.xtext.generator

import org.xtext.myCsv.Program
import org.xtext.myCsv.Load
import org.xtext.myCsv.Store
import org.xtext.myCsv.ExportJson
import org.xtext.myCsv.Projection
import org.xtext.myCsv.Select
import org.xtext.myCsv.FieldIndexName
import org.xtext.myCsv.FieldIndexNum
import org.xtext.myCsv.LineIndexCond
import org.xtext.myCsv.LineIndexNum
import org.xtext.myCsv.CellIndex
import org.xtext.myCsv.DeleteField
import org.xtext.myCsv.DeleteLine
import org.xtext.myCsv.InsertField
import org.xtext.myCsv.InsertLine
import org.xtext.myCsv.Values
import org.xtext.myCsv.ModifyField
import org.xtext.myCsv.ModifyLine
import org.xtext.myCsv.ModifyCell
import org.xtext.myCsv.PrintField
import org.xtext.myCsv.PrintLine
import org.xtext.myCsv.PrintCell
import org.xtext.myCsv.PrintTable
import org.xtext.myCsv.PrintExpr
import org.xtext.myCsv.ExpressionLog
import org.xtext.myCsv.OrExpression
import org.xtext.myCsv.AndExpression
import org.xtext.myCsv.UnaryLogExpression
import org.xtext.myCsv.NestedLogExpression
import org.xtext.myCsv.ExpressionRel
import org.xtext.myCsv.ExpressionCalcul
import org.xtext.myCsv.AdditiveExpression
import org.xtext.myCsv.MultiplicativeExpression
import org.xtext.myCsv.AdditiveExpressionRhs
import org.xtext.myCsv.MultiplicativeExpressionRhs
import org.xtext.myCsv.UnaryExpression
import org.xtext.myCsv.NbField
import org.xtext.myCsv.NestedExpressionCalcul
import org.xtext.myCsv.AggregatExpression
import org.xtext.myCsv.LitteralInt
import org.xtext.myCsv.LitteralFloat
import org.xtext.myCsv.LitteralString
import java.util.ArrayList
import java.util.HashMap

/**
 * Interpreter for MyCsv
 */
class MyCsvInterpreter {
	
	var Csv currentCsv = new Csv

	def void interpretProgram(Program p){
		for(stmt : p.stmts) {
			stmt.interpret
		}
	}
	
	def dispatch void interpret(Load l){
		var sep = ","
		if (l.isSepDefined()){
			sep = l.sep
		}
		currentCsv = new Csv(l.path.value, sep, l.noHeader)
	}
	
	def dispatch void interpret(Store l){
		var sep= ","
		if (l.isSepDefined()){
			sep = l.sep
		}
		currentCsv.storeCsv(l.path.value, sep)
	}
	
	def dispatch void interpret(LineIndexCond f){
	 	
	 	
	}
	
	def dispatch void interpret(LineIndexNum f){
		
		
	}
	
	def dispatch void interpret(FieldIndexName f){
		
		for(field : f.fields)
		{
		}
		
	}
	def dispatch void interpret(FieldIndexNum f){
		
		for(colNum : f.columns)
		{
		}
		
	}
	
	def dispatch void interpret(CellIndex f){
		if( f.colname === null) {
		} else {
		}
			
	}
	
	
	def dispatch void interpret(Values v){
		
		for(value : v.values)
		{
		}
		
	}
	
	def dispatch void interpret(ExportJson l){
		
	 	
	}
	def dispatch void interpret(Projection l){
		
	 	
	}
	def dispatch void interpret(Select l){
		
	 	
	}
	
	def dispatch void interpret(DeleteField l){
		
	 	
	}
	def dispatch void interpret(DeleteLine l){
		
	 	
	}
	
	def dispatch void interpret(InsertField l){
		
	 	
	}
	def dispatch void interpret(InsertLine l){
		
	 	
	}
	
	def dispatch void interpret(ModifyField l){
		
	 	
	}
	def dispatch void interpret(ModifyLine l){
		
	 	
	}
	def dispatch void interpret(ModifyCell l){
		
	 	
	}
	
	def dispatch void interpret(PrintField l){
		
	 	
	}
	def dispatch void interpret(PrintLine l){
		
	 	
	}
	def dispatch void interpret(PrintCell l){
		
	 	
	}
	def dispatch void interpret(PrintTable l){
		
	 	
	}
	def dispatch void interpret(PrintExpr l){
		
	 	
	}

	def dispatch void interpret(ExpressionLog l){
		
	 	
	}

	def dispatch void interpret(OrExpression l){
		
	 	
	}

	def dispatch void interpret(AndExpression l){
		
	 	
	}

	def dispatch void interpret(UnaryLogExpression l){
	 	
		if (l.isNot)
		{
			
		}
		
	}
	
	def dispatch void interpret(ExpressionRel l){
		
	 	
	}

	def dispatch void interpret(NestedLogExpression l){
		
	 	
	}

	def dispatch void interpret(ExpressionCalcul l){
		
	 	
	}

	def dispatch void interpret(AdditiveExpression l){
		
		for (expr : l.rhs)
		{
			
		}
		
	}
	
	def dispatch void interpret(AdditiveExpressionRhs l){
		
	 	
	}

	def dispatch void interpret(MultiplicativeExpression l){
		
		for (expr : l.rhs)
		{
			
		}
		
	}
	
	def dispatch void interpret(MultiplicativeExpressionRhs l){
		
	 	
	}

	def dispatch void interpret(UnaryExpression l){
		
		if (l.isOp) {}
		
	}
	
	def dispatch void interpret(NbField l){
		
	 	
	}
	def dispatch void interpret(AggregatExpression l){
		
	 	
	}
	def dispatch void interpret(LitteralInt l){
		
	}
	def dispatch void interpret(LitteralFloat l){
	}
	def dispatch void interpret(NestedExpressionCalcul l){
		
	 	
	}	
	def dispatch void interpret(LitteralString l){

	}

}