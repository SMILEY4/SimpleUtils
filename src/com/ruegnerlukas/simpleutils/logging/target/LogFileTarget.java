package com.ruegnerlukas.simpleutils.logging.target;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.ruegnerlukas.simpleutils.logging.LogLevel;



public class LogFileTarget implements LogTarget {

	private final File file;
	private PrintWriter out;
	private boolean isClosed = false;
	
	
	
	
	public LogFileTarget(File file, boolean appendToFile) {
		this.file = file;
		
		try {
			this.out = new PrintWriter(new BufferedWriter(new FileWriter(file, appendToFile)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	
	@Override
	public boolean write(LogLevel logLevel, String message) {
		if(out == null) {
			return false;
		}
		out.print(message);
		return true;
	}
	
	
	
	
	public boolean close() {
		if(isClosed) {
			return true;
		}
		out.close();
		isClosed = true;
		return true;
	}

	
}
