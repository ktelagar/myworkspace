package com.cpc.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import com.cpc.dto.AwbNo;

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AppParamConverterProvider implements ParamConverterProvider {

	@Override
	public ParamConverter getConverter(Class rawType, Type genericType, Annotation[] annotations) {
		if (rawType.isAssignableFrom(AwbNo.class)) {
			return new AwbNoParamConverter();
		}
		return null;
	}

}
