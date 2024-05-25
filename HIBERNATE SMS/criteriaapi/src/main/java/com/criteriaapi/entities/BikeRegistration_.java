package com.criteriaapi.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BikeRegistration.class)
public abstract class BikeRegistration_ {

	public static volatile SingularAttribute<BikeRegistration, String> modelName;
	public static volatile SingularAttribute<BikeRegistration, String> engineNo;
	public static volatile SingularAttribute<BikeRegistration, Date> purchaseDate;
	public static volatile SetAttribute<BikeRegistration, TrafficChallan> trafficChallans;
	public static volatile SingularAttribute<BikeRegistration, String> ownerName;
	public static volatile SingularAttribute<BikeRegistration, Integer> bikeNo;
	public static volatile SingularAttribute<BikeRegistration, String> registrationNo;
	public static volatile SingularAttribute<BikeRegistration, String> chasisNo;
	public static volatile SingularAttribute<BikeRegistration, String> manufacturer;

	public static final String MODEL_NAME = "modelName";
	public static final String ENGINE_NO = "engineNo";
	public static final String PURCHASE_DATE = "purchaseDate";
	public static final String TRAFFIC_CHALLANS = "trafficChallans";
	public static final String OWNER_NAME = "ownerName";
	public static final String BIKE_NO = "bikeNo";
	public static final String REGISTRATION_NO = "registrationNo";
	public static final String CHASIS_NO = "chasisNo";
	public static final String MANUFACTURER = "manufacturer";

}

