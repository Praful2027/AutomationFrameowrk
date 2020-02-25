package testProject;

import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;

public class Test1 implements WebTest{

	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		
		WebDriver driver = helper.getDriver();
		driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
		
		return null;
	}

}
