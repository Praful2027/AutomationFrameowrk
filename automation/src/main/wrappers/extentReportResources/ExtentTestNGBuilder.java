package extentReportResources;

import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import seleniumResources.DriverUtils;

public class ExtentTestNGBuilder extends BuildExtent{
	
	private static DriverUtils util;
	
	
	public void updateResult(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			//Capture and attach screenshot
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
			String screenshotPath = util.takeScreenshot(result.getName());
			
			//MarkupHelper is used to display the output in different colors
			getChildInstance().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			getChildInstance().log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			//To add it in the extent report 

			getChildInstance().fail("Test Case Failed Snapshot is below " + getChildInstance().addScreenCaptureFromPath(screenshotPath));
			
		}
		else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			getChildInstance().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		} 
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			getChildInstance().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case PASSED", ExtentColor.GREEN));
		}
		
	}
	
	
}
