package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddNewPet {

	
	// Set Base URL
	String ROOT_URI = "https://petstore.swagger.io/v2/pet";

	@Test
	public void addPet() {
	    // Write the request body
		File file = new File("src/test/resources/input.json");
		String reqBody = "{\"id\": 77244, \"name\": \"Riley\", \"status\": \"dead\"}";
		baseURI = "https://petstore.swagger.io/v2";
		Response response2 =
	            given()
	                .contentType(ContentType.JSON)
	                .queryParam("status", "dead")
	            .when()
	                .get("/pet/findByStatus");
	    
//	    Response response2=given().contentType(ContentType.JSON).when().get(ROOT_URI);
	    Response response =given().contentType(ContentType.JSON) // Set headers
	        .body(file).when().post(ROOT_URI); // Send POST request

	    // Print response of POST request
	    String body = response.getBody().asPrettyString();
	    System.out.println(body);
//	    response.then().body("status", equalTo("dead"));
	}
}
