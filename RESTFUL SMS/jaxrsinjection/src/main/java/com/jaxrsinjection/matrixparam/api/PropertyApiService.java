package com.jaxrsinjection.matrixparam.api;

import java.util.List;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/property")
public class PropertyApiService {
	/**
	 * 
	 * @param propertyType    = path parameter
	 * @param floor           = query parameter
	 * @param facing          = path parameter
	 * @param location        = query parameter
	 * @param city            = path parameter
	 * @param minRentalAmount = query parameter
	 * @param maxRentalAmount = query parameter
	 * @return /api/property/hyderabad;location=ameerpet/east/apartment;propertySize=1200/rentals?floor=5&minRentalAmount=12000&maxRentalAmount=25000
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{city}/{facing}/{propertyType}/rentals")
	public String searchForRent(@PathParam("propertyType") String propertyType, @QueryParam("floor") List<Integer> floors,
			@PathParam("facing") String facing, @MatrixParam("location") String location,
			@PathParam("city") String city,
			@QueryParam("minRentalAmount") @DefaultValue("12000") double minRentalAmount,
			@QueryParam("maxRentalAmount") @DefaultValue("25000") double maxRentalAmount,
			@MatrixParam("propertySize") List<Integer> propertySizes) {
		return "propertyType :" + propertyType + " floor : " + floors + " facing : " + facing + " location : " + location
				+ " city : " + city + " minRentalAmount : " + minRentalAmount + " maxRentalAmount : " + maxRentalAmount
				+ " propertySize : " + propertySizes;
	}
}
