package com.littleeyelabs.android.clarkkent;

import android.content.Context;

//internal to the package
class CrashlyticsReporter implements FailureReporter {

	
	public CrashlyticsReporter(Context context) {
		// Crashlytics gets the app token from the manifest file.  Sigh...
	}

	@Override
	public void log(Failure error) {
		// TODO Auto-generated method stub

	}

}
