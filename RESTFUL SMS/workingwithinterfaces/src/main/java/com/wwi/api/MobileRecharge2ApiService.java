package com.wwi.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.ws.rs.Path;

@Path("/mobileRecharge2")
public class MobileRecharge2ApiService implements MobileRechargeApiService {

	@Override
	public List<String> availablePlans(String provider, String circle, String planType) {
		return Stream.of(new String[] { "Plan-999-" + provider, "Plan-1799-" + circle, "DataPlan-499-" + planType })
				.collect(Collectors.toList());
	}

}
