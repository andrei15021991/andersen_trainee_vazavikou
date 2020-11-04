package com.andersen.travel_agency.dao;

import com.andersen.travel_agency.entity.Order;
import com.andersen.travel_agency.entity.Tour;

import java.sql.SQLException;
import java.util.List;

public interface TravelAgencyDAO {

    List<Tour> getAllTours() throws DAOException;

    int makeOrder(String firstName, String lastName, String passport, int tourId) throws DAOException, SQLException;

    Order showMyOrder(String passport) throws DAOException;

    int updateOrder(String passport, int tourId) throws DAOException;
}
