package TestBase;
import API.TokenStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public Logger logger;

    @BeforeClass
    public void setup() {
        logger = LogManager.getLogger(this.getClass());
        TokenStore.tokens_dict.put("EMPTY_TOKEN", "");
        TokenStore.tokens_dict.put("INVALID_TOKEN", "invalid");
        TokenStore.tokens_dict.put("EXPIRED_TOKEN", "BQCTKBo4yx_KzccnmmMNc6HEwIi0k2ltAgexsUbUE9B1_hatAaDH_3OmPjg8DT6DjpIsc1wgSoKTXO7A9MhQw5YJlH6nOOAaCsSAaF-5yLPNRhypjIk");

    }
}