package extentReports;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BuildExtent {


	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static MediaEntityModelProvider mediaModel;
	public static ExtentKlovReporter klovReporter;
	public static ExtentLoggerReporter loggerReporter;

	public static ExtentReports getInstance() {
		return extent;
	}



	//Initialize the Klov Report
	public static void klovReport(String projectName, String reportName, String hostName, int hostNumber, String klovURL){

		//TODO: Setup klov using properties file: klovReporter.loadInitializationParams("klov.properties");

		klovReporter = new ExtentKlovReporter(projectName, reportName);

		// specify mongoDb connection
		klovReporter.initMongoDbConnection(hostName, hostNumber);

		//URL of the KLOV server you must specify the served URL to ensure all your runtime media is uploaded to the server
		klovReporter.initKlovServerConnection(klovURL);
	}


	//Initialize the Logger Report
	public static void loggerReport(String loggerFilePath) {

		//Add a logger file path
		loggerReporter = new ExtentLoggerReporter(loggerFilePath);
	}



	//Builds the HTML Extent Report
	public static ExtentReports buildReport(String reportPath, String attachKlovReport, String reportName) throws IOException{

		//Initialize the HtmlReporter
		sparkReporter = new ExtentSparkReporter(reportPath);

		sparkReporter.config().setDocumentTitle(reportName);
		sparkReporter.setAnalysisStrategy(AnalysisStrategy.SUITE);

		//Initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();

		//TODO: Include logic to attach multiple types of reports based on user flag

		//Attach only HtmlReporter
		extent.attachReporter(sparkReporter);

		return extent;

	}


	//Build a Customized logo for the Extent Report
	public static void customizeReport(String htmlFile, String release, String reportName) throws IOException {
		FileReader fr = new FileReader(htmlFile);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder content = new StringBuilder(1024);
		String s;
		while ((s = br.readLine()) != null) {
			content.append(s);
		}
		s= content.toString();

		//Use the below replace all function to find and replace the HTML content within the report
		s = s.replaceAll("", ""); //To Replace Extent Reports Link
		BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
		bw.write(s);
		br.close();
		bw.close();
	}


	//Initialize the test nodes
	public static ExtentTest parentTest;
	public static ExtentTest childTest;


	//Creates a Parent Test
	public static ExtentTest createParentTest(String testName, String testDescription, String testCategory) {
		parentTest = getInstance().createTest(testName, testDescription);
		parentTest.assignCategory(testCategory);
		return parentTest;
	}


	//Parent Test Instance
	public static ExtentTest getParentInstance() {
		return parentTest;
	}


	//Creates a Child Test
	public static ExtentTest createChildTest(String testName, String testDescription, String testCategory) {
		childTest = getParentInstance().createNode(testName, testDescription);
		childTest.assignCategory(testCategory);
		return childTest;
	}


	//Creates an Independent Child Test
	public static ExtentTest createIndependentChildTest(String testName, String testDescription, String testCategory) {
		childTest = getInstance().createTest(testName, testDescription);
		childTest.assignCategory(testCategory);
		return childTest;
	}


	//Child Test Instance
	public static ExtentTest getChildInstance() {
		return childTest;
	}



	//Step status

	//Pass step
	public static void passStep(String stepDescription) {
		getChildInstance().log(Status.PASS, stepDescription);
		System.out.println(stepDescription);
	}

	//Fail step
	public static void failStep(String stepDescription) {
		getChildInstance().log(Status.FAIL, stepDescription);
		System.out.println(stepDescription);
	}

	//Skip step
	public static void skipStep(String stepDescription) {
		getChildInstance().log(Status.SKIP, stepDescription);
		System.out.println(stepDescription);
	}

	//Info step
	public static void infoStep(String stepDescription) {
		getChildInstance().log(Status.INFO, stepDescription);
		System.out.println(stepDescription);
	}

	//Warning step
	public static void warningStep(String stepDescription) {
		getChildInstance().log(Status.WARNING, stepDescription);
		System.out.println(stepDescription);
	}

	//Error step
	public static void errorStep(String stepDescription) {
		getChildInstance().log(Status.ERROR, stepDescription);
		System.out.println(stepDescription);
	}

	//Exception step
	public static void fatalStep(String stepDescription) {
		getChildInstance().log(Status.FATAL, stepDescription);
		System.out.println(stepDescription);
	}


	//Publish Report
	public static void publishReport(String htmlFile, String release, String reportName) throws IOException {
		//Write to report in the end
		getInstance().flush();
		//Include modifications to the HTML
		customizeReport(htmlFile, release, reportName);
	}


	//Create parent and child test case
//	public static void createParentChildTestCase(String parentTestCase, String childTestCase){
//
//		if (!(parentTestCase.equalsIgnoreCase(GlobalVariable.parentTestCase))) {
//			GlobalVariable.parentTestCase = parentTestCase
//
//					createParentTest(GlobalVariable.parentTestCase, "", GlobalVariable.testCategory);
//		}
//
//		GlobalVariable.childTestCase = childTestCase
//				createChildTest(GlobalVariable.childTestCase, '', GlobalVariable.testCategory);
//
//	}

}
