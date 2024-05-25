package com.criteriaapi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "journey")
public class Journey implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "journey_no")
	protected int journeyNo;
	protected String source;
	protected String destination;
	protected Date journeyDate;
	@Column(name = "commute_mode")
	protected String commuteMode;
	protected Integer hours;
	protected double amount;

	public int getJourneyNo() {
		return journeyNo;
	}

	public void setJourneyNo(int journeyNo) {
		this.journeyNo = journeyNo;
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

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getCommuteMode() {
		return commuteMode;
	}

	public void setCommuteMode(String commuteMode) {
		this.commuteMode = commuteMode;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((commuteMode == null) ? 0 : commuteMode.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + hours;
		result = prime * result + ((journeyDate == null) ? 0 : journeyDate.hashCode());
		result = prime * result + journeyNo;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		Journey other = (Journey) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (commuteMode == null) {
			if (other.commuteMode != null)
				return false;
		} else if (!commuteMode.equals(other.commuteMode))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (hours != other.hours)
			return false;
		if (journeyDate == null) {
			if (other.journeyDate != null)
				return false;
		} else if (!journeyDate.equals(other.journeyDate))
			return false;
		if (journeyNo != other.journeyNo)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Journey [journeyNo=" + journeyNo + ", source=" + source + ", destination=" + destination
				+ ", journeyDate=" + journeyDate + ", commuteMode=" + commuteMode + ", hours=" + hours + ", amount="
				+ amount + "]";
	}

}
