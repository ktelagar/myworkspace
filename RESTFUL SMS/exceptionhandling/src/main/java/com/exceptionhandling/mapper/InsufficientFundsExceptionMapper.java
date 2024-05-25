package com.exceptionhandling.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.exceptionhandling.dto.Error;
import com.exceptionhandling.dto.Errors;
import com.exceptionhandling.exception.InsufficientFundsException;

@Provider
public class InsufficientFundsExceptionMapper implements ExceptionMapper<InsufficientFundsException> {

	@Override
	public Response toResponse(InsufficientFundsException exception) {
		Error error = Error.of().errorCode(20001).errorMessage(exception.getMessage()).build();
		Errors errors = new Errors();
		errors.getErrors().add(error);
		Response response = Response.status(Status.BAD_REQUEST).entity(errors).build();
		return response;
	}

}
