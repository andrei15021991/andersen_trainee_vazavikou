package com.andersen_trainee.travel_agency_servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.andersen_trainee.travel_agency_servlet.entity.Tour;

public interface TravelAgencyDAO {
	List<Tour> allTours() throws DAOException;

	int makeOrder(String firstName, String lastName, String passport, int tourId) throws DAOException, SQLException;

}
