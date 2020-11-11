package com.andersen_trainee.travel_agency_servlet.service;

import java.util.List;

import com.andersen_trainee.travel_agency_servlet.entity.Tour;

public interface TravelAgencyService {
	List<Tour> allTours() throws ServiceException;

	int makeOrder(String firstName, String lastName, String passport, int tourId) throws ServiceException;

}
