package com.littleeyelabs.android.clarkkent;

import java.util.ArrayList;
import java.util.List;


// internal to the package, should not be visible to clients of the library
class FailureService {
	private static List<FailureReporter> reporters = null;

	/**
	 * Register the reporter plug-ins here
	 * @param context
	 */
	static void addReporter(FailureReporter reporter) {
		if (reporters == null) {
			reporters = new ArrayList<FailureReporter>();
		}
		reporters.add(reporter);
	}

	public static void report(Failure error) {
		for (FailureReporter reporter:reporters) {
			reporter.log(error);
		}
	}
	
}
