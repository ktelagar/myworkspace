package com.exceptionhandling.service;

import java.util.UUID;

import com.exceptionhandling.exception.InsufficientFundsException;

public class RBIService {
	public String upiTransfer(String fromUpiId, String toUpiId, double amount) {
		if (fromUpiId.equals("9999999991@icici")) {
			throw new InsufficientFundsException("no balance");
		}
		return UUID.randomUUID().toString().substring(0, 9);
	}
}
