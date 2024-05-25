package com.exceptionhandling.boot;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.exceptionhandling.api.StockManagerApiService;
import com.exceptionhandling.api.UPIGatewayApiService;
import com.exceptionhandling.mapper.InsufficientFundsExceptionMapper;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

@ApplicationPath("/api")
public class ExceptionHandlingApplication extends ResourceConfig {

	public ExceptionHandlingApplication() {
		register(JacksonFeature.class);
		register(UPIGatewayApiService.class);
		register(InsufficientFundsExceptionMapper.class);
		register(StockManagerApiService.class);
		register(OpenApiResource.class);
	}

}
