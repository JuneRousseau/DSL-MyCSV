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
import java.nio.file.Files
import java.io.IOException
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Scanner
import org.xtext.generator.MyCsvCompilerBash

@ExtendWith(InjectionExtension)
@InjectWith(MyCsvInjectorProvider)
class MyCsvCompilerBashTest {

	@Test
	def void compileTests() {
		val File directoryPath = new File("examples/tests/")
		val s = new Scanner(System.in);

		println("----------TESTS----------")
		println("<Please print enter between each tests>")

		for (testFile : directoryPath.list())
		{
			try
			{
				val basename = testFile.substring(0, testFile.indexOf("."))
				val inputMyCsv = "examples/tests/" + basename + ".mycsv"
				val compiledShPath = "examples-gen/bash/" + basename + ".sh"

				val String cmdExecSh = "./" + basename + ".sh"
				print("\n---------Test de " + basename + "---------\n")
				s.nextLine()

				val prog = loadMyCSV(URI.createURI(inputMyCsv))
				Assertions.assertNotNull(prog)
				val errors = prog.eResource.errors
				Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

				val bashCompiler = new MyCsvCompilerBash
				val compiledProg = bashCompiler.compile(prog)

				Files.writeString(Paths.get(compiledShPath), compiledProg, StandardCharsets.UTF_8);
				
				val File file = new File(compiledShPath)
				file.setExecutable(true);

				val Runtime rt = Runtime.getRuntime();
				
				// execute the bash programm from its directory
				val Process pr = rt.exec(cmdExecSh, null, new File("examples-gen/bash"));
				val BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				var String line;
				while ((line = bfr.readLine()) !== null) {
					println("STDOUT: " + line);
				}

				val BufferedReader bfre = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
				while ((line = bfre.readLine()) !== null) {
					println("STDERR: " + line);
				}
				print("DONE")
			} catch (IOException ex) {
				println("Exception occured: " + ex + "\n----------------------\n\n\n\n")
				ex.printStackTrace()
			}
		}
	}

	def loadMyCSV(URI uri) {
		new MyCsvStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as Program
	}
}
