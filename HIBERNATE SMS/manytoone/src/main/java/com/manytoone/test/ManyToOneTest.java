package com.manytoone.test;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manytoone.entities.Associate;
import com.manytoone.entities.Leave;
import com.manytoone.helper.SessionFactoryRegistry;

public class ManyToOneTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Associate associate = new Associate();
			associate.setFullname("Matt");
			associate.setDepartment("I.T");
			associate.setDesignation("Software Developer");
			associate.setJoinedDate(LocalDate.of(1990, 02, 12));
			associate.setEmailAddress("matt@gmail.com");
			associate.setMobileNo("97497833");
			session.save(associate);

			Leave leave = new Leave();
			leave.setLeaveType("Personal Leave");
			leave.setStartDate(LocalDate.of(2022, 8, 12));
			leave.setEndDate(LocalDate.of(2022, 8, 15));
			leave.setDescription("Personal leave");
			leave.setStatus("Pending");
			leave.setAssociate(associate);

			session.save(leave);

			/*
			 * Leave leave = session.get(Leave.class, 1); System.out.println(leave);
			 */

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
