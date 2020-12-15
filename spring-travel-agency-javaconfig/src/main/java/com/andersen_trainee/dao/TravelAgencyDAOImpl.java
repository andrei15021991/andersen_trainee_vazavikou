package com.andersen_trainee.dao;

import com.andersen_trainee.model.Review;
import com.andersen_trainee.model.Tour;
import com.andersen_trainee.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class TravelAgencyDAOImpl implements TravelAgencyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Tour> getAllTours() {
        Session session = sessionFactory.getCurrentSession();
        List<Tour> tours = null;
        Query<Tour> query = session.createQuery("from Tour", Tour.class);
        tours = query.getResultList();

        return tours;
    }

    @Override
    public void makeAnOrder(String firstName, String lastName, String passport, int tourId) {
        User user = new User(firstName, lastName, passport);
        Session session = sessionFactory.getCurrentSession();
        Tour tour = session.get(Tour.class, tourId);
        user.getTours().add(tour);
        session.save(user);
    }

    @Override
    public void updateAnOrder(String passport, int tourId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();
        Tour tour = session.get(Tour.class, tourId);
        user.getTours().add(tour);
    }

    @Override
    public Set<Tour> showOrdersByUserPassport(String passport) {
        Set<Tour> tours = null;
        Session session = sessionFactory.getCurrentSession();
        User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();
        Hibernate.initialize(user.getTours());
        tours = user.getTours();

        return tours;
    }

    @Override
    public void deleteTourFromTheOrderByUserPassport(String passport, int tourId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();
        user.getTours().remove(session.get(Tour.class, tourId));
    }

    @Override
    public void leaveReviewByUserPassport(String passport, String review) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();
        Review r = new Review(review);
        r.setUser(user);
        session.save(r);
    }
}
