package org.xtext.generator

import java.io.File
import java.util.Scanner
import java.util.ArrayList
import java.util.HashMap
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import java.io.IOException
import java.util.Comparator
import org.xtext.myCsv.BinOpRel
import java.io.FileNotFoundException

class Csv {
	
	var ArrayList<ArrayList<Value>> data
	var ArrayList<String> header
	var HashMap<String, Integer> headerDict
	var String sep
	
	new (){
		data = new ArrayList
		header = new ArrayList
		headerDict = new HashMap
		sep = defaultSep
	}
	
	new (String path){
		this(path, defaultSep, false)
	}
	
	new (String path, String sep, boolean noHeader){
		data = new ArrayList
		header = new ArrayList
		this.sep = sep
				
		try {
			val file = new File(System.getProperty("user.dir") + "/" + path)
			val scan = new Scanner(file)
			
			if(noHeader){
				if (scan.hasNextLine){
					val line = scan.nextLine
					val ind = parseCsvLine(line, sep)
					data.add(ind)
					header = new ArrayList<String>
					for(var i = 0; i < ind.length ; i++){
						header.add(i.toString)
					}
				} else {
					throw new IllegalArgumentException("Empty CSV not handled.")
				}
			} else {
				val line = scan.nextLine
				header = parseHeader(line, sep)
			}
			
			while(scan.hasNextLine){
				val line = scan.nextLine
				data.add(parseCsvLine(line, sep))
			}
		} catch (FileNotFoundException e) {
			//Absent file results into empty Csv Object, no problem ;)
		}
		refreshHeaderDict
	}
	
	def refreshHeaderDict(){
		headerDict = new HashMap
		for(var int i = 0 ; i < header.length() ; i++){
			headerDict.put(header.get(i), i)
		}
	}
	
	def static String defaultSep(){
		return ","
	}
	
	def static private ArrayList<String> parseHeader(String line, String sep) {
		return new ArrayList(line.split(sep))
	}
	
	def static private ArrayList<Value> parseCsvLine(String line, String sep) {
		val res = new ArrayList
		val String[] rawValues = line.split(sep) 
		for(v : rawValues){
			res.add(Value.build(v))
		}		
		return res
	}
	
	def count(String fieldId){
		return nbLines
	}
	
	def sum(String fieldId){
		val field = headerDict.get(fieldId)
		var res = 0.0
		for(row : data){
			res += row.get(field).d
		}
		return res
	}
	
	def product(String fieldId){
		val field = headerDict.get(fieldId)
		var res = 1.0
		for(row : data){
			res *= row.get(field).d
		}
		return res
	}
	
	def mean(String fieldId){
		return sum(fieldId) / count(fieldId)
	}
	
	def toStringOpt(boolean noheader){
		var str=""
		var first = true
		
		if(!noheader) {
			for (head : header)
			{
				if(!first) str += sep
				str += head
				first=false
			}
			str+="\n"
		}
		for (line : data)
		{
			first= true
			for (value : line)
			{
				if(!first) str+=sep
				str+=value.toString
				first=false
			}
			str+="\n"
		}
		return str
	}
	
	override toString(){
		return toStringOpt(false)
	}
	
	def storeCsv(String path, String sep, boolean noheader) {
		this.sep = sep
		val output = toStringOpt(noheader)
		val pathStr = System.getProperty("user.dir") + "/" + path
		try {
    		Files.writeString(Paths.get(pathStr), output, StandardCharsets.UTF_8);
		} catch (IOException ex) {
			print("Exception occured: " + ex + "\n----------------------\n\n\n\n")
		}
	}
	
		
	def private prettyPrintJSON() {
		var output= ""
		
		output+="[\n"
		var first=true
		for(row : data)
		{
			if(!first) output+=",\n"
			output+=prettyPrintJSONObject(row)
			first=false
		}
		
		output+="\n]"
		return output
	}
	
	def private prettyPrintJSONObject(ArrayList<Value> row)
	{
		var output=""
		output+="{\n"
		var first=true
		for(var i=0; i<header.length; i++)
		{
			if(!first) output+=",\n"
			output+='    "'+header.get(i)+'"'+": "
			
			val value=row.get(i)
			if(value.type=="str")
			{
				output+='"'+value.toString+'"'
			}
			else
			{
				output+=value.toString
			}
			first=false
		}
		
		output+="\n}"	
		return output
	}
	
	
	def exportJson(String path) {
		var output=prettyPrintJSON()
		
		val pathStr = System.getProperty("user.dir") + "/" + path
		try {
    		Files.writeString(Paths.get(pathStr), output, StandardCharsets.UTF_8);
		} catch (IOException ex) {
			print("Exception occured: " + ex + "\n----------------------\n\n\n\n")
		}
	}
	
	def void select(ArrayList<Integer> lineIndex) {
		var tmpData = new ArrayList<ArrayList<Value>>
		for(index : lineIndex){
			tmpData.add(data.get(index))
		}
		data = tmpData
	}
	
	def projection(ArrayList<Integer> fieldIndex) {
		var tmpData = new ArrayList<ArrayList<Value>>
		for(row : data){
			var tmpRow=new ArrayList<Value>			
			for (var i=0; i<row.length ; i++)
			{
				if(fieldIndex.contains(i)){
					tmpRow.add(row.get(i))
				}
			}
			tmpData.add(tmpRow)
		}
		data=tmpData
		
		var tmpHeaders=new ArrayList<String>			
		for (var i=0; i<header.length ; i++)
		{
			if(fieldIndex.contains(i)){
				tmpHeaders.add(header.get(i))
			}
		}
		header=tmpHeaders
		refreshHeaderDict
	}	
	
	def deleteLine(ArrayList<Integer> lineIndex) {
		lineIndex.sort(Comparator.reverseOrder())
		for(index : lineIndex){
			data.remove(index.intValue)
		}
	}
	
	def deleteField(ArrayList<Integer> fieldIndex) {
		var tmpData = new ArrayList<ArrayList<Value>>
		for(row : data){
			var tmpRow=new ArrayList<Value>			
			for (var i=0; i<row.length ; i++)
			{
				if(!fieldIndex.contains(i)){
					tmpRow.add(row.get(i))
				}
			}
			tmpData.add(tmpRow)
		}
		data=tmpData
		
		var tmpHeaders=new ArrayList<String>			
		for (var i=0; i<header.length ; i++)
		{
			if(!fieldIndex.contains(i)){
				tmpHeaders.add(header.get(i))
			}
		}
		header=tmpHeaders
		refreshHeaderDict
	}
	
	def insertField(String fieldName, ArrayList<Value> values) {
		for(var i = 0 ; i < data.length ; i++){
			data.get(i).add(values.get(i % values.length))
		}
		header.add(fieldName)
		refreshHeaderDict
	}
	
	def insertLine(ArrayList<Value> values) {
		val newLine = new ArrayList<Value>
		for(var i = 0 ; i < header.length ; i++){
			newLine.add(values.get(i % values.length))
		}
		data.add(newLine)
	}
	
	def modifyField(ArrayList<Integer> fields, ArrayList<Value> values) {
		for (field : fields){
			for(var i = 0 ; i < data.length ; i++){
			data.get(i).set(field, (values.get(i % values.length)))
			}
		}		
	}
	
	def modifyLine(ArrayList<Integer> lines, ArrayList<Value> values) {
		val newLine = new ArrayList<Value>
		for(var i = 0 ; i < header.length ; i++){
			newLine.add(values.get(i % values.length))
		}
		
		for(line : lines)
		{
			data.set(line, newLine)
		}
	}
	
	def nbFields(){
		return header.length
	}
	
	def nbLines(){
		return data.length
	}
	
	def getCell(int line, int col){
		return data.get(line).get(col)
	}
	
	def setCell(int line, int col, Value value) {
		data.get(line).set(col, value)
	}
	
	def getRow(int index){
		return data.get(index)
	}
	
	def getField(int index){
		var col= new ArrayList<Value>
		for(row : data){
			col.add(row.get(index))
		}
		return col
	}
	
	def getFieldNum(String fieldName) {
		return headerDict.get(fieldName)
	}
	
	def getSep(){
		return this.sep
	}
	
	override equals(Object o){
		if(!(o instanceof Csv)){
			return false
		}
		val Csv other = o as Csv
		return sep.equals(other.sep)
			&& data.equals(other.data)
			&& header.equals(other.header)		
	}
}

class Value {
	public var Integer i
	public var Double d
	public var String s
	public var String type
	
	new (Integer ii){
		i = ii
		d = ii as double
		s = null
		type = "i"
	}
	new (Double dd){
		i = null
		d = dd
		s = null
		type = "d"
	}
	new (String ss){
		i = null
		d = null
		s = ss
		type = "str"
	}
	
	def static build(String s) {
		var Scanner sc= new Scanner(s)
			if (sc.hasNextInt) return new Value(sc.nextInt)
			else if (sc.hasNextDouble) return new Value(sc.nextDouble)
			else new Value(s)
	}
	
	override toString() {
		switch type
		{
			case "i":
				return i.toString
			case "d":
				{	// FIXME: it doesn't work. TODO
					// We check if the double should be printed as an Int
					if (d.intValue == d){
						return d.intValue.toString	
					} else {
						return d.toString
					}
				}
			case "str":
				return s.toString
			default:
				return "NA"
		}	
	}
	
	def boolean compare(BinOpRel rel, Value v) {
		if(type.equals("str")){
			if(!v.type.equals("str")){
				throw new IllegalArgumentException("Cannot compare a string with a number.")
			}
			switch (rel) {
				// s1.compareTo(s2) is positive iff s1 >= s2
				case GT: {
					return s.compareTo(v.s) > 0
				}
				case LT: {
					return s.compareTo(v.s) < 0
				}
				case GE: {
					return s.compareTo(v.s) >= 0
				}
				case LE: {
					return s.compareTo(v.s) <= 0
				}
				case EQ: {
					return s.compareTo(v.s) == 0
				}
				case NEQ: {
					return s.compareTo(v.s) != 0
				}
				default: {
					throw new IllegalArgumentException("Implemented binary comparison operations are only >, <, >=, <=, == and !=.")
				}
			}
		} else {
			if(v.type.equals("str")){
				throw new IllegalArgumentException("Cannot compare a number with a string.")
			}
			var double v1
			if(type.equals("d")){
				v1 = d
			} else {
				v1 = i
			}
			var double v2
			if(v.type.equals("d")){
				v2 = v.d
			} else {
				v2 = v.i
			}
			switch (rel) {
				// s1.compareTo(s2) is positive iff s1 >= s2
				case GT: {
					return v1 > v2
				}
				case LT: {
					return v1 < v2
				}
				case GE: {
					return v1 >= v2
				}
				case LE: {
					return v1 <= v2
				}
				case EQ: {
					return v1 == v2
				}
				case NEQ: {
					return v1 != v2
				}
				default: {
					throw new IllegalArgumentException("Implemented binary comparison operations are only >, <, >=, <=, == and !=.")
				}
			}
		}
	}
	
	override equals(Object o){
		if(!(o instanceof Value)){
			return false
		}
		val Value other = o as Value
		return this.compare(BinOpRel.EQ, other)
	}
}