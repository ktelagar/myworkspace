package com.mobilerecharge.dto;

public class RechargeRequest {
	private String mobileNo;
	private String circle;
	private String rechargeType;
	private String provider;
	private String planNo;
	private double amount;
	private Payment payment;

	public class Payment {
		private String cardType;
		private String cardNumber;
		private int expiryMonth;
		private int expiryYear;
		private int cvv;

		public String getCardType() {
			return cardType;
		}

		public void setCardType(String cardType) {
			this.cardType = cardType;
		}

		public String getCardNumber() {
			return cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}

		public int getExpiryMonth() {
			return expiryMonth;
		}

		public void setExpiryMonth(int expiryMonth) {
			this.expiryMonth = expiryMonth;
		}

		public int getExpiryYear() {
			return expiryYear;
		}

		public void setExpiryYear(int expiryYear) {
			this.expiryYear = expiryYear;
		}

		public int getCvv() {
			return cvv;
		}

		public void setCvv(int cvv) {
			this.cvv = cvv;
		}

	}

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

}
