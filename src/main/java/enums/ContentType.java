package enums;

public enum ContentType {
    JSON("application/json"),
    XML("application/xml");

    private String type;

    /**
     * Getter for content type
     * @return content type value as string
     */
    public String getContentType() {
        return type;
    }

    public static String JsonType = "application/json;charset=UTF-8";
    public static String XmlType = "application/xml; charset=UTF-8";

    private ContentType(String type) {
        this.type = type;
    }
}