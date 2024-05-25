package com.wwi.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.ws.rs.Path;

@Path("/mobileRecharge")
public class MobileRechargeApiServiceImpl implements MobileRechargeApiService {

	@Override
	public List<String> availablePlans(String provider, String circle, String planType) {
		return Stream.of(
				new String[] { "Unlimited-999-" + provider, "Unlimited-1799-" + circle, "Unlimitted-499-" + planType })
				.collect(Collectors.toList());
	}

}
