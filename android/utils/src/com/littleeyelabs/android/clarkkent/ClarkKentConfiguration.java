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
	private static final String PROD_PARSE_APPID = "";
	private static final String PROD_PARSE_CLIENTID = "";
	private static final String PROD_CRIT_APPID = "";

	private static final String DEV_PARSE_APPID = "";
	private static final String DEV_PARSE_CLIENTID = "";
	private static final String DEV_CRIT_APPID = "";
	// Crashlytics gets the app token from the manifest file.  Sigh...

	// Crashlytics gets the app token from the manifest file.  Sigh...

	
	public static void initialize(Context context, boolean isDebug) {
		if (!initialized) {
			//
			// Instantiate the various reporters you will use.
			//
			ParseReporter parse;
			CrittercismReporter crittercism;
			
			CrashlyticsReporter crashlytics = new CrashlyticsReporter(context);
			GoogleAnalyticsReporter googleAnalytics = new GoogleAnalyticsReporter();

			if (isDebug) {
				parse = new ParseReporter(context, DEV_PARSE_APPID, DEV_PARSE_CLIENTID);
				crittercism = new CrittercismReporter(context, DEV_CRIT_APPID);
			} else {
				parse = new ParseReporter(context, PROD_PARSE_APPID, PROD_PARSE_CLIENTID);
				crittercism = new CrittercismReporter(context, PROD_CRIT_APPID);
			}
			
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
