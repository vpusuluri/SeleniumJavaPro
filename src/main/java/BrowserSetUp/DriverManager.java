package BrowserSetUp;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager
{
   protected WebDriver driver;
   protected abstract WebDriver createWebDriver();
   public void quitWebDriver()
   {
      if(null != driver)
      {
           driver.quit();
           driver=null;
     }
   }
    public WebDriver getWebDriver()
{
     if(null == driver)
      {
    	 System.out.println("Creating webdriver");
         driver = createWebDriver();
       }
       return driver;
    }
}