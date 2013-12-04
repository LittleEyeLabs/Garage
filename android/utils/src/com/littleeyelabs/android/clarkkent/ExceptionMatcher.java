package com.littleeyelabs.android.clarkkent;

import java.util.HashMap;

/**
 * This class tries to prevent duplicate exceptions being reported
 * Uses a HashMap to keep track of previously reported exceptions.
 * 
 * @author gaurav
 */
class ExceptionMatcher {

	final static long STALE_THRESHHOLD = 1800 * 1000; // 30 minutes
	
	// Keep track of exception that have been triggered from a particular location
	// Technically we would use a HashSet but a HashMap is actually faster!
	HashMap<String, Long> map;
	
	public ExceptionMatcher() {
		map = new HashMap<String, Long>();
	}

	boolean isWorthReporting(Exception e, String className, String location) {
		String key = e.getClass().getName() + '@' + className + location;
		Long currentTime = System.currentTimeMillis();

		if (!map.containsKey(key)) {
			map.put(key, currentTime);
			return true;
		} else {
			Long lastTimeStamp = map.get(key);

			// If the exception was not reported in the last 30 mins, then report it
			if (currentTime - lastTimeStamp > STALE_THRESHHOLD) {
				// update the timestamp for this key
				map.put(key, currentTime);
				return true;
			}
			return false;
		}
	}
}
