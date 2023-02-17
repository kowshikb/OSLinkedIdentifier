package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataHubHomePageElements {
	
	
	public WebDriver driver;
	public WebDriverWait wait;

	public DataHubHomePageElements(WebDriver driver) {// driver data taken from greerkart class will be used in this class
		// driver data taken from factoryobjectclass will be used here
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public By welcomeText=By.cssSelector("h1.MuiTypography-root.jss97.MuiTypography-h1");
	public By acceptCookies=By.cssSelector("button#ccc-notify-accept");
	
	
	public By allheaderelements=By.cssSelector("button.MuiButtonBase-root.MuiTab-root.jss7.MuiTab-textColorInherit");
	

	public List<WebElement> findElements(By element) {
		return driver.findElements(element);
	}

	public WebElement findElement(By element) {
		return driver.findElement(element);
	}
	

	
	

}
