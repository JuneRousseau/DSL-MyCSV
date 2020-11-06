package org.xtext.generator

import org.xtext.myCsv.Program
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import java.io.IOException

/**
 * Compiler to Bash
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MyCsvDummyCompilerBash {

	val tmpCompilerPath="/tmp/myCsvCompilerBash/"	
	val tmpPy= tmpCompilerPath+"tmp.py"
		
	def String compilee(Program p){
		var res = "#!/bin/bash\n"
		res += "mkdir -p "+tmpCompilerPath+"\n"
		val csvCompilerPython = new MyCsvCompilerPython
		var String prog = csvCompilerPython.compile(p) 
		try {
    		Files.writeString(Paths.get(tmpPy), prog, StandardCharsets.UTF_8);
			} catch (IOException ex) {
			print("Exception occured: " + ex + "\n----------------------\n\n\n\n")
		}
		res += "python3 "+tmpPy+"\n"
		return res
	}
	
}