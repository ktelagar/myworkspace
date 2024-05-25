package com.flc.entities;

import java.io.Serializable;
import java.util.Objects;

public class Ride implements Serializable {
	protected int rideNo;
	protected String source;
	protected String destination;
	protected String carType;
	protected String mobileNo;

	public int getRideNo() {
		return rideNo;
	}

	public void setRideNo(int rideNo) {
		this.rideNo = rideNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carType, destination, mobileNo, rideNo, source);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ride other = (Ride) obj;
		return Objects.equals(carType, other.carType) && Objects.equals(destination, other.destination)
				&& Objects.equals(mobileNo, other.mobileNo) && rideNo == other.rideNo
				&& Objects.equals(source, other.source);
	}

	@Override
	public String toString() {
		return "Ride [rideNo=" + rideNo + ", source=" + source + ", destination=" + destination + ", carType=" + carType
				+ ", mobileNo=" + mobileNo + "]";
	}

}
