package hei.tp07.controller;

import hei.tp07.front.data.Singleton;
import hei.tp07.front.data.Slide;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/control", decoders = { SlideDecoder.class }, encoders = { SlideEncoder.class })
public class WebSocketController {

	@OnMessage
	public void chat(Slide slide, Session session) throws IOException {
		System.out.println("dans procédure");
		for (Session s : session.getOpenSessions()) {
			if (s.isOpen()) {
				Singleton.getInstance().setSlide(slide);
				send(slide, s);
			}
		}
	}

	@OnOpen
	public void init(Session session) {
		send(Singleton.getInstance().getSlide(), session);
	}

	private void send(Slide slide, Session session) {

		try {
			session.getBasicRemote().sendObject(slide);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
