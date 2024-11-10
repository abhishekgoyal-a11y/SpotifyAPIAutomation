package Tests;
import EndPoints.AccessToken;
import org.testng.annotations.Test;

public class TC_001_GenerateAccessToken {
    @Test
    void test_GenerateAccessToken() {
        AccessToken at = new AccessToken("https://accounts.spotify.com");
        String accessToken = at.generateAccessToken(200);
        System.out.println("Access Token :- "+accessToken);
    }
}
