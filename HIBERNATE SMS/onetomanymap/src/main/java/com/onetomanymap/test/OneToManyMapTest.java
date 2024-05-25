package com.onetomanymap.test;

import java.time.LocalDate;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.onetomanymap.entities.CourierCenter;
import com.onetomanymap.entities.Parcel;
import com.onetomanymap.helper.SessionFactoryRegistry;

public class OneToManyMapTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Parcel parcel1 = Parcel.builder().description("documents").source("hyderabad").destination("new delhi")
					.parcelDate(LocalDate.now()).shippingAmount(450).weight(10).build();

			Parcel parcel2 = Parcel.builder().description("books").source("pune").destination("new delhi")
					.parcelDate(LocalDate.now()).shippingAmount(150).weight(15).build();

			session.save(parcel1);
			session.save(parcel2);
			Map<String, Parcel> parcels = Map.of("awb939", parcel1, "awb938", parcel2);
			CourierCenter courierCenter = CourierCenter.builder().centerName("Bluedart Center").contactNo("93894783")
					.emailAddress("enquiries@bluedart.com").inChargeName("Smith").location("ameerpet").parcels(parcels)
					.build();
			session.save(courierCenter);

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
}
