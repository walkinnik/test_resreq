package utilities;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Utility {

    public Response sendGetRequest(String endpoint, Map<String, String> headers) {
        return given()
                .headers(headers)
                .log().headers()
                .log().body()
                .get(endpoint)
                .then()
                .log().headers()
                .log().body()
                .extract()
                .response();
    }

    public Response sendPostRequest(String endpoint, Map<String, String> headers, Map<String, String> body){
        return given()
                .headers(headers)
                .log().headers()
                .log().body()
                .body(body)
                .post(endpoint)
                .then()
                .log().headers()
                .log().body()
                .extract()
                .response();
    }

    public Response sendPatchRequest(String endpoint, Map<String, String> headers, Map<String, String> body){
        return given()
                .headers(headers)
                .log().headers()
                .log().body()
                .body(body)
                .put(endpoint)
                .then()
                .log().headers()
                .log().body()
                .extract()
                .response();
    }

    public Response sendDeleteRequest(String endpoint, Map<String, String> headers){
        return given()
                .headers(headers)
                .log().headers()
                .log().body()
                .delete(endpoint)
                .then()
                .log().headers()
                .log().body()
                .extract()
                .response();
    }
}