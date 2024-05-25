package com.jaxrsinjection.init;

import java.util.HashSet;
import java.util.Set;

import com.jaxrsinjection.async.api.ClientManagementApiService;
import com.jaxrsinjection.async.api.SalesApiService;
import com.jaxrsinjection.beanparam.api.LoanApiService;
import com.jaxrsinjection.formparam.api.ReviewApiService;
import com.jaxrsinjection.headercookieparam.api.RideApiService;
import com.jaxrsinjection.matrixparam.api.PropertyApiService;
import com.jaxrsinjection.pathsegment.api.CarApiService;
import com.jaxrsinjection.uriinfo.api.CabApiService;

import jakarta.ws.rs.core.Application;

public class JaxRsInjectionApplication extends Application {
	private Set<Class<?>> classes;

	public JaxRsInjectionApplication() {
		classes = new HashSet<>();
		classes.add(PropertyApiService.class);
		classes.add(CarApiService.class);
		classes.add(ReviewApiService.class);
		classes.add(RideApiService.class);
		classes.add(LoanApiService.class);
		classes.add(CabApiService.class);
		classes.add(SalesApiService.class);
		classes.add(ClientManagementApiService.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}
