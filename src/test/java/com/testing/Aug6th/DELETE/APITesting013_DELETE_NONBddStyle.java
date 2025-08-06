package com.testing.Aug6th.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting013_DELETE_NONBddStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_delete_non_bdd() {

        String bookingid = "695";
        String token = "700fb07d418c814";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        // r.header("Cookie","token="+token);
        r.cookie("token", token);


        response = r.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);


    }
}
