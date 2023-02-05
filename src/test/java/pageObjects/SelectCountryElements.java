package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectCountryElements {
	public WebDriver driver;
	public WebDriverWait wait;

	public SelectCountryElements(WebDriver driver) {// driver data taken from greerkart class will be used in this class
		// driver data taken from factoryobjectclass will be used here
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public By countryDropdown = By.cssSelector("select");
	public By checkBox = By.cssSelector("input.chkAgree");
	public By proceedButton = By.cssSelector("button");
	public By confirmationtextCss=By.cssSelector("div.wrapperTwo");
	public By chooseCountryTextCss=By.cssSelector("div.wrapperTwo>label");
	

	public void selectCountry(String countryName) {
		Select x = new Select(driver.findElement(countryDropdown));
		x.selectByValue(countryName);
	}

	public void checkCurrentpageUrl() {
		wait.until(ExpectedConditions.presenceOfElementLocated(chooseCountryTextCss));
		System.out.println("You landed on  country page");
	}
	
	public void tapOnProceed() {
		driver.findElement(checkBox).click();
		driver.findElement(proceedButton).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(confirmationtextCss));
		String text=driver.findElement(confirmationtextCss).getText();
		System.out.println(text);
		System.out.println("Order Placed");
	}
	

}
