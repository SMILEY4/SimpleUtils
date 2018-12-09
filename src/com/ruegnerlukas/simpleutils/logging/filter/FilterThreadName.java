package com.ruegnerlukas.simpleutils.logging.filter;

import java.util.HashSet;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public class FilterThreadName extends LogFilter {

	public static FilterThreadName only(String... threadNames) {
		return new FilterThreadName(true, threadNames);
	}
	
	
	public static FilterThreadName not(String... threadNames) {
		return new FilterThreadName(false, threadNames);
	}


	
	
	private final boolean isTypeOnly;
	private final HashSet<String> threadNames = new HashSet<String>();
	
	
	private FilterThreadName(boolean isTypeOnly, String[] threadNames) {
		this.isTypeOnly = isTypeOnly;
		for(int i=0; i<threadNames.length; i++) {
			this.threadNames.add(threadNames[i]);
		}
	}
	
	
	
	
	@Override
	public boolean acceptLogEntry(LogLevel level, long time, StackTraceElement srcTrace, long threadID, String threadName) {
		boolean hit = this.threadNames.contains(threadName);
		if(isTypeOnly) {
			return hit;
		} else {
			return !hit;
		}
	}
	
}
