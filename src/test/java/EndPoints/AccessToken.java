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

    public Response generateAccessToken(String clientId,
                                      String clientSecret){
        Response response = RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .when()
                .post(api_token_url)
                .then()
                .extract().response();
        return response;
    }
}
