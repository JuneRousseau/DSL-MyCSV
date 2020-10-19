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
 * Pretty-prints
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MyCsvCompilerPython {
	
	/* USEFULL CODE pour la gestion des headers lors des projections/delete fields
	 * 	res += "tmpHeaders = []\n"
	 *	res += "\ttmpHeaders.append(header[field])\n"
	 *	res += "header = tmpHeaders\n"
	 *	res += "headerDict = headerListToDict(header)"
	 */

	def dispatch String compile(Program p){
		var res = "# INTRO\n"
		res += "import csv\n"
		res += "import json\n\n"
		res += "# Note, name convention is as follow:\n"
		res += "# - data is a two-dimensional tabular\n"
		res += "# - row is a one-dimensional tabular\n"
		res += "# - line is a line index\n"
		res += "# - field is a column index\n"
		res += "# - values is a one-dimensional tabular\n\n"
		res += "data = []\n"
		res += "header = []\n"
		res += "headerDict = {}\n\n"
		
		res += "def Count(x):\n"
		res += "\treturn len(data)\n\n"
		
		res += "def Sum(x):\n"
		res += "\tres = 0\n"
		res += "\tfor row in data:\n"
		res += "\t\tres += row[x]\n"
		res += "\treturn res\n\n"
		
		res += "def Product(x):\n"
		res += "\tres = 1\n"
		res += "\tfor row in data:\n"
		res += "\t\tres *= row[x]\n"
		res += "\treturn res\n\n"
		
		res += "def Mean(x):\n"
		res += "\treturn Sum(x) / Count(x)\n\n"
		
		res += 'def exportJson(x):\n'
		res += '\tjsonText=""\n'
		res += '\tjsonText+="[\\n"\n'
		res += '\tfor i in range(len(data)-1):\n'
		res += '\t\tobjDict={}\n'
		res += '\t\trow=data[i]\n'
		res += '\t\tfor (i,head) in enumerate(header):\n'
		res += '\t\t\tobjDict[head]=row[i]\n'
		res += '\t\tjsonText+= json.dumps(objDict, indent=4)+",\\n"\n'
		res += '\tfor (i,head) in enumerate(header):\n'
		res += '\t\tobjDict[head]=data[-1][i]\n'
		res += '\tjsonText+= json.dumps(objDict, indent=4)+"\\n"\n'
		res += '\tjsonText+="]"\n'
		res += '\tf = open(x, "w")\n'
		res += '\tf.write(jsonText)\n'
		res += '\tf.close()\n\n'

		res += "def refreshHeaderDict():\n" //transforme une liste de headers en dictionnaire
		res += "\theaderDict={}\n"
		res += "\tfor (i,head) in enumerate(header):\n"
		res += '\t\theaderDict[head]=i\n\n'
		
		for(stmt : p.stmts) {
			res += stmt.compile() + "\n\n";
		}
		return res
	}
	
	def dispatch String compile(Load l){
		// Note : loading .csv with header sharing names happens badly
		// TODO : detect and differentiate strings and floats and ints
		var res = "#LOAD\n"
		res += "data = []\n"
		res += "header = []\n"
		res += "headerDict = {}\n"
		res += "with open('" + l.getPath.value + "', newline='') as csvfile:\n"
		
		res += "\treader = csv.reader(csvfile"
		if (l.isSepDefined()){
			res += ', delimiter = "' + l.sep + '"'
		}
		res += ")\n"
		
		if(!l.noHeader)
			res += "\theader = next(reader)\n"
			res += "\trefreshHeaderDict()\n"
		res += "\tfor line in reader:\n"
		res += "\t\tdata.append(line)"
		
		return res
	}
	
	def dispatch String compile(Store l){
		var res = "#STORE\n"
		res += "with open('" + l.getPath.value + "', 'w', newline='') as csvfile:\n"
		
		res += "\twriter = csv.writer(csvfile"
		if (l.isSepDefined()){
			res += ', delimiter = "' + l.sep + '"'
		}
		res += ")\n"
		
		res += "\twriter.writerow(header)\n"
		res += "\tfor line in data:\n"
		res += "\t\twriter.writerow(line)\n"
		
		return res
	}
	
	def dispatch String compile(LineIndexCond f){
	 	var res = "lines = []\n"
	 	res += "for (i, row) in enumerate(data):\n"
	 	res += "\tif (" + f.cond.compile +"):\n"
	 	res += "\tlines.append(i)\n"
	 	return res
	}
	
	def dispatch String compile(LineIndexNum f){
		var res = "lines = ["
		var first = true
		for(lineNum : f.lines)
		{
			if(!first)
				res += ", "
			res += lineNum
			first = false
		}
		res += "]\n"
		return res
	}
	
	def dispatch String compile(FieldIndexName f){
		var res = "fields = ["
		var first = true
		for(field : f.fields)
		{
			if(!first)
				res += ", "
			res += 'headerDict["' + field.value + '"]'
			first = false
		}
		res += "]\n"
		return res
	}
	def dispatch String compile(FieldIndexNum f){
		var res = "fields = ["
		var first = true
		for(colNum : f.columns)
		{
			if(!first)
				res += ", "
			res += colNum
			first = false
		}
		res += "]\n"
		return res
	}
	
	def dispatch String compile(CellIndex f){
		var res= "data[" + f.line + "]["
		if( f.colname === null) {
			res += f.colnum
		} else {
			res += 'headerDict["' + f.colname.value + '"]'
		}
		res += "]"
		return res	
	}
	
	
	def dispatch String compile(Values v){
		var res = "values = ["
		var first = true
		for(value : v.values)
		{
			if(!first)
				res += ", "
			res += value.compile
			first = false
		}
		res += "]\n"
		return res
	}
	
	def dispatch String compile(ExportJson l){
		var res = "# EXPORT JSON\n"
		return res + "exportJson('" + l.getPath.value + "')"
	}
	def dispatch String compile(Projection l){
		var res = "# PROJECTION\n"
		res += l.field.compile
		res += "fields.sort(reverse=True)\n"
		res += "for i in range(len(header):\n"
		res += "\tif !(i in field):\n"
		res += "\t\tdel header[i]\n"
		res += "\t\tfor row in data:\n"
		res += "\t\t\tdel row[i]\n"
		res += "refreshHeaderDict()\n"
		return res
	}
	def dispatch String compile(Select l){
		var res = "# SELECT\n"
		res += l.line.compile
		res += "tmp = []\n"
		res += "for line in lines:\n"
		res += "\ttmp.append(data[line])\n"
		res += "data = tmp\n"
		return res
	}
	
	def dispatch String compile(DeleteField l){
		var res = "# DELETE FIELD\n"
		res += l.fields.compile
		res += "fields.sort(reverse=True)\n"
		res += "for field in fields:\n"
		res += "\tdel header[field]\n"
		res += "\tfor row in data:\n"
		res += "\t\tdel row[field]\n"
		res += "refreshHeaderDict()\n"
		return res
	}
	def dispatch String compile(DeleteLine l){
		var res = "# DELETE LINE\n"
		res += l.lines.compile
		res += "lines.sort(reverse=True)\n"
		res += "for line in lines:\n"
		res += "\tdel data[line]\n"
		return res
	}
	
	def dispatch String compile(InsertField l){
		var res = "# INSERT FIELD\n"
		res += l.values.compile
		res += "for (i, row) in enumerate(data):\n"
		res += "\trow.append(values[i % len(values)]) #little trick to get correct semantics\n"
		res += 'header.append("' + l.fieldname.value + '")\n'
		res += 'refreshHeaderDict()\n'
		return res
	}
	def dispatch String compile(InsertLine l){
		var res = "# INSERT LINE\n"
		res += l.values.compile
		res += "data.append(values)\n"
		return res
	}
	
	def dispatch String compile(ModifyField l){
		var res = "# MODIFY FIELD\n"
		res += l.values.compile
		res += l.fields.compile
		res += "for (i, row) in enumerate(data):\n"
		res += "\tfor field in fields:\n"
		res += "\t\trow[field] = values[i % len(values)] #little trick to get correct semantics\n"
		return res
	}
	def dispatch String compile(ModifyLine l){
		var res = "# MODIFY LINE\n"
		res += l.values.compile
		res += l.lines.compile
		res += "for line in lines:\n"
		res += "\tdata[line] = values.copy() # copy is needed\n"
		return res
	}
	def dispatch String compile(ModifyCell l){
		var res = "# MODIFY CELL\n"
		return res + l.cell.compile + " = " + l.value.compile
	}
	
	def dispatch String compile(PrintField l){
		var res = "# PRINT FIELD\n"
		res += l.fields.compile
		res += 'for field in fields:\n'
		res += '\tprint("Field " + str(field) + ":")\n'
		res += '\tfor row in data:\n'
		res += '\t\tprint(row[field])'
		return res
	}
	def dispatch String compile(PrintLine l){
		var res = "# PRINT LINE\n"
		res += l.lines.compile
		res += 'for line in lines:\n'
		res += '\tprint(data[line])'
		return res
	}
	def dispatch String compile(PrintCell l){
		var res = "# PRINT CELL\n"
		return res + "print(" + l.cell.compile + ")"
	}
	def dispatch String compile(PrintTable l){
		var res = "# PRINT TABLE\n"
		res += "print(header)\n"
		res += "for row in data:\n"
		return res + "\tprint(row)"
	}
	def dispatch String compile(PrintExpr l){
		var res = "# PRINT EXPR\n"
		res += "print(" + l.exp.compile + ")"
		return res
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
		return 'row[headerDict["' + l.field.value + '"]]' + l.op.toString + l.getVal.compile //+ " " //?
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
			res = res + expr.compile // op is inside of expr
		}
		return res
	}
	
	def dispatch String compile(AdditiveExpressionRhs l){
		return " " + l.op.toString + " " + l.rhs.compile
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
		return " " + l.op.toString + " " + l.rhs.compile
	}

	def dispatch String compile(UnaryExpression l){
		var res = ""
		if (l.isOp) {res += "-"}
		return res+l.expr.compile
	}
	
	def dispatch String compile(NbField l){
		return "len(data[0])" // fail when data is empty
	}
	def dispatch String compile(AggregatExpression l){
		return l.aggregatOp.toString + '(headerDict["' + l.arg.value + '"])'
	}
	def dispatch String compile(LitteralInt l){
		return l.getVal.toString
		
	}
	def dispatch String compile(LitteralFloat l){
		return l.getVal.toString
	}
	def dispatch String compile(NestedExpressionCalcul l){
		return "(" + l.expr.compile + ")"
	}	
	def dispatch String compile(LitteralString l){
		return '"' + l.getVal + '"'
	}
}