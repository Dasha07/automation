package com.rocketmiles.test.steps;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class FaceBookAPISteps {

	
	@When("get user details with {string} token")
	public void get_facebook_token(String bearerToken) {
		System.out.println("get facebook token");
		Response response = given()
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + bearerToken)
		.get("https://graph.facebook.com/me");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
	}
	
	
	@And("get number of photos with {string} token")
	public void get_number_of_photos(String bearerToken) {
		System.out.println("get number of photos");
		Response response = given()
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + bearerToken)
		.get("https://graph.facebook.com/me/photos");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}
	
	@And("get number of posts with {string} token")
	public void get_number_of_posts(String bearerToken) {
		System.out.println("get number of photos");
		Response response = given()
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + bearerToken)
		.get("https://graph.facebook.com/me/posts");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}
}
