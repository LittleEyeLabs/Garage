package com.littleeyelabs.android.sampleapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.content.Context;

import com.littleeyelabs.android.logging.Folder;
import com.littleeyelabs.android.logging.LogFile;

public class TestLogger {
	
	public static String getLogs(Context context) {
		FileInputStream fis;
		
		try {
			if (LogFile.WHERE_TO_WRITE == Folder.APP_DIR) {
				fis = context.openFileInput(LogFile.FILE_NAME);
			} else {
				File sdFile = new File(context.getExternalFilesDir(null), LogFile.FILE_NAME);
				fis = new FileInputStream(sdFile);
			}
		} catch (FileNotFoundException e) {
			return null;
		}
		StringBuffer fileContent = new StringBuffer();
		fileContent.append("Folder = " + LogFile.WHERE_TO_WRITE + "\n");
		
		byte[] buffer = new byte[1024];
		try {
			while (fis.read(buffer) != -1) {
			    fileContent.append(new String(buffer));
			}
		} catch (IOException e) {
		}
		return fileContent.toString();
	}
	

}
