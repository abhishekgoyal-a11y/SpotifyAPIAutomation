package EndPoints;
import API.API;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AccessToken extends API {
    String api_token_url;

    public AccessToken(String base_url){
        this.api_token_url = base_url+"/api/token";
    }

    public String generateAccessToken(int expectedStatusCode){

        String clientId = "95e38f735fed4b2086167f8b8ef82fd6";
        String clientSecret = "8081b234487e471082bf10068fbcf961";

        Response response = RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .when()
                .post(api_token_url)
                .then()
                .statusCode(expectedStatusCode)
                .extract().response();
//        System.out.println("Response: " + response.getBody().asString());
        String accessToken = response.jsonPath().getString("access_token");
//        System.out.println("Access Token: " + accessToken);
        return accessToken;
    }
}
