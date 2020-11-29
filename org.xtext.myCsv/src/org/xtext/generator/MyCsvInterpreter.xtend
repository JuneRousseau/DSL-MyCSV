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
import java.util.HashSet
import org.xtext.myCsv.RenameField

/**
 * Interpreter for MyCsv
 */
class MyCsvInterpreter {
	
	var Csv currentCsv = new Csv

	def void interpretProgram(Program p){
		currentCsv= new Csv
		for(stmt : p.stmts) {
			stmt.interpret
		}
	}
	
	def dispatch void interpret(Load l){
		var sep = Csv.defaultSep
		if (l.isSepDefined()){
			sep = l.sep
		}
		currentCsv = new Csv(l.path.value, sep, l.noHeader)
	}
	
	def dispatch void interpret(Store l){
		var sep = currentCsv.getSep
		if (l.isSepDefined()){
			sep = l.sep
		}
		currentCsv.storeCsv(l.path.value, sep, l.noHeader)
	}
	
	def dispatch ArrayList<Integer> interpretLineIndex(LineIndexCond f){
		val res = new ArrayList<Integer> 
	 	for(var i = 0 ; i<currentCsv.nbLines ; i++){
	 		val row = currentCsv.getRow(i)
	 		if(f.cond.interpretLogicalExpression(row)) res.add(i)
	 	}
	 	return res
	}
	
	def ArrayList<Integer> uniquefy(ArrayList<Integer> arg){
		val memo = new HashSet<Integer>
		val res = new ArrayList<Integer>
		for (i : arg){
			if(!memo.contains(i)){
				memo.add(i)
				res.add(i)
			}
		}
		return res
	}
	
	def dispatch ArrayList<Integer> interpretLineIndex(LineIndexNum f){
		return uniquefy(new ArrayList(f.lines))
	}
	
	def dispatch ArrayList<Integer> interpretFieldIndex(FieldIndexName f){
		val indexes = new ArrayList<Integer>
		for(field : f.fields)
		{
			indexes.add(currentCsv.getFieldNum(field.value))
		}
		return uniquefy(indexes)
	}
	def dispatch ArrayList<Integer> interpretFieldIndex(FieldIndexNum f){
		return uniquefy(new ArrayList<Integer>(f.columns))
	}
	
	def Pair<Integer, Integer> interpretCellIndex(CellIndex f){
		if(f.colname === null) {
			return new Pair<Integer, Integer>(f.line, f.colnum)
		} else {
			val colnum = currentCsv.getFieldNum(f.colname.value)
			return new Pair<Integer, Integer>(f.line, colnum)
		}
	}
	
	
	def ArrayList<Value> interpretValues(Values v){
		val res = new ArrayList
		for(value : v.values)
		{
			res.add(value.interpretValue)
		}
		return res
	}
	
	def dispatch void interpret(ExportJson l){
		currentCsv.exportJson(l.path.value)
	 	
	}
	def dispatch void interpret(Projection l){
		currentCsv.projection(l.field.interpretFieldIndex)
		
	 	
	}
	def dispatch void interpret(Select l){
		currentCsv.select(l.line.interpretLineIndex)
	}
	
	def dispatch void interpret(DeleteField l){
		currentCsv.deleteField(l.fields.interpretFieldIndex)
	 	
	}
	def dispatch void interpret(DeleteLine l){
		currentCsv.deleteLine(l.lines.interpretLineIndex)
	}
	
	def dispatch void interpret(InsertField l){
		currentCsv.insertField(l.fieldname.value, l.values.interpretValues)
	}
	def dispatch void interpret(InsertLine l){
		currentCsv.insertLine(l.values.interpretValues)
	}
	
	def dispatch void interpret(ModifyField l){
		currentCsv.modifyField(l.fields.interpretFieldIndex, l.values.interpretValues)
	}
	def dispatch void interpret(ModifyLine l){
		currentCsv.modifyLine(l.lines.interpretLineIndex, l.values.interpretValues)
	}
	def dispatch void interpret(ModifyCell l){
		var cell = l.cell.interpretCellIndex
	 	currentCsv.setCell(cell.key, cell.value, l.value.interpretValue)
	}
	
	def dispatch void interpret(PrintField l){
		val cols = l.fields.interpretFieldIndex
		for(index : cols){
			println("Field " + index + ":")
			for(el : currentCsv.getField(index)){
				println(el)
			}
		}
	}
	def dispatch void interpret(PrintLine l){
		val lines = l.lines.interpretLineIndex
		for(index : lines){
			println(currentCsv.getRow(index)) // TODO : print avec le bon séparateur ?
		}
	}
	def dispatch void interpret(PrintCell l){
		var cell = l.cell.interpretCellIndex
		println(currentCsv.getCell(cell.key, cell.value))
	}
	def dispatch void interpret(PrintTable l){
		print(currentCsv.toString)
	}
	
	def dispatch void interpret(PrintExpr l){
		println(l.exp.interpretValue)
	}
	
	def dispatch void interpret(RenameField l){
		currentCsv.renameField(l.last_field.value, l.new_field.value)
	}
	
	def dispatch boolean interpretLogicalExpression(ExpressionLog l, ArrayList<Value> row){	 	
		return l.expr.interpretLogicalExpression(row)
	}

	def dispatch boolean interpretLogicalExpression(OrExpression l, ArrayList<Value> row){
		var res =l.lhs.interpretLogicalExpression(row)
		for(expr : l.rhs){
			res = res || expr.interpretLogicalExpression(row)  
		} 
		return res
	}

	def dispatch boolean interpretLogicalExpression(AndExpression l, ArrayList<Value> row){
		var res =l.lhs.interpretLogicalExpression(row)
		for(expr : l.rhs){
			res = res && expr.interpretLogicalExpression(row)  
		} 
		return res
	}

	def dispatch boolean interpretLogicalExpression(UnaryLogExpression l, ArrayList<Value> row){
		var res = l.expr.interpretLogicalExpression(row)
		if (l.isNot)
		{
			res = !res
		}
		return res
	}
	
	def dispatch boolean interpretLogicalExpression(ExpressionRel l, ArrayList<Value> row){
		val field = currentCsv.getFieldNum(l.field.value)
		val fieldValue = row.get(field)
		val exprValue = l.getVal.interpretValue
		return fieldValue.compare(l.op, exprValue)
	}

	def dispatch boolean interpretLogicalExpression(NestedLogExpression l, ArrayList<Value> row){
		return l.expr.interpretLogicalExpression(row)
	}

	def dispatch Value interpretValue(ExpressionCalcul l){
		return new Value(l.expr.interpretExpressionCalcul)
	 	
	}

	def dispatch double interpretExpressionCalcul(AdditiveExpression l){
		var res = l.lhs.interpretExpressionCalcul
		for (expr : l.rhs)
		{
			res += expr.interpretExpressionCalcul // dont worry about substraction, it works
		}
		return res
	}
	
	def dispatch double interpretExpressionCalcul(AdditiveExpressionRhs l){
		var res = l.rhs.interpretExpressionCalcul
		switch (l.op) {
			case MINUS: {
				res = -res // that's why it works ;)
			}
			default: {}
		}
		return res
	}

	def dispatch double interpretExpressionCalcul(MultiplicativeExpression l){
		var res = l.lhs.interpretExpressionCalcul
		for (expr : l.rhs)
		{
			res *= expr.interpretExpressionCalcul // dont worry about division, it works
		}
		return res
	}
	
	def dispatch double interpretExpressionCalcul(MultiplicativeExpressionRhs l){
		var res = l.rhs.interpretExpressionCalcul
		switch (l.op) {
			case DIV: {
				res = 1/res // that's why it works ;)
			}
			default: {}
		}
		return res
	}

	def dispatch double interpretExpressionCalcul(UnaryExpression l){
		var res = l.expr.interpretExpressionCalcul
		if (l.isOp) {res = -res}
		return res
	}
	
	def dispatch double interpretExpressionCalcul(NbField l){
		return currentCsv.nbFields
	}
	
	def dispatch double interpretExpressionCalcul(AggregatExpression l){
		switch (l.aggregatOp) {
			case COUNT: {
				return currentCsv.count(l.arg.value)
			}
			case SUM: {
				return currentCsv.sum(l.arg.value)
			}
			case PRODUCT: {
				return currentCsv.product(l.arg.value)
			}
			case MEAN: {
				return currentCsv.mean(l.arg.value)
			}
			default: {
				throw new IllegalArgumentException("Aggregative expression implemented are only Count, Sum, Product, and Mean.")
			}
		}
	}
	def dispatch double interpretExpressionCalcul(LitteralInt l){
		return l.getVal
	}
	def dispatch double interpretExpressionCalcul(LitteralFloat l){
		return l.getVal
	}
	def dispatch double interpretExpressionCalcul(NestedExpressionCalcul l){
		return l.expr.expr.interpretExpressionCalcul
	}	
	def dispatch Value interpretValue(LitteralString l){
		return new Value(l.getVal)
	}
}