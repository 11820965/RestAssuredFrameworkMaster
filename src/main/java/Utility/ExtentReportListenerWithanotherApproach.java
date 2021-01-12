package Utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListenerWithanotherApproach implements ITestListener{
	
	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest = extentReport.startTest(result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(LogStatus.PASS, "Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(LogStatus.FAIL, "Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(LogStatus.SKIP, "Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport"+ReusableClass.getCurrentTimeStamp()+"_.html", true);
		extentReport
        .addSystemInfo("Host Name", "SoftwareTestingMaterial")
        .addSystemInfo("Environment", "Automation Testing")
        .addSystemInfo("User Name", "Rajkumar SM");
		extentReport.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
		//extentReport.close();
		
	}

}
