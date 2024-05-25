package com.async.client;

import java.security.SecureRandom;
import java.util.Date;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.mobilerecharge.dto.PurchaseRequest;
import com.mobilerecharge.dto.Receipt;

import jakarta.ws.rs.client.AsyncInvoker;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.InvocationCallback;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class ICICIDirectBuy {

	public void buyStock(String[] stockNames) {
		ClientBuilder builder = ClientBuilder.newBuilder();
		builder.register(JacksonFeature.class);
		Client client = builder.build();
		SecureRandom random = new SecureRandom();

		for (String stockName : stockNames) {
			WebTarget webTarget = client.target("http://localhost:8081/exceptionhandling/api/stock/buy");
			PurchaseRequest request = new PurchaseRequest();
			request.setStockName(stockName);
			request.setBuyPrice(random.nextDouble(1, 500));
			request.setOrderedDate(new Date());
			request.setQuantity(random.nextInt(1, 1000));
			request.setStockHolderName("Martin");
			request.setStockExchange("BSE");
			AsyncInvoker asyncInvoker = webTarget.request().async();
			asyncInvoker.post(Entity.json(request), new ReceiptHandler());
		}
	}

	private static final class ReceiptHandler implements InvocationCallback<Response> {
		@Override
		public void completed(Response response) {
			Receipt receipt = null;

			receipt = response.readEntity(Receipt.class);
			System.out.println("saving the receipt for stock :" + receipt.getStockName() + " into database");
		}

		@Override
		public void failed(Throwable throwable) {
			System.out.println("logging the error :" + throwable.getMessage());
			throwable.printStackTrace();
		}
	}
}
