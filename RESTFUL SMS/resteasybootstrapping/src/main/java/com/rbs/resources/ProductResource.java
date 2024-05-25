package com.rbs.resources;

import java.security.SecureRandom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/product")
public class ProductResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getProductPrice(@QueryParam("productcode") String productCode) {
		return new SecureRandom().nextDouble() * 1000;
	}
}
