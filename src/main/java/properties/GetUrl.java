package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetUrl {

	/**
	 * Reading GET URIs from get.properties file
	 *
	 * */
	private static Properties properties;

	static {
		properties = new Properties();
		try {
			File file = new File("src/test/resources/properties/uri.properties");
			file.exists();
			FileInputStream in = new FileInputStream(file);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("uri.properties file is missing.", e);
		}
	}

	/****************************************/
	/* GET URLS MAPPING */
	/****************************************/

	/**
	 * URLS KEYS
	 */
	public static String service = properties.getProperty("service");


}


