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
 * String visits
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
abstract class MyCsvVisitor {

	def String visit(Program p){
		var res = beforeVisit(p)
		for(stmt : p.stmts) {
			res += stmt.visit()
		}
		return res + afterVisit(p) 
	}
		
	abstract def String beforeVisit(Program program)
	abstract def String afterVisit(Program program)
	
	def String visit(LineIndex l){
		val res = beforeVisit(l)
		if(l instanceof LineIndexCond){
			(l as LineIndexCond).visit
		}
		if(l instanceof LineIndexNum){
			(l as LineIndexNum).visit
		}
		return res + afterVisit(l)
	}
		
	abstract def String beforeVisit(LineIndex l)
	abstract def String afterVisit(LineIndex l)
	
	abstract def String visit(LineIndexCond f)
	abstract def String visit(LineIndexNum f)
	
	def String visit(FieldIndex l){
		val res = beforeVisit(l)
		if(l instanceof FieldIndexName){
			(l as FieldIndexName).visit
		}
		if(l instanceof FieldIndexNum){
			(l as FieldIndexNum).visit
		}
		return res + afterVisit(l)
	}
	
	abstract def String beforeVisit(FieldIndex l)
	abstract def String afterVisit(FieldIndex l)
	
	abstract def String visit(FieldIndexName f)
	abstract def String visit(FieldIndexNum f)
	
	abstract def String visit(CellIndex f)
	
	def String visit(Value l){
		val res = beforeVisit(l)
		if(l instanceof ExpressionCalcul){
			(l as ExpressionCalcul).visit
		}
		if(l instanceof LitteralString){
			(l as LitteralString).visit
		}
		return res + afterVisit(l)
	}
	
	abstract def String beforeVisit(Value l)
	abstract def String afterVisit(Value l)
	
	abstract def String visit(Values v)
	
	def String visit(Statement l){
		val res = beforeVisit(l)
		if(l instanceof Load){
			(l as Load).visit
		}
		if(l instanceof Store){
			(l as Store).visit
		}
		if(l instanceof ExportJson){
			(l as ExportJson).visit
		}
		if(l instanceof Projection){
			(l as Projection).visit
		}
		if(l instanceof Select){
			(l as Select).visit
		}
		if(l instanceof Delete){
			(l as Delete).visit
		}
		if(l instanceof Insert){
			(l as Insert).visit
		}
		if(l instanceof Modify){
			(l as Modify).visit
		}
		if(l instanceof Print){
			(l as Print).visit
		}
		return res + afterVisit(l)
	}
	
	abstract def String beforeVisit(Statement l)
	abstract def String afterVisit(Statement l)
	
	abstract def String visit(Load l)
	abstract def String visit(Store l)
	abstract def String visit(ExportJson l)
	abstract def String visit(Projection l)
	abstract def String visit(Select l)
	
	def String visit(Delete l){
		val res = beforeVisit(l)
		if(l instanceof DeleteField)
			(l as DeleteField).visit
		if(l instanceof DeleteLine)
			(l as DeleteLine).visit
		return res + afterVisit(l)
	}
	
	abstract def String beforeVisit(Delete l)
	abstract def String afterVisit(Delete l)
	
	abstract def String visit(DeleteField l)
	abstract def String visit(DeleteLine l)
	
	def String visit(Insert l){
		val res = beforeVisit(l)
		if(l instanceof InsertField)
			(l as InsertField).visit
		if(l instanceof InsertLine)
			(l as InsertLine).visit
		return res + afterVisit(l)
	}
	
	abstract def String beforeVisit(Insert l)
	abstract def String afterVisit(Insert l)
	
	abstract def String visit(InsertField l)
	abstract def String visit(InsertLine l)
	
	def String visit(Modify l){
		val res = beforeVisit(l)
		if(l instanceof ModifyField)
			(l as ModifyField).visit
		if(l instanceof ModifyLine)
			(l as ModifyLine).visit
		if(l instanceof ModifyCell)
			(l as ModifyCell).visit
		return res + afterVisit(l)
	}
	
	abstract def String beforeVisit(Modify l)
	abstract def String afterVisit(Modify l)
	
	abstract def String visit(ModifyField l)
	abstract def String visit(ModifyLine l)
	abstract def String visit(ModifyCell l)
	
	def String visit(Print l){
		val res = beforeVisit(l)
		if(l instanceof PrintField)
			(l as PrintField).visit
		if(l instanceof PrintLine)
			(l as PrintLine).visit
		if(l instanceof PrintCell)
			(l as PrintCell).visit
		if(l instanceof PrintTable)
			(l as PrintTable).visit
		if(l instanceof PrintExpr)
			(l as PrintExpr).visit
		return res + afterVisit(l)
	}
	
	abstract def String beforeVisit(Print l)
	abstract def String afterVisit(Print l)
	
	abstract def String visit(PrintField l)
	abstract def String visit(PrintLine l)
	abstract def String visit(PrintCell l)
	abstract def String visit(PrintTable l)
	abstract def String visit(PrintExpr l)

	abstract def String visit(ExpressionLog l)

	abstract def String visit(OrExpression l)

	abstract def String visit(AndExpression l)

	abstract def String visit(UnaryLogExpression l)

	def String visit(ExpressionLogPrimary l){
		val res = beforeVisit(l)
		if(l instanceof ExpressionRel)
			(l as ExpressionRel).visit
		if(l instanceof NestedLogExpression)
			(l as NestedLogExpression).visit
		return res + afterVisit(l)
	}
	
	abstract def String beforeVisit(ExpressionLogPrimary l)
		
	abstract def String afterVisit(ExpressionLogPrimary l)
	
	abstract def String visit(ExpressionRel l)

	abstract def String visit(NestedLogExpression l)

	abstract def String visit(ExpressionCalcul l)

	abstract def String visit(AdditiveExpression l)
	
	abstract def String visit(AdditiveExpressionRhs l)

	abstract def String visit(MultiplicativeExpression l)
	
	abstract def String visit(MultiplicativeExpressionRhs l)

	abstract def String visit(UnaryExpression l)

	def String visit(ExpressionCalculPrimary l){
		val res = beforeVisit(l)
		if(l instanceof NbField)
			(l as NbField).visit
		if(l instanceof AggregatExpression)
			(l as AggregatExpression).visit
		if(l instanceof LitteralInt)
			(l as LitteralInt).visit
		if(l instanceof LitteralFloat)
			(l as LitteralFloat).visit
		if(l instanceof NestedExpressionCalcul)
			(l as NestedExpressionCalcul).visit
		return res + afterVisit(l)
	}
	
	abstract def String beforeVisit(ExpressionCalculPrimary l)
	abstract def String afterVisit(ExpressionCalculPrimary l)
	
	abstract def String visit(NbField l)
	abstract def String visit(AggregatExpression l)
	abstract def String visit(LitteralInt l)
	abstract def String visit(LitteralFloat l)
	abstract def String visit(NestedExpressionCalcul l)
	
	abstract def String visit(LitteralString l)	
}