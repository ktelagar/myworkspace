package com.jaxrsinjection.beanparam.api;

import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PathParam;

public class LoanApplication {
	@PathParam("loanType")
	private String loanType;
	@FormParam("applicantName")
	private String applicantName;
	@FormParam("principleAmount")
	private double principleAmount;
	@FormParam("tenure")
	private int tenure;
	@FormParam("employmentType")
	private String employmentType;
	@FormParam("mobileNo")
	private String mobileNo;
	@FormParam("panNo")
	private String panNo;
	@HeaderParam("appCode")
	private String appCode;
	@CookieParam("loggedInSessionId")
	private String loggedInUser;

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public double getPrincipleAmount() {
		return principleAmount;
	}

	public void setPrincipleAmount(double principleAmount) {
		this.principleAmount = principleAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	@Override
	public String toString() {
		return "LoanApplication [loanType=" + loanType + ", applicantName=" + applicantName + ", principleAmount="
				+ principleAmount + ", tenure=" + tenure + ", employmentType=" + employmentType + ", mobileNo="
				+ mobileNo + ", panNo=" + panNo + ", appCode=" + appCode + ", loggedInUser=" + loggedInUser + "]";
	}

}
