package com.testing.Aug6th.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting008_GET_BDDStyle {


    @Test
    public void test_GET_Request(){
        String pincode = "560048";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)



                .when()
                .log()
                .all()
                .get()



                .then()
                .log().all()
                .statusCode(200);
    }


}
