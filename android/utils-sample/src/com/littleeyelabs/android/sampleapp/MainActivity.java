package com.littleeyelabs.android.sampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.littleeyelabs.android.clarkkent.ClarkKentConfiguration;
import com.littleeyelabs.android.logging.LogFile;
import com.littleeyelabs.android.logging.Logger;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";

	Button button1;
	Button button2;
	
	Button buttonEvent, buttonFailure, buttonLatency;
	
	TextView textView;
	int count = 0;
	LogFile file;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buttonEvent = (Button) findViewById(R.id.button_event);
		buttonFailure = (Button) findViewById(R.id.button_failure);
		buttonLatency = (Button) findViewById(R.id.button_latency);
		
		buttonEvent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				TestClarkKent.reportEvent();
			}
		});
		
		buttonFailure.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				TestClarkKent.reportFailure();
				
			}
		});

		buttonLatency.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				TestClarkKent.reportLatency();
			}
		});


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
				textView.setText(TestLogger.getLogs(MainActivity.this));
			}
		});
	
		// Initialize logging to file
		file = LogFile.initialize(this);
		
		// Initialize ClarkKent
		ClarkKentConfiguration.initialize(getApplicationContext(), BuildConfig.DEBUG);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
