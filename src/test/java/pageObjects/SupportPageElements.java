package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupportPageElements {
	
	
	public WebDriver driver;
	public WebDriverWait wait;

	public SupportPageElements(WebDriver driver) {// driver data taken from greerkart class will be used in this class
		// driver data taken from factoryobjectclass will be used here
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public By elementOfSupport=By.xpath("//*[contains(text(),'Support')]");
	public By signupLink=By.xpath("//*[contains(text(),'How do I sign up for an account?')]");
	
	public void clickOnElement(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.findElement(element).click();
	}
	
	

}
