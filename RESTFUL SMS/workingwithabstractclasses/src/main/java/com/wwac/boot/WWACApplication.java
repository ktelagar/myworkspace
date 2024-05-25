package com.wwac.boot;

import java.util.HashSet;
import java.util.Set;

import com.wwac.api.AccountJsonApiService;
import com.wwac.api.AccountXMLApiService;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class WWACApplication extends Application {
	private Set<Object> singletons;

	public WWACApplication() {
		singletons = new HashSet<>();
		singletons.add(new AccountXMLApiService());
		singletons.add(new AccountJsonApiService());
	}

	@Override
	public Set<Object> getSingletons() {
		System.out.println("getSingletons()");
		return singletons;
	}

}
