package com.onetomanyset.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class Challan implements Serializable {
	protected int challanNo;
	protected String description;
	protected Date issuedDate;
	protected String violationType;
	protected double amount;
	protected VehicleRegistration vehicleRegistration;
	
	public int getChallanNo() {
		return challanNo;
	}
	public void setChallanNo(int challanNo) {
		this.challanNo = challanNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public String getViolationType() {
		return violationType;
	}
	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public VehicleRegistration getBikeRegistration() {
		return vehicleRegistration;
	}
	public void setBikeRegistration(VehicleRegistration bikeRegistration) {
		this.vehicleRegistration = bikeRegistration;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, vehicleRegistration, challanNo, description, issuedDate, violationType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Challan other = (Challan) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(vehicleRegistration, other.vehicleRegistration) && challanNo == other.challanNo
				&& Objects.equals(description, other.description) && Objects.equals(issuedDate, other.issuedDate)
				&& Objects.equals(violationType, other.violationType);
	}
	@Override
	public String toString() {
		return "TrafficChallan [challanNo=" + challanNo + ", description=" + description + ", issuedDate=" + issuedDate
				+ ", violationType=" + violationType + ", amount=" + amount + ", bikeRegistration=" + vehicleRegistration
				+ "]";
	}
	

}
