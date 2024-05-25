package com.jaxrsinjection.service;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class RideService {
	private static final String HOSTNAME = "localhost";
	private static final int PORT = 8081;
	private static final String BASE_RESOURCE_URI = "/jaxrsinjection/rest/ride";
	private Client client;

	public RideService() {
		ClientBuilder builder = ClientBuilder.newBuilder();
		client = builder.build();
	}

	public String bookRide(String source, String destination, String appCode, String loggedInSessionId) {
		String body = null;
		WebTarget target = client.target("http://" + HOSTNAME + ":" + PORT + BASE_RESOURCE_URI)
				.path("/{source}/{destination}/book").resolveTemplate("source", source)
				.resolveTemplate("destination", destination);
		Invocation.Builder builder = target.request();
		builder = builder.header("appCode", appCode);
		builder = builder.cookie(new NewCookie("loggedInSessionId", loggedInSessionId));
		Invocation invocation = builder.buildPost(null);
		Response response = invocation.invoke();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			body = response.readEntity(String.class);
		}

		return body;

	}
}
