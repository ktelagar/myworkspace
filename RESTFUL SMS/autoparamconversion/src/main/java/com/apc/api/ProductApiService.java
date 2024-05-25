package com.apc.api;

import java.util.List;
import java.util.stream.Collectors;

import com.apc.dto.TrackingNo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/product")
public class ProductApiService {
	/**
	 * automatic param conversion for primitive types
	 * 
	 * @param productCode
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{productcode}/price")
	public double getProductPrice(@PathParam("productcode") int productCode) {
		return productCode;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/search")
	public String search(@QueryParam("category") List<Integer> categories) {
		String cats = categories.stream().map(c -> String.valueOf(c)).collect(Collectors.joining(","));
		return cats;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{trackingNo}/track")
	public String track(@PathParam("trackingNo") TrackingNo trackingNo) {
		return trackingNo.toString();
	}
}
