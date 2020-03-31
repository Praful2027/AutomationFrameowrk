package seleniumResources;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	

private static WebDriver driver = null;
private static WebDriverWait driverWait = null;
	
	public static void Initialize(String browser) {
		
		String br = browser.toLowerCase();

		switch (br) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "IE":
		case "Internet Explorer":
		case "InternetExplorer":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
	}
	
	
	public static WebDriver getDriverInstance() {
		return driver;
	}
	
	
	public static WebDriverWait getDriverWaitInstance(int timeOutInSeconds) {
		driverWait = new WebDriverWait(getDriverInstance(), timeOutInSeconds);
		return driverWait;
	}
	
	
	
	
	
}
