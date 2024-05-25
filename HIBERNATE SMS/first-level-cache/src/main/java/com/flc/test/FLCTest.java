package com.flc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.flc.entities.Ride;
import com.flc.helper.SessionFactoryRegistry;

public class FLCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();

			Ride ride = session.get(Ride.class, 1);
			System.out.println(ride);
			session.close();
			
			session = sessionFactory.openSession();
			Ride ride1 = session.get(Ride.class, 1);
			System.out.println(ride1);

			System.out.println("ride == ride2 ? :" + (ride == ride1));

		} finally {
			if (session != null) {
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
