package SeleniumJava.Project;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest 
{
  WebDriver driver;
  
  @BeforeMethod
  public void setUp()
  {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe"); 
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		
  }
  @Test
  public void getPage() 
  {
	  driver.get("https://www.google.com"); 
	  boolean result = waitUntillPageLoadedFully();
	  System.out.println("The Return value of function = " + result);
	  Assert.assertTrue(result);
			 
  }
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
  
  public boolean waitUntillPageLoadedFully()
  {
	  JavascriptExecutor j = (JavascriptExecutor)driver;
      boolean result=false;
      for (int i=0; i<50; i++)
      {
    	  System.out.println("Inside for loop");
         // System.out.println("Inside try block" + time + "milliseconds ");
		 //driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		 if (j.executeScript("return document.readyState").toString().equals("complete"))
		 {
		  System.out.println("Page has loaded");
		  result = true;
		  break;
		
		 }
         
         
         
  }
	return result;
}
}
