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
 * Pretty-prints
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MyCsvCompilerPython {

	def dispatch String compile(Program p){
		var res = "from csv import *\n"
		res += "data = []\n"
		res += "header = []\n"
		res += "headerDict = {}\n"
		// TODO definir les fonctions aggregatives
		for(stmt : p.stmts) {
			res += stmt.compile() + "\n";
		}
		res
	}
	
	def dispatch String compile(Load l){
		var res = "#LOAD\n"
		res += "data = []\n"
		res += "header = []\n"
		res += "headerDict = {}\n"
		res += "with open('" + l.getPath.value + "', newline='') as csvfile:\n"
		
		res += "\treader = csv.reader(csvfile"
		if (l.isSepDefined()){
			res += ', delimiter =" ' + l.sep + '"'
		}
		res += ")\n"
		
		if(!l.noHeader)
			res += "\theader = next(reader) # TODO convertir en dictionnaire\n"
		
		res += "\tfor line in reader:\n"
		res += "\t\tdata.append(line)\n"
		
		res
	}
	
	def dispatch String compile(Store l){
		var res = "#STORE\n"
		res += "with open('" + l.getPath.value + "', 'w', newline='') as csvfile:\n"
		
		res += "\twriter = csv.writer(csvfile"
		if (l.isSepDefined()){
			res += ', delimiter =" ' + l.sep + '"'
		}
		res += ")\n"
		
		res += "\twriter.writerow(header)\n"
		res += "\tfor line in data:\n"
		res += "\t\twriter.writerow(line)\n"
		
		res
	}
	
	def dispatch String compile(LineIndexCond f){
	 	return f.cond.compile
		
	}
	def dispatch String compile(LineIndexNum f){
		var res = ""
		for(num : f.lines)
		{
			res= res + num + " "
		}
		return res
	}
	
	def dispatch String compile(FieldIndexName f){
		var res = ""
		for(field : f.fields)
		{
			res= res + field.value + " "
		}
		return res
	}
	def dispatch String compile(FieldIndexNum f){
		var res = ""
		for(col : f.columns)
		{
			res= res + col + " "
		}
		return res
	}
	
	def dispatch String compile(CellIndex f){
		var res= "(" + f.line + ", "
		if( f.colname === null) {
			res= res + f.colnum
		} else {
			res = res + f.colname.value
		}
		res = res + ")"
		return res	
	}
	
	
	def dispatch String compile(Values v){
	 	var res = ""
		for(value : v.values)
		{
			res= res + value.compile + " "
		}
		return res
	}
	
	def dispatch String compile(ExportJson l){
		return 'ExportJson "' + l.getPath.value + '"'
	}
	def dispatch String compile(Projection l){
		return 'Projection '+ l.field.compile
	}
	def dispatch String compile(Select l){
		return 'Select '+ l.line.compile
	}
	
	
	def dispatch String compile(Delete l){
		return "Delete "+l.compile
	}
	
	def dispatch String compile(DeleteField l){
		return "field "+ l.fields.compile
	}
	def dispatch String compile(DeleteLine l){
		return "line "+ l.lines.compile
	}
	
	
	def dispatch String compile(Insert l){
		return "Insert "+l.compile
	}

	
	def dispatch String compile(InsertField l){
		return "field "+ l.fieldname.value +": "+ l.values.compile
	}
	def dispatch String compile(InsertLine l){
		return "line "+l.values.compile
	}
	
	def dispatch String compile(Modify l){
		return "Modify "+l.compile
	}
	
	def dispatch String compile(ModifyField l){
		return "field "+ l.fields.compile + " with "+l.values.compile
	}
	def dispatch String compile(ModifyLine l){
		return "line "+ l.lines.compile + " with "+l.values.compile
	}
	def dispatch String compile(ModifyCell l){
		return "cell "+ l.cell.compile + " with "+l.value.compile
	}

	
	def dispatch String compile(Print l){
		return "Print "+l.compile
	}
	
	def dispatch String compile(PrintField l){
		return "field "+ l.fields.compile
	}
	def dispatch String compile(PrintLine l){
		return "line "+ l.lines.compile
	}
	def dispatch String compile(PrintCell l){
		return "# PRINT CELL\nprint(" + l.cell.compile + ")"
	}
	def dispatch String compile(PrintTable l){
		return "# PRINT TABLE\nprint(header)\nfor row in data:\n\tprint(row)"
	}
	def dispatch String compile(PrintExpr l){
		return "expr "+ l.exp.compile
	}

	def dispatch String compile(ExpressionLog l){
		return l.expr.compile
	}

	def dispatch String compile(OrExpression l){
		var	res = l.lhs.compile
		for (expr : l.rhs)
		{
			res = res + " or " + expr.compile
		}
		return res	
	}

	def dispatch String compile(AndExpression l){
		var	res = l.lhs.compile
		for (expr : l.rhs)
		{
			res = res + " and " + expr.compile
		}
		return res	
	}

	def dispatch String compile(UnaryLogExpression l){
	 	var res = ""
		if (l.isNot)
		{
			res = res + "not "
		}
		return res + l.expr.compile
	}
	
	def dispatch String compile(ExpressionRel l){
		return l.field.value + l.op.toString + l.getVal.compile + " "
	}

	def dispatch String compile(NestedLogExpression l){
		return "(" + l.expr.compile + ")"
	}

	def dispatch String compile(ExpressionCalcul l){
		return l.expr.compile
	}

	def dispatch String compile(AdditiveExpression l){
		var	res = l.lhs.compile
		for (expr : l.rhs)
		{
			res = res + expr.compile
		}
		return res
	}
	
	def dispatch String compile(AdditiveExpressionRhs l){
		return l.op.toString + ""+l.rhs.compile
	}

	def dispatch String compile(MultiplicativeExpression l){
		var	res = l.lhs.compile
		for (expr : l.rhs)
		{
			res = res + expr.compile
		}
		return res
	}
	
	def dispatch String compile(MultiplicativeExpressionRhs l){
		return l.op.toString +""+ l.rhs.compile
	}

	def dispatch String compile(UnaryExpression l){
		var res = ""
		if (l.isOp) {res = res + "-"}
		return res+l.expr.compile
	}
	
	def dispatch String compile(NbField l){
		return "NbField"
	}
	def dispatch String compile(AggregatExpression l){
		return l.aggregatOp.toString + " " +l.arg.value
	}
	def dispatch String compile(LitteralInt l){
		return l.getVal+""
		
	}
	def dispatch String compile(LitteralFloat l){
		return l.getVal+""
	}
	def dispatch String compile(NestedExpressionCalcul l){
		return "(" + l.expr.compile + ")"
	}
	
	def dispatch String compile(LitteralString l){
		return l.getVal+""
	}
}