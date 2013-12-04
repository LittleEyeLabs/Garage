package com.littleeyelabs.android.clarkkent;


/**
 * This is the base implementation for each reportable object
 * 
 * The reportable will return a set of key-value pairs.
 * App developers can create their own reportables
 * 
 * @author gaurav
 */
abstract class Reportable {
	/**
	 * Each @Reportable type can define categories.
	 */
	String category;
	
	/**
	 * The actual event/failure/latency
	 */
	String name;
	
	/**
	 * What time this was reported in the app
	 */
	long creationTime;

	public Reportable(String category, String name) {
		this.category = category;
		this.name = name;
		creationTime = System.currentTimeMillis();
	}
	
	public abstract void report();
}
