package com.hb3bs.entities;

import java.io.Serializable;
import java.util.Objects;

public class Policy implements Serializable {
	protected int policyNo;
	protected String policyHolderName;
	protected String planName;
	protected int tenure;
	protected double premiumAmount;
	protected double insurredAmount;

	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public double getInsurredAmount() {
		return insurredAmount;
	}

	public void setInsurredAmount(double insurredAmount) {
		this.insurredAmount = insurredAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(insurredAmount, planName, policyHolderName, policyNo, premiumAmount, tenure);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Policy other = (Policy) obj;
		return Double.doubleToLongBits(insurredAmount) == Double.doubleToLongBits(other.insurredAmount)
				&& Objects.equals(planName, other.planName) && Objects.equals(policyHolderName, other.policyHolderName)
				&& policyNo == other.policyNo
				&& Double.doubleToLongBits(premiumAmount) == Double.doubleToLongBits(other.premiumAmount)
				&& tenure == other.tenure;
	}

	@Override
	public String toString() {
		return "Policy [policyNo=" + policyNo + ", policyHolderName=" + policyHolderName + ", planName=" + planName
				+ ", tenure=" + tenure + ", premiumAmount=" + premiumAmount + ", insurredAmount=" + insurredAmount
				+ "]";
	}

}
