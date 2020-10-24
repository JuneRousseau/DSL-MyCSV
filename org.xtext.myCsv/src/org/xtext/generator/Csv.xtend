package org.xtext.generator

import java.io.File
import java.util.Scanner
import java.util.ArrayList
import java.util.HashMap
import org.xtext.myCsv.Path
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import java.io.IOException

class Csv {
	
	public var ArrayList<ArrayList<Value>> data
	public var ArrayList<String> header
	public var HashMap<String, Integer> headerDict
	
	new (){
		data = new ArrayList
		header = new ArrayList
		headerDict = new HashMap
	}
	
	new (String path, String sep, boolean noHeader){
		data = new ArrayList
		
		try {
			val file = new File(path)
			if(noHeader){
				throw new IllegalArgumentException("Not Implemented yet. (handling .csv without header)")
			}
			val scan = new Scanner(file)
			
			while(scan.hasNextLine){
				val line = scan.nextLine
				data.add(parseCsvLine(line, sep))
			}
			
		} catch (Exception e) {
			e.printStackTrace // TODO : test wether it stops the programm
		}
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
		return data.length
	}
	
	def sum(String fieldId){
		val field = headerDict.get(fieldId)
		var res = 0.0
		for(row : data){
			res += row.get(field).i // TODO : better
		}
		return res
	}
	
	def product(String fieldId){
		val field = headerDict.get(fieldId)
		var res = 1.0
		for(row : data){
			res *= row.get(field).i // TODO : better
		}
		return res
	}
	
	def mean(String fieldId){
		return sum(fieldId) / count(fieldId)
	}
	
	def storeCsv(String path, String sep) {
		var str=""
		for (line : data)
		{
			var first= true
			for (value : line)
			{
				if(!first) str+=sep
				str+=value.toString
				first=false
			}
			str+="\n"
		}
		try {
    		Files.writeString(Paths.get(path), str, StandardCharsets.UTF_8);
		} catch (IOException ex) {
			print("Exception occured: " + ex + "\n----------------------\n\n\n\n")
		}	
	}
	
	
}

class Value {
	public var Integer i
	public var Double d
	public var String s
	public var String type
	
	new (Integer ii){
		i = ii
		d = null
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
				return d.toString
			case "str":
				return s.toString
		}	
	}
}