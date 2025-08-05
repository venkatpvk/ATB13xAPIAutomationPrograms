package com.testing.Aug5th;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Scanner;

public class RestAssuredUsingMain {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the id: ");
//        String id = scanner.next();
//
//        // For Get Method, to get details based on id
//        RestAssured.given()
//                .baseUri("https://restful-booker.herokuapp.com/booking/")
//                .basePath("/" + id)
//                .when().log().all().get()
//                .then().log().all().statusCode(200);



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
