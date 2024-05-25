package com.restfulcache.api;

import java.util.Date;

import com.restfulcache.dto.Product;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/product")
public class ProductApiService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{productcode}/info")
	public Response getProduct(@PathParam("productcode") String productcode) {
		Response response = null;
		
		System.out.println("productcode: " + productcode);
		
		Product product = new Product();
		product.setProductcode(productcode);
		product.setProductName("Firetv Stick");
		product.setManufacturer("amazon");
		product.setPrice(1500);

		response = Response.ok(Entity.json(product)).expires(new Date(2023, 11, 14, 9, 15)).build();

		return response;
	}
}
