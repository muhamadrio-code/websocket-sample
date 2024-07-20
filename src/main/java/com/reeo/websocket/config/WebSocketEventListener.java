package com.reeo.websocket.config;

import com.reeo.websocket.chat.ChatMessage;
import com.reeo.websocket.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener  {

  private final SimpMessageSendingOperations msgTemplate;

  @EventListener
  public void handleWebsocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
    String user = (String) accessor.getSessionAttributes().get("username");
    if (user != null) {
      log.info("user disconnected {}", user);
      ChatMessage chatMessage = ChatMessage.builder()
          .type(MessageType.LEAVE)
          .sender(user)
          .build();
      msgTemplate.convertAndSend("/topic/public", chatMessage);
    }
  }

}
