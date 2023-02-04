package stepdefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void check_whether_items_passed_to_scenario_and_properly_added() {

	}

	@Then("click on place order")
	public void click_on_place_order() {
		objOrderElement.findElement(objOrderElement.placeOrderButton).click();

	}

}
