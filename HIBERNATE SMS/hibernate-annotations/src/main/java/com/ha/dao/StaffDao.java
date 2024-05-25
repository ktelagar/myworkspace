package com.ha.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ha.entities.Staff;
import com.ha.helper.SessionFactoryRegistry;

public class StaffDao {
	public Staff getStaff(int staffNo) {
		Staff staff = null;
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();

			staff = session.get(Staff.class, staffNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return staff;
	}
}
