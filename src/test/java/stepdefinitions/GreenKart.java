package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.GreenKartElements;
import utils.TextContextSetup;

public class GreenKart {

	public TextContextSetup textContext;
	public GreenKartElements objGreenKart;
	public WebDriverWait wait;

	public GreenKart(TextContextSetup textContext) {

		this.textContext = textContext;
		this.wait = textContext.factoryObjVar.waitObject();

	}

	public ArrayList<String> items;

	@Given("User is on greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		objGreenKart = textContext.factoryObjVar.GreenKartElementObject();
		System.out.println("Title of the page: " + objGreenKart.getpageTitle());
	}

	@When("^search product with short name (.+) and extract actual name$")
	public void search_product_with_short_name_and_extract_actual_name(String string) throws InterruptedException {

		// above GreenKartObject() method return greenKartElement object
		// from here we passing driver data
		// to object class constructor where we mentioned all xpath and css
		objGreenKart.sendText(string);
		Thread.sleep(1500);
		List<WebElement> elementName = objGreenKart.findElements(objGreenKart.allProducts);
		System.out.println(elementName.size());
		items = new ArrayList<>();
		for (WebElement x : elementName) {

			try {
				items.add(x.findElement(objGreenKart.productName).getText().split("-")[0].trim());
				System.out.println(x.findElement(objGreenKart.productName).getText().split("-")[0].trim());
			} catch (Exception e) {
				System.out.println("out of range");
			}

		}

	}

	@When("items below are present select items and add to cart")
	public void items_below_are_present_select_items_and_add_to_cart(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		for (Map<String, String> eachrow : data) {
			System.out.println(eachrow.keySet());
			System.out.println(eachrow.entrySet());

			String item1 = eachrow.get("Item-1");
			String item2 = eachrow.get("Item-2");
			System.out.println(item1 + " " + item2);

		}

	}

	@When("^item (.*) is present select items as per (.*) and add to cart$")
	public void item_brocolli_and_almonds_are_present_select_items_and_add_to_cart(List<String> itemToBeAddedToCart,
			List<Integer> quantity) {
		int quantityIndex = 0;
		for (String item : itemToBeAddedToCart) {
			objGreenKart.sendText(item);
			if (objGreenKart.findElement(objGreenKart.productName).getText().split("-")[0].trim()
					.compareToIgnoreCase(item) == 0) {
				objGreenKart.findElement(objGreenKart.quantityField).sendKeys("0");
				int itemQuantity = quantity.get(quantityIndex);
				while (itemQuantity > 0) {
					objGreenKart.findElement(objGreenKart.quantityIncrementer).click();
					itemQuantity--;
				}
			}
			objGreenKart.findElement(objGreenKart.AddToCart).click();
			quantityIndex++;
		}
		System.out.println("Added items to cart");

	}

	@When("item is present select items as per quanity and add to cart")
	public void item_is_present_select_items_as_per_quanity_and_add_to_cart(DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> data = dataTable.asMaps();
		for (Map<String, String> item : data) {
			objGreenKart.sendText(item.get("item"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(objGreenKart.productName));
			if (objGreenKart.findElement(objGreenKart.productName).getText().split("-")[0].trim()
					.compareToIgnoreCase(item.get("item")) == 0) {
				objGreenKart.findElement(objGreenKart.quantityField).clear();
				int itemQuantity = Integer.parseInt(item.get("quantity"));
				while (itemQuantity > 0) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(objGreenKart.quantityIncrementer));
					objGreenKart.findElement(objGreenKart.quantityIncrementer).click();
					itemQuantity--;
				}
			}
			objGreenKart.findElement(objGreenKart.AddToCart).click();
			objGreenKart.findElement(objGreenKart.searchField).clear();
			objGreenKart.findElement(objGreenKart.searchButtonCss).click();

		}
		System.out.println("Added items to cart");

	}

	@When("click on cart and click on checkout")
	public void click_on_cart_and_click_on_checkout() {
		objGreenKart.findElement(objGreenKart.cartIcon).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(objGreenKart.checkOutButton));
		objGreenKart.findElement(objGreenKart.checkOutButton).click();
		System.out.println("Tapped on checkout");
	}

}
