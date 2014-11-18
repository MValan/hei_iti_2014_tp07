package hei.tp07.controller;

import java.io.IOException;

import hei.tp07.front.data.Slide;

import javax.websocket.DecodeException;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SlideEncoder implements Encoder.Text<Slide> {

	private ObjectMapper mapper;

	@Override
	public void destroy() {

	}

	@Override
	public void init(EndpointConfig arg0) {
		mapper = new ObjectMapper();
	}

	@Override
	public String encode(Slide slide) throws EncodeException {
		try {
			return mapper.writeValueAsString(slide);
		} catch (IOException e) {
			return e.getMessage();
		}
	}

}
