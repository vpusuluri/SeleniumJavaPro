package tests;

import org.testng.annotations.Test;

public class Testruntime 
{

	@Test(expectedExceptions = ArithmeticException.class)
	public void divisionWithException()
	{
		int i = 1/0;
	}
	
}
