package com.pps.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/parcel")
public class ParcelApiService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{awbNo: [a-z]{3}[0-9]{7}}/track")
	public String track(@PathParam("awbNo") String awbNo) {
		return "{\"awbNo\": \"" + awbNo + "\", \"status\": \"pending\"}";
	}
}
