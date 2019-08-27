package com.clc.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties properties = new Properties();

	public ReadConfig() {

		File src = new File("./Configuration\\config.properties");

		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("baseurl");
		return url;
	}
	
	public String getUsername() {
		String uname= properties.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pwd= properties.getProperty("password");
		return pwd;
	}
	
	public String getChromepath() {
		String path = properties.getProperty("chromepath");
		return path;
	}
	
	public String getFirefoxpath() {
		String path1 = properties.getProperty("firefoxpath");
		return path1;
	}
	
	public String getIepath() {
		String path2 = properties.getProperty("iepath");
		return path2;
	}

}
