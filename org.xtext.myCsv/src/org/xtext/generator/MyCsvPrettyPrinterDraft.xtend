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

/**
 * Pretty-prints
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MyCsvPrettyPrinterDraft {

	def void prettyPrint(Program p){
		for(stmt : p.stmts) {
			stmt.prettyPrint();
		}
	}
	
	def prettyPrint(Load l){
		print('Load "' + l.getPath.value + '"')
		if (l.isSepDefined()){
			print(' sep="' + l.sep + '"')
		}
		if (l.isNoHeader()){
			print(" noheader")
		}
		println()
	}
	
	def prettyPrint(Store l){
		print('Store "' + l.getPath.value + '"')
		if (l.isSepDefined()){
			print(' sep="' + l.sep + '"')
		}
		println()
	}
	
	def prettyPrint(ExportJson l){
		println('ExportJson "' + l.getPath.value + '"')
	}
	
	def prettyPrint(Projection l){
		print("Projecion ")
		l.field.prettyPrint
		println()
	}
	
	def prettyPrint(Select l){
		print("Select ")
		l.line.prettyPrint
		println()
	}
	
	def prettyPrint(Delete l){
		print('Delete ')
		if(l instanceof DeleteField)
			(l as DeleteField).prettyPrint
		if(l instanceof DeleteLine)
			(l as DeleteLine).prettyPrint
		println()
	}
	
	def prettyPrint(DeleteField l){
		print('field ')
		l.fields.prettyPrint
	}
	
	def prettyPrint(DeleteLine l){
		print('line ')
		l.lines.prettyPrint
	}
	
	def prettyPrint(Modify l){
		print('Modify ')
		if(l instanceof ModifyField)
			(l as ModifyField).prettyPrint
		if(l instanceof ModifyLine)
			(l as ModifyLine).prettyPrint
		if(l instanceof ModifyCell)
			(l as ModifyCell).prettyPrint
		println()
	}
	
	def prettyPrint(ModifyField l){
		print('field ')
		l.fields.prettyPrint
		print(' with ')
		l.values.prettyPrint
	}
	
	def prettyPrint(ModifyLine l){
		print('line ')
		l.lines.prettyPrint
		print(' with ')
		l.values.prettyPrint
	}
	
	def prettyPrint(ModifyCell l){
		print('cell ')
		l.cell.prettyPrint
		print(' with ')
		l.value.prettyPrint
	}
	
	def prettyPrint(Insert l){
		print('Insert ')
		if(l instanceof InsertField)
			(l as InsertField).prettyPrint
		if(l instanceof InsertLine)
			(l as InsertLine).prettyPrint
		println()
	}
	
	def prettyPrint(InsertField l){
		print('field ' + l.fieldname.value + ': ')
		l.values.prettyPrint
	}
	
	def prettyPrint(InsertLine l){
		print('line ')
		l.values.prettyPrint
	}
	
	def prettyPrint(Print l){
		print('Print ')
		if(l instanceof PrintField)
			(l as PrintField).prettyPrint
		if(l instanceof PrintLine)
			(l as PrintLine).prettyPrint
		if(l instanceof PrintCell)
			(l as PrintCell).prettyPrint
		if(l instanceof PrintTable)
			(l as PrintTable).prettyPrint
		if(l instanceof PrintExpr)
			(l as PrintExpr).prettyPrint
		println()
	}
	
	def prettyPrint(PrintField l){
		print('field ')
		l.fields.prettyPrint
	}
	
	def prettyPrint(PrintLine l){
		print('line ')
		l.lines.prettyPrint
	}
	
	def prettyPrint(PrintCell l){
		print('cell ')
		l.cell.prettyPrint
	}
	
	def prettyPrint(PrintTable l){
		print('table')
	}
	
	def prettyPrint(PrintExpr l){
		print('expr ')
		l.exp.prettyPrint
	}
	
	def prettyPrint(Values v){
		print("<Values>")
	}
	
	def prettyPrint(Value v){
		print("<Value>")
	}	
	
	def prettyPrint(Statement stmt){
		if(stmt instanceof Load){
			val l = stmt as Load
			l.prettyPrint
		}
		if(stmt instanceof Store){
			val l = stmt as Store
			l.prettyPrint
		}
		if(stmt instanceof ExportJson){
			val l = stmt as ExportJson
			l.prettyPrint
		}
		if(stmt instanceof Projection){
			val l = stmt as Projection
			l.prettyPrint
		}
		if(stmt instanceof Select){
			val l = stmt as Select
			l.prettyPrint
		}
		if(stmt instanceof Delete){
			val l = stmt as Delete
			l.prettyPrint
		}
		if(stmt instanceof Insert){
			val l = stmt as Insert
			l.prettyPrint
		}
		if(stmt instanceof Modify){
			val l = stmt as Modify
			l.prettyPrint
		}
		if(stmt instanceof Print){
			val l = stmt as Print
			l.prettyPrint
		}
	}
	
	def prettyPrint(FieldIndex f){
		if(f instanceof FieldIndexName){
			val x = f as FieldIndexName
			x.prettyPrint
		}
		if(f instanceof FieldIndexNum){
			val x = f as FieldIndexNum
			x.prettyPrint
		}
	}
	
	def prettyPrint(FieldIndexName f){
		print('<fieldIndexName>')
	}
	
	def prettyPrint(FieldIndexNum f){
		print('<fieldIndexNum>')
	}
	
	def prettyPrint(LineIndex f){
		if(f instanceof LineIndexCond){
			val x = f as LineIndexCond
			x.prettyPrint
		}
		if(f instanceof LineIndexNum){
			val x = f as LineIndexNum
			x.prettyPrint
		}
	}
	
	def prettyPrint(LineIndexCond f){
		print('<LineIndexCond>')
	}
	
	def prettyPrint(LineIndexNum f){
		print('<LineIndexNum>')
	}
	def prettyPrint(CellIndex f){
		print("(" + f.line + ", ")
		if( f.colname === null) {
			print(f.colnum)
		} else {
			print(f.colname.value)
		}
		print(")")		
	}
}