package com.inverse.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "deliveryAssociate" })
@ToString(exclude = "deliveryAssociate")
@Entity
@Table(name = "parcel")
public class Parcel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parcel_no")
	private int parcelNo;
	private String description;
	@Column(name = "delivery_type")
	private String deliveryType;
	private int weight;
	private double charges;
	@ManyToOne
	@JoinColumn(name = "delivery_associate_no")
	private DeliveryAssociate deliveryAssociate;

}
