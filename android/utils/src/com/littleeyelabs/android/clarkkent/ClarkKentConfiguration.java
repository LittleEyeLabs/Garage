package com.littleeyelabs.android.clarkkent;

import android.content.Context;

/**
 * Configure reporters - pick the ones you care about, and 
 * provide the various keys/etc required by each of them
 * 
 * TODO: Configuration should not be part of the library
 * 
 * @author gaurav
 */
public class ClarkKentConfiguration {
	private static boolean initialized = false;
	
	// IMPORTANT: Put your application registration values here
	private static final String PARSE_APPID = "";
	private static final String PARSE_CLIENTID = "";
	private static final String CRIT_APPID = "";
	// Crashlytics gets the app token from the manifest file.  Sigh...

	
	public static void initialize(Context context) {
		if (!initialized) {
			//
			// Instantiate the various reporters you will use.
			//
			ParseReporter parse = new ParseReporter(context, PARSE_APPID, PARSE_CLIENTID);
			CrittercismReporter crittercism = new CrittercismReporter(context, CRIT_APPID);
			CrashlyticsReporter crashlytics = new CrashlyticsReporter(context);
			
			GoogleAnalyticsReporter googleAnalytics = new GoogleAnalyticsReporter();
			
			// Set Failure Reporters
			FailureService.addReporter(parse);
			FailureService.addReporter(crittercism);
			FailureService.addReporter(crashlytics);
	
			// Event Reporters
			EventService.addReporter(parse);
			
			// Latency Reporters
			LatencyService.addReporter(parse);
			LatencyService.addReporter(googleAnalytics);
	
			initialized = true;
		}
	}
}
