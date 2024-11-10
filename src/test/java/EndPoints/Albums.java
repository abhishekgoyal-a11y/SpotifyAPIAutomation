package EndPoints;
import API.API;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Albums extends API {
    String url;
    String get_single_album_url;

    public Albums(String url) {
        this.url = url;
        this.get_single_album_url = this.url + "albums/ALBUM_ID";
    }

    public void getSingleAlbum(String albumID, String Market, int expectedStatusCode) {
        get_single_album_url = get_single_album_url.replace("ALBUM_ID", albumID);
        if (Market != null && !Market.isEmpty()) {
            get_single_album_url = get_single_album_url + "?market=" + Market;
        }
        Response resp = getRequest(
                get_single_album_url, ContentType.JSON,
                expectedStatusCode);
    }
}
