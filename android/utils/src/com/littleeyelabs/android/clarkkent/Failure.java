package com.littleeyelabs.android.clarkkent;



/**
 * Simple instance of a @Failure
 * 
 * Each failure needs to define a category, and a failure message.
 * Can optionally provide a throwable.
 * 
 * @author gaurav
 */
public class Failure extends Reportable {
	Throwable throwable = null;  // optional
	String message = null;

	public Failure(String category, String message) {
		super(category);
		this.message = message;
	}
	
	public Failure(String category, String message, Throwable t) {
		super(category);
		this.message = message;
		this.throwable = t;
	}

	@Override
	public void report() {
		FailureService.report(this);
	}

}
