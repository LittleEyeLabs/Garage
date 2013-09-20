package com.littleeyelabs.android.clarkkent;

public class Latency extends Reportable {
	private final static String DEFAULT = "Latency";
	long timeTaken;

	public Latency(String name) {
		super(DEFAULT);
	}

	@Override
	public void report() {
		LatencyService.report(this);
		// TODO Auto-generated method stub
		
	}

}
