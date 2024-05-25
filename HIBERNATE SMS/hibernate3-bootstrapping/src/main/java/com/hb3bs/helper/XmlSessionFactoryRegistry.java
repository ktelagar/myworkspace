package com.hb3bs.helper;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class XmlSessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration().configure("com/hb3bs/common/hb3bs.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace(); // logging
			throw e;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}
}
