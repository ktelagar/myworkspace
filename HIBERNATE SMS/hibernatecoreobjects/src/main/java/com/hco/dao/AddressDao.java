package com.hco.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hco.entities.Address;

public class AddressDao {
	private SessionFactory sessionFactory;

	public AddressDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Address getAddress(int addressNo) {
		Session session = null;
		Address address = null;

		try {
			session = sessionFactory.openSession();
			address = session.get(Address.class, addressNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return address;
	}
}
