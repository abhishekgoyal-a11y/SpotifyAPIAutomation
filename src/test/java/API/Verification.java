package API;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class Verification {

    public Map<String, Object> ResponseVerification(
            Response response,
            String expectedStatusCode,
            String expectedResult) {
        Map<String, Object> result = new HashMap<>();
        result.put("error_flag", true);
        String givenStatusCode = String.valueOf(response.getStatusCode());
        if (expectedStatusCode != null && !expectedStatusCode.isEmpty()) {
            if (!givenStatusCode.equals(expectedStatusCode)) {
                result.put(
                        "error_message",
                        "Status Code is Not Matching " + "Given " + givenStatusCode +
                                " Expected " + expectedStatusCode);
                result.put("error_flag", false);
                return result;
            }
        }
        if (expectedResult != null && !expectedResult.isEmpty()) {
            Map<String, Object> jsonResponse = response.jsonPath().getMap("$");
            if (jsonResponse.containsKey("error")){
                Object error = jsonResponse.get("error");
                if (error instanceof String){
                    if (!error.equals(expectedResult)) {
                        result.put(
                                "error_message",
                                "Error Message is Not Matching " + "Given " + error +
                                        " Expected " + expectedResult);
                        result.put("error_flag", false);
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
