package com.msf.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.msf.entities.Product;
import com.msf.helper.SessionFactoryRegistry;

public class ProductDao {
	public Product getProduct(int productNo) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Product product = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			product = session.get(Product.class, productNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return product;
	}
}
