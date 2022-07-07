package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BrowserSetUp.DriverManager;
import BrowserSetUp.DriverManagerFactory;
import BrowserSetUp.DriverType;
import Utilities.screenshot;

import pageObjects.DashboardPage;
import pageObjects.SignInPage;
import pageObjectsPOM.BasePage;
import pageObjectsPOM.HomePage;

public class LogInHRMTest {

	public WebDriver driver;
	DriverManager driverManager;
	// Creating object of Login page
	// SignInPage loginPage = new SignInPage(driver);

	SignInPage loginPage = new SignInPage(driver);
	HomePage dashboard = new HomePage(driver);
	 ExtentReports extent;
	 ExtentTest logger;
	//@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void setUp() 
	{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
	   
		  //System.setProperty("webdriver.chrome.driver","C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe"); 
		  //WebDriver driver = new ChromeDriver();
		  //WebDriverManager.chromedriver().setup();
		  driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		  System.out.println("Driver in setup = " + driverManager);
		  //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
			driver = driverManager.getWebDriver();
		  //driver = new ChromeDriver();
			  System.out.println("Driver  = " + driver);
		  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		/*
		 * extent = new ExtentReports(); extent.attachReporter(reporter);
		 * logger=extent.createTest("LoginTest");
		 */
		  //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
		  loginPage =   new SignInPage(driver); 
		  dashboard = new HomePage(driver);
		
	}

	@Test(priority = 0)
	public void loginPageTitleTest() 
	{
		System.out.println("Inside the Function");
		String title = loginPage.getLogInPageTitle();
		// System.out.println("Page Title = " + driver.getTitle());
		Assert.assertEquals(title, "OrangeHRM", "Home Page Displayed");
	}

	//@Parameters({"username","password"})
	@Test(priority = 1)
	public void loginTest() throws IOException
	{
		
		loginPage.loginToSite("Admin", "admin123");

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
	  public void tearDown() throws IOException
	  { 
		  
		
		  if(null != driver) {
	            driver.close();
	            driver.quit();
	
	  }
	  } 

}
