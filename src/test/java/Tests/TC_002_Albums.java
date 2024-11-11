package Tests;
import EndPoints.Albums;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.DataProviders;

public class TC_002_Albums {
    @Test(dataProvider = "AlbumsData", dataProviderClass = DataProviders.class)
    void test_getSingleAlbum(String albumID, String Market, String tokenType) {
        Albums al = new Albums("https://api.spotify.com/v1");
        Response response = al.getSingleAlbum(albumID, Market, tokenType);
        System.out.println(response.getBody().asPrettyString());
    }
}
