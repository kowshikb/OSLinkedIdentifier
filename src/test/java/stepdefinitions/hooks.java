package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TextContextSetup;

public class hooks {
	public TextContextSetup textContext;
	public hooks(TextContextSetup textContext) {
		this.textContext = textContext;
	}

	

	@Before("@tag1")
	public void beforeValidation() throws Exception {
		System.out.println("test");
	}

	@After("@tag1")
	public void afterValidation() throws Exception {
		textContext.driverInitVar.webDriverManager().quit();
	}

}
