package Selfuncs;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CommonFunctions 
{
	private WebDriver driver;
	private boolean isElementPresent(By by)
	{
	    try 
	    {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) 
	    {
	      return false;
	    }
	  }
	
	private boolean isAlertPresent() 
	{
	    try 
	    {
	      driver.switchTo().alert();
	      return true;
	    } 
	    catch (NoAlertPresentException e) 
	    {
	      return false;
	    }
	  }
	
	public void sleep(int seconds) 
	{
	    try 
	    {
	      Thread.sleep(seconds * 1000);
	    } catch (InterruptedException e) 
	    {
	      e.printStackTrace();
	    }
	  }
	

}
