package tests;

import java.util.Scanner;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class ArithemeticException 
{

		@Test(expectedExceptions= ArithmeticException.class)
		public void arithExcepTest()
		{
			int i = 2/0;
			System.out.println("The value of i = " + i);
		}
		
		@Test()
		public void skipExceptionTest()
		{
			System.out.println("Skipping this test");
			//Scanner scan = new Scanner(System.in);
			String str = "string";
			if(str.equalsIgnoreCase("string"))
			{
			throw new  SkipException("I will be skipped");
			}
		}
		

}
