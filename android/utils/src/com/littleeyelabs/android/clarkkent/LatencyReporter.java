package com.littleeyelabs.android.clarkkent;

// internal to the package, should not be visible to clients of the library
interface LatencyReporter {
	void log(Latency latency);
}
