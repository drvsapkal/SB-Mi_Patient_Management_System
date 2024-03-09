package com.hospital.response_result;

public class ResponseResult {
	 
	private boolean result;
	    private String message;

	    // Constructor, getters, and setters
	    public ResponseResult(boolean result, String message) {
	        this.result = result;
	        this.message = message;
	    }

	    public boolean isResult() {
	        return result;
	    }

	    public void setResult(boolean result) {
	        this.result = result;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
}
