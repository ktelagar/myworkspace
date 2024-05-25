package com.netsafe.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.netsafe.entities.Account;

public class NetsafeTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Account account = session.get(Account.class, 1);
		System.out.println(account);
		session.close();
	}
}
