package EndPoints;
import API.API;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// Document link - https://developer.spotify.com/documentation/web-api/reference/get-an-album
public class Albums extends API {
    String get_single_album_url;
    String get_multiple_album_url;

    public Albums() {
        get_single_album_url = base_url + "/albums/ALBUM_ID";
        get_multiple_album_url = base_url + "/albums";
    }

    public Response getSingleAlbum(String albumID, String Market, String tokenType) {
        get_single_album_url = get_single_album_url.replace("ALBUM_ID", albumID);
        if (Market != null && !Market.isEmpty()) {
            get_single_album_url = get_single_album_url + "?market=" + Market;
        }
        return getRequest(get_single_album_url, ContentType.JSON, tokenType);
    }

    public Response getMultipleAlbums(String albumIDs, String Market, String tokenType) {
        if (!albumIDs.isEmpty()) {
            get_multiple_album_url = get_multiple_album_url + "?ids=" + albumIDs;
        }
        if (Market != null && !Market.isEmpty()) {
            get_multiple_album_url = get_multiple_album_url + "&market=" + Market;
        }
        return getRequest(get_multiple_album_url, ContentType.JSON, tokenType);
    }
}
