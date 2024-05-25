package com.cch.api;

import java.time.LocalDate;
import java.util.UUID;

import com.cch.dto.RechargeRequest;
import com.cch.dto.RechargeStatus;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/mobile")
public class MobileApiService {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recharge")
	public RechargeStatus recharge(RechargeRequest rechargeRequest) {
		RechargeStatus rechargeStatus = null;

		rechargeStatus = new RechargeStatus();
		rechargeStatus.setTransactionNo(UUID.randomUUID().toString().substring(0, 9).replaceAll("-", "5"));
		rechargeStatus.setTransactionDate(LocalDate.now());
		rechargeStatus.setMobileNo(rechargeRequest.getMobileNo());
		rechargeStatus.setProvider(rechargeRequest.getProvider());
		rechargeStatus.setPlanNo(rechargeRequest.getPlanNo());
		rechargeStatus.setAmount(rechargeRequest.getAmount());
		rechargeStatus.setStatus("accepted");
		rechargeStatus
				.setRemarks("recharge request has been accepted, and a confirmation message will be received shortly");
		return rechargeStatus;
	}
}
