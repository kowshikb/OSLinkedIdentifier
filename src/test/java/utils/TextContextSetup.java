package utils;

import pageObjects.FactoryObjectClass;

public class TextContextSetup {
	
	public FactoryObjectClass factoryObjVar;
	
	public DriverInitialization driverInitVar;
	
	
	public TextContextSetup() throws Exception {              // constructor of this class
		driverInitVar=new DriverInitialization();
		factoryObjVar=new FactoryObjectClass(driverInitVar.webDriverManager());
	
		// we declared object for FactoryObjectClass and pass driver webdriver to it
	}

}