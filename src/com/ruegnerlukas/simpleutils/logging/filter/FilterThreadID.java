package com.ruegnerlukas.simpleutils.logging.filter;

import java.util.HashSet;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public class FilterThreadID extends LogFilter {

	public static FilterThreadID only(long... threadIDs) {
		return new FilterThreadID(true, threadIDs);
	}
	
	
	public static FilterThreadID not(long... threadIDs) {
		return new FilterThreadID(false, threadIDs);
	}


	
	
	private final boolean isTypeOnly;
	private final HashSet<Long> threadIDs = new HashSet<Long>();
	
	
	private FilterThreadID(boolean isTypeOnly, long[] threadIDs) {
		this.isTypeOnly = isTypeOnly;
		for(int i=0; i<threadIDs.length; i++) {
			this.threadIDs.add(threadIDs[i]);
		}
	}
	
	
	
	
	@Override
	public boolean acceptLogEntry(LogLevel level, long time, StackTraceElement srcTrace, long threadID, String threadName) {
		boolean hit = this.threadIDs.contains(threadID);
		if(isTypeOnly) {
			return hit;
		} else {
			return !hit;
		}
	}
	
}
