package com.paytmjersey.resources;

import java.security.SecureRandom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/payTMAccount")
public class PayTMAccountResource {

	@GET
	@Produces("text/plain")
	public double getAccountBalance(@QueryParam("mobileNo") String registeredMobileNo) {
		return 100 * new SecureRandom().nextDouble();
	}
}
