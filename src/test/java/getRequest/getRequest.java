package getRequest;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getRequest {
	
	@BeforeTest
	public void authentication() {
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "ToolsQa");
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication/";
	}
	
@Test
public void testResponse(){
	
	/*Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
	int code= resp.getStatusCode();
	System.out.println(code);
	//System.out.println(resp.getBody().asString());
	
	JsonPath JosnEvaluator = resp.jsonPath();
	System.out.println(JosnEvaluator.get("wind.speed").toString());*/
	
	/*RestAssured.baseURI="https://samples.openweathermap.org/data/2.5";
	Response response = RestAssured.given().queryParam("q", "London,uk").queryParam("appid", "439d4b804bc8187953eb36d2a8c26a02").when().get("/weather");
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("Transfer-Encoding"));
	Headers AllHeaders = response.getHeaders();
	
	for (Header header : AllHeaders) {
		System.out.println(header.getName()+"  "+header.getValue());
	}
	*/
	//given().get("https://reqres.in/api/users?page=2").then().body("data.findAll {id<9}.email", hasItems("michael.lawson@reqres.in"));

	Response response = given().get()
						.then().statusCode(200).extract().response();
	String StringResponse = response.getBody().toString();
	
	JsonPath jsonPath = response.jsonPath();
	System.out.println(jsonPath);
	
	
	/*List<String> email = from(StringResponse).getList("data.findAll{it.id<9}.email");
	System.out.println(email);
	
	System.out.println(given().get("https://reqres.in/api/users?page=2").then().extract().body().asString());
	*/
	
	
  }
}