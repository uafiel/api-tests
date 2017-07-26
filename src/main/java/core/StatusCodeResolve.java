package core;

public class StatusCodeResolve {

    public static String resolveStatusCode(int statusCode) {
        String successMessage = "";
        switch (statusCode) {
            case 200:
                successMessage = "Status Code: OK";
                break;
            case 404:
                successMessage = "Status Code: Not Found!";
                break;
            case 500:
                successMessage = "Status Code: Server Error";
        }
        return successMessage;
    }

}
