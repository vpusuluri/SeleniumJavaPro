package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	 
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public HomePage(WebDriver driver) 
	 {
	          this.driver = driver;
	          PageFactory.initElements(driver, this);
	 }
	 
	 //Locator for username field
	 private By welcomeUser = By.cssSelector("a#welcome");
	 
	 private By logout = By.xpath("//div[@id='welcome-menu']/ul/li[3]");
	 
	 //Locator for password field
	 
	 //Method to enter username
	 public String getLoggedInUser() 
	 {
		 return driver.findElement(welcomeUser).getText();
	 }
	 public void ClickWelcomeUser()
	 {
		 driver.findElement(welcomeUser).click();
	 }
	 public void logout()
	 {
		 driver.findElement(logout).click(); 
	 }
	 
	
	}