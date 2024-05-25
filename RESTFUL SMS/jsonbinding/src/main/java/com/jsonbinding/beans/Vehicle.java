package com.jsonbinding.beans;

import java.util.Arrays;

import jakarta.json.bind.annotation.JsonbProperty;

public class Vehicle {
	private int vehicleNo;
	private String rtaRegistrationNo;
	private String chasisNo;
	private String engineNo;
	private String color;
	private String manufacturer;
	private String model;
	private String fuelType;
	@JsonbProperty("capacity")
	private int seatingCapacity;
	private int year;
	private String[] features;
	private double price;

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getRtaRegistrationNo() {
		return rtaRegistrationNo;
	}

	public void setRtaRegistrationNo(String rtaRegistrationNo) {
		this.rtaRegistrationNo = rtaRegistrationNo;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String[] getFeatures() {
		return features;
	}

	public void setFeatures(String[] features) {
		this.features = features;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleNo=" + vehicleNo + ", rtaRegistrationNo=" + rtaRegistrationNo + ", chasisNo=" + chasisNo
				+ ", engineNo=" + engineNo + ", color=" + color + ", manufacturer=" + manufacturer + ", model=" + model
				+ ", fuelType=" + fuelType + ", seatingCapacity=" + seatingCapacity + ", year=" + year + ", features="
				+ Arrays.toString(features) + ", price=" + price + "]";
	}

}
