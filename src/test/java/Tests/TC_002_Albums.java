package Tests;
import API.Verification;
import EndPoints.Albums;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import Utilities.DataProviders;
import java.util.Map;

public class TC_002_Albums extends BaseClass {
    @Test(dataProvider = "AlbumsData", dataProviderClass = DataProviders.class)
    void test_albumEndpoints(String albumID, String Market,
                             String expectedStatusCode, String expectedResult,
                             String tokenType, String method){
        logger.info("TC_002_Albums Started");
        switch(method){
            case "test_getSingleAlbum":
                logger.info("test_getSingleAlbum Started");
                test_getSingleAlbum(albumID, Market, expectedStatusCode, expectedResult, tokenType);
                logger.info("test_getSingleAlbum Finished");
                break;
            default:
                Assert.fail("Invalid Method Specified: " + method);
        }
        logger.info("TC_002_Albums Finished");

    }
    void test_getSingleAlbum(String albumID, String Market,
                             String expectedStatusCode, String expectedResult,
                             String tokenType) {
        Albums al = new Albums();
        Verification verification = new Verification();
        Response response = al.getSingleAlbum(albumID, Market, tokenType);
        System.out.println(response.getBody().asPrettyString());
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)){
            Assert.fail(error_message);
        };
        Assert.assertTrue(true);
    }
}
