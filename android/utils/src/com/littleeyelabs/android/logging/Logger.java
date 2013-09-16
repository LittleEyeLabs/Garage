package com.littleeyelabs.android.logging;

import android.util.Log;

/**
 * Logging wrapper.
 * 
 * Allows changing log levels in one place (e.g. close to release)
 * Allows changing log implementation.  e.g. util.log AND local circular log file 
 * 
 * TODO: Allow writing to a local file, and then uploading that when required
 * TODO: Use varargs (Object...) to prevent unnecessary string construction
 * 
 * @author gaurav lochan
 */
public class Logger {
//	private static int LEVEL = (BuildConfig.DEBUG) ? Log.DEBUG : Log.INFO;
	private static int LEVEL = Log.INFO;

	private static LogFile logFile = null;

	/**
	 * Optional: Call it to initialize local file logging
	 * 
	 * @param context
	 */
	public static void setLogFile(LogFile file) {
		logFile = file;
	}
	
	/**
	 * Call this to change the logging level.  can be used to change log level
	 * at runtime, when debugging a release app
	 * 
	 * @param newLevel
	 */
	public static void setLogLevel(int newLevel) {
		if ((newLevel >= Log.VERBOSE) && (newLevel <= Log.ERROR)) {
			LEVEL = newLevel;
		}
	}

	/**
	 * Can be used by client code to check if debug logging is enabled.
	 * This can prevent unnecessary string creation for debug logs.
	 * 
	 * TODO: Use varargs (Object...) to prevent unnecessary string construction
	 */
	public static boolean isDebugEnabled() {
		return (LEVEL >= Log.DEBUG);
	}

	
	public static int Error(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.ERROR) {
			if (logFile != null) logFile.log(Log.ERROR, tag, msg, tr);
			return Log.e(tag, msg, tr);
		}
		return 0;
	}

	public static int Error(String tag, String msg) {
		if (LEVEL >= Log.ERROR) {
			if (logFile != null) logFile.log(Log.ERROR, tag, msg);
			Log.e(tag, msg);
		}
		return 0;
	}

	public static int Warn(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.WARN) {
			if (logFile != null) logFile.log(Log.WARN, tag, msg, tr);
			Log.w(tag, msg, tr);
		}
		return 0;
	}

	public static int Warn(String tag, String msg) {
		if (LEVEL >= Log.WARN) {
			if (logFile != null) logFile.log(Log.WARN, tag, msg);
			Log.w(tag, msg);
		}
		return 0;
	}

	public static int Info(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.INFO) {
			if (logFile != null) logFile.log(Log.INFO, tag, msg, tr);
			Log.i(tag, msg, tr);
		}
		return 0;
	}

	public static int Info(String tag, String msg) {
		if (LEVEL >= Log.INFO) {
			if (logFile != null) logFile.log(Log.INFO, tag, msg);
			Log.i(tag, msg);
		}
		return 0;
	}

	public static int Debug(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.DEBUG) {
			if (logFile != null) logFile.log(Log.DEBUG, tag, msg, tr);
			Log.d(tag, msg, tr);
		}
		return 0;
	}

	public static int Debug(String tag, String msg) {
		if (LEVEL >= Log.DEBUG) {
			if (logFile != null) logFile.log(Log.DEBUG, tag, msg);
			Log.d(tag, msg);
		}
		return 0;
	}

	public static int Verbose(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.VERBOSE) {
			if (logFile != null) logFile.log(Log.VERBOSE, tag, msg, tr);
			Log.v(tag, msg, tr);
		}
		return 0;
	}

	public static int Verbose(String tag, String msg) {
		if (LEVEL >= Log.VERBOSE) {
			if (logFile != null) logFile.log(Log.VERBOSE, tag, msg);
			Log.v(tag, msg);
		}
		return 0;
	}
	
	
}
