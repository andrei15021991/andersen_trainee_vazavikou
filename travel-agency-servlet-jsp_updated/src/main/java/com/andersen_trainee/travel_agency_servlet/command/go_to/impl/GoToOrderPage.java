package com.andersen_trainee.travel_agency_servlet.command.go_to.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andersen_trainee.travel_agency_servlet.command.Command;

public class GoToOrderPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("tourId"));

		HttpSession session = request.getSession(true);
		session.setAttribute("tour_id", id);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/order_page.jsp");
		requestDispatcher.forward(request, response);

	}

}
