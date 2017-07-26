package endpoints;

import core.Request;
import enums.ApplicationType;
import enums.ContentType;
import io.restassured.response.Response;
import properties.GetUrl;
import enums.StatusCode;

public class Service extends Request {

	private String url = GetUrl.service;

	public Service(ApplicationType applicationType, ContentType contentType) {
		super(applicationType, contentType);
	}

	public Response replaceWords(String textInput, StatusCode code){
		String path = "/json";
		Response response = getRequest(url + path, code, textInput);
		this.log.info("Headers: " + response.getHeaders());
		this.log.info ("Body: " + response.asString());
		return response;
	}

}
