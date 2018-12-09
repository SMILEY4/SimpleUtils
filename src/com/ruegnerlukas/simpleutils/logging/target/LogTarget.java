package com.ruegnerlukas.simpleutils.logging.target;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public interface LogTarget {
	
	public boolean write(LogLevel logLevel, String message);
	
	public boolean close();
}
