package seleniumWrapper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriver {
	

	public static WebDriver driver;
	public static WebDriverWait wait;

	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	public static WebDriverWait driverWait(int timeOut) {
		wait = new WebDriverWait(driver,timeOut);
		return wait;
	}
	
	
	
	
	
}
