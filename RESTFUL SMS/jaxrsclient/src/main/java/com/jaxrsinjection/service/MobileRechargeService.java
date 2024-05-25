package com.jaxrsinjection.service;

import com.mobilerecharge.dto.RechargeReceipt;
import com.mobilerecharge.dto.RechargeRequest;
import com.mobilerecharge.readers.JsonMessageBodyReader;
import com.mobilerecharge.writers.JsonMessageBodyWriter;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class MobileRechargeService {
	private final static String BASE_RESOURCE_URI = "/custom-content-handlers/api/mobile";
	private final static String HOSTNAME = "localhost";
	private final static int PORT = 8081;
	private Client client;

	public MobileRechargeService() {
		ClientBuilder builder = ClientBuilder.newBuilder();
		builder.register(JsonMessageBodyReader.class);
		builder.register(JsonMessageBodyWriter.class);
		client = builder.build();
	}

	public RechargeReceipt recharge(RechargeRequest rechargeRequest) {
		RechargeReceipt receipt = null;

		WebTarget webTarget = client.target("http://" + HOSTNAME + ":" + PORT + BASE_RESOURCE_URI).path("recharge");
		Invocation.Builder builder = webTarget.request();
		Invocation invocation = builder.buildPost(Entity.json(rechargeRequest));
		Response response = invocation.invoke();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			receipt = response.readEntity(RechargeReceipt.class);
		}
		return receipt;
	}

}
