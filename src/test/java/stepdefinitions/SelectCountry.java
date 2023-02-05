package stepdefinitions;

import io.cucumber.java.en.And;
import pageObjects.SelectCountryElements;
import utils.TextContextSetup;

public class SelectCountry {

	public TextContextSetup textContext;
	public SelectCountryElements objselectCountry;

	public SelectCountry(TextContextSetup textContext) {

		this.textContext = textContext;
	}

	@And("check whether user landed or select country page")
	public void check_whether_user_landed_or_select_country_page() {
		objselectCountry = textContext.factoryObjVar.SelectCountryElementsObject();
		objselectCountry.checkCurrentpageUrl();
	}

	@And("^Select Country as (.+)$")
	public void select_country(String string) {
		objselectCountry.selectCountry(string);
	}

	@And("Tap on proceed")
	public void tap_on_proceed() {
		objselectCountry.tapOnProceed();

	}

}
