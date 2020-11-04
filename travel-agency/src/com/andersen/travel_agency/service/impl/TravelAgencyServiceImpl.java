package com.andersen.travel_agency.service.impl;

import com.andersen.travel_agency.dao.DAOException;
import com.andersen.travel_agency.dao.DAOProvider;
import com.andersen.travel_agency.dao.TravelAgencyDAO;
import com.andersen.travel_agency.entity.Order;
import com.andersen.travel_agency.entity.Tour;
import com.andersen.travel_agency.service.ServiceException;
import com.andersen.travel_agency.service.TravelAgencyService;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class TravelAgencyServiceImpl implements TravelAgencyService {
    @Override
    public List<Tour> getAllTours() throws ServiceException {
        DAOProvider daoProvider = DAOProvider.getInstance();
        TravelAgencyDAO travelAgencyDAO = daoProvider.getTravelAgencyDAO();

        List<Tour> tours = null;

        try {
            tours = travelAgencyDAO.getAllTours();

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

    @Override
    public Order showOrder(String passport) throws ServiceException {
        DAOProvider daoProvider = DAOProvider.getInstance();
        TravelAgencyDAO travelAgencyDAO = daoProvider.getTravelAgencyDAO();

        Order order = null;

        try {
            if (Objects.isNull(passport)) {
                throw new ServiceException("enter your passport id");
            } else {

                order = travelAgencyDAO.showMyOrder(passport);
            }

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());

        }

        return order;
    }

    @Override
    public int updateOrder(String passport, int tourId) throws ServiceException {
        DAOProvider daoProvider = DAOProvider.getInstance();
        TravelAgencyDAO travelAgencyDAO = daoProvider.getTravelAgencyDAO();

        int update = 0;

        try {
            if (validateUpdate(passport, tourId)) {
                throw new ServiceException("wrong data");
            } else {
                update = travelAgencyDAO.updateOrder(passport, tourId);
            }

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());

        }

        return update;
    }

    private boolean validate(String firstName, String lastName, String passport) {

        return Stream.of(firstName, lastName, passport).anyMatch(Objects::isNull);
    }

    private boolean validateUpdate(String passport, int tourId) {

        return ((Objects.isNull(passport) || tourId <= 0) ? true : false);
    }
}
