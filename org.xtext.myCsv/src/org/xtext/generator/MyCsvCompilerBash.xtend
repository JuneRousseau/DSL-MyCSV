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
	val currentCsvPath= tmpCompilerPath+"current.csv"
	var String sep = Csv.defaultSep
		
	def dispatch String compile(Program p){
		var res = "#!/bin/bash\n"
		res += "# INTRO\n\n"
		res += "# Workspace\n"
		res += "mkdir -p "+tmpCompilerPath+"\n"
		res += "sep='" + Csv.defaultSep + "'\n\n"	
		
		// Some useful functions (two is some)
		res += "# FUNCTIONS\n"
		res += "# Update some global variables\n\n"
		res += "refreshHeaderMetaInfo () {\n"
			res += "\theaderString=$(head -n 1 "+ currentCsvPath +")\n"
			res += "\tnbField=$(awk -F\"${sep}\" '{print NF}' <<< \"${headerString}\")\n"
			//                awk -F"${sep}" '{print NF}' <<< "${headerString}"
			
			// Creating variable header
			res += "\tfor n in `seq $nbField` ; do header[$(($n - 1))]=$(echo $headerString | cut -d $sep -f $n) ; done\n"
			// Creating variable headerDict, we just reverse key and value
			res += "\tfor n in `seq $nbField` ; do headerDict[$(echo $headerString | cut -d $sep -f $n)]=$(($n - 1)) ; done\n"
		res += "}\n\n"
		
		res += "# Aggregative function counting lines of data\n"
		res += "countLines () {\n"
			res += "\tawk 'END{print NR - 1}' "+currentCsvPath+"\n"
			//```wc -l input.csv | cut -d " " -f 1``` doesn't work!! (because of wether there is a \n a the end of the file...)
		res += "}\n\n"
		
		res += "# Aggregative function summing over a field\n"
		res += "sum () {\n"
			res += "\techo 0\n"
		res += "}\n\n"
		
		res += "# Aggregative function making the product over a field\n"
		res+="product() {\n"
		  res+="\techo 0\n"
		res+="}\n\n"
		
		res += "# Aggregative function computing the mean of a field\n"
		res+="mean() {\n"
		  res+="\techo 0\n"
		res+="}\n\n"
		
		res += "# Takes a number n and a list l of natural under n.\n"
		res += "# returns the complement of l in [[1;n]].\n"
		res+="difference() {\n"
			res+="\tunset n; declare n\n"
			res+="\tcpt=1\n"

			res+="\tname=$2[@]\n"
			res+="\tl=(\"${!name}\")\n"

			res+="\tfor e in `seq $1` ; do\n"
			res+="\tif [[ ! \" ${l[@]} \" =~ \" ${e} \" ]]\n"
			res+="\tthen\n"
			res+="\tn[$cpt]=$e\n"

			res+="\tcpt=$(($cpt+1))\n"
			res+="\tfi\n"

			res+="\tdone\n"
			res+="\techo ${n[@]}; return 0\n"

			res+="}\n\n"

		for(stmt : p.stmts) {
			res += stmt.compile+"\n"
		}		
		res += "# OUTRO\n"
		res += "# Cleaning workspace\n"
		res += "rm "+tmpCompilerPath+"*\n"
		res += "rmdir "+tmpCompilerPath+"\n"
		return res
	}
	
	def dispatch String compile(Load l){
		var res = "# LOAD\n"
		res += "cp "+l.path.value+" "+currentCsvPath+"\n"

		var localSep = ""
		if (l.isSepDefined()){
			localSep = l.sep
		} else {
			localSep = sep
		}
		res += "sep='"+localSep+"'\n"
		
		if(!l.noHeader)
			//throw new IllegalArgumentException("Not Implemented yet. (handling .csv without header)")
			res += ""
		res += "unset header\n"
		res += "declare header\n"
		res += "unset headerDict\n"
		res += "declare -A headerDict\n"
		res += "refreshHeaderMetaInfo\n"
		return res
	}
	
	def dispatch String compile(Store l){
		var res = "# STORE\n"
		
		if (l.isSepDefined()){
			res += "sed 's/"+ sep + "/"+l.sep+"/g' "+currentCsvPath+" > "+l.path.value+"\n"
		} else {
			res += "cp "+currentCsvPath+" "+l.path.value+"\n"
		}
		
		return res
	}
	
	def dispatch String compile(LineIndexCond f){
		var res = "unset lineIndex\n"
		res += "declare lineIndex\n"
	 	return res + "#TODO\n" // TODO
	}
	
	def dispatch String compile(LineIndexNum f){
		var res = "unset lineIndex\n"
		res += "declare lineIndex\n"
		var c = 0
		for(i : f.lines){
			res += "lineIndex["+c+"]="+(i+2)+"\n"
			c++
		}
		return res
	}
	
	def dispatch String compile(FieldIndexName f){
		var res = "unset fieldIndex\n"
		res += "declare -A fieldIndex\n"
		for(field : f.fields)
		{
			res+="fieldIndex["+field.value+"]="+"$((${headerDict["+ field.value +"]} + 1))"+"\n"
		}
		return res
	}
	def dispatch String compile(FieldIndexNum f){
		var res = "unset fieldIndex\n"
		res += "declare fieldIndex\n"
		for(colNum : f.columns)
		{
			res+="fieldIndex["+colNum+"]="+(colNum+1)+"\n"
			// /!\ watch it
			// implementation of anti-redondance for FieldIndexNum
			// /!\ watch it
			// "+1" here to go from abstract indexation (colNum) (starting at 0)
			// to concrete indexation (colnum+1) (starting at 1) (that's for cut :) )
		}
		return res
	}
	
	def dispatch String compile(CellIndex f){
		var res = "unset cellIndex\n"
		res += "declare -A cellIndex\n"
		var colIndexString = ""
		if(f.colname === null) {
			colIndexString = f.colnum.toString
		} else {
			colIndexString = "${headerDict["+ f.colname.value +"]}"
		}
		// "+2" and "+1" are conversion from abstract to concrete indexation
		// Abstract indexation always starts at 0
		// 1 more offset is needed for line concrete indexation because of the header line
		res+="cellIndex[line]="+(f.line + 2)+"\n" // /!\ watch it
		res+="cellIndex[col]="+"$(("+ colIndexString + " + 1))\n" // /!\ watch it
		
		return res	
	}
	
	
	def dispatch String compile(Values v){
		var res = ""
		res+="unset values\n"
		res+="values=( "
		for(value : v.values)
		{
			res+= value.compileValue+" "
		}
		res+=")\n"
		return res
	}
	
	def dispatch String compile(ExportJson l){
		var res = "# EXPORT JSON\n"
	 	return res
	}
	def dispatch String compile(Projection l){
		var res = "# PROJECTION\n"
		res += l.field.compile()
		val tmpCsvProjection = tmpCompilerPath + "tmpProjection.csv"
		res += "cut -d $sep -f $(echo ${fieldIndex[@]} | sed 's/\\ /,/g') "+currentCsvPath
				+" > "+tmpCsvProjection+"\n"
		res += "mv "+tmpCsvProjection+" "+ currentCsvPath+"\n"
		res += "unset header\n"
		res += "declare header\n"
		res += "unset headerDict\n"
		res += "declare -A headerDict\n"
		res += "refreshHeaderMetaInfo\n"
	 	return res
	}
	def dispatch String compile(Select l){
		var res = "# SELECT\n"
		res += l.line.compile
		val tmpCsvSelect = tmpCompilerPath + "tmpSelect.csv"
		res += "echo $headerString >> "+ tmpCsvSelect + "\n"
		res += "for i in ${lineIndex[@]} ; do"
			res += "\thead -n $i "+ currentCsvPath + " | tail -n 1 >> "+ tmpCsvSelect + "\n"
		res += "done\n"
		res += "mv "+tmpCsvSelect+" "+currentCsvPath+"\n"
		return res
	}
	
	def dispatch String compile(DeleteField l){
		var res = "# DELETE FIELD\n"
		res += l.fields.compile()
		res += "unset fields\n"
		val tmpCsvDelete = tmpCompilerPath + "tmpDelete.csv"
		res += "declare -a fields\n"
		res += "fields=$(difference $nbField fieldIndex)\n"
		res += "cut -d $sep -f $(echo ${fields[@]} | sed 's/\\ /,/g') "+currentCsvPath
				+" > "+tmpCsvDelete+"\n"
		res += "mv "+tmpCsvDelete+" "+currentCsvPath+"\n"
		res += "unset header\n"
		res += "declare header\n"
		res += "unset headerDict\n"
		res += "declare -A headerDict\n"
		res += "refreshHeaderMetaInfo\n"
	 	return res
	}
	def dispatch String compile(DeleteLine l){
		var res = "# DELETE LINE\n"
		res += l.lines.compile
		val tmpCsvDelete = tmpCompilerPath + "tmpDelete.csv"
		res += "unset lines\n"
		res += "declare -a lines\n"
		res += "lines=$(difference $(countLines) lineIndex)\n"
		res += "for i in ${lines[@]} ; do\n"
			res += "\thead -n $i "+ currentCsvPath + " | tail -n 1 >> "+ tmpCsvDelete + "\n"
		res += "done\n"
		res += "mv "+tmpCsvDelete +" "+ currentCsvPath +"\n"
	 	return res
	}
	
	def dispatch String compile(InsertField l){
		var res = "# INSERT FIELDS\n"
		res += l.values.compile
		val tmpCsvInsert = tmpCompilerPath + "tmpInsert.csv"
		res += "echo $(echo ${headerString} | sed \"s/.$//\")${sep}"+l.fieldname.value+">>"+ tmpCsvInsert + "\n"
		res += "len_values=${#values[@]}\n"
		res += "for i in `seq $(countLines)` ; do\n"
			res += "\tj=$(($i-1))\n"
			res += "\tindex=$(echo $j%$len_values | bc)\n"
			res += "\tvalue=${values[$index]}\n"
			res += "\thead -n $(($i+1)) "+currentCsvPath+" | tail -n 1 | sed \"s/[[:space:]]*$/$sep$value/\">>"+tmpCsvInsert+"\n"
		res +="done\n"
		res +="mv "+tmpCsvInsert+" "+ currentCsvPath +"\n"
	 	return res
	}
	def dispatch String
	 compile(InsertLine l){
		var res = "# INSERT LINE\n"
		res += l.values.compile
		res += "len_values=${#values[@]}\n"
		res += "new_line=\"\"\n"
		res += "for i in `seq 0 $nbField` ; do\n"
			res += "\tindex=$(echo $i%$len_values | bc)\n"
			res += "\tnew_line=$(echo $new_line ${values[$index]})\n"
		res+="done\n"
		res+="echo $new_line | sed \"s/\\ /$sep/g\" >> "+currentCsvPath+"\n"
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
		res += l.fields.compile()
		res += "for i in ${fieldIndex[@]} ; do echo Field $(($i -1)):; tail -n $(($(countLines)-1)) "+currentCsvPath+" | cut -d $sep -f $i; done\n"
	 	return res
	}
	def dispatch String compile(PrintLine l){
		var res = "# PRINT LINE\n"
		res += l.lines.compile
		res += "for i in ${lineIndex[@]} ; do head -n $i "+ currentCsvPath + " | tail -n 1 ; done\n"
		return res
	}
	def dispatch String compile(PrintCell l){
		var res = "# PRINT CELL\n"
		res += l.cell.compile
		res += "head -n ${cellIndex[line]} "+ currentCsvPath +" | tail -n 1 | cut -d $sep -f ${cellIndex[col]}\n"
	 	return res
	}
	def dispatch String compile(PrintTable l){
		var res = "# PRINT TABLE\n"
		res += "cat "+currentCsvPath+"\n"
	 	return res
	}
	def dispatch String compile(PrintExpr l){
		var res = "# PRINT EXPR\n"
	 	return res + "echo " + l.exp.compileValue
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
		return "" //TODO
	}

	def dispatch String compile(NestedLogExpression l){
		return "(" + l.expr.compile + ")"
	}

	def dispatch String compileValue(ExpressionCalcul l){
		return "$(echo scale=10\\;" + l.expr.compileExpressionCalcul + "| bc)"
	}

	def dispatch String compileExpressionCalcul(AdditiveExpression l){
		var	res = l.lhs.compileExpressionCalcul
		for (expr : l.rhs)
		{
			res = res + expr.compileExpressionCalcul // op is inside of expr
		}
		return res
	}
	
	def dispatch String compileExpressionCalcul(AdditiveExpressionRhs l){
		return " " + l.op.toString + " " + l.rhs.compileExpressionCalcul
	}

	def dispatch String compileExpressionCalcul(MultiplicativeExpression l){
		var	res = l.lhs.compileExpressionCalcul
		for (expr : l.rhs)
		{
			res = res + expr.compileExpressionCalcul
		}
		return res
	}
	
	def dispatch String compileExpressionCalcul(MultiplicativeExpressionRhs l){
		return " \\" + l.op.toString + " " + l.rhs.compileExpressionCalcul
		// We escape the "*" operator so that it's a "times" and not the * from bash.
		// Escapting the "/" doesn't matter...
	}

	def dispatch String compileExpressionCalcul(UnaryExpression l){
		var res = ""
		if (l.isOp) {res += "-"}
		return res+l.expr.compileExpressionCalcul
	}
	
	def dispatch String compileExpressionCalcul(NbField l){
		return "$nbField"
	}
	def dispatch String compileExpressionCalcul(AggregatExpression l){
		switch (l.aggregatOp) {
			case COUNT: {
				return "$(countLines)"
			}
			case SUM: {
				return "$(sum "+l.arg.value+")" //TODO
			}
			case PRODUCT: {
				return "0" //TODO
			}
			case MEAN: {
				return "0" //TODO
			}
			default: {
				throw new IllegalArgumentException("Aggregative expression implemented are only Count, Sum, Product, and Mean.")
			}
		}
	}
	def dispatch String compileExpressionCalcul(LitteralInt l){
		return l.getVal.toString
	}
	def dispatch String compileExpressionCalcul(LitteralFloat l){
		return l.getVal.toString
	}
	def dispatch String compileExpressionCalcul(NestedExpressionCalcul l){
		return "(" + l.expr.compileExpressionCalcul + ")"
	}
	def dispatch String compileValue(LitteralString l){
		return '"' + l.getVal + '"'
	}
}