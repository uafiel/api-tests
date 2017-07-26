package core;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResponseBody {

	protected Logger log = LogManager.getLogger(ResponseBody.class.getName());

	public String getElement(Response response, String element) {
		this.log.info("Getting " + element + " from response");
		String value = response.jsonPath().getString(element);
		if (value != null) {
			this.log.info("Element found:" + value);
		} else {
			this.log.info("No element found");
		}
		return value;
	}

}
