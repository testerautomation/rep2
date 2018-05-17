package com.testcases;

import org.testng.annotations.Test;

import com.reusable.conversions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class jiraapi extends TestBase{

	
	
	
	@Test
	public void create_issue()

	{
		
		Response res=given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+get_session_id()).
				body(bodymethod.create_bug()).
				when().post(Config.getProperty("bug")).then().statusCode(201).extract().response();
		JsonPath js=conversions.rawToJson(res);
		System.out.println("The ID which is crearted is "+js.get("id"));
		
		
		given().header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+get_session_id()).
		body(bodymethod.add_comment()).post( Config.getProperty("new_comment")+js.get("id")+"/comment");
	}
}
