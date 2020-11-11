package com.andersen_trainee.travel_agency_servlet.service;

import com.andersen_trainee.travel_agency_servlet.service.impl.TravelAgencyServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	private TravelAgencyService travelAgencyService = new TravelAgencyServiceImpl();

	private ServiceProvider() {

	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public TravelAgencyService getTravelAgencyService() {
		return travelAgencyService;
	}

}
