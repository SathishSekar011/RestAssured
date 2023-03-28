package org.reqres;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;


public class RestApi {	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.queryParam("page", 2);
		Response request = httpRequest.request(Method.GET, "/api/users");
		
		int statusCode = request.getStatusCode();
		Assert.assertEquals(200, statusCode);
		System.out.println("Response Code Checked ");
		
		String asPrettyString = request.getBody().asPrettyString();
		System.out.println(asPrettyString);
		
	}
}
