package com.littleeyelabs.android.clarkkent;

import android.content.Context;

//internal to the package
class ParseReporter implements ErrorReporter, LatencyReporter, EventReporter {

	public ParseReporter(Context context) {
	}
	
	@Override
	public void log(Error error) {
		// TODO Auto-generated method stub
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
