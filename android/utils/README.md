Little Eye Utils
================

Some common capabilities that android developers can take advantage of.

Logger: A wrapper around android.util.log
- Supports changing log levels based on debug/release
- Supports writing to a file on disk (as well as logcat), which can be uploaded later.


ClarkKent: A mild-mannered reporter
- Supports reporting of events, failures and latencies.
- These can be reported to services such as Parse, Google Analytics, Crittercism, Crashlytics, etc
- Configure different instances of the services for Production and Dev versions of your app
- Easily migrate to a different service with a few lines of code.
- Designed to work in offline mode, and to use the network/battery efficiently

PeterParker: A library to take screenshots (Coming soon...)





TODOs:

Logger:
- Rollover of disk logfile
- When writing to separate logfile, format the log nicely
- Write exception stack in the logfile
- Allow user to upload this log file to a simple REST service
- Use varargs to prevent unnecessary string creation

ClarkKent:
- Think about what a user-defined Event/Failure/Latency would look like.  How to specify custom fields?
- Implement Reporter for GoogleAnalytics
- Infrastructure for a Reporter to persist to disk (offline mode)
- Infrastructure for a Reporter to batch up reportables (use network efficiently)
- Write exception stack to Parse


