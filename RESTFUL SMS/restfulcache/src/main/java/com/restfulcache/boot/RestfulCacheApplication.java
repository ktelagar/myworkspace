package com.restfulcache.boot;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.core.util.JacksonFeature;
import com.restfulcache.api.AccountApiService;
import com.restfulcache.api.ProductApiService;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class RestfulCacheApplication extends ResourceConfig {

	public RestfulCacheApplication() {
		register(JacksonFeature.class);
		register(ProductApiService.class);
		register(AccountApiService.class);
	}

}
