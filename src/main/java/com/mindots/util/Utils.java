package com.mindots.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class Utils {

	public static Map<String, String> getConfigFromFile(ServletContext context,String filename) throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		Map<String, String> retmap = new HashMap<String, String>();

			input = context.getResourceAsStream("WEB-INF/"+filename);
			prop.load(input);
			for (String key : prop.stringPropertyNames()) {
				retmap.put(key, prop.getProperty(key));
			}
			input.close();

		

		
		
		return retmap;

	}
}
