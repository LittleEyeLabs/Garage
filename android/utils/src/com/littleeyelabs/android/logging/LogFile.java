package com.littleeyelabs.android.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import android.content.Context;
import android.util.Log;

/**
 * Initialize this for logs to be written to a local file too
 * 
 * TODO: Limit file size (wraparound / use new file)
 * TODO: Profile performance difference between this and BufferWriter-FileWriter
 * 
 * @author gaurav lochan
 */
public class LogFile {
	public final static String TAG = "LogFile";
	private final PrintStream printStream;

	// Configuration
	public final static String FILE_NAME = "log.txt";
	public final static Folder WHERE_TO_WRITE = Folder.SD_CARD; 
	public final static boolean APPEND = false;
	
	int ACCESS_MODE = Context.MODE_PRIVATE; // | MODE_APPEND
	
	/**
	 * Initialize logging to a local file. Can return null if this failed.
	 * 
	 * @param context
	 * @param folderType
	 * @return
	 */
	public static LogFile initialize(Context context) {
		FileOutputStream fos;
		
		switch (WHERE_TO_WRITE) {
		case APP_DIR:
			try {
				int mode = (APPEND) ? Context.MODE_APPEND : Context.MODE_PRIVATE;
				fos = context.openFileOutput(FILE_NAME, mode);
			} catch (FileNotFoundException e1) {
				return null;
			}
			break;
		case SD_CARD:
			File sdFile = new File(context.getExternalFilesDir(null), FILE_NAME);
			Log.i(TAG, "app_dir = "+ sdFile.getAbsolutePath());

			try {
				fos = new FileOutputStream(sdFile, APPEND);
			} catch (FileNotFoundException e) {
				Log.e(TAG, "Can't write to SD Card.  Check for WRITE_EXTERNAL_STORAGE permission");
				return null;
			}
			break;
		default:
			return null;
		}
		
	    PrintStream printStream = new PrintStream(fos);
	    LogFile logFile = new LogFile(printStream);
	    Logger.setLogFile(logFile);
		return logFile;
	}
	

	public LogFile(PrintStream printStream) {
		this.printStream = printStream;
	}

	public void log(int level, String tag, String msg) {
		printStream.println(String.format("(%d) %s %s", level, tag, msg));
	}

	// TODO: Fix the logging format
	public void log(int level, String tag, String msg, Throwable tr) {
		if ((tr == null) || (tr.getMessage() == null)) {
			printStream.println(String.format("(%d) %s %s", level, tag, msg));
		} else {
			printStream.println(String.format("(%d) %s %s %s", level, tag, msg, tr.getMessage()));
		}
	}
	
}
