package com.andersen_trainee.messenger.dao;

import java.util.HashMap;
import java.util.Map;

import com.andersen_trainee.messenger.model.Message;

public class MessengerDBEmulation {

	private static Map<Integer, Message> messages = new HashMap<Integer, Message>();

	public static Map<Integer, Message> getMessages() {
		return messages;
	}

}
