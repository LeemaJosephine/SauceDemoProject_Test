package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods{

	public HomePage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public HomePage enterUserName(String name) {
		
		driver.findElement(By.id("user-name")).sendKeys(name);
		return this;
	}
	
	public HomePage enterPassword(String password) {
		
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}
	
	public InventoryPage clickSubmit() {
		
		driver.findElement(By.id("login-button")).click();
		return new InventoryPage(driver);
	}
	
	
}
