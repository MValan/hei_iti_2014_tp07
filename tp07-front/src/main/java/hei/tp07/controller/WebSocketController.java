package hei.tp07.controller;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value="/control")
public class WebSocketController {
	
	@OnMessage
    public void chat(String msg, Session session) throws IOException {
		System.out.println("dans procédure");
        for (Session s : session.getOpenSessions()) {
            if (s.isOpen()) {
                
            }
        }
    }
	
	
}
