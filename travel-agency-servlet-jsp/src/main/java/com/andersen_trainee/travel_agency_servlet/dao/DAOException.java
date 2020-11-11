package com.andersen_trainee.travel_agency_servlet.dao;

public class DAOException extends Exception {
	private static final long serialVersionUID = -7079183441905834537L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}

}
