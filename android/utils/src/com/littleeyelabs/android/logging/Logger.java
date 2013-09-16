package com.littleeyelabs.android.logging;

import android.util.Log;

import com.littleeyelabs.clarkkent.BuildConfig;

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
	// Note: If including this as source, uncomment this line and point to the 
	// BuildConfig in your project, to automatically change logging levels.
//	private static int LEVEL = (BuildConfig.DEBUG) ? Log.DEBUG : Log.INFO;
	private static int LEVEL = Log.INFO;

	/**
	 * Call this to change the logging level.  Usually not required, but
	 * can be used to change log level, when debugging an issue in a 
	 * release app.
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

	
	// public static void 
	public static int Error(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.ERROR) {
			return Log.e(tag, msg, tr);
		}
		return 0;
	}

	public static int Error(String tag, String msg) {
		if (LEVEL >= Log.ERROR) {
			Log.e(tag, msg);
		}
		return 0;
	}

	public static int Warn(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.WARN) {
			Log.w(tag, msg, tr);
		}
		return 0;
	}

	public static int Warn(String tag, String msg) {
		if (LEVEL >= Log.WARN) {
			Log.w(tag, msg);
		}
		return 0;
	}

	public static int Info(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.INFO) {
			Log.i(tag, msg, tr);
		}
		return 0;
	}

	public static int Info(String tag, String msg) {
		if (LEVEL >= Log.INFO) {
			Log.i(tag, msg);
		}
		return 0;
	}

	public static int Debug(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.DEBUG) {
			Log.d(tag, msg, tr);
		}
		return 0;
	}

	public static int Debug(String tag, String msg) {
		if (LEVEL >= Log.DEBUG) {
			Log.d(tag, msg);
		}
		return 0;
	}

	public static int Verbose(String tag, String msg, Throwable tr) {
		if (LEVEL >= Log.VERBOSE) {
			Log.v(tag, msg, tr);
		}
		return 0;
	}

	public static int Verbose(String tag, String msg) {
		if (LEVEL >= Log.VERBOSE) {
			Log.v(tag, msg);
		}
		return 0;
	}
	
	
}
