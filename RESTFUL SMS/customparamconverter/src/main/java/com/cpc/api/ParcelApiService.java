package com.cpc.api;

import com.cpc.dto.AwbNo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/parcel")
public class ParcelApiService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{awbNo}/track")
	public String track(@PathParam("awbNo") AwbNo awbNo) {
		return awbNo.toString();
	}
}
