package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderElements {
	public WebDriver driver;
	public WebDriverWait wait;

	public PlaceOrderElements(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		this.driver = driver;
	}

	public By table = By.cssSelector("table#productCartTables");
	public By placeOrderButton=By.xpath("//*[contains(text(),'Place Order')]");

	public void checkCurrentpageUrl() {

		wait.until(ExpectedConditions.presenceOfElementLocated(placeOrderButton));
		System.out.println("You landed cart with items added to it");
	}
	
	public WebElement findElement(By element) {
		return driver.findElement(element);
	}
	

}
