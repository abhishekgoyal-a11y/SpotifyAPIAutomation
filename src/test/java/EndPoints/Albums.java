package EndPoints;
import API.API;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// Document link - https://developer.spotify.com/documentation/web-api/reference/get-an-album
public class Albums extends API {
    String get_single_album_url;
    String get_multiple_album_url;
    String get_album_track_url;
    String save_album_for_current_user;
    String get_new_releases_url;

    public Albums() {
        get_single_album_url = base_url + "/albums/ALBUM_ID";
        get_multiple_album_url = base_url + "/albums";
        get_album_track_url = base_url + "/albums/ALBUM_ID/tracks";
        save_album_for_current_user = base_url + "/me/albums";
        get_new_releases_url = base_url + "/browse/new-releases";
    }

    public Response getSingleAlbum(String albumID, String Market, String tokenType) {
        String url = get_single_album_url.replace("ALBUM_ID", albumID);
        if (Market != null && !Market.isEmpty()) {
            url += "?market=" + Market;
        }
        return getRequest(url, ContentType.JSON, tokenType);
    }

    public Response getMultipleAlbums(String albumIDs, String Market, String tokenType) {
        StringBuilder urlBuilder = new StringBuilder(get_multiple_album_url);
        if (albumIDs != null && !albumIDs.isEmpty()) {
            urlBuilder.append("?ids=").append(albumIDs);
        }
        if (Market != null && !Market.isEmpty()) {
            urlBuilder.append("&market=").append(Market);
        }
        return getRequest(urlBuilder.toString(), ContentType.JSON, tokenType);
    }

    public Response getAlbumTracks(String albumID, String Market, String limit, String offset, String tokenType) {
        String url = get_album_track_url.replace("ALBUM_ID", albumID);
        StringBuilder urlBuilder = new StringBuilder(url);
        String Symbol = "?";

        if (Market != null && !Market.isEmpty()) {
            urlBuilder.append(Symbol).append("market=").append(Market);
            Symbol = "&";
        }
        if (limit != null && !limit.isEmpty()) {
            urlBuilder.append(Symbol).append("limit=").append(limit);
            Symbol = "&";
        }
        if (offset != null && !offset.isEmpty()) {
            urlBuilder.append(Symbol).append("offset=").append(offset);
        }
        return getRequest(urlBuilder.toString(), ContentType.JSON, tokenType);
    }

    public Response saveAlbumForCurrentUser(String albumIDs, String tokenType) {
        StringBuilder urlBuilder = new StringBuilder(save_album_for_current_user);
        if (albumIDs != null && !albumIDs.isEmpty()) {
            urlBuilder.append("?ids=").append(albumIDs);
        }
        System.out.println(urlBuilder);
        return putRequest(urlBuilder.toString(), ContentType.JSON, "{}", tokenType);
    }

    public Response getNewReleases(String limit, String offset, String tokenType) {
        StringBuilder urlBuilder = new StringBuilder(get_new_releases_url);
        String Symbol = "?";

        if (limit != null && !limit.isEmpty()) {
            urlBuilder.append(Symbol).append("limit=").append(limit);
            Symbol = "&";
        }
        if (offset != null && !offset.isEmpty()) {
            urlBuilder.append(Symbol).append("offset=").append(offset);
        }
        return getRequest(urlBuilder.toString(), ContentType.JSON, tokenType);
    }
}
