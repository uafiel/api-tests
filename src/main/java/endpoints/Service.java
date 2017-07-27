package endpoints;

import core.Request;
import enums.ApplicationType;
import enums.ContentType;
import enums.StatusCode;
import io.restassured.response.Response;
import properties.GetUrl;

import static org.hamcrest.Matchers.lessThan;

public class Service extends Request {

    private static final long RESPONSE_TIME = 2000L;
    private String url = GetUrl.service;

    public Service(ApplicationType applicationType, ContentType contentType) {
        super(applicationType, contentType);
    }

    public Response maskForbiddenWords(String textInput, StatusCode code) {
        String path = "/json";
        Response response = getRequest(url + path, code, textInput);
        this.log.info("Response body: " + response.asString());
        checkResponseTime(response);
        return response;
    }

    public Response addWordsAndTextReplacements(String textInput, StatusCode code, String forbiddenWord, String replacement) {
        String path = "/json";
        Response response = getRequestWithAddAndFillTextParameters(url + path, code, textInput, forbiddenWord, replacement);
        this.log.info("Response body: " + response.asString());
        checkResponseTime(response);
        return response;
    }


    public Response addWordsAndCharReplacements(String textInput, StatusCode code, String forbiddenWord, String replacement) {
        String path = "/json";
        Response response = getRequestWithAddAndFillCharParameters(url + path, code, textInput, forbiddenWord, replacement);
        this.log.info("Response body: " + response.asString());
        checkResponseTime(response);
        return response;
    }

    private void checkResponseTime(Response response) {
        long millis = response.getTime();
        double seconds = millis / 1000.0;
        this.log.info("Response time was: " + seconds + " seconds");
        response.then().time(lessThan(RESPONSE_TIME));


    }
}
