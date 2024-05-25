package com.mobilerecharge.dto;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseRequest {
	private String stockName;
	private String stockExchange;
	private int quantity;
	private double buyPrice;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date orderedDate;
	private String stockHolderName;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getStockHolderName() {
		return stockHolderName;
	}

	public void setStockHolderName(String stockHolderName) {
		this.stockHolderName = stockHolderName;
	}

}
