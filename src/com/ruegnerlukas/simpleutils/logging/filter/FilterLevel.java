package com.ruegnerlukas.simpleutils.logging.filter;

import java.util.EnumSet;
import java.util.Set;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public class FilterLevel extends LogFilter {

	
	public static FilterLevel only(LogLevel... levels) {
		return new FilterLevel(true, levels);
	}
	
	
	public static FilterLevel not(LogLevel... levels) {
		return new FilterLevel(false, levels);
	}
	
	
	
	
	
	private final boolean isTypeOnly;
	private final Set<LogLevel> levels = EnumSet.noneOf(LogLevel.class);
	
	
	
	
	private FilterLevel(boolean isTypeOnly, LogLevel[] levels) {
		this.isTypeOnly = isTypeOnly;
		for(int i=0; i<levels.length; i++) {
			this.levels.add(levels[i]);
		}
	}
	
	
	
	
	@Override
	public boolean acceptLogEntry(LogLevel level, long time, StackTraceElement srcTrace, long threadID, String threadName) {
		boolean hit = this.levels.contains(level);
		if(isTypeOnly) {
			return hit;
		} else {
			return !hit;
		}
	}
	

}
