package com.ruegnerlukas.simpleutils;



public class SystemUtils {

	
	public static String getJavaRuntimeName() {
		return System.getProperty("java.runtime.name");
	}
	
	
	
	
	public static String getJavaRuntimeVersion() {
		return System.getProperty("java.runtime.version");
	}
	
	
	
	
	public static String getJavaVersion() {
		return System.getProperty("java.version");
	}
	
	
	
	
	public static String getJavaHome() {
		return System.getProperty("java.home");
	}
	
	
	
	
	public static String getCountry() {
		return System.getProperty("user.country");
	}
	
	
	
	
	public static String getLanguage() {
		return System.getProperty("user.language");
	}
	
	
	
	
	public static String getOSName() {
		return System.getProperty("os.name");
	}

	
	
}