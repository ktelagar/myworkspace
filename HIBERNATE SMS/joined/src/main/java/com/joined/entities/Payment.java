package com.joined.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
@GenericGenerator(name = "incrementgen", strategy = "increment")
public class Payment implements Serializable {
	@Id
	@Column(name = "payment_no")
	@GeneratedValue(generator = "incrementgen")
	protected int paymentNo;
	protected String description;
	@Column(name = "customer_nm")
	protected String customerName;
	@Column(name = "payment_dt")
	protected Date paymentDate;
	@Column(name = "paid_amt")
	protected double paidAmount;

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(paidAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + paymentNo;
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
		Payment other = (Payment) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(paidAmount) != Double.doubleToLongBits(other.paidAmount))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (paymentNo != other.paymentNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [paymentNo=" + paymentNo + ", description=" + description + ", customerName=" + customerName
				+ ", paymentDate=" + paymentDate + ", paidAmount=" + paidAmount + "]";
	}

}
