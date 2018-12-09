package com.ruegnerlukas.simpleutils.logging.builder;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public abstract class MessageGroupBuilder extends MessageBuilder {

	public static MessageBuilder createByThread(String lineStart) {
		return new MessageGroupBuilderThread(lineStart);	
	}
	
}






class MessageGroupBuilderThread extends DefaultMessageBuilder {
	
	private String lineStart;
	private long lastThreadID = -1;
	
	protected MessageGroupBuilderThread(String lineStart) {
		this.lineStart = lineStart;
	}
	
	@Override
	public void buildMessage(StringBuilder builder, LogLevel logLevel, long time, StackTraceElement srcTrace, long threadID, String threadName, Object... msgObjects) {
		if(lastThreadID != threadID) {
			builder.append("Thread \"" + threadName + "\" id=" + threadID).append(getLineSeparator());
			lastThreadID = threadID;
		}
		builder.append(lineStart);
		super.buildMessage(builder, logLevel, time, srcTrace, threadID, threadName, msgObjects);
	}
	
}





