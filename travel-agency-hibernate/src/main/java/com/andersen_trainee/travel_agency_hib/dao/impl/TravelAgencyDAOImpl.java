package com.andersen_trainee.travel_agency_hib.dao.impl;

import com.andersen_trainee.travel_agency_hib.dao.DAOException;
import com.andersen_trainee.travel_agency_hib.dao.TravelAgencyDAO;
import com.andersen_trainee.travel_agency_hib.dao.config.HibernateConfig;
import com.andersen_trainee.travel_agency_hib.model.Review;
import com.andersen_trainee.travel_agency_hib.model.Tour;
import com.andersen_trainee.travel_agency_hib.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TravelAgencyDAOImpl implements TravelAgencyDAO {
    @Override
    public List<Tour> getAllTours() throws DAOException {
        Transaction transaction = null;
        List<Tour> tours = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<Tour> query = session.createQuery("from Tour", Tour.class);

            tours = query.getResultList();

            transaction.commit();

        } catch (Exception e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new DAOException(e.getMessage());
        }

        return tours;
    }

    @Override
    public void makeAnOrder(String firstName, String lastName, String passport, int tourId) throws DAOException {
        Transaction transaction = null;

        User user = new User(firstName, lastName, passport);

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Tour tour = session.get(Tour.class, tourId);

            user.getTours().add(tour);

            session.save(user);

            transaction.commit();

        } catch (Exception e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    public void updateAnOrder(String passport, int tourId) throws DAOException {
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();
            Tour tour = session.get(Tour.class, tourId);
            user.getTours().add(tour);

            transaction.commit();

        } catch (Exception e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    public Set<Tour> showOrdersByUserPassport(String passport) throws DAOException {
        Transaction transaction = null;
        Set<Tour> tours = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();

            Hibernate.initialize(user.getTours());

            tours = user.getTours();

            transaction.commit();

        } catch (Exception e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new DAOException(e.getMessage());
        }

        return tours;
    }

    @Override
    public void deleteTourFromTheOrderByUserPassport(String passport, int tourId) throws DAOException {
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();

            user.getTours().remove(session.get(Tour.class, tourId));

            transaction.commit();

        } catch (Exception e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void leaveReviewByUserPassport(String passport, String review) throws DAOException {
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = session.createQuery("from User where passport = :passport", User.class).setParameter("passport", passport).getSingleResult();

            Review r = new Review(review);
            r.setUser(user);

            session.save(r);

            transaction.commit();

        } catch (Exception e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new DAOException(e.getMessage());
        }


    }
}
