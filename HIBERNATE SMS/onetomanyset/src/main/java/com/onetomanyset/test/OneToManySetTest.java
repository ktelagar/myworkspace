package com.onetomanyset.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.onetomanyset.entities.VehicleRegistration;
import com.onetomanyset.entities.Challan;
import com.onetomanyset.helper.SessionFactoryRegistry;

public class OneToManySetTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		int planNo = 0;
		Challan trafficChallan1 = null;
		Challan trafficChallan2 = null;
		VehicleRegistration vehicleRegistration = null;
		Set<Challan> trafficChallans = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			vehicleRegistration = new VehicleRegistration();
			vehicleRegistration.setModelName("Jupiter");
			vehicleRegistration.setManufacturer("KTR");
			vehicleRegistration.setPurchaseDate(new Date());
			vehicleRegistration.setRegistrationNo("TS 09 AB 8016");
			vehicleRegistration.setChasisNo("CH1234567");
			vehicleRegistration.setEngineNo("E9y8y123");
			vehicleRegistration.setOwnerName("Krishna");
			session.save(vehicleRegistration);
			
			
			 trafficChallan1 = new Challan();
			 trafficChallan1.setDescription("over speeding");
			 trafficChallan1.setViolationType("speeding");
			 trafficChallan1.setIssuedDate(new Date()); trafficChallan1.setAmount(1200);
			 trafficChallan1.setBikeRegistration(vehicleRegistration);
			 session.save(trafficChallan1);
			 
			 trafficChallan2 = new Challan();
			 trafficChallan2.setDescription("no helmet");
			trafficChallan2.setViolationType("helmet"); trafficChallan2.setIssuedDate(new
			 Date()); trafficChallan2.setAmount(500);
			 trafficChallan1.setBikeRegistration(vehicleRegistration);
			 session.save(trafficChallan2);
			
			
			

			vehicleRegistration = session.get(VehicleRegistration.class, 2);
			System.out.println(vehicleRegistration);
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
