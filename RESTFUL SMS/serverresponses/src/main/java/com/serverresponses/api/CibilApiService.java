package com.serverresponses.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/cibil")
public class CibilApiService {

	@GET
	@Path("/{pan}/{fullname}/score")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCibilScore(@PathParam("pan") String pan, @PathParam("fullname") String fullname) {
		Response response = null;
		ResponseBuilder builder = null;

		builder = Response.status(201);
		builder = builder.header("rating", "5");
		builder = builder.cookie(new NewCookie("fullname", fullname));
		builder = builder.entity("760");
		response = builder.build();

		return Response.status(201).header("rating", "5").cookie(new NewCookie("fullname", fullname)).entity("701")
				.build();
	}
}
