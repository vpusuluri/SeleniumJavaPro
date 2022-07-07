package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOne 
{

	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
	   WebDriver driver = new ChromeDriver();
	   driver.get("http://demoqa.com/text-box");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   driver.getTitle();
	   driver.getCurrentUrl();
	   driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("User Name");
	   driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("123 Test Address");
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   WebElement element = driver.findElement(By.xpath("//button[@id='submit']"));
	   js.executeScript("arguments[0].scrollIntoView();",element);
	   driver.findElement(By.xpath("//button[@id='submit']")).click();
	   Thread.sleep(3000);
	   System.out.println(driver.findElement(By.xpath("//*[@id='output']/div")).getText());
	   driver.quit();
	}
	

}
