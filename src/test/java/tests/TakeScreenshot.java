package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot 
{

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.jockey.in/");
		driver.manage().window().maximize();
		/*
		 * File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * File dstFile = new File(
		 * "C:\\Users\\pvbra\\eclipse-workspace\\WebDriverProject\\Screenshots\\screenshot1.png"
		 * ); FileUtils.copyFile(srcFile, dstFile);
		 */
		
		WebElement section = driver.findElement(By.cssSelector("img[alt='Jockey Nightwear for Men']"));
		File srcFile1 = section.getScreenshotAs(OutputType.FILE);
		File dstFile1 = new File("C:\\Users\\pvbra\\eclipse-workspace\\WebDriverProject\\Screenshots\\screenshot2.png");
		FileUtils.copyFile(srcFile1, dstFile1);
		
		
		  WebElement partelem =  driver.findElement(By.cssSelector(".locateAStoreLink")); 
		  File srcFile2 =  partelem.getScreenshotAs(OutputType.FILE); 
		  File dstFile2 = new File("C:\\Users\\pvbra\\eclipse-workspace\\WebDriverProject\\Screenshots\\screenshot3.png"
		  ); 
		  FileUtils.copyFile(srcFile2, dstFile2);
		 
		
		driver.quit();
		
	

	}

	

}
