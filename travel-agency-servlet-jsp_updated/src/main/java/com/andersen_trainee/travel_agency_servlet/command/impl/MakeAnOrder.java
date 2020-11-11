package com.andersen_trainee.travel_agency_servlet.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersen_trainee.travel_agency_servlet.command.Command;
import com.andersen_trainee.travel_agency_servlet.service.ServiceException;
import com.andersen_trainee.travel_agency_servlet.service.ServiceProvider;
import com.andersen_trainee.travel_agency_servlet.service.TravelAgencyService;

public class MakeAnOrder implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		TravelAgencyService travelAgencyService = serviceProvider.getTravelAgencyService();

		int id = Integer.parseInt(request.getParameter("t_id"));
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String passport = request.getParameter("passport");

		try {
			travelAgencyService.makeOrder(fName, lName, passport, id);

			response.sendRedirect("TravelAgencyController?command=go_to_main_page&report=order success");

		} catch (ServiceException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
