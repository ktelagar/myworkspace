package com.otmoto.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(exclude = "lockers")
@EqualsAndHashCode(exclude = "lockers")
public class Account implements Serializable {
	protected int accountNo;
	protected String accountHolderName;
	protected LocalDate openedDate;
	protected String accountType;
	protected String branchCode;
	protected double balance;
	protected Set<Locker> lockers;
}
