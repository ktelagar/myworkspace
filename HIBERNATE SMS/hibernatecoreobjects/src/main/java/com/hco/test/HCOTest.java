package com.hco.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hco.dao.AddressDao;
import com.hco.entities.Address;

public class HCOTest {
	public static void main(String[] args) {
		Address address = null;
		AddressDao addressDao = null;
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
			addressDao = new AddressDao(sessionFactory);
			address = addressDao.getAddress(1);
			System.out.println(address);
		} finally {
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}
}
