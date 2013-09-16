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
	String Name;
	long creationTime;
	
	public Reportable(String name) {
		Name = name;
		creationTime = new Date().getTime();
	}
	

	public String getName() {
		return Name;
	}

	public long getCreatedAt() {
		return creationTime;
	}
	
	public abstract Object getData();
}
