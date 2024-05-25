package com.exceptionhandling.api;

import java.time.LocalDate;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.exceptionhandling.dto.Error;
import com.exceptionhandling.dto.Errors;
import com.exceptionhandling.dto.MerchantPaymentRequest;
import com.exceptionhandling.dto.UPIPaymentReceipt;
import com.exceptionhandling.exception.InsufficientFundsException;
import com.exceptionhandling.service.RBIService;

@Path("/upiGateway")
public class UPIGatewayApiService {
	private RBIService rbiService;

	public UPIGatewayApiService() {
		rbiService = new RBIService();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/merchantTransferNoExHandling")
	public UPIPaymentReceipt merchantPayWithNoExHandling(MerchantPaymentRequest request) {
		String transactionNo = null;
		UPIPaymentReceipt upiPaymentReceipt = null;

		transactionNo = rbiService.upiTransfer(request.getFromUpiID(), request.getToUpiID(), request.getAmount());
		upiPaymentReceipt = UPIPaymentReceipt.of().transactionNo(transactionNo).transactionDate(LocalDate.now())
				.fromUpiId(request.getFromUpiID()).toUpiId(request.getToUpiID()).amount(request.getAmount())
				.status("approved").build();
		return upiPaymentReceipt;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/merchantTransferExToResponse")
	public Response merchantPayWithExToResponse(MerchantPaymentRequest request) {
		String transactionNo = null;
		Response response = null;
		UPIPaymentReceipt upiPaymentReceipt = null;

		try {
			transactionNo = rbiService.upiTransfer(request.getFromUpiID(), request.getToUpiID(), request.getAmount());
			upiPaymentReceipt = UPIPaymentReceipt.of().transactionNo(transactionNo).transactionDate(LocalDate.now())
					.fromUpiId(request.getFromUpiID()).toUpiId(request.getToUpiID()).amount(request.getAmount())
					.status("approved").build();
			response = Response.ok(upiPaymentReceipt).build();
		} catch (InsufficientFundsException e) {
			Error error = Error.of().errorCode(20001).errorMessage(e.getMessage()).build();
			Errors errors = new Errors();
			errors.getErrors().add(error);
			response = Response.status(Status.BAD_REQUEST).entity(errors).build();
		}
		return response;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/merchantTransferWithThrowEx")
	public UPIPaymentReceipt merchantPayWithThrowEx(MerchantPaymentRequest request) {
		String transactionNo = null;
		UPIPaymentReceipt upiPaymentReceipt = null;

		try {
			transactionNo = rbiService.upiTransfer(request.getFromUpiID(), request.getToUpiID(), request.getAmount());
			upiPaymentReceipt = UPIPaymentReceipt.of().transactionNo(transactionNo).transactionDate(LocalDate.now())
					.fromUpiId(request.getFromUpiID()).toUpiId(request.getToUpiID()).amount(request.getAmount())
					.status("approved").build();

		} catch (InsufficientFundsException e) {
			Error error = Error.of().errorCode(20001).errorMessage(e.getMessage()).build();
			Errors errors = new Errors();
			errors.getErrors().add(error);
			Response response = Response.status(Status.BAD_REQUEST).entity(errors).build();
			WebApplicationException webApplicationException = new WebApplicationException(response);
			throw webApplicationException;
		}
		return upiPaymentReceipt;
	}
}
