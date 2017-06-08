package com.mega.socket;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * 测试类
 * 
 * @author Andy.jia
 *
 */
@ServerEndpoint("/test")
public class TestWebSocket {

	@OnOpen
	public void onOpen(Session session) throws IOException {
		// 以下代码省略...
		System.out.println("onOpen");
	}

	@OnMessage
	public String onMessage(String message) {

		// 以下代码省略...
		System.out.println("onMessage");
		return message;
	}


	@OnError
	public void onError(Throwable t) {
		System.out.println("onError");
		// 以下代码省略...
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) {
		System.out.println("onClose");
		// 以下代码省略...
	}

}
