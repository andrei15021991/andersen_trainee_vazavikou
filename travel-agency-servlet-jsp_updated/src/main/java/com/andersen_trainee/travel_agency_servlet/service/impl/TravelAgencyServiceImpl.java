package com.andersen_trainee.travel_agency_servlet.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.andersen_trainee.travel_agency_servlet.dao.DAOException;
import com.andersen_trainee.travel_agency_servlet.dao.DAOProvider;
import com.andersen_trainee.travel_agency_servlet.dao.TravelAgencyDAO;
import com.andersen_trainee.travel_agency_servlet.entity.Tour;
import com.andersen_trainee.travel_agency_servlet.service.ServiceException;
import com.andersen_trainee.travel_agency_servlet.service.TravelAgencyService;

public class TravelAgencyServiceImpl implements TravelAgencyService {

	@Override
	public List<Tour> allTours() throws ServiceException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		TravelAgencyDAO travelAgencyDAO = daoProvider.getTravelAgencyDAO();

		List<Tour> tours = null;

		try {
			tours = travelAgencyDAO.allTours();

			if (Objects.isNull(tours)) {
				throw new ServiceException("error connecting the database");
			}

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

		return tours;

	}

	@Override
	public int makeOrder(String firstName, String lastName, String passport, int tourId) throws ServiceException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		TravelAgencyDAO travelAgencyDAO = daoProvider.getTravelAgencyDAO();

		int res = 0;

		try {
			if (validate(firstName, lastName, passport) || tourId <= 0) {
				throw new ServiceException("wrong data");

			} else {
				res = travelAgencyDAO.makeOrder(firstName, lastName, passport, tourId);

			}

		} catch (DAOException | SQLException e) {
			throw new ServiceException(e.getMessage());
		}

		return res;
	}

	private boolean validate(String firstName, String lastName, String passport) {

		return Stream.of(firstName, lastName, passport).anyMatch(Objects::isNull);
	}

}
