package com.littleeyelabs.android.sampleapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.littleeyelabs.android.logging.Folder;
import com.littleeyelabs.android.logging.LogFile;
import com.littleeyelabs.android.logging.Logger;

public class MainActivity extends Activity {

	Button button1;
	Button button2;
	TextView textView;
	int count = 0;
	LogFile file;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setText("Log "+count);

		button2 = (Button) findViewById(R.id.button2);
		button2.setText("View Log");
		
		textView = (TextView) findViewById(R.id.textView1);

		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Logger.Info("Main", "count = "+count);
				textView.setText("Logged count");
				count++;
				button1.setText("Log "+count);
			}
		});
		
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				textView.setText(getLogs());
			}
		});
		
		file = LogFile.initialize(this, Folder.APP_DIR);
	}

	// Test function
	public String getLogs() {
		FileInputStream fis;
		try {
			fis = openFileInput("log.txt");
		} catch (FileNotFoundException e) {
			return null;
		}
		StringBuffer fileContent = new StringBuffer();
		
		byte[] buffer = new byte[1024];
		try {
			while (fis.read(buffer) != -1) {
			    fileContent.append(new String(buffer));
			}
		} catch (IOException e) {
		}
		return fileContent.toString();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
