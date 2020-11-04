package com.andersen.travel_agency.dao;

import com.andersen.travel_agency.dao.impl.TravelAgencyDAOImpl;

public final class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();
    private TravelAgencyDAO travelAgencyDAO = new TravelAgencyDAOImpl();

    private DAOProvider(){

    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public TravelAgencyDAO getTravelAgencyDAO() {
        return travelAgencyDAO;
    }
}
