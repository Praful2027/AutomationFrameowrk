package seleniumResources;

import org.openqa.selenium.WebElement;

/*
 * Contains wrappers for the Selenium Actions that can be used directly in the test cases. 
 * These wrappers avoid updating the test cases when newer versions of the dependencies are available.
 * This would help by just updating the wrappers where the actual Selenium Actions are created
 */

public class DriverActionsWrapper extends BaseDriver{

	//Action to open browser
	public void openBrowser(String baseURL) {
		getDriverInstance().get(baseURL);
	}


	//Action to maximize browser
	public static void MaximizeWindow() {
		getDriverInstance().manage().window().maximize();
	}


	//Action to close browser
	public void closeBrowser() {
		getDriverInstance().close();
	}


	//Action to quit driver
	public void quitDriver() {
		getDriverInstance().quit();
	}


	//Action to click object
	public void click(WebElement element) {
		element.click();
	}


	//Action to set text
	public void setText(WebElement element, String text) {
		element.sendKeys(text);
	}
}
