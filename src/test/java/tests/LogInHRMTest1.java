package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.SignInPage;
import pageObjectsPOM.BasePage;

public class LogInHRMTest1 {

	public WebDriver driver;
	// Creating object of Login page
	// SignInPage loginPage = new SignInPage(driver);

	SignInPage loginPage;
	DashboardPage dashboard;

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void setUp() 
	{

		  System.setProperty("webdriver.chrome.driver","C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe"); 
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		  
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
		  loginPage =   new SignInPage(driver); 
		  dashboard = new DashboardPage(driver);
		
	}

	@Test(priority = 0)
	public void loginPageTitleTest() 
	{
		System.out.println("Inside the Function");
		String title = loginPage.getLogInPageTitle();
		// System.out.println("Page Title = " + driver.getTitle());
		Assert.assertEquals(title, "OrangeHRM", "Home Page Displayed");
	}

	@Parameters({"username","password"})
	@Test(priority = 1)
	public void loginTest(String username,String password) 
	{

		loginPage.loginToSite(username, password);

		String uname = dashboard.getUsername();
		Assert.assertEquals(uname, "Welcome Paul", "User Logged in Successfully");

	}

	@Test(priority = 2)
	public void logOutTest() 
	{
	
		dashboard.clickLogout();
		boolean user = loginPage.isUserTextBoxPresent();
		Assert.assertTrue(user, "User Logged out Successfully");

	}
	
	
	  @AfterClass 
	  public void tearDown()
	  { 
		  
		  if(null != driver) {
	            driver.close();
	            driver.quit();
	
	  }
	  } 

}
