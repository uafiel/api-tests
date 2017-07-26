package core;

import enums.ApplicationType;
import enums.ContentType;
import enums.StatusCode;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.API;

import static io.restassured.RestAssured.given;

public class Request {

	public static final String REQUEST_PATH = API.getApiUrl();
	protected Logger log = LogManager.getLogger(Request.class.getName());
	private ApplicationType applicationType;
	private ContentType contentType;

	public Request(ApplicationType applicationType, ContentType contentType) {
		this.applicationType = applicationType;
		this.contentType = contentType;
	}


	protected Response getRequest(String url, StatusCode expectedCode, String textInput) {
		this.log.info("Executing GET request with path:" + REQUEST_PATH + url);
		this.log.info("Expecting " + StatusCodeResolve.resolveStatusCode(expectedCode.getStatusCode()));

		try {
			return given()
					.param("text", textInput)
					.header("Accept", applicationType.getApplicationType())
					.contentType(contentType.getContentType())
					.expect()
					.statusCode(expectedCode.getStatusCode())
					.log().ifError()
					.when()
					.get(REQUEST_PATH + url);

		} catch (AssertionError error) {
			this.log.error("Executing GET request with path:" + REQUEST_PATH + url);
			this.log.error("Expecting " + StatusCodeResolve.resolveStatusCode(expectedCode.getStatusCode()));
			throw new AssertionError(error.getMessage());
		}

	}


}
