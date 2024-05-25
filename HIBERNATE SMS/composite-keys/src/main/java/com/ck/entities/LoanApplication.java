package com.ck.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LoanApplication implements Serializable {
	/*
	 * protected int applicationNo; protected String branchCode;
	 */
	protected LoanApplicationNo loanApplicationNo;
	protected String applicantName;
	protected Date appliedDate;
	protected String loanType;
	protected Date dob;
	protected String gender;
	protected float loanAmount;

	/*
	 * public int getApplicationNo() { return applicationNo; }
	 * 
	 * public void setApplicationNo(int applicationNo) { this.applicationNo =
	 * applicationNo; }
	 * 
	 * public String getBranchCode() { return branchCode; }
	 * 
	 * public void setBranchCode(String branchCode) { this.branchCode = branchCode;
	 * }
	 */

	public LoanApplicationNo getLoanApplicationNo() {
		return loanApplicationNo;
	}

	public void setLoanApplicationNo(LoanApplicationNo loanApplicationNo) {
		this.loanApplicationNo = loanApplicationNo;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(applicantName, appliedDate, dob, gender, loanAmount, loanApplicationNo, loanType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanApplication other = (LoanApplication) obj;
		return Objects.equals(applicantName, other.applicantName) && Objects.equals(appliedDate, other.appliedDate)
				&& Objects.equals(dob, other.dob) && Objects.equals(gender, other.gender)
				&& Float.floatToIntBits(loanAmount) == Float.floatToIntBits(other.loanAmount)
				&& Objects.equals(loanApplicationNo, other.loanApplicationNo)
				&& Objects.equals(loanType, other.loanType);
	}

	@Override
	public String toString() {
		return "LoanApplication [loanApplicationNo=" + loanApplicationNo + ", applicantName=" + applicantName
				+ ", appliedDate=" + appliedDate + ", loanType=" + loanType + ", dob=" + dob + ", gender=" + gender
				+ ", loanAmount=" + loanAmount + "]";
	}

}
