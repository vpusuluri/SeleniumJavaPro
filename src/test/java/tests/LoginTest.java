package tests;

import org.testng.annotations.Test;

import Listener1.TestNGCustomReportListener;
import UFrame.BaseTest;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


@Listeners(Listener1.MyTestListener.class)

public class LoginTest  extends BaseTest
{
   WebDriver driver;
  
   
   SignInPage loginPage;
   HomePage homepage;
   private final static TestNGCustomReportListener frl = new TestNGCustomReportListener();
   TestNG testng = new TestNG();
   
   
   @BeforeClass
   public void setUp() throws Exception 
   {
	   
	   
		
		//setDriver("chrome","https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe"); 
		
		  driver = new ChromeDriver(); 
		  driver.manage().timeouts().implicitlyWait(60,
		  TimeUnit.SECONDS);
		  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		  Reporter.log("The OrangeHRM website is Launched");
		  Thread.sleep(6000);
		  driver.manage().timeouts().implicitlyWait(60,
		  TimeUnit.SECONDS); driver.manage().window().maximize();
		  Reporter.log("Window is Maximized");
 		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  loginPage = new SignInPage(driver);
			 homepage = new HomePage(driver);
 		
   }
   
   
   
   
   
   @BeforeTest
   public void setOutputDirectory(ITestContext context) {
      TestRunner runner = (TestRunner) context;
      String path=System.getProperty("user.dir");
      runner.setOutputDirectory(path+"/output-testng");
   }
  
  @Test(priority=1)
  public void openAppTest() 
  {
	  
      String title = loginPage.getLogInPageTitle();
      Reporter.log("The Page Title = " + title);
	  //String title = driver.getTitle();				 
	  Assert.assertTrue(title.contains("OrangeHRM")); 	
  }
  
  @Test(priority=2)
  public void loginTest() throws Exception
  {
	  //loginPage = new SignInPage(driver);
	  loginPage.loginToSite("Admin", "admin123");
	  //Thread.sleep(3000);;
	  String uname = homepage.getLoggedInUser();
	  Reporter.log("Logged in User Name = " + uname);
	  Assert.assertEquals(uname, "Welcome satish", "LoggedInUsr");
  }
  
  @Test(priority=3)
  public void logoutUserTest() throws Exception
  {
	  homepage.ClickWelcomeUser();
	  Thread.sleep(3000);;
	  homepage.logout();
  }

  @AfterClass
  public void tearDown() 
  {
	 Reporter.log("Browser is Getting closed");
	  driver.quit();
  }

}
