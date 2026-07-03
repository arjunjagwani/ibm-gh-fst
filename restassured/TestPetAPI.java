package restAssured;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPetAPI {

	final static String ROOT_URI = "http://ip-api.com/json";
@Test
public void getPetDetails() {

    // Base URI
    baseURI = "https://petstore.swagger.io/v2";

    // Query parameter value
    String status = "sold";

    // Send GET request with query parameters
    Response response =
        given()
            .contentType(ContentType.JSON)
            .queryParam("status", status)
        .when()
            .get("/pet/findByStatus");

    // Print response body
    System.out.println("Response Body is => " + response.getBody().asString());

    // Assertions
    response.then()
            .statusCode(200)
            .body("[0].status", equalTo(status));
}

	
 // Set Base URL with path parameter
 	
 
 	
  
 	
 @Test
 	
 public void getIPInformation2() {
 	
	  String ROOT_URI = "http://ip-api.com/json";
     Response response = 
 	
         given().contentType(ContentType.JSON) // Set headers
 	
         .when()
 	
         .pathParam("ipAddress", "107.218.134.107") // Set path parameter
 	
         .get(ROOT_URI); // Send GET request
 	
  
 	
     // Print response
 	
     System.out.println(response.getBody().asPrettyString());
 	
 }
 
//Set Base URL
//No need to add questions mark in the URL.
//queryParam() will automatically add it while parsing.


@Test
public void getIPInformation() {
	String ROOT_URI = "http://ip-api.com/json/{ipAddress}";
  Response response = 
      given().contentType(ContentType.JSON) // Set headers
      // Add query parameter
      .when().queryParam("fields", "query,country,city,timezone")
      .pathParam("ipAddress", "107.218.134.107")
      .get(ROOT_URI); // Send GET request
  
  // Print response
  System.out.println(response.getBody().asPrettyString());
}


}