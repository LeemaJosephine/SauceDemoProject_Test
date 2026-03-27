package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC001_Login_Test extends ProjectSpecificationMethods{

	@BeforeTest
	public void setup() {
		
		sheetname="LoginData";
		
	}
	
	@Test(dataProvider = "readData")
	public void loginTest(String username, String password, String test_type, String Expected_Message) {
		// TODO Auto-generated method stub

		new HomePage(driver)
		.enterUserName(username)
		.enterPassword(password)
		.clickSubmit()
		.validateLogin(test_type,Expected_Message);
		
	}

}
