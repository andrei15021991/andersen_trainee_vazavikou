package com.andersen_trainee.service;

import com.andersen_trainee.model.Tour;

import java.util.List;
import java.util.Set;

public interface TravelAgencyService {
    List<Tour> getAllTours();

    void makeAnOrder(String firstName, String lastName, String passport, int tourId);

    void updateAnOrder(String passport, int tourId);

    Set<Tour> showOrdersByUserPassport(String passport);

    void deleteTourFromTheOrderByUserPassport(String passport, int tourId);

    void leaveReviewByUserPassport(String passport, String review);
}
