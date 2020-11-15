package com.andersen_trainee.travel_agency_hib.view;

import com.andersen_trainee.travel_agency_hib.dao.DAOException;
import com.andersen_trainee.travel_agency_hib.dao.DAOProvider;
import com.andersen_trainee.travel_agency_hib.dao.TravelAgencyDAO;
import com.andersen_trainee.travel_agency_hib.model.Tour;

public class Main {
    public static void main(String[] args) throws DAOException {
        DAOProvider daoProvider = DAOProvider.getINSTANCE();
        TravelAgencyDAO travelAgencyDAO = daoProvider.getTravelAgencyDAO();


    }
}
