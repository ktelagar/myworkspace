package com.onetoonedirect.entities;

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
public class InspectionReport implements Serializable {
	protected int inspectionNo;
	protected LocalDate reportDate;
	protected String agentName;
	protected String description;
	protected String observations;
	protected int rating;
	protected double valuation;
	protected LocalDate reportExpiryDate;
	protected VehicleInspection vehicleInspection;
}
