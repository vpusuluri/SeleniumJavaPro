package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Test
public class newFeature 
{
	@Test(invocationCount=5)
	public void newFeatureTest() throws Exception
	{
		int count=0;
		System.out.println("Test Method Execution = " + count);
		
	
	}
	@Test(threadPoolSize = 3)
 	public void chromeTest() throws Exception
 	{ 
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe"); 
		 WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com"); 
	  Thread.sleep(10000);
	  driver.manage().window().maximize();
	  Thread.sleep(10000);
	  //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
	  //Thread.sleep(3000);
	  driver.quit();
 	}
	
	

}
