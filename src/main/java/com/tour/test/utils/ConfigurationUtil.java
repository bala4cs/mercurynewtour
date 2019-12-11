package com.tour.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import com.tour.logger.CustomLogger;


public class ConfigurationUtil{
	
	private static final CustomLogger LOGGER = new CustomLogger(ConfigurationUtil.class);

	
	static Properties prop = new Properties();
	static InputStream input = null;
	
	private static String PATTERN = "@-@";
	public static int PATTERN_LENGTH =PATTERN.length();
	
	/* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	private ConfigurationUtil(){ }
	
	private static ConfigurationUtil _instance = null;
	
	public static ConfigurationUtil getInstance(){
		if(_instance == null){
			_instance = new ConfigurationUtil();
		}
		return _instance;
	}
	
	public static void setFileName(String fileName){
		loadProperties(fileName, prop, input);
	}
	
	private static void loadProperties(String fileName, Properties prop,
			InputStream input) {
		// TODO Auto-generated method stub
		try {
			input = new FileInputStream(fileName);
			if (prop != null) {
				prop.load(input);
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getValue(String key) {
		
		if(getInstance().getProperty(key)!=null){
			return getInstance().getProperty(key);
		}else {
			return key;
		}
		
	}
	
	
	public static String replaceProperties(String request) {

		try {
			while (request.contains(PATTERN)) {
				int firstOcc = request.indexOf(PATTERN);
				int secondOcc = request.indexOf(PATTERN, firstOcc + 1);
				String keyPattern = request.substring(
						firstOcc + PATTERN_LENGTH, secondOcc);
				// keyPattern = RunTimeVariable.getValue(keyPattern);
				if (RunTimeVariable.getValue(keyPattern) != null) {
					request = request.replaceAll(PATTERN + keyPattern + PATTERN,RunTimeVariable.getValue(keyPattern));
				} else {
					LOGGER.error("There is no proper data in the Runtime variable - "+keyPattern);
				}
			}

			for (Object property : ConfigurationUtil.getAllPropertyNames()) {
				request = request.contains(property.toString()) ? request.replace(property.toString(),getValue(property.toString())) : request;
			}
		} catch (Exception e) {
			e.printStackTrace(); // TODO: handle exception
		}
		return request;
	}

	public String getProperty(String key) {
		return (String) prop.get(key);
	}
	
	public static Set<Object> getAllPropertyNames(){
		return prop.keySet();
	}
	
}