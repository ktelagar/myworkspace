package com.ck.entities;

import java.io.Serializable;
import java.util.Objects;

public class LoanApplicationNo implements Serializable {
	protected int applicationNo;
	protected String branchCode;

	public int getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(applicationNo, branchCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanApplicationNo other = (LoanApplicationNo) obj;
		return applicationNo == other.applicationNo && Objects.equals(branchCode, other.branchCode);
	}

	@Override
	public String toString() {
		return "LoanApplicationNo [applicationNo=" + applicationNo + ", branchCode=" + branchCode + "]";
	}

}
