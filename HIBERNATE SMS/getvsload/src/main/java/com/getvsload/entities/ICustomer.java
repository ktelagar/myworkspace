package com.getvsload.entities;

import java.util.Date;

public interface ICustomer {
	int getCustomerNo();

	void setCustomerNo(int customerNo);

	String getCustomerName();

	void setCustomerName(String customerName);

	Date getDob();

	void setDob(Date dob);

	String getGender();

	void setGender(String gender);

	String getMobileNo();

	void setMobileNo(String mobileNo);

	String getEmailAddress();

	void setEmailAddress(String emailAddress);
}
