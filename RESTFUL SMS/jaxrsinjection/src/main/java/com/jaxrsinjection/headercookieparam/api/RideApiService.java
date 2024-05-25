package com.jaxrsinjection.headercookieparam.api;

import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/ride")
public class RideApiService {
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{source}/{destination}/book")
	public String bookRide(@PathParam("source") String source, @PathParam("destination") String destination,
			@HeaderParam("appCode") String appCode, @CookieParam("loggedInSessionId") String loggedInSessionId) {
		return "Source :" + source + " destination : " + destination + " appCode : " + appCode + " loggedInSessionId: "
				+ loggedInSessionId;
	}
}
