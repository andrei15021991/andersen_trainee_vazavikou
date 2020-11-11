package com.andersen_trainee.travel_agency_servlet.dao;

import com.andersen_trainee.travel_agency_servlet.dao.impl.TravelAgencyDAOImpl;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	private TravelAgencyDAO travelAgencyDAO = new TravelAgencyDAOImpl();

	private DAOProvider() {

	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public TravelAgencyDAO getTravelAgencyDAO() {
		return travelAgencyDAO;
	}

}
