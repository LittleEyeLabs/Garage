package com.littleeyelabs.android.clarkkent;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;


/**
 * This is the static class to use to report errors.
 * 
 * Ideally, create an Error object and report that.  Different Error 
 * objects know what information to collect.
 * 
 * Alternatively, report an error using a tag, a message and a throwable.
 * 
 * @author gaurav
 */
public class Errors {
	static List<ErrorReporter> reporters = null;
	static boolean initialized = false;

	/**
	 * Configure the remote reporters here
	 * @param context
	 */
	public static void initialize(Context context) {
		if (!initialized) {
			reporters = new ArrayList<ErrorReporter>();
			reporters.add(new ParseReporter(context));
			reporters.add(new CrittercismReporter(context));
			initialized = true;
		}
	}

	public static void report(Error error) {
		for (ErrorReporter reporter:reporters) {
			reporter.log(error);
		}
	}
	
	public static void report(String tag, String error, Throwable tr) {
		
	}

}
