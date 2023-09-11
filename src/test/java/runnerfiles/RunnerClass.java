package runnerfiles;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunnerClass {

	@CucumberOptions(features = {
			"src/test/java/featureFiles" }, glue = "stepdefinitions", monochrome = true, tags = "@smoke", plugin = {
					"pretty", "html:target/cwdInjectionReport.html",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"rerun:test-output/failedTestcases.txt" })

	public class runnerfiles extends AbstractTestNGCucumberTests {

		
		  @Override
		  
		  @DataProvider(parallel = true) public Object[][] scenarios() { return
		  super.scenarios(); }
		 

	}

}
