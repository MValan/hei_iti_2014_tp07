package hei.tp07.controller;

import java.io.IOException;

import hei.tp07.front.data.Slide;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SlideDecoder implements Decoder.Text<Slide> {

	private ObjectMapper mapper;

	@Override
	public void destroy() {

	}

	@Override
	public void init(EndpointConfig arg0) {
		mapper = new ObjectMapper();
	}

	@Override
	public Slide decode(String json) throws DecodeException {
		try {
			return mapper.readValue(json, Slide.class);
		} catch (IOException e) {
			throw new DecodeException(json, "Impossible à decoder", e);
		}
	}

	@Override
	public boolean willDecode(String arg0) {
		return true;
	}

}
