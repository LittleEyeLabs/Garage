package com.littleeyelabs.android.clarkkent;

// internal to the package, should not be visible to clients of the library
interface FailureReporter {
	void log(Failure failure);
}
