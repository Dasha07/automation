package com.rocketmiles.test.common.utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author dasha_daniyalian
 */

public class AppProperties {

	Properties props = null;
	FileInputStream fis = null;
	public AppProperties() {
		File file = new File("application.properties");
		try {
			fis = new FileInputStream(file);
			props = new Properties();
			props.load(fis);
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		String value  = props.getProperty(key,"");
		return value;
	}
}
