package com.ruegnerlukas.simpleutils;



public class SystemUtils {

	
	
	public static enum OS {
		WINDOWS,
		MAX,
		UNKNOWN
	}
	
	
	/**
	 * @return the line separator of this system. Usefull for older java versions
	 * */
	public static String lineSeparator() {
		return System.getProperty("line.separator");
	}
	
	
	
	
	/**
	 * @return the full name of the operation system
	 * */
	public static String getFullOS() {
		return System.getProperty("os.name");
	}
	
	
	
	
	/**
	 * @return the name of the operating system
	 * */
	public static OS getOS() {
		if(isWindows()) {
			return OS.WINDOWS;
			
		} else if(isMac()) {
			return OS.MAX;
			
		} else {
			return OS.UNKNOWN;
		}
	}
	
	
	
	
	/**
	 * @return true, if this application is running on a macintosh
	 * */
	public static boolean isMac() {
		String os = getFullOS().toLowerCase();
		return (os.indexOf("mac") >= 0);
	}
	
	
	
	
	/**
	 * @return true, if this application is running on a windows
	 * */
	public static boolean isWindows() {
		String os = getFullOS();
		return (os.indexOf("win") >= 0);
	}
	
	

	
	
}