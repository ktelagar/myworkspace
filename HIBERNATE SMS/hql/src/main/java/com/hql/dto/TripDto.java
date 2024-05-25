package com.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class TripDto {
	private int tripNo;
	private String source;
	private String destination;
	private double amount;

}
