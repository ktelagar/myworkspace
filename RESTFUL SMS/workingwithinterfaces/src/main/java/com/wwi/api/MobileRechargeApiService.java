package com.wwi.api;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;


public interface MobileRechargeApiService {
	@GET
	@Path("/{provider}/{circle}/plans")
	@Produces("text/plain")
	List<String> availablePlans(@PathParam("provider") String provider, @PathParam("circle") String circle,
			@QueryParam("planType") String planType);
}
