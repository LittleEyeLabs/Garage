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

	public Failure(String category, String name) {
		super(category, name);
		this.name = name;
	}
	
	public Failure(String category, String name, Throwable t) {
		super(category, name);
		this.throwable = t;
	}

	@Override
	public void report() {
		FailureService.report(this);
	}

}
