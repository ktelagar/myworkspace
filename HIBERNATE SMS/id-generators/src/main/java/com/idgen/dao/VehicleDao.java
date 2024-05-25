package com.idgen.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.idgen.entities.Vehicle;
import com.idgen.helper.SessionFactoryRegistry;

public class VehicleDao {
	public String saveVehicle(Vehicle vehicle) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		String vehicleNo = null;
		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			vehicleNo = (String) session.save(vehicle);
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
		}
		return vehicleNo;
	}
}
