package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FactoryObjectClass {
	public DataHubHomePageElements dataHubHomePageElementsVar;
	public DocsPageElements docsPageElementsVar;
	public ApiDashboardElements apiDashboardElementsVar;
	public DownloadPageElements downloadPageElementsVar;
	public PricingElements pricingElementsVar;
	public SupportPageElements supportPageElementsVar;
	public WebDriverWait wait;

	public WebDriver driver;

	public FactoryObjectClass(WebDriver driver) {// driver to this will be passed when we create object of this class in
													// other class
		// driver to this class is taken from textcontextsetup class in utils package
		this.driver = driver;
	}

	public DataHubHomePageElements DataHubHomePageElementsObject() {// methods in this class returns object of pageobject classes
		dataHubHomePageElementsVar = new DataHubHomePageElements(driver);// driver here is passed form class variable of this class
		return dataHubHomePageElementsVar;

	}

	public DocsPageElements DocsPageElementsObject() {
		docsPageElementsVar = new DocsPageElements(driver);
		return docsPageElementsVar;

	}
	
	public WebDriverWait waitObject() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait;
	}
	
	public ApiDashboardElements ApiDashboardElementsObject() {
		apiDashboardElementsVar= new ApiDashboardElements(driver);
		return apiDashboardElementsVar;
		
	}
	
	public DownloadPageElements DownloadPageElementsObject() {
		downloadPageElementsVar= new DownloadPageElements(driver);
		return downloadPageElementsVar;
		
	}
	
	public PricingElements PricingElementsObject() {
		pricingElementsVar= new PricingElements(driver);
		return pricingElementsVar;
		
	}
	
	public SupportPageElements SupportPageElementsObject() {
		supportPageElementsVar= new SupportPageElements(driver);
		return supportPageElementsVar;
		
	}
	
	
	
	

}
