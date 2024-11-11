package EndPoints;
import API.API;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Albums extends API {
    String get_single_album_url;

    public Albums() {
        this.get_single_album_url = base_url + "/albums/ALBUM_ID";
    }

    public Response getSingleAlbum(String albumID, String Market, String tokenType) {
        get_single_album_url = get_single_album_url.replace("ALBUM_ID", albumID);
        if (Market != null && !Market.isEmpty()) {
            get_single_album_url = get_single_album_url + "?market=" + Market;
        }
        return getRequest(get_single_album_url, ContentType.JSON, tokenType);
    }
}
