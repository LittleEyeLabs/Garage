package com.littleeyelabs.android.clarkkent;

import java.util.Date;

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
	 * What time this was reported in the app
	 */
	long creationTime;

	public Reportable(String category) {
		this.category = category;
		creationTime = new Date().getTime();
	}
	
	public abstract void report();
}
