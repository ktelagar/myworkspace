package com.onetomanyset.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class VehicleRegistration implements Serializable {
	protected int vehicleNumber;
	protected String registrationNo;
	protected String modelName;
	protected String manufacturer;
	protected Date purchaseDate;
	protected String ownerName;
	protected String chasisNo;
	protected String engineNo;
	
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getChasisNo() {
		return chasisNo;
	}
	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(chasisNo, engineNo, manufacturer, modelName, ownerName, purchaseDate, registrationNo,
				vehicleNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleRegistration other = (VehicleRegistration) obj;
		return Objects.equals(chasisNo, other.chasisNo) && Objects.equals(engineNo, other.engineNo)
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(modelName, other.modelName)
				&& Objects.equals(ownerName, other.ownerName) && Objects.equals(purchaseDate, other.purchaseDate)
				&& Objects.equals(registrationNo, other.registrationNo) && vehicleNumber == other.vehicleNumber;
	}
	@Override
	public String toString() {
		return "VehicleRegistration [vehicleNumber=" + vehicleNumber + ", registrationNo=" + registrationNo
				+ ", modelName=" + modelName + ", manufacturer=" + manufacturer + ", purchaseDate=" + purchaseDate
				+ ", ownerName=" + ownerName + ", chasisNo=" + chasisNo + ", engineNo=" + engineNo + "]";
	}
	


}
