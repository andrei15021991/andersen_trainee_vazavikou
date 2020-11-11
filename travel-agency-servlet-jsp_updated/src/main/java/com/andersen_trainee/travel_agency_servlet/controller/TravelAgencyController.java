package com.andersen_trainee.travel_agency_servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersen_trainee.travel_agency_servlet.command.Command;
import com.andersen_trainee.travel_agency_servlet.command.CommandProvider;

public class TravelAgencyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommandProvider commandProvider = new CommandProvider();

	public TravelAgencyController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = request.getParameter("command");

		Command command = commandProvider.getCommand(commandName);
		command.execute(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = request.getParameter("command");

		Command command = commandProvider.getCommand(commandName);
		command.execute(request, response);

	}

}
