package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInitialization {
	WebDriver driver;
	public FileInputStream fis;
	public Properties proVar;

	public DriverInitialization() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		proVar = new Properties();
		proVar.load(fis);
	}

	public WebDriver webDriverManager() throws Exception {
		String url = proVar.getProperty("url");

		if (driver == null) {
			if (proVar.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();

			}
			driver.get(url);
			driver.manage().window().maximize();
		}

		return driver;
	}

}
