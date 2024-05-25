package com.exceptionhandling.api;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.exceptionhandling.dto.PurchaseRequest;
import com.exceptionhandling.dto.Receipt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;

@Path("/stock")
@OpenAPIDefinition(info = @Info(title = "stock service", description = "stock management service", version = "1.0.0"), servers = {
		@Server(url = "http://localhost:8081/exceptionhandling/api/", description = "development server") })
public class StockManagerApiService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buy")
	@Operation(method = "buyStock", description = "buying stock", requestBody = @RequestBody(content = {
			@Content(mediaType = "application/json", schema = @Schema(anyOf = { PurchaseRequest.class })) }))
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "receipt", content = {
			@Content(mediaType = "application/json", schema = @Schema(anyOf = { Receipt.class })) }) })
	public Receipt buyStock(PurchaseRequest purchaseRequest) throws InterruptedException {
		Receipt receipt = null;

		System.out.println("received request for purchasing stock :" + purchaseRequest.getStockName());
		Thread.sleep(1000);
		receipt = new Receipt();
		receipt.setReceiptNo(UUID.randomUUID().toString().substring(0, 9));
		receipt.setStockHolderName(purchaseRequest.getStockHolderName());
		int allotedQuantity = (int) (purchaseRequest.getQuantity() * 0.1);
		receipt.setAllotedQuantity(allotedQuantity);
		receipt.setStockName(purchaseRequest.getStockName());
		receipt.setAmountCharged(purchaseRequest.getBuyPrice() * allotedQuantity);
		receipt.setReceiptDate(new Date());
		System.out.println("dispatching receipt for stock: " + purchaseRequest.getStockName());

		return receipt;
	}
}
