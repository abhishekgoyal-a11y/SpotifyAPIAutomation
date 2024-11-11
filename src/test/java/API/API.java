package API;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class API {

    // POST Request
    public Response postRequest(String url, ContentType contentType,
                                String payload, String tokenType) {
        Map<String, String> headers = new HashMap<>();
        if (tokenType==null || tokenType.isEmpty()){
            tokenType = "ACCESS_TOKEN";
        }
        headers.put("Authorization", "Bearer " + TokenStore.tokens_dict.get(tokenType));
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .body(payload)
                .when()
                .post(url)
                .then()
                .extract().response();

//        System.out.println("POST Request Response: " + response.asPrettyString());
        return response;
    }

    // GET Request
    public Response getRequest(String url, ContentType contentType, String tokenType) {
        Map<String, String> headers = new HashMap<>();
        if (tokenType==null || tokenType.isEmpty()){
            tokenType = "ACCESS_TOKEN";
        }
        headers.put("Authorization", "Bearer " + TokenStore.tokens_dict.get(tokenType));
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .when()
                .get(url)
                .then()
                .extract().response();

//        System.out.println("GET Request Response: " + response.asPrettyString());
        return response;
    }

    // PUT Request
    public Response putRequest(String url, ContentType contentType,
                               String payload, String tokenType) {
        Map<String, String> headers = new HashMap<>();
        if (tokenType==null || tokenType.isEmpty()){
            tokenType = "ACCESS_TOKEN";
        }
        headers.put("Authorization", "Bearer " + TokenStore.tokens_dict.get(tokenType));
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .body(payload)
                .when()
                .put(url)
                .then()
                .extract().response();

//        System.out.println("PUT Request Response: " + response.asPrettyString());
        return response;
    }

    // PATCH Request
    public Response patchRequest(String url, ContentType contentType,
                                 String payload, String tokenType) {
        Map<String, String> headers = new HashMap<>();
        if (tokenType==null || tokenType.isEmpty()){
            tokenType = "ACCESS_TOKEN";
        }
        headers.put("Authorization", "Bearer " + TokenStore.tokens_dict.get(tokenType));
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .body(payload)
                .when()
                .patch(url)
                .then()
                .extract().response();

//        System.out.println("PATCH Request Response: " + response.asPrettyString());
        return response;
    }

    // DELETE Request
    public Response deleteRequest(String url, ContentType contentType, String tokenType) {
        Map<String, String> headers = new HashMap<>();
        if (tokenType==null || tokenType.isEmpty()){
            tokenType = "ACCESS_TOKEN";
        }
        headers.put("Authorization", "Bearer " + TokenStore.tokens_dict.get(tokenType));
        Response response = given()
                .contentType(contentType)
                .headers(headers)
                .when()
                .delete(url)
                .then()
                .extract().response();

//        System.out.println("DELETE Request Response: " + response.asPrettyString());
        return response;
    }

}
