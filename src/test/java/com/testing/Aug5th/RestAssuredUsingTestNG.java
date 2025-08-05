package com.testing.Aug5th;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Scanner;

public class RestAssuredUsingTestNG {

    @Test
    public void GetMethod() {

        // For Get Method, to get details based on id
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking/")
                .basePath("/" + 2)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void PostMethod(){

        // For Post Method, to create booking
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        String requestBody = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        // Send POST request
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/booking");

        // Print response
        System.out.println("Response:\n" + response.prettyPrint());
    }
}
