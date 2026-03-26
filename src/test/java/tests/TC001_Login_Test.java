package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC001_Login_Test extends ProjectSpecificationMethods{

	@Test
	public void loginTest() {
		// TODO Auto-generated method stub

		HomePage obj = new HomePage(driver);
		obj.enterUserName("standard_user");
		obj.enterPassword("secret_sauce");
		obj.clickSubmit();
	}

}
