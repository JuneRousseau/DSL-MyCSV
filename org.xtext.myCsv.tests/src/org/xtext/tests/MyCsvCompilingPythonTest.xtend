/*
 * generated by Xtext 2.23.0
 */
package org.xtext.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.xtext.myCsv.Program
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.xtext.MyCsvStandaloneSetupGenerated
import org.xtext.generator.MyCsvCompilerPython
import java.nio.file.Files
import java.io.IOException
import java.nio.file.Paths
import java.nio.charset.StandardCharsets

@ExtendWith(InjectionExtension)
@InjectWith(MyCsvInjectorProvider)
class MyCsvCompilingPythonTest {
	
	@Test
	def void loadModel() {
		val inputTest= "examples/compileSpec.mycsv"
		val outputTest= "examples/compileSpec.py"
		val prog= loadMyCSV(URI.createURI(inputTest))
		Assertions.assertNotNull(prog)
		val errors = prog.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		
		val pythonCompiler = new MyCsvCompilerPython
		
		val compiledProg= pythonCompiler.compile(prog)
		try {
    		Files.writeString(Paths.get(outputTest), compiledProg, StandardCharsets.UTF_8);
		} catch (IOException ex) {
	// Handle exception
		}

		print(compiledProg)
		
	}
	
	def loadMyCSV(URI uri){
		new MyCsvStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res= new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as Program
	}
}
