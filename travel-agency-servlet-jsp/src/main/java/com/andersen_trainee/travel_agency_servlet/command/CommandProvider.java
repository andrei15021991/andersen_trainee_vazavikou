package com.andersen_trainee.travel_agency_servlet.command;

import java.util.HashMap;
import java.util.Map;

import com.andersen_trainee.travel_agency_servlet.command.go_to.impl.GoToMainPage;
import com.andersen_trainee.travel_agency_servlet.command.go_to.impl.GoToOrderPage;
import com.andersen_trainee.travel_agency_servlet.command.impl.MakeAnOrder;
import com.andersen_trainee.travel_agency_servlet.command.impl.ShowAllTours;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	public CommandProvider() {
		// go-to
		commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPage());
		commands.put(CommandName.GO_TO_ORDER_PAGE, new GoToOrderPage());
		// commands
		commands.put(CommandName.ALL_TOURS, new ShowAllTours());
		commands.put(CommandName.MAKE_AN_ORDER, new MakeAnOrder());

	}

	public Command getCommand(String name) {
		return commands.get(CommandName.valueOf(name.toUpperCase()));
	}

}
