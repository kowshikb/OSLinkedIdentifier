package stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ApiDashboardElements;
import pageObjects.DataHubHomePageElements;
import pageObjects.DocsPageElements;
import pageObjects.DownloadPageElements;
import pageObjects.PricingElements;
import pageObjects.SupportPageElements;
import utils.TextContextSetup;

public class DataHubHomePage {

	public TextContextSetup textContext;
	public DataHubHomePageElements dataHubHomePageElementsVar;
	public DocsPageElements docsPageElementsVar;
	public ApiDashboardElements apiDashboardElementsVar;
	public DownloadPageElements downloadPageElementsVar;
	public PricingElements pricingElementsVar;
	public SupportPageElements supportPageElementsVar;

	public WebDriverWait wait;

	public DataHubHomePage(TextContextSetup textContext) {

		this.textContext = textContext;
		this.wait = textContext.factoryObjVar.waitObject();
		dataHubHomePageElementsVar = textContext.factoryObjVar.DataHubHomePageElementsObject();
		apiDashboardElementsVar = textContext.factoryObjVar.ApiDashboardElementsObject();
		docsPageElementsVar = textContext.factoryObjVar.DocsPageElementsObject();
		downloadPageElementsVar = textContext.factoryObjVar.DownloadPageElementsObject();
		pricingElementsVar = textContext.factoryObjVar.PricingElementsObject();
		supportPageElementsVar = textContext.factoryObjVar.SupportPageElementsObject();

	}

	@Given("User is on dataHub LandingPage and accept cookies")
	public void user_is_on_dataHub_LandingPage_and_accept_cookies() throws IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(dataHubHomePageElementsVar.acceptCookies));
			dataHubHomePageElementsVar.findElement(dataHubHomePageElementsVar.acceptCookies).click();

		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(dataHubHomePageElementsVar.acceptCookies));
			dataHubHomePageElementsVar.findElement(dataHubHomePageElementsVar.acceptCookies).click();
		}

		System.out.println("Accepted cookies in landingPage");
		wait.until(ExpectedConditions.visibilityOfElementLocated(dataHubHomePageElementsVar.welcomeText));
		String textonlandingpage = textContext.driverInitVar.proVar.getProperty("textonlandingpage");
		Assert.assertEquals(dataHubHomePageElementsVar.findElement(dataHubHomePageElementsVar.welcomeText).getText(),
				textonlandingpage);
		System.out.println("Validated Text in Landing Page");

	}

	@When("Following elements are there in landingpage")
	public void following_elements_are_there_in_landingpage(DataTable dataTable) {
		List<String> data = dataTable.asList();
		int i = 0;
		List<WebElement> headerElements = dataHubHomePageElementsVar
				.findElements(dataHubHomePageElementsVar.allheaderelements);
		for (WebElement x : headerElements) {
			Assert.assertEquals(x.getText(), data.get(i));
			// System.out.println(x.getText() + " : " +data.get(i) );
			i++;
		}
		System.out.println("All elements in Header are validated");

	}

	@Then("click on each element")
	public void click_on_each_element() throws InterruptedException {
		List<WebElement> headerElements = dataHubHomePageElementsVar
				.findElements(dataHubHomePageElementsVar.allheaderelements);
		for (WebElement x : headerElements) {
			x.click();
			Thread.sleep(3000);
			System.out.println("clicked on element " + x.getText());

		}

	}

	@When("User clicks on API Dashboard")
	public void user_clicks_on_api_dashboard() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(apiDashboardElementsVar.elementOfApiDashboard));
		apiDashboardElementsVar.findElement(apiDashboardElementsVar.elementOfApiDashboard).click();
		System.out.println("User is on Api dashboard UI");

	}

	@Then("User lands on Api Dashboard page and validate any element in this page")
	public void user_lands_on_api_dashboard_page_and_validate_any_element_in_this_page() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(apiDashboardElementsVar.elementOftextonApiDashboard));
		String textonApiDashBoardpage = textContext.driverInitVar.proVar.getProperty("textonApiDashBoardpage");
		Assert.assertEquals(
				apiDashboardElementsVar.findElement(apiDashboardElementsVar.elementOftextonApiDashboard).getText(),
				textonApiDashBoardpage);
		System.out.println("Validated Text in Landing Page");

	}

	@When("User clicks on Download")
	public void user_clicks_on_download() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(downloadPageElementsVar.elementofdownload));
		downloadPageElementsVar.findElement(downloadPageElementsVar.elementofdownload).click();
		System.out.println("User is on Download UI");

	}

	@Then("User lands on Download page and validate any element in this page")
	public void user_lands_on_download_page_and_validate_any_element_in_this_page() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(downloadPageElementsVar.elementofDropdown));
		downloadPageElementsVar.findElement(downloadPageElementsVar.elementofDropdown).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(downloadPageElementsVar.dropdownPanel));
		List<WebElement> elementsInDropdown = downloadPageElementsVar
				.findElements(downloadPageElementsVar.allelementinDropdown);
		for (WebElement x : elementsInDropdown) {
			try {
				if (x.getText().equalsIgnoreCase("Lookups")) {
					x.click();
					System.out.println("Selected Lookups");
				}

			} catch (Exception e) {
				System.out.println("Ignore");
			}

		}
		System.out.println("selected one random element from dropdown");

	}

	@When("User clicks on Docs")
	public void user_clicks_on_docs() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(docsPageElementsVar.elementofdocument));
		apiDashboardElementsVar.findElement(docsPageElementsVar.elementofdocument).click();
		System.out.println("User is on Api Documentation UI");
	}

	@Then("User lands on Docs page and print all element in the side panel")
	public void user_lands_on_docs_page_and_print_all_element_in_the_side_panel() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(docsPageElementsVar.elementOfSidepanelinDocument));
		WebElement sidepanel = apiDashboardElementsVar.findElement(docsPageElementsVar.elementOfSidepanelinDocument);
		List<WebElement> elementsInSidePanel = sidepanel.findElements(docsPageElementsVar.eachelementinSidePanel);
		for (WebElement x : elementsInSidePanel) {
			System.out.println(x.getText());
		}
		System.out.println("All elements printed");

	}

	@When("User clicks on SupportPrice")
	public void user_clicks_on_support_price() {
		supportPageElementsVar.clickOnElement(supportPageElementsVar.elementOfSupport);
		System.out.println("User is on support page");
	}

	@Then("User lands on supportPrice page and validate any element in this page")
	public void user_lands_on_support_price_page_and_validate_any_element_in_this_page() {
		supportPageElementsVar.clickOnElement(supportPageElementsVar.signupLink);
		System.out.println("User clicked on signupLink");

	}

	@When("User clicks on pricing")
	public void user_clicks_on_pricing() {
		pricingElementsVar.clickOnElement(pricingElementsVar.elementOfPricingTab);
		System.out.println("User is on pricing tab");

	}

	@Then("User lands on pricing page and validate any element in this page")
	public void user_lands_on_pricing_page_and_validate_any_element_in_this_page() {
		pricingElementsVar.clickOnElement(pricingElementsVar.premiumPlanButton);
		System.out.println("User is on pricing tab");

	}

	@When("click on OS Downloads API")
	public void click_on_os_downloads_api() {
		docsPageElementsVar.clickOnElement(docsPageElementsVar.eachelementinSidePanel, "OS Downloads API");
		System.out.println("Clicked on OS Downloads API");

	}

	@Then("verify links shown after expanding OS Downloads API")
	public void verify_links_shown_after_expanding_os_downloads_api() {
		docsPageElementsVar.getAllElementsAfterClick(docsPageElementsVar.subelementsUnderMainOption);
		System.out.println("printed subelements in Downloads API ");

	}

	@When("click on OS Features API")
	public void click_on_os_features_api() {
		docsPageElementsVar.clickOnElement(docsPageElementsVar.eachelementinSidePanel, "OS Features API");
		System.out.println("Clicked on OS Features API");

	}

	@Then("verify links shown after expanding OS Features API")
	public void verify_links_shown_after_expanding_os_features_api() {
		docsPageElementsVar.getAllElementsAfterClick(docsPageElementsVar.subelementsUnderMainOption);
		System.out.println("printed subelements in Features API ");

	}

	@When("click on OS Linked Identifiers API")
	public void click_on_os_linked_identifiers_api() {
		docsPageElementsVar.clickOnElement(docsPageElementsVar.eachelementinSidePanel, "OS Linked Identifiers API");
		System.out.println("Clicked on OS Linked Identifiers API");

	}

	@Then("verify links shown after expanding OS Linked Identifiers API")
	public void verify_links_shown_after_expanding_os_linked_identifiers_api() {
		docsPageElementsVar.getAllElementsAfterClick(docsPageElementsVar.subelementsUnderMainOption);
		System.out.println("printed subelements in Linked Identifiers API ");

	}

}
