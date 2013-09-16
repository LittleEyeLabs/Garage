package com.littleeyelabs.android.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

// TODO: Limit file size
// TODO: Cache writes
public class LogFile {
	public final static String TAG = "LogFile";
	public final static String FILE_NAME = "log.txt";
	private final PrintStream printStream;
	
	/**
	 * Initialize logging to a local file. 
	 * 
	 * @param context
	 * @param folderType
	 * @return
	 */
	public static LogFile initialize(Context context, Folder folderType) {
		String baseDir = "";
		FileOutputStream fos;
		
		switch (folderType) {
		case APP_DIR:
			baseDir = context.getFilesDir().getAbsolutePath();
			Log.i(TAG, "app_dir = "+baseDir);
			try {
				fos = context.openFileOutput(FILE_NAME, Context.MODE_APPEND);
			} catch (FileNotFoundException e1) {
				return null;
			}
			break;
		case SD_CARD:
			// BUGGY
			// TODO: Deal with exceptions on particular devices
			baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
			Log.i(TAG, "app_dir = "+baseDir);
			File file = new File(baseDir + File.separator + FILE_NAME);
			file.mkdirs();
			if (!file.canWrite()) {
				return null;
			}
			try {
				fos = new FileOutputStream(file);
			} catch (FileNotFoundException e) {
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
		printStream.println(String.format("%d %s %s", level, tag, msg));
	}

	public void log(int level, String tag, String msg, Throwable tr) {
		if ((tr == null) || (tr.getMessage() == null)) {
			printStream.println(String.format("%d %s %s", level, tag, msg));
		} else {
			printStream.println(String.format("%d %s %s %s", level, tag, msg, tr.getMessage()));
		}
	}
	
}
