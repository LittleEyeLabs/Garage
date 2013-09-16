package com.littleeyelabs.android.clarkkent;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;


public class Events {
	static List<EventReporter> reporters = null;
	static boolean initialized = false;

	public static void initialize(Context context) {
		if (!initialized) {
			reporters = new ArrayList<EventReporter>();
			reporters.add(new ParseReporter(context));
			initialized = true;
		}
	}

	public static void report(Event event) {
		
	}

	public static void report(String tag, String event) {
		
	}

}
