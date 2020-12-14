package com.andersen_trainee.dao;

import com.andersen_trainee.model.Review;
import com.andersen_trainee.model.Tour;
import com.andersen_trainee.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class TravelAgencyDAOImpl implements TravelAgencyDAO {
    private SessionFactory sessionFactory;

    public TravelAgencyDAOImpl() {

    }

    public TravelAgencyDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Tour> getAllTours() {
        List<Tour> tours = null;

        try (Session session = sessionFactory.openSession()) {
            Query<Tour> query = session.createQuery("from Tour", Tour.class);

            tours = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tours;
    }

    @Override
    public void makeAnOrder(String firstName, String lastName, String passport, int tourId) {
        User user = new User(firstName, lastName, passport);

        try (Session session = sessionFactory.openSession()) {

            Tour tour = session.get(Tour.class, tourId);

            user.getTours().add(tour);

            session.save(user);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void updateAnOrder(String passport, int tourId) {

        try (Session session = sessionFactory.openSession()) {
            User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();
            Tour tour = session.get(Tour.class, tourId);
            user.getTours().add(tour);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Set<Tour> showOrdersByUserPassport(String passport) {
        Set<Tour> tours = null;

        try (Session session = sessionFactory.openSession()) {
            User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();

            Hibernate.initialize(user.getTours());

            tours = user.getTours();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tours;
    }


    @Override
    public void deleteTourFromTheOrderByUserPassport(String passport, int tourId) {
        try (Session session = sessionFactory.openSession()) {

            User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();

            user.getTours().remove(session.get(Tour.class, tourId));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leaveReviewByUserPassport(String passport, String review) {
        try (Session session = sessionFactory.openSession()) {

            User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();

            Review r = new Review(review);
            r.setUser(user);

            session.save(r);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
