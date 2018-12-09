package com.ruegnerlukas.simpleutils.logging.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public class LogFilterManager {

	
	private List<LogFilter> filters = new ArrayList<LogFilter>();
	
	
	
	public LogFilterManager addFilter(LogFilter filter) {
		filters.add(filter);
		return this;
	}
	
	
	
	
	public LogFilterManager removeFilter(LogFilter filter) {
		filters.remove(filter);
		return this;
	}
	
	
	
	
	public LogFilterManager removeFilter(Class<? extends LogFilter> filterType) {
		Iterator<LogFilter> iter = filters.iterator();
		while (iter.hasNext()) {
		    if (iter.next().getClass() == filterType) {
		        iter.remove();
		    }
		}
		return this;
	}
	
	
	
	
	public boolean acceptLogEntry(LogLevel level, long time, StackTraceElement srcTrace, long threadID, String threadName) {
		for(int i=0; i<filters.size(); i++) {
			if(!filters.get(i).acceptLogEntry(level, time, srcTrace, threadID, threadName)) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
}
