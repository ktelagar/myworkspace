package com.ck.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ck.entities.LoanApplication;
import com.ck.entities.LoanApplicationNo;

public class CKTest {
	public static void main(String[] args) {
		Session session = null;
		Configuration configuration = null;
		SessionFactory sessionFactory = null;

		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			/*
			 * LoanApplication pk = new LoanApplication(); pk.setApplicationNo(10000928);
			 * pk.setBranchCode("SBIN00098");
			 */
			LoanApplicationNo pk = new LoanApplicationNo();
			pk.setApplicationNo(10000928);
			pk.setBranchCode("SBIN00098");

			LoanApplication loanApplication = session.get(LoanApplication.class, pk);
			System.out.println(loanApplication);

		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}
}
