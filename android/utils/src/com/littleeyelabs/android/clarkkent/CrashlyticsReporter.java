package com.littleeyelabs.android.clarkkent;

import android.content.Context;
import android.util.Log;

import com.crashlytics.android.Crashlytics;

// internal to the package, should not be visible to clients of the library
class CrashlyticsReporter implements FailureReporter {
	private final static String TAG = "CrashlyticsReporter";
	
	boolean isInitialized;
	
	public CrashlyticsReporter(Context context) {
		// It takes a while to initialize, so do it in a separate thread
		isInitialized = false;
		new InitThread(context).start();
	}

	@Override
	public void log(Failure failure) {
		if (isInitialized) {
			if (failure.throwable != null) {
				Crashlytics.logException(failure.throwable);
			} else {
				Exception e = new Exception(failure.category + ": " + failure.name);
				Crashlytics.logException(e);
			}
		}
	}
	
	
	class InitThread extends Thread {
		Context context;
		
		public InitThread(Context context) {
			this.context = context;
		}
		
		/**
		 * This is the init function for crashlytics
		 */
		@Override
		public void run() {
			try { 
				Crashlytics.start(context);
				isInitialized = true;
			} catch (Exception e) {
				Log.w(TAG, "Crashlytics did not start", e);
			}
		}
	}

	
}
