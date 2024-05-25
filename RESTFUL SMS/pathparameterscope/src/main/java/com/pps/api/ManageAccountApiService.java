package com.pps.api;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/{accountNo}/manageaccount")
public class ManageAccountApiService {
	@GET
	@Path("/orders")
	@Produces(MediaType.TEXT_PLAIN)
	public String getOrders(@PathParam("accountNo") String accountNo) {
		return accountNo;
	}

	@GET
	@Path("/addresses")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAddresses(@PathParam("accountNo") String accountNo) {
		return accountNo;
	}
}
