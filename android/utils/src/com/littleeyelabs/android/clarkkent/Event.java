package com.littleeyelabs.android.clarkkent;

public class Event extends Reportable {
	public Event(String category, String name) {
		super(category, name);
	}

	@Override
	public void report() {
		EventService.report(this);
	}

}
