package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FactoryObjectClass {
	public GreenKartElements greenKartElement;
	public OfferPageElements offerPageElement;
	public PlaceOrderElements placeOrderElement;
	public SelectCountryElements selectCountryElement;
	public WebDriverWait wait;

	public WebDriver driver;

	public FactoryObjectClass(WebDriver driver) {// driver to this will be passed when we create object of this class in
													// other class
		// driver to this class is taken from textcontextsetup class in utils package
		this.driver = driver;
	}

	public GreenKartElements GreenKartElementObject() {// methods in this class returns object of pageobject classes
		greenKartElement = new GreenKartElements(driver);// driver here is passed form class variable of this class
		return greenKartElement;

	}

	public OfferPageElements OfferPageElementObject() {
		offerPageElement = new OfferPageElements(driver);
		return offerPageElement;

	}
	
	public WebDriverWait waitObject() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait;
	}
	
	public PlaceOrderElements PlaceOrderElementsObject() {
		placeOrderElement= new PlaceOrderElements(driver);
		return placeOrderElement;
		
	}
	
	public SelectCountryElements SelectCountryElementsObject() {
		selectCountryElement= new SelectCountryElements(driver);
		return selectCountryElement;
		
	}
	

}
