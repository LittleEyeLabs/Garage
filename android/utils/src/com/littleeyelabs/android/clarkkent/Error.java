package com.littleeyelabs.android.clarkkent;


public class Error extends Reportable {
	private final static String DEFAULT = "Error";
	Throwable throwable;

	public Error() {
		super(DEFAULT);
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

}
