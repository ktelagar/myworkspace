package com.bindinguri.api;

import java.security.SecureRandom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/policy")
public class PolicyApiService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getPolicyDetails(@QueryParam("policyNo") String policyNo) {
		String policyDetails = null;

		policyDetails = "{'policyNo':'" + policyNo
				+ "', 'policyHolderName': 'cris', 'gender': 'male', 'dob' : '10/01/1998'}";

		return policyDetails;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/amount")
	public double getPremimumAmount(@QueryParam("policyNo") String policyNo) {
		return new SecureRandom().nextDouble() * 1000;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/nextDue")
	public String getNextPremiumDueDate(@QueryParam("policyNo") String policyNo) {
		return "10-01-2022";
	}
}
