package com.htx.entities;

import java.io.Serializable;
import java.util.Objects;

public class Branch implements Serializable {
	protected int branchNo;
	protected String branchName;
	protected String ifscCode;
	protected String workingHours;
	protected String location;
	protected String contactNo;

	public int getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchName, branchNo, contactNo, ifscCode, location, workingHours);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		return Objects.equals(branchName, other.branchName) && branchNo == other.branchNo
				&& Objects.equals(contactNo, other.contactNo) && Objects.equals(ifscCode, other.ifscCode)
				&& Objects.equals(location, other.location) && Objects.equals(workingHours, other.workingHours);
	}

	@Override
	public String toString() {
		return "Branch [branchNo=" + branchNo + ", branchName=" + branchName + ", ifscCode=" + ifscCode
				+ ", workingHours=" + workingHours + ", location=" + location + ", contactNo=" + contactNo + "]";
	}

}
