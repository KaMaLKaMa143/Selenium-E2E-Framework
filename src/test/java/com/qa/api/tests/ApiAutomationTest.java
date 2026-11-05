package com.qa.api.tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiAutomationTest 
{
	//1. automating GET request
	@Test(priority=1)
	public void testGetUserList()
	{
		RestAssured.baseURI="https://reqres.in";
		given()
		.queryParam("page","2")
		.when()
		.get("/api/users")
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.body("data[0].first_name",notNullValue())
		.log().all();
		
	
	}
	//2.Automating POST request
	@Test(priority=2)
	public void testCreateUser()
	{
		RestAssured.baseURI="https://reqres.in";
		String requestBody = "{\"name\": \"Kamal Kumar\", \"job\": \"QA Automation Engineer\"}";
		given()
		.contentType(ContentType.JSON)
		.body(requestBody)
		.when()
		.post("/api/users")
		.then()
		.statusCode(201)
		.body("name",equalTo("Kamal Kumar"))
		.body("job",equalTo("QA Automation Engineer"))
		.body("id", notNullValue())
		.log().all();
	}

}
