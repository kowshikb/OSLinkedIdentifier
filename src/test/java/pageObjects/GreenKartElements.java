package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreenKartElements {
	public WebDriver driver;

	public GreenKartElements(WebDriver driver) {// driver data taken from greerkart class will be used in this class
		// driver data taken from factoryobjectclass will be used here
		this.driver = driver;
	}

	public By searchField = By.cssSelector("input[type='search']");
	public By searchButtonCss= By.cssSelector("button.search-button");

	public By productName = By.cssSelector("h4.product-name");

	public By allProducts = By.cssSelector("div.product");

	public By quantityIncrementer = By.cssSelector("a.increment");

	public By quantityField = By.cssSelector("input.quantity");
	public By cartIcon= By.cssSelector("img[alt='Cart']");

	public By AddToCart = By.xpath("//*[contains(text(),'ADD TO CART')]");
	public By checkOutButton=By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]");

	public String getpageTitle() {
		return driver.getTitle();
	}

	public void sendText(String text) {
		driver.findElement(searchField).sendKeys(text);
	}

	public List<WebElement> findElements(By element) {
		return driver.findElements(element);
	}

	public WebElement findElement(By element) {
		return driver.findElement(element);
	}

}
