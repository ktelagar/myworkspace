package com.manytoone.entities;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Associate implements Serializable {
	protected int associateNo;
	protected String fullname;
	protected String designation;
	protected String department;
	protected LocalDate joinedDate;
	protected String emailAddress;
	protected String mobileNo;

}
