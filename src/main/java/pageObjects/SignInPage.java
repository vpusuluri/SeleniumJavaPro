package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignInPage 
{
	 
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public SignInPage(WebDriver driver) 
	 {
	          this.driver = driver;
	          PageFactory.initElements(driver, this);
	 }
	 
	 //Locator for username field
	 private By uName = By.cssSelector("input#txtUsername");
	 
	 //Locator for password field
	 private By pswd = By.cssSelector("input#txtPassword");
	 
	 //Locator for login button
	 private By loginBtn = By.cssSelector("input#btnLogin");
	 
	 private By loginLink = By.cssSelector(".ico-login");
	 //Method to enter username
	 public void enterUsername(String user) 
	 {
		 driver.findElement(uName).sendKeys(user);
	 }
	 public boolean isUserTextBoxPresent()
	 {
		 return driver.findElement(uName).isDisplayed();
		 
	 }
	
	 public String getLogInPageTitle()
	 {
		 System.out.println("Page Title = " + driver.getTitle());
		 return  driver.getTitle();
		 
	 }
	 
	 //Method to enter password
	 public void enterPassword(String pass) {
		 driver.findElement(pswd).sendKeys(pass);
	 }
	 
	 //Method to click on Login button
	 public void clickLogin() {
	 driver.findElement(loginBtn).click();
	 }
	 
	 public void clickLoginLink()
	 {
		 driver.findElement(loginLink).click();
	 }
	 
	 public void loginToSite(String Username, String Password)
	 {
	                 this.enterUsername(Username);
	                 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	                 this.enterPassword(Password);
	                 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	                 this.clickLogin();
	                 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	}