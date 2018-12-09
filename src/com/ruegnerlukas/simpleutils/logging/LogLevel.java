package com.ruegnerlukas.simpleutils.logging;



public enum LogLevel {
	DEBUG(false, "Debug", "-"),
	INFO( false, " Info", "i"),
	WARN( true,  " Warn", "!"),
	ERROR(true,  "ERROR", "*"),
	FATAL(true,  "FATAL", "F"),
	NONE(false, "", "");
	
	public final boolean IS_ERROR;
	public final String DISPLAY;
	public final String SYMBOL;
	
	private LogLevel(boolean isError, String display, String symbol) {
		IS_ERROR = isError;
		DISPLAY = display;
		SYMBOL = symbol;
	}
}
