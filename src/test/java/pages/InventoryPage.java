package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class InventoryPage extends ProjectSpecificationMethods{

	@FindBy(className = "app_logo")
	WebElement logo_name;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errorMsg;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public InventoryPage validateLogin(String Test_Type, String ExpectedText) {
		
		if(Test_Type.equalsIgnoreCase("ValidUNValidPass")) {
			Assert.assertEquals(logo_name.getText(),ExpectedText);
		
		} else if(Test_Type.equalsIgnoreCase("InvalidUNValidPass")) {
			Assert.assertEquals(errorMsg.getText(), ExpectedText);
		}
		
		return this;
	}
}
