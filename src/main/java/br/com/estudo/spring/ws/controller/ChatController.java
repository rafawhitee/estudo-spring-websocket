package br.com.estudo.spring.ws.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import br.com.estudo.spring.ws.dto.CreateChatDTO;
import br.com.estudo.spring.ws.dto.NewMessageDTO;
import br.com.estudo.spring.ws.model.Chat;
import br.com.estudo.spring.ws.model.ChatMessage;

@Controller
public class ChatController {

	private SimpMessageHeaderAccessor headerAccessor;

	// Create a new Chat
	@MessageMapping("/chat.create")
	@SendTo("/topic/public")
	public Chat registerChat(@Payload CreateChatDTO createChatDto, SimpMessageHeaderAccessor headerAccessor) {
		Chat chat = createChatDto.getNewChat();
		if(chat != null) {
			checkHeaderAccessor(headerAccessor);
			boolean chatIdAlreadyExists = chatIdAlreadyExists(chat);
			if (chatIdAlreadyExists) {
	            Chat chatOnSession = getChatOnSessionAttributesById(chat);
	            chatOnSession.getUsers().add(createChatDto.getUser());
			} else {
				headerAccessor.getSessionAttributes().put(chat.getId().toString(), chat);
			}
		}
		return chat;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload NewMessageDTO newMessageDto) {
		Chat chat = newMessageDto.getCurrentChat();
		ChatMessage chatMessage = newMessageDto.getNewChatMessage();
		if (chat != null && chatMessage != null) {
			Chat chatOnSession = getChatOnSessionAttributesById(chat);
			if (chatOnSession != null) {
				chatOnSession.getMessages().add(chatMessage);
			}
		}
		return chatMessage;
	}

	private boolean chatIdAlreadyExists(Chat chat) {
		if (chat != null) {
			Chat chatOnSession = getChatOnSessionAttributesById(chat);
			if (chatOnSession != null)
				return true;

			return false;
		}
		return false;
	}

	private void checkHeaderAccessor(SimpMessageHeaderAccessor headerAccessor) {
		if (this.headerAccessor == null) {
			this.headerAccessor = headerAccessor;
		}
	}

	private Chat getChatOnSessionAttributesById(Chat chat) {
		if (chat != null) {
			Integer idChat = chat.getId();
			Chat currentChat = (Chat) headerAccessor.getSessionAttributes().get(idChat.toString());
			return currentChat;
		}
		return null;
	}

}