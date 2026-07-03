


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubAPI {

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOXeOIXmR9ZP4TU/B+A44ecpqHMQqqn+22PXnFNEuPDs";
	int id;
	@BeforeClass
	public void setUp() {
		// Create request specification
				requestSpec = new RequestSpecBuilder()
					.setBaseUri("https://api.github.com")
					// Set content type
					.addHeader ("Content-Type", "application/json")
					// Set base URL
					.addHeader("Authorization", "token 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")
					
					// Build request specification
					.build();

				responseSpec = new ResponseSpecBuilder()
					// Check status code in response
					// Check response content type
					.expectContentType("application/json")
					// Build response specification
					.build();
	}
	
	@Test(priority = 1)
    public void addSSHKey() {

        String requestBody = "{\n" +
                "  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response =
                given()
                    .spec(requestSpec)
                    .body(requestBody)
                .when()
                    .post("/user/keys")
                .then()
                    .extract()
                    .response();

       
        System.out.println(response.prettyPrint());
        id=response.body().path("id");

        // Assert status code
        Assert.assertEquals(response.getStatusCode(), 201);

       

       
    }
	
	@Test(priority = 2)
	public void getSSHKey() {
		Response response=given().spec(requestSpec)
		.pathParam("keyId", id)
		.when()
		.get("/user/keys/{keyId}");
		Reporter.log(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void deleteSSHKey() {
		Response response=given().spec(requestSpec)
		.pathParam("keyId", id)
		.when()
		.delete("/user/keys/{keyId}");
		Reporter.log(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 204);
	}
	
//	
//	@Test(priority = 1)
//	public void addSSHKey() {
//		HashMap<String,String> request=new HashMap<>();
//		request.put("title","TestAPIKey");
//		request.put("key","ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOXeOIXmR9ZP4TU/B+A44ecpqHMQqqn+22PXnFNEuPDs");
//		
//		Response response=given().spec(requestSpec).when().body(request)
//		.post("/users/keys");
//		System.out.println(response.body().prettyPrint());
//	}
	
}
