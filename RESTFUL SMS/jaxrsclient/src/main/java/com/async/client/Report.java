package com.async.client;

public class Report {
	String productSales;
	int newClients;

	public String getProductSales() {
		return productSales;
	}

	public void setProductSales(String productSales) {
		this.productSales = productSales;
	}

	public int getNewClients() {
		return newClients;
	}

	public void setNewClients(int newClients) {
		this.newClients = newClients;
	}

	@Override
	public String toString() {
		return "Report [productSales=" + productSales + ", newClients=" + newClients + "]";
	}

}
