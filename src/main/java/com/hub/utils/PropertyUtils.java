package com.hub.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.hub.constants.FrameworkConstants;
import com.hub.enums.ConfigProperties;
/**
 * <P>Class holding the method which will read the property file to fetch the data</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public final class PropertyUtils {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private PropertyUtils() {

	}

	private static Properties property = new Properties();

	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(file);
		}catch(FileNotFoundException e) {

		}catch(IOException e) {

		}
	}


	public static String getValue(ConfigProperties key) throws Exception {

		if(Objects.isNull(key) || Objects.isNull(property.getProperty(key.name().toLowerCase()))) {
			throw new Exception("Property name" + key +" is not found. Please check config.properties");
		}
		return property.getProperty(key.name().toLowerCase());

	}
}
