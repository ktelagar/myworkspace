package com.hibtools.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibtools.entities.Ticket;

public class HibToolsTest {
	public static void main(String[] args) {
		boolean flag = false;
		Ticket ticket = null;
		Session session = null;
		Transaction transaction = null;
		Configuration configuration = null;
		SessionFactory sessionFactory = null;

		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			ticket = new Ticket();
			ticket.setSource("Hyderbad");
			ticket.setDestination("Banglore");
			ticket.setJourneyDate(new Date());
			ticket.setAge(23);
			ticket.setGender("Female");
			ticket.setPassengerName("Agelina");
			ticket.setAmount(938);
			ticket.setSeatNo(23);
			ticket.setCoachNo("S1");

			String ticketNo = (String) session.save(ticket);
			System.out.println("ticket no : " + ticketNo);
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
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}
}
