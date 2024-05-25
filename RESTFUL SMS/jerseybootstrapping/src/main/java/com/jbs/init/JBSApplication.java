package com.jbs.init;

import java.util.HashSet;
import java.util.Set;

import com.jbs.resources.stock.StockResource;
import com.jbs.resources.weather.WeatherResource;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

//@ApplicationPath("/api")
public class JBSApplication extends Application {
	private Set<Object> singletons;
	private Set<Class<?>> classes;

	public JBSApplication() {
		singletons = new HashSet<>();
		classes = new HashSet<>();

		singletons.add(new StockResource());
		classes.add(WeatherResource.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
