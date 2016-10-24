package com.jensonjo.jaxrs.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jensonjo.jaxrs.messenger.database.DatabaseClass;
import com.jensonjo.jaxrs.messenger.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Jenson"));
		messages.put(2L, new Message(2, "REST", "Jenson"));
	}

	public List<Message> getAllMessages() {
		// Message m1 = new Message(1, "Hello World", "Jenson");
		// Message m2 = new Message(1, "Hello Jersey", "Jenson");
		// ArrayList<Message> list = new ArrayList<>();
		// list.add(m1);
		// list.add(m2);
		// return list;
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return messages.get(message);
	}

	public Message updateMessage(Message message) {
		messages.put(message.getId(), message);
		return messages.get(message.getId());
	}
}
