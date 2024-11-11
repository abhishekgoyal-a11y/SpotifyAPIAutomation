package EndPoints;
import API.API;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Albums extends API {
    String base_url;
    String get_single_album_url;

    public Albums(String base_url) {
        this.base_url = base_url;
        this.get_single_album_url = this.base_url + "albums/ALBUM_ID";
    }

    public Response getSingleAlbum(String albumID, String Market) {
        get_single_album_url = get_single_album_url.replace("ALBUM_ID", albumID);
        if (Market != null && !Market.isEmpty()) {
            get_single_album_url = get_single_album_url + "?market=" + Market;
        }
        Response response = getRequest(get_single_album_url, ContentType.JSON);
        return response;
    }
}
