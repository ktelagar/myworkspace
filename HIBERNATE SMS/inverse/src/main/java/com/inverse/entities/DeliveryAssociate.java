package com.inverse.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "parcels")
@EqualsAndHashCode(exclude = "parcels")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "delivery_associate")
public class DeliveryAssociate implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "delivery_associate_no")
	private int deliveryAssociateNo;
	@Column(name = "associate_nm")
	private String associateName;
	private int experience;
	private String designation;
	@Column(name = "contact_no")
	private String contactNo;
	@OneToMany(mappedBy = "deliveryAssociate", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	@JoinColumn(name = "delivery_associate_no")
	private Set<Parcel> parcels;
}
