package com.ruegnerlukas.simpleutils.logging.target;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public class DefaultLogTarget implements LogTarget {

	private PrintStream out;
	private PrintStream err;

	public DefaultLogTarget() {
		out = new PrintStream(new FileOutputStream(FileDescriptor.out));
		err = new PrintStream(new FileOutputStream(FileDescriptor.err));
	}
	
	
	
	@Override
	public boolean write(LogLevel logLevel, String message) {
		if(logLevel.IS_ERROR) {
			err.print(message);
		} else {
			out.print(message);
		}
		return true;
	}

	public boolean close() {
		out.close();
		err.close();
		return true;
	}
	
}
