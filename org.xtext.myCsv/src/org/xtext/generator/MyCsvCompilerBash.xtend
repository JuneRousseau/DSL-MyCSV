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
 * Compiler to Bash
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MyCsvCompilerBash {

	val tmpCompilerPath="/tmp/myCsvCompilerBash/"	
	val currentCsvPath= tmpCompilerPath+"current.csv"
		
	def dispatch String compile(Program p){
		var res = "#!/bin/bash\n"
		res += "# INTRO\n\n"
		res += "# Workspace\n"
		res += "mkdir -p "+tmpCompilerPath+"\n"
		res += "echo \"\" > "+currentCsvPath+"\n"
		res += "sep='" + Csv.defaultSep + "'\n\n"	
		
		// Some useful functions (two is some)
		res += "# FUNCTIONS\n"
		res += "# Check if the parameters is a number or not\n"
		res += "isNumber () {\n"
		res += "\tvGreped=$(echo $1 | grep -E '[[:alpha:]]+')\n"
		res += "\tif [ $(echo 0$vGreped) = 0 ] ; then \n"
		res += "\t\techo 1\n" //it's a number
		res += "\telse\n"
		res += "\t\techo 0\n" //it isn't a number
		res += "\tfi\n"
		res += "}\n\n"
		
		res += "# Update some global variables\n\n"
		res += "refreshHeaderMetaInfo () {\n"
			res += "\theaderString=$(head -n 1 "+ currentCsvPath +" | sed 's/\\r//g')\n"
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
			res += "\tres=0\n"
			res += "\tf=$((${headerDict[$1]}+1))\n"
			res += "\tfor i in `seq 2 $(($(countLines) + 1))`; do\n"
				res += "\t\tline=$(head -n $i "+ currentCsvPath + " | tail -n 1)\n"
				res += "\t\tv=$(echo $line | cut -d $sep -f $f)\n"
				res += "\t\tres=$(echo $res+$v | bc)\n"
			res += "\tdone\n"
			res += "\techo $res\n"
		res += "}\n\n"
		
		res += "# Aggregative function making the product over a field\n"
		res+="product() {\n"
			res += "\tres=0\n"
			res += "\tf=$((${headerDict[$1]}+1))\n"
			res += "\tfor i in `seq 2 $(($(countLines) + 1))`; do\n"
				res += "\t\tline=$(head -n $i "+ currentCsvPath + " | tail -n 1)\n"
				res += "\t\tv=$(echo $line | cut -d $sep -f $f)\n"
				res += "\t\tres=$(echo $res*$v | bc)\n"
			res += "\tdone\n"
			res += "\techo $res\n"
		res += "}\n\n"
		
		res += "# Aggregative function computing the mean of a field\n"
		res+="mean() {\n"
			res+="\techo scale=10\\; $(sum $1)/$(countLines)| bc\n"
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
	
	def String refreshRoutine(){
		var res = ""
		res += "unset header\n"
		res += "declare header\n"
		res += "unset headerDict\n"
		res += "declare -A headerDict\n"
		res += "refreshHeaderMetaInfo\n"
		return res
	}
	
	def dispatch String compile(Load l){
		var res = "# LOAD\n"
		
		res += "rm -f "+currentCsvPath+"\n"
		
		var sep = ""
		if (l.isSepDefined()){
			sep = l.sep
		} else {
			sep = Csv.defaultSep
		}
		res += "sep='"+sep+"'\n"
		
		if(l.noHeader) {
			res += "headerString=$(head -n 1 "+ l.path.value +")\n"
			res += "nbField=$(awk -F\"${sep}\" '{print NF}' <<< \"${headerString}\")\n"
			res += "unset heads ; declare -a heads \n"
			res += "for n in `seq 0 $(($nbField-1))` ; do\n"
				res += "\theads[$(($n+1))]=$(echo field$n)\n"
			res +="done\n"
			res+= "headerLine=$(echo ${heads[@]}| sed \"s/ /$sep/g\" )\n"
			res += "echo $headerLine >> "+currentCsvPath+"\n"
			}
			
		res += "cat "+l.path.value+" >> "+currentCsvPath+"\n"
		res += "sed -i 's/\\r//g' "+currentCsvPath+"\n"
		res += refreshRoutine()
		return res
	}
	
	def dispatch String compile(Store l){
		var res = "# STORE\n"
		
		if (l.isSepDefined()){
			res += "sed \"s/$sep/"+l.sep+"/g\" "+currentCsvPath+" > "+l.path.value+"\n"
		} else {
			res += "cp "+currentCsvPath+" "+l.path.value+"\n"
		}

		if (l.noHeader){
			val tmpPath = tmpCompilerPath+"tmp"
			res += "tail -n $(countLines) "+l.path.value+" > "+tmpPath+"\n"
			res += "cp "+tmpPath+" "+l.path.value+"\n"
		}
		
		return res
	}
	
	def dispatch String compile(LineIndexCond f){
		var res = "unset lineIndex\n"
		res += "declare lineIndex\n"
		res += "for indexLine in `seq 2 $(($(countLines) + 1))` ; do\n"
			res += "\tline=$(head -n $indexLine "+ currentCsvPath + " | tail -n 1)\n"
			res += "\ttest=" + f.cond.compileExpressionLog+ "\n"
			res += "\tif [ $test = 1 ] ; then\n"
				res += "\t\tlineIndex[$indexLine]=$indexLine\n"
			res+= "\tfi\n"
		res += "done\n"
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
	
	def dispatch String compile(LineIndexNum f){
		var res = "unset lineIndex\n"
		res += "declare lineIndex\n"
		var cpt=1
		for(i : uniquefy(new ArrayList(f.lines))){
			res += "lineIndex["+cpt+"]="+(i+2)+"\n"
			cpt++
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
			res+= '"'+value.compileValue+'" '
		}
		res+=")\n"
		return res
	}
	
	def dispatch String compile(ExportJson l){
		var res = "# EXPORT JSON\n"
		val path = l.path.value
		res += "rm -f "+path+"\n"
		res += "touch "+path+"\n"
		
		res += "echo [ >> " + path + "\n"
		res += "for l in `seq 2 $(countLines)` ; do\n"
			res += "\techo { >> " + path + "\n"
			res += "\tline=$(head -n $l "+ currentCsvPath + " | tail -n 1 | sed 's/\\r//g')\n"
			res += "\tfor f in `seq 1 $(($nbField-1))` ; do\n"
				res += exportJsonAttribute(false, path, "\t\t")
			res += "\tdone\n"
			// Last field
			res += exportJsonAttribute(true, path, "\t")
			res += "\techo }, >> " + path + "\n"
		res += "done\n"
		
		// Last line
		res += "echo { >> " + path + "\n"
		res += "line=$(tail -n 1 "+currentCsvPath+" | sed 's/\\r//g')\n"
		res += "for f in `seq 1 $(($nbField-1))` ; do\n"
			res+= exportJsonAttribute(false, path, "\t")
		res += "done\n"
		// Last field
		res += exportJsonAttribute(true, path, "")
		res += "echo } >> " + path + "\n"
		
		res += "echo ] >> " + path + "\n"
	 	return res
	}
	
	def String exportJsonAttribute(boolean last, String path, String tab){
		var res = ""
		var comma = ","
		var varName = "$f"
		if(last){
			comma=""
			varName="$nbField"
		}
		res += tab+"value=$(echo $line | cut -d $sep -f "+varName+")\n"
		res += tab+"if [ $(isNumber $value) = 1 ] ; then\n"
			res += tab+"\tquote=''\n"
			/*
			float=$(echo $value | grep -E "^[.][0-9]*")
			if [ a$float != "a" ] ; do
			  value=0$value
			 */
			res += tab+"\tfloat=$(echo $value | grep -E \"^[.][0-9]*\")\n"
			res += tab+"\tif [ $(echo a$float) != \"a\" ] ; then\n"
				res += tab+"\t\tvalue=$(echo 0$value)\n"
			res += tab+"\tfi\n"
		res += tab+"else\n"
			res += tab+"\tquote='\"'\n"
		res += tab+"fi\n"
		res += tab+"echo -e '\t'\\\"${header[$(("+varName+"-1))]}\\\": $quote$value$quote"+comma+" >> "+path+"\n"
		return res
	}
	
	def dispatch String compile(Projection l){
		var res = "# PROJECTION\n"
		res += l.field.compile()
		val tmpCsvProjection = tmpCompilerPath + "tmpProjection.csv"
		res += "cut -d $sep -f $(echo ${fieldIndex[@]} | sed 's/\\ /,/g') "+currentCsvPath
				+" > "+tmpCsvProjection+"\n"
		res += "mv "+tmpCsvProjection+" "+ currentCsvPath+"\n"
		res += refreshRoutine()
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
		res += refreshRoutine()
	 	return res
	}
	def dispatch String compile(DeleteLine l){
		var res = "# DELETE LINE\n"
		res += l.lines.compile
		val tmpCsvDelete = tmpCompilerPath + "tmpDelete.csv"
		res += "unset lines\n"
		res += "declare -a lines\n"
		res += "lines=$(difference $(($(countLines)+1)) lineIndex)\n"
		res += "for i in ${lines[@]} ; do\n"
			res += "\thead -n $i "+ currentCsvPath + " | tail -n 1 >> "+ tmpCsvDelete + "\n"
		res += "done\n"
		res += "mv "+tmpCsvDelete +" "+ currentCsvPath +"\n"
	 	return res
	}
	
	def dispatch String compile(InsertField l){
		var res = "# INSERT FIELD\n"
		res += l.values.compile
		val tmpCsvInsert = tmpCompilerPath + "tmpInsert.csv"
		res += "unset localSep ; localSep=$sep\n"
		res += "if [ $(echo 0$headerString) = \"0\" ] ; then\n"
			res += "\tlocalSep=\"\"\n"
		res += "fi\n"
		res += "echo $(echo ${headerString})${localSep}"+l.fieldname.value+">>"+ tmpCsvInsert + "\n"
		res += "len_values=${#values[@]}\n"
		res += "for i in `seq $(countLines)` ; do\n"
			res += "\tj=$(($i-1))\n"
			res += "\tindex=$(echo $j%$len_values | bc)\n"
			res += "\tvalue=${values[$index]}\n"
			res += "\thead -n $(($i+1)) "+currentCsvPath+" | tail -n 1 | sed \"s/[[:space:]]*$/$localSep$value/\">>"+tmpCsvInsert+"\n"
		res +="done\n"
		res +="mv "+tmpCsvInsert+" "+ currentCsvPath +"\n"
		res += refreshRoutine()
	 	return res
	}
	def dispatch String
	 compile(InsertLine l){
		var res = "# INSERT LINE\n"
		res += l.values.compile
		res += "len_values=${#values[@]}\n"
		res += "new_line=\"\"\n"
		res += "for i in `seq 0 $(($nbField-1))` ; do\n"
			res += "\tindex=$(echo $i%$len_values | bc)\n"
			res += "\tnew_line=$(echo $new_line ${values[$index]})\n"
		res+="done\n"
		res+="echo $new_line | sed \"s/\\ /$sep/g\" >> "+currentCsvPath+"\n"
	 	return res
	}
	
	def dispatch String compile(ModifyField l){
		var res = "# MODIFY FIELD\n"
		val tmpCsvModify = tmpCompilerPath + "tmpModify.csv"
		res += l.values.compile //result in $values
		res += l.fields.compile //result in $fieldIndex
		
		res += "echo ${headerString} >>"+ tmpCsvModify + "\n"
		res += "len_values=${#values[@]}\n"
		res += "for l in `seq 1 $(countLines)` ; do\n" //for each line
			res += "\tnew_line=\"\"\n" //create new line
			res +="\tfor f in `seq $nbField` ; do\n" //for each fields
				res += "\t\tif [[ \" ${fieldIndex[@]} \" =~ \" ${f} \" ]]\n" //if we need to modify the field
				res += "\t\tthen\n"
				res += "\t\t\tindex=$(echo \\($l-1\\)%$len_values | bc)\n"
				res += "\t\t\tvalue=${values[$index]}\n" //get the value into the compiled values
				res += "\t\telse\n"
				res += "\t\t\tvalue=$(head -n $(($l+1)) "+currentCsvPath+" | tail -n 1 | cut -d $sep -f $f)\n" //get the value into the source line
				res += "\t\tfi\n"
				res += "\t\tnew_line=$(echo \"${new_line}${value}${sep}\")\n" //add the good value
			res += "\tdone\n"
			res += "\techo $new_line | sed \"s/\\ /$sep/g\" | sed 's/.$//' >> "+tmpCsvModify+"\n"
		res +="done\n"
		
		res +="mv "+tmpCsvModify+" "+ currentCsvPath +"\n"
	 	return res
	}
	def dispatch String compile(ModifyLine l){
		var res = "# MODIFY LINE\n"
		val tmpCsvModify = tmpCompilerPath + "tmpModify.csv"
		res += l.values.compile
		res += "len_values=${#values[@]}\n"
		res += "new_line=\"\"\n"
		res += "for i in `seq 0 $(($nbField-1))` ; do\n"
			res += "\tindex=$(echo $i%$len_values | bc)\n"
			res += "\tnew_line=$(echo $new_line ${values[$index]})\n"
		res +="done\n"
		res += l.lines.compile
		res += "for i in `seq 0 $(($(countLines)+1))` ; do\n"
			res += "\tif [[ \" ${lineIndex[@]} \" =~ \" ${i} \" ]]\n" //si i est dans lineIndex
			res += "\tthen\n"
			res += "\t\techo $new_line | sed \"s/\\ /$sep/g\" >> "+tmpCsvModify+"\n"
			res += "\telse\n"
			res += "\t\thead -n $i "+currentCsvPath+" | tail -n 1 >> "+tmpCsvModify+"\n"
			res += "\tfi\n"
		res +="done\n"
	 	res +="mv "+tmpCsvModify+" "+ currentCsvPath +"\n"
	 	return res
	}
	def dispatch String compile(ModifyCell l){
		var res = "# MODIFY CELL\n"
		val tmpCsvModify = tmpCompilerPath + "tmpModify.csv"
		res += "value="+l.value.compileValue+"\n"
		res += l.cell.compile // cellIndex[line] and cellIndex[col]
		res += "for l in `seq $(($(countLines)+1))` ; do \n"
			res += "\tif [ $l = ${cellIndex[line]} ]\n"
			res += "\tthen\n" //if the right line
				res += "\t\tnew_line=\"\"\n"
				res += "\t\tfor f in `seq $nbField` ; do\n"
					res += "\t\t\tif [ $f = ${cellIndex[col]} ]\n" //if the right field
					res += "\t\t\tthen\n"
						res += "\t\t\t\tnew_val=$value\n"
					res += "\t\t\telse\n"
						res += "\t\t\t\tnew_val=$(head -n $l "+currentCsvPath+" | tail -n 1 | cut -d $sep -f $f)\n"
					res += "\t\t\tfi\n"
					res += "\t\t\t\tnew_line=$(echo \"${new_line}${new_val}${sep}\")\n"
				res += "\t\tdone\n"
				res += "\t\techo $new_line | sed 's/.$//' >>"+tmpCsvModify+"\n"
			res += "\telse\n" //if not the right line
				res += "\t\thead -n $l "+currentCsvPath+" | tail -n 1 >> "+tmpCsvModify+"\n" //just add line
			res += "\tfi\n"
		
		res +="done\n"
		res +="mv "+tmpCsvModify+" "+ currentCsvPath +"\n"
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
	
	def dispatch String compile(RenameField l){
		var res = "# RENAME FIELD\n"
		val tmpCsvRename = tmpCompilerPath + "tmpRename.csv"
		res += "new_headers=\"\"\n"
		res += "for f in `seq 0 $(($nbField-1))` ; do\n"
			res += "\tif [ $(echo $f) = ${headerDict[\""+l.last_field.value+"\"]} ] ; then\n"
				res += "\t\tnew_headers=$(echo $new_headers \""+l.new_field.value+"\")\n"
			res += "\telse\n"
				res += "\t\tnew_headers=$(echo $new_headers ${header[$f]})\n"
			res += "\tfi\n"
		res +="done\n"
		res +="echo $new_headers | sed \"s/\\ /$sep/g\" > "+tmpCsvRename+"\n"
		res +="tail -n $(countLines) "+currentCsvPath+" >> "+tmpCsvRename+"\n"
		res += "mv "+tmpCsvRename+" "+currentCsvPath+"\n"
		res += "refreshHeaderMetaInfo\n"
	 	return res
	}

	def String compileExpressionLog(ExpressionLog l){
		return "$(echo scale=10\\;" + l.expr.compile + "| bc)"
	}

	def dispatch String compile(OrExpression l){
		var	res = l.lhs.compile
		for (expr : l.rhs)
		{
			res += " \\|\\| " + expr.compile
		}	// /!\ Whatch it: Escaping escape !
		return res	
	}

	def dispatch String compile(AndExpression l){
		var	res = l.lhs.compile
		for (expr : l.rhs)
		{
			res += " \\&\\& " + expr.compile
		}
		return res
	}

	def dispatch String compile(UnaryLogExpression l){
	 	var res = ""
		if (l.isNot)
		{
			res += "!"
		}
		return res + l.expr.compile
	}
	
	def dispatch String compile(ExpressionRel l){
		// awk is our best friend
		// echo <fieldValue> <expressionValue> | awk '{ print ($1 <op> $2) }'"
		// "$line" is available thanks to LineIndexCond compilation
		val fieldValue = "$(echo $line | cut -d $sep -f $((${headerDict["+l.field.value+"]} + 1)))"
		return "$(echo " + fieldValue + " "+l.getVal.compileValue+" | awk '{ print ($1 "+l.op.toString+" $2) }')"
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
				return "$(sum "+l.arg.value+")"
			}
			case PRODUCT: {
				return "$(product "+l.arg.value+")"
			}
			case MEAN: {
				return "$(mean "+l.arg.value+")"
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