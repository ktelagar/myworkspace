package com.jaxrsinjection.pathsegment.api;

import java.util.List;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.PathSegment;

@Path("/car")
public class CarApiService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{city}/{manufacturer}/search")
	public String searchCars(@PathParam("city") PathSegment cityPathSegment,
			@PathParam("manufacturer") PathSegment manufacturerPathSegment, @QueryParam("model") String model,
			@QueryParam("color") String color, @QueryParam("year") List<Integer> year,
			@QueryParam("fuelType") @DefaultValue("petrol") String fuelType,
			@QueryParam("minPrice") @DefaultValue("1") double minPrice,
			@QueryParam("maxPrice") @DefaultValue("99999999999") double maxPrice) {
		String response = null;

		response = "city : " + cityPathSegment.getPath();
		MultivaluedMap<String, String> cityMatrixParameters = cityPathSegment.getMatrixParameters();
		response += ";" + extractMultiValuedMap(cityMatrixParameters);

		response += " manufacturer: " + manufacturerPathSegment.getPath();
		MultivaluedMap<String, String> manufacturerMatrixParameters = manufacturerPathSegment.getMatrixParameters();
		response += ";" + extractMultiValuedMap(manufacturerMatrixParameters);
		response += " model : " + model + " color=" + color + " year=" + year.get(0) + " fuelType = " + fuelType
				+ " minPrice=" + minPrice + " maxPrice=" + maxPrice;

		return response;
	}

	private String extractMultiValuedMap(MultivaluedMap<String, String> multivaluedMap) {
		String content = "";
		for (String key : multivaluedMap.keySet()) {
			List<String> values = multivaluedMap.get(key);
			content += key + "=[";
			for (String value : values) {
				content += value + " ";
			}
			content += "];";
		}
		return content;
	}
}
