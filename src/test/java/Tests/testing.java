package Tests;

import EndPoints.Albums;
import org.testng.annotations.Test;

public class testing {
    @Test
    void test_getSingleAlbum(String albumID, String Market, int expectedStatusCode) {
        Albums al = new Albums("https://api.spotify.com/v1/");
        al.getSingleAlbum(albumID, Market, expectedStatusCode);
    }
}
