package com.jaxrsinjection.formparam.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/review")
public class ReviewApiService {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String saveReview(@FormParam("reviewerName") String reviewerName,
			@FormParam("productCode") String productCode, @FormParam("rating") int rating,
			@FormParam("comments") String comments) {
		return "reviewerName : " + reviewerName + " productCode:" + productCode + " rating: " + rating + " comments :"
				+ comments;
	}
}
