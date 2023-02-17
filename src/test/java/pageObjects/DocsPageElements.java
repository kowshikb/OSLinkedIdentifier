package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocsPageElements {

	public WebDriver driver;
	public WebDriverWait wait;

	public DocsPageElements(WebDriver driver) {// driver data taken from greerkart class will be used in this class
		// driver data taken from factoryobjectclass will be used here
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public By elementofdocument = By.xpath("//*[contains(text(),'Docs')]");
	public By elementOfSidepanelinDocument = By.xpath("//ul[@aria-label='Secondary']");
	public By eachelementinSidePanel = By.cssSelector("div.MuiListItemText-root");
	public By subelementsUnderMainOption = By.cssSelector(
			"span.MuiTypography-root.MuiListItemText-primary.MuiTypography-body1.MuiTypography-displayBlock");

	public void clickOnElement(By element, String s) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		List<WebElement> allelements = driver.findElements(element);
		for (WebElement x : allelements) {
			if (x.getText().contentEquals(s)) {
				x.click();
				break;
			}
		}
	}

	public void getAllElementsAfterClick(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		List<WebElement> allelements = driver.findElements(element);
		for (WebElement x : allelements) {
			System.out.println(x.getText());
		}
	}

	public List<WebElement> findElements(By element) {
		return driver.findElements(element);
	}

	public WebElement findElement(By element) {
		return driver.findElement(element);
	}

}
