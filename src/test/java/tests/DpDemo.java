package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* @Test method testAddMethod is called 3 times, as there are 3 sets of parameter provided by @DataProvder */
public class DpDemo 
{
	  @DataProvider(name = "addMethodDp")
	  public Object[][] dataProvider()
	  {
		  return new Object[][]
				  {
			          {2,5,7},{3,7,10},{4,5,9}
				  };
	  }
	  
	  @Test(dataProvider = "addMethodDp")
	  public void testAddMethod(int a, int b, int result)
	  {
		  Calculator calculator = new Calculator();
		  Assert.assertEquals(calculator.add(a,b),result );
	  }

}
