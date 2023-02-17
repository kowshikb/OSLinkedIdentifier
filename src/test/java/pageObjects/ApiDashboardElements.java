package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApiDashboardElements {
	
	
	public WebDriver driver;
	public WebDriverWait wait;

	public ApiDashboardElements(WebDriver driver) {// driver data taken from greerkart class will be used in this class
		// driver data taken from factoryobjectclass will be used here
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public By elementOfApiDashboard=By.xpath("//*[contains(text(),'API Dashboard')]");
	public By elementOftextonApiDashboard=By.cssSelector("p.MuiTypography-root.MuiTypography-body1");
	
	
	

	public List<WebElement> findElements(By element) {
		return driver.findElements(element);
	}

	public WebElement findElement(By element) {
		return driver.findElement(element);
	}

}
