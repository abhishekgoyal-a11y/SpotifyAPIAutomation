package Tests;
import EndPoints.AccessToken;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.DataProviders;

public class TC_001_GenerateAccessToken {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    void test_GenerateAccessToken(String clientId,
                                  String clientSecret,
                                  String expectedStatusCode) {
        AccessToken at = new AccessToken("https://accounts.spotify.com");
        Response response = at.generateAccessToken(clientId, clientSecret);
        System.out.println("Access Token :- "+response.getBody().asPrettyString());
    }
}
