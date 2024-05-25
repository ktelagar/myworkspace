package com.criteriaapi.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TrafficChallan.class)
public abstract class TrafficChallan_ {

	public static volatile SingularAttribute<TrafficChallan, Date> issuedDate;
	public static volatile SingularAttribute<TrafficChallan, Integer> challanNo;
	public static volatile SingularAttribute<TrafficChallan, Double> amount;
	public static volatile SingularAttribute<TrafficChallan, BikeRegistration> bikeRegistration;
	public static volatile SingularAttribute<TrafficChallan, String> violationType;
	public static volatile SingularAttribute<TrafficChallan, String> description;

	public static final String ISSUED_DATE = "issuedDate";
	public static final String CHALLAN_NO = "challanNo";
	public static final String AMOUNT = "amount";
	public static final String BIKE_REGISTRATION = "bikeRegistration";
	public static final String VIOLATION_TYPE = "violationType";
	public static final String DESCRIPTION = "description";

}

