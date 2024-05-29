package api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.core.appender.routing.Routes;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONObject;

import api.utils.Excel;
import api.utils.Excelutils;
import api.utils.IdHolder;
import api.utils.RestUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class User_steps extends RestUtils{
	public static String excelFilePath = "./src/test/resources/Api_data.xlsx";
	public static String username="Numpy@gmail.com";
	public static String password="api@123";
	RequestSpecification request;
	ResponseSpecification responseSpec;
	Response response;
	@Given("Admin creates POST request with all fields for {string}")
	public void admin_creates_post_request_with_all_fields_for(String testcase) throws IOException {
		String jsonString = Excelutils.excelDataToJsonString(excelFilePath, testcase);
	    request=given()
				.auth().basic(username,password)
				.baseUri(routes.getString("base_url"))
				.contentType("application/json")
				//.spec(requestSpecification())
				.body(jsonString);
   }
	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {
		response = request
	            .when()
	            .post(routes.getString("Post_Userurl"))
	            .then().log().all().extract().response();
	    System.out.println(response);
	 	    if (response.getStatusCode() == 201){
	    	IdHolder.userId = UserKeyJson(response,"user_id");
	    	System.out.println("******UserId Stored" + IdHolder.userId);
	    }
				
		
	}

	@Then("Admin receives {int} Created Status with response body")
	public void admin_receives_created_status_with_response_body(Integer int1) {
		assertEquals(response.getStatusCode(),201);
		assertEquals(response.header("Content-Type"),"application/json");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema/Userpost.json"));
	}

	@Given("Admin creates GET Request")
	public void admin_creates_get_request() {
		request=given()
				.auth().basic(username,password)
				.baseUri(routes.getString("base_url"))
				.contentType("application/json");
				//.spec(requestSpecification())
				//.body(jsonString);
	}

	@When("Admin sends HTTPS Request with valid endpoint")
	public void admin_sends_https_request_with_valid_endpoint() {
		response = request
	            .when()
	            .get(routes.getString("Get_Alluser"))
	            .then().log().all().extract().response();
	    System.out.println(response);
	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		assertEquals(200,response.getStatusCode());
		assertEquals(response.header("Content-Type"),"application/json");
	}

	@Given("Admin creates GET Request with valid UserId")
	public void admin_creates_get_request_with_valid_user_id() throws FileNotFoundException {
		request=given()
		.auth().basic(username,password)
		.baseUri(routes.getString("base_url"))
		.contentType("application/json")
		//.spec(requestSpecification())
		.pathParam("userId", IdHolder.userId);
	}

	@When("Admin sends HTTPS Request with a valid endpoint")
	public void admin_sends_https_request_with_a_valid_endpoint() {
		response = request
	            .when()
	            .get(routes.getString("Get_UserbyUserId"))
	            .then().log().all().extract().response();
	    System.out.println(response);
	}

	@Given("Admin creates PUT Request with valid UserId for {string}")
	public void admin_creates_put_request_with_valid_user_id_for(String testcase) throws IOException {
		String jsonString = Excelutils.excelDataToJsonString(excelFilePath, testcase);
	    request=given()
	    		.auth().basic(username,password)
				.baseUri(routes.getString("base_url"))
				.contentType("application/json")
				//.spec(requestSpecification())
				.pathParam("userId", IdHolder.userId)
				.body(jsonString);
	
	}

	@When("Admin sends PUT Request with a valid endpoint")
	public void admin_sends_put_request_with_a_valid_endpoint() {
		response = request
	            .when()
	            .put(routes.getString("update_UpdateUser"))
	            .then().log().all().extract().response();
	    System.out.println(response);
	    }
	@Given("Admin creates Delete Request with valid UserId")
	public void admin_creates_delete_request_with_valid_user_id() {
		request=given()
				.auth().basic(username,password)
				.baseUri(routes.getString("base_url"))
				.contentType("application/json")
				//.spec(requestSpecification())
				.pathParam("userId", IdHolder.userId);
	}

	@When("Admin sends DELETE Request with a valid endpoint")
	public void admin_sends_delete_request_with_a_valid_endpoint() {
		response = request
	            .when()
	            .delete(routes.getString("delete_DeleteUser"))
	            .then().log().all().extract().response();
	    System.out.println(response);
	    }
	@Given("Admin creates POST request for {string}")
	public void admin_creates_post_request_for(String testcase) throws IOException {
		String jsonString = Excelutils.excelDataToJsonString(excelFilePath, testcase);
	    request=given()
	    		.auth().basic(username,password)
				.baseUri(routes.getString("base_url"))
				.contentType("application/json")
				//.spec(requestSpecification())
				.body(jsonString);
	}

	@Then("Admin receives {int} Bad Request with response body")
	public void admin_receives_bad_request_with_response_body(Integer status) {
		assertEquals(400,response.getStatusCode());
		assertEquals(response.header("Content-Type"),"application/json");
    	
	}
	@Then("Admin receives {int} Conflict with response body")
	public void admin_receives_conflict_with_response_body(Integer int1) {
		assertEquals(409,response.getStatusCode());
		assertEquals(response.header("Content-Type"),"application/json");
	}


	}
