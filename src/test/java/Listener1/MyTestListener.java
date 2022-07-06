package Listener1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener  implements ITestListener
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("New Test Started:  " +result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Get Name Test Successfully Finished:  " +result.getName());
		System.out.println("Get Status Test Successfully Finished:  " +result.getStatus());
		System.out.println("Get Host Test Successfully Finished:  " +result.getHost());
		System.out.println("Get Test Name Test Successfully Finished:  " +result.getTestName());
		System.out.println("Get Instance Name Test Successfully Finished:  " +result.getInstanceName());
		System.out.println("Get Parameters Test Successfully Finished:  " +result.getParameters());
		System.out.println("Get Start Millis Test Successfully Finished: " +result.getStartMillis());
		System.out.println("Get end Millis Test Successfully Finished: " +result.getEndMillis());
		System.out.println("Get Attributes Name Test Successfully Finished: " +result.getAttributeNames());
		System.out.println("Get Test Context Test Successfully Finished: " +result.getTestContext());
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Get Name Test Failed: " +result.getName());
		System.out.println("Get Status Test Failed:  " +result.getStatus());
		System.out.println("Get Host Test Failed:  " +result.getHost());
		System.out.println("Get Test Name Test Failed:  " +result.getTestName());
		System.out.println("Get Instance Name Test Failed:  " +result.getInstanceName());
		System.out.println("Get Parameters Test Failed:  " +result.getParameters());
		System.out.println("Get Start Millis Test Failed: " +result.getStartMillis());
		System.out.println("Get end Millis Test Failed: " +result.getEndMillis());
		System.out.println("Get Attributes Names Test Failed: " +result.getAttributeNames());
		System.out.println("Get Test Context Test Failed: " +result.getTestContext());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test Skipped: " +  result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("Test Failed but within success percentage: " + result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("Test onStart: " + context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("Test onFinish:  " + context.getName());
		
	}

}
