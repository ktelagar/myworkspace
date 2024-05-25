package com.jc.test;

import com.jaxrsinjection.service.MobileRechargeService;
import com.mobilerecharge.dto.RechargeReceipt;
import com.mobilerecharge.dto.RechargeRequest;

import jakarta.ws.rs.core.Request;

public class PayTMServiceTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//		double balance = new PayTMAccountService().getBalance("0383944");
//		System.out.println("balance : " + balance);
//		PropertyService propertyService = new PropertyService();
//		String rentals = propertyService.rentals("hyderabad", "east", "Apartment", 10, 25000, 28000, "Ameerpet",
//				Arrays.asList(new Integer[] { 1600, 1250, 1400 }));
//		System.out.println(rentals);
//		RideService rideService = new RideService();
//		String ride = rideService.bookRide("Ameerpet", "Hi-Tech City", "ap304", "bNI3X093");
//		System.out.println(ride);
		MobileRechargeService mobileRechargeService = new MobileRechargeService();
		RechargeRequest request = new RechargeRequest();
		request.setRechargeType("data");
		request.setMobileNo("9383984944");
		request.setProvider("airtel");
		request.setCircle("AP");
		request.setPlanNo("P03983");
		request.setAmount(399);
		
		RechargeRequest.Payment payment =  request.new Payment();
		payment.setCardNumber("9383938390383833");
		payment.setCardType("credit");
		payment.setCvv(939);
		payment.setExpiryMonth(3);
		payment.setExpiryYear(2023);
		request.setPayment(payment);
		
		
		RechargeReceipt receipt = mobileRechargeService.recharge(request);
		System.out.println(receipt);
		
	}
}
