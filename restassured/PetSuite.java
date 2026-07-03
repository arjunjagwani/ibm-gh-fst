package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PetSuite {
	// Declare request specification
	RequestSpecification requestSpec;
	// Declare response specification
	ResponseSpecification responseSpec;
	
	static long id;

	@BeforeClass
	public void setUp() {
		// Create request specification
		requestSpec = new RequestSpecBuilder()
			// Set content type
			.addHeader("Content-Type", "application/json")
			// Set base URL
			.setBaseUri("https://petstore.swagger.io/v2/pet")
			// Build request specification
			.build();

		responseSpec = new ResponseSpecBuilder()
			// Check status code in response
			.expectStatusCode(200)
			// Check response content type
			.expectContentType("application/json")
			// Check if response contains name property
			.expectBody("status", equalTo("alive"))
			// Build response specification
			.build();
	}

	@DataProvider(name = "petInfo")
	public Object[][] petInfoProvider() {
		// Setting parameters to pass to test case
		Object[][] testData = new Object[][] { 
			{ 77232, "Riley", "alive" }, 
			{ 77233, "Hansel", "alive" } 
		};
		return testData;
	}
	
	@DataProvider(name="petInfo2")
	public Object[][] petWithoutId(){
		Object[][] testData=new Object[][] {
			{"pet1","alive"},
			{"pet2","alive"}
		};
		return testData;
	}

//	@Test(priority=1, dataProvider = "petInfo")
//	// Test case using a DataProvider
//	public void addPets(int petId, String petName, String petStatus) {
//		Map<String, Object> reqBody = new HashMap<>();
//		reqBody.put("id", petId);
//		reqBody.put("name", petName);
//		reqBody.put("status", petStatus);
//		
//		given().spec(requestSpec) // Use requestSpec
//			.body(reqBody) // Send request body
//		.when()
//			.post() // Send POST request
//		.then().spec(responseSpec) // Assertions using responseSpec
//		.body("name", equalTo(petName)); // Additional Assertion
//	}
	@Test(priority=1,dataProvider = "petInfo2")
	public void addPets2( String petName, String petStatus) {
		Map<String, Object> reqBody = new HashMap<>();
//		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		Response response=given().spec(requestSpec) // Use requestSpec
			.body(reqBody) // Send request body
		.when()
			.post(); // Send POST request
		id=response.body().path("id");
	}
	
//	@Test(dataProvider = "petInfo2")
//	public void updatePets2( String petName, String petStatus) {
//		Map<String, Object> reqBody = new HashMap<>();
////		reqBody.put("id", petId);
//		reqBody.put("name", petName);
//		reqBody.put("status", petStatus);
//		
//		given().spec(requestSpec) // Use requestSpec
//			.body(reqBody) // Send request body
//		.when()
//			.post() // Send POST request
//		.then().spec(responseSpec) // Assertions using responseSpec
//		.body("name", equalTo(petName)); // Additional Assertion
//	}

	// Test case using a DataProvider
	@Test( priority=2)
	public void getPets() {
		
		
		given().spec(requestSpec) // Use requestSpec
			.pathParam("petId", id) // Add path parameter
			.log().all() // Log for request details
		.when()
			.get("/{petId}") // Send GET request
		.then().spec(responseSpec); // Assertions using responseSpec
		     // Log for request details
	}

	// Test case using a DataProvider
	@Test(priority=3)
	public void deletePets() {
		given().spec(requestSpec) // Use requestSpec
			.pathParam("petId", id) // Add path parameter
		.when()
			.delete("/{petId}") // Send GET request
		.then()
			.body("code", equalTo(200))
			.body("message", equalTo(""+id)); // Assertions using responseSpec
	}
}
