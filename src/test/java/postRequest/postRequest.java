package postRequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
public class postRequest {

	@Test
	public void postRequestMethod() {
		
		//Specify base URI
		 /* RestAssured.baseURI="http://restapi.demoqa.com/customer";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		   
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		  requestParams.put("FirstName","JohnXYZ");
		  requestParams.put("LastName","XYZJohn");
		  requestParams.put("UserName","JohnXYZ");
		  requestParams.put("Password","JohnXYZxyx");
		  requestParams.put("Email","JohnXYZ@gmail.com");
		  
		  
		  httpRequest.header("Content-Type","application/json");
		  
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST,"/register");
		    
		  System.out.println(response.getStatusCode());*/
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Tim");
		map.put("class", "2nd");
		
		Arrays.asList("tun","pin");
		
		JSONObject jsonObject = new JSONObject(map);
		System.out.println(jsonObject);
		
		given().contentType(ContentType.JSON)
		.body(jsonObject)
		.when().post("https://reqres.in/api/users").then().statusCode(201);
		
	}
}
