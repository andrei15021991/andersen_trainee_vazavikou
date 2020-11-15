package com.andersen_trainee.travel_agency_hib.dao;

import com.andersen_trainee.travel_agency_hib.dao.impl.TravelAgencyDAOImpl;

public final class DAOProvider {
    private static final DAOProvider INSTANCE = new DAOProvider();
    private TravelAgencyDAO travelAgencyDAO = new TravelAgencyDAOImpl();

    private DAOProvider() {

    }

    public static DAOProvider getINSTANCE() {
        return INSTANCE;
    }

    public TravelAgencyDAO getTravelAgencyDAO() {
        return travelAgencyDAO;
    }
}
