package base;


import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.UtilityClass;

public class ProjectSpecificationMethods extends UtilityClass {

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
	
}
