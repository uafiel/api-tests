import core.ResponseBody;
import endpoints.Service;
import enums.ApplicationType;
import enums.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import enums.StatusCode;
import utils.BaseTest;
import utils.ExcelUtils;

public class ReplaceWordsTests extends BaseTest{
	private Service service = new Service(ApplicationType.JSON, ContentType.JSON);

	@Test(dataProvider = "TestData")
	public void start(String testName, String input, String expected) {
	    this.log.info("Executing " + testName + " test.");
		Response response = service.replaceWords(input, StatusCode.OK);
		ResponseBody body = new ResponseBody();
        Assert.assertEquals((body.getElement(response,"result")),expected);
	}

    @DataProvider
    public Object[][] TestData() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("src/test/resources/TestData.xlsx", "Sheet1");
        return (testObjArray);
    }

}
