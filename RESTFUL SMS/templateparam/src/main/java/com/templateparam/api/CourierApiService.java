package com.templateparam.api;

import java.security.SecureRandom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/courier")
public class CourierApiService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{parcelWeight}/{deliveryCircle}/charges")
	public double getCourierCharges(@PathParam("parcelWeight") int weight, @PathParam("deliveryCircle") String circle) {
		System.out.println("weight: " + weight + " deliveryCircle : " + circle);
		return new SecureRandom().nextDouble() * 100;
	}

}
