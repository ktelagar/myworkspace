package com.rbs.boot;

import java.util.HashSet;
import java.util.Set;

import com.rbs.resources.ProductResource;

import jakarta.ws.rs.core.Application;

public class RestEasyBootStrappingApplication extends Application {
	private Set<Class<?>> classes;

	public RestEasyBootStrappingApplication() {
		classes = new HashSet<>();
		classes.add(ProductResource.class);
		System.out.println("RestEasyBootStrappingApplication created");
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}
