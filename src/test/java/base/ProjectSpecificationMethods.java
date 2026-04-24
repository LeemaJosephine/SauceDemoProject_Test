package base;


import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificationMethods extends UtilityClass {

	@BeforeSuite
	public void reportInitialzation() {
		
		//To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\leema\\eclipse-workspace\\SauceDemoProject_Test\\TestReport\\SauceDemo_TestReport.html");
		reporter.config().setReportName("Sauce Demo Application Test Report");  // optional
		
		//To capture the test data
		// ITestListener -> ExtentReports -> ExtentSparkReporter
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);	
	}
	
	@BeforeClass
	public void testDetails() {
		
		test = extent.createTest(testname,testdescription);
		test.assignCategory(testcatgory);
		test.assignAuthor(author);
	}
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void launchBrowser(String url, String browser) {
		
		launchBrowserAndLoadURL(url,browser);
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		browserClose();
	}
	
	@DataProvider
	public String[][] readData() throws IOException {
		
		return readExcel(sheetname);
	}
	
	@AfterSuite
	public void closeReport() {
		extent.flush();
	}
	
}
