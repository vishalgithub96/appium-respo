package testcases;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.util.Assert;


public class TestExtentReports 
{
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	@BeforeTest
	public void setupReport() 
	{
		htmlReporter = new ExtentSparkReporter("./report/extent.html");	
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("W2 Automation Report");
		htmlReporter.config().setReportName("Automation test results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation Tester", "Vishal Kumar");
		extent.setSystemInfo("Build No", "12345");
		extent.setSystemInfo("Organization ", "crocus robotics pvt ltd ");

	}
	
	@Test(priority = 0)
	public void loginTest() 
	{
		test=extent.createTest("Login Test");
		test.log(Status.INFO, "Entering username");
		test.info("Entering password");
		
		
	}
	@Test(priority = 1)
	public void userRegTest() 
	{
		test=extent.createTest("User Reg Test");
		test.log(Status.INFO, "Entering first name");
	   	
	}
	@Test(priority = 2)
	public void skipTest() 
	{
		test=extent.createTest("User Reg Skip");
		test.info("skip first name");
		throw new SkipException("skipping the test cases");
	
		
	}
	
	@AfterMethod
	public void updateResults(ITestResult result) 
	{
		if (result.getStatus()==ITestResult.SUCCESS) 
		{   
			String methodName = result.getMethod().getMethodName();
			test.pass(methodName.toUpperCase()+" : Pass");
			
		}else if (result.getStatus()==ITestResult.FAILURE) 
		{   String methodName = result.getMethod().getMethodName();
		    test.fail(methodName.toUpperCase()+" : FAILED");
		}
		else if (result.getStatus()==ITestResult.SKIP) 
		{   String methodName = result.getMethod().getMethodName();
		    test.skip(methodName.toUpperCase()+" : SKIPPED");
		}
	}
	
	
	
	
	@AfterTest
	public void endReport() 
	{
		extent.flush();
	}
	
	
	

}
