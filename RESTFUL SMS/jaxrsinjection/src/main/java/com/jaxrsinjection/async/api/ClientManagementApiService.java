package com.jaxrsinjection.async.api;

import java.security.SecureRandom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/client")
public class ClientManagementApiService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{year}/new")
	public int getNewClients(@PathParam("year") int year) throws InterruptedException {
		System.out.println("received newClients request and is under processing...");
		Thread.sleep(1000);
		return new SecureRandom().nextInt();
	}
}
