package com.andersen_trainee.travel_agency_servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.andersen_trainee.travel_agency_servlet.dao.DAOException;
import com.andersen_trainee.travel_agency_servlet.dao.DAOTool;
import com.andersen_trainee.travel_agency_servlet.dao.TravelAgencyDAO;
import com.andersen_trainee.travel_agency_servlet.dao.cp.ConnectionPool;
import com.andersen_trainee.travel_agency_servlet.entity.Country;
import com.andersen_trainee.travel_agency_servlet.entity.Hotel;
import com.andersen_trainee.travel_agency_servlet.entity.Review;
import com.andersen_trainee.travel_agency_servlet.entity.Tour;

public class TravelAgencyDAOImpl implements TravelAgencyDAO {

	@Override
	public List<Tour> allTours() throws DAOException {
		List<Tour> tours = new ArrayList<>();

		Review review = null;
		Hotel hotel = null;
		Country country = null;
		Tour tour = null;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = ConnectionPool.getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(DAOTool.LIST_TOUR);

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

		}finally {
			ConnectionPool.close(connection);
		}

		return tours;
	}

	@Override
	public int makeOrder(String firstName, String lastName, String passport, int tourId)
			throws DAOException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;

		int res = 0;

		try {
			connection = ConnectionPool.getConnection();
			connection.setAutoCommit(false);

			preparedStatement1 = connection.prepareStatement(DAOTool.MAKE_ORDER_USER);

			preparedStatement1.setString(1, firstName);
			preparedStatement1.setString(2, lastName);
			preparedStatement1.setString(3, passport);

			int prs1 = preparedStatement1.executeUpdate();

			preparedStatement2 = connection.prepareStatement(DAOTool.MAKE_ORDER);

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
		}finally {
			ConnectionPool.close(connection);
		}

		return res;
	}

}
