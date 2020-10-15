package org.xtext.generator

import org.xtext.myCsv.Program
import org.xtext.myCsv.Load
import org.xtext.myCsv.Store
import org.xtext.myCsv.ExportJson
import org.xtext.myCsv.Projection
import org.xtext.myCsv.Select
import org.xtext.myCsv.Delete
import org.xtext.myCsv.Insert
import org.xtext.myCsv.Modify
import org.xtext.myCsv.Print
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
 * PrettyPrinter
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */ 
 
 class MyCsvPrettyPrinter {

	def dispatch String prettyPrint(Program p){
		var res=""
		for( stmt : p.stmts )
		{
			res+=stmt.prettyPrint + "\n"
		}
		return res
	}
	
	 def dispatch String prettyPrint(LineIndexCond f){
	 	return f.cond.prettyPrint
		
	}
	 def dispatch String prettyPrint(LineIndexNum f){
		var res = ""
		for(num : f.lines)
		{
			res= res + num + " "
		}
		return res
	}
	
	 def dispatch String prettyPrint(FieldIndexName f){
		var res = ""
		for(field : f.fields)
		{
			res= res + field.value + " "
		}
		return res
	}
	 def dispatch String prettyPrint(FieldIndexNum f){
		var res = ""
		for(col : f.columns)
		{
			res= res + col + " "
		}
		return res
	}
	
	 def dispatch String prettyPrint(CellIndex f){
		var res= "(" + f.line + ", "
		if( f.colname === null) {
			res= res + f.colnum
		} else {
			res = res + f.colname.value
		}
		res = res + ")"
		return res	
	}
	
	
	 def dispatch String prettyPrint(Values v){
	 	var res = ""
		for(value : v.values)
		{
			res= res + value.prettyPrint + " "
		}
		return res
	}

	
	 def dispatch String prettyPrint(Load l){
	 	var res = 'Load "' + l.getPath.value + '"'
		if (l.isSepDefined()){
			res = res + ' sep="' + l.sep + '"'
		}
		if (l.isNoHeader()){
			res = res + " noheader"
		}
		return res
	}
	 def dispatch String prettyPrint(Store l){
	 	var res = 'Store "' + l.getPath.value + '"'
		if (l.isSepDefined()){
			res = res + ' sep="' + l.sep + '"'
		}
		return res		
	}
	 def dispatch String prettyPrint(ExportJson l){
		return 'ExportJson "' + l.getPath.value + '"'
	}
	 def dispatch String prettyPrint(Projection l){
		return 'Projection '+ l.field.prettyPrint
	}
	 def dispatch String prettyPrint(Select l){
		return 'Select '+ l.line.prettyPrint
	}
	
	
	 def dispatch String prettyPrint(Delete l){
		return "Delete "+l.prettyPrint
	}
	
	 def dispatch String prettyPrint(DeleteField l){
		return "field "+ l.fields.prettyPrint
	}
	 def dispatch String prettyPrint(DeleteLine l){
		return "line "+ l.lines.prettyPrint
	}
	
	
	 def dispatch String prettyPrint(Insert l){
		return "Insert "+l.prettyPrint
	}

	
	 def dispatch String prettyPrint(InsertField l){
		return "field "+ l.fieldname.value +": "+ l.values.prettyPrint
	}
	 def dispatch String prettyPrint(InsertLine l){
		return "line "+l.values.prettyPrint
	}
	
	 def dispatch String prettyPrint(Modify l){
		return "Modify "+l.prettyPrint
	}
	
	 def dispatch String prettyPrint(ModifyField l){
		return "field "+ l.fields.prettyPrint + " with "+l.values.prettyPrint
	}
	 def dispatch String prettyPrint(ModifyLine l){
		return "line "+ l.lines.prettyPrint + " with "+l.values.prettyPrint
	}
	 def dispatch String prettyPrint(ModifyCell l){
		return "cell "+ l.cell.prettyPrint + " with "+l.value.prettyPrint
	}

	
	 def dispatch String prettyPrint(Print l){
		return "Print "+l.prettyPrint
	}
	
	 def dispatch String prettyPrint(PrintField l){
		return "field "+ l.fields.prettyPrint
	}
	 def dispatch String prettyPrint(PrintLine l){
		return "line "+ l.lines.prettyPrint
	}
	 def dispatch String prettyPrint(PrintCell l){
		return "cell "+ l.cell.prettyPrint
	}
	 def dispatch String prettyPrint(PrintTable l){
		return "table "
	}
	 def dispatch String prettyPrint(PrintExpr l){
		return "expr "+ l.exp.prettyPrint
	}

	 def dispatch String prettyPrint(ExpressionLog l){
		return l.expr.prettyPrint
	}

	 def dispatch String prettyPrint(OrExpression l){
		var	res = l.lhs.prettyPrint
		for (expr : l.rhs)
		{
			res = res + " or " + expr.prettyPrint
		}
		return res	
	}

	 def dispatch String prettyPrint(AndExpression l){
		var	res = l.lhs.prettyPrint
		for (expr : l.rhs)
		{
			res = res + " and " + expr.prettyPrint
		}
		return res	
	}

	 def dispatch String prettyPrint(UnaryLogExpression l){
	 	var res = ""
		if (l.isNot)
		{
			res = res + "not "
		}
		return res + l.expr.prettyPrint
	}
	
	 def dispatch String prettyPrint(ExpressionRel l){
		return l.field.value + l.op.toString + l.getVal.prettyPrint + " "
	}

	 def dispatch String prettyPrint(NestedLogExpression l){
		return "(" + l.expr.prettyPrint + ")"
	}

	 def dispatch String prettyPrint(ExpressionCalcul l){
		return l.expr.prettyPrint
	}

	 def dispatch String prettyPrint(AdditiveExpression l){
		var	res = l.lhs.prettyPrint
		for (expr : l.rhs)
		{
			res = res + expr.prettyPrint
		}
		return res
	}
	
	 def dispatch String prettyPrint(AdditiveExpressionRhs l){
		return l.op.toString + ""+l.rhs.prettyPrint
	}

	 def dispatch String prettyPrint(MultiplicativeExpression l){
		var	res = l.lhs.prettyPrint
		for (expr : l.rhs)
		{
			res = res + expr.prettyPrint
		}
		return res
	}
	
	 def dispatch String prettyPrint(MultiplicativeExpressionRhs l){
		return l.op.toString +""+ l.rhs.prettyPrint
	}

	 def dispatch String prettyPrint(UnaryExpression l){
		var res = ""
		if (l.isOp) {res = res + "-"}
		return res+l.expr.prettyPrint
	}
	
	 def dispatch String prettyPrint(NbField l){
		return "NbField"
	}
	 def dispatch String prettyPrint(AggregatExpression l){
		return l.aggregatOp.toString + " " +l.arg.value
	}
	 def dispatch String prettyPrint(LitteralInt l){
		return l.getVal+""
		
	}
	 def dispatch String prettyPrint(LitteralFloat l){
		return l.getVal+""
	}
	 def dispatch String prettyPrint(NestedExpressionCalcul l){
		return "(" + l.expr.prettyPrint + ")"
	}
	
	 def dispatch String prettyPrint(LitteralString l){
		return l.getVal+""
	}	
}