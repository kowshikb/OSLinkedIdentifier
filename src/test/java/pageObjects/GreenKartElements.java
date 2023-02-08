package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartElements {
	public WebDriver driver;
	public WebDriverWait wait;

	public GreenKartElements(WebDriver driver) {// driver data taken from greerkart class will be used in this class
		// driver data taken from factoryobjectclass will be used here
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	
	public void clearTextFromTextField(By element) {
		String chars = Keys.chord(Keys.CONTROL, "a"); 
		driver.findElement(element).sendKeys(chars);
		driver.findElement(element).sendKeys(Keys.BACK_SPACE);
	}

	public List<WebElement> findElements(By element) {
		return driver.findElements(element);
	}

	public WebElement findElement(By element) {
		return driver.findElement(element);
	}
	
	public int sizeOfAllElementsInPage(By element) {
		return driver.findElements(element).size();
	}
	
	public void quantityIncrementer(String x,By element) {
		int itemQuantity = Integer.parseInt(x);
		while (itemQuantity > 0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			driver.findElement(element).click();
			itemQuantity--;
		}
	}

}
