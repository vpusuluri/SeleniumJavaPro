package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class DashboardPage 
{
 
 WebDriver driver;
 
 //Constructor that will be automatically called as soon as the object of the class is created
 public DashboardPage(WebDriver driver) 
 {
	 	this.driver=driver;
 }
 
 //Locators for the page title and the logout button
 By heading = By.cssSelector("a#menu_dashboard_index > b");
 By welcomeHead = By.cssSelector("a#welcome");
 By username = By.cssSelector("a#welcome");
 By logoutBtn = By.cssSelector("div#welcome-menu > ul > li:nth-of-type(2) > a");
 
 //Method to capture the page heading
 public String getHeading() 
 {
	 String head = driver.findElement(heading).getText();
	 return head;
 }
 public String getUsername()
 {
	 String uname = driver.findElement(username).getText();
	 return uname;
 }
 
 
 //Method to click on Logout button
 public void clickLogout() 
 {
	 driver.findElement(welcomeHead).click();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 driver.findElement(logoutBtn).click();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 }
 
 
}