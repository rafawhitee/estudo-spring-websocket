package br.com.estudo.spring.ws.dto;

import br.com.estudo.spring.ws.model.Chat;
import br.com.estudo.spring.ws.model.User;

public class CreateChatDTO {
	
	private Chat newChat;
	private User user;
	
	public Chat getNewChat() {
		return newChat;
	}
	public void setNewChat(Chat newChat) {
		this.newChat = newChat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
