package com.andersen_trainee.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.andersen_trainee.messenger.dao.MessengerDBEmulation;
import com.andersen_trainee.messenger.model.Message;

public class MessageService {
	private Map<Integer, Message> messages = MessengerDBEmulation.getMessages();

	public MessageService() {
		messages.put(1, new Message(1, "Hello World", "some one"));
		messages.put(2, new Message(2, "Hello World", "some one else"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);

		return message;
	}

	public Message getMessageById(int id) {
		return messages.get(id);
	}

	public Message updateMessage(Message message) {
		Set<Integer> keys = messages.keySet();

		for (Integer key : keys) {
			if (message.getId() == key) {
				messages.put(message.getId(), message);

				return message;
			}
		}

		return null;
	}

	public void deleteMessage(int id) {
		messages.remove(id);
	}

}
