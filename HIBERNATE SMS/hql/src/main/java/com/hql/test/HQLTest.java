package com.hql.test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hql.dto.TripDto;
import com.hql.entities.BikeRegistration;
import com.hql.entities.Journey;
import com.hql.entities.TrafficChallan;
import com.hql.helper.SessionFactoryRegistry;

public class HQLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			 showAllJourneys(session);
			 showAllTypedJourneys(session);
			 showJourneysOfDuration(session, 8);
			 showNoOfJourneysByCommuteMode(session, "road");
			 showJourneyHours(session, 1);
			List<TripDto> tripDtos = getTripsBetweenSourceAndDestination(session, "Hyderabad", "Banglore");
			for (TripDto dto : tripDtos) {
				System.out.println(dto);
			}
			 showJourneysByAmount(session, 1000, 5000);
			 showNoOfJourneysBySourceAndJourneyDate(session, "Hyderabad");
			 showTrafficChallans(session, "TS 09 BB 9833");
			showBikeRegistrationsByViolationType(session, "helmet");
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}

	private static void showAllJourneys(Session session) {
		Query query = null;

		query = session.createQuery("from com.hql.entities.Journey");
		List<Journey> journeys = query.getResultList();
		printJourneys(journeys);
	}

	private static void showAllTypedJourneys(Session session) {
		TypedQuery<Journey> typedQuery = null;

		typedQuery = session.createQuery("from Journey", Journey.class);
		List<Journey> journeys = typedQuery.getResultList();
		printJourneys(journeys);
	}

	private static void showJourneysOfDuration(Session session, int hours) {
		TypedQuery<Journey> typedQuery = null;

		typedQuery = session.createQuery("from Journey j where j.hours > :hours", Journey.class);
		typedQuery.setParameter("hours", hours);
		List<Journey> journeys = typedQuery.getResultList();
		printJourneys(journeys);
	}

	private static void showNoOfJourneysByCommuteMode(Session session, String commuteMode) {
		TypedQuery<Long> typedQuery = null;

		typedQuery = session.createQuery("select count(j) from Journey j where j.commuteMode like :commuteMode",
				Long.class);
		typedQuery.setParameter("commuteMode", commuteMode);
		long count = typedQuery.getResultList().get(0);
		System.out.println("no of journeys: " + count + " for commute mode : " + commuteMode);
	}

	private static void showJourneyHours(Session session, int journeyNo) {
		TypedQuery<Integer> typedQuery = null;
		typedQuery = session.createQuery("select j.hours from Journey j where j.journeyNo = :jno", Integer.class);
		typedQuery.setParameter("jno", journeyNo);
		int hours = typedQuery.getResultList().get(0);
		System.out.println("journey hours: " + hours);
	}

	private static List<TripDto> getTripsBetweenSourceAndDestination(Session session, String source,
			String destination) {
		List<TripDto> tripDtos = null;
		TypedQuery<TripDto> typedQuery = session.createQuery(
				"select new com.hql.dto.TripDto(j.journeyNo, j.source, j.destination, j.amount) from Journey j where j.source=:source and j.destination=:dest",
				TripDto.class);
		typedQuery.setParameter("source", source);
		typedQuery.setParameter("dest", destination);
		tripDtos = typedQuery.getResultList();

		return tripDtos;
	}

	private static void showJourneysByAmount(Session session, double minAmount, double maxAmount) {
		TypedQuery<Object[]> typedQuery = session.createQuery(
				"select j.source, j.destination, j.journeyDate from Journey j where j.amount between :minAmount and :maxAmount",
				Object[].class);
		typedQuery.setParameter("minAmount", minAmount);
		typedQuery.setParameter("maxAmount", maxAmount);
		List<Object[]> records = typedQuery.getResultList();
		for (Object[] record : records) {
			System.out.println("source : " + record[0] + " destination: " + record[1] + " journeyDate: " + record[2]);
		}
	}

	private static void showNoOfJourneysBySourceAndJourneyDate(Session session, String source) {
		TypedQuery<Object[]> typedQuery = session.createQuery(
				"select j.source, count(j.source) from Journey j group by j.source having j.source = :source",
				Object[].class);
		typedQuery.setParameter("source", source);
		List<Object[]> records = typedQuery.getResultList();
		for (Object[] record : records) {
			System.out.println("source : " + record[0] + " trips : " + record[1]);
		}
	}

	private static void showTrafficChallans(Session session, String registrationNo) {
		TypedQuery<TrafficChallan> typedQuery = session.createQuery(
		"select tc from TrafficChallan tc where tc.bikeRegistration.registrationNo=:bregNo",
				TrafficChallan.class);
		typedQuery.setParameter("bregNo", registrationNo);
		List<TrafficChallan> trafficChallans = typedQuery.getResultList();
		for (TrafficChallan tc : trafficChallans) {
			System.out.println(tc);
		}
	}

	private static void showBikeRegistrationsByViolationType(Session session, String violationType) {
		TypedQuery<BikeRegistration> typedQuery = session.createQuery(
	"select br from BikeRegistration br inner join br.trafficChallans tc where tc.violationType = :vt",
				BikeRegistration.class);
		typedQuery.setParameter("vt", violationType);
		List<BikeRegistration> bikeRegistrations = typedQuery.getResultList();
		for (BikeRegistration tc : bikeRegistrations) {
			System.out.println(tc);
		}
	}

	private static void printJourneys(List<Journey> journeys) {
		for (Journey journey : journeys) {
			System.out.println(journey);
		}
	}

}
