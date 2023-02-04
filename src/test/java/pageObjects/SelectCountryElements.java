package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectCountryElements {
	public WebDriver driver;

	public SelectCountryElements(WebDriver driver) {// driver data taken from greerkart class will be used in this class
		// driver data taken from factoryobjectclass will be used here
		this.driver = driver;
	}

	public By countryDropdown = By.cssSelector("select");
	public By checkBox = By.cssSelector("input.chkAgree");
	public By proceedButton = By.cssSelector("button");
	public By confirmationtext=By.cssSelector("div.wrapperTwo");

	public void selectCountry(String countryName) {
		Select x = new Select(driver.findElement(countryDropdown));
		x.selectByValue(countryName);
	}

	public void checkCurrentpageUrl() {
		String url=driver.getCurrentUrl();
		Assert.assertEquals("https://rahulshettyacademy.com/seleniumPractise/#/country", url) ;
		System.out.println("You landed on  country page");
			
		
	}
	
	public void tapOnProceed() {
		driver.findElement(proceedButton).click();
		String text=driver.findElement(confirmationtext).getText();
		System.out.println(text);
		Assert.assertEquals("Thank you, your order has been placed successfully You'll be redirected to Home page shortly!!", text);
		System.out.println("Order Placed");
	}

}
