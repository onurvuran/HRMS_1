package com.hrms.hrms.core.abstracts.utilities.result;

public class Result {

	private boolean success;
	private String message;

	public Result(boolean success) {

		this.success = success;

	}

	public Result(boolean success, String message) {
		this(success);
		this.success = success;

	}

	public boolean isSucces() {
		return this.success;
	}

	public String getMessage() {
		return this.message;
	}

}
