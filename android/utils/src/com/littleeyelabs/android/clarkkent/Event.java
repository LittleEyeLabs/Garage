package com.littleeyelabs.android.clarkkent;

public class Event extends Reportable {
	String name;
	
	public Event(String category, String name) {
		super(category);
		this.name = name;
	}

	@Override
	public void report() {
		EventService.report(this);
	}

}
