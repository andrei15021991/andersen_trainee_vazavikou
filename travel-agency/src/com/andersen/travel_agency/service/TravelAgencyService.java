package com.andersen.travel_agency.service;

import com.andersen.travel_agency.entity.Order;
import com.andersen.travel_agency.entity.Tour;

import java.util.List;

public interface TravelAgencyService {
    List<Tour> getAllTours() throws ServiceException;

    int makeOrder(String firstName, String lastName, String passport, int tourId) throws ServiceException;

    Order showOrder(String passport) throws ServiceException;

    int updateOrder(String passport, int tourId) throws ServiceException;
}
