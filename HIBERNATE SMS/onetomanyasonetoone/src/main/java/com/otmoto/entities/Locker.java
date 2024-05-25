package com.otmoto.entities;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode(exclude = { "account" })
public class Locker implements Serializable {
	protected int lockerNo;
	protected String keyNo;
	protected String dimensions;
	protected double charges;
	protected Account account;
}
