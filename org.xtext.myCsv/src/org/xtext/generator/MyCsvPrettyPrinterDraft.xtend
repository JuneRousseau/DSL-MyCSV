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

	def dispatch prettyPrint(Program p){
		for(stmt : p.stmts) {
			stmt.prettyPrint();
		}
	}
	
	def dispatch prettyPrint(Load l){
		print('Load "' + l.getPath.value + '"')
		if (l.isSepDefined()){
			print(' sep="' + l.sep + '"')
		}
		if (l.isNoHeader()){
			print(" noheader")
		}
		println()
	}
	
	def dispatch prettyPrint(Store l){
		print('Store "' + l.getPath.value + '"')
		if (l.isSepDefined()){
			print(' sep="' + l.sep + '"')
		}
		println()
	}
	
	def dispatch prettyPrint(ExportJson l){
		println('ExportJson "' + l.getPath.value + '"')
	}
	
	def dispatch prettyPrint(Projection l){
		print("Projection ")
		l.field.prettyPrint
		println()
	}
	
	def dispatch prettyPrint(Select l){
		print("Select ")
		l.line.prettyPrint
		println()
	}
	
	def dispatch prettyPrint(Delete l){
		print('Delete ')
		l.prettyPrint
		println()
	}
	
	def dispatch prettyPrint(DeleteField l){
		print('field ')
		l.fields.prettyPrint
	}
	
	def dispatch prettyPrint(DeleteLine l){
		print('line ')
		l.lines.prettyPrint
	}
	
	def dispatch prettyPrint(Modify l){
		print('Modify ')
		l.prettyPrint
	}
	
	def dispatch prettyPrint(ModifyField l){
		print('field ')
		l.fields.prettyPrint
		print(' with ')
		l.values.prettyPrint
	}
	
	def dispatch prettyPrint(ModifyLine l){
		print('line ')
		l.lines.prettyPrint
		print(' with ')
		l.values.prettyPrint
	}
	
	def dispatch prettyPrint(ModifyCell l){
		print('cell ')
		l.cell.prettyPrint
		print(' with ')
		l.value.prettyPrint
	}
	
	def dispatch prettyPrint(Insert l){
		print('Insert ')
		l.prettyPrint
	}
	
	def dispatch prettyPrint(InsertField l){
		print('field ' + l.fieldname.value + ': ')
		l.values.prettyPrint
	}
	
	def dispatch prettyPrint(InsertLine l){
		print('line ')
		l.values.prettyPrint
	}
	
	def dispatch prettyPrint(Print l){
		print('Print ')
		l.prettyPrint
	}
	
	def dispatch prettyPrint(PrintField l){
		print('field ')
		l.fields.prettyPrint
	}
	
	def dispatch prettyPrint(PrintLine l){
		print('line ')
		l.lines.prettyPrint
	}
	
	def dispatch prettyPrint(PrintCell l){
		print('cell ')
		l.cell.prettyPrint
	}
	
	def dispatch prettyPrint(PrintTable l){
		print('table')
	}
	
	def dispatch prettyPrint(PrintExpr l){
		print('expr ')
		l.exp.prettyPrint
	}
	
	def dispatch prettyPrint(Values v){
		print("<Values>")
	}
	
	def dispatch prettyPrint(Value v){
		print("<Value>")
	}	
	
	def dispatch prettyPrint(Statement stmt){
		stmt.prettyPrint
		println()
	}
	
	def dispatch prettyPrint(FieldIndex f){
		f.prettyPrint
	}
	
	def dispatch prettyPrint(FieldIndexName f){
		print('<fieldIndexName>')
	}
	
	def dispatch prettyPrint(FieldIndexNum f){
		print('<fieldIndexNum>')
	}
	
	def dispatch prettyPrint(LineIndex f){
		f.prettyPrint
	}
	
	def dispatch prettyPrint(LineIndexCond f){
		print('<LineIndexCond>')
	}
	
	def dispatch prettyPrint(LineIndexNum f){
		print('<LineIndexNum>')
	}
	def dispatch prettyPrint(CellIndex f){
		print("(" + f.line + ", ")
		if( f.colname === null) {
			print(f.colnum)
		} else {
			print(f.colname.value)
		}
		print(")")		
	}
}