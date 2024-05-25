package com.onetomanymap.entities;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CourierCenter implements Serializable {
	protected int courierCenterNo;
	protected String centerName;
	protected String location;
	protected String contactNo;
	protected String emailAddress;
	protected String inChargeName;
	protected Map<String, Parcel> parcels;
}
