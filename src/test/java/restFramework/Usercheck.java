package restFramework;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Usercheck {
	static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("currenttime", dateFormat.format(new Date()));
        //System.setProperty(arg0, arg1)
    }
	TestBase testBase;
	//add custom log message
	static Logger logger = Logger.getLogger(Usercheck.class);
	
	
	
	@BeforeClass 
	public void setUP() {
		testBase = new TestBase("http://dummy.restapiexample.com/api/v1");
		logger.info("Prechecks completed");
		
	}
	
	@Test
	public void getEmployee() {
		
		Response response = testBase.getRequest();
		Assert.assertEquals(200, response.getStatusCode());
		logger.info("request sent successfully");
		System.out.println(response.getBody().asString());
		
		System.out.println("**********************");
	}
	
	@Test
	public void getEmployeenegative() {
	
			Response response = testBase.getRequestnegative();
			Assert.assertEquals(200, response.getStatusCode());
			logger.info("request sent successfully");
			System.out.println(response.getBody().asString());
		
	}
	
	/*@AfterMethod
	public void disconnect() {
		
		testBase.closeConnections();
	}*/
	
	
	
	

}
