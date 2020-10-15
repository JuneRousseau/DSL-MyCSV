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
class MyCsvCompilerPython {

	def dispatch String compile(Program p){
		var res = "from csv import *\n"
		res += "data = []\n"
		res += "header = []\n"
		res += "headerDict = {}\n"
		// TODO initialiser un csv vide
		// TODO definir les fonctions aggregatives
		for(stmt : p.stmts) {
			res += stmt.compile();
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
	
	def dispatch String compile(ExportJson l){
		print('ExportJson "' + l.getPath.value + '"')
	}
	
	def dispatch String compile(Projection l){
		print("Projection ")
		l.field.compile
	}
	
	def dispatch String compile(Select l){
		print("Select ")
		l.line.compile
	}
	
	def dispatch String compile(Delete l){
		print('Delete ')
		l.compileDelete
	}
	
	def dispatch String compileDelete(DeleteField l){
		print('field ')
		l.fields.compile
	}
	
	def dispatch String compileDelete(DeleteLine l){
		print('line ')
		l.lines.compile
	}
	
	def dispatch String compile(Modify l){
		print('Modify ')
		l.compileModify
	}
	
	def dispatch String compileModify(ModifyField l){
		print('field ')
		l.fields.compile
		print(' with ')
		l.values.compile
	}
	
	def dispatch String compileModify(ModifyLine l){
		print('line ')
		l.lines.compile
		print(' with ')
		l.values.compile
	}
	
	def dispatch String compileModify(ModifyCell l){
		print('cell ')
		l.cell.compile
		print(' with ')
		l.value.compile
	}
	
	def dispatch String compile(Insert l){
		print('Insert ')
		l.compileInsert
	}
	
	def dispatch String compileInsert(InsertField l){
		print('field ' + l.fieldname.value + ': ')
		l.values.compile
	}
	
	def dispatch String compileInsert(InsertLine l){
		print('line ')
		l.values.compile
	}
	
	def dispatch String compile(Print l){
		print('Print ')
		l.compilePrint
	}
	
	def dispatch String compilePrint(PrintField l){
		print('field ')
		l.fields.compile
	}
	
	def dispatch String compilePrint(PrintLine l){
		print('line ')
		l.lines.compile
	}
	
	def dispatch String compilePrint(PrintCell l){
		print('cell ')
		l.cell.compile
	}
	
	def dispatch String compilePrint(PrintTable l){
		print('table')
	}
	
	def dispatch String compilePrint(PrintExpr l){
		print('expr ')
		l.exp.compile
	}
	
	def dispatch String compile(Values v){
		print("<Values>")
	}
	
	def dispatch String compile(Value v){
		print("<Value>")
	}
	
	def dispatch String compile(FieldIndexName f){
		print('<fieldIndexName>')
	}
	
	def dispatch String compile(FieldIndexNum f){
		print('<fieldIndexNum>')
	}
	
	def dispatch String compile(LineIndexCond f){
		print('<LineIndexCond>')
	}
	
	def dispatch String compile(LineIndexNum f){
		print('<LineIndexNum>')
	}

	def dispatch String compile(CellIndex f){
		print("(" + f.line + ", ")
		if( f.colname === null) {
			print(f.colnum)
		} else {
			print(f.colname.value)
		}
		print(")")		
	}
}