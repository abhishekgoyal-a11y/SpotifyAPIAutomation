package EndPoints;
import API.API;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AccessToken extends API {
    public Response generateAccessToken(String clientId,
                                      String clientSecret){
        return RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .when()
                .post("https://accounts.spotify.com/api/token")
                .then()
                .extract().response();
    }
}
