package com.andersen.travel_agency.service;

import com.andersen.travel_agency.service.impl.TravelAgencyServiceImpl;

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
