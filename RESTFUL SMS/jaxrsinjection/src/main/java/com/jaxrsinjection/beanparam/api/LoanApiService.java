package com.jaxrsinjection.beanparam.api;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/loan")
public class LoanApiService {
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{loanType}/apply")
	public String applyLoan(@BeanParam LoanApplication loanApplication) {
		return loanApplication.toString();
	}
}
