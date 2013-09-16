package com.littleeyelabs.android.clarkkent;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class Latencies {
	static List<LatencyReporter> reporters = null;
	static boolean initialized = false;

	// TODO: Find a different way to initialize the required reporters here
	public static void initialize(Context context) {
		if (!initialized) {
			reporters = new ArrayList<LatencyReporter>();
			reporters.add(new ParseReporter(context));
			reporters.add(new GoogleAnalyticsReporter());
			initialized = true;
		}
	}

	public static void report(Error error) {
		
	}

	public static void report(String action, long timeTaken) {
		
	}

}
