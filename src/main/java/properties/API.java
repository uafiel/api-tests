package properties;

import joptsimple.internal.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		Logger log = LogManager.getLogger(API.class.getName());
		properties = new Properties();
		try {
			File file = new File("src/test/resources/properties/api.properties");
			file.exists();
			FileInputStream in = new FileInputStream(file);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			log.info(e.getMessage());
			throw new RuntimeException("api.properties file is missing.", e);
		}
	}

	public static final String BASE_URI = properties.getProperty("protocol") + "://" + properties.getProperty("host");

	public static String getApiUrl() {
		String baseUri = System.getenv("BASE_URI");
		return !Strings.isNullOrEmpty(baseUri) ? baseUri : API.BASE_URI;
	}
}
