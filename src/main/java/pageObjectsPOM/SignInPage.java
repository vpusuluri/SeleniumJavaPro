package pageObjectsPOM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SignInPage 
{
	 
	 WebDriver driver;
	
	 
	 
	 //Locator for username field
	 @FindBy(css = "input#txtUsername")
	 //private By uName = By.cssSelector("input#txtUsername");
	 WebElement uName;
	 
	 //Locator for password field
	 @FindBy(css = "input#txtPassword")
	 WebElement pswd;
	 
	 //Locator for login button
	 @FindBy(css = "input#btnLogin")
	 WebElement loginBtn;
	 
	//Constructor that will be automatically called as soon as the object of the class is created
		 public SignInPage(WebDriver driver) 
		 {
		         this.driver = driver;
		         PageFactory.initElements(driver, this);
		 }
	 //Method to enter username
	 public void enterUsername(String user) 
	 {
		 uName.sendKeys(user);
	 }
	 public boolean isUserTextBoxPresent()
	 {
		 return uName.isDisplayed();
		 
	 }
	
	 public String getLogInPageTitle()
	 {
		 System.out.println("Page Title = " + driver.getTitle());
		 return  driver.getTitle();
		 
	 }
	 
	 //Method to enter password
	 public void enterPassword(String pass) {
		 pswd.sendKeys(pass);
	 }
	 
	 //Method to click on Login button
	 public void clickLogin() {
	 loginBtn.click();
	 }
	 
	 public void loginToSite(String Username, String Password)
	 {
	                 this.enterUsername(Username);
	                 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	                 this.enterPassword(Password);
	                 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	                 this.clickLogin();
	                 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	}