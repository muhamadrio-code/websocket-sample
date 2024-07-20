package com.reeo.websocket.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
@Slf4j
public class ChatController {

  @MessageMapping("/chat.sendMessage")
  @SendTo("/topic/public")
  public ChatMessage sendMessage(
      @Payload ChatMessage chatMessage
  ) {
    log.info("Chat::" + chatMessage.toString());
    return chatMessage;
  }

  @MessageMapping("/chat.addUser")
  @SendTo("/topic/public")
  public ChatMessage addUser(
      @Payload ChatMessage chatMessage,
      SimpMessageHeaderAccessor headerAccessor
  ) {

    headerAccessor.getSessionAttributes()
        .put("username", chatMessage.getSender());
    log.info("username::" + chatMessage);
    return chatMessage;
  }
}
