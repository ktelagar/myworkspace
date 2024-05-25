package com.renw.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/store")
public class StoreResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getStoreLocation(@QueryParam("storeName") String storeName) {
		return "secunderabad";
	}
}
