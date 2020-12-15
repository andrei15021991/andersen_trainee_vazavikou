package com.andersen_trainee.service;

import com.andersen_trainee.dao.TravelAgencyDAO;
import com.andersen_trainee.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("service")
public class TravelAgencyServiceImpl implements TravelAgencyService {

    @Autowired
    private TravelAgencyDAO travelAgencyDAO;


    @Override
    @Transactional
    public List<Tour> getAllTours() {
        return travelAgencyDAO.getAllTours();
    }

    @Override
    @Transactional
    public void makeAnOrder(String firstName, String lastName, String passport, int tourId) {
        travelAgencyDAO.makeAnOrder(firstName, lastName, passport, tourId);
    }

    @Override
    @Transactional
    public void updateAnOrder(String passport, int tourId) {
        travelAgencyDAO.updateAnOrder(passport, tourId);
    }

    @Override
    @Transactional
    public Set<Tour> showOrdersByUserPassport(String passport) {
        return travelAgencyDAO.showOrdersByUserPassport(passport);
    }

    @Override
    @Transactional
    public void deleteTourFromTheOrderByUserPassport(String passport, int tourId) {
        travelAgencyDAO.deleteTourFromTheOrderByUserPassport(passport, tourId);
    }

    @Override
    @Transactional
    public void leaveReviewByUserPassport(String passport, String review) {
        travelAgencyDAO.leaveReviewByUserPassport(passport, review);
    }
}
