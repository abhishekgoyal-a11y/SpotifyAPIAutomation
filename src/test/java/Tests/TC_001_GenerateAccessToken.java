package Tests;
import API.TokenStore;
import API.Verification;
import EndPoints.AccessToken;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;
import utilities.DataProviders;
import java.util.Map;

public class TC_001_GenerateAccessToken extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    void test_GenerateAccessToken(String clientId,
                                  String clientSecret,
                                  String expectedStatusCode,
                                  String expectedResult) {
        logger.info("TC_001_GenerateAccessToken Started");
        AccessToken at = new AccessToken();
        Verification verification = new Verification();
        Response response = at.generateAccessToken(clientId, clientSecret);
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
//        System.out.println("Response :- " + response.getBody().asPrettyString());
        if (error_flag.equals(false)){
            Assert.fail(error_message);
        };
        String access_token = response.jsonPath().get("access_token");
        if (access_token!=null && !access_token.isEmpty()){
            TokenStore.tokens_dict.put("ACCESS_TOKEN", access_token);
            System.out.println("ACCESS_TOKEN is generated:- " + access_token);
        }
        Assert.assertTrue(true);
        logger.info("TC_001_GenerateAccessToken Finished");
    }
}
