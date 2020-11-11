package com.andersen_trainee.travel_agency_servlet.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andersen_trainee.travel_agency_servlet.command.Command;
import com.andersen_trainee.travel_agency_servlet.entity.Tour;
import com.andersen_trainee.travel_agency_servlet.service.ServiceException;
import com.andersen_trainee.travel_agency_servlet.service.ServiceProvider;
import com.andersen_trainee.travel_agency_servlet.service.TravelAgencyService;

public class ShowAllTours implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		TravelAgencyService travelAgencyService = serviceProvider.getTravelAgencyService();

		List<Tour> tours = null;
		HttpSession session = null;

		try {
			tours = travelAgencyService.allTours();

			session = request.getSession();
			session.setAttribute("tours", tours);

			response.sendRedirect("TravelAgencyController?command=go_to_main_page");

		} catch (ServiceException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
