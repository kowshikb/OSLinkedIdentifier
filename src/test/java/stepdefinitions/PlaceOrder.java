package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.PlaceOrderElements;
import utils.TextContextSetup;

public class PlaceOrder {

	public TextContextSetup textContext;
	public PlaceOrderElements objOrderElement;
	public WebDriverWait wait;

	public PlaceOrder(TextContextSetup textContext) {

		this.textContext = textContext;
		this.wait = textContext.factoryObjVar.waitObject();
	}

	@And("check wether user landed on place order page")
	public void check_wether_user_lander_on_place_order_page() {
		objOrderElement = textContext.factoryObjVar.PlaceOrderElementsObject();
		objOrderElement.checkCurrentpageUrl();
	}

	@And("check whether items passed to scenario and properly added")
	public void check_whether_items_passed_to_scenario_and_properly_added(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		System.out.println(data);
		int i=0;
		List<WebElement> itemsAddedToCart = objOrderElement.findElements(objOrderElement.allRowsInTable);
		for (WebElement x : itemsAddedToCart) {
			Assert.assertEquals(data.get(i+1).get("item"),x.findElement(objOrderElement.itemsaddedtocartcss).getText().split("-")[0].trim());
			Assert.assertEquals(data.get(i).get("quantity"),x.findElement(objOrderElement.itemQuantityAddedToCart).getText());
			System.out.println(x.findElement(objOrderElement.itemsaddedtocartcss).getText().split("-")[0].trim()+":"+x.findElement(objOrderElement.itemQuantityAddedToCart).getText());
			i++;
		}
		
	}

	@Then("click on place order")
	public void click_on_place_order() {
		objOrderElement.findElement(objOrderElement.placeOrderButton).click();

	}

}
