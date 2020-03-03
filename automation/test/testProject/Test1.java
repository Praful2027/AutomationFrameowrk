package testProject;

import org.testng.annotations.Test;

import seleniumWrapper.DriverActionsWrapper;


public class Test1{

	@Test
	public void test1(){
		
		
		DriverActionsWrapper driver = new DriverActionsWrapper();
		driver.setupDriver("Chrome");
		
		driver.openBrowser("https://www.google.com");
	}

}
