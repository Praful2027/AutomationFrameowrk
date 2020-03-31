package seleniumResources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DriverWaitWrapper extends BaseDriver{


	//Waits until Web Element is Visible on the UI
	public void waitUntilVisible(WebElement elementBy, int timeOut) {
		getDriverWaitInstance(timeOut).until(ExpectedConditions.visibilityOf(elementBy));
	}


	//Waits until Web Element is Not Visible on the UI
	public void waitUntilNotVisible(WebElement elementBy, int timeOut) {
		getDriverWaitInstance(timeOut).until(ExpectedConditions.invisibilityOf(elementBy));
	}
	
	
	//Waits until Web Element is present in the DOM
		public void waitUntilPresent(WebElement elementBy, int timeOut) {
//			getDriverWaitInstance(timeOut).until(ExpectedConditions.presenceOfElementLocated(elementBy));
		}

}
