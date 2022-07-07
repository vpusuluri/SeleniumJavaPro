package pageObjectsPOM;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class HomePage 
{
 
 WebDriver driver;
 
 //Constructor that will be automatically called as soon as the object of the class is created
 
 
 @FindBy(css = "a#menu_dashboard_index > b")
 private WebElement heading;
  @FindBy(css = "a#welcome")
 private WebElement welcomeHead;
 
 @FindBy(css = "a#welcome")
 private WebElement username;
 
 @FindBy(css = "div#welcome-menu > ul > li:nth-of-type(2) > a")
 private WebElement logoutBtn;
 
 
 @FindBy(css = "h1")
 WebElement dashboardTitle;
 
 @FindBy(css="a#menu_dashboard_index > b")
 WebElement dashboardTab;
 
 @FindBy(css="a#menu_time_viewTimeModule > b")
 WebElement timeTab;
 
 @FindBy(css="a#menu_attendance_Attendance")
 WebElement attendSubTab;
 
 
 
 public HomePage(WebDriver driver) 
 {
	 	this.driver=driver;
	 	PageFactory.initElements(driver, this);
 }
 
 
 //Method to capture the page heading
 public String getHeading() 
 {
	 String head = heading.getText();
	 return head;
 }
 public String getUsername()
 {
	 String uname = username.getText();
	 return uname;
 }
 
 public void hoverOnAttendanceSubtab()
 {
	 Actions action = new Actions(driver);
	  action.moveToElement(timeTab).perform();
	  action.moveToElement(attendSubTab).perform();
	  
	  //action.moveToElement(course).click().perform();
 }
 
 
 
 
 //Method to click on Logout button
 public void clickLogout() 
 {
	 welcomeHead.click();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 logoutBtn.click();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 }
 
 
}