package com.mobilerecharge.dto;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Receipt {
	private String receiptNo;
	private String stockName;
	private String stockHolderName;
	private int allotedQuantity;
	private double amountCharged;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date receiptDate;

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockHolderName() {
		return stockHolderName;
	}

	public void setStockHolderName(String stockHolderName) {
		this.stockHolderName = stockHolderName;
	}

	public int getAllotedQuantity() {
		return allotedQuantity;
	}

	public void setAllotedQuantity(int allotedQuantity) {
		this.allotedQuantity = allotedQuantity;
	}

	public double getAmountCharged() {
		return amountCharged;
	}

	public void setAmountCharged(double amountCharged) {
		this.amountCharged = amountCharged;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

}
