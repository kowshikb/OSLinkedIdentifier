package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfferPageElements {
	public WebDriver driver;

	public OfferPageElements(WebDriver driver) {// driver data taken from greerkart class will be used in this class
		this.driver = driver;
	}

	public By offerLink = By.cssSelector("a[href='#/offers']");
	public By searchField = By.cssSelector("input#search-field");
	public By table = By.cssSelector("table.table.table-bordered");
	public By columnHeader = By.cssSelector("th[role='columnheader']");

	public WebElement findElement(By element) {
		return driver.findElement(element);
	}



}
