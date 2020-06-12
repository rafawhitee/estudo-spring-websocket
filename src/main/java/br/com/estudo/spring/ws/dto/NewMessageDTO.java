package br.com.estudo.spring.ws.dto;

import br.com.estudo.spring.ws.model.Chat;
import br.com.estudo.spring.ws.model.ChatMessage;

public class NewMessageDTO {

	private Chat currentChat;
	private ChatMessage newChatMessage;
	
	public Chat getCurrentChat() {
		return currentChat;
	}
	public void setCurrentChat(Chat currentChat) {
		this.currentChat = currentChat;
	}
	public ChatMessage getNewChatMessage() {
		return newChatMessage;
	}
	public void setNewChatMessage(ChatMessage newChatMessage) {
		this.newChatMessage = newChatMessage;
	}

}
