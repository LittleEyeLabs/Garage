package com.littleeyelabs.android.clarkkent;

import java.util.Date;
import java.util.Map;

/**
 * This is the base implementation for each reportable object
 * 
 * The reportable will return a set of key-value pairs.
 * App developers can create their own reportables
 * 
 * @author gaurav
 */
abstract class Reportable {
	private final static String GENERIC = "Generic";
	/**
	 * The type of @Reportable
	 */
	String category;
	
	/**
	 * When this was reported on the app
	 */
	long creationTime;

	public Reportable() {
		this.category = GENERIC;
		creationTime = new Date().getTime();
	}

	public Reportable(String category) {
		this.category = category;
		creationTime = new Date().getTime();
	}
	
	public abstract void report();
}
