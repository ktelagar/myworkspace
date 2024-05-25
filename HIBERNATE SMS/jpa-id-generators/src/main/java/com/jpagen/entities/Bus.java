package com.jpagen.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "bus")
@SequenceGenerator(name = "busSequenceGenerator", sequenceName = "bus_sequence", allocationSize = 1)
//@TableGenerator(name = "busTableGenerator", table = "unique_keys", pkColumnName = "keyname", pkColumnValue = "busno", valueColumnName = "nextval", allocationSize = 1, initialValue = 10)
public class Bus implements Serializable {
	@Id
	@Column(name = "bus_no")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "busSequenceGenerator")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "busSequenceGenerator")
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "busTableGenerator")
	protected int busNo;
	@Column(name = "bus_type")
	protected String busType;
	@Column(name = "registration_no")
	protected String registrationNo;
	@Column(name = "fuel_type")
	protected String fuelType;
	protected String color;
	protected int capacity;

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(busNo, busType, capacity, color, fuelType, registrationNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		return busNo == other.busNo && Objects.equals(busType, other.busType) && capacity == other.capacity
				&& Objects.equals(color, other.color) && Objects.equals(fuelType, other.fuelType)
				&& Objects.equals(registrationNo, other.registrationNo);
	}

	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", busType=" + busType + ", registrationNo=" + registrationNo + ", fuelType="
				+ fuelType + ", color=" + color + ", capacity=" + capacity + "]";
	}

}
