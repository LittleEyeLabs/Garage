package com.littleeyelabs.android.clarkkent;

import com.crittercism.app.Crittercism;

import android.content.Context;

// internal to the package, should not be visible to clients of the library
class CrittercismReporter implements FailureReporter {

	public CrittercismReporter(Context context, String appId) {
		Crittercism.initialize(context, appId);
	}

	@Override
	public void log(Failure failure) {
		if (failure.throwable != null) {
			Crittercism.logHandledException(failure.throwable);
		} else {
			Exception e = new Exception(failure.category + ": " + failure.name);
			Crittercism.logHandledException(e);
		}
	}

}
