package com.jaxrsinjection.service;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class PropertyService {
	private final String HOSTNAME = "localhost";
	private final int PORT = 8081;
	private final String BASE_RESOURCE_URI = "/jaxrsinjection/rest/property/";
	private Client client;

	public PropertyService() {
		ClientBuilder builder = ClientBuilder.newBuilder();
		client = builder.build();
	}

	public String rentals(String city, String facing, String propertyType, int floors, double minRentalAmount,
			double maxRentalAmount, String location, List<Integer> propertySizes) {
		String body = null;

		WebTarget target = client.target("http://" + HOSTNAME + ":" + PORT + BASE_RESOURCE_URI).path("/{city}")
				.matrixParam("location", location).path("/{facing}/{propertyType}");
		
		for (Integer propertySize : propertySizes) {
			target = target.matrixParam("propertySize", propertySize);
		}

		target = target.path("/rentals").resolveTemplate("city", city).resolveTemplate("facing", facing)
				.resolveTemplate("propertyType", propertyType).queryParam("floor", floors)
				.queryParam("minRentalAmount", minRentalAmount).queryParam("maxRentalAmount", maxRentalAmount);
		System.out.println(target.toString());
		Invocation.Builder builder = target.request();
		Invocation invocation = builder.buildGet();
		Response response = invocation.invoke();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			body = response.readEntity(String.class);
		} else {
			System.out.println("error status code: " + response.getStatus());
			System.out.println(response.readEntity(String.class));
		}
		return body;
	}

}
