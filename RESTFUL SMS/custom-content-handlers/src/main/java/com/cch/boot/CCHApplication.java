package com.cch.boot;

import java.util.HashSet;
import java.util.Set;

import com.cch.api.MobileApiService;
import com.cch.readers.JsonMessageBodyReader;
import com.cch.writers.JsonMessageBodyWriter;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class CCHApplication extends Application {
	private Set<Class<?>> classes;

	public CCHApplication() {
		classes = new HashSet<>();
		classes.add(JsonMessageBodyReader.class);
		classes.add(JsonMessageBodyWriter.class);
		classes.add(MobileApiService.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}
