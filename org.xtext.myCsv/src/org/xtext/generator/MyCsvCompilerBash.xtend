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
	static String sep= ','
		
	def dispatch String compile(Program p){
		var res = "#!/bin/bash\n"
		res += "mkdir -p "+tmpCompilerPath+"\n"
		res += "sep=','\n\n"	
		for(stmt : p.stmts) {
			res += stmt.compile+"\n"
		}
		
		res += "rm "+tmpCompilerPath+"*\n"
		res += "rmdir "+tmpCompilerPath+"\n"
		return res
	}
	
	def dispatch String compile(Load l){
		var res = "# LOAD\n"
		res += "cp "+l.path.value+" "+tmpCsv+"\n"

		if (l.isSepDefined()){
			MyCsvCompilerBash.sep=l.sep
			res += "sep='"+l.sep+"'\n"
		}
		
		if(!l.noHeader)
			//throw new IllegalArgumentException("Not Implemented yet. (handling .csv without header)")
			res += ""
		
		return res
	}
	
	def dispatch String compile(Store l){
		var res = "# STORE\n"
		
		if (l.isSepDefined()){
			res += "sed 's/$sep/"+l.sep+"/g' "+tmpCsv+" > "+l.path.value+"\n"
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
	 	return res
	}

	def dispatch String compile(ExpressionLog l){
		var res = ""
	 	return res
	}

	def dispatch String compile(OrExpression l){
		var res = ""
	 	return res
	}

	def dispatch String compile(AndExpression l){
		var res = ""
	 	return res
	}

	def dispatch String compile(UnaryLogExpression l){
	 	var res = ""
		if (l.isNot)
		{
			res += ""
		}
		return res
	}
	
	def dispatch String compile(ExpressionRel l){
		var res = ""
	 	return res
	}

	def dispatch String compile(NestedLogExpression l){
		var res = ""
	 	return res
	}

	def dispatch String compile(ExpressionCalcul l){
		var res = ""
	 	return res
	}

	def dispatch String compile(AdditiveExpression l){
		var	res = ""
		for (expr : l.rhs)
		{
			res+=""
		}
		return res
	}
	
	def dispatch String compile(AdditiveExpressionRhs l){
		var res = ""
	 	return res
	}

	def dispatch String compile(MultiplicativeExpression l){
		var	res = ""
		for (expr : l.rhs)
		{
			res += ""
		}
		return res
	}
	
	def dispatch String compile(MultiplicativeExpressionRhs l){
		var res = ""
	 	return res
	}

	def dispatch String compile(UnaryExpression l){
		var res = ""
		if (l.isOp) {res += ""}
		return res
	}
	
	def dispatch String compile(NbField l){
		var res = ""
	 	return res
	}
	def dispatch String compile(AggregatExpression l){
		var res = ""
	 	return res
	}
	def dispatch String compile(LitteralInt l){
		return l.getVal.toString
		
	}
	def dispatch String compile(LitteralFloat l){
		return l.getVal.toString
	}
	def dispatch String compile(NestedExpressionCalcul l){
		var res = ""
	 	return res
	}	
	def dispatch String compile(LitteralString l){
		return '"' + l.getVal + '"'
	}
}