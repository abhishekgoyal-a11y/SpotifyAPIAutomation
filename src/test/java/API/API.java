package API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class API {

    // POST Request
    public Response postRequest(String url, ContentType contentType,
                                String payload, int expectedStatusCode) {
        String token = "";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .body(payload)
                .when()
                .post(url)
                .then()
                .statusCode(expectedStatusCode)
                .extract().response();

//        System.out.println("POST Request Response: " + response.asPrettyString());
        return response;
    }

    // GET Request
    public Response getRequest(String url, ContentType contentType,
                               int expectedStatusCode) {
        String token = "";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .when()
                .get(url)
                .then()
                .statusCode(expectedStatusCode)
                .extract().response();

//        System.out.println("GET Request Response: " + response.asPrettyString());
        return response;
    }

    // PUT Request
    public Response putRequest(String url, ContentType contentType,
                               String payload, int expectedStatusCode) {
        String token = "";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .body(payload)
                .when()
                .put(url)
                .then()
                .statusCode(expectedStatusCode)
                .extract().response();

//        System.out.println("PUT Request Response: " + response.asPrettyString());
        return response;
    }

    // PATCH Request
    public Response patchRequest(String url, ContentType contentType,
                                 String payload, int expectedStatusCode) {
        String token = "";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .body(payload)
                .when()
                .patch(url)
                .then()
                .statusCode(expectedStatusCode)
                .extract().response();

//        System.out.println("PATCH Request Response: " + response.asPrettyString());
        return response;
    }

    // DELETE Request
    public Response deleteRequest(String url, ContentType contentType, int expectedStatusCode) {
        String token = "";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .when()
                .delete(url)
                .then()
                .statusCode(expectedStatusCode)
                .extract().response();

//        System.out.println("DELETE Request Response: " + response.asPrettyString());
        return response;
    }


    public Map<String, Object> ResponseVerification(
            Response response,
            String expectedStatusCode,
            String expectedResult) {
        Map<String, Object> result = new HashMap<>();
        result.put("error_flag", true);
        String givenStatusCode = String.valueOf(response.getStatusCode());
        if (expectedStatusCode != null && !expectedStatusCode.isEmpty()) {
            if (!givenStatusCode.equals(expectedStatusCode)) {
                result.put(
                        "error_message",
                        "Status Code is Not Matching " + "Given " + givenStatusCode +
                                " Expected " + expectedStatusCode);
                result.put("error_flag", false);
                return result;
            }
        }
        if (expectedResult != null && !expectedResult.isEmpty()) {
            Map<String, Object> jsonResponse = response.jsonPath().getMap("$");
            if (jsonResponse.containsKey("error")){
                Object error = jsonResponse.get("error");
                if (error instanceof String){
                    if (!error.equals(expectedResult)) {
                        result.put(
                                "error_message",
                                "Error Message is Not Matching " + "Given " + error +
                                        " Expected " + expectedResult);
                        result.put("error_flag", false);
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
