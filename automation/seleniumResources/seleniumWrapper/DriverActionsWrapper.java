package seleniumWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Contains wrappers for the Selenium Actions that can be used directly in the test cases. 
 * These wrappers avoid updating the test cases when newer versions of the dependencies are available.
 * This would help by just updating the wrappers where the actual Selenium Actions are created
 */

public class DriverActionsWrapper extends BaseDriver{
	
	
	
	
	//Setup the WebDriver with the required browser
	public void setupDriver(String browser) {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE") || browser.equalsIgnoreCase("InternetExplorer") || browser.equalsIgnoreCase("Internet Explorer")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
	}
	
	
	//Action to open browser
	public void openBrowser(String baseURL) {
		getDriver().get(baseURL);
	}
	
	
	//Action to close browser
	public void closeBrowser() {
		getDriver().close();
	}
	
	
	//Action to quit driver
	public void quitDriver() {
		getDriver().quit();
	}
	
	
	//Action to click object
	public void click(By elementBy) {
		getDriver().findElement(elementBy).click();
	}
	
	
	//Action to set test
	public void setText(By elementBy, String text) {
		getDriver().findElement(elementBy).sendKeys(text);
	}
	
	
	
	

}
