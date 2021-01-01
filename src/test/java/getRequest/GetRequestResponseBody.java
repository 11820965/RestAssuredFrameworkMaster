package getRequest;

import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.path.json.JsonPath.*;

import java.util.Iterator;
import java.util.List;
 

public class GetRequestResponseBody {

	@Test
	public void getRequest() {
		
		RestAssured.baseURI="https://samples.openweathermap.org/data/2.5";
		Response response = RestAssured.given().queryParam("q", "London,uk").queryParam("appid", "439d4b804bc8187953eb36d2a8c26a02").when().get("/weather");
		
		
		
		
		System.out.println(response.getBody().toString());
		
		System.out.println(response.jsonPath().getMap("$"));
		String main = response.jsonPath().getString("weather.main");
		System.out.println(main);
		
		List<JSONObject> jsonarray = response.jsonPath().getList("weather");
		
		System.out.println(jsonarray.size());
		
		
	} 
}
