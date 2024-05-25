package com.cch.readers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import com.cch.dto.RechargeRequest;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;

@Consumes(MediaType.APPLICATION_JSON)
@Provider
public class JsonMessageBodyReader implements MessageBodyReader<Object> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		if (type.isAssignableFrom(RechargeRequest.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		System.out.println("readFrom(...)");
		Jsonb jsonb = JsonbBuilder.create();
		Object obj = jsonb.fromJson(entityStream, type);
		return obj;
	}

}
