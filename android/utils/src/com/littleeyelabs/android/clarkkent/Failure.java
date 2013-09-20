package com.littleeyelabs.android.clarkkent;



/**
 * Simple instance of a @Failure
 * 
 * Each major failure can be a subclass, especially, if it needs to contain 
 * information relevant to that failure
 * 
 * @author gaurav
 */
public class Failure extends Reportable {
	Throwable throwable = null;  // optional
	String message = null;

	public Failure(String message) {
		this.message = message;
	}
	
	public Failure(String message, Throwable t) {
		this.message = message;
		this.throwable = t;
	}

	@Override
	public void report() {
		// TODO Auto-generated method stub
		
	}

}
