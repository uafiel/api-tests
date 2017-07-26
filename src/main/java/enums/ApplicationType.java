package enums;

public enum ApplicationType {
	JSON("application/json"),
	XML("application/xml");

	private String type;

	public String getApplicationType() {
		return type;
	}

	ApplicationType(String type) {
		this.type = type;
	}
}