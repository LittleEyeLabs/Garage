package com.littleeyelabs.android.clarkkent;

import java.util.ArrayList;
import java.util.List;


class EventService {
	private static List<EventReporter> reporters = null;

	/**
	 * Register the reporter plug-ins here
	 * @param context
	 */
	static void addReporter(EventReporter reporter) {
		if (reporters == null) {
			reporters = new ArrayList<EventReporter>();
		}
		reporters.add(reporter);
	}

	public static void report(Event event) {
		
	}

	public static void report(String tag, String event) {
		
	}

}
