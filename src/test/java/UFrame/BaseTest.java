package UFrame;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;
import pageObjects.SignInPage;

public class BaseTest 
{

    WebDriver driver;
   
   
   
    //driver = new ChromeDriver();
    protected void setDriver(String browserType, String appURL) 
    {
		switch (browserType) 
		{
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
			
			
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}
    
    private static WebDriver initChromeDriver(String appURL) 
    {
		System.out.println("Launching google chrome with new profile..");
		//System.setProperty(key, value)
		
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-features=VizDisplayCompositor");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
    private static WebDriver initFirefoxDriver(String appURL) 
    {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
    
	/*
	 * @Parameters({ "browserType", "appURL" })
	 * 
	 * @BeforeClass public void initializeBaseTestSetup(String browserType, String
	 * appURL) { try { setDriver(browserType, appURL);
	 * 
	 * } catch (Exception e) { System.out.println("Error....." + e.getStackTrace());
	 * } }
	 */
	
	
	
	 


    public WebDriver getDriver() 
    {
        return driver;
    }
}