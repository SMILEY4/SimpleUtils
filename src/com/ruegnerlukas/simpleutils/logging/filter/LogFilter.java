package com.ruegnerlukas.simpleutils.logging.filter;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public abstract class LogFilter {

	public abstract boolean acceptLogEntry(LogLevel level, long time, StackTraceElement srcTrace, long threadID, String threadName);
	
}
