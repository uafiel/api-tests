import core.ResponseBody;
import endpoints.Service;
import enums.ApplicationType;
import enums.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import enums.StatusCode;
import utils.BaseTest;

public class ReplaceWordsTests extends BaseTest{
	private Service service = new Service(ApplicationType.JSON, ContentType.JSON);

	@Test
	public void start() {
		Response response = service.replaceWords("fu_ckyoufuck", StatusCode.OK);
		ResponseBody body = new ResponseBody();
	}


}
