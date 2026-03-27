package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods{

	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement pass;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage enterUserName(String name) {
		
		username.sendKeys(name);
		return this;
	}
	
	public HomePage enterPassword(String password) {
		
		pass.sendKeys(password);
		return this;
	}
	
	public InventoryPage clickSubmit() {
		
		driver.findElement(By.id("login-button")).click();
		return new InventoryPage(driver);
	}
	
	
}
