package testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public Logger logger;

	@BeforeClass
	public void setup() {
		logger = LogManager.getLogger(this.getClass());
	}
}