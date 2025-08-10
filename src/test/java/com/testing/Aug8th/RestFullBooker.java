package com.testing.Aug8th;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RestFullBooker {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String pincode;

    @Test(priority = 3)
    public void CreateToken() {
        String payload = "{\n" + "    \"username\" : \"admin\",\n" + "    \"password\" : \"password123\"\n" + "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();


        response = requestSpecification.when().log().all().post();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }


    @Test(priority = 1)
    public void GetBookingIds() {
        pincode = "560048";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");

        response = requestSpecification.when().log().all().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }


    @Test(priority = 2)
    public void GetBooking() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking");
        requestSpecification.basePath("977");

        response = requestSpecification.when().log().all().get();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }


    @Test(priority = 4)
    public void CreateBooking(){
        String payload = "{\n" +
                "    \"firstname\" : \"PothineniVenkata \",\n" +
                "    \"lastname\" : \"Krishna\",\n" +
                "    \"totalprice\" : 516,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2025-08-10\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }


    @Test(priority = 5)
    public void UpdateBooking(){

        String payload = "{\n" +
                "    \"firstname\" : \"Pothineni\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Accept", "application/json");
        requestSpecification.cookie("token", "cdcf15876067b0f");
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking/");
        requestSpecification.basePath("977");
        requestSpecification.body(payload);

        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }


    @Test(priority = 6)
    public void PartialUpdate(){
        String payload = "{\n" +
                "    \"firstname\" : \"Pothineni\",\n" +
                "    \"lastname\" : \"Krishna\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Accept", "application/json");
        requestSpecification.cookie("token", "cdcf15876067b0f");
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking/");
        requestSpecification.basePath("977");
        requestSpecification.body(payload);

        response = requestSpecification.when().patch();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }

    @Test(priority = 7)
    public void Delete(){
        requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Accept", "application/json");
        requestSpecification.cookie("token", "cdcf15876067b0f");
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking/");
        requestSpecification.basePath("977");
    }
}
