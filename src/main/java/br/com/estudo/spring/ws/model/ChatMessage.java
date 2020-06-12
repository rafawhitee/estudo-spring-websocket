package br.com.estudo.spring.ws.model;

public class ChatMessage {

	private String content;
	private User user;


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
