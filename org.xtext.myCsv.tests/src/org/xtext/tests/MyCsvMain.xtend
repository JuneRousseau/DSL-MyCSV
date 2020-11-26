package org.xtext.tests

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import org.xtext.generator.MyCsvCompilerPython
import org.eclipse.emf.common.util.URI
import org.xtext.MyCsvStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.myCsv.Program
import org.xtext.generator.MyCsvCompilerBash
import org.xtext.generator.MyCsvInterpreter

class MyCsvMain {
	
	def static void main(String[] args){
		val String mode= args.get(0)
		val String input= args.get(1)
		if(mode.equals("compile-bash"))
		{
			val String output= args.get(2)
			compileBash(input, output)
		}
		else if(mode.equals("compile-python"))
		{
			val String output= args.get(2)
			compilePython(input, output)
		}
		else if(mode.equals("interpret"))
		{
			interpret(input)
		}
		else
		{
			print("Mode "+ mode+" unknown: please use compile-bash , compile-python or interpret")
		}
		print("Done")
	}
	
	def static void interpret(String inputMyCsv){
		val interpreter = new MyCsvInterpreter
		
		val prog = loadMyCSV(URI.createURI(inputMyCsv))
		if(prog === null){
			print("Error with parsing")
		}
		val errors = prog.eResource.errors
		if (!errors.isEmpty)
		{
			print('''Unexpected errors: «errors.join(", ")»''')
		}
		// EXECUTE INTERPRETER	
		interpreter.interpretProgram(prog)
	}
	
	def static  void compileBash(String inputMyCsv, String compiledShPath){

		val bashCompiler = new MyCsvCompilerBash

		// GETTING MYCSV AST
		val prog = loadMyCSV(URI.createURI(inputMyCsv))
		if(prog === null){
			print("Error with parsing")
		}
		val errors = prog.eResource.errors
		if (!errors.isEmpty)
		{
			print('''Unexpected errors: «errors.join(", ")»''')
		}
				
		// COMPILING AND WRITING RESULTS
		val compiledSh = bashCompiler.compile(prog)
		Files.writeString(Paths.get(compiledShPath), compiledSh, StandardCharsets.UTF_8);
		
	}
	
	def static void compilePython(String inputMyCsv, String compiledPyPath){

		val pythonCompiler = new MyCsvCompilerPython

		// GETTING MYCSV AST
		val prog = loadMyCSV(URI.createURI(inputMyCsv))
		if(prog === null){
			print("Error with parsing")
		}
		val errors = prog.eResource.errors
		if (!errors.isEmpty)
		{
			print('''Unexpected errors: «errors.join(", ")»''')
		}
				
		// COMPILING AND WRITING RESULTS
		val compiledPy = pythonCompiler.compile(prog)
		Files.writeString(Paths.get(compiledPyPath), compiledPy, StandardCharsets.UTF_8);

	}
	
	def static loadMyCSV(URI uri){
		new MyCsvStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res= new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as Program
	}
}