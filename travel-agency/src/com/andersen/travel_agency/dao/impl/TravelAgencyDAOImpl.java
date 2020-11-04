package com.andersen.travel_agency.dao.impl;

import com.andersen.travel_agency.dao.DAOException;
import com.andersen.travel_agency.dao.TravelAgencyDAO;
import com.andersen.travel_agency.dao.cp.ConnectionPool;
import com.andersen.travel_agency.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.andersen.travel_agency.dao.DAOTool.*;

public class TravelAgencyDAOImpl implements TravelAgencyDAO {

    @Override
    public List<Tour> getAllTours() throws DAOException {
        List<Tour> tours = new ArrayList<>();

        Review review = null;
        Hotel hotel = null;
        Country country = null;
        Tour tour = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = ConnectionPool.getDataSource().getConnection();

            statement = connection.createStatement();

            resultSet = statement.executeQuery(LIST_TOUR);

            while (resultSet.next()) {
                review = new Review();
                review.setReview(resultSet.getString("review"));

                hotel = new Hotel();
                hotel.setStars(resultSet.getString("stars"));

                country = new Country();
                country.setName(resultSet.getString("country"));

                tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setTotalCoast(resultSet.getInt("coast"));
                tour.setReview(review);
                tour.setCountry(country);
                tour.setHotel(hotel);

                tours.add(tour);
            }


        } catch (SQLException e) {
            throw new DAOException(e.getMessage());

        } finally {
            ConnectionPool.closeConnection(connection, statement, resultSet);
        }

        return tours;
    }

    @Override
    public int makeOrder(String firstName, String lastName, String passport, int tourId) throws DAOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;

        int res = 0;

        try {
            connection = ConnectionPool.getDataSource().getConnection();
            connection.setAutoCommit(false);

            preparedStatement1 = connection.prepareStatement(MAKE_ORDER_USER);

            preparedStatement1.setString(1, firstName);
            preparedStatement1.setString(2, lastName);
            preparedStatement1.setString(3, passport);

            int prs1 = preparedStatement1.executeUpdate();

            preparedStatement2 = connection.prepareStatement(MAKE_ORDER);

            preparedStatement2.setInt(1, tourId);
            preparedStatement2.setString(2, passport);

            int prs2 = preparedStatement2.executeUpdate();

            connection.commit();

            res = prs1 + prs2;

        } catch (SQLException e) {
            if (Objects.nonNull(connection)) {
                connection.rollback();
            }

            throw new DAOException(e.getMessage());

        } finally {
            ConnectionPool.closeConnection(connection, preparedStatement1, preparedStatement2);

        }

        return res;
    }

    @Override
    public Order showMyOrder(String passport) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Order order = null;
        User user = null;
        Tour tour = null;
        Country country = null;
        Hotel hotel = null;

        try {
            connection = ConnectionPool.getDataSource().getConnection();

            preparedStatement = connection.prepareStatement(SHOW_ORDER);
            preparedStatement.setString(1, passport);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hotel = new Hotel();
                hotel.setStars(resultSet.getString("stars"));

                country = new Country();
                country.setName(resultSet.getString("name"));

                tour = new Tour();
                tour.setTotalCoast(resultSet.getInt("total_coast"));
                tour.setHotel(hotel);
                tour.setCountry(country);

                user = new User();
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPassport(resultSet.getString("passport"));

                order = new Order();
                order.setTour(tour);
                order.setUser(user);
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());

        } finally {
            ConnectionPool.closeConnection(connection, preparedStatement, resultSet);
        }

        return order;
    }

    @Override
    public int updateOrder(String passport, int tourId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int update = 0;

        try {
            connection = ConnectionPool.getDataSource().getConnection();

            preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setInt(1, tourId);
            preparedStatement.setString(2, passport);

            update = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());

        } finally {
            ConnectionPool.closeConnection(connection, preparedStatement);

        }

        return update;
    }


}
