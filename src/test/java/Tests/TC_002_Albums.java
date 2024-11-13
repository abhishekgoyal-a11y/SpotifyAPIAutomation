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
    void test_albumEndpoints(String testCaseNumber, String method,
                             String albumID, String albumIDs,
                             String Market,
                             String limit, String offset,
                             String expectedStatusCode, String expectedResult,
                             String tokenType) {
        logger.info(testCaseNumber + " Started");
        switch (method) {
            case "test_getSingleAlbum":
                test_getSingleAlbum(albumID, Market, expectedStatusCode, expectedResult, tokenType);
                break;
            case "test_getMultipleAlbums":
                test_getMultipleAlbums(albumIDs, Market, expectedStatusCode, expectedResult, tokenType);
                break;
            case "test_getAlbumTracks":
                test_getAlbumTracks(albumID, Market, limit, offset, expectedStatusCode, expectedResult, tokenType);
                break;
            case "test_saveAlbumForCurrentUser":
                test_saveAlbumForCurrentUser(albumIDs, expectedStatusCode, expectedResult, tokenType);
                break;
            default:
                Assert.fail("Invalid Method Specified: " + method);
        }
        logger.info(testCaseNumber + " Finished");

    }

    void test_getSingleAlbum(String albumID, String Market,
                             String expectedStatusCode, String expectedResult,
                             String tokenType) {
        Albums al = new Albums();
        Verification verification = new Verification();
        Response response = al.getSingleAlbum(albumID, Market, tokenType);
//        System.out.println(response.getBody().asPrettyString());
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)) {
            Assert.fail(error_message);
        };
        Assert.assertTrue(true);
    }

    void test_getMultipleAlbums(String albumIDs, String Market,
                                String expectedStatusCode, String expectedResult,
                                String tokenType) {
        Albums al = new Albums();
        Verification verification = new Verification();
        Response response = al.getMultipleAlbums(albumIDs, Market, tokenType);
//        System.out.println(response.getBody().asPrettyString());
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)) {
            Assert.fail(error_message);
        };
        Assert.assertTrue(true);
    }

    void test_getAlbumTracks(String albumID, String Market, String limit, String offset,
                             String expectedStatusCode, String expectedResult,
                             String tokenType) {
        Albums al = new Albums();
        Verification verification = new Verification();
        Response response = al.getAlbumTracks(albumID, Market, limit, offset, tokenType);
//        System.out.println(response.getBody().asPrettyString());
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)) {
            Assert.fail(error_message);
        };
        Assert.assertTrue(true);
    }

    void test_saveAlbumForCurrentUser(String albumIDs,
                                      String expectedStatusCode, String expectedResult,
                                      String tokenType) {
        Albums al = new Albums();
        Verification verification = new Verification();
        Response response = al.saveAlbumForCurrentUser(albumIDs, tokenType);
        System.out.println(response.getBody().asPrettyString());
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)) {
            Assert.fail(error_message);
        };
        Assert.assertTrue(true);
    }
}
