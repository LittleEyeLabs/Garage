package com.littleeyelabs.android.clarkkent;

import android.content.Context;

import com.parse.Parse;
import com.parse.ParseObject;

// internal to the package, should not be visible to clients of the library
class ParseReporter implements FailureReporter, LatencyReporter, EventReporter {
	private final static String FAILURE = "Failure";
	private final static String EVENT = "Event";

	public ParseReporter(Context context, String applicationId, String clientKey) {
		Parse.initialize(context, applicationId, clientKey);
	}
	
	@Override
	public void log(Failure failure) {
		ParseObject parseObject = new ParseObject(failure.category + FAILURE);
		parseObject.put("creationTime", failure.creationTime);
		parseObject.put("message", failure.message);
		
		// TODO: Inject exception
		
		parseObject.saveEventually();
	}

	@Override
	public void log(Event event) {
		ParseObject parseObject = new ParseObject(event.category + EVENT);
		parseObject.put("creationTime", event.creationTime);
		parseObject.put("name", event.name);
		parseObject.saveEventually();
	}

	@Override
	public void log(Latency latency) {
		ParseObject parseObject = new ParseObject(latency.category); // All latencies go to the 'Latency' table
		parseObject.put("creationTime", latency.creationTime);
		parseObject.put("name", latency.name);
		parseObject.put("timeTaken", latency.timeTaken);
		parseObject.saveEventually();
	}

}
