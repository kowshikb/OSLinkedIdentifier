package runnerfiles;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunnerClass {

	@CucumberOptions(features = {"src/test/java/features/AddItems.feature","src/test/java/features/GreenKart.feature"},
			glue = "stepdefinitions",monochrome = true)
	public class runnerfiles extends AbstractTestNGCucumberTests {
		
		/*
		 * @Override
		 * 
		 * @DataProvider(parallel=true) public Object [][] scenarios(){ return
		 * super.scenarios(); }
		 */
		 
	}
	
	
	

}
