package restFramework;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredFramework {
	
	@Test
	public void test_01() {
		Response response = given().get("https://reqres.in/api/users?page=1").then().statusCode(200)
		.and().body("data.id", hasItems(2)).extract().response();
		
		System.out.println(response.getStatusLine().toString());
		
		
	}
}
