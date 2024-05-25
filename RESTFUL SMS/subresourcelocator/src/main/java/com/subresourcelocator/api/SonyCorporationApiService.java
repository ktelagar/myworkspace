package com.subresourcelocator.api;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/sony")
public class SonyCorporationApiService {
	/*
	 * @Path("/electronics") public SonyElectronicsApiService electronics() { return
	 * new SonyElectronicsApiService(); }
	 * 
	 * @Path("/entertainment") public SonyEntertainmentApiService entertainment() {
	 * return new SonyEntertainmentApiService(); }
	 */

	@Path("/{businessUnit}")
	public Object service(@PathParam("businessUnit") String businessUnit) {
		if (businessUnit.equals("electronics")) {
			return new SonyElectronicsApiService();
		} else if (businessUnit.equals("entertainment")) {
			return new SonyEntertainmentApiService();
		}
		throw new NotFoundException();
	}
}
