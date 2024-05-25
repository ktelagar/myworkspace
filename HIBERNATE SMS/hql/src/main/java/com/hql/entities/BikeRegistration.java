package com.hql.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class BikeRegistration implements Serializable {
	protected int bikeNo;
	protected String registrationNo;
	protected String modelName;
	protected String manufacturer;
	protected Date purchaseDate;
	protected String ownerName;
	protected String chasisNo;
	protected String engineNo;
	protected Set<TrafficChallan> trafficChallans;

	public int getBikeNo() {
		return bikeNo;
	}

	public void setBikeNo(int bikeNo) {
		this.bikeNo = bikeNo;
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

	public Set<TrafficChallan> getTrafficChallans() {
		return trafficChallans;
	}

	public void setTrafficChallans(Set<TrafficChallan> trafficChallans) {
		this.trafficChallans = trafficChallans;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bikeNo;
		result = prime * result + ((chasisNo == null) ? 0 : chasisNo.hashCode());
		result = prime * result + ((engineNo == null) ? 0 : engineNo.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((registrationNo == null) ? 0 : registrationNo.hashCode());
		result = prime * result + ((trafficChallans == null) ? 0 : trafficChallans.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BikeRegistration other = (BikeRegistration) obj;
		if (bikeNo != other.bikeNo)
			return false;
		if (chasisNo == null) {
			if (other.chasisNo != null)
				return false;
		} else if (!chasisNo.equals(other.chasisNo))
			return false;
		if (engineNo == null) {
			if (other.engineNo != null)
				return false;
		} else if (!engineNo.equals(other.engineNo))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (registrationNo == null) {
			if (other.registrationNo != null)
				return false;
		} else if (!registrationNo.equals(other.registrationNo))
			return false;
		if (trafficChallans == null) {
			if (other.trafficChallans != null)
				return false;
		} else if (!trafficChallans.equals(other.trafficChallans))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BikeRegistration [bikeNo=" + bikeNo + ", registrationNo=" + registrationNo + ", modelName=" + modelName
				+ ", manufacturer=" + manufacturer + ", purchaseDate=" + purchaseDate + ", ownerName=" + ownerName
				+ ", chasisNo=" + chasisNo + ", engineNo=" + engineNo + ", trafficChallans=" + trafficChallans + "]";
	}

}
