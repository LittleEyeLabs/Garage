package com.littleeyelabs.android.clarkkent;


public class Event extends Reportable {
	private final static String DEFAULT = "Event";

	public Event(String name) {
		super(DEFAULT);
	}

	@Override
	public void report() {
		EventService.report(this);
	}

}
