package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import pageObjects.OfferPageElements;
import utils.TextContextSetup;

public class OffersPage {
	public OfferPageElements objOfferPage;
	public TextContextSetup textContext;
	

	public OffersPage(TextContextSetup textContext) {// we haven't created object of offerpage but class variable
		// will be initialized with help of picocontainer
		this.textContext = textContext;
	}

	@Then("^search with short name (.+) in offer page to check product exist$")
	public void search_with_short_name_in_offer_page_to_check_product_exist(String string) {

		objOfferPage = textContext.factoryObjVar.OfferPageElementObject(); // from here we passing
																			// driver data
		// to object class constructor where we mentioned all xpath and css

		objOfferPage.findElement(objOfferPage.offerLink).click();
		textContext.genericMethodsVar.switchTabs();
		objOfferPage.findElement(objOfferPage.searchField).sendKeys(string);
		WebElement table = objOfferPage.findElement(objOfferPage.table);

		List<WebElement> headerElements = table.findElements(objOfferPage.columnHeader);
		for (WebElement x : headerElements) {
			System.out.print(x.getText() + " |");
		}
		System.out.println();
		List<WebElement> rowElements = table.findElements(By.tagName("tr"));
		for (WebElement x : rowElements) {
			List<WebElement> dataElements = x.findElements(By.tagName("td"));
			for (WebElement y : dataElements) {
				System.out.print(y.getText() + " |");
			}
			System.out.println();
		}

	}

}
