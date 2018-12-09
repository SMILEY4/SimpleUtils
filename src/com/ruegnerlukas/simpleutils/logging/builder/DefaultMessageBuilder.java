package com.ruegnerlukas.simpleutils.logging.builder;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import com.ruegnerlukas.simpleutils.logging.LogLevel;

public class DefaultMessageBuilder extends MessageBuilder {

	public static final String LONG_DATE_FORMAT = "YYYY-MM-dd::HH:mm:ss.SSS";
	public static final String SHORT_DATE_FORMAT = "HH:mm:ss.SSS";
	
	private boolean displayLogLevel = true;
	private boolean displayTimestamp = true;
	private boolean displayThreadName = false;
	private boolean displayThreadID = true;
	private boolean displaySource = true;
	
	private boolean useLevelSymbols = false;

	private boolean displayMethodName = false;
	private boolean useSimpleClassName = true;
	private int sourceNameSizeLimit = 10000;
	private int sourceNameSizeMin = 20;
	
	private int limitArrayElements = 20;
	private boolean prettyPrintArrays = true;
	private StringBuilder sb = new StringBuilder();

	
	private String dateFormat = LONG_DATE_FORMAT;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
	
	
	
	
	@Override
	public void buildMessage(StringBuilder builder, LogLevel logLevel, long time, StackTraceElement srcTrace, long threadID, String threadName, Object... msgObjects) {
	
		if(displayLogLevel) {
			String strLogLevel = useLevelSymbols ? logLevel.SYMBOL : logLevel.DISPLAY;
			builder.append("(").append(strLogLevel).append(")");
			if( !(displayTimestamp || displayThreadName || displayThreadID || displaySource) ) {
				builder.append(": ");
			} else {
				builder.append(" ");
			}
		}
		
		if(displayTimestamp) {
			String strTimestamp = simpleDateFormat.format(new Date(time));
			builder.append(strTimestamp);
			if( !(displayThreadName || displayThreadID || displaySource) ) {
				builder.append(": ");
			} else {
				builder.append(" ");
			}
		}
	
		if(displayThreadName) {
			builder.append(threadName);
			if( !(displayThreadID || displaySource) ) {
				builder.append(": ");
			} else {
				if(displayThreadID) {
					builder.append("-");
				} else {
					builder.append(" ");
				}
			}
		}
		
		if(displayThreadID) {
			builder.append("(").append("PID=").append(threadID < 10 ? " "+threadID : threadID).append(")");
			if( !(displaySource) ) {
				builder.append(": ");
			} else {
				builder.append(" ");
			}
		}
		
		if(displaySource) {
			
			String strSource;
			
			if(srcTrace == null) {
				strSource = "srsunknown";
			} else {
				String className = useSimpleClassName ? srcTrace.getClassName().split("\\.")[srcTrace.getClassName().split("\\.").length-1] : srcTrace.getClassName();
				strSource = className + (displayMethodName ? '.' + srcTrace.getMethodName() + '(' + ')' : "") + ':' + srcTrace.getLineNumber();
			}
	
			if(strSource.length() > this.sourceNameSizeLimit) {
				strSource = "..." + strSource.substring(strSource.length()-sourceNameSizeLimit+3, strSource.length());
			}
			strSource += ":";
			
			if(strSource.length() < sourceNameSizeMin) {
				strSource = String.format("%-"+sourceNameSizeMin+"s", strSource);
			}
			
			builder.append('@').append(strSource).append(" ");
			
		}
		
		
		for(int i=0; i<msgObjects.length; i++) {
			Object msgObj = msgObjects[i];
			
			if(msgObj != null) {
				if(msgObj.getClass().isArray()) {
					builder.append(arrayObjectToString(msgObj));
				} else {
					builder.append(msgObj.toString());
				}
				
			} else {
				builder.append("null");
			}
			
		}
		
		builder.append(getLineSeparator());
	
	}
	
	
	
	
	private String arrayObjectToString(Object obj) {
		if(!prettyPrintArrays) {
			return obj.toString();
		}
		
		sb.setLength(0);
		
		if(obj instanceof char[]) {
			char[] arr = (char[])obj;
			sb.append("char[" + arr.length + "]@" +Integer.toHexString(arr.hashCode()) + " {");
			for(int i=0, n=arr.length; i<n; i++) {
				if(i >= limitArrayElements) {
					sb.append('.').append('.').append('.');
					break;
				} else {
					sb.append(arr[i]);
					if(i < n-1) {
						sb.append(',').append(' ');
					}
				}
			}
			sb.append('}');
			
		} else if(obj instanceof byte[]) {
			byte[] arr = (byte[])obj;
			sb.append("byte[" + arr.length + "]@" +Integer.toHexString(arr.hashCode()) + " {");
			for(int i=0, n=arr.length; i<n; i++) {
				if(i >= limitArrayElements) {
					sb.append('.').append('.').append('.');
					break;
				} else {
					sb.append(arr[i]);
					if(i < n-1) {
						sb.append(',').append(' ');
					}
				}
			}
			sb.append('}');
			
		} else if(obj instanceof short[]) {
			short[] arr = (short[])obj;
			sb.append("short[" + arr.length + "]@" +Integer.toHexString(arr.hashCode()) + " {");
			for(int i=0, n=arr.length; i<n; i++) {
				if(i >= limitArrayElements) {
					sb.append('.').append('.').append('.');
					break;
				} else {
					sb.append(arr[i]);
					if(i < n-1) {
						sb.append(',').append(' ');
					}
				}
			}
			sb.append('}');
			
		} else if(obj instanceof int[]) {
			int[] arr = (int[])obj;
			sb.append("int[" + arr.length + "]@" +Integer.toHexString(arr.hashCode()) + " {");
			for(int i=0, n=arr.length; i<n; i++) {
				if(i >= limitArrayElements) {
					sb.append('.').append('.').append('.');
					break;
				} else {
					sb.append(arr[i]);
					if(i < n-1) {
						sb.append(',').append(' ');
					}
				}
			}
			sb.append('}');
			
		} else if(obj instanceof long[]) {
			long[] arr = (long[])obj;
			sb.append("long[" + arr.length + "]@" +Integer.toHexString(arr.hashCode()) + " {");
			for(int i=0, n=arr.length; i<n; i++) {
				if(i >= limitArrayElements) {
					sb.append('.').append('.').append('.');
					break;
				} else {
					sb.append(arr[i]);
					if(i < n-1) {
						sb.append(',').append(' ');
					}
				}
			}
			sb.append('}');
			
		} else if(obj instanceof float[]) {
			float[] arr = (float[])obj;
			sb.append("float[" + arr.length + "]@" +Integer.toHexString(arr.hashCode()) + " {");
			for(int i=0, n=arr.length; i<n; i++) {
				if(i >= limitArrayElements) {
					sb.append('.').append('.').append('.');
					break;
				} else {
					sb.append(arr[i]);
					if(i < n-1) {
						sb.append(',').append(' ');
					}
				}
			}
			sb.append('}');
			
		} else if(obj instanceof double[]) {
			double[] arr = (double[])obj;
			sb.append("double[" + arr.length + "]@" +Integer.toHexString(arr.hashCode()) + " {");
			for(int i=0, n=arr.length; i<n; i++) {
				if(i >= limitArrayElements) {
					sb.append('.').append('.').append('.');
					break;
				} else {
					sb.append(arr[i]);
					if(i < n-1) {
						sb.append(',').append(' ');
					}
				}
			}
			sb.append('}');
			
		} else if(obj instanceof String[]) {
			String[] arr = (String[])obj;
			sb.append("String[" + arr.length + "]@" +Integer.toHexString(arr.hashCode()) + " {");
			for(int i=0, n=arr.length; i<n; i++) {
				if(i >= limitArrayElements) {
					sb.append('.').append('.').append('.');
					break;
				} else {
					sb.append(arr[i]);
					if(i < n-1) {
						sb.append(',').append(' ');
					}
				}
			}
			sb.append('}');
			
		} else if(obj instanceof Object[]) {
			Object[] arr = (Object[])obj;
			sb.append("Object[" + arr.length + "]@" +Integer.toHexString(arr.hashCode()) + " {");
			for(int i=0, n=arr.length; i<n; i++) {
				if(i >= limitArrayElements) {
					sb.append('.').append('.').append('.');
					break;
				} else {
					sb.append(arr[i]);
					if(i < n-1) {
						sb.append(',').append(' ');
					}
				}
			}
			sb.append('}');
			
		}
		
		return sb.toString();
	}

	
	
	
	
	
	public void setDisplayLogLevel(boolean displayLogLevel) {
		this.displayLogLevel = displayLogLevel;
	}
	
	
	
	
	public void setDisplayTimestamp(boolean displayTimestamp) {
		this.displayTimestamp = displayTimestamp;
	}
	
	
	
	
	public void setDisplayThreadID(boolean displayThreadID) {
		this.displayThreadID = displayThreadID;
	}
	
	
	
	
	public void setDisplayThreadName(boolean displayThreadName) {
		this.displayThreadName = displayThreadName;
	}
	
	
	
	
	public void setDisplaySource(boolean displaySource) {
		this.displaySource = displaySource;
	}
	
	
	
	
	public void setSourceNameSizeLimit(int maxSize) {
		this.sourceNameSizeLimit = maxSize;
	}

	
	
	
	public void setSourceNameSizeMin(int minSize) {
		this.sourceNameSizeMin = minSize;
	}
	
	
	
	
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
		simpleDateFormat = new SimpleDateFormat(dateFormat);
	}
	
	
	
	public void setUseSimpleClassName(boolean useSimpleSourceName) {
		this.useSimpleClassName = useSimpleSourceName;
	}
	
	
	
	
	public void setDisplayMethodName(boolean displayMethodName) {
		this.displayMethodName = displayMethodName;
	}
	
	
	
	
	public void useLevelSymbols(boolean useLevelSymbols) {
		this.useLevelSymbols = useLevelSymbols;
	}
	
	
	public void setPrettyPrintArrays(boolean prettyPrintArrays) {
		this.prettyPrintArrays = prettyPrintArrays;
	}
	
	
	public void setLimitArrayElements(int limitArrayElements) {
		this.limitArrayElements = limitArrayElements;
	}
	
	

}
