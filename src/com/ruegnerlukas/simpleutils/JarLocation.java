package com.ruegnerlukas.simpleutils;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.ruegnerlukas.simpleutils.logging.logger.Logger;

public class JarLocation {


	private static boolean enableRedir = false;
	private static Map<String,String> locMap = new HashMap<String,String>();
	
	
	
	private JarLocation() {
	}


	
	

	public static void enableRedirecting(boolean enable) {
		JarLocation.enableRedir = enable;
	}
	
	
	
	
	public static void redirect(String src, String target) {
		if(target == null) {
			locMap.remove(src);
		} else {
			locMap.put(src, target);
		}
	}
	


	
	public static String getJarFile() {
		return getJarFile(JarLocation.class);
	}
	
	
	
	public static String getJarFile(Class<?> c) {
		return new File(c.getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath();
	}
	
	
	
	
	public static String getJarLocation() {
		String res = "";

		File file = getWorkingDir(JarLocation.class);
		if(file == null) {
			res = System.getProperty("user.dir");
		} else {
			if(file.getPath().endsWith(".jar")) {
				res = file.getParentFile().getPath();
			} else {
				res = file.getPath();
			}
		}
		
		if(enableRedir) {
			if(locMap.containsKey(res)) {
				res = locMap.get(res);
			}
		}
		
		return res;
	}

	
	
	
	public static String getJarLocation(Class<?> c) {
		
		String res = "";
		
		File file = getWorkingDir(c);
		if(file == null) {
			res = System.getProperty("user.dir");
		} else {
			if(file.getPath().endsWith(".jar")) {
				res = file.getParentFile().getPath();
			} else {
				res = file.getPath();
			}
		}
		
		if(enableRedir) {
			if(locMap.containsKey(res)) {
				res = locMap.get(res);
			}
		}
		
		return res;
	}
	
	
	
	
	private static File getWorkingDir(Class<?> c) {
		try {
			return new File(c.getProtectionDomain().getCodeSource().getLocation().toURI());
		} catch (URISyntaxException e) {
			Logger.get().warn("Problem determining working directory.");
		}
		return null;
	}
	
}