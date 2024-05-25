package com.dmloperations.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dmloperations.entities.Journey;

public class DMLOperationsTest {
	public static void main(String[] args) {
		boolean flag = false;
		Session session = null;
		Journey journey = null;
		Transaction transaction = null;
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * journey = new Journey(); journey.setSource("Hyderabad");
			 * journey.setDestination("Banglore"); journey.setJourneyDate(new Date());
			 * //journey.setHours(10); //journey.setCommuteMode("Train");
			 * journey.setAmount(1500);
			 * 
			 * int journeyNo = (int) session.save(journey); int eJourneyNo =
			 * journey.getJourneyNo();
			 * 
			 * System.out.println("journey no: " + journeyNo);
			 * System.out.println("entity journey no : " + eJourneyNo);
			 */

			/*
			 * session.persist(journey); int journeyNo = journey.getJourneyNo();
			 * System.out.println("journey no : " + journeyNo);
			 */
			// session.saveOrUpdate(journey);

			/*
			 * journey = session.get(Journey.class, 1); journey.setDestination("Pune");
			 * session.update(journey);
			 */

			/*
			 * journey = new Journey(); journey.setJourneyNo(1);
			 * journey.setSource("Hyderabad"); journey.setDestination("Chennai");
			 * journey.setJourneyDate(new Date()); journey.setHours(10);
			 * journey.setCommuteMode("Train"); journey.setAmount(1300);
			 * session.update(journey);
			 */

			/*
			 * journey = session.get(Journey.class, 1); Journey journey1 = new Journey();
			 * journey1.setJourneyNo(journey.getJourneyNo());
			 * journey1.setSource(journey.getSource());
			 * journey1.setDestination(journey.getDestination());
			 * journey1.setCommuteMode("air");
			 * journey1.setJourneyDate(journey.getJourneyDate()); journey1.setHours(1);
			 * session.merge(journey1);
			 */

			/*
			 * journey = session.get(Journey.class, 1); session.delete(journey);
			 */
			/*
			 * journey = new Journey(); journey.setJourneyNo(2); session.delete(journey);
			 */
			journey = session.get(Journey.class, 1);
			journey.setDestination("Goa");
			session.update(journey);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
		}
	}
}
