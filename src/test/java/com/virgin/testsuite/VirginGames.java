package com.virgin.testsuite;


import com.virgin.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.parsing.Parser.JSON;
import static org.hamcrest.CoreMatchers.equalTo;


public class VirginGames extends TestBase {
    static ValidatableResponse response;

    @Test
    public void getAllGames() {
//        This will convert text in json
        RestAssured.registerParser("text/plain",JSON);
         response = given()
                .when()
                .get("")
        .then().log().all().statusCode(200);



        response.body("bingoLobbyInfoResource.streams[2].streamName", equalTo("virgingamessession"));
        response.body("bingoLobbyInfoResource.streams[2].streamId", equalTo(309));

    }


}
