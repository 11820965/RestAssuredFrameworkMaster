package Utility;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jayway.jsonpath.internal.filter.LogicalOperator;

public class ExtentReportListener implements ITestListener{
	
	
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReport;
	ExtentTest extentTest;
	Logger logger;
	static String CurrentTimeStamp ;
	private static final String dir = System.getProperty("user.dir");
	
	
	
	 public ExtentReportListener() {
		logger = Logger.getLogger("log4j.properties");
		
	}
	
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest = extentReport.createTest(result.getMethod().getMethodName());
		extentTest.log(Status.INFO, result.getMethod().getMethodName());
		extentTest.log(Status.INFO, result.getTestClass().getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.log(Status.PASS, "Test has been passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.FAIL, "Test has been failed due to below error : "+result.getThrowable());
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.log(Status.SKIP, "Test has been skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart (ITestContext context) {
		// TODO Auto-generated method stub
		
		
		
		try {
				//String currentTimeString = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date());
				File file = new File(dir+"\\Detailed_Report"+"\\extentReport1_"+".html");
				//FileOutputStream fo = new FileOutputStream(file);
				htmlReporter = new ExtentHtmlReporter(file); 
						
						
				htmlReporter.config().setDocumentTitle("RestAssured Framework Details");
				htmlReporter.config().setTheme(Theme.STANDARD);
				htmlReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
				
				extentReport = new ExtentReports();
				extentReport.attachReporter(htmlReporter);
				
				extentReport.setSystemInfo("HostName", "localhost");
				extentReport.setSystemInfo("Environment", "QA");
				extentReport.setSystemInfo("user", "srabanti.ghosh");
				
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
			
	}
	
	
	

}
