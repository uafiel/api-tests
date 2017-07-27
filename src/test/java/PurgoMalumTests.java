import core.ResponseBody;
import endpoints.Service;
import enums.ApplicationType;
import enums.ContentType;
import enums.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ExcelUtils;

public class PurgoMalumTests extends BaseTest {
    private Service service = new Service(ApplicationType.JSON, ContentType.JSON);

    @DataProvider
    public Object[][] TestData() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("src/test/resources/tdShouldBeMasked.xlsx", "Sheet1");
        return (testObjArray);
    }

    @Test(dataProvider = "TestData")
    public void wordsFromProfanityListShouldBeMasked(String testName, String input, String expected) {
        this.log.info("Executing " + testName + " test.");
        this.log.info("Text input: " + input + " expected output: " + expected);
        Response response = service.maskForbiddenWords(input, StatusCode.OK);
        ResponseBody body = new ResponseBody();
        Assert.assertEquals((body.getElement(response, "result")), expected);
    }

    @DataProvider
    public Object[][] TestDataB() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("src/test/resources/tdAddWordsWithReplacementsText.xlsx", "Sheet1");
        return (testObjArray);
    }

    @Test(dataProvider = "TestDataB")
    public void addWordToProfanityListAndReplacementForIt(String testName, String input, String forbiddenWords, String replacement, String expected) {
        this.log.info("Executing " + testName + " test.");
        this.log.info("Text input: " + input + " expected output: " + expected);
        Response response = service.addWordsAndTextReplacements(input, StatusCode.OK, forbiddenWords, replacement);
        ResponseBody body = new ResponseBody();
        Assert.assertEquals((body.getElement(response, "result")), expected);
    }

    @DataProvider
    public Object[][] TestDataC() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("src/test/resources/tdInvalidTextReplacement.xlsx", "Sheet1");
        return (testObjArray);
    }

    @Test(dataProvider = "TestDataC")
    public void attemptToUseInvalidReplacement(String testName, String input, String forbiddenWords, String replacement, String expected) {
        this.log.info("Executing " + testName + " test.");
        this.log.info("Text input: " + input + " expected output: " + expected);
        Response response = service.addWordsAndTextReplacements(input, StatusCode.OK, forbiddenWords, replacement);
        ResponseBody body = new ResponseBody();
        Assert.assertEquals((body.getElement(response, "error")), expected);
    }

    @DataProvider
    public Object[][] TestDataD() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("src/test/resources/tdAddWordsWithReplacementsChar.xlsx", "Sheet1");
        return (testObjArray);
    }

    @Test(dataProvider = "TestDataD")
    public void addWordToProfanityListAndCharReplacementForIt(String testName, String input, String forbiddenWords, String replacement, String expected) {
        this.log.info("Executing " + testName + " test.");
        this.log.info("Text input: " + input + " expected output: " + expected);
        Response response = service.addWordsAndCharReplacements(input, StatusCode.OK, forbiddenWords, replacement);
        ResponseBody body = new ResponseBody();
        Assert.assertEquals((body.getElement(response, "result")), expected);
    }


}
