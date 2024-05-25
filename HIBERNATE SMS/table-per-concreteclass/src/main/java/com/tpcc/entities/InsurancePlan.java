package com.tpcc.entities;

import java.io.Serializable;

public class InsurancePlan implements Serializable {
	protected int insurancePlanNo;
	protected String planName;
	protected String description;
	protected boolean taxSaver;
	protected float minInsurredAmount;

	public int getInsurancePlanNo() {
		return insurancePlanNo;
	}

	public void setInsurancePlanNo(int insurancePlanNo) {
		this.insurancePlanNo = insurancePlanNo;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getTaxSaver() {
		return taxSaver;
	}

	public void setTaxSaver(boolean taxSaver) {
		this.taxSaver = taxSaver;
	}

	public float getMinInsurredAmount() {
		return minInsurredAmount;
	}

	public void setMinInsurredAmount(float minInsurredAmount) {
		this.minInsurredAmount = minInsurredAmount;
	}

	@Override
	public String toString() {
		return "InsurancePlan [insurancePlanNo=" + insurancePlanNo + ", planName=" + planName + ", description="
				+ description + ", taxSaver=" + taxSaver + ", minInsurredAmount=" + minInsurredAmount + "]";
	}

}
