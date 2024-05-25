package com.cch.dto;

public class RechargeRequest {
	private String mobileNo;
	private String circle;
	private String rechargeType;
	private String provider;
	private String planNo;
	private double amount;
	private Payment payment;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPlanNo() {
		return planNo;
	}

	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "RechargeRequest [mobileNo=" + mobileNo + ", circle=" + circle + ", rechargeType=" + rechargeType
				+ ", provider=" + provider + ", planNo=" + planNo + ", amount=" + amount + ", payment=" + payment + "]";
	}

}
