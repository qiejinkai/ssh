package com.qjk.ssh.exception;

public class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserException() {
		super();
	}
	
	public UserException(String message){
		super(message);
	}
	
	public UserException(String message,Throwable e){
		super(message, e);
	}

}
