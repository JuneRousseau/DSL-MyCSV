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
import org.xtext.generator.MyCsvPrettyPrinter

@ExtendWith(InjectionExtension)
@InjectWith(MyCsvInjectorProvider)
class MyCsvPrettyPrintingTest {
	/*return "<exprCalcUnary>"
	@Inject
	ParseHelper<Program> parseHelper
	*/
	
	@Test
	def void loadModel() {
		val result= loadMyCSV(URI.createURI("examples/compileSpec.mycsv"))
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		
		val prettyPrinter = new MyCsvPrettyPrinter
		print(prettyPrinter.prettyPrint(result))
		}
	
	def loadMyCSV(URI uri){
		new MyCsvStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res= new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as Program
	}
}
