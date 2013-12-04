package com.littleeyelabs.android.clarkkent;

import android.content.Context;

import com.parse.Parse;
import com.parse.ParseObject;

// internal to the package, should not be visible to clients of the library

// TODO: Convert creationTime into readable string
// TODO: Add exception stack traces to log(failure)
class ParseReporter implements FailureReporter, LatencyReporter, EventReporter {
	private final static String FAILURE = "Failure";
	private final static String EVENT = "Event";
	private final static String LATENCY = "Latency";

	public ParseReporter(Context context, String applicationId, String clientKey) {
		Parse.initialize(context, applicationId, clientKey);
	}
	
	@Override
	public void log(Failure failure) {
		ParseObject parseObject = new ParseObject(failure.category);
		parseObject.put("Type", FAILURE);
		parseObject.put("ReportedAt", failure.creationTime);
		parseObject.put("Name", failure.name);
		parseObject.saveEventually();
	}

	@Override
	public void log(Event event) {
		ParseObject parseObject = new ParseObject(event.category);
		parseObject.put("Type", EVENT);
		parseObject.put("ReportedAt", event.creationTime);
		parseObject.put("Name", event.name);
		parseObject.saveEventually();
	}

	@Override
	public void log(Latency latency) {
		ParseObject parseObject = new ParseObject(latency.category); // All latencies go to the 'Latency' table
		parseObject.put("Type", LATENCY);
		parseObject.put("ReportedAt", latency.creationTime);
		parseObject.put("Name", latency.name);
		parseObject.put("TimeTaken", latency.timeTaken);
		parseObject.saveEventually();
	}

}
