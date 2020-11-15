package com.andersen_trainee.travel_agency_hib.dao;

import com.andersen_trainee.travel_agency_hib.model.Tour;
import com.andersen_trainee.travel_agency_hib.model.User;

import java.util.List;
import java.util.Set;

public interface TravelAgencyDAO {
    List<Tour> getAllTours() throws DAOException;

    void makeAnOrder(String firstName, String lastName, String passport, int tourId) throws DAOException;

    void updateAnOrder(String passport, int tourId) throws DAOException;

    Set<Tour> showOrdersByUserPassport(String passport) throws DAOException;

    void deleteTourFromTheOrderByUserPassport(String passport, int tourId) throws DAOException;

    void leaveReviewByUserPassport(String passport, String review) throws DAOException;
}
