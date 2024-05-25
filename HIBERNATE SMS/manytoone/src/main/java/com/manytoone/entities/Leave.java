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
public class Leave implements Serializable {
	protected int leaveNo;
	protected String leaveType;
	protected String description;
	protected LocalDate startDate;
	protected LocalDate endDate;
	protected String status;
	protected Associate associate;

}
