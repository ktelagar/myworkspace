package com.onetomanymap.entities;

import java.io.Serializable;
import java.time.LocalDate;

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
public class Parcel implements Serializable {
	protected int parcelNo;
	protected String description;
	protected int weight;
	protected String source;
	protected String destination;
	protected LocalDate parcelDate;
	protected float shippingAmount;

}
