package listenerUtility;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseUtility.BaseClass;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class ListenerImplementationClass implements ITestListener, ISuiteListener{
public ExtentReports report;
public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		JavaUtility jutil= new JavaUtility();
		String time = jutil.getCurrentDateAndTimeForSS();
	System.out.println("Execution Started and Report Configuration");
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("VTIGER_CRM");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		
		System.out.println("Execution completed and report Backup");
		report.flush();
		}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"==START==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.INFO, methodName+"==SUCCESS==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
	    test= report.createTest(methodName);
		JavaUtility jutil= new JavaUtility();
		String dateAndTime = jutil.getCurrentDateAndTimeForSS();
	
			TakesScreenshot tks= (TakesScreenshot) BaseClass.sdriver;
			String temp = tks.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(temp,methodName+"_"+dateAndTime );
			test.log(Status.FAIL,methodName+"==FAILED==");
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"==SKIPPED==");
	}


	

	
}
