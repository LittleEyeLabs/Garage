package com.littleeyelabs.android.clarkkent;

/**
 * Work-in-progress.
 * 
 * @author gaurav
 */
public class Latency extends Reportable {
	long timeTaken;

	public Latency(String category, String name) {
		super(category, name);
	}

	@Override
	public void report() {
		timeTaken = System.currentTimeMillis() - creationTime;
		LatencyService.report(this);
	}

}
