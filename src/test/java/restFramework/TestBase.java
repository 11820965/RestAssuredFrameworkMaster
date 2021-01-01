package restFramework;
import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	private static String baseUriLink;
	private static RestAssured restAssured;
	private static RequestSpecification request;

	public TestBase(String baseUri) {
		
		baseUriLink = baseUri;
		restAssured.baseURI = baseUriLink;
		request = restAssured.given();
		//http://dummy.restapiexample.com/api/v1
		//Here we can define the header as well as authentication
		request.header("Content-Type","application/json");
		
	}
	
	public Response getRequest() {
	
		Response response = null;
		
		request.pathParam("id", "1");
		response = request.get("/employee/{id}");
		return response;
		
		
	}
	
	public Response getRequestnegative() {
		
		request.pathParam("id", "2");
		Response response = request.get("/employee/{id}");
		return response;
		
	}
	
	public void closeConnections() {
		
		
		
		request.config(RestAssuredConfig.config().connectionConfig(ConnectionConfig.connectionConfig()
				.closeIdleConnectionsAfterEachResponse()));
	}
	
}
