package EndPoints;
import API.API;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Artists extends API {
    String get_single_artist_url;
    String get_multiple_artists_url;
    String get_artist_albums_url;
    String get_artist_top_tracks_url;
    String get_related_artists_url;

    public Artists() {
        get_single_artist_url = base_url + "/artists/ARTIST_ID";
        get_multiple_artists_url = base_url + "/artists";
        get_artist_albums_url = base_url + "/artists/ARTIST_ID/albums";
        get_artist_top_tracks_url = base_url + "/artists/ARTIST_ID/top-tracks";
        get_related_artists_url = base_url + "/artists/ARTIST_ID/related-artists";
    }

    public Response getSingleArtist(String artistID, String tokenType) {
        String url = get_single_artist_url.replace("ARTIST_ID", artistID);
        return getRequest(url, ContentType.JSON, tokenType);
    }

    public Response getSeveralArtists(String artistIDs, String tokenType) {
        StringBuilder urlBuilder = new StringBuilder(get_multiple_artists_url);
        if (artistIDs != null && !artistIDs.isEmpty()) {
            urlBuilder.append("?ids=").append(artistIDs);
        }
        return getRequest(urlBuilder.toString(), ContentType.JSON, tokenType);
    }

    // GET /artists/{id}/albums
    public Response getArtistAlbums(String artistID, String include_groups,
                                    String Market, String limit, String offset, String tokenType) {
        String url = get_artist_albums_url.replace("ARTIST_ID", artistID);
        StringBuilder urlBuilder = new StringBuilder(url);
        String Symbol = "?";

        if (include_groups != null && !include_groups.isEmpty()) {
            urlBuilder.append(Symbol).append("include_groups=").append(include_groups);
            Symbol = "&";
        }
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

    public Response getArtistTopTracks(String artistID, String Market, String tokenType) {
        String url = get_artist_top_tracks_url.replace("ARTIST_ID", artistID);
        StringBuilder urlBuilder = new StringBuilder(url);

        if (Market != null && !Market.isEmpty()) {
            urlBuilder.append("?market=").append(Market);
        }
        return getRequest(urlBuilder.toString(), ContentType.JSON, tokenType);
    }

    public Response getArtistRelatedArtists(String artistID, String tokenType) {
        String url = get_related_artists_url.replace("ARTIST_ID", artistID);
        return getRequest(url, ContentType.JSON, tokenType);
    }
}
