package com.jbs.resources.weather;

import java.security.SecureRandom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/weather")
public class WeatherResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int getWeather(@QueryParam("zip") String zipCode) {
		System.out.println("weather hashcode: " + this.hashCode());
		return new SecureRandom().nextInt(100);
	}

}
