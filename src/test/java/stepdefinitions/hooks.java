package stepdefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TextContextSetup;

public class hooks {
	public TextContextSetup textContext;

	public hooks(TextContextSetup textContext) {
		this.textContext = textContext;
	}

	@Before("@smoke")
	public void beforeValidation() throws Exception {
		System.out.println("test");
	}

	@After("@smoke")
	public void afterValidation() throws Exception {
		textContext.driverInitVar.webDriverManager().quit();
	}

	@AfterStep
	public void takeScreenShot(Scenario scenario) throws Exception {
		WebDriver driver = textContext.driverInitVar.webDriverManager();
		if (scenario.isFailed()) {

			File sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(fileContent, "image/png","image" );
			
		}

	}

}
