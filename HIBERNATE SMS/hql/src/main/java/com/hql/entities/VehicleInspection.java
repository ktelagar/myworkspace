package com.hql.entities;

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
public class VehicleInspection implements Serializable {
	protected int inspectionNo;
	protected String rtaRegistrationNo;
	protected String chasisNo;
	protected String engineNo;
	protected String modelName;
	protected String manufacturer;
	protected String vehicleType;
	protected LocalDate purchaseDate;

}
