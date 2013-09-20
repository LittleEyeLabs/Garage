package com.littleeyelabs.android.clarkkent;

import java.util.ArrayList;
import java.util.List;

import com.parse.Parse;

import android.content.Context;

/**
 * Configure remote reporting plugins
 * 
 * @author gaurav
 */
public class ClarkKent {
	private static boolean initialized = false;
	
	// TODO: Put your registration values here
	private static final String PARSE_APPID = "";
	private static final String PARSE_CLIENTID = "";
	
	public static void initialize(Context context) {
		if (!initialized) {
			//
			// Instantiate the various reporters you will use.
			//
			ParseReporter parse = new ParseReporter(context, PARSE_APPID, PARSE_CLIENTID);
			CrittercismReporter crittercism = new CrittercismReporter(context);
			GoogleAnalyticsReporter googleAnalytics = new GoogleAnalyticsReporter();
			
			// Set Failure Reporters
			FailureService.addReporter(parse);
			FailureService.addReporter(crittercism);
	
			// Event Reporters
			EventService.addReporter(parse);
			
			// Latency Reporters
			LatencyService.addReporter(parse);
			LatencyService.addReporter(googleAnalytics);
	
			initialized = true;
		}
	}
}
