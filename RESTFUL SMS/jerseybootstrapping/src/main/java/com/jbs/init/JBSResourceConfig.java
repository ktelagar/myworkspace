package com.jbs.init;

import org.glassfish.jersey.server.ResourceConfig;

import com.jbs.resources.stock.StockResource;
import com.jbs.resources.weather.WeatherResource;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class JBSResourceConfig extends ResourceConfig {

	public JBSResourceConfig() {
		super.register(StockResource.class);
		register(new WeatherResource());
	}

}
