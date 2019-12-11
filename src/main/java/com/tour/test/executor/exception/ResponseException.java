package com.tour.test.executor.exception;

import com.tour.logger.CustomLogger;

public class ResponseException extends Exception{

	private static final CustomLogger LOGGER = new CustomLogger(ResponseException.class);
	
	private static final long serialVersionUID = 1;

	private String message = null;
	 
	    public ResponseException() {
	        super();
	    }
	 
	    public ResponseException(String message) {
	        super(message);
	        LOGGER.error(message);
	    }
	    
	    
	    public ResponseException(Throwable cause) {
	        super(cause);
	    }
	 
	    public ResponseException(String result, Exception e) {
	    	if(e.getMessage().contains("Content is not allowed in prolog.")){
	    		LOGGER.error(" Please check the response : " +result);
	    	}else{
	    		LOGGER.error(e.getMessage());
	    	}
	    }

		@Override
	    public String toString() {
	        return message;
	    }
	 
	    @Override
	    public String getMessage() {
	        return message;
	    }
}
