package com.ruegnerlukas.simpleutils.logging.filter;

import java.util.ArrayList;
import java.util.List;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public class FilterSource {

	protected final static int TYPE_ONLY = 0;
	protected final static int TYPE_NOT = 1;

	
	
	/**
	 * @param packages a list of packages. A package name can be a simple name of a specific package or a (partial) path to a package
	 * */
	public static FilterSourcePackage packagesOnly(String... packages) {
		return new FilterSourcePackage(TYPE_ONLY, packages);
	}
	
	
	/**
	 * @param packages a list of packages. A package name can be a simple name of a specific package or a (partial) path to a package
	 * */
	public static FilterSourcePackage packagesNot(String... packages) {
		return new FilterSourcePackage(TYPE_NOT, packages);
	}
	
	
	
	
	/**
	 * @param classes a list of classes. A class name can be a simple name of a specific class or a name with a (partial) path
	 * */
	public static FilterSourceClass classesOnly(String... classes) {
		return new FilterSourceClass(TYPE_ONLY, classes);
	}
	
	
	/**
	 * @param classes a list of classes. A class name can be a simple name of a specific class or a name with a (partial) path
	 * */
	public static FilterSourceClass classesNot(String... classes) {
		return new FilterSourceClass(TYPE_NOT, classes);
	}
	
	
	
	
	/**
	 * @param classes a list of methods. A method name can be a simple name of a specific method or a name with a simple class name and a  optional (partial) path. "()" are not required
	 * */
	public static FilterSourceMethod methodsOnly(String... methods) {
		return new FilterSourceMethod(TYPE_ONLY, methods);
	}
	
	
	/**
	 * @param classes a list of methods. A method name can be a simple name of a specific method or a name with a simple class name and a  optional (partial) path. "()" are not required
	 * */
	public static FilterSourceMethod methodsNot(String... methods) {
		return new FilterSourceMethod(TYPE_NOT, methods);
	}
	

}




class FilterSourcePackage extends LogFilter {

	
	private int filterType;
	private List<String> packages = new ArrayList<String>();
	
	
	protected FilterSourcePackage(int filterType, String[] packages) {
		this.filterType = filterType;
		for(int i=0; i<packages.length; i++) {
			this.packages.add(packages[i]);
		}
	}
	
	
	@Override
	public boolean acceptLogEntry(LogLevel level, long time, StackTraceElement srcTrace, long threadID, String threadName) {
		if(srcTrace == null || srcTrace.getClassName() == null) {
			if(this.filterType == FilterSource.TYPE_ONLY) {
				return false;
			} else {
				return false;
			}
		}
		
		final String strPackage = srcTrace.getClassName().substring(0, srcTrace.getClassName().lastIndexOf("\\."));
		
		boolean hit = false;
		for(int i=0; i<packages.size(); i++) {
			if(strPackage.contains(packages.get(i))) {
				hit = true;
				break;
			}
		}
		
		if(filterType == FilterSource.TYPE_ONLY) {
			if(hit) {
				return true;
			} else {
				return false;
			}
			
		} else if(filterType == FilterSource.TYPE_NOT) {
			if(hit) {
				return false;
			} else {
				return true;
			}
			
		}
		
		return false;
	}
	
}






class FilterSourceClass extends LogFilter {

	
	private int filterType;
	private List<String> classNames = new ArrayList<String>();
	
	
	public FilterSourceClass(int filterType, String[] classNames) {
		this.filterType = filterType;
		for(int i=0; i<classNames.length; i++) {
			this.classNames.add(classNames[i]);
		}
	}
	
	
	@Override
	public boolean acceptLogEntry(LogLevel level, long time, StackTraceElement srcTrace, long threadID, String threadName) {
		if(srcTrace.getClassName() == null) {
			return false;
		}
		
		final String strClassName = srcTrace.getClassName().substring(srcTrace.getClassName().lastIndexOf("\\."), 0);
		
		boolean hit = false;
		for(int i=0; i<classNames.size(); i++) {
			if(strClassName.endsWith(classNames.get(i))) {
				hit = true;
				break;
			}
		}
		
		if(filterType == FilterSource.TYPE_ONLY) {
			if(hit) {
				return true;
			} else {
				return false;
			}
			
		} else if(filterType == FilterSource.TYPE_NOT) {
			if(hit) {
				return false;
			} else {
				return true;
			}
			
		}
		
		return false;
	}
	
}



class FilterSourceMethod extends LogFilter {

	
	private int filterType;
	private List<String> methodNames = new ArrayList<String>();
	
	
	public FilterSourceMethod(int filterType, String[] methodNames) {
		this.filterType = filterType;
		for(int i=0; i<methodNames.length; i++) {
			this.methodNames.add(methodNames[i].replaceAll("\\(", "").replaceAll("\\)", ""));
		}
	}
	
	
	@Override
	public boolean acceptLogEntry(LogLevel level, long time, StackTraceElement srcTrace, long threadID, String threadName) {
		if(srcTrace.getClassName() == null || srcTrace.getMethodName() == null) {
			return false;
		}
		
		final String strMethodName = srcTrace.getClassName() + "." + srcTrace.getMethodName();
		
		boolean hit = false;
		for(int i=0; i<methodNames.size(); i++) {
			if(strMethodName.endsWith(methodNames.get(i))) {
				hit = true;
				break;
			}
		}
		
		if(filterType == FilterSource.TYPE_ONLY) {
			if(hit) {
				return true;
			} else {
				return false;
			}
			
		} else if(filterType == FilterSource.TYPE_NOT) {
			if(hit) {
				return false;
			} else {
				return true;
			}
			
		}
		
		return false;
	}
	
}












