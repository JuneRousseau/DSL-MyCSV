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
import org.xtext.myCsv.Statement
import org.xtext.myCsv.FieldIndex
import org.xtext.myCsv.FieldIndexName
import org.xtext.myCsv.FieldIndexNum
import org.xtext.myCsv.LineIndex
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
import org.xtext.myCsv.Value
import org.xtext.myCsv.PrintField
import org.xtext.myCsv.PrintLine
import org.xtext.myCsv.PrintCell
import org.xtext.myCsv.PrintTable
import org.xtext.myCsv.PrintExpr
import org.xtext.myCsv.ExpressionLog
import org.xtext.myCsv.OrExpression
import org.xtext.myCsv.AndExpression
import org.xtext.myCsv.UnaryLogExpression
import org.xtext.myCsv.ExpressionLogPrimary
import org.xtext.myCsv.NestedLogExpression
import org.xtext.myCsv.ExpressionRel
import org.xtext.myCsv.ExpressionCalcul
import org.xtext.myCsv.AdditiveExpression
import org.xtext.myCsv.MultiplicativeExpression
import org.xtext.myCsv.AdditiveExpressionRhs
import org.xtext.myCsv.MultiplicativeExpressionRhs
import org.xtext.myCsv.UnaryExpression
import org.xtext.myCsv.ExpressionCalculPrimary
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
 
 class MyCsvPrettyPrinter extends MyCsvVisitor {

		
	 override String beforeVisit(Program program){
		return ""
	}
	 override String afterVisit(Program program){
		return ""
	}
	

	 override String beforeVisit(LineIndex l){
		return ""
	}
	 override String afterVisit(LineIndex l){
		return ""
	}
	
	 override String visit(LineIndexCond f){
	 	return f.cond.visit
		
	}
	 override String visit(LineIndexNum f){
		var res = ""
		for(num : f.lines)
		{
			res= res + num + " "
		}
		return res
	}
	
	
	 override String beforeVisit(FieldIndex l){
		return ""
	}
	 override String afterVisit(FieldIndex l){
		return ""
	}
	
	 override String visit(FieldIndexName f){
		var res = ""
		for(field : f.fields)
		{
			res= res + field.value + " "
		}
		return res
	}
	 override String visit(FieldIndexNum f){
		var res = ""
		for(col : f.columns)
		{
			res= res + col + " "
		}
		return res
	}
	
	 override String visit(CellIndex f){
		var res= "(" + f.line + ", "
		if( f.colname === null) {
			res= res + f.colnum
		} else {
			res = res + f.colname.value
		}
		res = res + ")"
		return res	
	}
	
	
	 override String beforeVisit(Value l){
	 	return ""
		
	}
	 override String afterVisit(Value l){
		return ""
	}
	
	 override String visit(Values v){
	 	var res = ""
		for(value : v.values)
		{
			res= res + value.visit + " "
		}
		return res
	}
	
	
	 override String beforeVisit(Statement l){
		return ""
	}
	 override String afterVisit(Statement l){
		return "\n"
	}
	
	 override String visit(Load l){
	 	var res = 'Load "' + l.getPath.value + '"'
		if (l.isSepDefined()){
			res = res + ' sep="' + l.sep + '"'
		}
		if (l.isNoHeader()){
			res = res + " noheader"
		}
		return res
	}
	 override String visit(Store l){
	 	var res = 'Store "' + l.getPath.value + '"'
		if (l.isSepDefined()){
			res = res + ' sep="' + l.sep + '"'
		}
		return res		
	}
	 override String visit(ExportJson l){
		return 'ExportJson "' + l.getPath.value + '"'
	}
	 override String visit(Projection l){
		return 'Projection '+ l.field.visit
	}
	 override String visit(Select l){
		return 'Select '+ l.line.visit
	}
	
	
	 override String beforeVisit(Delete l){
		return "Delete "
	}
	 override String afterVisit(Delete l){
		return ""
	}
	
	 override String visit(DeleteField l){
		return "field "+ l.fields.visit
	}
	 override String visit(DeleteLine l){
		return "line "+ l.lines.visit
	}
	
	
	 override String beforeVisit(Insert l){
		return "Insert "
	}
	 override String afterVisit(Insert l){
		return ""
	}
	
	 override String visit(InsertField l){
		return "field "+ l.fieldname.value +": "+ l.values.visit
	}
	 override String visit(InsertLine l){
		return "line "+l.values.visit
	}
	
	 override String beforeVisit(Modify l){
		return "Modify "
	}
	 override String afterVisit(Modify l){
		return ""
	}
	
	 override String visit(ModifyField l){
		return "field "+ l.fields.visit + " with "+l.values.visit
	}
	 override String visit(ModifyLine l){
		return "line "+ l.lines.visit + " with "+l.values.visit
	}
	 override String visit(ModifyCell l){
		return "cell "+ l.cell.visit + " with "+l.value.visit
	}

	
	 override String beforeVisit(Print l){
		return "Print "
	}
	 override String afterVisit(Print l){
		return ""
	}
	
	 override String visit(PrintField l){
		return "field "+ l.fields.visit
	}
	 override String visit(PrintLine l){
		return "line "+ l.lines.visit
	}
	 override String visit(PrintCell l){
		return "cell "+ l.cell.visit
	}
	 override String visit(PrintTable l){
		return "table "
	}
	 override String visit(PrintExpr l){
		return "expr "+ l.exp.visit
	}

	 override String visit(ExpressionLog l){
		return l.expr.visit
	}

	 override String visit(OrExpression l){
		var	res = l.lhs.visit
		for (expr : l.rhs)
		{
			res = res + " or " + expr.visit
		}
		return res	
	}

	 override String visit(AndExpression l){
		var	res = l.lhs.visit
		for (expr : l.rhs)
		{
			res = res + " and " + expr.visit
		}
		return res	
	}

	 override String visit(UnaryLogExpression l){
	 	var res = ""
		if (l.isNot)
		{
			res = res + "not "
		}
		return res + l.expr.visit
	}

	
	 override String beforeVisit(ExpressionLogPrimary l){
		return ""
	}
		
	 override String afterVisit(ExpressionLogPrimary l){
		return ""
	}
	
	 override String visit(ExpressionRel l){
		return l.field.value + l.op.toString + l.getVal.visit + " "
	}

	 override String visit(NestedLogExpression l){
		return "(" + l.expr.visit + ")"
	}

	 override String visit(ExpressionCalcul l){
		return l.expr.visit
	}

	 override String visit(AdditiveExpression l){
		var	res = l.lhs.visit
		for (expr : l.rhs)
		{
			res = res + expr.visit
		}
		return res
	}
	
	 override String visit(AdditiveExpressionRhs l){
		return l.op.toString + ""+l.rhs.visit
	}

	 override String visit(MultiplicativeExpression l){
		var	res = l.lhs.visit
		for (expr : l.rhs)
		{
			res = res + expr.visit
		}
		return res
	}
	
	 override String visit(MultiplicativeExpressionRhs l){
		return l.op.toString +""+ l.rhs.visit
	}

	 override String visit(UnaryExpression l){
		var res = ""
		if (l.isOp) {res = res + "-"}
		return res+l.expr.visit
	}

	
	 override String beforeVisit(ExpressionCalculPrimary l){
		return ""
	}
	 override String afterVisit(ExpressionCalculPrimary l){
		return ""
	}
	
	 override String visit(NbField l){
		return "NbField"
	}
	 override String visit(AggregatExpression l){
		return l.aggregatOp.toString + " " +l.arg.value
	}
	 override String visit(LitteralInt l){
		return l.getVal+""
		
	}
	 override String visit(LitteralFloat l){
		return l.getVal+""
	}
	 override String visit(NestedExpressionCalcul l){
		return "(" + l.expr.visit + ")"
	}
	
	 override String visit(LitteralString l){
		return l.getVal+""
	}	
}