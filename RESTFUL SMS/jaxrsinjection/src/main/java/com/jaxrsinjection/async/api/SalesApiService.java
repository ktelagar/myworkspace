package com.jaxrsinjection.async.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/sales")
public class SalesApiService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{year}/report")
	public String getProductSales(@PathParam("year") int year) throws InterruptedException {
		System.out.println("recieved getProductSales() request and is under processing...");
		Thread.sleep(1000);
		return "{\"households\": 93898, \"electronics\": 38938}";
	}
}
