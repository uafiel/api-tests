package utils;

import org.joda.time.DateTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;

public class BaseTest {

	protected Logger log = LogManager.getLogger(BaseTest.class.getName());

	@AfterSuite
	public void tearDown() {
		this.log.info("Tests finished at: " + DateTime.now().toLocalTime().toString());

	}
}
