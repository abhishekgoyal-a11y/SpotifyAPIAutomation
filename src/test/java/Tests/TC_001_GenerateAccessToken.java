package Tests;
import EndPoints.AccessToken;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;
import java.util.Map;

public class TC_001_GenerateAccessToken {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    void test_GenerateAccessToken(String clientId,
                                  String clientSecret,
                                  String expectedStatusCode,
                                  String expectedResult) {
        AccessToken at = new AccessToken("https://accounts.spotify.com");
        Response response = at.generateAccessToken(clientId, clientSecret);
        Map<String, Object> response_verification = at.ResponseVerification(response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        System.out.println("Response :- "+response.getBody().asPrettyString());
        if (error_flag.equals(false)){
            Assert.fail(error_message);
        };
        Assert.assertTrue(true);
    }
}
