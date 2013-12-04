package com.littleeyelabs.android.sampleapp;

import com.littleeyelabs.android.clarkkent.Event;
import com.littleeyelabs.android.clarkkent.Failure;
import com.littleeyelabs.android.clarkkent.Latency;

public class TestClarkKent {
	
	public static void reportEvent() {
		new Event("Download", "Starting download for book 1234").report();
	}
	
	public static void reportFailure() {
		new Failure("Download",  "Error getting content-length").report();
	}

	public static void reportLatency() {
		Latency latency = new Latency("downloadBook");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			latency.report();
		}
	}


}





