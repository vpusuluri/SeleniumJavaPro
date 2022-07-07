package BrowserSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager
{

	private WebDriver driver;

	public WebDriver createWebDriver()
	{
		System.out.println("Inside ChromeDriverManager");
		 ChromeOptions options = new ChromeOptions();
		 options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\pvbra\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe"); 
		 driver = new ChromeDriver(options);
		 System.out.println("Driver in create webdriver = " + driver);
		 return driver;
		 
	}

}
