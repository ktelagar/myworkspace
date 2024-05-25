package com.criteriaapi.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.criteriaapi.entities.BikeRegistration;
import com.criteriaapi.entities.BikeRegistration_;
import com.criteriaapi.entities.Journey;
import com.criteriaapi.entities.Journey_;
import com.criteriaapi.entities.TrafficChallan;
import com.criteriaapi.entities.TrafficChallan_;
import com.criteriaapi.helper.EntityManagerFactoryHelper;

public class CriteriaApiTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = EntityManagerFactoryHelper.getEmf();
			em = emf.createEntityManager();
			 showJourneys(em);
			 showJourneyHoursByJourneyNo(em, 1);
			 showJourneysByDateandCommuniteMode(em, new Date(2021, 04, 1), "road");
			 showNoOfJourneysByCommuteMode(em, "road");
			 showNoOfJourneysFromSource(em, "Hyderabad");
			 showNoOfJourneysBetweenSourceAndDestination(em, "Hyderabad", "Banglore");
			 showJourneysByMinimumHours(em, 10);
			 showBikeRegistrationsByViolationType(em, "helmet");
			showTrafficChallansByBikeModelName(em, "Apache RTR");
		} finally {
			if (em != null) {
				em.close();
			}
			EntityManagerFactoryHelper.closeEmf();
		}
	}

	private static void showJourneys(EntityManager em) {
		CriteriaQuery<Journey> cq = null;
		TypedQuery<Journey> tq = null;
		CriteriaBuilder cb = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Journey.class);
		Root<Journey> root = cq.from(Journey.class);
		cq.select(root);

		tq = em.createQuery(cq);
		List<Journey> journeys = tq.getResultList();
		printJourneys(journeys);
	}

	private static void showJourneyHoursByJourneyNo(EntityManager em, int journeyNo) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
		Root<Journey> root = cq.from(Journey.class);
		cq.select(root.get("hours"));
		cq.where(cb.equal(root.get("journeyNo"), journeyNo));
		TypedQuery<Integer> typedQuery = em.createQuery(cq);
		typedQuery.getResultList().stream().forEach(System.out::println);
	}

	// select source, destination from journey where journey_dt = ? and
	// commute_mode=air

	private static void showJourneysByDateandCommuniteMode(EntityManager em, Date journeyDate, String commuteMode) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Journey> root = cq.from(Journey.class);
		cq.multiselect(root.get("source"), root.get("destination"));
		// System.out.println(journeyDate.getYear());
		cq.where(cb.and(cb.greaterThan(root.get("journeyDate"), journeyDate),
				cb.equal(root.get("commuteMode"), commuteMode)));
		TypedQuery<Object[]> typedQuery = em.createQuery(cq);
		List<Object[]> records = typedQuery.getResultList();
		System.out.println(records.size());
	}

	// no of journeys based on commute mode
	private static void showNoOfJourneysByCommuteMode(EntityManager em, String commuteMode) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Journey> root = cq.from(Journey.class);
		cq.multiselect(cb.count(root.get("journeyNo")));
		cq.where(cb.equal(root.get("commuteMode"), commuteMode));
		TypedQuery<Long> typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(System.out::println);
	}

	// show me count of journeys from the source
	private static void showNoOfJourneysFromSource(EntityManager em, String source) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		Root<Journey> root = cq.from(Journey.class);
		cq.multiselect(root.get("source"), cb.count(root.get("source")));
		cq.groupBy(root.get("commuteMode"));
		cq.having(cb.equal(root.get("source"), source));
		TypedQuery<Object[]> typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(record -> {
			System.out.println("source : " + record[0] + " count : " + record[1]);
		});
	}

	private static void showNoOfJourneysBetweenSourceAndDestination(EntityManager em, String source,
			String destination) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Journey> root = cq.from(Journey.class);
		cq.multiselect(cb.count(root.get("journeyNo")));
		cq.where(cb.and(cb.equal(root.get("source"), source), cb.equal(root.get("destination"), destination)));
		TypedQuery<Long> typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(System.out::println);
	}

	private static void showJourneysByMinimumHours(EntityManager em, int hours) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Journey> root = cq.from(Journey.class);
		cq.multiselect(root.get(Journey_.SOURCE), root.get(Journey_.DESTINATION));
		cq.where(cb.greaterThanOrEqualTo(root.get(Journey_.HOURS), hours));
		TypedQuery<Object[]> typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(record -> {
			System.out.println("source : " + record[0] + ", destination: " + record[1]);
		});
	}

	private static void showBikeRegistrationsByViolationType(EntityManager em, String violationType) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<BikeRegistration> cq = cb.createQuery(BikeRegistration.class);
		Root<BikeRegistration> root = cq.from(BikeRegistration.class);
		Join<BikeRegistration, TrafficChallan> join = root.join(BikeRegistration_.trafficChallans);
		cq.where(cb.equal(join.get(TrafficChallan_.VIOLATION_TYPE), violationType));
		TypedQuery<BikeRegistration> typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(System.out::println);
	}

	private static void showTrafficChallansByBikeModelName(EntityManager em, String bikeModelName) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TrafficChallan> cq = cb.createQuery(TrafficChallan.class);
		Root<TrafficChallan> root = cq.from(TrafficChallan.class);
		cq.select(root);
		Join<TrafficChallan, BikeRegistration> join = root.join(TrafficChallan_.bikeRegistration);
		cq.where(cb.like(join.get("modelName"), bikeModelName));
		TypedQuery<TrafficChallan> typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(System.out::println);
	}

	private static void printJourneys(List<Journey> journeys) {
		journeys.stream().forEach(System.out::println);
	}
}






