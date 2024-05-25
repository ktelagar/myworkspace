package com.subresourcelocator.api;

import java.security.SecureRandom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public class SonyEntertainmentApiService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{channelNo}/price")
	public double getSubscriptionPrice(@PathParam("channelNo") String channelNo) {
		return new SecureRandom().nextDouble() * 100;
	}
}
