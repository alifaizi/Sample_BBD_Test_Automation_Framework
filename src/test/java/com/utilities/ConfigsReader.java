package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//Created by Ali Faizi for demonstration and learning purposes only. 
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	
	private static Properties property;
	
	/**
	 * This method will read the properties file
	 */
	
	public static void readProperties(String filePath) {
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			property = new Properties();
			property.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return the value for a specific key
	 */
	public static String getProperty(String key) {
		return property.getProperty(key);
	}

}
