package br.com.estudo.spring.ws.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {

	private Integer id;
	private List<User> users;
	private List<ChatMessage> messages;
	
	public Chat() {
		users = new ArrayList<User>();
		messages = new ArrayList<ChatMessage>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ChatMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ChatMessage> messages) {
		this.messages = messages;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
