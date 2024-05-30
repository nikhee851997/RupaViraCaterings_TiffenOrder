package listenerscodeonTiffenOrdersByRupavira;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reportmanager.ExtentReportsManager;

public class MyListeners implements ITestListener
{
	
 public WebDriver driver;
 public ExtentReports extent;
 public ExtentTest test;
 public ExtentSparkReporter spark;
 
 
 @Override
 public void onStart(ITestContext context)
 //ITestContext is an interface that shares data between testcases in the same class
 {
	 
	 //1.Create the object of ExtentReports class(Subject)
	 extent = ExtentReportsManager.generateReport();
	 
	 //2.Create the object of ExtentSparkReporter class(acts as Observer) through which we can specify where we want to store our ExtentReports
	 spark = new ExtentSparkReporter("ExtentReportSample\\Index.html");
	 
	 // Config that ExtentReport as we wanted (Customizable)
	 spark.config().setReportName("RupaViraCaterings");
	 //                              (Name of project_JIRA story_Environment )
	 spark.config().setDocumentTitle("TiffensOrderPlacement_Allergies,SpecialInstructions_QA ExtentReports");
	 spark.config().setTheme(Theme.DARK);
	 spark.config().setEncoding("utf-8");
	 spark.config().setTimeStampFormat("MM-dd-yy HH:mm:ss");
	 
	 //3.And ExtentSparkReporter class is attached to ExtentReports class(Subject)
	 extent.attachReporter(spark);
	 
	 //Name of the method
	 String TestCaseinitial= context.getName();

	 //To create a method on extent report
	 test = extent.createTest(TestCaseinitial);
	 
	 
	 //To know the status of method on extent report
	 test.log(Status.INFO, TestCaseinitial+ "-----------> Started browsing for the items");
	 
 }
 
 @Override
 public void onTestStart(ITestResult result)
 //ITestResult is an interface that gives result of a testcase execution
 {
	 
	 //Name of the method
	 String TestCasesecondary= result.getName();
	 
	 //To create a method on extent report
	 test= extent.createTest(TestCasesecondary);
	 
	 //To know the status of the method on extent report
	 test.log(Status.INFO, TestCasesecondary+ "-----------> you are almost there Keep selecting items");
	  
 }
 
 @Override
 public void onTestSuccess(ITestResult result)
 {
	 
	 //Name of the method
	 String Testcaseexecuted = result.getName();
	 
	 //To know the status of the method on extent report
	 test.log(Status.INFO, Testcaseexecuted+ "-----------> Placed order successfully");
 }
 
 @Override
 public void onTestFailure(ITestResult result)
 {
	 
	 //Name of the method
	 String Testcasefailed =result.getName();
	 
	 driver= null;
		
		try
		{
			//method chaining
		  driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) 
		{
			e.printStackTrace();
		}
		
		
		// TakesScreenshot is an interface that enables  driver to capture screenshot  
		// getScreenshotAs method captures screenshot and stores it in specified location.

		File Srce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String Dest = System.getProperty("user.dir")+"\\test-output\\Screenshots\\" + Testcasefailed+ ".png";
	    
		try 
		{
			FileHandler.copy(Srce, new File(Dest));	
	    } 
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(Dest);
		
	 //To know the status of the method on extent report
	 test.log(Status.INFO, Testcasefailed+ "-------------> Sorry something went wrong");
	 
 }
 
 @Override
 public void onTestSkipped(ITestResult result)
 {
	 
	 //Name of the method
	 String Testcaseskipped = result.getName();
	 
	 //To know the status of the method on extent report
	 test.log(Status.INFO, Testcaseskipped+ "------------> Hang tight we are working on it");
	 
 }
 
 @Override
 public void onFinish(ITestContext context)
 {
	 
	//Name of the method
	String TestCaseend = context.getName();
	
	//To create a method on extent report
	ExtentTest test= extent.createTest(TestCaseend);
	
	//To know the status of the method on extent report
	test.log(Status.INFO, TestCaseend + "-----------> Thanks for the order, Enjoy your meal");
	
	//4.This method instructions ExtentReports to write test info at certain destination
	extent.flush();
	
	// This is path where extent report is stored
	String pathOfExtentReport = System.getProperty("user.dir")+"\\ExtentReportSample\\Index.html";
	
	//This will throw the extent report on my desktop by picking file from the path directly. 
	File extentReportPath = new File(pathOfExtentReport);
	try 
	{
	    Desktop.getDesktop().browse(extentReportPath.toURI()); // uri means Uniform Resource Identifier
	} 
	catch (IOException e)
	{
		//If it fail to pick it gets the reason why it cannot do that.
		e.printStackTrace();
	}
	
  }
	
 }
 
 

