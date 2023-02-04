package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericMethods {

	public WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void switchTabs() {
		Set<String> open_windows = driver.getWindowHandles();
		Iterator<String> data = open_windows.iterator();
		String tab = "";
		while (data.hasNext()) {
			tab = data.next();
		}
		driver.switchTo().window(tab);
	}

}
