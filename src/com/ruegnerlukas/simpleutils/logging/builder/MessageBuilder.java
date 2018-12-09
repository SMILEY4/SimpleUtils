package com.ruegnerlukas.simpleutils.logging.builder;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public abstract class MessageBuilder {

	
	private String lineSeparator = System.lineSeparator();
	
	
	
	
	public void setLineSeparator(String lineSeparator) {
		this.lineSeparator = lineSeparator;
	}
	
	
	
	
	public String getLineSeparator() {
		return this.lineSeparator;
	}
	
	
	
	
	public abstract void buildMessage(StringBuilder builder, LogLevel logLevel, long time, StackTraceElement srcTrace, long threadID, String threadName, Object... msgObjects);
	
}
