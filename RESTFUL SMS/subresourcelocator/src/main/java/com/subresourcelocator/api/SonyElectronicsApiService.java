package com.subresourcelocator.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public class SonyElectronicsApiService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{productCode}/details")
	public String getProduct(@PathParam("productCode") String productCode) {
		return "{\"productCode\":\"" + productCode + "\", \"description\": \"wireless ear buds\", \"price\": 949}";
	}
}
