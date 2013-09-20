package com.littleeyelabs.android.clarkkent;

import android.content.Context;

import com.parse.Parse;
import com.parse.ParseObject;

//internal to the package
class ParseReporter implements FailureReporter, LatencyReporter, EventReporter {

	public ParseReporter(Context context, String applicationId, String clientKey) {
		Parse.initialize(context, applicationId, clientKey);
	}
	
	@Override
	public void log(Failure error) {
		ParseObject parseObject = new ParseObject(error.category);
		parseObject.put("creationTime", error.creationTime);
		parseObject.put("message", error.message);
		parseObject.saveInBackground();
	}

	@Override
	public void log(Event event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void log(Latency latency) {
		// TODO Auto-generated method stub
	}

}
