package com.jpamf.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Subscriber implements Serializable {
	protected int subscriberNo;
	protected String subscriberName;
	protected String subscriptionType;
	protected Date subscribedDate;
	protected String circle;
	protected float creditLimit;
	protected Date dob;
	protected String gender;
	protected String mobileNo;
	protected String emailAddress;

	public int getSubscriberNo() {
		return subscriberNo;
	}

	public void setSubscriberNo(int subscriberNo) {
		this.subscriberNo = subscriberNo;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Date getSubscribedDate() {
		return subscribedDate;
	}

	public void setSubscribedDate(Date subscribedDate) {
		this.subscribedDate = subscribedDate;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public float getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(circle, creditLimit, dob, emailAddress, gender, mobileNo, subscribedDate, subscriberName,
				subscriberNo, subscriptionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriber other = (Subscriber) obj;
		return Objects.equals(circle, other.circle)
				&& Float.floatToIntBits(creditLimit) == Float.floatToIntBits(other.creditLimit)
				&& Objects.equals(dob, other.dob) && Objects.equals(emailAddress, other.emailAddress)
				&& Objects.equals(gender, other.gender) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(subscribedDate, other.subscribedDate)
				&& Objects.equals(subscriberName, other.subscriberName) && subscriberNo == other.subscriberNo
				&& Objects.equals(subscriptionType, other.subscriptionType);
	}

	@Override
	public String toString() {
		return "Subscriber [subscriberNo=" + subscriberNo + ", subscriberName=" + subscriberName + ", subscriptionType="
				+ subscriptionType + ", subscribedDate=" + subscribedDate + ", circle=" + circle + ", creditLimit="
				+ creditLimit + ", dob=" + dob + ", gender=" + gender + ", mobileNo=" + mobileNo + ", emailAddress="
				+ emailAddress + "]";
	}

}
