package com.ruegnerlukas.simpleutils.logging.logger;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;

import com.ruegnerlukas.simpleutils.logging.LogLevel;
import com.ruegnerlukas.simpleutils.logging.builder.DefaultMessageBuilder;
import com.ruegnerlukas.simpleutils.logging.builder.MessageBuilder;
import com.ruegnerlukas.simpleutils.logging.filter.LogFilterManager;
import com.ruegnerlukas.simpleutils.logging.target.DefaultLogTarget;
import com.ruegnerlukas.simpleutils.logging.target.LogTarget;


public class Logger {

	private static final Logger DEFAULT_LOGGER = new Logger("Default");
	
	private static Map<String, Logger> loggers;
	private static Logger defaultLogger = new Logger("Default");

	
	public static Logger get() {
		return defaultLogger;
	}
	
	
	public static void setDefault(Logger logger) {
		if(logger == null) {
			defaultLogger = DEFAULT_LOGGER;
		} else {
			defaultLogger = logger;
		}
	}
	
	
	
	public static Logger get(String name) {
		Logger logger = loggers.get(name);
		if(logger == null) {
			logger = new Logger(name);
			loggers.put(name, logger);
		}
		return logger;
	}
	
	
	
	
	
	
	
	
	private final String NAME;
	
	private LogFilterManager filterManager = new LogFilterManager();
	private MessageBuilder msgBuilder = new DefaultMessageBuilder();
	private StringBuilder stringBuilder = new StringBuilder();
	private LogTarget logTarget = new DefaultLogTarget();
	
	
	
	public Logger(String name) {
		this.NAME = name;
	}
	
	
	
	
	
	
	public Logger setFilterManager(LogFilterManager filterManager) {
		this.filterManager = filterManager;
		return this;
	}
	
	
	
	
	public LogFilterManager getFilterManager() {
		return filterManager;
	}
	
	
	
	
	public Logger setMessageBuilder(MessageBuilder msgBuilder) {
		this.msgBuilder = msgBuilder;
		return this;
	}
	
	
	
	
	public MessageBuilder getMessageBuilder() {
		return msgBuilder;
	}
	
	
	
	
	public Logger setLogTarget(LogTarget logTarget) {
		this.logTarget = logTarget;
		return this;
	}
	
	
	
	
	public LogTarget getLogTarget() {
		return logTarget;
	}
	
	
	
	
	public Logger redirectStdOutput( LogLevel levelStdOut, LogLevel levelStdErr) {
		System.setOut(new Interceptor(System.out, levelStdOut, this));
		System.setErr(new Interceptor(System.err, levelStdErr, this));
		return this;
	}
	
	
	
	
	public synchronized void log(LogLevel logLevel, Object... msgObjs) {
		
		// get time
		final long time = System.currentTimeMillis();
		
		// get source
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement srcTrace = null;
		for(int i=1; i<stackTrace.length; i++) {
			StackTraceElement e = stackTrace[i];
			if(!e.getClassName().equals(Logger.class.getName()) && !e.getClassName().equals(Interceptor.class.getName())) {
				srcTrace = e;
				break;
			}
		}
		
		// get thread id
		final long threadID = Thread.currentThread().getId();
		
		// get thread name
		final String threadName = Thread.currentThread().getName();
		
		
		// FILTER
		boolean acceptEntry = getFilterManager().acceptLogEntry(logLevel, time, srcTrace, threadID, threadName);
		if(!acceptEntry) {
			return;
		}
		
		// BUILD
		stringBuilder.setLength(0);
		getMessageBuilder().buildMessage(stringBuilder, logLevel, time, srcTrace, threadID, threadName, msgObjs);
		
		// WRITE
		logTarget.write(logLevel, stringBuilder.toString());
		
	}
	
	
	
	
	public void debug(Object... msgObjs) {
		log(LogLevel.DEBUG, msgObjs);
	}
	
	
	
	
	public void debug(Exception e) {
		log(LogLevel.DEBUG, e);
	}
	
	
	
	
	public void debug(String message, Exception e) {
		log(LogLevel.DEBUG, message, e);
	}
	
	
	
	
	public void info(Object... msgObjs) {
		log(LogLevel.INFO, msgObjs);
	}
	
	
	
	
	public void info(Exception e) {
		log(LogLevel.INFO, e);
	}
	
	
	
	
	public void info(String message, Exception e) {
		log(LogLevel.INFO, message, e);
	}
	
	
	
	
	public void warn(Object... msgObjs) {
		log(LogLevel.WARN, msgObjs);
	}
	
	
	
	
	public void warn(Exception e) {
		log(LogLevel.WARN, e);
	}
	
	
	
	
	public void warn(String message, Exception e) {
		log(LogLevel.WARN, message, e);
	}
	
	
	
	
	public void error(Object... msgObjs) {
		log(LogLevel.ERROR, msgObjs);
	}
	
	
	
	
	public void error(Exception e) {
		log(LogLevel.ERROR, e);

	}
	
	
	
	
	public void error(String message, Exception e) {
		log(LogLevel.ERROR, message, e);
	}
	
	
	
	
	public void fatal(Object... msgObjs) {
		log(LogLevel.FATAL, msgObjs);
	}
	
	
	
	
	public void fatal(Exception e) {
		log(LogLevel.FATAL, e);
	}
	
	
	
	
	public void fatal(String message, Exception e) {
		log(LogLevel.FATAL, message, e);
	}
	
	
	
	
	private final StringBuilder sbTrace = new StringBuilder();
	
	public void stackTrace(LogLevel logLevel) {
		
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		if(stacktrace == null || stacktrace.length == 0) {
			return;
		}
		
		sbTrace.setLength(0);
		
		for(int i=2; i<stacktrace.length-1; i++) {
			StackTraceElement stackElement = stacktrace[i];
			sbTrace	.append(stackElement.getClassName().split("\\.")[stackElement.getClassName().split("\\.").length-1])
					.append('.')
					.append(stackElement.getMethodName())
					.append(" < ");
		}
		
		sbTrace	.append(stacktrace[stacktrace.length-1].getClassName())
				.append('.')
				.append(stacktrace[stacktrace.length-1].getMethodName());
		
		log(logLevel, sbTrace.toString());
	}
	
	
	
	
	public void log(LogLevel logLevel, Exception e) {
		log(logLevel, e.toString());
		for(StackTraceElement traceElement : e.getStackTrace()) {
			log(logLevel, traceElement.toString());
		}
	}
	
	
	
	
	public void log(LogLevel logLevel, String message, Exception e) {
		log(logLevel, message);
		log(logLevel, e.toString());
		for(StackTraceElement traceElement : e.getStackTrace()) {
			log(logLevel, traceElement.toString());
		}
	}
	
	
	
	
	public void blankLine() {
		logTarget.write(LogLevel.NONE, "."+getMessageBuilder().getLineSeparator());
	}

	
	
	
	public void close() {
		logTarget.close();
	}
	
	
	
	
	public String getName() {
		return this.NAME;
	}
	
	
}




class Interceptor extends PrintStream {

	private LogLevel logLevel;
	private Logger logger;
	
	public Interceptor(OutputStream out, LogLevel logLevel, Logger logger) {
		super(out, true);
		this.logLevel = logLevel;
		this.logger = logger;
	}
	
	
	@Override
	public void print(String x) {
		logger.log(logLevel, x);
	}
	
	@Override
	public void println(boolean x) {
		logger.log(logLevel, x);
	}
	
	@Override
	public void println(char x) {
		logger.log(logLevel, x);
	}
	
	@Override
	public void println(int x) {
		logger.log(logLevel, x);
	}
	
	@Override
	public void println(long x) {
		logger.log(logLevel, x);
	}
	
	@Override
	public void println(float x) {
		logger.log(logLevel, x);
	}
	
	@Override
	public void println(double x) {
		logger.log(logLevel, x);
	}
	
	@Override
	public void println(char[] x) {
		logger.log(logLevel, x);
	}
	
	@Override
	public void println(String x) {
		logger.log(logLevel, x);
	}
	
	@Override
	public void println(Object x) {
		logger.log(logLevel, x);
	}
	
}
