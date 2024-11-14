package Tests;
import API.Verification;
import EndPoints.Artists;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import Utilities.DataProviders;
import java.util.Map;

public class TC_003_Artists extends BaseClass {

    @Test(dataProvider = "ArtistsData", dataProviderClass = DataProviders.class)
    void test_artistEndpoints(String testCaseNumber, String method,
                              String artistID, String artistIDs,
                              String include_groups, String Market,
                              String limit, String offset,
                              String expectedStatusCode, String expectedResult,
                              String tokenType) {
        logger.info(testCaseNumber + " Started");
        switch (method) {
            case "test_getSingleArtist":
                test_getSingleArtist(artistID, expectedStatusCode, expectedResult, tokenType);
                break;
            case "test_getSeveralArtists":
                test_getSeveralArtists(artistIDs, expectedStatusCode, expectedResult, tokenType);
                break;
            case "test_getArtistAlbums":
                test_getArtistAlbums(artistID, include_groups, Market, limit, offset, expectedStatusCode, expectedResult, tokenType);
                break;
            case "test_getArtistTopTracks":
                test_getArtistTopTracks(artistID, Market, expectedStatusCode, expectedResult, tokenType);
                break;
            case "test_getArtistRelatedArtists":
                test_getArtistRelatedArtists(artistID, expectedStatusCode, expectedResult, tokenType);
                break;
            default:
                Assert.fail("Invalid Method Specified: " + method);
        }
        logger.info(testCaseNumber + " Finished");
    }

    void test_getSingleArtist(String artistID,
                              String expectedStatusCode, String expectedResult,
                              String tokenType) {
        Artists artists = new Artists();
        Verification verification = new Verification();
        Response response = artists.getSingleArtist(artistID, tokenType);
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
//        System.out.println(response.getBody().asPrettyString());
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)) {
            Assert.fail(error_message);
        }
        Assert.assertTrue(true);
    }

    void test_getSeveralArtists(String artistIDs,
                                String expectedStatusCode, String expectedResult,
                                String tokenType) {
        Artists artists = new Artists();
        Verification verification = new Verification();
        Response response = artists.getSeveralArtists(artistIDs, tokenType);
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)) {
            Assert.fail(error_message);
        }
        Assert.assertTrue(true);
    }

    void test_getArtistAlbums(String artistID, String include_groups,
                              String Market, String limit, String offset,
                              String expectedStatusCode, String expectedResult,
                              String tokenType) {
        Artists artists = new Artists();
        Verification verification = new Verification();
        Response response = artists.getArtistAlbums(artistID, include_groups, Market, limit, offset, tokenType);
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)) {
            Assert.fail(error_message);
        }
        Assert.assertTrue(true);
    }

    void test_getArtistTopTracks(String artistID, String Market,
                                 String expectedStatusCode, String expectedResult,
                                 String tokenType) {
        Artists artists = new Artists();
        Verification verification = new Verification();
        Response response = artists.getArtistTopTracks(artistID, Market, tokenType);
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)) {
            Assert.fail(error_message);
        }
        Assert.assertTrue(true);
    }

    void test_getArtistRelatedArtists(String artistID,
                                      String expectedStatusCode, String expectedResult,
                                      String tokenType) {
        Artists artists = new Artists();
        Verification verification = new Verification();
        Response response = artists.getArtistRelatedArtists(artistID, tokenType);
        Map<String, Object> response_verification = verification.ResponseVerification(
                response, expectedStatusCode, expectedResult);
        String error_message = (String) response_verification.get("error_message");
        Boolean error_flag = (Boolean) response_verification.get("error_flag");
        if (error_flag.equals(false)) {
            Assert.fail(error_message);
        }
        Assert.assertTrue(true);
    }
}
