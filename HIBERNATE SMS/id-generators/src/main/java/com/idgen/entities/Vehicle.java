package com.idgen.entities;

import java.io.Serializable;
import java.util.Objects;

public class Vehicle implements Serializable {
	protected String vehicleNo;
	protected String modelName;
	protected String manufacturer;
	protected String registrationNo;
	protected String color;
	protected String fuelType;
	protected double leaseAmount;

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
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

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public double getLeaseAmount() {
		return leaseAmount;
	}

	public void setLeaseAmount(double leaseAmount) {
		this.leaseAmount = leaseAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, fuelType, leaseAmount, manufacturer, modelName, registrationNo, vehicleNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(color, other.color) && Objects.equals(fuelType, other.fuelType)
				&& Double.doubleToLongBits(leaseAmount) == Double.doubleToLongBits(other.leaseAmount)
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(modelName, other.modelName)
				&& Objects.equals(registrationNo, other.registrationNo) && vehicleNo == other.vehicleNo;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleNo=" + vehicleNo + ", modelName=" + modelName + ", manufacturer=" + manufacturer
				+ ", registrationNo=" + registrationNo + ", color=" + color + ", fuelType=" + fuelType
				+ ", leaseAmount=" + leaseAmount + "]";
	}

}
