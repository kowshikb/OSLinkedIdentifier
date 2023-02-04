package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverInitialization {
	WebDriver driver;
	

	public WebDriver webDriverManager() throws Exception {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\global.properties");
		Properties proVar = new Properties();
		proVar.load(fis);
		String url = proVar.getProperty("url");

		if (driver == null) {
			if (proVar.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\chromedriver.exe");
				driver = new ChromeDriver();
			
			}
			driver.get(url);
			driver.manage().window().maximize();
		}

		return driver;
	}

}
