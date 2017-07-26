package properties;

import joptsimple.internal.Strings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class API {

	/**
	 * Reading API default properties
	 */
	private static Properties properties;

	static {
		properties = new Properties();
		try {
			File file = new File("src/test/resources/properties/api.properties");
			file.exists();
			FileInputStream in = new FileInputStream(file);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("api.properties file is missing.", e);
		}
	}

	public static String baseUri = properties.getProperty("protocol") + "://" + properties.getProperty("host");

	public static String getApiUrl() {
		String baseUri = System.getenv("baseUri");
		return !Strings.isNullOrEmpty(baseUri) ? baseUri : API.baseUri;
	}
}
