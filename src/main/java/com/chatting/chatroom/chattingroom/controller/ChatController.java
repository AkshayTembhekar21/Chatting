package com.chatting.chatroom.chattingroom.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.chatting.chatroom.chattingroom.model.ChatMessage;

@Controller
public class ChatController {

	@GetMapping("/")
    public String index(Model model) {
        return "index"; // Thymeleaf will look for src/main/resources/templates/index.html
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }
	
}
