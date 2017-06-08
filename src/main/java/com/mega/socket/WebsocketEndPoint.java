package com.mega.socket;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * socket 工具类
 * @author Andy.jia
 *
 */
public class WebsocketEndPoint extends TextWebSocketHandler{
	
	@Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      super.handleTextMessage(session, message);
      System.out.println("进入了工具类");
      TextMessage returnMessage = new TextMessage(message.getPayload()+" 后台的消息");
      session.sendMessage(returnMessage);
    }
}
