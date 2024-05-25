package com.async.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import jakarta.ws.rs.client.AsyncInvoker;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class SalesReport {

	public Report generateAnnualReport(int year) throws InterruptedException, ExecutionException {
		Report report = null;
		ClientBuilder builder = null;
		Client client = null;
		WebTarget salesApiTarget = null;
		WebTarget clientManagementApiTarget = null;

		builder = ClientBuilder.newBuilder();
		client = builder.build();
		salesApiTarget = client.target("http://localhost:8081/jaxrsinjection/rest/sales/{year}/report");
		salesApiTarget = salesApiTarget.resolveTemplate("year", year);
		AsyncInvoker salesApiInvoker = salesApiTarget.request().async();
		Future<Response> salesApiFuture = salesApiInvoker.get();

		clientManagementApiTarget = client.target("http://localhost:8081/jaxrsinjection/rest/client/{year}/new");
		clientManagementApiTarget = clientManagementApiTarget.resolveTemplate("year", year);
		AsyncInvoker clientManagementInvoker = clientManagementApiTarget.request().async();
		Future<Response> clientManagementFuture = clientManagementInvoker.get();

		while (salesApiFuture.isDone() == false || clientManagementFuture.isDone() == false)
			;
		String productSales = salesApiFuture.get().readEntity(String.class);
		Integer newClients = clientManagementFuture.get().readEntity(Integer.class);

		report = new Report();
		report.setProductSales(productSales);
		report.setNewClients(newClients);

		return report;
	}
}
