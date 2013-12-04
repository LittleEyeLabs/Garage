package com.littleeyelabs.android.clarkkent;

/**
 * Work-in-progress.
 * 
 * @author gaurav
 */
public class Latency extends Reportable {
	private final static String LATENCY_CATEGORY = "Latency";
	
	/**
	 * Each latency measurement has a name associated with it.
	 */
	String name;
	long timeTaken;

	public Latency(String name) {
		super(LATENCY_CATEGORY);
		this.name = name;
		
	}

	@Override
	public void report() {
		long timeTaken = System.currentTimeMillis() - creationTime;
		LatencyService.report(this);
	}

}
