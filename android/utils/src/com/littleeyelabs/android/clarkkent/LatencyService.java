package com.littleeyelabs.android.clarkkent;

import java.util.ArrayList;
import java.util.List;

class LatencyService {
	private static List<LatencyReporter> reporters = null;

	/**
	 * Register the reporter plug-ins here
	 * @param context
	 */
	static void addReporter(LatencyReporter reporter) {
		if (reporters == null) {
			reporters = new ArrayList<LatencyReporter>();
		}
		reporters.add(reporter);
	}

	public static void report(Latency error) {
	}

	public static void report(String action, long timeTaken) {
	}

}
