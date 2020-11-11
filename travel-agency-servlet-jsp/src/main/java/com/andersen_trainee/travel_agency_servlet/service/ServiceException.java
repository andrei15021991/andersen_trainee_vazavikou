package com.andersen_trainee.travel_agency_servlet.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 691301930476206458L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

}
