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


/**
 * Compiler to Bash
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MyCsvCompilerBash {

	val tmpCompilerPath="/tmp/myCsvCompilerBash/"	
	val tmpCsv= tmpCompilerPath+"tmpCsv.csv"
	var String sep = Csv.defaultSep
		
	def dispatch String compile(Program p){
		var res = "#!/bin/bash\n"
		res += "# INTRO\n"
		res += "mkdir -p "+tmpCompilerPath+"\n"
		res += "sep='" + Csv.defaultSep + "'\n\n"	
		for(stmt : p.stmts) {
			res += stmt.compile+"\n"
		}		
		res += "# OUTRO\n"
		res += "rm "+tmpCompilerPath+"*\n"
		res += "rmdir "+tmpCompilerPath+"\n"
		return res
	}
	
	def dispatch String compile(Load l){
		var res = "# LOAD\n"
		res += "cp "+l.path.value+" "+tmpCsv+"\n"

		if (l.isSepDefined()){
			sep=l.sep
			res += "sep='"+l.sep+"'\n"
		}
		
		if(!l.noHeader)
			//throw new IllegalArgumentException("Not Implemented yet. (handling .csv without header)")
			res += ""

		res += "string=$(head -n 1 "+ tmpCsv +")\n"
		res += "nbField=$(awk -F\"${sep}\" '{print NF}' <<< \"${string}\")\n"
		//                awk -F"${sep}" '{print NF}' <<< "${string}"
		return res
	}
	
	def dispatch String compile(Store l){
		var res = "# STORE\n"
		
		if (l.isSepDefined()){
			res += "sed 's/"+ sep + "/"+l.sep+"/g' "+tmpCsv+" > "+l.path.value+"\n"
		} else {
			res += "cp "+tmpCsv+" "+l.path.value+"\n"
		}
		
		return res
	}
	
	def dispatch String compile(LineIndexCond f){
	 	var res = ""
	 	return res
	}
	
	def dispatch String compile(LineIndexNum f){
		var res = ""
		return res
	}
	
	def dispatch String compile(FieldIndexName f){
		var res = ""
		for(field : f.fields)
		{
			res+=""
		}
		return res
	}
	def dispatch String compile(FieldIndexNum f){
		var res = ""
		for(colNum : f.columns)
		{
			res+=""
		}
		return res
	}
	
	def dispatch String compile(CellIndex f){
		var res= ""
		if( f.colname === null) {
			res+=""
		} else {
			res+=""
		}
		return res	
	}
	
	
	def dispatch String compile(Values v){
		var res = ""
		for(value : v.values)
		{
			res+= ""
		}
		return res
	}
	
	def dispatch String compile(ExportJson l){
		var res = "# EXPORT JSON\n"
	 	return res
	}
	def dispatch String compile(Projection l){
		var res = "# PROJECTION\n"
	 	return res
	}
	def dispatch String compile(Select l){
		var res = "# SELECT\n"
	 	return res
	}
	
	def dispatch String compile(DeleteField l){
		var res = "# DELETE FIELD\n"
	 	return res
	}
	def dispatch String compile(DeleteLine l){
		var res = "# DELETE LINE\n"
	 	return res
	}
	
	def dispatch String compile(InsertField l){
		var res = "# INSERT FIELDS\n"
	 	return res
	}
	def dispatch String compile(InsertLine l){
		var res = "# INSERT LINE\n"
	 	return res
	}
	
	def dispatch String compile(ModifyField l){
		var res = "# MODIFY FIELDS\n"
	 	return res
	}
	def dispatch String compile(ModifyLine l){
		var res = "# MODIFY LINE\n"
	 	return res
	}
	def dispatch String compile(ModifyCell l){
		var res = "# MODIFY CELL\n"
	 	return res
	}
	
	def dispatch String compile(PrintField l){
		var res = "# PRINT FIELDS\n"
	 	return res
	}
	def dispatch String compile(PrintLine l){
		var res = "# PRINT LINE\n"
	 	return res
	}
	def dispatch String compile(PrintCell l){
		var res = "# PRINT CELL\n"
	 	return res
	}
	def dispatch String compile(PrintTable l){
		var res = "# PRINT TABLE\n"
		res += "cat "+tmpCsv+"\n"
	 	return res
	}
	def dispatch String compile(PrintExpr l){
		var res = "# PRINT EXPR\n"
	 	return res + "echo " + l.exp.compileValue
	}

	def dispatch String compile(ExpressionLog l){
		return l.expr.compile
	}

	def dispatch String compile(OrExpression l){
		var	res = l.lhs.compile
		for (expr : l.rhs)
		{
			res += " or " + expr.compile
		}
		return res	
	}

	def dispatch String compile(AndExpression l){
		var	res = l.lhs.compile
		for (expr : l.rhs)
		{
			res += " and " + expr.compile
		}
		return res
	}

	def dispatch String compile(UnaryLogExpression l){
	 	var res = ""
		if (l.isNot)
		{
			res += "not "
		}
		return res + l.expr.compile
	}
	
	def dispatch String compile(ExpressionRel l){
		return "" //TODO
	}

	def dispatch String compile(NestedLogExpression l){
		return "(" + l.expr.compile + ")"
	}

	def dispatch String compileValue(ExpressionCalcul l){
		return "$(echo scale=10\\;" + l.expr.compileExpressionCalcul + "| bc)"
	}

	def dispatch String compileExpressionCalcul(AdditiveExpression l){
		var	res = l.lhs.compileExpressionCalcul
		for (expr : l.rhs)
		{
			res = res + expr.compileExpressionCalcul // op is inside of expr
		}
		return res
	}
	
	def dispatch String compileExpressionCalcul(AdditiveExpressionRhs l){
		return " " + l.op.toString + " " + l.rhs.compileExpressionCalcul
	}

	def dispatch String compileExpressionCalcul(MultiplicativeExpression l){
		var	res = l.lhs.compileExpressionCalcul
		for (expr : l.rhs)
		{
			res = res + expr.compileExpressionCalcul
		}
		return res
	}
	
	def dispatch String compileExpressionCalcul(MultiplicativeExpressionRhs l){
		return " \\" + l.op.toString + " " + l.rhs.compileExpressionCalcul
		// We escape the "*" operator so that it's a "times" and not the * from bash.
		// Escapting the "/" doesn't matter...
	}

	def dispatch String compileExpressionCalcul(UnaryExpression l){
		var res = ""
		if (l.isOp) {res += "-"}
		return res+l.expr.compileExpressionCalcul
	}
	
	def dispatch String compileExpressionCalcul(NbField l){
		return "$nbField"
	}
	def dispatch String compileExpressionCalcul(AggregatExpression l){
		switch (l.aggregatOp) {
			case COUNT: {//wc -l input.csv | cut -d " " -f 1
				return "$(wc -l "+ tmpCsv +" | cut -d \" \" -f 1)"
			}
			case SUM: {
				return "0" //TODO
			}
			case PRODUCT: {
				return "0" //TODO
			}
			case MEAN: {
				return "0" //TODO
			}
			default: {
				throw new IllegalArgumentException("Aggregative expression implemented are only Count, Sum, Product, and Mean.")
			}
		}
	}
	def dispatch String compileExpressionCalcul(LitteralInt l){
		return l.getVal.toString
	}
	def dispatch String compileExpressionCalcul(LitteralFloat l){
		return l.getVal.toString
	}
	def dispatch String compileExpressionCalcul(NestedExpressionCalcul l){
		return "(" + l.expr.compileExpressionCalcul + ")"
	}
	def dispatch String compileValue(LitteralString l){
		return '"' + l.getVal + '"'
	}
}