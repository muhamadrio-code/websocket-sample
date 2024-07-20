package com.reeo.websocket.chat;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ChatMessage {
  public String content;
  public String sender;
  public MessageType type;
}
