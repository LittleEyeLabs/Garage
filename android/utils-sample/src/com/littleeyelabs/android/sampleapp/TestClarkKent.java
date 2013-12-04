package com.littleeyelabs.android.sampleapp;

import com.littleeyelabs.android.clarkkent.Event;
import com.littleeyelabs.android.clarkkent.Failure;
import com.littleeyelabs.android.clarkkent.Latency;

public class TestClarkKent {
	
	public static void reportEvent() {
		new Event("Download", "Starting download for book 1234").report();
		sleep(20);
		new Event("Download", "Paused download for book 1234").report();
		sleep(20);
		new Event("Download", "Resumed download for book 1234").report();
	}
	
	public static void reportFailure() {
		new Failure("Download",  "Error getting content-length").report();
	}

	public static void reportLatency() {
		Latency latency = new Latency("Download", "Sleep for 1 second");
		sleep(1000);
		latency.report();
	}
	
	private static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}


}





