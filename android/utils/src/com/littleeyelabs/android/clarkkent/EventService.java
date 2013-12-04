package com.littleeyelabs.android.clarkkent;

import java.util.ArrayList;
import java.util.List;

// internal to the package, should not be visible to clients of the library
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
		for (EventReporter reporter:reporters) {
			reporter.log(event);
		}
	}

}
