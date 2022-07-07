package BrowserSetUp;

public class DriverManagerFactory
{
   public static DriverManager getDriverManager(DriverType type)
   {
      DriverManager driverManager=null;
      switch(type)
      {
         case 
                CHROME:
                      driverManager = new ChromeDriverManager();
                      System.out.println("The driver here = " + driverManager);
                      break;
         /*case 
                FIREFOX:
                       driverManager = new FireFoxManager();
                       break;
         case 
                 IE:
                       driverManager = new IEDriverManager();
                       break;*/
        }
      return driverManager;
      
}
   
}