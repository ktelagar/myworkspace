package com.async.client;

public class ICICIDirectTest {
	public static void main(String[] args) {
		ICICIDirectBuy buy = new ICICIDirectBuy();
		buy.buyStock(new String[] { "Ranbaxy", "SBI", "Cipla" });
	}
}
