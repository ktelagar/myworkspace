package com.criteriaapi.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Journey.class)
public abstract class Journey_ {

	public static volatile SingularAttribute<Journey, Integer> hours;
	public static volatile SingularAttribute<Journey, Double> amount;
	public static volatile SingularAttribute<Journey, Integer> journeyNo;
	public static volatile SingularAttribute<Journey, String> commuteMode;
	public static volatile SingularAttribute<Journey, String> destination;
	public static volatile SingularAttribute<Journey, Date> journeyDate;
	public static volatile SingularAttribute<Journey, String> source;

	public static final String HOURS = "hours";
	public static final String AMOUNT = "amount";
	public static final String JOURNEY_NO = "journeyNo";
	public static final String COMMUTE_MODE = "commuteMode";
	public static final String DESTINATION = "destination";
	public static final String JOURNEY_DATE = "journeyDate";
	public static final String SOURCE = "source";

}

